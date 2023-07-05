;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12230)
(include sci.sh)
(use Main)
(use n951)

(public
	rm12v23 0
)

(instance rm12v23 of ShiversRoom
	(properties
		picture 12230
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
		(if (>= gPrevRoomNum 13000) ; rm13v000
			(proc951_7 21210)
			(proc951_9 21210)
			(gSounds play: 21210 -1 0 0)
			(gSounds fade: 21210 25 10 10 0 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12180
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12250
	)
)

