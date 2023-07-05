;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23550)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)

(public
	rm23v550 0
)

(instance rm23v550 of ShiversRoom
	(properties
		picture 23550
		invView 1
	)

	(method (init &tmp temp0)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(efExitPlaque init: 3)
		(super init: &rest)
		(if (IsFlag 23)
			(vBehindBull init:)
			(self initRoom: 47 69 60 83)
			(psInBull init:)
			(= temp0
				((Prop new:)
					view: 23550
					cycleSpeed: 24
					setPri: 30 1
					init:
					yourself:
				)
			)
			(if (== gPrevRoomNum 23590) ; LyrePuzzleRm
				(temp0 setCycle: End)
				(gSounds play: 12306 0 82 0)
			else
				(temp0 cel: (temp0 lastCel:))
			)
			(UpdateScreenItem temp0)
		)
	)
)

(instance psInBull of PotSpot
	(properties
		nsLeft 47
		nsTop 60
		nsRight 69
		nsBottom 83
	)
)

(instance vBehindBull of View
	(properties
		priority 15
		fixPriority 1
		view 23550
		loop 1
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 23540
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 23570
	)
)

(instance efExitPlaque of ExitFeature
	(properties
		nextRoom 23920
	)

	(method (init)
		(self createPoly: 191 75 218 75 220 84 190 84 191 75)
		(super init: &rest)
	)
)

