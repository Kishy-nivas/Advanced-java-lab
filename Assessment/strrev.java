class strrev{
    static String r = "" ;

    public static String rev(String s) {

        if(s.length() <= 1){
   //         System.out.print(s) ;
            return s ;
        }

        r = r  + rev(s.substring(1, s.length() )) +s.substring(0,1);

        return r ;
    }


    public static void main(String a[]) {
        String s = "kashyap" ;
        System.out.println( rev(s) );

    }
}