class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] carData = new double[position.length][2];
        for(int i = 0;i<position.length;i++){
            carData[i][0]=position[i]*1d;
            carData[i][1]=((target-position[i])*1d/speed[i])*1d;
        } 
        Arrays.sort(carData,(a,b)->Double.compare(a[0],b[0]));
        int nof = 1;
        double tt=carData[position.length-1][1];
        for(int i=carData.length-2;i>=0;i--){
            if(carData[i][1]>tt){
                nof++;
                tt=carData[i][1];
            }
        }
        return nof;
    }
}
