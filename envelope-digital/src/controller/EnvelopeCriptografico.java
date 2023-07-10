package controller;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class EnvelopeCriptografico {

    private String pathArqClaro, pathArqChavePublica, pathSaidaArqCriptografado, pathSaidaArqChaveAssinada, algoritmoSimetrico;

    public EnvelopeCriptografico(String pathArqClaro, String pathArqChavePublica, String pathSaidaArqCriptografado, String pathSaidaArqChaveAssinada, String algoritmoSimetrico) {
        this.pathArqClaro = pathArqClaro;
        this.pathArqChavePublica = pathArqChavePublica;
        this.pathSaidaArqCriptografado = pathSaidaArqCriptografado;
        this.pathSaidaArqChaveAssinada = pathSaidaArqChaveAssinada;
        this.algoritmoSimetrico = algoritmoSimetrico;
    }

    public void execute() throws Exception{
        // Gerar chave simétrica temporária/aleatória
        SecretKey chaveSimetrica = gerarChaveSimetrica(algoritmoSimetrico);

        // Cifrar arquivo em claro com a chave gerada
        byte[] arquivoCriptografado = cifrarArquivo(pathArqClaro, chaveSimetrica, algoritmoSimetrico);

        // Carregar a chave pública do destinatário
        PublicKey chavePublica = carregarChavePublica(pathArqChavePublica);

        // Cifrar a chave temporária com a chave do destinatário
        byte[] chaveCriptografada = cifrarChaveSimetrica(chaveSimetrica, chavePublica);

        // Salvar os arquivos gerados
        salvarArquivo(pathSaidaArqCriptografado, arquivoCriptografado);
        salvarArquivo(pathSaidaArqChaveAssinada, chaveCriptografada);
    }

    // Gerar chave simétrica temporária/aleatória
    private SecretKey gerarChaveSimetrica(String algoritmo) throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(algoritmo);
        return keyGenerator.generateKey();
    }

    // Cifrar arquivo em claro com a chave gerada
    private byte[] cifrarArquivo(String arquivoClaro, SecretKey chaveSimetrica, String algoritmo)
            throws Exception {
        Cipher cipher = Cipher.getInstance(algoritmo);
        cipher.init(Cipher.ENCRYPT_MODE, chaveSimetrica);

        byte[] arquivoBytes = Files.readAllBytes(Paths.get(arquivoClaro));
        return cipher.doFinal(arquivoBytes);
    }

    // Carregar chave pública do arquivo
    private PublicKey carregarChavePublica(String chavePublicaFile) throws Exception {
        byte[] chaveBytes = Files.readAllBytes(Paths.get(chavePublicaFile));
        String chavePEM = new String(chaveBytes);
        chavePEM = chavePEM.replaceAll("\\n", "")
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "");
        byte[] chaveDecodificada = decodeBase64(chavePEM);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(chaveDecodificada);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(spec);
    }

    private byte[] decodeBase64(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != '-' && c != '\n' && c != '\r') {
                stringBuilder.append(c);
            }
        }
        return Base64.getDecoder().decode(stringBuilder.toString());
    }

    // Cifrar a chave temporária com a chave pública do destinatário
    private byte[] cifrarChaveSimetrica(SecretKey chaveSimetrica, PublicKey chavePublica) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, chavePublica);
        return cipher.doFinal(chaveSimetrica.getEncoded());
    }

    // Salvar arquivo no disco
    private void salvarArquivo(String nomeArquivo, byte[] conteudo) throws Exception {
        String caminhoCompleto =  nomeArquivo;
        try (FileOutputStream fos = new FileOutputStream(caminhoCompleto)) {
            fos.write(conteudo);
        }
    }
}