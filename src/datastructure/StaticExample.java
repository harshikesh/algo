package datastructure;

class StaticExample {
   static int count = 0;

    StaticExample() {
        count++;
        System.out.println(count);
    }

    public static void main(String args[]) {

        StaticExample c1 = new StaticExample();
        StaticExample c2 = new StaticExample();
        StaticExample c3 = new StaticExample();

    }
}