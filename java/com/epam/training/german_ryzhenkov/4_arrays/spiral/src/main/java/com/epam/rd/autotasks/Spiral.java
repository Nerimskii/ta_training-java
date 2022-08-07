package com.epam.rd.autotasks;

class Spiral {
    static int[][] spiral(int rows, int columns) {

        int firstNumber = 1;
        int[][] spiralArray = new int[rows][columns];

        if (rows == 1) {
            for (int i = 0; i < columns; i++) {
                spiralArray[0][i] = firstNumber;
                firstNumber++;
            }

        } else {

            for (int i = 0; i < columns; i++) {
                spiralArray[0][i] = firstNumber;
                firstNumber++;
            }
            for (int i = 1; i < rows; i++) {
                spiralArray[i][columns - 1] = firstNumber;
                firstNumber++;
            }
            for (int i = columns - 2; i >= 0; i--) {
                spiralArray[rows - 1][i] = firstNumber;
                firstNumber++;
            }
            for (int i = rows - 2; i > 0; i--) {
                spiralArray[i][0] = firstNumber;
                firstNumber++;
            }
            
            int c = 1;
            int d = 1;

            while (firstNumber < rows * columns) {
                //right
                while (spiralArray[c][d + 1] == 0) {
                    spiralArray[c][d] = firstNumber;
                    firstNumber++;
                    d++;
                }

                //down
                while (spiralArray[c + 1][d] == 0) {
                    spiralArray[c][d] = firstNumber;
                    firstNumber++;
                    c++;
                }

                //left
                while (spiralArray[c][d - 1] == 0) {
                    spiralArray[c][d] = firstNumber;
                    firstNumber++;
                    d--;
                }

                //up
                while (spiralArray[c - 1][d] == 0) {
                    spiralArray[c][d] = firstNumber;
                    firstNumber++;
                    c--;
                }
            }

            //center is 0. fix it

            for (int x = 0; x < rows; x++) {
                for (int y = 0; y < columns; y++) {
                    if (spiralArray[x][y] == 0) {
                        spiralArray[x][y] = firstNumber;
                    }
                }
            }
        }
        return spiralArray;
    }
}
