;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1190)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v190 0
)

(instance rm1v190 of ShiversRoom
	(properties
		picture 1190
	)

	(method (init)
		(if (IsFlag 1)
			(vStonehengeOpen init:)
		)
		(gSounds interruptChain:)
		(gSounds adjChainVol: 34)
		(gSounds
			playChain:
				20101
				-1
				-1
				-5
				20101
				-1
				-1
				-5
				20102
				-1
				-1
				-5
				20103
				-1
				-1
				-5
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance vStonehengeOpen of View
	(properties
		priority 20
		fixPriority 1
		view 1190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1191
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1191
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1200
	)

	(method (init)
		(self createPoly: 126 143 97 53 145 49 171 53 171 57 149 105 195 142)
		(super init: &rest)
	)
)

