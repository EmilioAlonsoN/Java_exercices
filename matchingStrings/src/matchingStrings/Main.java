package matchingStrings;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<String> strings = Arrays.asList("aba", "baba", "aba", "xzxb");
        List<String> queries = Arrays.asList("aba", "xzxb", "ab");
        matchingStrings(strings, queries);
    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {

        List<Integer> result = new ArrayList<>(queries.size());

        for (String query : queries) {

            int count = 0;

            for (String string : strings) {

                System.out.println(" ");
                System.out.println(query);
                System.out.println(string);

                Boolean compare = query.equals(string);
                System.out.println(compare);

                if (compare) {
                    count++;
                    System.out.println(count);
                }
            }
            result.add(count);
        }
        System.out.println(result);
        return result;
    }

}
