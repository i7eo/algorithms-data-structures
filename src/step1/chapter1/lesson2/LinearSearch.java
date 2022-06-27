package step1.chapter1.lesson2;

public class LinearSearch {
    private LinearSearch() {}
    public static int search(int[] data, int target) {
//        int _target = -1;
//        for(int i = 0; i < data.length; i++) {
//            if(data[i] == target) {
//                _target = i;
//            }
//        }
//        return _target;
        for(int i = 0; i < data.length; i++) {
            if(data[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] data = {24,14,12,9,16,32,66,4};

//        LinearSearch ls = new LinearSearch();

        int result = LinearSearch.search(data, 16);
        System.out.println(result);
        int result2 = LinearSearch.search(data, 666);
        System.out.println(result2);
    }
}
