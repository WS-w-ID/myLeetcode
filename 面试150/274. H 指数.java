class Solution {
    public int hIndex(int[] citations) {
        /**问题：找出最大的h，使得有h个元素的值大于等于h;
         * 维护cnt数组，统计出 引用次数为i的论文有cnt[i]篇,其中i<=n,因为h<=n
         * 倒序遍历求和，可以得到 有total=sum(cnt[i],...,cnt[n])篇论文的引用次数>=i,直到total>=i，就表示有至少i篇论文的引用次数>=i
         */
        int n=citations.length, total=0;
        int[] cnt = new int[n+1];
        for(int i=0;i<n;++i){   // 计数
            if(citations[i]>=n)
                ++cnt[n];
            else
                ++cnt[citations[i]];
        }

        for(int i=n; i>=0; --i){    // 逆序遍历
            total += cnt[i];
            if(total >= i)
                return i;
        }

        return 0;

    }
}
