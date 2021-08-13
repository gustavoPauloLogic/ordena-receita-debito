package com.code;

public class Principal {

    /*********Entrada************Saida**************Reordenações***
     *                     *                   *                  *
     *   10,-10,-1,-1,10   *  10 -1 -1 10 -10  *        1         *
     *   -1,-1,-1,1,1,1    *  -1 1 1 1 -1 -1   *        3         *
     *   5,-2,-3,1         *  5 -2 -3 1        *        0         *
     *                     *                   *                  *
     **************************************************************/


    private static final int[] valores = {-1,-1,-1,1,1,1};
    private static int reordenacoes = 0;

    public static void main(String[] args) {
        int somaValores = 0;

        for (int i=0; i<valores.length; i++) {

            while (valores[0] < 0) {
                somaValores = ordenaLista(valores[i], i);
            }

            somaValores = somaValores + valores[i] >= 0 ? somaValores + valores[i]
                    : (i == 0 ? ordenaLista(valores[i], i) : ordenaLista(valores[i-1], i-1));
        }

        imprimir();
    }

    private static int ordenaLista(int valor, int posicao) {
        reordenacoes += 1;

        for (int i=posicao; i<valores.length; i++) {
            if (i == (valores.length - 1)) {
                valores[valores.length - 1] = valor;
            } else {
                valores[i] = valores[i+1];
            }
        }

        return 0;
    }

    private static void imprimir() {
        StringBuilder valor = new StringBuilder();

        for (int v : valores) {
            valor.append(" " + v);
        }

        System.out.println("Saída: " + valor);
        System.out.println("Reordenações: " + reordenacoes);
    }
}
