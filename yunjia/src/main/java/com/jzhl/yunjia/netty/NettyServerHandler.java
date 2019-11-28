package com.jzhl.yunjia.netty;

import com.jzhl.yunjia.config.SpringFactory;
import com.jzhl.yunjia.utils.RedisUtil;
import com.jzhl.yunjia.utils.StringUtil;
import com.jzhl.yunjia.utils.YunJiaUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import java.net.InetSocketAddress;

public class NettyServerHandler  extends SimpleChannelInboundHandler<Object> {
    /**
     * 日志
     */
    private Logger log = LoggerFactory.getLogger(getClass());

    ServletContext context;
    RedisUtil redisUtil;

    public NettyServerHandler(ServletContext context){

        System.out.println("-----------开始初始化--------------");
        redisUtil = ((RedisUtil) SpringFactory.getBean("redisUtil"));
        this.context = context;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg){

        try {
            ByteBuf msg1 = (ByteBuf) msg;

            byte[] bytes = new byte[msg1.readableBytes()];
            msg1.readBytes(bytes);
            String date = StringUtil.parseByte2HexStr(bytes);

            String head = date.substring(0,2);
            String tail = date.substring(date.length()-2,date.length());

            if(!head.equals("02")){
                System.out.println("---------------02 error--------------");
                return;
            }

            String command = date.substring(4,6);

            switch (command){
                case "56":
                    // 心跳反馈  并保存设备通讯时间
                    String deviceName = StringUtil.hexStr2Str(date.substring(56,68));
                    YunJiaUtil.sendHeartDate(ctx, deviceName);

                    //将通讯保存在上下文中
                    YunJiaUtil.setServletContext(context, ctx,deviceName);
                    break;
                case "53":
                    //自动上传历史刷卡记录
                    System.out.println("传送历史刷卡记录");
                    YunJiaUtil.command53(ctx,date);
                    break;
                case "54":
                    //自动上传历史报警记录
                    YunJiaUtil.command54(ctx,date);
                    break;
                case "E7":
                    //传送门禁请求数据
                    System.out.println("传送门禁请求数据");
                    YunJiaUtil.commandE7(ctx,date,redisUtil);
                    break;
                case "57":
                    //传送门禁请求数据 应答
                    String voice = (String)redisUtil.get("yunjia_voice");

                    if(date.substring(14,16).equals("06")){
                        YunJiaUtil.command80(ctx,voice);
                    }
                    break;
                case "73":
                    //传送门禁主动请求数据 应答
                    String voice1 = (String)redisUtil.get("yunjia_voice");

                    if(date.substring(14,16).equals("06")){
                        YunJiaUtil.command80(ctx,voice1);
                    }
                    break;

                default:
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {

//        System.out.println("channel 通道 Read 读取 Complete 完成");
        ctx.flush();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress insocket = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = insocket.getAddress().getHostAddress();
        log.info("cliet -- [ip:" + clientIp + "]-- online");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // 当出现异常就关闭连接
        System.out.println("------------------error-----------------------" + cause);
        ctx.close();
    }
}
