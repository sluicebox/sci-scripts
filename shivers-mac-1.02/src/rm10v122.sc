;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10122)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v122 0
)

(instance rm10v122 of ShiversRoom
	(properties
		picture 10122
	)

	(method (init)
		(proc951_16 98)
		(super init: &rest)
		(efExitBack init: 8)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 10121
	)

	(method (init)
		(if (== gPrevRoomNum 10500) ; rm10v500
			(= nextRoom 10500)
		)
		(self
			createPoly:
				0
				0
				50
				30
				190
				30
				190
				100
				50
				100
				50
				32
				0
				2
				0
				143
				263
				143
				263
				0
		)
		(super init: &rest)
	)
)

