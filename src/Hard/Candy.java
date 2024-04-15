package Hard;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        // Using the Greedy Two Pass Approach
        // Going from left to right and if left rating is less than current increasing candy count
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) candies[i] = candies[i - 1] + 1;
        }
        // Going from right to left and checking if the current rating is greater than right and if yes
        // then we compare candy counts and if current candy count <= right candy count we increase our
        // candy count
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]
                    && candies[i] <= candies[i + 1]) candies[i] = candies[i + 1] + 1;
        }
        // since each child has one candy minimum the candy count is initially equal to the
        // number of children
        int count = ratings.length;
        // adding all candy counts to get the final answer
        for (int candy: candies) count += candy;
        return count;
    }
}
