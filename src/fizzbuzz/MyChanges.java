package fizzbuzz;

public class MyChanges {
    public static void main(String[] args) {
        NumberProcessor threadA = new NumberProcessor((number) -> {
            if (number % 3 == 0 && number % 5 != 0) {
                System.out.print("fizz");
            }
        });
        NumberProcessor threadB = new NumberProcessor((number) -> {
            if (number % 3 != 0 && number % 5 == 0) {
                System.out.print("buzz");
            }
        });
        NumberProcessor threadC = new NumberProcessor((number) -> {
            if (number % 5 == 0 && number % 3 == 0) {
                System.out.print("fizzbuzz");
            }
        });
        NumberProcessor threadD = new NumberProcessor((number) -> {
            if (number % 5 != 0 && number % 3 != 0) {
                System.out.print(number);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

        for (int i = 1; i <= 20; i++) {
            threadA.process(i);
            threadB.process(i);
            threadC.process(i);
            threadD.process(i);

            while (true) {
                int processedNumbersCount = 0;
                if (threadA.isNumberProcessed()) processedNumbersCount++;
                if (threadB.isNumberProcessed()) processedNumbersCount++;
                if (threadC.isNumberProcessed()) processedNumbersCount++;
                if (threadD.isNumberProcessed()) processedNumbersCount++;

                if (processedNumbersCount == 4) {
                    System.out.println();
                    break;
                }
            }
        }
        threadA.interrupt();
        threadB.interrupt();
        threadC.interrupt();
        threadD.interrupt();
    }
}