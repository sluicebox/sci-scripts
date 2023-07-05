;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27214)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v214 0
)

(instance rm27v214 of ShiversRoom
	(properties
		picture 27214
	)

	(method (init)
		(if (== gPrevRoomNum 34010) ; rm34v010
			(proc951_7 22701)
			(proc951_9 22701)
			(gSounds play: 22701 -1 98 0)
			(if (IsFlag 6)
				(gSounds play: 10407 0 90 0)
			else
				(gSounds play: 10503 0 90 0)
			)
		)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nsLeft 210
		nextRoom 27213
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nsRight 50
		nextRoom 27210
	)
)

