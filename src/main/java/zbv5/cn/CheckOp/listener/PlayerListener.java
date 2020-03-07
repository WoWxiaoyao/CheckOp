package zbv5.cn.CheckOp.listener;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.player.*;
import zbv5.cn.CheckOp.lang.Lang;
import zbv5.cn.CheckOp.util.CheckUtil;
import zbv5.cn.CheckOp.util.LogUtil;
import zbv5.cn.CheckOp.util.PrintUtil;

public class PlayerListener implements Listener
{
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        if(CheckUtil.Join)
        {
            Player p = e.getPlayer();
            CheckUtil.Check(p,false);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e)
    {
        if(CheckUtil.Quit)
        {
            Player p = e.getPlayer();
            CheckUtil.Check(p,false);
        }
    }

    @EventHandler
    public void onPlayerGameModeChange(PlayerGameModeChangeEvent e)
    {
        if(CheckUtil.CreativeMode)
        {
           // if(e.isCancelled()) return;
            Player p = e.getPlayer();
            if(!CheckUtil.WhiteList.contains(p.getName()))
            {
                if(e.getNewGamemode() == 1)
                {
                    e.setCancelled(true);
                    PrintUtil.PrintPlayer(p, Lang.GameMode,false);
                    PrintUtil.PrintConsole("&c&l危 &4检测玩家"+p.getName()+"异常 原因:非法创造",true);
                    LogUtil.log(p,"非法创造");
                    CheckUtil.Check(p,true);
                }
            }
        }
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e)
    {
        if(CheckUtil.Command)
        {
           // if(e.isCancelled()) return;
            Player p = e.getPlayer();
            CheckUtil.Check(p,true);
        }
    }

    @EventHandler
    public void onPlayerChat(PlayerChatEvent e)
    {
        if(CheckUtil.Chat)
        {
          //  if(e.isCancelled()) return;
            Player p = e.getPlayer();
            CheckUtil.Check(p,false);
        }
    }

    @EventHandler
    public void onBuild(BlockPlaceEvent e)
    {
        if(CheckUtil.Build)
        {
       // if(e.isCancelled()) return;
            Player p = e.getPlayer();
            CheckUtil.Check(p,false);
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e)
    {
        if(CheckUtil.Break)
        {
            //  if(e.isCancelled()) return;
            Player p = e.getPlayer();
            CheckUtil.Check(p,false);
        }
    }
}
