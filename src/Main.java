import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] gameBord = {{' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '},
                             {'-','+','-','+','-'},
                             {' ','|',' ','|',' '}};

        List<Integer> player1List = new ArrayList<>();
        List<Integer> player2List = new ArrayList<>();

        printGameBord(gameBord);

        Scanner cin = new Scanner(System.in);

        int pos;
        int playerNum;
        boolean criteria = true;

        while (criteria){
            System.out.println("Player 1: ");
            pos = cin.nextInt();
            playerNum = 0;
            while (player1List.contains(pos) || player2List.contains(pos)){
                System.out.println("Aceasta caseta este deja ocupata: ");
                pos = cin.nextInt();
            }
            player1List.add(pos);
            changeMatrix(pos,gameBord,playerNum);
            printGameBord(gameBord);
            if (check(gameBord)){
                System.out.println("Avem un castigator !");
                break;
            }
            else if(checkTie(gameBord)){
                System.out.println("Nu avem nici-un castigator, egalitate.");
                break;
            }


            System.out.println("Player 2: ");
            pos = cin.nextInt();
            playerNum = 1;
            while (player1List.contains(pos) || player2List.contains(pos)){
                System.out.println("Aceasta caseta este deja ocupata: ");
                pos = cin.nextInt();
            }
            player2List.add(pos);
            changeMatrix(pos, gameBord, playerNum);
            printGameBord(gameBord);
            if (check(gameBord)){
                System.out.println("Avem un castigator !");
                break;
            }
            else if(checkTie(gameBord)){
                System.out.println("Nu avem nici-un castigator, egalitate.");
                break;
            }
        }


        cin.close();
    }

    public static void printGameBord(char[][] gameBord){
        for (char[] row:gameBord) {
            for (char c: row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void changeMatrix(int pos, char[][] gameBord, int playerNum){
        //ROW 1
        if(pos <= 3){
            if(pos == 1){
                if(playerNum == 0)
                    gameBord[0][0] = '0';
                else
                    gameBord[0][0] = 'X';
            }
            else if(pos == 2){
                if(playerNum == 0)
                    gameBord[0][2] = '0';
                else
                    gameBord[0][2] = 'X';
            }
            else{
                if(playerNum == 0)
                    gameBord[0][4] = '0';
                else
                    gameBord[0][4] = 'X';
            }
        }

        //ROW 2
        if(pos > 3 && pos <= 6){
            if(pos == 4){
                if(playerNum == 0)
                    gameBord[2][0] = '0';
                else
                    gameBord[2][0] = 'X';
            }
            else if(pos == 5){
                if(playerNum == 0)
                    gameBord[2][2] = '0';
                else
                    gameBord[2][2] = 'X';
            }
            else {
                if(playerNum == 0)
                    gameBord[2][4] = '0';
                else
                    gameBord[2][4] = 'X';
            }
        }

        //ROW 3
        if(pos > 6 && pos <= 9){
            if(pos == 7){
                if(playerNum == 0)
                    gameBord[4][0] = '0';
                else
                    gameBord[4][0] = 'X';
            }
            else if(pos == 8){
                if(playerNum == 0)
                    gameBord[4][2] = '0';
                else
                    gameBord[4][2] = 'X';
            }
            else {
                if(playerNum == 0)
                    gameBord[4][4] = '0';
                else
                    gameBord[4][4] = 'X';
            }
        }

    }

    public static boolean check(char[][] gameBord){
        boolean criteria1 = false;
        boolean criteria2 = false;
        //boolean criteria3 = false;
        boolean criteria4 = false;
        boolean criteria5 = false;

        if (gameBord[0][0] == gameBord[2][2] && gameBord[0][0] == gameBord[4][4] && gameBord[0][0] != ' ')
                criteria1 = true;

        if (gameBord[0][4] == gameBord[2][2] && gameBord[0][4] == gameBord[4][0] && gameBord[0][0] != ' ')
            if (gameBord[0][4] != ' ')
                criteria2 = true;

        StringBuilder s;

        for (int i = 0; i < 5; i=i+2) {
            s = new StringBuilder();
            for (int j = 0; j < 5; j=j+2) {
                s.append(gameBord[i][j]);
            }
            if(charactersCheck(s.toString())){
                criteria4 = true;
                break;
            }
        }

        for (int i = 0; i < 5; i=i+2) {
            s = new StringBuilder();
            for (int j = 0; j < 5; j=j+2) {
                s.append(gameBord[j][i]);
            }
            if(charactersCheck(s.toString())){
                criteria5 = true;
                break;
            }
        }

        return criteria1 || criteria2 || criteria4 || criteria5;
    }

    public static boolean charactersCheck(String s){
        char[] ch = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ch[i] = s.charAt(i);
        }

        return ch[0] == ch[1] && ch[0] == ch[2] && ch[0] != ' ';
    }

    public static boolean checkTie(char[][] gameBord){
        for (int i = 0; i<5; i++)
            for (int j = 0; j<5; j++)
                if (gameBord[i][j] == ' ')
                    return false;
        return true;
    }

}