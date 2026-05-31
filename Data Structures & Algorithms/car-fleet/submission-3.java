class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        double[][] carData = new double[n][2];
        for(int i=0;i<n;i++){
            carData[i][0]=position[i];
            carData[i][1]=(target-position[i])*1.0/speed[i];
        }
        Arrays.sort(carData,(a,b)->Double.compare(a[0],b[0]));
        int carFleet = 1;
        double time = carData[n-1][1];
        for(int i=n-2;i>=0;i--){
            if(time<carData[i][1]){
                carFleet++;
                time = carData[i][1];
            }
        }
        return carFleet;
    }
}
