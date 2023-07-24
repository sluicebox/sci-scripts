;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3112)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v112 0
)

(local
	local0
)

(instance rm3v112 of ShiversRoom
	(properties
		picture 3112
	)

	(method (init)
		(proc951_16 130)
		(= local0 3112)
		(efExitBack init: 8)
		(hsLeftPage init:)
		(hsRightPage init:)
		(gSounds play: 10616 0 40 0)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds play: 10617 0 40 0)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 3111
	)

	(method (init)
		(self
			createPoly: 0 0 20 10 243 10 243 133 20 133 20 11 0 1 0 143 263 143 263 0
		)
		(super init: &rest)
	)
)

(instance hsLeftPage of HotSpot
	(properties
		nsLeft 20
		nsTop 10
		nsRight 131
		nsBottom 133
	)

	(method (doVerb)
		(if (<= 3112 (-- local0) 3117)
			(gCurRoom drawPic: local0)
			(gSounds stop: 10607)
			(gSounds play: 10607 0 32 0)
		else
			(gCurRoom newRoom: 3111) ; rm3v111
		)
	)
)

(instance hsRightPage of HotSpot
	(properties
		nsLeft 132
		nsTop 10
		nsRight 243
		nsBottom 133
	)

	(method (doVerb)
		(if (<= 3112 (++ local0) 3117)
			(gCurRoom drawPic: local0)
			(gSounds stop: 10606)
			(gSounds play: 10606 0 32 0)
		else
			(gCurRoom newRoom: 3111) ; rm3v111
		)
	)
)

