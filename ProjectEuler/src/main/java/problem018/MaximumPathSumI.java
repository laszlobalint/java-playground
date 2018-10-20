package problem018;

import java.util.ArrayList;
import java.util.List;

public class MaximumPathSumI {

    public static void main(String[] args) {
        String[] data = data();
        List<List<Integer>> list = listList(data);
        System.out.println(maximumPathSolution(list));
    }

    private static String[] data() {
        String str = "75\n" +
                "95 64\n" +
                "17 47 82\n" +
                "18 35 87 10\n" +
                "20 04 82 47 65\n" +
                "19 01 23 75 03 34\n" +
                "88 02 77 73 07 63 67\n" +
                "99 65 04 28 06 16 70 92\n" +
                "41 41 26 56 83 40 80 70 33\n" +
                "41 48 72 33 47 32 37 16 94 29\n" +
                "53 71 44 65 25 43 91 52 97 51 14\n" +
                "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";
    return str.split("\n");
    }

    private static List<List<Integer>> listList (String[] array) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();

        temp.add(Integer.parseInt(array[0]));
        list.add(temp);

        for (int i = 1; i < array.length; i++) {
          String[] splitArray = array[i].split(" ");
          temp = new ArrayList<>();
            for (String aSplitArray : splitArray) {
                temp.add(Integer.parseInt(aSplitArray));
            }
          list.add(temp);
        }
        return list;
    }

    private static int maximumPathSolution(List<List<Integer>> list) {
        for (int j = list.size() - 2; j >= 0; j--) {
            for (int len = 0; len < list.get(j).size(); len++) {
                list.get(j).set(len, list.get(j).get(len) + Math.max(list.get(j + 1).get(len), list.get(j + 1).get(len + 1)));
            }
        }
        return list.get(0).get(0);
    }
}
