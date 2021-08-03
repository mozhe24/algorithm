1、链表判断有环
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow!=fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}

2、反转单链表
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next ==null){
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;

        ListNode r;
        while(q!=null){
            r = q.next;
            q.next = p;

            p =q;
            q = r;
        }
        return p;
}
}
3、两个数组的交集（输出结果不重复）
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    Arrays.sort(nums1);
    Arrays.sort(nums2);

    HashSet<Integer> result = new HashSet<>();

    int p1 = 0;
    int p2 = 0;

    while (p1 < nums1.length && p2 < nums2.length) {
        int v1 = nums1[p1];
        int v2 = nums2[p2];
        if (v1 == v2) {
            result.add(v1);
            ++p1;
            ++p2;
        } else if (v1 > v2) {
            ++p2;
        } else if (v1 < v2) {
            ++p1;
        }
    }

    int[] res = new int[result.size()];
    int index = 0;
    for (Integer v : result) {
        res[index++] = (int) v;

    }
    return res;

   }
}
4、 二叉树的最大深度（递归实现和非递归实现）
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
递归实现：
class Solution {
    public int maxDepth(TreeNode root) {
         if(root == null){
             return 0;
         }

         int leftMaxDepth = maxDepth(root.left);
         int rightMaxDepth = maxDepth(root.right);
         return Math.max(leftMaxDepth, rightMaxDepth)+1;
    }
}
非递归实现：
class Solution {
    public int maxDepth(TreeNode root) {
         
         if (root == null) {
             return 0;
         }

         Deque<TreeNode> queue = new LinkedList<TreeNode>();
         queue.offer(root);
         int ans = 0;
         while (!queue.isEmpty()) {
             int size = queue.size();
             while (size > 0) {
                 TreeNode node = queue.poll();
                 if (node.left != null) {
                     queue.offer(node.left);
                 }
                 if (node.right != null) {
                     queue.offer(node.right);
                 }
                 size--;
             }
             ans++;
         }
         return ans;
     }   
 }
5、前序遍历（递归实现和非递归实现）
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> result = new ArrayList();
         //递归实现
         if(root == null){
             return result;
         }

         result.add(root.val);
         result.addAll(preorderTraversal(root.left));
         result.addAll(preorderTraversal(root.right));
         return result;
    }
}


class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        //非递归实现
        List<Integer> result = new ArrayList();

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                result.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return result;

    }
}
6、中序遍历(递归实现和非递归实现)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //递归实现
        List<Integer> result = new ArrayList();

        if(root == null){
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        
        return result;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //非递归实现
        List<Integer> result = new ArrayList();

        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;

        }
        return result;
    }
}
7、后续遍历(递归实现和非递归实现)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //递归实现
        List<Integer> result = new ArrayList();
        if(root == null){
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        //非递归实现
        List<Integer> result = new ArrayList();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();

        TreeNode pre = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right == null  || root.right == pre){
                result.add(root.val);
                pre = root;
                root =null;
            }else{
                stack.push(root);
                root = root.right;
            }
        }
        return result;
        
    }
}
8、二叉树广度优先搜索(递归实现和非递归实现)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
递归实现
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root == null){
            return result;
        } 

        levelOrderByIndex(root, 0, result);
        
        return result;
    }

    public void levelOrderByIndex(TreeNode t, int index, List<List<Integer>> result){
        if(index == result.size()){
            result.add(new ArrayList());
        }

        result.get(index).add(t.val);

        if(t.left!=null){
            levelOrderByIndex(t.left, index+1, result);
        }
        if(t.right!=null){
            levelOrderByIndex(t.right, index+1, result);
        }
    }
}

//非递归实现
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList();
        if (root == null){
            return result;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size()>0){
            int size = queue.size();
            List<Integer> tmpResult = new ArrayList<>();
            for (int i =0 ;i < size; i ++){
                TreeNode t = queue.remove();
                tmpResult.add(t.val);
                if (t.left!=null){
                    queue.add(t.left);
                }
                if (t.right!=null){
                    queue.add(t.right);
                }
            }
            result.add(tmpResult);
        }
        return result;
    }
}
9、斐波那契数列(递归和非递归实现)
class Solution {
    public int fib(int n) {
    
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;

        int p = 0;
        int q = 1;
        int r = 1;
        for(int i = 2; i < n; i++){
            p = q;
            q = r;
            r = p+q;
            
        }
        return r;
    }
}

class Solution {
    public int fib(int n) {
    
      if(n<2){
          return n;
      }
      
      return fib(n-1)+ fib(n-2);
      
    }
}
10、归并排序
原理：merge_sort(left, right) = merge(merge_sort(left, middle), merge_sort(middle+1, right));
时间复杂度(O(nlogn))
空间复杂度（O(n)）
是否稳定排序（稳定,不会改变元素在数组中位置）
class Solution {
    public void Merge_Sort(int data[]){

        int left = 0;
        int right = data.length;
        int mid = (left + right) / 2;
        int tmp[] = new int [right-left];
        Merge_Sort(data, left, mid, tmp);
        Merge_Sort(data, mid+1, right, tmp);
        Merge_Array(data, left, mid, right, tmp);
    }

    public void Merge_Array(int data[], int left, int mid, int right, int tmp[]){

        int i = left;
        int j = mid + 1;
        int k = 0;
        while(i<=mid && j<=right){
            i(data[i]<data[j]){
                tmp[k++] = data[i++];
            }
            else{
                tmp[k++] = data[j++];
            }
        }
        while(i<=mid){
            tmp[k++] = data[i++];
        }

        while(j<=right){
            tmp[k++] = data[j++];
        }

        for(int n = 0; n < k; n++){
            data[left + n] = tmp[k++];
        }
    }
}




11、快速排序
原理: quick_sort(left, right) = qucik_sort(left, middle) + quick_sort(middle + 1, right);
时间复杂度(O(nlogn))
空间复杂度（不需要创建额外的空间）
是否稳定排序（不稳定，会改变元素在数组中的位置）

class Solution{

    public int Partition(int data[], int left, int right) {
        int start = left;
        int end = right;
        int pivot = data[right];//取最后一个数作为pivot

        while (start < end) {

            while (start < end && data[start] <= pivot) {//从左往右找到第一个大于pivot的数
                start++;
            }
            data[end] = data[start];

            while (start < end && data[end] >= pivot) {//从右往左找到第一个小于pivot的数
                end--;
            }
            data[start] = data[end];

        }
        data[start] = pivot;//start==end
        return start;

    }

    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int index = Partition(arr, start, end);
            quickSort(arr, start, index - 1);
            quickSort(arr, index + 1, end);
        }
    }
}



12、Top K 查找第K大的数字

13、任意三个数相加为0
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length <3){
            return result;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (nums[first] > 0) {
                break;
            }
            if (first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }

            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                int sum = nums[first] + nums[second] + nums[third];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while (second < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (second < third && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    second++;
                    third--;
                } else if (sum > 0) {
                    third--;
                } else if (sum < 0) {
                    second++;
                }
            }
        }
        return result;
    }
}
