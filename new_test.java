
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;

public class new_test {

    public static void main(String[] args) throws IOException {
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();

        File textFile = new File("E:\\task2\\t8.shakespeare.txt");

        String data = FileUtils.readFileToString(textFile);
        Map<String, String> map = new HashMap<>();
        File t2 = new File("E:\\task2\\find_words.txt");
        String content, key, value, word1;
        Scanner st = new Scanner(t2);
        Scanner st3 = new Scanner(t2);
        File f = new File("E:\\task2\\frenchdic.txt");
        Scanner st1 = new Scanner(f);
        while (st1.hasNext()) {
            key = st1.next();
            value = st1.nextLine();
            map.put(key, value);
        }
        st1.close();
        content = data.toString();

        ArrayList<String> findWord = new ArrayList<>();
        while (st.hasNext()) {
            findWord.add(st.nextLine());
        }

        Iterator it = findWord.iterator();
        while (it.hasNext()) {

            word1 = (String) it.next();
            int i = 0;

            Pattern pattern = Pattern.compile(word1);
            Matcher matcher = pattern.matcher(content);
            while (matcher.find()) 
                ++i;
            System.out.println(word1 + ":" + i);
            data = data.replaceAll(word1 + "", map.get(word1) + "");
        }
        st.close();
        FileUtils.writeStringToFile(textFile, data);
        st3.close();
        long endTime = System.currentTimeMillis();
        System.out.println("Took " + (endTime - startTime) / 1000 + " seconds");
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long actualMemUsed;
        actualMemUsed = afterUsedMem - beforeUsedMem;
        System.out.print(actualMemUsed/(1024*1024)+"KB");
    }
}
