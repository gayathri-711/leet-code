class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int INT_MAX = Integer.MAX_VALUE;   //  2147483647
        int INT_MIN = Integer.MIN_VALUE;   // -2147483648

        // 1️⃣ Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // If string is empty or only spaces
        if (i == n) return 0;

        // 2️⃣ Check sign
        int sign = 1;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3️⃣ Convert digits
        long result = 0;  // use long temporarily for overflow detection

        boolean digitFound = false;

        while (i < n && Character.isDigit(s.charAt(i))) {
            digitFound = true;
            int digit = s.charAt(i) - '0';

            result = result * 10 + digit;

            // 4️⃣ Check overflow and clamp (rounding)
            if (sign == 1 && result > INT_MAX) return INT_MAX;
            if (sign == -1 && -result < INT_MIN) return INT_MIN;

            i++;
        }

        // If no digits found → return 0
        if (!digitFound) return 0;

        result *= sign;

        // Final safety clamp
        if (result > INT_MAX) return INT_MAX;
        if (result < INT_MIN) return INT_MIN;

        return (int) result;
    }
}
