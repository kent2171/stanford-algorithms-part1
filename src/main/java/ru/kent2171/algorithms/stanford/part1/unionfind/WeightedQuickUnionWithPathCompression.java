package ru.kent2171.algorithms.stanford.part1.unionfind;

/**
 * The main purpose of this improvement is to avoid tall trees.
 * <p>
 * - keep track of the weight of each tree (number of elements in the tree);
 * - balance by linking root of smaller tree to root of larger tree;
 * - half a search path each time when calculating the root element by linking node to it's grand-parent;
 *
 */
public class WeightedQuickUnionWithPathCompression implements UnionFindApi {

    private final int id[];
    private final int sz[];

    public WeightedQuickUnionWithPathCompression(int n) {
        this.id = new int[n];
        this.sz = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        for (int i = 0; i < id.length; i++) {
            sz[i] = 1;
        }
    }

    @Override
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
    }

    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
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
