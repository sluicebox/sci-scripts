;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6900)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Print)
(use Actor)
(use System)

(public
	rm6900 0
)

(instance rm6900 of KQRoom
	(properties
		picture 999
	)

	(method (init)
		(super init:)
		(graham init:)
		(valenice init:)
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
				(Prints {Graham says you are late.... the end.})
				(self cue:)
			)
			(1
				(= gQuit 1)
			)
		)
	)
)

(instance graham of Actor
	(properties
		x 40
		y 90
		view 6900
	)
)

(instance valenice of Actor
	(properties
		x 175
		y 90
		view 6900
		loop 1
	)
)

(instance rosella of Actor
	(properties
		x 250
		y 90
		view 6900
		loop 2
	)
)

