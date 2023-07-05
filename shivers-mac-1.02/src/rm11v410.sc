;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11410)
(include sci.sh)
(use Main)
(use n951)

(public
	rm11v410 0
)

(instance rm11v410 of ShiversRoom
	(properties
		picture 11410
	)

	(method (init)
		(proc951_16 26)
		(efBack init: 8)
		(super init: &rest)
	)
)

(instance efBack of ExitFeature
	(properties)

	(method (init)
		(self nextRoom: 11180 createPoly: 0 0 0 143 263 143 263 0 1 0)
		(super init: &rest)
		(if (== gPrevRoomNum 11150) ; rm11v150
			(self nextRoom: 11150)
		)
	)
)

