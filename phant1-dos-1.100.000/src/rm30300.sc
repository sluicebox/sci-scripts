;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30300)
(include sci.sh)
(use Main)
(use ExitFeature)
(use Print)
(use Feature)
(use System)

(public
	rm30300 0
)

(instance rm30300 of ScaryRoom
	(properties
		picture 30110
		stepSound 4
	)

	(method (init)
		(super init: &rest)
		(file init: setHotspot: 4 3) ; Do, Move
		(southExit init: 3)
		(eastExit init: 2)
		(westExit init: 4)
		(self setScript: sLookInCabinet)
	)
)

(instance sLookInCabinet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Prints {Adrienne looks in the cabinet.})
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance file of Feature
	(properties
		nsLeft 105
		nsTop 73
		nsRight 207
		nsBottom 97
		x 156
		y 85
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(Prints {Rummage in folder})
			(if ((gInventory at: 0) ownedBy: 30300) ; invLibKey
				(gEgo get: 0) ; invLibKey
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		x 147
		y 130
	)

	(method (init)
		(= nextRoom gPrevRoomNum)
		(super init: &rest)
	)
)

(instance westExit of ExitFeature
	(properties
		x -5
		y 69
	)

	(method (init)
		(= nextRoom gPrevRoomNum)
		(super init: &rest)
	)
)

(instance eastExit of ExitFeature
	(properties
		nsLeft 295
		nsTop 0
		nsRight 307
		nsBottom 140
		x 301
		y 69
	)

	(method (init)
		(= nextRoom gPrevRoomNum)
		(super init: &rest)
	)
)

