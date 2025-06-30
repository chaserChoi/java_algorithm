package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {

    public static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        // 방문할 수 있는 점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문
        // 출발은 0부터 bfs로 방문 시 방문 순서 : 0->1->2->3->4
        int[][] nodes = {{0, 2}, {0, 1}, {1, 3}, {2, 3}, {2, 4}};
        // 인접 리스트를 활용해서 인접해 있는 노드를 밤르게 접근
        adjList = new ArrayList<>();
        visited = new boolean[5];
        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]); // 단방향
            adjList.get(nodes[i][1]).add(nodes[i][0]); // 양방향인 경우
        }
        // 정점 번호가 작은 것부터 방문하기 위한 정렬
        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        // Queue 안에 integer가 아니라 int[]을 담아서 0번째는 노드 번호, 1번째는 distant 설계 가능
        Queue<Integer> myQueue = new LinkedList<>();
        int[] distant = new int[5];
        int target = 4;
        myQueue.add(0);
        visited[0] = true;
        while (!myQueue.isEmpty()) {
            int temp = myQueue.poll();
            for (int i : adjList.get(temp)) {
              if (!visited[i]) {
                  myQueue.add(i);
                  visited[i] = true; // queue에 담는 시점에 true 세팅해야지, 중복해서 queue에 안담김.
                  distant[i] = distant[temp] + 1;
                  // 만ㅁ약에 찾고자하는 target이 정해저 있으면 break;
                  if (target == i) break;
              }
            }
        }

    }


}
