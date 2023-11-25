package view;

import java.util.Random;

public class View {
    Random random = new Random();

    public int GetValue(int lowNumber, int hiNumber){
        return random.nextInt(lowNumber, hiNumber);
    }
    public void print(int data, String title){
        System.out.printf("%s %d", title, data);
    }
}
