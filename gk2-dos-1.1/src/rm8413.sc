;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 8413)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	rm8413 0
)

(instance rm8413 of ExitRoom
	(properties
		picture 8413
		east 840 ; starnSeeRm
		south 840 ; starnSeeRm
	)

	(method (init)
		(super init: &rest)
		(water init:)
		(if (IsFlag 617)
			(lily init:)
		)
	)

	(method (newRoom newRoomNumber)
		(gSoundManager stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance water of GKFeature
	(properties
		nsTop 19
		nsRight 240
		nsBottom 333
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; invLily
				(SetFlag 617)
				(PlayScene 501 0 840) ; starnSeeRm
				(lily init:)
				(gEgo put: 45) ; invLily
			)
			(62 ; Do
				(= noun (if (IsFlag 617) 17 else 16))
				(gMessager say: noun 62 0 0 0 840)
			)
			(else
				(= noun
					(cond
						((IsFlag 617) 22)
						((IsFlag 603) 21)
						(else 22)
					)
				)
				(gMessager say: noun 62 0 0 0 840)
			)
		)
	)
)

(instance lily of View
	(properties
		sightAngle 360
		x 200
		y 252
		view 30501
	)
)

