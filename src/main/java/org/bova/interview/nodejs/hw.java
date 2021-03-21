package org.bova.interview.nodejs;

import java.util.Scanner;

/*
The Snake

We are going to build today the legacy snake game using nodejs and console as a GUI.
Not in a  browser!


Steps :
Display only the board of the the game (n*m)
Display a snake on the board with length of 3 points
Make the snake move only when a key is being pressed - (no need to implement continuous movement )
Handle collisions with walls and the snake itself
Add random food to the board and when the snake eat it remove the food and make the snake a bigger (1 point)
Bonus: Make the snake move constantly and only change the snake direction when key is pressed

***************

***  *

 ***  *

           ****
----
Point {
    int x;
    int y;
}

Point[SNACK_MAX_LENGHT] = ?;
    Set?


par
    80
    10



**********
*        *
* ***    *
*        *
*        *
*        *
*        *
*        *
*        *
**********
R

**********

BOARD_RIFGT_X
BOARD_LEFT_X
BOARD_TOP_Y
BOARD_BOTTOM_Y

X_BOARD <- StdIn
Y_BOARD <- StdIn

**********
*        *
*  ***   *
*        *
*        *
*        *
*        *
*        *
*        *
**********


Point[SNACK_MAX_LENGHT] snake = new Point[];

???
    int head_index;
    inex tail+index;

// x,  y
{2, 2}
{3, 2}
{4, 2}

{3, 2}
{4, 2}
{5, 2}

---
{2, 2}
    <-
    -> {3, 2}
        <-
        ->{4, 2}

REMOVE {2, 2}
    <-
    -> {3, 2}
        <-
        ->{4, 2}


Head meet wall?



enum Direction {
    LEFT,
    RIGHT,
    UP,
    DOWN
}



switch(Direction direction) {
    LEFT:
        break;

}

Score: 2

[n][m]

Cell
- wall
- empty
- snake
- food

- Starting conditions
    position
    direction

- StdsIn <- Direction of movement

    ->"
L - left
R - right
U - up
D - down



--


 */
public class hw {

    public static void main(String[] args) {
        System.out.println("Hello World!");

//        Scanner input = new Scanner( System.in );
//        int boardWidth = input.nextInt();
//        int boardHeigth = input.nextInt();
//
//        SnakeGame snakeGame = new SnakeGame(boardWidth, boardHeigth);

        SnakeGame snakeGame = new SnakeGame(10, 10);
//        SnakeGame snakeGame = new SnakeGame(5, 5);
//        SnakeGame snakeGame = new SnakeGame(7, 7);
        snakeGame.play();
    }

}
