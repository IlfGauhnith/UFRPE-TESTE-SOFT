package ufrpe.bcc.ts.imc;

public class CalculoIMC {

    /**
     * Calcula o IMC com base na altura e peso e retorna a classificação correspondente.
     *
     * @param altura Altura em metros.
     * @param peso Peso em quilogramas.
     * @return Uma string representando a classificação do IMC.
     */
    public String IMC(float altura, float peso) {
        if (altura <= 0 || peso <= 0) {
            throw new IllegalArgumentException("Altura e peso devem ser maiores que zero.");
        }

        // Cálculo do IMC
        float imc = peso / (altura * altura);

        // Retorna a classificação baseada no IMC
        if (imc < 18.5) {
            return "MAGREZA";
        } else if (imc <= 24.9) {
            return "NORMAL";
        } else if (imc <= 29.9) {
            return "SOBREPESO";
        } else if (imc <= 39.9) {
            return "OBESIDADE";
        } else {
            return "OBESIDADE GRAVE";
        }
    }

    // Método principal para teste (opcional)
    public static void main(String[] args) {
        CalculoIMC calculo = new CalculoIMC();
        System.out.println(calculo.IMC(1.75f, 70f)); // Exemplo: altura 1.75m, peso 70kg
    }
}