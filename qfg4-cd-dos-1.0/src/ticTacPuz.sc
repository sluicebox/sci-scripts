;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 648)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Str)
(use Array)
(use Print)
(use ForwardCounter)
(use Actor)
(use System)

(public
	ticTacPuz 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
)

(procedure (localproc_0 param1)
	(return (+ 40 (* (mod param1 3) (CelWide 645 0 0))))
)

(procedure (localproc_1 param1)
	(return (+ 35 (* (/ param1 3) (CelHigh 645 0 0))))
)

(procedure (localproc_2 param1 &tmp temp0 temp1 temp2)
	(= global107 local2)
	(= temp1 local2)
	(if (== param1 rotating)
		(if (!= local0 -1)
			(|= temp1 (<< $0001 local1))
		)
	else
		(|= temp1 (<< $0001 local0))
	)
	(localproc_4)
	(if (> local7 7)
		(for ((= temp2 0)) (< temp2 9) ((++ temp2))
			(if (not (& local2 (<< $0001 temp2)))
				(return temp2)
			)
		)
		(SetDebug)
	else
		(while (& temp1 (<< $0001 (= temp0 (Random 0 8))))
		)
	)
	(return temp0)
)

(procedure (localproc_3)
	(cond
		(
			(and
				(== ((local3 at: 0) value2:) ((local3 at: 1) value2:))
				(== ((local3 at: 2) value2:) ((local3 at: 1) value2:))
			)
			(= local6 1)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 3) value2:) ((local3 at: 4) value2:))
				(== ((local3 at: 5) value2:) ((local3 at: 4) value2:))
			)
			(= local6 2)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 6) value2:) ((local3 at: 7) value2:))
				(== ((local3 at: 8) value2:) ((local3 at: 7) value2:))
			)
			(= local6 3)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 0) value2:) ((local3 at: 3) value2:))
				(== ((local3 at: 6) value2:) ((local3 at: 3) value2:))
			)
			(= local6 4)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 1) value2:) ((local3 at: 7) value2:))
				(== ((local3 at: 4) value2:) ((local3 at: 7) value2:))
			)
			(= local6 5)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 2) value2:) ((local3 at: 8) value2:))
				(== ((local3 at: 5) value2:) ((local3 at: 8) value2:))
			)
			(= local6 6)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 0) value2:) ((local3 at: 4) value2:))
				(== ((local3 at: 8) value2:) ((local3 at: 4) value2:))
			)
			(= local6 7)
			(return 1)
		)
		(
			(and
				(== ((local3 at: 6) value2:) ((local3 at: 4) value2:))
				(== ((local3 at: 2) value2:) ((local3 at: 4) value2:))
			)
			(= local6 8)
			(return 1)
		)
		(else
			(= local6 0)
			(return 0)
		)
	)
)

(procedure (localproc_4 &tmp temp0)
	(= local7 0)
	(for ((= temp0 0)) (< temp0 9) ((++ temp0))
		(if (& local2 (<< $0001 temp0))
			(++ local7)
		)
	)
	(if (>= local7 7)
		(return 1)
	else
		(return 0)
	)
)

(instance ticTacPuz of PuzzleBar
	(properties)

	(method (helpYou &tmp temp0)
		(= temp0 (Str new:))
		(switch local5
			(0
				(= local5 1)
				(Message msgGET 641 1 9 0 1 (temp0 data:)) ; "To disarm the trap, mark three boxes in a row, column, or diagonal with the same color."
				(Print addText: (temp0 data:) y: 150 init:)
			)
			(1
				(= local5 2)
				(Message msgGET 641 1 9 0 2 (temp0 data:)) ; "Think about which color would be useful in a particular square, wait for it to appear, then click on it quickly."
				(Print addText: (temp0 data:) y: 150 init:)
			)
			(2
				(= local5 3)
				(Message msgGET 641 1 9 0 3 (temp0 data:)) ; "Start with the center square, then try to duplicate its color in other squares."
				(Print addText: (temp0 data:) y: 150 init:)
			)
			(3
				(= local5 4)
				(Message msgGET 641 1 9 0 4 (temp0 data:)) ; "If you've chosen the wrong colors a few times, use the Exit button and start over so you don't set off the trap. Don't click on "?" again unless you want to skip the puzzle entirely."
				(Print addText: (temp0 data:) y: 150 init:)
			)
			(else
				(Message msgGET 641 1 9 0 5 (temp0 data:)) ; "You barely manage to line up the tumblers in the trap mechanism and disarm it before it was about to explode."
				(Print addText: (temp0 data:) y: 150 init:)
				(= local4 1)
				(ticTacPuz setScript: leaveScript)
			)
		)
		(temp0 dispose:)
	)

	(method (dispose)
		(local3 dispose:)
		(super dispose:)
		(if local4
			(return 1)
		else
			(return 0)
		)
	)

	(method (init)
		(= local3 (IntArray new: 9))
		(super init: &rest)
		(rotating init: puzzleCast hide:)
		(squaring init: puzzleCast hide:)
	)

	(method (setPlane)
		(= usePlane 1)
		(plane
			bitmap: 0
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 82 40 250 155
			setBitmap: 935 0 0 1
			addCast: puzzleCast
		)
	)

	(method (resetPuzzle &tmp temp0 temp1 temp2)
		(= local2 0)
		(= local4 0)
		(= local0 -1)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= temp2 (ASquare new:))
			(temp2
				loop: 4
				nsTop: (= temp1 (+ 35 (* (/ temp0 3) (CelHigh 645 0 0))))
				y: temp1
				nsLeft: (= temp1 (+ 40 (* (mod temp0 3) (CelWide 645 0 0))))
				x: temp1
				value: temp0
				value2: (+ temp0 10)
				setCel: 1
				init: self
			)
			(local3 at: temp0 temp2)
			(self add: temp2)
		)
		(self setScript: thisScript)
	)
)

(class ASquare of TextIcon
	(properties
		priority 55
		fixPriority 1
		view 645
		signal 1
		cycler 0
		cycleSpeed 6
	)

	(method (init)
		(super init: &rest)
		(= nsRight (+ nsLeft (CelWide 645 0 0)))
		(= nsBottom (+ nsTop (CelHigh 645 0 0)))
	)

	(method (setCycle param1)
		(if cycler
			(cycler dispose:)
		)
		(if param1
			(= cycler
				(if (& (param1 -info-:) $8000)
					(param1 new:)
				else
					param1
				)
			)
			(cycler init: self &rest)
		else
			(= cycler 0)
		)
	)

	(method (highlight))

	(method (select &tmp [temp0 3] temp3)
		(return
			(if (or (== value local0) (== value local1))
				(cond
					((== value local1)
						(= temp3 squaring)
						(= value2 (= loop (squaring cel:)))
						(= value3 (squaring cel:))
						(|= local2 (<< $0001 local1))
					)
					((== value local0)
						(= temp3 rotating)
						(= value2 (= loop (rotating cel:)))
						(= value3 (rotating cel:))
						(|= local2 (<< $0001 local0))
					)
					(else
						(return 0)
					)
				)
				(= loop value3)
				(UpdateScreenItem self)
				(cond
					((localproc_3)
						(= local4 1)
						(ticTacPuz setScript: sHighLightBoxes)
					)
					((== local2 511)
						(ticTacPuz setScript: sHighLightBoxes)
					)
				)
			)
		)
	)
)

(instance rotating of Prop
	(properties
		view 645
		loop 5
		signal 16385
	)
)

(instance squaring of Prop
	(properties
		view 645
		loop 5
		signal 16385
	)
)

(instance thisScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ticTacPuz noHands: 1)
				(= cycles 2)
			)
			(1
				(rotating
					x: (localproc_0 (= local0 (localproc_2 rotating)))
					y: (localproc_1 local0)
					cel: (Random 0 3)
					setLoop: 5
					setPri: 100
					show:
					setScript: theTimer1
				)
				(squaring
					x: (localproc_0 (= local1 (localproc_2 squaring)))
					y: (localproc_1 local1)
					cel: (Random 0 3)
					setLoop: 5
					setPri: 100
					setScript: theTimer2
					show:
				)
				(ticTacPuz noHands: 0)
				(self dispose:)
			)
		)
	)
)

(instance theTimer1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks
					(*
						(/ [gEgoStats 9] 10) ; pick locks
						(switch global439
							(1 5)
							(2 3)
							(3 1)
						)
					)
				)
			)
			(1
				(if (!= local2 511)
					(rotating
						x: (localproc_0 (= local0 (localproc_2 rotating)))
					)
					(rotating y: (localproc_1 local0))
					(rotating cel: (Random 0 3))
					(= ticks
						(*
							(/ [gEgoStats 9] 10) ; pick locks
							(switch global439
								(1 5)
								(2 3)
								(3 1)
							)
						)
					)
				else
					(self dispose:)
				)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance theTimer2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks
					(* (/ [gEgoStats 9] 10) (if (== global439 1) 5 else 3)) ; pick locks
				)
			)
			(1
				(if (and (localproc_4) (== local2 511))
					(self dispose:)
				else
					(squaring
						x: (localproc_0 (= local1 (localproc_2 squaring)))
					)
					(squaring y: (localproc_1 local1))
					(squaring cel: (Random 0 3))
					(= ticks
						(* (/ [gEgoStats 9] 10) (if (== global439 1) 5 else 3)) ; pick locks
					)
				)
			)
			(2
				(self changeState: 1)
			)
		)
	)
)

(instance toCycle of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (and (param1 isKindOf: ASquare) (= temp0 (param1 cycler:)))
			((param1 cycler:) doit:)
		)
	)
)

(instance sHighLightBoxes of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(ticTacPuz eachElementDo: #perform toCycle)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ticTacPuz noHands: 1)
				(if (rotating script:)
					((rotating script:) caller: 0)
					((rotating script:) dispose:)
				)
				(if (squaring script:)
					((squaring script:) caller: 0)
					((squaring script:) dispose:)
				)
				(rotating dispose:)
				(squaring dispose:)
				(switch local6
					(0
						(ticTacPuz setScript: leaveScript)
					)
					(1
						((local3 at: 0) setCycle: ForwardCounter 6)
						((local3 at: 1) setCycle: ForwardCounter 6)
						((local3 at: 2) setCycle: ForwardCounter 6 self)
					)
					(2
						((local3 at: 3) setCycle: ForwardCounter 6)
						((local3 at: 4) setCycle: ForwardCounter 6)
						((local3 at: 5) setCycle: ForwardCounter 6 self)
					)
					(3
						((local3 at: 6) setCycle: ForwardCounter 6)
						((local3 at: 7) setCycle: ForwardCounter 6)
						((local3 at: 8) setCycle: ForwardCounter 6 self)
					)
					(4
						((local3 at: 0) setCycle: ForwardCounter 6)
						((local3 at: 3) setCycle: ForwardCounter 6)
						((local3 at: 6) setCycle: ForwardCounter 6 self)
					)
					(5
						((local3 at: 1) setCycle: ForwardCounter 6)
						((local3 at: 4) setCycle: ForwardCounter 6)
						((local3 at: 7) setCycle: ForwardCounter 6 self)
					)
					(6
						((local3 at: 2) setCycle: ForwardCounter 6)
						((local3 at: 5) setCycle: ForwardCounter 6)
						((local3 at: 8) setCycle: ForwardCounter 6 self)
					)
					(7
						((local3 at: 0) setCycle: ForwardCounter 6)
						((local3 at: 4) setCycle: ForwardCounter 6)
						((local3 at: 8) setCycle: ForwardCounter 6 self)
					)
					(8
						((local3 at: 2) setCycle: ForwardCounter 6)
						((local3 at: 4) setCycle: ForwardCounter 6)
						((local3 at: 6) setCycle: ForwardCounter 6 self)
					)
				)
			)
			(1
				(ticTacPuz setScript: leaveScript)
			)
		)
	)
)

(instance leaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(ticTacPuz state: (& (ticTacPuz state:) $ffdf))
				(if (== local2 511)
					(SetFlag 182)
				)
				(self dispose:)
			)
		)
	)
)

