;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10310)
(include sci.sh)
(use Main)
(use n951)

(public
	rm10v310 0
)

(instance rm10v310 of ShiversRoom
	(properties
		picture 10310
	)

	(method (init)
		(if (IsFlag 43)
			(gSounds play: 13911 0 82 0)
			(ClearFlag 43)
		)
		(super init: &rest)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitForward init: 3)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 10290
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 10300
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 10320
	)

	(method (init)
		(self
			createPoly: 81 136 104 102 97 92 91 68 101 47 112 41 139 40 155 42 170 56 175 67 175 80 170 93 160 102 182 135
		)
		(super init: &rest)
	)
)

