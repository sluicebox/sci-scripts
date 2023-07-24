;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 18080)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm18v8 0
)

(instance rm18v8 of ShiversRoom
	(properties
		picture 18080
	)

	(method (init)
		(ClearFlag 43)
		(gGame handsOff:)
		(door init:)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(if (IsFlag 30)
			(if (== gPrevRoomNum 18250) ; rm18v25
				(gSounds play: 11801 0 82 0)
				(door setCycle: End)
				(SetFlag 43)
				(efExitForward init: 3)
			else
				(hsDoor init:)
				(efGeoffrey init: 0)
			)
		else
			(efGeoffrey init: 0)
		)
		(gGame handsOn:)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance door of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 18080
		cycleSpeed 15
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 76 143 78 86 91 44 119 6 127 0 139 0 161 23 178 49 187 77 189 103 190 142
		)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds play: 11801 0 82 0)
		(door setCycle: End)
		(SetFlag 43)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 18100
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 18070
	)
)

(instance efGeoffrey of ExitFeature
	(properties
		nextRoom 18250
	)

	(method (init)
		(self
			createPoly: 111 32 107 39 106 45 107 54 112 61 119 67 132 69 148 66 155 59 160 47 154 32 135 24 123 25 113 31
		)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 40010
	)

	(method (init)
		(self
			createPoly: 76 143 78 86 91 44 119 6 127 0 139 0 161 23 178 49 187 77 189 103 190 142
		)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

