package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        // selecaoCandidatos();
        // imprimirSelecionados();
         String[] candidatos = {
            "João", "Maria", "Pedro", "Ana", "Lucas"
        };

        for(String candidato: candidatos){
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do{
            atendeu = atender();
            continuarTentando = !atendeu;

            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");
        }while(continuarTentando && tentativasRealizadas<3);

        if(atendeu)
            System.out.println("Conseguimos contatos com "+ candidato +" na "+ tentativasRealizadas +" tentativa");
        else
            System.out.println("Nao conseguimos contato com "+ candidato + ", numero maximos de tentativas "+ tentativasRealizadas);
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String[] candidatos = {
            "João", "Maria", "Pedro", "Ana", "Lucas"
        };

        for(String candidato : candidatos){
            System.out.println("O candidato selecionado foi "+ candidato);
        }

    }

    static void selecaoCandidatos(){
        String[] candidatos = {
            "João", "Maria", "Pedro", "Ana", "Lucas",
            "Mariana", "Carlos", "Sara", "Paulo", "Laura"
        };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000;

        while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual];
            
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou o salario de " + salarioPretendido);

            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + " foi selecionado");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }

    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        } else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contraproposta");
        } else {
            System.out.println("Aguardando o resultdo dos demais candidatos");
        }
    }
}
