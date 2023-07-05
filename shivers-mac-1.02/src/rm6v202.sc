;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6202)
(include sci.sh)
(use Main)
(use n951)

(public
	rm6v202 0
)

(instance rm6v202 of ShiversRoom
	(properties
		picture 6202
	)

	(method (init)
		(proc951_16 89)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties
		nextRoom 6200
	)

	(method (init)
		(self
			createPoly:
				48
				5
				230
				0
				242
				134
				104
				141
				125
				142
				263
				142
				264
				0
				0
				0
				1
				142
				54
				142
				47
				6
		)
		(super init: &rest)
	)
)

