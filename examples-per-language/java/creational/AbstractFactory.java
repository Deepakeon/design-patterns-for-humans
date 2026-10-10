interface Door {
    void getDescription();
}

class WoodenDoor implements Door{
    public void getDescription(){
        System.out.println("I am a wooden door");
    }
}

class IronDoor implements Door{
    public void getDescription(){
        System.out.println("I am an iron door");
    }
}

interface DoorFittingExpert {
    void getDescription();
}

class Welder implements DoorFittingExpert{
    public void getDescription(){
        System.out.println("I can only fit iron doors");
    }
}

class Carpenter implements DoorFittingExpert{
    public void getDescription(){
        System.out.println("I can only fit wooden doors");
    }
}

interface DoorFactory{
    Door makeDoor();
    DoorFittingExpert makeFittingExpert();
}

class WoodenDoorFactory implements DoorFactory{
    public Door makeDoor(){
        return new WoodenDoor();
    }
    
    public DoorFittingExpert makeFittingExpert(){
        return new Carpenter();
    }
}

class IronDoorFactory implements DoorFactory{
    public Door makeDoor(){
        return new IronDoor();
    }
    
    public DoorFittingExpert makeFittingExpert(){
        return new Welder();
    }
}

class AbstractFactory {
    public static void main(String[] args){
        DoorFactory woodenFactory = new WoodenDoorFactory();
        Door door = woodenFactory.makeDoor();
        DoorFittingExpert expert = woodenFactory.makeFittingExpert();

        door.getDescription();
        expert.getDescription();

        DoorFactory ironFactory = new IronDoorFactory();
        door = ironFactory.makeDoor();
        expert = ironFactory.makeFittingExpert();

        door.getDescription();
        expert.getDescription();
    }
}