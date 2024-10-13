class RandomizedSet {
    /**移除 链表O(1); 随机返回 数组O(1)，但是移除可以通过数组的交换位置来变相实现O(1) 
     链表或许也可以通过map里存储val的节点指针来实现*/

    List<Integer> arr = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Random random = new Random();


    public RandomizedSet() {

    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)) // 已经存在
            return false;
        map.put(val, arr.size());   // 【注意】先加入防止数组size变化
        arr.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(arr.size() == 0 || !map.containsKey(val))    // 不存在
            return false;
        // arr.remove(map.get(val));   // 时间复杂度为O(n)
        int removeIndex = map.get(val), lastValue = arr.get(arr.size()-1);

        arr.set(removeIndex, lastValue);    // 最后一个换到前面来
        map.put(lastValue, removeIndex);  // 【不要忘了】改变原本最后一个元素的下标map记录
        arr.remove(arr.size()-1);   // 删掉没用的最后一个
        map.remove(val); 
        return true;
    }
    
    public int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
