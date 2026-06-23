class Solution {
    int[] parent;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];

        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];

            if (find(u) == find(v)) {
                return edge;
            }

            union(u, v);
        }
        return new int[0];
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int p1 = find(x), p2 = find(y);

        if (p1 == p2) {
            return;
        }

        if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
        } else if (rank[p2] > rank[p1]) {
            parent[p1] = p2;
        } else {
            parent[p1] = p2;
            rank[p1] += 1;
        }
    }
}
