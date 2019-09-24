package net.zhaoxuyang.common.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FilesTest {

    public static void main(String[] args) throws IOException {

        //【1】创建文件
        //直接创建
        Path target1 = Paths.get("C:\\target1.txt");
        Path newFile = Files.createFile(target1);//直接创建文件

        //带属性地创建
        Path target2 = Paths.get("C:\\target2.txt");
        Set<PosixFilePermission> pfpSet = PosixFilePermissions.fromString("rw-rw-rw-");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(pfpSet);
        Files.createFile(target2, attr);//带属性地创建

        //【2】删除文件
        Files.delete(target1);//删除文件

        //【3】文件的复制
        Path sourcePath = Paths.get("");
        Path targetPath = Paths.get("");
        Files.copy(sourcePath, targetPath);//
        //可以附加多个选项
        //COPY_ATTRIBUTES：复制文件属性
        //ATOMIC_MOVE：原子性。确保两边都完成，否则回滚（例如复制或移动文件夹时）
        Files.copy(sourcePath, targetPath, COPY_ATTRIBUTES, ATOMIC_MOVE);//附加选项
        Files.move(sourcePath, targetPath, COPY_ATTRIBUTES, ATOMIC_MOVE);//附加选项

        //【4】文件的属性
        Path filePath = Paths.get("C:\\offline_FtnInfo.txt");
        System.out.println(Files.getLastModifiedTime(filePath));//最后修改时间
        System.out.println(Files.size(filePath));//字节数
        System.out.println(Files.isSymbolicLink(filePath));//是否符号链接
        System.out.println(Files.isDirectory(filePath));//是否文件夹
        System.out.println(Files.readAttributes(filePath, "*"));//读取所有属性

        //【5】设置文件属性
        try {
            Path profile = Paths.get("");
            PosixFileAttributes attrs = Files.readAttributes(profile, PosixFileAttributes.class);//获取属性视图
            Set<PosixFilePermission> permissions = attrs.permissions();//读取访问许可
            permissions.clear();//消除访问许可

            //日志信息
            String owner = attrs.owner().getName();
            String perms = PosixFilePermissions.toString(permissions);
            System.out.format("%s %s\n", owner, perms);

            //设置新的访问许可
            permissions.add(PosixFilePermission.OWNER_READ);//所有者可读
            permissions.add(PosixFilePermission.OWNER_WRITE);//所有者可写
            permissions.add(PosixFilePermission.GROUP_READ);//组内可读
            permissions.add(PosixFilePermission.OTHERS_READ);//其他人可读
            Files.setPosixFilePermissions(filePath, permissions);

        } catch (IOException e) {
            System.out.println(e);
        }

        //【6】快速读写数据
        Path readFile = Paths.get("");
        try (BufferedReader reader = Files.newBufferedReader(filePath, UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                //
            }
        }

        Path writePath = Paths.get("");
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, UTF_8, WRITE)) {
            writer.write("Hello!");
        }

        //【7】简化读取和写入
        Path readFile2 = Paths.get("");
        List<String> lines = Files.readAllLines(readFile2);
        byte[] bytes = Files.readAllBytes(readFile2);

        //【8】监测文件或目录的变化
        try {
            Path dir = Paths.get("C:/");
            WatchService watcher = FileSystems.getDefault().newWatchService();
            WatchKey key = dir.register(watcher, ENTRY_MODIFY);//监测修改变化

            boolean shutdown = false;
            while (!shutdown) {
                key = watcher.take();
                for (WatchEvent<?> event : key.pollEvents()) {
                    if (event.kind() == ENTRY_MODIFY) {
                        System.out.println(event.kind() + dir.toString());
                    }
                }
                key.reset();
            }
        } catch (IOException | InterruptedException e) {
            Logger.getLogger(FilesTest.class.getName()).log(Level.SEVERE, null, e);
        }

        //【9】运用FileChannel的寻址能力读取文件中的最后1000个字符
        Path bigFilePath = Paths.get("F:\\收藏\\dump.sql");//90MB左右
        ByteBuffer buffer = ByteBuffer.allocate(2048);
        FileChannel channel = FileChannel.open(bigFilePath, READ);
        channel.read(buffer, channel.size() - 1000);
    }
}
