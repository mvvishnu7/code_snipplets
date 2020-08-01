package mv.workspace.snipplets.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class MinimumHeightTrees {

    public static void main(String[] args) {
        System.out.println(new MinimumHeightTrees()
                .findMinHeightTrees(4, new int[][]
                                {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}}
//                        {{0, 1}, {0, 2}, {0, 3}, {3, 4}, {4, 5}}
                ));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (Objects.isNull(edges) || edges.length == 0) return List.of(0);

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] e : edges) {
            List<Integer> edges0 = map.getOrDefault(e[0], new ArrayList<>());
            List<Integer> edges1 = map.getOrDefault(e[1], new ArrayList<>());

            edges0.add(e[1]);
            edges1.add(e[0]);

            map.put(e[0], edges0);
            map.put(e[1], edges1);
        }
        List<Integer> list = map.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return chop(map, list);
    }

    private List<Integer> chop(Map<Integer, List<Integer>> map, List<Integer> leaves) {
        if (map.size() <= 2) return new ArrayList<>(map.keySet());
        List<Integer> list = new ArrayList<>();
        for (Integer leaf : leaves) {
            Integer neighbor = map.get(leaf).get(0);
            map.get(neighbor).remove(leaf);
            if (map.get(neighbor).size() == 1) list.add(neighbor);
            map.remove(leaf);
        }
        return chop(map, list);
    }
}


