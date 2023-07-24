;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8180)
(include sci.sh)
(use Main)

(public
	rm8v180 0
)

(instance rm8v180 of ShiversRoom
	(properties)

	(method (init)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
		(if 1
			(= picture 8180)
		else
			(= picture 8190)
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 8220
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 8200
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 8280
	)

	(method (init)
		(self
			createPoly: 56 139 104 140 116 128 111 0 147 0 147 117 159 142 53 142
		)
		(super init: &rest)
	)
)

