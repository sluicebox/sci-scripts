;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use Print)

(class AnimatePrint of Print
	(properties
		myMouth 0
		myEyes 0
		theLength 0
	)

	(method (init)
		(= modeless 1)
		(= ticks 120)
		(if myMouth
			(myMouth init: theLength)
		)
		(if myEyes
			(myEyes init:)
		)
		(super init:)
	)

	(method (addText param1 param2 param3 param4)
		(= width 230)
		(= theLength (/ (Message msgSIZE gCurRoomNum param1 param2 param3 param4) 12))
		(super addText: param1 param2 param3 param4 &rest)
	)

	(method (dispose)
		(if myMouth
			(myMouth dispose:)
		)
		(if myEyes
			(myEyes dispose:)
		)
		(super dispose:)
		((gCurRoom script:) cue:)
	)
)

