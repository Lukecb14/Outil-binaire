import java.util.Scanner;
import java.lang.Math;

class Binary {
    public static void main(String[] args) {
        
        while(true==true) {
            
            boolean funcTest = false;
            
            
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("Please write which function you would like to select from the following list: ");
            System.out.println("    DEC - Convert to decimal");
            System.out.println("    C2 - Complément à 2");
            System.out.println("    C1 - Complément à 1");


            while (funcTest==false){

                Scanner scanFunc = new Scanner(System.in);
                String func = scanFunc.nextLine();

                if (func.equals("Convert to decimal") || func.equals("DEC") || func.equals("dec")){
                    funcTest=true;
                    convToDec();
                } else if (func.equals("Complément à 2") || func.equals("C2") || func.equals("c2" )){
                    funcTest=true;
                    comp2();
                } else if (func.equals("Complément à 1") || func.equals("C1") || func.equals("c1" )){
                    funcTest=true;
                    comp1();
                } /* This is where I would insert more functions in the future*/ else {
                    funcTest=false;
                    System.out.println("Please enter a valid commmand");
                }
            }
        }
    }

    public static void convToDec() {
        boolean valid = false;
        double decNum = 0;
        String binNum = inputBin();
            
        int point=binNum.indexOf('.');
                
        if (point>=0) {
            for (int i=0; i<point; i++) {
                if (binNum.charAt(i)=='1') {
                    decNum = decNum+ Math.pow(2,point-i-1);
                }
            }
            for (int i=point; i<binNum.length(); i++) {
                if (binNum.charAt(i)=='1') {
                    decNum = decNum+ Math.pow(2,point-i);
                }
            }
        } else {
            for (int i=0; i<binNum.length(); i++) {
                if (binNum.charAt(i)=='1') {
                    decNum = decNum+ Math.pow(2,binNum.length()-i-1);
                }
            }
        }

        System.out.println("The decimal value of that number is : "+ decNum);
    }
	
    public static void comp2() {
        String binNum=inputBin();
        boolean found1=false;
        StringBuilder comp2Num = new StringBuilder(binNum);

        for (int i=binNum.length()-1; i>=0; i--) {

            if (found1==true && binNum.charAt(i)=='1') {
                comp2Num.setCharAt(i, '0');
            } else if (found1==true && binNum.charAt(i)=='0') {
                comp2Num.setCharAt(i, '1');
            }

            if (binNum.charAt(i)=='1'){
                found1=true;
            }
        }

        System.out.println("Le complément à 2 est: "+comp2Num);
    }

    public static void comp1() {
        String binNum=inputBin();
        StringBuilder comp1Num = new StringBuilder(binNum);

        for (int i=binNum.length()-1; i>=0; i--) {

            if (binNum.charAt(i)=='1') {
                comp1Num.setCharAt(i, '0');
            } else if (binNum.charAt(i)=='0') {
                comp1Num.setCharAt(i, '1');
            }
        }

        System.out.println("Le complément à 1 est: "+comp1Num);
    }
    
    public static String inputBin() {

        boolean valid = false;
        String Num = "";
        System.out.println("Please enter a valid binary number:");
        
        while (valid==false) {
            int periodCount = 0;
            
            Scanner scanNum = new Scanner(System.in);
 	        Num = scanNum.nextLine();

            for (int i=0; i<Num.length(); i++) {
                if (Num.charAt(i) != '1' && Num.charAt(i) != '0' && Num.charAt(i) != '.') {
                    System.out.println("That isn't a valid binary number. Try again.");
                    break;
                }
                if (Num.charAt(i) == '.') {
                    periodCount++;
                }
                if (periodCount>1) {
                    System.out.println("That isn't a valid binary number. Try again.");
                    break;
                }
                if (i==(Num.length()-1)) {
                    valid=true;
                }
            }
        }
        return(Num);
    }
}