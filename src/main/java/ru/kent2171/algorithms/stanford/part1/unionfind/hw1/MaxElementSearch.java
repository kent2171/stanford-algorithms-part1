package ru.kent2171.algorithms.stanford.part1.unionfind.hw1;

import java.util.Arrays;

import ru.kent2171.algorithms.stanford.part1.unionfind.UnionFindApi;

public class MaxElementSearch implements UnionFindApi {

    private int[] id;
    private int[] sz;
    private int[] max;
    private int count;

    public MaxElementSearch(int n) {
        this.id = new int[n];
        this.max = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
            max[i] = i;
        }

        this.sz = new int[n];
        Arrays.fill(sz, 1);
        this.count = n;
    }

    private int root(int i) {
        while (i != id[i]) {
            // path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    //@Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) {
            return;
        }

        if (sz[rootP] >= sz[rootQ]) {
            id[rootQ] = rootP;
            sz[rootP] += sz[rootQ];
        } else {
            id[rootP] = rootQ;
            sz[rootQ] += sz[rootP];
        }

        if (max[rootP] >= max[rootQ]) {
            max[rootQ] = max[rootP];
        } else {
            max[rootP] = max[rootQ];
        }

        count--;
    }

    //@Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    //@Override
    public int find(int i) {
        return max[root(i)];
    }

    //@Override
    public int count() {
        return 0;
    }
}
