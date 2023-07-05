;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20920)
(include sci.sh)
(use Main)
(use n951)

(public
	rm20v920 0
)

(instance rm20v920 of ShiversRoom
	(properties
		picture 20920
	)

	(method (init)
		(proc951_16 37)
		(efExitBack init: 8)
		(super init: &rest)
		(if (and (== gPrevRoomNum 20570) (IsFlag 43)) ; rm20v570
			(gSounds play: 12009 0 82 0)
			(ClearFlag 43)
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 20810
	)

	(method (init)
		(if (== gPrevRoomNum 20570) ; rm20v570
			(= nextRoom 20570)
		)
		(if (== gPrevRoomNum 20530) ; rm20v530
			(= nextRoom 20530)
		)
		(if (== gPrevRoomNum 20810) ; rm20v810
			(= nextRoom 20810)
		)
		(self createPoly: 0 0 263 0 263 143 0 143 0 1)
		(super init: &rest)
	)
)

