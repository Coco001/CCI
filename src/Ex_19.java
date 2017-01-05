import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 对于一个有向图，请实现一个算法，找出两点之间是否存在一条路径。
 * 给定图中的两个结点的指针UndirectedGraphNode* a,UndirectedGraphNode* b,
 * 请返回一个bool，代表两点之间是否存在一条路径(a到b或b到a)。
 */
public class Ex_19 {
    private class UndirectedGraphNode {
        int label = 0;
        UndirectedGraphNode left = null;
        UndirectedGraphNode right = null;
        ArrayList<UndirectedGraphNode> neighbors = new ArrayList<UndirectedGraphNode>();

        public UndirectedGraphNode(int label) {
            this.label = label;
        }
    }
    public boolean checkPath(UndirectedGraphNode a, UndirectedGraphNode b) {
        // write code here
        if(a==null||b==null)
            return false;
        if(a==b)
            return true;
        return BFS(a, b)||BFS(b,a);
    }

    private boolean BFS(UndirectedGraphNode a, UndirectedGraphNode b) {
        ArrayDeque<UndirectedGraphNode> queue = new ArrayDeque<>();
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        visited.put(a, true);
        queue.addLast(a);
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.pollFirst();
            for (UndirectedGraphNode t : node.neighbors) {
                if (!visited.containsKey(t)) {
                    if (t == b) {
                        return true;
                    }
                    visited.put(t, true);
                    queue.addLast(t);
                }
            }
        }
        return false;
    }

    private boolean DFS(UndirectedGraphNode a, UndirectedGraphNode b) {
        if(a==null||b==null)
            return false;
        if(a==b)
            return true;
        HashMap<UndirectedGraphNode, Boolean> visited = new HashMap<>();
        visited.put(a, true);
        for (UndirectedGraphNode t : a.neighbors) {
            if (!visited.containsKey(t) && DFS(t, b)) {
                return true;
            }
        }
        return false;
    }

}
