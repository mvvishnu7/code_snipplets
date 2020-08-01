package mv.workspace.snipplets.random;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayBitOperation {
    private static Integer resultState;

    public static void main(String[] args) {
        int startIndex = 32;
        int endIndex = 63;
        List<Integer> list = IntStream.of(53, 60, 38, 45, 47, 55)
//                .range(startIndex, endIndex)
                .boxed()
                .collect(Collectors.toList());
//
        doBitwiseAnd(list);
    }

    private static void doBitwiseAnd(List<Integer> list) {
        Integer result = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            result = result & list.get(i);
        }

        if (!result.equals(resultState)) {
            resultState = result;
            System.out.println(list);
            System.out.println("result: " + result);
        }
    }
}

//        [53, 60, 38, 45, 47, 55]
//        result: 36
//        [49, 48, 55, 36, 37, 58]
//        result: 32
//        [61, 59, 57, 54, 49, 51]
//        result: 48
//        [41, 55, 50, 60, 59, 37]
//        result: 32
//        [34, 39, 35, 38, 50, 43]
//        result: 34
//        [42, 44, 39, 56, 33, 53]
//        result: 32
//        [61, 40, 41, 59, 62, 58]
//        result: 40
