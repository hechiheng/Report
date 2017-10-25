package com.report.global;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;
import org.apache.struts.action.ActionMessages;

public class SysGlobals {

    /////////////////////////////////////////////////////////////////
    //---------------------以下为通用代码，不需要修改--------------------
    /////////////////////////////////////////////////////////////////
    private SysGlobals() {
    }

    /**
     * 系统配置文件config.system-config.properties加载对象
     */
    private static Properties property;

    /**
     * 设置系统提示信息，提示信息内容由SysMessageBean封装。
     * 
     * @param request
     * @param smb
     */
    public static void setSysMessage(HttpServletRequest request,
            SysMessageBean smb) {
        //创建一个ActionMessages对象，用于封装想要返回显示层的信息
        ActionMessages ams = new ActionMessages();
        if (smb.getMessage() != null) {
            //向ActionMessages对象添加ActionMessage信息对象
            ams.add("sysMessage", smb.getMessage());
        }
        if (smb.getLinkText() != null) {
            //向信息提示页面增加转向链接
            ams.add("sysLinkText", smb.getLinkText());
        }
        if (smb.getPageTitle() != null) {
            //向信息提示页面设置页面title内容
            ams.add("sysPageTitle", smb.getPageTitle());
        }

        //把smb对象设置为request对象的属性传递给vm，用于构造转向链接地址
        request.setAttribute("sysInfoLink", smb);

        //设定ActionMessages对象的显示方式，并将其设置为request对象的属性返回显示层
        request.setAttribute(Globals.MESSAGE_KEY, ams);
    }

    /**
     * 从system-config.properties配置文件中获取不是目录的配置信息。
     * 
     * @param key
     * @return String
     */
    public static String getSysConfig(String key) {
        return getSysConfig(key, false);
    }

    /**
     * 从system-config.properties配置文件中获取配置信息。 <br>
     * 如果是目录，在配置文件中指定以"\"结尾，如：C:\\dir\\ <br>
     * 如果value为中文，需要进行Unicode编码
     * 
     * @param key
     * @param isDir
     *            指定要获取的信息是否为目录，是为true，否则为false
     * @return String
     */
    public static String getSysConfig(String key, boolean isDir) {
        String value = null;
        if (property == null) {
            initConfig();
        }

        // 获取Properties对象中fileUploadDir键的值
        value = property.getProperty(key);
        // 判断key所代表的是不是目录，如果是，判断目录是否存在，不存在则创建该目录
        if (isDir) {
            File dir = new File(value);
            if (!dir.exists()) {
                dir.mkdirs();
            }
        }
        return value;
    }

    //加载系统配置属性文件
    private static void initConfig() {
        try {
            property = new Properties();
            InputStream is = SysGlobals.class
                    .getResourceAsStream("/config/system-config.properties");
            property.load(is);
            is.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断某个模块session的有效性，有效返回true，否则返回false <br>
     * 每个模块通过一个模块名关联一个Map保存在全局Session中
     * 
     * @param request
     * @param module
     *            指出要验证的模块的名字
     * @return boolean
     */
    public static boolean isValid(HttpServletRequest request, String module) {
        //从request对象中获取存在的session对象
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute(module) == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * 从全局Session中获取某个模块的Session对象，通过指定的module值查找，不存在返回null <br>
     * 每个模块通过一个模块名关联一个Map保存在全局Session对象中
     * 
     * @param request
     * @param module
     *            指出要获取的模块的名字
     * @return Map
     */
    public static Map getSessionObj(HttpServletRequest request, String module) {
        //判断session是否有效，无效则直接返回null
        if (!isValid(request, module)) {
            return null;
        }
        else {
            return (Map) request.getSession(false).getAttribute(module);
        }
    }

    /**
     * 设置某个模块的Session对象，将其通过指定的module增加到全局的Session对象中。
     * 每个模块通过一个模块名关联一个Map保存在全局Session对象中
     * 
     * @param request
     * @param module
     *            某个模块的Session对象在全局Session对象中绑定的key
     * @param map
     *            某个模块的Session信息
     *  
     */
    public static void setSessionObj(HttpServletRequest request, String module,
            Map map) {
        HttpSession session = request.getSession();
        session.setAttribute(module, map);
    }

    /**
     * 删除某个模块的session对象
     * 
     * @param request
     * @param module
     *            指定要删除session的模块的名字
     */
    public static void removeSessionObj(HttpServletRequest request,
            String module) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(module);
        }
    }

    /**
     * 删除某个模块的session对象中某个值
     * 
     * @param request
     * @param module
     *            指定要删除session的模块的名字
     * @param key
     *            指定要删除的session对象中的key
     */
    public static void removeSessionObj(HttpServletRequest request,
            String module, String key) {
        Map map = getSessionObj(request, module);
        if (map != null) {
            map.remove(key);
        }
    }
}

