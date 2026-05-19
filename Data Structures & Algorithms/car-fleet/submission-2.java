class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] carData = new double[n][2];
        for(int i = 0; i < n; i++){
            carData[i][0]=position[i];
            carData[i][1]=(target-position[i])*1d/speed[i];
        }
        Arrays.sort(carData,(a,b)->Double.compare(a[0],b[0]));
        int nof = 0;
        double tt = 0;
        for(int i=n-1;i>=0;i--){
            if(carData[i][1]>tt){
                nof++;
                tt = carData[i][1];
            }
        }
        return nof;
    }
}
