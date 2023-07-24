;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1002)
(include sci.sh)
(use Main)
(use n951)

(public
	rm1v02 0
)

(instance rm1v02 of ShiversRoom
	(properties
		picture 1002
	)

	(method (init)
		(efExitLetter init: 3)
		(efExitUp init: 4)
		(super init: &rest)
		(if (== gPrevRoomNum 1003) ; rm1v03
			(gSounds play: 10621 0 82 0)
		)
		(if (IsFlag 43)
			(ClearFlag 43)
			(proc951_9 10128)
			(gSounds play: 10128 0 82 0)
		)
	)
)

(instance efExitUp of ExitFeature
	(properties
		nextRoom 1000
	)

	(method (init)
		(self
			createPoly: 1 1 189 1 189 82 135 116 178 128 223 94 190 84 190 1 262 1 262 141 1 141
		)
		(super init: &rest)
	)
)

(instance efExitLetter of ExitFeature
	(properties
		nextRoom 1003
	)

	(method (init)
		(self createPoly: 190 85 139 115 179 127 219 94)
		(super init: &rest)
	)
)

