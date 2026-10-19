interface Door {
    void open();
    void close();
}

class LabDoor implements Door{
    public void open(){
        System.out.println("Opening lab door");
    }

    public void close(){
        System.out.println("Closing the lab door");
    }
}

class SecuredDoor implements Door{
    protected Door door;

    SecuredDoor(Door door){
        this.door = door;
    }

    public boolean authenticate(String password){
        return password.equals("$ecr@t");
    }

    public void open(){
        this.open(null);
    }

    public void open(String password){
        if(this.authenticate(password)){
            this.door.open();
        }else{
            System.out.println("Big no! It ain't possible.");
        }
    }

    public void close(){
        this.door.close();
    }
}

class Proxy {
    public static void main(String[] args) {
        SecuredDoor door = new SecuredDoor(new LabDoor());
        door.open("invalid");

        door.open("$ecr@t");
        door.close();
    }
}