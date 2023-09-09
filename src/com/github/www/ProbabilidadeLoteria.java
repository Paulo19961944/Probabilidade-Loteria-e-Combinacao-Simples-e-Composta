package com.github.www;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.BigInteger;

public class ProbabilidadeLoteria {
    public static void main(String[] args) {
        // Declaração de Variáveis
        int selecionar;
        long totalNumeros, totalAcertos;
        BigInteger resultado;
        BigInteger fatorialTotalNumeros = BigInteger.ONE;
        BigInteger fatorialTotalAcertos = BigInteger.ONE;
        BigInteger fatorialCombinacao = BigInteger.ONE;

        // Chama a Classe Scanner
        Scanner teclado = new Scanner(System.in);
        System.out.println();
        System.out.println("********** COMBINAÇÃO SIMPLES E COMPOSTA | PROBABILIDADE LOTERIA **********");
        System.out.println();
        System.out.print("Caso o número do resultado não se repita digite 1, caso ele repita digite 2: ");
        selecionar = teclado.nextInt();
        System.out.print("Digite o total de números: ");
        totalNumeros = teclado.nextLong();
        System.out.print("Digite o total de acertos: ");
        totalAcertos = teclado.nextLong();

        // Declara a variável da fórmula
        long combinacao = totalNumeros - totalAcertos;

        // Calcula o fatorial
        switch (selecionar) {
            case 1:
                for (int i = 1; i <= totalNumeros; i++) {
                    fatorialTotalNumeros = fatorialTotalNumeros.multiply(BigInteger.valueOf(i));
                }

                for (int i = 1; i <= totalAcertos; i++) {
                    fatorialTotalAcertos = fatorialTotalAcertos.multiply(BigInteger.valueOf(i));
                }

                for (int i = 1; i <= combinacao; i++) {
                    fatorialCombinacao = fatorialCombinacao.multiply(BigInteger.valueOf(i));
                }

                // Resultado
                resultado = fatorialTotalNumeros.divide(fatorialCombinacao.multiply(fatorialTotalAcertos));

                // Formatação do resultado com pontos a cada três dígitos
                DecimalFormat df = new DecimalFormat("###,###,###");
                String resultadoFormatado = df.format(resultado);

                // Printa o resultado na tela
                System.out.println();
                System.out.println("********** RESULTADO **********");
                System.out.println();
                System.out.println("O Resultado é: " + resultadoFormatado);
                System.out.println("E as chances de ganhar são: 1 em " + resultadoFormatado);
                System.out.println();
                System.out.println("********** PAULO HENRIQUE AZEVEDO DO NASCIMENTO **********");
                break;

            case 2:
                // Declara a Variável
                BigInteger resultadoComRepeticao = BigInteger.valueOf(totalNumeros).pow((int) totalAcertos);

                // Formatação do resultado com pontos a cada três dígitos
                DecimalFormat df2 = new DecimalFormat("###,###,###");
                String resultadoComRepeticaoFormatado = df2.format(resultadoComRepeticao);

                // Printa o resultado na tela
                System.out.println();
                System.out.println("********** RESULTADO **********");
                System.out.println();
                System.out.println("O Resultado é: " + resultadoComRepeticaoFormatado);
                System.out.println("E as chances de ganhar são: 1 em " + resultadoComRepeticaoFormatado);
                System.out.println();
                System.out.println("********** PAULO HENRIQUE AZEVEDO DO NASCIMENTO **********");
                break;
        }
    }
}
