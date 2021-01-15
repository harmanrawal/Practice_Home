import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution2 {

	// Complete the plusMinus function below.
	static void plusMinus(int[] arr) {
		int pos = 0, neg = 0, zeros = 0;
		double posp = 0, negp = 0, zerosp = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0)
				neg++;
			else if (arr[i] > 0)
				pos++;
			else
				zeros++;
		}
		System.out.println(neg);
		System.out.println(pos);

		negp = Double.valueOf(String.valueOf(neg)) / Double.valueOf(String.valueOf(arr.length));
		posp = (double) pos / arr.length;
		zerosp = (double) zeros / arr.length;
		DecimalFormat df = new DecimalFormat("0.000000");
		System.out.println(df.format(negp));
		System.out.println(df.format(posp));
		System.out.println(df.format(zerosp));
	}

	static void staircase(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j <= i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}

	}

	static void miniMaxSum(int[] arr) {

		long sum = arr[0];
		int min = arr[0], max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] < min)
				min = arr[i];
			if (arr[i] > max)
				max = arr[i];
		}
		System.out.println((sum - max) + " " + (sum - min));
	}

	static int birthdayCakeCandles(int[] ar) {

		int max = ar[0], count = 0;
		for (int i = 1; i < ar.length; i++) {
			if (max < ar[i]) {
				max = ar[i];
			}
		}
		// System.out.println(max);
		for (int i = 0; i < ar.length; i++) {
			if (max == ar[i]) {
				count++;
			}
		}
		return count;

	}

	static String timeConversion(String s) {

		SimpleDateFormat df = new SimpleDateFormat("hh:mm:ssaa");
		Date dt = null;
		try {
			dt = df.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		df = new SimpleDateFormat("HH:mm:ss");
		return df.format(dt);
	}

	static String[] cavityMap(String[] grid) {

		String a[] = new String[grid.length];
		for (int i = 0; i < grid.length; i++) {
			String s = grid[i];
			String s1 = "";
			for (int j = 0; j < grid[i].length(); j++) {
				char ch = s.charAt(j);

				if (i == 0 || j == 0 || i == (grid[i].length() - 1) || j == (grid[i].length() - 1)) {
					s1 += ch;
				} else {
					char ch_up = grid[i - 1].charAt(j);
					char ch_down = grid[i + 1].charAt(j);
					char ch_right = grid[i].charAt(j + 1);
					char ch_left = grid[i].charAt(j - 1);
					if (ch > ch_up && ch > ch_down && ch > ch_right && ch > ch_left) {
						s1 += "X";
					} else {
						s1 += ch;
					}
				}

			}
			a[i] = s1;
		}
		return a;
	}

	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

		List<Integer> result = new ArrayList<Integer>();
		int a_count = 0, b_count = 0;
		for (int i = 0; i < a.size(); i++) {
			int numa = a.get(i);
			int numb = b.get(i);
			if (numa > numb) {
				a_count++;
			} else if (numa < numb) {
				b_count++;
			}
		}
		result.add(a_count);
		result.add(b_count);
		return result;
	}

	public static List<Integer> gradingStudents(List<Integer> grades) {

		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < grades.size(); i++) {
			int num = grades.get(i);
			if ((num + 1) % 5 == 0 && num > 37) {
				result.add(num + 1);
			} else if ((num + 2) % 5 == 0 && num > 37) {
				result.add(num + 2);
			} else {
				result.add(num);
			}
		}
		return result;
	}

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {

		int apple_count = 0, orange_count = 0;
		for (int i = 0; i < apples.length; i++) {
			if (a + apples[i] >= s && a + apples[i] <= t) {
				apple_count++;
			}
		}
		for (int i = 0; i < oranges.length; i++) {
			if (b + oranges[i] >= s && b + oranges[i] <= t) {
				orange_count++;
			}
		}
		System.out.println(apple_count);
		System.out.println(orange_count);
	}

	static String kangaroo(int x1, int v1, int x2, int v2) {
		String check = "NO";
		while (true) {
			if (x1 > x2 && v1 >= v2) {
				break;
			}
			if (x2 > x1 && v2 >= v1) {
				break;
			}
			if (x1 == x2) {
				check = "YES";
				break;
			}
			x1 += v1;
			x2 += v2;
		}
		return check;
	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		List<Integer> factors = new ArrayList<Integer>();
		int max_a = a.get(0), min_b = b.get(0);
		for (int num : a) {
			if (num > max_a) {
				max_a = num;
			}
		}
		// System.out.println(max_a);
		for (int num : b) {
			if (num < min_b) {
				min_b = num;
			}
		}
		// System.out.println(min_b);
		for (int i = max_a; i <= min_b; i++) {
			boolean check = true;
			for (int j = 0; j < a.size(); j++) {
				if (i % (a.get(j)) != 0) {
					check = false;
					break;
				}

			}
			if (check == true)
				factors.add(i);
		}
		// System.out.println(factors);
		for (int i = 0; i < factors.size(); i++) {
			boolean check = true;
			for (int j = 0; j < b.size(); j++) {
				if (b.get(j) % factors.get(i) != 0) {
					check = false;
					break;
				}
			}
			if (check == false) {
				factors.remove(i);
				i--;
			}
		}

		// System.out.println(factors);

		return factors.size();
	}

	static int[] breakingRecords(int[] scores) {
		int min = scores[0], max = scores[0], min_count = 0, max_count = 0;

		for (int i = 1; i < scores.length; i++) {
			if (scores[i] > max) {
				max = scores[i];
				max_count++;
			}
			if (scores[i] < min) {
				min = scores[i];
				min_count++;
			}
		}

		int a[] = { max_count, min_count };
		return a;
	}

	static int birthday(List<Integer> s, int d, int m) {
		List<Integer> list = new ArrayList<Integer>();
		int count = 0;
		for (int i = 0; i < m; i++) {
			list.add(s.get(i));
		}
		int sum = 0;
		for (int j = 0; j < list.size(); j++) {
			sum += list.get(j);
		}
		if (sum == d) {
			count++;
		}
		for (int i = m; i < s.size(); i++) {
			list.remove(0);
			list.add(s.get(i));
			sum = 0;
			for (int j = 0; j < list.size(); j++) {
				sum += list.get(j);
			}
			if (sum == d) {
				count++;
			}

		}
		return count;
	}

	static int divisibleSumPairs(int n, int k, int[] ar) {
		int count = 0;

		for (int i = 0; i < ar.length; i++) {
			int num = ar[i];
			for (int j = i + 1; j < ar.length; j++) {
				if (i != j) {
					if ((num + ar[j]) % k == 0)
						count++;
				}
			}
		}

		return count;

	}

	static int migratoryBirds(List<Integer> arr) {
		int max = 0;
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i : arr) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}
		Integer key = (int) map.keySet().toArray()[0];
		max = map.get(key);
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				key = entry.getKey();
				max = entry.getValue();
			}
		}

		return key.intValue();
	}

	static String dayOfProgrammer(int year) {

		int num = 0;
		if (((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) && year > 1918) {
			num = 256 - 244;
		} else if (year < 1918 && year % 4 == 0) {
			num = 256 - 244;
		} else if (year == 1918) {
			num = 256 - 243 + 13;
		} else {
			num = 256 - 243;
		}
		String st = num + ".09." + year;
		return st;

	}

	static void bonAppetit(List<Integer> bill, int k, int b) {

		int sum = 0;
		for (int i : bill) {
			sum += i;
		}
		sum -= bill.get(k);
		if (b == sum / 2) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - sum / 2);
		}
	}

	static int sockMerchant(int n, int[] ar) {

		int count = 0;
		Map<Integer, Integer> socks = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			if (socks.containsKey(ar[i])) {
				socks.put(ar[i], socks.get(ar[i]) + 1);
				if (socks.get(ar[i]) == 2) {
					count++;
					socks.put(ar[i], 0);
				}
			} else {
				socks.put(ar[i], 1);
			}
		}

		return count;
	}

	static int pageCount(int n, int p) {

		boolean last_page_single = true;
		if (n % 2 != 0)
			last_page_single = false;
		int front_step = 0, last_step = 0;

		front_step = p / 2;
		if (last_page_single)
			last_step = (n - p + 1) / 2;
		else
			last_step = (n - p) / 2;
		System.out.println(front_step + " " + last_step);
		if (front_step <= last_step)
			return front_step;
		else
			return last_step;
	}

	static int countingValleys(int n, String s) {
		int valley_count = 0, current = 0, next = 0;
		boolean upcheck = true;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			int counter;
			if (ch == 'U')
				counter = 1;
			else
				counter = -1;
			next = current + counter;
			if (current == 0 && next > 0) {
				upcheck = true;
			}
			if (current == 0 && next < 0) {
				upcheck = false;
				valley_count++;
			}
			current = next;
		}
		return valley_count;
	}

	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int total_money = 0;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int sum = keyboards[i] + drives[j];
				if (sum > total_money && sum <= b) {
					total_money = sum;
				}
			}
		}
		if (total_money > 0)
			return total_money;
		else
			return -1;
	}

	static String catAndMouse(int x, int y, int z) {
		if (Math.abs(x - z) < Math.abs(y - z)) {
			return "Cat A";
		} else if (Math.abs(x - z) > Math.abs(y - z)) {
			return "Cat B";
		} else
			return "Mouse C";
	}

	static int formingMagicSquare(int[][] s) {
		List<Integer> result = new ArrayList<Integer>();
		int arr[][][] = { { { 8, 3, 4 }, { 1, 5, 9 }, { 6, 7, 2 } }, { { 4, 3, 8 }, { 9, 5, 1 }, { 2, 7, 6 } },
				{ { 2, 7, 6 }, { 9, 5, 1 }, { 4, 3, 8 } }, { { 6, 7, 2 }, { 1, 5, 9 }, { 8, 3, 4 } },
				{ { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } }, { { 4, 9, 2 }, { 3, 5, 7 }, { 8, 1, 6 } },
				{ { 2, 9, 4 }, { 7, 5, 3 }, { 6, 1, 8 } }, { { 6, 1, 8 }, { 7, 5, 3 }, { 2, 9, 4 } } };

		for (int i = 0; i < arr.length; i++) {
			int a[][] = arr[i];
			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				for (int k = 0; k < a[j].length; k++) {
					sum += Math.abs(s[j][k] - a[j][k]);
				}
			}
			// System.out.println(sum);
			result.add(sum);

		}
		Collections.sort(result);
		System.out.println(result);
		return result.get(0);
	}

	public static int pickingNumbers(List<Integer> a) {
		// Write your code here
		List<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < a.size(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			int num = a.get(i);
			list.add(num);
			for (int j = 0; j < a.size(); j++) {
				if (i != j) {
					boolean check = true;
					for (int k = 0; k < list.size(); k++) {
						if (Math.abs(list.get(k) - a.get(j)) > 1) {
							check = false;
							break;
						}
					}
					if (check == true)
						list.add(a.get(j));
				}
			}
			// System.out.println(list);
			subsets.add(list);
		}
		// System.out.println(subsets);

		ArrayList<Integer> list = subsets.get(0);
		for (ArrayList<Integer> eng : subsets) {
			if (eng.size() > list.size()) {
				list = eng;
			}
		}
		return list.size();

	}

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		
		 ArrayList<Integer> uniqueScores = new ArrayList<Integer>() ;
		 int rank=1;
		 TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
	     for(int i=0;i<scores.length;i++)
	        {
	    	 	if(!uniqueScores.contains(scores[i]))
	    	 	{
	    	 		uniqueScores.add(scores[i]);
	    	 		map.put(scores[i], rank);
	    	 		rank++;
	    	 	}
	        }
	     Collections.sort(uniqueScores);
	     
	     //System.out.println(map);
	     //System.out.println(uniqueScores);
	     int start_index = 0;
	     int first_key = uniqueScores.get(start_index);
	     int last_key = uniqueScores.get(uniqueScores.size()-1);
	     int rank_initial = map.get(first_key)+1;
	     int a[] = new int[alice.length];
	    // System.out.println(rank_initial);
	     /*for(int i=0;i<alice.length;i++)
	     {
	    	 System.out.print(alice[i]+" ");
	     }
	     System.out.println();*/
	     for(int i=0;i<alice.length;i++)
	     {
	    	 first_key = uniqueScores.get(start_index);
	    	 int end_index  = uniqueScores.size()-1;
	    	 last_key = uniqueScores.get(uniqueScores.size()-1);
	    	 int aliceScore=alice[i];
	    	// System.out.println(aliceScore);
	    	 if(aliceScore<first_key)
	    	 {
	    		 rank = rank_initial;
	    	 }
	    	 else if(aliceScore>=last_key)
	    	 {
	    		 rank = 1;
	    	 }
	    	 else
	    	 {
	    		 while(true)
	    		 {	    		 
	    			 int mid_index=(start_index+end_index)/2;
		    		 if(aliceScore == uniqueScores.get(mid_index))
		    		 {
		    			 rank = map.get(uniqueScores.get(mid_index));
		    			 break;
		    		 }
		    		 else if(map.get(uniqueScores.get(start_index))-1 == map.get(uniqueScores.get(end_index)))
		    		 {
		    			 rank = map.get(uniqueScores.get(start_index));
		    			 break;
		    		 }
		    		 else if(aliceScore>=uniqueScores.get(start_index) && aliceScore<uniqueScores.get(mid_index))
		    		 {
		    			 end_index=mid_index;
		    		 }
		    		 else if(aliceScore>uniqueScores.get(mid_index) && aliceScore<=uniqueScores.get(end_index))
					 {
		    			 start_index = mid_index;
					 }
		    		
	    		 }
	    	 }
	    	 //else(aliceScore == map.get(key))
	    	 
	    	 
	    	 a[i] = rank;
	     }
	   return a;
	}
	
	public static int binarySearchLocal(ArrayList<Integer> marks, int begin, int end, int aliceScore)
	{
		
		
		return 0;
	}
	// Complete the climbingLeaderboard function below.
	/*static int[] climbingLeaderboard1(int[] scores, int[] alice) {

        ArrayList<Integer> treeSetObj = new ArrayList<Integer>() ;
        ArrayList<Marks> tree = new ArrayList<Marks>();
        
        //Adding scores to TreeSetObj
        for(int i=0;i<scores.length;i++)
        {
            if(treeSetObj.contains(scores[i]))
                continue;
            else
                treeSetObj.add(scores[i]);
        }
        int index=treeSetObj.size();
        Collections.sort(treeSetObj);
        for(int i=0;i<treeSetObj.size();i++)
        {
            Marks obj = new Marks();
            obj.mark=treeSetObj.get(i);
            obj.rank=index;
            tree.add(obj);
            index--;
        }
        for(int i=0;i<tree.size();i++)
        {
            System.out.println(tree.get(i).mark+" "+tree.get(i).rank);
        }
        int start_index=0;
        int a[]= new int[alice.length];
        for(int i=0;i<alice.length;i++)
        {
            int rank=0;
            int marks = alice[i];
            
                if(marks<tree.get(0).mark)
                {
                    rank=tree.get(0).rank+1;
                }
                else if(marks>=tree.get(tree.size()-1).mark)
                {
                    rank=1;
                }
                
                else 
                {
                	int end_index=tree.size()-1,mid_index=0;
                    Marks begin = tree.get(start_index);
                    Marks last = tree.get(tree.size()-1);
                    mid_index = (start_index+end_index-1)/2;
                    Marks mid = tree.get(mid_index);
                    
                    boolean rank_found=false;
                    while(!rank_found)
                    {
                        if(mid.mark == marks)
                        {
                            rank = mid.rank;
                            break;
                        }
                        else if(begin.rank-1 == last.rank)
                        {
                            rank = begin.rank;
                            break;
                        }
                        else if(marks>mid.mark && marks<=last.mark)
                        {
                            begin=mid;
                            start_index=mid_index;
                            
                        }
                        else if(marks<mid.mark && marks>=begin.mark)
                        {
                            last=mid;
                            end_index=mid_index;
                        }
                        mid_index=(start_index+end_index)/2;
                        mid=tree.get((start_index+end_index)/2);
                    }
                    while(tree.get(start_index).mark<=marks)
                    {
                    	if((tree.get(start_index+1).mark>marks))
                    		break;
                    	start_index++;
                    }
                    
                }
                
            //else if(marks<tree.lastKey())
            
            a[i]=rank;
        }
        
        for(int i=0;i<a.length;i++)
            System.out.println(a[i]);
        return a;
        
        

    }*/


	public static class Marks {
		int mark;
		int rank;
	}

	// Complete the hurdleRace function below.
    static int hurdleRace(int k, int[] height) {
    	int diff=0,max=0;
    	for(int i=0;i<height.length;i++)
    	{
    		if(height[i]>max)
    		{
    			max=height[i];
    		}
    	}
    	diff=max-k;
    	return diff;

    }

    // Complete the designerPdfViewer function below.
    static int designerPdfViewer(int[] h, String word) {

    	int result=1,max=0,check=0;
    	char[] chars = new char[h.length];
    	for(char i=97;i<(97+26);i++,check++)
    	{
    		if(word.contains(String.valueOf(i)))
    		{
    			chars[check] = i;
    		}
    		else
    		{
    			chars[check] = 0;
    		}
    		check++;
    	}
    	
    	
    	for(int i=0;i<h.length;i++)
    	{
    		if(h[i]>max && chars[i]!=0)
    			max=h[i];
    	}
    	result*= word.length()*max;
    	return result;

    }

    static int utopianTree(int n) {
    	int height=1;
    	for(int i=1;i<=n;i++)
    	{
    		if(i%2==0)
    			height+=1;
    		else
    			height*=2;
    	}
    	return height;
    }
    
 // Complete the angryProfessor function below.
    static String angryProfessor(int k, int[] a) {
    	
    	int count=0;
    	for(int i=0;i<a.length;i++)
    	{
    		if(a[i]<=0)
    			count++;
    	}
    	if(count>=k)
    		return "YES";
    	else
    		return "NO";

    }

    // Complete the beautifulDays function below.
    static int beautifulDays(int i, int j, int k) {
    	int count=0;
    	
    	for(int a=i;a<=j;a++)
    	{
    		String num = String.valueOf(a);
    		StringBuilder rev = new StringBuilder(num);
    		int rev1 = Integer.parseInt(String.valueOf(rev.reverse()));
    		int diff = Math.abs(a-rev1);
    		if(diff%k == 0)
    			count++;
    	}
    	
    	return count;
    }

    static int viralAdvertising(int n) {
    	int shares=5;
    	int daily_likes=5/2;
    	int likes=0;
    	likes+=daily_likes;
    	for(int i=2;i<=n;i++)
    	{
    		shares=daily_likes*3;
    		daily_likes=shares/2;
    		likes+=daily_likes;
    	}
    	
    	return likes;

    }

    // Complete the saveThePrisoner function below.
    static int saveThePrisoner(int n, int m, int s) {
    	if((m+s-1)%n==0)
            return (n);
            else 
            return ((m+s-1)%n);
    	}
    
 
    // Complete the circularArrayRotation function below.
    static int[] circularArrayRotation(int[] a, int k, int[] queries) {
    	//ArrayList<Integer> list = new ArrayList<Integer>();
    	int[] ans = new int[queries.length];
    	//System.out.println(list);
    	int start_point = k%a.length;
    	for(int i=0;i<queries.length;i++)
    	{
    		int pos=0;
    		if((queries[i]-start_point)>=0)
    			pos=queries[i]-start_point;
    		else 
    			pos=queries[i]-start_point+a.length;
    		ans[i] = a[pos];
    	}
    	return ans;
    }
    
    // Complete the findDigits function below.
    static int findDigits(int n) {

    	int num=n;
    	int count=0;
    	while(n>0)
    	{
    		int rem = n%10;
    		if(rem != 0)
    			if(num%rem == 0)
    				count++;
    		n=n/10;
    	}
    	System.out.println(count);
    	return count;

    }

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
    	BigInteger bi = new BigInteger("1");
    	BigInteger result = new BigInteger("1");
    	for(int i=2;i<=n;i++)
    	{
    		BigInteger bi2 = new BigInteger(String.valueOf(i));
        	//System.out.println(bi2);
    		bi=bi.multiply(bi2);
    	}
    	System.out.println(bi);
    }

   
    // Complete the appendAndDelete function below.
    static String appendAndDelete(String s, String t, int k) {
        //int index=0;
        int length;
       // System.out.println(s.length());
       // System.out.println(t.length());
        if(s.length()>=t.length())
			length = s.length();
        else
        	length = t.length();
        int i=0;
        for(i=0;i<length;i++)
        {
        	if(i>=s.length() || i>=t.length())
        		break;
        	if(s.charAt(i) != t.charAt(i))
        		break;
        }
        int diff=(s.length()-i)+(t.length()-i);
        System.out.println(diff);
        System.out.println(k);
        if(diff%2 == k%2 && k>diff)
            return "Yes";
         else if(s.length()+t.length()-k <0)
            return "Yes";
        else if(diff > k)
            return "No";
        else 
            return "No";
    }
    
    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {

    	int n = p.length;
    	int result[]=new int[p.length];
    	for(int i=0;i<n;i++)
    	{
    		
    	}
    	
    	return p;

    }
    
    static int squares(int a, int b) {
    	int count =0;
    	int low_limit = (int) Math.sqrt(a);
    	int upper_limit = (int) Math.sqrt(b);
    	for(int i=low_limit;i<upper_limit;i++)
    	{
    		int sqr = i*i;
    		if(sqr>=a && sqr<=b)
    			count++;
    	}
    	return count;
    }

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    	int fine=0;
    	if(y1!=y2 && y1 > y2)
            fine=10000;
        else
        {
        	if(y1<y2)
        		fine=0;
        	else if(m1 != m2 && m1 > m2)
            {
                fine = 500*Math.abs(m1-m2);
            }
            else
            {
            	if(m1<m2)
            		fine=0;
            	else if(d1>d2)
                    fine = 15*Math.abs(d1-d2);
            }
        }
        return fine;
    	
    }

    // Complete the cutTheSticks function below.
    static int[] cutTheSticks(int[] arr) {
    	int min=0,index=0;
    	boolean flag=false;
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	while(!flag)
    	{
    		min=arr[0];
    		int count=0;
    		for(int j=1;j<arr.length;j++)
    		{
    			if(arr[j]<min && arr[j]!=0)
    				{
    					min=arr[j];
    				}
    			else if(min==0 && arr[j]!=0)
    			{
    				min=arr[j];
    			}
    		}
    		for(int j=0;j<arr.length;j++)
    		{
    			if(arr[j]>0)
    			{
    				count++;
    				arr[j]-=min;
    			}
    		}
    		if(count==0)
    			break;
    		else
    			ret.add(count);
    	}
    	int[] retur = new int[ret.size()];
    	for(int i=0;i<ret.size();i++)
    	{
    		retur[i] = ret.get(i);
    	}
    	return retur;

    }

    public static int nonDivisibleSubset(int k, List<Integer> s) {
    	Set<Integer> set = new TreeSet<Integer>();
    	for(int i=0;i<s.size()-1;i++)
    	{
    		for(int j=i+1;j<s.size();j++)
    		{
    			if((s.get(i)+s.get(j))%k == 0)
    			{
    				set.add(s.get(i));
    				set.add(s.get(j));
    			}
    		}
    	}
    	System.out.println(set);
    	return set.size();
    }
    
    static int jumpingOnClouds(int[] c, int k) {
    	int count=100, pos=0,n=c.length;
    	do {
            pos = (pos + k) % n;
            if(c[pos] == 1){
                count -= 2;
            }
            count--;
        } while (pos != 0);
    	
    	return count;
    }

 // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds1(int[] c) {
    	int count=0,k=0;
    	while(k<c.length-1)
    	{
    		if(k+2>c.length-1)
    		{
    			count++;
    			break;
    		}
    		if(c[k+2]==0)
    		{
    			count+=2;
    			k=k+2;
    		}
    		else
    		{
    			count++;
    			k++;
    		}
    	}
    	
    	
    	return count;
    }
    
 // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
    
     int operations=0;
     Map<Integer,Integer> map = new HashMap<Integer,Integer>();
     for(int i=0;i<arr.length;i++)
     {
    	 if(map.containsKey(arr[i]))
    	 {
    		 map.put(arr[i], map.get(arr[i])+1);
    	 }
    	 else
    	 {
    		 map.put(arr[i], 1);
    	 }
    	 
     }
     int max=0;
	 for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > max) {
				//key = entry.getKey();
				max = entry.getValue();
			}
		}
     operations=arr.length-max;
     return operations;

    }

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long length = s.length();
    	long count=0, factor=0;
    	for(int i=0;i<length;i++)
    	{
    		if(s.charAt(i) == 'a')
    			count++;
    	}
    	factor=n/length;
    	count*=factor;
    	length=n%length;
    	for(int i=0;i<length;i++)
    	{
    		if(s.charAt(i) == 'a')
    			count++;
    	}
    	return count;
    	
    }

    
    public static long taumBday(int b, int w, int bc, int wc, int z) {

    	long cost=0;
    	if(bc == wc && z>=wc)
    	{
    		cost = b*bc + w*wc;
    	}
    	return cost;
    }
    
    static int palindromeIndex(String s) {
        int index=-1;
        StringBuilder st = new StringBuilder(s);
        String rev = String.valueOf(st.reverse());
        if(s.equals(rev))
            index=-1;
        else
        {
             for(int i=0;i<s.length();i++)
            {
                 String n = s.substring(0,i)+s.substring(i+1);
                 st = new StringBuilder(n);
                 rev = String.valueOf(st.reverse());
                 if(n.equals(rev))
                 {
                     index=i;
                     break;
                 }
            }
       
        }
        
        return index;

    }
    
    static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		//appendAndDelete("qwerasdf", "qwerbsdf", 6);
		repeatedString("aba", 10);
		int arr[] = {5,4,4,2,2,8};
		//cutTheSticks(arr);
		int br[] = {50,65,77,90,102};
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(4);
		List<Integer> b = new ArrayList<Integer>();
		b.add(1);
		b.add(7);
		b.add(2);
		b.add(4);
		nonDivisibleSubset(3, b);
		/*			 * b.add(4); b.add(3);7 100 100 50 40 40 20 10 4 5 25 50 120 b.add(2); b.add(1);
					 * b.add(3); b.add(4);
					 */
		// pickingNumbers(b);
		
		
		//climbingLeaderboard(arr, br);
		// getTotalX(a, b);
		// plusMinus(arr);

		// staircase(6);
		/*int x[]= {39356,87674,16667,54260,43958,70429,53682,6169,87496,66190,90286,4912,44792,65142,36183,43856,77633,38902,1407,88185,80399,72940,97555,23941,96271,49288,27021,32032,75662,69161,33581,15017,56835,66599,69277,17144,37027,39310,23312,24523,5499,13597,45786,66642,95090,98320,26849,72722,37221,28255,60906},k=51;
		int y[]={47,10,12,13,6,29,22,17,7,3,30,45,1,21,50,17,25,42,5,6,47,2,24,1,6,14,24,43,7,2,35,3,13,22,16,19,0,12,10,32,41,14,1,42,35,0,9,34,17,14,15,38,17,13,40,48,27,38,41,8,14,25,11,27,47,2,20,22,39,4,28,29,43,29,21,1,4,4,10,46,43,50,33,34,12,47,32,13,8,47,22,23,21,33,24,43,35,19,39,24};
		circularArrayRotation(x, k, y);*/
		//saveThePrisoner(5,2,1);
		// miniMaxSum(arr);
		// birthdayCakeCandles(arr);
		// migratoryBirds(b);
		// System.out.println(dayOfProgrammer(2100));
		// System.out.println(pageCount(6, 5));
		//int ar[][] = { { 4, 8, 2 }, { 4, 5, 7 }, { 6, 1, 6 } };
		// formingMagicSquare(ar);
		
		scanner.close();

	}
}
