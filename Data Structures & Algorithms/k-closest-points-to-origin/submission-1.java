class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> disSqr(b) - disSqr(a)
        );

        for(int[] point : points) {
            pq.offer(point);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] res = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll();
        }
        return res;
    }

    private int disSqr(int[] a) {
        int x = a[0];
        int y = a[1];

        return x * x + y * y;
    }
}
