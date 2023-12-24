;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 365)
(include sci.sh)
(use Main)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use Window)

(public
	gates 0
)

(local
	local0 = -1
	[local1 10]
	[local11 14]
	local25
	local26
	[local27 16]
	[local43 16]
	local59 = 4
	local60
	local61
	local62
	local63
	local64
	[local65 6] = [1 1 1 1 1 1]
	local71
	[local72 3] = [10 10 40]
	[local75 3] = [29 15 22]
	local78
)

(procedure (localproc_0)
	(local26 activate: local63 show:)
	((local26 inA:) move:)
)

(procedure (localproc_1 param1)
	(Wait 0)
	(Wait param1)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(= temp0 (= temp1 -1))
	(if (param1 inA:)
		(= temp0 (localproc_2 (param1 inA:)))
	)
	(if (param1 inB:)
		(= temp1 (localproc_2 (param1 inB:)))
	)
	(return (+ (if (> temp0 temp1) temp0 else temp1) 1))
)

(procedure (localproc_3 param1 param2 param3 param4 param5)
	(Graph grFILL_BOX param2 param1 (+ param2 1) (+ param1 2) 1 param4)
	(Graph grFILL_BOX param3 (+ param1 1) (+ param3 1) (+ param1 3) 1 param4)
	(++ param2)
	(++ param3)
	(Graph grFILL_BOX param2 param1 (+ param2 1) (+ param1 2) 1 param5)
	(Graph grFILL_BOX param3 (+ param1 1) (+ param3 1) (+ param1 3) 1 param5)
	(if (< param2 param3)
		(Graph grFILL_BOX param2 (+ param1 1) (+ param3 1) (+ param1 2) 1 param5)
		(Graph grUPDATE_BOX (- param2 1) param1 (+ param3 2) (+ param1 3) 1)
	else
		(Graph grFILL_BOX param3 (+ param1 1) (+ param2 1) (+ param1 2) 1 param5)
		(Graph grUPDATE_BOX (- param3 1) param1 (+ param2 2) (+ param1 3) 1)
	)
)

(procedure (localproc_4 param1 param2 param3)
	(if (or (== param2 -1) (== param3 -1))
		(return -1)
	)
	(return
		(&
			$0001
			(switch param1
				(1
					(~ param2)
				)
				(2
					(& param2 param3)
				)
				(3
					(| param2 param3)
				)
				(4
					(^ param2 param3)
				)
				(5
					(^ $0001 (& param2 param3))
				)
				(6
					(^ $0001 (| param2 param3))
				)
				(7
					(^ $0001 (^ param2 param3))
				)
			)
		)
	)
)

(procedure (localproc_5 param1 param2 &tmp temp0 temp1)
	(= temp0 (gate new:))
	(if param1
		(temp0 value: (Random 1 7) inA: (localproc_5 (- param1 1)))
		(if (!= (temp0 value:) 1)
			(temp0
				inB:
					(if (== param1 1)
						(localproc_5 (- param1 1) ((temp0 inA:) value:))
					else
						(localproc_5 (- param1 1))
					)
			)
		)
	else
		(= temp1 (if (>= argc 2) param2 else -1))
		(while 1
			(temp0 value: (Random 10 (+ 9 local59)))
			(if (!= temp1 (temp0 value:))
				(break)
			)
		)
	)
	(= [local1 (++ local0)] (temp0 value:))
	(return temp0)
)

(procedure (localproc_6 param1 &tmp temp0 [temp1 8])
	(Graph grFILL_BOX 39 12 48 43 1 45)
	(Graph grUPDATE_BOX 39 12 48 43 1)
	(Message msgGET gCurRoomNum 1 0 9 param1 @temp1)
	(Display @temp1 dsCOORD 12 41 dsCOLOR 11 dsALIGN alLEFT dsFONT 4)
)

(procedure (localproc_7 param1 param2 &tmp temp0 temp1 temp2)
	(= temp2 (+ 55 (* 9 (- 4 local59))))
	(Graph grFILL_BOX 41 temp2 42 114 1 34)
	(Graph grFILL_BOX 49 temp2 50 114 1 34)
	(Graph grFILL_BOX 41 113 param1 114 1 34)
	(for ((= temp1 (- 4 local59))) (< temp1 4) ((++ temp1))
		(Graph grFILL_BOX 41 (+ 55 (* 9 temp1)) param1 (+ 56 (* 9 temp1)) 1 34)
		(DrawCel 402 (- 13 temp1) 2 (+ 52 (* 9 temp1)) 41 -1)
		(Graph grFILL_BOX 43 (+ 63 (* 9 temp1)) 48 (+ 68 (* 9 temp1)) 1 36)
	)
	(DrawCel 402 8 2 97 41 -1)
	(Graph grFILL_BOX 41 91 param1 92 1 34)
	(Graph grFILL_BOX 41 92 param1 93 1 33)
	(Graph grFILL_BOX 41 103 param1 104 1 34)
	(if (!= gDifficulty 2) ; Expert
		(Graph grFILL_BOX param1 temp2 (+ param1 1) 114 1 34)
	)
	(Graph grUPDATE_BOX 41 51 131 119 1)
	(for ((= temp1 0)) (< temp1 (<< $0001 local59)) ((++ temp1))
		(= temp0 (+ 51 (* temp1 param2)))
		(DrawCel 402 0 [local43 temp1] 107 temp0 -1)
		(DrawCel 402 0 (& temp1 $0001) 85 temp0 -1)
		(DrawCel 402 0 (& (>> temp1 $0001) $0001) 76 temp0 -1)
		(if (>= local59 3)
			(DrawCel 402 0 (& (>> temp1 $0002) $0001) 67 temp0 -1)
		)
		(if (>= local59 4)
			(DrawCel 402 0 (& (>> temp1 $0003) $0001) 58 temp0 -1)
		)
	)
	(= local78 1)
)

(instance gates of PuzzleBar
	(properties
		state 8
		puzzleHeight 169
		noun 1
		msgModule 360
		personalID 24
	)

	(method (init &tmp temp0 temp1 temp2)
		(if [global135 24]
			(for ((= temp0 0)) (< temp0 6) ((++ temp0))
				(= [local65 temp0] 0)
			)
		)
		(= curInvIcon @local1)
		(= window chipWin)
		(switch gDifficulty
			(0 ; Novice
				(= local59 2)
			)
			(1 ; Standard
				(= local59 3)
			)
			(2 ; Expert
				(= local59 4)
			)
		)
		(for ((= temp0 0)) (< temp0 7) ((++ temp0))
			(self
				add:
					((= [local11 temp0] (stock new:))
						nsLeft: 182
						nsTop: (+ 41 (* temp0 13))
						loop: (+ temp0 1)
						value: temp0
						yourself:
					)
			)
		)
		(for ((= temp0 9)) (<= temp0 (+ 9 local59)) ((++ temp0))
			(self
				add:
					((= [local11 temp0] (stock new:))
						nsLeft: 212
						nsTop: (+ 9 (* temp0 9))
						loop: temp0
						value: temp0
						yourself:
					)
			)
		)
		(= temp0 10)
		(for ((= temp2 1)) (<= temp0 (+ 9 local59)) ((<<= temp2 $0001))
			(self
				add:
					((inputVal new:)
						nsTop: (+ 10 (* temp0 9))
						value: temp2
						yourself:
					)
			)
			(++ temp0)
		)
		(self
			add:
				tester
				program
				progSock
				testSock
				testBut
				((= temp0 (= local26 (gate new:)))
					nsTop: 60
					nsLeft: 261
					nsRight: 288
					nsBottom: 70
					loop: 0
					inA: (gate new:)
					inB: (gate new:)
					output: (gate new:)
					yourself:
				)
				((temp0 output:) init: temp0 1 yourself:)
				((temp0 inA:) init: temp0 0 yourself:)
				((temp0 inB:) init: temp0 0 yourself:)
		)
		(if (== local59 2)
			((temp0 inA:) value: 10 loop: 10)
			((temp0 inB:) value: 11 loop: 11)
		)
		(= temp1 (gate new:))
		(temp1
			value: (Random 2 7)
			inA: (localproc_5 (if (== local59 2) 0 else 1))
		)
		(temp1
			inB:
				(localproc_5 (if (== local59 2) 0 else 1) ((temp1 inA:) value:))
		)
		(= [local1 (++ local0)] (temp1 value:))
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(= [local43 temp0] (temp1 activate: temp0))
		)
		(temp1 dispose: 0)
		(super init: &rest)
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(super hide: &rest)
	)

	(method (showHelp param1)
		(if (or (not shown) (and argc param1))
			(super showHelp: param1 &rest)
		)
		(if (and (not (& state $2000)) (or (and argc param1) [local65 local64]))
			(Say
				self
				noun
				9
				(switch local64
					(0 19)
					(1 20)
					(2 21)
					(3 22)
					(4 17)
					(5 23)
				)
				0
				0
				msgModule
			)
			(= [local65 local64] 0)
		)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (or (& local71 $fffe) (super buyClue: &rest))
			(if (& local71 $0001)
				(Print
					addText:
						1
						(switch gDifficulty
							(0 21) ; Novice
							(1 22) ; Standard
							(2 23) ; Expert
						)
						0
						2
				)
				(= temp1 10)
				(for ((= temp0 local0)) (>= temp0 0) ((-- temp0))
					(if (> [local1 temp0] 7)
						(Print addIcon: 402 [local1 temp0] 2 temp1 15)
						(+= temp1 30)
					)
				)
			else
				(Print
					addText:
						1
						(switch gDifficulty
							(0 21) ; Novice
							(1 22) ; Standard
							(2 23) ; Expert
						)
						0
						1
				)
				(= temp1 0)
				(for ((= temp0 0)) (<= temp0 local0) ((++ temp0))
					(if (<= [local1 temp0] 7)
						(Print
							addIcon:
								402
								[local1 temp0]
								2
								[local72 temp1]
								[local75 temp1]
						)
						(++ temp1)
					)
				)
			)
			(++ local71)
			(Print init:)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(if local62
			(local62 dispose: 0)
			(= local62 0)
		)
		(if (& (event type:) $0040) ; direction
			(= temp8 4)
			(= temp7 eventY)
			(= temp2 eventX)
			(= temp3 7)
			(= temp4 9)
			(= temp5 8)
			(= temp6 -1)
			(switch (event message:)
				(JOY_DOWN
					(= temp5 6)
					(= temp6 1)
				)
				(JOY_RIGHT
					(= temp8 1)
					(if
						(and
							(IsObject highlightedIcon)
							(== (highlightedIcon name:) {gate})
						)
						(= temp8 9)
					)
					(= temp7 eventX)
					(= temp2 eventY)
					(= temp3 6)
					(= temp4 8)
					(= temp5 7)
					(= temp6 1)
				)
				(JOY_LEFT
					(= temp8 1)
					(= temp7 eventX)
					(= temp2 eventY)
					(= temp3 6)
					(= temp4 8)
					(= temp5 9)
				)
			)
			(= temp9 32767)
			(= temp10 0)
			(for ((= temp1 0)) (< temp1 size) ((++ temp1))
				(= temp0 (self at: temp1))
				(if
					(and
						(>= temp2 (- (temp0 temp3:) temp8))
						(<= temp2 (+ (temp0 temp4:) temp8))
						(> temp9 (* temp6 (temp0 temp5:)) (* temp6 temp7))
					)
					(= temp9 (* temp6 (temp0 temp5:)))
					(= temp10 temp0)
				)
			)
			(if temp10
				(self highlight: temp10 1)
			)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $030f)) ; evJOYUP | evJOYDOWN | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (highlight param1 param2 &tmp temp0)
		(cond
			((and (IsObject param1) (< (param1 nsTop:) 21))
				(gGame setCursor: gTheCursor)
			)
			((and local25 (IsObject highlightedIcon))
				(SetCursor 402 local25 (if (== local25 8) 0 else 2))
			)
		)
		(super highlight: param1)
		(if
			(and
				(>= argc 2)
				param2
				(IsObject highlightedIcon)
				(not (& (param1 signal:) $0004))
				(not pHandsOff)
			)
			(SetCursor
				(+
					(param1 nsLeft:)
					(/ (- (param1 nsRight:) (param1 nsLeft:)) 2)
				)
				(- (param1 nsBottom:) 3)
			)
		)
	)
)

(instance chipWin of SysWindow
	(properties
		top 33
		left 5
		bottom 173
		right 315
		back 5
		priority -1
	)

	(method (open)
		(super open: &rest)
		(DrawCel 403 0 0 1 21 -1)
		(DrawCel 403 1 0 127 21 -1)
		(if local78
			(localproc_7
				(switch gDifficulty
					(0 74) ; Novice
					(1 98) ; Standard
					(2 131) ; Expert
				)
				(if (== gDifficulty 2) 5 else 6) ; Expert
			)
			(if (!= (progSock value:) 0)
				(= local61 0)
			)
		else
			(SetCursor 402 8 0)
			(= local25 8)
		)
	)

	(method (dispose)
		(if (!= (progSock value:) 0)
			(Graph grRESTORE_BOX local61)
		)
		(if (or (== (testSock value:) 1) (== (testSock value:) 2))
			(Graph grRESTORE_BOX local60)
		)
		(super dispose: &rest)
	)
)

(instance stock of CodeIcon
	(properties
		view 402
		signal 385
		downClick 144
		upClick 0
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(cond
				((== local25 8)
					(gMessager say: 1 0 8) ; "That won't fit here!"
				)
				((== local25 loop)
					(= local25 0)
					(gGame setCursor: gTheCursor)
				)
				(else
					(SetCursor view loop 2)
					(= local25 loop)
				)
			)
		)
	)

	(method (highlight param1)
		(super highlight: param1)
		(cond
			(param1
				(gatePrint y: 70 modeless: 1)
				(if (>= value 9)
					(gatePrint addText: 26 1 0 1 init:) ; "Click on these letters to program inputs for the circuit you will build in the Circuit Area."
				else
					(gatePrint addText: 1 0 11 loop init:)
				)
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(instance gatePrint of Print
	(properties
		ticks 60
		modeless 1
	)
)

(instance inputVal of CodeIcon
	(properties
		view 402
		loop 14
		nsLeft 231
		signal 385
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(= temp0 (- (inputArea nsLeft:) 4))
			(= temp1
				(+
					(inputArea nsTop:)
					9
					(* local63 (if (== gDifficulty 2) 5 else 6)) ; Expert
				)
			)
			(Graph grFILL_BOX temp1 temp0 (+ temp1 5) (+ temp0 3) 1 36)
			(Graph grUPDATE_BOX temp1 temp0 (+ temp1 5) (+ temp0 3) 1)
			(^= loop $0001)
			(^= local63 value)
			(self show: 0)
			(localproc_0)
			(DrawCel
				view
				8
				1
				temp0
				(+
					(inputArea nsTop:)
					9
					(* local63 (if (== gDifficulty 2) 5 else 6)) ; Expert
				)
				-1
			)
		)
	)

	(method (highlight param1)
		(super highlight: param1)
		(cond
			(param1
				(gatePrint y: 10 modeless: 1 addText: 27 1 0 1 init:) ; "Test the input to the circuit by changing each 'F' to 'T'. If the color of the word 'OUT' in the Circuit Area is red, it indicates the output is 'T'. In the truth table on the left, the |c0|red arrow|c| indicates which condition is being tested."
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(class gate of CodeIcon
	(properties
		view 402
		loop 9
		signal 417
		downClick 144
		upClick 0
		inA 0
		inB 0
		output 0
		register 0
	)

	(method (init param1 param2)
		(if param2
			(= inA param1)
			(= nsTop (+ (inA nsTop:) 1))
			(= nsLeft (+ (param1 nsLeft:) 27))
			(= local26 self)
			(= value (= loop 9))
		else
			(= output param1)
			(= nsLeft (+ (output nsLeft:) -19))
			(= nsTop
				(+
					(param1 nsTop:)
					(cond
						((== output local26) 0)
						((== (output loop:) 1) 1)
						((== (param1 inA:) self) -4)
						(else 6)
					)
				)
			)
		)
		(= nsRight (+ nsLeft 16))
		(= nsBottom (+ nsTop 8))
	)

	(method (hide)
		(self show: 3)
		(if (IsObject inA)
			(inA hide:)
		)
		(if (IsObject inB)
			(inB hide:)
		)
	)

	(method (move)
		(if (>= loop 9)
			(= nsTop
				(+
					(output nsTop:)
					(cond
						((== output local26) 0)
						((== (output loop:) 1) 1)
						((== (output inA:) self) -4)
						(else 6)
					)
				)
			)
			(= nsLeft
				(+ (output nsLeft:) (if (== output local26) -16 else -19))
			)
			(= nsRight (+ nsLeft 16))
			(= nsBottom (+ nsTop 8))
		else
			(= nsLeft
				(+ (output nsLeft:) (if (== output local26) -27 else -30))
			)
			(= nsTop
				(+
					(output nsTop:)
					(cond
						((== output local26) -1)
						((== (output loop:) 1) 0)
						((== (output inA:) self) -10)
						(else 10)
					)
				)
			)
			(= nsRight (+ nsLeft 27))
			(= nsBottom (+ nsTop 10))
			(if (IsObject inB)
				(inB move:)
			)
			(if (IsObject inA)
				(inA move:)
			)
		)
		(self show: 2)
	)

	(method (select &tmp temp0 temp1)
		(= downClick
			(cond
				(local25 145)
				(value 144)
				(1 104)
			)
		)
		(= upClick (if (or local25 value) 0 else 207))
		(if (super select: &rest)
			(cond
				((== local25 8)
					(gMessager say: 1 0 8) ; "That won't fit here!"
				)
				((== local25 9)
					(cond
						((and inA output)
							(local26 hide: loop: local25 value: local25)
							(= local25 0)
							(gGame setCursor: gTheCursor)
							(if (== (output inA:) self)
								(output inA: 0)
							else
								(output inB: 0)
							)
							(if (local26 inA:)
								((local26 inA:) dispose: 0)
							)
							(local26 inA: (self inA:))
							(inA output: local26)
							(= inA 0)
							((local26 inA:) move:)
							(local26 show: 2)
							(= local62 self)
						)
						((== local26 self)
							(self show: 3)
							(= value (= loop local25))
							(= local25 0)
							(gGame setCursor: gTheCursor)
						)
						(else
							(gMessager say: 1 0 8) ; "That won't fit here!"
							(return)
						)
					)
				)
				((>= local25 9)
					(if (== self local26)
						(gMessager say: 1 0 8) ; "That won't fit here!"
						(return)
					)
					(self show: 3 init: output 0)
					(if (IsObject inA)
						(inA dispose: 1)
						(= inA 0)
					)
					(if (IsObject inB)
						(inB dispose: 1)
						(= inB 0)
					)
					(= value (= loop local25))
					(= local25 0)
					(gGame setCursor: gTheCursor)
				)
				(local25
					(if (>= loop 9)
						(= temp0 0)
						(= temp1 self)
						(while (!= local26 temp1)
							(= temp1 (temp1 output:))
							(++ temp0)
						)
						(if
							(or
								(>= temp0 3)
								(and (not temp0) (>= (localproc_2 local26) 3))
							)
							(gMessager say: 1 0 1) ; "Oops! You're using more gates than necessary to program the chip. Please use fewer gates to complete the circuit."
							(return)
						)
					)
					(= temp0 loop)
					(self show: 3)
					(= value local25)
					(= local25 0)
					(gGame setCursor: gTheCursor)
					(if (< temp0 9)
						(if (and (!= temp0 1) (== value 1))
							(inB dispose: 1)
							(= inB 0)
							(inA hide:)
							(= loop value)
							(inA move:)
						)
						(if (and (== temp0 1) (!= value 1))
							(inA hide:)
							(= loop value)
							(inA move:)
							(gates
								add:
									((= inB (gate new:))
										init: self 0
										show:
										yourself:
									)
							)
						)
						(= loop value)
						(self show:)
					else
						(= loop value)
						(if output
							(self move:)
							(if (!= value 1)
								(gates
									add:
										((= inB (gate new:))
											init: self 0
											show:
											yourself:
										)
								)
							)
							(self show:)
							(gates
								add:
									((= inA (gate new:))
										init: self 0
										show:
										yourself:
									)
							)
						else
							(self hide:)
							(if (!= value 1)
								(gates
									add:
										((= inB (gate new:))
											init: self 0
											yourself:
										)
								)
							)
							(gates
								add:
									((= local26 (= output (gate new:)))
										init: self 1
										nsTop: nsTop
										nsLeft: nsLeft
										nsBottom: nsBottom
										nsRight: nsRight
										show:
										yourself:
									)
							)
							(self move:)
						)
						(= nsBottom (+ nsTop 10))
						(= nsRight (+ nsLeft 27))
					)
				)
				(value
					(SetCursor view loop 2)
					(= local25 loop)
					(= value 0)
					(self show:)
				)
			)
			(localproc_0)
		)
	)

	(method (show param1 &tmp temp0 temp1 temp2)
		(= temp0 (if argc param1 else cel))
		(if (and value (< temp0 3))
			(if (and (== local26 self) (== register 1) (== temp0 2))
				(= cel temp0)
				(DrawCel view loop 4 nsLeft nsTop -1)
			else
				(super show: temp0 &rest)
			)
		else
			(Graph
				grFILL_BOX
				nsTop
				nsLeft
				nsBottom
				nsRight
				1
				(switch temp0
					(0 38)
					(1 52)
					(2 37)
					(3 36)
				)
			)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		)
		(if (< temp0 3)
			(= temp1 4)
			(= temp2 3)
			(if (== register 1)
				(+= temp1 8)
				(+= temp2 8)
			)
		else
			(= temp1 (= temp2 36))
		)
		(if (and (!= output local26) (!= self local26))
			(if (>= loop 9)
				(localproc_3
					(+ nsLeft 16)
					(+ nsTop 3)
					(+
						nsTop
						(cond
							((== (output loop:) 1) 3)
							((== (output inA:) self) 6)
							(else 0)
						)
					)
					temp1
					temp2
				)
			else
				(localproc_3
					(+ nsLeft 27)
					(+ nsTop 4)
					(+
						nsTop
						(cond
							((== (output loop:) 1) 4)
							((== (output inA:) self) 12)
							(else -4)
						)
					)
					temp1
					temp2
				)
			)
		)
	)

	(method (dispose param1)
		(if argc
			(if param1
				(self show: 3)
			)
			(if (IsObject inA)
				(inA dispose: param1)
			)
			(if (IsObject inB)
				(inB dispose: param1)
			)
		)
		(gates delete: self)
		(super dispose:)
	)

	(method (activate param1)
		(= register
			(cond
				((not value)
					(if (IsObject inA)
						(inA activate: param1)
					)
					(if (IsObject inB)
						(inB activate: param1)
					)
					-1
				)
				((< value 9)
					(localproc_4
						value
						(and (IsObject inA) (inA activate: param1))
						(and (IsObject inB) (inB activate: param1))
					)
				)
				((== value 9)
					(inA activate: param1)
				)
				(1
					(& $0001 (>> param1 (- value 10)))
				)
			)
		)
	)
)

(instance tester of CodeIcon
	(properties
		nsLeft 240
		nsTop 109
		nsRight 273
		nsBottom 127
		signal 385
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(cond
				((or (== local25 8) (>= local25 9))
					(gMessager say: 1 0 8) ; "That won't fit here!"
				)
				(value
					(= local25 value)
					(SetCursor 402 value 2)
					(= value 0)
					(Graph grFILL_BOX 109 298 131 302 1 36)
					(Graph grUPDATE_BOX 109 298 131 302 1)
					(Graph grFILL_BOX nsTop nsLeft nsBottom nsRight 1 37)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
				)
				(local25
					(= value local25)
					(DrawCel 402 value 2 243 113 -1)
					(= local25 0)
					(gGame setCursor: gTheCursor)
					(for ((= temp0 0)) (< temp0 4) ((++ temp0))
						(= temp1 (>> temp0 $0001))
						(DrawCel
							402
							0
							(localproc_4 value temp0 temp1)
							298
							(+ 109 (* temp0 6))
							-1
						)
					)
				)
			)
		)
	)

	(method (show))

	(method (highlight param1)
		(super highlight: param1)
		(cond
			(param1
				(gatePrint y: 20 modeless: 1 addText: 4 9 0 1 init:) ; "This area is where you can test each logic gate to learn its logic. For more on logic gates, see your EncycloAlmanacTion- aryOgraphy (page 29)."
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(instance program of CodeIcon
	(properties
		nsLeft 147
		nsTop 60
		nsRight 161
		nsBottom 74
		signal 417
		downClick 213
		upClick 0
	)

	(method (select &tmp temp0 temp1)
		(if (super select: &rest)
			(if (== (progSock value:) 2)
				(= temp1 1)
				(for ((= temp0 0)) (< temp0 16) ((++ temp0))
					(if (< (= [local27 temp0] (local26 activate: temp0)) 0)
						(= temp1 0)
						(break)
					)
				)
				(if temp1
					(Say gates 30 1) ; "Chip programmed."
					(= local64 3)
					(gates showHelp:)
				else
					(gMessager say: 1 0 2) ; "You need to complete the circuit before pressing the Program Button."
				)
			else
				(gMessager say: 1 0 10) ; "The chip cannot be programmed if it is not plugged into the chip socket."
			)
		)
	)

	(method (show param1 &tmp temp0)
		(= cel (if argc param1 else cel))
		(Graph
			grFILL_BOX
			(+ nsTop 5)
			(+ nsLeft 5)
			(- nsBottom 5)
			(- nsRight 5)
			1
			(switch cel
				(0 28)
				(1 52)
				(2 12)
			)
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
	)
)

(instance progSock of CodeIcon
	(properties
		nsLeft 146
		nsTop 87
		nsRight 161
		nsBottom 112
		signal 385
		value 2
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((== local25 8)
					(if (== value 0)
						(= local61 (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
						(DrawCel 402 8 0 nsLeft nsTop -1)
						(= value 2)
						(= local25 0)
						(gGame setCursor: gTheCursor)
					else
						(gMessager say: 1 0 7) ; "Oops! You need to test the old chip before testing a replacement."
					)
				)
				(local25
					(gMessager say: 1 0 8) ; "That won't fit here!"
				)
				((!= value 0)
					(Graph grRESTORE_BOX local61)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(= local25 8)
					(SetCursor 402 8 0)
					(= value 0)
					(if (== local64 3)
						(= local64 4)
						(gates showHelp:)
					)
				)
			)
		)
	)

	(method (show)
		(if (not local61)
			(= local61 (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
			(DrawCel 402 8 0 nsLeft nsTop -1)
			(= value 2)
		)
	)

	(method (highlight param1)
		(super highlight: param1)
		(cond
			(param1
				(gatePrint y: 20 modeless: 1 addText: 29 1 0 1 init:) ; "|c2|Chip Programming Socket:|c| Press PROG button to program the new chip."
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(instance testSock of CodeIcon
	(properties
		nsLeft 21
		nsTop 98
		nsRight 36
		nsBottom 123
		signal 385
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((== local25 8)
					(if (or (== value 0) (== value 3))
						(= local60 (Graph grSAVE_BOX nsTop nsLeft nsBottom nsRight 1))
						(DrawCel 402 8 0 nsLeft nsTop -1)
						(= value (if (== value 0) 1 else 2))
						(= local25 0)
						(gGame setCursor: gTheCursor)
						(= local64 (if (== value 1) 1 else 5))
						(gates showHelp:)
					else
						(gMessager say: 1 0 7) ; "Oops! You need to test the old chip before testing a replacement."
					)
				)
				(local25
					(gMessager say: 1 0 8) ; "That won't fit here!"
				)
				((or (== value 1) (== value 2))
					(= value (if (== value 1) 0 else 3))
					(Graph grRESTORE_BOX local60)
					(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
					(= local25 8)
					(SetCursor 402 8 0)
				)
			)
		)
	)

	(method (show))

	(method (highlight param1)
		(super highlight: param1)
		(cond
			(param1
				(gatePrint y: 20 modeless: 1 addText: 28 1 0 1 init:) ; "|c2|Chip Test Socket:|c| Place the old or new chip here for testing."
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

(instance testBut of CodeIcon
	(properties
		nsLeft 21
		nsTop 64
		nsRight 35
		nsBottom 78
		signal 417
		downClick 213
		upClick 0
	)

	(method (select &tmp temp0 [temp1 40] temp41 temp42 temp43)
		(if (super select: &rest)
			(= temp43
				(switch gDifficulty
					(0 74) ; Novice
					(1 98) ; Standard
					(2 131) ; Expert
				)
			)
			(= temp42 (if (== gDifficulty 2) 5 else 6)) ; Expert
			(switch (testSock value:)
				(1
					(localproc_6 1)
					(localproc_1 40)
					(localproc_6 2)
					(Message msgGET gCurRoomNum 1 0 3 1 @temp1)
					(Display @temp1 dsCOORD 50 49 dsCOLOR 0 dsALIGN alLEFT dsFONT 4)
					(localproc_1 40)
					(Message msgGET gCurRoomNum 1 0 3 (Random 2 5) @temp1)
					(Display @temp1 dsCOORD 50 60 dsCOLOR 0 dsALIGN alLEFT dsFONT 999)
					(localproc_1 20)
					(Message msgGET gCurRoomNum 1 0 4 (Random 1 4) @temp1)
					(Display @temp1 dsCOORD 50 71 dsCOLOR 0 dsALIGN alLEFT dsFONT 999)
					(localproc_1 15)
					(Message msgGET gCurRoomNum 1 0 5 (Random 1 5) @temp1)
					(Display @temp1 dsCOORD 50 82 dsCOLOR 0 dsALIGN alLEFT dsFONT 999)
					(localproc_1 30)
					(Message msgGET gCurRoomNum 1 0 6 1 @temp1)
					(Display @temp1 dsCOORD 50 95 dsCOLOR 11 dsALIGN alLEFT dsFONT 999)
					(localproc_1 180)
					(Graph grFILL_BOX 41 51 131 119 1 36)
					(localproc_7 temp43 temp42)
					(Graph grRESTORE_BOX local60)
					(Graph
						grUPDATE_BOX
						(testSock nsTop:)
						(testSock nsLeft:)
						(testSock nsBottom:)
						(testSock nsRight:)
						1
					)
					(testSock value: 3)
					(Say gates 5 9) ; "The old computer chip is discarded."
					(= local64 2)
					(inputArea
						nsLeft:
							(switch gDifficulty
								(0 73) ; Novice
								(1 64) ; Standard
								(2 55) ; Expert
							)
						nsBottom: temp43
					)
					(gates
						showHelp:
						add:
							inputArea
							((inputArea new:) nsLeft: 91 nsRight: 103 noun: 24)
							((inputArea new:) nsLeft: 103 nsRight: 113 noun: 25)
					)
				)
				(2
					(= temp41 0)
					(Graph grFILL_BOX 51 98 (- temp43 1) 102 1 36)
					(Graph grUPDATE_BOX 51 98 (- temp43 1) 102 1)
					(for ((= temp0 0)) (< temp0 (<< $0001 local59)) ((++ temp0))
						(if (!= [local27 temp0] [local43 temp0])
							(= temp41 1)
						)
						(DrawCel
							402
							0
							[local27 temp0]
							98
							(+ 51 (* temp0 temp42))
							-1
						)
					)
					(localproc_6 1)
					(localproc_1 40)
					(if temp41
						(localproc_6 2)
					else
						(localproc_6 3)
						(self show: 2)
						(gCSoundFX number: 106 loop: 1 play:)
						(while (!= (gCSoundFX prevSignal:) -1)
							(gSounds eachElementDo: #check)
						)
						(localproc_1 20)
						(gates solvePuzzle: goAway:)
					)
				)
			)
		)
	)

	(method (show param1 &tmp temp0)
		(= cel (if argc param1 else cel))
		(Graph
			grFILL_BOX
			(+ nsTop 5)
			(+ nsLeft 5)
			(- nsBottom 5)
			(- nsRight 5)
			1
			(switch cel
				(0 28)
				(1 52)
				(2 12)
			)
		)
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
	)
)

(instance inputArea of CodeIcon
	(properties
		nsLeft 73
		nsTop 41
		nsRight 91
		nsBottom 74
		signal 417
		noun 23
	)

	(method (show))

	(method (highlight param1)
		(super highlight: param1)
		(cond
			(param1
				(gatePrint
					y: 30
					modeless: 1
					addText:
						noun
						1
						0
						(if (== noun 23)
							(+ gDifficulty 1) ; Standard
						else
							1
						)
					init:
				)
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)
)

