;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 140)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	srGabeRoom 0
)

(instance srGabeRoom of ExitRoom ; "Schloss Ritter: Gabriel's Bedroom"
	(properties
		noun 20
		picture 1401
		south 1403 ; rm1403
	)

	(method (init)
		(super init: &rest)
		(cond
			((not (IsFlag 480))
				(SetFlag 480)
				(PlayScene 119)
				(man init: setScript: FidgetScript)
			)
			((and (IsFlag 190) (or (IsFlag 155) (IsFlag 156))) 0) ; "Locked door" in srHallTopicRm, "Trial Records" in rm711c2d2, "Trial Records" in rm711c2d2
			(else
				(man init:)
				(rock init:)
			)
		)
		(if (not (OneOf gPrevRoomNum 120 130)) ; srHallRoom, srLibRoom
			(gSoundManager play: 0 123 122 121)
		)
		(if (== gChapter 6)
			(pillows init:)
		)
		(hallDoor init:)
		(fireplace init:)
		(shrank init:)
		(win init:)
		(switch gPrevRoomNum
			(1403
				(gEgo posn: 453 401 heading: 45)
			)
			(120 ; srHallRoom
				(gEgo posn: 486 317 heading: 215)
			)
			(1413
				(gEgo posn: 114 306 heading: 45)
			)
			(1430
				(gEgo posn: 223 274 heading: 45)
			)
			(160 ; srSecretRoom
				(gEgo posn: 320 267 heading: 215)
				(PlayScene 1130)
			)
			(else
				(gEgo posn: 457 316 heading: 215)
			)
		)
		(gEgo normalize: init: setScaler: Scaler 100 49 382 244)
	)
)

(instance pillows of View
	(properties
		modNum 140
		sightAngle 360
		x 159
		y 315
		priority 500
		fixPriority 1
		view 31119
		loop 1
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 775)
				(= noun 16)
				(super doVerb: theVerb)
			else
				(PlayScene 760)
				(SetFlag 775)
				(gEgo get: 61) ; invPillowcase
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance hallDoor of ExitFeature
	(properties
		nsLeft 500
		nsTop 105
		nsRight 568
		nsBottom 242
		approachX 640
		nextRoomNum 120 ; srHallRoom
		exitDir 0
	)
)

(instance win of GKFeature
	(properties
		noun 21
		nsLeft 220
		nsTop 57
		nsRight 298
		nsBottom 172
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)
)

(instance fireplace of GKFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(and (self onMe: event) (== gChapter 6))
				(and (gCast contains: man) (IsFlag 455))
			)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 43 116 177 110 185 294 43 332
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((gCast contains: man)
				(man doVerb: theVerb)
			)
			((== gChapter 6)
				(= noun 25)
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom newRoom: 1413)
			)
		)
	)
)

(instance shrank of GKFeature
	(properties
		x 370
		y 168
	)

	(method (handleEvent event)
		(if (== 6 gChapter)
			(= sightAngle 360)
		else
			(= sightAngle 5)
		)
		(super handleEvent: event)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 341 104 341 225 399 234 398 102
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (== 6 gChapter)
					(gMessager say: 25 62) ; "(PICK UP, CH 6 CLICK ON GABE'S SHRANK OR SECRET PASSAGE, ANXIOUS)There's nothing in the secret passage that can help me now."
				else
					(PlayScene 2130 0 1445) ; srGabeShrank
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rock of View
	(properties
		x 156
		y 315
		view 31119
	)
)

(instance man of Prop
	(properties
		approachX 194
		approachY 650
		x 94
		y 291
		view 20120
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or (IsFlag 455) (!= (event message:) $003e)) ; >
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(cond
			((IsFlag 455)
				(= noun 30)
				(super doVerb: theVerb)
			)
			((== theVerb 62) ; Do
				(gEgo posn: 453 401 heading: 45)
				(SetFlag 455)
				(PlayScene 125)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

