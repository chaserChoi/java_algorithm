package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 트리 탐색 + 재귀적 호출
public class A01HeapSort {

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};
        // 최초 힙 구성 : n*log(n)
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

        // 루트 노드와 최하위 노드를 자리 change해가면서 재 heapify
        for (int i = arr.length - 1; i >= 0; i--) {
            // 0번째 index와 마지막 index의 자리 change
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, 0, i);
        }

        // pq를 통한 정렬 방법
        // 최초 힙 구성 : n * log(n)
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
        System.out.println(pq.poll()); // log(n)
        pq.add(6); // log(n)

//        System.out.println(Arrays.toString(arr));
    }

    static void heapify(int[] arr, int parent, int length) {
        // 자식 노드와의 비교 : 왼쪽 자식 노드 (parent * 2 + 1), 오른쪽 자식 노드 (parent * 2 + 2)
        int left = parent * 2 + 1;
        int right = parent * 2 + 2;
        int smallest = parent;

        // 자식이 더 작으면 자리 change
        if (left < length && arr[smallest] < arr[left]) {
            smallest = left;
        }
        if (right < length && arr[smallest] < arr[right]) {
            smallest = right;
        }

        // 만약 자리 change가 발생하면 재귀적 호출0
        if (smallest != parent) {
            int temp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, smallest, length);
        }
    }
}
