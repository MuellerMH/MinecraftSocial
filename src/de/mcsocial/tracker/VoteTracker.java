package de.mcsocial.tracker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.security.KeyPair;

import javax.crypto.BadPaddingException;

import org.bukkit.Bukkit;

import com.vexsoftware.votifier.crypto.RSA;
import com.vexsoftware.votifier.crypto.RSAIO;
import com.vexsoftware.votifier.crypto.RSAKeygen;

import de.mcsocial.main.MCSocial;
import de.mcsocial.notification.VoteNotificationEvent;
import de.mcsocial.notification.VoteNotify;

public class VoteTracker extends Thread {
	private static MCSocial plugin;
	private String host;
	private int port;
	private KeyPair keyPair;
	private static VoteTracker listener;
	private ServerSocket server;
	private boolean running;

	/**
	 * S
	 *
	 * @param plugin
	 */
	public VoteTracker(MCSocial plugin) {
		VoteTracker.plugin = plugin;
		this.host = getHost();
		this.port = 8192;
		this.running = true;
		generateSetup();

		startSocket();
	}

	private void startSocket() {
		try {
			server = new ServerSocket();
			server.bind(new InetSocketAddress(host, port));
		} catch (IOException e) {
			// System.out.println("[MCSocial] startSocket." + e.getMessage());
		}
	}

	private void shutdown() {
		running = false;
		if (server == null)
			return;
		try {
			server.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void run() {
		// Main loop.
		while (running) {
			try {
				Socket socket = server.accept();
				socket.setSoTimeout(5000); // Don't hang on slow connections.
				BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				InputStream in = socket.getInputStream();

				// Send them our version.
				writer.write("MCSocial 0.0.0.1.7");
				writer.newLine();
				writer.flush();

				// Read the 256 byte block.
				byte[] block = new byte[256];
				in.read(block, 0, block.length);

				// Decrypt the block.
				block = RSA.decrypt(block, keyPair.getPrivate());
				int position = 0;

				// Perform the opcode check.

				// System.out.println("[MCSocial] Vote incomming." + block.toString());
				// Perform the opcode check.
				String opcode = readString(block, position);
				position += opcode.length() + 1;

				// System.out.println("[MCSocial] Vote incomming." + opcode);

				// Parse the block.
				String serviceName = readString(block, position);
				position += serviceName.length() + 1;
				String username = readString(block, position);
				position += username.length() + 1;
				String address = readString(block, position);
				position += address.length() + 1;
				String timeStamp = readString(block, position);
				position += timeStamp.length() + 1;
				final VoteNotify vote = new VoteNotify();
				vote.setServiceName(serviceName);
				vote.setUsername(username);
				vote.setAddress(address);
				vote.setTimeStamp(timeStamp);

				// Call event in a synchronized fashion to ensure that the
				// custom event runs in the
				// the main server thread, not this one.
				VoteTracker.plugin.getServer().getScheduler().scheduleSyncDelayedTask(VoteTracker.plugin, new Runnable() {
					public void run() {
						Bukkit.getServer().getPluginManager().callEvent(new VoteNotificationEvent(vote));
					}
				});

				// Clean up.
				writer.close();
				in.close();
				socket.close();
			} catch (SocketException ex) {
				// System.out.println("[MCSocial] Vote incomming." + ex.getMessage());
			} catch (BadPaddingException ex) {
				// System.out.println("[MCSocial] Vote incomming." + ex.getMessage());
			} catch (Exception ex) {
				// System.out.println("[MCSocial] Vote incomming." + ex.getMessage());
			}
		}
	}

	/**
	 * Reads a string from a block of data.
	 *
	 * @param data The data to read from
	 * @return The string
	 */
	private String readString(byte[] data, int offset) {
		StringBuilder builder = new StringBuilder();
		for (int i = offset; i < data.length; i++) {
			if (data[i] == '\n')
				break; // Delimiter reached.
			builder.append((char) data[i]);
		}
		return builder.toString();
	}

	public static void onEnable(MCSocial plugin) {
		VoteTracker.listener = new VoteTracker(plugin);
		VoteTracker.listener.start();
	}

	public static void onDisable() {
		VoteTracker.listener.shutdown();
	}

	private void generateSetup() {
		File rsaDirectory = new File(VoteTracker.plugin.getDataFolder() + "/rsa");

		// Replace to remove a bug with Windows paths - SmilingDevil
		String listenerDirectory = VoteTracker.plugin.getDataFolder().toString().replace("\\", "/") + "/listeners";

		try {
			if (!rsaDirectory.exists()) {
				rsaDirectory.mkdir();
				new File(listenerDirectory).mkdir();
				keyPair = RSAKeygen.generate(2048);
				RSAIO.save(rsaDirectory, keyPair);

			} else {
				keyPair = RSAIO.load(rsaDirectory);
			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	private String getHost() {

		String hostAddr = Bukkit.getServer().getIp();
		if (hostAddr == null || hostAddr.length() == 0)
			hostAddr = "0.0.0.0";

		// System.out.println("[MCSocial] getHost." + hostAddr);
		return hostAddr;
	}

}
