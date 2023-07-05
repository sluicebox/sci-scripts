;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6260)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm6v260 0
)

(local
	local0
)

(instance rm6v260 of ShiversRoom
	(properties
		picture 6260
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(= local0 0)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (>= newRoomNumber 7000)
			(gSounds fade: 20601 0 15 8 1 0)
			(gSounds fade: 20603 0 15 8 1 0)
			(if (proc951_11 2 6000)
				(gSounds playChain: -1 -4 20602 -1)
				(gSounds adjChainVol: 34)
			)
		)
		(super newRoom: newRoomNumber &rest)
		(if (and local0 (<= newRoomNumber 7000))
			(gSounds play: 10712 0 40 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 6040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 6500
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 7010
	)

	(method (init)
		(self createPoly: 103 143 103 38 173 38 173 144)
		(super init: &rest)
	)
)

(instance pExtra of Prop
	(properties
		priority 26
		fixPriority 1
		view 6260
		loop 1
		cycleSpeed 27
	)
)

(instance pDoor of Prop
	(properties
		priority 25
		fixPriority 1
		view 6260
		cycleSpeed 27
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 103 143 103 38 173 38 173 144)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== global186 0)
			(gCurRoom setScript: sDoorOpens)
		else
			(gCurRoom setScript: sPurchaseMe)
		)
	)
)

(instance sDoorOpens of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(pDoor init:)
				(if (IsFlag 8)
					(pExtra init:)
				)
				(proc951_7 10711)
				(= cycles 1)
			)
			(1
				(pDoor setCycle: End)
				(if (IsFlag 8)
					(pExtra setCycle: End)
				)
				(gSounds play: 10711 0 40 self)
			)
			(2
				(gGame handsOn:)
				(efExitDoor init: 3)
				(= local0 1)
				(hsDoor dispose:)
				(self dispose:)
			)
		)
	)
)

(instance hsDialogArea of HotSpot
	(properties
		nsRight 266
		nsBottom 143
	)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (doVerb)
		(vDialog dispose:)
		(self dispose:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)
)

(instance sPurchaseMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(vDialog init:)
				(gSounds play: 35020 0 106 self)
			)
			(1
				(hsDialogArea init:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance vDialog of View
	(properties
		x 55
		y 118
		priority 250
		fixPriority 1
		view 921
		cel 5
	)
)

