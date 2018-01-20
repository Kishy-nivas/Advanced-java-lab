/*
Flow

Get a random number


*/

import java.util.Random ;
import java.util.Scanner ;

class game {


    public static void main(String []a){

        int fixedRandomNumber , userGuess ;

        Scanner s = new Scanner(System.in) ;
        Random  r =  new Random() ;

        //Fixed Random Number
        fixedRandomNumber = r.nextInt(101) ;
        
        do {
            //Get User Input
            System.out.println("Enter your Guess") ;            
            userGuess = s.nextInt() ;
            
            if(userGuess < fixedRandomNumber) {
                System.out.println("Guess Was less") ; 
            } else if(userGuess > fixedRandomNumber){
                System.out.println("Guess Was more") ;
            }

        }while(userGuess != fixedRandomNumber) ;


        System.out.println("Guess Was exact") ;        



        
    }

}