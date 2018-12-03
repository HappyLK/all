package com.example.demo.ssql;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration//上边有介绍
@EnableTransactionManagement //开启事物spring提供的注解
public class DataSourceConfiguration {
    private static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfiguration.class);

    //默认去找application.yum中的druid.type相当于将配置文件中的该值赋值给dataSourceType
    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;


    @Bean(name = "masterDataSource")
    @Primary//优先选择主数据源（原因可写可读）
    @ConfigurationProperties(prefix = "druid.master") //意思是从application.yum中找druid.master开头所有的信息都要放到要创建的masterDataSource并且交给spring管理
    public DataSource masterDataSource() throws SQLException{
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("========MASTER: {}=========", masterDataSource);
        return masterDataSource;
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource(){
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        LOGGER.info("========SLAVE: {}=========", slaveDataSource);
        return slaveDataSource;
    }

    //druid监控界面需要用的到servlet
    @Bean
    public ServletRegistrationBean druidServlet() {

        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow", "localhost");
        reg.addInitParameter("deny","/deny");
        LOGGER.info(" druid console manager init : {} ", reg);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico, /druid/*");
        LOGGER.info(" druid filter register : {} ", filterRegistrationBean);
        return filterRegistrationBean;
    }
}
