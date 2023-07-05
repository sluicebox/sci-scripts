;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 440)
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
	clubMainRm 0
)

(instance clubMainRm of ExitRoom ; "Hunt Club: Main Hall"
	(properties
		noun 6
		picture 4401
		east 4402 ; rm4402
	)

	(method (init)
		(if (== gPrevRoomNum 430) ; clubFrontRm
			(gEgo
				posn: 116 274
				heading: 135
				normalize:
				setScaler: Scaler 81 63 299 254
				init:
			)
		else
			(gEgo
				posn: 560 273
				heading: 225
				normalize:
				setScaler: Scaler 91 47 342 236
				init:
			)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 430) ; clubFrontRm
			(gSoundManager play: 0 430 431 432)
		)
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
				(pVonZell init: setScript: FidgetScript)
				(if (not (IsFlag 505))
					(SetFlag 505)
					(PlayScene 276)
					(gGame handsOn:)
				)
			)
			((IsFlag 54)
				(SetFlag 504)
				(PlayScene 305 0 4402) ; rm4402
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
						(= gCurRoomNum 430) ; clubFrontRm
						(PlayScene 289 0 4402) ; rm4402
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
		(fCouches init:)
		(fDeerHead init:)
		(fFirePlace init:)
		(efBackHall init:)
		(efFrontHall init:)
	)
)

(instance coatOnRack of View ; UNUSED
	(properties
		sightAngle 360
		x 6
		y 302
		view 30305
	)
)

(instance pVonZell of Prop
	(properties
		x 398
		y 173
		view 21277
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (proc11_15 4420)))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (proc11_15 4420)
				(PlayScene 278 0 4420) ; rm4420
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pPreiss of Prop
	(properties
		x 390
		y 170
		view 21289
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (not (proc11_15 4421)))
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (proc11_15 4421)
				(PlayScene 290 0 4421) ; rm4421
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fMagazine of GKFeature
	(properties
		approachX 331
		approachY 197
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 223 151 239 140 269 141 285 164 286 178 279 189 284 196 308 192 317 200 321 210 349 209 357 197 387 199 386 199 388 186 381 169 391 152 420 145 440 156 436 230 403 246 363 241 240 255 229 253 234 230 232 180
					yourself:
				)
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
		x 310
		y 148
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 238 185 227 129 239 123 253 123 272 52 349 56 361 125 391 128 392 139 384 143 393 236
					yourself:
				)
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
		x 312
		y 68
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 281 34 343 34 332 103 293 103
					yourself:
				)
		)
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
		x 345
		y 268
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 272 200 281 210 291 208 311 217 339 233 346 251 417 263 436 272 430 335 321 337 268 286 255 230 261 221
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 571 328 616 310 616 215 560 206 511 203 476 199 465 218 425 217 428 249 495 270 493 297 558 318 560 329
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

(instance efBackHall of ExitFeature
	(properties
		approachX 500
		approachY 200
		nextRoomNum 450 ; clubBackRm
		exitDir 0
	)

	(method (init)
		(self createPoly: 484 105 484 201 508 208 530 199 530 105)
		(super init: &rest)
	)
)

(instance efFrontHall of ExitFeature
	(properties
		approachX 50
		approachY 261
		nextRoomNum 430 ; clubFrontRm
		exitDir 6
	)

	(method (init)
		(self createPoly: 34 38 70 67 70 244 30 276)
		(super init: &rest)
	)
)

