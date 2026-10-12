import java.util.ArrayList;

abstract class FileSystemNode{
    protected String name;
    protected int size;

    FileSystemNode(String name, int size){
        this.name = name;
        this.size = size;
    }

    abstract int getSize();
}

class File extends FileSystemNode{
    File(String name, int size){
        super(name, size);
    }

    public int getSize(){
        return size;
    }
}

class Directory extends FileSystemNode{
    ArrayList<FileSystemNode> nodes = new ArrayList<>();

    Directory(String name){
        super(name, 0);
    }

    public void add(FileSystemNode node){
        nodes.add(node);
    }

    public int getSize(){
        return nodes.stream().mapToInt(FileSystemNode::getSize).sum();
    }
}

class Composite{
    public static void main(String[] args) {
        Directory images = new Directory("images");
        images.add(new File("Me", 10));
        images.add(new File("Brother", 10));
        System.out.println(images.getSize());
    }
}
