package view;

import controller.*;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EnvelopeDigitalGUI extends javax.swing.JFrame {
    
    private Boolean chave_publica_ok, chave_privada_ok , texto_claro_ok, mensagem_criptografada_ok, chave_criptografada_ok; // variáveis de controle
    private String pathArqClaro, pathArqChavePublica, pathMensagemCriptografada, pathChaveCriptografada, pathChavePrivada; // caminhos de entrada
    private String pathSaidaArqCriptografado, pathSaidaArqChaveAssinada, pathSaidaMensagemDecifrada; // caminhos de saída

    public EnvelopeDigitalGUI() {
        initComponents();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    // Método para selecionar arquivos usando o JFileChooser
    private JFileChooser SelecionarArquivos(){
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecione o arquivo de entrada");
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        // Define o diretório inicial como o diretório pai da raiz do projeto
        String projectDir = System.getProperty("user.dir");
        File parentDir = new File(projectDir).getParentFile();
        fileChooser.setCurrentDirectory(parentDir);

        return fileChooser;
    }

    // Método para atualizar os botões com base nas variáveis de controle
    private void AtualizarBotoes(){
        
        if(chave_publica_ok && texto_claro_ok)
            Button_CriarEnvelope.setEnabled(true);

        if(mensagem_criptografada_ok && chave_criptografada_ok && chave_privada_ok)
            Button_AbrirEnvelope.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Combobox_AlgoritmoSimetrico = new javax.swing.JComboBox<>();
        Button_AbrirChavePrivada = new javax.swing.JButton();
        Button_AbrirChavePublica = new javax.swing.JButton();
        Button_AbrirTextoClaro = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        Button_AbrirMensagemCriptografada = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        Button_AbrirChaveCriptografada = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        label_ArqTextoClaro = new javax.swing.JLabel();
        label_ArqChavePublica = new javax.swing.JLabel();
        label_ArqChavePrivada = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        label_ChaveCripto = new javax.swing.JLabel();
        label_MensagemCripto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Button_AbrirEnvelope = new javax.swing.JButton();
        Button_CriarChavePublica = new javax.swing.JButton();
        Button_CriarEnvelope = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Button_PathSaidaArqCriptografado = new javax.swing.JButton();
        Button_PathSaidaChaveAssinada = new javax.swing.JButton();
        Button_PathArqDecifrado = new javax.swing.JButton();
        Label_SaidaArqCriptografado = new javax.swing.JLabel();
        Label_SaidaChaveAssinada = new javax.swing.JLabel();
        Label_SaidaArqDecifrado = new javax.swing.JLabel();

        jLabel9.setText("jLabel9");

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Envelope Digital");
        setLocationByPlatform(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Configurações", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 0, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel4.setText("Chave privada :");

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel2.setText("Texto claro : ");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel3.setText("Chave publica :");

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel5.setText("Algoritmo assimetrico:");

        Combobox_AlgoritmoSimetrico.setBackground(new java.awt.Color(196, 225, 255));
        Combobox_AlgoritmoSimetrico.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Combobox_AlgoritmoSimetrico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AES", "DES", "RC4" }));
        Combobox_AlgoritmoSimetrico.setBorder(null);
        Combobox_AlgoritmoSimetrico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Combobox_AlgoritmoSimetrico.setFocusable(false);
        Combobox_AlgoritmoSimetrico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combobox_AlgoritmoSimetricoActionPerformed(evt);
            }
        });

        Button_AbrirChavePrivada.setBackground(new java.awt.Color(196, 225, 255));
        Button_AbrirChavePrivada.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_AbrirChavePrivada.setText("Abrir");
        Button_AbrirChavePrivada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_AbrirChavePrivada.setFocusPainted(false);
        Button_AbrirChavePrivada.setFocusable(false);
        Button_AbrirChavePrivada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AbrirChavePrivadaActionPerformed(evt);
            }
        });

        Button_AbrirChavePublica.setBackground(new java.awt.Color(196, 225, 255));
        Button_AbrirChavePublica.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_AbrirChavePublica.setText("Abrir");
        Button_AbrirChavePublica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_AbrirChavePublica.setFocusPainted(false);
        Button_AbrirChavePublica.setFocusable(false);
        Button_AbrirChavePublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AbrirChavePublicaActionPerformed(evt);
            }
        });

        Button_AbrirTextoClaro.setBackground(new java.awt.Color(196, 225, 255));
        Button_AbrirTextoClaro.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_AbrirTextoClaro.setText("Abrir");
        Button_AbrirTextoClaro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_AbrirTextoClaro.setFocusPainted(false);
        Button_AbrirTextoClaro.setFocusable(false);
        Button_AbrirTextoClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AbrirTextoClaroActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel17.setText("Mensagem criptografada:");

        Button_AbrirMensagemCriptografada.setBackground(new java.awt.Color(196, 225, 255));
        Button_AbrirMensagemCriptografada.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_AbrirMensagemCriptografada.setText("Abrir");
        Button_AbrirMensagemCriptografada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_AbrirMensagemCriptografada.setFocusPainted(false);
        Button_AbrirMensagemCriptografada.setFocusable(false);
        Button_AbrirMensagemCriptografada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AbrirMensagemCriptografadaActionPerformed(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel18.setText("Chave criptografada:");

        Button_AbrirChaveCriptografada.setBackground(new java.awt.Color(196, 225, 255));
        Button_AbrirChaveCriptografada.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_AbrirChaveCriptografada.setText("Abrir");
        Button_AbrirChaveCriptografada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_AbrirChaveCriptografada.setFocusPainted(false);
        Button_AbrirChaveCriptografada.setFocusable(false);
        Button_AbrirChaveCriptografada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AbrirChaveCriptografadaActionPerformed(evt);
            }
        });

        jSeparator3.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator3.setEnabled(false);

        jSeparator4.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator4.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jSeparator3)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Combobox_AlgoritmoSimetrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_AbrirTextoClaro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_AbrirChavePublica))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_AbrirMensagemCriptografada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_AbrirChaveCriptografada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Button_AbrirChavePrivada)))
                        .addGap(0, 16, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Button_AbrirTextoClaro)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_AbrirChavePublica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Button_AbrirMensagemCriptografada)
                    .addComponent(Button_AbrirChaveCriptografada)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(Button_AbrirChavePrivada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Combobox_AlgoritmoSimetrico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações do arquivos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 0, 12))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel1.setText("Texto claro:");

        label.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        label.setText("Chave publica:");

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel7.setText("Chave privada:");

        label_ArqTextoClaro.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        label_ArqTextoClaro.setText("Não informado.");

        label_ArqChavePublica.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        label_ArqChavePublica.setText("Não informado.");

        label_ArqChavePrivada.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        label_ArqChavePrivada.setText("Não informado.");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel13.setText("Chave criptografada:");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel11.setText("Mensagem criptografada:");

        label_ChaveCripto.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        label_ChaveCripto.setText("Não informado.");

        label_MensagemCripto.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        label_MensagemCripto.setText("Não informado.");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_MensagemCripto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_ArqTextoClaro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_ArqChavePublica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_ArqChavePrivada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label_ChaveCripto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(label_ArqTextoClaro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label)
                    .addComponent(label_ArqChavePublica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(label_ArqChavePrivada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_ChaveCripto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_MensagemCripto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        Button_AbrirEnvelope.setBackground(new java.awt.Color(196, 225, 255));
        Button_AbrirEnvelope.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_AbrirEnvelope.setText("Abrir envelope");
        Button_AbrirEnvelope.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_AbrirEnvelope.setEnabled(false);
        Button_AbrirEnvelope.setFocusPainted(false);
        Button_AbrirEnvelope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_AbrirEnvelopeActionPerformed(evt);
            }
        });

        Button_CriarChavePublica.setBackground(new java.awt.Color(196, 225, 255));
        Button_CriarChavePublica.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_CriarChavePublica.setText("Criar chaves");
        Button_CriarChavePublica.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_CriarChavePublica.setFocusPainted(false);
        Button_CriarChavePublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CriarChavePublicaActionPerformed(evt);
            }
        });

        Button_CriarEnvelope.setBackground(new java.awt.Color(196, 225, 255));
        Button_CriarEnvelope.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_CriarEnvelope.setText("Criar envelope");
        Button_CriarEnvelope.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_CriarEnvelope.setEnabled(false);
        Button_CriarEnvelope.setFocusPainted(false);
        Button_CriarEnvelope.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_CriarEnvelopeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(Button_CriarChavePublica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_AbrirEnvelope)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Button_CriarEnvelope, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_AbrirEnvelope)
                    .addComponent(Button_CriarEnvelope)
                    .addComponent(Button_CriarChavePublica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Arquivos de saida", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI", 0, 12))); // NOI18N

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel19.setText("Arq. criptografado:");

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel20.setText("Chave assinada:");

        jLabel23.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        jLabel23.setText("Arq. decifrado:");

        Button_PathSaidaArqCriptografado.setBackground(new java.awt.Color(196, 225, 255));
        Button_PathSaidaArqCriptografado.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_PathSaidaArqCriptografado.setText("Selecionar");
        Button_PathSaidaArqCriptografado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_PathSaidaArqCriptografado.setFocusPainted(false);
        Button_PathSaidaArqCriptografado.setFocusable(false);
        Button_PathSaidaArqCriptografado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PathSaidaArqCriptografadoActionPerformed(evt);
            }
        });

        Button_PathSaidaChaveAssinada.setBackground(new java.awt.Color(196, 225, 255));
        Button_PathSaidaChaveAssinada.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_PathSaidaChaveAssinada.setText("Selecionar");
        Button_PathSaidaChaveAssinada.setToolTipText("");
        Button_PathSaidaChaveAssinada.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_PathSaidaChaveAssinada.setFocusPainted(false);
        Button_PathSaidaChaveAssinada.setFocusable(false);
        Button_PathSaidaChaveAssinada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PathSaidaChaveAssinadaActionPerformed(evt);
            }
        });

        Button_PathArqDecifrado.setBackground(new java.awt.Color(196, 225, 255));
        Button_PathArqDecifrado.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Button_PathArqDecifrado.setText("Selecionar");
        Button_PathArqDecifrado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Button_PathArqDecifrado.setFocusPainted(false);
        Button_PathArqDecifrado.setFocusable(false);
        Button_PathArqDecifrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_PathArqDecifradoActionPerformed(evt);
            }
        });

        Label_SaidaArqCriptografado.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Label_SaidaArqCriptografado.setText(" ");

        Label_SaidaChaveAssinada.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Label_SaidaChaveAssinada.setText(" ");

        Label_SaidaArqDecifrado.setFont(new java.awt.Font("Yu Gothic UI", 0, 12)); // NOI18N
        Label_SaidaArqDecifrado.setText(" ");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_PathSaidaArqCriptografado))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_PathSaidaChaveAssinada))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Button_PathArqDecifrado)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Label_SaidaArqCriptografado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_SaidaChaveAssinada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_SaidaArqDecifrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(Button_PathSaidaArqCriptografado)
                    .addComponent(Label_SaidaArqCriptografado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_PathSaidaChaveAssinada)
                    .addComponent(jLabel20)
                    .addComponent(Label_SaidaChaveAssinada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Button_PathArqDecifrado)
                    .addComponent(jLabel23)
                    .addComponent(Label_SaidaArqDecifrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_AbrirEnvelopeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AbrirEnvelopeActionPerformed
        
        if(pathSaidaMensagemDecifrada == null){
            JOptionPane.showMessageDialog(null, "Selecione a pasta dos arquivos de saida.");
            return;
        }
        
        Object selectedItem = Combobox_AlgoritmoSimetrico.getSelectedItem();
        try {
            String algoritmo = selectedItem.toString();
            AbrirEnvelopeAssinado abrirEnvelopeAssinado = new AbrirEnvelopeAssinado(pathMensagemCriptografada, pathChaveCriptografada, pathSaidaMensagemDecifrada, pathChavePrivada, algoritmo);
            abrirEnvelopeAssinado.execute();
            JOptionPane.showMessageDialog(null, "Envelope aberto com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_Button_AbrirEnvelopeActionPerformed
    
    private void Button_AbrirTextoClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AbrirTextoClaroActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setDialogTitle("Selecione o arquivo em claro");

        // Aplicando filtro para arquivos txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            pathArqClaro = selectedFile.getPath();
          
            label_ArqTextoClaro.setText(fileName);
            texto_claro_ok = true;
            AtualizarBotoes();
        }
    }//GEN-LAST:event_Button_AbrirTextoClaroActionPerformed

    private void Combobox_AlgoritmoSimetricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combobox_AlgoritmoSimetricoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combobox_AlgoritmoSimetricoActionPerformed

    private void Button_AbrirChavePublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AbrirChavePublicaActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setDialogTitle("Selecione a chave publica");

        // Aplicando filtro para arquivos txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .pem", "pem");
        fileChooser.setFileFilter(filter);
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            pathArqChavePublica = selectedFile.getPath();
            
            label_ArqChavePublica.setText(fileName);
            chave_publica_ok = true;
            AtualizarBotoes();
        }
    }//GEN-LAST:event_Button_AbrirChavePublicaActionPerformed

    private void Button_AbrirChavePrivadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AbrirChavePrivadaActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setDialogTitle("Selecione a chave privada");

        // Aplicando filtro para arquivos txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .pem", "pem");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            pathChavePrivada =selectedFile.getPath();
                    
            label_ArqChavePrivada.setText(fileName);
            chave_privada_ok = true;
            AtualizarBotoes();
        }
    }//GEN-LAST:event_Button_AbrirChavePrivadaActionPerformed

    private void Button_PathSaidaArqCriptografadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PathSaidaArqCriptografadoActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setSelectedFile(new File("arquivo_criptografado.txt"));
        
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            pathSaidaArqCriptografado = selectedDirectory.getAbsolutePath().replace("\\", "/");
            
            // Extrair a última pasta e o nome do arquivo
            String lastFolder = selectedDirectory.getParentFile().getName();
            String fileName = selectedDirectory.getName();

            // Atualizar o texto do JLabel com a última pasta e o nome do arquivo
            String labelText = "Saida: " + lastFolder + "/" + fileName;
            Label_SaidaArqCriptografado.setText(labelText);
        }
    }//GEN-LAST:event_Button_PathSaidaArqCriptografadoActionPerformed

    private void Button_PathSaidaChaveAssinadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PathSaidaChaveAssinadaActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setSelectedFile(new File("chave_assinada.pem"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            pathSaidaArqChaveAssinada = selectedDirectory.getAbsolutePath().replace("\\", "/");
            
            // Extrair a última pasta e o nome do arquivo
            String lastFolder = selectedDirectory.getParentFile().getName();
            String fileName = selectedDirectory.getName();

            // Atualizar o texto do JLabel com a última pasta e o nome do arquivo
            String labelText = "Saida: " + lastFolder + "/" + fileName;
            Label_SaidaChaveAssinada.setText(labelText);
        }
    }//GEN-LAST:event_Button_PathSaidaChaveAssinadaActionPerformed

    private void Button_PathArqDecifradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_PathArqDecifradoActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setSelectedFile(new File("arquivo_decifrado.txt"));

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            pathSaidaMensagemDecifrada = selectedDirectory.getAbsolutePath().replace("\\", "/");
            
            // Extrair a última pasta e o nome do arquivo
            String lastFolder = selectedDirectory.getParentFile().getName();
            String fileName = selectedDirectory.getName();

            // Atualizar o texto do JLabel com a última pasta e o nome do arquivo
            String labelText = "Saida: " + lastFolder + "/" + fileName;
            Label_SaidaArqDecifrado.setText(labelText);
        }
    }//GEN-LAST:event_Button_PathArqDecifradoActionPerformed

    private void Button_AbrirChaveCriptografadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AbrirChaveCriptografadaActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setDialogTitle("Selecione a chave assinada");

        // Aplicando filtro para arquivos txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos .pem", "pem");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            pathChaveCriptografada = selectedFile.getPath();
          
            label_ChaveCripto.setText(fileName);
            chave_criptografada_ok = true;
            AtualizarBotoes();
        }
    }//GEN-LAST:event_Button_AbrirChaveCriptografadaActionPerformed

    private void Button_AbrirMensagemCriptografadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_AbrirMensagemCriptografadaActionPerformed
        
        JFileChooser fileChooser = SelecionarArquivos();
        fileChooser.setDialogTitle("Selecione o arquivo criptografado");

        // Aplicando filtro para arquivos txt
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos de texto", "txt");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            pathMensagemCriptografada = selectedFile.getPath();
          
            label_MensagemCripto.setText(fileName);
            mensagem_criptografada_ok = true;
            AtualizarBotoes();
        }
    }//GEN-LAST:event_Button_AbrirMensagemCriptografadaActionPerformed

    private void Button_CriarEnvelopeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CriarEnvelopeActionPerformed
        
        if(pathSaidaArqCriptografado == null || pathSaidaArqChaveAssinada == null){
            JOptionPane.showMessageDialog(null, "Selecione a pasta dos arquivos de saida.");
            return;
        }
        
        Object selectedItem = Combobox_AlgoritmoSimetrico.getSelectedItem();
        try {
            String algoritmo = selectedItem.toString();
            EnvelopeCriptografico envelopeCriptografico = new EnvelopeCriptografico(pathArqClaro, pathArqChavePublica, pathSaidaArqCriptografado, pathSaidaArqChaveAssinada, algoritmo);
            envelopeCriptografico.execute();
            JOptionPane.showMessageDialog(null, "Envelope criado com sucesso.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_Button_CriarEnvelopeActionPerformed

    private void Button_CriarChavePublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_CriarChavePublicaActionPerformed
        java.awt.EventQueue.invokeLater(() -> {
            new CriarChaveGUI().setVisible(true);
        });
    }//GEN-LAST:event_Button_CriarChavePublicaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_AbrirChaveCriptografada;
    private javax.swing.JButton Button_AbrirChavePrivada;
    private javax.swing.JButton Button_AbrirChavePublica;
    private javax.swing.JButton Button_AbrirEnvelope;
    private javax.swing.JButton Button_AbrirMensagemCriptografada;
    private javax.swing.JButton Button_AbrirTextoClaro;
    private javax.swing.JButton Button_CriarChavePublica;
    private javax.swing.JButton Button_CriarEnvelope;
    private javax.swing.JButton Button_PathArqDecifrado;
    private javax.swing.JButton Button_PathSaidaArqCriptografado;
    private javax.swing.JButton Button_PathSaidaChaveAssinada;
    private javax.swing.JComboBox<String> Combobox_AlgoritmoSimetrico;
    private javax.swing.JLabel Label_SaidaArqCriptografado;
    private javax.swing.JLabel Label_SaidaArqDecifrado;
    private javax.swing.JLabel Label_SaidaChaveAssinada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label_ArqChavePrivada;
    private javax.swing.JLabel label_ArqChavePublica;
    private javax.swing.JLabel label_ArqTextoClaro;
    private javax.swing.JLabel label_ChaveCripto;
    private javax.swing.JLabel label_MensagemCripto;
    // End of variables declaration//GEN-END:variables
}