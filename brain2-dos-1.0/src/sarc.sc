;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 175)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use IconBar)
(use LoadMany)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	sarc 0
)

(local
	[local0 3] = [3 3420 5024]
	[local3 10] = [{0} {1} {2} {3} {4} {5} {6} {7} {8} {9}]
	[local13 5] = [{000} {001} {002} {003} {004}]
	local18
	[local19 35]
	[local54 3]
	[local57 5]
	local62
	local63
	local64
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp7 [local0 global114])
	(for ((= temp1 0)) (< temp1 (+ 3 global114)) ((++ temp1))
		(for ((= temp2 0)) (not (& temp2 temp7)) ((= temp2 (<< $0001 temp6)))
			(= temp6 (Random 0 12))
		)
		(switch temp6
			(0
				(= temp4 (Random 1 10))
				(= temp3 (Random 1 100))
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0)] temp3)
					(+= temp3 temp4)
				)
			)
			(1
				(= temp4 (Random 1 10))
				(= temp3 (Random (+ 1 (* temp4 7)) 100))
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0)] temp3)
					(-= temp3 temp4)
				)
				(&= temp7 (~ temp2))
			)
			(2
				(= temp4 (Random 11 99))
				(= temp3 (Random 1 (- 999 (* temp4 7))))
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0)] temp3)
					(+= temp3 temp4)
				)
			)
			(3
				(= temp4 (Random 11 99))
				(= temp3 (Random (+ 1 (* temp4 7)) 999))
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0)] temp3)
					(-= temp3 temp4)
				)
			)
			(4
				(= temp4 (Random 1 9))
				(= temp5 (Random 1 9))
				(= temp3 (Random (+ 1 (* temp5 4)) 100))
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0)] temp3)
					(if (not (mod temp0 2))
						(+= temp3 temp4)
					else
						(-= temp3 temp5)
					)
				)
			)
			(5
				(= temp4 (Random 11 99))
				(= temp5 (Random 11 99))
				(= temp3 (Random (+ 1 (* temp5 4)) (- 999 (* temp4 3))))
				(for ((= temp0 0)) (< temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0)] temp3)
					(if (not (mod temp0 2))
						(+= temp3 temp4)
					else
						(-= temp3 temp5)
					)
				)
			)
			(6
				(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) (- temp0 1))] (* temp0 temp0))
				)
				(&= temp7 (~ temp2))
			)
			(7
				(= temp4 (Random 1 20))
				(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) (- temp0 1))]
						(* (+ temp4 temp0) (+ temp4 temp0))
					)
				)
			)
			(8
				(= temp4 1)
				(= temp5 1)
				(= [local19 (+ (* temp1 7) 0)] temp4)
				(= [local19 (+ (* temp1 7) 1)] temp5)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0 2)] (+ temp4 temp5))
					(= temp3 temp5)
					(+= temp5 temp4)
					(= temp4 temp3)
				)
				(&= temp7 (~ temp2))
			)
			(9
				(= temp4 (Random 1 5))
				(= temp5 (Random temp4 10))
				(= [local19 (+ (* temp1 7) 0)] temp4)
				(= [local19 (+ (* temp1 7) 1)] temp5)
				(for ((= temp0 0)) (< temp0 5) ((++ temp0))
					(= [local19 (+ (* temp1 7) temp0 2)] (+ temp4 temp5))
					(= temp3 temp5)
					(+= temp5 temp4)
					(= temp4 temp3)
				)
				(&= temp7 (~ (>> temp2 $0001)))
			)
			(10
				(= temp3 1)
				(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) (- temp0 1))] temp3)
					(+= temp3 (+ temp0 1))
				)
				(&= temp7 (~ temp2))
			)
			(11
				(= temp3 (Random 1 20))
				(= temp4 (Random 2 5))
				(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) (- temp0 1))] temp3)
					(+= temp3 (* temp0 temp4))
				)
			)
			(12
				(= temp3 (Random 11 200))
				(= temp4 (Random 6 9))
				(for ((= temp0 1)) (<= temp0 7) ((++ temp0))
					(= [local19 (+ (* temp1 7) (- temp0 1))] temp3)
					(+= temp3 (* temp0 temp4))
				)
			)
		)
	)
)

(instance sarc of PuzzleBar
	(properties
		solvedFlag 6
		noun 5
		personalID 13
	)

	(method (init &tmp temp0)
		(= local62 0)
		(= local63 0)
		(= window puz2Window)
		(localproc_0)
		(self add: lockButton)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self
				add:
					((= [local54 temp0] (incButton new:))
						nsLeft: (+ 79 (* temp0 12))
						yourself:
					)
			)
		)
		(self add: enterBut)
		(for ((= temp0 0)) (< temp0 (+ 3 global114)) ((++ temp0))
			(self
				add:
					((= [local57 temp0] (answerBut new:))
						nsTop: (+ 79 (* temp0 20))
						text: (Format [local13 temp0] {%d} 0)
						cursor: [local19 (+ (* temp0 7) 3)]
						yourself:
					)
			)
		)
		(= local18 0)
		([local57 0] loop: 9)
		(LoadMany rsSOUND 104 207 104 135 236 248 118 106)
		(super init: &rest)
		((= puzzleCast (Set new:))
			add: (lock setPri: 15 loop: 8 cel: 2 x: 129 y: 39 yourself:)
		)
		(= showCast 1)
	)

	(method (show param1)
		(= local64 param1)
		(super show: &rest)
	)

	(method (animateOnce)
		(if (& state $2000)
			(&= state $dfff)
			(gMessager say: noun 4 15) ; "Hmmm. This a strange lock, as it has no numbers. Perhaps something has to be inserted (a punched card?) into the slot on the side of the sarcophagus."
		)
		(super animateOnce: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1)
		(if (& (event type:) $0040) ; direction
			(= temp1 (self indexOf: highlightedIcon))
			(switch (event message:)
				(JOY_DOWN
					(cond
						((not temp1)
							(+= temp1 2)
						)
						((< temp1 4)
							(= temp1 4)
						)
						((== temp1 (- size 4))
							(= temp1 (- size 2))
						)
						((> temp1 (- size 4))
							(= temp1 0)
						)
						(else
							(++ temp1)
						)
					)
				)
				(JOY_UP
					(cond
						((not temp1)
							(= temp1 (- size 2))
						)
						((< temp1 4)
							(= temp1 0)
						)
						((== temp1 4)
							(= temp1 2)
						)
						((> temp1 (- size 4))
							(= temp1 (- size 4))
						)
						(else
							(-- temp1)
						)
					)
				)
				(JOY_RIGHT
					(cond
						((not temp1) 0)
						((< temp1 4)
							(if (>= (++ temp1) 4)
								(= temp1 1)
							)
						)
						((< temp1 (- size 3)) 0)
						((>= (++ temp1) size)
							(= temp1 (- size 3))
						)
					)
				)
				(JOY_LEFT
					(cond
						((not temp1) 0)
						((< temp1 4)
							(if (< (-- temp1) 1)
								(= temp1 3)
							)
						)
						((< temp1 (- size 3)) 0)
						((< (-- temp1) (- size 3))
							(= temp1 (- size 1))
						)
					)
				)
			)
			(= temp0 (self at: temp1))
			(proc5_9 temp0)
			(event type: evNULL)
		)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(= highlightedIcon 0)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (buyClue &tmp temp0 temp1 temp2 temp3 temp4)
		(if (super buyClue: &rest)
			(if (< local18 0)
				(for ((= local18 0)) (< local18 (+ global114 3)) ((++ local18))
					(= temp2 (self at: (+ local18 5)))
					(if (!= (temp2 value:) (temp2 cursor:))
						(break)
					)
				)
			)
			(= temp0 ([local57 local18] cursor:))
			(= temp3 100)
			(for ((= temp4 0)) (< temp4 3) ((++ temp4))
				(= temp1 (mod (/ temp0 temp3) 10))
				(/= temp3 10)
				(= temp2 [local54 temp4])
				(while (!= (temp2 value:) temp1)
					(gCSoundFX number: 104 setLoop: 1 play:)
					(self select: temp2 0)
					(Wait 5)
				)
			)
			(Wait 15)
			(self select: enterBut 0)
		)
	)
)

(instance puz2Window of SysWindow
	(properties
		top 10
		left 60
		right 252
		priority -1
	)

	(method (open &tmp temp0 temp1 [temp2 3])
		(= bottom (+ 149 (* 20 global114)))
		(super open: &rest)
		(DrawCel 166 0 0 0 21 -1)
		(for ((= temp0 0)) (< temp0 (+ global114 3)) ((++ temp0))
			(DrawCel 166 1 0 0 (+ 78 (* 20 temp0)) -1)
			(if local64
				(for ((= temp1 0)) (< temp1 7) ((++ temp1))
					(if (!= temp1 3)
						(Format @temp2 {%d} [local19 (+ (* temp0 7) temp1)])
						(proc5_8
							@temp2
							0
							(+ 5 (* temp1 27))
							(+ 84 (* temp0 20))
							-1
							1
						)
					)
				)
			else
				(sarc puzzleStatus: 2 state: (| (sarc state:) $2000))
			)
		)
	)
)

(instance incButton of TextIcon
	(properties
		view 166
		loop 3
		nsTop 52
		highlightColor 11
		downClick 121
		upClick 104
		text {0}
		textColor 52
	)

	(method (select)
		(= textColor highlightColor)
		(if (super select: &rest)
			(= value (mod (++ value) 10))
			(self text: [local3 value] showText: highlightColor)
		)
		(= textColor 52)
	)

	(method (showText param1)
		(DrawCel view loop 3 (+ nsLeft 1) (- nsTop 11) -1)
		(proc5_8 text param1 (+ nsLeft 1) (- nsTop 10) -1 1)
	)

	(method (highlight param1 &tmp [temp0 11])
		(if param1
			(self show: 0 showText: highlightColor)
		else
			(self show: 2 showText: textColor)
		)
	)
)

(instance answerBut of TextIcon
	(properties
		view 166
		loop 2
		nsLeft 84
		signal 385
		noun 22
		text {0}
	)

	(method (select)
		(if (super select: &rest)
			(cond
				((== value cursor)
					(gMessager say: noun 4) ; "You already have the correct answer for this row."
				)
				((== local18 -1)
					(= local18 (- (sarc indexOf: self) 5))
					(= [local57 local18] self)
					(self loop: 9 show:)
				)
				(else
					([local57 local18] loop: 2 show:)
					(= local18 (- (sarc indexOf: self) 5))
					(self loop: 9 show:)
				)
			)
		)
	)

	(method (showText param1)
		(if (== value cursor)
			(proc5_8 text 0 (+ nsLeft 1) (+ nsTop 5) -1 1)
		else
			(proc5_8 text param1 (+ nsLeft 1) (+ nsTop 5) -1 1)
		)
	)
)

(instance enterBut of CodeIcon
	(properties
		view 166
		loop 4
		cel 0
		nsLeft 79
		nsTop 67
		signal 385
	)

	(method (select &tmp temp0 temp1 temp2)
		(if (super select: &rest)
			(if (!= local18 -1)
				(= value
					(+
						(* ([local54 0] value:) 100)
						(* ([local54 1] value:) 10)
						([local54 2] value:)
					)
				)
				([local57 local18]
					value: value
					text: (Format ([local57 local18] text:) {%d} value)
					show:
				)
				([local54 0] value: 0 text: [local3 0] show:)
				([local54 1] value: 0 text: [local3 0] show:)
				([local54 2] value: 0 text: [local3 0] show:)
				(if (== value ([local57 local18] cursor:))
					(gCSoundFX number: 135 setLoop: 1 play:)
					([local57 local18] loop: 2 show:)
					(if (>= (++ local62) (+ global114 3))
						(lock setScript: openLock)
					else
						(= temp2 (+ local18 1))
						(= temp1 0)
						(for
							((= temp0 0))
							(and (< temp0 (+ 2 global114)) (not temp1))
							((++ temp0))
							
							(if
								(!=
									([local57
											(mod
												(+ temp0 temp2)
												(+ 3 global114)
											)
										]
										value:
									)
									([local57
											(mod
												(+ temp0 temp2)
												(+ 3 global114)
											)
										]
										cursor:
									)
								)
								(= local18 -1)
								(= temp1 1)
								([local57 (mod (+ temp0 temp2) (+ 3 global114))]
									select:
								)
							)
						)
					)
				else
					(gCSoundFX number: 248 setLoop: 1 play:)
					(switch (++ local63)
						(1
							((sarc puzzleCast:)
								add:
									(octoeyesrght
										setPri: 15
										cel: 0
										show:
										yourself:
									)
									(octoeyesleft
										setPri: 15
										cel: 0
										show:
										yourself:
									)
							)
						)
						(2
							(octoeyesrght cel: 1)
							(octoeyesleft cel: 1)
						)
						(3
							(octoeyesrght cel: 2)
							(octoeyesleft cel: 2)
							(sarc animateOnce:)
							(if global114
								(Wait 60)
								(Prints
									{You have angered the spirit of the tomb}
								)
								(sarc puzzleStatus: 2)
								(sarc goAway:)
							)
						)
					)
				)
			else
				(Prints {You haven't picked a button yet.})
			)
		)
	)
)

(instance octoeyesrght of Prop
	(properties
		x 207
		y 42
		view 166
		loop 6
	)
)

(instance octoeyesleft of Prop
	(properties
		x 95
		y 42
		view 166
		loop 7
	)
)

(instance lock of Prop
	(properties
		view 166
	)
)

(instance lockButton of IconI
	(properties
		nsLeft 69
		nsTop 29
		nsRight 123
		nsBottom 41
		signal 129
	)

	(method (show))

	(method (highlight))

	(method (select)
		(if (not (lock script:))
			(lock setScript: jiggleKey)
		)
	)
)

(instance jiggleKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sarc pHandsOff: 1)
				(lock setCycle: End self)
			)
			(1
				(sarc pHandsOff: 0)
				(self dispose:)
			)
		)
	)
)

(instance openLock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 118 setLoop: 1 play:)
				(sarc pHandsOff: 1)
				(lock
					loop: 5
					setCel: 0
					cycleSpeed: 10
					y: (+ (lock y:) 1)
					setCycle: End self
				)
			)
			(1
				(= ticks 30)
			)
			(2
				(gCSoundFX number: 106 setLoop: 1 play:)
				(lock setCel: (- (lock cel:) 1))
				(= ticks 30)
			)
			(3
				(sarc pHandsOff: 0)
				(sarc solvePuzzle:)
				(self dispose:)
			)
		)
	)
)

