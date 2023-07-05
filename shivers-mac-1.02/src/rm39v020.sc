;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39020)
(include sci.sh)
(use Main)
(use n951)

(public
	rm39v020 0
)

(instance rm39v020 of ShiversRoom
	(properties
		picture 39020
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 13911 0 82 0)
			(ClearFlag 43)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 39050) ; rm39v050
			(gSounds fade: 23901 58 5 16 0 0)
			(gSounds fade: 23902 26 5 16 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 39030
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 39010
	)
)

(instance efForward of ExitFeature ; UNUSED
	(properties
		nextRoom 39020
	)

	(method (init)
		(self createPoly:)
		(super init: &rest)
	)
)

