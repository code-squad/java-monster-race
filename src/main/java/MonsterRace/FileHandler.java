package MonsterRace;

import java.io.*;

public class FileHandler {

  private static FileHandler fileHandler = new FileHandler();

  private File file;
  private String filePath = Text.FILE_PAHT.toString();

  private FileReader fileReader;
  private BufferedReader bufReader;

  private FileWriter fileWriter;
  private BufferedWriter bufferedWriter;

  private FileHandler() {
    try {
      file = new File(filePath);

      fileReader = new FileReader(file);
      bufReader = new BufferedReader(fileReader);
    } catch (Exception e) {
      System.out.println(Text.E_FILE);
    }
  }

  // 새로운 파일로 연결하고 싶을 시 생성자 오버로딩을 이용하고 싶은데
  // 싱글톤 패턴에서 사용해도 유효할까요?
  public void connectNewFile(String filePath) throws Exception {
    this.filePath = filePath;
    file = new File(this.filePath);

    fileReader = new FileReader(file);
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
//    BufferedOutputStream bs = null;
//
//    bs = new BufferedOutputStream(new FileOutputStream("D:/Eclipse/Java/Output.txt"));
//    String str = "오늘 날씨는 아주 좋습니다.";
//    bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음
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
