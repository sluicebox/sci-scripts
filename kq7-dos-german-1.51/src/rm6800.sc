;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6800)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Print)
(use Actor)
(use System)

(public
	rm6800 0
)

(instance rm6800 of KQRoom
	(properties
		picture 999
	)

	(method (init)
		(super init:)
		(edger init:)
		(rosella init:)
		(self setScript: roomScript)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Prints {Oh how beautiful all this is bla bla bla.})
				(self cue:)
			)
			(1
				(Prints {Kiss kiss.})
				(self cue:)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: 6700)
			)
		)
	)
)

(instance edger of Actor
	(properties
		x 50
		y 100
		view 6800
	)
)

(instance rosella of Actor
	(properties
		x 200
		y 100
		view 6800
		loop 1
	)
)

