;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1081)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v81 0
)

(instance rm1v81 of ShiversRoom
	(properties
		picture 1081
	)

	(method (init)
		(proc951_9 10111)
		(gSounds play: 10111 -1 0 0)
		(gSounds fade: 10111 26 1 40 0 0)
		(if (IsFlag 33)
			(vLetter init:)
		)
		(efExitForward init: 3)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance vLetter of View
	(properties
		priority 20
		fixPriority 1
		view 1081
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1080
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1071
	)

	(method (init)
		(self
			createPoly: 95 142 108 85 187 54 197 31 217 31 226 6 263 3 263 61 203 63 144 88 168 142
		)
		(super init: &rest)
	)
)

