;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27111)
(include sci.sh)
(use Main)
(use n951)

(public
	rm27v111 0
)

(instance rm27v111 of ShiversRoom
	(properties
		picture 27111
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)

	(method (newRoom)
		(proc951_1 5)
		(super newRoom: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 27102
	)

	(method (init)
		(self
			createPoly: 24 143 92 111 101 80 97 19 170 19 163 111 216 142 26 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 27110
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 27110
	)
)

