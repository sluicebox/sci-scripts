;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 420)
(include sci.sh)
(use Main)
(use TPSound)
(use oPopupMenuHandler)
(use oHandsOnWhenCued)
(use CycleCueList)
(use CueMe)
(use PushButton)
(use soFlashCyberSniff)
(use foEExit)
(use Talker)
(use RandCycle)
(use Polygon)
(use Feature)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	ro420 0
)

(local
	local0
	local1
	local2
	local3
	local4 = {}
	local5
)

(instance ro420 of L7Room
	(properties
		picture 42000
	)

	(method (init)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 639 384 599 392 569 424 509 446 434 465 322 468 220 453 109 429 52 394 52 372 5 372 5 474 337 474 637 474
					yourself:
				)
		)
		(gOMusic1 setMusic: 42000 setRelVol: 100)
		(poOcean init:)
		(= global330 0)
		(= gToJulia toJulia)
		(= gToGraham toGraham)
		(= gToPaul toPaul)
		(poJulia init:)
		(voJulia init:)
		(poJuliaEyes init:)
		(poAGraham init:)
		(poGraham init: hide:)
		(voGraham init: hide:)
		(poAPaul init:)
		(voScoreBoard init:)
		(poConveyorBelt init: setScript: soScoreTitleIn)
		(foJuliaComp init:)
		(foGrahamComp init:)
		(foPaulComp init:)
		(foLowerTeeth init:)
		(foUvula init:)
		(foCookRoom init:)
		(foExitSouth init:)
		(cond
			((gEgo has: ((ScriptID 64037 0) get: 16)) ; oInvHandler, ioQuiche
				(gGame handsOff:)
				(gCurRoom setScript: soLarryEnters)
			)
			((gEgo has: ((ScriptID 64037 0) get: 36)) ; oInvHandler, ioQuichePlus
				(gGame handsOff:)
				(oShortSound preload: 42001)
				(Load rsVIEW 42036 42030 42032 42041)
				(gCurRoom setScript: soLarryEnters)
			)
			(else
				(poALarry init: view: 42018 loop: 0 cel: 0 posn: 48 412)
				(gGame handsOn:)
			)
		)
	)

	(method (gimme)
		(gEgo get: ((ScriptID 64037 0) get: 49)) ; oInvHandler, ioBeaverCheese
		(gEgo get: ((ScriptID 64037 0) get: 17)) ; oInvHandler, ioKumquat
		(gEgo get: ((ScriptID 64037 0) get: 22)) ; oInvHandler, ioLimeJuice
		(gEgo get: ((ScriptID 64037 0) get: 16)) ; oInvHandler, ioQuiche
		(gEgo get: ((ScriptID 64037 0) get: 36)) ; oInvHandler, ioQuichePlus
		(gEgo get: ((ScriptID 64037 0) get: 38)) ; oInvHandler, ioSalt
		(gEgo get: ((ScriptID 64037 0) get: 46)) ; oInvHandler, ioScorecard
		(gEgo get: ((ScriptID 64037 0) get: 16)) ; oInvHandler, ioQuiche
		(gEgo get: ((ScriptID 64037 0) get: 36)) ; oInvHandler, ioQuichePlus
	)

	(method (newRoom newRoomNumber)
		(= global330 0)
		(= gToJulia 0)
		(= gToGraham 0)
		(= gToPaul 0)
		(if (!= newRoomNumber 420) ; ro420
			(gOMusic1 stop:)
			(gOSound1 stop:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance soLarryEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(poALarry view: 42016 loop: 0 cel: 0 posn: 6 408 init:)
				(= ticks 60)
			)
			(2
				(poALarry setCycle: End self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soGrahamTurnTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poAGraham view: 42010 loop: 1 cel: 0 show: setCycle: End self)
				(poGraham hide:)
				(voGraham hide:)
			)
			(1
				(poGraham view: 42011 loop: 0 cel: 0 show:)
				(voGraham show:)
				(poAGraham hide:)
				(= gToGraham toGraham)
				(gMessager say: 3 4 0 0 self) ; "Oh, we never enter into idle conversation with ordinary people. We're brought here at great expense, you know, just to judge, never associate. No, goodness, no!"
			)
			(2
				(= gToGraham 0)
				(poAGraham show: setCycle: Beg self)
				(poGraham hide:)
				(voGraham hide:)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soPaulTurnTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poAPaul view: 42015 loop: 1 cel: 0 setCycle: End self)
			)
			(1
				(= gToPaul toPaul)
				(gMessager say: 2 4 0 0 self) ; "There ain't nothing you're goin' to do that will make me change anything about my opinion of your cooking. I don't even care if I haven't tasted it. I still know my cookin's best. Go on!"
			)
			(2
				(= gToPaul 0)
				(poAPaul setCycle: Beg self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance soQuiche of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(oSound stop:)
				(gGame handsOff:)
				((ScriptID 64017 0) set: 114) ; oFlags
				(= local0 0)
				(gMessager say: 7 48 0 1 coEndTalk) ; "Proudly, you present your concoction for evaluation by the panel of esteemed chefs."
				(poALarry
					view: 42016
					loop: 1
					cel: 0
					posn: 48 412
					setCycle: End self 10 9999
				)
			)
			(1
				(aoEntryQuiche posn: 157 511 init:)
			)
			(2
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(3
				(= ticks 45)
			)
			(4
				(gMessager say: 7 48 0 2 self) ; "Scorecard, please."
			)
			(5
				(poAJulia
					view: 42000
					loop: 0
					cel: 0
					posn: 215 345
					init:
					setCycle: End self
				)
				(poJulia hide:)
				(voJulia hide:)
				(poJuliaEyes hide:)
			)
			(6
				(poJulia show:)
				(voJulia show:)
				(poJuliaEyes show:)
				(= gToJulia toJulia)
				(gMessager say: 7 48 0 3 self) ; "Thank you, Mr. (BEAT) Laffer."
			)
			(7
				(= ticks 45)
			)
			(8
				(gMessager say: 7 48 0 4 self) ; "Well, let's see now..."
			)
			(9
				(= gToJulia 0)
				(poJulia hide:)
				(voJulia hide:)
				(poJuliaEyes hide:)
				(poAJulia
					view: 42000
					loop: 1
					cel: 0
					posn: 215 345
					setCycle: End self
				)
			)
			(10
				(= local0 0)
				(gMessager say: 7 48 0 5 coEndTalk) ; "(DISGUSTING TASTE SOUNDS:) Ugh. Blah. Yech. Ptuuuiy!"
				(= cycles 1)
			)
			(11
				(poAJulia view: 42000 loop: 2 cel: 0 setCycle: CT 16 1 self)
			)
			(12
				(poAJulia
					view: 42000
					loop: 2
					cel: 3
					setCycle: CT (Random 11 15) 1 self
				)
			)
			(13
				(if (not local0)
					(-= state 2)
				)
				(= cycles 1)
			)
			(14
				(poJulia view: 42005 loop: 0 cel: 0 show:)
				(UpdateScreenItem poJulia)
				(voJulia show:)
				(= gToJulia toJulia)
				(poAJulia setCycle: 0 hide:)
				(gMessager say: 7 48 0 6 self) ; "Well. This has nothing to distinguish it from the hundreds of other Venezuelan Beaver Cheese Quiches we've endured... although the essence of kumquat does help slightly."
				(oSound setAmbient: 42004)
				(= local0 0)
				(aoEntryQuiche setSpeed: 15 setMotion: MoveTo 310 526 coEndTalk)
				(poConveyorBelt cycleSpeed: 60 setCycle: Fwd)
			)
			(15
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(16
				(aoEntryQuiche setMotion: MoveTo 480 531)
				(poGraham show:)
				(voGraham show:)
				(poAGraham hide:)
				(= gToGraham toGraham)
				(gMessager say: 7 48 0 7 self) ; "What? I don't even want to bother tasting it then."
				(= ticks 30)
			)
			(17
				(poAPaul loop: 1 cel: 0 setCycle: End self)
			)
			(18 0)
			(19
				(Load 140 43306 33101) ; WAVE
				(= gToGraham 0)
				(= gToPaul toPaul)
				(gMessager say: 7 48 0 8 self) ; "Wait. I might want to try it... (DISAPPOINTED) aw, never mind."
				(aoFlyingQuiche cycleSpeed: 5 posn: 426 530 init: cel: 0 hide:)
			)
			(20
				(= local1 0)
				(poConveyorBelt setScript: soLowScore)
				(= gToPaul 0)
				(poConveyorBelt cycleSpeed: 1 setCycle: Rev)
				(voRedLight init:)
				(oSound setAmbient: 42004)
				(gOSound1 setAmbient: 42005)
				(poALarry
					view: 42018
					loop: 0
					cel: 0
					posn: 48 412
					cycleSpeed: 8
					setCycle: End self 9 10 11 9999
				)
				(aoFlyingQuiche show: setCycle: CT 6 1 aoFlyingQuiche)
				(aoEntryQuiche dispose:)
			)
			(21
				(oShortSound playSound: 43306)
				(aoFlyingQuiche
					cel: 7
					y: (+ (aoFlyingQuiche y:) 30)
					show:
					setCycle: End aoFlyingQuiche
				)
			)
			(22
				(oPaulSFX playSound: 33101)
			)
			(23
				(gMessager say: 7 48 0 9) ; "(HIT IN STOMACH) Ouwfh!"
			)
			(24
				(poALarry hide:)
				(= ticks 60)
			)
			(25
				(voRedLight dispose:)
				(gOSound1 stop:)
				(oSound dispose:)
				(poJulia view: 42003 loop: 0 cel: 0 show:)
				(UpdateScreenItem poJulia)
				(poJuliaEyes show:)
				(voJulia show:)
				(poAJulia hide:)
				(poAGraham view: 42010 loop: 0 cel: 0 show:)
				(poGraham hide:)
				(voGraham hide:)
				(poAPaul view: 42015 loop: 0 cel: 0)
				(= gToJulia toJulia)
				(= gToGraham toGraham)
				(= gToPaul toPaul)
				(poALarry
					view: 42018
					loop: 0
					cel: 0
					posn: 48 412
					cycleSpeed: 6
					show:
				)
				(poConveyorBelt setCycle: 0 setScript: 0)
				(voScoreBoard
					x: 183
					text: (MakeMessageText 0 0 1 1 420) ; "CAPTAIN'S COOK-OFF COMPETITION"
					draw:
					show:
				)
				((ScriptID 90 0) init:) ; oTravelScreen
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soQuichePlus of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(oSound stop:)
				(gEgo put: ((ScriptID 64037 0) get: 36)) ; oInvHandler, ioQuichePlus
				(= local0 0)
				(gMessager say: 7 74 0 1 coEndTalk) ; "Proudly, you present your special enhanced concoction for evaluation by the panel of esteemed chefs."
				(poALarry
					view: 42016
					loop: 1
					cel: 0
					posn: 48 412
					setCycle: End self 10 9999
				)
			)
			(1
				(aoEntryQuiche posn: 157 511 init:)
			)
			(2
				(if (not local0)
					(-= state 1)
				)
				(= cycles 1)
			)
			(3
				(gMessager say: 7 74 0 2 self) ; "Scorecard, please."
			)
			(4
				(poAJulia
					view: 42000
					loop: 0
					cel: 0
					posn: 215 345
					init:
					setCycle: End self
				)
				(poJulia hide:)
				(poJuliaEyes hide:)
				(voJulia hide:)
			)
			(5
				(poJulia show:)
				(voJulia show:)
				(poJuliaEyes show:)
				(gMessager say: 7 74 0 3 self) ; "Thank you, Mr. (BEAT) Laffer."
			)
			(6
				(= ticks 45)
			)
			(7
				(gMessager say: 7 74 0 4 self) ; "Well, what do we have here..."
			)
			(8
				(= gToJulia 0)
				(poAJulia view: 42000 loop: 1 cel: 0 setCycle: End self 12 9999)
				(poJulia hide:)
				(voJulia hide:)
				(poJuliaEyes hide:)
			)
			(9
				(oShortSound playSound: 42001)
			)
			(10
				(poConveyorBelt cycleSpeed: 12 setCycle: Fwd)
				(oSound setAmbient: 42004)
				(aoEntryQuiche setSpeed: 3 setMotion: MoveTo 346 530 self)
			)
			(11
				(poAJulia view: 42035 loop: 0 cel: 0 setCycle: End self 2 3 8)
				(poConveyorBelt setCycle: 0)
			)
			(12
				(oJuliaSFX setRelVol: 400 playSound: 42006)
			)
			(13
				(poAJulia cycleSpeed: 15)
			)
			(14
				(poGraham show:)
				(voGraham show:)
				(poAGraham hide:)
				(= gToGraham toGraham)
				(gMessager say: 7 74 0 7 self) ; "(ENTHUSIASTICALLY) I'll have what she's having!"
			)
			(15
				(= gToGraham 0)
				(poAGraham
					view: 42010
					loop: 2
					cel: 0
					posn: 344 352
					show:
					setCycle: CycleCueList 9 1 self 8
				)
				(poGraham hide:)
				(voGraham hide:)
			)
			(16
				(oShortSound playSound: 42001)
				(= cycles 1)
			)
			(17
				(poAGraham
					view: 42030
					loop: 0
					cel: 0
					doit:
					setCycle: End self 7 9 24
				)
			)
			(18
				(oGrahamSFX setRelVol: 400 playSound: 42007)
			)
			(19
				(poAPaul loop: 1 cel: 99 doit:)
				(= gToPaul toPaul)
				(gMessager say: 7 74 0 10 coEndTalk) ; "(ENTHUSIASTICALLY) Hey! Wait for me!!"
			)
			(20
				(poAPaul
					view: 42040
					loop: 0
					cel: 0
					posn: 488 357
					setCycle: End self 2 10 36 40 9999
				)
			)
			(21
				(aoEntryQuiche hide:)
				(poAGraham view: 42030 loop: 0 cel: 0 doit: setCycle: End)
			)
			(22
				(oPaulSFX setRelVol: 400 playSound: 42008)
			)
			(23
				(gMessager kill:)
				(= gToPaul 0)
				(poAJulia view: 42036 loop: 0 cel: 0 setCycle: RandCycle -1)
				(poAGraham
					view: 42032
					loop: 0
					cel: 0
					posn: 344 352
					setCycle: RandCycle -1
				)
			)
			(24
				(poAPaul setPri: 450)
			)
			(25
				(= cycles 1)
			)
			(26
				(poAPaul
					view: 42041
					loop: 0
					cel: 0
					posn: 393 367
					cycleSpeed: 6
					setScript: soPaulGoRound
				)
				(= local1 0)
				(poConveyorBelt
					cycleSpeed: 2
					setCycle: Fwd
					setScript: soHighScore
				)
				(= cycles 1)
			)
			(27
				(poALarry
					view: 42018
					loop: 2
					cel: 0
					posn: 52 408
					setCycle: End self
				)
			)
			(28
				(gMessager say: 7 74 0 13 self) ; "You may not know much about cooking, but you know what THEY like! Look at those scores! You just won the Cook-Off competition!"
			)
			(29
				(if (not local1)
					(-= state 1)
				)
				(= cycles 1)
			)
			(30
				(poALarry
					view: 42018
					loop: 3
					cel: 0
					posn: 46 408
					setCycle: End self
				)
			)
			(31
				(voRedLight dispose:)
				(aoFlyingQuiche dispose:)
				(poALarry hide:)
				(gOSound1 stop:)
				(oSound dispose:)
				(poJulia
					view: 42003
					loop: 0
					cel: 0
					posn: 215 345
					setPri: 410
					show:
				)
				(UpdateScreenItem poJulia)
				(poJuliaEyes show:)
				(voJulia show:)
				(poAJulia setCycle: 0 hide:)
				(poAGraham
					view: 42010
					loop: 0
					cel: 0
					posn: 344 352
					setCycle: 0
					setPri: 410
					show:
				)
				(poGraham hide:)
				(voGraham hide:)
				(poAPaul
					view: 42015
					loop: 0
					cel: 0
					posn: 488 357
					setPri: 410
					setCycle: 0
				)
				(= gToJulia toJulia)
				(= gToGraham toGraham)
				(= gToPaul toPaul)
				(poALarry view: 42018 loop: 0 cel: 0 posn: 48 412 show:)
				(poConveyorBelt setCycle: 0 setScript: 0)
				(voScoreBoard
					x: 183
					text: (MakeMessageText 0 0 1 1 420) ; "CAPTAIN'S COOK-OFF COMPETITION"
					draw:
					show:
				)
				((ScriptID 64017 0) set: 115) ; oFlags
				((ScriptID 80 0) setReal: (ScriptID 80 0) 5) ; oAnnounceTimer, oAnnounceTimer
				((ScriptID 90 0) init:) ; oTravelScreen
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soPaulGoRound of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poAPaul view: 42022 loop: 1 cel: 0 setPri: 450)
				(= cycles 1)
			)
			(1
				(poAPaul
					view: 42022
					loop: 1
					cel: 14
					setPri: 450
					setCycle: Beg self 13 12 4 0
				)
			)
			(2
				(poAPaul setPri: 450)
			)
			(3
				(poAPaul setPri: 100)
			)
			(4
				(poAPaul setPri: 450)
			)
			(5
				(= cycles 1)
			)
			(6
				(if (< (poAPaul cycleSpeed:) 30)
					(poAPaul cycleSpeed: (+ (poAPaul cycleSpeed:) 3))
					(poConveyorBelt
						cycleSpeed: (+ (poConveyorBelt cycleSpeed:) 3)
					)
					(self changeState: 1)
				else
					(poConveyorBelt setCycle: 0)
					(self dispose:)
				)
			)
		)
	)
)

(instance soScoreTitleIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (< (voScoreBoard x:) 183)
					(= cycles 1)
				else
					(voScoreBoard x: (- (voScoreBoard x:) 1))
					(self changeState: 0)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance soLowScore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(if (< (voScoreBoard x:) -1200)
					(= cycles 1)
				else
					(voScoreBoard x: (- (voScoreBoard x:) 5))
					(self changeState: (- state 1))
				)
			)
			(2
				(voScoreBoard x: 550 text: (MakeMessageText 0 0 1 2 420) draw:) ; "JUDGE JULIA'S SCORE: 0; JUDGE GRAHAM'S SCORE: 0; JUDGE PAUL'S SCORE: 0"
				(= cycles 1)
			)
			(3
				(voScoreBoard x: (- (voScoreBoard x:) 5))
				(= cycles 1)
			)
			(4
				(if (< (voScoreBoard x:) -1200)
					(voScoreBoard x: local5)
					(= local1 1)
				)
				(self changeState: (- state 1))
			)
		)
	)
)

(instance soHighScore of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(voScoreBoard hide:)
				(= cycles 1)
			)
			(2
				(voScoreBoard
					x: 550
					text: (MakeMessageText 0 0 1 3 420) ; "JUDGE JULIA'S SCORE: 100; JUDGE GRAHAM'S SCORE: 100; JUDGE PAUL'S SCORE: 100"
					draw:
					show:
				)
				(= cycles 1)
			)
			(3
				(voScoreBoard x: (- (voScoreBoard x:) 5))
				(= cycles 1)
			)
			(4
				(if (< (voScoreBoard x:) -1500)
					(voScoreBoard x: local5)
					(= local1 1)
				)
				(self changeState: (- state 1))
			)
		)
	)
)

(instance soOcean of OceanMotionSin
	(properties
		nCenterY 300
		nRange 12
	)
)

(instance poOcean of Prop
	(properties
		x 3
		y 315
		priority 6
		fixPriority 1
		view 42099
	)

	(method (init)
		(super init:)
		(self setScript: soOcean)
	)
)

(instance aoEntryQuiche of Actor
	(properties
		x 157
		y 511
		priority 450
		fixPriority 1
		view 42023
	)
)

(instance aoFlyingQuiche of Actor
	(properties
		x 138
		y 520
		priority 450
		fixPriority 1
		view 42018
		loop 1
	)

	(method (cue)
		(if (== cel 9)
			(self dispose:)
		else
			(self hide:)
		)
	)
)

(instance poALarry of Prop
	(properties
		x 6
		y 408
		priority 600
		fixPriority 1
		view 42016
	)
)

(instance poAJulia of Prop
	(properties
		noun 1
		x 215
		y 345
		priority 410
		fixPriority 1
		view 42000
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 1 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 1 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(48 ; Kumquat Quiche
				(poConveyorBelt doVerb: theVerb)
			)
			(74 ; Quiche de Larry
				(poConveyorBelt doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poAGraham of Prop
	(properties
		noun 3
		x 344
		y 352
		priority 410
		fixPriority 1
		view 42010
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gCurRoom setScript: soGrahamTurnTalk)
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 3 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 3 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(48 ; Kumquat Quiche
				(poConveyorBelt doVerb: theVerb)
			)
			(74 ; Quiche de Larry
				(poConveyorBelt doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poAPaul of Prop
	(properties
		noun 2
		x 488
		y 357
		priority 410
		fixPriority 1
		view 42015
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gCurRoom setScript: soPaulTurnTalk)
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 2 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 2 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(48 ; Kumquat Quiche
				(poConveyorBelt doVerb: theVerb)
			)
			(74 ; Quiche de Larry
				(poConveyorBelt doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance poConveyorBelt of Prop
	(properties
		noun 7
		y 479
		priority 430
		fixPriority 1
		view 42024
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(46 ; Venezuelan Beaver Cheese
				(proc64896_15 8 0)
				(super doVerb: theVerb)
			)
			(48 ; Kumquat Quiche
				(proc64896_15 8 0)
				((ScriptID 64017 0) set: 246) ; oFlags
				(gCurRoom setScript: soQuiche)
			)
			(74 ; Quiche de Larry
				(proc64896_15 8 0)
				((ScriptID 64017 0) set: 246) ; oFlags
				(gCurRoom setScript: soQuichePlus)
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 7 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 7 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voRedLight of View
	(properties
		x 500
		y 150
		priority 50
		fixPriority 1
		view 42025
	)

	(method (init)
		(super init: &rest)
		(= local3 0)
		(= local2 1)
	)

	(method (doit)
		(super doit: &rest)
		(if local2
			(if (> local3 30)
				(= local3 0)
				(if (self isNotHidden:)
					(self hide:)
				else
					(self show:)
				)
			else
				(++ local3)
			)
		)
	)
)

(instance foJuliaComp of Feature
	(properties
		noun 4
		x 181
		y 412
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 169 334 201 341 194 314 166 307 161 314
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foGrahamComp of Feature
	(properties
		noun 5
		x 314
		y 412
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 299 349 341 351 330 321 289 320 287 326
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foPaulComp of Feature
	(properties
		noun 6
		x 454
		y 412
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 435 347 477 344 473 316 437 316 432 321
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foLowerTeeth of Feature
	(properties
		noun 9
		x 333
		y 367
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 582 345 529 357 471 366 386 374 306 372 234 368 166 358 117 345 93 337 84 330 89 365 111 373 147 383 207 394 294 404 396 404 459 396 533 378 568 361
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foUvula of Feature
	(properties
		noun 10
		x 510
		y 153
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 524 136 496 135 491 151 491 160 499 169 511 171 521 169 526 162 529 155 526 141
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foCookRoom of Feature
	(properties
		noun 11
		x 138
		y 180
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 85 347 83 328 101 315 142 307 169 306 188 306 209 284 236 268 255 264 269 240 276 220 276 203 255 172 223 143 212 134 130 133 127 98 102 90 94 83 85 66 89 38 99 16 128 1 0 0 1 361 26 356 69 356 78 350
					yourself:
				)
		)
		(super init: &rest)
		(AddDefaultVerbs self)
	)
)

(instance foExitSouth of ExitFeature
	(properties
		x 613
		y 187
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 640 480 640 460 0 460 0 480
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

(instance poJulia of Prop
	(properties
		noun 1
		x 215
		y 345
		priority 410
		fixPriority 1
		view 42003
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gMessager say: 1 4 0 0 0) ; "Yes, darling, I know you'd love to talk to me, but the judges here are forbidden from fraternizing with the prisoners, er, I mean, contestants."
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 1 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 1 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(48 ; Kumquat Quiche
				(poConveyorBelt doVerb: theVerb)
			)
			(74 ; Quiche de Larry
				(poConveyorBelt doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voJulia of View
	(properties)

	(method (init)
		(= view (poJulia view:))
		(= loop (+ (poJulia loop:) 1))
		(= x (poJulia x:))
		(= y (poJulia y:))
		(self setPri: (+ (poJulia priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poJulia view:))
		(= loop (+ (poJulia loop:) 1))
		(= x (poJulia x:))
		(= y (poJulia y:))
		(self setPri: (+ (poJulia priority:) 1))
		(super show: &rest)
	)
)

(instance toJulia of Talker
	(properties)

	(method (init)
		(= view (poJulia view:))
		(= loop (+ (poJulia loop:) 1))
		(= x (poJulia x:))
		(= y (poJulia y:))
		(= priority (+ (poJulia priority:) 1))
		(voJulia hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voJulia show:)
		(super dispose: &rest)
	)
)

(instance poJuliaEyes of Prop
	(properties)

	(method (init)
		(= view (poJulia view:))
		(= loop (+ (poJulia loop:) 2))
		(= x (poJulia x:))
		(= y (poJulia y:))
		(self setPri: (+ (poJulia priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= view (poJulia view:))
		(= x (poJulia x:))
		(= y (poJulia y:))
		(super show: &rest)
		(self setCycle: Blink 10)
	)
)

(instance poGraham of Prop
	(properties
		noun 3
		x 344
		y 352
		priority 410
		fixPriority 1
		view 42011
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gCurRoom setScript: soGrahamTurnTalk)
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 3 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 3 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(48 ; Kumquat Quiche
				(poConveyorBelt doVerb: theVerb)
			)
			(74 ; Quiche de Larry
				(poConveyorBelt doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance voGraham of View
	(properties)

	(method (init)
		(= view (poGraham view:))
		(= loop (+ (poGraham loop:) 1))
		(= x (poGraham x:))
		(= y (poGraham y:))
		(self setPri: (+ (poGraham priority:) 1))
		(super init: &rest)
	)

	(method (show)
		(= view (poGraham view:))
		(= loop (+ (poGraham loop:) 1))
		(= x (poGraham x:))
		(= y (poGraham y:))
		(self setPri: (+ (poGraham priority:) 1))
		(super show: &rest)
	)
)

(instance toGraham of Talker
	(properties)

	(method (init)
		(= view (poGraham view:))
		(= loop (+ (poGraham loop:) 1))
		(= x (poGraham x:))
		(= y (poGraham y:))
		(= priority (+ (poGraham priority:) 1))
		(voGraham hide:)
		(super init: &rest)
	)

	(method (dispose)
		(voGraham show:)
		(super dispose: &rest)
	)
)

(instance poGrahamEyes of Prop ; UNUSED
	(properties)

	(method (init)
		(= view (poGraham view:))
		(= loop (+ (poGraham loop:) 2))
		(= x (poGraham x:))
		(= y (poGraham y:))
		(self setPri: (+ (poGraham priority:) 15))
		(super init: &rest)
		(self cycleSpeed: 6)
		(self setCycle: Blink 10)
	)

	(method (show)
		(= view (poGraham view:))
		(= x (poGraham x:))
		(= y (poGraham y:))
		(super show: &rest)
		(self setCycle: Blink 10)
	)
)

(instance poPaul of Prop
	(properties
		noun 2
		x 488
		y 357
		priority 410
		fixPriority 1
		view 42014
	)

	(method (init)
		(super init: &rest)
		(AddDefaultVerbs self)
		(self addHotspotVerb: 4)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Talk
				(gCurRoom setScript: soPaulTurnTalk)
			)
			(16 ; TMT Scorecard
				(if ((ScriptID 64017 0) test: 115) ; oFlags
					(gMessager say: 2 16 2) ; "There's no use to try again, Larry. It's over. No more. Done. Finito."
				else
					(gMessager say: 2 16) ; "Just place your Cook-Off Entry directly on the food conveyor belt."
				)
			)
			(48 ; Kumquat Quiche
				(poConveyorBelt doVerb: theVerb)
			)
			(74 ; Quiche de Larry
				(poConveyorBelt doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance toPaul of Talker
	(properties)

	(method (init)
		(= view (poPaul view:))
		(= loop (+ (poPaul loop:) 1))
		(= x (poPaul x:))
		(= y (poPaul y:))
		(= priority (+ (poPaul priority:) 1))
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance oSound of TPSound
	(properties)
)

(instance oShortSound of TPSound
	(properties)
)

(instance oJuliaSFX of TPSound
	(properties)
)

(instance oGrahamSFX of TPSound
	(properties)
)

(instance oPaulSFX of TPSound
	(properties)
)

(instance coEndTalk of CueMe
	(properties)

	(method (cue)
		(= local0 1)
	)
)

(instance voScoreBoard of TextItem
	(properties
		x 700
		y 90
		fixPriority 1
		fore 64
		font 2510
		border 0
		maxWidth 1200
	)

	(method (init &tmp temp0 temp1 [temp2 2])
		(= back skip)
		(= text (MakeMessageText 0 0 1 1 420)) ; "CAPTAIN'S COOK-OFF COMPETITION"
		(super init: &rest)
		(= temp1 50)
		(= temp0 600)
		(self setScale:)
		(= scaleX (MulDiv 128 temp0 nWidth))
		(= scaleY (MulDiv 128 temp1 nHeight))
		(self draw:)
		(= local5 x)
	)
)

