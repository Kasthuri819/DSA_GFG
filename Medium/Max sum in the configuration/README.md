<h2><a href="https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1">Max sum in the configuration</a></h2><h3>Difficulty Level : Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given an integer array(0-based indexing) <strong>A </strong>of size <strong>N</strong>, you have to find the maximum value of sum of<strong> i*A[i]&nbsp;</strong>for all <strong>0&lt;=i&lt;=N-1</strong>,<strong>&nbsp;</strong>where <strong>A[i]</strong> is the element at index <strong>i </strong>in the array. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.</span></p>
<p><span style="font-size: 18px;"><strong>Example 1:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input:
</strong>N = 4
A[] = {8, 3, 1, 2}
<strong>Output: </strong>29<strong>
Explanation: </strong>All the configurations possible by rotating the elements are:
3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
Here the max sum is 29.<br></span></pre>
<p style="font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif; font-size: medium; white-space: normal;"><span style="font-size: 18px;"><strong>Example 2:</strong></span></p>
<pre><strong>Input:
</strong>N = 3
A[] = {1, 2, 3}
<strong>Output: </strong>29<strong>
Explanation: </strong>All the configurations possible by rotating the elements are:
1 2 3 here sum is 1*0+2*1+3*2 = 8
3 1 2 here sum is 3*0+1*1+2*2 = 5
2 3 1 here sum is 2*0+3*1+1*2 = 5
Here the max sum is 8.</pre>
<p><span style="font-size: 18px;"><strong>Your&nbsp;Task:</strong><br>Your task is to complete the function <strong>max_sum</strong> which takes two arguments, the integer array <strong>A [ ]</strong> and its size&nbsp;<strong>N</strong> and returns an integer value denoting the required maximum sum.</span></p>
<p><span style="font-size: 18px;"><strong>Expected Time Complexity:&nbsp;</strong>O(N).<br><strong>Expected Auxiliary Space:&nbsp;</strong>O(1).</span></p>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1&lt;=N&lt;=10<sup>4</sup><br>1&lt;=A[]&lt;1000</span></p></div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Amazon</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Arrays</code>&nbsp;<code>Data Structures</code>&nbsp;<code>Mathematical</code>&nbsp;