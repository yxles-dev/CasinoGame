import java.io.*;

public class TextReader {
    private String location;
    private String text;

    // Getter
    public String getText(String fileLocation) throws FileNotFoundException {

        this.location = fileLocation;
        FileReader reader = new FileReader(location);
        BufferedReader br = new BufferedReader(reader);
        String line;
        StringBuilder sb = new StringBuilder();

        try {
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        text = sb.toString();
        return text;
    }
}
