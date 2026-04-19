class Solution {
  public int lastStoneWeight(int[] stones) {
    Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

    for (int stone : stones) {
      pq.offer(stone);
    }

    while (pq.size() > 1) {
      int x = pq.poll();
      int y = pq.poll();

      if (x == y) {
        pq.offer(0);
      } else {
        pq.offer(x - y);
      }
    }
    return stones.length == 0 ? 0 : pq.peek();
  }
}
