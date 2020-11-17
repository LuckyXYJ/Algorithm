package 排序;

public class PX_选择 {
    public static void main(String[] args) {

        int[] arr = {5,6,74,3,23,5665,322,2};

        selectSort2(arr,arr.length);
    }

    static void selectSort(int[] arr, int length){
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[i] > arr[j]){
                    arr[i] = arr[i] + arr[j];
                    arr[j] = arr[i] - arr[j];
                    arr[i] = arr[i] - arr[j];
                }
            }
        }
        System.out.println(ArrayPrint.printlnArr(arr));
    }

    static void selectSort2(int[] arr, int length){
        for (int i = 0; i < length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            if (i == minIndex) continue;

            arr[i] = arr[i] + arr[minIndex];
            arr[minIndex] = arr[i] - arr[minIndex];
            arr[i] = arr[i] - arr[minIndex];
        }
        System.out.println(ArrayPrint.printlnArr(arr));
    }
}
