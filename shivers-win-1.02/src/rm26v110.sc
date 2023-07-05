;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v110 0
)

(instance rm26v110 of ShiversRoom
	(properties
		picture 26110
	)

	(method (init)
		(if (== gPrevRoomNum 26160) ; rm26v160
			(proc951_7 22602)
			(proc951_9 22602)
			(gSounds play: 22602 -1 0 0)
			(gSounds fade: 22602 106 4 15 0 0)
		)
		(efExitLeft init: 2)
		(efExitRight init: 6)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26100
	)

	(method (init)
		(self createPoly: 0 0 60 0 60 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26130
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

