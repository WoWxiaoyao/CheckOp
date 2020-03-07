package zbv5.cn.CheckOp.lang;

import zbv5.cn.CheckOp.util.FileUtil;
import zbv5.cn.CheckOp.util.PrintUtil;

public class Lang
{
    public static String Prefix = "&6[&bCheckOp&6]";
    public static String GameMode = "{prefix}&c检测到你的游戏模式异常.";
    public static String OP = "{prefix}&c检测到你的权限异常.";
    public static String NoPermission = "{prefix}&c你没有权限这样做";
    public static String SuccessReload = "{prefix}&a重载完成!";
    public static String FailReload = "{prefix}&c重载失败!请前往控制台查看报错.";
    public static String NullCommand = "{prefix}&c未知指令.";
    public static String Executed= "{prefix}&a已执行操作.";
    public static String FailExecuted= "{prefix}&c执行操作失败.";
    public static String AlreadyExists= "{prefix}&c该玩家已经在白名单内了.";
    public static String NoExists= "{prefix}&c该玩家不在白名单内.";
    public static String NullList= "{prefix}&c白名单内不存在任何玩家.";

    public static void LoadLang()
    {
        try
        {
            Prefix = FileUtil.lang.getString("Prefix");
            GameMode  = FileUtil.lang.getString("GameMode");
            OP   = FileUtil.lang.getString("OP");
            NoPermission  = FileUtil.lang.getString("NoPermission");
            SuccessReload  = FileUtil.lang.getString("SuccessReload");
            FailReload  = FileUtil.lang.getString("FailReload");
            NullCommand  = FileUtil.lang.getString("NullCommand");
            Executed  = FileUtil.lang.getString("Executed");
            FailExecuted   = FileUtil.lang.getString("FailExecuted");
            AlreadyExists  = FileUtil.lang.getString("AlreadyExists");
            NoExists  = FileUtil.lang.getString("NoExists");
            NullList = FileUtil.lang.getString("NullList");
            PrintUtil.PrintConsole("&a&l√ &a语言文件加载完成.",false);
        }
        catch (Exception e)
        {
            PrintUtil.PrintConsole("&c&l× &4读取语言文件出现问题,请检查服务器.",false);
            e.printStackTrace();
        }
    }
}
