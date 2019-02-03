package multicast.converter;

import multicast.message.MessageType;
import multicast.network.UdpPacket;
import org.junit.Assert;
import org.junit.Test;

public class PacketConverterTest {
    PacketConverter packetConverter = new PacketConverter();

    @Test
    public void shouldCheckSerializeAndDeserialize() {
        byte[] values = {1, 2, 3};
        UdpPacket udpPacket = new UdpPacket(MessageType.IntroduceRequest, values.length, values);
        byte[] result = packetConverter.serialize(udpPacket);
        UdpPacket resultUdpPacket=packetConverter.deserialize(result);
        Assert.assertEquals(udpPacket,resultUdpPacket);
    }
}
