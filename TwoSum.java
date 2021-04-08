import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* 
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
*/

public class TwoSum {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList<>(); // Autoboxing likely so slow down exec time
        Collections.addAll(numList, 2,7,11,15);
        int target = 18;

        Service service = new Service();
        int[] result = service.run(numList, target);

        String response = String.format("The indeces in the list %s that equal target %s are %s", numList, target, Arrays.toString(result));
        System.out.println(response);
    }
}

class Service {
    public int[] run(List<Integer> numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (map.containsKey(target - numbers.get(i))) {   
                result[1] = map.get(target - numbers.get(i));
                result[0] = i;
                return result;
            }
            map.put(numbers.get(i), i);
        }
        return result;
    }

}