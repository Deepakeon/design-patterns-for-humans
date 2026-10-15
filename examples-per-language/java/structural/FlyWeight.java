import java.util.HashMap;
import java.util.Map;

class KarakTea{

}

class TeaMaker{
    protected HashMap<String, KarakTea> availableTea = new HashMap<>();

    public KarakTea make(String preference){
        if(availableTea.get(preference) == null){
            availableTea.put(preference, new KarakTea());
        }

        return availableTea.get(preference);
    }
}

class TeaShop{
    protected HashMap<Integer, KarakTea> orders = new HashMap<>();
    protected TeaMaker teaMaker;

    TeaShop(TeaMaker teaMaker){
        this.teaMaker = teaMaker;
    }

    public void takeOrder(String teaType, int table){
        orders.put(table, teaMaker.make(teaType));
    }

    public void serve(){
        for(Map.Entry<Integer, KarakTea> order: orders.entrySet()){
            System.out.println("Serving tea to table#" + order.getKey());
        }
    }
}

class FlyWeight{
    public static void main(String[] args) {
        TeaMaker teaMaker = new TeaMaker();
        TeaShop shop = new TeaShop(teaMaker);

        shop.takeOrder("less sugar", 1);
        shop.takeOrder("more milk", 2);
        shop.takeOrder("without sugar", 5);

        shop.serve();

    }
}
