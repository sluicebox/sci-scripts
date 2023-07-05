;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	lodgeExtRm 0
)

(instance lodgeExtRm of ExitRoom ; "Hunting Lodge: Exterior"
	(properties
		modNum 500
		noun 3
		picture 5001
		east 620 ; woods5Rm
		west 605 ; woods2Rm
	)

	(method (init)
		(switch gPrevRoomNum
			(5111 ; stableWall
				(Lock 140 510 0) ; WAVE
				(gEgo posn: 525 260 heading: 225)
			)
			(510 ; stableRm
				(Lock 140 510 0) ; WAVE
				(gEgo posn: 525 260 heading: 225)
			)
			(620 ; woods5Rm
				(gEgo posn: 525 330 heading: 270)
			)
			(else
				(gEgo posn: 221 328 heading: 45)
			)
		)
		(gEgo normalize: setScaler: Scaler 45 28 286 238 init:)
		(super init: &rest)
		(Lock 140 250 1) ; WAVE
		(gGk2Music setLoop: -1 number: 250 play:)
		(if (== gPrevRoomNum 430) ; clubFrontRm
			(SetFlag 680)
			(PlayScene 606 0 540) ; gabeRm
		)
		(fLodgeDoor init:)
		(fStable init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(gGk2Music stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance fLodgeDoor of ExitFeature
	(properties
		approachX 293
		approachY 252
		nextRoomNum 520 ; greatRm
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 260 143 305 144 306 239 262 247)
	)
)

(instance fStable of ExitFeature
	(properties
		approachX 542
		approachY 239
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 482 152 581 146 582 232 482 232)
	)

	(method (doVerb)
		(if (not (gEgo has: 53)) ; invShears
			(PlayScene 1605 0 510) ; stableRm
		else
			(gCurRoom newRoom: 510) ; stableRm
		)
	)
)

