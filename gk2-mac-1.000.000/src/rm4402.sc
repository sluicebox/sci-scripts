;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4402)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm4402 0
)

(instance rm4402 of ExitRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4402
	)

	(method (init)
		(if (and (IsFlag 54) (== gChapter 3))
			(= west 430)
		else
			(= west 440)
		)
		(gEgo
			posn: 460 235
			heading: 225
			normalize:
			setScaler: Scaler 70 45 320 236
			init:
		)
		(super init: &rest)
		(if (== gPrevRoomNum 430) ; clubFrontRm
			(gSoundManager play: 0 430 431 432)
		)
		(fCouches init:)
		(cond
			((!= gChapter 3)
				(fMagazine init:)
			)
			(
				(and
					(or (IsFlag 509) (IsFlag 271)) ; "Just wanted to put back this magazine." in rm4450
					(IsFlag 266) ; "What were y'all talking about a minute ago?" in rm4430
					(IsFlag 265) ; "Have you guys heard about the wolf killing last night?" in rm4430
				)
				(gSoundManager stop:)
				(PlayScene 322 0 12) ; endChapter
			)
			((and (IsFlag 524) (IsFlag 525) (not (IsFlag 53)))
				(pVonZell init: setScript: (FidgetScript new:))
				(if (not (IsFlag 505))
					(SetFlag 505)
					(gSoundManager pauseAll: 1)
					(PlayScene 276)
					(gSoundManager play: 0 430 431 432)
				)
			)
			((IsFlag 54)
				(pMVonZell init: setScript: (FidgetScript new:))
				(pMKlingmann init: setScript: (FidgetScript new:))
				(pMVonGlower init: setScript: (FidgetScript new:))
				(pMPreiss init: setScript: (FidgetScript new:))
				(pMVonAigerHennemann init: setScript: (FidgetScript new:))
				(if (not (IsFlag 504))
					(SetFlag 504)
					(PlayScene 305)
				)
			)
			(
				(and
					(IsFlag 546)
					(IsFlag 53)
					(IsFlag 515)
					(IsFlag 50)
					(IsFlag 245) ; "Missing Persons" in rm4220b
					(IsFlag 949)
				)
				(cond
					((and (not (IsFlag 506)) (== gPrevRoomNum 430)) ; clubFrontRm
						(SetFlag 506)
						(gSoundManager pauseAll: 1)
						(PlayScene 289)
						(pPreiss init: setScript: (FidgetScript new:))
					)
					((IsFlag 506)
						(pPreiss init: setScript: (FidgetScript new:))
					)
				)
				(gGame handsOn:)
			)
			(else
				(fMagazine init:)
			)
		)
		(fDeerHead init:)
		(fFirePlace init:)
		(fBar init:)
		(fBackHall init:)
		(gGame handsOn:)
	)
)

(instance pVonZell of Prop
	(properties
		modNum 440
		x 195
		y 210
		view 22277
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 278 0 4420) ; rm4420
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pPreiss of Prop
	(properties
		modNum 440
		x 217
		y 199
		view 22289
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 290 0 4421) ; rm4421
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pMVonZell of Prop
	(properties
		modNum 440
		x 161
		y 210
		view 27305
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(IsFlag 509)
					(IsFlag 271) ; "Just wanted to put back this magazine." in rm4450
					(and
						(IsFlag 267) ; "Hey, how's it going?" in rm4450
						(IsFlag 269) ; "What're you two kids talking about?" in rm4450
						(IsFlag 270) ; "Just wanted to grab a magazine." in rm4450
						(not (gEgo has: 76)) ; invMagWithRecorder
					)
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					(
						(and
							(IsFlag 267) ; "Hey, how's it going?" in rm4450
							(IsFlag 269) ; "What're you two kids talking about?" in rm4450
							(IsFlag 270) ; "Just wanted to grab a magazine." in rm4450
							(not (gEgo has: 76)) ; invMagWithRecorder
						)
						(gMessager say: 38 62 0 0 0 440) ; "(PICKUKP, TRY TO TALK TO VON ZELL/KLINGMANN AFTER PICKING UP MAGAZINE AND BEFORE PLANTING TAPE RECORDER)It IS a hoot to pester them, but I'm kinda runnin' out of reasons. Maybe I should wait until I have somethin' meaningful to say."
					)
					((or (IsFlag 509) (IsFlag 271)) ; "Just wanted to put back this magazine." in rm4450
						(gMessager say: 3 62 0 0 0 440) ; "(TRY TO TALK TO VON ZELL/KLINGMANN AFTER PLANTING TAPE RECORDER)I don't want to bother them now. I WANT them to keep talking."
					)
					(else
						(PlayScene 315 0 4450) ; rm4450
					)
				)
			)
			(116 ; invMagWithRecorder
				(if (and (IsFlag 266) (IsFlag 265)) ; "What were y'all talking about a minute ago?" in rm4430, "Have you guys heard about the wolf killing last night?" in rm4430
					(gSoundManager stop:)
					(PlayScene 321 0 -1)
					(PlayScene 322 0 12) ; endChapter
				else
					(PlayScene 321)
				)
			)
			(40 ; invTapeRecorder
				(if (IsFlag 548)
					(gMessager say: 4 40 0 0 0 440) ; "(CLICK TAPE RECORDER ON VON ZELL/KLINGMANN WITHOUT HIDING IT IN MAGAZINE FIRST)I'd LOVE to record what they're saying, but every time I get close they clam up!"
				else
					(gMessager say: 33 40 0 0 0 440) ; "(TRY TO USE TAPE RECODER ON KLINGMANN/VON ZELL AT CLUB MTG CH 3)That's a thought, but I'd have to get closer."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pMKlingmann of Prop
	(properties
		modNum 440
		x 217
		y 198
		view 26305
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(IsFlag 509)
					(IsFlag 271) ; "Just wanted to put back this magazine." in rm4450
					(and
						(IsFlag 267) ; "Hey, how's it going?" in rm4450
						(IsFlag 269) ; "What're you two kids talking about?" in rm4450
						(IsFlag 270) ; "Just wanted to grab a magazine." in rm4450
						(not (gEgo has: 76)) ; invMagWithRecorder
					)
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(pMVonZell doVerb: theVerb &rest)
	)
)

(instance pMVonAigerHennemann of Prop
	(properties
		modNum 440
		sightAngle 360
		x 504
		y 267
		view 4402
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 55))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 55)
						(gMessager say: 1 62 0 0 0 440) ; "(TRY TO TALK TO VON AIGNER/HENNEMENN AFTER DONE WITH DIALOGUE)I've already bonded with those two."
					)
					((IsFlag 507)
						(PlayScene 308 0 4430) ; rm4430
					)
					(else
						(SetFlag 507)
						(PlayScene 307 0 4430) ; rm4430
					)
				)
			)
			(40 ; invTapeRecorder
				(gMessager say: 39 62 0 0 0 440) ; "(PICKUP, TRY TO USE TAPE RECORDER ON )I don't think THEY'RE sayin' anythin' worth recording."
			)
			(116 ; invMagWithRecorder
				(gMessager say: 39 62 0 0 0 440) ; "(PICKUP, TRY TO USE TAPE RECORDER ON )I don't think THEY'RE sayin' anythin' worth recording."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pMVonGlower of Prop
	(properties
		modNum 440
		approachX 460
		approachY 400
		x 334
		y 178
		priority 500
		fixPriority 1
		view 24305
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 508))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (not (IsFlag 508))
					(SetFlag 508)
					(PlayScene 314)
				else
					(gMessager say: 2 62 0 0 0 440) ; "(TRY TO TALK TO VON GLOWER AND PREISS AFTER FIRST TIME)They're busy."
				)
			)
			(40 ; invTapeRecorder
				(gMessager say: 39 62 0 0 0 440) ; "(PICKUP, TRY TO USE TAPE RECORDER ON )I don't think THEY'RE sayin' anythin' worth recording."
			)
			(116 ; invMagWithRecorder
				(gMessager say: 39 62 0 0 0 440) ; "(PICKUP, TRY TO USE TAPE RECORDER ON )I don't think THEY'RE sayin' anythin' worth recording."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pMPreiss of Prop
	(properties
		modNum 440
		approachX 460
		approachY 400
		x 269
		y 225
		priority 500
		fixPriority 1
		view 25305
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 508))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(pMVonGlower doVerb: theVerb &rest)
	)
)

(instance fBar of GKFeature
	(properties
		sightAngle 360
		x 557
		y 153
	)

	(method (init)
		(self createPoly: 499 150 616 41 616 266 519 266 499 251)
		(super init: &rest)
	)

	(method (doVerb)
		(gMessager say: 34 62 0 0 0 440) ; "(LOOK AT BAR IN HUNT CLUB MAIN HALL)And I thought Germans only drank beer."
	)
)

(instance fMagazine of GKFeature
	(properties)

	(method (init)
		(self
			createPoly:
				138
				198
				134
				191
				141
				177
				135
				164
				115
				148
				98
				156
				107
				270
				199
				257
				258
				201
				255
				149
				225
				138
				198
				146
				201
				198
				184
				203
				168
				193
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 4440)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fFirePlace of GKFeature
	(properties
		sightAngle 360
		x 116
		y 153
	)

	(method (init)
		(self
			createPoly:
				83
				261
				35
				244
				32
				124
				61
				120
				74
				49
				100
				47
				164
				62
				176
				128
				200
				131
				197
				238
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 35 62 0 0 0 440) ; "(LOOK AT FIREPLACE IN HUNT CLUB MAIN HALL, OMINOUS AT END)Just the right size for the big bad wolf to come down the chimney. Unless he's already here."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fDeerHead of GKFeature
	(properties
		sightAngle 360
		x 152
		y 73
	)

	(method (init)
		(self createPoly: 126 41 178 41 178 105 126 105)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 37 62 0 0 0 440) ; "(LOOK AT DEER HEAD IN HUNT CLUB MAIN HALL, SARCASTIC)Dead things. Gotta love 'em."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCouches of GKFeature
	(properties
		sightAngle 360
		x 314
		y 243
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 375 299 396 285 397 253 415 258 423 247 424 202 421 191 300 188 293 204 214 199 206 221 204 275
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 36 62 0 0 0 440) ; "(CLICK ON CHAIRS IN HUNT CLUB MAIN HALL)I don't think I should get too comfy around here."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBackHall of ExitFeature
	(properties
		exitDir 6
	)

	(method (init)
		(self createPoly: 236 112 250 108 266 115 266 197 236 193)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 450) ; clubBackRm
		else
			(super doVerb: theVerb)
		)
	)
)

