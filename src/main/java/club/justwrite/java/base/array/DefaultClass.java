package club.justwrite.java.base.array;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/17
 **/
class DefaultClass implements Inter{

    @Override
    public void g() {
        Printer.print("Print g()");
    }

    private void f(){
        Printer.print("Printer f()");
    }

    private void d(){
        Printer.print("Printer d()");
    }
}
