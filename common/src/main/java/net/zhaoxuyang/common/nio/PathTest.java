package net.zhaoxuyang.common.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

    public static void main(String[] args) throws IOException {
        String source = "F:\\收藏\\dump.sql";

        //【1】创建Path
        Path path = Paths.get(source);
        Path path_ = FileSystems.getDefault().getPath(source);

        //【2】从Path中获取信息
        System.out.println("绝对路径：" + path.toAbsolutePath());
        System.out.println("文件名：" + path.getFileName().toString());
        System.out.println("父目录：" + path.getParent().getFileName().toString());
        System.out.println("根目录：" + path.getRoot().toString());
        System.out.println("名称元素数量：" + path.getNameCount());
        System.out.println("获取名称元素：" + path.subpath(0, 1));
        System.out.println("--------------------------------");

        //【3】去除冗余项]
        Path normalizedPath = Paths.get("./123").normalize();//去除冗余项
        Path realPath = Paths.get("F:\\收藏\\dump.sql.lnk").toRealPath();//融合了toAbsolutePath()和normalize()

        //【4】Path之间的转换
        Path prefix = Paths.get("C:/");
        System.out.println("合成Path：" + prefix.resolve("exe/123.zip"));
        
        Path path1 = Paths.get("F:\\share\\BigBWA-master\\src");
        Path path2 = Paths.get("F:\\share\\BigBWA-test\\target\\maven-status");
        System.out.println("计算距离："+path1.relativize(path2));
        
        //【5】与java.io.File的转换
        File path2file = Paths.get("path2file").toFile();
        Path file2path = new File("file2path").toPath();
    }
}
