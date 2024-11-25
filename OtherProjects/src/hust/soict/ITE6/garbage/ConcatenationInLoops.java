package src.hust.soict.ITE6.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random randomGenerator = new Random(123);

        long startTime = System.currentTimeMillis();
        String concatenatedString = "";
        for (int i = 0; i < 65536; i++) {
            concatenatedString += randomGenerator.nextInt(2);
        }
        System.out.println("Time taken with + operator: " + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("Length of concatenatedString using + operator: " + concatenatedString.length());

        randomGenerator = new Random(123);
        startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            stringBuffer.append(randomGenerator.nextInt(2));
        }
        concatenatedString = stringBuffer.toString();
        System.out.println("Time taken with StringBuffer: " + (System.currentTimeMillis() - startTime) + "ms");

        randomGenerator = new Random(123);
        startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            stringBuilder.append(randomGenerator.nextInt(2));
        }
        concatenatedString = stringBuilder.toString();
        System.out.println("Time taken with StringBuilder: " + (System.currentTimeMillis() - startTime) + "ms");
    }
}
