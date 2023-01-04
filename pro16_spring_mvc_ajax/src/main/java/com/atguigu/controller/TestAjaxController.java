package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
public class TestAjaxController {

    @RequestMapping("/test/ajax")
    public void testAjax(Integer id, @RequestBody String requestBody, HttpServletResponse response) throws IOException {
        System.out.println("requestBody = " + requestBody);
        System.out.println("id = " + id);
        response.getWriter().write("hello,axios");
    }

    @RequestMapping("/test/RequestBody/json")
    public void testRequestBody(@RequestBody Map<String,Object> map, HttpServletResponse response) throws IOException {
        System.out.println("map = " + map);
        response.getWriter().write("hello,RequestBody");
    }

    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("user = " + user);
        response.getWriter().write("hello,RequestBody");
    }

    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public List<User> testResponseBodyJson(){
        User user1 = new User(1001, "admin", "123456",20,"m");
        User user2 = new User(1002, "admin", "123456",20,"m");
        User user3 = new User(1003, "admin", "123456",20,"m");
        List<User> list = Arrays.asList(user1, user2, user3);
        return list;
    }
    /*
    public Map<String,Object> testResponseBodyJson(){
        User user1 = new User(1001, "admin", "123456",20,"m");
        User user2 = new User(1002, "admin", "123456",20,"m");
        User user3 = new User(1003, "admin", "123456",20,"m");
        Map<String, Object> map = new HashMap<>();
        map.put("1001",user1);
        map.put("1002",user2);
        map.put("1003",user3);
        return map;
    }
    */
    /*
    public User testResponseBodyJson(){
        User user = new User(1001, "admin", "123456",20,"m");
        return user;
    }
    */

}
