package com.rm.example.demo.file;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/21
 */
public class FileUtil {
    private Logger log = Logger.getLogger(FileUtil.class);

    /**
     * 创建、删除文件
     */
    public void createFile() {
        String content = "hello world";
        String path = "F://test";
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        String fileName = "test.txt";
        File myFile = new File(path, fileName);

       /* 第二种方法
       String file = "F:\\test\\test.txt";
        File myFile = new File(file);*/

        if (!myFile.exists()) {
            try {
                myFile.createNewFile();
                log.info("创建文件");
            } catch (IOException e) {
                e.printStackTrace();
                log.error("创建文件异常");
            }

            //myFile.delete();
            //log.info("删除文件");
        }
        //写入文件(1)
        /*FileOutputStream fop = null;
        try {
            fop = new FileOutputStream(myFile);
            byte[] contentInBytes = content.getBytes();
            fop.write(contentInBytes);
            fop.flush();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("写入文件异常");
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        //写入文件(2)
        //FileWriter(参数true为追加内容，若无则是覆盖内容)
       /* FileWriter fw = null;
        try {
            fw = new FileWriter(myFile, true);
            fw.write(content);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("写入文件出错");
        } finally {
            if (fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        //写入文件（3）
        /*BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(myFile, true));
            bw.write(content);
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/
      // 第四种：打印流PrintStream和PrintWriter
     // 字节打印流：PrintStream
     // 字符打印流：PrintWriter
      /*  PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(myFile, true));
            pw.println(content);      // 换行
            //pw.print(content);        // 不换行
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }*/

      //读取文件
     // 第一种：以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。

    }
}
