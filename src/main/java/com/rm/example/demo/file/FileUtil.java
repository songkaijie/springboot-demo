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
        //System.out.write()方法是字符流,System.out.println()方法是字节流
        // 第一种：以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。
        /*InputStream in = null;
        try {
            in = new FileInputStream(myFile);
            //一次读一个字节
           int tempbyte;
            while ((tempbyte = in.read()) != -1) {
               System.out.write(tempbyte);
            }
            //一次读多个字节
            int byteread = 0;
            byte[] tempbytes = new byte[100];
            while ((byteread = in.read(tempbytes)) != -1) {
                System.out.write(tempbytes, 0, byteread);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //第二种读取文件的方式
       /* Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(myFile));
            // 一次读一个字节
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if (((char) tempchar) != '\r') {
                    System.out.print((char) tempchar);
                }
            }
            //一次读多个字节
            char[] tempchars = new char[30];
            int charread = 0;
            // 读入多个字符到字符数组中，charread为一次读取字符数
            while ((charread = reader.read(tempchars)) != -1) {
                // 同样屏蔽掉\r不显示
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/

        //第三种读取文件的方式：以行为单位读取文件，常用于读面向行的格式化文件
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(myFile));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        //删除文件夹下面的所有文件
        // File[] files=myFile.listFiles();
        //for(int i=0;i<files.length;i++){
        //    if(files[i].isDirectory()){
        //        files[i].delete();
        //    }
        //}

    }
}
//文件函数

//判断文件是否存在
//myFile.exists()


//读取文件名称
//myFile.getName

//读取文件绝对路径
//myFile.getAbsolutePath()

//读取文件的父级路径
//new File(myFile.getAbsolutePath()).getParent()

//读取文件的大小
//myFile.length()


//判断文件是否被隐藏
//myFile.isHidden()

//判断文件是否可读
// myFile.canRead()

//判断文件是否可写
//myFile.canWrite()

//判断文件是否为文件夹
// myFile.isDirectory()