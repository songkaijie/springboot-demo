package com.rm.example.demo.file;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @Author: Song Kaijie
 * @Date: 2019/5/21
 */
public class FileUtilTest {

    @Test
    public void createFile() throws IOException {
        FileUtil fileUtil = new FileUtil();
        fileUtil.createFile();
    }
}