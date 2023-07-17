;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 970)
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
	rm970 0
)

(instance rm970 of ExitRoom ; "Neuschwanstein: Singer's Hall"
	(properties
		noun 9
		picture 9701
		south 9702 ; rm9702
	)

	(method (init)
		(if (== gChapter 4)
			(tourTapeButton init:)
		else
			(secretPanel init:)
		)
		(super init: &rest)
		(studyExit init:)
		(gEgo
			posn: 457 325
			heading: 225
			sel_737:
			init:
			setScaler: Scaler 34 20 328 283
		)
		(if (and (== gChapter 6) (not (IsFlag 645)))
			(SetFlag 645)
			(PlayScene 774)
		)
		(if (and (!= gPrevRoomNum 9713) (or (not (IsFlag 700)) (IsFlag 699))) ; neuSaangerSecret
			(guard init:)
		)
		(leftRm init:)
		(wolfPanel_0 init:)
		(wolfPanel_1 init:)
		(wolfPanel_2 init:)
		(wolfPanel_3 init:)
		(restOfRoom init:)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 9702) (IsFlag 804))
			(SetFlag 699)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance studyExit of ExitFeature
	(properties
		x 467
		y 252
		BAD_SELECTOR 930
		BAD_SELECTOR 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 449 310 449 200 457 186 472 185 483 198 485 320
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance leftRm of ExitFeature
	(properties
		x 41
		y 197
		BAD_SELECTOR 9702
		BAD_SELECTOR 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: -1 53 85 132 84 342 -2 336
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance secretPanel of GKFeature
	(properties
		modNum 960
		sightAngle 360
		x 370
		y 284
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 360 270 381 274 380 299 360 292
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 62)) ; Do
			((IsFlag 804)
				(= noun 13)
				(= BAD_SELECTOR (= BAD_SELECTOR 0))
			)
			((gCast contains: guard)
				(= noun 12)
				(= BAD_SELECTOR (= BAD_SELECTOR 0))
			)
			(else
				(= BAD_SELECTOR 9713)
			)
		)
		(super doVerb: theVerb)
	)
)

(instance wolfPanel_0 of GKFeature
	(properties
		sightAngle 360
		x 164
		y 212
		BAD_SELECTOR 487
		BAD_SELECTOR 9712
	)

	(method (init)
		(if (IsFlag 632)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 101 172 93 204 93 251 102 260 133 260 141 248 146 248 150 259 184 257 189 248 193 248 199 256 230 257 235 246 233 199 231 183 225 171 198 176 192 202 188 202 181 175 154 172 145 201 138 200 132 175 116 165
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolfPanel_1 of GKFeature
	(properties
		sightAngle 360
		x 597
		y 176
		BAD_SELECTOR 487
		BAD_SELECTOR 9740
	)

	(method (init)
		(if (IsFlag 632)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 311 164 312 246 329 247 329 159
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolfPanel_2 of GKFeature
	(properties
		sightAngle 360
		x 406
		y 226
		BAD_SELECTOR 487
		BAD_SELECTOR 9741
	)

	(method (init)
		(if (IsFlag 632)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 358 152 359 250 388 254 384 146
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance wolfPanel_3 of GKFeature
	(properties
		sightAngle 360
		x 305
		y 227
		BAD_SELECTOR 487
		BAD_SELECTOR 9742
	)

	(method (init)
		(if (IsFlag 632)
			(= BAD_SELECTOR 0)
		)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 575 95 579 267 617 271 618 83
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance restOfRoom of GKFeature
	(properties
		noun 4
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
					init: -3 -4 -1 72 44 84 44 154 227 186 227 144 257 152 257 188 372 198 381 163 519 163 618 59 621 -5
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance tourTapeButton of Prop
	(properties
		noun 1
		sightAngle 360
		x 10
		y 290
		view 141
	)

	(method (cue)
		(gGame changeScore: 994)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 588)
			(gMessager say: noun 62 0 0 self) ; "This is the final room of our tour, the Singer's Hall. It was modeled after the Singer's Hall of the Wartburg castle where minstrel competitions were held in the 13th century."
		else
			(super doVerb: theVerb)
		)
	)
)

(instance guard of Prop
	(properties
		sightAngle 360
		x 337
		y 321
		view 40970
	)

	(method (init)
		(super init: &rest)
		(self setScript: FidgetScript)
	)

	(method (doVerb theVerb)
		(= modNum 910)
		(= noun
			(cond
				((== gChapter 4)
					(if (== theVerb 62) ; Do
						1
					else
						(= theVerb 0)
						2
					)
				)
				((== theVerb 31) ; invDove
					(= modNum 970)
					4
				)
				((IsFlag 804)
					(= theVerb 0)
					(= modNum 970)
					5
				)
				(else
					(= theVerb 62) ; Do
					18
				)
			)
		)
		(super doVerb: theVerb)
	)
)

