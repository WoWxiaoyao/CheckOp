package zbv5.cn.CheckOp.util;

import zbv5.cn.CheckOp.Main;
import zbv5.cn.CheckOp.lang.Lang;
import zbv5.cn.CheckOp.listener.PlayerListener;

public class PluginUtil
{
    public static void LoadPlugin()
    {
        PrintUtil.PrintConsole("&e======== &bCheckOp &e> &d开始加载 &e========",false);
        FileUtil.LoadFile();
        Lang.LoadLang();
        CheckUtil.LoadCheck();
        Main.getInstance().getServer().getPluginManager().registerEvents(new PlayerListener(), Main.getInstance());
        PrintUtil.PrintConsole("&e======== &bCheckOp &e> &a加载成功 &e========",false);
    }

    public static void DisablePlugin()
    {
        PrintUtil.PrintConsole("&e======== &bCheckOp &e> &d开始卸载 &e========",false);
        PrintUtil.PrintConsole("&e> 感谢您的使用,期待下次运行~",false);
        PrintUtil.PrintConsole("&e======== &bCheckOp &e> &c卸载完成 &e========",false);
    }

    public static void reloadLoadPlugin()
    {
        PrintUtil.PrintConsole("&e======== &bCheckOp &e> &d开始重载 &e========",false);
        FileUtil.LoadFile();
        Lang.LoadLang();
        CheckUtil.LoadCheck();
        PrintUtil.PrintConsole("&e======== &bCheckOp &e> &a重载成功 &e========",false);
    }
}
