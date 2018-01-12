public class Main implements Runnable {
    private static int SLEEP_MS = 1000;
    private static boolean ABORTED = false;

    private String name;

    Main(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run() {
        while (!ABORTED) {
            System.out.println("Running " + name);

            try {
                Thread.sleep(SLEEP_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void stop() {
        ABORTED = true;
    }

    public static void main(String[] args) {
        String name = String.valueOf(System.currentTimeMillis());
        if (args != null && args.length > 0) {
            name = args[0];
        }

        Main main = new Main(name);

        Thread mainRunner = new Thread(main, "MainRunner");
        mainRunner.setDaemon(false);
        mainRunner.start();
    }
}
