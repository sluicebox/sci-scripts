;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use Feature)
(use System)

(public
	ExitFeature 0
)

(class ExitFeature of Feature
	(properties
		nextRoom 0
		exitCursor 0
		lastCursor 0
		message 11
	)

	(method (init param1)
		(super init: &rest)
		(gTheDoits add: self)
		(= exitCursor param1)
		(= lastCursor gTheCursor)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (cue))

	(method (handleEvent event)
		(if
			(and
				(& (event type:) evVERB)
				(self onMe: event)
				(self isNotHidden:)
			)
			(SetFlag 181)
		)
		(if (and (== approachX 0) (== approachY 0))
			(= approachX (event x:))
			(= approachY (event y:))
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 11) 0) ; ???
			((OneOf theVerb 5 7 8 9 10) ; Exit, ExitRight, ExitLeft, ExitUp, ExitDown
				(= gTheCursor gWalkCursor)
				((gTheIconBar walkIconItem:) type: 20480 message: 3)
				(gGame handsOff:)
				(gCurRoom newRoom: nextRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(cond
			(
				(self
					onMe:
						(+ (Abs ((gCurRoom plane:) left:)) gMouseX)
						(+ (Abs ((gCurRoom plane:) top:)) gMouseY)
				)
				(cond
					((== gTheCursor gWalkCursor)
						(= lastCursor gTheCursor)
						((gTheIconBar curIcon:) type: 16384 message: message)
						(gGame setCursor: exitCursor)
						(= y
							(+
								(Abs ((gCurRoom plane:) top:))
								(Abs ((gCurRoom plane:) bottom:))
							)
						)
					)
					((and (!= gTheCursor exitCursor) y)
						(= y 0)
					)
				)
			)
			(
				(or
					(== gTheCursor exitCursor)
					(and
						(or (== lastCursor gWalkCursor) (== lastCursor gWaitCursor))
						(== gTheCursor gWalkCursor)
					)
				)
				((gTheIconBar curIcon:) type: 20480 message: 3)
				(gGame setCursor: gWalkCursor)
				(= y (= lastCursor 0))
			)
		)
	)
)

