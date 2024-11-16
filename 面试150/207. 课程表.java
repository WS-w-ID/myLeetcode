class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> table = new HashMap<>();
        int n=prerequisites.length;
        int[] inDegree = new int[numCourses];
        // 初始化
        for(int i=0; i<numCourses; ++i){
            inDegree[i] = 0;
            table.put(i, new ArrayList<Integer>());
        }
        for(int i=0; i<n; ++i){
            ++inDegree[prerequisites[i][0]];    // 入度+1
            table.get(prerequisites[i][1]).add(prerequisites[i][0]);    // 保存子节点
        }
        
        Deque<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; ++i){
            if(inDegree[i] == 0)
                queue.offer(i);
        }

        int count = 0;
        while(!queue.isEmpty()){
            ++count;
            int pre = queue.poll(); // 遍历入度为0的节点
            for(int val : table.get(pre)){ // 遍历受影响的节点
                --inDegree[val];  // 入度都减少1
                if(inDegree[val] == 0)
                    queue.offer(val);
            }
        }

        return count == numCourses;
    }
}
