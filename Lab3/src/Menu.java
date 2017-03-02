/**
 * Created by Andy on 2/27/17.
 */
public class Menu extends Food {

    ListInterface<Food> burger ;
    ListInterface<Food> cheeseBurger;
    ListInterface<Food> veggieBurger;
    ListInterface<Food> noOnionBurger;
    ListInterface<Food> noOnionCheese;
    ListInterface<Food> noTomatoBurger;
    Food bun = new Food(5);
    Food patty = new Food(4);
    Food lettuce = new Food(3);
    Food tomato = new Food(3);
    Food onion = new Food (5);
    Food cheese = new Food(2);

    public Menu(){
        burger = new MenuList<>();
        buildBurger();
        cheeseBurger = new MenuList<>();
        buildCheeseBurger();
        veggieBurger = new MenuList<>();
        buildVeggieBurger();
        noOnionBurger = new MenuList<>();
        buildNoOnion();
        noOnionCheese = new MenuList<>();
        buildNoOnionCheese();
        noTomatoBurger = new MenuList<>();
        buildNoTomatoBurger();
    }


    public void buildBurger(){
        burger.add(bun);
        burger.add(patty);
        burger.add(lettuce);
        burger.add(tomato);
        burger.add(onion);
    }

    public void buildCheeseBurger(){
        cheeseBurger.add(cheese);
        cheeseBurger.add(bun);
        cheeseBurger.add(lettuce);
        cheeseBurger.add(tomato);
        cheeseBurger.add(patty);
        cheeseBurger.add(onion);
    }

    public void buildVeggieBurger(){
        veggieBurger.add(lettuce);
        veggieBurger.add(lettuce);
        veggieBurger.add(tomato);
        veggieBurger.add(onion);
    }

    public void buildNoOnion(){
        noOnionBurger.add(patty);
        noOnionBurger.add(bun);
        noOnionBurger.add(tomato);
        noOnionBurger.add(lettuce);
    }
    public void buildNoOnionCheese(){
        noOnionCheese.add(bun);
        noOnionCheese.add(patty);
        noOnionCheese.add(lettuce);
        noOnionCheese.add(cheese);
        noOnionCheese.add(tomato);

    }
    public void buildNoTomatoBurger(){
        noTomatoBurger.add(bun);
        noTomatoBurger.add(patty);
        noTomatoBurger.add(lettuce);
        noTomatoBurger.add(onion);
    }
}
