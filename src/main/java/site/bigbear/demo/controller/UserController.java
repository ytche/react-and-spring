package site.bigbear.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import site.bigbear.demo.constant.Constant;
import site.bigbear.demo.pojo.User;
import site.bigbear.demo.vo.Message;

import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cheyantao
 */
@Controller
@ResponseBody
@RequestMapping("/api/v1/users")
public class UserController {


    @PostMapping(value = "actions/login",headers = "Accept=application/json")
    public Message login(@RequestBody User user, HttpSession session){
        session.setAttribute(Constant.CURRENT_USER_TAG,user);
        List<Map<String,Object>> permissionList= new ArrayList<>();
        for (int i=1;i<6;i++){
            Map<String,Object> permission=new HashMap<>();
            permission.put("id",i);
            permission.put("url","/test"+i);
            permission.put("name","test"+i);
            permissionList.add(permission);
        }
        return Message.success(permissionList);
    }

}
