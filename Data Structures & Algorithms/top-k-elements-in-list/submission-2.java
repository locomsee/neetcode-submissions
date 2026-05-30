class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       // Step 1: Create a frequency map (number -> how many times it appears)
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Step 2: Count frequency of each number in nums
        // merge(x, 1, Integer::sum):
        // - if x is not in map → put x with value 1
        // - if x already exists → add 1 to existing value
        for (int x : nums) {
            frequencyMap.merge(x, 1, Integer::sum);
        }

        // Step 3: Create a min-heap (priority queue)
        // It will store map entries sorted by frequency (value)
        // Smallest frequency is at the top
        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        // Step 4: Iterate over all frequency entries
        for (var e : frequencyMap.entrySet()) {

            // Add current element (number + its frequency) into heap
            priorityQueue.offer(e);

            // Step 5: Keep heap size limited to k
            // If we have more than k elements, remove the smallest frequency
            // This ensures only top k frequent elements remain in heap
            if (priorityQueue.size() > k) {
                priorityQueue.poll(); // removes element with lowest frequency
            }
        }

        // Step 6: Extract the keys (numbers) from heap
        // These are the k most frequent elements // int array
        return priorityQueue.stream().mapToInt(Map.Entry::getKey).toArray(); 
    }
}
