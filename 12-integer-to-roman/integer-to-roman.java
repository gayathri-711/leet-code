class Solution {
    public String intToRoman(int num) {
        // Roman numeral values and their symbols (ordered greatest → smallest)
        int[] values =    {1000, 900, 500, 400, 100,  90,  50,  40,  10,   9,   5,   4,   1};
        String[] symbols ={"M", "CM","D", "CD","C", "XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        // Greedily match from largest to smallest
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
