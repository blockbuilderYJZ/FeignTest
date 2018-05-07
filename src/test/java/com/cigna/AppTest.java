package com.cigna;

import static org.junit.Assert.assertTrue;

import feign.Feign;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testHello(){
        FeignOne feignOne= Feign.builder()
                .options(new Request.Options(1000,3500))
                .target(FeignOne.class,"http://127.0.0.1:8080");
        feignOne.helloWorld("你好！");
    }
    @Test
    public void getUser(){
        FeignOne feignOne= Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .options(new Request.Options(1000,3500))
                .target(FeignOne.class,"http://127.0.0.1:8080");
        FeignOne.User user=feignOne.getUser("hehe");
        System.out.println(user.name+"   "+user.age);
    }
}
