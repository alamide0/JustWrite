package club.justwrite.android.router.compiler;

import javax.annotation.processing.Messager;
import javax.tools.Diagnostic;

/**
 * @author ACC
 * @desc
 * @create 2020/5/9 11:03 AM
 **/
final class Logger {
    private Messager messager;
    private String prefix = ">>>>>>>> ";

    Logger(Messager messager) {
        this.messager = messager;
    }

    void info(String info) {
        messager.printMessage(Diagnostic.Kind.NOTE, prefix + info);
    }

    void error(String info) {
        messager.printMessage(Diagnostic.Kind.ERROR, prefix + info);
    }

    void warning(String warning) {
        messager.printMessage(Diagnostic.Kind.WARNING, prefix + warning);
    }
}
