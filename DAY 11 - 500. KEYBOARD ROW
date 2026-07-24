class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        // Map each character to its row index
        int[] charToRow = new int[26];
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                charToRow[c - 'a'] = i;
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            String lower = word.toLowerCase();
            int row = charToRow[lower.charAt(0) - 'a'];
            boolean valid = true;

            for (char c : lower.toCharArray()) {
                if (charToRow[c - 'a'] != row) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        return result.toArray(new String[0]);
    }
}
