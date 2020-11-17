package 排序;

public class PX_冒泡排序 {
    public static void main(String[] args) {

        int[] arr = {5,6,74,3,23,5665,322,2};

        bublleSort(arr,arr.length);
    }

    static void bublleSort(int[] arr, int length){
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
        System.out.println(ArrayPrint.printlnArr(arr));
    }
}
