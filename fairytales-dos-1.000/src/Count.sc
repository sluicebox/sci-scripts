;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 965)
(include sci.sh)

(public
	Count 0
)

(procedure (Count theList theCode &tmp theCount theNode) ; UNUSED
	(= theNode (FirstNode (theList elements:)))
	(= theCount 0)
	(while theNode
		(if (theCode doit: (NodeValue theNode) &rest)
			(++ theCount)
		)
		(= theNode (NextNode theNode))
	)
	(return theCount)
)

