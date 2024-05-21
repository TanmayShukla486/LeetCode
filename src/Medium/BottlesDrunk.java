package Medium;

public class BottlesDrunk {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int fullBottles = numBottles, emptyBottles = 0;
        int bottlesDrunk = 0;
        while (fullBottles != 0 || emptyBottles >= numExchange){
            bottlesDrunk += fullBottles;
            emptyBottles += fullBottles;
            fullBottles = 0;
            while (emptyBottles >= numExchange) {
                fullBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            }
        }
        return bottlesDrunk;
    }

    public static void main(String[] args) {
        new BottlesDrunk().maxBottlesDrunk(10, 3);
    }
}
