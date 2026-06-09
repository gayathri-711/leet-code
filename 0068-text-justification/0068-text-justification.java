class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i;
            int lineLength = 0;

            // Find how many words fit in the current line
            while (j < words.length &&
                   lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int numWords = j - i;
            int spaces = maxWidth - lineLength;

            StringBuilder line = new StringBuilder();

            // Last line or single word line -> left justify
            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                        spaces--;
                    }
                }

                while (spaces-- > 0) {
                    line.append(" ");
                }
            } 
            // Fully justify
            else {
                int gaps = numWords - 1;
                int evenSpaces = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int currentSpaces = evenSpaces;
                        if (extraSpaces > 0) {
                            currentSpaces++;
                            extraSpaces--;
                        }

                        while (currentSpaces-- > 0) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}