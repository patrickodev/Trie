package trie.patrick;

import java.util.HashMap;

public class TrieNode {
	
		private boolean isWord;
	    private HashMap<String, TrieNode> children;
	    private String text;

	    public TrieNode(){
	        isWord = false;
	        children = new HashMap<>();
	    }

	    public TrieNode(String text){
	        isWord = false;
	        this.text = text;
	        children = new HashMap<>();
	    }

	    public boolean isWord() {
	        return isWord;
	    }

	    public void setIsWord(boolean word) {
	        isWord = word;
	    }

	    public TrieNode setChildren(String c) {
	        children.put(c, new TrieNode(c));
	        return children.get(c);
	    }

	    public HashMap<String, TrieNode> getChildren(){
	        return children;
	    }

	    public boolean isChild(String c){
	        if(!children.isEmpty()) {
	            return children.containsKey(c);
	        }
	        return false;
	    }

	    public TrieNode getChild(String c){
	        return children.get(c);
	    }

	    public void setText(String text) {
	        this.text = text;
	    }
	    
	    public String getText() {
	        return text;
	    }
}
