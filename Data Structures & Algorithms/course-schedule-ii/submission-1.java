class Solution {
    Map<Integer, List<Integer>> preMap = new HashMap<>();
    Set<Integer> cycle = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    List<Integer> output = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int[] prereq : prerequisites) {
            preMap.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }

        for (int crs = 0; crs < numCourses; crs++) {
            if (!dfs(crs)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }
        return res;
    }

    public boolean dfs(int crs) {
        if (cycle.contains(crs)) {
            return false;
        }

        if (visited.contains(crs)) {
            return true;
        }

        cycle.add(crs);

        for (int pre : preMap.getOrDefault(crs, Collections.emptyList())) {
            if (!dfs(pre)) {
                return false;
            }
        }

        cycle.remove(crs);
        visited.add(crs);
        output.add(crs);

        return true;
    }
}
