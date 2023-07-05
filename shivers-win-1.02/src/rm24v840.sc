;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24840)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v840 0
)

(instance rm24v840 of ShiversRoom
	(properties
		picture 24840
	)

	(method (init)
		(proc951_16 55)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24380
	)

	(method (init)
		(self createPoly: 0 0 262 0 262 143 0 143 0 1)
		(super init: &rest)
	)
)

