package kt.osrs.analysis.model

import kt.osrs.analysis.classIdentity
import kt.osrs.analysis.tree.dsl.NodeSequence
import org.objectweb.asm.Opcodes.*

class Actor : Identifiable() {
    override val executeIndex = 7
    override val identity = classIdentity {
        name = "Actor"
        staticDefinition {
            superName = "{RenderableNode}"
            "Ljava/lang/String;" occurs 1
        }

        memberIdentity {
            name = "animation"
            desc = "I"
            sequence = NodeSequence {
                jn {
                    node(IALOAD) {
                        fmn {
                            mmn(INVOKESTATIC) {
                                !fmn()
                            }
                        }
                    }
                }
            }
        }
        memberIdentity {
            name = "interactingIndex"
            desc = "I"
            sequence = NodeSequence {
                node(ASTORE) {
                    node(AALOAD) {
                        node(ISUB) {
                            !fmn()
                        }
                    }
                }
            }
        }
        memberIdentity {
            name = "localX"
            desc = "I"
            sequence = NodeSequence {
                mmn(null, "(III)V") {
                    !fmn() {
                        vn(ALOAD, 0)
                    } and fmn() {
                        vn(ALOAD, 0)
                    } and vn(ILOAD, 1)
                }
            }
        }
        memberIdentity {
            name = "localY"
            desc = "I"
            sequence = NodeSequence {
                mmn(null, "(III)V") {
                    fmn() {
                        vn(ALOAD, 0)
                    } and !fmn() {
                        vn(ALOAD, 0)
                    } and vn(ILOAD, 1)
                }
            }
        }
    }
}