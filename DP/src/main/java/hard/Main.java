package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Node[] nodes = new Node[n];
        String[] names = scanner.nextLine().split(" ");
        for(int i = 0; i < n; i ++){
            nodes[i] = new Node(scanner.nextInt(), names[i]);
        }
        Arrays.sort(nodes, (a,b) -> {
            if(a.height != b.height){
                return a.height - b.height;
            }
            return a.name.compareTo(b.name);
        });
    }
    static class Node{
        public Node(int height, String name){
            this.height = height;
            this.name = name;
        }
        public int height;
        public String name;
    }
}
