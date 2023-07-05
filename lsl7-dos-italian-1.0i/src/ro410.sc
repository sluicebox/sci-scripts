;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use L7TalkWindow)
(use CycleCueList)
(use CueMe)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use Scaler)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	ro410 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16 = 5
	local17 = 7
	local18
	local19
	local20
)

(procedure (localproc_0)
	(oScore1 init: 167 127 2 showNewScore: 0 (Random 0 7) (Random 0 9))
	(oScore2 init: 318 120 5 showNewScore: 0 (Random 0 2) (Random 0 7))
	(oScore3 init: 446 123 8 showNewScore: 0 (Random 0 5) (Random 0 9))
	(oScore4 init: 576 136 11 showNewScore: 0 (Random 0 6) (Random 0 7))
)

(procedure (localproc_1)
	(switch local1
		(0
			(if (oScore1 doUpdate:)
				(oScore1 updateRandom: 3 2)
			)
		)
		(1
			(if (oScore2 doUpdate:)
				(oScore2 update:)
			)
		)
		(2
			(if (oScore3 doUpdate:)
				(oScore3 updateRandom: 5 7)
			)
		)
		(3
			(if (oScore4 doUpdate:)
				(oScore4 update:)
			)
		)
	)
	(if (> (++ local1) 3)
		(= local1 0)
	)
)

(procedure (localproc_2)
	(poPinhead init:)
	(oScore1 showNewScore: 0 0 0 doUpdate: 1)
	(poMermaid init:)
	(oScore3 showNewScore: 0 0 0 doUpdate: 1)
	(poHulk init:)
	(oScore4 showNewScore: 0 0 0 doUpdate: 1)
)

(instance ro410 of L7Room
	(properties
		picture 41100
	)

	(method (init)
		(gEgo
			init:
			normalize: 7
			setScaler: Scaler 110 100 455 401
			posn: 320 470
		)
		(super init:)
		(= global330 0)
		(= gToVicki 0)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 609 461 605 406 523 386 392 386 338 388 287 388 263 387 166 388 87 465 232 473
					yourself:
				)
		)
		(poLavaLamp init: setCycle: Fwd)
		(poTheDoorsMan init:)
		(poRobot init:)
		(localproc_0)
		(oScore2 doUpdate: 0 showNewScore: 0 0 0)
		(localproc_2)
		(= local16 (Random 0 9))
		(= local17 (Random 0 9))
		(poALarry init: hide:)
		(foCardReader init:)
		(foLuvSign init:)
		(foLavaLamp init:)
		(foBigLavaBtn init:)
		(foBooth1 init:)
		(foBooth2 init:)
		(foBooth3 init:)
		(foBooth4 init:)
		(foScoreBD1 init:)
		(foScoreBD2 init:)
		(foScoreBD3 init:)
		(foScoreBD4 init:)
		(foExitMap init:)
		(voBoothLights init: hide:)
		(gOMusic1 setMusic: 41000)
		((ScriptID 64017 0) clear: 217) ; oFlags
		((ScriptID 64017 0) clear: 163) ; oFlags
		((ScriptID 64017 0) set: 306) ; oFlags
		(= local0 gGameTime)
		(if (not ((ScriptID 64017 0) test: 282)) ; oFlags
			((ScriptID 50 0) ; oDildo
				posn: 527 367
				setDest: 640 494
				view: 40123
				loop: 0
				cel: 0
				setPri: 300
				nMyFlag: 282
				oAltScript: soDildo
				init:
			)
		)
		(if
			(and
				(not ((ScriptID 64017 0) test: 113)) ; oFlags
				((ScriptID 64017 0) test: 168) ; oFlags
				((ScriptID 64017 0) test: 164) ; oFlags
				(not ((ScriptID 64017 0) test: 165)) ; oFlags
			)
			(gGame handsOff:)
			(gEgo hide: setScaler: Scaler 130 100 455 401 posn: 163 406)
			(poALarry show:)
			(poVicki init:)
			(voVicki init:)
			(gCurRoom setScript: soVickiUsesLuvMaster)
		else
			(gGame handsOn:)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (> (- gGameTime local0) 10)
			(localproc_1)
			(= local0 gGameTime)
		)
	)

	(method (dispose)
		(gOSound1 stop:)
		(if (gTimers contains: oMusicTimer)
			(oMusicTimer dispose: delete:)
		)
		(super dispose: &rest)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
	)
)

(instance soLarryUsesLuvMaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local12 1)
				(gGame handsOff:)
				((ScriptID 64017 0) set: 112) ; oFlags
				(UnmarkTopic global248 85)
				((ScriptID 64017 0) set: 217) ; oFlags
				(poALarry
					view: 41014
					loop: 0
					cel: 0
					posn: 155 396
					show:
					setCycle: End self 14 9999
				)
				(gEgo hide:)
			)
			(1
				(gOSound1 playSound: 41003)
			)
			(2
				(gOSound1 playSound: 41001 self)
				(poTheDoorsMan view: 41001 loop: 0 cel: 0 setCycle: End self)
			)
			(3 0)
			(4
				(poTheDoorsMan setPri: 370)
				(gEgo setPri: 600 show: walkTo: 304 400 self 1 1 1)
				(poALarry hide:)
			)
			(5
				(gEgo normalize: 3)
				(= cycles 1)
			)
			(6
				(poALarry
					view: 41002
					loop: 0
					cel: 0
					x: 300
					y: 400
					show:
					setCycle: End self
				)
				(gEgo hide:)
			)
			(7
				(gEgo normalize: 3 show: setMotion: MoveTo 313 350 self)
				(poALarry hide:)
			)
			(8
				(gOSound1 playSound: 41001 self)
				(poTheDoorsMan
					view: 41001
					loop: 0
					cel: 11
					setPri: 600
					setCycle: Beg self
				)
				(voBoothLights show:)
			)
			(9 0)
			(10
				(gMessager say: 2 16 0 1 self) ; "(LOTS OF FUNNY PORNO MOVIE SOUND FX) Oh. Yes. Ah! (YOU'RE DONE; QUIETLY) Oh."
			)
			(11
				(gOSound1 playSound: 41004 self)
				(oScore2 showNewScore: 0 0 1)
			)
			(12
				(gEgo hide: posn: 300 402 setPri: 600)
				(poALarry view: 41002 loop: 1 cel: 0 x: 300 y: 400 show:)
				(poTheDoorsMan view: 41001 loop: 0 cel: 0 setCycle: End self)
				(gOSound1 playSound: 41001 self)
				(oScore2 showNewScore: 0 0 2)
			)
			(13 0)
			(14
				(poTheDoorsMan setPri: 370)
				(poALarry setCycle: End self)
			)
			(15
				(gEgo normalize: 2 show:)
				(poALarry hide:)
				(poTheDoorsMan view: 41001 loop: 0 cel: 11 setCycle: Beg self)
				(gOSound1 playSound: 41001)
				(gMessager say: 2 16 0 2 self) ; "Wow! I bet I was in there an hour!"
				(voBoothLights hide:)
			)
			(16 0)
			(17
				(gMessager say: 2 16 0 3 self) ; "(MECHANICAL SOUNDING) Your score, Larry Laffer: (BEAT) two."
			)
			(18
				(gGame handsOn:)
				(gEgo normalize: 2 1)
				(self dispose:)
			)
		)
	)
)

(instance soVickiUsesLuvMaster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				((ScriptID 64017 0) set: 245) ; oFlags
				((ScriptID 64017 0) set: 112) ; oFlags
				((ScriptID 64017 0) set: 217) ; oFlags
				(poALarry
					view: 41014
					loop: 0
					cel: 0
					posn: 155 396
					show:
					setCycle: End self 14 9999
				)
			)
			(2
				(gOSound1 playSound: 41003)
			)
			(3
				(gOSound1 playSound: 41001 self)
				(poTheDoorsMan view: 41001 loop: 0 cel: 0 setCycle: End self)
			)
			(4 0)
			(5
				(oMermaidSFX setRelVol: 15)
				(poTheDoorsMan setPri: 370)
				(gEgo setPri: 600 show: walkTo: 162 480 self 1 1 1)
				(poALarry hide:)
			)
			(6
				(gEgo normalize: 6 1)
				(= gToVicki toVicki)
				(gMessager sayRange: 2 16 4 1 2 self) ; "Okay, Vicki. There ya go!"
			)
			(7
				(= local15 0)
				((ScriptID 64017 0) set: 305) ; oFlags
				(= local18 0)
				(oMusicTimer setReal: oMusicTimer 18)
				(gOMusic1 playSound: 41007 coEndMusic)
				(poAVicki
					view: 41003
					loop: 0
					cel: 0
					posn: 384 320
					setPri: 410
					init:
					setCycle: End self
				)
				(poVicki hide:)
				(voVicki hide:)
				(= gToVicki 0)
			)
			(8
				(gOSound1 playSound: 41001 self)
				(poAVicki setPri: 50)
				(poTheDoorsMan show: setCycle: Beg self)
			)
			(9 0)
			(10
				(voBoothLights show:)
				(poAVicki
					view: 41004
					loop: 0
					cel: 0
					posn: 380 318
					setCycle: End self 7 9999
				)
				(poALarry
					view: 41008
					loop: 0
					cel: 0
					x: 142
					y: 474
					priority: 500
					show:
					setScript: soLarryWatches
				)
				(gEgo hide:)
			)
			(11
				(voVickiClothes init:)
			)
			(12
				(gMessager say: 2 16 4 3) ; "(MANY RANDOM PORNO SOUND FX) Oh. Ah. Pant. Heavy breathing. (END WITH TARZAN YELL) Ahh-e-ah-e-ah-e-ah-e-ah!"
				(= local14 0)
				(self setScript: soSpinNumbers coEndTalk)
				(poAVicki
					view: 41004
					loop: 1
					cel: 0
					posn: 390 332
					setPri: 410
					doit:
					setCycle: End self
				)
			)
			(13
				(poAVicki
					view: 41004
					loop: 2
					cel: 0
					posn: 386 328
					doit:
					setCycle: End self
				)
			)
			(14
				(poAVicki
					view: 41004
					loop: 3
					cel: 0
					posn: 390 332
					doit:
					setCycle: Fwd
				)
				(= cycles 1)
			)
			(15
				(= cycles 1)
			)
			(16
				(cond
					(local18
						(self setScript: soBlowScore self)
					)
					((or local14 local15)
						(self setScript: soBlowScore self)
					)
					(else
						(self changeState: (- state 1))
					)
				)
			)
			(17
				(gEgo show:)
				(poALarry hide: setScript: 0)
				(self setScript: 0)
				(poRobotAfter init:)
				(poRobot dispose:)
				(poAVicki
					view: 41005
					loop: 0
					cel: 0
					posn: 384 320
					setPri: 100
					doit:
					setCycle: End self 7 13 14 22 9999
				)
			)
			(18
				(voVickiClothes dispose:)
			)
			(19
				(gOSound1 playSound: 41001)
				(poAVicki setPri: 410)
			)
			(20
				(poTheDoorsMan hide: loop: 0 cel: 11)
			)
			(21
				(poTheDoorsMan show:)
			)
			(22
				(gOSound1 stop:)
				(gOMusic1 setMusic: 41000)
				(voBoothLights hide:)
				(poVicki show:)
				(voVicki show:)
				(= gToVicki toVicki)
				(poAVicki hide:)
				(gMessager sayRange: 2 16 4 4 6 self) ; "Well? Let's see you top THAT!"
			)
			(23
				(= gToVicki 0)
				(gMessager say: 2 16 4 7 self) ; "But, wait! I didn't even lose all my clothes yet! (Sigh.)"
				(poAVicki
					view: 41006
					loop: 2
					cel: 0
					posn: 384 320
					setPri: 410
					show:
					setCycle: End self
				)
				(poVicki hide:)
				(voVicki hide:)
			)
			(24 0)
			(25
				(gMessager sayRange: 2 16 4 8 9 self) ; "(MECHANICAL SOUNDING) Your score, Larry Laffer: (BEAT) 1000. (LESS MECHANICAL) Wow. A perfect score. (SOFT & SEXY) Laffer. Come by the office, okay? I get off at midnight. Please."
			)
			(26
				((ScriptID 64017 0) set: 113) ; oFlags
				((ScriptID 64017 0) set: 165) ; oFlags
				((ScriptID 80 0) setReal: (ScriptID 80 0) 5) ; oAnnounceTimer, oAnnounceTimer
				(gEgo show:)
				(poALarry hide:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soBlowScore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gOSound1 playSound: 41006 self)
				(if
					(and
						(> ((oScore2 oDig100:) cel:) 8)
						(> ((oScore2 oDig10:) cel:) 8)
						(> ((oScore2 oDig1:) cel:) 8)
					)
					(poExplodeScore init: hide:)
				else
					(poExplodeScore init: hide: setScript: soKeepSpinning)
				)
			)
			(1
				(poExplodeScore setScript: 0 show: setCycle: End self)
				(gOSound1 playSound: 41010 self)
			)
			(2 0)
			(3
				(poAVicki
					view: 41005
					loop: 0
					cel: 0
					posn: 384 320
					setPri: 100
					doit:
					setCycle: 0
				)
				(gMessager kill:)
				(= local13 1)
				((ScriptID 64017 0) clear: 305) ; oFlags
				(self dispose:)
			)
		)
	)
)

(instance soSpinNumbers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oScore2 update:)
				(= cycles 1)
			)
			(1
				(if (> ((oScore2 oDig100:) cel:) 8)
					(if (> ((oScore2 oDig10:) cel:) 8)
						(if (> ((oScore2 oDig1:) cel:) 8)
							(= cycles 1)
						else
							(self changeState: (- state 1))
						)
					else
						(self changeState: (- state 1))
					)
				else
					(self changeState: (- state 1))
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soKeepSpinning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oScore2 update:)
				(= cycles 1)
			)
			(1
				(if (> ((oScore2 oDig100:) cel:) 8)
					(if (> ((oScore2 oDig10:) cel:) 8)
						(if (> ((oScore2 oDig1:) cel:) 8)
							(= cycles 1)
						else
							(self changeState: (- state 1))
						)
					else
						(self changeState: (- state 1))
					)
				else
					(self changeState: (- state 1))
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soPinhead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poPinhead setCycle: End self)
			)
			(1
				(voPinhead show:)
				(= cycles 1)
			)
			(2
				(if (> (= local2 (poPinhead cel:)) 9)
					(if (< (= local5 (- local2 (Random 3 7))) 0)
						(= local5 0)
					)
					(poPinhead setCycle: CT local5 -1 self)
				else
					(if (> (= local5 (+ local2 (Random 3 11))) 14)
						(= local5 14)
					)
					(poPinhead setCycle: CT local5 1 self)
				)
			)
			(3
				(if (> (+= local8 (Random 1 7)) 9)
					(= local8 0)
					(poPinhead cycleSpeed: (Random 1 4))
				)
				(= local20
					(+
						(* 100 ((oScore1 oDig100:) cel:))
						(* 10 ((oScore1 oDig10:) cel:))
						((oScore1 oDig1:) cel:)
					)
				)
				(= local19 (+ 600 (* 10 local16) local17))
				(if (>= local20 local19)
					(oScore1 doUpdate: 0)
				)
				(= cycles 1)
			)
			(4
				(self changeState: 2)
			)
		)
	)
)

(instance soMermaid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (= local3 (poMermaid cel:)) 7)
					(if (< (= local6 (- local3 (Random 3 6))) 0)
						(= local6 0)
					)
					(poMermaid setCycle: CT local6 -1 self)
				else
					(if (> (= local6 (+ local3 (Random 2 7))) 11)
						(= local6 11)
					)
					(poMermaid setCycle: CT local6 1 self)
				)
			)
			(1
				(if (> (+= local9 (Random 1 5)) 11)
					(oMermaidSFX playSound: 41008)
				)
				(if (> local9 8)
					(= local9 0)
					(poMermaid cycleSpeed: (Random 1 5))
				)
				(= local20
					(+
						(* 100 ((oScore3 oDig100:) cel:))
						(* 10 ((oScore3 oDig10:) cel:))
						((oScore3 oDig1:) cel:)
					)
				)
				(= local19 (+ 800 (* 10 local16) local17))
				(if (>= local20 local19)
					(oScore3 doUpdate: 0)
				)
				(= cycles 1)
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance soHulk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local4 (poHulk cel:))
				(cond
					(local11
						(if (> local4 3)
							(if (< (= local7 (- local4 (Random 1 3))) 0)
								(= local7 0)
							)
							(poHulk setCycle: CT local7 -1 self)
						else
							(if (> (= local7 (+ local4 (Random 1 3))) 5)
								(= local7 5)
							)
							(poHulk setCycle: CT local7 1 self)
						)
					)
					((> local4 5)
						(if (< (= local7 (- local4 (Random 1 7))) 0)
							(= local7 0)
						)
						(poHulk setCycle: CT local7 -1 self)
					)
					(else
						(if (> (= local7 (+ local4 (Random 2 5))) 9)
							(= local7 9)
						)
						(poHulk setCycle: CT local7 1 self)
					)
				)
			)
			(1
				(if (> (+= local10 (Random 1 7)) 400)
					(if local11
						(= local11 0)
						(poHulk
							loop: 0
							cel: 23
							cycleSpeed: (Random 5 15)
							setCycle: Beg self
						)
					else
						(= local11 1)
						(poHulk
							loop: 0
							cycleSpeed: (Random 6 20)
							setCycle: End self
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(if (> local10 400)
					(if (> local10 404)
						(oHulkSFX playSound: 41009)
					)
					(= local10 0)
					(if local11
						(poHulk loop: 1 cel: 0)
					else
						(poHulk loop: 0 cel: 0)
					)
				)
				(= local20
					(+
						(* 100 ((oScore4 oDig100:) cel:))
						(* 10 ((oScore4 oDig10:) cel:))
						((oScore4 oDig1:) cel:)
					)
				)
				(= local19 (+ 700 (* 10 local16) local17))
				(if (>= local20 local19)
					(oScore4 doUpdate: 0)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance soGiantLavaLamp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 12 160 0 1 self) ; "Are you sure? Okay..."
			)
			(1
				(poALarry
					view: 41015
					loop: 0
					cel: 0
					posn: 559 404
					show:
					setCycle: End self
				)
				(gEgo hide:)
			)
			(2
				(= local15 0)
				(oSound setRelVol: 300 playSound: 24502 coEndMusic)
				(= ticks 70)
			)
			(3
				(gEgo show:)
				(poALarry hide:)
				(= cycles 1)
			)
			(4
				(if (not local15)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(oSound setRelVol: 100)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soLarryWatches of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poALarry
					view: 41008
					loop: 0
					cel: 0
					x: 142
					y: 474
					priority: 500
					show:
				)
				(= ticks 720)
			)
			(1
				(poALarry setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soDildo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 50 0) setCycle: End self) ; oDildo
			)
			(1
				((ScriptID 50 0) hide:) ; oDildo
				(self dispose:)
			)
		)
	)
)

(class ScoreDigit of Prop
	(properties
		view 41010
	)

	(method (init param1 param2 param3)
		(super init:)
		(self loop: param3 posn: param1 param2)
	)

	(method (runIdle)
		(self cel: (Random 0 9) cycleSpeed: (Random 8 32) setCycle: Fwd)
	)

	(method (showNew param1)
		(self cel: param1 setCycle: 0)
	)

	(method (bumpVal &tmp temp0)
		(= temp0 (self cel:))
		(if (> (++ temp0) 9)
			(= temp0 0)
		)
		(self cel: temp0)
	)

	(method (bumpValRandom param1 &tmp temp0)
		(if (> (= temp0 (+ (= temp0 (self cel:)) (Random 1 param1))) 9)
			(= temp0 0)
		)
		(self cel: temp0)
	)
)

(class ScoreDisplay of Set
	(properties
		doUpdate 1
		oDig100 0
		oDig10 0
		oDig1 0
	)

	(method (init param1 param2 param3)
		(super init:)
		(= oDig100 (ScoreDigit new:))
		(= oDig10 (ScoreDigit new:))
		(= oDig1 (ScoreDigit new:))
		(oDig1 init: param1 param2 param3)
		(oDig10 init: param1 param2 (- param3 1))
		(oDig100 init: param1 param2 (- param3 2))
	)

	(method (idleAll)
		(oDig100 runIdle:)
		(oDig10 runIdle:)
		(oDig1 runIdle:)
	)

	(method (showNewScore param1 param2 param3)
		(oDig100 showNew: param1)
		(oDig10 showNew: param2)
		(oDig1 showNew: param3)
	)

	(method (update)
		(oDig1 bumpVal:)
		(if (== (oDig1 cel:) 0)
			(oDig10 bumpVal:)
			(if (== (oDig10 cel:) 0)
				(oDig100 bumpVal:)
			)
		)
	)

	(method (updateRandom param1 param2)
		(oDig1 bumpValRandom: param1)
		(if (== (oDig1 cel:) 0)
			(oDig10 bumpValRandom: param2)
			(if (== (oDig10 cel:) 0)
				(oDig100 bumpVal:)
			)
		)
	)

	(method (dispose)
		(self release:)
		(super dispose:)
	)
)

(instance oScore1 of ScoreDisplay
	(properties)
)

(instance oScore2 of ScoreDisplay
	(properties)
)

(instance oScore3 of ScoreDisplay
	(properties)
)

(instance oScore4 of ScoreDisplay
	(properties)
)

(instance poExplodeScore of Prop
	(properties
		priority 600
		x 312
		y 104
		view 41013
		fixPriority 1
	)
)

(instance poLavaLamp of Prop
	(properties
		priority 1
		x 44
		y 231
		view 41000
		fixPriority 1
	)
)

(instance poTheDoorsMan of Prop
	(properties
		priority 5
		x 46
		y 381
		view 41001
	)
)

(instance poRobot of Prop
	(properties
		priority 10
		x 326
		y 335
		view 41007
		fixPriority 1
	)
)

(instance poRobotAfter of Prop
	(properties
		priority 10
		x 326
		y 335
		loop 1
		view 41007
		fixPriority 1
	)
)

(instance poALarry of Prop
	(properties
		x 155
		y 396
		view 41014
	)
)

(instance poLarryInsertsCard of Prop ; UNUSED
	(properties
		x 155
		y 396
		view 41014
	)
)

(instance poAVicki of Prop
	(properties
		priority 410
		x 384
		y 320
		view 41003
		fixPriority 1
	)
)

(instance poPinhead of Prop
	(properties
		priority 50
		x 196
		y 261
		view 40120
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(voPinhead init: hide:)
		(self setScript: soPinhead)
	)
)

(instance poMermaid of Prop
	(properties
		priority 380
		x 408
		y 277
		view 40121
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(proc64896_15 7)
		(oMermaidSFX setRelVol: 40)
		(self setScript: soMermaid)
	)
)

(instance poHulk of Prop
	(properties
		priority 50
		x 496
		y 278
		view 40122
		fixPriority 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: soHulk)
	)
)

(instance voVickiClothes of View
	(properties
		priority 300
		x 395
		y 335
		view 41009
		fixPriority 1
	)
)

(instance voBoothLights of View
	(properties
		x 48
		y 380
		loop 1
		view 41001
	)
)

(instance voPinhead of View
	(properties
		priority 50
		x 196
		y 261
		loop 1
		view 40120
		fixPriority 1
	)
)

(instance foCardReader of Feature
	(properties
		noun 2
		x 70
		y 337
		approachX 155
		approachY 396
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 113 276 78 266 39 265 5 293 10 335 28 357 44 372 66 388 95 404 109 410 136 384 113 276
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; TMT Scorecard
				(cond
					(((ScriptID 64017 0) test: 113) ; oFlags
						(gMessager say: 2 16 3) ; "What? Enter again? And ruin Vicki's perfect score with your lousy performance? (BEAT) Really, Larry."
					)
					(local12
						(gMessager say: 2 16 8) ; "Oh, sure. You'd like to THINK you could "perform" again so soon...."
					)
					(((ScriptID 64017 0) test: 164) ; oFlags
						(self case: 4)
						((ScriptID 64017 0) set: 217) ; oFlags
						(gGame handsOff:)
						(gCurRoom setScript: soVickiUsesLuvMaster)
					)
					((not ((ScriptID 64017 0) test: 217)) ; oFlags
						((ScriptID 64017 0) set: 217) ; oFlags
						(self case: 1)
						((ScriptID 64017 0) set: 245) ; oFlags
						(gGame handsOff:)
						(gCurRoom setScript: soLarryUsesLuvMaster)
					)
					(((ScriptID 64017 0) test: 163) ; oFlags
						(super doVerb: theVerb)
					)
					(
						(and
							((ScriptID 64017 0) test: 217) ; oFlags
							(not ((ScriptID 64017 0) test: 163)) ; oFlags
						)
						(self case: 2)
						(super doVerb: theVerb)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foExitMap of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 600 0 640 0 640 480 600 480
					yourself:
				)
		)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 13)) ; oMapCursor
	)

	(method (doVerb)
		((ScriptID 90 0) init:) ; oTravelScreen
	)
)

(instance foLuvSign of Feature
	(properties
		noun 11
		x 319
		y 56
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 2 76 39 77 89 64 83 26 147 3 182 7 235 10 269 4 333 1 417 6 510 9 623 30 633 41 636 63 626 89 608 106 600 109 555 104 512 99 493 97 469 90 452 91 433 93 414 91 399 88 259 89 198 91 139 95 66 105 22 111
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLavaLamp of Feature
	(properties
		noun 10
		x 46
		y 213
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 265 85 248 32 154 25 152 16 155 8 162 12 261 24 274 39 264
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foBigLavaBtn of Feature
	(properties
		noun 12
		x 587
		y 304
		approachX 562
		approachY 403
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 589 322 602 290 583 286 572 321
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 160)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(160 ; Push
				(if ((ScriptID 64017 0) test: 111) ; oFlags
					((ScriptID 64017 0) clear: 111) ; oFlags
				else
					((ScriptID 64017 0) set: 111) ; oFlags
				)
				(gCurRoom setScript: soGiantLavaLamp)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBooth1 of Feature
	(properties
		noun 1
		x 183
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 249 375 240 251 232 126 172 127 103 136 124 250 143 378 194 378
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (oScore1 doUpdate:)
					(gMessager say: 1 1) ; "This booth is occupied...and evidently, quite successfully, too."
				else
					(gMessager say: 7 1) ; "This booth is unoccupied...and evidently, quite successfully, too."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBooth2 of Feature
	(properties
		noun 3
		x 304
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 351 377 357 251 369 127 308 125 248 128 253 245 257 376 302 377
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 64017 0) test: 165) ; oFlags
					(gMessager say: 3 1 5) ; "Looks like SOMEbody's sexually satisfied around here!"
				else
					(gMessager say: 3 1 1) ; "This booth looks empty."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBooth3 of Feature
	(properties
		noun 4
		x 420
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 456 381 456 381 464 297 481 197 492 136 436 131 384 128 370 211 362 305 360 379 438 380
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (oScore3 doUpdate:)
					(gMessager say: 4 1) ; "What the hell is going on in there?!"
				else
					(gMessager say: 7 1) ; "This booth is unoccupied...and evidently, quite successfully, too."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foBooth4 of Feature
	(properties
		noun 5
		x 531
		y 300
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 544 386 564 312 595 230 624 155 567 144 509 138 490 210 474 292 466 345 464 382 511 385
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (oScore4 doUpdate:)
					(gMessager say: 5 1) ; "There are many governments that ban that sort of behavior!"
				else
					(gMessager say: 7 1) ; "This booth is unoccupied...and evidently, quite successfully, too."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foScoreBD1 of Feature
	(properties
		noun 6
		x 166
		y 107
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 140 96 199 96 199 123 140 123
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (oScore1 doUpdate:)
					(gMessager say: 6 1) ; "Looks like things are going pretty well in this booth!"
				else
					(gMessager say: 6 1) ; "Looks like things are going pretty well in this booth!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foScoreBD2 of Feature
	(properties
		noun 7
		x 312
		y 102
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 285 92 344 92 344 117 285 117
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (and (not local13) ((ScriptID 64017 0) test: 164)) ; oFlags
					(gMessager say: 7 1 6 1) ; MISSING MESSAGE
				else
					(gMessager say: 7 1 0 1) ; "This booth is unoccupied...and evidently, quite successfully, too."
				)
			)
			(68 ; Name
				(if (not ((ScriptID 64017 0) test: 217)) ; oFlags
					(gMessager say: 7 68 1 2) ; "Booth #2's Score"
				else
					(gMessager say: 7 68 0 1) ; "Your Score"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foScoreBD3 of Feature
	(properties
		noun 8
		x 445
		y 110
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 418 101 477 101 477 125 418 125
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (oScore3 doUpdate:)
					(gMessager say: 8 1) ; "This booth's occupant is doing well!"
				else
					(gMessager say: 8 1) ; "This booth's occupant is doing well!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance foScoreBD4 of Feature
	(properties
		noun 9
		x 575
		y 125
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 545 112 605 112 605 137 545 138
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (oScore4 doUpdate:)
					(gMessager say: 9 1) ; "The score is not the only thing rising around this booth!"
				else
					(gMessager say: 9 1) ; "The score is not the only thing rising around this booth!"
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poVicki of Prop
	(properties
		priority 400
		x 384
		y 320
		view 41006
		fixPriority 1
	)
)

(instance voVicki of View
	(properties)

	(method (init)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(self setPri: (+ (poVicki priority:) 1))
		(super show: &rest)
	)
)

(instance toVicki of Talker
	(properties)

	(method (init)
		(= view (poVicki view:))
		(= loop (+ (poVicki loop:) 1))
		(= x (poVicki x:))
		(= y (poVicki y:))
		(= priority (+ (poVicki priority:) 1))
		(voVicki hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voVicki show:)
		(super dispose: &rest)
	)
)

(instance oSound of TPSound
	(properties)
)

(instance oMermaidSFX of TPSound
	(properties)
)

(instance oHulkSFX of TPSound
	(properties)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local14 1)
	)
)

(instance coEndMusic of CueMe
	(properties)

	(method (cue)
		(= local15 1)
	)
)

(instance oMusicTimer of Timer
	(properties)

	(method (cue)
		(= local18 1)
		(self dispose: delete:)
	)
)

