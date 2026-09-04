import java.util.Scanner;

public class Productofarray{

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int prefix = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.print("Output: [");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}