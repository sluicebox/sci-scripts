;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15120)
(include sci.sh)
(use Main)
(use n951)

(public
	rm15v12 0
)

(instance rm15v12 of ShiversRoom
	(properties
		picture 15120
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(if (== gPrevRoomNum 15150) ; rm15v15
			(gSounds fade: 21501 0 15 8 1 0)
			(proc951_7 21303)
			(gSounds play: 21303 -1 0 0)
			(gSounds fade: 21303 18 15 6 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15140
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15110
	)
)

