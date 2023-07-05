;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use Scaler)
(use Polygon)
(use Feature)

(public
	srGerdaRoom 0
)

(instance srGerdaRoom of GK2Room ; "Schloss Ritter: Gerde's Bedroom"
	(properties
		noun 4
		picture 1501
	)

	(method (init)
		(super init: &rest)
		(hallDoor init:)
		(desk init:)
		(shrank init:)
		(if (not (IsFlag 478))
			(SetFlag 478)
			(PlayScene 149)
		)
		(gEgo
			posn: 415 282
			heading: 225
			normalize:
			setScaler: Scaler 67 62 278 261
			init:
		)
	)
)

(instance hallDoor of GKFeature
	(properties
		noun 1
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
					init: 548 20 618 17 618 335 548 322
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance desk of GKFeature
	(properties
		nsLeft 290
		nsTop 177
		nsRight 454
		nsBottom 218
		sightAngle 40
		approachX 410
		x 408
		y 225
		sceneNum 150
		nextRoomNum 1542 ; rm1542
	)
)

(instance shrank of GKFeature
	(properties
		nsLeft 474
		nsTop 43
		nsRight 598
		nsBottom 228
		sightAngle 40
		approachX 504
		x 464
		y 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 426 63 507 63 507 223 422 212
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 879)
					(PlayScene 1151 0 1510) ; rm1510
				else
					(PlayScene 151 0 1510) ; rm1510
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

