package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Utility class for working with the indexes variable {@link org.example.Port} object */
public class PortParserUtil {
    private static final String COMMA_SPLITERATOR = ",";
    private static final String DASH_SPLITERATOR = "-";

    /** Return list of sequences of numbers
     * @param indexes is array of strings
     * @return list of sequences of numbers */
    public static List<List<Integer>> getIndexCombine(String[] indexes) {
        List<List<Integer>> combine = new ArrayList<>();

        for (String index : indexes) {
            List<Integer> tmp = new ArrayList<>();
            String[] splintered = index.split(COMMA_SPLITERATOR);

            for (String string : splintered) {
                if (string.contains(DASH_SPLITERATOR)) {
                    String[] range = string.split(DASH_SPLITERATOR);
                    List<Integer> intRange = IntStream.rangeClosed(Integer.parseInt(range[0]), Integer.parseInt(range[1])).boxed().collect(Collectors.toList());
                    tmp.addAll(intRange);
                } else {
                    tmp.add(Integer.parseInt(string));
                }
            }
            combine.add(tmp);
        }
        System.out.println(combine);
        return combine;
    }

    /** Return all possible unique ordered groups
     * @param indexes the result of the method {@link org.example.PortParserUtil#getIndexCombine(String[])}
     * @return all possible unique ordered groups */
    public static List<List<Integer>> getOrderedUniqListIndex(List<List<Integer>> indexes) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpRest = new ArrayList<>();
        filResult(result, tmpRest, indexes, 0);
        return result;
    }

    /** Used by the method {@link org.example.PortParserUtil#getOrderedUniqListIndex(List)}
     * for recursive filling unique ordered groups of elements of arrays of numbers */
    private static void filResult(List<List<Integer>> result, List<Integer> tmpRes, List<List<Integer>> indexes, int indexesLayer) {
        int indexesSize = indexes.size() - 1;
        if (indexesLayer != indexesSize) {
            List<Integer> subList = indexes.get(indexesLayer);
            List<Integer> copyOfTmpRes = new ArrayList<>(tmpRes);
            for (int i = 0; i < subList.size(); i++) {
                tmpRes.add(subList.get(i));
                filResult(result, tmpRes, indexes, indexesLayer + 1 );
                tmpRes = new ArrayList<>(copyOfTmpRes);
            }
        } else {
            List<Integer> lastSubList = indexes.get(indexesLayer);
            for (int i = 0; i < lastSubList.size(); i++) {
                List<Integer> copyOfTmpRes = new ArrayList<>(tmpRes);
                copyOfTmpRes.add(lastSubList.get(i));
                result.add(copyOfTmpRes);
            }
            tmpRes.clear();
        }
    }
}
