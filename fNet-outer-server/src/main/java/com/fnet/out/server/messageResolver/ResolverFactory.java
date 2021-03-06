package com.fnet.out.server.messageResolver;

import com.fnet.common.transfer.protocol.Message;
import com.fnet.common.transfer.protocol.MessageResolver;

import java.util.ArrayList;
import java.util.List;

public class ResolverFactory {

    private static ResolverFactory resolverFactory = new ResolverFactory();
    private static List<MessageResolver> resolvers = new ArrayList<>();
    static {
        resolvers.add(new DisconnectResolver());
        resolvers.add(new HeartBeatResolver());
        resolvers.add(new RegisterResolver());
        resolvers.add(new TransferResolver());
        resolvers.add(new HeartBeatResponseResolver());
    }

    private ResolverFactory() {

    }

    public static ResolverFactory getInstance() {
        return resolverFactory;
    }

    public MessageResolver getMessageResolver(Message message) {
        for (MessageResolver resolver : resolvers) {
            if (resolver.isSupport(message)) {
                return resolver;
            }
        }
        throw new RuntimeException("can not find resolver, message type:" + message.getType());
    }
}
