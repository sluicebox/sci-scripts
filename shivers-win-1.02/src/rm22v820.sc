;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22820)
(include sci.sh)
(use Main)
(use n951)

(public
	rm22v820 0
)

(instance rm22v820 of ShiversRoom
	(properties
		picture 22820
	)

	(method (init)
		(proc951_16 45)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 22100
	)

	(method (init)
		(self createPoly: 0 0 262 0 262 143 0 143 0 1)
		(super init: &rest)
	)
)

