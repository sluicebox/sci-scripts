;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	cavePitRm 0
)

(instance cavePitRm of ExitRoom
	(properties
		picture 6701
	)

	(method (init)
		(gEgo
			posn: 244 223
			heading: 135
			BAD_SELECTOR:
			setScaler: Scaler 71 55 231 199
			init:
		)
		(super init: &rest)
		(fWestExit init:)
		(fPit init:)
		(Lock 140 670 1) ; WAVE
		(gGk2Music setLoop: -1 number: 670 play:)
		(gGame handsOn:)
	)

	(method (dispose)
		(Lock 140 670 0) ; WAVE
		(super dispose:)
	)
)

(instance fWestExit of ExitFeature
	(properties
		sightAngle 360
		BAD_SELECTOR 6
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				86
				57
				66
				71
				89
				115
				91
				145
				137
				182
				198
				217
				198
				10
				151
				22
				134
				35
				95
				47
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(Lock 140 670 0) ; WAVE
			(gGk2Music stop:)
			(PlayScene 7052 0 660) ; caveMainRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fPit of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly:
				253
				245
				336
				225
				578
				220
				614
				232
				614
				287
				590
				285
				573
				302
				541
				307
				531
				313
				510
				320
				492
				332
				331
				332
				331
				277
				301
				268
				294
				253
				280
				253
				270
				247
				262
				249
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 665)
					(gMessager say: 1 62) ; "(CAVE PIT ROOM, CLICK ON PIT AREA AFTER NEARLY FALLING IN)I can't see anything, and I'm not going down in there again in the dark!"
				else
					(PlayScene 703)
					(SetFlag 665)
				)
			)
			(24 ; invLantern
				(gMessager say: 2 24) ; "(CLICK UNLIT LANTERN ON PIT)The lantern won't do much good unless it's lit."
			)
			(21 ; invMatches
				(gMessager say: 4 21) ; "(TRY TO USE MATCHES TO LIGHT UP PIT)Those matches won't throw much light."
			)
			(22 ; invRope
				(gMessager say: 1 62) ; "(CAVE PIT ROOM, CLICK ON PIT AREA AFTER NEARLY FALLING IN)I can't see anything, and I'm not going down in there again in the dark!"
			)
			(else
				(gMessager say: 6 62) ; "(CLICK ON PIT AFTER FALLING IN BUT BEFORE LIGHTING LANTERN, NOT TOO FREAKED YET, JUST SLIGHTLY NERVOUS)I can't see anything down there ... but I hear somethin'. Somethin' down there."
			)
		)
	)
)

