package zbv5.cn.CheckOp.util;

import cn.nukkit.Player;
import zbv5.cn.CheckOp.Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class LogUtil
{

    public static void CheckLog()
    {
        if(CheckUtil.Log)
        {
            createDataFolder();
            PrintUtil.PrintConsole("&e  > &b启用logs记录.",false);
        } else {
            PrintUtil.PrintConsole("&e  > &3禁用logs记录.",false);
        }
    }



    public static void createDataFolder()
    {
        File logs = new File(Main.getInstance().getDataFolder(), "logs.yml");
        if (!logs.exists())
        {
            Main.getInstance().saveResource("logs.yml", false);
        }
    }

    public static void log(Player p, String reason)
    {
        if(CheckUtil.Log)
        {
            createDataFolder();
            File logs = new File(Main.getInstance().getDataFolder(), "logs.yml");
            try {
                BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(new FileOutputStream(logs,true),"UTF-8"));
                bw.write("["+DateUtil.getDate("yyyy年MM月dd HH时mm分ss秒")+"]玩家:"+p.getName()+" 操作异常,原因:"+reason+"\r\n");
                bw.flush();
                bw.close();
            }  catch (Exception e)
            {
                PrintUtil.PrintConsole("&c&l× &4log写入出现问题.",true);
                e.printStackTrace();
            }
        }
    }
}
