class eulerIsGreat {
    public static int fact(int n) {
        if(n == 0){
            return 1 ;
        }

        return n * fact(n-1) ;
    }

    public static double eNumber(double n) {


        if( n == 0) {

            return 1 ;
        }

        double x = fact( (int) n) ;
        System.out.println(1/x);
        return ( (1 / x ) + eNumber(n-1)) ;

    }

    public static void main(String a[]){

        System.out.println(eNumber(3)) ;
        System.out.println(1/9.0);
    }
}