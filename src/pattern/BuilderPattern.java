package pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oalizada on 12/7/2016.
 */
public class BuilderPattern {
}
interface Packing{
    String pack();
}

class Wrapper implements Packing{

    public String pack(){
        return "Wrapper";
    }
}

class Bottle implements Packing{
    public String pack(){
        return "Bottle";
    }
}


interface  Item{
    public String name();
    public Packing packing();
    public float price();
}

abstract class Burger implements Item{
    public Packing packing(){
        return new Wrapper();
    }
    public abstract float price();
}

abstract class  ColdDrink implements Item{
    public Packing packing(){
        return new Bottle();
    }
    public abstract float price();
}

 class VegBurger extends Burger{
    @Override
    public float price(){
        return 0.5f;
    }
    public String name(){
        return "VegBurger";
    }
}
 class ChickenBurger extends Burger {
    @Override
    public float price() {
        return 50.5f;
    }
    @Override
    public String name() {
        return "Chicken Burger";
    }
}

 class Coke extends ColdDrink {
    @Override
    public float price() {
        return 30.0f;
    }
    @Override
    public String name() {
        return "Coke";
    }
}

class Pepsi extends ColdDrink {
    @Override
    public float price() {
        return 35.0f;
    }
    @Override
    public String name() {
        return "Pepsi";
    }
}
class Meal{
    private List<Item> items=new ArrayList<Item>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getCost(){
        float cost=0.0f;
        for(Item item:items){
            cost+=item.price();

        }
        return cost;
    }
    public void showItems(){
        for (Item item : items) {
            System.out.println(item.name());
            System.out.println(item.packing().pack());
            System.out.println(item.price());
        }
    }
}
class MealBuilder {
    public Meal prepareVegBuilder() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public void prepareChicken() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());

    }
}

class BuilderPatternDemo{
        public static  void main(String[] args) {
            MealBuilder mealBuilder=new MealBuilder();
            Meal vegMeal=mealBuilder.prepareVegBuilder();
            vegMeal.showItems();
        }
    }
