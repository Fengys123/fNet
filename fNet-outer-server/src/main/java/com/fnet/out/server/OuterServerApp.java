package com.fnet.out.server;

import com.fnet.common.codec.MessageDecoder;
import com.fnet.common.codec.MessageEncoder;
import com.fnet.common.config.Config;
import com.fnet.common.config.cmd.CmdConfigService;
import com.fnet.common.net.TcpServer;
import com.fnet.out.server.handler.MonitorInnerServerHandler;
import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.commons.cli.*;

/**
 * start outer server here
 */
public class OuterServerApp {

    public static void main(String[] args) throws InterruptedException, ParseException {

        new CmdConfigService().setOuterServerConfig(args);

        if (Config.isOuterServerConfigComplete()) {
            new TcpServer().startMonitor(Config.OUTER_SERVER_PORT, new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();
                    pipeline.addLast(new MessageDecoder(), new MessageEncoder(), new IdleStateHandler(30, 30, 30),
                            new MonitorInnerServerHandler());
                }
            });
        }
    }
}
