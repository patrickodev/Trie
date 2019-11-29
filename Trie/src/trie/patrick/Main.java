package trie.patrick;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		String arquivo = args[0];
        String prefixo = args[1];
        String qtd = "0";
        Trie arvore = new Trie();
        
        try {
        	
            FileReader read = new FileReader("lib/"+arquivo);
            @SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(read);
            String line;
            while( (line = reader.readLine()) != null ){
                arvore.Insert(line);
            }
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        if(args.length > 2){
        	
            qtd = args[2];
        }

        arvore.AutoComplete(prefixo, Integer.parseInt(qtd));
        arvore.CheckWord("flamengo");
        arvore.CheckWord("campeao");
        arvore.Remove("vasco");
        arvore.CheckWord("vasco");
    }	
}
