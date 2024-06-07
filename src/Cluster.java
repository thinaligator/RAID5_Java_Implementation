import java.util.ArrayList;
import java.util.List;

public class Cluster{

    public static void main(String[] args) {
        Disc disc = new Disc(Disc.numOfDiscs(), Disc.bitData());
        Cluster cluster = new Cluster();
        List<List<Boolean>> listOfDiscs = cluster.createDiscList(disc);

        List<Boolean> list = cluster.toList(disc);
        saveData(list, listOfDiscs);

        for (int i = 0; i < listOfDiscs.size(); i++) {
            System.out.println("Disc " + i + ": " + listOfDiscs.get(i));
        }
    }

    public static void sumControl(List<List<Boolean>> listOfDiscs) {
        int numberOfDiscs = listOfDiscs.size();
        int dataSize = listOfDiscs.get(0).size();
        int skipIndex = numberOfDiscs - 1;
        boolean decrementing = true;

        for (int i = 0; i < dataSize; i++) {
            boolean parityBit = false;
            for (int j = 0; j < numberOfDiscs; j++) {
                if (j != skipIndex) {
                    boolean dataBit = listOfDiscs.get(j).get(i);
                    parityBit ^= dataBit;
                    parityBit = !parityBit;
                }
            }
            listOfDiscs.get(skipIndex).set(i, parityBit);

            if (decrementing) {
                skipIndex--;
                if (skipIndex < 0) {
                    skipIndex = 1;
                    decrementing = false;
                }
            } else {
                skipIndex++;
                if (skipIndex >= numberOfDiscs) {
                    skipIndex = numberOfDiscs - 2;
                    decrementing = true;
                }
            }
        }
    }

    public static void saveData(List<Boolean> list, List<List<Boolean>> listOfDiscs) {
        int numberOfDiscs = listOfDiscs.size();
        int dataLength = list.size();
        int dataLength2 = list.size();
        int totalLength = dataLength + (numberOfDiscs - 1 - (dataLength % (numberOfDiscs - 1)));

        for (int i = dataLength; i < totalLength; i++) {
            list.add(false);
        }

        int currentIndex = 0;
        boolean decrementing = true;
        int skipIndex = numberOfDiscs - 1;

        while (currentIndex < totalLength) {
            int currentIterationStartIndex = currentIndex;
            for (int i = 0; i < numberOfDiscs; i++) {
                if (i == skipIndex) {
                    listOfDiscs.get(i).add(false);
                } else {
                    if (currentIndex < totalLength) {
                        Boolean bit = list.get(currentIndex);
                        listOfDiscs.get(i).add(bit);
                        currentIndex++;
                    }
                }
            }

            if (currentIndex == currentIterationStartIndex) {
                break;
            }
            //alg do przechodzenia dla sumie kontr
            if (decrementing) {
                skipIndex--;
                if (skipIndex < 0) {
                    skipIndex = 1;
                    decrementing = false;
                }
            } else {
                skipIndex++;
                if (skipIndex >= numberOfDiscs) {
                    skipIndex = numberOfDiscs - 2;
                    decrementing = true;
                }
            }

        }
        if (dataLength2 % (listOfDiscs.size() -1) == 0) {
            for (List<Boolean> disc : listOfDiscs) {
                disc.remove(disc.size() - 1);
            }
        }

        sumControl(listOfDiscs);
    }




    public static List<List<Boolean>> createDiscList(Disc disc){
        List<List<Boolean>> listOfDiscs = new ArrayList<>();
        int numberOfDiscs = disc.getNumberOfDiscs();
        for(int i=0; i<numberOfDiscs; i++){
            List<Boolean> list = new ArrayList<>();
            listOfDiscs.add(list);
        }
        return listOfDiscs;
    }

    public static List<Boolean> toList(Disc disc){

        String data = disc.getData();
        List<Boolean> list = new ArrayList<>();

        for (int i = 0; i < data.length(); i++) {
            char character = data.charAt(i);
            if(character == '1'){
                list.add(true);
            }else{
                list.add(false);
            }

        }
        return list;
    }
}
