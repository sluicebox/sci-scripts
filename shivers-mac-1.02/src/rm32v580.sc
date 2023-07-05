;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32580)
(include sci.sh)
(use Main)

(public
	rm32v580 0
)

(local
	local0
)

(instance rm32v580 of ShiversRoom
	(properties
		picture 32580
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitUp init: 4)
		(= local0 0)
		(hsNipple init:)
		(super init: &rest)
	)
)

(instance hsNipple of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 236 63 242 63 245 61 245 58 240 57 237 57 235 59 235 62
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (> local0 2)
			(gSounds play: 35131 0 90 0)
			(= local0 0)
		else
			(++ local0)
		)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32570
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 32570
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 32071
	)

	(method (init)
		(self createPoly: 84 140 95 53 84 0 208 0 201 58 216 142)
		(super init: &rest)
	)
)

