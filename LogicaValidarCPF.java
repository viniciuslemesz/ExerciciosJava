class Main {
    public static void main(String[] args) {
        String cpf = "22233366638";
        //String cpf = "22222222238";
        
        int soma = 0;
        int segunda_soma = 0;
        int primeiro_digito = 0;
        int segundo_digito = 0;
        int cont = 10;
        boolean verificarDiferentes = false;
        boolean validacao = false;
        
        //soma += (cpf.charAt(0) - '0') * 10;
        //soma += (cpf.charAt(0) - 48) * 10;
       //soma += (cpf.charAt(0) - 48) * 9;
       
       System.out.println("---VALIDACAO DE CPF---");
       System.out.println("OBS: APENAS LOGICA, NAO TEM SCANNER AINDA\n");
       
       
       // VERIFICAÇÃO DE DIGITOS IGUAIS
       for(int i=1;i<11;i++)
       {
            if(cpf.charAt(0) != cpf.charAt(i) )
            {
                verificarDiferentes = true;
            }
            
       }
        
        // CASO NAO TENHA DIGITOS IGUAIS => VALIDAÇÃO
        if(verificarDiferentes == true)
        {
          
          
        //CALCULO PRIMEIRO DIGITO VERIFICADOR    
        for(int i=0;i<9;i++)
        {
            soma += (cpf.charAt(i) - 48) * cont;
            cont--;
        }
        
        System.out.println("Resultado: " + soma);
        System.out.println("Resto da divisao: " + soma%11);
        
        primeiro_digito = 11 - (soma%11); 
         
        if(primeiro_digito > 9)
        {
            primeiro_digito = 0;
        }
        System.out.println("Calculo primeiro digito verificador: " + ( 11 - (soma%11)));
            
        // Como o resultado da subtração não é maior que 9, o resultado é o próprio dígito verificador ==> 3 e 8
          
        System.out.println("\n");
            
        //CALCULO SEGUNDO DIGITO VERIFICADOR
        cont = 11;
        for(int i=0;i<10;i++)
        {
            segunda_soma += (cpf.charAt(i) - 48) * cont;
            cont--;
        }
            
        System.out.println("Resultado: " + segunda_soma);
        System.out.println("Resto da divisao: " + segunda_soma%11);
        segundo_digito = 11 - (segunda_soma%11);
        if(segundo_digito > 9)
        {
            segundo_digito = 0;
        }
        
        System.out.println("Calculo segundo digito verificador: " + ( 11 - (segunda_soma%11)));    
            
        if(primeiro_digito == (cpf.charAt(9) - 48) && segundo_digito == (cpf.charAt(10) - 48)) 
        {
            validacao = true;
        }
            
        if(!validacao)
        {
            System.out.println("\nCPF INVALIDO!");
        }
        else
        {
            System.out.println("\nCPF VALIDO!");
        }
        
            
        }
        else
            {
                System.out.printf("\nCPF INVALIDO! Digitos iguais!");  
            }
        
        
    }
}