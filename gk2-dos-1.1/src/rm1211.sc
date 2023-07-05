;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1211)
(include sci.sh)
(use Main)
(use northExit)
(use Feature)
(use System)

(public
	rm1211 0
)

(local
	local0
)

(instance rm1211 of ExitRoom
	(properties
		picture 1211
		south 120 ; srHallRoom
	)

	(method (cue)
		(= local0 1)
		(gSoundManager stop:)
		(self newRoom: 100) ; srExtRoom
	)

	(method (newRoom newRoomNumber)
		(if (and (not local0) (== newRoomNumber 100)) ; srExtRoom
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (init)
		(= local0 0)
		(super init: &rest)
		(door init:)
		(art1 init:)
		(art2 init:)
	)
)

(instance soundTurnerOffer of Script
	(properties)

	(method (cue)
		(gSoundManager stop:)
	)
)

(instance door of ExitFeature
	(properties
		nsLeft 192
		nsTop 72
		nsRight 416
		nsBottom 304
		sceneNum 132
		nextRoomNum 100 ; srExtRoom
		exitDir 0
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gSoundManager fade: 0 10 10 1 soundTurnerOffer)
		)
		(super doVerb: theVerb &rest)
	)
)

(instance art1 of GKFeature
	(properties
		noun 16
		modNum 120
		nsLeft 140
		nsTop 117
		nsRight 176
		nsBottom 256
	)
)

(instance art2 of GKFeature
	(properties
		noun 16
		modNum 120
		nsTop 98
		nsRight 48
		nsBottom 266
	)
)

