package org.example;

public class Main {
    public static void main(String[] args) {
        String[] data = {"1,3-5", "2", "3-4"};
        String[] inputData = {"1,3-6", "2-4", "3-5"};
        String[] inputData2 = {"1,3-6", "2-4", "3-5", "7,9"};
        Port port = new Port(data);

        System.out.println(PortParserUtil.getOrderedUniqListIndex(PortParserUtil.getIndexCombine(port.getIndexes())));
        System.out.println(PortParserUtil.getOrderedUniqListIndex(PortParserUtil.getIndexCombine(inputData)));
        System.out.println(PortParserUtil.getOrderedUniqListIndex(PortParserUtil.getIndexCombine(inputData2)));

    }

}