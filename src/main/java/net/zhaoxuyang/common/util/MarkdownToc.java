package net.zhaoxuyang.common.util;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * MarkDown目录生成
 *
 * @author zhaoxuyang
 */
public class MarkdownToc {

    public static String getToc(String filePath) throws IOException {
        StringBuilder result = new StringBuilder(2048);
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        for (String line : lines) {
            // 包含#加空格则视为标题
            if (line.contains("# ")) {
                result.append(tranTitle(line)).append("\n");
            }
        }
        System.out.println(result.toString());
        return result.toString();
    }

    public static String tranTitle(String line) {
        StringBuilder result = new StringBuilder(2048);
        
        //统计标题级别，以添加对应的列表缩进大小
        int lastIndex = line.lastIndexOf('#');
        //<a>标签里的内容
        String right = line.replaceAll("(#+ )", "");
        
        //替换()和.号，字母转小写，如果有其他的替换规则，也可以在这里更改
        String link = right.replaceAll("\\.", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll(" ", "-")
                .replaceAll(right, right)
                .toLowerCase();
        //添加列表的缩进，i=1，表示从二级标题开始，个人习惯，这里可以更改
        for (int i = 1; i < lastIndex; i++) {
            result.append('\t');
        }
        
        //添加列表和链接
        result.append("- ")
                .append("<a href=\"#")
                .append(link)
                .append("\">")
                .append(right)
                .append("</a>");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        //getToc("/Code/project/模式.md");
        getToc(args[0]);
    }
}
