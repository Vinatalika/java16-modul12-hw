package unit1;

public class Implementation {
    public static void main(String[] args) {
        TimerThread timer = new TimerThread();
        Thread timerThread = new Thread(() -> timer.startTimer());
        timerThread.start();

        Thread messageThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    System.out.println("Минуло 5 секунд");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        messageThread.start();
    }
}
