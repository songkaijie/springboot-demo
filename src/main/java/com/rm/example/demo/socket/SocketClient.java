package com.rm.example.demo.socket;

import org.apache.log4j.Logger;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/15
 */
public class SocketClient {
    private static Logger log = Logger.getLogger(SocketClient.class);

    public static void main(String args[]) throws Exception {
        //要连接的服务端ip地址和端口
        String host = "127.0.0.1";
        int port = 55533;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        String message = "你好";
        socket.getOutputStream().write(message.getBytes("UTF-8"));
        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while ((len = inputStream.read(bytes)) != -1) {
            sb.append(new String(bytes, 0, len, "UTF-8"));
        }
        log.info("get message from server:" + sb);
        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
