;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1071)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm1v71 0
)

(instance rm1v71 of ShiversRoom
	(properties
		picture 1071
	)

	(method (init)
		(gSounds fade: 10111 98 1 40 0 0)
		(if (IsFlag 33)
			(vLetter init:)
		)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance vLetter of View
	(properties
		priority 20
		fixPriority 1
		view 1071
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1070
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1070
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1061
	)

	(method (init)
		(self
			createPoly: 141 142 193 97 219 96 219 34 197 15 149 17 129 33 124 52 93 53 90 87 97 99 76 142
		)
		(super init: &rest)
	)
)

