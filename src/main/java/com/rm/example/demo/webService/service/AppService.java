package com.rm.example.demo.webService.service;

import com.rm.example.demo.entity.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.UnsupportedEncodingException;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/17
 */
@WebService
public interface AppService {
    @WebMethod
    String getUserName(@WebParam(name = "id") String id) throws UnsupportedEncodingException;
    @WebMethod
    User getUser(String id) throws UnsupportedEncodingException;
}
