package 排序;

/**
 * 时间复杂度
 *      最坏，平均 O(n^2)
 *      最好O(n)
 *
 * 空间复杂度
 *      O(1);
 *
 * 稳定性
 *      看判断方式，< 稳定  <= 不稳定
 */

public class PX_冒泡排序 {
    public static void main(String[] args) {

        int[] arr = {3,2,1,5,6,4};//{5,6,74,3,23,5665,322,2};

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

    static void maopao(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[j - 1]) {
                    arr[j] = arr[j] + arr[j-1];
                    arr[j-1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j-1];
                }
            }
        }

        System.out.println(ArrayPrint.printlnArr(arr));
    }

    static void mmaopao1(int[] arr, int length) {

        for (int end = length - 1; end > 0; end++) {
            for (int begin = 0; begin < length; begin++) {
                if (arr[begin] > arr[begin + 1]) {
                    arr[begin] = arr[begin] + arr[begin-1];
                    arr[begin-1] = arr[begin] - arr[begin - 1];
                    arr[begin] = arr[begin] - arr[begin-1];
                }
            }
        }
    }

    /**
     * 冒泡优化1：如果序列已经有序，可以提前终止排序
     * @param arr 前面
     * @param length 1
     */
    static void maopaoyouhua(int[] arr, int length) {

        for (int i = length - 1; i > 0; i--) {
            boolean sorted = true;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j - 1]) {
                    arr[j] = arr[j] + arr[j-1];
                    arr[j-1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j-1];
                    sorted = false;
                }
            }
            if (sorted) break;
        }
    }

    /**
     * 优化2 ： 记录最后交换的位置，减少无意义比较
     * @param arr 尾部局部有序，可以不比较
     * @param length
     */
    static void maopaoyouhua2(int[] arr, int length) {
        for (int i = length - 1; i > 0; i--) {
            int index = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j - 1]) {
                    arr[j] = arr[j] + arr[j-1];
                    arr[j-1] = arr[j] - arr[j - 1];
                    arr[j] = arr[j] - arr[j-1];
                    index = j + 1;
                }
            }
            i = index;
        }
    }

    static void swap(int a , int b) {

    }
}
