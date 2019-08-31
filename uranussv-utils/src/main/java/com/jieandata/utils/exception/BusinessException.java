package com.jieandata.utils.exception;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.helpers.MessageFormatter;

import com.jieandata.utils.common.enums.RespCodeEnum;

import java.io.PrintWriter;

/**
 * 业务异常
 * create by peng.ke in 2018年8月13日 下午1:38:16
 *
 */
public class BusinessException extends RuntimeException{

	private static final long serialVersionUID = -2759422875330115876L;
	
	private RespCodeEnum respCodeEnum;

    public RespCodeEnum getRespCodeEnum() {
        return respCodeEnum;
    }

    public String getRespDesc() {
        if (this.respCodeEnum == null) {
            this.respCodeEnum = RespCodeEnum.UNKNOWN_EXCEPTION;
        }
        return respCodeEnum.getRespDesc();
    }
    
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(RespCodeEnum respCodeEnum) {
        this.respCodeEnum = respCodeEnum;
    }

    public BusinessException(String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage());
    }

    public BusinessException(Throwable cause, String message) {
        super(message, cause);
    }

    public BusinessException(Throwable cause, String message, Object... args) {
        super(MessageFormatter.arrayFormat(message, args).getMessage(), cause);
    }

    /**
     * @see Throwable#printStackTrace(PrintWriter)
     */
    @Override
    public void printStackTrace(PrintWriter s) {
        StackTraceElement[] traceElements = getStackTrace();
        if (ArrayUtils.isEmpty(traceElements)) {
            super.printStackTrace(s);
            return;
        }

        int theOriginalMonsterClassIndex = locateOriginalMonsterClassIndex(traceElements);
        if (theOriginalMonsterClassIndex >= 0) {
            //ArrayUtils.subarray方法内部会保证即使lastIndex + 1 > traceElements.length，也不会发生数组越界
            StackTraceElement[] filteredTraceElements = (StackTraceElement[]) ArrayUtils.subarray(
                    traceElements, 0, theOriginalMonsterClassIndex + 1);
            setStackTrace(filteredTraceElements);
        }
        super.printStackTrace(s);
    }

    /**
     * 定位最初(如果按照日志从上往下看，应该是最后一次)出现匹配com.monster.*路径的类的位置
     *
     * @param traceElements
     * @return
     */
    private int locateOriginalMonsterClassIndex(StackTraceElement[] traceElements) {
        int theOriginalMonsterClassIndex = -1;
        int elementsLength = traceElements.length;
        for (int currentIndex = 0; currentIndex < elementsLength; currentIndex++) {
            if (isMonsterProjectClass(traceElements[currentIndex])) {
                theOriginalMonsterClassIndex = currentIndex;
                continue;
            }
            if (hasFoundOriginalMonsterClass(theOriginalMonsterClassIndex)) {
                break;
            }
        }
        return theOriginalMonsterClassIndex;
    }

    private boolean hasFoundOriginalMonsterClass(int theOriginalMonsterClassIndex) {
        return theOriginalMonsterClassIndex != -1;
    }

    private boolean isMonsterProjectClass(StackTraceElement traceElement) {
        if (traceElement == null) {
            return false;
        }
        if (StringUtils.isBlank(traceElement.getClassName())) {
            return false;
        }
        return traceElement.getClassName().startsWith(
                "com.monster.");
    }

}
