package Session4;
/*
I decided to iterate through an input string and treat each index as the middle of my supposed palindrome. My first idea
was to do it brute force but I discarded the idea quickly and the idea below was my second one. I do not see how I could
make it faster or more efficient, at least for now. One idea would be to omit the part when I look for the longest sequence
of the same characters (including my character at ith index). and then stop looking for the palindrome, when
 it is not longer possible to find the longer one. But I started to wonder if it is worth checking at every iteration
 if this condition is fulfilled, and decided not to include it.
*/
public class LongestPalindrome {
    public String longest(String string){
        if(string.length() < 1){
            return null;
        }
        String result = string.substring(0,1);
        for(int i = 0; i < string.length(); i++){
            int left = 0;
            int right = 0;
            while(i - left > 0 && string.charAt(i) == string.charAt(i - 1 - left)){
                    left++;
            }
            while(i + right < string.length()-1 && string.charAt(i) == string.charAt(i + 1 + right)){
                    right++;
            }

            while(i - left > 0 && i + right < string.length()-1 && string.charAt(i - 1 - left) == string.charAt(i + 1 + right)){
                left++;
                right++;
            }
            if(result.length() <= left+right){
                result = string.substring(i - left, i + right + 1);
            }
        }
        return result;
    }
    public static void main(String[] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longest("aa"));
        System.out.println(longestPalindrome.longest("aba"));
        System.out.println(longestPalindrome.longest("abaa"));
        System.out.println(longestPalindrome.longest("12321"));
        System.out.println(longestPalindrome.longest("1111232100"));
        System.out.println(longestPalindrome.longest(""));

    }
}
