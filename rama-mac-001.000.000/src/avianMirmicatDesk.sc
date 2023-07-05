;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6611)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	avianMirmicatDesk 0
)

(instance avianMirmicatDesk of CloseupLocation
	(properties)

	(method (init)
		(if (not (IsFlag 126))
			(Load rsAUDIO 6611)
		)
		(super init: 6626)
		(projectorBtn init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(25
				(mural1 init: global117)
				(mural2 init: global117)
			)
			(26
				(mural1 dispose:)
				(mural2 dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance projectorBtn of Feature
	(properties
		nsLeft 425
		nsTop 84
		nsRight 446
		nsBottom 110
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb)
		(gCurRoom setScript: flashProjector)
	)
)

(instance flashProjector of Script
	(properties)

	(method (doit)
		(super doit:)
		(if register
			(== (PalVary 2) register) ; PalVaryInfo
			(= register 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 126)
				(projectorSound number: 6611 loop: 1 play:)
				(PalVary 0 6627 1 100 1 160) ; PalVaryStart
				(gCurRoom doVerb: 25)
				(= register 100)
			)
			(1
				(PalVary 1 2 25) ; PalVaryReverse
				(= ticks 60)
			)
			(2
				(PalVary 0 6627 2 100 1 160) ; PalVaryStart
				(projectorSound fade:)
				(= ticks 120)
			)
			(3
				(PalVary 1 2) ; PalVaryReverse
				(= cycles 1)
			)
			(4
				(= ticks 240)
			)
			(5
				(projectorSound number: 6900 loop: 1 play:)
				(PalVary 0 6627 1 100 1 160) ; PalVaryStart
				(gCurRoom doVerb: 26)
				(= register 100)
			)
			(6
				(PalVary 1 2) ; PalVaryReverse
				(= cycles 1)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mural1 of View
	(properties
		x 106
		y 36
		view 6626
	)
)

(instance mural2 of View
	(properties
		x 363
		y 34
		view 6626
		cel 1
	)
)

(instance projectorSound of Sound
	(properties
		flags 5
		number 6611
	)
)

