package task2;

import java.util.*;

public class Main {
    private static final Integer[] numbers = new Integer[]{null,3,4,2,7,3,6,null};
    private static final int sum=10;

    public static void main(String[] args) {
        findNumbersForSum(numbers, sum);
    }

    public static void findNumbersForSum(Integer[] numbers, int sum){
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer numb: getFilteredNumbers(numbers)) {
            map.put(numb.hashCode(), numb);
            if (map.containsValue(sum - numb)) {
                System.out.println("["+numb+", "+(sum-numb)+"]");
                break;
            }
        }
    }

    private static Integer[] getFilteredNumbers(Integer[] numbers){
        if (Objects.nonNull(numbers)){
            return Arrays.stream(numbers).filter(Objects::nonNull).toArray(Integer[]::new);
        } else {
            return new Integer[]{};
        }
    }

}