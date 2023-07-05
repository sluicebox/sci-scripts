;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use skipCartoon)
(use Motion)
(use Actor)
(use System)

(public
	rm150 0
)

(instance rm150 of KQRoom
	(properties
		picture 999
	)

	(method (init)
		(super init:)
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
				(valenice init:)
				(rosella init: setCycle: Fwd)
				(= seconds 3)
			)
			(1
				(gMessager say: 0 0 2 0 self 100) ; "Rosella!"
			)
			(2
				(= seconds 2)
			)
			(3
				(gCurRoom newRoom: 1250)
			)
		)
	)
)

(instance valenice of Actor
	(properties
		x 250
		y 80
		view 0
	)
)

(instance rosella of Actor
	(properties
		x 50
		y 80
		view 1
		loop 1
	)
)

