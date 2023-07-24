;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1130)
(include sci.sh)
(use Main)

(public
	rm1v130 0
)

(instance rm1v130 of ShiversRoom
	(properties
		picture 1130
	)

	(method (init)
		(gSounds fade: 10124 0 1 40 1 0)
		(efExitLeft init: 7)
		(efExitRight init: 1)
		(efExitForward init: 9)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 1131
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 1125
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 1140
	)

	(method (init)
		(self
			createPoly: 98 133 145 133 134 108 173 92 185 94 235 94 248 45 209 20 174 43 178 71 165 83 100 100 98 132
		)
		(super init: &rest)
	)
)

