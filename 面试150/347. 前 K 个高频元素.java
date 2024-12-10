class Solution {
    /**1.小根堆：维护大小为k的小根堆，不断与堆顶元素比较，频率更小就舍弃了，频率更大就替换堆顶元素，最后剩的k个就是结果。
       2.大根堆：直接建立一个大小为n的大根堆，然后将堆尾元素替换为堆顶元素k-1次并调整，每次就可以得到一个最大值了。
     */
    Map<Integer, Integer> map = new HashMap<>();
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        for(int i=0; i<n; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int[] heap = new int[k];
        int heapSize=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){    // 为了避免重复元素的复杂判断，直接遍历map
            if(heapSize < k){
                heap[heapSize++] = entry.getKey();
                if(heapSize == k){
                    buildMinHeap(heap, heapSize);
                }
            }
            else if(entry.getValue() > map.get(heap[0])){
                heap[0] = entry.getKey();
                minHeapify(heap, heapSize, 0);
            }
        }
        return heap;
    }

    public void buildMinHeap(int[] heap, int heapSize){
        for (int i = heapSize / 2 - 1; i >= 0; --i) {   // 倒数从第一个非叶子节点 heapSize/2-1 开始调整
            minHeapify(heap, heapSize, i);
        }
    } 


    public void minHeapify(int[] heap, int heapSize, int i){
        int l=2*i+1, r=2*i+2, minest=i;
        if(l<heapSize && map.get(heap[l])<map.get(heap[minest])){ 
            minest = l;
        }
        if(r<heapSize &&  map.get(heap[r])<map.get(heap[minest])){
            minest = r;
        }
        if(minest != i){
            swap(heap, minest, i);
            minHeapify(heap, heapSize, minest);
        }
        
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
