import java.util.Scanner;

public class OneRoundOneRollYahtzee
{
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.print("Please enter 1) to roll your own dice, 2) to let the computer roll the dice, or 3) to quit: ");
        int choice = input.nextInt();

        if(choice == 1)
        {
            decision1();
            //categories();
        }
        else if(choice == 2)
        {
            decision2();
            //categories();
        }
        else
        {
            System.out.println("Have a nice day!");
        }
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

    private static void decision2()
    {

        int number = 5;
        int[] random = new int[number];
        int count = 1;
        String increasing = "";

        for(int i = 0; i < number; i++)
        {
            random[i] = (int)(6.0 * Math.random() + 1.0);
        }
        for(int i = 0; i < number; i++){
            for(int j = i + 1; j < number; j++){
                if(random[i] > random[j]){
                    int temp = random[i];
                    random[i] = random[j];
                    random[j] = temp;}
            }
        }
        for (int i = 0; i < number; i++)
        {
            increasing += (random[i] + " ");
        }
        System.out.print("The 5 rolls in non-decreasing order are: " + increasing);
    }

    public static void categories()
    {
        String[] selection = {"Not Valid", "1. Aces", "2. Twos", "3. Threes", "4. Fours", "5. Fives", "6. Sixes", "7. Three of a kind", "8. Four of a kind", "9. Full House", "10. Small straight", "11. Large Straight", "12. Yahtzee", "13. Chance"};
        //String[] Lower = {"7. Three of a kind", "8. Four of a kind", "9. Full House", "10. Small straight", "11. Large Straight", "12. Yahtzee", "13. Chance"};
        System.out.println("\nYou may choose to score from the following categories");
        System.out.println("Upper selection");
        for(int i = 1; i <= 6; i++){
            //Upper[i+1] = Upper[0];
            System.out.println(selection[i]);
        }
        System.out.println();
        System.out.println("Lower Selection");
        for(int i = 7; i <= 13; i++){
            System.out.println(selection[i]);}
    }

}
