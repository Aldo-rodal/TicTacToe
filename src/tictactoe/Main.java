package tictactoe;
    import java.util.*;
public class Main {
    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        final int sizeGrid = 3;

        char[][] gamePlay = new char[sizeGrid][sizeGrid];


        for (int i = 0; i < sizeGrid; i++) {
            for (int j = 0; j < sizeGrid; j++) {
                gamePlay[i][j] = ' ';
            }
        }

        System.out.println("---------");

        for (int i = 0; i < sizeGrid; i++) {
            System.out.print("| ");
            for (int j = 0; j < sizeGrid; j++) {
                System.out.print(gamePlay[i][j] + " ");
            }
            System.out.print("|\n");
        }
        System.out.println("---------");


        for (;;) {
            char hor;
            char ver;
            int a;
            int b;
            for (; ; ) {
                System.out.print("Enter coordinates: ");

                hor = scanner.next().charAt(0);
                ver = scanner.next().charAt(0);

                a = Character.getNumericValue(hor) - 1;
                b = Character.getNumericValue(ver) - 1;

                if (hor < 48 || hor > 57) {
                    System.out.println("You should enter numbers!");
                } else if (hor < 49 || hor > 51) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (ver < 48 || ver > 57) {
                    System.out.println("You should enter numbers!");
                } else if (ver < 49 || ver > 51) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (gamePlay[a][b] == 'X' || gamePlay[a][b] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            }

            gamePlay[a][b] = 'X';

            System.out.println("---------");

            for (int i = 0; i < sizeGrid; i++) {
                System.out.print("| ");
                for (int j = 0; j < sizeGrid; j++) {
                    System.out.print(gamePlay[i][j] + " ");
                }
                System.out.print("|\n");
            }
            System.out.println("---------");

            int countXHor;
            int countXVer;
            int countYHor;
            int countYVer;
            int countXWins = 0;
            int countYWins = 0;
            int countSpaces = 0;

            for (int i = 0; i < sizeGrid; i++) {
                countXHor = 0;
                countYHor = 0;
                countXVer = 0;
                countYVer = 0;
                for (int j = 0; j < sizeGrid; j++) {
                    if (gamePlay[i][j] == 'X') {
                        countXHor++;
                    } else if (gamePlay[i][j] == 'O') {
                        countYHor++;
                    } else if (gamePlay[i][j] == ' ' || gamePlay[i][j] == '_') {
                        countSpaces++;
                    }
                    if (gamePlay[j][i] == 'X') {
                        countXVer++;
                    } else if (gamePlay[j][i] == 'O') {
                        countYVer++;
                    }
                }
                if (countXHor == sizeGrid || countXVer == sizeGrid) {
                    countXWins++;
                } else if (countYHor == sizeGrid || countYVer == sizeGrid) {
                    countYWins++;
                }
            }

            int countXDiag1 = 0;
            int countXDiag2 = 0;
            int countYDiag1 = 0;
            int countYDiag2 = 0;

            for (int i = 0; i < sizeGrid; i++) {
                for (int j = 0; j < sizeGrid; j++) {
                    if (gamePlay[i][j] == 'X' && i == j) {
                        countXDiag1++;
                    }
                    if (gamePlay[i][sizeGrid - j - 1] == 'X' && i == j) {
                        countXDiag2++;
                    }
                    if (gamePlay[i][j] == 'O' && i == j) {
                        countYDiag1++;
                    }
                    if (gamePlay[i][sizeGrid - j - 1] == 'O' && i == j) {
                        countYDiag2++;
                    }
                }
            }

            if (countXDiag1 == sizeGrid || countXDiag2 == sizeGrid) {
                countXWins++;
            } else if (countYDiag1 == sizeGrid || countYDiag2 == sizeGrid) {
                countYWins++;
            }

            if (countXWins == 1 && countYWins == 0) {
                System.out.print("X wins");
                break;
            } else if (countYWins == 1 && countXWins == 0) {
                System.out.print("O wins");
                break;
            } else if (countXWins == 0 && countYWins == 0 && countSpaces == 0) {
                System.out.print("Draw");
                break;
            }

            char horO;
            char verO;
            int aO;
            int bO;
            for (; ; ) {
                System.out.print("Enter coordinates: ");

                horO = scanner.next().charAt(0);
                verO = scanner.next().charAt(0);

                aO = Character.getNumericValue(horO) - 1;
                bO = Character.getNumericValue(verO) - 1;

                if (horO < 48 || horO > 57) {
                    System.out.println("You should enter numbers!");
                } else if (horO < 49 || horO > 51) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (verO < 48 || verO > 57) {
                    System.out.println("You should enter numbers!");
                } else if (verO < 49 || verO > 51) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (gamePlay[aO][bO] == 'X' || gamePlay[aO][bO] == 'O') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    break;
                }
            }

            gamePlay[aO][bO] = 'O';

            System.out.println("---------");

            for (int i = 0; i < sizeGrid; i++) {
                System.out.print("| ");
                for (int j = 0; j < sizeGrid; j++) {
                    System.out.print(gamePlay[i][j] + " ");
                }
                System.out.print("|\n");
            }
            System.out.println("---------");

            countXWins = 0;
            countYWins = 0;
            countSpaces = 0;

            for (int i = 0; i < sizeGrid; i++) {
                countXHor = 0;
                countYHor = 0;
                countXVer = 0;
                countYVer = 0;
                for (int j = 0; j < sizeGrid; j++) {
                    if (gamePlay[i][j] == 'X') {
                        countXHor++;
                    } else if (gamePlay[i][j] == 'O') {
                        countYHor++;
                    } else if (gamePlay[i][j] == ' ' || gamePlay[i][j] == '_') {
                        countSpaces++;
                    }
                    if (gamePlay[j][i] == 'X') {
                        countXVer++;
                    } else if (gamePlay[j][i] == 'O') {
                        countYVer++;
                    }
                }
                if (countXHor == sizeGrid || countXVer == sizeGrid) {
                    countXWins++;
                } else if (countYHor == sizeGrid || countYVer == sizeGrid) {
                    countYWins++;
                }
            }

            countXDiag1 = 0;
            countXDiag2 = 0;
            countYDiag1 = 0;
            countYDiag2 = 0;

            for (int i = 0; i < sizeGrid; i++) {
                for (int j = 0; j < sizeGrid; j++) {
                    if (gamePlay[i][j] == 'X' && i == j) {
                        countXDiag1++;
                    }
                    if (gamePlay[i][sizeGrid - j - 1] == 'X' && i == j) {
                        countXDiag2++;
                    }
                    if (gamePlay[i][j] == 'O' && i == j) {
                        countYDiag1++;
                    }
                    if (gamePlay[i][sizeGrid - j - 1] == 'O' && i == j) {
                        countYDiag2++;
                    }
                }
            }

            if (countXDiag1 == sizeGrid || countXDiag2 == sizeGrid) {
                countXWins++;
            } else if (countYDiag1 == sizeGrid || countYDiag2 == sizeGrid) {
                countYWins++;
            }

            if (countXWins == 1 && countYWins == 0) {
                System.out.print("X wins");
                break;
            } else if (countYWins == 1 && countXWins == 0) {
                System.out.print("O wins");
                break;
            } else if (countXWins == 0 && countYWins == 0 && countSpaces == 0) {
                System.out.print("Draw");
                break;
            }
        }
    }
}
