;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22040)
(include sci.sh)
(use Main)

(public
	rm22v040 0
)

(instance rm22v040 of ShiversRoom
	(properties
		picture 22040
	)

	(method (init)
		(efExitForward init: 3)
		(efExitRight init: 6)
		(efExitLeft init: 7)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22050
	)

	(method (init)
		(self
			createPoly: 24 142 200 142 198 86 193 55 191 41 36 41 25 91 24 142
		)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22030
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22030
	)
)

