package hadoop.ch03.v17034460237;
import org.apache.hadoop.conf.*;
import org.apache.hadoop.fs.*;
import java.net.URI;
import org.apache.log4j.BasicConfigurator;


public class CreateHDFSFile {
    public static void main(String[] args) throws Exception{
        //自动快速地使用缺省Log4j环境
        BasicConfigurator.configure();
        //获取配置信息
        Configuration conf=new Configuration() ;
        //配置NameNode地址
        URI uri =new URI("hdfs://192.168.30.131:9000");
        //获取FileSystem对象
        FileSystem fs  = FileSystem.get(uri,conf,"hadoop");
        //在hdfs中文件的路径
        Path dfs =new Path("/17034460237/test5.txt");
        //创建文件输入流os
        FSDataOutputStream os=fs.create(dfs,true);
        //输入内容
        os.writeBytes("Hello World");
        //关闭流和文件系统
        os.close();
        fs.close();
    }
}
