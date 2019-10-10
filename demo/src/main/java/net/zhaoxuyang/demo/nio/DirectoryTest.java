package net.zhaoxuyang.demo.nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DirectoryTest {

    public static void main(String[] args) {
        //【1】找出目录下所有Java文件
        String dir1 = "F:\\2019\\20190308\\ssm.zxy97.com\\src\\com\\zxy97\\ssm\\template";
        listJavaFiles(dir1);

        System.out.println("-----------------------------");

        // 【2】遍历目录树，找出所有Java文件
        try {
            String dir2 = "F:\\2019\\20190308\\ssm.zxy97.com\\src\\com\\zxy97\\ssm";
            Files.walkFileTree(Paths.get(dir2), new FindJavaFileVistor());
        } catch (IOException ex) {
            Logger.getLogger(DirectoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 列出指定目录下的Java文件（不递归）
     *
     * @param dir 目录
     */
    public static void listJavaFiles(String dir) {
        Path dirPath = Paths.get(dir);
        String glob = "*.java";
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(dirPath, glob)) {
            for (Path entry : ds) {
                System.out.println(entry.toAbsolutePath());
            }
        } catch (IOException ex) {
            Logger.getLogger(DirectoryTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * 遍历目录树。继承Java提供的一个实现类，否则实现FileVisitor接口
     */
    private static class FindJavaFileVistor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path entry, BasicFileAttributes attrs) {
            if (entry.toString().endsWith(".java")) {
                System.out.println(entry.toAbsolutePath());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
