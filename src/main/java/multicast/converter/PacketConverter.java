package multicast.converter;

import multicast.message.MessageType;
import multicast.network.UdpPacket;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class PacketConverter {

	public UdpPacket deserialize(byte[] tlvData) {
        ByteBuffer buffer=ByteBuffer.wrap(tlvData);
        MessageType type=MessageType.deserialize(buffer.get(0));
        short length = buffer.getShort(1);
        byte[] tlv = Arrays.copyOfRange(tlvData,3,length+3);

	    return new UdpPacket(type,length,tlv);
	}

	public byte[] serialize(UdpPacket message) {
	    ByteBuffer buffer=ByteBuffer.allocate(message.getLength()+3);
	    buffer.put(message.getType().serialize());
	    buffer.putShort((short) message.getLength());
	    buffer.put(message.getValue());

	    return buffer.array();
	}
}
