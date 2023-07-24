;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22270)
(include sci.sh)
(use Main)
(use n951)
(use n22001)

(public
	rm22v270 0
)

(instance rm22v270 of ShiversRoom
	(properties
		picture 22270
	)

	(method (init)
		(if (>= gPrevRoomNum 23000)
			(proc951_9 22201)
			(gSounds play: 22201 -1 0 0)
			(gSounds fade: 22201 74 5 16 0 0)
			(proc22001_0)
		)
		(efExitHut init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(efExitForward init: 3)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 2)
		(proc951_1 1)
		(super newRoom: &rest)
	)
)

(instance efExitHut of ExitFeature
	(properties
		nextRoom 22140
	)

	(method (init)
		(self
			createPoly: 267 16 209 52 209 53 212 53 212 105 224 109 242 113 266 115
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22220
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22230
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22160
	)

	(method (init)
		(self createPoly: 89 41 151 41 151 103 163 143 89 143)
		(super init: &rest)
	)
)

