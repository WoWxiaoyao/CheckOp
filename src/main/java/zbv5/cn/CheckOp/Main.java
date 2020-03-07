package zbv5.cn.CheckOp;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import zbv5.cn.CheckOp.lang.Lang;
import zbv5.cn.CheckOp.util.CheckUtil;
import zbv5.cn.CheckOp.util.FileUtil;
import zbv5.cn.CheckOp.util.PluginUtil;
import zbv5.cn.CheckOp.util.PrintUtil;

public class Main extends PluginBase
{
    private static Main instance;

    public static Main getInstance()
    {
        return instance;
    }

    @Override
    public void onEnable()
    {
        instance = this;
        PluginUtil.LoadPlugin();

    }

    @Override
    public void onDisable()
    {
        PluginUtil.DisablePlugin();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getLabel().equalsIgnoreCase("CheckOp"))
        {
            if (args.length == 0)
            {
                PrintUtil.PrintCommandSender(sender,false,"&6==== [&bCheckOp&6] ====");
                PrintUtil.PrintCommandSender(sender,false,"&6/"+label+"&a add &e<玩家> &7- &b将玩家加入至白名单");
                PrintUtil.PrintCommandSender(sender,false,"&6/"+label+"&a del &e<玩家> &7- &b将玩家移出至白名单");
                PrintUtil.PrintCommandSender(sender,false,"&6/"+label+"&a list &7- &e列出白名单全体玩家");
                PrintUtil.PrintCommandSender(sender,false,"&6/"+label+"&c reload &7- &4重载插件配置");
                return true;
            } else {
                if(!sender.hasPermission("CheckOp.admin"))
                {
                    PrintUtil.PrintCommandSender(sender,false, Lang.NoPermission);
                    return false;
                }
                if(args[0].equalsIgnoreCase("add"))
                {
                    if (args.length == 2)
                    {
                        String name = args[1];
                        if(CheckUtil.WhiteList.contains(name))
                        {
                            PrintUtil.PrintCommandSender(sender,false,Lang.AlreadyExists);
                            return false;
                        } else {
                            CheckUtil.WhiteList.add(name);
                            if(FileUtil.setWhiteList(CheckUtil.WhiteList))
                            {
                                PrintUtil.PrintCommandSender(sender,false,Lang.Executed);
                            } else {
                                PrintUtil.PrintCommandSender(sender,false,Lang.FailExecuted);
                            }
                        }
                        return true;
                    } else {
                        PrintUtil.PrintCommandSender(sender,false,"{prefix}&c正确方式: /"+label+" add <玩家>");
                        return false;
                    }
                }
                if(args[0].equalsIgnoreCase("del"))
                {
                    if (args.length == 2)
                    {
                        String name = args[1];
                        if(!CheckUtil.WhiteList.contains(name))
                        {
                            PrintUtil.PrintCommandSender(sender,false,Lang.NoExists);
                            return false;
                        } else {
                            CheckUtil.WhiteList.remove(name);
                            if(FileUtil.setWhiteList(CheckUtil.WhiteList))
                            {
                                PrintUtil.PrintCommandSender(sender,false,Lang.Executed);
                            } else {
                                PrintUtil.PrintCommandSender(sender,false,Lang.FailExecuted);
                            }
                        }
                        return true;
                    } else {
                        PrintUtil.PrintCommandSender(sender,false,"{prefix}&c正确方式: /"+label+" del <玩家>");
                        return false;
                    }
                }
                if(args[0].equalsIgnoreCase("list"))
                {
                    if(CheckUtil.WhiteList.isEmpty())
                    {
                        PrintUtil.PrintCommandSender(sender,false,Lang.NullList);
                        return false;
                    } else {
                        PrintUtil.PrintCommandSender(sender,false,"&6==== [&b白名单&6] ====");
                        for(String name:CheckUtil.WhiteList)
                        {
                            PrintUtil.PrintCommandSender(sender,false,"&e> &a"+name);
                        }
                    }
                    return false;
                }
                if(args[0].equalsIgnoreCase("reload"))
                {
                    try
                    {
                        PluginUtil.reloadLoadPlugin();
                        PrintUtil.PrintCommandSender(sender,false,Lang.SuccessReload);
                        return true;
                    } catch (Exception e)
                    {
                        PrintUtil.PrintCommandSender(sender,false,Lang.FailReload);
                        e.printStackTrace();
                    }
                    return false;
                }
                PrintUtil.PrintCommandSender(sender,false, Lang.NullCommand);
                return false;
            }
        }
        return false;
    }
}
