package task2;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{5,6,3,2,5,1,4,9};
        quickSortTripleDivision(array,0, array.length-1);
        for (int a:array) {
            System.out.print(a+" ");
        }
    }
    public static void swap(int[] source, int leftMarker, int rightMarker){
        int tmp = source[leftMarker];
        source[leftMarker] = source[rightMarker];
        source[rightMarker] = tmp;
    }
    public static void quickSortTripleDivision(int[] a, int leftBorder, int rightBorder){
        int v=a[rightBorder];
        if (rightBorder<=leftBorder) return;
        int i=leftBorder;
        int j=rightBorder-1;
        int p=leftBorder-1;
        int q=rightBorder;
        while (i<=j){
            while (a[i]<v)
                i++;
            while (a[j]>v)
                j--;
            if (i>=j) break;
            swap(a,i,j);
            if (a[i]==v) {
                p++;
                swap(a,p,i);
            }
            i++;
            if (a[j]==v){
                q--;
                swap(a,q,j);
            }
            j--;
        }
        swap(a,i,rightBorder);
        j=i-1;
        i++;
        for (int k=leftBorder;k<=p;k++, j--)
            swap(a,k,j);
        for (int k=rightBorder-1;k>=q;k--,i++)
            swap(a,k,i);
        quickSortTripleDivision(a,leftBorder,j);
        quickSortTripleDivision(a,i,rightBorder);
    }
}
