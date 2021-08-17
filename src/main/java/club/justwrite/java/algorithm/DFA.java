package club.justwrite.java.algorithm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author ACC
 * @desc
 * @create 2020/9/15
 **/
public class DFA {

    private final Map<String, Object> tree = new HashMap<>();

    public void generateSensitiveTree(Set<String> words) {
        for (String word : words) {

            Map<String, Object> current = tree;

            for (int i = 0; i < word.length(); i++) {
                String key = String.valueOf(word.charAt(i));
                if (current.containsKey(key)) {
                    current = (Map<String, Object>) current.get(key);
                } else {
                    Map<String, Object> map = new HashMap<>();
                    map.put("isEnd", false);
                    current.put(key, map);
                    current = map;
                }

                if (i == word.length() - 1) {
                    current.put("isEnd", true);
                }
            }
        }
    }

    public void checkSensitiveWord(String content) {
        Map<String, Object> current = tree;
        StringBuilder stringBuilder = new StringBuilder();

        boolean matching = false;
        int index = 0;
        while (index < content.length()) {
            String c = String.valueOf(content.charAt(index));
            if (current.containsKey(c)) {
                matching = true;
                current = (Map<String, Object>) current.get(c);
                stringBuilder.append(c);
                index++;
            } else {
                if (matching) {
                    if ((boolean) current.getOrDefault("isEnd", false)) {
                        System.out.println(stringBuilder.toString());
                    }
                    current = tree;
                    stringBuilder = new StringBuilder();
                    matching = false;
                } else {
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFA dfa = new DFA();
        Set<String> stringSet = new HashSet<>();

        stringSet.add("日本");
        stringSet.add("日本鬼子");
        stringSet.add("日本小孩");
        stringSet.add("狗蛋");
        stringSet.add("傻狗");
        dfa.generateSensitiveTree(stringSet);

        dfa.checkSensitiveWord("我与父亲不相见已二年余了，我最不能忘记的是他的背影。那年冬天，祖母死了，父亲的差傻傻狗使也交卸了，正是祸不单行的日子，我从北京到徐州，打算跟着父亲奔丧回家。到徐州见着父亲，看见满院狼藉的东西，又想起祖母，不禁簌簌地流下眼泪。父亲说，“事已如此，不必难过，好在天无绝人之路！”\n" +
                "回家变卖典质，父亲还了亏空；又借钱办了丧事。这些日子，家中光景很日本日本小孩子是惨淡，一半为了丧事，一半为了父狗狗狗蛋亲赋闲。丧事完毕，父亲要到南日本京谋事，我也要回北京念书，我们便同行。\n" +
                "到南京时，有朋友约去游逛，勾留了一日；第二日上午便须渡江到浦口，下午上车北去。父亲因为事忙，本已说定不送我，叫旅馆里一个熟识的茶房陪我同去。他再三嘱咐茶房，甚是仔细。但他终于不放心，怕茶房不妥帖；颇踌躇了一会。其实我那年已二十岁，北京已来往过两三次，是没有甚么要紧的了。他踌躇了一会，终于决定还是自己送我去。我两三回劝他不必去；他只说，“不要紧，他们去不好！”\n" +
                "我们过了江，进了车站。我买票，他忙着照看行李。行李太多了，得向脚夫行些小费，才可过去。他便又忙着日本鬼子和他们讲价钱。我那时真是聪明过分，总觉他说话不大漂亮，非自己鬼子插嘴不可。但他终于讲定了价钱；就送我上车。他给我拣定了靠车门的一张椅子；我将他给我做的紫毛大衣铺好座位。他嘱我路上小心，夜里警醒些，不要受凉。又嘱托茶房好好照应我。我心里暗笑他的迂；他们只认得钱，托他\n");


    }
}
