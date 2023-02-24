import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class countwords {
    private ArrayList<String> ArrList;
    private TreeMap<String, Integer> ArrMap;
    private int max = 0;

    private static final Set<String> pretexts = Set.of(
            "в", "без", "до", "из", "к", "на", "по", "о", "от", "перед", "при", "с", "у", "за", "над", "об",
            "под", "про", "для");
    public countwords(String fileName) throws IOException {
        initCollections(fileName);
    }
    private void initCollections(String fileName) throws IOException {
        this.ArrList = new ArrayList<>();
        this.ArrMap = new TreeMap<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            while (reader.ready()){
                String str = reader.readLine().toLowerCase();

                String[] arrStr = str.trim().replaceAll("[—.,?!«»]*", "").split(" ");

                Set<String> words = Arrays.stream(arrStr).map(String::toLowerCase).collect(Collectors.toSet());
                words.removeAll(pretexts);

                ArrList.addAll(Arrays.asList(arrStr));
                ArrList.removeIf(x -> Objects.equals(x, ""));

                for (String s : words) {
                    if (!s.isEmpty() && this.ArrMap.containsKey(s))
                        ArrMap.put(s, ArrMap.get(s) + 1);
                    else {
                        ArrMap.put(s, 1);
                    }
                }
            }
        }
    }

    public String maxCountWord(){
        for(Map.Entry<String, Integer> i : this.ArrMap.entrySet()){
            if(i.getValue() > max)
            {max = i.getValue();}
//            else {i.getValue() = null;}
        }
        for(Map.Entry<String, Integer> i : this.ArrMap.entrySet()){
            if(i.getValue() == max )
                return i.getKey();
        }
        return null;
    }

    public int getMax() {
        return max;
    }
    public ArrayList<String> ArrList() {

        return this.ArrList;
    }
}