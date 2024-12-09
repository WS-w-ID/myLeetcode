class Solution {
    /**堆排序 */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {  // 调整k次
            swap(nums, 0, i);   // 去掉最大的元素，找下一个最大的
            --heapSize;
            maxHeapify(nums, 0, heapSize);  // 调整
        }
        return nums[0];
    }

    // 建立大根堆
    public void buildMaxHeap(int[] heap, int heapSize) {
        for (int i = heapSize / 2 - 1; i >= 0; --i) {   // 倒数从第一个非叶子节点 heapSize/2-1 开始调整
            maxHeapify(heap, i, heapSize);
        } 
    }

    // 堆的下沉操作
    public void maxHeapify(int[] heap, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;  // 左孩子 i*2+1，右孩子 i*2+2，值最大节点指针
        if (l < heapSize && heap[l] > heap[largest]) {  // 左孩子更大
            largest = l;
        } 
        if (r < heapSize && heap[r] > heap[largest]) {  // 右孩子更大
            largest = r;
        }
        if (largest != i) { // 值最大节点不是父节点，交换
            swap(heap, i, largest);
            maxHeapify(heap, largest, heapSize);    // 递归交换直到下沉完毕
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
