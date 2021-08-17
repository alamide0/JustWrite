package club.justwrite.java.book;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/13
 **/
public class InnerClass {

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        innerClass.execute();
    }


    public void execute() {
        InnerClass innerClass = new InnerClass();

        Printer.print(innerClass.normalAccess().access(2));
        Printer.print(innerClass.reverseAccess().access(2));


        int d = 100;
        int s = 1000;

        Access res = new Access() {

            @Override
            public int access(int index) {
                return d + s;
            }
        };


        Access res2 = new Access() {

            @Override
            public int access(int index) {
                checkBound(index);
                return data[index];
            }
        };

        res.access(3);
        Printer.print(res.access(3));
        Printer.print(res2.access(3));
    }

    private int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private void checkBound(int index) {
        if (index < 0 || index >= data.length) {
            throw new ArrayIndexOutOfBoundsException("index = " + index);
        }
    }

    public Access normalAccess() {
        return new NormalAccess();
    }

    public Access reverseAccess() {
        return new ReverseAccess();
    }

    private class NormalAccess implements Access {

        @Override
        public int access(int index) {
            checkBound(index);
            return data[index];
        }
    }

    private class ReverseAccess implements Access {

        @Override
        public int access(int index) {
            int destIndex = data.length - index - 1;
            checkBound(destIndex);
            return data[destIndex];
        }
    }
}

