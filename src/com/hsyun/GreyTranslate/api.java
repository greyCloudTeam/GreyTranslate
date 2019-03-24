package com.hsyun.GreyTranslate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class api {
	/**
     * 调用百度翻译api
     * y和m的值去http://api.fanyi.baidu.com/api/trans/product/apidoc看
     * appid和key去http://api.fanyi.baidu.com/申请
     * 
     * @param y
     * 源语言
     * @param m
     * 目标语言，不能为auto
     * @param con
     * 要翻译的内容,一定需要是uft8编码！
     * @param appid
     * appid
     * @param key
     * key
     * @return 一个长度为2的string类型数组，[0]为源语言，[1]为翻译后结果
	 * @throws Exception 
     */
	public static String[] baiduTranslate(String y,String m,String con,String appid,String key) throws Exception{
		String ncon=URLEncoder.encode(con, "UTF-8");//url编码
		String rand=String.valueOf(Math.random()*10000000);
		String sign1=appid+con+rand+key;
		String sign2=code.getMD5(sign1);
		String arg="q="+ncon+"&from="+y+"&to="+m+"&appid="+appid+"&salt="+rand+"&sign="+sign2;
		String end=http.sendPost("http://api.fanyi.baidu.com/api/trans/vip/translate", arg);
		JsonParser a=new JsonParser();
		JsonElement b=a.parse(end);
		if(b.getAsJsonObject().has("error_code")) {
			throw new Exception("翻译时出错，错误代码:"+b.getAsJsonObject().get("error_code").getAsString()+"，错误信息:"+b.getAsJsonObject().get("error_msg").getAsString());
		}else {
			String c[]=new String[2];
			c[0]=b.getAsJsonObject().get("from").getAsString();
			c[1]=b.getAsJsonObject().get("trans_result").getAsJsonArray().get(0).getAsJsonObject().get("dst").getAsString();
			return c;
		}		
	}
}