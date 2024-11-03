package sorting;

public class SelectionSort {

    int select(int arr[], int i) {
        int min = i;
        for (; i < arr.length; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }

        }
        return min;

    }

    void selectionSort(int arr[], int n) {

        for (int i = 0; i < arr.length; i++) {
            int min = select(arr, i);
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

    }
}
