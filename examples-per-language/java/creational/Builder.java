class Burger{
    protected int size;
    
    protected boolean cheese = false;
    protected boolean pepperoni = false;
    protected boolean lettuce = false;
    protected boolean tomato = false;

    Burger(BurgerBuilder builder){
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
    }
}

class BurgerBuilder{
    public int size;

    public boolean cheese = false;
    public boolean pepperoni = false;
    public boolean lettuce = false;
    public boolean tomato = false;

    BurgerBuilder(int size){
        this.size = size;
    }

    public BurgerBuilder addPepperoni(){
        this.pepperoni = true;
        return this;
    }

    public BurgerBuilder addLettuce(){
        this.lettuce = true;
        return this;
    }

    public BurgerBuilder addCheese(){
        this.cheese = true;
        return this;
    }

    public BurgerBuilder addTomato(){
        this.tomato = true;
        return this;
    }

    public Burger build(){
        return new Burger(this);
    }
}

public class Builder {
    public static void main(String[] args){
        Burger burger = new BurgerBuilder(10).addCheese().addLettuce().addPepperoni().addTomato().build();
        System.out.println(burger);
    }
}
