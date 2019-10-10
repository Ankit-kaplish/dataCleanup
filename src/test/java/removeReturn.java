import java.io.*;

public class removeReturn {
    public static void main(String[] args) {
        String fileNamePathInput = "something";
        String fileNamePathOutput = "something";
        String delimiter = ",";
        File fileIp = new File(fileNamePathInput);
        File fileOp = new File(fileNamePathOutput);

        try (BufferedReader reader = new BufferedReader(new FileReader(fileIp));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileOp))

        ) {
            String header = reader.readLine();
            int count = header.split(delimiter).length;
            writer.write(header + "\n");
            StringBuilder line;
            while ((line = new StringBuilder(reader.readLine())) != null) {
                while (line.toString().split(delimiter).length != count) {
                    line.append(reader.readLine());
                }
                writer.write(line.toString());
            }

            writer.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
