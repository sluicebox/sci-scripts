;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3010)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use System)

(public
	rm3v010 0
)

(local
	local0
)

(instance rm3v010 of ShiversRoom
	(properties
		picture 3010
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(spDoor init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 2320) ; rm2v32
				(gSounds stop: 10318)
				(proc951_8 10318)
			)
			(local0
				(gSounds play: 10320 0 82 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3370
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3030
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 2320
	)

	(method (init)
		(self
			createPoly:
				90
				124
				183
				124
				183
				48
				176
				33
				164
				23
				152
				18
				135
				17
				127
				17
				110
				22
				99
				30
				92
				44
				91
				50
				90
				124
		)
		(super init: &rest)
		(gMouseDownHandler delete: self)
		(gMouseDownHandler addToFront: self)
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 3010
		cycleSpeed 36
	)

	(method (init)
		(self
			createPoly:
				90
				124
				183
				124
				183
				48
				176
				33
				164
				23
				152
				18
				135
				17
				127
				17
				110
				22
				99
				30
				92
				44
				91
				50
				90
				124
		)
		(super init: &rest)
	)

	(method (doVerb)
		(= local0 1)
		(self setScript: sOpenDoor)
	)
)

(instance sOpenDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 10217 0 82 0)
				(spDoor setCycle: End)
				(= cycles 1)
			)
			(1
				(= seconds 4)
			)
			(2
				(efExitForward init: 3)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

