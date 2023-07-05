;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39030)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm39v030 0
)

(local
	local0
)

(instance rm39v030 of ShiversRoom
	(properties
		picture 39030
	)

	(method (init)
		(ClearFlag 43)
		(if (== gPrevRoomNum 39090) ; rm39v090
			(gSounds fade: 23901 58 5 16 0 0)
			(gSounds fade: 23902 26 5 16 0 0)
		)
		(door init:)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39020
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10300
	)

	(method (init)
		(self createPoly: 58 144 54 3 182 2 181 143)
		(super init: &rest)
	)
)

(instance door of ShiversProp
	(properties
		priority 25
		fixPriority 1
		view 39030
		cycleSpeed 12
	)

	(method (doVerb)
		(gSounds play: 13910 0 82 0)
		(self setCycle: End createPoly: -1 -1 -1 -1 -1 -1)
		(efExitForward init: 9)
		(SetFlag 43)
	)

	(method (init)
		(self createPoly: 61 142 60 8 180 8 179 142)
		(super init: &rest)
	)
)

