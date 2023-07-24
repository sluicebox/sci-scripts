;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20560)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm20v560 0
)

(instance rm20v560 of ShiversRoom
	(properties
		picture 20560
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20561)
		else
			(for ((= temp0 0)) (< temp0 6) ((++ temp0))
				((View new:)
					view: 20560
					loop: temp0
					cel: [global540 temp0]
					setPri: 1 1
					init:
				)
			)
		)
		(if (and (== gPrevRoomNum 20570) (IsFlag 43)) ; rm20v570
			(gSounds play: 12009 0 82 0)
			(ClearFlag 43)
		)
		(efExitForward init: 3)
		(efExitRightU init: 6)
		(efExitLeftU init: 7)
		(efExitRight init: 3)
		(efExitLeft init: 3)
		(super init: &rest)
	)
)

(instance efExitForward of ExitFeature
	(properties
		nextRoom 20550
	)

	(method (init)
		(self createPoly: 66 82 66 124 201 124 201 83 179 79 79 79 67 82)
		(super init: &rest)
	)
)

(instance efExitRightU of ExitFeature
	(properties
		nextRoom 20570
	)

	(method (init)
		(self
			createPoly: 263 0 237 0 237 34 255 34 255 97 239 97 239 142 262 142 262 1
		)
		(super init: &rest)
	)
)

(instance efExitLeftU of ExitFeature
	(properties
		nextRoom 20570
	)

	(method (init)
		(self createPoly: 0 0 0 143 23 143 23 95 10 95 10 35 23 35 23 0 1 0)
		(super init: &rest)
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20470
	)

	(method (init)
		(self
			createPoly: 235 0 203 0 203 142 237 142 237 96 254 96 254 35 236 35 236 0
		)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20610
	)

	(method (init)
		(self createPoly: 26 0 26 36 13 36 13 94 25 94 25 143 61 143 61 0 27 0)
		(super init: &rest)
	)
)

