package hadoop.ch03.v17034460237;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.log4j.BasicConfigurator;

import java.net.URI;
public class ReadHDFSFile {
    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();
        //获取配置信息
        Configuration conf = new Configuration();
        //获取namenode地址
        URI uri = new URI("hdfs://192.168.30.131:9000");
        //获取FileSystem对象
        FileSystem fs = FileSystem.get(uri,conf,"hadoop");
        //在HDFS中test5的路径
        Path path=new Path("/17034460237/test5.txt");
        FSDataInputStream dis = fs.open(path);
        String str=null;
        while((str=dis.readLine())!=null){
            System.out.println(str);
        }
        //关闭fs流
        fs.close();
    }
}
