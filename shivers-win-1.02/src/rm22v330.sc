;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22330)
(include sci.sh)
(use Main)

(public
	rm22v330 0
)

(instance rm22v330 of ShiversRoom
	(properties
		picture 22330
	)

	(method (init)
		(efExitForward init: 3)
		(efExitDoor init: 3)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 22320
	)

	(method (init)
		(self createPoly: 0 0 20 0 20 44 18 44 9 58 6 109 20 109 20 143 0 143)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 22340
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 22140
	)

	(method (init)
		(self
			createPoly: 203 0 124 43 135 113 153 120 191 126 239 132 230 0 203 0
		)
		(super init: &rest)
	)
)

(instance efExitDoor of ExitFeature
	(properties
		nextRoom 22080
	)

	(method (init)
		(self createPoly: 46 109 6 109 9 58 18 44 30 44 41 60)
		(super init: &rest)
	)
)

