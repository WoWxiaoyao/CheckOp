package zbv5.cn.CheckOp.util;

import cn.nukkit.Player;
import zbv5.cn.CheckOp.Main;
import zbv5.cn.CheckOp.lang.Lang;

import java.util.ArrayList;
import java.util.List;

public class CheckUtil
{
    public static boolean CreativeMode = false;
    public static boolean Chat = false;
    public static boolean Command = false;
    public static int Command_Delay = 1;
    public static boolean Join = false;
    public static boolean Quit = false;
    public static boolean Build = false;
    public static boolean Break = false;

    public static boolean Log = false;

    public static List<String> WhiteList = new ArrayList<String>();

    public static void LoadCheck()
    {
        try
        {
            if(FileUtil.config.getBoolean("CheckList.CreativeMode.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用游戏模式切换检测.",false);
                CreativeMode = true;
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用游戏模式切换检测.",false);
            }

            if(FileUtil.config.getBoolean("CheckList.Chat.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用聊天检测.",false);
                Chat = true;
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用聊天检测.",false);
            }

            if(FileUtil.config.getBoolean("CheckList.Command.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用指令检测.",false);
                Command = true;
                Command_Delay = FileUtil.config.getInt("CheckList.Command.Delay");
                PrintUtil.PrintConsole("&e  > &b指令检测延迟:"+Command_Delay,false);
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用指令检测.",false);
            }

            if(FileUtil.config.getBoolean("CheckList.Join.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用进入服务器检测.",false);
                Join = true;
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用进入服务器检测.",false);
            }

            if(FileUtil.config.getBoolean("CheckList.Quit.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用退出服务器检测.",false);
                Quit = true;
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用退出服务器检测.",false);
            }

            if(FileUtil.config.getBoolean("CheckList.Build.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用建造检测.",false);
                Build = true;
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用建造检测.",false);
            }

            if(FileUtil.config.getBoolean("CheckList.Break.Enable"))
            {
                PrintUtil.PrintConsole("&e  > &b启用破坏检测.",false);
                Break = true;
            } else {
                PrintUtil.PrintConsole("&e  > &3禁用破坏检测.",false);
            }

            WhiteList = FileUtil.config.getStringList("WhiteList");
            PrintUtil.PrintConsole("&a&l√ &a白名单列表加载完成.",false);

            Log = FileUtil.config.getBoolean("logs");
            LogUtil.CheckLog();

            PrintUtil.PrintConsole("&a&l√ &a检测功能加载完成.",false);
        }
        catch (Exception e)
        {
            PrintUtil.PrintConsole("&c&l× &4检测加载出现问题,请检查config.yml.",false);
            e.printStackTrace();
        }
    }

    public static void Check(Player p,boolean Delay)
    {
        if(!WhiteList.contains(p.getName()))
        {
            if(p.isOp())
            {
                if((Delay) &&(Command_Delay > 0))
                {
                    final Player pp = p;
                    Main.getInstance().getServer().getScheduler().scheduleDelayedTask(Main.getInstance(), new Runnable()
                    {
                        public void run()
                        {
                            pp.setOp(false);
                            PrintUtil.PrintPlayer(pp,Lang.OP,false);
                            PrintUtil.PrintConsole("&c&l危 &4检测玩家"+pp.getName()+"异常 原因:非法OP",true);
                            LogUtil.log(pp,"非法OP");
                        }
                    }, Command_Delay*20);
                } else {
                    p.setOp(false);
                    PrintUtil.PrintPlayer(p,Lang.OP,false);
                    PrintUtil.PrintConsole("&c&l危 &4检测玩家"+p.getName()+"异常 原因:非法OP",true);
                    LogUtil.log(p,"非法OP");
                }
            }
        }
    }

}
