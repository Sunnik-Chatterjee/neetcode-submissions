class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(curr.children[index]==null){
                curr.children[index]= new TrieNode();
            }
            curr = curr.children[index];
            if(i==word.length()-1) curr.isEnd = true;
        }
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }
    boolean dfs(String word, int index, TrieNode root){
        TrieNode curr = root;
        for(int i=index;i<word.length();i++){
            if(word.charAt(i)=='.'){
                for(TrieNode child : curr.children){
                    if(child!=null && dfs(word,i+1,child)) return true;
                }
                return false;
            }else{
                int idx = word.charAt(i)-'a';
                if(curr.children[idx]==null) return false;
                curr = curr.children[idx];
                if(i==word.length()-1 && !curr.isEnd) return false;
            }
        }
        return curr.isEnd;
    }
}
