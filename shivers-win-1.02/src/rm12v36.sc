;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12360)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v36 0
)

(instance rm12v36 of ShiversRoom
	(properties
		picture 12360
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(efForward init: 9)
		(efForRight init: 9)
		(if (IsFlag 10)
			((View new:) view: 12360 cel: 0 setPri: 25 1 init:)
		)
		(if (IsFlag 9)
			((View new:) view: 12360 cel: 1 setPri: 25 1 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12350
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12330
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 12310
	)

	(method (init)
		(self
			createPoly:
				45
				142
				45
				90
				44
				69
				89
				69
				89
				73
				84
				77
				81
				94
				116
				96
				123
				48
				221
				23
				222
				123
		)
		(super init: &rest)
	)
)

(instance efForRight of ExitFeature
	(properties
		nextRoom 12310
	)

	(method (init)
		(self createPoly: 223 124 222 23 243 17 243 122)
		(super init: &rest)
	)
)

