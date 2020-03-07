package zbv5.cn.CheckOp.util;

import cn.nukkit.utils.Config;
import zbv5.cn.CheckOp.Main;

import java.io.File;
import java.util.List;

public class FileUtil
{
    public static Config lang;
    public static Config config;

    public static void LoadFile()
    {
        try
        {
            File Config_Yml = new File(Main.getInstance().getDataFolder(), "config.yml");
            if (!Config_Yml.exists())
            {
                Main.getInstance().saveResource("config.yml", false);
            }
            config = new Config(new File(Main.getInstance().getDataFolder() + "/config.yml"));

            File Lang_Yml = new File(Main.getInstance().getDataFolder(), "lang.yml");
            if (!Lang_Yml.exists())
            {
                Main.getInstance().saveResource("lang.yml", false);
            }
            lang = new Config(new File(Main.getInstance().getDataFolder() + "/lang.yml"));

            PrintUtil.PrintConsole("&a&l√ &a配置文件加载完成.",false);
        }
        catch (Exception e)
        {
            PrintUtil.PrintConsole("&c&l× &4加载配置文件出现问题,请检查服务器.",false);
            e.printStackTrace();
        }
    }

    public static Boolean setWhiteList(List<String> WhiteList)
    {
        boolean c = false;
        File Config_Yml = new File(Main.getInstance().getDataFolder(), "config.yml");
        try
        {
            config.set("WhiteList",WhiteList);
            config.save(Config_Yml);
            config = new Config(new File(Main.getInstance().getDataFolder() + "/config.yml"));
            c = true;
        }
        catch (Exception e)
        {
            PrintUtil.PrintConsole("&c&l× &4白名单写入出现问题.",true);
            e.printStackTrace();
        }
        return c;
    }
}
