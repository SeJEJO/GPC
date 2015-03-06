package Model;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Crypto {
	public static byte[] cifra(String sinCifrar) throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
		final byte[] bytes = sinCifrar.getBytes("UTF-8");
		final Cipher aes = obtieneCipher(true);
		final byte[] cifrado = aes.doFinal(bytes);
		return cifrado;
	}

	public static String descifra(byte[] cifrado) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException  {
		final Cipher aes = obtieneCipher(false);
		final byte[] bytes = aes.doFinal(cifrado);
		final String sinCifrar = new String(bytes, "UTF-8");
		return sinCifrar;
	}

	private static Cipher obtieneCipher(boolean paraCifrar) throws NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException, InvalidKeyException {
		final String frase = "Gpc_S3J3j011&R4m1";
		final MessageDigest digest = MessageDigest.getInstance("SHA");
		digest.update(frase.getBytes("UTF-8"));
		final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");

		final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
		if (paraCifrar) {
			aes.init(Cipher.ENCRYPT_MODE, key);
		} else {
			aes.init(Cipher.DECRYPT_MODE, key);
		}

		return aes;
	}
	
	public static String desordenar(String palabra){
		String desorden="",numeros="";
		char[] letras = palabra.toCharArray();
		int[] aleatorios = new int[letras.length];
		for(int i=0;i<letras.length;i++){
			aleatorios[i]= (int) (Math.random()*letras.length);
			char aux = letras[i];
			letras[i] = letras[aleatorios[i]];
			letras[aleatorios[i]] = aux;
			numeros = numeros+aleatorios[i]+";";
		}
		for(int i=0;i<letras.length;i++){
			desorden+=letras[i];
		}
		desorden+="/:"+numeros;
		return desorden;
	}
	public static String ordenar(String palabra){
		String ordenar="",numeros="";
		String palabrasinordenar = palabra.substring(0, palabra.indexOf("/:"));
		int[] num = new int[palabrasinordenar.length()];
		char[] letras = palabrasinordenar.toCharArray();
		numeros = palabra.substring(palabra.indexOf("/:")+2);
		for (int i = 0; i<num.length; i++) {
			num[i]= Integer.valueOf(numeros.substring(0, numeros.indexOf(";")));
			numeros = numeros.substring(numeros.indexOf(";")+1);
		}
		for (int i = letras.length-1; i >=0  ; i--) {
			char aux = letras[i];
			letras[i] = letras[num[i]];
			letras[num[i]] = aux;
		}
		for(int i=0;i<letras.length;i++){
			ordenar+=letras[i];
		}
		return ordenar;
	}
	
}
