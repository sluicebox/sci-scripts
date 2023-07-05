;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	greatRm 0
)

(instance greatRm of ExitRoom ; "Hunting Lodge: Great Room"
	(properties
		noun 6
		picture 5201
	)

	(method (init)
		(switch gPrevRoomNum
			(500 ; lodgeExtRm
				(gEgo posn: 307 250 heading: 225)
			)
			(else
				(gEgo posn: 227 336 heading: 45)
			)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 83 40 332 235 init:)
		(super init: &rest)
		(if (== gPrevRoomNum 500) ; lodgeExtRm
			(gSoundManager play: 520 521 522 523 524)
		)
		(if (and (not (IsFlag 8)) (== gPrevRoomNum 5211))
			(gMessager say: 14 62 0 1 0 520) ; "(CLICK ON HENNEMANN - OTHER TIMES - ALL DIALOGUE EXHAUSTED)I think Herr Hennemann has already spilled everythin' of consequence."
		)
		(if (not (IsFlag 658))
			(pHennemann init: setPri: 250 setScript: sHennemannFidgets)
		)
		(fStairs init:)
		(fShrank init:)
		(fFrontDoor init:)
		(fBar init:)
		(fFireplace init:)
		(if (IsFlag 63)
			(SetFlag 656)
		)
		(if
			(and
				(IsFlag 655)
				(IsFlag 656)
				(gEgo has: 52) ; invGrossbergLetter
				(IsFlag 685)
				(not (IsFlag 658))
				(IsFlag 657)
			)
			(pFire init: setCycle: Fwd)
			(SetFlag 659)
		)
		(if (== gPrevRoomNum 530) ; hallRm
			(if (gCast contains: pHennemann)
				(PlayScene 2608)
			else
				(PlayScene 3608)
			)
			(gGame handsOn:)
		else
			(gGame handsOn:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 500) ; lodgeExtRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance pHennemann of Prop
	(properties
		approachX 156
		approachY 250
		x 171
		y 156
		view 20607
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (proc11_15 5211)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 62) (proc11_15 5211)) ; Do
			(if (not (IsFlag 654))
				(SetFlag 654)
				(PlayScene 612 0 5211) ; rm5211
			else
				(gCurRoom newRoom: 5211)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pFire of Prop
	(properties
		sightAngle 360
		x 528
		y 282
		view 20520
	)

	(method (doVerb theVerb)
		(fFireplace doVerb: theVerb)
	)
)

(instance fShrank of GKFeature
	(properties)

	(method (init)
		(super init:)
		(self createPoly: 10 98 92 100 92 276 12 280)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (or (gEgo has: 50) (IsFlag 658)) ; invLantern
				(PlayScene 1609 0 5214) ; rm5214
			else
				(PlayScene 609 0 5214) ; rm5214
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fStairs of ExitFeature
	(properties
		approachX 238
		approachY 220
		BAD_SELECTOR 608
		BAD_SELECTOR 6
	)

	(method (init)
		(super init:)
		(self createPoly: 106 33 164 33 164 180 106 148)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (gCast contains: pHennemann)
				(PlayScene 608 0 530) ; hallRm
			else
				(PlayScene 1608 0 530) ; hallRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFrontDoor of ExitFeature
	(properties
		approachX 300
		approachY 227
		BAD_SELECTOR 0
	)

	(method (init)
		(super init:)
		(self createPoly: 282 228 280 120 324 120 322 223)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 500) ; lodgeExtRm
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBar of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init:)
		(self createPoly: 108 177 176 187 164 259 108 261)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE GREAT ROOM, CLICK ON BAR)I wouldn't mind a drink, but I have a feelin' I should stay alert."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFireplace of GKFeature
	(properties
		approachX 640
		approachY 274
	)

	(method (init)
		(super init:)
		(self createPoly: 502 232 518 103 614 103 614 302 502 271)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 5212)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance sHennemannFidgets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(pHennemann cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

