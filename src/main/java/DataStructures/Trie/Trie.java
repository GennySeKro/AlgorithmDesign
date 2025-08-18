package DataStructures.Trie;

public class Trie {

    private static class TireNode {
        //子节点数组
        private TireNode[] children;

        //是否为某个字符串的结尾
        public boolean isEnd;

        public TireNode(){
            this.children = new TireNode[26];
            this.isEnd = false;
        }
    }

    private final TireNode root;

    public Trie(){
        this.root = new TireNode();
    }

    /*
    插入一个字符串
     */

    public void insert(String word){
        TireNode node = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                node.children[index] = new TireNode();
            }
            node = node.children[index];
        }

        node.isEnd = true;
    }

    /*
    搜索一个字符串是否存在
     */

    public boolean search(String word){
        TireNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    /*
    判断是否存在以该前缀开头的字符串
     */

    public boolean searchStartWith(String prefix){
        return searchPrefix(prefix) != null;
    }

    /*
    查找前缀对应的节点
     */

    private TireNode searchPrefix(String word){
        TireNode node = root;
        for (char c : word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                return null;
            }

            node = node.children[index];
        }

        return node;
    }


    /*
    删除一个字符串
     */
    public boolean delete(String word){
        return delete(root, word, 0);
    }

    private boolean delete(TireNode node, String word, int depth) {
        if (depth == word.length()){
            if (!node.isEnd){
                return false;
            }

            node.isEnd = false;
            return node.children == null || allChildrenNull(node);
        }

        int index = word.charAt(depth) - 'a';
        TireNode child = node.children[index];

        if (child == null){
            return false;
        }

        boolean shouldDeleteChild = delete(child, word, depth + 1);

        if (shouldDeleteChild){
            node.children[index] = null;
            return !node.isEnd && allChildrenNull(node);
        }

        return false;
    }

    /*
    判断一个节点的子节点是否都为空
     */
    private boolean allChildrenNull(TireNode node){
        for (TireNode child : node.children){
            if (child != null){
                return false;
            }
        }

        return true;
    }
}
