
public class HackerRankAlgos {

    static int hackerlandRadioTransmitters(int[] x, int k) {
    	int count=0;
    	for(int i=0;i<x.length-1;i++)
    	{
    		
    	}
    	return count;
    }
    
    public static long taumBday(int b, int w, int bc, int wc, int z) {
    	long result=0;
    	long bcost=bc,wcost=wc;
    	if(wc+z < bc)
    		bcost=wc+z;
    	if(bc+z < wc)
    		wcost=bc+z;
    	result=(long)(b*bcost)+(long)(w*wcost);
    	return result;

    }
    
    static void kaprekarNumbers(int p, int q) {
    	String op="";
    	
        for(long i=p;i<=q;i++)
        {
            int length = String.valueOf(i).length();
            long num = i*i;
            //System.out.println(i);
            String left="";
            String right="";
            
            if(num%2 == 0)
            {
            	right = String.valueOf(num).substring(String.valueOf(num).length()-length);
                left  = String.valueOf(num).substring(0,String.valueOf(num).length()-length);
            }
            else
            {
            	right = String.valueOf(num).substring(String.valueOf(num).length()-length);
                left  = String.valueOf(num).substring(0,String.valueOf(num).length()-length);

            }
            int num1=Integer.parseInt(right);
            int num2=0;
            if(!left.equals(""))
            	num2=Integer.parseInt(left);
           
            if(num1+num2 == i)
                op+= String.valueOf(i)+" ";
           
        }
        if(op.length() == 0)
        	System.out.println("INVALID RANGE");
        else
        	System.out.println(op);

    }
    
    static int[] closestNumbers(int[] arr) {
    	

    	return arr;
    }
	
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5};
		//hackerlandRadioTransmitters(a, 1);
		//System.out.println(taumBday(3, 6, 9, 1, 1));
		kaprekarNumbers(1,99999);
		
	}

}
