package club.justwrite.java.algorithm.leetcode.test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc 用来管理 LeetCode 存放目录的问题
 * @create 2020/6/24
 **/
public class LeetCodeManager {

    private static final String DIR_PATH = "/Users/zhaoxiaosi/Documents/Private/Train/JustWrite/src/main/java/club/justwrite/java/algorithm/leetcode";
    private static final String BLOG_PATH = "/Users/zhaoxiaosi/Documents/Private/Train/JustWrite/blog/algorithm/leetcode";

    public static void main(String[] args) {
        LeetCodeManager leetCodeManager = new LeetCodeManager();
        leetCodeManager.moveFiles();
    }

    public void moveFiles() {

        //move java 源代码文件
        List<String> javas = findFiles(DIR_PATH);
        for (String name : javas) {
            moveAndModifyPackage(name);
        }

        //move blog 下面的文件
        List<String> blogs = findFiles(BLOG_PATH);
        for (String name : blogs) {
            moveBlogs(name);
        }
    }

    private void moveBlogs(String blogName) {
        int offset = blogName.lastIndexOf("LeetCode-");
        int indexer = Integer.parseInt(blogName.substring(offset + "LeetCode-".length(), offset + "LeetCode-0000".length()));

        int start = (indexer - 1) / 50 * 50 + 1;
        int end = start + 49;

        String targetP = "p" + fillNum(start) + "_p" + fillNum(end);
        Path target = Paths.get(BLOG_PATH, File.separator + targetP);
        Path targetFile = Paths.get(BLOG_PATH, File.separator + targetP + File.separator + getSimpleName(blogName));
        if (!Files.exists(target)) {
            try {
                Files.createDirectory(target);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.move(Paths.get(blogName), targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getSimpleName(String path) {
        return path.substring(path.lastIndexOf(File.separator) + 1, path.length());
    }


    private void moveAndModifyPackage(String name) {
        int indexer = Integer.parseInt(name.substring(name.length() - "0000.java".length(), name.length() - ".java".length()));

        int start = (indexer - 1) / 50 * 50 + 1;
        int end = start + 49;

        String targetP = "p" + fillNum(start) + "_p" + fillNum(end);
        Path target = Paths.get(DIR_PATH, File.separator + targetP);
        Path targetFile = Paths.get(DIR_PATH, File.separator + targetP + File.separator + getSimpleName(name));
        if (!Files.exists(target)) {
            try {
                Files.createDirectory(target);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            List<String> sourceLines = Files.readAllLines(Paths.get(name));

            BufferedWriter dest = new BufferedWriter(new FileWriter(targetFile.toFile()));
            boolean hasOverridePackage = false;
            int lines = sourceLines.size();
            int count = 0;
            for (String s : sourceLines) {
                count++;
                if (!hasOverridePackage && s.contains("package")) {
                    dest.write("package club.justwrite.java.algorithm.leetcode." + targetP + ";");
                    hasOverridePackage = true;
                } else {
                    dest.write(s);
                }

                if (count != lines) {
                    dest.write("\n");
                }
            }

            dest.flush();
            dest.close();

            Files.delete(Paths.get(name));//删除
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String fillNum(int n) {
        if (n < 10) {
            return "000" + n;
        } else if (n < 100) {
            return "00" + n;
        } else if (n < 1000) {
            return "0" + n;
        } else {
            return String.valueOf(n);
        }
    }

    private List<String> findFiles(String dir) {
        List<String> res = new ArrayList<>();

        File dirFile = new File(dir);

        for (File f : dirFile.listFiles()) {
            if (!f.isDirectory()) {
                res.add(f.getPath());
            }
        }

        return res;
    }

}
