#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> numToIndex; // Maps number to its index
        
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            
            // Check if the complement exists in the map
            if (numToIndex.find(complement) != numToIndex.end()) {
                return {numToIndex[complement], i}; // Found the solution
            }
            
            // Add current number and index to the map
            numToIndex[nums[i]] = i;
        }
        
        // No solution found
        return {};
    }
};

int main() {
    Solution solution;
    
    int n;
    cin >> n;
    
    vector<int> nums(n);
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    
    int target;
    cin >> target;
    
    vector<int> result = solution.twoSum(nums, target);
    if (result.size() == 2) {
        cout << "[ " << result[0] << "  " << result[1] << "]"<<endl;
       
    } else {
        cout << "null" << endl;
    }
    
    return 0;
}