package ru.kent2171.algorithms.stanford.part1.unionfind.hw1;

public class SmallestFromGreatestSearch {

    private int size;
    private int[] nextAliveNode;

    public SmallestFromGreatestSearch(int n) {
        this.size = n;
        this.nextAliveNode = new int[n];

        for (int i = 0; i < nextAliveNode.length; i++) {
            if (i < n - 1) {
                nextAliveNode[i] = i + 1;
            } else {
                nextAliveNode[i] = -1;
            }
        }
    }

    public void remove(int x) {
        if (x < 0 || x >= size) {
            throw new IllegalArgumentException("Specified element does not exist");
        }

        boolean isNodeRemoved = nextAliveNode[x] != x + 1;
        if (isNodeRemoved) {
            return;
        }

        int nextAliveNode = this.nextAliveNode[x];
        int removedNode = x;
        while (x != 0 && this.nextAliveNode[x - 1] == removedNode) {
            this.nextAliveNode[x - 1] = nextAliveNode;
            x--;
        }
    }

    public int findSmallestFromGreatest(int x) {
        if (x >= size - 1) {
            return -1;
        }
        return this.nextAliveNode[x];
    }

    public static void main(String[] args) {
        SmallestFromGreatestSearch search = new SmallestFromGreatestSearch(10);
        System.out.println();
    }
}
