package src;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.classfile.constantpool.IntegerEntry;

//Gson  
import com.google.gson.Gson;
import com.google.gson.JsonObject; // Para manipular JSON como objeto
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/*
 * Usuário escohe: 
 * tamanho 
 * letras maiúsculas e minúsculas? 
 * números? 
 * especiais? 
 * algum alfabeto adicional? Se sim, quantos e quais?
 * 
 * Função do programa:
 * Randomizar o tipo de dado conforme a escolha para cada caractere da senha 
 *  (Exemplo: Primeiro caractere: randomiza se vai ser um número ou uma letra e doepis randomiza o caractere dentro dessa classe)
 * Fazer isso com todos os caracteres
 * Ao final, verificar se tem ao menos um caractere de cada tipo que o usuário escolheu
 * 
 * Acho que é só
 */


public class Gerador {
    public static boolean loopCheck = true;

    public static void main(String[] args)
        throws IOException
    {
        dataColect();
    }

    //Coleta de dados
    public static void dataColect() 
        throws IOException
    {
        BufferedReader cr = new BufferedReader(new InputStreamReader((System.in)));
        int passSize, quantityOfadicionalAlphabets = 0;
        boolean numbers, specialCharacters, caseType, adicionalAlphabet = false;
        String adicionalAlphabetType;
        ArrayList<String> moreAlphabets = new ArrayList<>();



        System.out.println("Bem vindo ao MASTER BLASTER EXTREME REVELETIONS 2 ULTIMATE gerador de senhas :D");
        System.out.println("Vou fazer algumas perguntas sobre suas preferências para senha");

        System.out.println("Qual tamanho deseja? \n Digite apenas números");
        passSize = Integer.parseInt(cr.readLine());

    

        System.out.println("Deseja incluir letras maiúsculas e minúsculas? (Por padrão tem apenas minúsculas) \n Responda s ou n");
        while(loopCheck){
            caseType = inputCheck(cr.readLine());
        }
        loopCheck = true;


        System.out.println("Deseja incluir números? \n Responda s ou n");
        while(loopCheck){
            numbers = inputCheck(cr.readLine());
        }
        loopCheck = true;
        
        
        System.out.println("Deseja incluir caracteres especiais? \n Responda s ou n");
        while(loopCheck){
            specialCharacters = inputCheck(cr.readLine());
        }
        loopCheck = true;

        boolean askNewAlphabet = true;
        System.out.println("Deseja incluir caracteres de algum outro alfabeto? \n Responda s ou n");

        while(loopCheck){
            adicionalAlphabet = inputCheck(cr.readLine());
        }
        loopCheck = true;

        while (askNewAlphabet){
            if(adicionalAlphabet){
                System.out.println("Escolha um dos alfabetos:");
                System.out.println("1-Cirilico \r\n" + "2-Grego \r\n" + "3-Hebraico \r\n" + "4-Arabe \r\n" + "5-Devanagari \r\n" + "6-Bopomofo \r\n" +  
                                    "7-Hangul \r\n" + "8-Hiragana \r\n" +  "9-Katakana \r\n" + "10-Tailandes \r\n" + "11-Armenio \r\n" + 
                                    "12-Georgiano \r\n" + "13-Etiope \r\n" + "14-Cherokee \r\n" + "15-Tibetano \r\n" + "16-Runico \r\n" +
                                    "17-Linear_b \r\n" + "18-Deseret \r\n" + "19-Osmanya \r\n" + "20-Vai \r\n" + "Responda apenas o numero");
                                    //talvez tenha alguma forma mais inteligente de fazer esse print. acho que com array sei la
                /*--------------------------------------------------------------------------------------------------------------------------------------------------- */
            
                if(Integer.parseInt(cr.readLine())>20 || Integer.parseInt(cr.readLine())<1){
                    System.out.println("Escolhe só um dos que estão na lista noia");
                } else{
                    moreAlphabets.add(verifyAlphabetType(Integer.parseInt(cr.readLine())));
                    quantityOfadicionalAlphabets = moreAlphabets.size();

                    System.out.println("Deseja incluir mais um? Responda s ou n");
                    if(cr.readLine().equals("n")){
                        adicionalAlphabet = false;
                        askNewAlphabet = false;
                    } else{
                        System.out.println("fodase deu errado");
                    }
                }
            }
        }
    }

    //Verifica o tipo do alfabeto
    public static String verifyAlphabetType(int i){
        String methodReturn;
        switch (i) {
            case 1: methodReturn = "cirilico"; break;
            case 2: methodReturn = "grego"; break;
            case 3: methodReturn = "hebraico"; break;
            case 4: methodReturn = "arabe"; break;
            case 5: methodReturn = "devanagari"; break;
            case 6: methodReturn = "bopomofo"; break;
            case 7: methodReturn = "hangul"; break;
            case 8: methodReturn = "hiragana"; break;
            case 9: methodReturn = "katakana"; break;
            case 10: methodReturn = "tailandes"; break;
            case 11: methodReturn = "armenio"; break;
            case 12: methodReturn = "georgiano"; break;
            case 13: methodReturn = "etiope"; break;
            case 14: methodReturn = "cherokee"; break;
            case 15: methodReturn = "tibetano"; break;
            case 16: methodReturn = "runico"; break;
            case 17: methodReturn = "linear_b"; break;
            case 18: methodReturn = "deseret"; break;
            case 19: methodReturn = "osmanya"; break;
            case 20: methodReturn = "vai"; break;
            default: methodReturn = "latino"; break;
        }

        return methodReturn;
    }

    //Faz a validação de s para true e n para false nas variáveis bool
    public static boolean inputCheck(String checker){
        boolean methodReturn = false;

        if(checker.equals("s")){
            loopCheck = false;
            methodReturn = true;
        } else if (checker.equals("n")){
            loopCheck = false;
            methodReturn = false;
        } else if (!(checker.equals("s")) && !(checker.equals("n"))){
            System.out.println("Aí tu ta me tirando. Responda apenas com s para sim e n para não, bobão.");
        }

        return methodReturn;
    }

    public static String jsonReader(String kindOfData, String letterCase){
        String finalData = "null";
        
        try {
            String caminhoJson = "D:/Documentos/Treino Java/json/allCharacters.json";

            // Le o conteúdo do arquivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(caminhoJson)));
            
            Gson gson = new Gson();

            //Serializa o JSON (Converde de arquivo json pra um JsonObject)
            JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

            //Tipo do dado/alfabeto
            JsonObject dataType = jsonObject.getAsJsonObject(kindOfData);

            //obtendo valor q eu quero
            finalData = dataType.get(letterCase).getAsString();

        } catch (Exception e){
            e.printStackTrace();
        }

        return finalData;
    }

    public static int  numberOfCharacters(String kindOfData){
        int finalData = 0;

        try {
            String caminhoJson = "D:/Documentos/Treino Java/json/allCharacters.json";

            // Le o conteúdo do arquivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(caminhoJson)));
            
            Gson gson = new Gson();

            //Serializa o JSON (Converde de arquivo json pra um JsonObject)
            JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

            //Tipo do dado/alfabeto
            JsonObject dataType = jsonObject.getAsJsonObject(kindOfData);

            //obtendo valor q eu quero
            finalData = Integer.parseInt(dataType.get("quantidade").getAsString());  

        } catch (Exception e){
            e.printStackTrace();
        }

        return finalData;
    }



    public static String jsonReader(String kindOfData, String letterCase){
        String finalData = "null";
        
        try {
            String caminhoJson = "D:/Documentos/Treino Java/json/allCharacters.json";

            // Le o conteúdo do arquivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(caminhoJson)));
            
            Gson gson = new Gson();

            //Serializa o JSON (Converde de arquivo json pra um JsonObject)
            JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

            //Tipo do dado/alfabeto
            JsonObject dataType = jsonObject.getAsJsonObject(kindOfData);

            //obtendo valor q eu quero
            finalData = dataType.get(letterCase).getAsString();

        } catch (Exception e){
            e.printStackTrace();
        }

        return finalData;
    }

    public static int  numberOfCharacters(String kindOfData){
        int finalData = 0;

        try {
            String caminhoJson = "D:/Documentos/Treino Java/json/allCharacters.json";

            // Le o conteúdo do arquivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(caminhoJson)));
            
            Gson gson = new Gson();

            //Serializa o JSON (Converde de arquivo json pra um JsonObject)
            JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

            //Tipo do dado/alfabeto
            JsonObject dataType = jsonObject.getAsJsonObject(kindOfData);

            //obtendo valor q eu quero
            finalData = Integer.parseInt(dataType.get("quantidade").getAsString());  

        } catch (Exception e){
            e.printStackTrace();
        }

        return finalData;
    }

    public static String jsonReader(String kindOfData, String letterCase){
        String finalData = "null";
        
        try {
            String caminhoJson = "D:/Documentos/Treino Java/json/allCharacters.json";

            // Le o conteúdo do arquivo JSON
            String jsonContent = new String(Files.readAllBytes(Paths.get(caminhoJson)));
            
            Gson gson = new Gson();

            //Serializa o JSON (Converde de arquivo json pra um JsonObject)
            JsonObject jsonObject = gson.fromJson(jsonContent, JsonObject.class);

            //Tipo do dado/alfabeto
            JsonObject dataType = jsonObject.getAsJsonObject(kindOfData);

            //obtendo valor q eu quero
            finalData = dataType.get(letterCase).getAsString();

        } catch (Exception e){
            e.printStackTrace();
        }

        return finalData;
    }

}
