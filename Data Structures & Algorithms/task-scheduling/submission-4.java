class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] counts = new int[26];

    for (char task : tasks) {
      counts[task - 'A']++;
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int count : counts) {
      if (count > 0) {
        pq.offer(count);
      }
    }

    Queue<int[]> q = new LinkedList<>();
    int time = 0;

    while (!pq.isEmpty() || !q.isEmpty()) {
      time++;

      if (pq.isEmpty()) {
        time = q.peek()[1];
      } else {
        int freq = pq.poll() - 1;
        if (freq > 0) {
          q.offer(new int[] {freq, time + n});
        }
      }

      if (!q.isEmpty() && time == q.peek()[1]) {
        pq.offer(q.poll()[0]);
      }
    }
    return time;
  }
}
