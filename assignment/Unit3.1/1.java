class Solution {
    public void sum(int[] a, int n, int x) {
        int res = 0;
        for (int i = 0; i <= n; i++) {
            res += a[i] * Math.pow(x, i);
        }
        System.out.println(res);
    }

    public void sum2(int[] a, int n, int x) {
        int res = a[0];
        for (int i = 1; i <= n; i++) {
            res += a[i] * x;
            x *= x;
        }
        System.out.println(res);
    }
}
