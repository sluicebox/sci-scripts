;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1445)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)

(public
	srGabeShrank 0
)

(local
	local0
	local1
)

(instance srGabeShrank of ExitRoom ; "Schloss Ritter: Gabriel's Bedroom"
	(properties
		modNum 140
		noun 20
		south 140 ; srGabeRoom
	)

	(method (cue)
		(= local1 1)
		(gSoundManager stop:)
		(self newRoom: 160) ; srSecretRoom
	)

	(method (newRoom newRoomNumber)
		(if (and (not local1) (== newRoomNumber 160)) ; srSecretRoom
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (init)
		(= local1 0)
		(= picture
			(if (IsFlag 479)
				(SetFlag 457)
				(shrankExit init:)
				1446
			else
				(shrankBack init:)
				1445
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(if (not local0)
			(PlayScene 3130 0 -1)
		)
		(super dispose:)
	)
)

(instance shrankExit of ExitFeature
	(properties
		modNum 140
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 13 84 294 120 294 338 13 340
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(= local0 1)
				(PlayScene 4130 0 160) ; srSecretRoom
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shrankBack of GKFeature
	(properties
		noun 23
		modNum 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 13 84 294 120 294 338 13 340
					yourself:
				)
		)
		(super init: &rest)
	)
)

