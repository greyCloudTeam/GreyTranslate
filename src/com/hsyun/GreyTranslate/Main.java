package com.hsyun.GreyTranslate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		if(args.length==0) {
			printHelp();
			return;
		}
		//读命令行
		String y="";
		String m="";
		String con="";
		for(int i=0;i<args.length;i++) {
			if(i==0) {
				if(args[i].equals("help")) {
					printHelp();
					return;
				}else {
					y=args[i];
					continue;
				}
			}
			if(i==1) {
				m=args[i];
			}else {
				if(i==2) {
					con=con+args[i];
				}else {
					con=con+" "+args[i];
				}
			}
		}
		//发布时用这个(仅linux)
		String path[]=System.getProperty("java.class.path").split("/");
		String end="";
		for(int i=0;i<path.length;i++) {
			if(i==path.length-1) {
				break;
			}else {
				end+=path[i]+"/";
			}
		}
		FileReader f=new FileReader(end+"config.json");
		//eclipse调试时用这个
		//FileReader f=new FileReader(System.getProperty("user.dir")+"/config.json");
		//DataInputStream dis=new DataInputStream(f.);
		BufferedReader br = new BufferedReader(f);
		String confi="";
		String line;//读文件的一行
        while ((line = br.readLine()) != null) {
            //一次读入一行数据
            confi+=line+"\n";
        }
        //System.out.println(confi);
        JsonParser a=new JsonParser();
        JsonElement b=a.parse(confi);
        String appid=b.getAsJsonObject().get("baidu").getAsJsonObject().get("appid").getAsString();
        String key=b.getAsJsonObject().get("baidu").getAsJsonObject().get("key").getAsString();
		String c[]=api.baiduTranslate(y, m, con, appid, key);
		System.out.println("源语言："+c[0]+"\n目标语言："+m+"\n翻译前："+con+"\n翻译后:"+c[1]);
	}
	public static void printHelp() {
		System.out.println("帮助信息：\n"+
						   "help:获取帮助信息\n"
						   + "[翻译源]:可选bd(百度翻译)，可以省略，默认为bd+\n"
						   + "\t[源语言] [目标语言]:将源语言翻译为目标语言，语言的简称在下面\n"
						   + "语言列表：\n"
						   +"auto\t自动检测(只能用在原语言)\n"
        				+"zh\t中文\n"
        				+"en\t英语\n"
        				+"yue\t粤语\n"
        				+"wyw\t文言文\n"
        				+"jp\t日语\n"
        				+"kor\t韩语\n"
        				+"fra\t法语\n"
        				+"spa\t西班牙语\n"
        				+"ara\t阿拉伯语\n"
        				+"ru\t俄语\n"
        				+"pt\t葡萄牙语\n"
        				+"de\t德语\n"
        				+"it\t意大利语\n"
        				+"el\t希腊语\n"
        				+"nl\t荷兰语\n"
        				+"bul\t保加利亚语\n"
        				+"dan\t丹麦语\n"
        				+"swe\t瑞典语\n"
        				+"cht\t繁体中文\n"
		);
	}

}
