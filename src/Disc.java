import java.util.Scanner;

public class Disc{

    private int numberOfDiscs;
    private String data;

    public Disc(int numberOfDiscs, String data) {
        this.numberOfDiscs = numberOfDiscs;
        this.data = data;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }
    public String getData() {
        return data;
    }


    public static String bitData(){
        Scanner scanner = new Scanner(System.in);
        String data="";
        while (true) {
            System.out.println("Please insert bit sequence you want to save in a RAID5 data storage");
            data = scanner.nextLine();

            if (data.matches("1[01]+")) {
                System.out.println("Sequence accepted: " + data);
                break;
            } else {
                System.out.println("Invalid sequence. The sequence must start with 1. Please try again.");
            }
        }
        return data;
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