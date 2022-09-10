package task3;

import java.util.Objects;

public class Main {
    private static String[][] inputData = new String[][]{
            {"car","ca6$$#_rtwheel"}, // true
            {"cwhl", "cartwheel"}, // true
            {"cwhee", "cartwheel"}, // true
            {"cartwheel", "cartwheel"}, // true
            {"cwheeel", "cartwheel"}, // false
            {"lw", "cartwheel"}, // false
            {null, "car"} // false
    };
    public static void main(String[] args) {
        if (Objects.nonNull(inputData))
            for (String[] input: inputData) System.out.println(fuzzySearch(input[0],input[1]));
    }
    public static boolean fuzzySearch(String target, String stringData){
        if (!Objects.nonNull(target)||!Objects.nonNull(stringData)) return false;
        String[] charsTarget=target.split("");
        int prevPosition = 0;
        StringBuilder localStringData = new StringBuilder(stringData);
        for (String character: charsTarget) {
            if(localStringData.toString().contains(character) &&
                    stringData.indexOf(character)>=prevPosition){
                localStringData.deleteCharAt(localStringData.indexOf(character));
                prevPosition=stringData.indexOf(character);
            } else return false;
        }
        return true;
    }
}