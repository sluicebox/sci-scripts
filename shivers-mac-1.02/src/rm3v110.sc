;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3110)
(include sci.sh)
(use Main)
(use n951)

(public
	rm3v110 0
)

(local
	local0
)

(instance rm3v110 of ShiversRoom
	(properties
		picture 3110
	)

	(method (init)
		(proc951_16 140)
		(efBook init: 0)
		(efExit init: 8)
		(= local0 0)
		(hsSymbol init:)
		(hsHat init:)
		(super init: &rest)
	)
)

(instance hsSymbol of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 221 82 212 91 211 97 219 102 231 105 246 101 250 93 222 82
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (or (== local0 0) (== local0 2))
			(++ local0)
		else
			(= local0 0)
		)
	)
)

(instance hsHat of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 30 61 49 60 60 55 65 46 53 41 42 37 31 40 27 46 24 49 21 50 24 58 30 60
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (or (== local0 1) (== local0 3))
			(++ local0)
		else
			(= local0 0)
		)
		(if (== local0 4)
			(gSounds play: 35120 0 90 0)
		)
	)
)

(instance efBook of ExitFeature
	(properties
		nextRoom 3111
	)

	(method (init)
		(self createPoly: 97 63 89 47 110 40 120 57)
		(super init: &rest)
	)
)

(instance efExit of ExitFeature
	(properties
		nextRoom 3100
	)

	(method (init)
		(self
			createPoly: 0 0 263 0 263 132 237 132 237 110 249 104 254 96 248 89 201 65 134 43 76 26 37 26 23 30 13 44 13 49 17 58 21 64 108 142 3 142 0 0
		)
		(super init: &rest)
	)
)

