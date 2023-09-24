/*Необходимо написать программу – розыгрыша игрушек в магазине детских товаров. 
Желательный функционал программы:
В программе должен быть минимум один класс со следующими свойствами:
id игрушки,
текстовое название,
количество
частота выпадения игрушки (вес в % от 100)
 
Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)
Возможность организовать розыгрыш игрушек.

Например, следующим образом:
С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.
Это список призовых игрушек, которые ожидают выдачи.
Еще у нас должен быть метод – получения призовой игрушки.
После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.
Не забываем уменьшить количество игрушек
*/
/*1) Напишите класс-конструктор у которого принимает минимум 3 строки,
содержащие три поля id игрушки, текстовое название и частоту выпадения игрушки
2) Из принятой строки id и частоты выпадения(веса) заполнить минимум три массива.
3) Используя API коллекцию: java.util.PriorityQueue добавить элементы в коллекцию
4) Организовать общую очередь 
5) Вызвать Get 10 раз и записать результат в файл */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input quantity of all toys in shop: ");
        Integer all = Integer.parseInt(sc.nextLine());
        System.out.println("Input number of kinds of toys: ");
        Integer kinds = Integer.parseInt(sc.nextLine()); 
        Toy[] toyList = new Toy[kinds];
        System.out.println("Input new toy: ");
        float sumWeight = 0;
        if (kinds != 1) {
        for (int i = 1; i < kinds; i++) {
            System.out.println("Input name of toy: ");
            String name = sc.nextLine();
            System.out.println("Input weight of toy(in persents, 20 for example): ");
            float weight = Integer.parseInt(sc.nextLine());
            toyList[i-1] = addToy(i, name, weight, all);
            sumWeight += toyList[i-1].getWeight();
        }
        }
        System.out.println("Input name of toy: ");
        toyList[kinds - 1] = addToy(kinds, sc.nextLine(), 100 - sumWeight, all);
        ArrayList<Toy> toyQueue = new ArrayList<>();
        toyQueue = getToy(kinds, all, toyList);
       
        sc.close();

        File myFile = new File("queue.txt");
        try {
            myFile.createNewFile();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        try (PrintWriter writer = new PrintWriter("queue.txt")) {
            writer.println("\n");
            for (Toy toy : toyQueue) {
                writer.println(toy);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } 
    }
    
    public static Toy addToy(Integer id, String name, Float weight, int allToys){
            int quantity = Math.round(weight / 100 * (float) allToys);
            Toy newToy = new Toy(id, name, quantity, weight);
            return newToy;
        }
    
    public static ArrayList<Toy> getToy(Integer numberOfKinds, Integer numberOfToys, Toy[] toyList ){
        ArrayList<Toy> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 1; i < numberOfToys + 1; i++) {
            int id = rand.nextInt(numberOfKinds) + 1;
            for (Toy toy : toyList) {
                if (toy.getId().equals(id)){
                    int n = toy.getQuantity();
                    if (n > 0){
                        Toy copyToy = new Toy(toy.getId(), toy.getName(), n, toy.getWeight());
                        list.add(copyToy);
                        n --;
                        //toy.setQuantity(n - 1);
                        toy.setQuantity(n);
                    } else {
                        i--;
                    }
                }
            }
        }
        return list;
    }

}



/* Тесты: 
3. Ошибки при работе с файлами


*/ 
