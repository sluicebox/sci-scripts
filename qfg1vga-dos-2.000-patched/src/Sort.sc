;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 966)
(include sci.sh)
(use System)

(public
	Sort 0
)

(procedure (Sort theList theLTCode &tmp temp node minValue tempList) ; UNUSED
	(= tempList (List new:))
	(while (= node (FirstNode (theList elements:)))
		(= minValue (NodeValue node))
		(while node
			(if (theLTCode doit: (= temp (NodeValue node)) minValue &rest)
				(= minValue temp)
			)
			(= node (NextNode node))
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

