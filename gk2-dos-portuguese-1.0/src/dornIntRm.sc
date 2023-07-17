;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Actor)

(public
	dornIntRm 0
)

(instance dornIntRm of ExitRoom ; "Exotic Animal Kennel"
	(properties
		noun 13
		picture 2601
	)

	(method (init)
		(if (IsFlag 328)
			(= south 2602)
		)
		(gEgo
			posn: 442 281
			heading: 225
			sel_737:
			setScaler: Scaler 101 54 325 233
			init:
		)
		(super init: &rest)
		(if (!= gPrevRoomNum 2620)
			(gSoundManager play: 0 251 252 253)
		)
		(fExit init:)
		(fLeftCages init:)
		(fRightCages init:)
		(vDorn init: setScript: FidgetScript)
		(if (and (== gPrevRoomNum 2620) (not (IsFlag 8)))
			(gMessager say: 20 62 0 1 0 260) ; "(CLICK ON DORN--ALL DIALGOUE EXHAUSTED, SCORNFUL)I think I've said all I care to to Mr. Dorn."
		)
		(gGame handsOn:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 250) ; dornExtRm
			(gSoundManager stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance fExit of GKFeature
	(properties
		approachX 200
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 136 120 136 67 212 67 212 220 164 220 164 124)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gCurRoom newRoom: 250) ; dornExtRm
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fLeftCages of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 124 158 120 156 242 36 331 0 331)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 651)
				(gMessager say: 5 62 2 1 0 260) ; "(LOOK AT ANIMALS AGAIN, ANGRY)If I ever solve this case, I'll sick Leber on this guy."
			else
				(SetFlag 651)
				(gMessager say: 5 62 1 1 0 260) ; "(LOOK AT DORN'S ANIMALS)These animals are filthy. hungry too. I'd like to put Dorn in one of these cages - and leave him there."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fRightCages of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 482 117 482 220 612 307 614 124)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 651)
				(gMessager say: 5 62 2 1 0 260) ; "(LOOK AT ANIMALS AGAIN, ANGRY)If I ever solve this case, I'll sick Leber on this guy."
			else
				(SetFlag 651)
				(gMessager say: 5 62 1 1 0 260) ; "(LOOK AT DORN'S ANIMALS)These animals are filthy. hungry too. I'd like to put Dorn in one of these cages - and leave him there."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vDorn of Prop
	(properties
		x 301
		y 283
		view 2601
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (!= (event message:) $0a3c))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gCurRoom newRoom: 2620)
			)
			(90 ; invWolfTags
				(gMessager say: 3 20 0 1 0 260) ; "(DORN'S PLACE, INT. TRY TO GIVE WOLF TAGS TO DORN)The sleezebag lost them. I'm not about to give 'em back."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

