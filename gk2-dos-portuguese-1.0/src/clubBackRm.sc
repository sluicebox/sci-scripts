;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Scaler)
(use Feature)

(public
	clubBackRm 0
)

(local
	local0
)

(instance clubBackRm of ExitRoom ; "Hunt Club: Back Hall"
	(properties
		noun 4
		picture 4501
	)

	(method (cue)
		(= local0 1)
		(gSoundManager stop:)
		(self newRoom: 460) ; ritualRm
	)

	(method (newRoom newRoomNumber)
		(if (and (not local0) (== newRoomNumber 460)) ; ritualRm
			(gSoundManager fade: 0 10 10 1 self)
		else
			(super newRoom: newRoomNumber &rest)
		)
	)

	(method (init)
		(= local0 0)
		(if (== gPrevRoomNum 460) ; ritualRm
			(gSoundManager play: 0 431 432 430)
		)
		(if (and (IsFlag 54) (== gChapter 3))
			(= south 4402)
		else
			(= south 440)
		)
		(self setRegions: 4599) ; clubRegion
		(gEgo
			posn: 220 365
			heading: 45
			BAD_SELECTOR:
			setScaler: Scaler 106 54 332 224
			init:
		)
		(super init: &rest)
		(fPlant init:)
		(fSTDoor init:)
		(fBMDoor init:)
	)
)

(instance fPlant of GKFeature
	(properties
		approachX 440
		approachY 320
	)

	(method (init)
		(self
			createPoly:
				416
				323
				410
				273
				421
				252
				397
				233
				386
				213
				406
				193
				397
				177
				397
				153
				426
				126
				443
				92
				449
				83
				445
				65
				471
				41
				487
				48
				493
				62
				492
				86
				486
				98
				500
				122
				495
				133
				522
				145
				512
				163
				521
				173
				506
				193
				507
				222
				469
				239
				455
				251
				472
				275
				466
				324
				454
				332
				436
				333
		)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(!= gChapter 3)
					(IsFlag 513)
					(and
						(== (event message:) $003e) ; >
						(not (IsFlag 526))
						(not (IsFlag 513))
					)
					(== (gEgo x:) 350)
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (and (== gChapter 3) (IsFlag 526))
					(gEgo get: 32) ; invCuckooClock
					(ClearFlag 528)
					(ClearFlag 526)
					(if (gTimers contains: (ScriptID 4599 1)) ; cuckooTimer
						((ScriptID 4599 1) dispose: delete:) ; cuckooTimer
					)
					(PlayScene 326)
				else
					(gMessager say: 1 62 0 0 0 450) ; "(HUNT CLUB BACK HALL, LOOK AT PLANT)Nice plant."
				)
			)
			(74 ; invCuckooClock
				(if (and (IsFlag 527) (not (gEgo has: 33))) ; invXaverKeys
					(gMessager say: 7 62 0 0 0 450) ; "(TRY TO HIDE CUCKOO CLOCK IN PLANT AFTER GETTING AND RETURNING KEYS, SMART ASS)I don't think that'll be necessary again."
				else
					((gUser BAD_SELECTOR:) BAD_SELECTOR:)
					(SetFlag 526)
					(gEgo put: 32) ; invCuckooClock
					((ScriptID 4599 1) setReal: (ScriptID 4599 1) 15) ; cuckooTimer, cuckooTimer
					(PlayScene 327)
				)
			)
			(else
				(gMessager say: 9 62 0 0 0 450) ; "(PICKUP, TRY TO HIDE SOMETHING ELSEIN THE PLANT IN THE HUNT CLUB BACK HALL)Why would I want to put THAT in the plant?"
			)
		)
	)
)

(instance fBMDoor of GKFeature
	(properties
		modNum 450
		approachX 330
		approachY 290
	)

	(method (init)
		(self createPoly: 260 19 260 300 306 244 306 28)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or
					(!= gChapter 3)
					(and (== (event message:) $003e) (gEgo has: 33)) ; >, invXaverKeys
					(and (IsFlag 525) (== gChapter 3))
					(and (IsFlag 527) (== (event message:) $0027)) ; '
					(and (not (IsFlag 527)) (IsFlag 547))
				)
			)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(cond
					((!= gChapter 3)
						(gMessager say: 5 62) ; "(TRY TO OPEN BASEMENT DOOR IN HUNT CLUB AFTER GETTING CAUGHT DOWN THERE BY VON ZELL)I DON'T think I'm goin' to get down there again."
					)
					((and (== gChapter 3) (IsFlag 525) (IsFlag 524))
						(gMessager say: 5 62) ; "(TRY TO OPEN BASEMENT DOOR IN HUNT CLUB AFTER GETTING CAUGHT DOWN THERE BY VON ZELL)I DON'T think I'm goin' to get down there again."
					)
					((not (IsFlag 527))
						(if (IsFlag 547)
							(gMessager say: 10 62 0 0 0 450) ; "(PICKUP, SECOND TIME TRYING LOCKED HUNT CLUB BASEMENT DOOR)It won't do much good to keep tryin' it. It's locked."
						else
							(SetFlag 547)
							(PlayScene 328)
						)
					)
					((gEgo has: 33) ; invXaverKeys
						(gMessager say: 3 62 0 0 0 450) ; "(THOUGHTFUL)I should probably return those keys first, before Xaver notices they're gone."
					)
					(else
						(PlayScene 330 0 460) ; ritualRm
					)
				)
			)
			(39 ; invXaverKeys
				(if (IsFlag 527)
					(gMessager say: 2 39 0 0 0 450) ; "(TRY TO LOCK DOOR TO BASEMENT)I don't want to lock the door again."
				else
					(SetFlag 527)
					(PlayScene 329)
					(gEgo posn: 350 300 heading: 315 BAD_SELECTOR:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fSTDoor of GKFeature
	(properties
		approachX 640
	)

	(method (handleEvent event)
		(if (and (self onMe: event) (IsFlag 545))
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (init)
		(self createPoly: 336 60 336 216 404 216 404 62)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 545)
				(gMessager say: 6 theVerb 0 0 0 450) ; "(TRY TO OPEN BACK DOOR AFTER GETTING BASEMENT DOOR OPEN)It just leads to a back alley."
			else
				(SetFlag 545)
				(PlayScene 325)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

