package club.justwrite.java.string;

import club.justwrite.java.io.FileUtils;
import club.justwrite.java.io.Printer;
import com.google.gson.Gson;

import java.io.InputStream;

public class FoodBabyHtmlDecode {

    public static void main(String[] args) {

        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("data.txt");

        String richText = FileUtils.readString(inputStream);

        Gson gson = new Gson();
        String[] res = gson.fromJson(richText, String[].class);

        Steps steps = Steps.decode(res);

        for (StepItem item : steps.steps) {
            Printer.print(gson.toJson(item));

        }


    }
}
