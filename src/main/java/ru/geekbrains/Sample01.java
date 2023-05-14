package ru.geekbrains;

/**
 Создать классы Собака и Кот с наследованием от класса Животное.
 Все животные могут бегать и плыть. В качестве параметра каждому методу передается длина препятствия.
 Результатом выполнения действия будет печать в консоль. (Например, dog1.run(150); -> 'Бобик пробежал 150 м.');
 У каждого животного есть ограничения на действия
 (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
 Добавить подсчет созданных котов, собак и животных.
 */
public class Sample01 {
    public static void main(String[] args) {

        int[] arr = new int[]{12, 3, 5, 6, -6, 3};

        ArrayUtils.PrintArray(arr);

        Animal[] animals = {
                new Cat("Барсик", 20, 30),
                new Dog("Шарик", 50, 100),
                new Cat("Перрсик", 50, 0),
                new Animal("Рога и копыта", 50, 50),
                new Animal("Четыре лапы и хвост", 30, 30)
        };
        for (Animal animal: animals) {
            animal.run(20);
            animal.swim(40);
            animal.run(10);
            animal.swim(20);
            animal.run(30);
            animal.swim(70);

        }
        System.out.printf("Колличество животных: %d\n", Animal.getCounter());
        System.out.printf("Колличество животных: %d\n", Dog.getCounter());
        System.out.printf("Колличество животных: %d\n", Cat.getCounter());


    }
}

class Animal{
    protected String name;
    protected int maxRun;
    protected int maxSwim;
    private static int counter;

    public static int getCounter() {
        return counter;
    }

    {
        counter++;
    }
    public Animal(String name, int maxRun, int maxSwim) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
    }
    public void run(int distance){
        if(distance <= maxRun){
            System.out.printf("%s пробежал %d метров.\n", name, distance);
        } else{
            System.out.printf("%s не смог пробежал %d метров.\n", name, distance);
        }
    }

    public void swim(int distance){
        if(distance <= maxSwim){
            System.out.printf("%s проплыл %d метров.\n", name, distance);
        } else{
            System.out.printf("%s не смог проплыть %d метров.\n", name, distance);
        }
    }
}

class Cat extends Animal{
    private static int counter;

    public static int getCounter() {
        return counter;
    }

    {
        counter++;
    }
    public Cat(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать.", name);
    }
}

class Dog extends Animal{

    private static int counter;
    public static int getCounter() {
        return counter;
    }

    {
        counter++;
    }

    public Dog(String name, int maxRun, int maxSwim) {
        super(name, maxRun, maxSwim);
    }
}