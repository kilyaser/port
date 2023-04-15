package org.example;

/** The Port class contains an array of strings.
 *  An array of strings can be set only when creating a class object */
public class Port {
    private String[] indexes;

    /** Constructor of a class with one argument
     * @param indexes is an array of strings */
    public Port(String[] indexes) {
        this.indexes = indexes;
    }

    /** @return an array of strings */
    public String[] getIndexes() {
        return indexes;
    }
}
