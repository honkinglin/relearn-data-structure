## Binary Search Tree (BST)

### Brief Summary of Binary Search Tree (BST):
A binary search tree (BST) is a hierarchical data structure.

Organizes elements in a tree-like structure where each node has at most two children: left and right.

Follows the property that for any given node, all elements in the left subtree are less than the node, and all elements in the right subtree are greater than the node.

### Key Points in Implementing this Data Structure:
1. **Root Node:** The topmost node of the tree.
2. **Child Nodes:** Each node has at most two children: left child and right child.
3. **Ordering Property:** For any given node, all elements in the left subtree are less than the node, and all elements in the right subtree are greater than the node.
4. **Binary Search:** Utilizes binary search algorithm for efficient search operations.
5. **Balanced BST:** Balanced BST ensures that the height of the tree is minimized, improving search, insertion, and deletion operations.
6. **In-order Traversal:** Traversal method that visits nodes in ascending order, useful for printing elements in sorted order.

### Practical Applications of this Data Structure:
1. **Searching:** Binary search trees provide efficient searching capabilities due to their hierarchical structure and binary search property.
2. **Sorting:** In-order traversal of a BST results in elements being visited in sorted order, making BSTs useful for sorting data.
3. **Symbol Tables:** BSTs can be used to implement symbol tables in compilers and interpreters for storing identifiers and their associated values efficiently.
4. **Database Indexing:** BSTs are used in database indexing to speed up search operations, particularly for range queries and exact match searches.
5. **File Systems:** BSTs can be utilized in file systems to organize and search for files efficiently, especially when directories are arranged hierarchically.

BSTs are versatile data structures with various applications in computer science and software engineering, providing efficient solutions to many problems requiring hierarchical organization and ordered access to data.

### Pre-order Traversal:

- Application: Pre-order traversal is commonly used in expression tree evaluation, where operators are processed before their operands.

- Example Usage: Pre-order traversal can be applied in creating a prefix notation (Polish notation) representation of mathematical expressions.

- Description: In pre-order traversal, the root node is visited first, then the left subtree is traversed recursively, followed by traversing the right subtree recursively.

### In-order Traversal:

- Application: In-order traversal is often used to retrieve elements of a binary search tree in sorted order.

- Example Usage: In-order traversal can be employed to print elements of a binary search tree in sorted order.

- Description: In in-order traversal, nodes are visited in ascending order (assuming the tree contains elements in non-descending order). The left subtree is visited first, followed by visiting the root node, and then the right subtree is visited.

### Post-order Traversal:

- Application: Post-order traversal is useful in expression tree evaluation, where operands are processed before their operators.

- Example Usage: Post-order traversal can be applied to create a postfix notation (Reverse Polish notation) representation of mathematical expressions.

- Description: In post-order traversal, nodes are visited in a bottom-up manner. The left subtree is traversed first, followed by traversing the right subtree, and finally visiting the root node.
