package designpatterns;

abstract class BasePizza {
    public abstract int cost();
}

class Farmhouse extends BasePizza {
    @Override
    public int cost(){
        return 200;
    }
}

class VegDelight extends BasePizza {
    @Override
    public int cost(){
        return 100;
    }
}

abstract class ToppingDecorator extends BasePizza {
}

class ExtraCheese extends ToppingDecorator {
    BasePizza basePizza;

    public ExtraCheese(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return basePizza.cost() + 15;
    }
}

class Mushroom extends ToppingDecorator {
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return basePizza.cost() + 25;
    }
}

public class Decorator {
    public static void main(String[] args) {
        BasePizza myPizza = new Mushroom(new ExtraCheese(new VegDelight()));
        System.out.println(myPizza.cost());
    }
}