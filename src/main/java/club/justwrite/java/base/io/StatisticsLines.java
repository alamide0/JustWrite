package club.justwrite.java.base.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ACC
 * @desc 统计文件夹下，各个文件的行数
 * @create 2020/5/22 10:29 AM
 **/
public class StatisticsLines {
    private final ConcurrentHashMap<String, Long> data;

    private final String folderPath;
    private final String[] suffixNames;//需要扫描文件的后缀名
    private ExecutorService executor = Executors.newCachedThreadPool();
    private static final int PART_SIZE = 1000;

    public StatisticsLines(String folderPath, String[] suffixNames) {
        this.folderPath = folderPath;
        this.suffixNames = suffixNames;
        data = new ConcurrentHashMap<>(this.suffixNames.length);
    }


    public void scan() {

        long startMills = System.currentTimeMillis();

        File file = new File(folderPath);
        List<String> list = new ArrayList<>();
        FileUtils.getAllFileNames(file, list);

        int threadSize = list.size() / PART_SIZE + 1;

        CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        IReadLines readLines = new LineNumberReaderReadLines();


        for (int i = 0; i < threadSize; i++) {

            final int startJ = i * PART_SIZE;
            int temp = i * PART_SIZE + PART_SIZE;
            final int endJ = temp >= list.size() ? list.size() - 1 : temp;

            executor.execute(() -> {
                for (int j = startJ; j < endJ; j++) {
                    String name = list.get(j);
                    String suf = isNeedScan(name);
                    if (suf != null) {
                        long lines = readLines.readLines(name);
                        data.merge(suf, lines, (a, b) -> a + b);
                    }
                }
                countDownLatch.countDown();
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
        }


        Printer.printDivider();
        long totalLines = 0;
        for (String keyName : data.keySet()) {
            Printer.print("File " + keyName + " total line is " + data.get(keyName));
            totalLines += data.get(keyName);
            Printer.printDivider();
        }

        Printer.print("Total line is " + totalLines);

        Printer.print("Cost time " + (System.currentTimeMillis() - startMills) + "ms");

    }

    private String isNeedScan(String name) {
        for (String suf : suffixNames) {
            if (name.endsWith(suf)) {
                return suf;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        StatisticsLines statisticsLines = new StatisticsLines("/Users/zhaoxiaosi/Documents/Work/Android/pregnotice-android", new String[]{"java", "kt", "xml"});
        statisticsLines.scan();
    }


    interface IReadLines {
        long readLines(String file);
    }

    static class LineNumberReaderReadLines implements IReadLines {

        @Override
        public long readLines(String path) {
            File file = new File(path);
            long length = file.length();
            try {
                LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(file));
                lineNumberReader.skip(length);
                lineNumberReader.close();
                return lineNumberReader.getLineNumber();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    static class PathsReadLines implements IReadLines {

        @Override
        public long readLines(String file) {
            try {
                return Files.lines(Paths.get(file)).count();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

}
