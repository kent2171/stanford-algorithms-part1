/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.kent2171.algorithms.stanford.part1;

import java.lang.reflect.Constructor;
import java.util.Scanner;

import ru.kent2171.algorithms.stanford.part1.unionfind.AbstractUnionFindAlgo;

public class UnionFindApp {

    public static void main(String[] args) throws Exception {
        Constructor<?> constructor = UnionFindApp.class.getClassLoader().loadClass(args[0]).getDeclaredConstructors()[0];

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("enter number of elements:");
            AbstractUnionFindAlgo uf = (AbstractUnionFindAlgo) constructor.newInstance(scanner.nextInt());
            while (true) {
                System.out.println("enter first element:");
                int p = scanner.nextInt();

                System.out.println("enter second element:");
                int q = scanner.nextInt();

                if (!uf.connected(p, q)) {
                    uf.union(p, q);
                    System.out.println();
                    System.out.println(String.format("p=%s, q=%s are merged", p, q));
                    System.out.println();
                } else {
                    System.out.println();
                    System.out.println(String.format("p=%s, q=%s are connected", p, q));
                    System.out.println();
                }
            }
        }
    }
}
