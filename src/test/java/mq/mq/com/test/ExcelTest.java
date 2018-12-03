package mq.mq.com.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
public class ExcelTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp(){
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
    }
    @Test
    public void exportExcel(){
        List<Users> users = new ArrayList<>();
        Users users1 = new Users(1,"张三", 18, 1);
        Users users2 = new Users(2,"张4", 18, 0);
        Users users3 = new Users(3,"张5", 18, 0);
        Users users4 = new Users(4,"张6", 18, 1);

        users.add(users1);
        users.add(users2);
        users.add(users3);
        users.add(users4);

        ExcelUtils.exportExcel(users,"点名册", "名单", Users.class, "name.xls", response);
        System.out.println("success");
    }

    @Test
    public void importExcel(){
        String filePath = "E:\\工作簿1.xlsx";
        //解析excel，
        List<Users> personList = ExcelUtils.importExcel(filePath,1,1,Users.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+personList.size()+"】行");

        personList.forEach(o -> System.out.println(o));
        //TODO 保存数据库
    }

}
