package com.epam.rd.autotasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskCarousel {
    int capacity;
    List<Task> taskList;
    int index;

    public TaskCarousel(int capacity) {
        if (capacity > 0) {
            this.capacity = capacity;
            this.taskList = new ArrayList<>();
        }
    }

    public boolean addTask(Task task) {
        if (task != null && !task.isFinished() &&  capacity > 0) {
            taskList.add(task);
            capacity--;
            return true;
        }
        return false;
    }

    public boolean execute() {
        if (taskList.size() > 0 ) {
            taskList.get(index).execute();
            if (taskList.get(index).isFinished()) {
                taskList.remove(index);
                capacity++;
                index--;
            }
            index++;
            if (index == taskList.size()) index = 0;
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return capacity <= 0;
    }

    public boolean isEmpty() {
        return taskList.isEmpty();
    }

    public static void main(String[] args) {
        TaskCarousel carousel = new TaskCarousel(3);

        CountDownTask task1 = new CountDownTask(2);
        CountDownTask task2 = new CountDownTask(2);
        CompleteByRequestTask task3 = new CompleteByRequestTask();

        System.out.println(carousel.addTask(task1)); //true
        System.out.println(carousel.addTask(task2)); //true
        System.out.println(carousel.addTask(task3)); //true
        System.out.println();

        System.out.println(carousel.isFull()); // true
        System.out.println();

        for(int i = 0; i < 100; i++){
            System.out.println(carousel.execute()); // true
        }
        System.out.println();

        System.out.println(task1.isFinished()); // true
        System.out.println(task2.isFinished()); // true
        System.out.println(task3.isFinished()); // false
        System.out.println();

        task3.complete();

        System.out.println(task3.isFinished()); // false
        System.out.println(carousel.execute()); // true
        System.out.println(task3.isFinished()); // true
        System.out.println();

        System.out.println(carousel.isEmpty()); // true


    }
}
