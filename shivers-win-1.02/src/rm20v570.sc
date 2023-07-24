;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20570)
(include sci.sh)
(use Main)
(use n951)
(use Motion)

(public
	rm20v570 0
)

(local
	local0
)

(instance rm20v570 of ShiversRoom
	(properties
		picture 20570
	)

	(method (init)
		(efExitPlaque init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(pPropStairs init:)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 20920
	)

	(method (init)
		(self
			createPoly: 1 83 6 72 11 69 34 69 36 74 24 110 37 122 36 126 16 128 0 127 0 120 14 111 15 84 1 84
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20560
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20560
	)

	(method (init)
		(self createPoly: 0 0 0 66 42 66 42 0 1 0)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20572
	)

	(method (init)
		(self createPoly: 94 142 170 142 154 0 106 0 95 141)
		(super init: &rest)
	)
)

(instance pPropStairs of ShiversProp
	(properties
		priority 10
		fixPriority 1
		view 20570
	)

	(method (init)
		(if (== gPrevRoomNum 20572) ; rm20v572
			(self setCel: 3)
			(= local0 1)
			(efExitForward init: 3)
		)
		(self createPoly: 104 104 104 140 161 140 161 103 104 103)
		(super init: &rest)
	)

	(method (doVerb)
		(proc951_16 150)
		(if (not local0)
			(gSounds play: 12008 0 82 0)
			(self setCycle: End)
			(self createPoly: 0 0 0 0 0 0 0 0 0 0)
			(efExitForward init: 3)
			(= local0 1)
			(SetFlag 43)
		)
	)
)

