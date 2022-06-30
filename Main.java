import java.io.*;
import java.lang.*;
import java.util.*;


public class Main {
    //-------template-----------
    public static Scanner ip=new Scanner(System.in);
    public static PrintStream op=System.out;
    public static String inputPath=null;
    public static String outputPath=null;
    public static String expectedOutputPath=null;
    //---------------end--------------
    
    public static void solve(){
        op.println("running");
    }
    
    
    
	public static void main (String[] args) throws Exception{

        //setup
        if(args.length!=0){
            if(args[0].equals("TESTING")){
                inputPath=args[1];
                outputPath=args[2];
                ip=new Scanner(new File(inputPath));
                op=new PrintStream(new File(outputPath));
            }
        }

        //logic
	    int t=ip.nextInt();
        while(t--!=0){

            solve();

        }


        //testing
        if(args.length!=0){
            if(args[0].equals("TESTING")){
                expectedOutputPath=args[3];
                System.out.print("TestCase "+args[4]+" ");
                Scanner myOutput=new Scanner(new File(outputPath));
                Scanner givenOutput=new Scanner(new File(expectedOutputPath));
                int cnt=1;
                while(givenOutput.hasNext()&&myOutput.hasNextLine()){
                    if(givenOutput.nextLine().equals(myOutput.nextLine())){
                        cnt++;
                    }else{
                        System.out.println("Error at line "+cnt);
                        return;
                    }
                }
                if(myOutput.hasNextLine()||myOutput.hasNextLine()){
                    System.out.println("Error at line "+cnt);
                    return;
                }
                System.out.println("passed");
            }
            
        }
	}
}

