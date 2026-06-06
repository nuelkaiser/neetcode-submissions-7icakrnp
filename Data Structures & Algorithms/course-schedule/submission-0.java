class Solution {
    Map<Integer, List<Integer>> preq = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            preq.put(i, new ArrayList<>());
        }

        for (int[] prereq : prerequisites) {
            preq.get(prereq[0]).add(prereq[1]);
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int crs) {
        if (visited.contains(crs)) {
            return false;
        }

        if (preq.get(crs).isEmpty()) {
            return true;
        }

        visited.add(crs);

        for (int prereq : preq.get(crs)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        visited.remove(crs);
        preq.put(crs, new ArrayList<>());
        return true;
    }
}
