<h2><a href="https://www.geeksforgeeks.org/problems/find-h-index/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card">Find H-Index for sorted citations</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 14pt;"><span style="background-color: #ffffff; color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px;">Given an array, <strong>citations</strong></span><strong style="color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px; box-sizing: border-box; margin: 0px; padding: 0px; border: 0px; vertical-align: baseline;">[],</strong><span style="background-color: #ffffff; color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px;"> where elements are in non-</span></span><span style="background-color: #ffffff; color: #273239; font-family: Nunito, sans-serif; font-size: 18px; letter-spacing: 0.162px;">increasing</span><span style="background-color: #ffffff; color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px; font-size: 14pt;">&nbsp;order. The task is to find the H-index.</span></p>
<blockquote>
<p><span style="font-size: 14pt;"><strong><span style="color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px; white-space-collapse: preserve; box-sizing: border-box; margin: 0px; padding: 0px; border: 0px; vertical-align: baseline;">H-Index</span></strong><span style="color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px; white-space-collapse: preserve;"> is usually assigned to the researcher denoting the contributions made in terms of the papers and citations. H-index(H) is the largest value such that the researcher has at least H papers cited at least H times.</span></span></p>
</blockquote>
<p><span style="font-size: 14pt;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 14pt;"><strong>Input: </strong><span style="color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px; white-space: normal;">citations</span>[] = [5, 3, 3, 0, 0]<br><strong>Output:</strong> 3<br><strong>Explanation:</strong> There are at least 3 papers (5, 3, 3) with at least 3 citations.</span></pre>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> citations[] = [5, 4, 2, 1, 1]<br><strong>Output:</strong> 2<br><strong>Explanation:</strong> There are atleast 2 papers (5, 4, 2) with atleast 2 citations.<br></span></pre>
<pre><span style="font-size: 14pt;"><strong>Input:</strong> citations[] = [0, 0]<br><strong>Output:</strong> 0<br></span></pre>
<p><span style="font-size: 14pt;"><strong>Constraints:</strong><br>1 ≤&nbsp;<span style="color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px;">citations</span>.size() ≤ 10<sup>6<br></sup>0 ≤&nbsp;<span style="color: #273239; font-family: Nunito, sans-serif; letter-spacing: 0.162px;">citations</span>[i] ≤ 10<sup>6</sup></span></p></div>