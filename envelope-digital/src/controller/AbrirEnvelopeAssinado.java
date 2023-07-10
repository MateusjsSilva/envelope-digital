package controller;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class AbrirEnvelopeAssinado {

    private String pathMensagemCriptografada, pathChaveCriptografada, pathSaidaMensagemDecifrada, pathChavePrivada, algoritmoSimetrico;

    public AbrirEnvelopeAssinado(String pathMensagemCriptografada, String pathChaveCriptografada,
            String pathSaidaMensagemDecifrada, String pathChavePrivada, String algoritmoSimetrico) {
        this.pathMensagemCriptografada = pathMensagemCriptografada;
        this.pathChaveCriptografada = pathChaveCriptografada;
        this.pathSaidaMensagemDecifrada = pathSaidaMensagemDecifrada;
        this.pathChavePrivada = pathChavePrivada;
        this.algoritmoSimetrico = algoritmoSimetrico;
    }

    public void execute() throws Exception{
        abrirEnvelopeAssinado(pathMensagemCriptografada, pathChaveCriptografada, pathChavePrivada, algoritmoSimetrico);
    }

    // Abrir envelope assinado
    public void abrirEnvelopeAssinado(String mensagemCriptografadaFile, String chaveCriptografadaFile, String chavePrivadaFile, String algoritmoSimetrico)
            throws Exception {
        // Carregar chave privada do destinatário
        PrivateKey chavePrivada = carregarChavePrivada(chavePrivadaFile);

        // Decifrar a chave temporária com a chave privada do destinatário
        byte[] chaveCriptografadaBytes = Files.readAllBytes(Paths.get(chaveCriptografadaFile));
        byte[] chaveTemporariaBytes = decifrarChaveTemporaria(chaveCriptografadaBytes, chavePrivada);

        // Decifrar o arquivo em claro com a chave obtida
        byte[] mensagemCriptografadaBytes = Files.readAllBytes(Paths.get(mensagemCriptografadaFile));
        byte[] mensagemDecifradaBytes = decifrarMensagem(mensagemCriptografadaBytes, chaveTemporariaBytes, algoritmoSimetrico);

        // Salva o conteúdo do arquivo descriptografado em um arquivo de texto
        String mensagemDecifradaTexto = new String(mensagemDecifradaBytes);
        Files.write(Paths.get(pathSaidaMensagemDecifrada), mensagemDecifradaTexto.getBytes());
    }

    // Carregar chave privada do arquivo
    private PrivateKey carregarChavePrivada(String chavePrivadaFile) throws Exception {
        byte[] chaveBytes = Files.readAllBytes(Paths.get(chavePrivadaFile));
        String chavePEM = new String(chaveBytes);
        chavePEM = chavePEM.replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");
        byte[] chaveDecodificada = Base64.getDecoder().decode(chavePEM);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(chaveDecodificada);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(spec);
    }

    // Decifrar a chave temporária com a chave privada do destinatário
    private byte[] decifrarChaveTemporaria(byte[] chaveCriptografada, PrivateKey chavePrivada)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, chavePrivada);
        return cipher.doFinal(chaveCriptografada);
    }

    // Decifrar a mensagem com a chave obtida
    private byte[] decifrarMensagem(byte[] mensagemCriptografada, byte[] chaveTemporaria, String algoritmoSimetrico)
            throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException,
            BadPaddingException, IllegalBlockSizeException {
        
    	SecretKey chaveSimetrica = new SecretKeySpec(chaveTemporaria, algoritmoSimetrico);
        Cipher cipher = Cipher.getInstance(algoritmoSimetrico);
        cipher.init(Cipher.DECRYPT_MODE, chaveSimetrica);
        return cipher.doFinal(mensagemCriptografada);
    }
}