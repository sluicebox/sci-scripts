;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 291)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use IconBar)
(use LoadMany)
(use Rev)
(use Window)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	gearsPuzzle 0
)

(local
	local0
	[local1 10] = [147 160 182 205 216 147 160 182 205 216]
	[local11 10] = [60 43 36 43 60 159 142 135 142 159]
	[local21 10]
	[local31 10] = [144 149 180 210 214 144 149 180 210 214]
	[local41 10] = [77 32 26 32 77 176 131 125 131 176]
	[local51 2] = [73 172]
	[local53 10] = [46 45 46 64 17 64 0 64 0 43]
	[local63 2] = [84 114]
	[local65 2] = [82 112]
	local67
	local68
	local69
	local70
	[local71 2]
	local73
	local74
	[local75 2]
	[local77 2]
	local79
	local80
	local81
	local82
	local83
	local84
	local85
)

(procedure (localproc_0 &tmp temp0 temp1)
	(= local80 1)
	(ClearFlag 15)
	(= local79 0)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= temp1 (gearsPuzzle at: temp0))
		(temp1 signal: (| (temp1 signal:) $0004))
	)
	(for ((= temp0 7)) (< temp0 12) ((++ temp0))
		(= temp1 (gearsPuzzle at: temp0))
		(temp1 signal: (| (temp1 signal:) $0004))
	)
	(elevatorCast eachElementDo: #cel 0)
	(elevatorRope y: 49 loop: 11)
	(counterWtRope loop: 13)
	(elevator x: 86 y: 78 signal: 2066)
	(counterWeight x: 126 y: 121 signal: 2066)
	(crashDummy loop: 8 x: 101 y: 123 signal: 2066)
	(localproc_1)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= temp1 (gearsPuzzle at: temp0))
		(if (not (& (temp1 signal:) $0004))
			([local71 0] cel: (temp1 value:))
			(= local69 temp1)
			(break)
		)
	)
	(for ((= temp0 7)) (< temp0 12) ((++ temp0))
		(= temp1 (gearsPuzzle at: temp0))
		(if (not (& (temp1 signal:) $0004))
			([local71 1] cel: (mod (temp1 value:) 5))
			(= local70 temp1)
			(break)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(for ((= temp1 0)) (< temp1 10) ((++ temp1))
		(= [local21 temp1] 0)
	)
	(switch global114
		(0
			(= [local75 1] (Random 2 5))
			(= [local75 0] 1)
			(= local67 2)
			(= local68 3)
		)
		(1
			(= [local75 1] (Random 2 8))
			(= [local75 0] (Random 1 2))
			(= local67 3)
			(= local68 5)
		)
		(2
			(= [local75 1] (Random 5 9))
			(= [local75 0] (Random 2 5))
			(= local67 5)
			(= local68 5)
		)
	)
	(= [local77 1] (* (= temp0 (Random 12 18)) [local75 1]))
	(= [local77 0] (* temp0 [local75 0]))
	(= local83 (Random 0 4))
	(= [local21 local83] [local77 0])
	(if (< (- [local77 0] (* local83 12)) 8)
		(= temp6 (/ (- [local77 0] 8) local83))
	else
		(= temp6 12)
	)
	(for ((= temp1 (- local83 1))) (>= temp1 0) ((-- temp1))
		(= [local21 temp1] (- [local21 (+ temp1 1)] (Random 1 temp6)))
	)
	(for ((= temp1 (+ local83 1))) (< temp1 5) ((++ temp1))
		(= [local21 temp1] (+ [local21 (- temp1 1)] (Random 1 temp6)))
	)
	(= local84 (Random 5 9))
	(= [local21 local84] [local77 1])
	(if (< (- [local77 1] (* local84 12)) 8)
		(= temp6 (/ (- [local77 1] 8) local84))
	else
		(= temp6 12)
	)
	(for ((= temp1 (- local84 1))) (>= temp1 5) ((-- temp1))
		(= [local21 temp1] (+ [local21 (+ temp1 1)] (Random 1 temp6)))
	)
	(for ((= temp1 (+ local84 1))) (< temp1 10) ((++ temp1))
		(= [local21 temp1] (- [local21 (- temp1 1)] (Random 1 temp6)))
	)
	(for ((= temp1 0)) (< temp1 5) ((++ temp1))
		(= temp4 (gearsPuzzle at: temp1))
		(if (== (temp4 value:) local83)
			(temp4 signal: (& (temp4 signal:) $fffb))
		)
	)
	(for ((= temp1 1)) (< temp1 local67) ((++ temp1))
		(repeat
			(= temp5 (Random 0 4))
			(= temp4 (gearsPuzzle at: temp5))
			(if (& (temp4 signal:) $0004)
				(temp4 signal: (& (temp4 signal:) $fffb))
				(break)
			)
		)
	)
	(for ((= temp1 7)) (< temp1 12) ((++ temp1))
		(= temp4 (gearsPuzzle at: temp1))
		(if (== (temp4 value:) local84)
			(temp4 signal: (& (temp4 signal:) $fffb))
		)
	)
	(for ((= temp1 1)) (< temp1 local68) ((++ temp1))
		(repeat
			(= temp5 (Random 5 9))
			(= temp4 (gearsPuzzle at: (+ temp5 2)))
			(if (& (temp4 signal:) $0004)
				(temp4 signal: (& (temp4 signal:) $fffb))
				(break)
			)
		)
	)
	(if (== global114 2)
		(= local74 (Random 900 1000))
		(= temp3 (localproc_2 [local75 1] [local75 0]))
		(= temp2 (localproc_3 25 temp3))
		(= local73 (+ local74 temp2))
	else
		(= local74 (Random 300 600))
		(= temp3 (localproc_2 [local75 1] [local75 0]))
		(= local73 (localproc_3 local74 temp3))
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 [temp2 2])
	(= temp1 (/ param1 param2))
	(= [temp2 0] (mod param1 param2))
	(if (!= [temp2 0] 0)
		(= [temp2 0] (/ (= temp0 (* [temp2 0] 10)) param2))
		(= [temp2 1] (mod temp0 param2))
		(if (!= [temp2 1] 0)
			(= [temp2 1] (/ (= temp0 (* [temp2 1] 10)) param2))
			(if (> (= temp0 (mod temp0 param2)) 4)
				(++ [temp2 1])
			)
		)
	else
		(= [temp2 1] 0)
	)
	(return (+ (* temp1 100) (* [temp2 0] 10) [temp2 1]))
)

(procedure (localproc_3 param1 param2 &tmp temp0 [temp1 2] temp3 temp4)
	(= temp0 (/ param2 100))
	(= [temp1 0] (mod param2 100))
	(= [temp1 1] (mod [temp1 0] 10))
	(/= [temp1 0] 10)
	(= temp4 (/ (= temp3 (* [temp1 1] param1)) 100))
	(= temp3 (* [temp1 0] param1))
	(= temp4 (+ (+= temp4 (/ temp3 10)) (* temp0 param1)))
	(if (> [temp1 1] 4)
		(++ [temp1 0])
	)
	(if (> [temp1 0] 4)
		(++ temp4)
	)
	(return temp4)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6 &tmp temp0)
	(if (>= argc 6)
		(= temp0 param6)
	else
		(= temp0 gUserFont)
	)
	(Display param1 dsCOORD param3 param4 dsCOLOR param2 dsALIGN alLEFT dsFONT temp0 &rest)
)

(procedure (localproc_5 &tmp temp0 temp1 temp2)
	(for ((= temp0 0)) (< temp0 5) ((++ temp0))
		(= temp1 (gearsPuzzle at: temp0))
		(if (== (temp1 value:) local83)
			(break)
		)
	)
	(for ((= temp0 7)) (< temp0 12) ((++ temp0))
		(= temp2 (gearsPuzzle at: temp0))
		(if (== (temp2 value:) local84)
			(break)
		)
	)
	(Wait 0)
	(temp1 textColor: 28 show:)
	(temp2 textColor: 28 show:)
	(Wait 120)
	(temp1 textColor: 51 show:)
	(temp2 textColor: 51 show:)
)

(procedure (localproc_6 param1 &tmp temp0)
	(if param1
		(= temp0 (GetPort))
		(SetPort 0)
		(= local82 (Graph grSAVE_BOX 21 8 83 47))
		(DrawCel 292 0 1 8 21 15)
		(Animate (elevatorCast elements:) 0)
		(SetPort temp0)
	else
		(= temp0 (GetPort))
		(SetPort 0)
		(Graph grRESTORE_BOX local82)
		(Graph grUPDATE_BOX 21 8 83 47 1)
		(SetPort temp0)
	)
)

(procedure (localproc_7 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(instance gearsPuzzle of PuzzleBar
	(properties
		hintFlag 15
		solvedFlag 8
		noun 13
		personalID 3
	)

	(method (init &tmp temp0 temp1)
		(= local81 (gGame setCursor: gWaitCursor 1))
		(LoadMany rsVIEW 292 293)
		(= window puz2Window)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(self
				add:
					((= temp1 (gearChoices new:))
						nsLeft: [local1 temp0]
						nsTop: [local11 temp0]
						value: temp0
						cursor: 0
						loop: (+ temp0 1)
						maskLoop: (+ temp0 1)
					)
			)
			(temp1 signal: (| (temp1 signal:) $0004))
		)
		(self
			add: ((= [local71 0] (levers new:)) nsTop: [local51 0] nsLeft: 176)
		)
		(self add: downArrow)
		(for ((= temp0 5)) (< temp0 10) ((++ temp0))
			(self
				add:
					((= temp1 (gearChoices new:))
						nsLeft: [local1 temp0]
						nsTop: [local11 temp0]
						value: temp0
						cursor: 1
						loop: (- 5 (mod temp0 5))
						maskLoop: (- 5 (mod temp0 5))
					)
					(temp1 signal: (| (temp1 signal:) $0004))
			)
		)
		(self
			add: ((= [local71 1] (levers new:)) nsTop: [local51 1] nsLeft: 176)
		)
		(self add: inputGearIcon outputGearIcon)
		(localproc_0)
		(super init: &rest)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4)
		(elevatorCast
			add:
				ratWheel
				rat
				chain
				miniWheel
				elevator
				elevatorRope
				counterWtRope
				crashDummy
				counterWeight
		)
		(ratWheel hide:)
		(rat hide:)
		(chain hide:)
		(miniWheel hide:)
		(elevator show:)
		(elevatorRope show:)
		(counterWtRope show:)
		(crashDummy hide:)
		(counterWeight show:)
		(|= local80 $0002)
		(= puzzleStatus 0)
		(gSystemWindow eraseOnly: 1)
		(if (& state $0008)
			(gCMusic fade: 0 10 10 1)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
		(|= state $0020)
		(if (and window (IsObject window))
			(window open:)
		)
		(= thisPort (GetPort))
		(= temp0 30)
		(= temp1 30)
		(for ((= temp2 (FirstNode elements))) temp2 ((= temp2 temp3))
			(= temp3 (NextNode temp2))
			(if (not (IsObject (= temp4 (NodeValue temp2))))
				(return)
			)
			(if (and (not (& (temp4 signal:) $0080)) (<= (temp4 nsRight:) 0))
				(temp4 show: temp0 temp1)
				(= temp0 (+ 20 (temp4 nsRight:)))
			else
				(temp4 show:)
			)
		)
		(local69 select:)
		(local70 select:)
		(cond
			((not curIcon) 0)
			((HaveMouse)
				(gGame setCursor: gTheCursor 1)
			)
			(else
				(gGame
					setCursor:
						gTheCursor
						1
						(+
							(curIcon nsLeft:)
							(/ (- (curIcon nsRight:) (curIcon nsLeft:)) 2)
						)
						(- (curIcon nsBottom:) 3)
				)
			)
		)
		(localproc_7)
		(gGame setCursor: local81 1)
		(if (not (& shown (<< $0001 global114)))
			(self showHelp: 0)
			(|= shown (<< $0001 global114))
		)
		(if puzzleCast
			(puzzleCast eachElementDo: #show)
		)
		(self doit: hide:)
		(gSystemWindow eraseOnly: 0)
		(if (& state $0008)
			(gCMusic play: setVol: 0 fade: 127 10 10 0)
		)
		(elevatorCast release:)
		(return puzzleStatus)
	)

	(method (hide)
		(elevatorCast eachElementDo: #hide)
		(Animate (elevatorCast elements:) 0)
		(localproc_6 0)
		(super hide: &rest)
	)

	(method (animateOnce)
		(cond
			(local0
				(Animate (elevatorCast elements:) 0)
				(= local0 0)
			)
			((& local80 $0002)
				(&= local80 $fffd)
				(Animate (elevatorCast elements:) 0)
			)
			((not (& local80 $0001))
				(Animate (elevatorCast elements:) 1)
				(if gDoMotionCue
					(= gDoMotionCue 0)
					(elevatorCast eachElementDo: #motionCue)
				)
			)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (& (event type:) $0040) ; direction
			(if (IsObject highlightedIcon)
				(= temp2 (self indexOf: highlightedIcon))
				(switch (event message:)
					(JOY_DOWN
						(cond
							((<= temp2 4)
								(= temp2 6)
							)
							((== temp2 6)
								(while (& ((self at: (++ temp2)) signal:) $0004)
								)
							)
							((<= temp2 11)
								(= temp2 13)
							)
							((< temp2 (- size 3))
								(= temp2 (- size 2))
							)
							(else
								(for
									((= temp2 0))
									(& ((self at: temp2) signal:) $0004)
									((++ temp2))
								)
							)
						)
					)
					(JOY_UP
						(cond
							((<= temp2 4)
								(= temp2 (- size 2))
							)
							((== temp2 6)
								(-- temp2)
								(while (& ((self at: (-- temp2)) signal:) $0004)
								)
							)
							((<= temp2 11)
								(= temp2 6)
							)
							((< temp2 (- size 3))
								(for
									((= temp2 11))
									(& ((self at: temp2) signal:) $0004)
									((-- temp2))
								)
							)
							(else
								(= temp2 13)
							)
						)
					)
					(JOY_RIGHT
						(cond
							((< temp2 4)
								(while (& ((self at: (++ temp2)) signal:) $0004)
									(if (== temp2 4)
										(= temp2 6)
										(break)
									)
								)
							)
							((== temp2 4)
								(= temp2 6)
							)
							((< temp2 11)
								(while (& ((self at: (++ temp2)) signal:) $0004)
									(if (== temp2 11)
										(= temp2 13)
										(break)
									)
								)
							)
							((== temp2 11)
								(= temp2 13)
							)
							((< temp2 (- size 3))
								(if (> (++ temp2) 14)
									(= temp2 (- size 2))
								)
							)
							((>= (++ temp2) size)
								(= temp2 (- size 3))
							)
						)
					)
					(JOY_LEFT
						(cond
							((not temp2)
								(= temp2 (- size 2))
							)
							((<= temp2 4)
								(while (& ((self at: (-- temp2)) signal:) $0004)
									(if (== temp2 0)
										(= temp2 (- size 2))
										(break)
									)
								)
							)
							((== temp2 6)
								(-- temp2)
								(while (& ((self at: (-- temp2)) signal:) $0004)
								)
							)
							((<= temp2 11)
								(while (& ((self at: (-- temp2)) signal:) $0004)
								)
							)
							((== temp2 13)
								(-- temp2)
								(while (& ((self at: (-- temp2)) signal:) $0004)
								)
							)
							((< temp2 (- size 3))
								(-- temp2)
							)
							((< (-- temp2) (- size 3))
								(= temp2 (- size 1))
							)
						)
					)
				)
			else
				(for
					((= temp2 0))
					(& ((self at: temp2) signal:) $0004)
					((++ temp2))
				)
			)
			(= temp0 (self at: temp2))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(super dispatchEvent: event &rest)
	)

	(method (showHelp)
		(= local0 1)
		(super showHelp: &rest)
	)

	(method (solvePuzzle &tmp temp0)
		(gCSoundFX number: 106 setVol: 0 play: 127)
		(Wait 0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(local69 textColor: 28 show:)
			(local70 textColor: 28 show:)
			(Wait 20)
			(local69 textColor: 51 show:)
			(local70 textColor: 51 show:)
			(Wait 20)
		)
		(local69 textColor: 28 show:)
		(local70 textColor: 28 show:)
		(Wait 20)
		(super solvePuzzle: &rest)
		(self goAway:)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3)
		(= local0 1)
		(if (IsFlag hintFlag)
			(if (== local79 1)
				(= local79 0)
				(= local85 1)
			else
				(++ local79)
			)
			(if (not local85)
				(ClearFlag hintFlag)
			)
		)
		(if (super buyClue: &rest)
			(switch global114
				(0
					(= temp2 21)
				)
				(1
					(= temp2 22)
				)
				(2
					(= temp2 23)
				)
			)
			(cond
				((or (== global114 0) (== global114 1))
					(if (= temp1 (Message msgSIZE msgModule 13 temp2 0 1))
						(= temp0 (Memory memALLOC_CRIT temp1))
						(Message msgGET msgModule 13 temp2 0 1 temp0)
						(= temp3 (localproc_2 local73 local74))
						(proc15_4
							self
							99
							temp0
							local73
							local74
							(/ temp3 100)
							(mod temp3 100)
							local73
							local74
							(/ temp3 100)
							(mod temp3 100)
							[local75 1]
							[local75 0]
							[local77 local79]
						)
						(if temp0
							(Memory memFREE temp0)
						)
					)
				)
				(
					(and
						(== global114 2)
						(= temp1 (Message msgSIZE msgModule 13 temp2 0 1))
					)
					(= temp0 (Memory memALLOC_CRIT temp1))
					(Message msgGET msgModule 13 temp2 0 1 temp0)
					(= temp3 (localproc_2 (- local73 local74) 25))
					(proc15_4
						self
						99
						temp0
						local73
						local74
						(- local73 local74)
						local73
						local74
						(- local73 local74)
						(/ temp3 100)
						(mod temp3 100)
						(- local73 local74)
						25
						(/ temp3 100)
						(mod temp3 100)
						[local75 1]
						[local75 0]
						[local77 local79]
					)
					(if temp0
						(Memory memFREE temp0)
					)
				)
			)
		)
	)

	(method (dispose)
		(chainClank dispose:)
		(elevatorCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(DisposeScript 969)
		(super dispose: &rest)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 1
		left 47
		bottom 190
		right 281
		back 135
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 292 0 0 1 21 -1)
		(DrawCel 293 0 0 140 21 -1)
		(Animate (elevatorCast elements:) 0)
	)
)

(instance gearChoices of TextIcon
	(properties
		view 293
		cursor 0
		maskView 293
		maskCel 4
		textColor 51
	)

	(method (highlight param1)
		(if param1
			(PicNotValid 1)
			(if (< (self value:) 5)
				(DrawCel 292 9 5 50 36 -1)
				(Graph grREDRAW_BOX 36 50 48 62)
			else
				(DrawCel 292 9 3 80 37 -1)
				(Graph grREDRAW_BOX 37 80 46 89)
			)
			(PicNotValid 0)
		else
			(PicNotValid 1)
			(if (< (self value:) 5)
				(DrawCel 292 9 4 50 36 -1)
				(Graph grREDRAW_BOX 36 50 48 62)
			else
				(DrawCel 292 9 2 80 37 -1)
				(Graph grREDRAW_BOX 37 80 46 89)
			)
			(PicNotValid 0)
		)
		(super highlight: param1 &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super select: &rest)
			(if (< (self value:) 5)
				(= temp5 (* 2 (mod (local69 value:) 5)))
				(= temp3
					(-
						(if (/ (local69 value:) 5) 186 else 87)
						[local53 (+ temp5 1)]
					)
				)
				(= temp2 (- 188 [local53 temp5]))
				(= temp4 local69)
				(= local69 self)
			else
				(= temp5 (* 2 (mod (local70 value:) 5)))
				(= temp3
					(-
						(if (/ (local70 value:) 5) 186 else 87)
						[local53 (+ temp5 1)]
					)
				)
				(= temp2 (- 188 [local53 temp5]))
				(= temp4 local70)
				(= local70 self)
			)
			(= temp5 (* 2 (mod value 5)))
			(= temp1 (- (if (/ value 5) 186 else 87) [local53 (+ temp5 1)]))
			(= temp0 (- 188 [local53 temp5]))
			(DrawCel 293 9 (mod (temp4 value:) 5) temp2 temp3 -1)
			(temp4 show:)
			(DrawCel 293 8 (mod value 5) temp0 temp1 -1)
			(self show:)
			([local71 cursor] cel: (mod value 5) show:)
		)
	)

	(method (showText &tmp [temp0 4] temp4 temp5 temp6 temp7)
		(= temp4 [local31 (self value:)])
		(= temp5 (- [local41 (self value:)] 1))
		(= temp6 (+ [local31 (self value:)] 17))
		(= temp7 (+ [local41 (self value:)] 8))
		(if (& signal $0004)
			(self text: {})
			(Graph grFILL_BOX temp5 temp4 temp7 temp6 1 167 -1 -1)
			(Graph grUPDATE_BOX temp5 temp4 temp7 temp6 1)
		else
			(self text: (Format @temp0 {%2d} [local21 (self value:)]))
			(Graph grFILL_BOX temp5 temp4 temp7 temp6 1 78 -1 -1)
			(Graph grUPDATE_BOX temp5 temp4 temp7 temp6 1)
			(proc5_8
				text
				textColor
				[local31 (self value:)]
				[local41 (self value:)]
				-1
				999
			)
		)
	)
)

(instance levers of IconI
	(properties
		view 293
		loop 7
		cel 0
		signal 129
	)

	(method (onMe)
		(return 0)
	)
)

(instance downArrow of CodeIcon
	(properties
		view 293
		loop 6
		nsLeft 172
		nsTop 91
	)

	(method (highlight param1)
		(if param1
			(PicNotValid 1)
			(DrawCel 292 9 1 71 100 -1)
			(Graph grREDRAW_BOX 100 71 108 79)
			(PicNotValid 0)
		else
			(PicNotValid 1)
			(DrawCel 292 9 0 71 100 -1)
			(Graph grREDRAW_BOX 100 71 108 79)
			(PicNotValid 0)
		)
		(super highlight: param1 &rest)
	)

	(method (show &tmp [temp0 6])
		(localproc_4 (Format @temp0 {%4d} local74) 180 148 108 -1 999)
		(localproc_4 (Format @temp0 {%4d} local73) 180 207 108 -1 999)
		(super show: &rest)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(if (super select: &rest)
			(= temp0 [local21 (local69 value:)])
			(= temp1 [local21 (local70 value:)])
			(= temp2 (localproc_2 temp1 temp0))
			(= temp3 (localproc_2 [local75 1] [local75 0]))
			(cond
				((<= -2 (- temp2 temp3) 2)
					(gearsPuzzle setScript: correctElevator)
				)
				((< (- temp2 temp3) -2)
					(gearsPuzzle setScript: upElevator)
				)
				((> (- temp2 temp3) 2)
					(gearsPuzzle setScript: downElevator)
				)
			)
		)
	)
)

(instance inputGearIcon of IconI
	(properties
		view 292
		loop 9
		cel 5
		nsLeft 50
		nsTop 36
		nsRight 62
		nsBottom 48
		signal 129
		noun 26
	)

	(method (highlight))

	(method (show))

	(method (select)
		(gMessager say: noun 1) ; "This is the input gear which the robot rat will pedal."
		(= local0 1)
	)
)

(instance outputGearIcon of IconI
	(properties
		view 292
		loop 9
		cel 3
		nsLeft 80
		nsTop 37
		nsRight 89
		nsBottom 46
		signal 129
		noun 27
	)

	(method (highlight))

	(method (show))

	(method (select)
		(gMessager say: noun 1) ; "This is the output gear which will drive the counterweight up and down."
		(= local0 1)
	)
)

(instance rat of Prop
	(properties
		x 37
		y 63
		view 292
		loop 4
		priority 15
		signal 2066
	)
)

(instance ratWheel of Prop
	(properties
		x 15
		y 75
		z 50
		view 292
		loop 3
		priority 15
		signal 2066
	)
)

(instance elevatorRope of Prop
	(properties
		x 101
		y 49
		view 292
		loop 11
		priority 15
		signal 2066
	)
)

(instance counterWtRope of Prop
	(properties
		x 134
		y 45
		view 292
		loop 13
		priority 15
		signal 2066
	)
)

(instance chain of Prop
	(properties
		x 110
		y 43
		view 292
		loop 14
		priority 15
		signal 2066
	)
)

(instance miniWheel of Prop
	(properties
		x 101
		y 41
		view 292
		loop 10
		priority 15
		signal 2066
	)
)

(instance elevator of Actor
	(properties
		x 86
		y 78
		view 292
		loop 1
		priority 15
		signal 2066
		moveSpeed 4
	)

	(method (doit)
		(cond
			((and (< (self y:) [local63 0]) (!= (self loop:) 11))
				(elevatorRope loop: 11)
			)
			(
				(and
					(> (self y:) [local63 0])
					(< (self y:) [local63 1])
					(!= (self loop:) 12)
				)
				(elevatorRope loop: 12)
			)
			((and (> (self y:) [local63 1]) (!= (self loop:) 13))
				(elevatorRope loop: 13)
			)
		)
		(super doit: &rest)
	)
)

(instance counterWeight of Actor
	(properties
		x 126
		y 121
		view 292
		loop 2
		priority 15
		signal 2066
		moveSpeed 4
	)

	(method (doit)
		(cond
			((and (< (self y:) [local65 0]) (!= (self loop:) 11))
				(counterWtRope loop: 11)
			)
			(
				(and
					(> (self y:) [local65 0])
					(< (self y:) [local65 1])
					(!= (self loop:) 12)
				)
				(counterWtRope loop: 12)
			)
			((and (> (self y:) [local65 1]) (!= (self loop:) 13))
				(counterWtRope loop: 13)
			)
		)
		(super doit: &rest)
	)
)

(instance crashDummy of Actor
	(properties
		x 101
		y 123
		view 292
		loop 8
		priority 15
		signal 2066
		cycleSpeed 4
		moveSpeed 4
	)

	(method (cue)
		(self setScript: boinkTheDummy)
	)
)

(instance elevatorCast of Set
	(properties)
)

(instance upElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 149 188 189 190)
				(gearsPuzzle pHandsOff: 1)
				(= local81 (gGame setCursor: 996))
				(&= local80 $fffe)
				(gCSoundFX number: 189 setLoop: 0 play: 127)
				(crashDummy cycleSpeed: 9 loop: 15 setCycle: End self show:)
			)
			(1
				(crashDummy loop: 8)
				(elevatorRope y: (+ (elevatorRope y:) 6))
				(localproc_6 1)
				(ratWheel cycleSpeed: 6 setCycle: Fwd show:)
				(rat cycleSpeed: 6 loop: 4 setCycle: Fwd show:)
				(chainClank number: 188 setLoop: -1 play: 127)
				(chain cycleSpeed: 6 setCycle: Fwd show:)
				(miniWheel cycleSpeed: 6 setCycle: Rev show:)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(2
				(ratWheel cycleSpeed: 9)
				(rat cycleSpeed: 9 loop: 5)
				(chain cycleSpeed: 9)
				(miniWheel cycleSpeed: 9)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(3
				(ratWheel cycleSpeed: 1 setCycle: Rev)
				(rat cycleSpeed: 1 loop: 6 setCycle: Rev)
				(chain cycleSpeed: 3 setCycle: Rev)
				(miniWheel cycleSpeed: 3 setCycle: Fwd)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(4
				(gCSoundFX number: 190 setLoop: 0)
				(crashDummy
					cycleSpeed: 4
					loop: 8
					yStep: 2
					setMotion: MoveTo (crashDummy x:) 102
					setCycle: End crashDummy
				)
				(elevator yStep: 2 setMotion: MoveTo (elevator x:) 57 self)
				(elevatorRope loop: 11 setCycle: Fwd)
				(counterWtRope loop: 13 setCycle: Fwd)
				(counterWeight
					yStep: 2
					setMotion: MoveTo (counterWeight x:) 156
				)
			)
			(5
				(if (counterWeight mover:)
					(counterWeight setMotion: 0)
				)
				(elevatorRope setCycle: 0)
				(counterWtRope setCycle: 0)
				(ShakeScreen 6 ssUPDOWN)
				(gCSoundFX number: 149 setLoop: 0 play: 127)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(6
				(rat cycleSpeed: 9)
				(ratWheel cycleSpeed: 9)
				(chain cycleSpeed: 9)
				(miniWheel cycleSpeed: 9)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 1))
			)
			(7
				(rat setCycle: Beg self)
			)
			(8
				(chainClank stop:)
				(ratWheel setCycle: 0)
				(rat loop: 5 cel: 0 setCycle: 0)
				(chain setCycle: 0)
				(miniWheel setCycle: 0)
				(localproc_5)
				(gearsPuzzle puzzleStatus: 2)
				(gearsPuzzle goAway:)
				(localproc_0)
				(gearsPuzzle pHandsOff: 0)
				(gGame setCursor: local81)
				(self dispose:)
			)
		)
	)
)

(instance correctElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 188 189)
				(gearsPuzzle pHandsOff: 1)
				(= local81 (gGame setCursor: 996))
				(&= local80 $fffe)
				(gCSoundFX number: 189 setLoop: 0 play: 127)
				(crashDummy cycleSpeed: 9 loop: 15 setCycle: End self show:)
			)
			(1
				(crashDummy loop: 8)
				(elevatorRope y: (+ (elevatorRope y:) 6))
				(localproc_6 1)
				(ratWheel cycleSpeed: 6 setCycle: Fwd show:)
				(rat cycleSpeed: 6 loop: 4 setCycle: Fwd show:)
				(chainClank number: 188 setLoop: -1 play: 127)
				(chain cycleSpeed: 6 setCycle: Fwd show:)
				(miniWheel cycleSpeed: 6 setCycle: Rev show:)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(2
				(rat cycleSpeed: 4)
				(ratWheel cycleSpeed: 4)
				(chain cycleSpeed: 4)
				(miniWheel cycleSpeed: 4)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 1))
			)
			(3
				(crashDummy
					loop: 8
					yStep: 2
					setMotion: MoveTo (crashDummy x:) 181
				)
				(elevator yStep: 2 setMotion: MoveTo (elevator x:) 136 self)
				(elevatorRope loop: 11 setCycle: Fwd)
				(counterWtRope loop: 13 setCycle: Fwd)
				(counterWeight yStep: 2 setMotion: MoveTo (counterWeight x:) 58)
			)
			(4
				(if (counterWeight mover:)
					(counterWeight setMotion: 0)
				)
				(elevatorRope setCycle: 0)
				(counterWtRope setCycle: 0)
				(chainClank stop:)
				(ratWheel setCycle: 0)
				(rat setCycle: 0)
				(chain setCycle: 0)
				(miniWheel setCycle: 0)
				(gearsPuzzle solvePuzzle:)
				(gearsPuzzle pHandsOff: 0)
				(gGame setCursor: local81)
				(self dispose:)
			)
		)
	)
)

(instance downElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(LoadMany rsSOUND 149 188 189 191)
				(gearsPuzzle pHandsOff: 1)
				(= local81 (gGame setCursor: 996))
				(&= local80 $fffe)
				(gCSoundFX number: 189 setLoop: 0 play: 127)
				(crashDummy cycleSpeed: 9 loop: 15 setCycle: End self show:)
			)
			(1
				(crashDummy loop: 8)
				(elevatorRope y: (+ (elevatorRope y:) 6))
				(localproc_6 1)
				(ratWheel cycleSpeed: 6 setCycle: Fwd show:)
				(rat cycleSpeed: 6 loop: 4 setCycle: Fwd show:)
				(chainClank number: 188 setLoop: -1 play: 127)
				(chain cycleSpeed: 6 setCycle: Fwd show:)
				(miniWheel cycleSpeed: 6 setCycle: Rev show:)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(2
				(ratWheel cycleSpeed: 5)
				(rat cycleSpeed: 5 loop: 5)
				(chain cycleSpeed: 5)
				(miniWheel cycleSpeed: 5)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(3
				(ratWheel cycleSpeed: 1)
				(rat cycleSpeed: 1 loop: 6)
				(chain cycleSpeed: 3)
				(miniWheel cycleSpeed: 3)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 2))
			)
			(4
				(gCSoundFX number: 191 setLoop: 0)
				(crashDummy
					cycleSpeed: 4
					loop: 7
					cel: 0
					yStep: 4
					setMotion: MoveTo (crashDummy x:) 181
					setScript: kickDummyFeet
				)
				(elevator yStep: 4 setMotion: MoveTo (elevator x:) 136 self)
				(elevatorRope loop: 11 setCycle: Fwd)
				(counterWtRope loop: 13 setCycle: Fwd)
				(counterWeight yStep: 4 setMotion: MoveTo (counterWeight x:) 58)
			)
			(5
				(if (counterWeight mover:)
					(counterWeight setMotion: 0)
				)
				(elevatorRope setCycle: 0)
				(counterWtRope setCycle: 0)
				(rat cycleSpeed: 9)
				(ratWheel cycleSpeed: 9)
				(chain cycleSpeed: 9)
				(miniWheel cycleSpeed: 9)
				(ShakeScreen 6 ssUPDOWN)
				(gCSoundFX number: 149 setLoop: 0 play: 127)
				(= ticks (* (rat cycleSpeed:) (NumCels rat) 1))
			)
			(6
				(rat setCycle: End self)
			)
			(7
				(chainClank stop:)
				(ratWheel setCycle: 0)
				(rat loop: 5 cel: 0 setCycle: 0)
				(chain setCycle: 0)
				(miniWheel setCycle: 0)
				(localproc_5)
				(gearsPuzzle puzzleStatus: 2)
				(gearsPuzzle goAway:)
				(localproc_0)
				(gearsPuzzle pHandsOff: 0)
				(gGame setCursor: local81)
				(self dispose:)
			)
		)
	)
)

(instance kickDummyFeet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(crashDummy cycleSpeed: 4 loop: 7 cel: 0 setCycle: CT 10 1 self)
			)
			(1
				(self setScript: boinkTheDummy)
				(crashDummy setCycle: End self)
			)
			(2
				(crashDummy cel: 11 setCycle: CT 14 1 self)
			)
			(3
				(crashDummy cel: 11 setCycle: CT 14 1 self)
			)
			(4
				(crashDummy cel: 11 setCycle: CT 14 1 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance boinkTheDummy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX setLoop: 0 play: 127 self)
			)
			(1
				(chainClank play: 127)
			)
		)
	)
)

(instance chainClank of Sound
	(properties
		loop -1
	)
)

