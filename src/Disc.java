import java.util.Scanner;

public class Disc{

    private int numberOfDiscs;
    private String sequence;

    public Disc(int numberOfDiscs, String sequence) {
        this.numberOfDiscs = numberOfDiscs;
        this.sequence = sequence;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }
    public String getSequence() {
        return sequence;
    }


    public static String bitSequence(){
        Scanner scanner = new Scanner(System.in);
        String sequence="";
        while (true) {
            System.out.println("Please insert bit sequence you want to save in a RAID5 data storage");
            sequence = scanner.nextLine();

            if (sequence.matches("1[01]+")) {
                System.out.println("Sequence accepted: " + sequence);
                break;
            } else {
                System.out.println("Invalid sequence. The sequence must start with 1. Please try again.");
            }
        }
        return sequence;
    }

    public static int numOfDiscs(){
        Scanner scanner = new Scanner(System.in);
        String stringNumberOfDiscs="";
        while (true) {
            System.out.println("Please insert number of discs you want to use in a RAID5 data storage");
            stringNumberOfDiscs = scanner.nextLine();

            if (stringNumberOfDiscs.matches("[3-9]")){
                System.out.println("Number of discs accepted: " + stringNumberOfDiscs);
                break;
            } else {
                System.out.println("Invalid number of discs. Minimum value is 3, maximum value is 9. Please try again.");
            }
        }
        int number = Integer.parseInt(stringNumberOfDiscs);
        return number;
    }


}