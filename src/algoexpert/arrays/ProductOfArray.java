package algoexpert.arrays;

public class ProductOfArray {

    public int[] arrayOfProducts(int[] array) {
        int n = array.length;
        int[] prefixProduct = new int[n];
        prefixProduct[0] = 1;

        for (int i = 1; i < n; i++)
            prefixProduct[i] = prefixProduct[i - 1] * array[i - 1];

        int[] result = new int[n];
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = prefixProduct[i] * suffixProduct;
            suffixProduct *= array[i];
        }
        return result;
    }
}
