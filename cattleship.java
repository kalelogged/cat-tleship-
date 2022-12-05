import java.util.*;

public class cattleship {
    public static int rows = 10;
    public static int cols = 10;
    public static int playerCats;
    public static int computerCats;
    public static String[][] grid = new String[rows][cols];
    public static int[][] missedGuesses = new int[rows][cols];

    public static void main(String[] args){
        createOceanMap();
        deployPlayerCats();
        deployComputerCats();

        do {
            Cattle();
        }while(cattleship.playerCats != 0 && cattleship.computerCats != 0);

        gameOver();
    }

    public static void createOceanMap(){
        System.out.print("  ");
        for(int i = 0; i < cols; i++)
                System.out.print(i);
        System.out.println();

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = " ";
                if (j == 0)
                    System.out.print(i + "|" + grid[i][j]);
                else if (j == grid[i].length - 1)
                    System.out.print(grid[i][j] + "|" + i);
                else
                    System.out.print(grid[i][j]);
            }
            System.out.println();
        }

        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();
    }

    public static void deployPlayerCats(){
        Scanner input = new Scanner(System.in);

        System.out.println("\nposition your cats:");
        
        cattleship.playerCats = 5;
        for (int i = 1; i <= cattleship.playerCats; ) {
            System.out.print("enter the X coordinate for your " + i + " cat: ");
            int x = input.nextInt();
            System.out.print("enter the Y coordinate for your " + i + " cat: ");
            int y = input.nextInt();

            if((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "@";
                i++;
            }
            else if((x >= 0 && x < rows) && (y >= 0 && y < cols) && grid[x][y] == "@")
                System.out.println("you can't place two or more cats on the same location");
            else if((x < 0 || x >= rows) || (y < 0 || y >= cols))
                System.out.println("you can't place cats outside the " + rows + " by " + cols + " grid");
        }
        printOceanMap();
    }

    public static void deployComputerCats(){
        System.out.println("\ncomputer is positioning cats");
        
        cattleship.computerCats = 5;
        for (int i = 1; i <= cattleship.computerCats; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);

            if((x >= 0 && x < rows) && (y >= 0 && y < cols) && (grid[x][y] == " "))
            {
                grid[x][y] =   "x";
                System.out.println(i + ". cat DEPLOYED");
                i++;
            }
        }
        printOceanMap();
    }

    public static void Cattle(){
        playerTurn();
        computerTurn();

        printOceanMap();

        System.out.println();
        System.out.println("your cats: " + cattleship.playerCats + " | computer cats: " + cattleship.computerCats);
        System.out.println();
    }

    public static void playerTurn(){
        System.out.println("\nYOUR TURN");
        int x = -1, y = -1;
        do {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter X coordinate: ");
            x = input.nextInt();
            System.out.print("Enter Y coordinate: ");
            y = input.nextInt();

            if ((x >= 0 && x < rows) && (y >= 0 && y < cols))
            {
                if (grid[x][y] == "x")
                {
                    System.out.println("you fed da cat");
                    grid[x][y] = "!";
                    --cattleship.computerCats;
                }
                else if (grid[x][y] == "@") {
                    System.out.println("RIP BOZO");
                    grid[x][y] = "x";
                    --cattleship.playerCats;
                    ++cattleship.computerCats;
                }
                else if (grid[x][y] == " ") {
                    System.out.println("L + you missed");
                    grid[x][y] = "-";
                }
            }
            else if ((x < 0 || x >= rows) || (y < 0 || y >= cols))
                System.out.println("you can't place cats outside the " + rows + " by " + cols + " grid");
        }while((x < 0 || x >= rows) || (y < 0 || y >= cols));
    }

    public static void computerTurn(){
        System.out.println("\nCOMPUTER'S TURN");
        
        int x = -1, y = -1;
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);

            if ((x >= 0 && x < rows) && (y >= 0 && y < cols))
            {
                if (grid[x][y] == "@")
                {
                    System.out.println("the computer fed your cat");
                    grid[x][y] = "x";
                    --cattleship.playerCats;
                    ++cattleship.computerCats;
                }
                else if (grid[x][y] == "x") {
                    System.out.println("the computer is A BOZO");
                    grid[x][y] = "!";
                }
                else if (grid[x][y] == " ") {
                    System.out.println("L + computer missed");
                    if(missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1;
                }
            }
        }while((x < 0 || x >= rows) || (y < 0 || y >= cols));
    }

    public static void gameOver(){
        System.out.println("your cats: " + cattleship.playerCats + " | computer cats: " + cattleship.computerCats);
        if(cattleship.playerCats > 0 && cattleship.computerCats <= 0)
            System.out.println("you won the CAT tle =^._.^= ∫");
        else
            System.out.println("you lost the CAT tle BOZO (ﾐΦ ﻌ Φﾐ)∫");
        System.out.println();
   }

    public static void printOceanMap(){
        System.out.println();
      
        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();

        for(int x = 0; x < grid.length; x++) {
            System.out.print(x + "|");

            for (int y = 0; y < grid[x].length; y++){
                System.out.print(grid[x][y]);
            }

            System.out.println("|" + x);
        }

        System.out.print("  ");
        for(int i = 0; i < cols; i++)
            System.out.print(i);
        System.out.println();
    }
}
