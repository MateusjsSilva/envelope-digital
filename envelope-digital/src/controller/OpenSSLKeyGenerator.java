package controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class OpenSSLKeyGenerator {
    
    private final String privateKeyPath;
    private final String publicKeyPath;

    public OpenSSLKeyGenerator(String privateKeyPath, String publicKeyPath) {
        this.privateKeyPath = privateKeyPath;
        this.publicKeyPath = publicKeyPath;
    }

    public void execute() throws NoSuchAlgorithmException, IOException {
        // Gera o par de chaves RSA
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Tamanho da chave em bits
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Salva a chave privada em formato PEM
        savePrivateKeyPEM(privateKeyPath, keyPair.getPrivate());

        // Salva a chave pública em formato PEM
        savePublicKeyPEM(publicKeyPath, keyPair.getPublic());
    }

    // Método para salvar a chave privada em formato PEM
    private void savePrivateKeyPEM(String filePath, PrivateKey privateKey) throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
            fos.write("-----BEGIN PRIVATE KEY-----\n".getBytes());
            fos.write(java.util.Base64.getEncoder().encode(spec.getEncoded()));
            fos.write("\n-----END PRIVATE KEY-----\n".getBytes());
        }
    }

    // Método para salvar a chave pública em formato PEM
    private void savePublicKeyPEM(String filePath, PublicKey publicKey) throws FileNotFoundException, IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            X509EncodedKeySpec spec = new X509EncodedKeySpec(publicKey.getEncoded());
            fos.write("-----BEGIN PUBLIC KEY-----\n".getBytes());
            fos.write(java.util.Base64.getEncoder().encode(spec.getEncoded()));
            fos.write("\n-----END PUBLIC KEY-----\n".getBytes());
        }
    }
}