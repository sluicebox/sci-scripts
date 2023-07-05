;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6400)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Print)
(use System)

(public
	rm6400 0
)

(instance rm6400 of KQRoom
	(properties
		picture 6400
	)

	(method (init)
		(SetFlag 21)
		(super init:)
		(gEgo x: 150 y: 100 view: 900 init: normalize:)
		(gGame handsOff:)
		(gCurRoom setScript: falling)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(Prints {Show falling cartoom/movie})
				(= seconds 1)
			)
			(2
				(gCurRoom newRoom: 6450)
			)
		)
	)
)

