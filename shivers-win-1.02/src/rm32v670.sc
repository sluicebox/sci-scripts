;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32670)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v670 0
)

(instance rm32v670 of ShiversRoom
	(properties
		picture 32670
	)

	(method (init)
		(if (== gPrevRoomNum 32520) ; rm32v520
			(ClearFlag 43)
			(gSounds play: 13202 0 82 0)
		)
		(if (and (IsFlag 43) (== gPrevRoomNum 32450)) ; rm32v450
			(gSounds play: 13218 0 82 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32450
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32230
	)
)

