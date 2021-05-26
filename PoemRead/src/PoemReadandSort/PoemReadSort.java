package PoemReadandSort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.*;

public class PoemReadSort {
    public static boolean readPoemTreeSetWay(String fileName) {
        BufferedReader reader = null;
        String[] wordsArray;
        TreeSet <String> words = new TreeSet <>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                wordsArray = line.split("\\s*(=>|,|!|\\.|:|;|\\?|\\s)\\s*");
                for (int i = 0; i < wordsArray.length; i++) {
                    words.add(wordsArray[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Iterator iterator;
        iterator = words.iterator();
        System.out.println("Poem words in ascending order: ");
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + " ");
        }
        return true;
    }

    public static boolean readPoemLexicographically(String fileName) {
        BufferedReader reader = null;
        String[] wordsArray;
        List <String> list = new ArrayList <>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                wordsArray = line.split("\\s*(=>|,|!|\\.|:|;|\\?|\\s)\\s*");
                for (int i = 0; i < wordsArray.length; i++) {
                    list.add(wordsArray[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < list.size() - 1; ++i) {
            for (int j = i + 1; j < list.size(); ++j) {
                if (list.get(i).toLowerCase().compareTo(list.get(j).toLowerCase()) > 0) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.println("In lexicographical order:");
        for (String temp : list) {
            System.out.println(temp);
        }
        return true;
    }


    public static Map <String, Integer> sortLocaleHun(String fileName) throws ParseException {

        String hungarianRules = ("< a,A < á,Á < b,B < c,C < cs,Cs,CS < d,D < dz,Dz,DZ < dzs,Dzs,DZS" +
                "< e,E < é,É < f,F < g,G < gy,Gy,GY < h,H < i,I < í,Í < j,J" +
                "< k,K < l,L < ly,Ly,LY < m,M < n,N < ny,Ny,NY < o,O < ó,Ó" +
                "< ö,Ö < ő,Ő < p,P < q,Q < r,R < s,S < sz,Sz,SZ < t,T" +
                "< ty,Ty,TY < u,U < ú,Ú < ü,Ü < ű,Ű < v,V < w,W < x,X < y,Y < z,Z < zs,Zs,ZS");

        BufferedReader reader = null;
        String[] wordsArray;
        List <String> list = new ArrayList <>();
        Map<String, Integer> wordCount = new HashMap <>();

        List once = new ArrayList();
        List twice = new ArrayList();
        List three = new ArrayList();
        List four = new ArrayList();
        List five = new ArrayList();
        List six = new ArrayList();
        Map<Integer, List> listMap = new TreeMap <>();

        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                wordsArray = line.split("\\s*(=>|,|!|\\.|:|;|\\?|\\s)\\s*");
                for (int i = 0; i < wordsArray.length; i++) {
                    list.add(wordsArray[i]);
                    int counter = 1;
                    if (wordCount.containsKey(wordsArray[i])) {
                        counter = wordCount.get(wordsArray[i]);
                        counter++;
                        wordCount.replace(wordsArray[i], counter);
                    } else {
                        wordCount.put(wordsArray[i], counter);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();

        List<WordCounterWrapper> wrapperList = new ArrayList <>();
        for (String key: wordCount.keySet()) {
            wrapperList.add(new WordCounterWrapper(key, wordCount.get(key)));
        }

        Collections.sort(wrapperList);
        System.out.println(wrapperList);

        RuleBasedCollator hunCollator = new RuleBasedCollator(hungarianRules);
        sortStrings(hunCollator, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
        Iterator it = wordCount.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            System.out.println(pair.getKey() + "=" + pair.getValue());

            // Order in a TreeMap where key is going to be the number, value is a list with words!
            if (pair.getValue().equals(1)) {
                once.add(pair.getKey());
            }
            if (pair.getValue().equals(2)) {
                twice.add(pair.getKey());
            }
            if (pair.getValue().equals(3)) {
                three.add(pair.getKey());
            }
            if (pair.getValue().equals(4)) {
                four.add(pair.getKey());
            }
            if (pair.getValue().equals(5)) {
                five.add(pair.getKey());
            }
            if (pair.getValue().equals(6)) {
                six.add(pair.getKey());
            }
            it.remove();
        }
        listMap.put(1, once);
        listMap.put(2, twice);
        listMap.put(3, three);
        listMap.put(4, four);
        listMap.put(5, five);
        listMap.put(6, six);
        System.out.println(listMap);
        return wordCount;
    }

    public static void sortStrings(Collator collator, List words) {
        String tmp;
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                if (collator.compare(words.get(i), words.get(j)) > 0) {
                    tmp = (String) words.get(i);
                    words.set(i, words.get(j));
                    words.set(j, tmp);
                }
            }
        }
    }
}
