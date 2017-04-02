
/**
 * Write a description of class OneRoundOneRollYahtzee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class OneRoundOneRollYahtzee
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
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
    public static void decision1()
    {
        Scanner input = new Scanner(System.in);
       //int[] list;
       
       System.out.print("Please enter the five dice rolls (seperated by spaces): ");
       String myList = input.nextLine();
       char[] list = new char[myList.length()];
       
       String order = "";
       for (int i = 0; i < list.length; i++) {
            list[i] = myList.charAt(i);
            
        }
       char temp = '0';
       for (int i = 0; i < list.length; i++){
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                    
                }
            }
        }
       System.out.print("Here are the digits in non-inceasing order: ");
       for (int i = 0; i < list.length; i++) 
       {
           if(list[i] != ' ')
            order += (list[i] + " ");
           //System.out.print(list[i] + ",");
       }

       System.out.print(order);
    }
    public static void decision2()
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
        Scanner input = new Scanner(System.in);
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