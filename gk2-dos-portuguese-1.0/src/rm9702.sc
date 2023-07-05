;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9702)
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
	rm9702 0
)

(instance rm9702 of ExitRoom
	(properties
		picture 9702
		south 970 ; rm970
	)

	(method (newRoom newRoomNumber)
		(if (and (== gChapter 6) (== newRoomNumber 900))
			(gGk2Music fade:)
			(Lock rsAUDIO 910 0)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		)
		(super init: &rest)
		(sideExit init:)
		(farExit init:)
		(if (== gPrevRoomNum 970)
			(gEgo
				posn: 279 325
				heading: 325
				BAD_SELECTOR:
				init:
				setScaler: Scaler 39 27 330 283
			)
		else
			(gEgo
				posn: 413 283
				heading: 225
				BAD_SELECTOR:
				init:
				setScaler: Scaler 39 27 330 283
			)
		)
		(if (and (IsFlag 700) (not (IsFlag 804)))
			(PlayScene 782)
		)
		(rightRm init:)
		(wolf_3 init:)
		(wolf_4 init:)
		(wolf_5 init:)
		(windowF init:)
		(restOfRoom init:)
	)
)

(instance sideExit of GKFeature
	(properties
		modNum 970
		sightAngle 360
		x 148
		y 262
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 255 196 278 198 278 254 254 259
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 301 199 319 202 319 248 300 251
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 199 189 220 191 218 261 198 263
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 129 200 129 322 170 309 170 204 159 182 144 182
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 38 166 89 171 95 195 92 272 38 280
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 31) ; invDove
				(PlayScene 784)
				(SetFlag 700)
				(gEgo put: 77) ; invDove
			)
			((gCast contains: guard)
				(= noun 7)
				(super doVerb: theVerb)
			)
			((and (== gChapter 6) (== theVerb 62) (not (IsFlag 700))) ; Do
				(= noun 6)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance farExit of ExitFeature
	(properties
		nsLeft 331
		nsTop 210
		nsRight 363
		nsBottom 267
		sightAngle 360
		BAD_SELECTOR 900
		BAD_SELECTOR 0
	)
)

(instance rightRm of ExitFeature
	(properties
		sightAngle 360
		x 572
		y 197
		BAD_SELECTOR 970
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 618 55 525 148 544 339 620 336
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolf_3 of GKFeature
	(properties
		sightAngle 360
		x 18
		y 178
		BAD_SELECTOR 9743
	)

	(method (init)
		(if (== gChapter 6)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 84 38 94 35 268 -1 272
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolf_4 of GKFeature
	(properties
		sightAngle 360
		x 240
		y 201
		BAD_SELECTOR 9744
	)

	(method (init)
		(if (== gChapter 6)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 228 149 255 153 252 251 226 253
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolf_5 of GKFeature
	(properties
		sightAngle 360
		x 295
		y 204
		BAD_SELECTOR 9745
	)

	(method (init)
		(if (== gChapter 6)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 287 161 304 166 304 244 287 248
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance windowF of GKFeature
	(properties
		modNum 970
		sightAngle 360
		x 450
		y 202
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 382 236 521 236 521 187 510 168 391 170 379 204
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 31) ; invDove
			(= noun 13)
			(= BAD_SELECTOR 0)
			(= theVerb 62) ; Do
		else
			(= noun 0)
			(= BAD_SELECTOR 9711)
		)
		(super doVerb: theVerb)
	)
)

(instance restOfRoom of GKFeature
	(properties
		noun 4
		modNum 970
		sightAngle 360
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 -2 0 73 108 167 250 176 250 204 311 195 310 161 392 144 392 181 574 157 574 92 616 82 617 -3
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of View
	(properties
		noun 1
		modNum 970
		sightAngle 360
		x 10
		y 290
		view 141
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 588)
		)
		(super doVerb: theVerb)
	)
)

(instance guard of Prop
	(properties
		noun 7
		modNum 970
		sightAngle 360
		x 50
		y 200
		view 131
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)
)

