public class Fib {


    public int[][] multiMatrix(int[][] matrix1, int[][] matrix2) {

        int[][] tempResult = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {//matrix1 行数
            for (int j = 0; j < matrix2[0].length; j++) { //matrix2的列数

                for (int k = 0; k < matrix2.length; k++) {
                    tempResult[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return tempResult;
    }


    public int[][] matrixPowwer(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];

        //先把res设为单位矩阵

        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }

        int[][] temp = m;

        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = multiMatrix(res, temp);
            }
            temp = multiMatrix(temp, temp);

        }
        return res;
    }

    //原始的Fibonacci sequence 的算法三：矩阵乘法 ，算法复杂度 ：O(logN)
    //爬台阶问题的分析：
    public int fibMethod(int n) {
        if (n < 1) return 0;

        if (n == 1 || n == 2) return 1;

        int[][] base = {{1, 1}, {1, 0}};

        int[][] result = matrixPowwer(base, n - 2);

        return result[0][0] + result[1][0];
    }

    //爬楼梯问题的分析
    public int climb_steps(int n) {
        if (n < 1) return 0;

        if (n == 1 || n == 2) return n;

        int[][] base = {{1, 1}, {1, 0}};

        int[][] result = matrixPowwer(base, n - 2);

        return 2 * result[0][0] + result[1][0];
    }

    //母牛下崽问题的分析
    public int cowAndBabies(int n) {
        if (n < 1) return 0;

        if (n == 1 || n == 2 || n == 3) return n;

        int[][] base = {{1, 1, 0}, {0, 0, 1}, {1, 0, 0}};

        int[][] result = matrixPowwer(base, n - 3);

        return 3 * result[0][0] + 2 * result[1][0] + result[2][0];
    }


    public static void main(String[] args) {
        int n = 8;
        Fib fib = new Fib();
        System.out.println(fib.fibMethod(n));

        System.out.println(fib.climb_steps(n));

        System.out.println(fib.cowAndBabies(n));


    }
}

