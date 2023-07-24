;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 640)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	lairExtRm 0
)

(instance lairExtRm of ExitRoom
	(properties
		picture 6401
	)

	(method (init)
		(switch gPrevRoomNum
			(635 ; woods8Rm
				(gEgo posn: 173 214 heading: 135)
			)
			(6440
				(gEgo posn: 292 290 heading: 45)
			)
			(else
				(gEgo posn: 292 290 heading: 270)
				(gSoundManager play: 0 600 601)
			)
		)
		(gEgo setScaler: Scaler 73 29 266 149 sel_737: init:)
		(super init: &rest)
		(if (and (== gPrevRoomNum 660) (IsFlag 658)) ; caveMainRm
			(PlayScene 678)
		)
		(fNorthExit init:)
		(fOrangeMud init:)
		(fBriarHedges init:)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 660) ; caveMainRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fOrangeMud of GKFeature
	(properties
		modNum 600
		approachX 342
		approachY 251
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 326 219 375 229 364 243 412 245 447 239 448 229 473 225 466 211 396 202 339 206
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 679)
			(PlayScene 681 0 6440) ; rm6440
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBriarHedges of GKFeature
	(properties
		modNum 600
		approachX 624
		approachY 225
	)

	(method (init)
		(super init: &rest)
		(if (or (IsFlag 658) (and (IsFlag 684) (not (IsFlag 663))))
			(= sightAngle 360)
		)
		(self createPoly: 342 194 342 55 373 0 614 0 614 207 469 208)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 663) (IsFlag 658))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 663)
						(if (IsFlag 658)
							(gMessager say: 7 62 0 1 0 600) ; "(TRY TO ENTER LAIR AFTER SEEING VON ZELL)I'm NOT goin' in there again."
						else
							(PlayScene 683)
							(gCurRoom newRoom: 660) ; caveMainRm
						)
					)
					((IsFlag 684)
						(gMessager say: 16 62 0 1 0 600) ; "(TRY TO GET THROUGH HEDGES BEFORE CUTTING THEM)I'm not makin' much progress against those briars. Not with my bare hands."
					)
					(else
						(SetFlag 684)
						(= sightAngle 360)
						(PlayScene 682)
					)
				)
			)
			(89 ; invShears
				(if (not (IsFlag 663))
					(PlayScene 684)
					(SetFlag 663)
					(gCurRoom newRoom: 660) ; caveMainRm
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)
)

(instance fNorthExit of ExitFeature
	(properties
		BAD_SELECTOR 0
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 257 190 266 0 0 0 0 189)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 635) ; woods8Rm
		else
			(super doVerb: &rest)
		)
	)
)

