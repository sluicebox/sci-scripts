;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20900)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v900 0
)

(instance rm20v900 of ShiversRoom
	(properties
		picture 20900
	)

	(method (init)
		(proc951_16 36)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20140
	)

	(method (init)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

