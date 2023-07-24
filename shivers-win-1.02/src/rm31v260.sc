;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31260)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm31v260 0
)

(instance rm31v260 of ShiversRoom
	(properties
		picture 31260
	)

	(method (init)
		(ClearFlag 43)
		(efExitRight init: 1)
		(efExitLeft init: 7)
		(if (IsFlag 11)
			(spDoor init:)
			(if (== gPrevRoomNum 31270) ; rm31v270
				(spDoor doVerb:)
			)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(if (IsFlag 43)
			(ClearFlag 43)
			(gSounds play: 13120 0 82 0)
		)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 31290
	)

	(method (init)
		(self
			createPoly: 80 143 76 125 78 110 77 99 75 85 79 75 95 66 115 58 108 37 109 25 120 15 133 13 151 18 159 27 159 43 153 58 177 67 191 80 193 94 191 116 192 128 189 142 80 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 31270
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 31250
	)
)

(instance spDoor of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 31260
	)

	(method (doVerb)
		(gSounds play: 13116 0 82 0)
		(SetFlag 43)
		(self createPoly: -1 -1 -1 -1 -1 -1 setCycle: End)
		(efExitForward init: 3)
	)
)

