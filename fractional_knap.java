public class fractional_knap {
    public static int fibSeq(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return fibSeq(n-1) + fibSeq(n-2);
    }
    public static void main(String[]args){
        int n = 6;
        System.out.print(fibSeq(n));
    }

}
