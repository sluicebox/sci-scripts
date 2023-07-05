;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7070)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm7v070 0
)

(instance rm7v070 of ShiversRoom
	(properties
		picture 7070
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(if (IsFlag 8)
			(vOpenCupboard init:)
		)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 2)
		(super newRoom: &rest)
	)
)

(instance vOpenCupboard of View
	(properties
		priority 10
		fixPriority 1
		view 7070
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 7080
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 7090
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 7100
	)

	(method (init)
		(self
			createPoly:
				84
				50
				84
				113
				93
				114
				71
				142
				189
				142
				162
				113
				164
				95
				229
				95
				230
				2
				129
				1
				129
				46
		)
		(super init: &rest)
	)
)

