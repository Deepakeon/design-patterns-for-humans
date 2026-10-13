interface Coffee{
    int getCost();
    String getDescription();
}

class SimpleCoffee implements Coffee{
    public int getCost(){
        return 10;
    }

    public String getDescription(){
        return "Simple coffee";
    }
}

class MilkCoffee implements Coffee{
    protected Coffee coffee;

    MilkCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    public int getCost(){
        return this.coffee.getCost() + 2;
    }

    public String getDescription(){
        return this.coffee.getDescription() + ", milk";
    }
}

class WhipCoffee implements Coffee{
    protected Coffee coffee;

    WhipCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    public int getCost(){
        return this.coffee.getCost() + 5;
    }

    public String getDescription(){
        return this.coffee.getDescription() + ", whip";
    }
}

class VanillaCoffee implements Coffee{
    protected Coffee coffee;

    VanillaCoffee(Coffee coffee){
        this.coffee = coffee;
    }

    public int getCost(){
        return this.coffee.getCost() + 3;
    }

    public String getDescription(){
        return this.coffee.getDescription() + ", vanilla";
    }
}

class Decorator {
    public static void main(String[] args) {
        Coffee someCoffee = new SimpleCoffee();
        System.out.println(someCoffee.getCost());
        System.out.println(someCoffee.getDescription());

        someCoffee = new MilkCoffee(someCoffee);
        System.out.println(someCoffee.getCost());
        System.out.println(someCoffee.getDescription());

        someCoffee = new WhipCoffee(someCoffee);
        System.out.println(someCoffee.getCost());
        System.out.println(someCoffee.getDescription());

        someCoffee = new VanillaCoffee(someCoffee);
        System.out.println(someCoffee.getCost());
        System.out.println(someCoffee.getDescription());
    }
}