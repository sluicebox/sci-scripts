;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26180)
(include sci.sh)
(use Main)
(use n951)

(public
	rm26v180 0
)

(instance rm26v180 of ShiversRoom
	(properties
		picture 26180
	)

	(method (init)
		(if (== gPrevRoomNum 26130) ; rm26v130
			(proc951_7 22601)
			(proc951_9 22601)
			(gSounds play: 22601 -1 0 0)
			(gSounds fade: 22601 106 4 15 0 0)
		)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 26160
	)

	(method (init)
		(self createPoly: 0 0 40 0 40 144 0 144 0 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 26190
	)

	(method (init)
		(self createPoly: 220 0 262 0 262 144 220 144 220 0)
		(super init: &rest)
	)
)

