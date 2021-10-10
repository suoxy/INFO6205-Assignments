package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

public class UF_Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // let user type number of sites
        System.out.print("hello, this is UF_Client! Do you want to do multiple runs for step 3?  y/n     ");
        String s = scanner.next();
        if (s.equalsIgnoreCase("y")) {
            int sites = 100;
            for (int i = 1; i <= 20; i++) {
                int totalConnections = count(sites);
                System.out.println("All sited are connected, total sites(n) is " + sites
                        + ",  total number of connection(m) is " + totalConnections);
                sites = sites * 2;
            }
        } else {
            System.out.print("Please enter an integer: ");
            int n = scanner.nextInt();
            int totalConnections = count(n);
            System.out.println("All sited are connected, total number of connection is " + totalConnections);
        }
    }

    public static int count(int n) {
        UF_HWQUPC qupc = new UF_HWQUPC(n, true);
        Random random = new Random();
        int count = 0;
        while(qupc.components() > 1) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            if (!qupc.connected(p, q)) { // did find() twice here
                qupc.union(p ,q);
            }
            count++;
        }

        return count;
    }
}
