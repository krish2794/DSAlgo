package org.example.trie;

public class Test {

    public static void main(String[] args) {
        Trie trie = new Trie();
        TrieNode trieNode = new TrieNode();
        trie.insert(trieNode, "hello");
        System.out.println(trie.search(trieNode, "hello"));
    }
}
