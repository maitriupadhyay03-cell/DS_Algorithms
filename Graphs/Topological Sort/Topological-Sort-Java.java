import java.util.*;

/**
 * Topological Sort using DFS (Depth-First Search) in Java
 *
 * Algorithm:
 *   1. Perform DFS from each unvisited vertex.
 *   2. After visiting all neighbors of a vertex, push it onto a stack.
 *   3. Pop vertices from the stack to get topological order.
 *
 * Time Complexity:  O(V + E)
 * Space Complexity: O(V + E)
 */
public class TopologicalSort {

    private int vertices;
    private List<List<Integer>> adjList;

    public TopologicalSort(int v) {
        this.vertices = v;
        adjList = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }
        stack.push(node);
    }

    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        System.out.print("Topological Sort Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
            if (!stack.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example: 5->2, 5->0, 4->0, 4->1, 2->3, 3->1
        // Expected: 5 -> 4 -> 2 -> 3 -> 1 -> 0
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.topologicalSort();
    }
}
