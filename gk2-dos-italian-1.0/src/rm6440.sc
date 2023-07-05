;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6440)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)

(public
	rm6440 0
)

(instance rm6440 of ExitRoom
	(properties
		picture 6440
		south 640 ; lairExtRm
	)

	(method (init)
		(super init: &rest)
		(fPawPrint init: createPoly: 189 109 246 80 314 98 297 172 235 168)
		(fOrangeMud init:)
		(gGame handsOn:)
	)
)

(instance fOrangeMud of GKFeature
	(properties
		modNum 600
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				0
				299
				614
				298
				614
				0
				0
				0
				0
				209
				246
				79
				315
				98
				298
				173
				235
				168
				188
				111
				0
				212
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 15 62 0 1 0 600) ; "(LOOK AT ORANGE MUD AT HEDGES IN CH 5, SUSPICOUS)The earth is orange over here. Must be some minerals in the soil."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fPawPrint of GKFeature
	(properties
		modNum 600
		x 140
		y 180
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (or (IsFlag 662) (IsFlag 661)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((IsFlag 658)
					(gMessager say: 18 62 0 1 0 600) ; "(PICKUP, LOOK AT EITHER PRINT IN WOODS AFTER SEEING VON ZELL, SICKENED)I guess I know who made this print!"
				)
				((IsFlag 662)
					(gMessager say: 12 62 0 1 0 600) ; "(FINDS FIRST PAW PRINT IN WOODS)That paw print matches the one I found at the farm!"
				)
				(else
					(SetFlag 662)
					(if (IsFlag 661)
						(gMessager say: 11 62 0 1 0 600) ; "Another autograph by the same big son-of-a-bitch that was at the farm."
					else
						(PlayScene 680)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

