public class TestSingleton {
    public static void main(String args[]){
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println(thread1.getName());
        System.out.println(thread2.getName());
        System.out.println(thread3.getName());
    }

    private static class Thread1 implements Runnable {
        @Override
        public void run() {
            System.out.println("aaa");
            LoggerSingleton logger1 = LoggerSingleton.getInstance();
            logger1.logError("11111", "HIGH");
            logger1.logConnection("100.10.0.82", "18:12");
            logger1.logChange("Folder bin", "00:42");
        }
    }

    private static class Thread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("bbb");
            LoggerSingleton logger2 = LoggerSingleton.getInstance();
            logger2.logError("11251", "LOW");
            logger2.logConnection("122.10.0.7", "11:36");
        }

    }

    private static class Thread3 implements Runnable {
        @Override
        public void run() {
            System.out.println("ccc");
            LoggerSingleton logger3 = LoggerSingleton.getInstance();
            logger3.logConnection("28.100.0.19", "06:37");
            logger3.logChange("File exam.txt", "07:44");
        }
}}