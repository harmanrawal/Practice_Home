import java.io.*;

public class SubArraySum 
{

	public static void main(String[] args) throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int n = Integer.parseInt(br.readLine());
		for(int i=0 ; i< n ; i++)
		{
			String line = br.readLine();
			int array_length = Integer.parseInt(line.split("\\s+")[0]);
			int sum = Integer.parseInt(line.split("\\s+")[1]);
			//System.out.println(sum);
			String array = br.readLine();
			String array_list[] = array.split("\\s+");
			int array_int[] = new int[array_length];
			for(int j=0;j<array_length;j++)
			{
				array_int[j]=Integer.parseInt(array_list[j]);
			}
			//System.out.println(array_int);
			int start_pos=0,end_pos=0;
			int test_sum=array_int[0];
			boolean check=false;
			//System.out.println("Test Sum : "+test_sum);
			/*System.out.print("Array is : ");
			for(int j=0;j<array_length;j++)
			{
				System.out.print(array_int[j]+" ");
			}
			System.out.println();*/
			for(int j=1;j<array_length;j++)
			{
				if(test_sum == sum)
				{
					//System.out.println("Sum is now : "+test_sum);
					check=true;
					break;
				}
				else if(test_sum<sum)
				{
					test_sum+=array_int[j];
					end_pos=j;
					while(test_sum>sum)
					{
						test_sum-=array_int[start_pos];
						start_pos++;
						if(test_sum<=sum)
						{
							check = true;
							break;
						}
					}
				}
			}
			//System.out.println(test_sum);
			if(end_pos==array_length-1)
			{
				
			}
			if(check == true)
			System.out.println((start_pos+1)+" "+(end_pos+1));
			else
				
			System.out.println("-1");
		}
	}

}
