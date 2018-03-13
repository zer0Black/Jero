package com.lxt.file;

import com.lxt.file.controller.FileController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * 文件服务测试驱动类
 *
 * @author lixuetao
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = JeroFileApplication.class)
@WebAppConfiguration
public class JeroFileControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new FileController()).build();
    }

    @Test
    public void testGetById() throws Exception{
        String uri = "/file/  ";
        MvcResult result = mvc.perform(MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = result.getResponse().getStatus();
        Assert.assertEquals(200, status);



    }

}
