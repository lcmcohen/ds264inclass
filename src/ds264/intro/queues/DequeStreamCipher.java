package ds264.intro.queues;

import java.util.Deque;
import java.util.LinkedList;

public class DequeStreamCipher {
    private Deque<Integer> keyStream;

    public DequeStreamCipher(byte[] key) {
        keyStream = generateKeyStream(key);
    }

    private Deque<Integer> generateKeyStream(byte[] key) {
        Deque<Integer> keyDeque = new LinkedList<>();

        // Initialize the deque with the key bytes
        for (byte b : key) {
            keyDeque.offerLast((int) b);
        }

        return keyDeque;
    }

    public byte encrypt(byte plaintext) {
        // Get the next key byte from the front of the deque
        int keyByte = keyStream.pollFirst();

        // XOR the plaintext byte with the key byte to get the ciphertext byte
        byte ciphertext = (byte) (plaintext ^ keyByte);

        // Rotate the key byte and put it back into the rear of the deque
        keyStream.offerLast(keyByte);

        return ciphertext;
    }

    public byte decrypt(byte ciphertext) {
        // Get the next key byte from the front of the deque
        int keyByte = keyStream.pollFirst();

        // XOR the ciphertext byte with the key byte to get the plaintext byte
        byte plaintext = (byte) (ciphertext ^ keyByte);

        // Rotate the key byte and put it back into the rear of the deque
        keyStream.offerLast(keyByte);

        return plaintext;
    }

    public static void main(String[] args) {
        // Example usage
        byte[] key = {0x1A, 0x2B, 0x3C, 0x4D, 0x5E};
        DequeStreamCipher streamCipher = new DequeStreamCipher(key);

        String plaintext = "Hello, World!";
        byte[] encryptedBytes = new byte[plaintext.length()];

        // Encrypt the message
        for (int i = 0; i < plaintext.length(); i++) {
            encryptedBytes[i] = streamCipher.encrypt((byte) plaintext.charAt(i));
        }

        // Decrypt the message
        StringBuilder decryptedMessage = new StringBuilder();
        for (byte b : encryptedBytes) {
            decryptedMessage.append((char) streamCipher.decrypt(b));
        }

        System.out.println("Original: " + plaintext);
        System.out.print("Encrypted: ");
        for (byte b : encryptedBytes) {
            System.out.print(String.format("%02X ", b));
        }
        System.out.println();
        System.out.println("Decrypted: " + decryptedMessage.toString());
    }
}
