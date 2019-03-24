# GreyTranslate
一个小型的用于linux的命令行翻译工具  
## 使用说明  
注意！虽然是java写的，但是只能用于linux！用在windows下会报错  
1.去release下载trans.jar和config.json  
2.把trans.jar和config.json放在同一个目录  
3.打开命令行，输入sudo vim /etc/profile，在末尾加上下面几句  
alias trans="java -jar /home/caiwen/trans.jar"  
alias tra2zh="java -jar /home/caiwen/trans.jar auto zh"  
alias tra2en="java -jar /home/caiwen/trans.jar auto en"  
（把/home/caiwen/改成你的trans.jar和config.json所在的目录)  
4.保存，输入source /etc/profile  
然后就配置完成了（jar和json必须在同一个目录！！！)，输入trans help可以查看帮助信息  
也可以直接输入 tra2zh 要翻译的文字 来将任何语言翻译成中文，或者tra2en翻译成英文  
## 注意  
如果想长期使用，请去百度翻译申请appid和key，然后把config.json的appid和key改成你申请的  
如果想搬源码，建议去我的另外一个项目：greyJTools，这个java工具库将百度翻译的api整合进去了  
