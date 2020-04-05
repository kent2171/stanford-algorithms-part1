package ru.kent2171.algorithms.stanford.part1.unionfind;

/**
 * lazy approach - each element has relation to it's parent until element is not links to itself (root of the tree);
 * <p>
 * 0   1   9   6   7   8
 * / \  |
 * 2  4  5
 * |
 * 3
 * <p>
 * characteristics:
 * - merge is a cheap operation, all you need is to change idx of one element to another (because of this algo is
 * named quick union);
 * -
 */
public class QuickUnion implements UnionFindApi {

    private final int id[];
    private int count;

    // N array accesses
    public QuickUnion(int n) {
        this.id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
        count = n;
    }

    // When we union two items into single component we always look for a root of the tree to prevent
    // tall trees. The worst case is when all items are connected into the same tree of N elements hight.
    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP != rootQ) {
            id[rootQ] = rootP;
            count--;
        }
    }

    // the worst case is 2N
    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public int count() {
        return count;
    }

    // the worst case is N
    private int root(int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }
}
