class TrieNode{
    TrieNode[] childrens;
    boolean isEnd;
    TrieNode(){
        childrens = new TrieNode[26];
        isEnd = false;
        for(int i=0;i<26;i++){
            childrens[i]=null;
        }
    }
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.childrens[index]==null){
                curr.childrens[index]= new TrieNode();
            }
            curr = curr.childrens[index];
            if(i==word.length()-1){
                curr.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.childrens[index]==null) return false;
            if(i==word.length()-1 && curr.childrens[index].isEnd==false) return false;
            curr = curr.childrens[index];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++){
            int index = prefix.charAt(i)-'a';
            if(curr.childrens[index]==null) return false;
            curr = curr.childrens[index];
        }
        return true;
    }
}
