package ru.kent2171.algorithms.stanford.part1.unionfind;

public abstract class AbstractUnionFindAlgo {

    private final int n;

    public AbstractUnionFindAlgo(int n) {
        this.n = n;
    }

    public abstract void union(int p, int q);

    public abstract boolean connected(int p, int q);

    public abstract int find(int p);

    public abstract int count();
}
