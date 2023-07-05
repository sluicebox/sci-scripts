;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39)
(include sci.sh)
(use System)

(class QGSet of Set
	(properties)

	(method (eachElementDo param1 &tmp temp0 temp1 temp2)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 nextNode))
			(= nextNode (NextNode temp0))
			(= temp1 (NodeValue temp0))
			(= temp2 nextNode)
			(temp1 param1: &rest)
			(= nextNode temp2)
		)
	)
)

