package mq.springboot.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    //swagger2的配置文件，这里可以配置swagger2的一些基本的内容，比如扫描的包等等
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径
                .apis(RequestHandlerSelectors.basePackage("mq.springboot"))
                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 测试使用 Swagger2 构建RESTful API")
                //创建人
                .contact(new Contact("MarryFeng", "http://www.baidu.com", ""))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }
//    //配置Swagger2的Docket对象，交给Spring容器
//
//    @Bean
//    public Docket createRestApi() {
//        //配置加载指定包下的注解
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                //测试API可设置不同组，ui界面看到api不一样
//                .groupName("test")
//                .genericModelSubstitutes(DeferredResult.class)
//                //.genericModelSubstitutes(ResponseEntity.class)
//                .useDefaultResponseMessages(false)
//                .forCodeGeneration(true)
//                //.pathMapping("/")// base，最终调用接口后会和paths拼接在一起
//                .select()
//                .apis(RequestHandlerSelectors
//                        .basePackage("mq.springboot"))
////                .paths(PathSelectors.regex("/cat/.*"))//过滤的接口
//                .paths(PathSelectors.any())//任何路径
//                .build();
//    }
//
//
//
//    //apiInfo：API接口相关描述
//
//    private ApiInfo apiInfo() {
//        /*
//
//         * ApiInfo apiInfo = new ApiInfo("Cat相关接口",//大标题 "Cat相关接口，主要用于测试.",//小标题
//
//         * "1.0",//版本"http://wyait.blog.51cto.com", "wyait",//作者
//
//         * "上海舞泡科技有限公司",//链接显示文字 "http://www.5pao.com/"//网站链接 );
//
//         */
//
//        return new ApiInfoBuilder()
//                .title("cat相关API")
//                //大标题
//                .description("cat相关接口测试")
//                //详细描述
//                .version("1.0")
//                //版本
//                .termsOfServiceUrl("NOterms of service")
//                .contact("http://wyait.blog.51cto.com")
//                .license("Version1.0")
//                .licenseUrl("http://www.5pao.com")
//                .build();
//    }
//
//        /*
//
//         * return new ApiInfoBuilder()
//
//         * .title("Spring Boot中使用Swagger2构建RESTfulAPIs")
//
//         * .description("更多Spring Boot相关资料，百度一下")
//
//         *.termsOfServiceUrl("http://wyait.blog.51cto.com")
//
//         * .version("1.0.0").build();
//
//         */
//
//        //return apiInfo;
}
