package cn.zmhappy.hongdiary.util;

import java.util.UUID;

public final class CommonUtil {

    /**
     * 生成唯一的文件名
     */
    public static String getUniqueFileName() {
        String str = UUID.randomUUID().toString();
        return str.replace("-", "").substring(20);
    }

}
