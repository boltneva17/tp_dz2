import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Reader {
    private ArrayList<Integer> numbers = new ArrayList<>();
    public Reader(String path){
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()){
                numbers.add(scanner.nextInt());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public int _min(){
        int ans = (int) Math.pow(2, 32) - 1;
        for(int k : numbers){
            ans = Math.min(k, ans);
        }
        return ans;
    }

    public int _max(){
        int ans = (int)- Math.pow(2, 32) + 1;
        for(int k : numbers){
            ans = Math.max(k, ans);
        }
        return ans;
    }

    public int _sum(){
        int ans = 0;
        for(int k : numbers){
            ans += k;
        }
        return ans;
    }

    public int _mult(){
        int ans = 1;
        for(int k : numbers){
            ans *= k;
        }
        return ans;
    }
}
