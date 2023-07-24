;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use IconBar)
(use LoadMany)
(use Window)

(public
	safe 0
)

(local
	[local0 5] = [27 17 30 23 27]
	[local5 5] = [27 17 30 23 27]
	local10
	local11 = 5
	local12 = 8
	[local13 5]
	local18
	local19
	local20 = 20
	local21
	local22
	[local23 110]
	[local133 8]
	[local141 8] = [129 129 129 129 150 150 150 150]
	[local149 8] = [65 85 105 125 65 85 105 125]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 [temp9 5] [temp14 2] temp16 temp17)
	(= temp1 (* (+ local18 param1) local11))
	(= temp4 param1)
	(= temp3 (+ local22 10 (* param1 17)))
	(while (<= temp4 param2)
		(= temp7 (= temp8 0))
		(= [temp9 0] (= [temp9 1] (= [temp9 2] (= [temp9 3] (= [temp9 4] 0)))))
		(= temp0 0)
		(for ((= temp2 55)) (< temp0 local11) ((+= temp2 19))
			(= temp6 [local23 (+ temp1 temp0)])
			(Graph
				grFILL_BOX
				temp3
				(+ temp2 2)
				(+ temp3 15)
				(+ temp2 18)
				1
				[local0 0]
				-1
				-1
			)
			(DrawCel 382 (+ temp6 3) param3 temp2 temp3 15)
			(if temp6
				(if (== temp6 [local13 temp0])
					(++ temp7)
				)
				(for ((= temp5 0)) (< temp5 local11) ((++ temp5))
					(if (and (== temp6 [local13 temp5]) (not [temp9 temp5]))
						(++ temp8)
						(++ [temp9 temp5])
						(break)
					)
				)
			)
			(++ temp0)
		)
		(Graph grFILL_BOX (+ temp3 3) 12 (+ temp3 13) 24 1 [local0 0] -1 -1)
		(Graph grFILL_BOX (+ temp3 3) 31 (+ temp3 13) 43 1 [local0 0] -1 -1)
		(Graph grUPDATE_BOX (+ temp3 3) 12 (+ temp3 13) 24 1)
		(Graph grUPDATE_BOX (+ temp3 3) 31 (+ temp3 13) 43 1)
		(Graph grUPDATE_BOX temp3 55 (+ temp3 16) 145 1)
		(if (not [local23 (+ temp1 (- local11 1))])
			(= temp17 (= temp16 0))
		else
			(= temp16 (- temp8 temp7))
			(= temp17 temp7)
		)
		(proc5_8 (Format @temp14 390 3 temp16) [local0 2] 14 (+ temp3 4)) ; "%1d"
		(proc5_8 (Format @temp14 390 3 temp17) [local0 3] 34 (+ temp3 4)) ; "%1d"
		(if (and param4 (== temp7 local11) (not local10))
			(= local10 1)
			(Wait 0)
			(Wait 10)
			(for ((= temp6 0)) (< temp6 3) ((++ temp6))
				(gCMusic2 number: 948 setLoop: 1 play:)
				(localproc_0 temp4 temp4 1 1)
				(Wait 45)
				(localproc_0 temp4 temp4 0 1)
				(Wait 45)
			)
			(Wait 45)
			(gCMusic2 stop:)
			(safe solvePuzzle:)
			(safe goAway:)
			(break)
		)
		(++ temp4)
		(+= temp3 17)
		(+= temp1 local11)
	)
)

(procedure (localproc_1 &tmp temp0)
	(= local19 (= local21 (= local18 0)))
	(for ((= temp0 0)) (< temp0 local11) ((++ temp0))
		(= [local13 temp0] (Random 1 local12))
	)
	(for ((= temp0 0)) (< temp0 110) ((++ temp0))
		(= [local23 temp0] 0)
	)
)

(instance safe of PuzzleBar
	(properties
		puzzleHeight 150
		bottomHeight 0
		solvedFlag 4
	)

	(method (init &tmp temp0 temp1 temp2)
		(= local18 (= local19 0))
		(if (not (IsFlag 0))
			(for ((= temp2 0)) (< temp2 5) ((++ temp2))
				(= [local0 temp2] [local5 temp2])
			)
		)
		(LoadMany rsSOUND 58 60 61 948)
		(= local19 0)
		(switch global114
			(0
				(= local11 3)
				(= local12 4)
				(= local20 15)
			)
			(1
				(= local11 4)
				(= local12 6)
				(= local20 12)
			)
			(2
				(= local11 5)
				(= local12 8)
				(= local20 12)
			)
		)
		(= local22 iconHeight)
		(= window sfWindow)
		(safeUpArrow highlightColor: [local0 1])
		(safeDownArrow highlightColor: [local0 1])
		(self add: safeUpArrow safeDownArrow)
		(localproc_1)
		(for ((= temp1 0)) (< temp1 local12) ((++ temp1))
			(self
				add:
					((= [local133 temp1] (symbolIcon new:))
						loop: (+ temp1 4)
						cel: 0
						nsLeft: [local149 temp1]
						nsTop: [local141 temp1]
						highlightColor: [local0 1]
						lowlightColor: [local0 4]
						value: (+ temp1 1)
						yourself:
					)
			)
		)
		(super init: &rest)
	)

	(method (show)
		(super show: &rest)
		(if local10
			(Wait 0)
			(Wait 60)
		)
		(return local10)
	)

	(method (buyClue &tmp temp0 temp1)
		(if (super buyClue: &rest)
			(= temp1 [local133 (- [local13 (= temp0 (mod local21 local11))] 1)])
			(safe select: temp1 0)
		)
	)

	(method (showHelp)
		(proc5_9 390 0) ; "This lock is sealed by a set of computer-chosen symbols. To open the lock, you must guess the selected symbols. After each guess, the computer will show you (in red) how many symbols you guessed correctly, but in the wrong positions, and (in blue) how many you guessed exactly right."
		(proc5_9 390 1) ; "Guess symbols by clicking on the symbols at the bottom of the display. You can also use the Up and Down Arrow symbols to look at your previous guesses."
		(proc5_14 390 2 local20 local20) ; "You have up to %d guesses to logically deduce the chosen combination without setting off the security alarm (this will cause the computer to reset the combination, and you'll have to start over). If you need help, a Hint Coin will buy you the next symbol of the correct combination."
	)
)

(instance sfWindow of SysWindow
	(properties
		top 8
		left 30
		bottom 181
		right 193
		back 29
		priority 14
	)

	(method (open)
		(super open:)
		(DrawCel 382 0 0 0 local22 15)
		(localproc_0 0 4 0 1)
	)
)

(instance safeUpArrow of IconI
	(properties
		view 382
		loop 1
		cel 0
		nsLeft 7
		nsTop 139
		signal 129
	)

	(method (select)
		(if (and (super select: &rest) (> local18 0))
			(gCMusic2 number: 61 setLoop: 1 play:)
			(-- local18)
			(localproc_0 0 4 0 1)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (not (& signal $0020))
			(return)
		)
		(= temp0 (if (and argc param1) 2 else 0))
		(DrawCel view loop temp0 nsLeft nsTop 15)
	)
)

(instance safeDownArrow of IconI
	(properties
		view 382
		loop 2
		cel 0
		nsLeft 29
		nsTop 139
		signal 129
	)

	(method (select)
		(if
			(and
				(super select: &rest)
				(or
					(and (mod local21 local11) (< local18 (- local19 4)))
					(< local18 (- local19 5))
				)
			)
			(gCMusic2 number: 60 setLoop: 1 play:)
			(++ local18)
			(localproc_0 0 4 0 1)
		)
	)

	(method (highlight param1 &tmp temp0)
		(if (not (& signal $0020))
			(return)
		)
		(= temp0 (if (and argc param1) 2 else 0))
		(DrawCel view loop temp0 nsLeft nsTop 15)
	)
)

(instance symbolIcon of CodeIcon
	(properties
		view 382
		loop 3
		cel 0
	)

	(method (select &tmp temp0 temp1 temp2 temp3)
		(= temp0 0)
		(cond
			((and (not local10) (< local19 local20) (super select: &rest))
				(= [local23 local21] value)
				(if (not (mod (++ local21) local11))
					(++ local19)
					(= temp0 1)
				)
				(if
					(and
						(not (<= (- local19 4) local18 (+ local19 4)))
						(not temp0)
					)
					(= local18 (- local19 4))
				)
				(gCMusic2 number: 58 setLoop: 1 play:)
				(localproc_0 0 4 0 1)
			)
			((>= local19 local20)
				(proc5_9 390 4) ; "*** Warning! Warning! *** Safe has been tampered with. Resetting security code."
				(= temp2 0)
				(for ((= temp3 local18)) (< temp2 5) ((++ temp3))
					(for ((= temp1 0)) (< temp1 local11) ((++ temp1))
						(if (<= temp1 (- temp2 (- 2 global114)))
							(= [local23 (+ (* temp3 local11) temp1)]
								[local13 temp1]
							)
						else
							(= [local23 (+ (* temp3 local11) temp1)] 0)
						)
					)
					(gCMusic2 number: 61 setLoop: 1 play:)
					(localproc_0 0 4 0 0)
					(Wait 0)
					(Wait 15)
					(++ temp2)
				)
				(= temp2 0)
				(for ((= temp3 local18)) (< temp2 4) ((++ temp3))
					(for ((= temp1 0)) (< temp1 local11) ((++ temp1))
						(= [local23 (+ (* temp3 local11) temp1)] 0)
					)
					(gCMusic2 number: 60 setLoop: 1 play:)
					(localproc_0 0 4 0 0)
					(Wait 0)
					(Wait 8)
					(++ temp2)
				)
				(proc5_9 390 5) ; "Old combination being purged."
				(localproc_1)
				(safe goAway:)
			)
		)
	)

	(method (highlight param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp5 (if argc param1))
		(if (& signal $2000)
			(super highlight: temp5 &rest)
		else
			(if (not (& signal $0020))
				(return)
			)
			(= temp4 (if temp5 highlightColor else lowlightColor))
			(= temp0 nsTop)
			(= temp1 nsLeft)
			(= temp2 (- nsBottom 2))
			(= temp3 (- nsRight 1))
			(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
			(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
			(Graph grUPDATE_BOX nsTop nsLeft nsBottom nsRight 1)
		)
	)
)

