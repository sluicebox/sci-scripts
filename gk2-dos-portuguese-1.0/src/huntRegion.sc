;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 499)
(include sci.sh)
(use Main)
(use n011)
(use Print)
(use Scaler)
(use Feature)
(use Timer)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	huntRegion 0
	ChaseTimer 1
	WolfTimer 2
	pWolf 3
	proc499_4 4
	HuntExit 5
)

(local
	local0 = -1
	local1 = -1
	local2 = -1
	local3
	local4
)

(procedure (proc499_4)
	(cond
		((== global144 1)
			(if (and (!= gCurRoomNum 651) (!= gCurRoomNum 501)) ; hravineRm, hlodgeExtRm
				(pWolf init:)
				(SetWolfPosn doit:)
				(WolfTimer setReal: WolfTimer 10)
			)
			(if (and (!= gCurRoomNum 501) (!= gCurRoomNum 651)) ; hlodgeExtRm, hravineRm
				(= global136 gCurRoomNum)
			)
		)
		((!= gCurRoomNum global136)
			(if (gTimers contains: WolfTimer)
				(WolfTimer delete:)
			)
			(= global136 gPrevRoomNum)
			(if (and (!= gCurRoomNum 651) (!= gCurRoomNum 501)) ; hravineRm, hlodgeExtRm
				(ChaseTimer setReal: ChaseTimer 10)
			)
		)
		(else
			(if (gTimers contains: ChaseTimer)
				(ChaseTimer delete:)
			)
			(cond
				((and (!= gCurRoomNum 651) (!= gCurRoomNum 501)) ; hravineRm, hlodgeExtRm
					(WhichSideIsGabe doit:)
					(SetWolfPosn doit:)
					(pWolf init:)
					(if (OneOf local2 1 4)
						(PlayScene 1688)
					else
						(PlayScene 688)
					)
					(= global144 1)
					(WolfTimer setReal: WolfTimer 10)
				)
				((== gPrevRoomNum 606) ; hwoods2Rm
					(= global136 621)
				)
				(else
					(= global136 606)
				)
			)
		)
	)
	(if local4
		(Printf {wolf is now in %d } global136)
	)
)

(instance huntRegion of Rgn
	(properties
		modNum 600
		keep 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: wolfSoundScr)
	)
)

(instance wolfSoundScr of Script
	(properties)

	(method (dispose)
		(gGk2Sound client: 0 stop:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 20))
			)
			(1
				(cond
					((== gCurRoomNum 501) ; hlodgeExtRm
						(= cycles 2)
					)
					((and (!= gCurRoomNum 651) (!= gCurRoomNum global136)) ; hravineRm
						(if (Random 0 1)
							(Lock 140 602 1) ; WAVE
							(gGk2Sound setLoop: 1 number: 602 play: self)
						else
							(Lock 140 603 1) ; WAVE
							(gGk2Sound setLoop: 1 number: 603 play: self)
						)
					)
				)
			)
			(2
				(Lock 140 602 0) ; WAVE
				(Lock 140 603 0) ; WAVE
				(self init:)
			)
		)
	)
)

(instance disposeWolf of Script
	(properties)

	(method (cue)
		(gGame handsOn: 0)
		(pWolf dispose:)
	)
)

(instance sWolfFidget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pWolf cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 1 2))
			)
			(2
				(pWolf setCycle: Beg self)
			)
			(3
				(= seconds (Random 1 2))
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance pWolf of Prop
	(properties
		heading -1
		modNum 600
		sightAngle 360
		x -1
		y -1
		view 201
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 8 62 0 1 0 600) ; "(LOOK AT WOLF DURING HUNT IN WOODS)Yeah. It's a WOLF."
			)
			(135 ; invGun
				(self hide:)
				(if (gTimers contains: ChaseTimer)
					(ChaseTimer dispose:)
				)
				(if (gTimers contains: WolfTimer)
					(WolfTimer dispose:)
				)
				(gGame BAD_SELECTOR: 0)
				(gEgo put: 81) ; invGun
				(ClearFlag 407)
				(gCurRoom newRoom: 12) ; endChapter
			)
			(23 ; invRitterDagger
				(gMessager say: 9 23 0 1 0 600) ; "(TRY TO USE DAGGER ON WOLF IN WOODS)I don't want to GET that close."
			)
			(8 ; invTalisman
				(gGame handsOff:)
				(= global144 0)
				(WhichSideIsGabe doit:)
				(if (> (gEgo x:) (pWolf x:))
					(PlayScene 696)
				else
					(PlayScene 1696)
				)
				(self setScript: 0)
				(switch gCurRoomNum
					(601 ; hwoods1Rm
						(switch (Random 1 3)
							(1
								(if (!= local2 4)
									(= local3 626)
									(= local0 4)
									(LeaveWoods1 doit: 4)
								else
									(= local3 611)
									(= local0 3)
									(LeaveWoods1 doit: 3)
								)
							)
							(2
								(if (!= local2 3)
									(= local3 611)
									(= local0 3)
									(LeaveWoods1 doit: 3)
								else
									(= local3 626)
									(= local0 4)
									(LeaveWoods1 doit: 4)
								)
							)
							(3
								(if (!= local2 2)
									(= local3 606)
									(= local0 2)
									(LeaveWoods1 doit: 2)
								else
									(= local3 611)
									(= local0 3)
									(LeaveWoods1 doit: 3)
								)
							)
						)
					)
					(606 ; hwoods2Rm
						(switch (Random 1 3)
							(1
								(if (!= local2 4)
									(= local3 601)
									(= local0 4)
									(LeaveWoods2 doit: 4)
								else
									(= local3 616)
									(= local0 3)
									(LeaveWoods2 doit: 3)
								)
							)
							(2
								(if (!= local2 3)
									(= local3 616)
									(= local0 3)
									(LeaveWoods2 doit: 3)
								else
									(= local3 601)
									(= local0 4)
									(LeaveWoods2 doit: 4)
								)
							)
							(3
								(if (!= local2 2)
									(= local3 501)
									(= local0 2)
									(LeaveWoods2 doit: 2)
								else
									(= local3 616)
									(= local0 3)
									(LeaveWoods2 doit: 3)
								)
							)
						)
					)
					(611 ; hwoods3Rm
						(switch (Random 1 4)
							(1
								(if (!= local2 1)
									(= local3 601)
									(= local0 1)
									(LeaveWoods3 doit: 1)
								else
									(= local3 616)
									(= local0 2)
									(LeaveWoods3 doit: 2)
								)
							)
							(2
								(if (!= local2 2)
									(= local3 616)
									(= local0 2)
									(LeaveWoods3 doit: 2)
								else
									(= local3 651)
									(= local0 3)
									(LeaveWoods3 doit: 3)
								)
							)
							(3
								(if (!= local2 3)
									(= local3 651)
									(= local0 3)
									(LeaveWoods3 doit: 3)
								else
									(= local3 601)
									(= local0 1)
									(LeaveWoods3 doit: 1)
								)
							)
							(4
								(if (!= local2 3)
									(= local3 651)
									(= local0 3)
									(LeaveWoods3 doit: 3)
								else
									(= local3 616)
									(= local0 2)
									(LeaveWoods3 doit: 2)
								)
							)
						)
					)
					(616 ; hwoods4Rm
						(switch (Random 1 2)
							(1
								(if (!= local2 1)
									(= local3 606)
									(= local0 1)
									(LeaveWoods4 doit: 1)
								else
									(= local3 611)
									(= local0 4)
									(LeaveWoods4 doit: 4)
								)
							)
							(2
								(if (!= local2 4)
									(= local3 611)
									(= local0 4)
									(LeaveWoods4 doit: 4)
								else
									(= local3 606)
									(= local0 1)
									(LeaveWoods4 doit: 1)
								)
							)
						)
					)
					(621 ; hwoods5Rm
						(switch (Random 1 3)
							(1
								(if (!= local2 4)
									(= local3 501)
									(LeaveWoods5 doit: 4)
									(= local0 4)
								else
									(= local3 626)
									(= local0 2)
									(LeaveWoods5 doit: 2)
								)
							)
							(2
								(if (!= local2 2)
									(= local3 626)
									(= local0 2)
									(LeaveWoods5 doit: 2)
								else
									(= local3 501)
									(= local0 4)
									(LeaveWoods5 doit: 4)
								)
							)
							(3
								(if (!= local2 3)
									(= local3 631)
									(= local0 3)
									(LeaveWoods5 doit: 3)
								else
									(= local3 626)
									(= local0 2)
									(LeaveWoods5 doit: 2)
								)
							)
						)
					)
					(626 ; hunt6Rm
						(switch (Random 1 3)
							(1
								(if (!= local2 4)
									(= local3 621)
									(= local0 4)
									(LeaveWoods6 doit: 4)
								else
									(= local3 601)
									(= local0 2)
									(LeaveWoods6 doit: 2)
								)
							)
							(2
								(if (!= local2 3)
									(= local3 636)
									(= local0 3)
									(LeaveWoods6 doit: 3)
								else
									(= local3 601)
									(= local0 2)
									(LeaveWoods6 doit: 2)
								)
							)
							(3
								(if (!= local2 2)
									(= local3 601)
									(= local0 2)
									(LeaveWoods6 doit: 2)
								else
									(= local3 621)
									(= local0 4)
									(LeaveWoods6 doit: 4)
								)
							)
						)
					)
					(631 ; hwoods7Rm
						(switch (Random 1 2)
							(1
								(if (!= local2 1)
									(= local3 621)
									(= local0 1)
									(LeaveWoods7 doit: 1)
								else
									(= local3 636)
									(= local0 2)
									(LeaveWoods7 doit: 2)
								)
							)
							(2
								(if (!= local2 2)
									(= local3 636)
									(= local0 2)
									(LeaveWoods7 doit: 2)
								else
									(= local3 621)
									(= local0 1)
									(LeaveWoods7 doit: 1)
								)
							)
						)
					)
					(636 ; hwoods8Rm
						(switch (Random 1 3)
							(1
								(if (!= local2 1)
									(= local3 626)
									(= local0 1)
									(LeaveWoods8 doit: 1)
								else
									(= local3 631)
									(= local0 4)
									(LeaveWoods8 doit: 4)
								)
							)
							(2
								(if (!= local2 4)
									(= local3 631)
									(= local0 4)
									(LeaveWoods8 doit: 4)
								else
									(= local3 626)
									(= local0 1)
									(LeaveWoods7 doit: 1)
								)
							)
							(3
								(if (!= local2 3)
									(= local3 641)
									(= local0 3)
									(LeaveWoods8 doit: 3)
								else
									(= local3 626)
									(= local0 1)
									(LeaveWoods7 doit: 1)
								)
							)
						)
					)
				)
				(= global136 local3)
				(if local4
					(Printf {wolf ran to room %d} local3)
				)
				(ChaseTimer setReal: ChaseTimer 10)
			)
			(else
				(gMessager say: 17 0 0 1 0 600) ; "(TRY TO USE DAGGER ON WOLF IN WOODS)I don't want to GET that close."
				(super doVerb: theVerb)
			)
		)
	)
)

(instance WolfTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				(== gChapter 5)
				(!= gCurRoomNum 651) ; hravineRm
				(!= gCurRoomNum 501) ; hlodgeExtRm
				(!= gCurRoomNum 641) ; hlairExtRm
				(!= gCurRoomNum 666) ; uDie
				(== gCurRoomNum global136)
			)
			(wolfSoundScr dispose:)
			(gGk2Music fade: 0 20 10 1)
			(Lock rsAUDIO 606 0)
			(PlayScene 690 0 666) ; uDie
		)
	)
)

(instance ChaseTimer of Timer
	(properties)

	(method (cue)
		(if
			(and
				(== gChapter 5)
				(!= gCurRoomNum 651) ; hravineRm
				(!= gCurRoomNum 501) ; hlodgeExtRm
				(!= gCurRoomNum 641) ; hlairExtRm
				(!= gCurRoomNum 666) ; uDie
				(!= gCurRoomNum global136)
			)
			(WhichSideIsGabe doit:)
			(if (OneOf local2 1 4)
				(PlayScene 1688)
			else
				(PlayScene 688)
			)
			(= global136 gCurRoomNum)
			(pWolf init:)
			(SetWolfPosn doit:)
			(= global144 1)
			(WolfTimer setReal: WolfTimer 10)
		)
	)
)

(instance WhichSideIsGabe of Code
	(properties)

	(method (doit)
		(switch (gEgo heading:)
			(180
				(= local2 1)
			)
			(0
				(= local2 3)
			)
			(90
				(= local2 4)
			)
			(else
				(= local2 2)
			)
		)
	)
)

(instance WhichSideIsWolf of Code
	(properties)

	(method (doit)
		(switch (pWolf heading:)
			(180
				(= local1 1)
			)
			(0
				(= local1 3)
			)
			(90
				(= local1 4)
			)
			(else
				(= local1 2)
			)
		)
	)
)

(instance SetWolfPosn of Code
	(properties)

	(method (doit)
		(switch gCurRoomNum
			(601 ; hwoods1Rm
				(if (== global144 1)
					(switch gPrevRoomNum
						(606 ; hwoods2Rm
							(= local1 2)
						)
						(626 ; hunt6Rm
							(= local1 4)
						)
						(else
							(= local1 3)
						)
					)
				else
					(switch local2
						(2
							(= local1 4)
						)
						(else
							(= local1 2)
						)
					)
				)
				(switch local1
					(2
						(pWolf
							view: 201
							loop: 2
							cel: 0
							posn: 472 223
							setScaler: Scaler 83 63 258 219
							heading: 270
						)
					)
					(4
						(pWolf
							view: 201
							loop: 3
							cel: 0
							posn: 104 279
							heading: 90
							setScaler: Scaler 83 63 258 219
						)
					)
					(else
						(pWolf
							view: 205
							loop: 1
							cel: 0
							setScale: 0
							posn: 240 358
							heading: 0
						)
					)
				)
			)
			(606 ; hwoods2Rm
				(if (== global144 1)
					(switch gPrevRoomNum
						(601 ; hwoods1Rm
							(= local1 4)
						)
						(616 ; hwoods4Rm
							(= local1 3)
						)
						(else
							(if (== global136 621)
								(= local1 2)
							else
								(= local1 4)
							)
						)
					)
				else
					(switch local2
						(1
							(= local1 3)
						)
						(2
							(= local1 4)
						)
						(else
							(= local1 2)
						)
					)
				)
				(switch local1
					(3
						(pWolf
							view: 205
							loop: 1
							cel: 0
							posn: 140 340
							setScale: 0
							heading: 0
						)
					)
					(4
						(pWolf
							view: 201
							loop: 3
							cel: 0
							posn: 82 246
							setScaler: Scaler 58 45 224 194
							heading: 90
						)
					)
					(else
						(pWolf
							view: 201
							loop: 2
							cel: 0
							posn: 248 264
							setScaler: Scaler 58 45 224 194
							heading: 270
						)
					)
				)
			)
			(611 ; hwoods3Rm
				(if (== global144 1)
					(switch gPrevRoomNum
						(601 ; hwoods1Rm
							(= local1 1)
						)
						(else
							(= local1 3)
						)
					)
				else
					(switch local2
						(3
							(= local1 1)
						)
						(else
							(= local1 3)
						)
					)
				)
				(switch local1
					(1
						(pWolf
							view: 204
							loop: 1
							cel: 0
							setScaler: Scaler 69 26 332 203
							posn: 371 216
							heading: 180
						)
					)
					(else
						(pWolf
							view: 205
							loop: 1
							cel: 0
							setScale: 0
							posn: 402 357
							heading: 0
						)
					)
				)
			)
			(616 ; hwoods4Rm
				(if (== 1 global144)
					(switch gPrevRoomNum
						(606 ; hwoods2Rm
							(= local1 1)
						)
						(else
							(= local1 4)
						)
					)
				else
					(switch local2
						(4
							(= local1 1)
						)
						(else
							(= local1 4)
						)
					)
				)
				(switch local1
					(1
						(pWolf
							view: 204
							loop: 1
							cel: 0
							setScaler: Scaler 85 37 325 226
							posn: 95 226
							heading: 180
						)
					)
					(else
						(pWolf
							view: 201
							loop: 3
							cel: 0
							setScaler: Scaler 78 57 263 203
							posn: 58 320
							heading: 90
						)
					)
				)
			)
			(621 ; hwoods5Rm
				(if (== 1 global144)
					(switch gPrevRoomNum
						(626 ; hunt6Rm
							(= local1 2)
						)
						(631 ; hwoods7Rm
							(= local1 3)
						)
						(else
							(if (== global136 606)
								(= local1 4)
							else
								(= local1 2)
							)
						)
					)
				else
					(switch local2
						(1
							(= local1 3)
						)
						(2
							(= local1 4)
						)
						(else
							(= local1 2)
						)
					)
				)
				(switch local1
					(3
						(pWolf
							view: 205
							loop: 1
							cel: 0
							setScale: 0
							posn: 247 374
							heading: 0
						)
					)
					(4
						(pWolf
							view: 201
							loop: 3
							cel: 0
							posn: 90 275
							setScaler: Scaler 63 28 321 241
							heading: 90
						)
					)
					(else
						(pWolf
							view: 201
							loop: 2
							cel: 0
							posn: 535 258
							setScaler: Scaler 63 28 321 241
							heading: 270
						)
					)
				)
			)
			(626 ; hunt6Rm
				(if (== 1 global144)
					(switch gPrevRoomNum
						(621 ; hwoods5Rm
							(= local1 4)
						)
						(else
							(= local1 2)
						)
					)
				else
					(switch local2
						(2
							(= local1 4)
						)
						(else
							(= local1 2)
						)
					)
				)
				(switch local1
					(2
						(pWolf
							view: 201
							loop: 2
							cel: 0
							setScaler: Scaler 75 61 276 220
							posn: 525 230
							heading: 270
						)
					)
					(else
						(pWolf
							view: 201
							loop: 3
							cel: 0
							setScaler: Scaler 75 61 276 220
							posn: 194 331
							heading: 90
						)
					)
				)
			)
			(631 ; hwoods7Rm
				(if (== 1 global144)
					(switch gPrevRoomNum
						(621 ; hwoods5Rm
							(= local1 1)
						)
						(else
							(= local1 2)
						)
					)
				else
					(switch local2
						(2
							(= local1 1)
						)
						(else
							(= local1 2)
						)
					)
				)
				(switch local1
					(1
						(pWolf
							view: 204
							cel: 0
							loop: 2
							setScaler: Scaler 53 32 288 208
							posn: 346 287
							heading: 180
						)
					)
					(else
						(pWolf
							view: 201
							loop: 2
							cel: 0
							setScaler: Scaler 100 81 329 277
							posn: 544 334
							heading: 270
						)
					)
				)
			)
			(636 ; hwoods8Rm
				(if (== 1 global144)
					(switch gPrevRoomNum
						(631 ; hwoods7Rm
							(= local1 4)
						)
						(else
							(= local1 1)
						)
					)
				else
					(switch local2
						(1
							(= local1 4)
						)
						(else
							(= local1 1)
						)
					)
				)
				(switch local1
					(1
						(pWolf
							view: 204
							loop: 2
							cel: 0
							setScaler: Scaler 30 28 197 191
							posn: 180 199
							heading: 180
						)
					)
					(else
						(pWolf
							view: 201
							loop: 3
							cel: 0
							setScaler: Scaler 75 41 297 209
							posn: 94 251
							heading: 90
						)
					)
				)
			)
		)
		(pWolf setScript: sWolfFidget)
	)
)

(instance LeaveWoods1 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 18
					setScaler: Scaler 83 63 258 219
					posn: 570 109
					setCycle: Beg disposeWolf
				)
			)
			(4
				(pWolf
					view: 201
					loop: 1
					cel: 18
					setScaler: Scaler 83 63 258 219
					posn: 3 215
					setCycle: Beg disposeWolf
				)
			)
			(else
				(pWolf
					view: 205
					loop: 0
					cel: 11
					setScale: 0
					posn: 236 473
					setCycle: Beg disposeWolf
				)
			)
		)
	)
)

(instance LeaveWoods2 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 17
					setScaler: Scaler 58 45 224 194
					posn: 633 176
					setCycle: Beg disposeWolf
				)
			)
			(4
				(pWolf
					view: 201
					loop: 1
					cel: 23
					setScaler: Scaler 58 45 224 194
					posn: 0 197
					setCycle: Beg disposeWolf
				)
			)
			(else
				(pWolf
					view: 205
					loop: 0
					cel: 11
					setScale: 0
					posn: 198 470
					setCycle: Beg disposeWolf
				)
			)
		)
	)
)

(instance LeaveWoods3 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 22
					setScaler: Scaler 100 47 288 217
					posn: 628 228
					setCycle: Beg disposeWolf
				)
			)
			(1
				(pWolf dispose:)
			)
			(else
				(pWolf
					view: 205
					loop: 0
					cel: 11
					setScale: 0
					posn: 417 479
					setCycle: Beg disposeWolf
				)
			)
		)
	)
)

(instance LeaveWoods4 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(4
				(pWolf
					view: 201
					loop: 1
					cel: 13
					setScaler: Scaler 78 57 263 203
					posn: -30 275
					setCycle: Beg disposeWolf
				)
			)
			(else
				(pWolf dispose:)
			)
		)
	)
)

(instance LeaveWoods5 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 26
					setScaler: Scaler 63 28 321 241
					posn: 616 230
					setCycle: Beg disposeWolf
				)
			)
			(4
				(pWolf
					view: 201
					loop: 1
					cel: 22
					setScaler: Scaler 63 28 321 241
					posn: 17 243
					setCycle: Beg disposeWolf
				)
			)
			(else
				(pWolf
					view: 205
					loop: 0
					cel: 11
					setScale: 0
					posn: 273 473
					setCycle: Beg disposeWolf
				)
			)
		)
	)
)

(instance LeaveWoods6 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 22
					setScaler: Scaler 75 61 276 220
					posn: 673 187
					setCycle: Beg disposeWolf
				)
			)
			(4
				(pWolf
					view: 201
					loop: 1
					cel: 24
					setScaler: Scaler 75 61 276 220
					posn: 54 227
					setCycle: Beg disposeWolf
				)
			)
			(else
				(pWolf
					view: 205
					loop: 0
					cel: 11
					setScale: 0
					posn: 273 473
					setCycle: Beg disposeWolf
				)
			)
		)
	)
)

(instance LeaveWoods7 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 22
					setScaler: Scaler 100 81 329 277
					posn: 613 263
					setCycle: Beg disposeWolf
				)
			)
			(else
				(pWolf dispose:)
			)
		)
	)
)

(instance LeaveWoods8 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(2
				(pWolf
					view: 201
					loop: 0
					cel: 22
					setScaler: Scaler 75 41 297 209
					posn: 628 228
					setCycle: Beg disposeWolf
				)
			)
			(4
				(pWolf
					view: 201
					loop: 1
					cel: 23
					setScaler: Scaler 75 41 297 209
					posn: 3 246
					setCycle: Beg disposeWolf
				)
			)
			(1
				(pWolf dispose:)
			)
			(else
				(pWolf
					view: 205
					loop: 0
					cel: 11
					setScale: 0
					posn: 236 472
					setCycle: Beg disposeWolf
				)
			)
		)
	)
)

(class HuntExit of ExitFeature
	(properties)

	(method (handleEvent event)
		(if (and (self onMe: event) (== (event message:) JOY_UPLEFT))
			(event message: $003e) ; >
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb)
		(WhichSideIsWolf doit:)
		(if
			(and
				(== global136 gCurRoomNum)
				(or
					(and (== local1 2) (== BAD_SELECTOR 2))
					(and (== local1 4) (== BAD_SELECTOR 6))
					(and (== local1 3) (== BAD_SELECTOR 4))
					(and (== local1 1) (== BAD_SELECTOR 0))
				)
			)
			(if (gTimers contains: WolfTimer)
				(WolfTimer delete:)
			)
			(if (gTimers contains: ChaseTimer)
				(ChaseTimer delete:)
			)
			(wolfSoundScr dispose:)
			(gGk2Music fade: 0 20 10 1)
			(Lock rsAUDIO 606 0)
			(PlayScene 690 0 666) ; uDie
		else
			(super doVerb: 62)
		)
	)
)

