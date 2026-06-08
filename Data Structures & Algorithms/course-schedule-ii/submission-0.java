class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for (int[] prereq : prerequisites) {
            preMap.computeIfAbsent(prereq[0], k -> new ArrayList<>()).add(prereq[1]);
        }

        List<Integer> output = new ArrayList<>();
        Set<Integer> cycle = new HashSet<>();
        Set<Integer> visit = new HashSet<>();

        for (int course = 0; course < numCourses; course++) {
            if (!dfs(course, preMap, visit, cycle, output)) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = output.get(i);
        }

        return res;
    }

    public boolean dfs(int course, Map<Integer, List<Integer>> preMap, Set<Integer> visit,
        Set<Integer> cycle, List<Integer> output) {
        if (cycle.contains(course)) {
            return false;
        }

        if (visit.contains(course)) {
            return true;
        }

        cycle.add(course);
        for (int pre : preMap.getOrDefault(course, Collections.emptyList())) {
            if (!dfs(pre, preMap, visit, cycle, output)) {
                return false;
            }
        }

        cycle.remove(course);
        visit.add(course);
        output.add(course);

        return true;
    }
}
