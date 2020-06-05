package com.ydspringmvc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ydspringmvc.entity.UserBean;

@Controller
@RequestMapping(value="/ch10")
public class Ch10Controller1 {
	@RequestMapping(value="/map1",method=RequestMethod.GET)
	public String map1(){
		return "ch10";
	}
	
	@RequestMapping(value="/map1",method=RequestMethod.POST)
	public String map1(HttpServletRequest request, @RequestParam(value = "myFile", required =false)MultipartFile[] files) throws Exception{
		//判断参数是否为空
		if(files!=null){
			//遍历每个上传的文件
			for(int i=0;i<files.length;i++){
				MultipartFile file=files[i];
				String oriName=file.getOriginalFilename();//得到上传时的文件名
				//对中文的文件名进行转码,如果web.xml中有转码的过滤器，则不需要。
				String newFileName=oriName;//new String(oriName.getBytes("ISO8859-1"),"UTF-8");
				//获取保存文件的物理路径
				String savePath=request.getRealPath("/")+"/WEB-INF/upload/";
				File newfile=new File(savePath+newFileName);
				if(!newfile.exists()){
					newfile.createNewFile();
				}
				//调用transferTo，将request中的文件内容，写入文件系统
				file.transferTo(newfile);
			}
		}
		return "success";
	}
	
	@RequestMapping(value="/map2",method=RequestMethod.GET)
	public void map2(HttpServletRequest request,HttpServletResponse response) throws Exception{
	     response.setContentType("text/html;charset=UTF-8");
	     BufferedInputStream bis = null;
	     BufferedOutputStream bos = null;
	     
	     String newFileName = "副本.jar";//下载文件的文件名，有时从数据库中获取
	     //得到完整的路径
	     String savePath=request.getRealPath("/")+"/WEB-INF/upload/";
	     String downloadPath=savePath+newFileName;
	     long fileLength=new File(downloadPath).length();//得到下载文件的大小
	     //设置response的头信息，使浏览器能够弹出下载文件的对话框
	     response.setHeader("Content-disposition", "attachment; filename="+ new String(newFileName.getBytes("UTF-8"), "ISO8859-1"));
	     response.setHeader("Content-Length", String.valueOf(fileLength));
	     
	     bis = new BufferedInputStream(new FileInputStream(downloadPath));//得到文件的输入流
	     bos = new BufferedOutputStream(response.getOutputStream());//得到response的输出流
	     //使用循环，不断读取文件内容，写入response
	     byte[] buff = new byte[2048];
	     int bytesRead;
	     while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	        bos.write(buff, 0, bytesRead);
	     }
	     
	     bis.close(); 
	     bos.close();


	}
}
