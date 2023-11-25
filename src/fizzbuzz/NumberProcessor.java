package fizzbuzz;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

class NumberProcessor extends Thread {
    private int number;
    private Consumer<Integer> processor;
    private AtomicBoolean isNumberProcessed = new AtomicBoolean(true);

    public NumberProcessor(Consumer<Integer> processor) {
        this.processor = processor;
    }

    public boolean isNumberProcessed() {
        return isNumberProcessed.get();
    }

    public void process(int number) {
        this.number = number;
        this.isNumberProcessed.set(false);
    }

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            if (isNumberProcessed.get()) {
                continue;
            }

            processor.accept(number);
            isNumberProcessed.set(true);
        }
    }
}
