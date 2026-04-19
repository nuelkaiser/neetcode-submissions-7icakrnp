class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> dist(b) - dist(a));

        for(int[] point : points ) {
            pq.offer(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }    


        int i = 0;
        int[][] res = new int[k][2];

        while(!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

    public int dist(int[] x) {
        return x[0] * x[0] + x[1] * x[1];
    }
}
