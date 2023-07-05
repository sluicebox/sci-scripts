;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 41)
(include sci.sh)
(use Main)
(use Rev)
(use Window)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm041 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm041 of Rm
	(properties
		picture 41
		style 0
		horizon 133
		picAngle 70
	)

	(method (init)
		(Load rsVIEW 82)
		(Load rsVIEW 44)
		(Load rsVIEW 241)
		(Load rsVIEW 36)
		(Load rsVIEW 133)
		(Load rsVIEW 39)
		(Load rsSOUND 20)
		(Load rsSOUND 41)
		(Load rsSOUND 14)
		(Load rsSOUND 22)
		(super init:)
		(= global207 1)
		(itemBalloon init:)
		(itemVisual init:)
		(gEgo loop: 1 posn: 293 173 init:)
		(proc0_10 115 166 330 169)
		(HandsOn)
		(clock setPri: 1 stopUpd: init:)
		(minHand setPri: 3 cycleSpeed: 2 init:)
		(hourHand setPri: 3 init:)
		(pend setPri: 2 cycleSpeed: 3 setCycle: Fwd init:)
		(minHandKoo setPri: 4 cycleSpeed: 1 setCycle: Fwd init:)
		(hourHandKoo setPri: 4 cycleSpeed: 7 setCycle: Fwd init:)
		(kooKoo setPri: 4 setScript: kooKooScript init: hide:)
		(minHand1 setPri: 1 cycleSpeed: 1 setCycle: Rev init:)
		(hourHand1 setPri: 1 cycleSpeed: 5 setCycle: Fwd init:)
		(pend1 setPri: 3 cycleSpeed: 3 setCycle: Fwd init:)
		(minHand2 setPri: 1 cycleSpeed: 2 setCycle: Rev init:)
		(hourHand2 setPri: 1 cycleSpeed: 6 setCycle: Rev init:)
		(pend2 setPri: 3 cycleSpeed: 4 setCycle: Fwd init:)
		(minHand3 setPri: 1 cycleSpeed: 4 init:)
		(hourHand3 setPri: 1 init:)
		(pend3 setPri: 3 cycleSpeed: 7 setCycle: Fwd init:)
		(table init:)
		(gAddToPics
			add: kooKooKlock clock1 clock2 clock3 shelfClocks caseClocks
			eachElementDo: #init
			doit:
		)
		(gGlobalMGSound number: 20 priority: 5 loop: -1 play: kooKooScript)
		(if (not [global675 41])
			(if (= local1 (proc0_11 44))
				(= [global675 41] 1)
				(= global206 gSpeed)
				(switch global131
					(0
						(gGame setSpeed: 4)
					)
					(1
						(gGame setSpeed: 7)
					)
					(2
						(gGame setSpeed: 8)
					)
				)
				(self setScript: rhymeScript)
			)
		else
			(mouseDone init:)
		)
	)

	(method (handleEvent event &tmp temp0)
		(= local0 (event type:))
		(switch (event type:)
			(evKEYBOARD
				(if
					(and
						(== (rhymeScript state:) 10)
						(== local4 1)
						(== (event message:) KEY_RETURN)
					)
					(rhymeScript cycles: 1)
				)
			)
			($0040 ; direction
				(if (and (== (rhymeScript state:) 10) (== local4 1))
					(rhymeScript cycles: 1)
				)
			)
			(evMOUSEBUTTON
				(= temp0 (event modifiers:))
				(if (and (== (rhymeScript state:) 10) (== local4 1))
					(rhymeScript cycles: 1)
				)
				(if (and (& temp0 emSHIFT) (!= local2 1))
					(cond
						((proc0_16 event 134 86 157 146)
							(if (not [global675 41])
								(LookAt clock)
								(self setScript: talkScript)
							)
						)
						((and (proc0_16 event 69 81 85 103) (== local3 2))
							(= local3 4)
							(kooKooScript cue:)
						)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doit)
		(if (gEgo inRect: 294 168 309 181)
			(gGlobalMGSound number: 1 loop: -1 stop:)
			(self newRoom: 24)
		)
		(super doit:)
		(if (> (gEgo distanceTo: clock) 30)
			(= global108 0)
		)
		(if
			(and
				(not [global675 41])
				(not global108)
				(< (gEgo distanceTo: clock) 30)
			)
			(= global108 1)
			(LookAt clock)
			(self setScript: talkScript)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global103 1)
				(= local2 1)
				(HandsOff)
				(clock cycleSpeed: (if global131 2 else 1) setCycle: Fwd)
				(itemBalloon setCel: 0 show:)
				(RedrawCast)
				(rhymeSound number: 41 loop: 1 play:)
				(Display
					{Can you\nfind me\na mouse?}
					dsWIDTH
					80
					dsCOORD
					(- (itemBalloon x:) 38)
					(- (itemBalloon y:) 50)
					dsALIGN
					alCENTER
					dsFONT
					0
					dsCOLOR
					0
				)
				(= seconds global120)
			)
			(1
				(itemBalloon setCel: 1)
				(itemVisual show:)
				(clock setCel: 0)
				(= seconds global121)
			)
			(2
				(itemVisual hide:)
				(itemBalloon hide:)
				(= global103 0)
				(= local2 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance rhymeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global209 1)
				(= global103 1)
				(= local2 1)
				(HandsOff)
				(gEgo setMotion: MoveTo 190 176 self)
				(mouse init:)
			)
			(1
				(proc0_18)
				(gEgo setLoop: 3)
				(mouse setMotion: MoveTo 224 135 self)
			)
			(2
				(gEgo stopUpd:)
				(mouse setMotion: MoveTo 164 135 self)
			)
			(3
				(mouse view: 82 setLoop: 0 setMotion: MoveTo 163 115 self)
			)
			(4
				(self setScript: musicScript)
				(mouse setMotion: MoveTo 162 94 self)
			)
			(5
				(mouse setLoop: 2 setCel: 0 posn: 145 75 stopUpd:)
			)
			(6
				(mouse y: 77 setCel: (mouse lastCel:))
				(clock posn: 147 140)
				(mouse posn: (+ (clock x:) 1) (- (clock y:) 61))
				(hourHand posn: (+ (clock x:) 1) (- (clock y:) 49))
				(minHand posn: (+ (clock x:) 1) (- (clock y:) 49))
				(pend posn: (clock x:) (- (clock y:) 24))
				(RedrawCast)
				(clock posn: 144 136)
				(mouse posn: (+ (clock x:) 1) (- (clock y:) 61))
				(hourHand posn: (+ (clock x:) 1) (- (clock y:) 49))
				(minHand posn: (+ (clock x:) 1) (- (clock y:) 49))
				(pend posn: (clock x:) (- (clock y:) 24))
				(RedrawCast)
				(= cycles 2)
			)
			(7
				(mouse
					setLoop: 1
					posn: 163 88
					setCycle: Fwd
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 163 135 self
				)
			)
			(8
				(minHand setScript: clockHandsScript)
				(mouse
					view: 44
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 147 145 self
				)
			)
			(9
				(mouse
					view: 44
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 40 141 self
				)
			)
			(10
				(mouse setAvoider: 0 dispose:)
				(gEgo setMotion: 0 setAvoider: 0 setCycle: Walk setLoop: -1)
				(= local0 0)
				(= global103 0)
			)
			(11
				(gGame setSpeed: global206)
				(rhymeBox dispose:)
				(proc0_12)
				(if (== gScore gPossibleScore)
					(HandsOff)
					(gEgo setMotion: MoveTo 330 169)
				else
					(NormalEgo)
					(HandsOn)
					(= global209 0)
				)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (== (rhymeSound prevSignal:) -1)
			(rhymeSound prevSignal: 0)
			(= local4 1)
		)
	)
)

(instance musicScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rhymeSound number: 14 loop: 1 play: self)
				(rhymeBox init:)
				(rhymeBox open:)
			)
			(1
				(Display
					{Hickory, dickory, dock!}
					dsWIDTH
					320
					dsCOORD
					5
					3
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(2
				(Display
					{The mouse ran up the clock;}
					dsWIDTH
					320
					dsCOORD
					5
					13
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(3
				(Display
					{The clock struck one,}
					dsWIDTH
					320
					dsCOORD
					5
					23
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(4
				(rhymeScript cue:)
			)
			(5
				(Display {And down he run,} dsWIDTH 320 dsCOORD 5 33 dsALIGN alLEFT dsFONT 0 dsCOLOR 0)
			)
			(6
				(Display
					{Hickory, dickory, dock!}
					dsWIDTH
					320
					dsCOORD
					5
					43
					dsALIGN
					alLEFT
					dsFONT
					0
					dsCOLOR
					0
				)
			)
			(7
				(= seconds 3)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance clockHandsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (hourHand cel:) (hourHand lastCel:))
					(hourHand setCel: 0)
				else
					(hourHand setCel: (+ (hourHand cel:) 1))
				)
				(= cycles 2)
			)
			(1
				(hourHand stopUpd:)
				(minHand setCycle: End self)
			)
			(2
				(client setScript: clockHandsScript)
			)
		)
	)
)

(instance clock3HandsScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (hourHand3 cel:) (hourHand3 lastCel:))
					(hourHand3 setCel: 0)
				else
					(hourHand3 setCel: (+ (hourHand3 cel:) 1))
				)
				(= cycles 2)
			)
			(1
				(hourHand3 stopUpd:)
				(minHand3 setCycle: End self)
			)
			(2
				(client setScript: clock3HandsScript)
			)
		)
	)
)

(instance kooKooSound of Sound
	(properties
		number 22
		priority 15
	)
)

(instance rhymeSound of Sound
	(properties
		number 14
		priority 10
	)
)

(instance mouse of Act
	(properties)

	(method (init)
		(super init:)
		(self
			view: 44
			yStep: 2
			xStep: 4
			setCycle: Walk
			ignoreActors: 1
			illegalBits: 0
			ignoreHorizon: 1
			setAvoider: Avoid
			posn: (gEgo x:) (gEgo y:)
			setMotion: MoveTo 234 168
		)
	)
)

(instance mouseDone of View
	(properties)

	(method (init)
		(super init:)
		(self view: 82 posn: 145 75 setLoop: 2 setCel: 0 stopUpd:)
	)
)

(instance clock of Prop
	(properties
		y 136
		x 144
		view 241
		loop 8
	)
)

(instance minHand of Prop
	(properties
		y 87
		x 145
		view 241
		loop 4
		cel 9
	)
)

(instance hourHand of Prop
	(properties
		y 87
		x 145
		view 241
		loop 4
		cel 10
	)
)

(instance pend of Prop
	(properties
		y 112
		x 144
		view 241
		loop 3
	)
)

(instance kooKooKlock of PV
	(properties
		y 95
		x 78
		view 241
		loop 5
		priority 0
	)
)

(instance minHandKoo of Prop
	(properties
		y 83
		x 80
		view 241
		loop 7
		cel 9
	)
)

(instance hourHandKoo of Prop
	(properties
		y 83
		x 80
		view 241
		loop 7
		cel 8
	)
)

(instance kooKoo of Prop
	(properties
		y 79
		x 82
		view 241
		loop 6
	)
)

(instance clock1 of PV
	(properties
		y 112
		x 172
		view 241
		cel 5
		priority 0
	)
)

(instance minHand1 of Prop
	(properties
		y 86
		x 172
		view 241
		loop 4
		cel 2
	)
)

(instance hourHand1 of Prop
	(properties
		y 86
		x 172
		view 241
		loop 4
		cel 7
	)
)

(instance pend1 of Prop
	(properties
		y 99
		x 172
		view 241
		loop 1
	)
)

(instance clock2 of PV
	(properties
		y 109
		x 196
		view 241
		cel 6
		priority 0
	)
)

(instance minHand2 of Prop
	(properties
		y 83
		x 196
		view 241
		loop 4
		cel 5
	)
)

(instance hourHand2 of Prop
	(properties
		y 83
		x 196
		view 241
		loop 4
		cel 3
	)
)

(instance pend2 of Prop
	(properties
		y 99
		x 196
		view 241
		loop 2
	)
)

(instance clock3 of PV
	(properties
		y 115
		x 223
		view 241
		cel 7
		priority 0
	)
)

(instance minHand3 of Prop
	(properties
		y 89
		x 223
		view 241
		loop 4
	)
)

(instance hourHand3 of Prop
	(properties
		y 89
		x 223
		view 241
		loop 4
		cel 4
	)
)

(instance pend3 of Prop
	(properties
		y 101
		x 223
		view 241
		loop 1
	)
)

(instance shelfClocks of PV
	(properties
		y 135
		x 189
		view 241
		priority 11
	)
)

(instance caseClocks of PV
	(properties
		y 124
		x 104
		view 241
		cel 1
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 115 183 setPri: 11 ignoreActors: 1 stopUpd:)
	)
)

(instance itemVisual of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 133
			setLoop: 3
			setCel: 0
			posn: 90 60
			setPri: 15
			hide:
			stopUpd:
		)
	)
)

(instance itemBalloon of View
	(properties)

	(method (init)
		(super init:)
		(self
			view: 39
			setLoop: 0
			setCel: 0
			posn: 91 83
			setPri: 14
			hide:
			stopUpd:
		)
	)
)

(instance rhymeBox of Window
	(properties)

	(method (init)
		(super init:)
		(self
			top: 12
			left: 67
			bottom: 66
			right: 251
			type: 4
			title: {Hickory Dickory Dock}
			back: 12
		)
	)
)

(instance kooKooScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 2)
			)
			(1
				(if (!= local3 4)
					(self init:)
				else
					(= local3 3)
					(kooKoo show: setCycle: End)
				)
				(= cycles 2)
			)
			(2
				(kooKooSound number: 22 loop: 1 play: self)
			)
			(3
				(kooKoo setCycle: Beg self)
			)
			(4
				(kooKoo hide:)
				(self init:)
			)
		)
	)
)

