;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6700)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	rm6700 0
)

(instance rm6700 of KQRoom
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
				(Prints {Credits run.})
				(self cue:)
			)
			(2
				(gGame handsOn:)
				(if (IsFlag 252)
					(gCurRoom newRoom: 6900)
				else
					(Prints
						{This game is over. Thank you... thank you very much.}
					)
					(= gQuit 1)
				)
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

