;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use SQNarrator)
(use n666)
(use Str)
(use Print)
(use RandCycle)
(use PolyPath)
(use StopWalk)
(use Grooper)
(use Ego_64988)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	ego 0
	Roger 1
	endroidReforms 2
)

(local
	local0
	local1
)

(class ego of Ego
	(properties
		noun 1
		modNum 20
		view 900
		cycleSpeed 4
		moveSpeed 4
	)

	(method (init)
		(super init:)
		(|= signal $3000)
		(if (not cycler)
			(self setCycle: Walk)
		)
		(Roger client: self)
	)

	(method (setMotion &tmp temp0)
		(if (== (self view:) 578)
			(switch (self loop:)
				(0
					(= temp0 0)
				)
				(1
					(= temp0 1)
				)
				(2
					(= temp0 0)
				)
				(3
					(= temp0 1)
				)
				(4
					(= temp0 6)
				)
				(5
					(= temp0 6)
				)
			)
			((ScriptID 0 15) stop:) ; fidgetWhistle
			(if (== (self script:) (ScriptID 0 13)) ; sFidget
				(self setScript: 0)
			)
			(self
				view: 900
				setLoop: -1
				setLooper: Grooper
				loop: temp0
				setCycle: StopWalk 901
				setSpeed: gEgoSpeed
			)
		)
		(super setMotion: &rest)
	)

	(method (doit)
		(if (!= (gEgo view:) 901)
			(if (== gCurRoomNum 570)
				((ScriptID 0 14) setReal: (ScriptID 0 14) 20) ; fidgetTimer, fidgetTimer
			else
				((ScriptID 0 14) setReal: (ScriptID 0 14) 60) ; fidgetTimer, fidgetTimer
			)
		)
		(super doit: &rest)
	)

	(method (put param1 param2 &tmp temp0 temp1 temp2)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(if (and gTheIconBar (== (gTheIconBar curInvIcon:) temp0))
				(for ((= temp1 0)) (<= temp1 7) ((++ temp1))
					(if
						(and
							(not (& ((gTheIconBar at: temp1) signal:) $0004))
							(!= ((gTheIconBar at: temp1) message:) 5)
						)
						(= temp2 (gTheIconBar at: temp1))
						(break)
					)
				)
				(if
					(and
						(> temp1 7)
						(== ((= temp2 (gTheIconBar returnFirstAvail:)) message:) 5)
					)
					(= temp2 (gTheIconBar returnFirstAvail: 1))
				)
				(gTheIconBar
					curInvIcon: 0
					disableIcon:
						((gTheIconBar useIconItem:) setCursor: gNormalCursor yourself:)
					clearInvItem:
					curIcon: temp2
				)
				(if (not (and (gUser controls:) (gUser input:)))
					(= global121 (gTheIconBar curIcon:))
				)
			)
			(gInventory highlightedIcon: 0 selectedInvIcon: 0)
		)
	)

	(method (facingMe)
		(return 1)
	)

	(method (normalize param1 param2)
		(cond
			((> argc 1)
				(gEgo view: param2)
			)
			((IsFlag 52)
				(gEgo view: 910)
			)
			((IsFlag 53)
				(gEgo view: 902)
			)
			(else
				(gEgo view: 900)
			)
		)
		(gEgo
			setLoop: -1
			setLooper: Grooper
			loop: (if argc param1 else 2)
			setPri: -1
			setMotion: 0
			setCycle: StopWalk (+ view 1)
			setStep: 3 2 0
			setSpeed: gEgoSpeed
			state: (|= state $0002)
			ignoreActors: 0
		)
	)

	(method (enterRoom param1 param2 param3 param4 param5 param6)
		(gEgo
			posn: param1 param2
			setMotion:
				(if (and (== argc 6) param6) PolyPath else MoveTo)
				param3
				param4
				(and (>= argc 5) param5)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (== gCurRoomNum 410)
					(gMessager say: 0 4 3 1 0 0) ; "That won't help in this situation."
				else
					(super doVerb: theVerb)
				)
			)
			(14 ; Trans_Signaler
				(if (== gCurRoomNum 340)
					(gCurRoom notify: 33)
				else
					(gMessager say: 0 0 4 0 0 20) ; "As Manuel told you, you can only use it from the area you transported to originally."
				)
			)
			(6 ; Datacorder
				(cond
					((and (== gCurRoomNum 260) (not (IsFlag 410)))
						(gMessager say: noun theVerb 0 0 0 20) ; "Sorry, you can't bring up the datacorder at this time."
					)
					((OneOf gCurRoomNum 250 470 490 460 410)
						(gMessager say: noun theVerb 0 0 0 20) ; "Sorry, you can't bring up the datacorder at this time."
					)
					((gCurRoom inset:)
						(gMessager say: noun theVerb 0 0 0 20) ; "Sorry, you can't bring up the datacorder at this time."
					)
					(else
						(gInventory hide:)
						(gGame handsOff:)
						(FrameOut)
						(gCurRoom setInset: (ScriptID 900 0) 0 0 1) ; dataCorderInset
					)
				)
			)
			(106 ; Eulogy
				(if (not (IsFlag 41))
					(gEgo cue:)
				)
			)
			(88 ; Nail
				(if (== gCurRoomNum 260)
					(gCurRoom notify:)
				else
					(super doVerb: theVerb)
				)
			)
			(109 ; Alarm_Key
				(gGame points: 3 413)
				(if (== gCurRoomNum 450)
					(gCurRoom notify:)
				else
					(gCurRoom setScript: sHandleAlarm)
				)
			)
			(93 ; Actuator
				(cond
					((and (== gCurRoomNum 270) (not (IsFlag 80)))
						(gCurRoom setScript: (ScriptID 270 2)) ; sForceFieldDeactvtd
					)
					((!= gCurRoomNum 270)
						(gInventory hide:)
						(gMessager say: 22 0 8 0 0 270) ; "Hmm. Doesn't seem to work here."
					)
				)
			)
			(113 ; Eva_Suit
				(if (== gCurRoomNum 480)
					(self setScript: sPutOnEvaSuit)
				else
					(gMessager say: 1 113 7 0 0 20) ; "No, that's just not a good idea now."
				)
			)
			(114 ; Eva_Helmet
				(cond
					(
						(OneOf
							gCurRoomNum
							600
							610
							620
							640
							650
							660
							670
							680
							690
							700
							720
							730
							735
							740
							750
							760
							770
						)
						(gMessager say: 1 62 0 0 0 20) ; "You actually don't need need to wear your helmet while traipsing around inside Stellar."
					)
					((IsFlag 53)
						(self setScript: sPutOnEvaHelmet)
					)
					(else
						(self setScript: sTryEvaHelmet)
					)
				)
			)
			(4 ; Do
				(cond
					((== gCurRoomNum 470)
						(gMessager say: 1 4 3 0 0 20) ; "Roger is in space. He can't remove his helmet."
					)
					((IsFlag 52)
						(self setScript: sRemoveEvaHelmet)
					)
					(
						(OneOf
							gCurRoomNum
							600
							610
							620
							640
							650
							660
							670
							680
							690
							700
							720
							730
							735
							740
							750
							760
							770
						)
						(gDoVerbCode doit: 4)
					)
					((IsFlag 53)
						(self setScript: sRemoveEvaSuit)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(if (or (IsFlag 52) (IsFlag 53))
					(gMessager say: 1 1 6 0 0 20) ; "Hey! That's me!"
				else
					(gMessager say: 1 1 0 0 0 20) ; "You're back in your comfy, reassuring janitorial duds."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class EgoSmallTalker of SQNarrator
	(properties
		body 0
		bodyView 0
		bodyLoop 0
		bodyCel 0
		talkView 0
		talkLoop 0
		client 0
		stopWalkTalk 1
		prepMove 0
		showTalk 1
	)

	(method (canTalk)
		(return 0)
	)

	(method (init)
		(super init:)
		(= disposeWhenDone 0)
		(cond
			(prepMove
				(= ticks -1)
				(Load rsVIEW bodyView)
				(= body
					((Prop new:)
						view: bodyView
						setLoop: bodyLoop
						setCel: bodyCel
						scaleSignal: (client scaleSignal:)
						scaleX: (client scaleX:)
						scaleY: (client scaleY:)
						x: (client x:)
						y: (client y:)
						init:
						setCycle: End self
						yourself:
					)
				)
				(client hide:)
			)
			(showTalk
				(Load rsVIEW talkView)
				(= body
					((Prop new:)
						view: talkView
						setLoop: talkLoop
						setCel: bodyCel
						scaleSignal: (client scaleSignal:)
						scaleX: (client scaleX:)
						scaleY: (client scaleY:)
						x: (client x:)
						y: (client y:)
						init:
						hide:
						yourself:
					)
				)
				(self cue:)
			)
			(else
				(= body 0)
				(self cue:)
			)
		)
	)

	(method (startText &tmp temp0)
		(= temp0 (super startText: &rest))
		(if (and (not (& gMsgType $0002)) showTalk)
			(self setViews:)
			(Load rsVIEW talkView)
			(body
				view: talkView
				setLoop: talkLoop
				setCel: bodyCel
				show:
				setCycle: RandCycle (* (/ temp0 3) 2) 0 1
			)
			(client hide:)
		else
			(= ticks (* (/ temp0 3) 2))
		)
	)

	(method (startAudio param1 param2 param3 param4 param5)
		(if showTalk
			(self setViews:)
			(Load rsVIEW talkView)
			(body
				view: talkView
				setLoop: talkLoop
				setCel: bodyCel
				show:
				setCycle: TalkRandCycle
			)
			(client hide:)
		)
		(super startAudio: param1 param2 param3 param4 param5)
	)

	(method (cue)
		(cond
			((== state 0)
				(self sayForReal:)
			)
			((== state 2)
				(self realDispose:)
			)
		)
	)

	(method (setViews)
		(= showTalk (= prepMove 1))
		(switch (gEgo loop:)
			(0
				(if (IsFlag 53)
					(= bodyView 930)
					(= bodyLoop 0)
					(= talkView 9300)
					(= talkLoop 0)
				else
					(switch global156
						(0
							(= bodyView 940)
							(= bodyLoop 0)
							(= talkView 9401)
							(= talkLoop 0)
						)
						(1
							(= bodyView 940)
							(= bodyLoop 0)
							(= talkView 9400)
							(= talkLoop 0)
						)
						(2
							(= bodyView 940)
							(= bodyLoop 2)
							(= talkView 9400)
							(= talkLoop 2)
						)
						(3
							(= bodyView 940)
							(= bodyLoop 2)
							(= talkView 9401)
							(= talkLoop 2)
						)
						(4
							(= showTalk 0)
							(= bodyView 940)
							(= bodyLoop 2)
						)
					)
				)
			)
			(1
				(if (IsFlag 53)
					(= bodyView 930)
					(= bodyLoop 1)
					(= talkView 9300)
					(= talkLoop 1)
				else
					(switch global156
						(0
							(= bodyView 940)
							(= bodyLoop 1)
							(= talkView 9401)
							(= talkLoop 1)
						)
						(1
							(= bodyView 940)
							(= bodyLoop 1)
							(= talkView 9400)
							(= talkLoop 1)
						)
						(2
							(= bodyView 940)
							(= bodyLoop 3)
							(= talkView 9400)
							(= talkLoop 3)
						)
						(3
							(= bodyView 940)
							(= bodyLoop 3)
							(= talkView 9401)
							(= talkLoop 3)
						)
						(4
							(= showTalk 0)
							(= bodyView 940)
							(= bodyLoop 3)
						)
					)
				)
			)
			(2
				(if (IsFlag 53)
					(= bodyView 932)
					(= bodyLoop 0)
					(= talkView 9320)
					(= talkLoop 0)
				else
					(switch global156
						(0
							(= bodyView 942)
							(= bodyLoop 0)
							(= talkView 9421)
							(= talkLoop 0)
						)
						(1
							(= bodyView 942)
							(= bodyLoop 0)
							(= talkView 9420)
							(= talkLoop 0)
						)
						(2
							(= bodyView 942)
							(= bodyLoop 2)
							(= talkView 9420)
							(= talkLoop 2)
						)
						(3
							(= bodyView 942)
							(= bodyLoop 2)
							(= talkView 9421)
							(= talkLoop 2)
						)
						(4
							(= showTalk 0)
							(= bodyView 942)
							(= bodyLoop 2)
						)
					)
				)
			)
			(3
				(cond
					((IsFlag 53)
						(= bodyView 932)
						(= bodyLoop 1)
						(= talkView 9320)
						(= talkLoop 1)
					)
					((== global156 1)
						(= bodyView 942)
						(= bodyLoop 1)
						(= talkView 9420)
						(= talkLoop 1)
					)
					((== global156 4)
						(= showTalk (= prepMove 0))
					)
					(else
						(= prepMove 0)
						(= talkView 9421)
						(= talkLoop 1)
					)
				)
			)
			(4
				(if (IsFlag 53)
					(= bodyView 934)
					(= bodyLoop 0)
					(= talkView 9340)
					(= talkLoop 0)
				else
					(switch global156
						(0
							(= bodyView 944)
							(= bodyLoop 0)
							(= talkView 9441)
							(= talkLoop 0)
						)
						(1
							(= bodyView 944)
							(= bodyLoop 0)
							(= talkView 9440)
							(= talkLoop 0)
						)
						(2
							(= bodyView 944)
							(= bodyLoop 2)
							(= talkView 9440)
							(= talkLoop 2)
						)
						(3
							(= bodyView 944)
							(= bodyLoop 2)
							(= talkView 9441)
							(= talkLoop 2)
						)
						(4
							(= showTalk 0)
							(= bodyView 944)
							(= bodyLoop 2)
						)
					)
				)
			)
			(5
				(if (IsFlag 53)
					(= bodyView 934)
					(= bodyLoop 1)
					(= talkView 9340)
					(= talkLoop 1)
				else
					(switch global156
						(0
							(= bodyView 944)
							(= bodyLoop 1)
							(= talkView 9441)
							(= talkLoop 1)
						)
						(1
							(= bodyView 944)
							(= bodyLoop 1)
							(= talkView 9440)
							(= talkLoop 1)
						)
						(2
							(= bodyView 944)
							(= bodyLoop 3)
							(= talkView 9440)
							(= talkLoop 3)
						)
						(3
							(= bodyView 944)
							(= bodyLoop 3)
							(= talkView 9441)
							(= talkLoop 3)
						)
						(4
							(= showTalk 0)
							(= bodyView 944)
							(= bodyLoop 3)
						)
					)
				)
			)
			(6
				(cond
					((IsFlag 53)
						(= bodyView 936)
						(= bodyLoop 0)
						(= talkView 9360)
						(= talkLoop 0)
					)
					((== global156 1)
						(= bodyView 946)
						(= bodyLoop 0)
						(= talkView 9460)
						(= talkLoop 0)
					)
					((== global156 4)
						(= showTalk (= prepMove 0))
					)
					(else
						(= prepMove 0)
						(= talkView 9461)
						(= talkLoop 0)
					)
				)
			)
			(7
				(cond
					((IsFlag 53)
						(= bodyView 936)
						(= bodyLoop 1)
						(= talkView 9360)
						(= talkLoop 1)
					)
					((== global156 1)
						(= bodyView 946)
						(= bodyLoop 1)
						(= talkView 9460)
						(= talkLoop 1)
					)
					((== global156 4)
						(= showTalk (= prepMove 0))
					)
					(else
						(= prepMove 0)
						(= talkView 9461)
						(= talkLoop 1)
					)
				)
			)
		)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(= state 2)
			(= scratch 1)
			(if prepMove
				(body view: bodyView setLoop: bodyLoop)
				(body setCel: (body lastCel:) setCycle: Beg self)
			else
				(self realDispose:)
			)
		else
			(= scratch 0)
			(self realDispose:)
		)
	)

	(method (realDispose)
		(if (and (& gMsgType $0001) narratorBuf)
			(narratorBuf dispose:)
			(= narratorBuf 0)
		)
		(if curText
			(gTextScroller addString: {} 50 84 0)
			(gTextScroller addString: {} gUserFont 82 0)
			(strHandle dispose:)
			(= curText 0)
		)
		(cond
			(scratch
				(= state 0)
				(if (or prepMove showTalk)
					(client show:)
					(body dispose:)
					(= body 0)
				)
			)
			(body
				(body setCycle: 0 setCel: 0)
			)
		)
		(super dispose: scratch)
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp1 (Print new:))
		(temp1 x: 7 y: 192 font: gUserFont back: 0 modeless: 2 init:)
		(if gTextScroller
			(= strHandle (Str format: {%s\n} (self name:)))
			(gTextScroller addString: (strHandle data:) 50 84 0)
			(strHandle dispose:)
			(= strHandle (Str format: {%s\n\n} param1))
			(= curText (gTextScroller addString: (strHandle data:) gUserFont 82 0 0))
		)
		(gPrints delete: temp1)
		(= dialog (temp1 dialog:))
	)
)

(instance Roger of EgoSmallTalker
	(properties)

	(method (init)
		(if (and (gCast contains: gEgo) (self canTalk:) (!= global156 5))
			(self setViews:)
		else
			(= showTalk (= prepMove 0))
		)
		(super init:)
	)

	(method (canTalk &tmp temp0)
		(if (IsFlag 53)
			(= temp0 902)
		else
			(= temp0 900)
		)
		(return
			(and
				(== (gEgo view:) (+ temp0 1))
				(not (& (gInventory state:) $0020))
			)
		)
	)
)

(instance endroidReforms of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setMotion: 0)
				(= cycles 12)
			)
			(1
				(Load 140 2901 2902) ; WAVE
				(client setHeading: 225 self)
			)
			(2
				(client
					view: 2950
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: CT 22 1 self
				)
			)
			(3
				((= local1 (Sound new:)) number: 2902 loop: 0 play: setVol: 127)
				(client setCycle: CT 30 1 self)
			)
			(4
				(client setCycle: End)
				((= local0 (Prop new:))
					view: 2950
					loop: 2
					cel: 0
					posn: (client x:) (client y:)
					init:
					setCycle: End self
				)
				(if (gEgo scaler:)
					(local0 setScaler: gEgo)
				)
				(local1 number: 2901 play:)
			)
			(5
				(EgoDead 26 self) ; "You pick strange methods of getting a charge out of life."
			)
			(6
				(local0 hide: dispose:)
				(= local0 0)
				(local1 dispose:)
				(= local1 0)
				(cond
					((gEgo has: 61) ; Full_Tray
						(ClearFlag 21)
						(SetFlag 16)
						(client put: 61 get: 60) ; Full_Tray, Empty_Tray
						((gInventory at: 60) select: 0 1) ; Empty_Tray
						(= global121 (gTheIconBar curIcon:))
					)
					((IsFlag 25) 0)
					(else
						(ClearFlag 21)
						(SetFlag 16)
						(client put: 111 get: 110) ; Whisk_Broom_Full, Whisk_Broom
						((gInventory at: 110) select: 0 1) ; Whisk_Broom
						(= global121 (gTheIconBar curIcon:))
					)
				)
				(ClearFlag 29)
				(ClearFlag 30)
				(ClearFlag 33)
				(if (!= gCurRoomNum 290)
					(gGame handsOn:)
					(gCurRoom newRoom: 290)
				else
					(client posn: (client x:) (client y:))
					(gCurRoom notify:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sPutOnEvaSuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 53)
				(client put: 46 setMotion: 0 setSpeed: 6 setHeading: 180 self) ; Eva_Suit
			)
			(1
				(client view: 4890 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(client normalize: 2)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRemoveEvaSuit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 53)
				(client get: 46 setMotion: 0 setSpeed: 6 setHeading: 180 self) ; Eva_Suit
			)
			(1
				(client view: 4890 loop: 0)
				(client cel: (client lastCel:) setCycle: Beg self)
			)
			(2
				(client normalize: 2)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTryEvaHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setMotion: 0 setSpeed: 6 setHeading: 180 self)
			)
			(1
				(= cycles 5)
			)
			(2
				(client view: 4881 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(= ticks 30)
			)
			(4
				(client loop: 1 cel: 0 setCycle: End self)
			)
			(5
				(= ticks 60)
			)
			(6
				(client setCycle: Beg self)
			)
			(7
				(= ticks 30)
			)
			(8
				(gMessager say: 2 0 0 0 self 20) ; "It just doesn't work that way."
			)
			(9
				(= ticks 30)
			)
			(10
				(client view: 4881 loop: 0)
				(client cel: (client lastCel:) setCycle: Beg self)
			)
			(11
				(client normalize: 2)
				(= cycles 1)
			)
			(12
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPutOnEvaHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 53)
				(SetFlag 52)
				(client put: 45 setMotion: 0 setSpeed: 6 setHeading: 180 self) ; Eva_Helmet
			)
			(1
				(client view: 4892 loop: 0 cel: 0 setCycle: End self)
			)
			(2
				(client normalize: 2)
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sRemoveEvaHelmet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client setMotion: 0 setSpeed: 6 setHeading: 180 self)
			)
			(1
				(client view: 4892 loop: 0)
				(client cel: (client lastCel:) setCycle: Beg self)
			)
			(2
				(ClearFlag 52)
				(SetFlag 53)
				(client get: 45 normalize: 2) ; Eva_Helmet
				(= cycles 1)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHandleAlarm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(egoSound number: 453 play: self)
			)
			(1
				(if (IsFlag 49)
					(ClearFlag 49)
					(gMessager say: 1 0 1 0 self 20) ; "The shuttle's alarm is now activated."
				else
					(SetFlag 49)
					(gMessager say: 1 0 2 0 self 20) ; "The shuttle's alarm is now deactivated."
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoSound of Sound
	(properties)
)

