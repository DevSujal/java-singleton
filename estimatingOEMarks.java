import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class estimatingOEMarks {

    static class data {
        String name;
        double marks;

        data(String name,double marks) {
            this.name = name;
            this.marks = marks;
        }

        public String toString() {
            return name + " " + marks + "\n";
        }
    }
    

    public static void main(String[] args) {
        ArrayList<data> al = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("abc.txt"))) {
           String line, str[];
           while((line = bf.readLine()) != null){
               System.out.println(line);
            str = line.split(" ");
                if(str.length < 6){
                    continue;
                }
                al.add(new data(str[1] + " " + str[2] + " " + str[3], Double.parseDouble(str[str.length - 1])));
           }
        } catch (Exception e) {
            System.out.println("some err occured");
        }

        // Iterator<data>itr = al.iterator();
        // System.out.println(al.size());
        // while (itr.hasNext()) {
        //     System.out.println(itr.next());
        // }

        System.out.println(al + " " + al.size());

        ArrayList<data> al2 = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader("bbc.txt"))) {
           String line, str[];
           while((line = bf.readLine()) != null){
               System.out.println(line);
            str = line.split(" ");
                if(str.length < 6 || str[0].length() > 2){
                    continue;
                }
                al2.add(new data(str[1] + " " + str[2] + " " + str[3], Double.parseDouble(str[str.length - 1])));
           }
        } catch (Exception e) {
            System.out.println("some err occured");
        }

        System.out.println(al2 + " " + al2.size());

        ArrayList<data> n = new ArrayList<>();
        for(int i = 0; i < al.size(); i++){

            data d = al.get(i);
            for (int j = 0; j < al2.size(); j++) {
                data h = al2.get(j);
                // System.out.println(d + " " + h);
                if(d.name.split(" ")[0].equalsIgnoreCase(h.name.split(" ")[0])){
                    if(d.name.split(" ")[2].equalsIgnoreCase(h.name.split(" ")[2]) || d.name.split(" ")[2].equalsIgnoreCase(h.name.split(" ")[1]) || d.name.split(" ")[1].equalsIgnoreCase(h.name.split(" ")[2]) || d.name.split(" ")[1].equalsIgnoreCase(h.name.split(" ")[1])){

                        n.add(new data(d.name, d.marks + h.marks));
                    }
                }
            }
        }
        Collections.sort(n, new Comparator<data>() {
            public int compare(data d, data h){
                if(d.marks < h.marks){
                    return 1;
                }else if(d.marks > h.marks){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        });
        System.out.println(n + "" + n.size());
    }
}
