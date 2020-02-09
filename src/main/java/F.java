public class F {

    public static void main(String[] args) {
        F f = new F();
//f.fibb(5);
        System.out.println(f.fibb(6));
    }

    public int fibb(int n) {
        int sum = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fibb(n - 1)) + (fibb(n - 2));
    }
}
