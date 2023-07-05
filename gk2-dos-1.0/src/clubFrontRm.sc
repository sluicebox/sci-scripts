;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 430)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Scaler)
(use Feature)
(use Timer)
(use Actor)
(use System)

(public
	clubFrontRm 0
)

(instance clubFrontRm of ExitRoom
	(properties
		picture 4301
	)

	(method (init)
		(if (gSoundManager soundArray:)
			(gSoundManager fade: 0 10 10 1 turnOffSound)
		)
		(if (IsFlag 116) ; "Die K\94niglich-Bayrische Hofjagdloge" in rm4220
			(= noun 16)
		else
			(= noun 27)
		)
		(self setRegions: 4599) ; clubRegion
		(super init: &rest)
		(fStreet init:)
		(fDoor init:)
		(if (OneOf gPrevRoomNum 440 4402) ; clubMainRm
			(gEgo
				posn: 200 332
				heading: 45
				normalize:
				setScaler: Scaler 101 79 339 288
				init:
			)
		else
			(gEgo
				posn: 455 332
				heading: 315
				normalize:
				setScaler: Scaler 101 79 339 288
				init:
			)
		)
		(switch gChapter
			(1
				(pXaver init:)
				(cond
					((!= gPrevRoomNum 4320)
						(if (IsFlag 520)
							(PlayScene 101 0 4320) ; rm4320
						else
							(SetFlag 520)
							(PlayScene 100 0 4320) ; rm4320
						)
					)
					((IsFlag 31)
						(ClearFlag 31)
						(tProof setReal: tProof 10)
						(gGame handsOn:)
					)
					(else
						(ClearFlag 32)
						(PlayScene 106 0 4102) ; rm4102
					)
				)
			)
			(3
				(if (gTimers contains: (ScriptID 4599 2)) ; xGoneTimer
					(fDesk init:)
				else
					(pXaver init:)
				)
				(cond
					((== gPrevRoomNum 4342)
						(if (gTimers contains: (ScriptID 4599 2)) ; xGoneTimer
							(self setScript: sEnterFromDesk)
						else
							(gGame handsOn:)
						)
					)
					((== gPrevRoomNum 4341)
						(if (gTimers contains: (ScriptID 4599 2)) ; xGoneTimer
							(self setScript: sEnterFromDesk)
						else
							(gGame handsOn:)
						)
					)
					((IsFlag 539)
						(gGame handsOn:)
					)
					(else
						(SetFlag 539)
						(self setScript: sFirstTimeInChapter3)
					)
				)
			)
			(else
				(pXaver init:)
				(cond
					(
						(and
							(== gPrevRoomNum 4111)
							(gEgo has: 55) ; invWolfTags
							(IsFlag 341)
							(IsFlag 321) ; "Missing Persons" in rm4220b
							(IsFlag 678)
						)
						(gCurRoom setScript: sLeaveForHuntingLodge)
					)
					((not (IsFlag 352))
						(SetFlag 352)
						(gCurRoom setScript: sFirstTimeInChapter5)
					)
					(else
						(gGame handsOn:)
					)
				)
			)
		)
	)

	(method (cue)
		(fDesk dispose:)
		(pXaver init:)
		(if (IsFlag 523)
			(PlayScene 254)
		else
			(SetFlag 523)
			(PlayScene 254)
		)
	)

	(method (notify)
		(fDesk init:)
		(pXaver dispose:)
		(if (IsFlag 522)
			(PlayScene 253)
		else
			(SetFlag 522)
			(PlayScene 252)
		)
	)

	(method (dispose)
		(if (gTimers contains: tProof)
			(tProof dispose: delete:)
		)
		(super dispose: &rest)
	)
)

(instance turnOffSound of Script
	(properties)

	(method (cue)
		(gSoundManager stop:)
	)
)

(instance sEnterFromDesk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				((ScriptID 4599 2) dispose: delete:) ; xGoneTimer
				(fDesk dispose:)
				(pXaver init:)
				(if (!= gPrevRoomNum 4342)
					(PlayScene 256 0 -1)
				)
				(if (IsFlag 523)
					(PlayScene 254 self)
				else
					(SetFlag 523)
					(PlayScene 254 self)
				)
			)
			(2
				(if (or (IsFlag 543) (IsFlag 544))
					(ClearFlag 544)
					(ClearFlag 543)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveForHuntingLodge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(PlayScene 561 0 500) ; lodgeExtRm
				(self dispose:)
			)
		)
	)
)

(instance sFirstTimeInChapter3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(PlayScene 250 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFirstTimeInChapter5 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(PlayScene 560 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pXaver of Prop
	(properties
		modNum 430
		sightAngle 360
		x 318
		y 133
		signal 30753
	)

	(method (doVerb theVerb)
		(if (== gChapter 5)
			(gMessager say: 5 0 0 0 0 430) ; "(HUNT CLUB. CLICK ON XAVER CH 5, DRY)I'm not in the mood to communicate with the dead today."
		else
			(switch theVerb
				(62 ; Do
					(switch gChapter
						(1
							(gMessager say: 9 62 0 0 0 430) ; "(CLICK ON XAVER DURING 'SHOW PAPERS' TIME CH 1)He's bein' pretty stubborn about that proof of heritage stuff."
						)
						(3
							(cond
								((IsFlag 54)
									(gMessager say: 25 0 0 0 0 430) ; "(PICKUP, TRY TO TALK TO XAVER CH 3 CLUB MTG HAS STARTED)There're more interestin' people to talk to in the back."
								)
								((IsFlag 506)
									(gMessager say: 26 0 0 0 0 430) ; "(PICKUP, TRY TO TALK TO XAVER CH 3 PREISS TIME FRAME)It's gettin' a bit late in the day to pick on Xaver. He's probably all asweat waitin' for the boys to arrive."
								)
								((IsFlag 52)
									(gMessager say: 24 0 0 0 0 430) ; "(TRY TO TALK TO XAVER CH 3 ALL DIALOGUE IS DONE, DRY)I think I've pumped that particular well dry."
								)
								(else
									(PlayScene 262 0 4320) ; rm4320
								)
							)
						)
						(5
							(gMessager say: 5 0 0 0 0 430) ; "(HUNT CLUB. CLICK ON XAVER CH 5, DRY)I'm not in the mood to communicate with the dead today."
						)
					)
				)
				(60 ; invRitterPapers
					(if (not (IsFlag 519))
						(SetFlag 519)
						(gEgo put: 14) ; invRitterPapers
						(tProof dispose: delete:)
						(PlayScene 105 0 12) ; endChapter
					else
						(gMessager say: 4 0 0 0 0 430) ; "(TRY TO SHOW XAVER SOMETHING ELSE)That wouldn't impress this guy."
					)
				)
				(39 ; invXaverKeys
					(gMessager say: 8 39 0 0 0 430) ; "(TRY TO SHOW XAVER HIS OWN KEYS)That probably wouldn't be a great idea."
				)
				(18 ; ???
					(gMessager say: 8 39 0 0 0 430) ; "(TRY TO SHOW XAVER HIS OWN KEYS)That probably wouldn't be a great idea."
				)
				(8 ; invTalisman
					(gMessager say: 3 8 0 0 0 430) ; "(TRY TO SHOW TALISMAN TO XAVER)This guy wouldn't know anything about the talisman."
				)
				(else
					(gMessager say: 4 0 0 0 0 430) ; "(TRY TO SHOW XAVER SOMETHING ELSE)That wouldn't impress this guy."
				)
			)
		)
	)

	(method (init)
		(if (== gChapter 1)
			(= view 22102)
			(= x 311)
			(= y 132)
		else
			(= view 20251)
		)
		(super init: &rest)
		(self setScript: FidgetScript)
	)
)

(instance fDesk of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(self
			createPoly:
				257
				324
				257
				182
				249
				182
				249
				177
				269
				172
				394
				171
				394
				180
				383
				180
				384
				327
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(PlayScene 255 0 4341) ; rm4341
			)
			(39 ; invXaverKeys
				(gGame handsOff:)
				(FrameOut)
				(SetFlag 542)
				(PlayScene 255 0 4342) ; rm4342
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fDoor of ExitFeature
	(properties
		approachY 300
		exitDir 1
	)

	(method (init)
		(self createPoly: -1 319 -1 0 98 17 109 289)
		(super init: &rest)
	)

	(method (handleEvent event)
		(if
			(and
				(self onMe: event)
				(or (gTimers contains: (ScriptID 4599 2)) (== gChapter 1)) ; xGoneTimer
			)
			(= global141 self)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(cond
				((== gChapter 1)
					(gMessager say: 1 62 0 0 0 430) ; "(LOOK PAST XAVER BEFORE GETTING IN, CH 1)I wouldn't mind going back there, but SOMEBODY'S blockin' the way."
				)
				((gTimers contains: (ScriptID 4599 2)) ; xGoneTimer
					((ScriptID 4599 2) dispose: delete:) ; xGoneTimer
					(gCurRoom cue:)
				)
				((and (IsFlag 54) (== gChapter 3))
					(gCurRoom newRoom: 4402)
				)
				(else
					(gCurRoom newRoom: 440) ; clubMainRm
				)
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fStreet of ExitFeature
	(properties
		sightAngle 0
		approachX 700
		approachY 300
		nextRoomNum 4102 ; rm4102
		exitDir 2
	)

	(method (init)
		(self createPoly: 571 334 571 -1 615 -1 616 334)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (gTimers contains: (ScriptID 4599 2)) ; xGoneTimer
					((ScriptID 4599 2) dispose: delete:) ; xGoneTimer
				)
				(if (gTimers contains: (ScriptID 4599 1)) ; cuckooTimer
					((ScriptID 4599 1) dispose: delete:) ; cuckooTimer
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tProof of Timer
	(properties)

	(method (cue)
		(if (not (DoAudio audWPLAY))
			(PlayScene 102 0 4102) ; rm4102
		else
			(self setReal: self 2)
		)
	)
)

