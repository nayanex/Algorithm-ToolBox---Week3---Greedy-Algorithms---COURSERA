import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        double[] weightFractions = new double[values.length];
        int itemWithHighestValuePerWeight;
        double fraction;

        for (int i = 0; i < weights.length; i++){
            if (capacity == 0)
                return value;
            itemWithHighestValuePerWeight = getItemWithMaxValuePerWeight(values, weights);
            fraction = Math.min(capacity, weights[itemWithHighestValuePerWeight]);
            value += fraction * (values[itemWithHighestValuePerWeight]/weights[itemWithHighestValuePerWeight]);
            weights[i] -= fraction;
            weightFractions[i] += fraction;
            capacity -= fraction;
        }
        return value;
    }

    private static int SortItensByValuePerWeight (int[] values, int[] weights) {
        HashMap<Integer, Double> valuesPerWeight = new HashMap<Integer, Double>();
        double max = (double) values[0] / (double) weights[0];
        int maxKey = weights[0];

        for (int i = 0; i < values.length; i++){
            if (weights[i] > 0){
                valuesPerWeight.put(weights[i],(double)values[i] / (double) weights[i]);
            }
            else
                weights[i] = 0;
        }

        for (int i = 0; i < values.length; i++){
            if (((double) values[i] / (double)weights[i] > max ) && ( weights[i] > 0) ){
                max = values[i];
                maxKey = weights[i];
            }
        }

        maxValues.put(maxKey, max);

        Map.Entry<Integer,Double> entry = maxValues.entrySet().iterator().next();
        int key = entry.getKey();

        return key;
    }



    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
