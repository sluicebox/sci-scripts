;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 926)
(include sci.sh)
(use Main)
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
	(DisposeScript 926)
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
	(DisposeScript 926)
)

(instance flipPoly of Code
	(properties)

	(method (doit thePoly &tmp i newPoints theSize)
		(= newPoints (Memory memALLOC_CRIT (* 4 (= theSize (thePoly size:)))))
		(for ((= i 0)) (< i theSize) ((++ i))
			(Memory
				memPOKE
				(+ newPoints (* 4 i))
				(-
					320
					(Memory
						memPEEK
						(- (+ (thePoly points:) (* 4 theSize)) (+ 4 (* 4 i)))
					)
				)
			)
			(Memory
				memPOKE
				(+ newPoints (* 4 i) 2)
				(Memory
					memPEEK
					(- (+ (thePoly points:) (* 4 theSize)) (+ 2 (* 4 i)))
				)
			)
		)
		(if (thePoly dynamic:)
			(Memory memFREE (thePoly points:))
		)
		(thePoly points: newPoints dynamic: 1)
	)
)

(instance flipFeature of Code
	(properties)

	(method (doit theFeature &tmp oldLeft)
		(if (IsObject (theFeature onMeCheck:))
			(FlipPoly (theFeature onMeCheck:))
		else
			(= oldLeft (theFeature nsLeft:))
			(theFeature nsLeft: (- 320 (theFeature nsRight:)) nsRight: (- 320 oldLeft))
		)
	)
)

