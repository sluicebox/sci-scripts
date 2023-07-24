;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3111)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v111 0
)

(instance rm3v111 of ShiversRoom
	(properties
		picture 3111
	)

	(method (init)
		(if (== gPrevRoomNum 3110) ; rm3v110
			(gSounds play: 10321 0 90 0)
		)
		(efBook init: 0)
		(efExit init: 8)
		(super init: &rest)
		(SetFlag 4)
		(if (IsFlag 45)
			(efExit nextRoom: 991)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 3110) ; rm3v110
			(gSounds play: 10322 0 90 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efBook of ExitFeature
	(properties
		nextRoom 3112
	)

	(method (init)
		(self createPoly: 79 134 79 6 183 6 184 134)
		(super init: &rest)
	)
)

(instance efExit of ExitFeature
	(properties
		nextRoom 3110
	)

	(method (init)
		(self
			createPoly: 79 134 79 6 183 6 184 134 0 134 0 143 263 143 263 0 0 0 0 134
		)
		(super init: &rest)
	)
)

