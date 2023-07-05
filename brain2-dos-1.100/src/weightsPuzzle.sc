;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 293)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use IconBar)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	weightsPuzzle 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6 = 1
	local7
	local8
	[local9 3] = [116 131 138]
	[local12 3] = [28 77 126]
	[local15 3] = [{gallon} {quart} {cup}]
	[local18 3] = [26 71 116]
	[local21 3] = [70 115 160]
	[local24 3] = [39 96 151]
	[local27 3] = [{left} {center} {right}]
	[local30 3] = [36 100 163]
	[local33 3] = [1 65 129]
	[local36 3] = [31 89 143]
	[local39 3] = [44 102 156]
	[local42 3] = [8 73 138]
	[local45 3] = [20 85 150]
	[local48 3] = [80 91 94]
	[local51 3]
	[local54 9]
	[local63 9]
	[local72 3]
	[local75 3]
	[local78 3] = [{00000} {00001} {00002}]
	[local81 9] = [701 8 6 0 0 0 0 0 0]
	[local90 3]
	local93
	local94
	local95
)

(procedure (localproc_0)
	(gGame setCursor: local1)
	(cupCursor hide:)
	(if (not (& local7 $0020))
		(Animate (cupCast elements:) 1)
	)
	(|= local7 $0008)
)

(procedure (localproc_1 param1)
	(if (== argc 0)
		(gGame setCursor: 996)
	else
		(gGame setCursor: 996 1 (+ [local12 param1] 17) [local9 param1])
		(weightsPuzzle eventX: (+ [local12 param1] 17) eventY: [local9 param1])
	)
	(cupCursor show:)
	(&= local7 $fff7)
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
	(if param1
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(= [local75 temp1] 0)
			(for ((= temp2 0)) (< temp2 3) ((++ temp2))
				(= temp3 (+ temp1 (* temp2 3)))
				(= temp4 (/ [local81 temp2] 100))
				(= temp5 (mod [local81 temp2] 100))
				(= temp6
					(+
						(= temp6
							(*
								(= temp6
									(+
										(= temp6 (* temp4 [local63 temp3]))
										(/ (* temp5 [local63 temp3]) 16)
									)
								)
								100
							)
						)
						(mod (* temp5 [local63 temp3]) 16)
					)
				)
				(= [local75 temp1] (localproc_3 1 [local75 temp1] temp6))
			)
		)
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(Format [local78 temp1] {%5d} [local75 temp1])
		)
	else
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(= [local72 temp1] 0)
			(for ((= temp2 0)) (< temp2 3) ((++ temp2))
				(= temp3 (+ temp1 (* temp2 3)))
				(= temp4 (/ [local81 temp2] 100))
				(= temp5 (mod [local81 temp2] 100))
				(= temp6
					(+
						(= temp6
							(*
								(= temp6
									(+
										(= temp6 (* temp4 [local54 temp3]))
										(/ (* temp5 [local54 temp3]) 16)
									)
								)
								100
							)
						)
						(mod (* temp5 [local54 temp3]) 16)
					)
				)
				(= [local72 temp1] (localproc_3 1 [local72 temp1] temp6))
			)
		)
		(if (== global114 2)
			(cond
				((> [local72 0] [local72 2])
					(= temp8 (localproc_3 0 [local72 0] [local72 2]))
					(cond
						((> 3000 temp8 1500)
							(= local8 (& (|= local8 $0004) $ffef))
						)
						((> temp8 3000)
							(= local8 (& (|= local8 $0008) $fffb))
						)
						(else
							(&= local8 $ffeb)
						)
					)
				)
				((> [local72 2] [local72 0])
					(= temp8 (localproc_3 0 [local72 2] [local72 0]))
					(cond
						((> 3000 temp8 1500)
							(= local8 (& (|= local8 $0010) $fffb))
						)
						((> temp8 3000)
							(= local8 (& (|= local8 $0020) $ffef))
						)
						(else
							(&= local8 $ffeb)
						)
					)
				)
				(else
					(&= local8 $ffeb)
				)
			)
			(Animate (cupCast elements:) 0)
		)
		(= temp7 1)
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(cond
				((!= [local72 temp1] [local75 temp1])
					(= temp7 0)
				)
				((!= global114 2)
					(switch temp1
						(0
							(|= local8 $0080)
							(= temp0 (weightWinCast at: 0))
							(temp0
								textColor: 52
								signal: (| (temp0 signal:) $0004)
							)
						)
						(1
							(|= local8 $0100)
							(= temp0 (weightWinCast at: 1))
							(temp0
								textColor: 52
								signal: (| (temp0 signal:) $0004)
							)
						)
						(2
							(|= local8 $0200)
							(= temp0 (weightWinCast at: 2))
							(temp0
								textColor: 52
								signal: (| (temp0 signal:) $0004)
							)
						)
					)
				)
			)
		)
		(if temp7
			(|= local8 $0001)
		)
		(for ((= temp1 0)) (< temp1 3) ((++ temp1))
			(if (< (= temp6 (localproc_3 0 [local75 temp1] [local72 temp1])) 0)
				(Format [local78 temp1] {%5d} -1)
				(|= local8 $0002)
			else
				(Format [local78 temp1] {%5d} temp6)
			)
		)
	)
)

(procedure (localproc_3 param1 param2 param3 &tmp temp0 temp1)
	(cond
		(param1
			(= temp0 (+ (/ param2 100) (/ param3 100)))
			(if (!= (mod param3 100) 0)
				(= temp1 (+ (mod param2 100) (mod param3 100)))
				(+= temp0 (/ temp1 16))
				(= temp1 (mod temp1 16))
			else
				(= temp1 (mod param2 100))
			)
		)
		((< param3 param2)
			(= temp0 (- (/ param2 100) (/ param3 100)))
			(if (< (= temp1 (- (mod param2 100) (mod param3 100))) 0)
				(-- temp0)
				(+= temp1 16)
			)
		)
		(else
			(= temp0 (- (/ param3 100) (/ param2 100)))
			(if (< (= temp1 (- (mod param3 100) (mod param2 100))) 0)
				(-- temp0)
				(+= temp1 16)
			)
			(= temp0 (- 0 temp0))
			(= temp1 (- 0 temp1))
		)
	)
	(return (+ (* temp0 100) temp1))
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(if param1
		(= local8 (<< (= temp3 (>> local8 $0007)) $0007))
	else
		(= local8 0)
		(= temp6 local5)
		(= local5 1)
		(ClearFlag 20)
	)
	(funnel cel: 3)
	(= local7 0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(= [local72 temp0] 0)
		(= [local75 temp0] 0)
	)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(= [local51 temp0] 0)
	)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(= [local63 temp0] 0)
		(= [local54 temp0] 0)
	)
	(switch global114
		(0
			(if (not (& local8 $0100))
				(= [local63 1] (+ (Random 1 15) 5))
			)
			(if (not (& local8 $0080))
				(= [local63 3] (+ (Random 1 20) 5))
			)
			(if (not (& local8 $0200))
				(= [local63 8] (+ (Random 1 25) 5))
			)
			(localproc_2 1)
		)
		(1
			(if
				(and
					(not (& local8 $0080))
					(not (& local8 $0100))
					(not (& local8 $0200))
				)
				(for ((= temp1 0)) (< temp1 3) ((++ temp1))
					(= [local90 temp1] -1)
				)
				(for ((= temp1 0)) (< temp1 3) ((++ temp1))
					(repeat
						(= temp3 (Random 0 2))
						(for ((= temp2 0)) (< temp2 3) ((++ temp2))
							(if (== [local90 temp2] temp3)
								(break)
							)
						)
						(if (== temp2 3)
							(switch temp3
								(0
									(if (& local8 $0080)
										(break)
									)
								)
								(1
									(if (& local8 $0100)
										(break)
									)
								)
								(2
									(if (& local8 $0200)
										(break)
									)
								)
							)
							(= [local90 temp1] temp3)
							(break)
						)
					)
				)
			else
				(for ((= temp1 0)) (< temp1 3) ((++ temp1))
					(switch [local90 temp1]
						(0
							(if (& local8 $0080)
								(= [local90 temp1] -1)
							)
						)
						(1
							(if (& local8 $0100)
								(= [local90 temp1] -1)
							)
						)
						(2
							(if (& local8 $0200)
								(= [local90 temp1] -1)
							)
						)
					)
				)
			)
			(if (!= [local90 1] -1)
				(= [local63 [local90 1]] (Random 1 15))
			)
			(if (!= [local90 0] -1)
				(= [local63 (+ [local90 0] 3)] (Random 1 20))
			)
			(if (!= [local90 2] -1)
				(= [local63 (+ [local90 2] 6)] (Random 1 25))
			)
			(localproc_2 1)
		)
		(2
			(= temp5 0)
			(while (== temp5 0)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (!= temp0 1)
						(= [local63 temp0] (Random 1 15))
					)
					(if (!= temp0 0)
						(= [local63 (+ temp0 3)] (Random 1 20))
					)
					(if (!= temp0 2)
						(= [local63 (+ temp0 6)] (Random 1 25))
					)
				)
				(localproc_2 1)
				(if (< (Abs (- [local75 0] [local75 2])) 1500)
					(= temp5 1)
				)
			)
		)
	)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (== global114 2)
			(+=
				[local51 1]
				(+ (/ [local63 temp0] 4) (mod (mod [local63 temp0] 4) 4))
			)
		else
			(+=
				[local51 1]
				(+
					(/ [local63 temp0] 16)
					(/ (mod [local63 temp0] 16) 4)
					(mod (mod [local63 temp0] 16) 4)
				)
			)
		)
		(+=
			[local51 0]
			(+
				(/ [local63 (+ temp0 3)] 16)
				(/ (mod [local63 (+ temp0 3)] 16) 4)
				(mod (mod [local63 (+ temp0 3)] 16) 4)
			)
		)
		(+=
			[local51 2]
			(+
				(/ [local63 (+ temp0 6)] 16)
				(/ (mod [local63 (+ temp0 6)] 16) 4)
				(mod (mod [local63 (+ temp0 6)] 16) 4)
			)
		)
	)
	(if param1
		(cupCursor hide:)
		(bucketTilting cel: 3)
		(Animate (cupCast elements:) 0)
		(localproc_0)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(= temp4 (cupSet at: temp0))
			(temp4
				state: (& (temp4 state:) $ffe0)
				signal: (& (temp4 signal:) $fffb)
				cel: 2
			)
		)
		(if (not param1)
			((weightWinCast at: temp6) cel: 0 lowlightColor: 4)
		)
		((weightWinCast at: local5) cel: 1 lowlightColor: 2)
		(weightsPuzzle eachElementDo: #show)
	)
)

(procedure (localproc_5 param1 param2 param3 param4 param5 param6 &tmp temp0)
	(if (>= argc 6)
		(= temp0 param6)
	else
		(= temp0 gUserFont)
	)
	(Display param1 dsCOORD param3 param4 dsCOLOR param2 dsALIGN alLEFT dsFONT temp0 &rest)
)

(procedure (localproc_6 &tmp temp0)
	(while ((= temp0 (Event new:)) type:)
		(temp0 dispose:)
	)
	(temp0 dispose:)
)

(instance weightsPuzzle of PuzzleBar
	(properties
		hintFlag 20
		solvedFlag 5
		noun 14
		msgModule 290
		personalID 18
	)

	(method (init &tmp temp0 temp1 temp2)
		(= local1 (gGame setCursor: gWaitCursor 1))
		(Load rsVIEW 290)
		(Load rsSOUND 106 144 145 184 185)
		(= local0 iconHeight)
		(= window weightsWindow)
		(= local93 (Random 0 2))
		(= local94 (Random 0 2))
		(localproc_4 0)
		(self add: tvMonitor)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self
				add:
					((spigot new:)
						name: [local27 temp0]
						nsLeft: [local36 temp0]
						nsRight: [local39 temp0]
						value: temp0
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self
				add:
					((fountain new:)
						name: [local27 temp0]
						nsLeft: [local18 temp0]
						nsRight: [local21 temp0]
						loop: (+ 12 temp0)
						cel: 2
						value: temp0
						yourself:
					)
			)
		)
		(self add: funnel)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self
				add:
					((= temp1 (container new:))
						name: [local15 temp0]
						nsLeft: [local12 temp0]
						nsTop: [local9 temp0]
						loop: (+ temp0 1)
						cel: 2
						value: temp0
					)
			)
			(cupSet add: temp1)
			(temp1 state: (& (temp1 state:) $fffe))
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self
				add:
					((= temp1 (weightWindow new:))
						name: [local27 temp0]
						nsLeft: [local33 temp0]
						value: temp0
						text: [local78 temp0]
						yourself:
					)
			)
			(weightWinCast add: temp1)
		)
		(self add: byline)
		((weightWinCast at: local5) cel: 1 lowlightColor: 2)
		(super init: &rest)
	)

	(method (show &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= local6 1)
		(cupCast
			add: liquidPouring cupCursor cupFilling bucketTilting bucketDumping
		)
		(liquidPouring hide:)
		(cupCursor hide:)
		(cupFilling hide:)
		(bucketTilting show:)
		(bucketDumping hide:)
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
		(localproc_6)
		(Animate (cupCast elements:) 0)
		(if (& local7 $0001)
			(= temp5 (Event new:))
			(gGame setCursor: 996)
			(cupCursor x: (temp5 x:) y: (- 3 (temp5 y:)) show:)
			(temp5 dispose:)
		else
			(gGame setCursor: local1 1)
		)
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
		(cupCast release:)
		(return puzzleStatus)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if (& (event type:) $0040) ; direction
			(if (or (IsObject highlightedIcon) (self firstTrue: #onMe event))
				(if (IsObject highlightedIcon)
					(= temp2 (self indexOf: highlightedIcon))
				else
					(= temp2 (self indexOf: (self firstTrue: #onMe event)))
				)
				(switch (event message:)
					(JOY_DOWN
						(cond
							((== temp2 0)
								(= temp2 2)
							)
							((<= temp2 3)
								(+= temp2 3)
							)
							((<= temp2 6)
								(= temp2 7)
							)
							((== temp2 7)
								(= temp2 8)
							)
							((<= temp2 10)
								(+= temp2 3)
								(if (& ((self at: temp2) signal:) $0004)
									(switch temp2
										(11
											(if
												(&
													((self at: 12) signal:)
													$0004
												)
												(= temp2 13)
											else
												(= temp2 12)
											)
										)
										(12
											(if
												(&
													((self at: 13) signal:)
													$0004
												)
												(= temp2 11)
											else
												(= temp2 13)
											)
										)
										(13
											(while
												(&
													((self at: (-- temp2))
														signal:
													)
													$0004
												)
											)
										)
									)
								)
							)
							((< temp2 (- size 3))
								(= temp2 (- size 2))
							)
							(else
								(= temp2 0)
							)
						)
					)
					(JOY_UP
						(cond
							((== temp2 0)
								(= temp2 (- size 2))
							)
							((<= temp2 3)
								(= temp2 0)
							)
							((<= temp2 6)
								(-= temp2 3)
							)
							((== temp2 7)
								(= temp2 6)
							)
							((<= temp2 10)
								(= temp2 7)
							)
							((< temp2 (- size 3))
								(-= temp2 3)
							)
							(else
								(for
									((-= temp2 4))
									(& ((self at: temp2) signal:) $0004)
									((-- temp2))
								)
							)
						)
					)
					(JOY_RIGHT
						(cond
							((<= temp2 9)
								(++ temp2)
							)
							((<= temp2 12)
								(while (& ((self at: (++ temp2)) signal:) $0004)
									(if (== temp2 13)
										(= temp2 (- size 3))
									)
								)
							)
							((== temp2 13)
								(= temp2 (- size 3))
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
							((<= temp2 11)
								(-- temp2)
							)
							((<= temp2 13)
								(while (& ((self at: (-- temp2)) signal:) $0004)
								)
							)
							((< (-- temp2) (- size 3))
								(= temp2 (- size 1))
							)
						)
					)
				)
			else
				(= temp2 0)
			)
			(= temp0 (self at: temp2))
			(cond
				((== temp2 7)
					(gGame
						setCursor:
							gTheCursor
							1
							(/ (+ (temp0 nsLeft:) (temp0 nsRight:)) 2)
							(- (temp0 nsBottom:) 15)
					)
				)
				((<= 8 temp2 10)
					(gGame
						setCursor:
							gTheCursor
							1
							(/ (+ (temp0 nsLeft:) (temp0 nsRight:)) 2)
							(temp0 nsTop:)
					)
				)
				(else
					(proc5_9 temp0)
				)
			)
			(event type: evNULL)
		)
		(if (& local7 $0010)
			(super dispatchEvent: event &rest)
			(return)
		)
		(if (not local1)
			(= local1 gTheCursor)
		)
		(cond
			((and (<= 0 eventX 190) (<= local0 eventY 161))
				(if (not (& local7 $0004))
					(|= local7 $0006)
				)
			)
			((& local7 $0004)
				(= local7 (& (|= local7 $0002) $fffb))
			)
		)
		(if (and (& local7 $0002) (& local7 $0001))
			(if (& local7 $0004)
				(localproc_1)
			else
				(localproc_0)
			)
		)
		(if (& local7 $0002)
			(&= local7 $fffd)
		)
		(super dispatchEvent: event &rest)
	)

	(method (animateOnce)
		(if local6
			(= local6 0)
			(Animate (cupCast elements:) 0)
		)
		(if (and (& local7 $0001) (not (& local7 $0008)))
			(Animate (cupCast elements:) 1)
			(if gDoMotionCue
				(= gDoMotionCue 0)
				(cupCast eachElementDo: #motionCue)
			)
		)
	)

	(method (solvePuzzle &tmp temp0 temp1)
		(gCSoundFX number: 106 setVol: 0 play: 127)
		((weightWinCast at: local5) cel: 0 show:)
		(Wait 0)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(weightWinCast eachElementDo: #textColor 37 eachElementDo: #show)
			(Wait 15)
			(weightWinCast eachElementDo: #textColor 35 eachElementDo: #show)
			(Wait 15)
		)
		(weightWinCast eachElementDo: #textColor 37 eachElementDo: #show)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(if (!= [local51 temp0] 0)
				(= temp1 1)
				(break)
			)
		)
		(if (== temp1 0)
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				(if (& ((cupSet at: temp0) state:) $0001)
					(= temp1 1)
				)
			)
		)
		(if temp1
			(proc15_0 self noun 27 15 0)
		)
		(gGame setCursor: local1)
		(weightsPuzzle pHandsOff: 0)
		(super solvePuzzle: &rest)
		(weightsPuzzle goAway:)
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(bucketTilting hide:)
		(bucketDumping hide:)
		(cupCursor hide:)
		(Animate (cupCast elements:) 0)
		(super hide: &rest)
	)

	(method (showHelp)
		(super showHelp: &rest)
		(Animate (cupCast elements:) 0)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 [temp12 7] temp19 temp20 temp21 temp22 temp23 temp24 temp25)
		(if (super buyClue: &rest)
			(= temp9 1)
			(for ((= temp6 0)) (< temp6 3) ((++ temp6))
				(= temp10 0)
				(for ((= temp7 0)) (< temp7 3) ((++ temp7))
					(cond
						(
							(<
								(= temp5
									(-
										[local63
											(= temp22 (+ (* temp6 3) temp7))
										]
										[local54 temp22]
									)
								)
								0
							)
							(= temp9 0)
						)
						((== temp5 0)
							(continue)
						)
					)
					(if (and (== global114 2) (== temp6 0))
						(+= temp10 (+ (/ temp5 4) (mod (mod temp5 4) 4)))
					else
						(+=
							temp10
							(+
								(/ temp5 16)
								(/ (mod temp5 16) 4)
								(mod (mod temp5 16) 4)
							)
						)
					)
					(= temp25 0)
					(switch temp6
						(0
							(for ((= temp8 0)) (< temp8 3) ((++ temp8))
								(if
									(and
										(& ((cupSet at: temp8) state:) $0001)
										(& ((cupSet at: temp8) state:) $0004)
									)
									(++ temp25)
								)
							)
							(cond
								((< (+ [local51 1] temp25) temp10)
									(= temp9 0)
									(break 2)
								)
								(temp25
									(for ((= temp8 0)) (< temp8 3) ((++ temp8))
										(if
											(and
												(&
													((cupSet at: temp8) state:)
													$0001
												)
												(&
													((cupSet at: temp8) state:)
													$0004
												)
											)
											(switch temp8
												(0
													(if (== (/ temp5 16) 0)
														(= temp9 0)
														(break 3)
													)
												)
												(1
													(if
														(==
															(/ (mod temp5 16) 4)
															0
														)
														(= temp9 0)
														(break 3)
													)
												)
												(2
													(if
														(==
															(mod
																(mod temp5 16)
																4
															)
															0
														)
														(= temp9 0)
														(break 3)
													)
												)
											)
										)
									)
								)
							)
						)
						(1
							(for ((= temp8 0)) (< temp8 3) ((++ temp8))
								(if
									(and
										(& ((cupSet at: temp8) state:) $0001)
										(& ((cupSet at: temp8) state:) $0008)
									)
									(++ temp25)
								)
							)
							(cond
								((< (+ [local51 0] temp25) temp10)
									(= temp9 0)
									(break 2)
								)
								(temp25
									(for ((= temp8 0)) (< temp8 3) ((++ temp8))
										(if
											(and
												(&
													((cupSet at: temp8) state:)
													$0001
												)
												(&
													((cupSet at: temp8) state:)
													$0008
												)
											)
											(switch temp8
												(0
													(if (== (/ temp5 16) 0)
														(= temp9 0)
														(break 3)
													)
												)
												(1
													(if
														(==
															(/ (mod temp5 16) 4)
															0
														)
														(= temp9 0)
														(break 3)
													)
												)
												(2
													(if
														(==
															(mod
																(mod temp5 16)
																4
															)
															0
														)
														(= temp9 0)
														(break 3)
													)
												)
											)
										)
									)
								)
							)
						)
						(2
							(for ((= temp8 0)) (< temp8 3) ((++ temp8))
								(if
									(and
										(& ((cupSet at: temp8) state:) $0001)
										(& ((cupSet at: temp8) state:) $0010)
									)
									(++ temp25)
								)
							)
							(cond
								((< (+ [local51 2] temp25) temp10)
									(= temp9 0)
									(break 2)
								)
								(temp25
									(for ((= temp8 0)) (< temp8 3) ((++ temp8))
										(if
											(and
												(&
													((cupSet at: temp8) state:)
													$0001
												)
												(&
													((cupSet at: temp8) state:)
													$0010
												)
											)
											(switch temp8
												(0
													(if (== (/ temp5 16) 0)
														(= temp9 0)
														(break 3)
													)
												)
												(1
													(if
														(==
															(/ (mod temp5 16) 4)
															0
														)
														(= temp9 0)
														(break 3)
													)
												)
												(2
													(if
														(==
															(mod
																(mod temp5 16)
																4
															)
															0
														)
														(= temp9 0)
														(break 3)
													)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(if (not temp9)
				(if (== global114 2)
					(Print
						x: 68
						first: 2
						addText: noun 9 14 0 ; "|c2|NOTE:|c| Dr. Brain's solution to this puzzle is different than the solution that you're currently working on. If you persist, your solution may still turn out. However, in order to give you Dr. Brain's solution, this puzzle will automatically reset. Would you like to try Dr. Brain's solution anyway?"
						addButton: 1 {Yes} 50 70
						addButton: 2 {No} 115 70
						init:
					)
					(if (or (== (Print retValue:) 2) (== (Print retValue:) 0))
						(Animate (cupCast elements:) 0)
						(return)
					)
				else
					(proc15_0 self noun 9 5 0)
				)
				(Animate (cupCast elements:) 0)
				(localproc_4 1)
				(Wait 0)
				(Wait 120)
			)
			(switch global114
				(0
					(repeat
						(switch local93
							(0
								(if (not (& local8 $0080))
									(= temp4 3)
									(= temp11 {water})
									(break)
								)
							)
							(1
								(if (not (& local8 $0100))
									(= temp4 1)
									(= temp11 {mercury})
									(break)
								)
							)
							(2
								(if (not (& local8 $0200))
									(= temp4 8)
									(= temp11 {alcohol})
									(break)
								)
							)
						)
						(= local93 (Random 0 2))
					)
					(= temp3 local93)
					(= temp19 (/ [local63 temp4] 16))
					(= temp20 (/ (mod [local63 temp4] 16) 4))
					(= temp21 (mod (mod [local63 temp4] 16) 4))
					(= temp1 (Message msgSIZE msgModule 14 21 0 1))
					(= temp0 (Memory memALLOC_CRIT temp1))
					(Message msgGET msgModule 14 21 0 1 temp0)
					(proc15_4
						self
						99
						temp0
						[local27 temp3]
						temp19
						temp20
						temp21
						temp11
					)
				)
				(1
					(repeat
						(switch local93
							(1
								(= temp24 [local90 1])
								(= temp23 0)
								(= temp11 {mercury})
							)
							(0
								(= temp24 [local90 0])
								(= temp23 1)
								(= temp11 {water})
							)
							(2
								(= temp24 [local90 2])
								(= temp23 2)
								(= temp11 {alcohol})
							)
						)
						(switch temp24
							(0
								(if (not (& local8 $0080))
									(break)
								)
							)
							(1
								(if (not (& local8 $0100))
									(break)
								)
							)
							(2
								(if (not (& local8 $0200))
									(break)
								)
							)
						)
						(= local93 (Random 0 2))
					)
					(= temp2 local93)
					(= temp4 (+ (* temp23 3) [local90 temp2]))
					(= temp1 (Message msgSIZE msgModule 14 22 0 1))
					(= temp0 (Memory memALLOC_CRIT temp1))
					(Message msgGET msgModule 14 22 0 1 temp0)
					(proc15_4
						self
						99
						temp0
						[local27 [local90 temp2]]
						[local63 temp4]
						temp11
					)
					(proc15_0 self 14 22 0 2)
				)
				(2
					(switch local93
						(1
							(= temp23 0)
							(= temp11 {mercury})
						)
						(0
							(= temp23 1)
							(= temp11 {water})
						)
						(2
							(= temp23 2)
							(= temp11 {alcohol})
						)
					)
					(repeat
						(switch local94
							(0
								(if
									(and
										(not (& local8 $0080))
										(not (== local93 0))
									)
									(break)
								)
							)
							(1
								(if
									(and
										(not (& local8 $0100))
										(not (== local93 1))
									)
									(break)
								)
							)
							(2
								(if
									(and
										(not (& local8 $0200))
										(not (== local93 1))
									)
									(break)
								)
							)
						)
						(= local94 (Random 0 2))
					)
					(= temp2 local93)
					(= temp4 (+ (* temp23 3) local94))
					(= temp1 (Message msgSIZE msgModule 14 22 0 1))
					(= temp0 (Memory memALLOC_CRIT temp1))
					(Message msgGET msgModule 14 22 0 1 temp0)
					(proc15_4
						self
						99
						temp0
						[local27 local94]
						[local63 temp4]
						temp11
					)
					(proc15_0 self 14 22 0 2)
				)
			)
			(Animate (cupCast elements:) 0)
			(if temp0
				(Memory memFREE temp0)
			)
		)
	)

	(method (dispose)
		(cupCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(cupSet release: dispose:)
		(weightWinCast release: dispose:)
		(super dispose: &rest)
	)
)

(instance weightsWindow of SysWindow
	(properties
		top 3
		left 70
		bottom 184
		right 260
		back 3
		priority 13
	)

	(method (open &tmp temp0)
		(super open:)
		(DrawCel 290 0 0 1 local0 -1)
	)
)

(instance container of CodeIcon
	(properties
		view 290
		maskView 290
	)

	(method (select param1 &tmp temp0 temp1)
		(if (& state $0002)
			(gCSoundFX number: 145 setLoop: 0 play:)
			(= local4 0)
			(&= local7 $fffe)
			(&= signal $fffb)
			(cupCursor setCel: 2)
			(localproc_0)
		else
			(if (& local7 $0001)
				(gCSoundFX number: 145 setLoop: 0 play:)
				(cupCursor hide:)
				(if (not (& local7 $0020))
					(Animate (cupCast elements:) 1)
				)
				(|= local7 $0008)
				(local4
					state: (& (local4 state:) $fffd)
					signal: (& (local4 signal:) $fffb)
					show: (if (& (local4 state:) $0001) 3 else 2)
				)
			)
			(= local4 self)
			(|= local7 $0001)
			(cupCursor
				setLoop: (self loop:)
				setLoop:
				setCel: (if (& (self state:) $0001) 3 else 2)
			)
			(localproc_1 (self value:))
			(gCSoundFX number: 144 setLoop: 0 play:)
		)
		(return
			(cond
				((& signal $0004) 0)
				((and argc param1 (& signal $0001))
					(self show: (= temp1 (if (& state $0001) 3 else 1)))
					(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
						(temp0 localize:)
						(if (and (self onMe: temp0) (not temp1))
							(self show: (= temp1 (if (& state $0001) 3 else 1)))
						)
						(temp0 dispose:)
					)
					(temp0 dispose:)
					(if (& state $0002)
						(self
							state: (& state $fffd)
							show: (if (& state $0001) 3 else 2)
						)
					else
						(if (IsObject gModelessDialog)
							(gModelessDialog dispose:)
						)
						(Animate (cupCast elements:) 1)
						(DrawCel 290 4 0 nsLeft 113 -1)
						(self state: (| state $0002) signal: (| signal $0004))
					)
					temp1
				)
				(else
					(if (& state $0002)
						(self
							state: (& state $fffd)
							show: (if (& state $0001) 3 else 2)
						)
					else
						(if (IsObject gModelessDialog)
							(gModelessDialog dispose:)
						)
						(Animate (cupCast elements:) 1)
						(DrawCel 290 4 0 nsLeft 113 -1)
						(self state: (| state $0002) signal: (| signal $0004))
					)
					1
				)
			)
		)
	)

	(method (show param1)
		(if argc
			(= cel param1)
		)
		(|= signal $0020)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(if (not (& signal $0004))
			(DrawCel view loop cel nsLeft nsTop -1)
		)
		(if (and gPMouse (gPMouse respondsTo: #stop))
			(gPMouse stop:)
		)
	)

	(method (highlight param1 &tmp temp0)
		(= temp0 (if argc param1))
		(cond
			((not (& signal $0020)) 0)
			((& signal $2000)
				(super highlight: temp0 &rest)
			)
			(temp0
				(self show: 0)
				(if (not (& local7 $0001))
					(Print
						modeless: 1
						font: 999
						x: (+ 72 (self nsLeft:))
						y: (- (+ 3 (self nsTop:)) 19)
						addTextF: {%s} (self name:)
						init:
					)
				)
			)
			(else
				(self show: (if (& state $0001) 3 else 2))
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
			)
		)
	)
)

(instance fountain of CodeIcon
	(properties
		view 290
		nsTop 83
		nsBottom 100
		noun 15
	)

	(method (highlight)
		(if
			(and
				(& local7 $0001)
				(not (& (local4 state:) $0001))
				(== (cupCursor script:) 0)
			)
			(super highlight: &rest)
		)
	)

	(method (show param1 &tmp [temp0 3])
		(|= signal $0020)
		(if (== argc 1)
			(= cel param1)
		)
		(DrawCel view loop cel [local30 value] 61 -1)
		(Graph
			grFILL_BOX
			62
			[local42 (self value:)]
			70
			[local45 (self value:)]
			1
			0
			-1
			-1
		)
		(Graph grUPDATE_BOX 62 [local42 (self value:)] 70 [local45 (self value:)] 1)
		(localproc_5
			(Format @temp0 {%2d} [local51 (self value:)])
			12
			[local42 (self value:)]
			63
			-1
			999
		)
	)

	(method (select)
		(return
			(cond
				((& signal $0004) 0)
				((& local7 $0001)
					(if (not (& (local4 state:) $0001))
						(if (!= [local51 (self value:)] 0)
							(if
								(and
									(== global114 2)
									(== (local4 value:) 0)
									(== (self value:) 1)
									(or (== local5 0) (== local5 2))
								)
								(gMessager say: noun 4 10 0) ; "A gallon of mercury in the side of the counterweight is simply too heavy!"
								(return 1)
							)
							(gCSoundFX number: 144 setLoop: 0 play:)
							(self show: 2)
							(cupCursor
								setScript: fillCup 0 [local24 (self value:)]
							)
							(switch (self value:)
								(0
									(local4 state: (| (local4 state:) $0008))
								)
								(1
									(local4 state: (| (local4 state:) $0004))
								)
								(2
									(local4 state: (| (local4 state:) $0010))
								)
							)
							cel
						else
							(gMessager say: noun 4 1 0) ; "There's no more left!"
							1
						)
					else
						(gMessager say: noun 4 2 0) ; "Your cup is full. Please pour it into the funnel on your right."
						1
					)
				)
				(else
					(gMessager say: noun 4 3 0) ; "Please select a cup to fill up."
					1
				)
			)
		)
	)
)

(instance funnel of CodeIcon
	(properties
		view 290
		loop 15
		cel 3
		nsLeft 145
		nsTop 101
		nsRight 183
		nsBottom 138
		noun 16
	)

	(method (highlight)
		(if
			(and
				(& local7 $0001)
				(& (local4 state:) $0001)
				(== (cupCursor script:) 0)
			)
			(super highlight: &rest)
		)
	)

	(method (show param1)
		(|= signal $0020)
		(if (== argc 1)
			(= cel param1)
		)
		(DrawCel view loop cel 163 101 -1)
		(Animate (cupCast elements:) 0)
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(if (and (& local7 $0001) (& (local4 state:) $0001))
			(gCSoundFX number: 144 setLoop: 0 play:)
			(= temp3 local5)
			(cupCursor setScript: pourCup)
			(cond
				((& (local4 state:) $0008)
					(if (== global114 0)
						(= local5 0)
					)
					(= temp0 1)
					(local4 state: (& (local4 state:) $fff7))
				)
				((& (local4 state:) $0004)
					(if (== global114 0)
						(= local5 1)
					)
					(= temp0 0)
					(local4 state: (& (local4 state:) $fffb))
				)
				((& (local4 state:) $0010)
					(if (== global114 0)
						(= local5 2)
					)
					(= temp0 2)
					(local4 state: (& (local4 state:) $ffef))
				)
			)
			(cond
				((== (local4 value:) 0)
					(= temp1 16)
				)
				((== (local4 value:) 1)
					(= temp1 4)
				)
				((== (local4 value:) 2)
					(= temp1 1)
				)
			)
			(if (== global114 0)
				((weightWinCast at: temp3) cel: 0 lowlightColor: 4)
				((weightWinCast at: local5) cel: 1 lowlightColor: 2)
				(weightWinCast eachElementDo: #show)
			)
			(= [local54 (+ local5 (* temp0 3))]
				(+ [local54 (+ local5 (* temp0 3))] temp1)
			)
			(= temp2 (weightWinCast at: local5))
			(temp2 textColor: 28 show:)
			(localproc_2 0)
		else
			(gMessager say: noun 4 4 0) ; "You must fill the container before you dump it."
		)
	)
)

(instance weightWindow of TextIcon
	(properties
		view 290
		loop 11
		cel 0
		nsTop 169
		maskView 290
		maskLoop 11
		highlightColor 6
		lowlightColor 4
		noun 17
		textColor 12
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(if (or (& signal $0004) (== highlightColor -1))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 nsTop)
		(= temp1 nsLeft)
		(= temp2 (- nsBottom 1))
		(= temp3 (- nsRight 1))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 1) (- nsLeft 1) (+ nsBottom 1) (+ nsRight 1) 1)
		(if (not (& local7 $0001))
			(cond
				(param1
					(switch (self value:)
						(0
							(= temp5 {Left})
						)
						(1
							(= temp5 {Center})
						)
						(2
							(= temp5 {Right})
						)
					)
					(= temp8 (Message msgSIZE (weightsPuzzle msgModule:) 14 4 12 1))
					(= temp6 (Memory memALLOC_CRIT temp8))
					(= temp7 (Memory memALLOC_CRIT (+ temp8 6)))
					(Message msgGET (weightsPuzzle msgModule:) 14 4 12 1 temp6)
					(Format temp7 temp6 temp5)
					(Print
						modeless: 1
						x: (- (+ nsLeft 70) 30)
						y: (- nsTop 20)
						addText: temp7
						init:
					)
					(if temp6
						(Memory memFREE temp6)
					)
					(if temp7
						(Memory memFREE temp7)
					)
				)
				((IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
			)
		)
	)

	(method (show)
		(super show: &rest)
		(Graph grFILL_BOX 28 78 (+ 28 (CelHigh 290 9 0)) 109 1 36 -1 -1)
		(Graph grUPDATE_BOX 28 78 (+ 28 (CelHigh 290 9 0)) 109 1)
		(DrawCel 290 9 local5 [local48 local5] 28 -1)
	)

	(method (showText param1 &tmp temp0 temp1 temp2 [temp3 10] [temp13 10])
		(if (< (= temp0 (ReadNumber text)) 0)
			(localproc_5 {Too much!} 28 (+ nsLeft 7) (+ nsTop 2) -1 999)
			(return)
		)
		(= temp1 (/ temp0 100))
		(= temp2 (mod temp0 100))
		(Format @temp3 {%3d lb} temp1)
		(Format @temp13 {%2d oz} temp2)
		(localproc_5 @temp3 param1 (+ nsLeft 1) (+ nsTop 2) -1 999)
		(localproc_5 @temp13 param1 (+ nsLeft 30) (+ nsTop 2) -1 999)
	)

	(method (select &tmp temp0 temp1)
		(if (& signal $0004)
			(return)
		)
		(gCSoundFX number: 144 setLoop: 0 play:)
		(= temp1 (weightWinCast at: local5))
		(temp1 cel: 0 lowlightColor: 4)
		(= temp0 (weightWinCast at: (self value:)))
		(temp0 cel: 1 lowlightColor: 2)
		(= local5 (self value:))
		(weightWinCast eachElementDo: #show)
	)
)

(instance spigot of CodeIcon
	(properties
		view 290
		loop 6
		cel 0
		nsTop 75
		nsBottom 82
	)

	(method (show))

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (not (& local7 $0001))
			(if param1
				(switch (self value:)
					(0
						(= temp2 {water})
						(= temp0 (/ [local81 1] 100))
						(= temp1 (mod [local81 1] 100))
					)
					(1
						(= temp2 {mercury})
						(= temp0 (/ [local81 0] 100))
						(= temp1 (mod [local81 0] 100))
					)
					(2
						(= temp2 {alcohol})
						(= temp0 (/ [local81 2] 100))
						(= temp1 (mod [local81 2] 100))
					)
				)
				(= temp5 (Message msgSIZE (weightsPuzzle msgModule:) 14 4 13 1))
				(= temp3 (Memory memALLOC_CRIT temp5))
				(= temp4 (Memory memALLOC_CRIT (+ temp5 7)))
				(Message msgGET (weightsPuzzle msgModule:) 14 4 13 1 temp3)
				(Format temp4 temp3 temp2 temp0 temp1)
				(Print modeless: 1 y: (- nsTop 37) addText: temp4 init:)
				(if temp3
					(Memory memFREE temp3)
				)
				(if temp4
					(Memory memFREE temp4)
				)
			else
				(if (IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
				(Animate (cupCast elements:) 0)
			)
		)
	)
)

(instance tvMonitor of IconI
	(properties
		view 290
		loop 6
		cel 0
		nsLeft 66
		nsTop 28
		nsRight 121
		nsBottom 56
		noun 18
	)

	(method (show))

	(method (select))

	(method (highlight param1)
		(if (not (& local7 $0001))
			(cond
				(param1
					(Print modeless: 1 ticks: 60 addText: noun 9 0 0 init:) ; "This is the Tip-O-Meter. It displays a close-up view of Dr. Brain's counterweight (a huge bucket) deep within his elevator shaft."
				)
				((IsObject gModelessDialog)
					(gModelessDialog dispose:)
				)
			)
		)
	)
)

(instance byline of IconI
	(properties
		view 290
		loop 6
		cel 0
		nsLeft 178
		nsTop 166
		nsRight 180
		nsBottom 168
	)

	(method (show))

	(method (select)
		(proc15_0 weightsPuzzle (weightsPuzzle noun:) 9 16 1)
	)
)

(instance cupFilling of Prop
	(properties
		view 290
		loop 5
		priority 15
		signal 18
	)
)

(instance liquidPouring of Prop
	(properties
		x 233
		y 146
		z 40
		view 290
		loop 7
		priority 15
		signal 18
	)
)

(instance bucketTilting of Prop
	(properties
		x 141
		y 20
		z -10
		noun 20
		view 290
		loop 8
		cel 3
		priority 15
		signal 18
		cycleSpeed 14
	)
)

(instance bucketDumping of Prop
	(properties
		x 141
		y 30
		noun 19
		view 290
		loop 10
		priority 15
		signal 18
	)
)

(instance cupCursor of Actor
	(properties
		yStep 3
		view 290
		loop 1
		cel 2
		priority 15
		signal 18
		moveSpeed 4
	)

	(method (doit)
		(if (& local7 $0020)
			(weightsPuzzle eventX: local2 eventY: local3)
			(&= local7 $ffdf)
		)
		(if (not (& local7 $0010))
			(self
				x: (+ 70 (weightsPuzzle eventX:))
				y: (+ 3 (weightsPuzzle eventY:))
			)
		)
		(super doit: &rest)
	)
)

(instance cupCast of Set
	(properties)
)

(instance weightWinCast of Set
	(properties)
)

(instance cupSet of Set
	(properties)
)

(instance fillCup of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(weightsPuzzle pHandsOff: 1)
				(|= local7 $0010)
				(cupCursor
					setMotion: MoveTo (+ 70 (self register:)) (+ 65 local0) self
				)
			)
			(1
				(gCSoundFX number: 145 setLoop: 0 play:)
				(if (== (local4 value:) 0)
					(gCSoundFX number: 184 setLoop: 0 play:)
					(cupFilling
						x: (+ 70 (self register:))
						y: (+ 65 local0)
						cel: 3
						cycleSpeed: 9
						show:
					)
					(Animate (cupCast elements:) 0)
					(= ticks (cupFilling cycleSpeed:))
				else
					(= state 2)
					(= cycles 1)
				)
			)
			(2
				(cupFilling setCycle: CT 0 -1 self)
			)
			(3
				(if (!= (local4 value:) 0)
					(gCSoundFX number: 184 setLoop: 0 play:)
				)
				(cupFilling
					x: (+ 70 (self register:))
					y: (+ 65 local0)
					cel: 2
					show:
					setCycle: End self
				)
			)
			(4
				(cupFilling cycleSpeed: 6 hide:)
				(gCSoundFX stop:)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (== [local24 temp0] register)
						(break)
					)
				)
				(-- [local51 temp0])
				((weightsPuzzle at: (+ 4 temp0)) show: 2)
				(gGame setCursor: 996 1 (self register:) (+ local0 62))
				(= local2 (self register:))
				(= local3 (+ local0 62))
				(cupCursor setCel: 3)
				(= local7 (| (&= local7 $ffef) $0020))
				(local4 state: (| (local4 state:) $0001))
				(weightsPuzzle pHandsOff: 0)
				(funnel cel: 2 show:)
				(gCSoundFX number: 145 setLoop: 0 play:)
				(self dispose:)
			)
		)
	)
)

(instance pourCup of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(weightsPuzzle pHandsOff: 1)
				(|= local7 $0010)
				(cupCursor setMotion: MoveTo 215 87 self)
			)
			(1
				(cupCursor x: 233 y: 102 setCel: 4)
				(liquidPouring show:)
				(= ticks (cupCursor cycleSpeed:))
			)
			(2
				(cupCursor setCycle: End)
				(liquidPouring setCycle: End self)
				(gCSoundFX number: 185 setLoop: 0 play:)
			)
			(3
				(cupCursor setCycle: CT 4 -1 self)
			)
			(4
				(= ticks (cupCursor cycleSpeed:))
			)
			(5
				(liquidPouring cel: 0 hide:)
				(gCSoundFX stop:)
				(gGame setCursor: 996 1 145 84)
				(cupCursor x: 215 y: 87 cel: 2)
				(= temp1 (weightWinCast at: local5))
				(temp1 show:)
				(= ticks 20)
			)
			(6
				(= temp1 (weightWinCast at: local5))
				(if (& (temp1 signal:) $0004)
					(temp1 textColor: 52 show:)
					(switch (temp1 value:)
						(0
							(if (not (& ((weightWinCast at: 1) signal:) $0004))
								(= local5 1)
							else
								(= local5 2)
							)
							((weightWinCast at: local5)
								cel: 1
								lowlightColor: 2
								show:
							)
						)
						(1
							(if (not (& ((weightWinCast at: 2) signal:) $0004))
								(= local5 2)
							else
								(= local5 0)
							)
							((weightWinCast at: local5)
								cel: 1
								lowlightColor: 2
								show:
							)
						)
						(2
							(if (not (& ((weightWinCast at: 1) signal:) $0004))
								(= local5 1)
							else
								(= local5 0)
							)
							((weightWinCast at: local5)
								cel: 1
								lowlightColor: 2
								show:
							)
						)
					)
				else
					(temp1 textColor: 12 show:)
				)
				(if (& local8 $0001)
					(Animate (cupCast elements:) 0)
					(cupCursor
						setMotion:
							MoveTo
							(+ 87 [local12 (local4 value:)])
							(+ 3 [local9 (local4 value:)])
							self
					)
				else
					(= cycles 1)
				)
			)
			(7
				(if (not (& local8 $0001))
					(gGame setCursor: 996 1 145 84)
					(cupCursor x: 215 y: 87)
					(= local2 145)
					(= local3 84)
				)
				(= local7 (| (&= local7 $ffef) $0020))
				(local4 state: (& (local4 state:) $fffe))
				(weightsPuzzle pHandsOff: 0)
				(= temp2 0)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (& ((cupSet at: temp0) state:) $0001)
						(= temp2 1)
						(break)
					)
				)
				(if (== temp2 0)
					(funnel show: 3)
				else
					(funnel show: 2)
				)
				(self dispose:)
				(if (& local8 $0002)
					(cupCursor setScript: resetCup 0 1)
					(return)
				)
				(if (== global114 2)
					(cond
						((& local8 $0004)
							(bucketTilting cel: 2)
						)
						((& local8 $0008)
							(weightsPuzzle setScript: spillBucket 0 0)
						)
						((& local8 $0010)
							(bucketTilting cel: 4)
						)
						((& local8 $0020)
							(weightsPuzzle
								setScript:
									spillBucket
									0
									(- (NumCels bucketTilting) 1)
							)
						)
						(else
							(bucketTilting cel: 3)
						)
					)
				)
				(if (& local8 $0001)
					(weightsPuzzle solvePuzzle:)
					(return)
				)
				(|= local8 $0040)
				(for ((= temp0 0)) (< temp0 3) ((++ temp0))
					(if (!= [local51 temp0] 0)
						(&= local8 $ffbf)
					)
				)
				(if (& local8 $0040)
					(for ((= temp0 0)) (< temp0 3) ((++ temp0))
						(if (& ((cupSet at: temp0) state:) $0001)
							(&= local8 $ffbf)
						)
					)
				)
				(if (& local8 $0040)
					(weightWinCast eachElementDo: #show)
					(Animate (cupCast elements:) 0)
					(proc15_0 weightsPuzzle 14 4 4 0)
					(cupCursor setScript: resetCup 0 0)
				)
			)
		)
	)
)

(instance resetCup of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(if register
					(= temp0 28)
					(= temp1 (weightWinCast at: local5))
					(Wait 0)
					(for ((= temp2 0)) (< temp2 8) ((++ temp2))
						(Wait 15)
						(if (== temp0 28)
							(+= temp0 2)
						else
							(= temp0 28)
						)
						(localproc_5
							{Too much!}
							temp0
							(+ (temp1 nsLeft:) 7)
							(+ (temp1 nsTop:) 2)
							-1
							999
						)
					)
				)
				(= cycles 1)
			)
			(1
				(weightsPuzzle pHandsOff: 1)
				(|= local7 $0010)
				(cupCursor
					setMotion:
						MoveTo
						(+ 87 [local12 (local4 value:)])
						(+ 3 [local9 (local4 value:)])
						self
				)
			)
			(2
				(gCSoundFX number: 145 play:)
				(bucketDumping
					setCycle: CT (- (NumCels bucketDumping) 2) 1 self
					show:
				)
				(gCSoundFX number: 185 play:)
			)
			(3
				(bucketDumping setCycle: CT 3 -1 self)
			)
			(4
				(bucketDumping setCycle: End self)
			)
			(5
				(bucketDumping hide: cel: 0)
				(localproc_4 1)
				(weightsPuzzle pHandsOff: 0)
				(&= local8 $fffd)
				(&= local7 $ffef)
				(proc15_0 weightsPuzzle (bucketDumping noun:) 9 0 0)
				(self dispose:)
			)
		)
	)
)

(instance spillBucket of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local95 0)
				(weightsPuzzle pHandsOff: 1)
				(|= local7 $0010)
				(bucketTilting
					cycleSpeed: 6
					setCycle: CT register (if register 1 else -1) self
				)
				(gCSoundFX number: 185 play:)
			)
			(1
				(= ticks (bucketTilting cycleSpeed:))
			)
			(2
				(++ local95)
				(bucketTilting
					cel:
						(if register
							(- register 1)
						else
							1
						)
				)
				(= ticks (bucketTilting cycleSpeed:))
			)
			(3
				(bucketTilting cel: register)
				(= ticks (bucketTilting cycleSpeed:))
			)
			(4
				(if (< local95 5)
					(self changeState: 2)
				else
					(= cycles 1)
				)
			)
			(5
				(localproc_4 1)
				(weightsPuzzle pHandsOff: 0)
				(&= local7 $ffef)
				(proc15_0 weightsPuzzle (bucketTilting noun:) 9 0 0 self)
			)
			(6
				(bucketTilting cycleSpeed: 14)
				(self dispose:)
			)
		)
	)
)

