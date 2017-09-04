package model_traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    private static final String GREEN = "зеленый";
    private static final String YELLOW = "желтый";
    private static final String RED = "красный";
    private static final String[] colors = new String[] {GREEN, YELLOW, RED};;

    public void doSwitch() {
        for (String color : colors) {
            printlnColor(color);
            try {
                Thread.sleep(read() * 1000);
            } catch (InterruptedException e) {
//            e.printStackTrace();
                infoBreak();
                return;
            }
        }
    }

    private int read() throws InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        } catch (IOException | NumberFormatException e) {
//            e.printStackTrace();
            System.err.println("Невозможно прочитать время действия");
//            infoBreak();
            throw new InterruptedException();
        }

    }

    private void infoBreak() {
        System.err.println("Светофор сломался");
        System.err.println("Мигает желтый сигнал...");
    }

    private void printlnColor(String color) {
        System.out.println("Загорелся " + color + " свет");
        System.out.println("Горит " + color + "... \nСколько ему гореть? (Вводить в секундах)");
    }
}
