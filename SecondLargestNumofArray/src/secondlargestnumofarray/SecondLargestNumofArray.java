package secondlargestnumofarray;

public class SecondLargestNumofArray {

    public static void main(String[] args) {
        int arr[] = new int[]{20,2,300,25,100,500};
        int max = arr[0];
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                
            }
           
        }
        System.out.println("Second Largest value from given array :" + arr[arr.length-2]);
    }
}
