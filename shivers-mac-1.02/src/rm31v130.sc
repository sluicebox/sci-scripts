;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31130)
(include sci.sh)
(use Main)

(public
	rm31v130 0
)

(instance rm31v130 of ShiversRoom
	(properties
		picture 31130
	)

	(method (init)
		(efExitBack init: 8)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 31420
	)

	(method (init)
		(if (== gPrevRoomNum 31420) ; rm31v420
			(= nextRoom 31420)
		)
		(if (== gPrevRoomNum 31410) ; rm31v410
			(= nextRoom 31410)
		)
		(if (== gPrevRoomNum 31411) ; rm31v411
			(= nextRoom 31411)
		)
		(self createPoly: 5 4 5 137 258 137 258 6 6 4)
		(super init: &rest)
	)
)

