package site.bigbear.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import site.bigbear.demo.vo.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cheyantao
 */
@Controller
@RequestMapping("/api/v1/test1s")
@ResponseBody
public class Test1Controller {

    @GetMapping
    public Message list(){
        List<Map<String,Object>> list=new ArrayList<>();
        for (int i=1;i<6;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("name","name"+i);
            map.put("id",i);
            list.add(map);
        }
        return Message.success(list);
    }
    @RequestMapping(method = {RequestMethod.PUT,RequestMethod.POST})
    public Message addOrUpdate(@RequestParam String name){
        return Message.success(null);
    }
    @DeleteMapping(value = "/{id}")
    public Message delete(@PathVariable String id){
        return Message.success();
    }
    @GetMapping(value = "/{id}")
    public Message find(@PathVariable String id){
        Map<String,Object> map=new HashMap<>();
        map.put("name","name1");
        map.put("id",1);
        return Message.success(map);
    }

}
