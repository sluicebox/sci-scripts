;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64965)
(include sci.sh)

(public
	Count 0
)

(procedure (Count theList theCode &tmp theCount theNode) ; UNUSED
	(= theNode (KList 3 (theList elements:))) ; FirstNode
	(= theCount 0)
	(while theNode
		(if (theCode doit: (KList 8 theNode) &rest) ; NodeValue
			(++ theCount)
		)
		(= theNode (KList 6 theNode)) ; NextNode
	)
	(return theCount)
)

