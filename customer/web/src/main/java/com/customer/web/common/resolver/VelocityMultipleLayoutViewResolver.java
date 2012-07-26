package com.customer.web.common.resolver;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

/**
 * velocity个性布局处理器
 * <p>
 * See VelocityViewResolver's javadoc for general usage info.
 * </p>
 * 
 * @author Eric.fu
 * @see VelocityViewResolver
 * @see VelocityLayoutView
 * @version $Id: VelocityMultipleLayoutViewResolver.java, v 0.1 2009-9-18 下午05:12:50 fuyangbiao Exp $
 */
public class VelocityMultipleLayoutViewResolver extends VelocityViewResolver {
    /** 布局配置 */
    private Map<String, String> mappings = new HashMap<String, String>();

    /** 布局键值。默认为：layout */
    private String              layoutKey;
    /** 内容视图键值。 默认为：screen_content */
    private String              screenContentKey;

    /**
     * Requires VelocityLayoutView.
     * @see VelocityLayoutView
     */
    protected Class<?> requiredViewClass() {
        return VelocityLayoutView.class;
    }

    /**
     * Set the context key used to specify an alternate layout to be used instead
     * of the default layout. Screen content templates can override the layout
     * template that they wish to be wrapped with by setting this value in the
     * template, for example:<br>
     * <code>#set( $layout = "MyLayout.vm" )</code>
     * <p>The default key is "layout", as illustrated above.
     * @param layoutKey the name of the key you wish to use in your
     * screen content templates to override the layout template
     * @see VelocityLayoutView#setLayoutKey
     */
    public void setLayoutKey(final String layoutKey) {
        this.layoutKey = layoutKey;
    }

    /**
     * Set the name of the context key that will hold the content of
     * the screen within the layout template. This key must be present
     * in the layout template for the current screen to be rendered.
     * <p>Default is "screen_content": accessed in VTL as
     * <code>$screen_content</code>.
     * @param screenContentKey the name of the screen content key to use
     * @see VelocityLayoutView#setScreenContentKey
     */
    public void setScreenContentKey(final String screenContentKey) {
        this.screenContentKey = screenContentKey;
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.view.velocity.VelocityViewResolver#buildView(java.lang.String)
     */
    protected AbstractUrlBasedView buildView(final String viewName) throws Exception {
        VelocityLayoutView view = (VelocityLayoutView) super.buildView(viewName);

        if (this.layoutKey != null) {
            view.setLayoutKey(this.layoutKey);
        }

        if (this.screenContentKey != null) {
            view.setScreenContentKey(this.screenContentKey);
        }

        // 需要包装layout
        if (!this.mappings.isEmpty()) {
            for (Map.Entry<String, String> entry : this.mappings.entrySet()) {

                // 获取正则表达式
                String mappingRegexp = StringUtils.replace(entry.getKey(), "*", ".*");

                // 匹配视图
                if (viewName.matches(mappingRegexp)) {
                    view.setLayoutUrl(entry.getValue());

                    return view;
                }
            }
        }

        return view;
    }

    public Map<String, String> getMappings() {
        return mappings;
    }

    public void setMappings(Map<String, String> mappings) {
        this.mappings = mappings;
    }

}
