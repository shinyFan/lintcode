package com.ibeifeng.sparkproject.util;

/**
 * Created by JINZONGFAN on 2019/6/22 16:45
 */

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;

import java.net.URI;

public class HdfsClient {
    public static void main(String[] args) throws Exception {
        HdfsClient client=new HdfsClient();
        client.testAddFileToHdfs();
        //client.testListAll();
    }

    FileSystem fs = null;

    /**
     * 初始化FileSystem
     */
    public void init() throws Exception {
        // 构造一个配置参数对象，设置一个参数：我们要访问的hdfs的URI
        // 从而FileSystem.get()方法就知道应该是去构造一个访问hdfs文件系统的客户端，以及hdfs的访问地址
        // new Configuration();的时候，它就会去加载jar包中的hdfs-default.xml
        // 然后再加载classpath下的hdfs-site.xml
        Configuration conf = new Configuration();
        //conf.set("fs.defaultFS", "hdfs://hdp-node01:9000");
        /**
         * 参数优先级： 1、客户端代码中设置的值 2、classpath下的用户自定义配置文件 3、然后是服务器的默认配置
         */
        //conf.set("dfs.replication", "3");

        // 获取一个hdfs的访问客户端，根据参数，这个实例应该是DistributedFileSystem的实例
        // fs = FileSystem.get(conf);

        // 如果这样去获取，那conf里面就可以不要配"fs.defaultFS"参数，而且，这个客户端的身份标识已经是hadoop用户
        conf.set("dfs.client.use.datanode.hostname", "true");//让可以使用主机名传参数
//        conf.set("fs.defaultFS", "hdfs://spark1:8020");//主机名访问
        fs = FileSystem.get(new URI("hdfs://47.110.51.243:9000/streaming_checkpoint"), conf, "root");
        //   fs = FileSystem.get(new URI("hdfs://39.96.84.195:9000/streaming_checkpoint"), conf, "root");
    }

    /**
     * 往hdfs上传文件
     */
    public void testAddFileToHdfs() throws Exception {
        init();
        // 要上传的文件所在的本地路径
        Path src = new Path("d:/data/tttt.png");
        // 要上传到hdfs的目标路径
        Path dst = new Path("/");
        fs.copyFromLocalFile(src, dst);

        fs.close();
    }

    /**
     * 从hdfs中复制文件到本地文件系统
     */
    public void testDownloadFileToLocal() throws Exception {
        init();
        fs.copyToLocalFile(new Path("/hosts"), new Path("d:/"));
        fs.close();
    }

    /**
     * 在hfds中创建目录、删除目录、重命名
     */
    public void testMkdirAndDeleteAndRename() throws Exception {
        init();
        // 创建目录
        fs.mkdirs(new Path("/a1/b1/c1"));

        // 删除文件夹 ，如果是非空文件夹，参数2必须给值true
        fs.delete(new Path("/aaa"), true);

        // 重命名文件或文件夹
        fs.rename(new Path("/a1"), new Path("/a2"));
    }

    /**
     * 查看目录信息，只显示文件
     */
    public void testListFiles() throws Exception {
        init();
        // 思考：为什么返回迭代器，而不是List之类的容器
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();

            System.out.println(fileStatus.getPath().getName());
            System.out.println(fileStatus.getBlockSize());
            System.out.println(fileStatus.getPermission());
            System.out.println(fileStatus.getLen());
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            for (BlockLocation bl : blockLocations) {
                System.out.println("block-length:" + bl.getLength() + "--" + "block-offset:" + bl.getOffset());
                String[] hosts = bl.getHosts();
                for (String host : hosts) {
                    System.out.println(host);
                }
            }
            System.out.println("--------------分割线--------------");
        }
    }

    /**
     * 查看文件及文件夹信息
     */
    public void testListAll() throws Exception {
        init();
        FileStatus[] listStatus = fs.listStatus(new Path("/"));
        String flag = "d--             ";

        for (FileStatus fstatus : listStatus) {
            if (fstatus.isFile())
                flag = "f--         ";
            System.out.println(flag + fstatus.getPath().getName());
        }
    }
}