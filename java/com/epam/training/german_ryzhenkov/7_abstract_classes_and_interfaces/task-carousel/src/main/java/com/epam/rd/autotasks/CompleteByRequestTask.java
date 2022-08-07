package com.epam.rd.autotasks;

import java.util.stream.Stream;

public class CompleteByRequestTask implements Task {
    boolean isCompleted;
    boolean isFinished;

    @Override
    public void execute() {
        if (isCompleted) isFinished = true;
    }

    @Override
    public boolean isFinished() {
        return isFinished;
    }

    public void complete() {
        isCompleted = true;
    }

    public static void main(String[] args) {

        CompleteByRequestTask cbrt= new CompleteByRequestTask();
        System.out.println(cbrt.isFinished());
        cbrt.complete();
        System.out.println(cbrt.isFinished());
        cbrt.execute();
        System.out.println(cbrt.isFinished());
        cbrt.execute();
        cbrt.complete();
        System.out.println(cbrt.isFinished());
    }
}
