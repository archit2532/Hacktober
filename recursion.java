import java.util.ArrayList;

public class recursion {

  public static void print1toN(int n) {
    if (n == 0) {
      return;
    }
    print1toN(n - 1);
    System.out.print(n + " ");
  }

  public static void printNto1(int n) {
    if (n == 0) {
      return;
    }
    System.out.print(n + " ");
    printNto1(n - 1);
  }

  public static int factorial(int n) {
    if (n == 1) {
      return 1;
    }
    int ans = n * factorial(n - 1);
    return ans;
  }

  public static int fibonacci(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  public static void printArray(int arr[], int n) {
    if (n == 0) {
      return;
    }
    printArray(arr, n - 1);
    System.out.println(arr[n - 1]);
  }

  public static void min_maxArray(int arr[], int i, int max, int min) {
    if (i >= arr.length) {
      System.out.println(min);
      System.out.println(max);
      return;
    }

    if (arr[i] < min) {
      min = arr[i];
    }

    if (arr[i] > max) {
      max = arr[i];
    }

    min_maxArray(arr, i + 1, max, min);
  }

  public static boolean charPresent(String str, char key, int i) {
    if (i >= str.length()) {
      return false;
    }
    if (str.charAt(i) == key) {
      return true;
    }

    return charPresent(str, key, i + 1);
  }

  public static void charIndex(
    String str,
    char key,
    int i,
    ArrayList<Integer> arr
  ) {
    if (i >= str.length()) {
      System.out.println(arr);
      return;
    }

    if (str.charAt(i) == key) {
      arr.add(i);
    }

    charIndex(str, key, i + 1, arr);
  }

  public static void printDigits(int n) {
    if (n <= 0) {
      return;
    }
    int digit = n % 10;
    printDigits(n / 10);
    System.out.println(digit);
  }

  public static boolean isArraySorted(int arr[], int i) {
    if (i == arr.length - 1) {
      return true;
    }
    if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isArraySorted(arr, i + 1);
  }

  public static int linearSearch(int arr[], int key, int i) {
    if (i >= arr.length) {
      return -1;
    }

    if (arr[i] == key) {
      return i;
    }

    return linearSearch(arr, key, i + 1);
  }

  public static int binarySearch(int arr[], int key, int start, int end) {
    if (start > end) {
      return -1;
    }
    int mid = start + (end - start) / 2;
    if (arr[mid] == key) {
      return mid;
    }

    if (arr[mid] < key) {
      return binarySearch(arr, key, mid + 1, end);
    } else {
      return binarySearch(arr, key, start, mid - 1);
    }
  }

  public static void printSubSequences(
    String str,
    String output,
    int i,
    ArrayList<String> ans
  ) {
    if (i >= str.length()) {
      ans.add(output);
      return;
    }
    printSubSequences(str, output, i + 1, ans);
    printSubSequences(str, output + str.charAt(i), i + 1, ans);
  }

  public static int coinChange(int arr[], int target) {
    if (target == 0) {
      return 0;
    }
    if (target < 0) {
      return Integer.MAX_VALUE;
    }

    int min = Integer.MAX_VALUE;
    for (int i = 0; i < arr.length; i++) {
      int ans = coinChange(arr, target - arr[i]);
      if (ans != Integer.MAX_VALUE) {
        min = Math.min(target, ans + 1);
      }
    }

    return min;
  }

  public static void maxAdjecent(int arr[], int i, int sum, int max) {
    if (i >= arr.length) {
      max = Math.max(sum, max);
      System.out.println(max);
      return;
    }

    maxAdjecent(arr, i + 2, sum + arr[i], max);
    maxAdjecent(arr, i + 1, sum, max);
  }

  public static int lastOccurance(String str, int i, char target) {
    if (str.charAt(i) == target) {
      return i + 1;
    }
    if (i <= 0) {
      return -1;
    }
    return lastOccurance(str, i - 1, target);
  }

  public static String reverseString(String str, int i, String ans) {
    if (i < 0) {
      return ans;
    }
    return reverseString(str, i - 1, ans + str.charAt(i));
  }

  public static String addString(
    String num1,
    String num2,
    int p1,
    int p2,
    int carry,
    StringBuilder ans
  ) {
    if (p1 >= 0 || p2 >= 0 || carry != 0) {
      return ans.toString();
    }
    int n1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
    int n2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
    int sum = n1 + n2 + carry;
    ans.insert(0, sum % 10);
    carry = sum / 10;
    return addString(num1, num2, p1 - 1, p2 - 1, carry, ans);
  }

  public static boolean isPalindrome(String str, int start, int end) {
    if (str.charAt(start) != str.charAt(end)) {
      return false;
    }
    if (start > end) {
      return true;
    }
    return isPalindrome(str, start + 1, end - 1);
  }

  public String removeOccurrences(String s, String part) {
    if (!s.contains(part)) {
      return s;
    }
    return removeOccurrences(s.replaceFirst(part, ""), part);
  }

  public static void printAllSubArrays(int arr[], int i, ArrayList<Integer> ans) {
    if (i >= arr.length) {
      return;
    }
    ans.add(arr[i]);
    System.out.println(ans);
    printAllSubArrays(arr, i + 1, ans);
  }
  
  public static int buyAndSellStocks(int prices[], int minProfit, int maxProfit, int i) {
    if (i == prices.length) {
      return maxProfit;
    }
    if (prices[i] < minProfit) {
      minProfit = prices[i];
    }
    maxProfit = prices[i] - minProfit;
    return Math.max(maxProfit, buyAndSellStocks(prices, minProfit, maxProfit, i + 1));
  }

  public static void main(String[] args) {
    // print1toN(20);
    // printNto1(20);
    // System.out.println(factorial(5));
    // System.out.println(fibonacci(13));
    int arr[] = { 1, 2, 3, 4, 5, 7, 9 };
    // printArray(arr, arr.length);
    // min_maxArray(arr, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    // System.out.println(charPresent("TonyStark", 'b', 0));
    // ArrayList<Integer> arr = new ArrayList<Integer>();
    // charIndex("TonyStarkSSS", 'S', 0, arr);
    // printDigits(647);
    // System.out.println(isArraySorted(arr, 0));
    // System.out.println(linearSearch(arr, 5, 0));
    // System.out.println(binarySearch(arr, 9, 0, arr.length-1));
    // StringBuilder str = new StringBuilder("abc");
    // StringBuilder output = new StringBuilder("");
    // ArrayList<String> ans = new ArrayList<String>();
    // printSubSequences("abc", "", 0, ans);
    // System.out.println(ans);
    // System.out.println(ans.size());
    int max = Integer.MIN_VALUE;
    maxAdjecent(arr, 0, 0, max);
    // String str = "bob";
    // String output = "";
    // System.out.println(lastOccurance(str, str.length()-1, 'd'));
    // System.out.println(reverseString(str, str.length() - 1, output));
    // System.out.println(isPalindrome(str, 0, str.length() - 1));
    // ArrayList<Integer> ans = new ArrayList<Integer>();
    // printAllSubArrays(arr, 0, ans);
  }
}
