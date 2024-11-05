class LRUCache {
    /**维护一个按使用频率从低到高的队列，和一个保存相应节点的前驱指针的哈希表
    【注意】 1. 非尾结点时，一次移动会造成两个节点的变化; 2. capacity=1时,tail会变化 */

    class LRUData{
        int key;
        int value;
        LRUData next;

        LRUData(int key, int value, LRUData next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    LRUData dummyHead = new LRUData(-1, -1, null);
    LRUData tail = dummyHead;
    Map<Integer, LRUData> map = new HashMap<>();
    int size = 0;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        LRUData preNode = map.get(key);
        if(preNode != null){   // 已存在
            if(preNode.next != tail){   // 不是最后一个节点
                map.put(preNode.next.next.key, preNode);  // 维护移到前面来的节点
                tail.next = preNode.next;   // 添加
                preNode.next = tail.next.next;  // 删除
                tail.next.next = null;  // 修改
                map.put(key, tail); // 维护换到后面去的节点
                tail = tail.next;
            }
            return tail.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        LRUData preNode = map.get(key);
        if(preNode != null){   // 已存在
            preNode.next.value = value; // 修改
            if(preNode.next != tail){   // 不是最后一个节点
                map.put(preNode.next.next.key, preNode);  // 维护移到前面来的节点
                tail.next = preNode.next;   // 添加
                preNode.next = tail.next.next;  // 删除
                tail.next.next = null;
                map.put(key, tail); // 维护换到后面去的节点
                tail = tail.next;
            }
        }
        else{   // 不存在
            if(size == capacity){
                if(size > 1)    // 删掉的不是tail
                    map.put(dummyHead.next.next.key, dummyHead); // 维护移到前面来的节点
                else        // 删掉的是tail
                    tail = dummyHead;
                map.remove(dummyHead.next.key);
                dummyHead.next = dummyHead.next.next;
                --size;
            }
            LRUData currNode = new LRUData(key, value, null);
            map.put(key, tail); // 保存前驱节点引用
            tail.next = currNode;
            tail = tail.next;
            ++size;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
