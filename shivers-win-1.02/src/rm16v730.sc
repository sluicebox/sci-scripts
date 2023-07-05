;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16730)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v730 0
)

(instance rm16v730 of ShiversRoom
	(properties
		picture 16730
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16734)
		)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 16290
	)

	(method (init)
		(self createPoly: 43 143 110 108 141 103 265 79 265 145)
		(super init: &rest)
	)
)

