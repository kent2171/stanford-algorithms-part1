package ru.kent2171.algorithms.stanford.part1.unionfind;

public class QuickFind extends AbstractUnionFind {

    public QuickFind(int n) {
        super(n);
    }

    @Override
    public void union(int p, int q) {

    }

    @Override
    public boolean connected(int p, int q) {
        return false;
    }

    @Override
    public int find(int p) {
        return 0;
    }

    @Override
    public int count() {
        return 0;
    }
}
