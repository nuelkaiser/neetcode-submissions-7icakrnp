class Solution {
    List<List<Integer>> adj = new ArrayList<>();
    Set<Integer> visited = new HashSet<>();


    public boolean validTree(int n, int[][] edges) {
        if(edges.length < n - 1) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        if(!dfs(0, -1)) {
            return false;
        }

        return visited.size() == n;
    }

    public boolean dfs(int node, int parent) {
        if(visited.contains(node)) {
            return false;
        }
        visited.add(node);

        for(int leave : adj.get(node)) {
            if(leave == parent) {
                continue;
            }

            if(!dfs(leave, node)) {
                return false;
            }
        }
        return true;
    }
}
