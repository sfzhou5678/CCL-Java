package vt.cs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hasee on 2018/4/8.
 */
public class MethodDetail {
    public String filePath;
    public String className;
    public String methodName;

    public Map<String, Integer> reservedDict = new HashMap<>();
    public Map<String, Integer> typeDict = new HashMap<>();
    public Map<String, Integer> literalDict = new HashMap<>();
    public Map<String, Integer> variableDict = new HashMap<>();
    public Map<String, Integer> functionNameDict = new HashMap<>();
    public Map<String, Integer> qualifiedNameDict = new HashMap<>();
    public Map<String, Integer> operatorDict = new HashMap<>();
    public Map<String, Integer> markerDict = new HashMap<>();

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Map<String, Integer> getReservedDict() {
        return reservedDict;
    }

    public void setReservedDict(Map<String, Integer> reservedDict) {
        this.reservedDict = reservedDict;
    }

    public Map<String, Integer> getTypeDict() {
        return typeDict;
    }

    public void setTypeDict(Map<String, Integer> typeDict) {
        this.typeDict = typeDict;
    }

    public Map<String, Integer> getLiteralDict() {
        return literalDict;
    }

    public void setLiteralDict(Map<String, Integer> literalDict) {
        this.literalDict = literalDict;
    }

    public Map<String, Integer> getVariableDict() {
        return variableDict;
    }

    public void setVariableDict(Map<String, Integer> variableDict) {
        this.variableDict = variableDict;
    }

    public Map<String, Integer> getFunctionNameDict() {
        return functionNameDict;
    }

    public void setFunctionNameDict(Map<String, Integer> functionNameDict) {
        this.functionNameDict = functionNameDict;
    }

    public Map<String, Integer> getQualifiedNameDict() {
        return qualifiedNameDict;
    }

    public void setQualifiedNameDict(Map<String, Integer> qualifiedNameDict) {
        this.qualifiedNameDict = qualifiedNameDict;
    }

    public Map<String, Integer> getOperatorDict() {
        return operatorDict;
    }

    public void setOperatorDict(Map<String, Integer> operatorDict) {
        this.operatorDict = operatorDict;
    }

    public Map<String, Integer> getMarkerDict() {
        return markerDict;
    }

    public void setMarkerDict(Map<String, Integer> markerDict) {
        this.markerDict = markerDict;
    }
}
