;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	DistObj 0
)

(class TellerObj of Obj
	(properties
		telObject 0
		telDistance 0
	)
)

(class DistObj of Obj
	(properties
		objList 0
	)

	(method (init param1 &tmp temp0)
		(gEgo actions: self)
		(= objList myList)
		(for ((= temp0 0)) (< temp0 argc) ((+= temp0 2))
			(if [param1 temp0]
				(objList
					add:
						((TellerObj new:)
							init:
							telObject: [param1 temp0]
							telDistance: [param1 (+ temp0 1)]
							yourself:
						)
				)
			else
				(Prints {You have passed a wrong parameter})
				(SetDebug)
			)
		)
	)

	(method (dispose)
		(objList dispose:)
		(super dispose:)
	)

	(method (doVerb)
		(objList firstTrue: #perform checkDist)
	)
)

(instance myList of List
	(properties)

	(method (firstTrue param1 &tmp temp0 temp1)
		(for ((= temp0 (FirstNode elements))) temp0 ((= temp0 nextNode))
			(= nextNode (NextNode temp0))
			(= temp1 (NodeValue temp0))
			(if (temp1 param1: &rest)
				(return (temp1 telObject:))
			)
		)
		(return 0)
	)
)

(instance checkDist of Code
	(properties)

	(method (doit param1)
		(if
			(<
				(gEgo distanceTo: (param1 telObject:) 65)
				(param1 telDistance:)
			)
			(return param1)
		)
		(return 0)
	)
)

