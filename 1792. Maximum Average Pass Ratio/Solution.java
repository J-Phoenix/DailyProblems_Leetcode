class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = (double)(a[0]+1)/(a[1]+1) - (double)a[0]/a[1];
            double gainB = (double)(b[0]+1)/(b[1]+1) - (double)b[0]/b[1];
            return Double.compare(gainB, gainA); // max heap
        });
        
        for (int[] cls : classes) {
            pq.offer(cls);
        }
        
        while (extraStudents-- > 0) {
            int[] cls = pq.poll();
            cls[0]++; // add one extra passing student
            cls[1]++;
            pq.offer(cls);
        }
        
        double sum = 0;
        while (!pq.isEmpty()) {
            int[] cls = pq.poll();
            sum += (double)cls[0]/cls[1];
        }
        
        return sum / classes.length;
    }
}
