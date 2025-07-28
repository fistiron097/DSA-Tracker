import java.util.*;
public class Classroom1 {

    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();
         
        public void add(int data){
            // add at last idx
            arr.add(data);
            // child idx
            int x = arr.size()-1;
            int par = (x-1)/2; // par index

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x,arr.get(par));
                arr.set(par,temp);

              x = par;
              par = (x-1) / 2;
            }

        }

        public int peek(){
            return arr.get(0);
        }


        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            // left ka index ayega for null we are cheching whether it is a valid index that's why we write maximum size of arraylist index 
            if(left < arr.size() && arr.get(minIdx) > arr.get(left)){
                minIdx = left;
            }

            if(right < arr.size() && arr.get(minIdx) > arr.get(right)){
                minIdx = right;
            }
            if(minIdx != i){
                // swap
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);

                heapify(minIdx);
            }
        }
        public int remove(){
            int data = arr.get(0);
            // step-1 swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            // step 2 - delete last 
            arr.remove(arr.size()-1);

            // step 3 - heapify 
            heapify(0);
            return data;
        } 
    }

    public static void heapify(int []arr, int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

            // left ka index ayega for null we are cheching whether it is a valid index that's why we write maximum size of arraylist index 
         if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
          }

        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }
        if(maxIdx != i){
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr,maxIdx, size);
        }
    }

    public static void heapSort(int []arr){
        // step 1 - build maxHeap
        int n = arr.length;
        for(int i = n/2; i>=0; i--){ // looping until last level 
            heapify(arr, i, n);
        }
        // step 2 - push largest at end 
        for(int i = n-1; i>0;i--){
            // swap
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i);
        }
    }
    public static void main(String[]args){
        int []arr = {1,2,4,5,3};
        heapSort(arr);
        System.out.println("Sorted Array:");
        for (int num : arr) {
        System.out.print(num + " ");
        }
    }
}
