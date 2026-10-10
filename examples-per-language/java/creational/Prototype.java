class Sheep{
    protected String name;
    protected String category;

    Sheep(String name, String category){
        this.name = name;
        this.category = category;
    }

    void setName(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }

    void setCategory(String category){
        this.category = category;
    }

    String getCategory(){
        return this.category;
    }

    public Sheep clone(){
        return new Sheep(name, category);
    }
}

class Prototype {
    public static void main(String[] args) {
        Sheep sheep = new Sheep("Jolly", "Mountain Sheep");
        System.out.println(sheep.getName());
        System.out.println(sheep.getCategory());

        Sheep clonedSheep = sheep.clone();
        clonedSheep.setName("Dolly");
        System.out.println(clonedSheep.getName());
        System.out.println(clonedSheep.getCategory());
    }
}
