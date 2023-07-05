;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Sound)
(use Game)
(use System)

(public
	rm400 0
)

(instance babble of Sound
	(properties
		number 902
		loop -1
	)
)

(instance rm400 of Room
	(properties
		picture 400
	)

	(method (init)
		(if (IsHiRes)
			(= picture 10400)
		)
		(gGame handsOff:)
		(super init: &rest)
		(self setScript: toLobbyScript)
		(babble play:)
	)
)

(instance toLobbyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound0 number: 400 loop: 1 play: self)
			)
			(1
				(gCurRoom newRoom: 405)
			)
		)
	)
)

