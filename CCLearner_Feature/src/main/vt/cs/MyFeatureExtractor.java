package vt.cs;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hasee on 2018/4/8.
 */
public class MyFeatureExtractor {
    public static void traverseFolder(List<String> filePathList, String path) {
        File file = new File(path);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                for (File file2 : files) {
                    traverseFolder(filePathList, file2.getAbsolutePath());
                }
            } else {
                String p = file.getAbsolutePath();
                if (p.endsWith(".java")) {
                    filePathList.add(p);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. 获取FileList, 同老Parser
        List<String> filePathList = new ArrayList<String>();

        traverseFolder(filePathList, "D:\\MyProjectsRepertory\\APIMiner\\ASTParser\\src\\main\\data\\BCB-sample\\func2\\codebase");
        Writer fw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(new File("codebase.json")), "UTF-8"));
//        traverseFolder(filePathList, "D:\\MyProjectsRepertory\\APIMiner\\ASTParser\\src\\main\\data\\BCB-sample\\func2\\curCodeFragment");
//        Writer fw = new BufferedWriter(new OutputStreamWriter(
//                new FileOutputStream(new File("curCodeFragments.json")), "UTF-8"));

        // 2. 获取每个Method的特征(Class/MethodName, filePath. freqLists)，并记录成Json格式
        ASTParserTool parserTool = new ASTParserTool();
        MethodList methodVectorList;

        Gson gson = new Gson();
        Map<String, Integer> freqDict;
        MethodDetail methodDetail;
        int fileCount = 0;

        System.out.println(filePathList.size());
        for (String javaFilePath : filePathList) {
            methodVectorList = parserTool.parseMethod(javaFilePath);
            for (MethodVector methodVector : methodVectorList.methodList) {
                methodDetail = new MethodDetail();
                methodDetail.setClassName(((NewMethodVector) methodVector).className);
                methodDetail.setFilePath(((NewMethodVector) methodVector).filePath);
                methodDetail.setMethodName(((NewMethodVector) methodVector).methodName);

                methodDetail.setReservedDict(calcFreqDict(methodVector.methodReservedWordTokenList.tokenList));
                methodDetail.setTypeDict(calcFreqDict(methodVector.methodTypeTokenList.tokenList));
                methodDetail.setLiteralDict(calcFreqDict(methodVector.methodLiteralTokenList.tokenList));
                methodDetail.setVariableDict(calcFreqDict(methodVector.methodVariableTokenList.tokenList));
                methodDetail.setFunctionNameDict(calcFreqDict(methodVector.methodFunctionNameTokenList.tokenList));
                methodDetail.setQualifiedNameDict(calcFreqDict(methodVector.methodQualifiedNameTokenList.tokenList));
                methodDetail.setOperatorDict(calcFreqDict(methodVector.methodOperatorTokenList.tokenList));
                methodDetail.setMarkerDict(calcFreqDict(methodVector.methodMarkerTokenList.tokenList));

                fw.write(gson.toJson(methodDetail) + "\n");
                fw.flush();
//                System.out.println(gson.toJson(methodDetail));
            }
            fw.flush();
            if (++fileCount % 1000 == 0) {
                System.out.println(fileCount);
            }
        }
    }

    private static Map<String, Integer> calcFreqDict(ArrayList<TokenVector> tokenList) {
        Map<String, Integer> freqDict = new HashMap<>();
        for (TokenVector tokenVector : tokenList) {
            freqDict.put(tokenVector.TokenName, tokenVector.TokenCount);
        }
        return freqDict;
    }
}
