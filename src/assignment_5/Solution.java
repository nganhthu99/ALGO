package assignment_5;

import java.util.*;

public class Solution {
    // Problem 1
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public Map<TreeNode, Integer> generateDepthMap(TreeNode root) {
        Map<TreeNode, Integer> map = new HashMap<>();
        generateDepthMapHelper(root, map, 0);
        return map;
    }

    private void generateDepthMapHelper(TreeNode root, Map<TreeNode, Integer> map, int depth) {
        if (root == null) return;
        map.put(root, depth);
        generateDepthMapHelper(root.left, map, depth + 1);
        generateDepthMapHelper(root.right, map, depth + 1);
    }

    // Problem 2
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }
    }

    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    // Problem 3
    public int[] sortWithBst(int[] arr) {
        TreeNode root = buildBst(arr);
        return buildList(root, new ArrayList<>()).stream()
                .mapToInt(i->i).toArray();
    }

    private TreeNode buildBst(int[] arr) {
        return new TreeNode(6, new TreeNode(4, null, new TreeNode(5, null, null)), new TreeNode(9,new TreeNode(7, null, null), null));
    }

    private List<Integer> buildList(TreeNode root, List<Integer> list) {
        if (root == null) return list;
        List<Integer> leftList = buildList(root.left, list);
        leftList.add(root.val);
        return buildList(root.right, leftList);
    }

//    private List<Integer> buildList(TreeNode root) {
//        if (root == null) return Collections.emptyList();
//        List<Integer> list = new ArrayList<>();
//
//        List<Integer> leftList = buildList(root.left);
//        list.addAll(leftList);
//
//        list.add(root.val);
//
//        List<Integer> rightList = buildList(root.right);
//        list.addAll(rightList);
//
//        return list;
//    }


    // Problem 6
    public List<Set<Integer>> subsetOfSize(List<Integer> list, int size) {
        List<Set<Integer>> listOfSet = new ArrayList<>();
        subsetOfSizeHelper(list, size,-1, new HashSet<>(), listOfSet);
        return listOfSet;
    }

    private void subsetOfSizeHelper(List<Integer> list, int size, int index, Set<Integer> set, List<Set<Integer>> listOfSet) {
        if (set.size() == size) {
            listOfSet.add(new HashSet<>(set));
            return;
        }
        for (int i = index + 1; i < list.size(); i++) {
            set.add(list.get(i));
            subsetOfSizeHelper(list, size, i, set, listOfSet);
            set.remove(list.get(i));
        }
    }
    public static void main(String[] args) {
        // 1
        System.out.println(
                new Solution().generateDepthMap(new TreeNode(1, new TreeNode(4), new TreeNode(9)))
        );
        // 2
        ListNode reversedList = new Solution().reverseLinkedList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        while (reversedList != null) {
            System.out.println(reversedList.val);
            reversedList = reversedList.next;
        }
        // 3
        System.out.println(
                Arrays.toString(new Solution().sortWithBst(new int[]{}))
        );
        // 6
        System.out.println(
                new Solution().subsetOfSize(Arrays.asList(3,5,2,4), 3)
        );
    }
}
