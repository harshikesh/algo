/**
 * Created by harshikesh.kumar on 21/01/17.
 */
public class WaterTap {
    public static void main(String[] args) {
        int[] testbuilding = {3,1,0,2,0,4,0};
        System.out.println("Water Volume : " + getWaterVolume(testbuilding));
    }

    public static int getWaterVolume(int[] buildings)
    {
        int level =0;
        if(buildings[0]<buildings[buildings.length-1]) {
            level = buildings[0];
        } else {
            level = buildings[buildings.length-1];
        }
        int waterVolume =0;
        for(int build:buildings)
        {
            if(build <= level)
            {
                waterVolume = waterVolume + (level-build);
            }
        }
        return waterVolume;
    }
}
