interface Lion{
    void roar();
}

class AfricanLion implements Lion{
    public void roar(){}
}

class AsianLion implements Lion{
    public void roar(){}
}

class Hunter {
    public void hunt(Lion lion){
        lion.roar();
    }
}

class WildDog{
    public void bark(){}
}

class WildDogAdapter implements Lion{
    protected WildDog dog;

    WildDogAdapter(WildDog dog){
        this.dog = dog;
    }

    public void roar(){
        dog.bark();
    }
}

class Adapter {
    public static void main(String[] args) {
        WildDog dog = new WildDog();
        WildDogAdapter wildDogAdapter = new WildDogAdapter(dog);

        Hunter hunter = new Hunter();
        hunter.hunt(wildDogAdapter);
    }
}