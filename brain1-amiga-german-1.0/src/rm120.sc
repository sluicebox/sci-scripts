;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Interface)
(use Language)
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
	[local0 19] = [18 27 30 30 26 23 20 18 28 18 20 30 26 24 28 30 30 23 26]
	[local19 19] = [18 27 30 30 26 23 20 18 28 18 20 30 26 24 28 30 30 23 26]
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45 = {}
	[local46 17]
	[local63 16]
	[local79 32]
	local111
	local112
	local113
	local114
	[local115 3] = [{first} {second} {third}]
	local118
	local119
	local120
	local121
	local122 = 1
	local123
	local124
	local125
	local126
	local127 = 1
	local128 = 1
	local129 = 1
	local130
	local131
	local132
	[local133 4]
	[local137 4]
	local141
	local142
	[local143 16] = [6 37 68 99 6 37 68 99 6 37 68 99 6 37 68 99]
	[local159 16] = [30 30 30 30 54 54 54 54 78 78 78 78 102 102 102 102]
	local175 = 171
	local176
	[local177 3] = [15 34 64]
	local180 = 8
	[local181 2]
	local183
	[local184 2] = [47 8]
	local186
	local187
	local188
	local189 = 2
	[local190 16]
	[local206 16]
	[local222 16]
	[local238 16]
	local254
	local255
	[local256 16] = [8 32 56 80 8 32 56 80 8 32 56 80 8 32 56 80]
	[local272 16] = [46 46 46 46 63 63 63 63 80 80 80 80 97 97 97 97]
	[local288 16] = [{1} {2} {3} {4} {5} {6} {7} {8} {9} {10} {11} {12} {13} {14} {15} {16}]
	[local304 16] = [{1} {3} {5} {7} {9} {11} {13} {15} {17} {19} {21} {23} {25} {27} {29} {31}]
	[local320 16] = [1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16]
	[local336 16] = [1 3 5 7 9 11 13 15 17 19 21 23 25 27 29 31]
	[local352 10] = [0 4 8 12 0 1 2 3 3 0]
	[local362 10] = [1 1 1 1 4 4 4 4 3 5]
	[local372 10] = [112 112 112 112 10 34 58 82 112 112]
	[local382 10] = [49 66 83 100 120 120 120 120 30 117]
	[local392 10] = [94 94 94 0 10 34 58 0 94 94]
	[local402 10] = [51 68 85 0 104 104 104 0 33 103]
	local412 = 20
	local413 = 142
	[local414 3]
	local417
	[local418 16]
	[local434 16]
	[local450 3]
	local453
	[local454 3]
	[local457 4] = [1 0 3 2]
	[local461 16] = [98 132 166 200 98 132 166 200 98 132 166 200 11 11 11 11]
	[local477 16] = [35 35 35 35 60 60 60 60 85 85 85 85 31 51 71 91]
	[local493 4] = [58 58 58 35]
	[local497 4] = [31 53 87 57]
	[local501 36] = [{11} {90} {42} {60} {22} {80} {02} {20} {33} {10} {84} {03} {12} {99} {22} {56} {23} {33} {04} {08} {35} {66} {88} {07} {12} {65} {11} {75} {18} {44} {08} {15} {30} {21} {88} {05}]
	[local537 36] = [11 90 42 60 22 80 2 20 33 10 84 3 12 99 22 56 23 33 4 8 35 66 88 7 12 65 11 75 18 44 8 15 30 21 88 5]
	local573
	[local574 10]
	local584
	local585
	local586 = 1
	local587
	[local588 10] = [17 38 59 17 38 59 17 38 59 17]
	[local598 20] = [54 54 54 75 75 75 96 96 96 117 {0} {1} {2} {3} {4} {5} {6} {7} {8} {9}]
	[local618 25] = [{Backgammon} {Baseball} {Basketball} {Billiards} {Blackjack} {Bowling} {Bridge} {Checkers} {Chess} {Cribbage} {Dominos} {Football} {Golf} {Hearts} {Hockey} {Horseshoes} {Jacks} {Jigsaw} {Poker} {Pool} {Puzzle} {Soccer} {Spades} {Tennis} {Tic-Tac-Toe}]
	[local643 25] = [129 147 161 183 197 229 247 261 283 297 329 347 361 383 397 529 547 561 583 597 729 747 761 783 797]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (!= [local137 temp0] -1)
			(proc5_8
				[local133 temp0]
				[local0 11]
				[local493 temp0]
				[local497 temp0]
				[local0 12]
			)
		)
	)
	(if (!= (= temp0 [local137 3]) -1)
		(DrawCel
			140
			((mathMarvel at: temp0) loop:)
			2
			[local493 3]
			[local497 3]
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
		(++ local121)
	)
	(return param1)
)

(procedure (localproc_3 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 2])
	(= temp1 1)
	(while temp1
		(= temp2 [local63 local111])
		(= temp3 [local63 (= temp4 (+ local111 param1))])
		(= [local46 local111] [local46 temp4])
		(= [local46 temp4] 0)
		(temp2
			view: (temp3 view:)
			loop: (temp3 loop:)
			cel: 0
			text: (temp3 text:)
		)
		(temp3
			view: 165
			loop: 0
			cel: 1
			text: local45
			signal: (| (temp3 signal:) $0004)
		)
		(bar15 enable: temp2)
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
		(= local111 temp4)
		(Wait 0)
		(Wait 5)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2 temp3)
	(while
		(or
			(not (= temp1 (localproc_5 (= temp0 (Random 0 (- local131 1))))))
			(== temp0 param1)
		)
	)
	(= temp2 (+ temp0 temp1))
	(= temp3 [local46 temp0])
	(= [local46 temp0] [local46 temp2])
	(= [local46 temp2] temp3)
	(= local111 temp0)
	(return temp2)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(= temp1
		(cond
			((and (mod param1 local132) (not [local46 (- param1 1)])) -1)
			((and (>= param1 local132) (not [local46 (- param1 local132)]))
				(- local132)
			)
			((and (mod (+ param1 1) local132) (not [local46 (+ param1 1)])) 1)
			(
				(and
					(< param1 (- local131 local132))
					(not [local46 (+ param1 local132)])
				)
				local132
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
		(= temp1 [local238 (= temp2 (param2 value:))])
		(= [local222 temp2] temp0)
		(= [local238 temp2] [local79 (param1 value:)])
	else
		(= temp1 [local79 (= temp2 (param2 value:))])
		(= [local79 temp2] [local79 (param1 value:)])
	)
	(= [local79 (param1 value:)] temp1)
	(theMusic3 number: 60 setLoop: 1 play:)
	(param1 show:)
	(param2 show:)
	(= local41 0)
	(localproc_7)
)

(procedure (localproc_7 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 [temp8 2])
	(= temp4 1)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(= temp3 0)
		(= temp6 [local352 temp0])
		(for ((= temp7 0)) (< temp7 4) ((++ temp7))
			(+= temp3 [local79 temp6])
			(+= temp6 [local362 temp0])
		)
		(if (not (and (or (== temp0 3) (== temp0 7)) (== local123 0)))
			(= temp1 [local190 temp0])
			(= temp2 [local206 temp0])
			(if (!= temp3 local176)
				(= temp4 0)
			)
			(Graph grFILL_BOX temp2 temp1 (+ temp2 8) (+ temp1 17) 1 [local0 1] -1 -1)
			(Graph grUPDATE_BOX temp2 temp1 (+ temp2 8) (+ temp1 17) 1)
			(proc5_8
				(Format @temp8 120 26 temp3) ; "%2d"
				[local0 2]
				(+ temp1 1)
				(+ temp2 1)
			)
		)
	)
	(if (and temp4 (not local39))
		(= local39 1)
		(gGame setCursor: 50)
		(Wait 0)
		(for ((= temp0 0)) (< temp0 local188) ((++ temp0))
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
				((= [local414 temp0] (selOperand new:))
					nsLeft: [local493 temp0]
					nsTop: [local497 temp0]
					cel: 3
					nsRight: (+ [local493 temp0] 27)
					highlightColor: [local0 7]
					lowlightColor: [local0 8]
					textColor: [local0 9]
					nsBottom: (+ [local497 temp0] 19)
					value: 0
					text: {}
					signal: 129
					maskCel: temp0
					yourself:
				)
		)
		(= [local450 temp0] 0)
	)
)

(procedure (localproc_10 &tmp temp0 temp1 temp2 temp3 temp4)
	(if
		(and
			([local414 0] value:)
			([local414 1] value:)
			([local414 2] value:)
			(mathOperator value:)
		)
		(= temp1 0)
		(= temp2 ([local414 0] value:))
		(= temp3 ([local414 1] value:))
		(= temp4 ([local414 2] value:))
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
			(++ local142)
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				([local414 temp0] value: 0 loop: 1 cel: 3 text: {} show:)
				(= [local450 temp0] 0)
			)
			(mathOperator loop: 2 cel: 4 value: 0 show:)
			(= local453 0)
			(DrawCel 140 6 2 (mathBox x:) (mathBox y:) 15)
			(mathBox x: (+ (mathBox x:) 41))
			(DrawCel 140 6 0 (mathBox x:) (mathBox y:) 15)
		else
			(gCMusic2 number: 54 setLoop: 1 play:)
			(Wait 0)
			(Wait 30)
			(proc5_9 120 28)
			(localproc_11)
		)
		(if (== local142 4)
			(= local40 1)
			(proc5_9 120 29)
			(DrawCel 140 6 2 (mathBox x:) (mathBox y:) 15)
			(mathBox x: (- (mathBox x:) 3))
			(mathBox y: (- (mathBox y:) 10))
			(DrawCel 140 6 1 (mathBox x:) (mathBox y:) 15)
			(DrawCel 140 6 3 (+ (mathBox x:) 14) (+ (mathBox y:) 16) 15)
			(theMusic3 number: 52 setLoop: 1 play:)
			(proc5_9 120 30)
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
		(if ([local414 temp0] value:)
			([local414 temp0] value: 0 loop: 1 cel: 3 text: {} show:)
			([local450 temp0]
				signal: (& ([local450 temp0] signal:) $fffb)
				cel: 0
				show:
			)
		)
		(= [local450 temp0] 0)
	)
	(if (mathOperator value:)
		(mathOperator loop: 2 cel: 4 value: 0 show:)
		(local453 signal: (& (local453 signal:) $fffb) cel: 0 show:)
	)
)

(procedure (localproc_12 param1 &tmp temp0)
	(mathMarvel select: param1 0)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(Wait 0)
		(Wait 10)
		(mathMarvel select: [local454 temp0] 0)
		(if (== local124 2)
			(mathMarvel select: [local414 temp0] 0)
		)
	)
)

(procedure (localproc_13 &tmp [temp0 5])
	(Graph grFILL_BOX 37 21 49 75 1 [local0 4] -1 -1)
	(if local585
		(if (>= local585 10)
			(if (>= local585 100)
				(DrawCel 388 (mod (+ (/ local585 100) 9) 10) 2 28 37 15)
			)
			(DrawCel 388 (mod (+ (/ local585 10) 9) 10) 2 44 37 15)
		)
		(DrawCel 388 (mod (+ local585 9) 10) 2 60 37 15)
	)
	(proc5_8 (Format @temp0 120 36 (+ local587 1)) [local0 16] 21 38 -1 gUserFont) ; "%d"
	(Graph grUPDATE_BOX 37 21 49 75 1)
)

(procedure (localproc_14 param1)
	(if 1
		(= global408 (Memory memALLOC_CRIT (StrLen [local115 param1])))
		(= global409 (Memory memALLOC_CRIT (StrLen [local115 param1])))
		(StrSplitInTwo global408 global409 [local115 param1])
		(proc5_14
			120
			37
			global408
			[local618 [global167 param1]]
			global409
			[local618 [global167 param1]]
		)
		(Memory memFREE global408)
		(Memory memFREE global409)
	)
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
			(for ((= temp0 0)) (< temp0 19) ((++ temp0))
				(= [local0 temp0] [local19 temp0])
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
			(= local120 (localproc_2 local121 1))
		)
		(if (not (IsFlag 11))
			(barMagic init:)
		else
			(= local118 (localproc_2 local121 1))
		)
		(if (not (IsFlag 12))
			(mathMarvel init:)
		else
			(= local119 (localproc_2 local121 1))
		)
		(if (IsFlag 32)
			(= local573 1)
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
			(proc5_9 120 0)
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
			(proc5_9 120 1)
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
			(proc5_9 120 2)
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
						(localproc_14 local120)
					)
					(else
						(proc5_9 120 3)
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
						(localproc_14 local119)
					)
					(else
						(proc5_14
							120
							4
							(if (< local124 2)
								{Each problem uses one number from each row.}
							else
								{}
							)
							(if (< local124 2)
								{Jede Aufgabe braucht eine Zahl aus jeder Reihe.}
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
						(localproc_14 local118)
					)
					(else
						(proc5_9 120 5)
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
				(local573
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
				(proc5_9 120 6)
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
					(if (!= local125 global114)
						(bar15 dispose:)
						(bar15 init:)
					)
					(if (bar15 show:)
						(proc5_1)
						(= local120 (localproc_2 local121 1))
						(= cycles 1)
					else
						(self dispose:)
					)
				else
					(= local38 1)
					(= cycles 1)
				)
			)
			(3
				(proc5_2)
				(localproc_14 local120)
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
					(if (!= local123 global114)
						(localproc_1 barMagic)
					)
					(if (barMagic show:)
						(proc5_1)
						(= local118 (localproc_2 local121 1))
						(= cycles 1)
					else
						(self dispose:)
					)
				else
					(= local39 1)
					(= cycles 1)
				)
			)
			(3
				(proc5_2)
				(localproc_14 local118)
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
		(= local125 global114)
		(= window puzWindow)
		(puzWindow back: [local0 13])
		(= local43 iconHeight)
		(= local44 (+ iconHeight puzzleHeight 3))
		(switch local125
			(0
				(= local131 9)
				(= local132 3)
				(= local130 2)
				(puzWindow right: 255 bottom: 118)
			)
			(1
				(= local131 16)
				(= local132 4)
				(= local130 0)
				(puzWindow right: 286 bottom: 142)
			)
			(else
				(= local131 16)
				(= local132 4)
				(= local130 0)
				(puzWindow right: 286 bottom: 142)
			)
		)
		(for ((= temp0 0)) (< temp0 local131) ((++ temp0))
			(= [local46 temp0] (mod (+ temp0 1) local131))
		)
		(= [local46 local131] 0)
		(= temp0 (+ 100 (Random 1 (* global164 3))))
		(= temp1 -1)
		(while temp0
			(= temp1 (localproc_4 temp1))
			(-- temp0)
		)
		(= temp0 0)
		(= temp4 0)
		(while (< temp0 local131)
			(if (= temp1 [local46 temp0])
				(= temp2 [local288 (- temp1 1)])
			else
				(= temp2 local45)
			)
			(= temp3
				((icon15 new:)
					text: temp2
					value: temp0
					nsLeft: [local143 temp4]
					nsTop: [local159 temp4]
					textColor: [local0 17]
					highlightColor: [local0 7]
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
			(self add: (= [local63 temp0] temp3))
			(++ temp0)
			(++ temp4)
			(if (and (== local125 0) (or (== temp0 3) (== temp0 6)))
				(++ temp4)
			)
		)
		(self add: blankIcon)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(if local38
			(self solvePuzzle:)
		)
		(return local38)
	)

	(method (buyClue)
		(if (or local113 (super buyClue: &rest))
			(if (== local125 2)
				(if local122
					(if (IsFlag 0)
						(proc5_9 120 7)
					else
						(proc5_9 120 8)
					)
					(= local122 0)
				)
				(Print 120 9 #icon 167 0 2 #at 4 6)
			else
				(if (== (gGame printLang:) 1)
					(proc5_9 120 10)
				else
					(proc5_9 120 11)
				)
				(if (!= local125 0)
					(if (== (gGame printLang:) 1)
						(proc5_9 120 12)
					else
						(proc5_9 120 13)
					)
				)
			)
			(= local113 1)
		)
	)

	(method (showHelp)
		(proc5_9 120 14)
		(switch local125
			(0
				(proc5_9 120 15)
			)
			(1
				(proc5_9 120 16)
			)
			(else
				(if (IsFlag 0)
					(proc5_9 120 17)
				else
					(proc5_9 120 18)
				)
			)
		)
		(proc5_9 120 19)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4)
		(if
			(or
				(and (<= 0 (event x:) 136) (<= 0 (event y:) 132))
				(& (event type:) $0040) ; direction
			)
			(if (and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
				(= temp0 (event message:))
				(= temp2 (/ (= temp3 (self indexOf: highlightedIcon)) local132))
				(switch temp0
					(JOY_UP
						(if (== (highlightedIcon name:) {icon15})
							(if temp2
								(= temp1 (self at: (- temp3 local132)))
								(if (& (temp1 signal:) $0004)
									(if (> (mod temp3 local132) 1)
										(= temp4 (+ local132 1))
									else
										(= temp4 (- local132 1))
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
								(= temp1 (self at: (+ temp3 local132)))
								(if (& (temp1 signal:) $0004)
									(if (> (mod temp3 local132) 1)
										(= temp4 (- local132 1))
									else
										(= temp4 (+ local132 1))
									)
									(= temp1 (self at: (+ temp3 temp4)))
								)
							else
								(= temp1 (self at: (mod temp3 local132)))
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
		(if local127
			(self showHelp:)
			(= local127 0)
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
		(if (and (not local38) (= temp2 (super select: &rest)))
			(= temp1 1)
			(cond
				((not (mod (= temp5 (- value local111)) local132))
					(if (> temp5 0)
						(= temp0 local132)
					else
						(= temp0 (- local132))
					)
					(localproc_3 temp0 value)
				)
				((== (/ value local132) (/ local111 local132))
					(if (> value local111)
						(= temp0 1)
					else
						(= temp0 -1)
					)
					(localproc_3 temp0 value)
				)
				(else
					(gCMusic2 number: 56 setLoop: 1 play:)
					(proc5_9 120 20)
					(= temp1 0)
				)
			)
			(if temp1
				(= local38 (== [local46 (- local131 1)] 0))
				(for ((= temp4 1)) (< temp4 local131) ((++ temp4))
					(if (!= temp4 [local46 (- temp4 1)])
						(= local38 0)
					)
				)
				(if local38
					(if (== global114 2)
						((= temp3 [local63 (- local131 1)])
							view: 167
							loop: 15
							cel: 0
						)
						(bar15 enable: temp3)
						(temp3 show:)
					)
					(gGame setCursor: 50)
					(for ((= temp4 0)) (< temp4 (- local131 1)) ((++ temp4))
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
						([local63 15] mask:)
						(Wait 15)
						([local63 15] show:)
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
			(if (< global114 2)
				(= temp2 (- nsBottom 2))
			else
				(= temp2 (- nsBottom 1))
			)
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
		(DrawCel 165 0 local130 0 local43 15)
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
		(= local123 global114)
		(= window puz2Window)
		(puz2Window back: [local0 13])
		(= local42 iconHeight)
		(= local44 (+ iconHeight puzzleHeight 3))
		(= local41 0)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(= [local79 temp0] 0)
		)
		(= local176 [local177 local123])
		(if (== local123 0)
			(= local188 9)
			(= local186 (= local187 3))
			(for ((= temp0 0)) (< temp0 16) ((++ temp0))
				(= [local190 temp0] [local392 temp0])
				(= [local206 temp0] [local402 temp0])
			)
			(= [local352 8] 2)
			(= temp1 170)
			(= local175 170)
			(= local183 74)
			(puz2Window bottom: 151 right: 276)
			(= local180 9)
			(= local189 1)
			(= local254 4)
			(= local255 125)
		else
			(= local175 171)
			(= local180 8)
			(= local189 2)
			(= [local352 8] 3)
			(= local183 91)
			(for ((= temp0 0)) (< temp0 16) ((++ temp0))
				(= [local190 temp0] [local372 temp0])
				(= [local206 temp0] [local382 temp0])
			)
			(= local188 16)
			(= local183 91)
			(= local186 (= local187 4))
			(puz2Window bottom: 179 right: 294)
			(= temp1 171)
			(= local254 local412)
			(= local255 local413)
		)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(if (== local123 2)
				(= [local222 temp0] [local304 temp0])
				(= [local238 temp0] [local336 temp0])
			else
				(= [local222 temp0] [local288 temp0])
				(= [local238 temp0] [local320 temp0])
			)
		)
		(= temp0 0)
		(= temp2 0)
		(while (< temp0 local188)
			(self
				add:
					((iconMagic new:)
						view: temp1
						nsLeft: [local256 temp2]
						nsTop: [local272 temp2]
						text: {}
						textColor: [local0 17]
						highlightColor: [local0 0]
						value: temp2
						yourself:
					)
			)
			(++ temp0)
			(if (and (or (== (++ temp2) 3) (== temp2 7)) (== local123 0))
				(++ temp2)
			)
		)
		(self
			add:
				(dummyIcon
					init:
					nsLeft: local254
					nsTop: local255
					view: temp1
					text: {1}
					value: 0
					maskView: temp1
					yourself:
				)
				(if (== local123 0)
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
						nsLeft: local412
						nsTop: local413
						nsRight: (+ local412 104)
						nsBottom: (+ local413 21)
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
		(if local39
			(self solvePuzzle:)
		)
		(return local39)
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(switch local123
				(0
					(proc5_9 120 21)
					(proc5_9 120 22)
				)
				(1
					(proc5_9 120 23)
				)
				(2
					(proc5_9 120 24)
				)
			)
		)
	)

	(method (showHelp)
		(proc5_9 120 25)
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
			(while (and (not [local238 (++ temp0)]) (< temp0 local188))
			)
			(if (>= temp0 local188)
				(self highlight: realDummy)
				(super advance: &rest)
			else
				(= temp2 (/ temp0 local180))
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
				(= temp0 local188)
			)
		)
		(if temp3
			(while (and (not [local238 (-- temp0)]) (>= temp0 0))
			)
			(if (< temp0 0)
				(= temp0 0)
			)
			(= temp1 (/ temp0 local180))
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
									(- local188 local187)
								)
								(= temp0
									(self
										at:
											(+
												(self indexOf: highlightedIcon)
												local187
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
									(!= local123 0)
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
							(if (> (highlightedIcon value:) (- local187 1))
								(= temp0
									(self
										at:
											(-
												(self indexOf: highlightedIcon)
												local187
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
									(== local123 0)
									(== dummyIcon local41)
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
							(if (!= local123 0)
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
		(if local128
			(self showHelp:)
			(= local128 0)
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
		(while (< temp0 local188)
			(proc5_8 [local222 temp0] [local0 3] temp1 temp2)
			(++ temp0)
			(if (and (> local123 0) (== temp0 8))
				(= temp1 (+ nsLeft 1))
				(+= temp2 11)
				(continue)
			)
			(+= temp1 13)
		)
	)

	(method (highlight &tmp temp0 temp1 temp2)
		(if (!= local41 dummyIcon)
			(= temp2 (/ (- (barMagic eventY:) nsTop) 11))
			(for
				((= temp1 (/ (- (barMagic eventX:) nsLeft) 13)))
				(>= temp1 local180)
				((-- temp1))
			)
			(while (>= temp2 local189)
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
				text: [local222 temp0]
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
			((== local41 self)
				(gCMusic2 number: 61 setLoop: 1 play:)
				(= local41 0)
				(self show:)
			)
			((IsObject local41)
				(gCMusic2 number: 58 setLoop: 1 play:)
				(localproc_6 local41 self)
			)
			(else
				(gCMusic2 number: 59 setLoop: 1 play:)
				(= local41 self)
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
		(if (and (not local39) (= temp0 (super select: &rest)))
			(gCMusic2 number: 58 setLoop: 1 play:)
			(if (not local41)
				(= local41 self)
				(self cel: 2 show:)
			else
				(localproc_6 self local41)
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
		(DrawCel local175 0 0 0 local42 15)
		(DrawCel local175 0 1 0 (+ local42 local183) 15)
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
					(if (!= local124 global114)
						(localproc_1 mathMarvel)
					)
					(if (mathMarvel show:)
						(proc5_1)
						(mathMarvel solvePuzzle:)
						(= local119 (localproc_2 local121 1))
						(= cycles 1)
					else
						(self dispose:)
					)
				else
					(= local40 1)
					(= cycles 1)
				)
			)
			(3
				(proc5_2)
				(localproc_14 local119)
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
		(= local124 global114)
		(= local453 (= local417 0))
		(= window mathWindow)
		(mathWindow back: [local0 13])
		(= local42 iconHeight)
		(= local142 0)
		(mathBox x: 18)
		(= local44 (+ iconHeight puzzleHeight 3))
		(= local141 (* 12 (Random 0 1)))
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(= [local434 temp0] 0)
		)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(if (== local124 2)
				(while [local434 (= temp1 (Random 0 11))]
				)
			else
				(= temp3 (- temp0 (mod temp0 4)))
				(while [local434 (= temp1 (Random temp3 (+ temp3 3)))]
				)
			)
			(= [local434 temp1] [local537 (= temp2 (+ temp0 (* local124 12)))])
			(= [local418 temp1] [local501 temp2])
		)
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= [local137 temp0] -1)
		)
		(for ((= temp0 12)) (< temp0 16) ((++ temp0))
			(self
				add:
					((operator new:)
						loop: (- temp0 10)
						cel: 0
						maskLoop: (- temp0 10)
						value: (- temp0 11)
						nsLeft: [local461 temp0]
						nsTop: [local477 temp0]
						highlightColor: [local0 7]
						lowlightColor: [local0 14]
						signal: 129
						yourself:
					)
			)
		)
		(if (== local124 2)
			(localproc_9)
		)
		(for ((= temp0 0)) (< temp0 12) ((++ temp0))
			(self
				add:
					((= temp3 (operand new:))
						value: [local434 temp0]
						cel: 0
						text: [local418 temp0]
						nsLeft: [local461 temp0]
						nsTop: [local477 temp0]
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
					nsLeft: [local493 3]
					nsTop: [local497 3]
					loop: 2
					cel: 4
					value: 0
					signal: 129
					yourself:
				)
		)
		(if (!= local124 2)
			(localproc_9)
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(return local40)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(if (super buyClue: &rest)
			(localproc_11)
			(= temp0 (localproc_8 0))
			(= temp2
				[local537 (+ (= temp1 (- (temp0 value:) 1)) (* local124 12))]
			)
			(= temp3 [local537 (+ temp1 (* local124 12) 4)])
			(= temp4 [local537 (+ temp1 (* local124 12) 8)])
			(if (not (= [local454 0] (localproc_8 temp2)))
				(= temp2
					[local537 (+ (= temp5 [local457 temp1]) (* local124 12) 8)]
				)
				(= temp3 [local537 (+ temp5 (* local124 12) 4)])
				(= temp4 [local537 (+ temp5 (* local124 12))])
				(= [local454 0] (localproc_8 temp2))
			)
			(= [local454 1] (localproc_8 temp3))
			(= [local454 2] (localproc_8 temp4))
			(theMusic3 number: 56 setLoop: 1 play:)
			(localproc_12 temp0)
		)
	)

	(method (showHelp)
		(proc5_14
			120
			27
			(if (< local124 2)
				{Each problem uses one number from each row.}
			else
				{}
			)
			(if (< local124 2)
				{Jede Aufgabe braucht eine Zahl aus jeder Reihe.}
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
							(if (== local124 2)
								(= temp4 [local414 2])
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
							((!= local124 2)
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
							(if (== local124 2)
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
								(if (== local124 2)
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
		(if local129
			(self showHelp:)
			(= local129 0)
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
			(if (== local124 2)
				(cond
					((not local417)
						(self cel: 1 show:)
						(= local417 self)
					)
					((!= local417 self)
						(local417 cel: 0 show:)
						(self cel: 1 show:)
						(= local417 self)
					)
					(else
						(self cel: 0 show:)
						(= local417 0)
					)
				)
			else
				(cond
					((not [local450 (= temp1 (/ (- nsTop 35) 25))])
						([local414 temp1] value: value text: text show:)
						(self mask: signal: (| signal $0004))
						(= [local450 temp1] self)
					)
					((== [local450 temp1] self)
						([local414 temp1]
							value: 0
							loop: 1
							cel: 3
							text: {}
							show:
						)
						(= [local450 temp1] 0)
						(self signal: (& signal $fffb) cel: 0 show:)
					)
					(else
						([local414 temp1] value: value text: text show:)
						(self mask: signal: (| signal $0004))
						([local450 temp1]
							signal: (& ([local450 temp1] signal:) $fffb)
							cel: 0
							show:
						)
						(= [local450 temp1] self)
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
		(if local417
			(for ((= temp0 0)) (!= [local414 temp0] self) ((++ temp0))
			)
			(self value: (local417 value:) text: (local417 text:) show:)
			(if [local450 temp0]
				([local450 temp0]
					signal: (& ([local450 temp0] signal:) $fffb)
					cel: 0
					show:
				)
			)
			(local417 mask: signal: (| (local417 signal:) $0004))
			(= [local450 temp0] local417)
			(= local417 0)
			(localproc_10)
		)
	)

	(method (showText param1 &tmp [temp0 4])
		(proc5_8 text param1 (+ nsLeft 4) (+ nsTop 6))
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
			(if (not local453)
				(mathOperator value: value loop: loop cel: 2 show:)
			else
				(local453 signal: (& (local453 signal:) $fffb) cel: 0 show:)
			)
			(mathOperator value: value loop: loop cel: 2 show:)
			(self mask: signal: (| signal $0004))
			(= local453 self)
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
		bottom 165
		right 270
	)

	(method (open)
		(super open:)
		(DrawCel 140 0 0 0 local42 15)
		(DrawCel 140 0 1 0 (+ local42 88) 15)
		(DrawCel 140 2 4 [local493 3] [local497 3] 15)
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
		(if (and (< local585 110) (super select: &rest))
			(gCMusic2 number: (+ 900 value) setLoop: 1 play:)
			(= local585 (+ (* local585 10) (mod (+ value 1) 10)))
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
			(= temp0 local585)
			(= local585 0)
			(if
				(or
					(not
						(= local586
							(and
								local586
								(== temp0 [local643 [global167 local587]])
							)
						)
					)
					(>= (++ local587) 3)
				)
				(if (= local573 local586)
					(gCMusic2 number: 51 setLoop: 1 play:)
					(proc5_9 120 31)
					(SetFlag 32)
				else
					(proc5_9 120 32)
					(= local586 1)
				)
				(backDoorLock goAway:)
			else
				(gCMusic2 number: 51 setLoop: 1 play:)
				(proc5_9 120 33)
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
		(= local585 (= local587 0))
		(= local586 1)
		(= local584 iconHeight)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(self
				add:
					((= [local574 temp0] (symbol_a new:))
						loop: temp0
						value: temp0
						nsLeft: [local588 temp0]
						nsTop: [local598 temp0]
						highlightColor: [local0 7]
						lowlightColor: [local0 18]
						yourself:
					)
			)
		)
		(self
			add:
				(symbol_b
					highlightColor: [local0 7]
					lowlightColor: [local0 18]
					textColor: [local0 9]
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(return local573)
	)

	(method (buyClue)
		(cond
			((>= local126 2)
				(proc5_9 120 34)
			)
			((super buyClue: &rest)
				(theMusic3 number: 56 setLoop: 1 play:)
				(localproc_2 local587 0)
				(= local585 [local643 [global167 local587]])
				(localproc_13)
				(++ local126)
			)
		)
	)

	(method (showHelp)
		(proc5_9 120 35)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(cond
			((== (event type:) evKEYBOARD)
				(if
					(or
						(== (= temp5 (event message:)) KEY_e)
						(== temp5 KEY_E)
						(== temp5 KEY_RETURN)
					)
					(backDoorLock select: symbol_b 0)
				)
			)
			((and (& (event type:) $0040) (IsObject highlightedIcon)) ; direction
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
		(DrawCel 150 0 0 3 (+ local584 2) 15)
		(localproc_13)
	)
)

(instance theMusic3 of Sound
	(properties)
)

