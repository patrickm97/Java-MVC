package controller;

import javax.swing.JOptionPane;
import model.CalculaPoupanca;
import view.Janela;

/**
 * classe Controller
 * @author Patrick
 */
public class Controller {
    
    private Janela janela;
    private CalculaPoupanca calc;
    private double resultado, arredondado;
    
    public Controller(Janela janela) {
        this.janela = janela;
        calc = new CalculaPoupanca();
    }
    
    public void calcular() {
        boolean jurosVazio, anosVazio, depositoVazio, anosInteiro = false;
        jurosVazio = (janela.getCaixaJuros().getText() == null || janela.getCaixaJuros().getText().length() == 0);
        anosVazio = (janela.getCaixaAnos().getText() == null || janela.getCaixaAnos().getText().length() == 0);
        depositoVazio = (janela.getCaixaDeposito().getText() == null || janela.getCaixaDeposito().getText().length() == 0);
        
        // checando se todos os campos foram preenchidos
        if(jurosVazio == true || anosVazio == true || depositoVazio == true)
            JOptionPane.showMessageDialog(janela, "Erro, preencha os três primeiros campos"
                    , "ERRO", JOptionPane.ERROR_MESSAGE);
        else if(Double.parseDouble(janela.getCaixaJuros().getText()) <= 0.0)
                JOptionPane.showMessageDialog(janela, "Erro, os juros não podem ser menores ou iguais a 0.0"
                        , "ERRO", JOptionPane.ERROR_MESSAGE);
        else if(Integer.parseInt(janela.getCaixaAnos().getText()) < 1)
            JOptionPane.showMessageDialog(janela, "Erro, o número de anos não pode ser menor que 1"
                    , "ERRO", JOptionPane.ERROR_MESSAGE);
        else if(Double.parseDouble(janela.getCaixaDeposito().getText()) <= 0.0)
            JOptionPane.showMessageDialog(janela, "Erro, o depósito não pode ser menor ou igual a 0.0"
                    , "ERRO", JOptionPane.ERROR_MESSAGE);    
        else {
            double juros, deposito;
            int anos;
            juros = Double.parseDouble(janela.getCaixaJuros().getText());
            anos = Integer.parseInt(janela.getCaixaAnos().getText());
            deposito = Double.parseDouble(janela.getCaixaDeposito().getText());
            resultado = calc.calcular(juros, anos, deposito);
            janela.getCaixaResultado().setText("");
            arredondado = Math.round(resultado * 100.0) / 100.0;
            janela.getCaixaResultado().setText(Double.toString(arredondado));
        }
    }
}
