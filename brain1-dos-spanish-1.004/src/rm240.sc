;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm240 0
)

(local
	[local0 3] = [43 0 5]
	[local3 3] = [11 1 7]
	local6 = -1
	[local7 18] = [90 39 90 59 54 79 114 79 42 49 78 49 101 49 41 69 101 69]
	[local25 9] = [0 0 1 1 2 2 3 2 3]
	[local34 5] = [12 29 84 127 220]
	[local39 10]
	local49
	local50
	local51 = -1
	local52
	[local53 5]
	[local58 5]
	local63
	[local64 5] = [10 44 82 128 154]
	[local69 5] = [101 107 112 105 106]
	[local74 5] = [35 69 115 141 179]
	[local79 5] = [130 129 124 131 127]
	[local84 8] = [{A battery} {A switch} {A coil} {A resistor} {A capacitor} 3 2 -1]
	local92
	local93
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
		(= temp1 (Connection new:))
		(temp1
			num: temp0
			xpos: [local7 (* 2 temp0)]
			ypos: [local7 (+ (* 2 temp0) 1)]
			orientation: [local25 temp0]
		)
		(= temp2 (temp1 xpos:))
		(= temp3 (temp1 ypos:))
		(temp1
			left: (- temp2 4)
			right: (+ temp2 4)
			top: (- temp3 4)
			bottom: (+ temp3 4)
		)
		(connectSet add: temp1)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
		(= temp1 (compSet at: temp0))
		(if
			(or
				(and
					(= temp2 (IsObject (temp1 curConnection:)))
					(!=
						((temp1 curConnection:) num:)
						(temp1 correctConnection:)
					)
				)
				(not temp2)
			)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_2 param1)
	(return (/ param1 8))
)

(procedure (localproc_3 param1 &tmp temp0 temp1 temp2 temp3 [temp4 6])
	(= temp1 0)
	(= temp3 1)
	(for ((= temp0 7)) (>= temp0 0) ((-- temp0))
		(= temp2 (sequencer at: (+ (* 8 param1) temp0)))
		(+= temp1 (* temp3 (- (temp2 loop:) 1)))
		(*= temp3 2)
	)
	(if (!= local51 2)
		(if local52
			(Display 240 20 dsRESTOREPIXELS [local39 (+ param1 5)])
		)
		(Format @temp4 240 25 temp1) ; "%d"
		(= [local39 (+ param1 5)]
			(Display @temp4 dsCOORD 51 (+ 36 (* param1 17)) dsFONT 999 dsCOLOR 0 dsSAVEPIXELS)
		)
	)
	(return temp1)
)

(procedure (localproc_4 &tmp temp0)
	(for ((= temp0 0)) (< temp0 (bulbSet size:)) ((++ temp0))
		(if (!= ((bulbSet at: temp0) cel:) 1)
			(return 0)
		)
	)
	(return 1)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2 temp3 temp4)
	(if (== local51 0)
		(= temp4 63)
	else
		(= temp4 255)
	)
	(= [local34 0] (Random 1 temp4))
	(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
		(= temp3 1)
		(while (== temp3 1)
			(= temp2 (Random 1 temp4))
			(for ((= temp1 0)) (< temp1 temp0) ((++ temp1))
				(if (== temp2 [local34 temp1])
					(= temp3 1)
					(break)
				)
				(= temp3 0)
			)
		)
		(= [local34 temp0] temp2)
	)
)

(procedure (localproc_6 &tmp temp0 temp1 temp2 temp3 [temp4 3])
	(= temp3 31)
	(= temp2 16)
	(for ((= temp0 0)) (<= temp0 4) ((++ temp0))
		(if local52
			(Display 240 20 dsRESTOREPIXELS [local39 temp0])
		)
		(Format @temp4 240 25 [local34 temp0]) ; "%d"
		(= [local39 temp0]
			(Display @temp4 dsCOORD temp2 (+ temp3 5) dsFONT 999 dsCOLOR 0 dsSAVEPIXELS)
		)
		(if (!= local51 2)
			(localproc_3 temp0)
		)
		(+= temp3 17)
	)
	(= local52 1)
)

(procedure (localproc_7 param1)
	(if (and (& (param1 type:) $0004) (== (param1 message:) 13))
		(param1 type: 1 message: 0)
	)
)

(instance rm240 of Rm
	(properties
		picture 240
		style 7
		south 220
	)

	(method (doit)
		(super doit: &rest)
		(Palette palANIMATE 234 255 1)
		(if local49
			(Palette palANIMATE 224 230 -1 234 255 -1)
		)
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(= [local0 temp0] [local3 temp0])
			)
		)
		(LoadMany rsSOUND 50 51 58 241 266 921 926)
		(super init: &rest)
		(if (> global106 16)
			(= local93 240)
		else
			(= local93 243)
		)
		(gCMusic number: local93 setLoop: -1 hold: 1 flags: 1 play:)
		(circuitFeat init:)
		(problemFeat setCycle: Fwd init:)
		(tapeFeat setCycle: Fwd init:)
		(binaryFeat init:)
		(circuit init:)
		(c1 init: stopUpd:)
		(c2 init: stopUpd:)
		(c3 init: stopUpd:)
		(c4 init: stopUpd:)
		(c5 init: stopUpd:)
		(tView posn: -100 -100 hide: init:)
		(= local49 (IsFlag 16))
		(= local50 (IsFlag 17))
		(if local49
			(electricalArc play:)
		)
	)

	(method (dispose)
		(bulbSet eachElementDo: #dispose release: dispose:)
		(connectSet eachElementDo: #dispose release: dispose:)
		(compSet eachElementDo: #dispose release: dispose:)
		(circuit dispose:)
		(sequencer dispose:)
		(gCMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 0) ; "This room looks like the inside of a computer. Two large computer consoles are floating in mid-air."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance circuit of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		hintFlag 37
		solvedFlag 16
	)

	(method (init &tmp temp0)
		(= window cirWindow)
		(cirWindow back: [local0 0])
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(self
				add:
					((= [local53 temp0] (responder_Sdetector new:))
						nsLeft: [local64 temp0]
						nsTop: [local69 temp0]
						nsRight: [local74 temp0]
						nsBottom: [local79 temp0]
						value: temp0
						yourself:
					)
			)
		)
		(super init: &rest)
	)

	(method (show)
		(tapeFeat hide:)
		(problemFeat hide:)
		(super show: &rest)
		(tapeFeat show:)
		(problemFeat show:)
		(compSet eachElementDo: #dispose)
		(if (gEgo has: 29)
			(connectSet eachElementDo: #dispose release: dispose:)
			(compSet eachElementDo: #dispose release: dispose:)
			(self dispose:)
		)
	)

	(method (buyClue &tmp [temp0 2])
		(if (super buyClue:)
			(proc5_9 240 1)
		)
	)

	(method (showHelp)
		(proc5_9 240 2)
		(proc5_9 240 3)
	)

	(method (animateOnce)
		(Animate (gCast elements:) 1)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= local63 0)
		(if (!= gTheCursor 8)
			(gGame setCursor: 8)
		)
		(= temp0 (event type:))
		(= temp2 (event x:))
		(= temp3 (event y:))
		(event globalize:)
		(= gLastEvent event)
		(gCast handleEvent: event)
		(if (and (& temp0 $0040) (!= local6 -1)) ; direction
			((compSet at: local6) doit: event)
			(return 0)
		)
		(event localize:)
		(= temp4 (self firstTrue: #onMe event))
		(if (and (!= local6 -1) (= temp5 (connectSet firstTrue: #onMe event)))
			((compSet at: local6) cel: (temp5 orientation:))
		)
		(if (not (event claimed:))
			(if (== (event type:) evNULL)
				0
			else
				(if (not (< (- size 5) (self indexOf: temp4) (- size 1)))
					(localproc_7 event)
				)
				(if (== (event type:) evMOUSEBUTTON)
					(cond
						((and (<= 34 temp2 148) (<= 28 temp3 92))
							(if
								(and
									(!= local6 -1)
									(IsObject temp5)
									(not (temp5 filled:))
								)
								(temp5 filled: 1)
								((compSet at: local6)
									posn:
										(+ 55 (temp5 xpos:))
										(+ 32 (temp5 ypos:))
									curConnection: temp5
									setPri: -1
								)
								(= local6 -1)
								(gCMusic2
									number: 926
									flags: 1
									setLoop: 1
									play:
								)
								(if (localproc_1)
									(Animate (gCast elements:) 0)
									(reward1Sound play:)
									(proc5_9 240 4)
									(proc5_9 240 5)
									(gEgo get: 29)
									(= local49 1)
									(electricalArc play:)
									(self solvePuzzle: 2 goAway:)
									(resistor dispose:)
									(capacitor dispose:)
									(coil dispose:)
									(sSwitch dispose:)
									(battery dispose:)
								)
							)
						)
						(
							(and
								(<= 0 temp2 186)
								(<= 101 temp3 133)
								(!= local6 -1)
							)
							(= temp6 (compSet at: local6))
							(temp6 goHome: setPri: -1)
							(= local63 1)
							(= local6 -1)
						)
					)
				)
			)
		)
		(event claimed: 0)
		(if (super dispatchEvent: event)
			(return 1)
		else
			(return 0)
		)
	)

	(method (hide)
		(highlightedIcon highlight: 0)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)
)

(instance reward1Sound of Sound
	(properties
		flags 1
		number 50
	)
)

(instance reward2Sound of Sound
	(properties
		flags 1
		number 51
	)
)

(instance binaryButtonSound of Sound
	(properties
		flags 1
		number 58
	)
)

(instance electricalArc of Sound
	(properties
		flags 1
		number 241
		loop -1
	)
)

(instance responder_Sdetector of CodeIcon
	(properties
		name {responder}
	)

	(method (highlight param1 &tmp temp0)
		(if (== local6 -1)
			(= temp0 (compSet at: value))
			(if param1
				(if (not (temp0 curConnection:))
					([local58 value] loop: 6 cel: value)
				else
					(tView
						loop: 6
						cel: value
						posn: (temp0 homeX:) (temp0 homeY:)
						show:
					)
				)
				(Print [local84 value] #at 20 166 #time 5 #dispose)
			else
				(if (not (temp0 curConnection:))
					([local58 value]
						loop: (+ value 1)
						cel: (if (== value 3) 2 else 0)
					)
				else
					(tView hide:)
				)
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
			)
		)
	)

	(method (select)
		(if (and (== local6 -1) (not local63))
			(self highlight: 0)
			(= local6 value)
			([local58 value] setPri: 15)
			(if (IsObject ([local58 value] curConnection:))
				(([local58 value] curConnection:) filled: 0)
				([local58 value] curConnection: 0)
			)
		)
	)

	(method (show))

	(method (mask))
)

(instance compSet of Set
	(properties)
)

(instance connectSet of Set
	(properties)
)

(instance cirWindow of SysWindow
	(properties
		top 32
		left 55
		bottom 167
		right 240
		priority -1
	)

	(method (open &tmp temp0 temp1 temp2)
		(super open:)
		(DrawCel 250 0 0 1 20 -1)
		(= temp0 77)
		(= temp1 162)
		(if (not (compSet size:))
			(battery
				posn: temp0 temp1
				homeX: temp0
				homeY: temp1
				setPri: -1
				correctConnection: 2
			)
			(= temp0 110)
			(= temp1 161)
			(sSwitch
				posn: temp0 161
				homeX: temp0
				homeY: 161
				setPri: -1
				correctConnection: 4
			)
			(= temp0 153)
			(= temp1 156)
			(coil
				posn: temp0 156
				homeX: temp0
				homeY: 156
				setPri: -1
				correctConnection: 1
			)
			(= temp0 195)
			(= temp1 150)
			(resistor
				posn: temp0 150
				homeX: temp0
				homeY: 150
				setPri: -1
				correctConnection: 0
			)
			(= temp0 221)
			(= temp1 159)
			(capacitor
				posn: temp0 159
				homeX: temp0
				homeY: 159
				setPri: -1
				correctConnection: 3
			)
			(compSet add: battery sSwitch coil resistor capacitor)
		)
		(for ((= temp2 0)) (< temp2 5) ((++ temp2))
			(= [local58 temp2] (compSet at: temp2))
		)
		(compSet eachElementDo: #init)
		(if (not (connectSet size:))
			(localproc_0)
		)
	)
)

(instance tView of Prop
	(properties
		view 250
		loop 6
	)
)

(class Component of Prop
	(properties
		value 0
		homeX 0
		homeY 0
		curConnection 0
		correctConnection 0
	)

	(method (goHome)
		(self cel: (if (== self resistor) 2 else 0) posn: homeX homeY)
	)

	(method (doit param1 &tmp temp0 temp1 temp2 [temp3 4])
		(super doit: &rest)
		(if (== value local6)
			(if argc
				(param1 localize:)
				(gTheDoits doit:)
				(gPMouse handleEvent: param1)
				(param1 dispose:)
			else
				(= temp0 (Event new: -1))
				(= temp1 (temp0 x:))
				(= temp2 (- (= temp2 (temp0 y:)) 10))
				(temp0 localize:)
				(gTheDoits doit:)
				(temp0 dispose:)
				(self posn: temp1 temp2)
			)
		)
	)

	(method (handleEvent event param2 &tmp temp0 temp1)
		(if curConnection
			(= temp1 (GetPort))
			(SetPort 0)
			(event localize:)
			(= temp0 0)
			(cond
				((event claimed:)
					(return 1)
				)
				((and (== (event type:) evMOUSEBUTTON) (== local6 -1) (self onMe: event))
					(= local6 value)
					(self setPri: 15)
					(if (IsObject curConnection)
						(curConnection filled: 0)
						(= curConnection 0)
					)
					(event claimed: 1)
				)
			)
			(SetPort temp1)
		else
			(super handleEvent: event param2 &rest)
		)
	)
)

(class Connection of Obj
	(properties
		num 0
		xpos 0
		ypos 0
		orientation 0
		filled 0
		correct 0
		left 0
		right 0
		top 0
		bottom 0
	)

	(method (onMe param1 &tmp temp0 temp1)
		(= temp0 (param1 x:))
		(= temp1 (param1 y:))
		(return (and (<= left temp0 right) (<= top temp1 bottom)))
	)
)

(instance battery of Component
	(properties
		view 250
		loop 1
	)
)

(instance sSwitch of Component
	(properties
		view 250
		loop 2
		value 1
	)
)

(instance coil of Component
	(properties
		view 250
		loop 3
		value 2
	)
)

(instance resistor of Component
	(properties
		view 250
		loop 4
		cel 2
		value 3
	)
)

(instance capacitor of Component
	(properties
		view 250
		loop 5
		value 4
	)
)

(instance problemFeat of Prop
	(properties
		x 77
		y 103
		description {circuit repair manual}
		view 240
		loop 7
		cel 5
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 3) (== theVerb 2))
			(if (not (IsFlag 16))
				(proc5_9 240 6 70 220)
			else
				(proc5_9 240 7)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance circuitFeat of Feature
	(properties
		description {circuit panel}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 8) ; "This panel contains the central control circuitry for the computer system."
			)
			(3
				(if (not local49)
					(circuit show:)
				else
					(proc5_9 240 9)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tapeFeat of Prop
	(properties
		x 188
		y 80
		description {tape drive}
		onMeCheck 8
		view 240
		loop 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 10) ; "Dr. Brain built this tape drive out of an old washing machine. It's totally obsolete, but he insisted on keeping it in the system out of a sense of history."
			)
			(3
				(proc5_9 240 11)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance binaryFeat of Feature
	(properties
		description {binary sequencing computer}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 12) ; "This is a once-state-of-the-art manually-motivated binary sequencing computer. (It's not even as up-to-date as the tape drive. But it could use your help.)"
			)
			(3
				(if (not local50)
					(sequencer init:)
				else
					(proc5_9 240 13)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance c1 of Prop
	(properties
		x 16
		y 144
		description {capacitor}
		view 240
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 14) ; "It's a happy red disc capacitor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance c2 of Prop
	(properties
		x 295
		y 94
		description {capacitor}
		view 240
		loop 1
		cel 13
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 15) ; "It's a shy yellow disc capacitor."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance c3 of Prop
	(properties
		x 307
		y 54
		description {electrolytic capacitor}
		view 240
		loop 2
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 16) ; "It's one of the famous Dancing Electrolytic Capacitors (the name may have something to do with the fact that they never made it big)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance c4 of Prop
	(properties
		x 285
		y 78
		description {resistor}
		view 240
		loop 3
		cel 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 17) ; "This is a resistor (as opposed to a draft resister)."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance c5 of Prop
	(properties
		x 18
		y 95
		description {resistor}
		view 240
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 240 18) ; "This is a resistor. It is used to control the flow of current through a circuit. (As opposed to a draft resister, which probably controls the flow of air through a drafty castle.)"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bulbSet of Set
	(properties)
)

(instance bulbSound of Sound
	(properties
		flags 1
		number 266
	)
)

(instance binIcon of CodeIcon
	(properties)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(binaryButtonSound play:)
			(= loop (- 3 loop))
			(self show:)
			(if (== [local34 (= temp0 (localproc_2 value))] (localproc_3 temp0))
				((bulbSet at: temp0) cel: 1)
				(bulbSound play:)
				(Animate (gCast elements:) 0)
				(if (localproc_4)
					(Wait 0)
					(Wait 120)
					(c1 setCycle: Fwd)
					(c2 setCycle: Fwd)
					(c3 setCycle: Fwd)
					(c4 setCycle: Fwd)
					(c5 setCycle: Fwd)
					(sequencer solvePuzzle: local51 goAway:)
				)
			else
				((bulbSet at: temp0) cel: 0)
			)
		)
	)
)

(instance sequencer of PuzzleBar
	(properties
		puzzleHeight 169
		bottomHeight 0
		solvedFlag 17
	)

	(method (init)
		(= window binWindow)
		(super init: &rest)
		(self show:)
	)

	(method (show &tmp temp0)
		(tapeFeat stopUpd:)
		(problemFeat stopUpd:)
		(= highlightedIcon (self at: (- size 3)))
		(super show: &rest)
		(bulbSet eachElementDo: #hide)
		(Animate (bulbSet elements:) 0)
		(tapeFeat startUpd:)
		(problemFeat startUpd:)
		(Animate (gCast elements:) 0)
		(cond
			((not local49)
				(proc5_11 240 19)
			)
			(local50
				(gCurRoom setScript: finishRoom)
			)
		)
	)

	(method (goAway &tmp temp0)
		(SetPort -1)
		(for ((= temp0 0)) (< temp0 (if (== local51 2) 5 else 10)) ((++ temp0))
			(Display 240 20 dsRESTOREPIXELS [local39 temp0])
		)
		(SetPort 0)
		(super goAway:)
	)

	(method (solvePuzzle)
		(super solvePuzzle: &rest)
		(reward2Sound play:)
		(proc5_11 240 21)
		(gEgo get: 8)
		(= local50 1)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super buyClue:)
			(for ((= temp0 0)) (< temp0 (bulbSet size:)) ((++ temp0))
				(if (== ((bulbSet at: temp0) cel:) 0)
					(break)
				)
			)
			(= temp2 1)
			(= temp3 [local34 temp0])
			(for ((= temp1 0)) (<= temp1 7) ((++ temp1))
				(= temp5 (self at: (+ (* 8 temp0) temp1)))
				(if (== (temp5 loop:) 2)
					(temp5 select:)
				)
			)
			(for ((= temp4 7)) (>= temp4 0) ((-- temp4))
				(= temp5 (self at: (+ (* 8 temp0) temp4)))
				(if (& temp2 temp3)
					(temp5 select:)
				)
				(+= temp2 temp2)
			)
		)
	)

	(method (showHelp)
		(proc5_11 240 22)
		(if (!= global114 2)
			(proc5_11 240 23)
		)
		(proc5_11 240 24)
	)

	(method (animateOnce)
		(Animate (bulbSet elements:) 1)
		(return 1)
	)

	(method (dispatchEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5)
		(if (not local49)
			(Animate (gCast elements:) 0)
			(Wait 0)
			(Wait 60)
			(sequencer goAway:)
		)
		(= temp0 (event type:))
		(= temp4 (self indexOf: highlightedIcon))
		(= temp1 (self firstTrue: #onMe event))
		(if (& temp0 $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(if (highlightedIcon isKindOf: CodeIcon)
						(if (<= temp4 31)
							(= temp5 (self at: (+ temp4 8)))
						else
							(= temp5 (self at: (- size 3)))
						)
					else
						(= temp5 (self at: 0))
					)
					(proc5_20 temp5)
					(self highlight: temp5)
				)
				(JOY_UP
					(if (highlightedIcon isKindOf: CodeIcon)
						(if (< 7 temp4 (- size 4))
							(= temp5 (self at: (- temp4 8)))
						else
							(= temp5 (self at: (- size 3)))
						)
					else
						(= temp5 (self at: (- size 5)))
					)
					(proc5_20 temp5)
					(self highlight: temp5)
				)
			)
		)
		(event claimed: 0)
		(super dispatchEvent: event)
	)
)

(instance binWindow of SysWindow
	(properties
		top 14
		left 49
		bottom 137
		right 267
		back 43
		priority -1
	)

	(method (open &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(super open:)
		(DrawCel 245 0 0 1 20 -1)
		(= local52 0)
		(if (!= local51 global114)
			(= local51 global114)
			(localproc_5)
		)
		(if (not (bulbSet size:))
			(= local92 global114)
			(= temp1 31)
			(= temp5 0)
			(for ((= temp3 0)) (<= temp3 4) ((++ temp3))
				(= temp0 81)
				(for ((= temp4 0)) (<= temp4 7) ((++ temp4))
					(= temp2 (binIcon new:))
					(temp2
						value: temp5
						nsLeft: temp0
						nsTop: temp1
						view: 245
						loop: 1
						cel: 0
						highlightColor: [local0 1]
						lowlightColor: [local0 2]
					)
					(++ temp5)
					(+= temp0 14)
					(sequencer add: temp2)
				)
				(= temp6 (Prop new:))
				(temp6
					view: 245
					loop: 3
					cel: 0
					setPri: 15
					posn: (+ temp0 56) (- (+ temp1 32) 6)
					init:
				)
				(bulbSet add: temp6)
				(+= temp1 17)
			)
			(= temp7 (sequencer at: 0))
			(= temp8 (sequencer at: 1))
			(= temp9 (sequencer at: 2))
			(= temp10 (sequencer at: 3))
			(sequencer
				delete: temp7
				addToEnd: temp7
				delete: temp8
				addToEnd: temp8
				delete: temp9
				addToEnd: temp9
				delete: temp10
				addToEnd: temp10
			)
		else
			(if (!= local92 global114)
				(bulbSet eachElementDo: #cel 0)
				(= local92 global114)
			)
			(bulbSet eachElementDo: #show)
		)
		(localproc_6)
	)
)

(instance earthquakeSound of Sound
	(properties
		flags 1
		number 921
	)
)

(instance finishRoom of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(earthquakeSound play:)
				(= cycles 1)
			)
			(1
				(ShakeScreen 25 ssLEFTRIGHT)
				(= cycles 1)
			)
			(2
				(earthquakeSound fade: 0 15 12 1)
				(= cycles 1)
			)
			(3
				(= ticks 300)
			)
			(4
				(gCurRoom newRoom: 220)
			)
		)
	)
)

