package com.gatewayserver.configuration.grpc;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ClientInterceptors;
import io.grpc.ForwardingClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClientBearerInterceptor
        implements ClientInterceptor {

    private final String token;
    public static final Metadata.Key<String> AUTH =
            Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
            MethodDescriptor<ReqT, RespT> methodDescriptor,
            CallOptions callOptions,
            Channel channel) {

        return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) {
            @Override
            public void start(Listener<RespT> responseListener,
                              Metadata headers) {
                headers.put(AUTH, "Bearer " + token);
                super.start(responseListener, headers);
            }
        };
    }

    public static Channel withToken(
            Channel channel,
            String token) {
        return ClientInterceptors.intercept(channel, new ClientBearerInterceptor(token));
    }
}
