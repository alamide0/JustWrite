package club.justwrite.java.string;

import club.justwrite.java.io.Printer;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Content {
    public List<ContentItem> contents = new ArrayList<>(2);
    private static IDecode decode = new PatternDecode();

    public static void main(String[] args) {
//        String s = "<img alt=\"\" src=\"https://static.ladybirdedu.com/upload_new/images/common/2020/03/10/dYsNpbUkExFTCodi.jpeg\" style=\"width: 1920px; height: 1080px;\">";
//        Pattern pattern = Pattern.compile("src=\"(.*?)\"");
//        Matcher matcher = pattern.matcher(s);
//        while (matcher.find()) {
//            Printer.print(matcher.group(1));
//        }

        Content content = decode("<p>加入100ml水，中火煮约8分钟，煮至变软。</p><p><img alt=\"\" src=\"https://static.ladybirdedu.com/upload_new/images/common/2020/03/10/KQsVKqcTMhEgl3w0.jpeg\" style=\"width: 1920px; height: 1080px;\"></p>");

        Gson gson = new Gson();
        Printer.print(gson.toJson(content));
    }

    public static Content decode(String htmlContent) {
        return decode.decode(htmlContent);
    }

    static class PatternDecode implements IDecode {

        private static Pattern labelP = Pattern.compile("<p>\\s*?(.*)\\s*?</p>");
        private static Pattern imgP = Pattern.compile("src=\"(.*?)\"");
        private static Pattern chineseP =Pattern.compile(".*?([\u4e00-\u9fa5]+.*)");

        @Override
        public Content decode(String htmlContent) {
            Content content = new Content();
            Matcher matcher = labelP.matcher(htmlContent);

            while (matcher.find()) {
                String m = matcher.group(1);
                Printer.print(m);
                if (m.contains("<img")) {
                    Matcher matcherImg = imgP.matcher(m);
                    if (matcherImg.find()) {
                        ContentItem contentItem = new ContentItem(ContentType.IMAGE);
                        contentItem.content = matcherImg.group(1);
                        content.contents.add(contentItem);
                    }
                } else {
                    Matcher matcherChinese = chineseP.matcher(m);
                    if(matcherChinese.find()){
                        ContentItem contentItem = new ContentItem(ContentType.TEXT);
                        contentItem.content = matcherChinese.group(1);
                        content.contents.add(contentItem);
                    }

                }
            }
            return content;
        }
    }

    interface IDecode {
        Content decode(String htmlContent);
    }
}
