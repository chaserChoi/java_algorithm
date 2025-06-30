package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// [[1, 2, 4, 8], [1, 2, 4, 9], [1, 2, 5, 10], [1, 3, 6], [1, 3, 7]]
public class A02Dfs모든경우의수 {

    static List<List<Integer>> adjList;

    public static void main(String[] args) {
//        1 ~ 10까지의 노드가 존재
        int[][] nodes = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {4, 8}, {4, 9}, {5, 10}};
        adjList = new ArrayList<>();
        for (int i=0; i<10; i++){
            adjList.add(new ArrayList<>());
        }

        // 여기서는 1번이 루트 노드라고 정해졌기 때문에, visited 제외하고 단방향 노드로 설계
        for (int i=0; i<nodes.length; i++){
            adjList.get(nodes[i][0]).add(nodes[i][1]); // 단방향
        }
        for (int i=0; i<adjList.size(); i++){
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(0);

        System.out.println(adjList);
    }

    static void dfs(int start) {
        for (int i : adjList.get(start)) {
                dfs(i);
        }
    }

}
