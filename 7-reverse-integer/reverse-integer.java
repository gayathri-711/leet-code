class Solution {
    public int reverse(int x) {
        int INT_MAX = Integer.MAX_VALUE;   // 2147483647
        int INT_MIN = Integer.MIN_VALUE;   // -2147483648

        int res = 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            // Check for overflow BEFORE multiplying/resizing
            if (res > INT_MAX / 10 || (res == INT_MAX / 10 && digit > 7)) 
                return 0;

            if (res < INT_MIN / 10 || (res == INT_MIN / 10 && digit < -8)) 
                return 0;

            res = res * 10 + digit;
        }

        return res;
    }
}

    