package org.smallworld.automation.utils;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class folderOptions {
    public List <String> fileList;
    public static String dir = System.getProperty("user.dir");
    public static final String HtmlReport = dir+"\\target\\cucumber-reports\\report.html";
    public static final String SOURCE_FOLDER = dir+"\\target\\reports\\Screenshots\\"; // SourceFolder path

    public void deleteScreenShotImages() throws IOException{

        File dir =new File(SOURCE_FOLDER);

        if(!dir.isDirectory()) {
            System.out.println("Not a directory. Do nothing");
            return;
        }
        File[] listFiles = dir.listFiles();
        for(File file : listFiles){
            System.out.println("Deleting "+file.getName());
            file.delete();
        }
    }
    public void deleteHtmlReport(){
        File report = new File(HtmlReport);
        report.delete();
    }



}
