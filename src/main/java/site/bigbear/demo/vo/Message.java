package site.bigbear.demo.vo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 前后台交互基本格式
 * @author cheyantao
 */
public class Message {
    private String info;
    private Object data;
    private Boolean success;
    private Integer errorCode;

    public Message() {
    }

    public Message(String info, Object data, Boolean success, Integer
            errorCode) {
        this.info = info;
        this.data = data;
        this.success = success;
        this.errorCode = errorCode;
    }
    public static Message fail(String info,int errorCode){
        return  new Message(info,null,false,errorCode);
    }
    public static Message success(String info,Object data){
        return new Message(info,data,true, 1);
    }
    public static Message success(Object data){
        return Message.success(null,data);
    }
    public static Message success(){
        return Message.success(null,null);
    }
    public String getInfo() {
        return this.info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "error";
        }
    }
}

