package com.dtstack.logstash.exception;


/**
 * 
 * @author sishu.yss
 *
 */
public class ExceptionUtil {
	
    public static String getErrorMessage(Throwable e) {
            StringBuffer sb = new StringBuffer();
            Throwable next = e.getCause();
            if (next != null) {
                    sb.append(next.getMessage() + "\n");
                    StackTraceElement[] nexts = next.getStackTrace();
                    for (StackTraceElement st : nexts) {
                            sb.append(st.getClassName() + "." + st.getMethodName() + "("
                                            + st.getLineNumber() + ")" + "\n");
                    }
            } else {
                    sb.append(e.getMessage() + "\n");
                    StackTraceElement[] sts = e.getStackTrace();
                    if (sts != null) {
                            for (StackTraceElement st : sts) {
                                    sb.append(st.getClassName() + "." + st.getMethodName()
                                                    + "(" + st.getLineNumber() + ")" + "\n");
                            }
                    }
            }
            return sb.toString();
    }

}
