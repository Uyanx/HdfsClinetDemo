package com.root.hdfs;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class HdfsClient {

    private FileSystem fileSystem;

    @Before
    public void init() throws IOException, InterruptedException, URISyntaxException {

        URI uri = new URI("hdfs://Hadoop101:8020");
        Configuration configuration = new Configuration();
        String user = "root";
        fileSystem = FileSystem.get(uri, configuration,user);

    }

    @After
    public  void close() throws IOException {

        // 关闭资源
        fileSystem.close();

    }



    @Test
    public void testmkdir() throws URISyntaxException, IOException, InterruptedException {
        // 创建文件夹
        fileSystem.mkdirs(new Path("/windowstest/test"));

    }
}
