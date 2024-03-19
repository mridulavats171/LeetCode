class Solution {
    public int leastInterval(char[] tasks, int n) {
            int[] taskCounts = new int[26]; // Assuming only uppercase letters (A-Z)
        
        for (char task : tasks) {
            taskCounts[task - 'A']++;
        }
        
        Arrays.sort(taskCounts);
        
        int maxFreq = taskCounts[25] - 1; // Subtract 1 because we need to account for the last execution
        int idleSlots = maxFreq * n;
        
        for (int i = 24; i >= 0 && taskCounts[i] > 0; i--) {
            idleSlots -= Math.min(taskCounts[i], maxFreq);
        }
        
        idleSlots = Math.max(0, idleSlots); // Ensure idleSlots is non-negative
        
        return tasks.length + idleSlots;
    }
}