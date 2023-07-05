;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 670)
(include sci.sh)
(use Main)
(use n013)
(use Inset)
(use Talker)
(use Sync)
(use RandCycle)
(use Cursor)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm670 0
)

(local
	local0
)

(instance rm670 of Room
	(properties
		picture 670
		style 14
		exitStyle 13
	)

	(method (init)
		(gGame handsOff:)
		(= local0 gNarrator)
		(= gNarrator endTalker)
		(if (gGame keepBar:)
			(gTheIconBar erase:)
		)
		(gGame setCursor: ((ScriptID 0 1) view: 996)) ; globeCursor
		(SetFlag 220)
		(gGkMusic1 number: 350 setLoop: -1 play: setVol: 0 fade: 85 5 10 0)
		(fire init: setCycle: Fwd)
		(super init: &rest)
		(self
			setScript:
				(if (IsFlag 407)
					(mosely init:)
					sayDead
				else
					sayAlive
				)
		)
	)

	(method (dispose)
		(= gNarrator local0)
		(super dispose:)
	)
)

(instance sayAlive of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 100)
			)
			(1
				(= ticks 100)
			)
			(2
				(gMessager sayRange: 1 0 1 1 3 self) ; "(THIS IS THE ENDING SCENE AFTER MALIA'S DEATH. THEY'RE BOTH SERIOUS)I think it's over now."
			)
			(3
				(= ticks 100)
			)
			(4
				(gMessager sayRange: 1 0 1 4 11 self) ; "You've changed, you know."
			)
			(5
				(= ticks 100)
			)
			(6
				(gMessager sayRange: 1 0 1 12 14 self) ; "This is a historical moment, isn't it? Three hundred years ago, the Ritter talisman was stolen by Tetelo. She used it to draw her family to power, while your family withered."
			)
			(7
				(= ticks 100)
			)
			(8
				(gMessager sayRange: 1 0 1 15 16 self) ; "You think too much."
			)
			(9
				(= ticks 100)
			)
			(10
				(gMessager say: 1 0 1 17 self) ; "(RRCC. PRETENDING TO BE SERIOUS--TEASING)Yeah. Kind of reminds me of livin' with you, Grace."
			)
			(11
				(= ticks 100)
			)
			(12
				(gMessager sayRange: 1 0 1 18 22 self) ; "You know when I said you'd changed?"
			)
			(13
				(client setScript: finalScript)
			)
		)
	)
)

(instance finalScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(for ((= temp1 100)) (>= temp1 0) ((-= temp1 5))
					(Palette 2 0 255 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 99)
				(= ticks 100)
			)
			(2
				(for ((= temp1 0)) (<= temp1 100) ((+= temp1 5))
					(Palette 2 0 255 temp1) ; PalIntensity
					(FrameOut)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(SetCursor 10 40 309 170)
				(finalInset init: self gCurRoom 1)
			)
			(4
				(gGame handsOff:)
				(gCurRoom newRoom: 680) ; creditRm
			)
		)
	)
)

(instance sayDead of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 100)
			)
			(1
				(= ticks 100)
			)
			(2
				(gMessager sayRange: 1 0 2 1 8 self) ; "(RRCC. THIS SCENE TAKES PLACE AT END OF GAME IF GABRIEL IS KILLED DURING THE GAME--SHE'S SPEAKING OF GABRIEL)I can't believe he's gone."
			)
			(3
				(= ticks 100)
			)
			(4
				(gMessager say: 1 0 2 9 self) ; "(RRCC)Yeah."
			)
			(5
				(= ticks 100)
			)
			(6
				(gMessager sayRange: 1 0 2 10 11 self) ; "(RRCC. WHISPERING)Good-bye, Gabriel Knight."
			)
			(7
				(client setScript: finalScript)
			)
		)
	)
)

(instance mosely of View
	(properties
		y 22
		priority 1
		fixPriority 1
		view 675
	)

	(method (init)
		(super init: &rest)
		(moselyHead init:)
	)
)

(instance moselyHead of Prop
	(properties
		x 49
		y 36
		view 675
		loop 1
		cycleSpeed 3
	)
)

(instance graceHead of Prop
	(properties
		x 89
		y 31
		priority 170
		fixPriority 1
		view 670
		loop 1
		cycleSpeed 3
	)
)

(instance gabeHead of Prop
	(properties
		x 46
		y 32
		priority 170
		fixPriority 1
		view 670
		cycleSpeed 3
	)
)

(instance fire of Prop
	(properties
		x 154
		y 48
		view 672
		cycleSpeed 10
	)
)

(instance endTalker of Talker
	(properties
		x 0
		y 157
		talkWidth 314
		modeless 2
		font 999
		back 0
		textX -44
		textY 128
	)

	(method (init)
		(= font (proc13_6 4 999 4 999 999))
		(= mouth
			(switch global180
				(1 gabeHead)
				(8 moselyHead)
				(2 graceHead)
			)
		)
		(super init:)
	)

	(method (startAudio param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(super startAudio: param1)
		(if mouth
			(= temp0 (param1 at: 0))
			(= temp1 (param1 at: 1))
			(= temp2 (param1 at: 2))
			(= temp3 (param1 at: 3))
			(= temp4 (param1 at: 4))
			(if (== global180 1)
				(mouth setCycle: MouthSync temp0 temp1 temp2 temp3 temp4)
			else
				(mouth setCycle: RandCycle ticks 0 1)
			)
		)
	)

	(method (display param1 &tmp temp0)
		(= fore
			(switch global180
				(1 54)
				(8 30)
				(2 21)
				(else global220)
			)
		)
		(if (& gMsgType $0001)
			(super display: param1)
		)
	)

	(method (dispose)
		(switch global180
			(8
				(moselyHead dispose:)
			)
			(2
				(graceHead dispose:)
			)
			(1
				(gabeHead dispose:)
			)
		)
		(= global180 0)
		(super dispose:)
	)
)

(instance finalInset of Inset
	(properties
		view 9591
		disposeNotOnMe 1
	)

	(method (init)
		(super init: &rest)
		((ScriptID 0 1) view: 999) ; globeCursor
		(cFour
			view: 959
			setLoop: 4
			cel: (/ gScore 100)
			setPri: (+ (GetHighPlanePri) 1)
			init:
		)
		(cFive
			view: 959
			setLoop: 4
			cel: (/ (mod gScore 100) 10)
			setPri: (+ (GetHighPlanePri) 1)
			init:
		)
		(cSix
			view: 959
			setLoop: 4
			cel: (mod gScore 10)
			setPri: (+ (GetHighPlanePri) 1)
			init:
		)
		(ClearFlag 220)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (doit &tmp temp0)
		(if disposeNotOnMe
			(= temp0 (gUser curEvent:))
			(if (not (temp0 type:))
				(temp0 localize: (gCast plane:))
				(cond
					((not (self onMe: temp0))
						(if (!= gTheCursor lastInsetExitCurs)
							(gGame setCursor: lastInsetExitCurs 1)
						)
					)
					((!= gTheCursor (ScriptID 0 1)) ; globeCursor
						(gGame setCursor: (ScriptID 0 1) 1) ; globeCursor
					)
				)
			)
		)
		(if script
			(script doit:)
		)
	)

	(method (doVerb)
		(return 1)
	)
)

(instance lastInsetExitCurs of Cursor
	(properties
		view 968
	)
)

(instance cFour of View
	(properties
		x 50
		y 24
		view 959
		loop 4
	)

	(method (doVerb)
		(return 1)
	)
)

(instance cFive of View
	(properties
		x 56
		y 24
		view 959
		loop 4
	)

	(method (doVerb)
		(return 1)
	)
)

(instance cSix of View
	(properties
		x 62
		y 24
		view 959
		loop 4
	)

	(method (doVerb)
		(return 1)
	)
)

