;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 82)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Array)
(use System)

(public
	bellPuzzle 0
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
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
)

(procedure (localproc_0 param1 &tmp temp0)
	(= temp0
		(if (> (+ 3 (* (- global439 1) 2) global342) 15)
			15
		else
			(+ 3 (* (- global439 1) 2) global342)
		)
	)
	(if (< local1 temp0)
		(if (== param1 (local2 at: local1))
			(local28 at: local1 param1)
			(++ local1)
		else
			(localproc_4 10)
			(if (bellPuzzle highlightedIcon:)
				((bellPuzzle highlightedIcon:) highlight: 2 0)
			)
			(= local1 0)
			(localproc_3 1 0 15)
			(bellPuzzle setScript: sRopeScr)
		)
		(if (and (== local1 temp0) (localproc_1))
			(= local1 0)
			(localproc_3 1 0 15)
			(if (!= (+ 3 (* (- global439 1) 2) global342) 16)
				(cond
					((== global439 3)
						(if (>= (+ 3 (* (- global439 1) 2) global342) 15)
							(SetFlag 397)
							(= global342 8)
						)
					)
					((== global439 2)
						(if (> (+ 3 (* (- global439 1) 2) global342) 10)
							(SetFlag 397)
							(= global342 5)
						)
					)
					((> (+ 3 (* (- global439 1) 2) global342) 8)
						(SetFlag 397)
						(= global342 5)
					)
				)
				(SetFlag 26)
				(bellPuzzle noHands: 1 state: (& (bellPuzzle state:) $ffdf))
			else
				(if (bellPuzzle highlightedIcon:)
					((bellPuzzle highlightedIcon:) highlight: 0)
				)
				(bellPuzzle setScript: sRopeScr)
			)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for
		((= temp0 0))
		(< temp0 (+ 3 (* (- global439 1) 2) global342))
		((++ temp0))
		
		(if (== (local28 at: temp0) (local2 at: temp0))
			(= local1 0)
			(++ global342)
			(if (OneOf (+ 3 (* (- global439 1) 2) global342) 12 14)
				(++ global342)
			)
			(return 1)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2)
	(if (> param1 15)
		(= temp2 1)
		(= temp1 15)
	else
		(= temp2 0)
		(= temp1 param1)
	)
	(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
		(if temp2
			(if (not param2)
				(local2 at: temp0 (local14 at: temp0))
			else
				(local15 at: temp0 (local27 at: temp0))
			)
		else
			(switch temp1
				(3
					(if (not param2)
						(local2 at: temp0 (local3 at: temp0))
					else
						(local15 at: temp0 (local16 at: temp0))
					)
				)
				(4
					(if (not param2)
						(local2 at: temp0 (local4 at: temp0))
					else
						(local15 at: temp0 (local17 at: temp0))
					)
				)
				(5
					(if (not param2)
						(local2 at: temp0 (local5 at: temp0))
					else
						(local15 at: temp0 (local18 at: temp0))
					)
				)
				(6
					(if (not param2)
						(local2 at: temp0 (local6 at: temp0))
					else
						(local15 at: temp0 (local19 at: temp0))
					)
				)
				(7
					(if (not param2)
						(local2 at: temp0 (local7 at: temp0))
					else
						(local15 at: temp0 (local20 at: temp0))
					)
				)
				(8
					(if (not param2)
						(local2 at: temp0 (local8 at: temp0))
					else
						(local15 at: temp0 (local21 at: temp0))
					)
				)
				(9
					(if (not param2)
						(local2 at: temp0 (local9 at: temp0))
					else
						(local15 at: temp0 (local22 at: temp0))
					)
				)
				(10
					(if (not param2)
						(local2 at: temp0 (local10 at: temp0))
					else
						(local15 at: temp0 (local23 at: temp0))
					)
				)
				(11
					(if (not param2)
						(local2 at: temp0 (local11 at: temp0))
					else
						(local15 at: temp0 (local24 at: temp0))
					)
				)
				(13
					(if (not param2)
						(local2 at: temp0 (local12 at: temp0))
					else
						(local15 at: temp0 (local25 at: temp0))
					)
				)
				(else
					(if (not param2)
						(local2 at: temp0 (local13 at: temp0))
					else
						(local15 at: temp0 (local26 at: temp0))
					)
				)
			)
		)
	)
	(localproc_3 (if param2 3 else 1) temp1 15)
)

(procedure (localproc_3 param1 param2 param3 &tmp temp0)
	(if (> param2 3)
		(= param2 0)
	)
	(for ((= temp0 param2)) (< temp0 param3) ((++ temp0))
		(switch param1
			(1
				(local28 at: temp0 -1)
			)
			(2
				(local2 at: temp0 -1)
			)
			(3
				(local15 at: temp0 -1)
			)
			(4
				(local28 at: temp0 -1)
				(local2 at: temp0 -1)
			)
		)
	)
)

(procedure (localproc_4 param1 &tmp temp0)
	(gLongSong number: param1 setLoop: 1 flags: 1 play:)
)

(instance bellPuzzle of PuzzleBar
	(properties)

	(method (init)
		(= local2 (IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1))
		(= local15
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local3 (IntArray with: 1 2 3))
		(= local4 (IntArray with: 4 4 4 1))
		(= local5 (IntArray with: 5 6 4 1 2))
		(= local6 (IntArray with: 3 2 1 2 3 6))
		(= local7 (IntArray with: 1 1 3 3 4 4 3))
		(= local8 (IntArray with: 4 4 4 2 6 6 6 4))
		(= local9 (IntArray with: 6 5 6 5 4 3 2 1 2))
		(= local10 (IntArray with: 6 5 4 1 2 3 4 1 4 3))
		(= local11 (IntArray with: 2 4 6 6 6 6 4 2 1 2 6))
		(= local12 (IntArray with: 1 6 5 4 3 4 2 1 6 5 4 3 4))
		(= local13 (IntArray with: 4 4 5 6 6 5 4 3 1 1 3 4 4 3 3))
		(= local14 (IntArray with: 4 4 5 6 6 5 4 3 1 1 3 4 3 1 1))
		(= local16 (IntArray with: -1 -1 -1 -1 -1 -1))
		(= local17 (IntArray with: -1 -1 -1 -1 -1 -1))
		(= local18 (IntArray with: -1 -1 -1 -1 -1 -1))
		(= local19 (IntArray with: -1 -1 -1 -1 -1 -1))
		(= local20
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local21
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local22
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local23
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local24
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local25
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local26
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local27
			(IntArray with: -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1)
		)
		(= local28 (IntArray new: 15))
		(= local29 (IntArray new: 7))
		(= local31 (IntArray with: 99 42 11 42 91 125))
		(= local32 (IntArray with: 81 81 55 34 34 55))
		(self changeCursor: 999)
		(super init: &rest)
	)

	(method (helpYou)
		(gMessager say: 19 9 0 (++ local0))
		(if (== local0 5)
			(SetFlag 26)
			(= noHands 1)
			(&= state $ffdf)
		)
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

	(method (resetPuzzle &tmp temp0)
		((ScriptID 34 3) setCel: 2) ; pExit
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(self
				add:
					((bell new:)
						nsLeft: (local31 at: temp0)
						x: (local31 at: temp0)
						nsTop: (local32 at: temp0)
						y: (local32 at: temp0)
						loop: (+ temp0 1)
						value: (+ temp0 1)
						init: self
						yourself:
					)
			)
		)
		(self eachElementDo: #show setScript: sRopeScr)
	)

	(method (dispose)
		(local2 dispose:)
		(local15 dispose:)
		(local3 dispose:)
		(local4 dispose:)
		(local5 dispose:)
		(local6 dispose:)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local10 dispose:)
		(local11 dispose:)
		(local12 dispose:)
		(local13 dispose:)
		(local14 dispose:)
		(local16 dispose:)
		(local17 dispose:)
		(local18 dispose:)
		(local19 dispose:)
		(local20 dispose:)
		(local21 dispose:)
		(local22 dispose:)
		(local23 dispose:)
		(local24 dispose:)
		(local25 dispose:)
		(local26 dispose:)
		(local27 dispose:)
		(local28 dispose:)
		(local29 dispose:)
		(local31 dispose:)
		(local32 dispose:)
		(super dispose:)
	)
)

(instance bell of TextIcon
	(properties
		view 281
	)

	(method (highlight param1 param2)
		(if (> argc 1)
			(= cel (if param2 1 else 2))
		else
			(= cel (if param1 0 else 2))
		)
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (select)
		(if (super select: &rest)
			(localproc_4 value)
			(localproc_0 value)
		)
	)
)

(instance sRopeScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(bellPuzzle noHands: 1)
				(localproc_2 (+ 3 (* (- global439 1) 2) global342) 0)
				(localproc_2 (+ 3 (* (- global439 1) 2) global342) 1)
				(self setScript: sRingBellsScr self)
			)
			(1
				(bellPuzzle noHands: 0)
				(if (bellPuzzle highlightedIcon:)
					((bellPuzzle highlightedIcon:) highlight: 0)
				)
				(self dispose:)
			)
		)
	)
)

(instance sRingBellsScr of Script
	(properties)

	(method (init)
		(= local30 0)
		(super init: &rest)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(= temp0 -1)
				(while
					(and
						(< temp0 (bellPuzzle size:))
						(if
							(and
								((= register (bellPuzzle at: (++ temp0)))
									isKindOf: TextIcon
								)
								(register value:)
							)
							(if (== (register value:) (local2 at: local30))
								0
							else
								1
							)
						else
							1
						)
					)
				)
				(self setScript: sFlashRopeScr self register)
			)
			(2
				(register highlight: 2 0)
				(= cycles 2)
			)
			(3
				(= temp1
					(if (> (+ 3 (* (- global439 1) 2) global342) 15)
						15
					else
						(+ 3 (* (- global439 1) 2) global342)
					)
				)
				(if (< (++ local30) temp1)
					(self changeState: 1)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sFlashRopeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 25)
			)
			(1
				(register highlight: 1 1)
				(= cycles 2)
			)
			(2
				(= ticks 15)
			)
			(3
				(localproc_4 (register value:))
				(register highlight: 2 0)
				(= cycles 2)
			)
			(4
				(self dispose:)
			)
		)
	)
)

