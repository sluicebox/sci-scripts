;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64926)
(include sci.sh)
(use Main)
(use Array)
(use System)

(public
	FlipPoly 0
	FlipFeature 1
)

(procedure (FlipPoly arg &tmp theList)
	(cond
		((not argc)
			(= theList (gCurRoom obstacles:))
		)
		((arg isKindOf: Collect)
			(= theList arg)
		)
		(else
			(arg perform: flipPoly)
			(return)
		)
	)
	(theList eachElementDo: #perform flipPoly)
	(DisposeScript 64926)
)

(procedure (FlipFeature args &tmp i) ; UNUSED
	(if (not argc)
		(gFeatures eachElementDo: #perform flipFeature)
	else
		(for ((= i 0)) (< i argc) ((++ i))
			(if ([args i] isKindOf: Collect)
				([args i] eachElementDo: #perform flipFeature)
			else
				([args i] perform: flipFeature)
			)
		)
	)
	(DisposeScript 64926)
)

(instance flipPoly of Code
	(properties)

	(method (doit thePoly &tmp i newPoints theSize)
		(= newPoints (IntArray with: (* 4 (= theSize (thePoly size:))) {}))
		(for ((= i 0)) (< i theSize) ((++ i))
			(newPoints
				at:
					(* 4 i)
					(-
						320
						((thePoly points:) at: (- (* 4 theSize) (+ 4 (* 4 i))))
					)
			)
			(newPoints
				at:
					(+ (* 4 i) 2)
					((thePoly points:) at: (- (* 4 theSize) (+ 2 (* 4 i))))
			)
		)
		(if (thePoly dynamic:)
			((thePoly points:) dispose:)
		)
		(thePoly points: newPoints dynamic: 1)
	)
)

(instance flipFeature of Code
	(properties)

	(method (doit theFeature &tmp node obj theList)
		(if ((theFeature onMeCheck:) isKindOf: List)
			(= theList (theFeature onMeCheck:))
			(for
				((= node (KList 3 (theList elements:)))) ; FirstNode
				node
				((= node (theList nextNode:)))
				
				(theList nextNode: (KList 6 node)) ; NextNode
				(= obj (KList 8 node)) ; NodeValue
				(FlipPoly obj)
			)
		else
			(FlipPoly (theFeature onMeCheck:))
		)
	)
)

