package vt.cs;

/**
 * Created by hasee on 2018/4/4.
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        String filePath = "D:\\MyProjectsRepertory\\APIMiner\\ASTParser\\src\\main\\data\\twitter4j-master\\twitter4j-examples\\src\\main\\java\\twitter4j\\examples\\account\\GetRateLimitStatus.java";

        ASTParserTool parserTool = new ASTParserTool();
        MethodList methodList = parserTool.parseMethod(filePath);
        System.out.println(methodList);

    }
}
