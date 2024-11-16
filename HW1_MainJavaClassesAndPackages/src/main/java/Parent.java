public abstract class Parent {
    private String name;

    public Parent() {
        System.out.println("Parent:constructor");
    }

    public Parent(String name) {
        System.out.println("Parent:name-constructor");
    }

    public static void getParentStaticOne() {
        System.out.println("Parent:static 1");
    }

    public static void getParentStaticTwo() {
        System.out.println("Parent:static 2");
    }

    public void getParentInstanceOne() {
        System.out.println("Parent:instance 1");
    }

    public void getParentInstanceTwo() {
        System.out.println("Parent:instance 2");
    }
}
