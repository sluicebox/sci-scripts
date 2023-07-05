;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6600)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm6600 0
)

(instance rm6600 of KQRoom
	(properties
		picture 999
	)

	(method (init)
		(super init:)
		(edAndRose init:)
		(self setScript: flyAway)
	)
)

(instance flyAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(edAndRose setMotion: MoveTo 320 95 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 6800)
			)
		)
	)
)

(instance edAndRose of Actor
	(properties
		y 95
		view 6600
	)
)

