import java.util.Scanner;
public class ReverseDigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        System.out.println("enter 3 digit no:");
        int n = sc.nextInt();

       int a = n%10 ;
       n = n/10;

       int b = n%10 ;
       n= n/10 ;

       int c = n%10;
       n = n/10;

       int reverse = a*100+b*10+c ;

       System.out.println("reverse:"+reverse);


       







    }




}