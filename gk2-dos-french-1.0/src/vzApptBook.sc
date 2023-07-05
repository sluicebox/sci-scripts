;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56513)
(include sci.sh)
(use n011)
(use northExit)
(use Feature)

(public
	vzApptBook 0
)

(instance vzApptBook of ExitRoom
	(properties
		modNum 546
		picture 56513
		south 56511 ; vzNightStand
	)

	(method (init)
		(super init: &rest)
		(fGrossLetter init:)
		(fPages init:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 56511) ; vzNightStand
			(PlayScene 1667)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fPages of GKFeature
	(properties
		noun 2
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 188 59 541 35 567 332 212 332)
	)
)

(instance fGrossLetter of GKFeature
	(properties
		modNum 546
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 570 137 605 137 604 332 578 332)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 668 0 56514) ; vzLetter
		else
			(super doVerb: theVerb)
		)
	)
)

