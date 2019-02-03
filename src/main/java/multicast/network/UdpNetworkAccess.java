//package multicast.network;
//
//import packet.converter.MessageConverter;
//import packet.message.Ingoing;
//import packet.message.MessageConfirmation;
//import packet.message.Outgoing;
//import packet.message.TextMessage;
//
//public class UdpNetworkAccess {
//	private UdpSender sender;
//	private UdpReceiver receiver;
//
//	public boolean sendMessage(TextMessage message) {
//		// Convert message do UdpMessage();
//		UdpPacket packet = new MessageConverter().serialize(message);
//		sender.sendMessage(packet);
//		return false;
//	}
//
//	public boolean confirmMessage(MessageConfirmation confirmation) {
//		return false;
//	}
//
//	public boolean leaveChat(Outgoing message) {
//		return false;
//	}
//
//	public boolean joinChat(Ingoing message) {
//		return false;
//	}
//}
