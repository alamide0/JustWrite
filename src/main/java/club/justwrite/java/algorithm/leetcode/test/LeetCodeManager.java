package club.justwrite.java.algorithm.leetcode.test;

import club.justwrite.java.io.Printer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author ACC
 * @desc 用来管理 LeetCode 存放目录的问题
 * @create 2020/6/24
 **/
public class LeetCodeManager {

    private static final String DIR_PATH = "/Users/zhaoxiaosi/Documents/Private/Train/JustWrite/src/main/java/club/justwrite/java/algorithm/leetcode";
    private static final String BLOG_PATH = "/Users/zhaoxiaosi/Documents/Private/Train/JustWrite/blog/algorithm/leetcode";
    private static final String INDEXER_PATH = "/Users/zhaoxiaosi/Documents/Private/Train/JustWrite/blog/algorithm/leetcode/Index.md";

    public static void main(String[] args) {
        LeetCodeManager leetCodeManager = new LeetCodeManager();
//        leetCodeManager.moveFiles();
        try {
            leetCodeManager.generateIndexer();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateIndexer() throws IOException {
        File file = new File(DIR_PATH);

        File[] files = file.listFiles();
        List<String> dirList = new ArrayList<>();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(INDEXER_PATH));
        bufferedWriter.write("# LeetCode Indexer\n");

        String pattern = "^p\\d{4}_p\\d{4}$";
        for (File f : files) {
            if (!f.isDirectory() || !Pattern.matches(pattern, f.getName())) continue;
            dirList.add(f.getAbsolutePath());
        }

        Collections.sort(dirList);

        for (String dir : dirList) {
            String simpleName = dir.substring(DIR_PATH.length() + 1);
            bufferedWriter.write("## " + simpleName.substring(1, 5) + "-" + simpleName.substring(7));
            bufferedWriter.newLine();
            File[] fs = new File(dir).listFiles();

            List<String> fileList = new ArrayList<>(fs.length);
            for (File f : fs) {
                fileList.add(f.getName());
            }

            Collections.sort(fileList);

            int count = 0;
            for (String fn : fileList) {
                bufferedWriter.write("[" + fn.substring("LeetCode".length(), "LeetCode".length() + 4) + "](" + "../../../src/main/java/club/justwrite/java/algorithm/leetcode/" + simpleName + "/" + fn + ")\t\t");
                count++;
                if (count / 10 == 1) {
                    count = 1;
                    bufferedWriter.write("\n");
                }
            }
            bufferedWriter.newLine();
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }

    public void moveFiles() {

        //move java 源代码文件
        List<String> javas = findFiles(DIR_PATH + "/ptemp");
        for (String name : javas) {
            if (name.contains("LeetCode")) {
                moveAndModifyPackage(name);
            }
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
