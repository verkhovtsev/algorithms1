package test;

public class Cougar {

    static String s2 = "123";
    static String s3 = "123";

    public static void main(String[] args) {
        int i=0, j=0, k=0;
        doStuff(i++, ++j, (k += 1));
        System.out.println(i + " " + j + " " + k);

        String s = "im string";
        String s1 = "im string";
        System.out.println(s == s1);
        System.out.println(s.equals(s1));
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));
        System.out.println(new A("12").equals(new A("12")));
        System.out.println(new A("12").equals(new A(new String("12"))));
    }

    static void doStuff(int i, int j, int k) {
        System.out.println(i + " " + j + " " + k);
    }
}
class A {
    String a;
    public A(String a) {
        this.a = a;
    }
}