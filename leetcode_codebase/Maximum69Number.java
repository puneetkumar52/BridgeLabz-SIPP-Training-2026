// you are given a positive integer num consisting only of digit 6 and 9.
class Maximum69Number {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);

        int index = s.indexOf('6');

        if (index != -1) {
            s = s.substring(0, index) + "9" + s.substring(index + 1);
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        Maximum69Number solution = new Maximum69Number();
        int num = 9669;
        int result = solution.maximum69Number(num);
        System.out.println(result); 
    }
}