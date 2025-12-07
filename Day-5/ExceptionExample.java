public class ExceptionExample {
    public static void main(String[] args) {

        int[] arr = { 2, 4, 3 };
        try {
            System.out.println(arr[5]);
        } catch (Exception e) {
            System.out.println("Error occured");
        } finally {
            System.out.println("Completed");
        }
    }
}
