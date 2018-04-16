import java.util.HashMap;


public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        int[] ret = new int[2];
	for (int i = 0; i < list.length; i++) {
		for (int j = i + 1; j < list.length; j++) {
			if (list[i] + list[j] == sum) {
				ret[0] = i ;
				ret[1] = j;
				return ret;
			}
		}
	}
	return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }
    
    public static int[] findTwoSum_2(int[] numbers, int target) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	int[] result = new int[2];
     
    	for (int i = 0; i < numbers.length; i++) {
    		if (map.containsKey(numbers[i])) {
    			int index = map.get(numbers[i]);
    			result[0] = index+1 ;
    			result[1] = i+1;
    			break;
    		} else {
    			map.put(target - numbers[i], i);
    		}
    	}
     
    	return result;
        }

}