import java.util.ArrayList;
import java.util.List;

public class Cluster{

    public static void main(String[] args) {
        Disc disc = new Disc(Disc.numOfDiscs(), Disc.bitSequence());
        Cluster cluster = new Cluster();

        System.out.println(cluster.toList(disc));



    }


    public static List<Boolean> toList(Disc disc){

        String sequence = disc.getSequence();
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < sequence.length(); i++) {
            char character = sequence.charAt(i);
            if(character == '1'){
                list.add(true);
            }else{
                list.add(false);
            }

        }
        return list;
    }

    public static void discCreate(int number){

    }



}
