package top.chenwanpeng.utils;

/**这是IO工具类
 * 
 * readIntoList方法:可以读取某个路径文件的内容到ArrayList集合
 * changeToLowercase(String filepath) :将指定文本中的大写都转换成小写,然后写回文本 参数:文本文件路径字符串
 *
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class IOUtils {
	private IOUtils() {
	}
	
	
	/**
	 * web工程下载文件用,参数:this,请求对象,响应对象,客户端请求下载的文件名称,请求下载文件在服务端的路径
	 * IOUtils.downLoad(this, request, response,"filename","/down/");
	 * 
	 */
	public static void downLoad(HttpServlet thiz, HttpServletRequest request, HttpServletResponse response,
			String filename,String url) throws IOException {
		String fn = new String(request.getParameter(filename).getBytes("ISO8859-1"),"UTF-8");
		String type = thiz.getServletContext().getMimeType(fn);
		response.setHeader("Content-Type", type);
		String realPath = thiz.getServletContext().getRealPath(url + fn);//"/down/"
		String agent = request.getHeader("User-Agent");
		if (agent.contains("Firefox")) {
			fn = base64EncodeFileName(fn);
		} else {
			fn = URLEncoder.encode(fn, "UTF-8");
		}
		response.setHeader("Content-Disposition", "attachment;filename=" + fn);
		InputStream isInputStream = new FileInputStream(realPath);
		ServletOutputStream os = response.getOutputStream();
		int len = 0;
		byte[] bs = new byte[1024];
		while ((len = isInputStream.read(bs)) != -1) {
			os.write(bs, 0, len);
		}
		isInputStream.close();
	}
	/**
	 * base64
	 * 用法:filename = base64EncodeFileName(filename);//火狐浏览的默认编码格式
	 */
	public static String base64EncodeFileName(String fileName) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		try {
			return "=?UTF-8?B?" + new String(base64Encoder.encode(fileName.getBytes("UTF-8"))) + "?=";
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 将指定文本中的大写都转换成小写,然后写回文本 参数:文本文件路径字符串
	 * 
	 * @throws IOException
	 * 
	 */
	public static void changeToLowercase(String filepath) throws IOException {
		// 创建缓冲输入流
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		StringBuilder lines = new StringBuilder();
		while ((line = br.readLine()) != null) {
			lines.append(line.toLowerCase()+"\r\n");
		}
		br.close();
		// 创建打印流
		PrintWriter pw = new PrintWriter(new FileWriter(filepath), true); // 自动刷新
		pw.print(lines.toString());
		pw.close();
	}

	/**
	 * 参数:文本文件路径字符串 => 返回:文本文件的集合
	 * 
	 * 
	 */
	public static ArrayList<String> readIntoList(String filepath) throws IOException {
		ArrayList<String> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line;
		while ((line = br.readLine()) != null) {
			list.add(line);
		}
		br.close();
		return list;
	}

	/**
	 * 参数:原路径,目标路径 =>实现复制
	 * 
	 * 
	 */
	private static void copy(File src, File dest) throws IOException {
		if (src.isDirectory() && dest.isDirectory()) {
			File file = new File(dest, src.getName());
			if (!file.exists()) {
				file.mkdirs();
			}
			File[] listFiles = src.listFiles();
			for (File srcFile : listFiles) {
				System.out.println(srcFile);
				if (srcFile.isFile()) {
					FileInputStream fileInputStream = new FileInputStream(srcFile);
					FileOutputStream fileOutputStream = new FileOutputStream(new File(file, srcFile.getName()));
					int len;
					byte[] bys = new byte[1024];
					while ((len = fileInputStream.read(bys)) != -1) {
						fileOutputStream.write(bys, 0, len);
					}
					fileInputStream.close();
					fileOutputStream.close();
				} else if (src.isDirectory()) {
					copy(srcFile, file);
				}

			}

		}
	}
}
