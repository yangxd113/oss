package com.my.first.demo_oss;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;

public class xiazaiwenjian {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		System.out.println("这是oss下载文件示例");
		String endpoint = "http://oss-cn-langfang-ltpoc-d01-a.develop.unicom.local/dasai-gs-file";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		String accessKeyId = "5KgFU9wXtcaXurze";
		String accessKeySecret = "VCJ0yip8V2wiJTxx57jLb2kj3W08pS";
		String bucketName = "dasai-gs-file";
		String objectName = "firstone";

		// 创建OSSClient实例。
		OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

		// 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
		OSSObject ossObject = ossClient.getObject(bucketName, objectName);
		// 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
		InputStream content = ossObject.getObjectContent();
		if (content != null) {
		    BufferedReader reader = new BufferedReader(new InputStreamReader(content));
		    while (true) {
		        String line = reader.readLine();
		        if (line == null) break;
		        System.out.println("\n" + line);
		    }
		    // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
		    content.close();
		}

		// 关闭OSSClient。
		ossClient.shutdown();
	}

}
