;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4102)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm4102 0
)

(instance rm4102 of ExitRoom ; "Dienerstrasse"
	(properties
		modNum 410
		noun 4
		picture 4102
		south 410 ; dienerRm
	)

	(method (init)
		(if (== gPrevRoomNum 410) ; dienerRm
			(gEgo posn: 150 281 heading: 45)
		else
			(gEgo posn: 421 207 heading: 225)
		)
		(if (OneOf gPrevRoomNum 430 470) ; clubFrontRm, crimeRm
			(Lock 140 470 0) ; WAVE
			(Lock 140 410 1) ; WAVE
			(gGk2Music setLoop: -1 number: 410 play:)
		)
		(gEgo sel_737: setScaler: Scaler 75 15 329 198 init:)
		(gGame handsOff:)
		(super init: &rest)
		(fHunt init:)
		(if (== gChapter 5)
			(peopleWithKid init: setScript: FidgetScript)
		)
		(fTrash init:)
		(if (and (not (IsFlag 549)) (== gChapter 3))
			(pCrimeScene init:)
			(vPoliceCars init:)
		)
		(gGame handsOn: 0)
	)
)

(instance peopleWithKid of Prop
	(properties
		modNum 410
		sightAngle 360
		x 534
		y 233
		view 41021
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 26 62 0 1 0 400) ; "(TRY TO TALK TO PEDESTRIANS)I'd give it a shot, but I don't speak the language."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pCrimeScene of Prop
	(properties
		approachX 420
		approachY 100
		x 301
		y 189
		view 22336
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd)
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 530))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 530)
				(gMessager say: 3 62 0 0 0 410) ; "(SLIGHTLY ANNOYED)The police won't let me do any investigatin' at the crime scene. I'll have to wait and talk to Leber."
			else
				(gGame handsOff:)
				(gCurRoom newRoom: 470) ; crimeRm
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vPoliceCars of View
	(properties
		approachX 420
		approachY 100
		x 218
		y 210
		view 22336
		loop 1
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 530))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(pCrimeScene doVerb: theVerb &rest)
	)
)

(instance fHunt of GKFeature
	(properties
		modNum 410
		sightAngle 360
		x 420
		y 100
	)

	(method (init)
		(self createPoly: 386 151 386 192 414 192 414 151)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 412)
				(gCurRoom newRoom: 4111)
			else
				(gMessager say: 9 62 0 0 0 410) ; "(PICKUP, FOR HUNT CLUB BEFORE YOU READ ADDRESS ON RECEIPT)Just more buildin's down this way."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTrash of GKFeature
	(properties
		modNum 410
		sightAngle 360
		x 252
		y 259
	)

	(method (init)
		(self createPoly: 233 226 271 226 271 292 233 292)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 10 62 0 0 0 410) ; "(PICKUP, FOR DIENERSTRASSE TRASH CANS CH 1)Even their TRASH cans are clean in this city."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

