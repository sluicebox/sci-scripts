;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 545)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Cursor)
(use Actor)
(use System)

(public
	vaRm 0
)

(instance vaRm of ExitRoom ; "Hunting Lodge: Von Aigner's Bedroom"
	(properties
		modNum 545
		noun 2
		picture 5601
	)

	(method (init)
		(super init: &rest)
		(cond
			((not (IsFlag 675))
				(SetFlag 675)
				(PlayScene 650)
			)
			((== gPrevRoomNum 530) ; hallRm
				(PlayScene 651)
			)
		)
		(fixEgo doit:)
		(fDoor init:)
		(fBed init:)
		(fShrank init:)
		(aVonAigner init: setScript: FidgetScript)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 530) ; hallRm
			(PlayScene 653)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance fDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 552
		approachY 272
		exitDir 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 526 62 609 51 609 287 527 269)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 530) ; hallRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBed of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 13 280 315 238 585 344)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE VON AIGNER'S ROOM, CLICK ON SHRANK, BED, ETC.)I can't examine anythin' with von Aigner sittin' right there."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fShrank of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 231 49 371 59 370 237 232 243)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE VON AIGNER'S ROOM, CLICK ON SHRANK, BED, ETC.)I can't examine anythin' with von Aigner sittin' right there."
		else
			(super doVerb: &rest)
		)
	)
)

(instance aVonAigner of Prop
	(properties
		sightAngle 360
		x 122
		y 155
		view 5601
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 5631) ; hlVonAignerTub
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (init)
		(super init: &rest)
		(if (IsFlag 63)
			(GKHotCursor delete: self)
		)
	)
)

(instance fixEgo of Code
	(properties)

	(method (doit)
		(gEgo
			view: 20652
			setScale: 0
			posn: 146 276
			init:
			setScript: (FidgetScript new:)
		)
	)
)

