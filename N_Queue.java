public class N_Queue {

    public int number(int n) {
        if (n < 1) return 0;

        int[] record = new int[n];

        return process(0, record, n);
    }

    public boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (record[k] == j || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    public int process(int i, int[] record, int n) {
        if (i == n) return 1;

        int res = 0;
        for (int j = 0; j < n; j++) {
            if (isValid(record, i, j)) {
                record[i] = j;
                res += process(i + 1, record, n);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        N_Queue Quene = new N_Queue();

        for (int i = 0;i<21;i++){
            System.out.println( "i = "+ i + " N_Queue result = " + Quene.number(i));
        }


    }


}
