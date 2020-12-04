
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.commons.io.FileUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shyam_s_sundar
 */
public class NewClass {
    
        public static void main(String[] args) throws IOException {
        File textFile = new File("E:\\task2\\t8.shakespeare.txt");
        
        String data = FileUtils.readFileToString(textFile);
        Map<String, String> map = new HashMap<>();
        File t2 = new File("E:\\task2\\find_words.txt");
        String word1, word2;
        Scanner st3 = new Scanner(t2);
        
        while (st3.hasNext()) {
            word1 = st3.next();
            int i=0;
            File f3=new File("E:\\task2\\t8.shakespeare.txt");
            Scanner st2 = new Scanner(f3);
            while (st2.hasNext()) {
                word2 = st2.next();
                if (word1.equals(word2)) {
                    ++i;
                }
            }
            System.out.println(word1 + ":" + i);
        }
        File f = new File("E:\\task2\\frenchdic.txt");
        Scanner st1 = new Scanner(f);
        String key, value;
        while (st1.hasNext()) {
            key = st1.next();
            value = st1.nextLine();
            map.put(key, value);
        }
        Scanner st = new Scanner(t2);
        String findWords;
        while (st.hasNext()) {
            findWords = st.next();
            String replaceFrench = map.get(findWords);
            data = data.replace(findWords + "", replaceFrench + "");
            FileUtils.writeStringToFile(textFile, data);
        }
    }
}
