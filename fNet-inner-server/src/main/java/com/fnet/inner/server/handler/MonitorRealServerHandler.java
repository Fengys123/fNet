package com.fnet.inner.server.handler;

import com.fnet.common.transferProtocol.Message;
import com.fnet.inner.server.data.ContactOfOuterToInnerChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class MonitorRealServerHandler extends ChannelInboundHandlerAdapter {

    private Message message;

    public MonitorRealServerHandler(Message message) {
        this.message = message;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel innerChannel = ctx.channel();
        ContactOfOuterToInnerChannel.getInstance().addToMap(message.getOuterChannelId(), innerChannel);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ContactOfOuterToInnerChannel.getInstance().removeFromMap(message.getOuterChannelId());
    }
}
