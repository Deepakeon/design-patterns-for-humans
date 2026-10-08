interface Door{
    float getWidth();
    float getHeight();
}

class WoodenDoor implements Door{
    protected float width;
    protected float height;

    WoodenDoor(float width, float height){
        this.width = width;
        this.height = height;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }
}

class DoorFactory {
    
    public static Door makeDoor(float width, float height){
        return new WoodenDoor(width, height);
    }
}

class SimpleFactory {
    public static void main(String[] args){
        Door door = DoorFactory.makeDoor(100, 200);

        System.out.println("Witdh: " + door.getWidth() + " Height: " + door.getHeight());

        Door door2 = DoorFactory.makeDoor(50, 100);
    }
}
