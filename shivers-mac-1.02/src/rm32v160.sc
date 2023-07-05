;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32160)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v160 0
)

(local
	local0
)

(instance rm32v160 of ShiversRoom
	(properties
		picture 32160
	)

	(method (init)
		(if (IsFlag 72)
			(efExitForward init: 3)
		)
		(if (IsFlag 73)
			(= picture 32164)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(= local0 0)
		(hsHead init:)
		(super init: &rest)
	)
)

(instance hsHead of HotSpot
	(properties)

	(method (init)
		(self createPoly: 10 37 8 39 31 40 31 20 27 16 17 16 12 22 14 27 10 36)
		(super init: &rest)
	)

	(method (doVerb)
		(if (and (== (++ local0) 2) (IsFlag 73))
			(gSounds play: 35121 0 90 0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32150
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32170
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 32161
	)

	(method (init)
		(self createPoly: 143 123 143 17 187 17 184 123 143 123)
		(super init: &rest)
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 32800
	)

	(method (init)
		(self createPoly: 77 82 97 80 102 92 102 122 81 124 76 122 76 82)
		(super init: &rest)
	)
)

