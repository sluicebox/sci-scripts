;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28040)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm28v040 0
)

(instance rm28v040 of ShiversRoom
	(properties
		picture 28040
	)

	(method (init)
		(if (IsFlag 27)
			(spPot init:)
			(efExitPot init: 3)
		else
			(hsPot init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (== gPrevRoomNum 933) ; boyGhost
			(proc951_9 22801)
			(gSounds play: 22801 -1 0 0)
			(gSounds fade: 22801 98 1 30 0 0)
		)
	)
)

(instance spPot of ShiversProp
	(properties
		priority 100
		fixPriority 1
		view 28040
	)

	(method (doVerb)
		(gCurRoom newRoom: 28210) ; rm28v210
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 28020
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 28000
	)
)

(instance efExitPot of ExitFeature
	(properties
		nextRoom 28210
	)

	(method (init)
		(self createPoly: 160 106 160 142 213 142 213 106 161 106)
		(super init: &rest)
	)
)

(instance hsPot of HotSpot
	(properties)

	(method (init)
		(self createPoly: 165 135 160 127 164 103 184 103 189 133)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 168)
		(gCurRoom setScript: sBoyPot)
	)
)

(instance sBoyPot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 15031 0 82 0)
				(spPot init:)
				(= seconds 3)
			)
			(1
				(gSounds fade: 22801 0 1 30 1 self)
			)
			(2
				(gCurRoom newRoom: 933) ; boyGhost
			)
		)
	)
)

