package com.yuxinhui.text.myapplication.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Message;
import android.util.Log;

import com.yuxinhui.text.myapplication.Bean.User;
import com.yuxinhui.text.myapplication.YuXinHuiApplication;
import com.yuxinhui.text.myapplication.adapter.ChatAdapter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;


public final class NetUtil{
	private static final String TAG = "uploadFile";
	private static final int TIME_OUT = 10 * 1000; // 超时时间
	private static final String CHARSET = "utf-8"; // 设置编码


	/**
	 * 上传图片
	 */
	public static boolean uploadAvatar(Context context,String fileurl) throws Exception {
		HttpClient client = new DefaultHttpClient();
		User user = YuXinHuiApplication.getInstace().getUser();
		String url=YuXinHuiApplication.URL_BOOT1+"msg/app_upPic?sid=" + user.getId() + "&sname=" + user.getNickname() + "&stype=" + user.getType() + "&gid=" + user.getGid() + "&checked=0";
		Log.e("haha",url);
		HttpPost post = new HttpPost(url);
		try {
    		File file = new File(fileurl);
			MultipartEntity entity = new MultipartEntity();
			entity.addPart("image",new FileBody(file));
    		post.setEntity(entity);
    		HttpResponse response = client.execute(post);
    		if (response.getStatusLine().getStatusCode() == 200) {
    			DialogUtils.createToasdt(context,"上传成功");
    		}
        }catch(FileNotFoundException e){
            e.printStackTrace();
	    }catch (Exception e) {
            e.printStackTrace();
        } finally {
			HttpUtils.closeClient();
		}
		return false;
	}

	/**
	 * 从应用服务器下载图片
	 */
	public static Bitmap downloadAvatar(Context context, String url) {
		Bitmap bitmap=null;
	    if(url==null){
	        return bitmap;
	    }else {
			try {
				HttpUriRequest request = new HttpGet(url);
				HttpClient client = new DefaultHttpClient();
				HttpResponse response = client.execute(request);
				HttpEntity entity = response.getEntity();
				InputStream in = entity.getContent();
				bitmap = BitmapFactory.decodeStream(in);
				if(null!=bitmap){
					Message message=new Message();
					message.what=1;
					ChatAdapter.handler.sendMessage(message);
				}
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				HttpUtils.closeClient();
			}
		}
		return bitmap;
	}

	public static void uploadFile1(String fileUrl){
		String end ="\r\n";
		String twoHyphens ="--";
		String boundary ="image";
		try
		{
			User user = YuXinHuiApplication.getInstace().getUser();
			String actionUrl = YuXinHuiApplication.URL_BOOT1+"msg/app_upPic?sid=" + user.getId() + "&sname=" + user.getNickname() + "&stype=" + user.getType() + "&gid=" + user.getGid() + "&checked=0";
			URL url =new URL(actionUrl);
			HttpURLConnection con=(HttpURLConnection)url.openConnection();
          /* 允许Input、Output，不使用Cache */
			con.setDoInput(true);
			con.setDoOutput(true);
			con.setUseCaches(false);
          /* 设置传送的method=POST */
			con.setRequestMethod("POST");
          /* setRequestProperty */
			con.setRequestProperty("Connection", "Keep-Alive");
			con.setRequestProperty("Charset", "UTF-8");
			con.setRequestProperty("Content-Disposition: form-data; name=\'image\'; filename=\'"
					+ fileUrl + "\'" + end,null);
          /* 设置DataOutputStream */
			DataOutputStream ds =
					new DataOutputStream(con.getOutputStream());
			ds.writeBytes(twoHyphens + boundary + end);
			ds.writeBytes(fileUrl+ end);
			ds.writeBytes(end);
          /* 取得文件的FileInputStream */
			FileInputStream fStream =new FileInputStream(fileUrl);
          /* 设置每次写入1024bytes */
			int bufferSize =1024;
			byte[] buffer =new byte[bufferSize];
			int length =-1;
          /* 从文件读取数据至缓冲区 */
			while((length = fStream.read(buffer)) !=-1)
			{
            /* 将资料写入DataOutputStream中 */
				ds.write(buffer, 0, length);
			}
			ds.writeBytes(end);
			ds.writeBytes(twoHyphens + boundary + twoHyphens + end);
          /* close streams */
			fStream.close();
			ds.flush();
          /* 取得Response内容 */
			InputStream is = con.getInputStream();
			int ch;
			StringBuffer b =new StringBuffer();
			while( ( ch = is.read() ) !=-1 )
			{
				b.append( (char)ch );
			}
          /* 将Response显示于Dialog */

          /* 关闭DataOutputStream */
			ds.close();
		}
		catch(Exception e)
		{

		}
	}

	/**
	 * 上传文件到服务器
	 * @param fielUrl 需要上传的文件的路径
	 * @param RequestURL 请求的rul
	 * @return 返回响应的内容
	 */
	public static int uploadFile(String fielUrl, String RequestURL) {
		int res=0;
		String result = null;
		String BOUNDARY = UUID.randomUUID().toString(); // 边界标识 随机生成
		String PREFIX = "--", LINE_END = "\r\n";
		String CONTENT_TYPE = "multipart/form-data"; // 内容类型

		try {
			URL url = new URL(RequestURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(TIME_OUT);
			conn.setConnectTimeout(TIME_OUT);
			conn.setDoInput(true); // 允许输入流
			conn.setDoOutput(true); // 允许输出流
			conn.setUseCaches(false); // 不允许使用缓存
			conn.setRequestMethod("POST"); // 请求方式
			conn.setRequestProperty("Charset", CHARSET); // 设置编码
			conn.setRequestProperty("connection", "keep-alive");
			conn.setRequestProperty("Content-Type", CONTENT_TYPE + ";boundary="+ BOUNDARY);
			File file = new File(fielUrl);

			if (file != null) {
				/**
				 * 当文件不为空时执行上传
				 */
				DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
				StringBuffer sb = new StringBuffer();
				sb.append(PREFIX);
				sb.append(BOUNDARY);
				sb.append(LINE_END);
				/**
				 * 这里重点注意： name里面的值为服务器端需要key 只有这个key 才可以得到对应的文件
				 * filename是文件的名字，包含后缀名
				 */

				sb.append("Content-Disposition: form-data; name=\"image\"; filename=\""
						+ file.getName() + "\"" + LINE_END);
				sb.append("Content-Type: application/octet-stream; charset="
						+ CHARSET + LINE_END);
				sb.append(LINE_END);
				dos.write(sb.toString().getBytes());
				InputStream is = new FileInputStream(file);
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = is.read(bytes)) != -1) {
					dos.write(bytes, 0, len);
				}
				is.close();
				dos.write(LINE_END.getBytes());
				byte[] end_data = (PREFIX + BOUNDARY + PREFIX + LINE_END)
						.getBytes();
				dos.write(end_data);
				dos.flush();
				/**
				 * 获取响应码 200=成功 当响应成功，获取响应的流
				 */
				res = conn.getResponseCode();
				Log.e(TAG, "response code:" + res);
				if (res == 200) {
					Log.e(TAG, "request success");
					InputStream input = conn.getInputStream();
					StringBuffer sb1 = new StringBuffer();
					int ss;
					while ((ss = input.read()) != -1) {
						sb1.append((char) ss);
					}
					result = sb1.toString();
					Log.e(TAG, "result : " + result);
				} else {
					Log.e(TAG, "request error");
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return res;
	}
}
