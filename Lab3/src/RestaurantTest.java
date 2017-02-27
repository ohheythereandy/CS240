/**
 * Created by Andy on 2/27/17.
 */


public class RestaurantTest {



    public static void main(String[] args) {

        TimeDate timeKeeping = new TimeDate();
        Inventory inventory = new Inventory();
        Customer customers = new Customer();
        int daysBetweenShipments=0;

        while(!timeKeeping.isEndOfMarch()){
            while(!timeKeeping.isOpen()){
                if(timeKeeping.isRestockTime() && daysBetweenShipments == 3){
                    inventory.getShipment();
                    daysBetweenShipments=0;
                }
                customers.addCustomers();
                while(!customers.lineIsEmpty()){


                }
                timeKeeping.nextHour();

            }
            //Sort and remove expired inventory

            timeKeeping.nextDay();
            daysBetweenShipments++;

        }
    } // end main

}//end restaraunt test