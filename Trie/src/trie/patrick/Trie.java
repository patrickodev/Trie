package trie.patrick;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Trie {
	
	TrieNode root;

    public Trie(){
    	
        root = new TrieNode();
    }

    public void Insert(String word){
    	
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            String c = word.substring(i,i+1);

            if(node.isChild(c)){
                node = node.getChild(c);
            }else{
                node = node.setChildren(c); 
                if(i == word.length() - 1)
                    node.setIsWord(true);
            }
        }
    }
    public TrieNode CheckPre(String pre){
    	
        TrieNode node = root;
        for(int i = 0; i < pre.length(); i++){
            String c = pre.substring(i,i+1);

            if(node.isChild(c)){
                node = node.getChild(c);
            }else{
                return null;
            }
        }
        return node;
    }

    public void CheckWord(String word){
    	
        TrieNode node = CheckPre(word);
        if(node.isWord()){
            System.out.println(word +" existe na árvore.");
        }
        else{
            System.out.println(word +" não existe na árvore.");
        }
    }

    public List<String> getwords(List<String> list, TrieNode node, String pre){
    	
        if(node.isWord())
            list.add(pre);
                
        for (String c : node.getChildren().keySet()) {
            list = getwords(list, node.getChild(c), pre.concat(c));
        }
        
        return list;
    }

    public void AutoComplete(String pre, int max){
    	
        List<String> list = new ArrayList<>();

        TrieNode node = CheckPre(pre);

        if(node != null){
        	
            list = getwords(list, node, pre);

            if(list.isEmpty()){
            	
                System.out.println("Não existe palavras com este prefixo.");
            }
            else{
                Collections.sort(list, new Comparator<String>() {
                	
                    @Override
                    public int compare(String s, String t1) {
                    	
                        if(s.length() > t1.length())
                            return 1;
                        
                        return -1;
                    }
                });
                
                if(max != -1){
                    max = Math.min(max, list.size());
                    list = list.subList(0, max);
                }
                
                System.out.println("Palavras com o prefixo: "+pre);
                
                for (String word : list) {
                    System.out.println(word);
                }
            }
        }else{
        	
            System.out.println("O prefixo não existe na árvore.");
        }
    }

    public void AutoComplete(String pre){
    	
        AutoComplete(pre, -1);
    }

    public void Remove(String word){
    	
        TrieNode node = CheckPre(word);
        
        if(node != null){

        System.out.println("Palavra: "+word+". Removida da árvore com sucesso.");
            
            int tam_word = word.length();
            
            while(word.length()>0){
            	
                node = CheckPre(word);

                if(tam_word == word.length() && node.isWord()){
                	
                    node.setIsWord(false);
                }
                
                if(node.getChildren().isEmpty()){
                	
                    node = null;
                }

                word = word.substring(0,word.length()-1);
            }
        }
        else{
        	
            System.out.println("Esta palavra não existe na árvore.");
        }
    }
}
