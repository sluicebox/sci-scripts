;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 35180)
(include sci.sh)
(use Main)
(use n951)
(use System)

(public
	rm35v180 0
)

(instance rm35v180 of ShiversRoom
	(properties
		picture 35180
	)

	(method (init)
		(if (== gPrevRoomNum 932) ; girlGhost
			(SetFlag 29)
			(proc951_9 24001)
			(gSounds play: 24001 -1 0 0)
			(gSounds fade: 24001 90 1 30 0 0)
		)
		(if (IsFlag 29)
			(self picture: 35184)
			(proc951_16 126)
			(efExitForward init: 3)
		else
			(hsGirlPot init:)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance hsGirlPot of HotSpot
	(properties)

	(method (init)
		(self createPoly: 121 92 121 117 145 118 145 92 122 92)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 169)
		(gCurRoom setScript: sGirlPot)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 35340
	)

	(method (init)
		(self createPoly: 113 89 113 125 152 125 152 89 113 89)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 35250
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 35240
	)
)

(instance sGirlPot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSounds play: 15031 0 82 0)
				(gCurRoom drawPic: 35184)
				(FrameOut)
				(= seconds 4)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 932) ; girlGhost
			)
		)
	)
)

