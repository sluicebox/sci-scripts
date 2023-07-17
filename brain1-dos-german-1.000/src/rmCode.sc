;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
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
	rmCode 0
)

(local
	[local0 6] = [13 52 7 13 50 35]
	[local6 6] = [12 9 14 12 1 2]
	local12
	[local13 3]
	local16
	local17
	[local18 10]
	local28
	local29
	local30
	[local31 10] = [17 38 59 17 38 59 17 38 59 17]
	[local41 10] = [54 54 54 75 75 75 96 96 96 117]
	[local51 10] = [{0} {1} {2} {3} {4} {5} {6} {7} {8} {9}]
	local61
	local62
)

(procedure (localproc_0 &tmp [temp0 15])
	(Graph grFILL_BOX 36 20 47 74 1 [local0 0] -1 -1)
	(Graph grUPDATE_BOX 36 20 47 74 1)
	(proc5_8
		(Format @temp0 380 41 local29) ; "%d"
		[local0 1]
		20
		38
		-1
		gUserFont
		106
		52
		101
		-1
	)
	(proc5_8 (Format @temp0 380 41 (+ local30 1)) [local0 5] 21 38 -1 gUserFont) ; "%d"
)

(procedure (localproc_1)
	(altS number: 939 setLoop: 1 play:)
	(cabinetDoor dispose:)
	(cabHandle dispose:)
	(if (not (IsFlag 5))
		(token show:)
		(codeCounter show:)
	)
	(rightOpenCabDoor show:)
	(leftOpenCabDoor show:)
	(Animate (gCast elements:) 1)
	(Wait 0)
	(Wait 30)
	(if (not (IsFlag 5))
		(proc5_9 380 42)
		(Wait 0)
		(Wait 45)
		(gCMusic2 number: 965 setLoop: 1 play:)
		(token dispose:)
		(codeCounter dispose:)
		(gEgo get: 3)
		(gEgo get: 16)
		(proc5_0 5)
	)
)

(instance rmCode of Rm
	(properties
		lookStr {The sign says that this is the "Doce Omor". What could that mean? Is Dr. Brain's mind scrambled?}
		picture 380
		style 100
		south 360
	)

	(method (init &tmp temp0)
		(if (not (IsFlag 0))
			(for ((= temp0 0)) (< temp0 11) ((++ temp0))
				(= [local0 temp0] [local6 temp0])
			)
		)
		(= local12 gSpeed)
		(= gSpeed 2)
		(LoadMany rsVIEW 381 382 383 384 385 386 387)
		(LoadMany
			rsSOUND
			51
			56
			58
			60
			380
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
			931
			939
			940
			961
			962
			965
		)
		(super init: &rest)
		(= local61 global114)
		(hangingPost init:)
		(cabHandle init: stopUpd:)
		(cabinetDoor init: stopUpd:)
		(cabinetFeature init:)
		(coinSlot init:)
		(screen init: stopUpd:)
		(door init: stopUpd:)
		(if (IsFlag 5)
			(= local62 global114)
			((ScriptID 391 0) init:) ; cipher
		else
			(cabinetLock init:)
		)
		(token init: hide:)
		(codeCounter init: hide:)
		(portrait init: stopUpd:)
		(safeDoor init: stopUpd:)
		(safeInnards init:)
		(rightOpenCabDoor init: hide:)
		(leftOpenCabDoor init: hide:)
		(book init:)
		(eyeChart init:)
		(skull init:)
		(holeInFloor init:)
		(trapdoor init:)
		(pulley init:)
		(doceOmor init:)
		(topLine init:)
		(if (not (IsFlag 4))
			((ScriptID 390 0) init:) ; safe
		)
		(if (not (IsFlag 6))
			((ScriptID 385 0) init:) ; hangman
		else
			((ScriptID 385 1) init:) ; rope
			((ScriptID 385 2) init:) ; nooseLoop
		)
		(if (!= (gCMusic number:) 380)
			(gCMusic number: 380 flags: 1 setLoop: -1 play:)
		)
		(gCMusic2 flags: 1)
	)

	(method (dispose)
		(if (IsObject (ScriptID 390 0)) ; safe
			((ScriptID 390 0) dispose:) ; safe
		)
		(if (IsObject (ScriptID 385 0)) ; hangman
			((ScriptID 385 0) dispose:) ; hangman
		)
		((ScriptID 391 0) dispose:) ; cipher
		(if (IsObject cabinetLock)
			(cabinetLock dispose:)
		)
		(DisposeScript 385)
		(DisposeScript 390)
		(DisposeScript 391)
		(= gSpeed local12)
		(super dispose:)
	)
)

(instance hangingPost of Feature
	(properties
		x 280
		y 83
		nsTop 5
		nsLeft 221
		nsBottom 189
		nsRight 308
		description {hanging post}
		sightAngle 90
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 6)
					(proc5_14
						380
						0
						[global116 0]
						[global116 1]
						[global116 2]
						[global116 0]
						[global116 1]
						[global116 2]
					)
				else
					(proc5_9 380 1)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance coinSlot of Feature
	(properties
		x 208
		y 60
		z 82
		nsTop 49
		nsLeft 202
		nsBottom 60
		nsRight 214
		description {coin slot}
		sightAngle 90
		lookStr {This is the "Pay TV" token slot.}
	)

	(method (doVerb theVerb invItem)
		(cond
			((and (== theVerb 4) (== invItem 3))
				(gEgo put: 3)
				(SetFlag 2)
				(if (!= local62 global114)
					((ScriptID 391 0) dispose:) ; cipher
					((ScriptID 391 0) init:) ; cipher
					(= local62 global114)
				)
				(gCurRoom setScript: startCipher)
			)
			((and (== theVerb 4) (== invItem 0))
				(if (SetFlag 2)
					(super doVerb: theVerb invItem &rest)
				else
					(proc5_9 380 2)
				)
			)
			((== theVerb 3)
				(if (IsFlag 2)
					(if (IsFlag 3)
						(gCurRoom setScript: openCipherDoor)
					else
						(if (!= local62 global114)
							((ScriptID 391 0) dispose:) ; cipher
							((ScriptID 391 0) init:) ; cipher
							(= local62 global114)
						)
						(if ((ScriptID 391 0) show:) ; cipher
							(gCurRoom setScript: openCipherDoor)
						)
					)
				else
					(proc5_9 380 3)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance startCipher of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc5_1)
				(screen setCycle: End self)
			)
			(1
				(proc5_2)
				((ScriptID 391 0) show:) ; cipher
				(if (IsFlag 3)
					(gCurRoom setScript: openCipherDoor)
				)
				(self dispose:)
			)
		)
	)
)

(instance safeInnards of Feature
	(properties
		x 208
		y 60
		nsTop 62
		nsLeft 23
		nsBottom 120
		nsRight 60
		description {safe shelves}
		sightAngle 90
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 4) ; "There is nothing more to take from the safe."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance screen of Prop
	(properties
		x 188
		y 42
		description {TV Screen}
		view 385
		loop 5
		priority 8
		signal 17
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 3)
				(cond
					((IsFlag 3)
						(gCurRoom setScript: openCipherDoor)
					)
					((IsFlag 2)
						(if (!= local62 global114)
							((ScriptID 391 0) dispose:) ; cipher
							((ScriptID 391 0) init:) ; cipher
							(= local62 global114)
						)
						(if ((ScriptID 391 0) show:) ; cipher
							(gCurRoom setScript: openCipherDoor)
						)
					)
					(else
						(proc5_9 380 5)
					)
				)
			)
			((== theVerb 2)
				(cond
					((IsFlag 3)
						(proc5_9 380 6)
					)
					((IsFlag 2)
						(proc5_9 380 7)
					)
					(else
						(proc5_9 380 8)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 162
		y 81
		description {exit door}
		view 385
		loop 4
		signal 1
		cycleSpeed 48
	)

	(method (onMe)
		(return (and (not (coinSlot onMe: &rest)) (super onMe: &rest)))
	)

	(method (doVerb theVerb &tmp [temp0 500])
		(switch theVerb
			(3
				(cond
					((IsFlag 3)
						(gCurRoom setScript: openCipherDoor)
					)
					((IsFlag 2)
						(if (!= local62 global114)
							((ScriptID 391 0) dispose:) ; cipher
							((ScriptID 391 0) init:) ; cipher
							(= local62 global114)
						)
						(if ((ScriptID 391 0) show:) ; cipher
							(gCurRoom setScript: openCipherDoor)
						)
					)
					(else
						(proc5_9 380 9)
					)
				)
			)
			(2
				(if (IsFlag 3)
					(proc5_9 380 10)
				else
					(proc5_9 380 11)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance openCipherDoor of HandsOffScript
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(screen dispose:)
				(coinSlot dispose:)
				(gCMusic2 number: 931 setLoop: 1 play:)
				(door setCycle: End self)
			)
			(1
				(if (not (gEgo has: 28))
					(gEgo get: 28)
				)
				(gCurRoom newRoom: 200)
				(self dispose:)
			)
		)
	)
)

(instance portrait of Prop
	(properties
		x 17
		y 60
		description {portrait of Dr. Brain}
		view 385
		priority 12
		signal 17
		cycleSpeed 48
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((== cel 0)
						(proc5_14 380 12)
					)
					((> cel 0)
						(proc5_9 380 13)
					)
				)
			)
			(3
				(cond
					((and (self cel:) (safeDoor cel:))
						(proc5_9 380 14)
					)
					((self cel:)
						(gCMusic2 number: 940 setLoop: 1 play:)
						(self priority: 12 setCel: 0)
						(gCast delete: safeDoor addToEnd: safeDoor)
					)
					(else
						(gCMusic2 number: 939 setLoop: 1 play:)
						(self priority: 2 setCel: 1)
						(gCast delete: self addToEnd: self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance safeDoor of Prop
	(properties
		x 24
		y 63
		description {safe}
		lookStr {You've found Dr. Brain's safe. It looks very secure, and has a lock quite unlike any you've ever seen.}
		view 385
		loop 1
		priority 3
		signal 17
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 2) local16)
				(proc5_9 380 15)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(local16
				(if cel
					(gCMusic2 number: 940 setLoop: 1 play:)
					(self setCel: 0)
				else
					(gCMusic2 number: 939 setLoop: 1 play:)
					(self setCel: 1)
				)
			)
			((IsFlag 4)
				(self setCel: (- 1 (self cel:)))
				(= local16 1)
			)
			(else
				(if (!= local61 global114)
					((ScriptID 390 0) dispose:) ; safe
					((ScriptID 390 0) init:) ; safe
					(= local61 global114)
				)
				(if ((ScriptID 390 0) show:) ; safe
					(= local16 1)
					((ScriptID 390 0) dispose:) ; safe
					(safeDoor setCel: 1)
					(gCMusic2 number: 939 setLoop: 1 play:)
					(codePaper init:)
					(rubyKey init:)
					(Animate (gCast elements:) 1)
					(Wait 0)
					(Wait 45)
					(proc5_9 380 16)
					(gCMusic2 number: 965 setLoop: 1 play:)
					(gEgo get: 1)
					(gEgo get: 17)
					(codePaper dispose:)
					(rubyKey dispose:)
				)
			)
		)
	)
)

(instance cabinetDoor of Prop
	(properties
		x 125
		y 161
		description {cabinet}
		lookStr {Could this be the famed "Cabinet of Dr. Caligari"? No, but it is one of the cabinets of Dr. Brain. It features a digital lock.}
		view 385
		loop 3
		priority 10
		signal 17
		cycleSpeed 24
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			((IsFlag 5)
				(localproc_1)
			)
			((cabinetLock show:)
				(cabinetLock dispose:)
				(= local62 global114)
				((ScriptID 391 0) init:) ; cipher
				(localproc_1)
			)
		)
	)
)

(instance cabinetFeature of Feature
	(properties
		nsTop 96
		nsLeft 72
		nsBottom 177
		nsRight 167
		description {cabinet}
		onMeCheck 384
	)

	(method (doVerb theVerb)
		(cond
			((and (IsFlag 5) (== theVerb 3))
				(proc5_9 380 17)
			)
			((== theVerb 3)
				(if (cabinetLock show:)
					(cabinetLock dispose:)
					(= local62 global114)
					((ScriptID 391 0) init:) ; cipher
					(localproc_1)
				)
			)
			((and (== theVerb 2) (not (IsFlag 5)))
				(proc5_9 (cabinetDoor lookStr:))
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance leftOpenCabDoor of Actor
	(properties
		x 78
		y 123
		description {cabinet door}
		view 385
		loop 3
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 17) ; "You've taken everything that was in the cabinet."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rightOpenCabDoor of Actor
	(properties
		x 150
		y 108
		description {cabinet door}
		view 385
		loop 3
		cel 2
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 17) ; "You've taken everything that was in the cabinet."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance cabHandle of Prop
	(properties
		x 112
		y 132
		description {cabinet lock}
		view 385
		loop 2
		priority 11
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 18) ; "The cabinet lock features a numeric keypad."
			)
			(3
				(cond
					((IsFlag 5)
						(localproc_1)
					)
					((cabinetLock show:)
						(cabinetLock dispose:)
						(= local62 global114)
						((ScriptID 391 0) init:) ; cipher
						(localproc_1)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance book of View
	(properties
		x 115
		y 107
		description {ornate book}
		view 385
		loop 7
		cel 1
		priority 11
		signal 17
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 3)
				(gCMusic2 number: 962 setLoop: 1 play:)
				(self setCel: (- 1 cel))
			)
			((== theVerb 2)
				(if (self cel:)
					(proc5_9 380 19)
				else
					(proc5_9 380 20)
					(proc5_9 380 21)
					(proc5_9 380 22)
					(proc5_9 380 23)
					(proc5_9 380 24)
					(proc5_9 380 25)
					(proc5_9 380 26)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance skull of Feature
	(properties
		nsTop 65
		nsLeft 125
		nsBottom 102
		nsRight 1150
		description {skull}
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 27) ; "This skull was left over after one of the doctor's unfortunate brain-transplant experiments. Fortunately, Dr. Brain was able to recycle it for a worthy purpose."
			)
			(3
				(proc5_9 380 28)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance holeInFloor of Feature
	(properties
		nsTop 127
		nsLeft 201
		nsBottom 166
		nsRight 267
		description {hole in floor}
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 29) ; "This leads down to a pool full of piranhas. Dr. Brain so hates to leave unsightly messes around the castle."
			)
			(3
				(proc5_9 380 30)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trapdoor of Feature
	(properties
		nsTop 132
		nsLeft 249
		nsBottom 183
		nsRight 319
		description {trap door}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 31) ; "It's the trap door cover."
			)
			(3
				(proc5_9 380 32)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pulley of Feature
	(properties
		nsTop 2
		nsLeft 273
		nsBottom 23
		nsRight 294
		description {pulley}
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(proc5_9 380 33)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance eyeChart of Feature
	(properties
		x 109
		y 133
		z 91
		nsTop 44
		nsLeft 94
		nsBottom 93
		nsRight 128
		description {eye chart}
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(if (or (== theVerb 3) (== theVerb 2))
			(gCMusic2 number: 58 setLoop: 1 play:)
			(proc5_9 380 34 82 383 0 0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance doceOmor of Feature
	(properties
		x 129
		y 189
		z 119
		nsLeft 81
		nsBottom 38
		nsRight 161
		description {doce omor}
		onMeCheck 512
		lookStr {The sign says "Doce Omor". It must be some kind of code.}
	)
)

(instance topLine of Feature
	(properties
		x 160
		y 189
		z 182
		nsBottom 14
		nsRight 319
		description {cross-beam}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 380 35) ; "In theory, any one of those decorations could be a secret compartment. But, in practice, they are just what they seem -- decorations."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance token of View
	(properties
		x 115
		y 133
		description {coin }
		sightAngle 90
		view 384
		loop 3
		cel 2
		priority 1
		signal 16
	)
)

(instance rubyKey of View
	(properties
		x 42
		y 77
		description {ruby key}
		sightAngle 90
		view 382
		loop 12
		cel 3
		priority 1
		signal 16
	)
)

(instance symbol_a of TextIcon
	(properties
		name {symbol}
		view 384
		loop 1
		cel 0
	)

	(method (select)
		(if (and (< local29 1000) (super select: &rest))
			(gCMusic2 number: (+ 900 value) setLoop: 1 play:)
			(= local29 (+ (* local29 10) value))
			(localproc_0)
		)
	)

	(method (show)
		(= text [local51 value])
		(super show: &rest)
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
		(= temp3 (- nsRight 4))
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
		view 384
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
			(= temp0 local29)
			(= local29 0)
			(cond
				((not (== temp0 [global116 local30]))
					(gCMusic2 number: 54 setLoop: 1 play:)
					(proc5_9 380 36)
					(cabinetLock goAway:)
				)
				((>= local30 2)
					(gCMusic2 number: 51 setLoop: 1 play:)
					(proc5_9 380 37)
					(= local17 1)
					(cabinetLock goAway:)
				)
				(else
					(++ local30)
					(gCMusic2 number: 51 setLoop: 1 play:)
					(proc5_9 380 38)
					(localproc_0)
				)
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
		(= temp3 (- nsRight 4))
		(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
		(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
		(Graph grUPDATE_BOX (- nsTop 2) (- nsLeft 2) nsBottom (+ nsRight 3) 1)
	)
)

(instance cabinetLock of PuzzleBar
	(properties
		puzzleHeight 121
		bottomHeight 0
	)

	(method (init &tmp temp0)
		(= window cabWindow)
		(= local29 (= local30 0))
		(= local28 iconHeight)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			(self
				add:
					((= [local18 temp0] (symbol_a new:))
						value: temp0
						nsLeft: [local31 temp0]
						nsTop: [local41 temp0]
						highlightColor: [local0 2]
						lowlightColor: [local0 3]
						textColor: [local0 4]
						yourself:
					)
			)
		)
		(self
			add:
				(symbol_b
					highlightColor: [local0 2]
					lowlightColor: [local0 3]
					textColor: [local0 4]
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(return local17)
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(if (< [global116 local30] 0)
				(= [global116 local30] (Random 1000 9999))
			)
			(= local29 [global116 local30])
			(localproc_0)
		)
	)

	(method (showHelp)
		(proc5_9 380 39)
		(proc5_9 380 40)
	)

	(method (dispatchEvent event &tmp temp0 temp1 [temp2 2] temp4 temp5 temp6 temp7)
		(cond
			((== (= temp0 (event type:)) evKEYBOARD)
				(cond
					((and (>= (= temp1 (event message:)) KEY_0) (<= temp1 KEY_9))
						(cabinetLock select: [local18 (- temp1 48)] 0)
					)
					((or (== temp1 KEY_e) (== temp1 KEY_E))
						(cabinetLock select: symbol_b 0)
					)
				)
			)
			((and (& temp0 $0040) (IsObject highlightedIcon)) ; direction
				(= temp4 (event message:))
				(= temp7 (/ (= temp6 (self indexOf: highlightedIcon)) 3))
				(switch temp4
					(JOY_UP
						(if (== (highlightedIcon name:) {symbol})
							(if (< temp6 3)
								(= temp5 (self at: (- size 3)))
							else
								(= temp5 (self at: (- temp6 3)))
							)
						else
							(= temp5 (self at: 10))
						)
						(proc5_20 temp5)
						(self highlight: temp5)
					)
					(JOY_DOWN
						(if (== (highlightedIcon name:) {symbol})
							(cond
								((< temp6 8)
									(= temp5 (self at: (+ temp6 3)))
								)
								((== temp6 8)
									(= temp5 (self at: (+ temp6 2)))
								)
								(else
									(= temp5 (self at: (- size 3)))
								)
							)
						else
							(= temp5 (self at: 0))
						)
						(proc5_20 temp5)
						(self highlight: temp5)
					)
				)
			)
		)
		(super dispatchEvent: event)
	)
)

(instance cabWindow of SysWindow
	(properties
		top 30
		left 75
		bottom 185
		right 167
		back 43
	)

	(method (open)
		(super open:)
		(DrawCel 384 0 0 1 local28 15)
		(localproc_0)
	)
)

(instance codePaper of View
	(properties
		x 46
		y 112
		view 382
		loop 12
		cel 2
		priority 1
		signal 16
	)
)

(instance codeCounter of Prop
	(properties
		x 123
		y 151
		view 384
		loop 3
		cel 3
		priority 1
		signal 17
	)
)

(instance altS of Sound
	(properties
		flags 1
	)
)

