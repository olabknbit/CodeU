package Session4;

public class Change {

    int makeChange(int value, int[] coins, int kth){
        if(coins.length - 1 == kth){
            if(value % coins[kth] == 0){
                return 1;
            }
            else return 0;
        }
        int numberOfWays = 0;
        while(value >= coins[kth]){
            numberOfWays += makeChange(value, coins, kth+1);
            value -= coins[kth];
        }
        return value == 0 ? numberOfWays+1 : numberOfWays;
    }
    public static void main(String[] args){
        Change change = new Change();
        System.out.println("should return 4:" + change.makeChange(10, new int[]{2, 3, 5}, 0));
        System.out.println("should return 0:" + change.makeChange(1, new int[]{2, 3, 5}, 0));
        System.out.println("throws an exception - dividing by 0:" + change.makeChange(1, new int[]{0}, 0));
    }
}
