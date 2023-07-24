;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Cursor)
(use Motion)
(use Actor)
(use System)

(public
	zooOfficeRm 0
)

(local
	local0
)

(instance zooOfficeRm of ExitRoom ; "Zoologischer Garten M\81nchen: Klingmann's Office"
	(properties
		noun 12
		picture 2401
	)

	(method (init)
		(super init: &rest)
		(if (gEgo has: 15) ; invSpliceTape
			(gEgo
				posn: 337 346
				heading: 315
				sel_737:
				init:
				setScaler: Scaler 100 88 334 295
			)
		else
			(fixEgo doit:)
		)
		(if (and (= local0 (not (gEgo has: 15))) (!= gPrevRoomNum 2420)) ; invSpliceTape
			(if (IsFlag 420)
				(PlayScene 43)
				(fixEgo doit:)
			else
				(PlayScene 42)
				(fixEgo doit:)
				(SetFlag 420)
			)
		)
		(fChair init:)
		(fBookCase init:)
		(fDoor init:)
		(fFaxDoor init:)
		(coat init:)
		(if (gEgo has: 15) ; invSpliceTape
			(desk init:)
		)
		(if (not (IsFlag 421))
			(fWalkieTalkie init:)
		)
		(if local0
			(pKlingmann init: setScript: sKlingmannFidget)
		)
		(fWolfPoster init:)
		(fPoster2 init:)
		(gGame handsOn: 0)
	)
)

(instance fChair of GKFeature
	(properties
		noun 18
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 146 295 171 273 136 256 148 210 168 216 188 203 241 198 227 263 206 277 242 289 249 305 202 297 190 303 187 318 174 319 182 293
		)
	)
)

(instance fWolfPoster of GKFeature
	(properties
		noun 19
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 65 48 140 52 140 159 65 163)
	)
)

(instance fPoster2 of GKFeature
	(properties
		noun 19
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 277 70 316 62 316 136 278 135)
	)
)

(instance fBookCase of GKFeature
	(properties
		noun 20
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self
			createPoly: 318 255 316 50 346 43 347 17 383 17 400 29 401 45 369 135 360 190 370 203 368 283
		)
	)
)

(instance fFaxDoor of GKFeature
	(properties
		noun 15
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(if (not local0)
			(= noun 16)
		)
		(self
			createPoly: 194 45 255 50 255 227 237 223 239 197 226 198 226 189 242 185 225 162 194 154
		)
	)
)

(instance fDoor of ExitFeature
	(properties
		sightAngle 360
		x 627
		y 350
		BAD_SELECTOR 2
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 491 309 492 0 610 0 610 331 574 331)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (== theVerb 62) ; Do
			(if (and (IsFlag 421) (not (IsFlag 437)))
				(= temp0 2342)
			else
				(= temp0 230)
			)
			(cond
				((and local0 (IsFlag 428))
					(PlayScene 45 0 -1)
					(PlayScene 2042 0 temp0)
					(fixEgo doit:)
				)
				(local0
					(PlayScene 1045 0 -1)
					(PlayScene 2042 0 temp0)
					(fixEgo doit:)
				)
				(else
					(PlayScene 2042 0 temp0)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance desk of GKFeature
	(properties
		sightAngle 360
		x 129
		y 231
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 28 301 25 245 21 240 21 224 41 214 36 203 37 196 32 178 65 179 76 179 113 175 145 191 191 188 236 183 225 188 225 198 238 198 227 263 72 282 69 296
					yourself:
				)
		)
		(super init: &rest)
		(if (not (gEgo has: 15)) ; invSpliceTape
			(GKHotCursor delete: self)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 47)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance coat of GKFeature
	(properties
		sightAngle 360
		x 388
		y 176
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 412 307 369 294 373 202 363 194 385 97 404 45 413 79
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				(local0
					(gMessager say: 13 62 0 1 0 240) ; "(KLINGMANN'S OFFICE, THOUGHTFUL)Herr Doktor's coat."
				)
				((gEgo has: 13) ; invKlingmannReceipt
					(gMessager say: 17 62 0 1 0 240) ; "(CLICK ON COAT AFTER GETTING RECEIPT)I don't think there's anythin' else in there."
				)
				(else
					(PlayScene 48)
					(gEgo get: 13) ; invKlingmannReceipt
					(if (IsFlag 421)
						(if (IsFlag 437)
							(PlayScene 44 0 230) ; hellZooRm
						else
							(PlayScene 44 0 2342) ; rm2342
						)
					else
						(gEgo
							posn: 280 302
							heading: 315
							setScaler: Scaler 100 88 334 295
						)
					)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fWalkieTalkie of GKFeature
	(properties
		modNum 240
		sightAngle 360
		x 153
		y 96
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 158 168 212 166 217 180 162 184)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 1 62 0 1) ; "(SLY, THOUGHTFUL)A walkie-talkie. Didn't Thomas have one like that?"
			)
			(61 ; invSpliceTape
				(gEgo
					posn: 280 302
					heading: 315
					setScaler: Scaler 100 88 334 295
				)
				(PlayScene 46)
				(SetFlag 421)
				(if (gEgo has: 13) ; invKlingmannReceipt
					(if (IsFlag 437)
						(PlayScene 44 0 230) ; hellZooRm
					else
						(PlayScene 44 0 2342) ; rm2342
					)
				)
				(gUser sel_712: 62)
				(GKHotCursor update: delete: self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pKlingmann of Prop
	(properties
		sightAngle 360
		x 49
		y 189
		view 51043
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (not (IsFlag 428))
					(SetFlag 428)
					(PlayScene 49)
					(fixEgo doit:)
				)
				(if (IsFlag 41)
					(gMessager say: 14 62 0 1 0 240) ; "(CLICK ON KLINGMANN--DIALOGUE DONE)Can't think of what else to ask him."
				else
					(gCurRoom newRoom: 2420)
				)
			)
			(41 ; invEvidenceReport
				(gMessager say: 2 0 0 1 0 240) ; "(TRY TO SHOW KLINGMANN HAIR FROM FARM)Hmmm. I'd rather ask someone who's not involved. This guy's a little too close to the fire not to be reflectin' heat."
			)
			(57 ; invZooHair
				(gMessager say: 2 0 0 1 0 240) ; "(TRY TO SHOW KLINGMANN HAIR FROM FARM)Hmmm. I'd rather ask someone who's not involved. This guy's a little too close to the fire not to be reflectin' heat."
			)
			(56 ; invFarmHair
				(gMessager say: 2 0 0 1 0 240) ; "(TRY TO SHOW KLINGMANN HAIR FROM FARM)Hmmm. I'd rather ask someone who's not involved. This guy's a little too close to the fire not to be reflectin' heat."
			)
			(58 ; invPawPrintCast
				(gMessager say: 2 0 0 1 0 240) ; "(TRY TO SHOW KLINGMANN HAIR FROM FARM)Hmmm. I'd rather ask someone who's not involved. This guy's a little too close to the fire not to be reflectin' heat."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 12 30))
			)
			(1
				(self changeState: 0)
			)
		)
	)
)

(instance sKlingmannFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 10)
			)
			(1
				(pKlingmann cel: 0 setLoop: (Random 0 2) 1 setCycle: End)
				(= seconds (Random 7 14))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance fixEgo of Code
	(properties)

	(method (doit)
		(gEgo
			setScale: 0
			view: 52043
			setLoop: 0 1
			cel: 0
			posn: 179 309
			init:
			setScript: sFidget
		)
	)
)

