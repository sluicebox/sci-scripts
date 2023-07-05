;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12270)
(include sci.sh)
(use Main)

(public
	rm12v27 0
)

(instance rm12v27 of ShiversRoom
	(properties
		picture 12270
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12310
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12290
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 240 0 262 0 262 144 240 144 240 0)
		(if (== gPrevRoomNum 12290) ; rm12v29
			(= nextRoom 12290)
		)
		(if (== gPrevRoomNum 12330) ; rm12v33
			(= nextRoom 12330)
		)
	)
)

