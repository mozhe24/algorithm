import java.util.Arrays;

public class algorithm {
    //冒泡排序  时间复杂度（O（n*n））
    public static void bubble_sort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    //冒泡改进1：每一趟排序正向反向各找到最大最小值，可几乎减少排序趟数的一半
    public static void bubble_sort_1(int[] a) {
        int low = 0;
        int high = a.length - 1;
        int tmp, j;
        while (low < high) {
            //正向冒泡找到最大的
            for (j = low; j < high; j++) {
                if (a[j] > a[j + 1]) {
                    tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
            --high;

            //反向冒泡找到最小的
            for (j = high; j > low; j--) {
                if (a[j] < a[j - 1]) {
                    tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
            ++low;
        }
    }

    //冒泡改进2：设置一个标志性变量，用于记录每趟排序中最后一次进行交换的位置，由于pos位置之后的记录均已交换到位，故在进行下一次排序时只要扫描到POS的位置即可。
    public static void bubble_sort_2(int[] a) {

        boolean needNextPass = true;
        for (int i = 1; i < a.length && needNextPass; i++) {
            needNextPass = false;
            for (int j = 0; j < a.length - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    needNextPass = true;
                }
            }
        }
    }

    //选择排序 时间复杂度（O（n*n））
    public static void selectSort(int array[]) {
        for (int i = 0; i < array.length - 1; i++) {
            int k = i;//k存放最小值下标，每次循环最小值的下标+1
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[k]) {
                    k = j;
                }
            }
            //在内存循环结束后，也就是找到了本轮循环的最小数以后，再进行交换
            if (i != k) {
                int temp = array[i];
                array[i] = array[k];
                array[k] = temp;
            }
        }

    }

    //插入排序 时间复杂度（O（n*n））
    public static void insert_sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            //从头部开始第一个当做已经排好序的，依次把后面的一个一个地插入到已经排好序的列表中去
            int j;
            int x = a[i];//x为待插入元素
            for (j = i; j > 0 && x < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = x;//插入
        }
    }

    //递归实现 快速排序 O(NlogN)
    public static void quick_sort(int[] a, int low, int high) {
        int i, j, index;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        index = a[i];
        while (i < j) {
            //从右向左查找比index小的放到index的左边
            while (i < j && a[j] >= index)
                j--;
            if (i < j) {
                a[i++] = a[j];
            }
            //从左向右查找比index大的放到index的右边
            while (i < j && a[i] < index)
                i++;
            if (i < j) {
                a[j--] = a[i];
            }
            a[i] = index;
            quick_sort(a, low, i - 1);//对低子表进行递归排序
            quick_sort(a, i + 1, high);//对高子表进行递归排序

        }

    }

    public static void quick_sort_start(int a[]) {
        quick_sort(a, 0, a.length - 1);
    }

    //归并排序 O(NlogN)
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];

        int i = low;
        int j = mid + 1;
        int k = 0;
        //把较小的数先移动到新数组中
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
            //把左边剩余的数移入到数组中
            while (i <= mid) {
                temp[k++] = a[i++];
            }

            //把右边剩余的数移入到数组中
            while (j <= high) {
                temp[k++] = a[j++];
            }

            //把新数组中的数覆盖到a数组中
            for (int x = 0; x < temp.length; x++) {
                a[x + low] = temp[x];
            }

    }

    public static void mergeSort(int[] a, int low, int high) {
        int mid = low + (high - low) / 2;
        if (low < high) {
            //左边归并排序
            mergeSort(a, low, mid);
            //右边归并排序
            mergeSort(a, mid + 1, high);

            merge(a, low, mid, high);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] a = {5,3,7,4,2,90,49,0,8};
       // bubble_sort(a);
        //bubble_sort_1(a);
        //bubble_sort_2(a);
        //selectSort(a);
        //insert_sort(a);
        quick_sort_start(a);
       //mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果: " + Arrays.toString(a));
    }
}
