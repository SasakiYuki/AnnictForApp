package com.wacode.yuki.annictforapp.type;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by yuki on 2016/09/27.
 */
@Retention(RetentionPolicy.SOURCE)
@StringDef({
        SeasonType.SPRING,
        SeasonType.SUMMER,
        SeasonType.AUTUMN,
        SeasonType.WINTER,
        SeasonType.ALL
})
public @interface SeasonType {
    public static final String SPRING = "spring";
    public static final String SUMMER = "summer";
    public static final String AUTUMN = "autumn";
    public static final String WINTER = "winter";
    public static final String ALL = "all";
}
