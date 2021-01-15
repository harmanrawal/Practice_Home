
public class Multiple {

	public static void main(String[] args) 
	{
		int[] a = {2,7,11,15}; 
		System.out.println(twoSum(a, 13)[1]);
	}

	static void multiplesOfThreeAndFive()
	{
		int i=3,sum=0;
		for(int j=i;j<1000;j++)
		{
			if(j%5 == 0 || j%3 == 0)
				sum+=j;
		}
		System.out.println(sum);
	}
	
	static void fibonacci()
	{
		int a=1,b=2;
		long sum=2;
		while(sum<4000000)
		{
			int c=a+b;
			if(c%2 == 0)
				sum+=c;
			a=b;
			b=c;
		}
		System.out.println(sum);
	}
	
	static int[] twoSum(int[] nums, int target) {
        int pos[]=new int[2];
		for(int i=0;i<nums.length-1;i++)
		{
			for(int j=i+1;j<nums.length;j++)
			{
				if(nums[i]+nums[j] == target)
				{
					pos[0]=i;
					pos[1]=j;
					break;
				}
			}
		}
        
		return pos;
    }
}
