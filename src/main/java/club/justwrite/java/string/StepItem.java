package club.justwrite.java.string;

public class StepItem {
    public Content content;

    public static StepItem decode(String content) {
        StepItem stepItem = new StepItem();
        stepItem.content = Content.decode(content);
        return stepItem;
    }
}
