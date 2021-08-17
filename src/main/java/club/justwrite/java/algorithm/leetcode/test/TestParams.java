package club.justwrite.java.algorithm.leetcode.test;

import club.justwrite.java.base.io.Printer;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author ACC
 * @desc
 * @create 2020/6/22
 **/
public class TestParams<Result> {
    Object[] params;
    Result result;

    public TestParams(Object[] params, Result result) {
        this.params = params;
        this.result = result;
    }

    public TestParams(Object params, Result result) {
        this.params = new Object[]{params};
        this.result = result;
    }

    public Object[] getParams() {
        return params;
    }

    public Result getResult() {
        return result;
    }

    public boolean isCorrect(Result realResult) {
        boolean res = realResult.getClass().isArray() ? Objects.deepEquals(realResult, result) : Objects.equals(realResult, result);
        String pms = params.length > 1 ? Arrays.deepToString(params) : params.length == 1 ? params[0].toString() : " no params";
        if (res) {
            Printer.print("Passed, params = " + pms + "，result = " + string(result));
        } else {
            Printer.print("Not Passed, params = " + pms + " ，excepted result = " + string(result) + "，real result = " + string(realResult));
        }
        return res;
    }

    private static String string(Object info) {
        if (info.getClass().isArray()) {
            Class cls = info.getClass().getComponentType();
            if (cls == String.class) {
                String[] strings = (String[]) info;
                return Arrays.toString(strings);
            } else if (cls == int.class) {
                return Arrays.toString((int[]) info);
            } else {
                return Arrays.toString((Object[]) info);
            }
        } else {
            return info.toString();
        }
    }
}
