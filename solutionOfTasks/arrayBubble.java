class ArrayBubble {
    public static void main(String[] args) {
        int arr[] = {3, 56, 7, 11, -5, 77, -9, 2, 91};
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tempt = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tempt;
                }
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}