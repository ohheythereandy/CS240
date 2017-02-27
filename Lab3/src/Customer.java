/**
 * Created by Andy on 2/27/17.
 */
import java.util.Random;
public class Customer {


    private int randomOrder;
    private CustomerQueue<Integer> customerLine;
    private Random random;

    public Customer(){
        randomOrder = 0;
        random = new Random();
        customerLine = new CustomerQueue<>();
    }

    public int getCustomerOrder(){
        return random.nextInt(5) +1 ;
    }

    public void addCustomers() {
        int arrivingCustomers = random.nextInt(100) + 1;

        try{
            for(int i = 0; i < arrivingCustomers; i++){
                if(customerLine.isFull()){
                    break;
                }
                customerLine.enqueue(getCustomerOrder());
            }
        }
        catch(IllegalStateException e){
            System.out.println("Customers are leaving because the line is full..");
        }
        

    }

    public boolean lineIsEmpty(){
        return customerLine.isEmpty();
    }
}
