package ru.kent2171.algorithms.stanford.part1.unionfind;

public class EagerQuickFind extends AbstractUnionFind {

    private final int id[];

    // constructor n array accesses
    public EagerQuickFind(int n) {
        super(n);
        this.id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        if (pid != qid) {
            // 2n accesses
            for (int i = 0; i < id.length; i++) {
                if (id[i] != pid) {
                    id[i] = qid;
                }
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public int count() {
        return id.length;
    }
}
