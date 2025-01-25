
class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> stoneJumps = new HashMap<>();
        
        stoneJumps.put(stones[0], new HashSet<>());
        stoneJumps.get(stones[0]).add(0);
        
        for (int i = 0; i < stones.length; i++) {
            int currentStone = stones[i];
            
            if (!stoneJumps.containsKey(currentStone)) {
                continue;
            }
            
            for (int jump : stoneJumps.get(currentStone)) {
                for (int nextJump = jump - 1; nextJump <= jump + 1; nextJump++) {
                    if (nextJump > 0) {
                        int nextStone = currentStone + nextJump;
                        
                        if (Arrays.binarySearch(stones, nextStone) >= 0) {
                            stoneJumps.putIfAbsent(nextStone, new HashSet<>());
                            stoneJumps.get(nextStone).add(nextJump);
                            
                            if (nextStone == stones[stones.length - 1]) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        
        return false;
    }
}