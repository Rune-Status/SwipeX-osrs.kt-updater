package kt.osrs.analysis.tree.dsl

class NodeSequence(init: NodeSequence.() -> Unit) {
    var tree: TreeNode? = null

    init {
        apply(init)
    }

    fun tree(node: TreeNode.() -> Unit) {
        tree = TreeNode().apply(node)
    }

    fun build(node: TreeNode) = { tree = node }

    fun vn(): TreeNode {
        return TreeNode(NodeType.VariableNode)
    }

    fun fmn(): TreeNode {
        return TreeNode(NodeType.FieldMemberNode)
    }
}