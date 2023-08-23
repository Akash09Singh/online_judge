
INSERT INTO problem (problem_id, contest_id, title, description, example1_input, example1_output, example2_input, example2_output, boiler_code_python, boiler_code_java, boiler_code_cpp)
VALUES
    (1, 1, 'Two Sum', 'Given an array of integers and a target sum, return indices of the two numbers such that they add up to the target.', 'nums1 = [2, 7, 11, 15] target1 = 9', '[0,1]', 'nums2 = [3, 2, 4] target2 = 6', '[1, 2]', 'class Solution:
    def two_sum(self, nums, target):
        #write your code here

if __name__ == "__main__":
    solution = Solution()

    n = int(input("Enter the number of elements: "))
    nums = []
    print("Enter the elements:")
    for _ in range(n):
        nums.append(int(input()))

    target = int(input("Enter the target sum: "))

    result = solution.two_sum(nums, target)
    print(result)', 'import java.util.*;

public class Main {

    public int[] twoSum(int[] nums, int target) {
        // write your code here and change the return value

        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        Main solution = new Main();
        int[] result = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}', '#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
    //write your code here and change the return value
    return null;
    }
        
};

int main() {
    Solution solution;
    
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    
    vector<int> nums(n);
    cout << "Enter the elements:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }
    
    int target;
    cout << "Enter the target sum: ";
    cin >> target;
    
    vector<int> result = solution.twoSum(nums, target);
    cout << result << endl;
    
    return 0;
}
'),
    (2, 1, 'Reverse Words in a String', 'Given a string, reverse the order of words.', 's1 = "the sky is blue"', 'blue is sky the', 's2 = "  hello world  "', 'world hello', 'class Solution:
    def reverse_words(self, s):
        #write your code here and change the return value
        return null

if __name__ == "__main__":
    solution = Solution()
    
    input_str = input("Enter a string: ")
    
    reversed_str = solution.reverse_words(input_str)
    print(reversed_str)
', 'import java.util.Scanner;

public class Main {

    public String reverseWords(String s) {
        //write your code here and change the return value
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Main solution = new Main();
        String reversed = solution.reverseWords(input);
        System.out.println(reversed);
    }
}
', '#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

class Solution {
public:
    string reverseWords(string s) {
    // write your code here and change the return value
        return null
    }
};

int main() {
    Solution solution;
    
    string input_str;
    cout << "Enter a string: ";
    getline(cin, input_str);
    
    string reversed_str = solution.reverseWords(input_str);
    cout << reversed_str << endl;
    
    return 0;
}
'),
    (3, 1, 'Subarray Sum Equals K', 'Given an array of integers and an integer k, find the total number of continuous subarrays whose sum equals k.', 'nums1 = [1, 1, 1] k1 = 2', 'Output: 2', 'nums2 = [1, 2, 3] k2 = 3', 'Output: 2', 'class Solution:
    def subarray_sum(self, nums, k):
    #write your code here and change the return value
        return null

if __name__ == "__main__":
    solution = Solution()

    n = int(input("Enter the number of elements: "))
    nums = []
    print("Enter the elements:")
    for _ in range(n):
        nums.append(int(input()))

    target = int(input("Enter the target sum: "))

    result = solution.subarray_sum(nums, target)
    print(target)
', 'import java.util.*;

public class Main {

    public int subarraySum(int[] nums, int k) {
        //write your code here and change the return value
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter the target sum: ");
        int target = scanner.nextInt();

        Main solution = new Main();
        int result = solution.subarraySum(nums, target);
        System.out.println(result);
    }
}
', '#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
    //write your code here and change the return value
        return null;
    }
};

int main() {
    Solution solution;

    int n;
    cout << "Enter the number of elements: ";
    cin >> n;

    vector<int> nums(n);
    cout << "Enter the elements:" << endl;
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    int target;
    cout << "Enter the target sum: ";
    cin >> target;

    int result = solution.subarraySum(nums, target);
    cout << result << endl;

    return 0;
}
'),
    (4, 2, 'Group Anagrams', 'Given an array of strings, group anagrams together.', 'strs1 = ["eat", "tea", "tan", "ate", "nat", "bat"]', 'Output: [["eat","tea","ate"],["tan","nat"],["bat"]]', 'strs2 = ["a"]', 'Output: [["a"]]', 'class Solution:
    def group_anagrams(self, strs):
    #write your code here and change the nul value
        return null

if __name__ == "__main__":
    solution = Solution()

    n = int(input("Enter the number of strings: "))
    strs = []
    print("Enter the strings:")
    for _ in range(n):
        strs.append(input())

    result = solution.group_anagrams(strs)
    print(result)
', 'import java.util.*;

public class Main{

    public List<List<String>> groupAnagrams(String[] strs) {
        //write your code here and change the return value
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        String[] strs = new String[n];
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        Main solution = new Main();
        List<List<String>> result = solution.groupAnagrams(strs);
        System.out.println(result);
    }
}
', '#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        //write your code here and change the return value
        return null;
    }
};

int main() {
    Solution solution;

    int n;
    cout << "Enter the number of strings: ";
    cin >> n;
    cin.ignore(); // Consume the newline

    vector<string> strs(n);
    cout << "Enter the strings:" << endl;
    for (int i = 0; i < n; i++) {
        getline(cin, strs[i]);
    }

    vector<vector<string>> result = solution.groupAnagrams(strs);
    cout << result << endl
    return 0;
}
'),
    (5, 2, 'Longest Palindromic Substring', 'Given a string, find the longest palindromic substring.', 's1 = "babad"', '"bab" or "aba"', 's2 = "cbbd"', 'Output: "bb"', 'class Solution:
    def longest_palindrome(self, s):
        #write your code here and change the return value

if __name__ == "__main__":
    solution = Solution()

    input_str = input("Enter a string: ")

    result = solution.longest_palindrome(input_str)
    print(result)
', 'import java.util.Scanner;

public class Main {

    public String longestPalindrome(String s) {
        //write your code here and change the return value
        return null;
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        Main  solution = new Main();
        String result = solution.longestPalindrome(input);
        System.out.println(result);
    }
}
', '#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        //write your code here and change the return value
        return null;
    }
};

int main() {
    Solution solution;

    string input_str;
    cout << "Enter a string: ";
    getline(cin, input_str);

    string result = solution.longestPalindrome(input_str);
    cout << result << endl;

    return 0;
}
'),
    (6, 3, 'Minimum Window Substring', 'Given two strings S and T, find the minimum window in S which will contain all the characters in T.', 'S1 = "ADOBECODEBANC" T1 = "ABC"', 'Output: "BANC"', 'S2 = "a" T2 = "aa"', 'Output: ""', 'class Solution:
    def min_window(self, s, t):
        #write your code here and change the return value
        return null

if __name__ == "__main__":
    solution = Solution()

    s = input("Enter the string: ")
    t = input("Enter the target string: ")

    result = solution.min_window(s, t)
    print(result)
', 'import java.util.*;

public class Main {

    public String minWindow(String s, String t) {
        //write your code here and change the return value
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        System.out.print("Enter the target string: ");
        String t = scanner.nextLine();

        Main solution = new Main();
        String result = solution.minWindow(s, t);
        System.out.println(result);
    }
}
',  '#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
    // write your code here and change the return value
        return null;
    }
};

int main() {
    Solution solution;

    string s, t;
    cout << "Enter the string: ";
    getline(cin, s);
    cout << "Enter the target string: ";
    getline(cin, t);

    string result = solution.minWindow(s, t);
    cout << result << endl;

    return 0;
}
'),
    (7, 3, 'Valid Parentheses:', 'Given a string containing just the characters "(", ")", "{", "}", "[" and "]", determine if the input string is valid', 's1 = "()"', 'Output: True', 's2 = "()[]{}"', 'Output: True', 'class Solution:
    def is_valid(self, s):
        #write your code here and change the return value
        return null

if __name__ == "__main__":
    solution = Solution()

    input_str = input("Enter a string of parentheses: ")

    result = solution.is_valid(input_str)
    print(result)
', 'import java.util.*;

public class Main {

    public boolean isValid(String s) {
        //write your code here and change the return value
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string of parentheses: ");
        String input = scanner.nextLine();

        Main solution = new Main();
        boolean result = solution.isValid(input);
        System.out.println(result);
    }
}
', '#include <iostream>
#include <stack>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
    //write your code here and change the return value
        return null;
    }
};

int main() {
    Solution solution;

    string input_str;
    cout << "Enter a string of parentheses: ";
    getline(cin, input_str);

    bool result = solution.isValid(input_str);
    cout << (result ? "true" : "false") << endl;

    return 0;
}
');
    