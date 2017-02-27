/**
 * Created by Andy on 2/27/17.
 */
public class Menu {

    Meal burger = new Meal();
    Meal cheeseBurger = new Meal();
    Meal veganBurger = new Meal();
    Meal noOnionBurger = new Meal();
    Meal noOnionCheeseBurger = new Meal();
    Meal noTomatoBurger = new Meal();

    public Menu(){
        MenuList menuList = new MenuList(6);
        menuList.add(burger);
        menuList.add(cheeseBurger);
        menuList.add(veganBurger);
        menuList.add(noOnionBurger);
        menuList.add(noOnionCheeseBurger);
        menuList.add(noTomatoBurger);

    }

}