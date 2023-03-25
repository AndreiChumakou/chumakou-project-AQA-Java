package by.itacademy.project.chumakou.taf.sledopitby.ui.util;

public class Util {

    public static void waitForPresentation() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
