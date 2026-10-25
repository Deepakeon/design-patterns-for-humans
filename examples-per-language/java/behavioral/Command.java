class Bulb{
    public void turnOn(){
        System.out.println("Bulb has been lit");
    }

    public void turnOff(){
        System.out.println("Darkness!");
    }
}

interface BulbCommand{
    void execute();
    void undo();
    void redo();
}

class TurnOn implements BulbCommand{
    protected Bulb bulb;

    TurnOn(Bulb bulb){
        this.bulb = bulb;
    }

    public void execute(){
        bulb.turnOn();
    }

    public void undo(){
        bulb.turnOff();
    }

    public void redo(){
        bulb.turnOn();
    }
}

class TurnOff implements BulbCommand{
    protected Bulb bulb;

    TurnOff(Bulb bulb){
        this.bulb = bulb;
    }

    public void execute(){
        bulb.turnOff();
    }

    public void undo(){
        bulb.turnOn();
    }

    public void redo(){
        bulb.turnOff();
    }
}

class RemoteControl{
    public void submit(BulbCommand command){
        command.execute();
    }
}

class Command {
    public static void main(String[] args) {
        Bulb bulb = new Bulb();
        BulbCommand turnOn = new TurnOn(bulb);
        BulbCommand turnOff = new TurnOff(bulb);

        RemoteControl remote = new RemoteControl();

        remote.submit(turnOn);
        remote.submit(turnOff);
    }
}