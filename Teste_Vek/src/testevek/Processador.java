package testevek;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author fernando
 */
abstract class Processador {
    // variáveis estaticas para facilitar o uso das mesmas entre classes e metodos, e tambem para sanar problemas que tive com o uso de não estaticas
    static int verificadorValor; 
    static String id;
        
    public static void CheckPagamento(String pagamento){        
        JFormattedTextField parcelamento = new JFormattedTextField(); 
        JFormattedTextField parcelamento6 = new JFormattedTextField();
        JFormattedTextField parcelamento12 = new JFormattedTextField(); 
        
        if(pagamento.equals("Débito")){
            JOptionPane.showMessageDialog(null, "Operação concluída", pagamento, JOptionPane.PLAIN_MESSAGE);
            
        }else if(pagamento.equals("Crédito")){
            id = "A";
            maskOnlyInt(parcelamento); 
            Object[] campos = { 
                "Taxa de Crédito em % (Obrigatório)", parcelamento
            };
            
            JOptionPane.showMessageDialog(null, campos, pagamento, JOptionPane.PLAIN_MESSAGE);
            String parcel = parcelamento.getText(); 
            parcel = parcel.replace(" ",""); 
            verificaVazio(parcel, pagamento);           
            
        }else{
            id = "B"; // define o id para o produtob, identificado no MainJFrame como 4468
            Object[] campos = { 
                "É Recomendado que seja preenchido um dos campos.",
                "\n Taxa de Parcelamento 6x em %", parcelamento6,
                "Taxa de Parcelamento 12x em %", parcelamento12     
                    
            };
            
            JOptionPane.showMessageDialog(null, campos, pagamento, JOptionPane.PLAIN_MESSAGE);  
            
            String parcel6 = parcelamento6.getText(); 
            String parcel12 = parcelamento12.getText();
            parcel6 = parcel6.replace(" ",""); 
            parcel12 = parcel12.replace(" ","");
            
            verificaVazioB(parcel6, parcel12, pagamento);            
        }
    }
        
    public static void verificaVazio(String testeVazio, String pagamento){        
        if(testeVazio.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo requerido.", "Vek", JOptionPane.PLAIN_MESSAGE);          
        
        }else{
            verificadorValor = Integer.parseInt(testeVazio);
            verificaValor(pagamento);    
        }
    }   

    public static void verificaVazioB(String parcel6, String parcel12, String pagamento){
        if(!parcel6.isEmpty()){ 
            verificadorValor = Integer.parseInt(parcel6);
            verificaValor(pagamento);
            parcel12 = ""; // seta o parcel12 para vazio, assim evitando entrar na segunda condição, caso o usuario preencha as duas opções
        
        }else if(!parcel12.isEmpty()){
            if(parcel12.equalsIgnoreCase("N/A")){
                JOptionPane.showMessageDialog(null, "Operação concluída", pagamento, JOptionPane.PLAIN_MESSAGE);
                
            }else{                
                verificadorValor = Integer.parseInt(parcel12);
                verificaValor(pagamento);                
            }         
        }
    }
    
    public static void verificaValor(String pagamento){
        if(id.equals("C")){
            if(verificadorValor >= 1 && verificadorValor <= 10){        
                JOptionPane.showMessageDialog(null, "Operação concluída", pagamento, JOptionPane.PLAIN_MESSAGE);          

            }else{
                JOptionPane.showMessageDialog(null, "Taxa fora dos padrões aceitaveis.", pagamento, JOptionPane.PLAIN_MESSAGE); 
            }
        
        }else{        
            if(verificadorValor > 10){
                JOptionPane.showMessageDialog(null, "Operação concluída", pagamento, JOptionPane.PLAIN_MESSAGE);
            
            }else{
                JOptionPane.showMessageDialog(null, "Taxa fora dos padrões aceitaveis.", pagamento, JOptionPane.PLAIN_MESSAGE);        
            }
        }            
    }
    
    public static void maskOnlyInt(JFormattedTextField jtextfield) {
        try {
            MaskFormatter apenasInt = new MaskFormatter("**"); // delimita quantidade de caracteres
            apenasInt.setValidCharacters("1234567890"); // delimita os caracteres usáveis
            apenasInt.install(jtextfield); 

            jtextfield.addFocusListener(new FocusListener() { // coloca o cursor no começo da linha, pois a mascara joga o mesmo para o fim do delimitador
                @Override
                public void focusGained(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }

                @Override
                public void focusLost(FocusEvent fe) {
                    jtextfield.setCaretPosition(0);
                }
            });
        } catch (ParseException ex) { 
            Logger.getLogger(Processador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
