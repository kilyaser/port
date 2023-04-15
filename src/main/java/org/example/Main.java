package org.example;

public class Main {
    public static void main(String[] args) {
        String[] data = {"1,3-6", "2", "3-5"};
        Port port = new Port(data);
        System.out.println(PortParserUtil.getOrderedUniqListIndex(PortParserUtil.getIndexCombine(port.getIndexes())));

    }

}