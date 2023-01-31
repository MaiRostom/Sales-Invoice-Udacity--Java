//import java.io.*;
//import java.util.*;
//
//public class CSVConverter {
//    public static void main(String[] args) throws IOException {
//        // Open the input and output files
//        File inputFile = new File("/home/amr/Downloads/Sales-Invoice-Generator-Java-main/src/studen.txt");FileP
//        File outputFile = new File("output.csv");
//        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
//
//        // Read the first line of the input file as the headers
//        String headers = reader.readLine();
//
//        // Write the headers to the output file
//        writer.write(headers.replace("#", ","));
//        writer.newLine();
//
//        // Read the rest of the input file and write the data to the output file
//        String line;
//        int id = 1;
//        while ((line = reader.readLine()) != null) {
//            String[] values = line.split("#");
//            writer.write(id + ",");
//            for (int i = 0; i < values.length; i++) {
//                writer.write(values[i]);
//                if (i < values.length - 1) {
//                    writer.write(",");
//                }
//            }
//            writer.newLine();
//            id++;
//        }
//
//        // Close the files
//        reader.close();
//        writer.close();
//    }
//}
/////////////////////////////////////////////////
//import java.io.*;
//
//public class calss {
//    public static void main(String[] args) throws IOException {
//        // Define the input file path
//        String inputFilePath = "/home/amr/Downloads/Sales-Invoice-Generator-Java-main/src/studentdata.txt";
//        // Define the output file path
//        String outputFilePath = "/home/amr/Downloads/Sales-Invoice-Generator-Java-main/out/file3.csv";
//
//        // Read the input file
//        BufferedReader br = new BufferedReader(new FileReader(inputFilePath));
//
//        // Write the headers row to the output file
//        String headers = br.readLine();
//     //   headers = "id," + headers;
//        BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath));
//        bw.write(headers);
//        bw.newLine();
//
//        // Read and process the rest of the file
//        String line = "";
//        int id = 1;
//        while ((line = br.readLine()) != null) {
//            // Replace the separator # with ,
//        	System.out.print("asdasd");
//            line = line.replace("#", ",");
//            // Add the id to the start of the line
//            line = id + "," + line;
//            // Write the line to the output file
//            bw.write(line);
//            bw.newLine();
//            id++;
//        }
//
//        // Close the file streams
//        br.close();
//        bw.close();
//    }
//}
////////////////////////////////////////////////////////
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//public class CSVConverter {
//  
//
//    
//   
//
//    public static void main(String[] args) throws IOException {
//    	
//    }
//    public  String readFile(){
//
//
//    	 File inputFile = new File("/home/amr/Downloads/Sales-Invoice-Generator-Java-main/src/studen.txt");
//
//
//        try (Scanner scanner = new Scanner(inputFile)) {
//
//
//            while (scanner.hasNext()) {
//                String S_data = scanner.nextLine();
//
//
//                S_data = S_data.replace("$", "\n");
//                S_data = S_data.replace("#", " , ");
//                String[] data_student = S_data.split("\n");
//                String output = "";
//                    for (int i = 0; i < data_student.length; i++) {
//                        String[] row = data_student[i].split(",");//row
//                        if (i == 0) {
//                        for (int k = 0; k < row.length; k++) {
//
//                                    //row1
//                        	output +="id         "+ row[0] + "           " + row[1] + "              " + row[2] + "           " + row[3] + "                 " + row[4] + "                   "
//                                            + row[5] + "                ";
//                                 break;
//                        }
//                        //i>0
//                    } else {
//
//                        if (i > 0) {
//                        	output += "\n" + i+"   ";
//                        }
//
//
//
//                        for (int k = 0; k < row.length; k++) {
//
//                            if(row.length==6) {
//                               // row[3] += row[3];
//                                                        //name         //grade            //email           //address
//                            	output += "   ," + row[0] + "     ," + row[1] + "    ," + row[2] + "   ," + row[3] +" ,"+row[4]+" ,"
//                                        + row[5];
//                                break;
//                            } else if (row.length==7) {
//                                row[3] += row[4]+row[5];
//                                output += "   ," + row[0] + "     ," + row[1] + "    ," + row[2] + "   ," + row[3] + "        ,"
//                                        + row[6];
//                                break;
//
//                        } else if (row.length==6&&row[k].length() >= 12) {
//                                row[3]+=row[4];
//                                output +="  ," + row[0] + " ," + row[1] + " ," + row[2] + "   ," + row[3] + "        ,"
//                                        + row[5] ;
//                                break;
//                            }
////                            if (row[k].length() >= 12) {
////                                FinalData += "," + row[k];
//                                    else
//                                for (int j = 0; j < 12; j++) {
//                                    if(j==0){
//                                    	output +=","+row[k].charAt(j);
//                                    }
//                                    if (j < row[k].length()) {
//
//                                    	output += row[k].charAt(j);
//
//
//                                    } else {
//                                    	output += "";
//
//                                    }
//                                }
//
//
//                        }
//
//                    }
//                }
//                File file2=new File("/home/amr/Downloads/Sales-Invoice-Generator-Java-main/out/file.csv");
//                FileWriter wr = new FileWriter(file2);
//                wr.write(output);
//
//                wr.flush();
//
//                wr.close();
//                System.out.println(output);
//                //  System.out.println(StData[]);
//                return output ;
//
//            }
//        } 
//        catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//       return null;
//    
//    
//
//    
//    
//
//}      
//}

/////////////////////////////////////
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class XMLConverter {
    public static void main(String[] args) {
        // Step 1: Read the text file
        try (BufferedReader reader = new BufferedReader(new FileReader("studentdata.txt"))) {
            String line;
            int id = 1;
            StringBuilder output = new StringBuilder();
            
            // Step 2: Add an id at the start of each record
            while ((line = reader.readLine()) != null) {
                String[] records = line.split("\\$");
                for (String record : records) {
                    output.append(id).append(",").append(record.replace("#", ",")).append("\n");
                    id++;
                }
            }
            
            // Step 3: Replace the separator # with ,
            // Step 4: Replace the separator $ with \n
            
            // Step 5: Write the final output to a CSV file
            System.out.println();
            try (FileWriter writer = new FileWriter("txtCSV.csv")) {
                writer.write(output.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
