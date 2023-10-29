package misc.hashtableexec;

import java.util.*;

public class Main {

//    public static boolean itemInCommon(int[] s1, int[] s2) {
//        HashMap<Integer, Boolean> items = new HashMap<>();
//        for ( int i : s1 ) {
//            items.put(i,true);
//        }
//
//        for ( int j : s2 ) {
//            if (items.get(j) != null)
//                return true;
//        }
//        return false;
//    }

    public static boolean itemInCommon(int[] arr1, int[] arr2) {
        Set<Integer> items = new HashSet<Integer>();

        for ( int i : arr1 ) {
            items.add(i);
        }
        for ( int j : arr2) {
            if ( items.contains(j) ) {
                return true;
            }
        }
        return false;
    } // Time Complexity : O(n) , Space Complexity : O(n)

    public static List findDuplicates(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        List<Integer> resutlSet = new ArrayList<>();

        for (int num: nums) {
            numCounts.put(num, numCounts.getOrDefault(num,0) + 1);
        }

        for (Map.Entry<Integer,Integer> entry : numCounts.entrySet()) {
            if (entry.getValue() > 1) {
                resutlSet.add(entry.getKey());
            }
        }
        return resutlSet;
    } // Time Complexity : O(n) , Space Complexity : O(n)

    public static Character firstNonRepeatingChar(String s) {
        char[] charArray = s.toCharArray();
        Map<Character,Integer> charCounts = new HashMap<>();

        for ( int i = 0 ; i < s.length() ; i++ ) {
            charCounts.put(charArray[i], charCounts.getOrDefault(charArray[i],0) + 1);
        }

        for ( int i = 0 ; i < s.length() ; i++ ) {
            if ( charCounts.get(charArray[i]) == 1 ) {
                return charArray[i];
            }
        }

        return null;
    }  // Time Complexity : O(n) , Space Complexity : O(n)

    public static List<List<String>> groupAnagrams (String[] strings) {

        Map<String, List<String>> groupAnagram = new HashMap<>();

        for (String anagrams : strings) {

            char[] stringChars = anagrams.toCharArray();

            Arrays.sort(stringChars);

            String sortedChars = String.valueOf(stringChars);

            if (!groupAnagram.containsKey(sortedChars)) {
                groupAnagram.put(sortedChars, new ArrayList());
            }

            groupAnagram.get(sortedChars).add(anagrams);
        }
        return new ArrayList(groupAnagram.values());

    }  // Time Complexity: n * m log m , Space Complexity: O(n * m)

//    public static int[] twoSum(int[] nums, int target) {
//        if ( nums.length == 0 ) return null;
//
//        int start = 0 ;
//        int end = nums.length - 1;
//        int[] result = new int[2];
//
//        while ( start < end ) {
//            if ( nums[start] + nums[end] == target) {
//                result[0] = start;
//                result[1] = end;
//
//                return result;
//            } else {
//                start++;
//            }
//        }
//        return null;
//    } /// WRONG LOGIC

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();

        for ( int i = 0 ; i < nums.length ; i++ ) {
            int num = nums[i];
            int complement = target - num;

            if (complements.containsKey(complement)) {
                return new int[]{complements.get(complement),i};
            }

            complements.put(num,i);

        }
        return new int[]{};
    }


    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndex = new HashMap<>();

        sumIndex.put(0,-1);
        int currentSum = 0 ;

        for (int i = 0 ; i < nums.length ; i++ ){
            currentSum += nums[i];

            if(sumIndex.containsKey(currentSum - target)) {
                return new int[] {sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);
        }

        return new int[]{};

    }

    public static int subarraySumCount(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap < Integer, Integer > sumOccuranceMap = new HashMap < > ();
        sumOccuranceMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumOccuranceMap.containsKey(sum - k)) {
                count += sumOccuranceMap.get(sum - k);
            }
            sumOccuranceMap.put(sum, sumOccuranceMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }


    public static int longestConsecutiveSequence(int[] nums) {
//        if ( nums.length == 0 ) {
//            return 0 ;
//        }

        Set<Integer> numsList = new HashSet<>();

        for ( int num : nums ) {
            numsList.add(num);
        }

        int longestSequence = 0 ;

        for (int num : nums) {

            int nextNum = num;
            int sequence = 0;

            while(numsList.contains(nextNum)) {
                sequence++;
                nextNum++ ;
            }
            longestSequence = Math.max(sequence, longestSequence);
        }

        return longestSequence;

    } // Time Complexity: O(n) , Space Complexity: O(n)

//    public static HashMap<Integer, Double> paymentPlan (double orderAmount, int numOfInstallments, int frequencyInDay) {
//
//        HashMap <Integer, Double> paymentPlan1 = new HashMap <>();
//        double paymentInstallment = orderAmount / numOfInstallments;
//        int frequencyForInstallment = 0;
//        double remainingOrderAmount = orderAmount;
//
//        while(remainingOrderAmount != 0) {
//
//            paymentPlan1.put(frequencyForInstallment, paymentInstallment);
//            remainingOrderAmount = remainingOrderAmount - paymentInstallment;
//            frequencyForInstallment = frequencyForInstallment + frequencyInDay;
//
//        }
//        return paymentPlan1;
//    }

    public static List<int[]> calculateInstallments(double orderAmount, int numInstallments, int frequencyInDays) {
        List<int[]> installments = new ArrayList<>();

        // Calculate the equal payment amount for each installment.
        double equalPayment = orderAmount / numInstallments;

        int daysPassed = 0;
        double remainingAmount = orderAmount;

        for (int i = 0; i < numInstallments; i++) {
            // Calculate the due amount for this installment.
            double installmentAmount = Math.min(equalPayment, remainingAmount);

            // Add the installment to the list with days passed and the amount to pay.
            installments.add(new int[]{daysPassed, (int) Math.round(installmentAmount * 100) / 100});

            // Update days passed and remaining amount.
            daysPassed += frequencyInDays;
            remainingAmount -= installmentAmount;
        }

        return installments;
    }

    public static void main(String[] args) {

        int[] array1 = {1, 3, 5};
        int[] array2 = {2, 4, 5};

        System.out.println(itemInCommon(array1, array2));

        /*
            EXPECTED OUTPUT:
            ----------------
            true

        */

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

        System.out.println(firstNonRepeatingChar("leetcode"));
        System.out.println(firstNonRepeatingChar("hello"));
        System.out.println(firstNonRepeatingChar("aabbcc"));

        /*
            EXPECTED OUTPUT:
            ----------------
            l
            h
            null

        */

        System.out.println("1st set:");
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("\n2nd set:");
        System.out.println(groupAnagrams(new String[]{"abc", "cba", "bac", "foo", "bar"}));

        System.out.println("\n3rd set:");
        System.out.println(groupAnagrams(new String[]{"listen", "silent", "triangle", "integral", "garden", "ranged"}));

        /*
            EXPECTED OUTPUT:
            ----------------
            1st set:
            [[eat, tea, ate], [tan, nat], [bat]]

            2nd set:
            [[abc, cba, bac], [foo], [bar]]

            3rd set:
            [[listen, silent], [triangle, integral], [garden, ranged]]

        */
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 2, 3, 4, 5}, 3)));
        System.out.println(Arrays.toString(twoSum(new int[]{}, 0)));

        /*
            EXPECTED OUTPUT:
            ----------------
            [0, 1]
            [1, 2]
            [0, 1]
            []
            [2, 3]
            [0, 1]
            []

        */

        int[] nums1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        int[] result1 = subarraySum(nums1, target1);
        System.out.println("[" + result1[0] + ", " + result1[1] + "]");

        int[] nums2 = {-1, 2, 3, -4, 5};
        int target2 = 0;
        int[] result2 = subarraySum(nums2, target2);
        System.out.println("[" + result2[0] + ", " + result2[1] + "]");

        int[] nums3 = {2, 3, 4, 5, 6};
        int target3 = 3;
        int[] result3 = subarraySum(nums3, target3);
        System.out.println("[" + result3[0] + ", " + result3[1] + "]");

        int[] nums4 = {};
        int target4 = 0;
        int[] result4 = subarraySum(nums4, target4);
        System.out.println("[]");

        /*
            EXPECTED OUTPUT:
            ----------------
            [1, 3]
            [0, 3]
            [1, 1]
            []

        */
        int[] nums5 = {3, 4, 7, 2, -3, 1, 4, 2};
        int target5 = 7;
        int result5 = subarraySumCount(nums5, target5);
        System.out.println(result5);

//        int[] nums10 = {100, 4, 200, 1, 3, 2};
//        int longest = longestConsecutiveSequence(nums10);
//        System.out.println(longest);

        List<int[]> resultSet = calculateInstallments(100.01,4, 14);

        for (int[] installment : resultSet) {
            System.out.println("[" + installment[0] + ", " + installment[1] / 1.0 + "]");
        }
    }

}

