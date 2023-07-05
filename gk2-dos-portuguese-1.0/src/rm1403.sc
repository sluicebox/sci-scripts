;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1403)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)
(use Actor)
(use System)

(public
	rm1403 0
)

(local
	local0
)

(instance rm1403 of ExitRoom ; "Schloss Ritter: Gabriel's Bedroom"
	(properties
		noun 1
		picture 1403
		south 140 ; srGabeRoom
	)

	(method (cue)
		(= local0 1)
		(gSoundManager stop:)
		(self newRoom: 130) ; srLibRoom
	)

	(method (newRoom newRoomNumber)
		(if (and (not local0) (== newRoomNumber 130)) ; srLibRoom
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (init)
		(if (OneOf gPrevRoomNum 130 24) ; srLibRoom, whereTo
			(gSoundManager play: 0 122 121 123)
		)
		(p1 init:)
		(p2 init:)
		(lion init:)
		(super init: &rest)
		(if (IsFlag 481)
			(doorExit init:)
		else
			(libDoor init:)
		)
		(if (== gChapter 6)
			(pillows init:)
		)
		(bed init:)
		(if (== gPrevRoomNum 130) ; srLibRoom
			(gEgo posn: 58 251 heading: 135)
		else
			(gEgo posn: 25 338 heading: 45)
		)
		(gEgo BAD_SELECTOR: setScaler: Scaler 97 63 357 229 init:)
	)
)

(instance doorExit of ExitFeature
	(properties
		noun 1
		modNum 140
		approachX 100
		x 100
		y 216
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 44 118 44 118 214 37 214
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 123 0 130) ; srLibRoom
			)
			(else
				(return 0)
			)
		)
	)
)

(instance libDoor of GKFeature
	(properties
		noun 1
		modNum 140
		approachX 100
		x 100
		y 216
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 37 44 118 44 118 214 37 214
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (or (IsFlag 462) (and (== (event message:) KEY_B) (IsFlag 481)))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 481)
						(PlayScene 123 0 130) ; srLibRoom
					)
					((IsFlag 462)
						(super doVerb: theVerb)
					)
					(else
						(SetFlag 462)
						(PlayScene 121)
					)
				)
			)
			(66 ; invLibraryKey
				(if (IsFlag 481)
					(super doVerb: theVerb)
				else
					(SetFlag 481)
					(gCurRoom newRoom: 130) ; srLibRoom
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance pillows of View
	(properties
		modNum 140
		x 162
		y 200
		view 30906
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 775)
				(= noun 16)
				(super doVerb: theVerb)
			else
				(PlayScene 760)
				(SetFlag 775)
				(gEgo get: 61) ; invPillowcase
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance bed of GKFeature
	(properties
		noun 3
		modNum 140
		x 240
		y 200
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 216 175 127 227 114 227 335 231 369 188 344 170 251 167
					yourself:
				)
		)
		(if (== gChapter 6)
			(= noun 16)
		else
			(= noun 3)
		)
		(super init: &rest)
	)

	(method (doVerb)
		(if (== gChapter 6)
			(pillows doVerb: &rest)
		else
			(super doVerb: &rest)
		)
	)
)

(instance p1 of GKFeature
	(properties
		noun 24
		modNum 140
		x 175
		y 76
	)

	(method (handleEvent event)
		(= global141 self)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 178 50 167 82 180 112 203 111 212 81 203 50
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance p2 of GKFeature
	(properties
		noun 24
		modNum 140
		x 395
		y 73
	)

	(method (handleEvent event)
		(= global141 self)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 417 42 403 63 406 102 429 115 453 105 458 62 442 42
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lion of GKFeature
	(properties
		noun 22
		modNum 140
		x 291
		y 30
	)

	(method (handleEvent event)
		(= global141 self)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 3 337 3 345 28 336 63 302 63 294 31
					yourself:
				)
		)
		(super init: &rest)
	)
)

