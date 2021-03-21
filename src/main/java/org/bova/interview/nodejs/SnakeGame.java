package org.bova.interview.nodejs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SnakeGame {

    private int boardWidth;

    private int boardHeigth;

    private Random rd;

    private Deque<Point> snake;

    private Point food;

    SnakeGame(int boardWidth, int boardHeigth) {
        this.boardWidth = boardWidth;
        this.boardHeigth = boardHeigth;
        rd = new Random();
        snake = new LinkedList<>();
    }

    public void play() {
        boolean sbakeTouchedTheWall;

//        generateInitialSnakePosition();
//        mockInitialSnakePosition();
//        mockInitialSnakePosition1();
//        mockInitialSnakePosition2();
        mockInitialSnakePosition4_OK();
//        mockInitialSnakePosition5_OK();

        mockFood();

        printScreen();

//        sbakeTouchedTheWall = move(Move.RIGHT);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }
//
//        sbakeTouchedTheWall = move(Move.LEFT);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }
//
//        sbakeTouchedTheWall = move(Move.LEFT);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }
//
//        sbakeTouchedTheWall = move(Move.RIGHT);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }

//        sbakeTouchedTheWall = move(Move.UP);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }
//
//        sbakeTouchedTheWall = move(Move.DOWN);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }
//
//        sbakeTouchedTheWall = move(Move.DOWN);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }
//
//        sbakeTouchedTheWall = move(Move.UP);
//        printScreen();
//        if(sbakeTouchedTheWall) {
//            System.out.println("Snake touched the wall!!!");
//            return;
//        }

        mainLoop();
        int iii = 0;
    }


    private void mainLoop() {
        boolean sbakeTouchedTheWall;
        System.out.println("L - left, R - right, U - up, D - down, Q - quit");

        Scanner input = new Scanner( System.in );
        char command = input.next().charAt(0);

        while(command != 'Q') {
            switch (command) {
                case 'L':
                    sbakeTouchedTheWall = move(Move.LEFT);
                    printScreen();
                    if(sbakeTouchedTheWall) {
                        System.out.println("Snake touched the wall!!!");
                        return;
                    }
                    break;
                case 'R':
                    sbakeTouchedTheWall = move(Move.RIGHT);
                    printScreen();
                    if(sbakeTouchedTheWall) {
                        System.out.println("Snake touched the wall!!!");
                        return;
                    }
                    break;
                case 'U':
                    sbakeTouchedTheWall = move(Move.UP);
                    printScreen();
                    if(sbakeTouchedTheWall) {
                        System.out.println("Snake touched the wall!!!");
                        return;
                    }
                    break;
                case 'D':
                    sbakeTouchedTheWall = move(Move.DOWN);
                    printScreen();
                    if(sbakeTouchedTheWall) {
                        System.out.println("Snake touched the wall!!!");
                        return;
                    }
                    break;
                default:
                    System.out.println("L - left, R - right, U - up, D - down, Q - quit");
                    break;
            }
            command = input.next().charAt(0);
        }
    }

    private void generateInitialSnakePosition() {
        Point snakeHead = new Point(
                getRandomNumber(2, this.boardWidth - 4),
                getRandomNumber(2, this.boardHeigth - 4)
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
    }

    // TODO: create Unit tests based on these checka
    private void mockInitialSnakePosition() {
        Point snakeHead = new Point(
                5,
                2
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
    }

    private void mockInitialSnakePosition1() {
        Point snakeHead = new Point(
                2,
                2
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
    }

    private void mockInitialSnakePosition2() {
        Point snakeHead = new Point(
                3,
                2
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
    }

    private void mockInitialSnakePosition3() {
        Point snakeHead = new Point(
                3,
                8
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
    }

    private void mockInitialSnakePosition4_OK() {
        Point snakeHead = new Point(
                3,
                3
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
    }

    private void mockInitialSnakePosition5_OK() {
        Point snakeHead = new Point(
                3,
                3
        );
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x + 1, snakeHead.y);
        snake.add(snakeHead);
        snakeHead = new Point(snakeHead.x, snakeHead.y + 1);
        snake.add(snakeHead);
    }

    private void mockFood() {
        food = new Point(6, 3);
    }

    private boolean move(Move move) {

        Point point;
        boolean snakeIsInOneRow;
        Point secondElementBeforeTheHead;
        boolean  sbakeTouchedTheWall = false;

        switch (move) {
            case LEFT:
                snake.removeLast();
                point = snake.getFirst();
                snake.offerFirst(new Point(point.getX() - 1, point.getY()));
                point = snake.getFirst();
                if(point.getX() == 1) {
                    sbakeTouchedTheWall = true;
                }
                break;
            case RIGHT:
                snake.removeFirst();
                point = snake.getLast();
                snake.offerLast(new Point(point.getX() + 1, point.getY()));
                point = snake.getLast();
                if(point.getX() == boardWidth - 2) {
                    sbakeTouchedTheWall = true;
                }
                break;
            case UP:
                secondElementBeforeTheHead = getSecondElementBeforeTheHaed();
                point = snake.getLast();
                if(secondElementBeforeTheHead.getY() == point.getY()) {
                    snakeIsInOneRow = true;
                } else {
                    snakeIsInOneRow = false;
                }

                snake.removeLast();
                if(snakeIsInOneRow) {
                    snake.offerLast(new Point(point.getX() - 1, point.getY() - 1));
                    point = snake.getLast();
                    if(point.getY() == boardHeigth - 2) {
                        sbakeTouchedTheWall = true;
                    }
                } else {
                    snake.offerLast(new Point(point.getX() + 1, point.getY() - 1));
                    point = snake.getLast();
                    if(point.getY() == boardHeigth - 2) {
                        if(point.getX() == boardWidth - 2) {
                            sbakeTouchedTheWall = true;
                        }
                    }
                }

                break;
            case DOWN:
                secondElementBeforeTheHead = getSecondElementBeforeTheHaed();
                point = snake.getLast();
                if(secondElementBeforeTheHead.getY() == point.getY()) {
                    snakeIsInOneRow = true;
                } else {
                    snakeIsInOneRow = false;
                }

                snake.removeLast();
                if(snakeIsInOneRow) {
                    snake.offerLast(new Point(point.getX() - 1, point.getY() + 1));
                    point = snake.getLast();
                    if(point.getY() == boardHeigth - 2) {
                        sbakeTouchedTheWall = true;
                    }
                } else {
                    snake.offerLast(new Point(point.getX() + 1, point.getY() + 1));
                    point = snake.getLast();
                    if(point.getY() == boardHeigth - 2) {
                        if(point.getX() == boardWidth - 2) {
                            sbakeTouchedTheWall = true;
                        }
                    }
                }
                break;
        }

        if(snake.contains(food)) {
            point = snake.getFirst();
            snake.offerFirst(new Point(point.getX() - 1, point.getY()) );
        }

        return sbakeTouchedTheWall;
    }

    private void printScreen() {
        for(int i = 0; i < boardHeigth; i++) {
            for(int j = 0; j < boardWidth; j++) {
                if(snake.contains(new Point(j,i))) {
                    System.out.print('>');
                } else if (i == 0 || i == boardHeigth - 1) {
                    System.out.print('*');
                } else if(j == 0 || j == boardHeigth - 1) {
                    System.out.print('*');
                } else if(food.getY() == i && food.getX() == j) {
                    System.out.print('+');
                } else {
                    System.out.print(' ');
                }
            }
            System.out.println(" ");
        }
        System.out.println("------------------------------------");
    }

    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    private Point getSecondElementBeforeTheHaed() {
        List<Point> list = (LinkedList) snake;

        return list.get(snake.size() - 2);
    }
}
