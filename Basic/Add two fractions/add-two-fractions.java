//{ Driver Code Starts
import java.util.*;

class Fraction_Addition
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T>0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			
			GfG g = new GfG();
			g.addFraction(a,b,c,d);
		T--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete this function*/
class GfG
{ 	
    void addFraction(int num1, int den1, int num2, int den2)
    {
        int numerator=(num1*den2)+(num2*den1);
        int denominator=den1*den2;
        
        int gcd=gcd(numerator,denominator);
        
        System.out.println(numerator/gcd+"/"+denominator/gcd);
    }
    
    static int gcd(int num1,int num2)
    {
        if(num2==0)
        {
            return num1;
        }
        return gcd(num2,num1%num2);
    }
}