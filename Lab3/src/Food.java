/**
 * Created by Andy on 2/27/17.
 */
public class Food {

    private int expirationCounter = 0;
    StackInterface<Integer> givenStack;


    public Food(int expirationDate){
        expirationCounter = expirationDate;
        givenStack = new FoodStack<>();
    }

    public Food(){

    }

    public int getExpirationDate (){
        return expirationCounter;
    }
}
