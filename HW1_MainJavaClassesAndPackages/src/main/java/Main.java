public class Main {
    public static void main(String[] args) {
        System.out.println("<---Child no constructor--->");
        Child childNoConstructor = new Child();
        childNoConstructor.getChildInstanceOne();
        childNoConstructor.getChildInstanceTwo();
        childNoConstructor.getParentInstanceOne();
        childNoConstructor.getParentInstanceTwo();

        System.out.println("<---Child name constructor--->");
        Child childNameConstructor = new Child("Ivan");
        childNameConstructor.getChildInstanceOne();
        childNameConstructor.getChildInstanceTwo();
        childNameConstructor.getParentInstanceOne();
        childNameConstructor.getParentInstanceTwo();
    }
}
