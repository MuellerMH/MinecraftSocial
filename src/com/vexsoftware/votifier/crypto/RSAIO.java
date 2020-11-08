/*
 * Copyright (C) 2011 Vex Software LLC
 * This file is part of Votifier.
 * 
 * Votifier is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Votifier is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Votifier.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.vexsoftware.votifier.crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

<<<<<<< HEAD
import javax.xml.bind.DatatypeConverter;
=======
//import javax.xml.bind.DatatypeConverter;
>>>>>>> b4ade11... add new directory

/**
 * Static utility methods for saving and loading RSA key pairs.
 * 
 * @author Blake Beaupain
 */
public class RSAIO {

	/**
	 * Saves the key pair to the disk.
	 * 
	 * @param directory
	 *            The directory to save to
	 * @param keyPair
	 *            The key pair to save
	 * @throws Exception
	 *             If an error occurs
	 */
	public static void save(File directory, KeyPair keyPair) throws Exception {
<<<<<<< HEAD
=======
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyPair.getPublic().getEncoded());
		FileOutputStream fos = new FileOutputStream(directory.getAbsoluteFile() + "/public.key");
		fos.write(x509EncodedKeySpec.getEncoded());
		fos.close();
		
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyPair.getPrivate().getEncoded());
		fos = new FileOutputStream(directory.getAbsoluteFile() + "/private.key");
		fos.write(pkcs8EncodedKeySpec.getEncoded());
		fos.close();
		/*
>>>>>>> b4ade11... add new directory
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();

		// Store the public key.
		X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(
				publicKey.getEncoded());
		FileOutputStream out = new FileOutputStream(directory + "/public.key");
<<<<<<< HEAD
		out.write(DatatypeConverter.printBase64Binary(publicSpec.getEncoded())
				.getBytes());
=======
		out.write(DatatypeConverter.printBase64Binary(publicSpec.getEncoded()).getBytes());
>>>>>>> b4ade11... add new directory
		out.close();

		// Store the private key.
		PKCS8EncodedKeySpec privateSpec = new PKCS8EncodedKeySpec(
				privateKey.getEncoded());
		out = new FileOutputStream(directory + "/private.key");
<<<<<<< HEAD
		out.write(DatatypeConverter.printBase64Binary(privateSpec.getEncoded())
				.getBytes());
		out.close();
=======
		out.write(DatatypeConverter.printBase64Binary(privateSpec.getEncoded()).getBytes());
		out.close();
		*/
>>>>>>> b4ade11... add new directory
	}

	/**
	 * Loads an RSA key pair from a directory. The directory must have the files
	 * "public.key" and "private.key".
	 * 
	 * @param directory
	 *            The directory to load from
	 * @return The key pair
	 * @throws Exception
	 *             If an error occurs
	 */
	public static KeyPair load(File directory) throws Exception {
<<<<<<< HEAD
=======
		File dateiPriK = new File(directory.getAbsoluteFile() + "/private.key");
		 
		// Private Key lesen
		FileInputStream fis = new FileInputStream(dateiPriK);
		byte[] encodedPrivateKey = new byte[(int) dateiPriK.length()];
		fis.read(encodedPrivateKey);
		fis.close();
		       
		// generiere Key
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);   
		 
		File dateiPubK = new File(directory.getAbsoluteFile() + "/public.key");
		 
		// Public key lesen
		fis = new FileInputStream(dateiPubK);
		byte[] encodedPublicKey = new byte[(int) dateiPubK.length()];
		fis.read(encodedPublicKey);
		fis.close();
		       
		// generiere Key
		keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
		
		return new KeyPair(publicKey, privateKey);
		
		/*
>>>>>>> b4ade11... add new directory
		// Read the public key file.
		File publicKeyFile = new File(directory + "/public.key");
		FileInputStream in = new FileInputStream(directory + "/public.key");
		byte[] encodedPublicKey = new byte[(int) publicKeyFile.length()];
		in.read(encodedPublicKey);
<<<<<<< HEAD
		encodedPublicKey = DatatypeConverter.parseBase64Binary(new String(
				encodedPublicKey));
=======
		encodedPublicKey = DatatypeConverter.parseBase64Binary(new String(encodedPublicKey));
>>>>>>> b4ade11... add new directory
		in.close();

		// Read the private key file.
		File privateKeyFile = new File(directory + "/private.key");
		in = new FileInputStream(directory + "/private.key");
		byte[] encodedPrivateKey = new byte[(int) privateKeyFile.length()];
		in.read(encodedPrivateKey);
<<<<<<< HEAD
		encodedPrivateKey = DatatypeConverter.parseBase64Binary(new String(
				encodedPrivateKey));
=======
		encodedPrivateKey = DatatypeConverter.parseBase64Binary(new String(encodedPrivateKey));
>>>>>>> b4ade11... add new directory
		in.close();

		// Instantiate and return the key pair.
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
				encodedPublicKey);
		PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
<<<<<<< HEAD
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(
				encodedPrivateKey);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
		return new KeyPair(publicKey, privateKey);
=======
		PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
		PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
		return new KeyPair(publicKey, privateKey);
		*/
>>>>>>> b4ade11... add new directory
	}

}
