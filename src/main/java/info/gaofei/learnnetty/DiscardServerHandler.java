package info.gaofei.learnnetty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
/**
 * Created by GaoQingming on 2018/10/11 0011.
 */


/**
 * Handles a server-side channel.
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter { // (1)

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
        //ByteBuf in = (ByteBuf) msg;
        //try {
        //    while (in.isReadable()) { // (1)
        //        System.out.print((char) in.readByte());
        //        System.out.flush();
        //    }
        //} finally {
        //    ReferenceCountUtil.release(msg); // (2)
        //}
        ctx.writeAndFlush(msg);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}