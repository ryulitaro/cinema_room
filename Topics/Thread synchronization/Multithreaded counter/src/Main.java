class Counter {

    int count = 0;

    public void inc() {
        synchronized (this) {
            count++;
        }
    }
}