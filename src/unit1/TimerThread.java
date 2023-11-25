package unit1;

public class TimerThread {
    public void startTimer() {
        long startTime = System.currentTimeMillis();

        while (true) {
            try {
                displayElapsedTime(startTime);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private static void displayElapsedTime(long startTime) {
        long currentTime = System.currentTimeMillis();
        long elapsedTimeInSeconds = (currentTime - startTime) / 1000;

        long hours = elapsedTimeInSeconds / 3600;
        long minutes = (elapsedTimeInSeconds % 3600) / 60;
        long seconds = elapsedTimeInSeconds % 60;

        String formattedTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        System.out.println("Час, що минув від моменту запуску програми: " + formattedTime);
    }
}
