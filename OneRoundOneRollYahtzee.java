import java.util.Arrays;
import java.util.Scanner;

public class OneRoundOneRollYahtzee
{
    private static Scanner input = new Scanner(System.in);

    private static int rules;
    private static int[] rolls = new int[5];


    public static void main(String[] args)
    {
        getChoice();
    }

    private static void getChoice()
    {
        System.out.print("Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit: ");
        int choice = input.nextInt();

        switch(choice){
            case 1:
                decision1();
                break;
            //categories();
            case 2:
                for(int i = 0; i < 5; i++){
                    rolls[i] = decision2();
                }
                System.out.print("The 5 rolls in non-decreasing order are: " + Arrays.toString(rolls));
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please select 1 or 2");
                getChoice();
        }

        categories();
        getChoice();
    }

    private static void decision1()
    {
        System.out.print("Please enter the five dice rolls (separated by spaces): ");
        String myList = input.nextLine();
        char[] list = myList.trim().replaceAll(" ", "").toCharArray();

        for(char c : list){
            if(Character.getNumericValue(c) > 6 || Character.getNumericValue(c) < 1){
                System.out.println("You entered an invalid dice roll: " + c);
                System.out.println("Please try again.");
                decision1();
                return;
            }
        }

        if(myList.length() < 5){
            System.out.println("You did not enter 5 digits, please try again.");
            decision1();
            return;
        }

        String order = "";

        System.out.print("Here are the digits in non-increasing order: ");
        for (int i : list)
        {
            order = order.concat(String.valueOf(Character.getNumericValue(i))).concat(" ");
        }

        System.out.print(order);
    }

    private static int decision2()
    {
        return (int)(6.0 * Math.random() + 1.0);
    }

    public static void categories()
    {
        String[] upperSelection = {
                "Aces",
                "Twos",
                "Threes",
                "Fours",
                "Fives",
                "Sixes"
        };

        String[] lowerSelection = {
                "Three of a kind",
                "Four of a kind",
                "Full House",
                "Small straight",
                "Large Straight",
                "Yahtzee",
                "Chance"
        };

        String[] selection = concat(upperSelection, lowerSelection);
        System.out.println("\nYou may choose to score from the following categories");
        System.out.println("Upper selection");
        int i = 1;
        for(String s : upperSelection){
            System.out.println(i + ". " + s);
            i++;
        }
        System.out.println("Lower Selection");
        for(String s : lowerSelection) {
            System.out.println(i + ". " + s);
            i++;
        }

        System.out.println("Please enter the number corresponding to your chosen category:");
        rules = input.nextInt();
        System.out.println("Your score for the " + selection[rules - 1] + " category is: " + eval());
    }

    private static int eval(){
        switch(rules) {
            case 1:
                return 0;
            case 2:
                return 0;
            case 3:
                return 0;
            case 4:
                return 0;
            case 5:
                return 0;
            case 6:
                return 0;
            case 7:
                return 0;
            case 8:
                return 0;
            case 9:
                return 0;
            case 10:
                return 0;
            case 11:
                return 0;
            case 12:
                return 0;
            case 13:
                return 0;
            default:
                System.out.println("The Yahtzee category is not legal for this roll: " + Arrays.toString(rolls));
                return eval();
        }
    }

    private static String[] concat(String[] a, String[] b) {
        int aLen = a.length;
        int bLen = b.length;
        String[] c= new String[aLen+bLen];
        System.arraycopy(a, 0, c, 0, aLen);
        System.arraycopy(b, 0, c, aLen, bLen);
        return c;
    }

}
