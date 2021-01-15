import static java.util.stream.IntStream.of;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.*;

public class HackerRankSolution {

	static int[] climbingLeaderboard(int[] scores, int[] alice) {
		scores = of(scores).distinct().toArray();
		int result[] = new int[alice.length];
		int index = scores.length - 1;
		for (int i = 0; i < alice.length; i++) {
			int marks = alice[i];
			int rank = 0;
			while (index >= 0) {
				if (marks >= scores[index])
					index--;
				else {
					rank = index + 2;
					break;
				}
			}
			if (index < 0)
				rank = 1;
			result[i] = rank;
		}
		return result;
	}

	static int[] permutationEquation(int[] p) {
		TreeMap<Integer, Integer> list = new TreeMap<Integer, Integer>();
		int[] results = new int[p.length];
		for (int i = 0; i < p.length; i++) {
			list.put(p[i], i + 1);
		}
		int x = 1;
		for (int i = 0; i < p.length; i++) {
			int pos = list.get(x);
			pos = list.get(pos);
			// System.out.println(pos);
			results[i] = pos;
		}
		return results;

	}

	public static int nonDivisibleSubset(int k, List<Integer> s) {

		List<Integer> mod = new ArrayList<Integer>();
		Set<Integer> result = new TreeSet<Integer>();
		for (int num : s) {
			mod.add(num % k);
		}
		for (int i = 0; i < s.size() - 1; i++) {
			for (int j = i + 1; j < s.size(); j++) {
				if (mod.get(i) + mod.get(j) == k) {
					result.add(s.get(i));
					result.add(s.get(j));
				}
			}
		}
		return result.size();
	}

	static String superReducedString(String s) {
		String op = "";
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			else
				map.put(s.charAt(i), 1);
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 != 0)
				op += entry.getKey();
		}
		// System.out.println(op);
		op = "";
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == s.charAt(i - 1)) {
				s = s.substring(0, i - 1) + s.substring(i + 1);
				i = 0;
			}
		}

		if (s.length() > 0)
			return s;
		else
			return "Empty String";
	}

	static int camelcase(String s) {
		int count = 1;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= 65 && s.charAt(i) <= 90)
				count++;
		}
		if (s.length() > 0)
			return count;
		else
			return 0;
	}

	static int minimumNumber(int n, String password) {
		int count = 0;
		int length_diff = 0;
		int digit = 1;
		int caps = 1;
		int smalls = 1;
		int spec = 1;
		length_diff = n - 6;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) >= '0' && password.charAt(i) <= '9' && digit == 1)
				digit = 0;
			if (password.charAt(i) >= 65 && password.charAt(i) <= 90 && caps == 1)
				caps = 0;
			if (password.charAt(i) >= 97 && password.charAt(i) <= 122 && smalls == 1)
				smalls = 0;
			if (spec == 1 && (password.charAt(i) == '!' || password.charAt(i) == '@' || password.charAt(i) == '#'
					|| password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '^'
					|| password.charAt(i) == '&' || password.charAt(i) == '*' || password.charAt(i) == '('
					|| password.charAt(i) == ')' || password.charAt(i) == '-' || password.charAt(i) == '+'))
				spec = 0;
		}
		if (Math.abs(length_diff) > (digit + caps + smalls + spec) && password.length() < 6)
			return length_diff;
		else
			return (digit + caps + smalls + spec);
	}

	static int alternate(String s) {
		int num_count[][] = new int[26][26];
		int pair[][] = new int[26][26];
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			int num = s.charAt(i) - 'a';

			for (int j = 0; j < 26; j++) {
				if (pair[num][j] == letter)
					num_count[num][j] = -1;

				if (num_count[num][j] != -1) {
					pair[num][j] = letter;
					num_count[num][j]++;
				}
			}

			for (int j = 0; j < 26; j++) {
				if (pair[j][num] == letter)
					num_count[j][num] = -1;

				if (num_count[j][num] != -1) {
					pair[j][num] = letter;
					num_count[j][num]++;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				// System.out.print(num_count[i][j]+" ");
				if (num_count[i][j] > max) {
					max = num_count[i][j];
				}
			}
			// System.out.println();
		}
		// System.out.println(max);
		if (s.length() == 1)
			return 0;

		return max;
	}

	static String caesarCipher(String s, int k) {

		String result = "";
		if (k > 26)
			k = k % 26;
		for (int i = 0; i < s.length(); i++) {

			char ch = s.charAt(i);
			if (ch >= 97 && ch <= 122) {
				ch += k;
				if (ch > 122)
					ch -= 26;
			}
			if (ch >= 65 && ch <= 90) {
				ch += k;
				if (ch > 90)
					ch -= 26;
			}
			result += ch;
		}
		// System.out.println(result);
		return result;
	}

	static int marsExploration(String s) {
		int count = 0;

		for (int i = 0; i < s.length() - 2; i += 3) {
			if (s.charAt(i) != 'S') {
				count++;
			}
			if (s.charAt(i + 1) != 'O') {
				count++;
			}
			if (s.charAt(i + 2) != 'S') {
				count++;
			}
		}

		// System.out.println(count);
		return count;

	}

	static String hackerrankInString(String s) {
		int current_pos = 0;
		String str = "hackerrank";
		boolean check = true;

		for (int i = 0; i < str.length(); i++) {
			// System.out.println(str.charAt(i)+" "+s.indexOf(str.charAt(i), current_pos));
			if (s.indexOf(str.charAt(i), current_pos) >= 0) {
				current_pos = s.indexOf(str.charAt(i), current_pos) + 1;
				// System.out.println(str.charAt(i)+" "+s.indexOf(str.charAt(i), current_pos));
			} else if (s.indexOf(str.charAt(i), current_pos) < 0) {
				check = false;
				break;
			}
		}
		// System.out.println(check);
		if (check)
			return "YES";
		else
			return "NO";
	}

	static String pangrams(String s) {

		boolean check = true;
		StringBuilder all_alph = new StringBuilder("00000000000000000000000000");
		s = s.toLowerCase();
		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i);
			ch -= 'a';
			if (ch >= 0 && all_alph.charAt(ch) != 1) {
				all_alph.setCharAt(ch, '1');
			}
		}
		System.out.println(all_alph);
		if (!all_alph.toString().contains("0"))
			return "YES";
		else
			return "NO";
	}

	static String[] weightedUniformStrings(String s, int[] queries) {
		String[] results = new String[queries.length];
		Set<Integer> sums = new HashSet<Integer>();
		int sum = 0;
		char ch = s.charAt(0);
		int count = 1;
		sums.add(s.charAt(0) - 96);
		for (int i = 1; i < s.length(); i++) {

			if (s.charAt(i) != ch) {
				count = 1;
				ch = s.charAt(i);
			} else {
				count++;
			}
			sum = count * (s.charAt(i) - 96);
			sums.add(sum);
		}
		// System.out.println(sums);
		for (int i = 0; i < queries.length; i++) {
			if (sums.contains(queries[i])) {
				results[i] = "Yes";
			} else {
				results[i] = "No";
			}
		}
		return results;
	}

	// Complete the separateNumbers function below.
	static void separateNumbers(String s) {
		long num = 0, next;
		int i = 0, length = 1;
		String last = s.substring(0, length), str = "";
		boolean check = true, found = false;
		while (check) {
			str = s.substring(i, i + length);
			next = Long.parseLong(str) + 1;
			// System.out.println(str + " "+next);
			if (length > s.length() / 2) {
				break;
			}
			if (String.valueOf(next).length() > str.length())
				length++;
			if (i + (str.length() + length) <= s.length()) {
				String next_str = s.substring(i + str.length(), i + (str.length() + length));
				if (next == Long.parseLong(next_str) && String.valueOf(next).equals(next_str)) {
					i = i + str.length();
					if (i + length >= s.length()) {
						check = false;
						found = true;
					}
				} else {
					if (String.valueOf(next).length() > str.length())
						length--;
					length++;
					i = 0;
					last = s.substring(i, length);
				}
			} else {
				break;
			}

		}
		if (found) {
			System.out.println("YES " + last);
		} else {
			System.out.println("NO");
		}

	}

	static String funnyString(String s) {

		StringBuilder st = new StringBuilder(s);
		String rev = String.valueOf(st.reverse());
		boolean check = true;
		for (int i = 0; i < s.length() - 1; i++) {
			int sum1 = Math.abs(s.charAt(i) - s.charAt(i + 1));
			int sum2 = Math.abs(rev.charAt(i) - rev.charAt(i + 1));
			if (sum1 != sum2) {
				check = false;
				break;
			}
		}
		if (check)
			return "Funny";
		else
			return "Not Funny";
	}

	static int gemstones(String[] arr) {
		String min = arr[0];
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() < min.length())
				min = arr[i];
		}

		for (int i = 0; i < min.length(); i++) {
			boolean char_check = true;
			for (int j = 0; j < arr.length; j++) {
				if (!arr[j].contains(String.valueOf(min.charAt(i)))) {
					char_check = false;
					break;
				}
			}
			if (char_check) {
				set.add(min.charAt(i));
			}
		}
		return set.size();
	}

	static int alternatingCharacters(String s) {
		int count = 0;
		char ch = s.charAt(0);
		for (int i = 1; i < s.length(); i++) {
			if (ch == s.charAt(i)) {
				count++;
			} else {
				ch = s.charAt(i);
			}
		}
		return count;
	}

	static int beautifulBinaryString(String b) {
		int count = 0;
		boolean check = true;
		while (check) {
			if (b.contains("010")) {
				count++;
				b = b.replaceFirst("010", "xyz");
			} else {
				check = false;
			}
		}
		System.out.println(count);
		return count;
	}

	static int theLoveLetterMystery(String s) {
		StringBuilder st = new StringBuilder(s);
		String rev = String.valueOf(st.reverse());
		int sum = 0;
		for (int i = 0; i < s.length() / 2; i++) {
			int diff = Math.abs(rev.charAt(i) - s.charAt(i));
			sum += diff;
		}
		return sum;
	}

	// Complete the palindromeIndex function below.
	static int palindromeIndex(String s) {
		int index = -1;
		StringBuilder st = new StringBuilder(s);
		String rev = String.valueOf(st.reverse());
		if (s.equals(rev))
			index = -1;
		else {
			for (int i = 0; i < s.length() / 2; i++) {
				if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
					String n1 = s.substring(0, i) + s.substring(i + 1);
					st = new StringBuilder(n1);
					String rev1 = String.valueOf(st.reverse());
					String n2 = s.substring(0, s.length() - 1 - i) + s.substring(s.length() - i);
					st = new StringBuilder(n2);
					String rev2 = String.valueOf(st.reverse());

					if (n1.equals(rev1)) {
						index = i;
						break;
					}

					if (n2.equals(rev2)) {
						index = s.length() - 1 - i;
						break;
					}
				}
			}

		}
		// System.out.println(index);
		return index;

	}

	static int anagram(String s) {

		if (s.length() % 2 != 0)
			return -1;
		else {
			int count = 0;
			String s1 = s.substring(0, s.length() / 2);
			String s2 = s.substring(s.length() / 2);
			// System.out.println(s1);
			// System.out.println(s2);
			for (int i = 0; i < s1.length(); i++) {
				if (!(s2.contains(String.valueOf(s1.charAt(i))))) {
					count++;
				} else {
					int index = s2.indexOf(s1.charAt(i));
					s2 = s2.substring(0, index) + s2.substring(index + 1);
					// System.out.println(s2);
				}
			}
			System.out.println(count);
			return count;
		}
	}

	static int makingAnagrams(String s1, String s2) {
		String check1 = "", check2 = "";
		if (s1.length() < s2.length()) {
			check1 = s1;
			check2 = s2;
		} else {
			check1 = s2;
			check2 = s1;
		}

		int count = 0;
		for (int i = 0; i < check1.length(); i++) {
			int index = check2.indexOf(check1.charAt(i));
			if (index >= 0) {
				count++;
				check2 = check2.substring(0, index) + check2.substring(index + 1);
			}
		}
		int total = s1.length() - count + s2.length() - count;
		// System.out.println(total);
		return total;
	}

	static String gameOfThrones(String s) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		System.out.println(map);
		boolean check = true;
		int a[] = evenOddMapValueCount(map);
		if (s.length() % 2 == 0 && a[1] > 0) {
			check = false;
		} else if (s.length() % 2 != 0 && a[1] > 1) {
			check = false;
		}
		if (check)
			return "YES";
		else
			return "NO";
	}

	static int[] evenOddMapValueCount(Map<Character, Integer> map) {
		int a[] = new int[2];
		a[0] = 0;
		a[1] = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				a[0]++;
			} else {
				a[1]++;
			}
		}
		return a;
	}

	static String twoStrings(String s1, String s2) {

		String check1 = "", check2 = "";
		if (s1.length() < s2.length()) {
			check1 = s1;
			check2 = s2;
		} else {
			check1 = s2;
			check2 = s1;
		}

		boolean check = false;
		for (int i = 0; i < check1.length(); i++) {
			int index = check2.indexOf(check1.charAt(i));
			if (index >= 0) {
				check = true;
				break;
			}
		}

		if (check)
			return "YES";
		else
			return "NO";
	}

	static String isValid(String s) {
		if(s.length()==1)
			return "YES";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
			} else {
				map.put(s.charAt(i), 1);
			}
		}
		Map<Integer, Integer> count_map = new HashMap<Integer, Integer>();
		System.out.println(map);
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (count_map.containsKey(entry.getValue())) {
				count_map.put(entry.getValue(), count_map.get(entry.getValue()) + 1);
			} else {
				count_map.put(entry.getValue(), 1);
			}
		}
		System.out.println(count_map);
		if (count_map.size() > 2)
			return "NO";
		else {
			boolean check_1 = false;
			if(count_map.size()==1)
				return "YES";
			if (!(count_map.containsValue(1)))
				return "NO";
			else {
				int even_key = 0,odd_key=0;
				int even_value = 0,odd_value=0;
				for (Entry<Integer, Integer> entry : count_map.entrySet()) {
					if(entry.getValue() == 1)
					{
						odd_key = entry.getKey();
						odd_value = entry.getValue();
						break;
					}
					if(entry.getValue() != 1)
					{
						even_key = entry.getKey();
						even_value = entry.getValue();
					}
				}
				//count_map.remove(odd_key);
				System.out.println(even_key);
				System.out.println(odd_key);
				if (Math.abs(even_key-odd_key) == 1) {
					return "YES";
				} else {
					return "NO";
				}
			}
		}
	}
	
    static int stringConstruction(String s) {
    	Set<String> set = new HashSet<String>();
    	for(int i=0;i<s.length();i++)
    	{
    		if(!set.contains(String.valueOf(s.charAt(i))))
    		{
    			set.add(String.valueOf(s.charAt(i)));
    		}
    		
    	}
    	System.out.println(set.size());
    	
    	
    	return set.size();
    }

    
    static String highestValuePalindrome(String s, int n, int k) {
    	
    	Set<Integer> set = new TreeSet<Integer>();
    	for(int i=0;i<n/2;i++)
    	{
    		int end = n-1-i,start=i;
    		if(s.charAt(start) != s.charAt(end))
    		{
    			String n1 = s.substring(0,start)+s.charAt(end)+s.substring(start+1);
    			int num1 = Integer.parseInt(n1);  
    			String n2 = s.substring(0,end)+s.charAt(start)+s.substring(end+1);
    			int num2 = Integer.parseInt(n2);
    			System.out.println(num1);
    			System.out.println(num2);
    			if(num1>num2)
    			{
    				s=n1;
    			}
    			else
    			{
    				s=n2;
    			}
    		}
    		System.out.println(s);
    	}

    	
    	return "";
    }
    
    static String encryption(String s) {
    	double num = Math.sqrt(s.length());
    	int rows,cols,end_pos=0,k=0;
    	rows = (int) Math.floor(num);
    	System.out.println(rows);
    	cols = (int) Math.ceil(num);
    	System.out.println(cols);
    	if(rows*cols<s.length())
    		rows++;
    	String splits[] = new String[rows];
    	String result = "";
    	for(int i=0;i<s.length();i+=cols)
    	{
    		if(i+cols>s.length())
    		{
    			end_pos=s.length();
    		}
    		else
    		{
    			end_pos=i+cols;
    		}
    		String ss = s.substring(i,end_pos);
    		splits[k] = ss;
    		k++;
    	}
    	for(int i=0;i<splits.length;i++)
    		System.out.println(splits[i]);
    	for(int i=0;i<cols;i++)
    	{
    		for(int j=0;j<rows;j++)
    		{
    			if(splits[j].length()<=i)
    				continue;
    			else
	    			result+=splits[j].charAt(i);
    		}
    		result+=" ";
    	}
    	System.out.println(result);
    	return result;
    }

    static String[] bigSorting(String[] unsorted) {
    	List<BigInteger> abi = new ArrayList<BigInteger>();
    	for(int i=0;i<unsorted.length;i++)
    	{
    		BigInteger bb = new BigInteger(unsorted[i]);
    		abi.add(bb);
    	}
    	System.out.println(abi);
    	String[] result= new String[abi.size()];
    	Collections.sort(abi);
    	int i=0;
    	for(BigInteger bi : abi)
		{
    		result[i]=bi.toString();
    		i++;
		}
    	return result;
    }
    
    static void insertionSort1(int n, int[] arr) {
    	int num = arr[arr.length-1];
    	boolean check=false;
//    	System.out.println(num);
    	for(int i=arr.length-2;i>=0;i--)
    	{
    		if(arr[i]>num)
    		{
    			arr[i+1] = arr[i];
    		}
    		else if(arr[i]<num)
    		{
    			arr[i+1] = num;
    			check=true;
    			break;
    		}
    		
    		for(int j=0;j<arr.length;j++)
    			System.out.print(arr[j]+" ");
    		System.out.println();
    	}
    	if(!check)
			arr[0]=num;
		
    	for(int j=0;j<arr.length;j++)
			System.out.print(arr[j]+" ");
		//System.out.println();
    }
    
    static void insertionSort2(int n, int[] arr) {
    	int num = arr[arr.length-1];
    	boolean check=false;
    	
//    	System.out.println(num);
    	for(int i=1;i<arr.length;i++)
    	{
    		int index=i;
    		for(int j=i-1;j>=0;j--)
    		{
    			if(i==j)
    				continue;
    			if(arr[j]>arr[index])
    			{
    				int temp=arr[j];
    				arr[j]=arr[j+1];
    				arr[j+1]=temp;
    				index--;
    			}
    		}
    		for(int j=0;j<arr.length;j++)
    			System.out.print(arr[j]+" ");
    		System.out.println();
    	}
		
		//System.out.println();
    }
    
    public static void insertionSort(int[] A){
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
            }
            A[j + 1] = value;
        }

        printArray(A);
    }


    static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println();
    }
    
    static int runningTime(int[] arr) {
    	int num = arr[arr.length-1];
    	boolean check=false;
    	int count=0;
//    	System.out.println(num);
    	for(int i=1;i<arr.length;i++)
    	{
    		int index=i;
    		for(int j=i-1;j>=0;j--)
    		{
    			if(i==j)
    				continue;
    			if(arr[j]>arr[index])
    			{
    				int temp=arr[j];
    				arr[j]=arr[j+1];
    				arr[j+1]=temp;
    				index--;
    				count++;
    			}
    		}
    		
    	}
		return count;
		//System.out.println();
    }
    
    static int[] quickSort(int[] arr) {
    	int result[] = new int[arr.length];
    	int pivot=arr[0],index=0;
    	List<Integer> small = new ArrayList<Integer>();
    	List<Integer> big = new ArrayList<Integer>();
    	for(int i=1;i<arr.length;i++)
    	{
    		if(arr[i]<pivot)
    		{
    			small.add(arr[i]);
    		}
    		else
    		{
    			big.add(arr[i]);
    		}
    	}
    	for(int i : small)
    	{
    		result[index]=i;
    		index++;
    	}
    	result[index]=pivot;
    	index++;
    	for(int i : big)
    	{
    		result[index]=i;
    		index++;
    	}
    	System.out.println(small);
    	System.out.println(pivot);
    	System.out.println(big);
    	return result;
    }
    
    static int[] countingSort(int[] arr) {
    	int result[] = new int[arr.length];
    	int count[] = new int[100];
    	for(int i=0;i<arr.length;i++)
    	{
    		count[arr[i]]++;
    	}
    	int index=0;
    	for(int i=0;i<100;i++)
    	{
    		for(int j=0;j<count[i];j++)
    		{
    			result[index]=i;
    			index++;
    		}
    	}
    	return result;
    }
    
    static void countSort(List<List<String>> arr) {
    	Map<Integer,ArrayList<String>> sorted = new TreeMap<Integer,ArrayList<String>>();
    	for(int i=0;i<arr.size();i++)
    	{
    		List<String> a = arr.get(i);
    		int list_index = Integer.parseInt(a.get(0));
    		String s = a.get(1);
    		if(i<arr.size()/2)
    			s="-";
    		if(sorted.containsKey(list_index))
    		{
    			sorted.get(list_index).add(s);
    		}
    		else
    		{
    			ArrayList<String> st = new ArrayList<String>();
    			st.add(s);
    			sorted.put(list_index, st);
    		}
    		
    	}
    	for(Entry<Integer, ArrayList<String>> entry : sorted.entrySet())
    	{
    		for(String s : entry.getValue())
    		{
    			System.out.print(s+" ");
    		}
    	}
    }
    
    static int[] icecreamParlor(int m, int[] arr) {

    	int op[] = new int[2];
    	for(int i=0;i<arr.length-1;i++)
    	{
    		for(int j=i+1;i<arr.length;j++)
    		{
    			if(arr[i]+arr[j] == m)
    			{
    				op[0]=i;
    				op[1]=j;
    				break;
    			}
    		}
    	}
    	return op;
    }
    
    static int[] missingNumbers(int[] arr, int[] brr) {
    	
    	Map<Integer,Integer> br_map = new TreeMap<Integer,Integer>();
    	for(int num : brr)
    	{
    		if(br_map.containsKey(num))
    		{
    			br_map.put(num, br_map.get(num)+1);
    		}
    		else
    		{
    			br_map.put(num, 1);
    		}
    	}
    	for(int num : arr)
    	{
    		if(br_map.get(num) == 1)
    			br_map.remove(num);
    		if(br_map.containsKey(num))
    		{
    			br_map.put(num, br_map.get(num)-1);
    		}
    		
    	}
    	int index=0;
    	int[] result = new int[br_map.size()];
    	for(Entry<Integer,Integer> entry : br_map.entrySet())
    	{
    		result[index]=entry.getKey();
    		index++;
    	}
    	
    	return result;
    }
    
    static int pairs(int k, int[] arr) {
    	int sum =0;
	    Set<Integer> set = new HashSet<Integer>();
	    for(int n=0; n< arr.length; n++)
	    {
	        set.add(arr[n]);
	    }
	    for(int n=0; n< arr.length; n++)
	    {
	        if(set.contains(arr[n]+k)){
	            sum+=1;
	        }
	    }
	    return sum;
    	
    }

    static String balancedSums(List<Integer> arr) {
    	boolean check=false;
    	int pivot = arr.get(0);
    	int sum1=0,sum2=0,pivot_index=0;
    	boolean pivot_pr=false;
    	for(int i=1;i<arr.size();i++)
    	{
    		sum1+=arr.get(i);
    	}
    	System.out.println(sum1);
    	while(!check)
    	{
    		if(sum1==sum2)
    		{
    			check = true;
    		}
    		else
    		{
    			if(pivot_index==arr.size()-1)
        			break;
    			sum2+=arr.get(pivot_index);
    			pivot_index++;
    			sum1-=arr.get(pivot_index);
    		}
    		
    	}
    	System.out.println(sum1);
    	System.out.println(sum2);
    	System.out.println(pivot_index);
    	System.out.println(arr.get(pivot_index));
    	System.out.println(check);
    	
    	if(check)
    		return "YES";
    	else
    		return "NO";

    }
    
    
    public static void main(String args[])
    {
    	int a[] = {1,5,3,4,2};
    	List<Integer> lsit = new ArrayList<Integer>();
    	//pairs(2,a);
    	lsit.add(1);
    	/*lsit.add(1);
    	lsit.add(4);
    	lsit.add(1);
    	lsit.add(1);*/
    	balancedSums(lsit);
    	
    }

}
