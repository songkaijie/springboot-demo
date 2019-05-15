package com.rm.example.demo.socket;

import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/15
 */
public class SocketClient {
    public static void main(String args[]) throws Exception {
        //要连接的服务端ip地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        outputStream.close();
        socket.close();
    }
}
