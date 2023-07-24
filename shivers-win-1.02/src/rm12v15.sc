;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 12150)
(include sci.sh)
(use Main)

(public
	rm12v15 0
)

(local
	local0
	local1
)

(instance rm12v15 of ShiversRoom
	(properties
		picture 12150
	)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efPlaque init: 3)
		(efGlobe init: 0)
		(= local0 0)
		(= local1 (Random 5 15))
		(hsPoseidon init:)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 12420
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 12110
	)
)

(instance efPlaque of ExitFeature
	(properties
		nextRoom 12550
	)

	(method (init)
		(self createPoly: 20 126 38 107 50 102 65 102 72 107 53 131)
		(super init: &rest)
	)
)

(instance efGlobe of ExitFeature
	(properties
		nextRoom 12600
	)

	(method (init)
		(self
			createPoly: 147 91 137 91 130 87 127 83 124 77 124 72 130 65 140 61 147 61 156 65 161 72 162 81 159 85 154 90
		)
		(super init: &rest)
	)
)

(instance hsPoseidon of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 125 50 119 45 118 37 118 25 124 21 134 21 141 24 143 33 141 38 134 44 131 50
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== local0 local1)
			(gSounds play: 35107 0 122 0)
			(= local0 0)
			(= local1 (Random 5 15))
		else
			(++ local0)
		)
	)
)

