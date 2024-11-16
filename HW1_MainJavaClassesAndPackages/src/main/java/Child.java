public class Child extends Parent {
    public Child() {
        System.out.println("Child:constructor");
    }

    public Child(String name) {
        super(name);
        System.out.println("Child:name-constructor");
    }

    public static void getChildStaticOne() {
        System.out.println("Child:static 1");
    }

    public static void getChildStaticTwo() {
        System.out.println("Child:static 2");
    }

    public void getChildInstanceOne() {
        System.out.println("Child:instance 1");
    }

    public void getChildInstanceTwo() {
        System.out.println("Child:instance 2");
    }
}
