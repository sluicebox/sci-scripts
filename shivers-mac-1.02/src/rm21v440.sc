;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21440)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm21v440 0
)

(local
	local0
)

(instance rm21v440 of ShiversRoom
	(properties
		picture 21440
	)

	(method (init)
		(efExitRightPlaque init: 3)
		(hsDoor init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 22020) ; rm22v020
				(gSounds fade: 22102 0 5 16 1 0)
				(gSounds fade: 22101 0 5 16 1 0)
				(gSounds fade: 22512 0 5 16 1 0)
			)
			(local0
				(gSounds play: 12207 0 82 0)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitRightPlaque of ExitFeature
	(properties
		nextRoom 21321
	)

	(method (init)
		(self
			createPoly: 180 143 182 106 192 94 220 94 218 111 210 134 223 141 222 144 180 143
		)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22020
	)

	(method (init)
		(self createPoly: 80 16 183 16 182 136 81 136 80 17)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 21030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 21040
	)
)

(instance hsDoor of HotSpot
	(properties)

	(method (init)
		(self createPoly: 80 16 183 16 182 136 81 136 80 17)
		(super init: &rest)
	)

	(method (doVerb)
		(gSounds stop: 12206)
		(gSounds stop: 12207)
		(gSounds play: 12206 0 82 0)
		(pDoor init: setCycle: End)
		(= local0 1)
		(efExitForward init: 3)
		(self dispose:)
	)
)

(instance pDoor of Prop
	(properties
		priority 5
		fixPriority 1
		view 21440
		cycleSpeed 24
	)

	(method (init)
		(if (IsFlag 22)
			(self view: 21441)
		)
		(super init: &rest)
	)
)

