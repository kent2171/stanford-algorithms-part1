package ru.kent2171.algorithms.stanford.part1.unionfind;

public interface UnionFindApi {

    /**
     * Connects this to elements into a single component.
     */
    void union(int p, int q);

    /**
     * @return true in case when both items are connected with each other
     */
    boolean connected(int p, int q);

    /**
     * @return the idx of component, associated with the specified element
     */
    int find(int p);

    /**
     * @return the number of components
     */
    int count();
}
