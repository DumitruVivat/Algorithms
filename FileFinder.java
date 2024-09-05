import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileFinder {
  public static void main(String[] args) {

    ArrayList<File> fileList = new ArrayList<>();
    searchFile(new File("/Users/dumitruvivat/Desktop"), fileList);
    for (File file : fileList) {
      System.out.println(file.getAbsolutePath());
    }
  }

  private static void searchFile(File rootfFile, List<File> fileList) {
    if (rootfFile.isDirectory()) {
      System.out.println("searging at: " + rootfFile.getAbsolutePath());
      File[] directoryFiles = rootfFile.listFiles();
      if (directoryFiles != null) {
        for (File file : directoryFiles) {
          if (file.isDirectory()) {
            searchFile(file, fileList);
          } else {
            if (file.getName().toLowerCase().endsWith(".jpg")) {
              fileList.add(file);
            }
          }
        }
      }
    }
  }
}
