import java.util.Random;
import java.util.Scanner;

public class CrossMyVersion {
    static final int SIZE_Y = 3;
    static final int SIZE_X = 3;

    static char field[][] = new char[SIZE_Y][SIZE_X];

    static final char PLAYER_DOT = 'X';
    static final char AI_DOT = 'O';
    static final char EMPTY_DOT = '.';

    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();

    private static void fillFieldEmpty() {
        for (int i = 0; i < SIZE_Y ; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private static void printField() {
        System.out.println("-------");
        for (int i = 0; i < SIZE_Y ; i++) {
            System.out.print("|");
            for (int j = 0; j < SIZE_X ; j++) {
                System.out.print(  field[i][j] + "|" );
            }
            System.out.println();
        }
        System.out.println("-------");
    }

    private static void playerStep() {
        int x;
        int y;
        do {
            System.out.println("ВВедите координаты Y-X от 1-3 :");
            y = scanner.nextInt() - 1;
            x = scanner.nextInt() - 1;
        } while (!checkStep(y,x));
        setSym(y,x, PLAYER_DOT);
    }

    private static void compStep() {
        int x;
        int y;
        do {
            y = rand.nextInt(SIZE_Y);
            x = rand.nextInt(SIZE_X);
        } while (!checkStep(y,x));
        setSym(y,x, AI_DOT);
    }

   private static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
   }

   
    private static boolean checkStep(int y, int x) {
        if (y < 0 || x < 0 || y > SIZE_Y - 1 || x > SIZE_X - 1) {
            return false;
        }
        return field[y][x] == EMPTY_DOT;
    }

    private static boolean isFieldFull() {
        for (int i = 0; i < SIZE_Y ; i++) {
            for (int j = 0; j < SIZE_X ; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean checkWin(char sym) {
        if (field[0][0] == sym && field[0][1] == sym && field[0][2] == sym) {
            return true;
        }
        if (field[1][0] == sym && field[1][1] == sym && field[1][2] == sym) {
            return true;
        }
        if (field[2][0] == sym && field[2][1] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[0][0] == sym && field[1][0] == sym && field[2][0] == sym) {
            return true;
        }
        if (field[0][1] == sym && field[1][1] == sym && field[2][1] == sym) {
            return true;
        }
        if (field[0][2] == sym && field[1][2] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[0][0] == sym && field[1][1] == sym && field[2][2] == sym) {
            return true;
        }
        if (field[0][2] == sym && field[1][1] == sym && field[2][0] == sym) {
            return true;
        }
        return false;
    }

        public static void main (String[]args){
            fillFieldEmpty();
            printField();
            while (true) {
                playerStep();
                printField();
                if (checkWin(PLAYER_DOT)) {
                    System.out.println("Player Win!");
                    break;
                }
                if (isFieldFull()) {
                    System.out.println("DRAW");
                    break;
                }
                compStep();
                printField();
                if (checkWin(AI_DOT)) {
                    System.out.println("Comp Win!");
                    break;
                }
                if (isFieldFull()) {
                    System.out.println("DRAW");
                    break;
                }
            }
        }
    }
