;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64966)
(include sci.sh)
(use System)

(public
	Sort 0
)

(procedure (Sort theList theLTCode &tmp temp node minValue tempList) ; UNUSED
	(= tempList (List new:))
	(while (= node (KList 3 (theList elements:))) ; FirstNode
		(= minValue (KList 8 node)) ; NodeValue
		(while node
			(if (theLTCode doit: (= temp (KList 8 node)) minValue &rest) ; NodeValue
				(= minValue temp)
			)
			(= node (KList 6 node)) ; NextNode
		)
		(TE doit: minValue theList tempList)
	)
	(tempList eachElementDo: #perform TE tempList theList dispose:)
)

(instance TE of Code
	(properties)

	(method (doit e sourceList destinationList)
		(destinationList addToEnd: e)
		(sourceList delete: e)
	)
)

