package ru.kent2171.algorithms.stanford.part1.unionfind;

// eager approach
public class QuickFind implements UnionFindApi {

    private final int id[];

    // N array accesses
    public QuickFind(int n) {
        this.id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    // 2N + 2 array accesses
    @Override
    public void union(int p, int q) {
        int pid = id[p];
        int qid = id[q];

        if (pid != qid) {
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
