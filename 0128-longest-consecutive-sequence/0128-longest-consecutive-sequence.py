class Solution:
    def longestConsecutive(self, nums: list[int]) -> int:
        # //using hashmap/
        mapp = defaultdict(int)
        res = 0

        for num in nums:
            if not mapp[num]:
                #to know the longest subsequence we will use {map[num - 1] + map[num + 1] + 1}
                mapp[num] = mapp[num - 1] + mapp[num + 1] + 1
                # Update endpoints
                mapp[num - mapp[num - 1]] = mapp[num]
                mapp[num + mapp[num + 1]] = mapp[num]

                # update result with max
                res = max(res, mapp[num])
        
        return res