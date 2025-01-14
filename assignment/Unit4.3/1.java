class Meow {
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    lock.notify();
                    try {
                        if (i != 9) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread evenThread = new Thread(() -> {
            for (int i = 2; i <= 10; i += 2) {
                synchronized (lock) {
                    System.out.println(i);
                    lock.notify();
                    try {
                        if (i != 10) {
                            lock.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        oddThread.start();
        evenThread.start();
    }
}
