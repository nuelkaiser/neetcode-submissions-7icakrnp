class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        

        for(int stone: stones) {
            maxHeap.add(stone);
        }

        while(maxHeap.size() > 1) {
            int lg = maxHeap.poll();
            int md = maxHeap.poll();

            if(lg == md) {
                continue;
            }else if(lg > md) {
                maxHeap.add(lg - md);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
