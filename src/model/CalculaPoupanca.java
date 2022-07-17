package model;

/**
 * classe CalculaPoupanca
 * @author Patrick
 */
public class CalculaPoupanca {
    
    public double calcular(double juros, int anos, double deposito) {
        double resultado;
        int meses;
        // deixando juros em forma numérica
        juros = juros / 100;
        // definindo número de meses
        meses = anos * 12;
        resultado = deposito * Math.pow(1+juros,meses);
        return resultado;
    }
}
