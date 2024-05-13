import java.util.ArrayList;
import java.util.List;

public class BerkeleyClock {
    private int clock;
    private int masterTime;

    public BerkeleyClock(int masterTime) {
        this.clock = masterTime;
        this.masterTime = masterTime;
    }

    public synchronized void synchronize(int[] nodeTimes) {
        int average = calculateAverage(nodeTimes);
        adjustTime(masterTime, average, "Master");

        for (int i = 0; i < nodeTimes.length; i++) {
            adjustTime(nodeTimes[i], average, "Client " + i);
        }
    }

    private int calculateAverage(int[] nodeTimes) {
        int sum = masterTime;
        for (int time : nodeTimes) {
            sum += time;
        }
        return sum / (nodeTimes.length + 1);
    }

    private void adjustTime(int time, int average, String identifier) {
        int adjustment = average - time;
        time += adjustment;
        System.out.println(identifier + " time adjusted to: " + time + " (" + adjustment + ")");
    }

    public synchronized int getTime() {
        return clock;
    }

    public static void main(String[] args) {
        int masterTime = 1000;
        System.out.println("Master time: " + masterTime);

        List<Thread> threads = new ArrayList<>();
        BerkeleyClock clock = new BerkeleyClock(masterTime);
        int[] nodeTimes = new int[5];

        for (int i = 0; i < nodeTimes.length; i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                int time = (int) (Math.random() * 2000);
                nodeTimes[index] = time;
                System.out.println("Client " + index + " has local time " + time);
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        clock.synchronize(nodeTimes);
    }
}