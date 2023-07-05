;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1510)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Polygon)
(use Feature)
(use Actor)

(public
	rm1510 0
)

(local
	local0
)

(instance rm1510 of ExitRoom
	(properties
		picture 1546
		south 150 ; srGerdaRoom
	)

	(method (cue)
		(= local0 1)
		(gSoundManager stop:)
		(self newRoom: 160) ; srSecretRoom
	)

	(method (newRoom newRoomNumber)
		(if (and (not local0) (== newRoomNumber 160)) ; srSecretRoom
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (init)
		(= local0 0)
		(super init: &rest)
		(passage init:)
		(clothes init:)
		(if (not (IsFlag 475))
			(libkey init:)
		)
	)
)

(instance desk of GKFeature ; UNUSED
	(properties
		nsLeft 100
		nsTop 240
		nsRight 212
		nsBottom 268
		BAD_SELECTOR 1512
	)
)

(instance passage of ExitFeature
	(properties
		BAD_SELECTOR 160
		BAD_SELECTOR 0
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 118 143 237 152 237 344 130 346
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance clothes of GKFeature
	(properties
		noun 3
		modNum 150
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 81 78 110 99 133 350 16 349 15 73
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance libkey of View
	(properties
		x 203
		y 150
		view 30120
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gEgo get: 22) ; invLibraryKey
			(SetFlag 475)
			(self dispose:)
			(gSoundManager fade: 0 10 10 1)
			(PlayScene 152 0 150) ; srGerdaRoom
		else
			(return 0)
		)
	)
)

