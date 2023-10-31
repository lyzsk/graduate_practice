from typing import List


class Solution:
    def findArray(self, pref: List[int]) -> List[int]:
        # n = len(pref)
        # arr = [0] * n
        # arr[0] = pref[0]
        # for i in range(1, n):
        #     arr[i] = pref[i] ^ pref[i - 1]
        # return arr
        return [pref[0]] + [pref[i] ^ pref[i - 1] for i in range(1, len(pref))]
