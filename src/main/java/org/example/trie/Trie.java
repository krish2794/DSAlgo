package org.example.trie;

public class Trie {

    void insert(TrieNode root, String key){

        TrieNode curr = root;
        for(int i=0;i<key.length();i++){
            char ch = key.charAt(i);
            if(curr.children[ch -'a'] == null){
                TrieNode newNode = new TrieNode();
                curr.children[ch - 'a'] = newNode;
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEndOfWord = true;
    }

    boolean search(TrieNode root, String key){
        TrieNode curr = root;
        for(int i=0 ; i<key.length();i++){
            char ch = key.charAt(i);
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEndOfWord;
    }
}


class TrieNode{
    final int ALPHABET_SIZE=26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];

    boolean isEndOfWord;

    TrieNode(){
        isEndOfWord = false;
        for(int i=0;i<ALPHABET_SIZE;i++){
            children[i] = null;
        }
    }
}