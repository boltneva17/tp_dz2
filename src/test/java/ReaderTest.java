import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ReaderTest{
    @Test
    public void minAndMax() {
        Random random = new Random();
        try {
            for (int i = 1; i <= 1000000; i *= 10) {
                String path = "test" + i;
                File newFile = new File(path);
                if (!newFile.createNewFile()) {
                    new FileWriter(path, false).close();
                }
                int[] expected = new int[2];
                expected[0] = (int) -Math.pow(2, 32) + 1;
                expected[1] = (int) Math.pow(2, 32) - 1;
                FileWriter writer = new FileWriter(path);
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    int x = random.nextInt();
                    expected[0] = Math.max(expected[0], x);
                    expected[1] = Math.min(expected[1], x);
                    builder.append(x);
                    if (j == i - 1) {
                        builder.append("\n");
                    } else {
                        builder.append(" ");
                    }
                }
                writer.write(builder.toString());
                writer.close();
                Reader reader = new Reader(path);
                int[] actual = new int[2];
                actual[1] = reader._min();
                actual[0] = reader._max();
                org.junit.Assert.assertArrayEquals(expected, actual);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void sumAndMult() {
        Random random = new Random();
        try {
            for (int i = 1; i <= 1000000; i *= 10) {
                String path = "test" + i;
                File newFile = new File(path);
                if (!newFile.createNewFile()) {
                    new FileWriter(path, false).close();
                }
                int[] expected = new int[2];
                expected[0] = 0;
                expected[1] = 1;
                FileWriter writer = new FileWriter(path);
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    int x = random.nextInt();
                    expected[0] += x;
                    expected[1] *= x;
                    builder.append(x);
                    if (j == i - 1) {
                        builder.append("\n");
                    } else {
                        builder.append(" ");
                    }
                }
                writer.write(builder.toString());
                writer.close();
                Reader reader = new Reader(path);
                int[] actual = new int[2];
                actual[1] = reader._mult();
                actual[0] = reader._sum();
                org.junit.Assert.assertArrayEquals(expected, actual);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void runTime() {
        Random random = new Random();
        try {
            for (Integer i = 1; i <= 1000000; i *= 10) {
                String path = "test" + i;
                File newFile = new File(path);
                if (!newFile.createNewFile()) {
                    new FileWriter(path, false).close();
                }
                FileWriter writer = new FileWriter(path);
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    int x = random.nextInt();
                    builder.append(x);
                    if (j == i - 1) {
                        builder.append("\n");
                    } else {
                        builder.append(" ");
                    }
                }
                writer.write(builder.toString());
                writer.close();
                long start = System.currentTimeMillis();
                Reader reader = new Reader(path);
                int ignore = reader._max();
                ignore = reader._min();
                ignore = reader._sum();
                ignore = reader._mult();
                long end = System.currentTimeMillis();
                System.out.println(new StringBuilder().append("Time of working with ").append(i).append(" numbers is:").append(end - start));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void myTest() {
        // проверяем, что среднее лежит между наибольшим и наименьшим значениями
        Random random = new Random();
        try {
            for (int i = 1; i <= 1000000; i *= 10) {
                String path = "test" + i;
                File newFile = new File(path);
                if (!newFile.createNewFile()) {
                    new FileWriter(path, false).close();
                }
                int maxVal = (int) -Math.pow(2, 32) + 1;
                int minVal = (int) Math.pow(2, 32) - 1;
                FileWriter writer = new FileWriter(path);
                StringBuilder builder = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    int x = random.nextInt();
                    maxVal = Math.max(maxVal, x);
                    minVal = Math.min(minVal, x);
                    builder.append(x);
                    if (j == i - 1) {
                        builder.append("\n");
                    } else {
                        builder.append(" ");
                    }
                }
                writer.write(builder.toString());
                writer.close();
                Reader reader = new Reader(path);
                int actual_sum = reader._sum();
                org.junit.Assert.assertTrue(actual_sum / i >= minVal && actual_sum / i <= maxVal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



