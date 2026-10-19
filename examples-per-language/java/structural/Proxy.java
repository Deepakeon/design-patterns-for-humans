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
    String password;

    SecuredDoor(Door door, String password){
        this.door = door;
        this.password = password;
    }

    public boolean authenticate(){
        return password.equals("$ecr@t");
    }

    public void open(){
        if(this.authenticate()){
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
        Door door = new SecuredDoor(new LabDoor(), "invalid");
        door.open();

        door = new SecuredDoor(new LabDoor(), "$ecr@t");
        door.open();
        door.close();
    }
}