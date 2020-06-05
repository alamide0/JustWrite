package club.justwrite.java.string;


import java.util.ArrayList;
import java.util.List;

public class Steps {

    public List<StepItem> steps = null;

    public static Steps decode(String[] steps) {
        if (steps == null) return null;
        Steps res = new Steps();
        res.steps = new ArrayList<>(steps.length);
        for (String str : steps) {
            res.steps.add(StepItem.decode(str));
        }
        return res;
    }

}
