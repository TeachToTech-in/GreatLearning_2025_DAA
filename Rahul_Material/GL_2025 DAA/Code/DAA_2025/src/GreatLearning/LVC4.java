package GreatLearning;

import java.util.ArrayList;
import java.util.Collections;

public class LVC4 {
	static void countSort(ArrayList<Integer> arr) {
		int max = Collections.max(arr);
		ArrayList<Integer> counter = new ArrayList<>(max+1);
		for(int i=0;i<=max;i++)
			counter.add(0);
		System.out.println(counter);
		for(int i =0 ;i<arr.size();i++)
			counter.set(arr.get(i),counter.get(arr.get(i))+1);
		System.out.println(counter);
		int j=0;
		for(int i =0 ;i<counter.size();)
		{ 
			if(counter.get(i)==0)
			{
				i++;
				continue;
			}
			counter.set(i, counter.get(i)-1);
			arr.set(j++,i);
		}
			
	}
	
	static void insertInSorted(ArrayList<Integer> arr, int item) {
			int i = arr.size()-1;
			arr.add(0);
			while(i>=0 && item < arr.get(i))
			{ 
				arr.set(i+1, arr.get(i));
				i--;
			}
			arr.set(i+1, item);
			
			
	}
	
	static void insertInSorted1(ArrayList<Integer> arr, int size) {
		int i = size-1;
		int item = arr.get(size);
		while(i>=0 && item < arr.get(i))
		{ 
			arr.set(i+1, arr.get(i));
			i--;
		}
		arr.set(i+1, item);
		
		
}
	
	static void insertionSort(ArrayList <Integer>arr)
	{
		int i=1;
		while(i<arr.size()) {
			insertInSorted1(arr,i);
			System.out.println(arr);
			i++;
		}
		
	}

	public static void main(String args[]) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(9);
        arr.add(5);
        arr.add(12);
        arr.add(6);
        arr.add(1);
       System.out.println(arr);
        insertionSort(arr);
        //countSort(arr);
      System.out.println(arr);
      //to find Number Of Digits in Decimal Number
      //int i = (int) (Math.log10(3345)+1);
      //System.out.println(i);
      
    }
}
