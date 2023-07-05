;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	hallRm 0
)

(instance hallRm of ExitRoom ; "Hunting Lodge: Upstairs Hall"
	(properties
		modNum 530
		noun 10
		picture 5301
		south 520 ; greatRm
	)

	(method (init)
		(switch gPrevRoomNum
			(540 ; gabeRm
				(gEgo posn: 261 286 heading: 180)
			)
			(543 ; priessRm
				(gEgo posn: 300 286 heading: 180)
			)
			(else
				(gEgo posn: 287 379 heading: 45)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 90 49 358 277 init:)
		(super init: &rest)
		(if (not (IsFlag 660))
			(SetFlag 660)
			(PlayScene 625)
		)
		(fKlingmannDoor init:)
		(fVonAignerDoor init:)
		(fGabrielDoor init:)
		(fPriessDoor init:)
		(fVonZellDoor init:)
		(fVonGlowerDoor init:)
		(gGame handsOn:)
	)
)

(instance fKlingmannDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 66
		approachY 412
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 34 300 98 300 98 14 80 0 34 0)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 658) (IsFlag 657)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 658)
					(gMessager say: 6 62) ; "(CLICK ON KLINGMANN'S DOOR AFTER SEEING VON ZELL IN PIT)Klingmann's terrified of von Zell. He'd be worse than useless."
				)
				((IsFlag 657)
					(gMessager say: 5 62) ; "(CLICK ON KLINGMANN'S DOOR AFTER SHOWING HIM TAGS, FAINT DISGUST)Herr Doktor doesn't have anything else interesting to share with me. I'll leave him alone... for a while."
				)
				(else
					(PlayScene 2626 0 542) ; klingRm
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fVonAignerDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 203
		approachY 352
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 166 304 192 304 192 103 166 86)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or (IsFlag 658) (IsFlag 656) (IsFlag 63))
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 658)
					(gMessager say: 9 62) ; "(CLICK ON VON AIGNER'S DOOR AFTER SEEING VON ZELL IN BODY PIT)I'm not sure Von Aigner can be trusted."
				)
				((or (IsFlag 656) (IsFlag 63))
					(gMessager say: 8 62) ; "(CLICK ON VON AIGNER'S DOOR AFTER FINISHING DIALOUGE IN BATH, DRY)I don't think Herr von Aigner wants to see me right now."
				)
				((> (gEgo y:) 350)
					(PlayScene 3626 0 545) ; vaRm
				)
				(else
					(PlayScene 5626 0 545) ; vaRm
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fGabrielDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 260
		approachY 286
		BAD_SELECTOR 4626
		BAD_SELECTOR 540
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 216 283 232 264 232 132 216 127)
	)
)

(instance fPriessDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 326
		approachY 275
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 354 283 338 266 338 124 354 132)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (gEgo has: 52)) ; invGrossbergLetter
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (and (gEgo has: 52) (IsFlag 685)) ; invGrossbergLetter
				(if (IsFlag 658)
					(gMessager say: 3 62) ; "(CLICK ON PREISS'S DOOR AFTER SEEING VON ZELL IN PIT)Preiss and Hennemann wouldn't be much help."
				else
					(gMessager say: 2 62) ; "(TRY TO REENTER PREISS ROOM, WRY)I've done all I care to in Preiss's room."
				)
			else
				(PlayScene 1626 0 543) ; priessRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fVonZellDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 370
		approachY 346
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 378 304 408 304 408 74 378 105)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 11 62) ; "(HUNTING LODGE UPSTAIRS, CLICK ON VON ZELL'S DOOR)It's no use. I saw him lock it myself."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fVonGlowerDoor of ExitFeature
	(properties
		sightAngle 360
		approachX 446
		approachY 419
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 472 300 540 300 540 0 490 0 472 16)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 658)
				(gCurRoom newRoom: 544) ; vgRm
			else
				(PlayScene 626 0 544) ; vgRm
				(gCurRoom newRoom: 544) ; vgRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

