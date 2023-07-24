;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use IconBar)
(use Feature)
(use LoadMany)
(use Window)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm120 0
)

(local
	[local0 17] = [30 36 10 12 34 52 14 7 11 50 34 9 35 43 10 13 10]
	[local17 17] = [14 10 4 4 10 1 12 15 4 1 12 4 2 3 4 4 4]
	local34
	local35
	local36
	local37
	local38
	local39
	local40 = {}
	[local41 17]
	[local58 16]
	[local74 32]
	local106
	local107
	local108
	local109
	[local110 3] = [{first} {second} {third}]
	local113
	local114
	local115
	local116
	local117 = 1
	local118
	local119
	local120
	local121
	local122 = 1
	local123 = 1
	local124 = 1
	local125
	local126
	local127
	[local128 4]
	[local132 4]
	local136
	local137
	[local138 16] = [6 37 68 99 6 37 68 99 6 37 68 99 6 37 68 99]
	[local154 16] = [30 30 30 30 54 54 54 54 78 78 78 78 102 102 102 102]
	local170 = 171
	local171
	[local172 3] = [15 34 64]
	local175 = 8
	[local176 2]
	local178
	[local179 2] = [47 8]
	local181
	local182
	local183
	local184 = 2
	[local185 16]
	[local201 16]
	[local217 16]
	[local233 16]
	local249
	local250
	[local251 16] = [8 32 56 80 8 32 56 80 8 32 56 80 8 32 56 80]
	[local267 16] = [46 46 46 46 63 63 63 63 80 80 80 80 97 97 97 97]
	[local283 16] = [{1} {2} {3} {4} {5} {6} {7} {8} {9} {10} {11} {12} {13} {14} {15} {16}]
	[local299 16] = [{1} {3} {5} {7} {9} {11} {13} {15} {17} {19} {21} {23} {25} {27} {29} {31}]
	[local315 16] = [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16]
	[local331 16] = [1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31]
	[local347 10] = [0 4 8 12 0 1 2 3 3 0]
	[local357 10] = [1 1 1 1 4 4 4 4 3 5]
	[local367 10] = [112 112 112 112 10 34 58 82 112 112]
	[local377 10] = [49 66 83 100 120 120 120 120 30 117]
	[local387 10] = [94 94 94 0 10 34 58 0 94 94]
	[local397 10] = [51 68 85 0 104 104 104 0 33 103]
	local407 = 20
	local408 = 142
	[local409 3]
	local412
	[local413 16]
	[local429 16]
	[local445 3]
	local448
	[local449 3]
	[local452 4] = [1 0 3 2]
	[local456 16] = [98 132 166 200 98 132 166 200 98 132 166 200 11 11 11 11]
	[local472 16] = [35 35 35 35 60 60 60 60 85 85 85 85 31 51 71 91]
	[local488 4] = [58 58 58 35]
	[local492 4] = [31 53 87 57]
	[local496 36] = [{11} {90} {42} {60} {22} {80} {02} {20} {33} {10} {84} {03} {12} {99} {22} {56} {23} {33} {04} {08} {35} {66} {88} {07} {12} {65} {11} {75} {18} {44} {08} {15} {30} {21} {88} {05}]
	[local532 36] = [11 90 42 60 22 80 2 20 33 10 84 3 12 99 22 56 23 33 4 8 35 66 88 7 12 65 11 75 18 44 8 15 30 21 88 5]
	local568
	[local569 10]
	local579
	local580
	local581 = 1
	local582
	[local583 10] = [17 38 59 17 38 59 17 38 59 17]
	[local593 20] = [54 54 54 75 75 75 96 96 96 117 {0} {1} {2} {3} {4} {5} {6} {7} {8} {9}]
	[local613 25] = [{Backgammon} {Baseball} {Basketball} {Billiards} {Blackjack} {Bowling} {Bridge} {Checkers} {Chess} {Cribbage} {Dominos} {Football} {Golf} {Hearts} {Hockey} {Horseshoes} {Jacks} {Jigsaw} {Poker} {Pool} {Puzzle} {Soccer} {Spades} {Tennis} {Tic-Tac-Toe}]
	[local638 25] = [129 147 161 183 197 229 247 261 283 297 329 347 361 383 397 529 547 561 583 597 729 747 761 783 797]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (!= [local132 temp0] -1)
			(proc5_8
				[local128 temp0]
				[local0 11]
				[local488 temp0]
				[local492 temp0]
				[local0 12]
			)
		)
	)
	(if (!= (= temp0 [local132 3]) -1)
		(DrawCel
			140
			((mathMarvel at: temp0) loop:)
			2
			[local488 3]
			[local492 3]
			15
		)
	)
)

(procedure (localproc_1 param1)
	(param1 dispose:)
	(param1 init:)
)

(procedure (localproc_2 param1 param2 &tmp temp0)
	(= temp0 [global167 param1])
	(while
		(or
			(< temp0 0)
			(== temp0 [global167 (mod (+ param1 1) 3)])
			(== temp0 [global167 (mod (+ param1 2) 3)])
		)
		(= [global167 param1] (= temp0 (Random 0 24)))
	)
	(if param2
		(++ local116)
	)
	(return param1)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
	(= temp1 1)
	(while temp1
		(= temp2 [local58 local106])
		(= temp3 [local58 (= temp4 (+ local106 param1))])
		(= [local41 local106] [local41 temp4])
		(= [local41 temp4] 0)
		(temp2
			view: (temp3 view:)
			loop: (temp3 loop:)
			cel: 0
			text: (temp3 text:)
		)
		(temp3 view: 165 loop: 0 cel: 1 text: local40)
		(bar15 enable: temp2)
		(bar15 disable: temp3)
		(if (== temp4 param2)
			(= temp1 0)
			(blankIcon
				nsTop: (+ (temp3 nsTop:) 11)
				nsLeft: (+ (temp3 nsLeft:) 14)
				nsRight: (+ (temp3 nsLeft:) 15)
				nsBottom: (+ (temp3 nsTop:) 12)
			)
			(if (IsObject (bar15 highlightedIcon:))
				((bar15 highlightedIcon:) highlight: 0)
			)
			(bar15 highlightedIcon: temp3)
			(proc5_20 blankIcon)
		)
		(gCMusic2 number: 61 setLoop: 1 play:)
		(temp2 show:)
		(temp3 show:)
		(= local106 temp4)
		(Wait 0)
		(Wait 5)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3)
	(while
		(or
			(not (= temp1 (localproc_5 (= temp0 (Random 0 (- local126 1))))))
			(== temp0 param1)
		)
	)
	(= temp2 (+ temp0 temp1))
	(= temp3 [local41 temp0])
	(= [local41 temp0] [local41 temp2])
	(= [local41 temp2] temp3)
	(= local106 temp0)
	(return temp2)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(= temp1
		(cond
			((and (mod param1 local127) (not [local41 (- param1 1)])) -1)
			((and (>= param1 local127) (not [local41 (- param1 local127)]))
				(- local127)
			)
			((and (mod (+ param1 1) local127) (not [local41 (+ param1 1)])) 1)
			(
				(and
					(< param1 (- local126 local127))
					(not [local41 (+ param1 local127)])
				)
				local127
			)
			(else 0)
		)
	)
)

(procedure (localproc_6 param1 param2 &tmp temp0 temp1 temp2)
	(= temp0 (param1 text:))
	(param1 text: (param2 text:))
	(param2 text: temp0)
	(param2 cel: 1)
	(param1 cel: 1)
	(if (== param2 dummyIcon)
		(= temp1 [local233 (= temp2 (param2 value:))])
		(= [local217 temp2] temp0)
		(= [local233 temp2] [local74 (param1 value:)])
	else
		(= temp1 [local74 (= temp2 (param2 value:))])
		(= [local74 temp2] [local74 (param1 value:)])
	)
	(= [local74 (param1 value:)] temp1)
	(theMusic3 number: 60 setLoop: 1 play:)
	(param1 show:)
	(param2 show:)
	(= local37 0)
	(localproc_7)
)

(procedure (localproc_7 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2])
	(= temp4 1)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(= temp3 0)
		(= temp6 [local347 temp0])
		(for ((= temp7 0)) (< temp7 4) ((++ temp7))
			(+= temp3 [local74 temp6])
			(+= temp6 [local357 temp0])
		)
		(if (not (and (or (== temp0 3) (== temp0 7)) (== local118 0)))
			(= temp1 [local185 temp0])
			(= temp2 [local201 temp0])
			(if (!= temp3 local171)
				(= temp4 0)
			)
			(Graph grFILL_BOX temp2 temp1 (+ temp2 8) (+ temp1 17) 1 [local0 1] -1 -1)
			(Graph grUPDATE_BOX temp2 temp1 (+ temp2 8) (+ temp1 17) 1)
			(proc5_8
				(Format @temp8 120 22 temp3) ; "%2d"
				[local0 2]
				(+ temp1 1)
				(+ temp2 1)
			)
		)
	)
	(if (and temp4 (not local35))
		(= local35 1)
		(gGame setCursor: 50)
		(Wait 0)
		(for ((= temp0 0)) (< temp0 local183) ((++ temp0))
			(= temp5 (barMagic at: temp0))
			(Wait 10)
			(gCMusic2 number: 58 setLoop: 1 play:)
			(temp5 mask:)
			(Wait 5)
			(temp5 show:)
		)
		(gCMusic2 number: 50 setLoop: 1 play:)
		(Wait 30)
		(barMagic goAway:)
	)
)

(procedure (localproc_8 param1 &tmp temp0 temp1 temp2)
	(for ((= temp0 (FirstNode (mathMarvel elements:)))) temp0 ((= temp0 temp1))
		(= temp1 (NextNode temp0))
		(= temp2 (NodeValue temp0))
		(cond
			(param1
				(if
					(and
						(== (temp2 name:) {operand})
						(== (temp2 value:) param1)
					)
					(if (not (& (temp2 signal:) $0004))
						(return temp2)
					else
						(return 0)
					)
				)
			)
			((and (== (temp2 name:) {operator}) (not (& (temp2 signal:) $0004)))
				(return temp2)
			)
		)
	)
	(return 0)
)

(procedure (localproc_9 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(mathMarvel
			add:
				((= [local409 temp0] (selOperand new:))
					nsLeft: [local488 temp0]
					nsTop: [local492 temp0]
					cel: 3
					nsRight: (+ [local488 temp0] 27)
					highlightColor: [local0 7]
					lowlightColor: [local0 8]
					textColor: [local0 9]
					nsBottom: (+ [local492 temp0] 19)
					value: 0
					text: {}
					signal: 129
					maskCel: temp0
					yourself:
				)
		)
		(= [local445 temp0] 0)
	)
)

(procedure (localproc_10 &tmp temp0 temp1 temp2 temp3 temp4)
	(if
		(and
			([local409 0] value:)
			([local409 1] value:)
			([local409 2] value:)
			(mathOperator value:)
		)
		(= temp1 0)
		(= temp2 ([local409 0] value:))
		(= temp3 ([local409 1] value:))
		(= temp4 ([local409 2] value:))
		(switch (mathOperator value:)
			(1
				(if (== temp4 (+ temp2 temp3))
					(= temp1 1)
				)
			)
			(2
				(if (== temp4 (- temp2 temp3))
					(= temp1 1)
				)
			)
			(3
				(if (== temp4 (* temp2 temp3))
					(= temp1 1)
				)
			)
			(4
				(if (== temp4 (/ temp2 temp3))
					(= temp1 1)
				)
			)
		)
		(if temp1
			(theMusic3 number: 50 setLoop: 1 play:)
			(++ local137)
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				([local409 temp0] value: 0 loop: 1 cel: 3 text: {} show:)
				(= [local445 temp0] 0)
			)
			(mathOperator loop: 2 cel: 4 value: 0 show:)
			(= local448 0)
			(DrawCel 140 6 2 (mathBox x:) (mathBox y:) 15)
			(mathBox x: (+ (mathBox x:) 41))
			(DrawCel 140 6 0 (mathBox x:) (mathBox y:) 15)
		else
			(gCMusic2 number: 54 setLoop: 1 play:)
			(Wait 0)
			(Wait 30)
			(proc5_9 120 24) ; "Try it again. This number sentence is not an equation."
			(localproc_11)
		)
		(if (== local137 4)
			(= local36 1)
			(proc5_9 120 25) ; "You solved the Math Marvel puzzle!"
			(DrawCel 140 6 2 (mathBox x:) (mathBox y:) 15)
			(mathBox x: (- (mathBox x:) 3))
			(mathBox y: (- (mathBox y:) 10))
			(DrawCel 140 6 1 (mathBox x:) (mathBox y:) 15)
			(DrawCel 140 6 3 (+ (mathBox x:) 14) (+ (mathBox y:) 16) 15)
			(theMusic3 number: 52 setLoop: 1 play:)
			(proc5_9 120 26) ; "In the chest, you find a key. You take it and put it away for later use."
			(gEgo get: 4)
			(gCMusic2 number: 58 setLoop: 1 play:)
			(DrawCel 140 6 1 (mathBox x:) (mathBox y:) 15)
			(Wait 0)
			(Wait 20)
			(mathMarvel goAway:)
		)
	)
)

(procedure (localproc_11 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if ([local409 temp0] value:)
			([local409 temp0] value: 0 loop: 1 cel: 3 text: {} show:)
			([local445 temp0]
				signal: (& ([local445 temp0] signal:) $fffb)
				cel: 0
				show:
			)
		)
		(= [local445 temp0] 0)
	)
	(if (mathOperator value:)
		(mathOperator loop: 2 cel: 4 value: 0 show:)
		(local448 signal: (& (local448 signal:) $fffb) cel: 0 show:)
	)
)

(procedure (localproc_12 param1 &tmp temp0)
	(mathMarvel select: param1 0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(Wait 0)
		(Wait 10)
		(mathMarvel select: [local449 temp0] 0)
		(if (== local119 2)
			(mathMarvel select: [local409 temp0] 0)
		)
	)
)

(procedure (localproc_13 &tmp [temp0 5])
	(Graph grFILL_BOX 37 21 49 75 1 [local0 4] -1 -1)
	(if local580
		(if (>= local580 11)
			(if (>= local580 110)
				(DrawCel 388 (mod (+ (/ local580 100) 9) 10) 2 28 37 15)
			)
			(DrawCel 388 (mod (+ (/ local580 10) 9) 10) 2 44 37 15)
		)
		(DrawCel 388 (mod (+ local580 9) 10) 2 60 37 15)
	)
	(proc5_8 (Format @temp0 120 32 (+ local582 1)) [local0 16] 21 38 -1 gUserFont) ; "%d"
	(Graph grUPDATE_BOX 37 21 49 75 1)
)

(procedure (localproc_14 param1)
	(proc5_14 120 33 [local110 param1] [local613 [global167 param1]]) ; "The %s code word is '%s'."
)

(instance rm120 of Rm
	(properties
		lookStr {This is the first floor hallway of the castle.}
		picture 120
		style 7
		south 100
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 17) ((++ temp0))
				(= [local0 temp0] [local17 temp0])
			)
		)
		(LoadMany rsVIEW 140 165 170 171)
		(LoadMany
			rsSOUND
			50
			51
			52
			56
			58
			59
			60
			61
			120
			121
			900
			901
			902
			903
			904
			905
			906
			907
			908
			909
			910
			912
			913
		)
		(gCMusic2 flags: 1)
		(theMusic3 flags: 1)
		(super init: &rest)
		(rightDoor init:)
		(westLight init:)
		(eastLight init:)
		(gAddToPics doit:)
		(drawer init:)
		(leftDoor init:)
		(backDoor init:)
		(= [global167 0] -1)
		(= [global167 1] -1)
		(= [global167 2] -1)
		(if (not (IsFlag 13))
			(bar15 init:)
		else
			(= local115 (localproc_2 local116 1))
		)
		(if (not (IsFlag 11))
			(barMagic init:)
		else
			(= local113 (localproc_2 local116 1))
		)
		(if (not (IsFlag 12))
			(mathMarvel init:)
		else
			(= local114 (localproc_2 local116 1))
		)
		(if (IsFlag 32)
			(= local568 1)
		else
			(backDoorLock init:)
		)
		(leftFeat init:)
		(rightFeat init:)
		(backFeat init:)
		(bootFeat init:)
		(tableFeat init:)
		(mirrorFeat init:)
		(armorFeat init:)
		(gCMusic number: 120 setLoop: -1 flags: 1 play:)
	)

	(method (dispose)
		(bar15 dispose:)
		(barMagic dispose:)
		(mathMarvel dispose:)
		(backDoorLock dispose:)
		(gCMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance westLight of Prop
	(properties
		x 84
		y 140
		view 120
		loop 5
		priority 12
		signal 16400
	)
)

(instance eastLight of Prop
	(properties
		x 211
		y 148
		view 120
		loop 4
		priority 12
		signal 16400
	)
)

(instance bootFeat of Feature
	(properties
		description {iron boot with flowers}
		onMeCheck 16
		lookStr {The flowers must be standing in a foot of water!}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(proc5_9 120 0) ; "Please leave Dr. Brain's flowers here for the next visitor."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance armorFeat of Feature
	(properties
		description {suit of armor}
		onMeCheck 128
		lookStr {You've heard that people were shorter in medieval times, and it must be true -- this armor is at least a foot short.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(gCMusic2 number: 914 setLoop: 1 play:)
			(proc5_9 120 1) ; "The armor makes a hollow "Clang" sound."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance mirrorFeat of Feature
	(properties
		description {wall mirror}
		onMeCheck 64
		lookStr {How does that go? "Mirror, mirror, on the wall..." No, that only works in Mixed-Up Fairy Tales.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(proc5_9 120 2) ; "You left a smudge on the mirror. Better wash up next time."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance tableFeat of Feature
	(properties
		description {mahogany table}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(drawer doVerb: theVerb &rest)
	)
)

(instance drawer of Prop
	(properties
		x 136
		y 98
		description {mahogany table}
		lookStr {Wooden you know it? The desk is tree foot tall. (The foot from the suit of armor must be a four-foot, then. Guess the oak's on you!)}
		view 120
		priority 14
		signal 16400
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(cond
					((not cel)
						(proc5_9 lookStr)
					)
					((IsFlag 13)
						(localproc_14 local115)
					)
					(else
						(proc5_9 120 3) ; "The drawer contains a sliding-tile puzzle."
					)
				)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(else
				(self setScript: start15)
			)
		)
	)
)

(instance leftDoor of Prop
	(properties
		x 44
		y 21
		view 120
		loop 1
		priority 12
		signal 16400
		cycleSpeed 30
	)

	(method (onMe)
		(return 0)
	)
)

(instance leftFeat of Feature
	(properties
		description {left-hand door}
		onMeCheck 2
		lookStr {A sign on this wooden door reads "Math Marvel".}
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(cond
					((not (leftDoor cel:))
						(proc5_9 lookStr)
					)
					((IsFlag 12)
						(localproc_14 local114)
					)
					(else
						(proc5_14 ; "The Math Marvel is one of Dr. Brain's inventions. You need to construct correct addition, subtraction, multiplication, and division problems to get what's in the treasure chest. %s"
							120
							4
							(if (< local119 2)
								{Each problem uses one number from each row.}
							else
								{}
							)
						)
					)
				)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(else
				(leftDoor setScript: startMath)
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 260
		y 21
		view 120
		loop 2
		priority 12
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance rightFeat of Feature
	(properties
		description {right-hand door}
		onMeCheck 4
		lookStr {This metal door is labelled "Magic Numbers".}
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(cond
					((not (rightDoor cel:))
						(proc5_9 lookStr)
					)
					((IsFlag 11)
						(localproc_14 local113)
					)
					(else
						(proc5_9 120 5) ; "This is a "magic square". Place numbers in the squares so that they add to the same totals across each row, down each column, and along both diagonals."
					)
				)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(else
				(rightDoor setScript: startMagic)
			)
		)
	)
)

(instance backDoor of Prop
	(properties
		x 175
		y 45
		view 120
		loop 3
		priority 12
		signal 16400
	)

	(method (onMe)
		(return 0)
	)
)

(instance backFeat of Feature
	(properties
		description {back door}
		onMeCheck 8
		lookStr {A sign on this solid wooden door reads "Clock Room". There is a keypad on the door for opening its combination lock.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(cond
				(local568
					(gCurRoom newRoom: 180)
				)
				((backDoorLock show:)
					(gCurRoom setScript: exitScript)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance exitScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic2 number: 912 setLoop: 1 play:)
				(backDoor setCycle: End self)
			)
			(1
				(proc5_9 120 6) ; "As the door opens, you notice a small award plaque showing that you have passed the mathematics examination with distinction. You pick it up proudly."
				(gEgo get: 23)
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance start15 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_1)
				(if (client cel:)
					(self changeState: 2)
				else
					(gCMusic2 number: 121 setLoop: 1 play:)
					(client setCycle: End self)
				)
			)
			(1
				(= cycles 1)
			)
			(2
				(proc5_2)
				(if (not (IsFlag 13))
					(if (!= local120 global114)
						(bar15 dispose:)
						(bar15 init:)
					)
					(if (bar15 show:)
						(proc5_1)
						(= local115 (localproc_2 local116 1))
						(= cycles 1)
					else
						(self dispose:)
					)
				else
					(= local34 1)
					(= cycles 1)
				)
			)
			(3
				(proc5_2)
				(localproc_14 local115)
				(self dispose:)
			)
		)
	)
)

(instance startMagic of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_1)
				(if (client cel:)
					(self changeState: 2)
				else
					(gCMusic2 number: 912 setLoop: 1 play:)
					(client setCycle: End self)
				)
			)
			(1
				(eastLight setCel: 1)
				(= cycles 3)
			)
			(2
				(proc5_2)
				(if (not (IsFlag 11))
					(if (!= local118 global114)
						(localproc_1 barMagic)
					)
					(if (barMagic show:)
						(proc5_1)
						(= local113 (localproc_2 local116 1))
						(= cycles 1)
					else
						(self dispose:)
					)
				else
					(= local35 1)
					(= cycles 1)
				)
			)
			(3
				(proc5_2)
				(localproc_14 local113)
				(self dispose:)
			)
		)
	)
)

(instance bar15 of PuzzleBar
	(properties
		puzzleHeight 110
		bottomHeight 0
		hintFlag 33
		solvedFlag 13
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= local120 global114)
		(= window puzWindow)
		(puzWindow back: [local0 13])
		(= local38 iconHeight)
		(= local39 (+ iconHeight puzzleHeight 3))
		(switch local120
			(0
				(= local126 9)
				(= local127 3)
				(= local125 2)
				(puzWindow right: 255 bottom: 118)
			)
			(1
				(= local126 16)
				(= local127 4)
				(= local125 0)
				(puzWindow right: 286 bottom: 142)
			)
			(else
				(= local126 16)
				(= local127 4)
				(= local125 0)
				(puzWindow right: 286 bottom: 142)
			)
		)
		(for ((= temp0 0)) (< temp0 local126) ((++ temp0))
			(= [local41 temp0] (mod (+ temp0 1) local126))
		)
		(= [local41 local126] 0)
		(= temp0 (+ 100 (Random 1 (* global164 3))))
		(= temp1 -1)
		(while temp0
			(= temp1 (localproc_4 temp1))
			(-- temp0)
		)
		(= temp0 0)
		(= temp4 0)
		(while (< temp0 local126)
			(if (= temp1 [local41 temp0])
				(= temp2 [local283 (- temp1 1)])
			else
				(= temp2 local40)
			)
			(= temp3
				((icon15 new:)
					text: temp2
					value: temp0
					nsLeft: [local138 temp4]
					nsTop: [local154 temp4]
					yourself:
				)
			)
			(cond
				((not temp1)
					(temp3 loop: 0 cel: 1 signal: (| (temp3 signal:) $0004))
				)
				((== global114 2)
					(temp3 view: 167 loop: (- temp1 1))
				)
			)
			(self add: (= [local58 temp0] temp3))
			(++ temp0)
			(++ temp4)
			(if (and (== local120 0) (or (== temp0 3) (== temp0 6)))
				(++ temp4)
			)
		)
		(self add: blankIcon)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(if local34
			(self solvePuzzle:)
		)
		(return local34)
	)

	(method (buyClue)
		(if (or local108 (super buyClue: &rest))
			(if (== local120 2)
				(if local117
					(proc5_9 120 7) ; "When the puzzle is complete, you will have created a picture of Dr. Brain's castle. But for now, pretend that the tiles are numbered 1-15 when in their correct order."
					(= local117 0)
				)
				(Print 120 8 #icon 167 0 2 #at 0 0)
			else
				(proc5_9 120 9) ; "Start with the top row and work your way down. One useful technique is to "snake" tiles into position. Let's say you want to place the first two tiles. Move the "1" tile just under the "2" position, and the "2" tile right under it. Move other tiles so that the empty square is in the "2" position, then slide both tiles up, get the empty square into the "1" position, slide the "1" tile over, then the "2" tile up. Work your way down the puzzle this way."
				(if (!= local120 0)
					(proc5_9 120 10) ; "The last two rows are a little trickier. Think of those squares as points around a circle. Let's say you have most of the 3rd row, but "10" is out of order (say the order is 9-11-10-12). Move the bottom row pieces so the empty square is under the "10", slide the "10" down, and rotate both rows together until the empty square is between "9" and "11", with the "10" under it. Slide "10" into position, and rotate the pieces back into their correct rows."
				)
			)
			(= local108 1)
		)
	)

	(method (showHelp)
		(proc5_9 120 11) ; "Inside the drawer, you find a sliding-tile puzzle. The object is to arrange the tiles correctly by sliding tiles into the empty space."
		(switch local120
			(0
				(proc5_9 120 12) ; "When you have correctly arranged the tiles, you will have the numbers 1-3 across the top row, 4-6 across the middle row, and 7-8 on the left side of the bottom row."
			)
			(1
				(proc5_9 120 13) ; "When you have correctly arranged the tiles, you will have the numbers 1-4 across the top row, 5-8 across the second row, 9-12 across the third row, and 13-15 on the left side of the bottom row."
			)
			(else
				(proc5_9 120 14) ; "When you have correctly arranged the tiles, you will have created a picture of Dr. Brain's castle. (The empty tile will end up in the bottom right corner.)"
			)
		)
		(proc5_9 120 15) ; "Click on any tile in the same row or column as the empty square to slide it (and its neighbors) into the empty square. You can spend a Hint Coin to get some suggestions on how to solve this puzzle."
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			(or
				(and (<= 0 (event x:) 136) (<= 0 (event y:) 132))
				(& (event type:) $0040) ; direction
			)
			(if (and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
				(= temp0 (event message:))
				(= temp2 (/ (= temp3 (self indexOf: highlightedIcon)) local127))
				(switch temp0
					(JOY_UP
						(if (== (highlightedIcon name:) {icon15})
							(if temp2
								(= temp1 (self at: (- temp3 local127)))
								(if (& (temp1 signal:) $0004)
									(if (> (mod temp3 local127) 1)
										(= temp4 (+ local127 1))
									else
										(= temp4 (- local127 1))
									)
									(= temp1 (self at: (- temp3 temp4)))
								)
							else
								(= temp1 (self at: (- size 3)))
							)
						else
							(= temp1 (self at: (- size 6)))
						)
						(proc5_20 temp1)
						(self highlight: temp1)
					)
					(JOY_DOWN
						(if (== (highlightedIcon name:) {icon15})
							(if (< temp2 3)
								(= temp1 (self at: (+ temp3 local127)))
								(if (& (temp1 signal:) $0004)
									(if (> (mod temp3 local127) 1)
										(= temp4 (- local127 1))
									else
										(= temp4 (+ local127 1))
									)
									(= temp1 (self at: (+ temp3 temp4)))
								)
							else
								(= temp1 (self at: (mod temp3 local127)))
							)
						else
							(= temp1 (self at: 0))
						)
						(proc5_20 temp1)
						(self highlight: temp1)
					)
				)
			)
			(super dispatchEvent: event &rest)
		else
			(event dispose:)
			(return 0)
		)
	)

	(method (advance)
		(super advance: &rest)
		(if (== (highlightedIcon name:) {blankIcon})
			(super advance:)
		)
	)

	(method (retreat)
		(super retreat:)
		(if (== (highlightedIcon name:) {blankIcon})
			(super retreat:)
		)
	)

	(method (animateOnce)
		(if local122
			(self showHelp:)
			(= local122 0)
		)
		(super animateOnce: &rest)
	)
)

(instance blankIcon of IconI
	(properties
		view 165
		loop 2
		cel 0
		signal 132
		maskView 165
		maskLoop 2
	)

	(method (select))

	(method (highlight))
)

(instance icon15 of TextIcon
	(properties
		view 165
		loop 1
		cel 0
		maskView 165
		maskCel 1
		lowlightColor 0
	)

	(method (select &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (and (not local34) (= temp2 (super select: &rest)))
			(= temp1 1)
			(cond
				((not (mod (= temp5 (- value local106)) local127))
					(if (> temp5 0)
						(= temp0 local127)
					else
						(= temp0 (- local127))
					)
					(localproc_3 temp0 value)
				)
				((== (/ value local127) (/ local106 local127))
					(if (> value local106)
						(= temp0 1)
					else
						(= temp0 -1)
					)
					(localproc_3 temp0 value)
				)
				(else
					(gCMusic2 number: 56 setLoop: 1 play:)
					(proc5_9 120 16) ; "You can't move that tile -- it isn't in the same row or column as the blank square."
					(= temp1 0)
				)
			)
			(if temp1
				(= local34 (== [local41 (- local126 1)] 0))
				(for ((= temp4 1)) (< temp4 local126) ((++ temp4))
					(if (!= temp4 [local41 (- temp4 1)])
						(= local34 0)
					)
				)
				(if local34
					(if (== global114 2)
						((= temp3 [local58 (- local126 1)])
							view: 167
							loop: 15
							cel: 0
						)
						(bar15 enable: temp3)
						(temp3 show:)
					)
					(gGame setCursor: 50)
					(for ((= temp4 0)) (< temp4 (- local126 1)) ((++ temp4))
						(gCMusic2 number: 61 setLoop: 1 play:)
						(= temp3 (bar15 at: temp4))
						(if (== global114 2)
							(temp3 maskView: 167 maskLoop: temp4 maskCel: 1)
						)
						(temp3 mask:)
						(Wait 15)
						(temp3 show:)
					)
					(if (== global114 2)
						([local58 15] mask:)
						(Wait 15)
						([local58 15] show:)
					)
					(gCMusic2 number: 50 setLoop: 1 play:)
					(Wait 30)
					(bar15 goAway:)
				)
			)
		)
		(return temp2)
	)

	(method (showText param1 &tmp temp0)
		(if (and (StrLen text) (< global114 2))
			(if (== (StrLen text) 1)
				(= temp0 11)
			else
				(= temp0 9)
			)
			(proc5_8 text param1 (+ nsLeft temp0) (+ nsTop 7))
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (or param1 (< global114 2))
			(if (or (not (& signal $0020)) (& signal $0004))
				(return)
			)
			(= temp4 (if param1 highlightColor else lowlightColor))
			(= temp0 nsTop)
			(= temp1 nsLeft)
			(= temp2 (- nsBottom 2))
			(= temp3 (- nsRight 1))
			(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		else
			(self show:)
		)
	)
)

(instance puzWindow of SysWindow
	(properties
		top 10
		left 150
		bottom 142
		right 286
	)

	(method (open)
		(super open:)
		(DrawCel 165 0 local125 0 local38 15)
	)
)

(instance barMagic of PuzzleBar
	(properties
		iconHeight 21
		puzzleHeight 147
		bottomHeight 0
		hintFlag 34
		solvedFlag 11
	)

	(method (init &tmp temp0 temp1 temp2)
		(= local118 global114)
		(= window puz2Window)
		(puz2Window back: [local0 13])
		(= local38 iconHeight)
		(= local39 (+ iconHeight puzzleHeight 3))
		(= local37 0)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(= [local74 temp0] 0)
		)
		(= local171 [local172 local118])
		(if (== local118 0)
			(= local183 9)
			(= local181 (= local182 3))
			(for ((= temp0 0)) (< temp0 16) ((++ temp0))
				(= [local185 temp0] [local387 temp0])
				(= [local201 temp0] [local397 temp0])
			)
			(= [local347 8] 2)
			(= temp1 170)
			(= local170 170)
			(= local178 74)
			(puz2Window bottom: 151 right: 276)
			(= local175 9)
			(= local184 1)
			(= local249 4)
			(= local250 125)
		else
			(= local170 171)
			(= local175 8)
			(= local184 2)
			(= [local347 8] 3)
			(= local178 91)
			(for ((= temp0 0)) (< temp0 16) ((++ temp0))
				(= [local185 temp0] [local367 temp0])
				(= [local201 temp0] [local377 temp0])
			)
			(= local183 16)
			(= local178 91)
			(= local181 (= local182 4))
			(puz2Window bottom: 179 right: 294)
			(= temp1 171)
			(= local249 local407)
			(= local250 local408)
		)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(if (== local118 2)
				(= [local217 temp0] [local299 temp0])
				(= [local233 temp0] [local331 temp0])
			else
				(= [local217 temp0] [local283 temp0])
				(= [local233 temp0] [local315 temp0])
			)
		)
		(= temp0 0)
		(= temp2 0)
		(while (< temp0 local183)
			(self
				add:
					((iconMagic new:)
						view: temp1
						nsLeft: [local251 temp2]
						nsTop: [local267 temp2]
						text: {}
						highlightColor: [local0 0]
						value: temp2
						yourself:
					)
			)
			(++ temp0)
			(if (and (or (== (++ temp2) 3) (== temp2 7)) (== local118 0))
				(++ temp2)
			)
		)
		(self
			add:
				(dummyIcon
					init:
					nsLeft: local249
					nsTop: local250
					view: temp1
					text: {1}
					value: 0
					maskView: temp1
					yourself:
				)
				(if (== local118 0)
					(theSquares
						init:
						nsTop: 125
						nsLeft: 4
						nsBottom: 135
						nsRight: 116
						yourself:
					)
				else
					((theSquares init:)
						nsLeft: local407
						nsTop: local408
						nsRight: (+ local407 104)
						nsBottom: (+ local408 21)
						yourself:
					)
				)
		)
		(self add: (realDummy init:))
		(super init: &rest)
	)

	(method (show)
		(= highlightedIcon (self at: 0))
		(super show: &rest)
		(if local35
			(self solvePuzzle:)
		)
		(return local35)
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(switch local118
				(0
					(proc5_9 120 17) ; "Each row, column, and diagonal will add up to "15". The center square is used four times (one row, one column, and both diagonals), so you'll want a very "average" number there -- put "5" in the center."
					(proc5_9 120 18) ; "The corners are used three times each, while the sides are each used just twice. So put the "extreme" numbers 1 and 9 opposite each other on the sides. Now work in the rest of the numbers around them to get the correct totals."
				)
				(1
					(proc5_9 120 19) ; "Each row, column, and diagonal will add up to "34". Try to keep the middle-sized numbers near the center of the square. One way to solve this type of magic square is to arrange all the numbers in order, then swap each number on the diagonals with its "complement" (1 with 16, 4 with 13, and so on -- subtract the number from 17 to get the number with which you should swap it)."
				)
				(2
					(proc5_9 120 20) ; "Each row, column, and diagonal will add up to "64". Try to keep the middle-sized numbers near the center of the square. One way to solve this type of magic square is to arrange all the numbers in order, then swap each number on the diagonals with its "complement" (1 with 31, 7 with 25, and so on -- subtract the number from 32 to get the number with which you should swap it)."
				)
			)
		)
	)

	(method (showHelp)
		(proc5_9 120 21) ; "This is a "magic square". Place numbers in the squares such that they add to the same totals across each row, down each column, and along both diagonals. If you get stuck, spend a Hint Coin for some clues on how to solve this type of magic square."
	)

	(method (advance &tmp temp0 temp1 temp2 temp3)
		(= temp1 (self at: (mod (+ 1 (self indexOf: highlightedIcon)) size)))
		(= temp3 0)
		(cond
			((== highlightedIcon dummyIcon)
				(= temp3 1)
				(= temp0 (dummyIcon value:))
			)
			((== temp1 dummyIcon)
				(= temp3 1)
				(= temp0 -1)
			)
		)
		(if temp3
			(while (and (not [local233 (++ temp0)]) (< temp0 local183))
			)
			(if (>= temp0 local183)
				(self highlight: realDummy)
				(super advance: &rest)
			else
				(= temp2 (/ temp0 local175))
				(= eventX (+ (theSquares nsLeft:) (* (- temp0 (* temp2 8)) 13)))
				(= eventY (+ (theSquares nsTop:) 2 (* temp2 11)))
				(gGame setCursor: gTheCursor 1 (+ eventX 6) (+ eventY 8))
				(self highlight: theSquares)
			)
		else
			(super advance: &rest)
		)
	)

	(method (retreat &tmp temp0 temp1 temp2 temp3)
		(= temp2 (self at: (- (self indexOf: highlightedIcon) 1)))
		(= temp3 0)
		(cond
			((and (== highlightedIcon dummyIcon) (dummyIcon value:))
				(= temp3 1)
				(= temp0 (dummyIcon value:))
			)
			((== temp2 realDummy)
				(= temp3 1)
				(= temp0 local183)
			)
		)
		(if temp3
			(while (and (not [local233 (-- temp0)]) (>= temp0 0))
			)
			(if (< temp0 0)
				(= temp0 0)
			)
			(= temp1 (/ temp0 local175))
			(= eventX (+ (theSquares nsLeft:) (* (- temp0 (* temp1 8)) 13)))
			(= eventY (+ (theSquares nsTop:) 2 (* temp1 11)))
			(gGame setCursor: gTheCursor 1 (+ eventX 6) (+ eventY 8))
			(self highlight: theSquares)
		else
			(super retreat: &rest)
		)
	)

	(method (dispatchEvent event &tmp temp0)
		(if (& (event type:) $0040) ; direction
			(switch (event message:)
				(JOY_DOWN
					(cond
						((== (highlightedIcon name:) {iconMagic})
							(if
								(<
									(self indexOf: highlightedIcon)
									(- local183 local182)
								)
								(= temp0
									(self
										at:
											(+
												(self indexOf: highlightedIcon)
												local182
											)
									)
								)
								(self highlight: temp0)
								(proc5_20 temp0)
							else
								(= eventX (theSquares nsLeft:))
								(= eventY (theSquares nsTop:))
								(self highlight: theSquares)
								(proc5_20 dummyIcon)
							)
						)
						((== highlightedIcon dummyIcon)
							(if
								(and
									(==
										(highlightedIcon nsTop:)
										(theSquares nsTop:)
									)
									(!= local118 0)
								)
								(= eventY (+ (highlightedIcon nsTop:) 11))
								(= eventX (highlightedIcon nsLeft:))
								(self highlight: theSquares)
								(proc5_20 dummyIcon)
							else
								(self highlight: realDummy)
								(super advance: &rest)
							)
						)
						(else
							(= temp0 (self at: 0))
							(self highlight: temp0)
							(proc5_20 temp0)
						)
					)
				)
				(JOY_UP
					(cond
						((== (highlightedIcon name:) {iconMagic})
							(if (> (highlightedIcon value:) (- local182 1))
								(= temp0
									(self
										at:
											(-
												(self indexOf: highlightedIcon)
												local182
											)
									)
								)
							else
								(= temp0 (self at: (- size 3)))
							)
							(proc5_20 temp0)
							(self highlight: temp0)
						)
						((== highlightedIcon dummyIcon)
							(if
								(or
									(==
										(highlightedIcon nsTop:)
										(theSquares nsTop:)
									)
									(== local118 0)
									(== dummyIcon local37)
								)
								(super retreat: &rest)
							else
								(= eventY (- (highlightedIcon nsTop:) 11))
								(= eventX (highlightedIcon nsLeft:))
								(self highlight: theSquares)
								(proc5_20 dummyIcon)
							)
						)
						(else
							(= eventY (theSquares nsTop:))
							(if (!= local118 0)
								(+= eventY 11)
							)
							(= eventX (theSquares nsLeft:))
							(self highlight: theSquares)
							(proc5_20 dummyIcon)
						)
					)
				)
			)
		)
		(super dispatchEvent: event &rest)
	)

	(method (animateOnce)
		(if local123
			(self showHelp:)
			(= local123 0)
		)
		(super animateOnce: &rest)
	)
)

(instance theSquares of TextIcon
	(properties
		text {}
	)

	(method (show &tmp temp0 temp1 temp2 temp3)
		(= temp2 (+ nsTop 2))
		(= temp0 0)
		(= temp1 (+ nsLeft 1))
		(while (< temp0 local183)
			(proc5_8 [local217 temp0] [local0 3] temp1 temp2)
			(++ temp0)
			(if (and (> local118 0) (== temp0 8))
				(= temp1 (+ nsLeft 1))
				(+= temp2 11)
				(continue)
			)
			(+= temp1 13)
		)
	)

	(method (highlight &tmp temp0 temp1 temp2)
		(if (!= local37 dummyIcon)
			(= temp2 (/ (- (barMagic eventY:) nsTop) 11))
			(for
				((= temp1 (/ (- (barMagic eventX:) nsLeft) 13)))
				(>= temp1 local175)
				((-- temp1))
			)
			(while (>= temp2 local184)
				(-- temp2)
			)
			(= temp0 (+ temp1 (* temp2 8)))
			(dummyIcon
				nsTop: (+ nsTop (* temp2 11))
				nsLeft: (+ nsLeft (* temp1 13))
				nsBottom: (+ nsTop (* temp2 11) 10)
				nsRight: (+ nsLeft (* temp1 13) 14)
				value: temp0
				highlightColor: [local0 6]
				text: [local217 temp0]
				highlight: 1
			)
		)
	)

	(method (select))
)

(instance realDummy of IconI
	(properties)

	(method (show))

	(method (highlight))

	(method (init))
)

(instance dummyIcon of TextIcon
	(properties
		view 170
		loop 2
		cel 1
		nsLeft 20
		nsTop 142
		maskView 170
		maskLoop 2
		maskCel 2
		lowlightColor 0
		text {1}
	)

	(method (select)
		(cond
			((== local37 self)
				(gCMusic2 number: 61 setLoop: 1 play:)
				(= local37 0)
				(self show:)
			)
			((IsObject local37)
				(gCMusic2 number: 58 setLoop: 1 play:)
				(localproc_6 local37 self)
			)
			(else
				(gCMusic2 number: 59 setLoop: 1 play:)
				(= local37 self)
				(self mask:)
			)
		)
		(return 1)
	)

	(method (mask)
		(DrawCel maskView maskLoop maskCel nsLeft nsTop -1)
		(self showText: [local0 3])
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if param1
			(barMagic highlightedIcon: self)
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
		(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
	)

	(method (showText)
		(proc5_8 text [local0 3] (+ nsLeft 1) (+ nsTop 2))
	)
)

(instance iconMagic of TextIcon
	(properties
		view 170
		loop 1
		cel 1
		maskView 170
		maskLoop 1
		maskCel 2
		lowlightColor 0
		text {}
	)

	(method (select &tmp temp0)
		(if (and (not local35) (= temp0 (super select: &rest)))
			(gCMusic2 number: 58 setLoop: 1 play:)
			(if (not local37)
				(= local37 self)
				(self cel: 2 show:)
			else
				(localproc_6 self local37)
			)
		)
		(return temp0)
	)

	(method (showText param1)
		(if (StrLen text)
			(proc5_8 text param1 (+ nsLeft 3) (+ nsTop 4))
		)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 10
		left 150
	)

	(method (open)
		(super open:)
		(DrawCel local170 0 0 0 local38 15)
		(DrawCel local170 0 1 0 (+ local38 local178) 15)
		(localproc_7)
	)
)

(instance startMath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc5_1)
				(if (client cel:)
					(self changeState: 2)
				else
					(gCMusic2 number: 912 setLoop: 1 play:)
					(client setCycle: End self)
				)
			)
			(1
				(westLight setCel: 1)
				(= cycles 3)
			)
			(2
				(proc5_2)
				(if (not (IsFlag 12))
					(if (!= local119 global114)
						(localproc_1 mathMarvel)
					)
					(if (mathMarvel show:)
						(proc5_1)
						(mathMarvel solvePuzzle:)
						(= local114 (localproc_2 local116 1))
						(= cycles 1)
					else
						(self dispose:)
					)
				else
					(= local36 1)
					(= cycles 1)
				)
			)
			(3
				(proc5_2)
				(localproc_14 local114)
				(self dispose:)
			)
		)
	)
)

(instance mathMarvel of PuzzleBar
	(properties
		iconHeight 21
		puzzleHeight 135
		bottomHeight 0
		solvedFlag 12
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(= local119 global114)
		(= local448 (= local412 0))
		(= window mathWindow)
		(mathWindow back: [local0 13])
		(= local38 iconHeight)
		(= local137 0)
		(mathBox x: 18)
		(= local39 (+ iconHeight puzzleHeight 3))
		(= local136 (* 12 (Random 0 1)))
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(= [local429 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(if (== local119 2)
				(while [local429 (= temp1 (Random 0 11))]
				)
			else
				(= temp3 (- temp0 (mod temp0 4)))
				(while [local429 (= temp1 (Random temp3 (+ temp3 3)))]
				)
			)
			(= [local429 temp1] [local532 (= temp2 (+ temp0 (* local119 12)))])
			(= [local413 temp1] [local496 temp2])
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= [local132 temp0] -1)
		)
		(for ((= temp0 12)) (< temp0 16) ((++ temp0))
			(self
				add:
					((operator new:)
						loop: (- temp0 10)
						cel: 0
						maskLoop: (- temp0 10)
						value: (- temp0 11)
						nsLeft: [local456 temp0]
						nsTop: [local472 temp0]
						highlightColor: [local0 7]
						lowlightColor: [local0 14]
						signal: 129
						yourself:
					)
			)
		)
		(if (== local119 2)
			(localproc_9)
		)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(self
				add:
					((= temp3 (operand new:))
						value: [local429 temp0]
						cel: 0
						text: [local413 temp0]
						nsLeft: [local456 temp0]
						nsTop: [local472 temp0]
						highlightColor: [local0 7]
						lowlightColor: [local0 15]
						textColor: [local0 9]
						signal: 129
						yourself:
					)
			)
		)
		(self
			add:
				(mathOperator
					init:
					nsLeft: [local488 3]
					nsTop: [local492 3]
					loop: 2
					cel: 4
					value: 0
					signal: 129
					yourself:
				)
		)
		(if (!= local119 2)
			(localproc_9)
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(return local36)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super buyClue: &rest)
			(localproc_11)
			(= temp0 (localproc_8 0))
			(= temp2
				[local532 (+ (= temp1 (- (temp0 value:) 1)) (* local119 12))]
			)
			(= temp3 [local532 (+ temp1 (* local119 12) 4)])
			(= temp4 [local532 (+ temp1 (* local119 12) 8)])
			(if (not (= [local449 0] (localproc_8 temp2)))
				(= temp2
					[local532 (+ (= temp5 [local452 temp1]) (* local119 12) 8)]
				)
				(= temp3 [local532 (+ temp5 (* local119 12) 4)])
				(= temp4 [local532 (+ temp5 (* local119 12))])
				(= [local449 0] (localproc_8 temp2))
			)
			(= [local449 1] (localproc_8 temp3))
			(= [local449 2] (localproc_8 temp4))
			(theMusic3 number: 56 setLoop: 1 play:)
			(localproc_12 temp0)
		)
	)

	(method (showHelp)
		(proc5_14 ; "The Math Marvel is one of Dr. Brain's inventions. You need to construct correct addition, subtraction, multiplication, and division problems to get what's in the treasure chest. %s You can buy the answer to the next problem for a Hint Coin."
			120
			23
			(if (< local119 2)
				{Each problem uses one number from each row.}
			else
				{}
			)
		)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(if (== (= temp0 (event type:)) evKEYBOARD)
			(= temp1 (event message:))
			(= temp2 0)
			(cond
				((== temp1 KEY_ADD)
					(= temp2 1)
				)
				((== temp1 KEY_SUBTRACT)
					(= temp2 2)
				)
				((or (== temp1 KEY_x) (== temp1 KEY_X))
					(= temp2 3)
				)
				((== temp1 KEY_DIVIDE)
					(= temp2 4)
				)
			)
			(if temp2
				(self select: (self at: (-- temp2)) 0)
			)
		)
		(if (and (& temp0 $0040) (IsObject highlightedIcon)) ; direction
			(switch (= temp3 (event message:))
				(JOY_UP
					(if (== (highlightedIcon name:) {operand})
						(if (> (highlightedIcon nsTop:) 35)
							(= temp4
								(self
									at:
										(= temp5
											(-
												(self indexOf: highlightedIcon)
												4
											)
										)
								)
							)
							(= temp6 (temp4 nsTop:))
							(if (& (temp4 signal:) $0004)
								(while
									(and
										(==
											((= temp4 (self at: (++ temp5)))
												nsTop:
											)
											temp6
										)
										(& (temp4 signal:) $0004)
									)
								)
							)
							(if
								(or
									(& (temp4 signal:) $0004)
									(!= (temp4 nsTop:) temp6)
								)
								(highlightedIcon highlight: 0)
								(self highlightedIcon: temp4)
								(self retreat:)
							else
								(proc5_20 temp4)
								(self highlight: temp4)
							)
						else
							(if (== local119 2)
								(= temp4 [local409 2])
							else
								(= temp4 (self at: 3))
							)
							(proc5_20 temp4)
							(self highlight: temp4)
						)
					else
						(self retreat:)
					)
				)
				(JOY_DOWN
					(if (== (highlightedIcon name:) {operand})
						(if (< (highlightedIcon nsTop:) 85)
							(= temp4
								(self
									at:
										(= temp5
											(+
												(self indexOf: highlightedIcon)
												4
											)
										)
								)
							)
							(= temp6 (temp4 nsTop:))
							(if (& (temp4 signal:) $0004)
								(while
									(and
										(==
											((= temp4 (self at: (-- temp5)))
												nsTop:
											)
											temp6
										)
										(not (& (temp4 signal:) $0004))
									)
								)
							)
							(if
								(or
									(& (temp4 signal:) $0004)
									(!= (temp4 nsTop:) temp6)
								)
								(highlightedIcon highlight: 0)
								(self highlightedIcon: temp4)
								(self advance:)
							else
								(proc5_20 temp4)
								(self highlight: temp4)
							)
						else
							(= temp5 (self indexOf: highlightedIcon))
							(while (== ((self at: (++ temp5)) name:) {operand})
							)
							(proc5_20 (= temp4 (self at: temp5)))
							(self highlight: temp4)
						)
					else
						(self advance:)
					)
				)
				(JOY_RIGHT
					(if (== (highlightedIcon name:) {operator})
						(cond
							((!= local119 2)
								(if
									(>
										(= temp5
											(*
												(+
													(self
														indexOf: highlightedIcon
													)
													1
												)
												4
											)
										)
										12
									)
									(= temp5 12)
								)
							)
							(
								(>
									(= temp5
										(+ (self indexOf: highlightedIcon) 4)
									)
									6
								)
								(= temp5 6)
							)
						)
						(= temp4 (self at: temp5))
						(if (& (temp4 signal:) $0004)
							(highlightedIcon highlight: 0)
							(self highlightedIcon: temp4)
							(self advance:)
						else
							(proc5_20 temp4)
							(self highlight: temp4)
						)
						(event message: JOY_DOWN)
					)
				)
				(JOY_LEFT
					(if (== (highlightedIcon name:) {operand})
						(if (== (highlightedIcon nsLeft:) 99)
							(= temp5 (/ (- (highlightedIcon nsTop:) 35) 25))
							(if (== local119 2)
								(+= temp5 4)
							)
							(= temp4 (self at: temp5))
							(proc5_20 temp4)
							(self highlight: temp4)
							(event message: JOY_UP)
						else
							(= temp5 (- (self indexOf: highlightedIcon) 1))
							(= temp6 (highlightedIcon nsTop:))
							(while
								(and
									(&
										((= temp4 (self at: temp5)) signal:)
										$0004
									)
									(== (temp4 nsTop:) temp6)
								)
								(-- temp5)
							)
							(if (!= (temp4 nsTop:) temp6)
								(= temp5 (/ (- (highlightedIcon nsTop:) 35) 25))
								(if (== local119 2)
									(+= temp5 4)
								)
								(= temp4 (self at: temp5))
								(proc5_20 temp4)
								(self highlight: temp4)
								(event message: JOY_UP)
							)
						)
					)
				)
			)
		)
		(super dispatchEvent: event)
	)

	(method (animateOnce)
		(if local124
			(self showHelp:)
			(= local124 0)
		)
		(return 0)
	)
)

(instance operand of TextIcon
	(properties
		view 140
		loop 1
		cel 0
		maskView 140
		maskLoop 1
		maskCel 2
		text {}
	)

	(method (select &tmp temp0 temp1)
		(if (= temp0 (super select:))
			(gCMusic2 number: 59 setLoop: 1 play:)
			(if (== local119 2)
				(cond
					((not local412)
						(self cel: 1 show:)
						(= local412 self)
					)
					((!= local412 self)
						(local412 cel: 0 show:)
						(self cel: 1 show:)
						(= local412 self)
					)
					(else
						(self cel: 0 show:)
						(= local412 0)
					)
				)
			else
				(cond
					((not [local445 (= temp1 (/ (- nsTop 35) 25))])
						([local409 temp1] value: value text: text show:)
						(self mask: signal: (| signal $0004))
						(= [local445 temp1] self)
					)
					((== [local445 temp1] self)
						([local409 temp1]
							value: 0
							loop: 1
							cel: 3
							text: {}
							show:
						)
						(= [local445 temp1] 0)
						(self signal: (& signal $fffb) cel: 0 show:)
					)
					(else
						([local409 temp1] value: value text: text show:)
						(self mask: signal: (| signal $0004))
						([local445 temp1]
							signal: (& ([local445 temp1] signal:) $fffb)
							cel: 0
							show:
						)
						(= [local445 temp1] self)
					)
				)
				(localproc_10)
			)
		)
		(return temp0)
	)

	(method (showText param1 &tmp temp0 [temp1 2] temp3)
		(if (not (& signal $0004))
			(= temp0 (StrLen text))
			(= temp1 0)
			(for ((= temp3 0)) (< temp3 temp0) ((++ temp3))
				(StrAt @temp1 0 (StrAt text temp3))
				(proc5_8 @temp1 param1 (+ nsLeft (* temp3 7) 1) (+ nsTop 2))
			)
		)
	)
)

(instance selOperand of TextIcon
	(properties
		view 140
		loop 1
		cel 3
		maskView 140
		maskLoop 1
		maskCel 3
		text {}
	)

	(method (show)
		(DrawCel view loop cel nsLeft nsTop 15)
		(self showText: [local0 2])
	)

	(method (select &tmp temp0)
		(gCMusic2 number: 60 setLoop: 1 play:)
		(if local412
			(for ((= temp0 0)) (!= [local409 temp0] self) ((++ temp0))
			)
			(self value: (local412 value:) text: (local412 text:) show:)
			(if [local445 temp0]
				([local445 temp0]
					signal: (& ([local445 temp0] signal:) $fffb)
					cel: 0
					show:
				)
			)
			(local412 mask: signal: (| (local412 signal:) $0004))
			(= [local445 temp0] local412)
			(= local412 0)
			(localproc_10)
		)
	)

	(method (showText param1 &tmp temp0 [temp1 2] temp3)
		(= temp0 (StrLen text))
		(for ((= temp3 0)) (< temp3 temp0) ((++ temp3))
			(StrAt @temp1 0 (StrAt text temp3))
			(proc5_8 @temp1 param1 (+ nsLeft (* temp3 8) 4) (+ nsTop 6))
		)
	)
)

(instance mathBox of View
	(properties
		x 18
		y 113
		view 140
		loop 6
		priority 14
		signal 16400
	)
)

(instance operator of CodeIcon
	(properties
		view 140
		cel 0
		maskView 140
		maskCel 3
	)

	(method (select &tmp temp0)
		(if (= temp0 (super select:))
			(gCMusic2 number: 58 setLoop: 1 play:)
			(if (not local448)
				(mathOperator value: value loop: loop cel: 2 show:)
			else
				(local448 signal: (& (local448 signal:) $fffb) cel: 0 show:)
			)
			(mathOperator value: value loop: loop cel: 2 show:)
			(self mask: signal: (| signal $0004))
			(= local448 self)
			(localproc_10)
		)
		(return temp0)
	)
)

(instance mathOperator of CodeIcon
	(properties
		view 140
		loop 2
		cel 4
		maskView 140
		maskLoop 2
		maskCel 3
	)

	(method (select))

	(method (highlight))
)

(instance mathWindow of SysWindow
	(properties
		top 19
		left 37
		bottom 174
		right 271
	)

	(method (open)
		(super open:)
		(DrawCel 140 0 0 0 local38 15)
		(DrawCel 140 0 1 0 (+ local38 88) 15)
		(DrawCel 140 2 4 [local488 3] [local492 3] 15)
		(DrawCel 140 6 0 (mathBox x:) (mathBox y:) 15)
		(Graph
			grUPDATE_BOX
			(mathBox x:)
			(mathBox y:)
			(+ (mathBox y:) 11)
			(+ (mathBox x:) 14)
			1
		)
		(localproc_0)
	)
)

(instance symbol_a of CodeIcon
	(properties
		name {symbol}
		view 388
		loop 1
		cel 0
	)

	(method (select)
		(if (and (< local580 110) (super select: &rest))
			(gCMusic2 number: (+ 900 value) setLoop: 1 play:)
			(= local580 (+ (* local580 10) (mod (+ value 1) 10)))
			(localproc_13)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& signal $0020))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (+ nsTop 2))
		(= temp1 (+ nsLeft 2))
		(= temp2 (- nsBottom 3))
		(= temp3 (- nsRight 3))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)
)

(instance symbol_b of TextIcon
	(properties
		name {symbol}
		view 150
		loop 2
		cel 0
		nsLeft 37
		nsTop 117
		nsRight 76
		nsBottom 133
		cursor 20
		text {Enter}
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(gCMusic2 number: 910 setLoop: 1 play:)
			(= temp0 local580)
			(= local580 0)
			(if
				(or
					(not
						(= local581
							(and
								local581
								(== temp0 [local638 [global167 local582]])
							)
						)
					)
					(>= (++ local582) 3)
				)
				(if (= local568 local581)
					(gCMusic2 number: 51 setLoop: 1 play:)
					(proc5_9 120 27) ; "Great! You unlocked the door!"
					(SetFlag 32)
				else
					(proc5_9 120 28) ; "Nothing happens. That must not have been the correct combination."
					(= local581 1)
				)
				(backDoorLock goAway:)
			else
				(gCMusic2 number: 51 setLoop: 1 play:)
				(proc5_9 120 29) ; "You hear a "Click!". You figured out part of the combination. Good going!"
				(localproc_13)
			)
		)
	)

	(method (showText param1)
		(proc5_8 text param1 (+ nsLeft 4) (+ nsTop 4))
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(if (not (& signal $0020))
			(return)
		)
		(= temp4 (if (and argc param1) highlightColor else lowlightColor))
		(= temp0 (+ nsTop 2))
		(= temp1 (+ nsLeft 2))
		(= temp2 (- nsBottom 3))
		(= temp3 (- nsRight 3))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)
)

(instance backDoorLock of PuzzleBar
	(properties
		puzzleHeight 121
		bottomHeight 0
	)

	(method (init &tmp temp0)
		(= window DOORWINdow)
		(DOORWINdow back: [local0 13])
		(= local580 (= local582 0))
		(= local581 1)
		(= local579 iconHeight)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(self
				add:
					((= [local569 temp0] (symbol_a new:))
						loop: temp0
						value: temp0
						nsLeft: [local583 temp0]
						nsTop: [local593 temp0]
						highlightColor: [local0 7]
						lowlightColor: [local0 10]
						yourself:
					)
			)
		)
		(self
			add:
				(symbol_b
					highlightColor: [local0 7]
					lowlightColor: [local0 10]
					textColor: [local0 9]
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(return local568)
	)

	(method (buyClue)
		(cond
			((>= local121 2)
				(proc5_9 120 30) ; "It appears that the previous hint coin got stuck in the slot."
			)
			((super buyClue: &rest)
				(theMusic3 number: 56 setLoop: 1 play:)
				(localproc_2 local582 0)
				(= local580 [local638 [global167 local582]])
				(localproc_13)
				(++ local121)
			)
		)
	)

	(method (showHelp)
		(proc5_9 120 31) ; "This is the security lock for the castle. Each time you solve one of the hallway puzzles, you will learn another code word from the combination. Using your Ultra Top Secret Decoder Grid, find the symbols which represent each code word, then key in the symbols in the correct order to open the lock. Click on ENTER (or press E) after each set of symbols."
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if (and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
			(= temp0 (event message:))
			(= temp2 (/ (= temp3 (self indexOf: highlightedIcon)) 3))
			(switch temp0
				(JOY_UP
					(if (== (highlightedIcon name:) {symbol})
						(if temp2
							(= temp1 (self at: (- temp3 3)))
						else
							(= temp1 (self at: (- size 3)))
						)
					else
						(= temp1 (self at: 10))
					)
					(proc5_20 temp1)
					(self highlight: temp1)
				)
				(JOY_DOWN
					(if (== (highlightedIcon name:) {symbol})
						(cond
							((< temp3 8)
								(= temp1 (self at: (+ temp3 3)))
							)
							((== temp3 8)
								(= temp1 (self at: (+ temp3 2)))
							)
							(else
								(= temp1 (self at: (mod temp3 3)))
							)
						)
					else
						(= temp1 (self at: 0))
					)
					(proc5_20 temp1)
					(self highlight: temp1)
				)
			)
		)
		(super dispatchEvent: event &rest)
	)
)

(instance DOORWINdow of SysWindow
	(properties
		top 30
		left 75
		bottom 185
		right 167
	)

	(method (open)
		(super open:)
		(DrawCel 150 0 0 3 (+ local579 2) 15)
		(localproc_13)
	)
)

(instance theMusic3 of Sound
	(properties)
)

