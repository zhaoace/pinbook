package com.customer.web.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * action基类
 * </p>
 * 
 * @author Eric.fu
 * @version $Id: BaseAction.java, v 0.1 2011-1-14 下午07:41:55 fuyangbiao Exp $
 */
public class BaseAction {
    protected static Log             logger                        = LogFactory
                                                                       .getLog(BaseAction.class);

    /** vm文件中使用的Key, 列表 */
    public static final String       DISPLAY_KEY_BEANS             = "beans";

    /** vm文件中使用的Key, 单个对象 */
    public static final String       DISPLAY_KEY_BEAN              = "bean";

    /** vm文件中使用的Key, 查询对象 */
    public static final String       DISPLAY_KEY_QUERY             = "query";

    protected static final String    SUCCESS_MESSAGE               = "处理成功";
    /** 返回信息键值 */
    protected static final String    RETURN_MESSAGE                = "returnMsg";
    /** 错误信息键值 */
    protected static final String    ERROR_MESSAGE                 = "errorMsg";
    /** 内弹返回页面 Add by Frank.fan */
    protected static final String    RESULT_VIEW                   = "/result";

    protected static final String    RESULT_VIEW_BACK              = "/resultBack";

    /** 内弹返回是否需要刷新 Add by Frank.fan */
    protected static final String    RESULT_RETURN_NEED_REFRUSH    = "needFresh";

    /** 内弹返回刷新参数 Add by Frank.fan */
    protected static final String    REFUSH_PARAMS_FOR_RESULT_VIEW = "REFUSH_PARAMS_FOR_RESULT_VIEW";

    /** 内弹返回页面关闭时间参数 */
    protected static final String    RESULT_RETURN_CLOSE_INTERVAL  = "closeInterval";

    /** 转换页面的日期格式 */
    public static final DateFormat[] supportedDateFormats          = new DateFormat[] {
            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), new SimpleDateFormat("yyyy-MM-dd HH:mm"),
            new SimpleDateFormat("yyyy-MM-dd"), new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("MM/dd/yyyy")                    };

    /**
     * 内弹页面返回,初始化参数,包括是否需要刷新背景
     * 
     * @param _map
     * @param model
     * @param isNeedRefrush
     * @return
     */
    @SuppressWarnings("unchecked")
    protected String getResultView(Map _map, ModelMap model, boolean isNeedRefrush, String returnUrl) {
        return getResultView(_map, model, isNeedRefrush, 5, returnUrl);// 默认5秒钟关闭时间
    }

    /**
     * @param _map
     * @param model
     * @param isNeedRefrush
     *            是否刷新
     * @param closeInterval
     *            延迟多长时间关闭
     * @param returnUrl
     *            返回页面
     * @return
     */
    @SuppressWarnings("unchecked")
    protected String getResultView(Map _map, ModelMap model, boolean isNeedRefrush,
                                   int closeInterval, String returnUrl) {
        model.put(RESULT_RETURN_CLOSE_INTERVAL, closeInterval);
        model.put(RESULT_RETURN_NEED_REFRUSH, isNeedRefrush);
        _map = _map == null ? new HashMap<String, String>() : _map;
        model.put(REFUSH_PARAMS_FOR_RESULT_VIEW, _map.get(REFUSH_PARAMS_FOR_RESULT_VIEW));

        return returnUrl;
    }

    protected List<Long> convert2List(String array) {
        if (array == null || "".equals(array)) {
            return new ArrayList<Long>();
        }
        List<Long> list = new ArrayList<Long>();
        for (String value : array.split(",")) {
            list.add(new Long(value));
        }
        return list;
    }

    protected List<String> convert2ListString(String array) {
        if (array == null || "".equals(array)) {
            return new ArrayList<String>();
        }
        List<String> list = new ArrayList<String>();
        for (String value : array.split(",")) {
            list.add(value);
        }
        return list;
    }

    @SuppressWarnings("unchecked")
    protected void usingEmptyTemplate(ModelMap model) {
        model.put("layout", "common/layout/blank.vm");
    }

}
