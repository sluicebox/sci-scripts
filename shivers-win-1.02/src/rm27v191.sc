;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27191)
(include sci.sh)
(use Main)

(public
	rm27v191 0
)

(instance rm27v191 of ShiversRoom
	(properties
		picture 27191
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 1)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27181
	)

	(method (init)
		(self createPoly: 91 142 111 41 161 41 161 116 177 142 92 142)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27190
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27192
	)
)

