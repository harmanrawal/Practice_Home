import java.util.HashMap;
import java.util.*;

public class Sorting {

	public static void main(String args[]) {
		List<String> s = new ArrayList<String>();
		s.add("1 2");
		s.add("1 4");
		System.out.println(connectedSum(4, s));
	}

	static int[] selectionSort(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
			printArray(arr);
		}
		return arr;
	}

	static void bubbleSort(int a[]) {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - 1 - i; j++) {
				if (a[j] > a[j + 1]) {
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			printArray(a);
		}
	}

	static void insertionSort(int a[]) {
		for (int i = 1; i < a.length; i++) {
			int num = a[i];
			int j;
			for (j = i - 1; j >= 0 && a[j] > num; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = num;
			printArray(a);
		}

	}
	
	static void mergeSort(int a[], int temp[], int leftStart , int rightEnd)
	{
		if(leftStart >= rightEnd)
			return;
		int mid = (leftStart+rightEnd)/2;
		mergeSort(a, temp, leftStart, mid);
		mergeSort(a, temp, mid+1, rightEnd);
		mergeHalves(a, temp, leftStart, rightEnd);
	}
	
	static void mergeHalves(int a[], int temp[], int leftStart , int rightEnd)
	{
		int index=leftStart;
		int left=leftStart;
		int leftEnd=(leftStart+rightEnd)/2;
		int right=leftEnd+1;
		
		while(left<=leftEnd && right<=rightEnd)
		{
			if(a[left]<a[right])
			{
				temp[index] = a[left];
				left++;
			}
			else
			{
				temp[index] = a[right];
				right++;
			}
			index++;
		}
		System.arraycopy(a, left, temp, index, leftEnd-left+1);
		System.arraycopy(a, right, temp, index, rightEnd-right+1);
		printArray(temp);
		System.arraycopy(temp, leftStart, a, leftStart, rightEnd-leftStart+1);
	}

	static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	 public static int connectedSum(int n, List<String> edges) {
	        
		 Set<Integer> unique_edge = new HashSet<Integer>();
		 int sum=0, element_count=0;
		 int counter=0;
		
		 for(String a : edges)
		 {
			 int num1 =  Integer.parseInt(a.split(" ")[0]);
			 int num2 =  Integer.parseInt(a.split(" ")[1]);
			 if(unique_edge.contains(num1) || unique_edge.contains(num2) || counter == 0)
			 {
				 unique_edge.add(num1);
				 unique_edge.add(num2);
				 counter = 1;
			 }
			 else
			 {
				 counter = 0;
				 sum = sum + (int)Math.ceil(Math.sqrt(unique_edge.size()));
				 element_count+= unique_edge.size();
				 unique_edge = new HashSet<Integer>();
			 }
		 }
		 sum = sum + (int)Math.ceil(Math.sqrt(unique_edge.size()));
		 element_count+= unique_edge.size();		 
		 int left_overs = n - element_count;
		 
		 return (sum+left_overs);
	    }

}
