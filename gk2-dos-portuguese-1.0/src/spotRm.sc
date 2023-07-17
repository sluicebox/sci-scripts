;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1170)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Polygon)
(use Feature)

(public
	spotRm 0
)

(instance spotRm of ExitRoom ; "Wittelsbacher Theater: Spotlight Room"
	(properties
		modNum 1170
		noun 21
		picture 11701
	)

	(method (init)
		(if (IsFlag 735)
			(self setRegions: 1101) ; resRegion
		)
		(gEgo
			posn: 315 280
			heading: 315
			sel_737:
			setScaler: Scaler 100 77 344 273
			init:
		)
		(if (IsFlag 739)
			(Palette 1 (= global249 210)) ; PalLoad
		else
			(Palette 1 (= global249 211)) ; PalLoad
		)
		(super init: &rest)
		(if (== gPrevRoomNum 11304)
			(cond
				((IsFlag 739)
					(PlayScene 871)
				)
				((IsFlag 768)
					(PlayScene 1861)
				)
				(else
					(SetFlag 768)
					(PlayScene 861)
				)
			)
		)
		(spotlight init:)
		(openCupboard init:)
		(southExit init:)
		(eastExit init:)
	)
)

(instance spotlight of GKFeature
	(properties
		modNum 1170
		sightAngle 360
		x 186
		y 206
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 139 284 139 269 182 272 179 205 167 205 167 179 150 168 152 114 176 106 213 109 221 145 212 167 213 200 193 243 194 270 233 262 233 273 222 282 198 283 199 307 182 307 181 282
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11710)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance openCupboard of GKFeature
	(properties
		modNum 1170
		sightAngle 360
		x 303
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 260 57 347 59 347 161 260 166
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 11711)
			)
			(34 ; invOperaGlasses
				(cond
					((IsFlag 763)
						(gMessager say: 18 theVerb 0 0 0 modNum) ; "(TRY TO USE OPERA GLASSES ON MITTLE LOGE AFTER SEEING VON GLOWER ONCE ALREADY, WORRIED)I already know he's there! Now I need to make sure he doesn't get out!"
					)
					((IsFlag 735)
						(gCurRoom newRoom: 11711)
					)
					(else
						(gCurRoom newRoom: 11752)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		modNum 1170
		sightAngle 360
		approachX 320
		approachY 600
		x 307
		y 314
		BAD_SELECTOR 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 295 615 295 615 333 0 333
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 770))
			(= global141 self)
		)
		(if (IsFlag 739)
			(= sightAngle 5)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((IsFlag 770)
						(gMessager say: 23 62 0 0 0 modNum) ; "(TRY TO EXIT SPOTLIGHT ROOM WITHOUT TURNING OFF LIGHT)I shouldn't leave the light on."
					)
					((IsFlag 739)
						(gCurRoom newRoom: 11304)
					)
					(else
						(PlayScene 2861 0 11304) ; rm11304
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance eastExit of ExitFeature
	(properties
		modNum 1170
		sightAngle 360
		x 593
		y 150
		BAD_SELECTOR 2
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 770))
			(= global141 self)
		)
		(if (IsFlag 739)
			(= sightAngle 5)
		)
		(super handleEvent: event)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 572 0 615 0 615 300 572 300
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(southExit doVerb: theVerb)
	)
)

