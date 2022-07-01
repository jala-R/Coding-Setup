package me.jalar.codingSetup;

import java.nio.file.*;
import java.util.*;
import me.jalar.codingSetup.Main;

public class Operation {
    public static void main(String[] args)throws Exception{
        String rootPath=args[0];
        String[][] files=null;
        try{
            files=getAllInputOutputFiles(rootPath+"/Inputs");
        }
        catch(Exception err){
            System.out.println(err.getMessage());
        }

        for(int i=0;i<files[0].length;i++){
            String testcaseNum="";
            testcaseNum+=(i+1);
            String cmdLineArgs[]={"TESTING",rootPath+"/Inputs/"+files[0][i],rootPath+"/Outputs/"+files[1][i],rootPath+"/ExepectedOutput/"+files[2][i],testcaseNum};
            Main.main(cmdLineArgs);

        }

        
        
    }
    public static String[][] getAllInputOutputFiles(String inputFolder)throws Exception{
        Path inputDir=Paths.get(inputFolder);
        DirectoryStream<Path> stream = Files.newDirectoryStream(inputDir);
        Iterator<Path> itr=stream.iterator();
        ArrayList<String> files=new ArrayList<>();
        while(itr.hasNext()){
            String str=itr.next().getFileName().toString();
            files.add(str);
        }

        System.out.println(files.size());


        String[][] fileList=new String[3][files.size()];

        for(int i=0;i<files.size();i++){
            int ind=getFileNumber(files.get(i));
            fileList[0][ind-1]=files.get(i);
            fileList[1][ind-1]="output"+ind+".txt";
            fileList[2][ind-1]=fileList[1][ind-1];
            // System.out.println(fileList[0][ind-1]+"  "+fileList[1][ind-1]+"  "+fileList[2][ind-1]);
        }
        return fileList;
    }

    public static int getFileNumber(String str){
        int ans=0;
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(isNum(c)){
                ans*=10;
                ans+=(c-'0');
            }
        }
        return ans;
    }

    public static boolean isNum(char c){
        return c>='0'&&c<='9';
    }
}
