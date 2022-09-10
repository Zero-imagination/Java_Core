package task2;

import java.util.*;

public class Main {
    private static final Integer[] numbers = new Integer[]{3,4,2,7,3,6,null};
    private static final int sum=10;

    public static void main(String[] args) {
        findNumbersForSum(numbers, sum);
    }
    public static void findNumbersForSum(Integer[] numbers, int sum){
        if (!Objects.nonNull(numbers)) System.out.println("Input array is null");
        else {
            Map<Integer,Integer> map = new HashMap<>();
            Arrays.stream(numbers)
                    .filter(Objects::nonNull)
                    .forEach((number)->map.put(number.hashCode(), number));
            for (Integer numb: numbers) {
                if (map.containsValue(sum - numb)) {
                    System.out.println("["+numb+", "+(sum-numb)+"]");
                    break;
                }
            }
        }
    }

}