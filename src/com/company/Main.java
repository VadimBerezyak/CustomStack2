package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    private static final Object customNull = "Z";
    private static Object[] sourceArray = {1, 1, 1, 1,123};
    private static Object[] resultArray;
    private static int maxIndex;

    public static void main(String[] args) {
//        sourceArray = new Object[1];
//        sourceArray[0] = null;

       // plusElement("123", customNull, sourceArray);
        deleteElement(sourceArray, 4);
    }

    private static void plusElement(Object value, Object customNull, Object[] sourceArray) {
        if (/*sourceArray[sourceArray.length - 1] != customNull && */sourceArray[sourceArray.length - 1] != null) {
            Object[] resultArray = new Object[(int) Math.ceil(sourceArray.length * 1.5)];
            for (int i = 0; i < sourceArray.length; i++) {
                resultArray[i] = sourceArray[i];
                if (resultArray[i] == customNull) {
                    resultArray[i] = value;
                    resultArray[i + 1] = customNull;
                    System.out.println(Arrays.toString(resultArray));
                    sourceArray = resultArray;
                    return;
                }
            }
            resultArray[sourceArray.length] = value;
            if (resultArray.length > sourceArray.length + 1) {
                resultArray[sourceArray.length + 1] = customNull;
                maxIndex = sourceArray.length + 1;
            }
            sourceArray = resultArray;
            System.out.println(Arrays.toString(sourceArray));
        } else if (sourceArray[sourceArray.length - 1] == null && sourceArray.length != 1) {
            int count = 0;
            for (int i = 0; i < sourceArray.length; i++) {
                if (sourceArray[i] == customNull) {
                    sourceArray[i] = value;
                    sourceArray[i + 1] = customNull;
                    System.out.println(Arrays.toString(sourceArray));
                    return;
                }
            }
            for (int i = sourceArray.length - 1; i >= 0; i--) {

                if (sourceArray[i] != null) {
                    sourceArray[i + 1] = value;
                    // sourceArray[i + 1] = customNull;
                    //System.out.println(Arrays.toString(sourceArray));
                    break;
                } else count++;
            }
            if (count > 1) {
                sourceArray[sourceArray.length - count + 1] = customNull;
            }
            if (count == sourceArray.length) {
                sourceArray[0] = value;
                sourceArray[1] = customNull;
            }
            System.out.println(Arrays.toString(sourceArray));

        } else if (sourceArray.length == 1 && sourceArray[0] == null) {
            Object[] resultArray = {value, customNull};
            sourceArray = resultArray;
            System.out.println(Arrays.toString(sourceArray));
        }
    }
    public static void deleteElement(Object[] sourceArray, int index){
        if(index == sourceArray.length -1) {
            sourceArray[sourceArray.length-1] = customNull;
        } else if(index >= 0 && index < sourceArray.length) {
            for (int i = index; i < sourceArray.length-1 ; i++) {
                sourceArray[i] = sourceArray[i+1];
            }
            sourceArray[sourceArray.length-1] = customNull;
        }
        System.out.println(Arrays.toString(sourceArray));
    }
}
