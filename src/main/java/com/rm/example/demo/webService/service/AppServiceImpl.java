package com.rm.example.demo.webService.service;

import com.rm.example.demo.entity.User;

import javax.jws.WebService;
import java.io.UnsupportedEncodingException;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/20
 */
//name暴露的服务名称, targetNamespace:命名空间,设置为接口的包名倒写(默认是本类包名倒写). endpointInterface接口地址
@WebService(name = "test", targetNamespace = "http://cxf.wolfcode.cn", endpointInterface = "com.rm.example.demo.webService.service.AppService")
public class AppServiceImpl implements AppService {
    @Override
    public String getUserName(String id) throws UnsupportedEncodingException {
        System.out.println("===========================" + id);
        return "success";
    }

    @Override
    public User getUser(String id) throws UnsupportedEncodingException {
        return null;
    }
}
