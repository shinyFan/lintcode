package com.jzf.utils;

import java.io.*;

public class Test {

    String basePath="D:/rep/";

    static Integer groupMax=0;

    public static void main(String[] args) throws IOException {
        //
        Test test=new Test();
        //test.init();
        long startTime = System.currentTimeMillis();
        System.out.println(startTime);
        Integer result = test.traverseFolder("D:/rep/");
        long endTime = System.currentTimeMillis();
        System.out.println(endTime);
        System.out.println(endTime-startTime);
        System.out.println(result);
        System.out.println(groupMax);


    }

    void init() throws IOException {


        int i;
        for(i=0;i<10000;i++){
            String secPath=i/1000+"/";
            File dir=new File(basePath+secPath);
            if(!dir.exists())
                dir.mkdir();

            String filePath=basePath+secPath+i+".txt";
            File file=new File(filePath);
            if(!file.exists())
                file.createNewFile();
            FileOutputStream out=new FileOutputStream(filePath);
            PrintStream p=new PrintStream(out);
            p.print(getRandom());
        }
    }

    int getRandom(){
        int x=(int)(Math.random()*80);
        return x;
    }

    public Integer traverseFolder(String path) throws IOException {
        Integer loaclMax=0;
        File file = new File(path);
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null == files || files.length == 0) {
                return 0;
            } else {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        traverseFolder(file2.getAbsolutePath());
                    } else {
                        FileInputStream fis=new FileInputStream(file2);
                        byte[] buf = new byte[1024];
                        StringBuffer sb=new StringBuffer();
                        while((fis.read(buf))!=-1){
                            sb.append(new String(buf));
                            buf=new byte[1024];//重新生成，避免和上次读取的数据重复
                        }
                        String num=sb.toString();
                        num=num.substring(0,num.indexOf("\0"));


                        Integer a=Integer.valueOf(num);
                        loaclMax=loaclMax>a?loaclMax:a;
                        groupMax=groupMax>loaclMax?groupMax:loaclMax;
                    }
                }
            }
        }
        return loaclMax;
    }

}
