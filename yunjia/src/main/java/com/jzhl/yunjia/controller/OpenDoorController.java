package com.jzhl.yunjia.controller;

import com.jzhl.yunjia.config.SpringFactory;
import com.jzhl.yunjia.utils.RedisUtil;
import com.jzhl.yunjia.utils.YunJiaUtil;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/yunjia")
public class OpenDoorController {

    @Resource
    RedisUtil redisUtil;


    /**
     * 远程开门接口
     * @param request
     * @throws IOException
     */
    @RequestMapping("/openOrForbid")
    public void open(String deviceSerial, String activType, int activTime,Boolean isOpen, HttpServletRequest request) throws IOException {

        ChannelHandlerContext ctx = null;

        Map<String,ChannelHandlerContext> map = (Map<String,ChannelHandlerContext>)request.getServletContext().getAttribute("ctx");
        if(map != null){
            ctx = map.get(deviceSerial);
        }

        if(ctx != null){
            if(isOpen){
                YunJiaUtil.open73(ctx,"01",activType,activTime ,activType);
                redisUtil.set("yunjia_voice", "您好, 请通行");
            }else{
                YunJiaUtil.open73(ctx,"00",activType,activTime ,activType);
                redisUtil.set("yunjia_voice", "您好, 禁止通行");
            }
        }
    }

    @RequestMapping("/open")
    public void openDoor(String deviceSerial, String door, HttpServletRequest request){
        ChannelHandlerContext ctx = null;

        Map<String,ChannelHandlerContext> map = (Map<String,ChannelHandlerContext>)request.getServletContext().getAttribute("ctx");
        if(map != null){
            ctx = map.get(deviceSerial);
        }

        if(ctx != null){
            YunJiaUtil.command2C(ctx,door);
        }
    }

    @RequestMapping("/openKeep")
    public void openDoorKeep(String deviceSerial, String door, HttpServletRequest request){
        ChannelHandlerContext ctx = null;

        Map<String,ChannelHandlerContext> map = (Map<String,ChannelHandlerContext>)request.getServletContext().getAttribute("ctx");
        if(map != null){
            ctx = map.get(deviceSerial);
        }

        if(ctx != null){
            YunJiaUtil.command2D(ctx,door);
        }
    }

    @RequestMapping("/openClose")
    public void openDoorClose(String deviceSerial, String door, HttpServletRequest request){
        ChannelHandlerContext ctx = null;

        Map<String,ChannelHandlerContext> map = (Map<String,ChannelHandlerContext>)request.getServletContext().getAttribute("ctx");
        if(map != null){
            ctx = map.get(deviceSerial);
        }

        if(ctx != null){
            YunJiaUtil.command2E(ctx,door);
        }
    }
}
