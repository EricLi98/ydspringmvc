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
		//�жϲ����Ƿ�Ϊ��
		if(files!=null){
			//����ÿ���ϴ����ļ�
			for(int i=0;i<files.length;i++){
				MultipartFile file=files[i];
				String oriName=file.getOriginalFilename();//�õ��ϴ�ʱ���ļ���
				//�����ĵ��ļ�������ת��,���web.xml����ת��Ĺ�����������Ҫ��
				String newFileName=oriName;//new String(oriName.getBytes("ISO8859-1"),"UTF-8");
				//��ȡ�����ļ�������·��
				String savePath=request.getRealPath("/")+"/WEB-INF/upload/";
				File newfile=new File(savePath+newFileName);
				if(!newfile.exists()){
					newfile.createNewFile();
				}
				//����transferTo����request�е��ļ����ݣ�д���ļ�ϵͳ
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
	     
	     String newFileName = "����.jar";//�����ļ����ļ�������ʱ�����ݿ��л�ȡ
	     //�õ�������·��
	     String savePath=request.getRealPath("/")+"/WEB-INF/upload/";
	     String downloadPath=savePath+newFileName;
	     long fileLength=new File(downloadPath).length();//�õ������ļ��Ĵ�С
	     //����response��ͷ��Ϣ��ʹ������ܹ����������ļ��ĶԻ���
	     response.setHeader("Content-disposition", "attachment; filename="+ new String(newFileName.getBytes("UTF-8"), "ISO8859-1"));
	     response.setHeader("Content-Length", String.valueOf(fileLength));
	     
	     bis = new BufferedInputStream(new FileInputStream(downloadPath));//�õ��ļ���������
	     bos = new BufferedOutputStream(response.getOutputStream());//�õ�response�������
	     //ʹ��ѭ�������϶�ȡ�ļ����ݣ�д��response
	     byte[] buff = new byte[2048];
	     int bytesRead;
	     while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
	        bos.write(buff, 0, bytesRead);
	     }
	     
	     bis.close(); 
	     bos.close();


	}
}
