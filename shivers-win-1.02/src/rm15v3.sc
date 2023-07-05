;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15030)
(include sci.sh)
(use Main)
(use n951)

(public
	rm15v3 0
)

(instance rm15v3 of ShiversRoom
	(properties
		picture 15030
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(if (< 14000 gPrevRoomNum 15000)
			(proc951_7 21303)
			(gSounds play: 21303 -1 0 0)
			(gSounds fade: 21303 18 15 6 0 0)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 15040
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 15010
	)
)

