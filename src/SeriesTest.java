import java.io.*;

public class SeriesTest {

	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int cases=Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++)
		{
			int n = Integer.parseInt(br.readLine());
			if(n>1)
			{
				System.out.print(1+" ");
				int num=1, inc_times=0, inc_fact=1;
				
				for(int j=2;j<=n;j++)
				{
					if(j%2 == 0)
					{
						if(inc_times<inc_fact)
						{
							System.out.print(inc_fact+" ");
							inc_times++;
							num+=inc_fact;
						}
						else if(inc_times == inc_fact)
						{

							inc_fact++;
							System.out.print(inc_fact+" ");
							num+=inc_fact;
							inc_times=1;
						}
					}
					else
					{
						System.out.print(num+" ");
					}
				}
			}
			else if(n == 1)
			{
				System.out.println(1);
			}
			else
			{
				
			}
			
		}
	}

}
