;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use System)

(public
	dornExtRm 0
)

(instance dornExtRm of ExitRoom
	(properties
		picture 2501
		south 200 ; MunichMapRm
	)

	(method (init)
		(if (== gPrevRoomNum 260) ; dornIntRm
			(gEgo
				posn: 254 276
				heading: 135
				sel_737:
				setScaler: Scaler 90 37 369 245
				init:
			)
		else
			(gEgo
				posn: 406 306
				heading: 315
				sel_737:
				setScaler: Scaler 90 37 369 245
				init:
			)
		)
		(super init: &rest)
		(Lock 140 250 1) ; WAVE
		(gGk2Music setLoop: -1 number: 250 play:)
		(fFrontDoor init:)
		(gGame handsOn: 0)
	)

	(method (newRoom newRoomNumber)
		(if (OneOf newRoomNumber 260 200) ; dornIntRm, MunichMapRm
			(Lock 140 250 0) ; WAVE
			(gGk2Music stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fFrontDoor of Feature
	(properties
		nsLeft 140
		nsTop 134
		nsRight 194
		nsBottom 244
		sightAngle 40
		approachX 166
		approachY 189
		x 166
		y 189
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 341)
				(if (IsFlag 687)
					(Lock 140 250 0) ; WAVE
					(gGk2Music stop:)
					(PlayScene 582 0 260) ; dornIntRm
				else
					(PlayScene 581 0 2502) ; dornEntryRm
				)
			else
				(PlayScene 580)
				(SetFlag 341)
			)
		)
	)
)

