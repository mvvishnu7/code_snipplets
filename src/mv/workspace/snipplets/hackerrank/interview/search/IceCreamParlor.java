package mv.workspace.snipplets.hackerrank.interview.search;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
 */
public class IceCreamParlor {

    public static void main(String[] args) {
        int money = 4;
        int[] cost = new int[]{2, 2, 4, 3};
        whatFlavors(cost, money);
    }

    private static void whatFlavors(int[] cost, int money) {
        Map<Integer, Integer> lookUp = new HashMap<>();

        for (int i = 0; i < cost.length; i++) {
            int current = cost[i];

            int needed = money - current;
            Integer neededIndex = lookUp.get(needed);
            if (neededIndex != null) {
                System.out.println((neededIndex + 1) + " " + (i + 1));
                break;
            }

            if (!lookUp.containsKey(current)) {
                lookUp.put(current, i);
            }
        }
    }
}
