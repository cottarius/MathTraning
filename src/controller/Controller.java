package controller;

import menu.Menu;
import model.Model;
import view.View;

import java.io.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Controller {
    Random random = new Random();
    Scanner in = new Scanner(System.in);
    private View view;
    private Model model;
    private Menu menu;

    public Controller(View view, Model model, Menu menu) {
        this.view = view;
        this.model = model;
        this.menu = menu;
    }

    /**
     * Главный метод
     * Генерируется два произвольных числа от определённом диапазоне.
     * Выбирается знак матемачисекой операции.
     * Пользователю предлагается ввести ответ.
     * Далее идёт сравнение ответа пользователя с правильным ответом
     */
    public void start(){
        try {
            //BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(new FileWriter("log.txt", true));
            String currentDateTime = LocalDate.now().toString();
            out.println("\n" + currentDateTime);
            String lineFromInput;
            int firstNumber;
            int secondNumber;
            int result;
            int inputResult;

            menu.run();
            menu.chooseOperation();
            int operationChoice = in.nextInt();
            switch (operationChoice) {
                case 1 -> {
                    for(int i = 0; i < 10; i++) {
                        firstNumber = view.GetValue(3, 20);
                        secondNumber = view.GetValue(3, 20);
                        if (random.nextInt(0, 2) == 0) {

                            System.out.printf("%d + %d = ", firstNumber, secondNumber);
                            inputResult = inputInt();
                            lineFromInput = firstNumber + " + " + secondNumber + " = " + inputResult;
                            out.println(lineFromInput);
                            result = model.addition(firstNumber, secondNumber);

                        } else {
                            if (firstNumber < secondNumber){
                                int temp = firstNumber;
                                firstNumber = secondNumber;
                                secondNumber = temp;
                            }
                            System.out.printf("%d - %d = ", firstNumber, secondNumber);
                            inputResult = inputInt();
                            lineFromInput = firstNumber + " - " + secondNumber + " = " + inputResult;
                            out.println(lineFromInput);
                            result = model.subtraction(firstNumber, secondNumber);
                        }
                        if (model.isEqual(inputResult, result)) {
                            System.out.println("Правильно!");
                        } else {
                            System.out.printf("Неправильно! Правильный ответ: %d\n", result);
                            out.println("Ошибка");
                        }
                    }
                    System.out.print("Для выхода нажмите клавишу 0\n");
                    in.nextInt();
                    out.close();
                }
                case 2 -> {
                    for (int i =0; i < 10; i++){
                        firstNumber = view.GetValue(1, 11);
                        secondNumber = view.GetValue(2, 3);
                        System.out.printf("%d * %d = ", firstNumber, secondNumber);
                        inputResult = inputInt();
                        lineFromInput = firstNumber + " * " + secondNumber + " = " + inputResult;
                        out.println(lineFromInput);
                        result = model.Multiply(firstNumber, secondNumber);
                        if (model.isEqual(inputResult, result)) {
                            System.out.println("Правильно!");
                        } else {
                            System.out.printf("Неправильно! Правильный ответ: %d\n", result);
                        }
                    }
                    System.out.print("Для выхода нажмите клавишу 0\n");
                    in.nextInt();
                    out.close();
                }
            }
        } catch (IOException ioException){
            System.out.print("Error during reading/writing");
        }
    }
    int inputInt() {
//        System.out.print(prompt);
        while(true){
            try {
                return Integer.parseInt(new Scanner(System.in).next());
            } catch(NumberFormatException ne) {
                System.out.print("Введите число! ");
            }
        }
    }
}


