;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24820)
(include sci.sh)
(use Main)
(use n951)

(public
	rm24v820 0
)

(instance rm24v820 of ShiversRoom
	(properties
		picture 24820
	)

	(method (init)
		(proc951_16 56)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 24360
	)

	(method (init)
		(self createPoly: 0 0 262 0 262 143 0 143 0 1)
		(if (== gPrevRoomNum 24420) ; rm24v420
			(= nextRoom 24420)
		)
		(if (== gPrevRoomNum 24330) ; rm24v330
			(= nextRoom 24330)
		)
		(super init: &rest)
	)
)

