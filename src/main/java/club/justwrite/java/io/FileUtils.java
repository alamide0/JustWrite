package club.justwrite.java.io;

import club.justwrite.java.processor.Execute;

import java.io.*;
import java.util.List;
import java.util.Objects;

@Execute
public class FileUtils {
//    @Execute
//    public static void readString() {
//
//        String fileName = "/Users/zhaoxiaosi/Documents/Private/Train/JustWrite/src/main/java/club/justwrite/string/data.txt";
//        StringBuilder stringBuilder = new StringBuilder();
//
//
//        try {
//            File file = new File(fileName);
//            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
//
//            String line;
//
//            while ((line = bufferedReader.readLine()) != null) {
//                stringBuilder.append(line);
//                stringBuilder.append("\n");
//            }
//
//            bufferedReader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        Printer.print(stringBuilder.toString());
//    }

//    @Execute

    public static String readString(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = null;
        ByteArrayOutputStream bos = null;
        try {

            bufferedInputStream = new BufferedInputStream(inputStream);
            bos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];

            int readCount;

            while ((readCount = bufferedInputStream.read(buffer)) != -1) {
                bos.write(buffer, 0, readCount);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Objects.requireNonNull(bos).toString();
    }

    public static String readString(String fileName) {

        try {
            return readString(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }


    public static void findFileNames(File file, List<String> res, String suffix) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                findFileNames(f, res, suffix);
            }
        } else {
            if (file.getName().endsWith(suffix)) {
                res.add(file.getPath());
            }
        }
    }

    public static void getAllFileNames(File file, List<String> res) {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                getAllFileNames(f, res);
            }
        } else {
            res.add(file.getPath());
        }
    }
}
