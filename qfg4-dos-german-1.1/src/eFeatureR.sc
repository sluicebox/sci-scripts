;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Print)
(use Feature)
(use System)

(public
	eFeatureR 0
)

(instance eFeatureR of Feature
	(properties)

	(method (init)
		(if (not (gCurRoom exitList:))
			(gCurRoom exitList: (List new:))
		)
		((gCurRoom exitList:) add: self)
	)

	(method (onMe param1 param2)
		(if (and (<= nsLeft param1 nsRight) (<= nsTop param2 nsBottom))
			(if (and approachX approachY)
				(gEgo setMotion: ((ScriptID 17) new:) approachX approachY) ; pOffMover
			else
				(= gQuit 1)
				(Prints
					{YOU HAVE SET approachX approachY of your eFeature}
				)
				(SetDebug)
			)
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

