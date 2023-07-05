;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13345)
(include sci.sh)
(use Main)
(use n951)

(public
	rm13v345 0
)

(instance rm13v345 of ShiversRoom
	(properties
		picture 13750
	)

	(method (init)
		(efExitLeft init: 7)
		(efExitRight init: 6)
		(efExitForward init: 9)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(proc951_1 3)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 13344
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 13344
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 13343
	)

	(method (init)
		(self createPoly: 58 142 81 126 81 18 167 33 167 112 195 142)
		(super init: &rest)
	)
)

