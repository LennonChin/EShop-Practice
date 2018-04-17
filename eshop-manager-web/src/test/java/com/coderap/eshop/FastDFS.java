package com.coderap.eshop;

import org.csource.fastdfs.*;
import org.junit.Test;

/**
 * @program: eshop-parent
 * @description: FastDFS测试
 * @author: Lennon Chin
 * @create: 2018/04/17 23:56:01
 */
public class FastDFS {

    @Test
    public void testFastDFS() throws Exception {

        ClientGlobal.init("D:/WorkSpace/Idea/eshop-parent/eshop-manager-web/src/main/resources/config/FastDFSClient.conf");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageServer storageServer = null;
        StorageClient storageClient = new StorageClient(trackerServer, storageServer);
        String[] fileInfos = storageClient.upload_file("C:/Users/limyr/Desktop/HashMap的Put方法.png", "png", null);
        for (String fileInfo : fileInfos) {
            System.out.println(fileInfo);
        }
    }
}
