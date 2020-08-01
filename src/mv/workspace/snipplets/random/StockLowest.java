package mv.workspace.snipplets.random;

import java.util.*;
import java.util.stream.Collectors;

public class StockLowest {

    public static void main(String[] args) {
        System.out.println(predictAnswer(
                List.of(5, 6, 8, 4, 9, 10, 8, 3, 6, 4),
                List.of(3, 1, 8)
        ));

    }

    public static List<Integer> predictAnswer(List<Integer> stockData, List<Integer> queries) {
        List<Pair> smallerLeftElement = getSmallerLeftElement(stockData);
        List<Pair> smallerRightElement = getSmallerRightElement(stockData);

        return queries.stream()
                .map(q -> getLowestElement(smallerLeftElement, smallerRightElement, q - 1))
                .map(p -> p.index < 0 ? p.index : p.index + 1)
                .collect(Collectors.toList());
    }

    private static List<Pair> getSmallerLeftElement(List<Integer> array) {
        Stack<Pair> stack = new Stack<>();
        List<Pair> outList = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            createSmallerElementList(array, stack, outList, i);
        }

        return outList;
    }


    private static List<Pair> getSmallerRightElement(List<Integer> array) {
        Stack<Pair> stack = new Stack<>();
        List<Pair> outList = new ArrayList<>();


        for (int i = array.size() - 1; i >= 0; i--) {
            createSmallerElementList(array, stack, outList, i);
        }

        Collections.reverse(outList);

        return outList;
    }


    private static void createSmallerElementList(List<Integer> array, Stack<Pair> stack, List<Pair> outList, int x) {
        while (!stack.isEmpty() && stack.peek().stockValue.compareTo(array.get(x)) >= 0) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            outList.add(new Pair(-1, -1));
        } else {
            outList.add(stack.peek());
        }

        stack.push(new Pair(array.get(x), x));
    }

    private static Pair getLowestElement(List<Pair> leftArray, List<Pair> rightArray, int index) {
        if (leftArray.get(index).index != -1 && rightArray.get(index).index != -1) {
            Integer leftDistance = index - leftArray.get(index).index;
            Integer rightDistance = rightArray.get(index).index - index;
            if (leftDistance <= rightDistance) {
                return leftArray.get(index);
            }
            return rightArray.get(index);
        }

        if (leftArray.get(index).index == -1) {
            return rightArray.get(index);
        }
        return leftArray.get(index);
    }

    private static class Pair {
        public Integer stockValue;
        public Integer index;

        public Pair(Integer stockValue, Integer index) {
            this.stockValue = stockValue;
            this.index = index;
        }
    }
}
