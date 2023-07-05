;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3360)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm3v360 0
)

(instance rm3v360 of ShiversRoom
	(properties
		picture 3360
	)

	(method (init)
		(if (== gPrevRoomNum 931) ; profGhost
			(SetFlag 5)
			(gSounds play: 10318 -1 32 0)
		)
		(if (IsFlag 5)
			(spProfPot init:)
		else
			(hsProfPot init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance hsProfPot of HotSpot
	(properties)

	(method (init)
		(self
			createPoly:
				193
				115
				195
				117
				200
				119
				207
				118
				209
				114
				207
				109
				204
				105
				203
				100
				199
				98
				195
				99
				193
				102
				193
				105
				194
				106
				193
				108
				192
				111
				192
				114
		)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 167)
		(gCurRoom setScript: sProfPot)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 3340
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 3320
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 3410
	)

	(method (init)
		(self createPoly: 94 117 111 60 101 17 91 2 20 2 20 117)
		(super init: &rest)
	)
)

(instance spProfPot of ShiversProp
	(properties
		priority 25
		view 3360
	)

	(method (init)
		(self setPri: 25 1)
		(super init: &rest)
	)

	(method (doVerb)
		(gCurRoom newRoom: 3361) ; rm3v361
	)
)

(instance sProfPot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 15031 0 82 0)
				(spProfPot init:)
				(= seconds 3)
			)
			(1
				(gSounds stop: 10318)
				(gSounds stop: 10320)
				(gGame handsOn:)
				(gCurRoom newRoom: 931) ; profGhost
			)
		)
	)
)

