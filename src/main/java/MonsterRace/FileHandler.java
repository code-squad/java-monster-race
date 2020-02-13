package MonsterRace;

import java.io.*;

public class FileHandler {

  private static FileHandler fileHandler = new FileHandler();

  private String filePath = Text.FILE_PAHT.toString();

  private FileReader fileReader;
  private BufferedReader bufReader;

  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;

  private FileHandler() {
    try {
      fileReader = new FileReader(new File(filePath));
      bufReader = new BufferedReader(fileReader);
    } catch (Exception e) {
      System.out.println(Text.E_FILE);
    }
  }

  public void connectNewFile(String filePath) throws Exception {
    this.filePath = filePath;
    fileReader = new FileReader(new File(this.filePath));
    bufReader = new BufferedReader(fileReader);
  }

  public String getFileData() throws Exception {
    StringBuilder resultString = new StringBuilder();
    String line;

    while ((line = bufReader.readLine()) != null) {
      resultString.append(line + "\n");
    }

    return resultString.toString();
  }

  public void setFileData(String fileData) throws Exception {
    System.out.println(fileData);
  }

  public static FileHandler getInstance() {
    return fileHandler;
  }

  public void close() {
    try {
      bufReader.close();
      fileReader.close();
    } catch (Exception e) {
      System.out.println(Text.E_CLOSE);
    }
  }
}
