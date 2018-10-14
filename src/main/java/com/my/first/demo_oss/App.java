package com.my.first.demo_oss;

import java.io.ByteArrayInputStream;

import com.aliyun.oss.OSSClient;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!,demo-oss" );
        //上传文件：
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-langfang-ltpoc-d01-a.develop.unicom.local/dasai-gs-file";
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = "5KgFU9wXtcaXurze";
        String accessKeySecret = "VCJ0yip8V2wiJTxx57jLb2kj3W08pS";
        String bucketName = "dasai-gs-file";
        String objectName = "firstone";

        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传内容到指定的存储空间（bucketName）并保存为指定的文件名称（objectName）。
        String content = "Hello OSS";
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));

        // 关闭OSSClient。
        ossClient.shutdown();
        //下载文件
    }
}
