package com.company;

import java.util.Arrays;
import java.util.Objects;

public class Main {

    private static final Object customNull = "Z";                    // customNull
    private static Object[] sourceArray;                            // массив для добавления элемента
    private static Object[] resultArray;
    private static int maxIndex;// копия массива

    public static void main(String[] args) {
        sourceArray = new Object[]{null};
        plusElement("123", customNull, sourceArray);
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
                    sourceArray[i] = value;
                    sourceArray[i + 1] = customNull;
                    System.out.println(Arrays.toString(sourceArray));
                    break;
                } else count++;
            }
            if (count == sourceArray.length) {
                sourceArray[0] = value;
                sourceArray[1] = customNull;
            }
            System.out.println(Arrays.toString(sourceArray));

        } else if (sourceArray.equals(null)) {
            Object[] resultArray = {value, customNull};
            sourceArray = resultArray;
            System.out.println(Arrays.toString(sourceArray));
        }


    }


}
