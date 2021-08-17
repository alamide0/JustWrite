package club.justwrite.java.base.regex;

import club.justwrite.java.base.io.Printer;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    public boolean isValidMobileNumber(String number){
        if(number == null || number.length() != 11 || number.charAt(0) != '1'){
            return false;
        }

        for(int i=1; i < number.length(); i++){
            if(number.charAt(i) < '0' || number.charAt(i) > '9'){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        Printer.print("abc".matches("abc"));
//        Printer.print("abc".matches("Abc"));
//        Printer.print("abc".matches("a.c"));
//        Printer.print(isPhoneNumber("18362983833"));

//        String content = "this is china ! yes no ";
//
//        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
//
//        Matcher matcher = pattern.matcher(content);
//
//
//        while (matcher.find()){
//            Printer.print(matcher.group());
//        }
//
//        Printer.print(isContainChineseCharacter("中国niu人"));
//        Printer.print("aa aaa aaa aaaaa sss ".replaceAll("\\s([a-z]{3})\\s", " <a>$1</a> "));
//
//        String s = "the quick brown fox jumps over over the lazy dog.";
//        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
//        System.out.println(r);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://www.baidu.com")
                .build();

        try {
            Response execute = client.newCall(request).execute();
            String string = execute.body().string();
            System.out.println("string = " + string);
            extractUrls(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isContainChineseCharacter(String content){
        String regex = "([\\u4E00-\\u9FA5]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            Printer.print(matcher.group());
        }
        return matcher.matches();
    }

    public static void extractUrls(String content){
        String regex = "(http://.*?)[>\\s']";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()){
            System.out.println(matcher.groupCount());
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
        }
    }

    public static boolean isPhoneNumber(String phone){
        String regex = "1\\d{10}";
        return phone != null && phone.matches(regex);
    }

    public static boolean isEmail(){
        return false;
    }
}
