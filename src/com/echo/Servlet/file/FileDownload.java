package com.echo.Servlet.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FileDownload")
public class FileDownload extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		//1.构建硬盘到文件的输入流
		String realPath = getServletContext().getRealPath("upload/123.png");
		File file = new File(realPath);
		FileInputStream is = new FileInputStream(file);
		//2：获取文件各种信息  contentType 文件名  文件长度
		String contenttype = getServletContext().getMimeType(file.getAbsolutePath());
		String filename = file.getName();
		System.out.println(filename);
		//创建  Content-Disposition 信息
		String disposition = "attachment; filename="+ filename;
		long size = file.length();
		//3.通过获取到的文件各种信息-- 设置相应报文头信息 --- 三个上面获取到的几个下载名字
		resp.setHeader("Content-Disposition", disposition);
		resp.setContentType(contenttype);  //默认在响应头里面
		resp.setContentLength((int) size);
		//4.通过第一步获取的硬盘到内存输入流遍历文件，然后通过输出流将文件发送出去
		ServletOutputStream out = resp.getOutputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while((len = is.read(b))!=-1)
		{
			out.write(b,0,len);
		}
		is.close();
		out.close();
			}
}
