package com.jzhl.yunjia.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import javax.servlet.ServletContext;

public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {
    private ServletContext context;

    public  NettyServerInitializer(ServletContext context){
        this.context = context;
    }
    /**
     * 初始化channel
     */
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
//        pipeline.addLast("encoder",new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new NettyServerHandler(context));
    }
}
