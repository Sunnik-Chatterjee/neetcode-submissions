class Task implements Comparable<Task>{
    int freq;
    int et;
    Task(int freq,int et){
        this.freq=freq;
        this.et = et;
    }
    public int compareTo(Task that){
        return that.freq-this.freq;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freqMap =  new HashMap<>();
        for(char c:tasks){
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Task> pq = new PriorityQueue<>();
        for(Character c: freqMap.keySet()){
            int freq = freqMap.get(c);
            pq.offer(new Task(freq,0));
        }
        Queue<Task> queue = new LinkedList<>();
        int time = 0;
        while(!queue.isEmpty() || !pq.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Task task = pq.poll();
                task.freq--;
                if(task.freq>0){
                    task.et=time+n;
                    queue.offer(task);
                }
            }
            if(!queue.isEmpty() && queue.peek().et==time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}
