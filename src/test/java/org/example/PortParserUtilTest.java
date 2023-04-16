package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PortParserUtilTest {

    @Test
    public void getIndexCombineTest() {
        String[] inputData =  {"1-5,7,9-11"};
        String[] inputData2 = {"1,3-6", "2", "3-5"};

        List<List<Integer>> expected = new ArrayList<>(Collections.singleton(Arrays.asList(1, 2, 3, 4, 5, 7, 9, 10, 11)));

        List<List<Integer>> expected2 = new ArrayList<>(Collections.singleton(Arrays.asList(1, 3, 4, 5, 6)));
        expected2.addAll(Collections.singleton(Arrays.asList(2)));
        expected2.addAll(Collections.singleton(Arrays.asList(3, 4, 5)));

        List<List<Integer>> result = PortParserUtil.getIndexCombine(inputData);
        List<List<Integer>> result2 = PortParserUtil.getIndexCombine(inputData2);

        Assertions.assertIterableEquals(expected, result);
        Assertions.assertIterableEquals(expected2, result2);
    }

    @Test
    public void getOrderedUniqListIndexTest() {
        String[] inputData = {"1,3-5", "2", "3-4"};

//      [[1, 2, 3], [1, 2, 4], [3, 2, 3], [3, 2, 4], [4, 2, 3], [4, 2, 4], [5, 2, 3], [5, 2, 4]]
        List<List<Integer>> expected = new ArrayList<>(Collections.singleton(Arrays.asList(1, 2, 3)));
        expected.addAll(Collections.singleton(Arrays.asList(1, 2, 4)));
        expected.addAll(Collections.singleton(Arrays.asList(3, 2, 3)));
        expected.addAll(Collections.singleton(Arrays.asList(3, 2, 4)));
        expected.addAll(Collections.singleton(Arrays.asList(4, 2, 3)));
        expected.addAll(Collections.singleton(Arrays.asList(4, 2, 4)));
        expected.addAll(Collections.singleton(Arrays.asList(5, 2, 3)));
        expected.addAll(Collections.singleton(Arrays.asList(5, 2, 4)));

        List<List<Integer>> result = PortParserUtil.getOrderedUniqListIndex(PortParserUtil.getIndexCombine(inputData));

        Assertions.assertIterableEquals(expected, result);
    }
}
