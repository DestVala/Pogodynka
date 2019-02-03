package multicast.network;

import multicast.Message;
import multicast.converter.PacketConverter;
import multicast.message.IntroduceResponce;

import java.io.IOException;
import java.net.*;

public class UdpSender {
    IntroduceResponce introduceResponce = new IntroduceResponce();
    PacketConverter packetConverter = new PacketConverter();
    private DatagramSocket socket;
    private InetAddress group;
    private byte[] buf;

    public boolean sendMessage(UdpPacket packet) {
        // convert UdpPacket to byte[]
        try {
            socket = new DatagramSocket();
            group = InetAddress.getByName("224.0.0.0");
            buf = packetConverter.serialize(packet);

            DatagramPacket sendPacket = new DatagramPacket(buf, buf.length, group, introduceResponce.getPort());
            socket.send(sendPacket);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
//        buf = multicastMessage.getBytes();
        return false;
    }

    private boolean sendMessage(byte[] data) {


        return false;
    }
}
