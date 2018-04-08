package vt.cs;

/**
 * Created by hasee on 2018/4/8.
 */
public class NewMethodVector extends MethodVector {
    String filePath;
    String className;
    String methodName;

    public NewMethodVector(String fname, String filePath, String className, String methodName,
                           int start, int end,
                           TokenList r_List, TokenList t_List, TokenList l_List, TokenList v_List4,
                           TokenList f_List, TokenList q_List, TokenList o_List, TokenList m_List) {
        super(fname, start, end, r_List, t_List, l_List, v_List4, f_List, q_List, o_List, m_List);
        this.filePath = filePath;
        this.className = className;
        this.methodName = methodName;
    }

    NewMethodVector(String fname, int start, int end, TokenList r_List, TokenList t_List, TokenList l_List, TokenList v_List4, TokenList f_List, TokenList q_List, TokenList o_List, TokenList m_List) {
        super(fname, start, end, r_List, t_List, l_List, v_List4, f_List, q_List, o_List, m_List);
    }
}
