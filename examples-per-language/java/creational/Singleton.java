class President{
    private static President instance;

    private President(){}

    public static President getInstance(){
        if(instance == null){
            instance = new President();
        }

        return instance;
    }
}
public class Singleton {
    public static void main(String[] args) {
        President president1 = President.getInstance();
        President president2 = President.getInstance();
        System.out.println(president1 == president2);
    }
}
