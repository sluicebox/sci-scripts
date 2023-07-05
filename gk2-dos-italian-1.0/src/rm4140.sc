;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4140)
(include sci.sh)
(use Main)
(use GK2Room)
(use System)

(public
	rm4140 0
)

(instance rm4140 of GK2Room ; "Marienplatz"
	(properties
		modNum 400
		noun 10
		picture 4140
		south 410 ; dienerRm
	)

	(method (init)
		(super init: &rest)
		(gGame handsOff:)
		(gCurRoom setScript: sJustPassingThrough)
	)
)

(instance sJustPassingThrough of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= ticks 280)
			)
			(2
				(gCurRoom newRoom: 410) ; dienerRm
				(self dispose:)
			)
		)
	)
)

