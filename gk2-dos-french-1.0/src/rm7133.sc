;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7133)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm7133 0
)

(instance rm7133 of ExitRoom
	(properties
		picture 7133
		east 710 ; courtRm
		south 710 ; courtRm
		west 710 ; courtRm
	)

	(method (init)
		(dungeonDoor init:)
		(super init: &rest)
	)
)

(instance dungeonDoor of Feature
	(properties
		nsLeft 254
		nsTop 220
		nsRight 332
		nsBottom 276
		sightAngle 40
		approachX 292
		approachY 283
		x 292
		y 247
	)

	(method (doVerb)
		(if (IsFlag 470)
			(gGk2Music fade:)
			(Lock 140 700 0) ; WAVE
			(gCurRoom newRoom: 720) ; dungeonRm
		else
			(PlayScene 191 0 710) ; courtRm
		)
	)
)

