class ThreadUtil {
    public static void printIfDaemon(Thread thread) {
        // implement logic
        String isDemon = thread.isDaemon() ? "daemon" : "not daemon";
        System.out.println(isDemon);
    }
}