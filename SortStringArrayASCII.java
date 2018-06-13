import java.util.Arrays;

public class SortStringArrayASCII{
	static String[] names = {"KRISHNA", "RAM", "HARI"};
	static String[] mainNames = Arrays.copyOf(names, names.length);
	static int[] asciiArray = new int[names.length];
	static int[] sortedAsciiArray = new int[names.length];

	public SortStringArrayASCII(){
		
	}
	public static void main(String[] args)throws Exception{
		int x = 0;
		// converting string into ASCII values
		for(String s: names){
			int sum = 0;
			for(int i=0; i<s.length(); i++){
				sum = sum + s.charAt(i);
			}
			asciiArray[x] = sum;
			x++;
		}

		System.out.println("##### BEFORE #####");
		printArrayASCII(names, asciiArray);
		
		sortedAsciiArray = Arrays.copyOf(asciiArray, asciiArray.length);
		sortArray(sortedAsciiArray);
		
		// Sorting names array
		for(int i=0; i<names.length; i++){
			int ind = indx(sortedAsciiArray[i]);
			names[i] = mainNames[ind];
		}

		System.out.println("##### AFTER #####");
		printArrayASCII(names, sortedAsciiArray);

	}
	private static int indx(int elem){
		for(int j=0; j<asciiArray.length; j++){
			if(elem == asciiArray[j]){
				return j;
			}
		}
		return -1;
	}
	private static void sortArray(int[] arr){
		int unchanged = 0;
		while(unchanged < arr.length-2){
			for(int i=0; i<arr.length-1; i++){
				int y = arr[i];
				if(arr[i] > arr[i+1]){
					int x = 0;
					x = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = x;
				}
				if(y == arr[i]){
					unchanged++;
				}
			}
		}
	}
	private static void printArrayASCII(String[] names, int[] asciiArr){
		System.out.println("name\t\t\tASCII\n_____________________");
		int x = 0;
		for(String name: names){
			System.out.println(names[x] + "\t\t\t" + asciiArr[x++]);
		}
		System.out.println("\n\n");
	}
}
