import java.util.Stack;

/**
 * Created by Andy on 2/27/17.
 * System to keep track of all food, in addition to orders placed
 * and items and customers lost
 */

import java.util.Random;
public class Inventory {

    Random random ;
    StackInterface<Integer> bunStack ;
    StackInterface<Integer> pattyStack ;
    StackInterface<Integer> lettuceStack ;
    StackInterface<Integer> tomatoStack ;
    StackInterface<Integer> onionStack ;
    StackInterface<Integer> cheeseStack ;
    private int wasteBun, wastePatty, wasteLettuce, wasteTomato, wasteOnion, wasteCheese;
    private int countItemOne , countItemTwo, countItemThree,
                countItemFour, countItemFive, countItemSix;
    private int lostCustomerDay;

    public Inventory(){

        random = new Random();
        bunStack = new FoodStack<>();
        pattyStack = new FoodStack<>();
        lettuceStack = new FoodStack<>();
        tomatoStack = new FoodStack<>();
        onionStack = new FoodStack<>();
        cheeseStack = new FoodStack<>();

    }

    public void getShipment(){

        for(int i = 0; i<6 ; i++){
            int itemChance = random.nextInt(300) + 1;
            int totalItem = 700 + itemChance;

            for(int  j =0; j< totalItem ; j++){
                switch(i){
                    case 0:
                        bunStack.push(5);
                        break;
                    case 1:
                        pattyStack.push(4);
                        break;
                    case 2:
                        lettuceStack.push(3);
                        break;
                    case 3:
                        tomatoStack.push(3);
                        break;
                    case 4:
                        onionStack.push(5);
                        break;
                    case 5:
                        cheeseStack.push(2);
                        break;
                }

            }
        }
    } // end getShipment



}
