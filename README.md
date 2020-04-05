### union find algorithms

| algorithm | initalize | union | connected |
|-----------|-----------|-------|------|---------|
| quick-find | N | N | 1 | 
| quick-union | N | N | N |
| weighted quick-union | N | lg(N) | lg(N) |


 * __quick-find__ - each element in array contains the root of the tree, when merging two trees we replace 
 root for all the elements each time;
 
 * __quick_union__  - each element in array contains link to the connected element, because we need to find the root
 each time when we merge two elements and don't need to replace indexes of all tree elements, union will be quicker,
 but in the worst case it will have N comlexity;
 
 * __weighted quick-union__ - merges two elements on the basis of the weight of their trees (weight is the number of
 elements in the tree), we always connect root of the smallest tree with the root of the highest tree, so
 we have a confidence that tree couldn't be higher than lg(N)
 
 * __weighted quick-union with path compression__ - makes all the same as weighted, but updates information
 about node parent when computing the tree root;