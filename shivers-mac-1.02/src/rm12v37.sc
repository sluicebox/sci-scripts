;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12370)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm12v37 0
)

(instance rm12v37 of ShiversRoom
	(properties
		picture 12370
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efForward init: 9)
		(if (IsFlag 9)
			((View new:) view: 12370 cel: 0 setPri: 25 1 init:)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12390
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12380
	)
)

(instance efForward of ExitFeature
	(properties
		nextRoom 12410
	)

	(method (init)
		(self
			createPoly: 71 142 71 136 79 121 73 110 77 104 105 55 148 11 200 60 216 110 222 144
		)
		(super init: &rest)
	)
)

