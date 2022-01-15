//Atividade 1 - Gustavo Alexandre e Pedro Trentin


import java.util.Scanner;
import java.util.Random;

public class Simulador{

    public static void main(String[] argumentos){
        Veiculo veiculos[] = new Veiculo[20];//cria o vetor de veiculos
        int j;
        for(j=0; j<20; j++){
            veiculos[j] = new Veiculo(-1, 0, 4, 0);//inicia-se o vetor de carros com 20 carros de id -1, apenas para organização
        }

        Scanner teclado = new Scanner(System.in);//cria a variavel 'teclado' para usar
        int opcao = 0;
        int identificador; //variavel usada para guardar o id do carro sendo analisado
        boolean foi_printado = false;//variavel para dizer se o carro ja foi mostrado ou nao na tela
        boolean ja_existe = false;//variavei usada para dizer se o id ja existe ou nao

        do{//iniciamos mostrando todas as opções na tela
            System.out.println("..:: Menu interativo do Simulador ::..");
            System.out.println("1 - Incluir um novo veículo");
            System.out.println("2 - Remover um veículo");
            System.out.println("3 - Abastecer um veículo");
            System.out.println("4 - Movimentar um veículo");
            System.out.println("5 - Movimentar todos os veículo");
            System.out.println("6 - Imprimir os dados de todos os veículo");
            System.out.println("7 - Esvaziar o pneu de apenas um carro");
            System.out.println("8 - Calibrar um pneu específico");
            System.out.println("9 - Calibrar todos os pneus");
            System.out.println("10 - Imprimir toda a pista de corrida");
            System.out.println("11 - Sair");
            System.out.print("Escolha uma das opções: ");
            opcao = teclado.nextInt();

            switch(opcao){
                case 1://Incluir um novo veículo
                    do {
                        ja_existe = false; //iniciamos com false apenas para testa se o id ja existe
                        Random s = new Random();//criamos um id randomico
                        int aux_id = s.nextInt();
                        identificador = aux_id;

                        if(identificador >= 0){//testamos para que seja positivo
                            for(int i=0; i<20; i++) {//percorre o vetor de veiculos
                                if (veiculos[i].getid() == identificador) {//verificamos se o id ja existe
                                    ja_existe = true;//atualizamos a variavel de existencia do id
                                    break;
                                }
                            }
                            if(ja_existe == false){//se o id nao existe, entao inserimos o veiculo
                                int i;
                                for(i=0; i<20; i++){//percorre o vetor de veiculos
                                    if(veiculos[i].getid() == -1){//checa se a posição esta vazia
                                        veiculos[i]=new Veiculo(identificador, 0, 4, 3.5);//insere o veiculo
                                        break;
                                    }
                                }
                                if(i==20) {//verificar se foi percorrido o vetor inteiro
                                    System.out.println("Lista cheia");
                                    break;
                                }
                            }
                            else {
                                System.out.println("\nJá existe esse id \n");//significa que o id ja existe
                                identificador = -1;
                            }
                        }
                    } while (identificador < 0);

                    break;
                case 2://Remover um veículo
                    do {
                        System.out.println("Informe o id do carro: \n");//informa o id do carro que vai ser removido
                        Scanner ler = new Scanner(System.in);
                        identificador = ler.nextInt();

                        if(identificador >= 0){//verifica se o id é valido
                            for(int i=0; i<20; i++){//percorre o vetor dos veiculos
                                if(veiculos[i].getid() == identificador){//procura o id escolhido
                                    veiculos[i]=new Veiculo(-1, 0, 4, 0);//remove o veiculo
                                    break;
                                }
                            }
                        }

                    } while (identificador < 0);

                    break;
                case 3://Abastecer um veículo
                    do {
                        System.out.println("Informe o id do carro: \n");//informa o id do carro a ser abastecido
                        Scanner ler_abastecer = new Scanner(System.in);
                        identificador = ler_abastecer.nextInt();

                        for(int i=0; i<20; i++){//percorre o vetor de veiculos
                            if(veiculos[i].getid() == identificador){//verifica o id escolhido
                                veiculos[i].abastecer();//chama a função de abastecer veiculos
                                break;
                            }
                        }

                    } while (identificador < 0);

                    break;
                case 4://movimentar um veículo
                    do {
                        System.out.println("Informe o id do carro: \n");//informa o id do carro a ser abastecido
                        Scanner ler_abastecer = new Scanner(System.in);
                        identificador = ler_abastecer.nextInt();

                        for(int i=0; i<20; i++){//percorre vetor de veiculos
                            if(veiculos[i].getid() == identificador){//verifica o id
                                veiculos[i].movimentar_veiculo();//chama a função de movimentar
                                break;
                            }
                        }

                    } while (identificador < 0);
                    break;
                case 5://Movimentar todos os veículo
                    for(int i=0; i<20; i++){//percorre o vetor de veiculos
                        if(veiculos[i].getid() != -1)
                            veiculos[i].movimentar_veiculo();//chama a função de movimentar para cada veiculo
                    }
                    break;
                case 6:// Imprimir os dados de todos os veículo
                    foi_printado = false;//inicia a variavel com false toda vez que o case 6 é chamado
                    System.out.println("------------------------------------------------------------");
                    for(int i=0; i<20; i++){//percorre o vetor de veiculos
                        if(veiculos[i].getid() != -1){//verifica se o id é diferente de -1, assim apenas mostra veiculos que existe e nao printa lixo de memoria
                            veiculos[i].imprimirDados();//chama a função de imprimir dados
                            foi_printado = true;//atualiza o valor da variavel
                        }
                    }
                    if(foi_printado==false) {//caso o valor da variavel nao seja alterado, significa que nao existem carros no vetor
                        System.out.println("\nNão ha carros para exibir\n");
                        System.out.println("------------------------------------------------------------");
                    }

                    break;
                case 7://Esvaziar o pneu de apenas um carro
                    do {
                        System.out.println("Informe o id do carro: \n");//pega o id do carro a esvaziar pneu
                        Scanner ler_abastecer = new Scanner(System.in);
                        identificador = ler_abastecer.nextInt();

                        for(int i=0; i<20; i++){//percorre o vetor de veiculos
                            if(veiculos[i].getid() == identificador){//verifica se o id é igual ao informado
                                veiculos[i].esvaziar_pneu();//chama a função de esvaziar pneu
                                break;
                            }
                        }

                    } while (identificador < 0);

                    break;
                case 8://Calibrar um pneu específico
                    do {
                        System.out.println("Informe o id do carro: \n");//armazena o id informado
                        Scanner ler_abastecer = new Scanner(System.in);
                        identificador = ler_abastecer.nextInt();

                        for(int i=0; i<20; i++){//percorre o vetor de veiculos
                            if(veiculos[i].getid() == identificador){//verifica se o id é igual ao informado
                                veiculos[i].calibrar_pneu();//chama a função de calibrar pneu
                                break;
                            }
                        }

                    } while (identificador < 0);

                    break;
                case 9://Calibrar todos os pneus
                    do {
                        System.out.println("Informe o id do carro: \n");//armazena o id informado
                        Scanner ler_abastecer = new Scanner(System.in);
                        identificador = ler_abastecer.nextInt();

                        for(int i=0; i<20; i++){//percorre o vetor de veiculos
                            if(veiculos[i].getid() == identificador){//verifica se o id é igual ao informado
                                veiculos[i].calibrar_todos_pneu();//chama a função de calibrar todos os pneus
                                break;
                            }
                        }

                    } while (identificador < 0);
                    break;
                case 10://Imprimir toda a pista de corrida
                    foi_printado = false;//inicia a variavel com valor false toda vez que o case 10 é chamado
                    System.out.println("------------------------------------------------------------");
                    for(int i=0; i<20; i++){//percorre o vetor de veiculos
                        if(veiculos[i].getid() != -1){//verifica se o veiculo existe no vetor
                            veiculos[i].printcarro(i+1);//chama a função de printar o carro com o valor de i+1
                            foi_printado = true;//atualiza o valor da variavel
                        }
                    }
                    if(foi_printado==false) {//se nenhum carro foi printado, entao a lista esta vazia
                        System.out.println("\nNão ha carros para exibir\n");
                        System.out.println("------------------------------------------------------------");
                    }

                    break;
                case 11:
                    System.out.println("Encerrando simulador. Obrigado");
                    break;

                default:
                    System.out.println("A opcao informada é invalida. Tente novamente");
            }
        }while(opcao != 11);

    }
}


