;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16420)
(include sci.sh)
(use Main)
(use n951)

(public
	rm16v420 0
)

(instance rm16v420 of ShiversRoom
	(properties
		picture 16420
		invView 2
	)

	(method (init)
		(if (IsFlag 13)
			(= picture 16424)
			(self initRoom: 174 194 113 140)
			(psOnFloor init:)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance psOnFloor of PotSpot
	(properties
		nsLeft 174
		nsTop 113
		nsRight 194
		nsBottom 140
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 16400
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 16410
	)
)

