;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11120)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm11v120 0
)

(local
	local0
)

(instance rm11v120 of ShiversRoom
	(properties
		picture 11120
	)

	(method (init)
		(= local0 0)
		(ClearFlag 43)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(hsDoor init:)
		(efSkullDial init: 3)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 8)
		(if (>= newRoomNumber 12000)
			(ClearFlag 43)
			(gSounds stop: 21902)
			(gSounds fade: 21103 0 5 16 1 0)
			(gSounds stop: 21101)
			(gSounds stopChain:)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 11110
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 11130
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 12010
	)

	(method (init)
		(self createPoly: 87 123 87 18 189 18 189 123)
		(super init: &rest)
	)
)

(instance efSkullDial of ExitFeature
	(properties
		nextRoom 11330
	)

	(method (init)
		(self createPoly: 20 34 71 34 71 77 20 77)
		(super init: &rest)
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 87 123 87 18 189 18 189 123)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== global186 0)
			(gCurRoom setScript: sOpenDoor)
		else
			(gCurRoom setScript: sPurchaseMe)
		)
	)
)

(instance pDoor of Prop
	(properties
		view 11120
	)

	(method (init)
		(if (IsFlag 10)
			(self view: 11121)
		)
		(super init: &rest)
	)
)

(instance pColossus of Prop
	(properties
		view 11120
		loop 1
	)

	(method (init)
		(if (IsFlag 10)
			(self view: 11121 loop: 1)
		)
		(super init: &rest)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hsDoor dispose:)
				(pDoor init: setPri: 25 1 setCycle: End)
				(if (IsFlag 9)
					(pColossus init: setPri: 27 1 setCycle: End)
				)
				(gSounds play: 11106 0 32 self)
			)
			(1
				(efExitForward init: 3)
				(= local0 1)
				(SetFlag 43)
				(gGame handsOn:)
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
		x 65
		y 110
		priority 25
		view 921
	)

	(method (init)
		(self setPri: 25)
		(super init: &rest)
	)
)

