;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30421)
(include sci.sh)
(use Main)
(use n951)
(use Array)
(use Actor)
(use System)

(public
	octagonPuzzle 0
)

(local
	[local0 16] = [0 3 1 2 0 2 1 3 3 0 1 2 0 3 2 1]
	[local16 72] = [0 1 2 0 2 3 1 3 1 3 1 0 2 3 2 0 2 2 3 0 0 1 3 1 2 3 1 0 2 3 1 0 1 2 2 1 0 3 3 0 1 3 2 1 0 2 3 0 1 2 2 0 0 3 3 1 0 3 1 0 3 2 2 1 2 1 3 3 1 2 0 0]
	[local88 24] = [124 52 143 68 124 84 105 68 105 36 143 36 162 52 162 84 143 100 105 100 86 84 86 52]
	[local112 18] = [116 29 97 45 135 45 78 61 116 61 154 61 97 77 135 77 116 93]
	[local130 18] = [44 26 69 1 159 1 189 1 189 26 189 96 159 119 69 119 44 96]
	local148
	local149
	local150
	local151
	local152
	local153
	local154
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(if (or (>= (local150 indexOf: param2) 0) (>= (local149 indexOf: param2) 0))
		(return 0)
	)
	(if (< (= temp2 (local151 indexOf: param2)) 0)
		(return 1)
	)
	(= temp1 (local149 indexOf: param1))
	(switch temp2
		(0
			(= temp0
				(if
					(= temp0
						(if (= temp0 (localproc_1 temp1 0 2))
							(localproc_2 temp1 1 3)
						)
					)
					(localproc_2 temp1 2 1)
				)
			)
		)
		(1
			(= temp0
				(if
					(= temp0
						(if
							(= temp0
								(if
									(= temp0
										(if (= temp0 (localproc_1 temp1 0 0))
											(localproc_1 temp1 3 2)
										)
									)
									(localproc_2 temp1 0 7)
								)
							)
							(localproc_2 temp1 4 1)
						)
					)
					(localproc_2 temp1 3 3)
				)
			)
		)
		(2
			(= temp0
				(if
					(= temp0
						(if
							(= temp0
								(if
									(= temp0
										(if (= temp0 (localproc_1 temp1 0 4))
											(localproc_1 temp1 1 2)
										)
									)
									(localproc_2 temp1 0 5)
								)
							)
							(localproc_2 temp1 4 3)
						)
					)
					(localproc_2 temp1 5 1)
				)
			)
		)
		(3
			(= temp0
				(if
					(= temp0
						(if (= temp0 (localproc_1 temp1 3 0))
							(localproc_2 temp1 1 7)
						)
					)
					(localproc_2 temp1 6 1)
				)
			)
		)
		(4
			(= temp0
				(if
					(= temp0
						(if
							(= temp0
								(if
									(= temp0
										(if
											(= temp0
												(if
													(= temp0
														(if
															(= temp0
																(if
																	(= temp0
																		(localproc_1
																			temp1
																			0
																			6
																		)
																	)
																	(localproc_1
																		temp1
																		1
																		0
																	)
																)
															)
															(localproc_1
																temp1
																2
																2
															)
														)
													)
													(localproc_1 temp1 3 4)
												)
											)
											(localproc_2 temp1 7 1)
										)
									)
									(localproc_2 temp1 6 3)
								)
							)
							(localproc_2 temp1 1 5)
						)
					)
					(localproc_2 temp1 2 7)
				)
			)
		)
		(5
			(= temp0
				(if
					(= temp0
						(if (= temp0 (localproc_1 temp1 1 4))
							(localproc_2 temp1 2 5)
						)
					)
					(localproc_2 temp1 7 3)
				)
			)
		)
		(6
			(= temp0
				(if
					(= temp0
						(if
							(= temp0
								(if
									(= temp0
										(if (= temp0 (localproc_1 temp1 3 6))
											(localproc_1 temp1 2 0)
										)
									)
									(localproc_2 temp1 3 5)
								)
							)
							(localproc_2 temp1 4 7)
						)
					)
					(localproc_2 temp1 8 1)
				)
			)
		)
		(7
			(= temp0
				(if
					(= temp0
						(if
							(= temp0
								(if
									(= temp0
										(if (= temp0 (localproc_1 temp1 1 6))
											(localproc_1 temp1 2 4)
										)
									)
									(localproc_2 temp1 4 5)
								)
							)
							(localproc_2 temp1 5 7)
						)
					)
					(localproc_2 temp1 8 3)
				)
			)
		)
		(8
			(= temp0
				(if
					(= temp0
						(if (= temp0 (localproc_1 temp1 2 6))
							(localproc_2 temp1 6 5)
						)
					)
					(localproc_2 temp1 7 7)
				)
			)
		)
	)
	(return temp0)
)

(procedure (localproc_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 [local0 (+ (= temp2 (mod (+ (/ param3 2) 2) 4)) (* param2 4))])
	(= temp0 (local149 at: param1))
	(return
		(==
			(= temp3
				[local16
					(+
						(= temp1 (mod (+ param3 (- 8 (temp0 cel:))) 8))
						(* param1 8)
					)
				]
			)
			temp4
		)
	)
)

(procedure (localproc_2 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= temp0 (local149 at: param1))
	(= temp4
		[local16
			(+ (= temp2 (mod (+ param3 (- 8 (temp0 cel:))) 8)) (* param1 8))
		]
	)
	(if (>= (= param2 (local150 indexOf: (local151 at: param2))) 0)
		(= temp1 (local149 at: param2))
		(= temp5
			[local16
				(+
					(= temp3
						(mod
							(+
								(= param3 (mod (+ param3 4) 8))
								(- 8 (temp1 cel:))
							)
							8
						)
					)
					(* param2 8)
				)
			]
		)
		(return (== temp4 temp5))
	else
		(return 1)
	)
)

(instance octagonPuzzle of ShiversRoom
	(properties
		picture 30421
	)

	(method (init &tmp temp0 temp1 temp2 temp3 [temp4 2])
		(super init:)
		(= local153 0)
		(= local148 0)
		(if (not (mod (= local154 (Random 1 8)) 3))
			(++ local154)
		)
		(efExitBack init: 8)
		(squares init:)
		(= local149 (IntArray new: 9))
		(= local150 (IntArray new: 9))
		(= local151 (IntArray new: 9))
		(= local152 (IntArray new: 9))
		(for ((= temp0 0)) (< temp0 4) ((++ temp0))
			(= temp3 (* 2 temp0))
			(squares
				addToEnd:
					((post new:)
						view: 30424
						loop: 0
						posn: [local88 temp3] [local88 (+ temp3 1)]
						cel: temp0
						setPri: 10 1
						init:
						yourself:
					)
			)
		)
		(for ((= temp0 4)) (< temp0 12) ((++ temp0))
			(= temp3 (* 2 temp0))
			(squares
				addToEnd:
					((post new:)
						view: 30424
						loop: 1
						posn: [local88 temp3] [local88 (+ temp3 1)]
						cel: (- temp0 4)
						setPri: 10 1
						init:
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= temp3 (* 2 temp0))
			(local151
				at:
					temp0
					((octagonSpace new:)
						posn: [local112 temp3] [local112 (+ temp3 1)]
						setPri: 5 1
						init:
						scratch: 0
						yourself:
					)
			)
			(local152
				at:
					temp0
					((octagonSpace new:)
						posn: [local130 temp3] [local130 (+ temp3 1)]
						setPri: 5 1
						init:
						scratch: 1
						yourself:
					)
			)
		)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(= temp2 (mod (* temp0 local154) 9))
			(= temp3 (* 2 temp2))
			(local149
				at:
					temp0
					((octagon new:)
						posn: [local130 temp3] [local130 (+ temp3 1)]
						loop: (+ temp0 1)
						cel: (Random 0 7)
						setPri: 25 1
						init:
						yourself:
					)
			)
			(local150 at: temp0 (local152 at: temp2))
		)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 30420
	)

	(method (init)
		(self createPoly: 0 0 0 143 40 143 40 0 220 0 220 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance octagonSpace of View
	(properties
		view 30421
	)
)

(instance post of View
	(properties
		view 30421
	)

	(method (onMe)
		(return 0)
	)
)

(instance octagon of View
	(properties
		view 30421
	)

	(method (init)
		(super init:)
		(gMouseDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (onMe)
		(if (== local148 self)
			(return 0)
		else
			(return (super onMe: &rest))
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10)
		(event localize: (self plane:))
		(if (and (self onMe: event) (not local148) (== (event type:) evMOUSEBUTTON))
			(= temp0 (local149 indexOf: self))
			(= local148 self)
			(self setPri: 255 1)
			(= temp1 x)
			(= temp2 y)
			(= temp5 (event x:))
			(= temp6 (event y:))
			(= temp7 0)
			(repeat
				(= temp3 (Event new:))
				(temp3 localize: (self plane:))
				(if (or (!= temp5 (temp3 x:)) (!= temp6 (temp3 y:)))
					(self posn: (- (temp3 x:) 14) (- (temp3 y:) 11))
					(if (not temp7)
						(= temp8 (local150 at: temp0))
						(local150 at: temp0 0)
					)
					(UpdateScreenItem self)
					(FrameOut)
					(= temp7 1)
				)
				(if (== (temp3 type:) evMOUSERELEASE)
					(= temp4 (gCast firstTrue: #onMe temp3))
					(cond
						(temp7
							(if (and temp4 (localproc_0 self temp4))
								(self posn: (temp4 x:) (temp4 y:))
								(local150 at: temp0 temp4)
								(if (>= (local151 indexOf: temp8) 0)
									(-- local153)
								)
								(if (>= (local151 indexOf: temp4) 0)
									(++ local153)
								)
								(gSounds play: 13006 0 82 0)
							else
								(gSounds play: 13009 0 82 0)
								(if temp4
									(self posn: (temp4 x:) (temp4 y:))
									(UpdateScreenItem self)
									(FrameOut)
									(gGame handsOff:)
									(= temp9 gGameTime)
									(while (< (- gGameTime temp9) 90)
										(gGame doit:)
									)
									(gGame handsOn:)
								)
								(self posn: temp1 temp2)
								(local150 at: temp0 temp8)
							)
						)
						((and temp4 (>= (local152 indexOf: temp4) 0))
							(gSounds stop: 13005)
							(gSounds play: 13005 0 82 0)
							(self cel: (mod (+ (self cel:) 1) 8))
						)
					)
					(self setPri: 25 1)
					(= local148 0)
					(temp3 dispose:)
					(break)
				)
				(temp3 dispose:)
			)
			(self setPri: 25 1)
			(if (== local153 9)
				(gCurRoom setScript: sPuzzleSolved)
			)
		)
	)
)

(instance squares of List
	(properties)
)

(instance sBadPiece of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 15)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sPuzzleSolved of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if ((local149 at: 3) cel:)
					(= temp1 3)
				else
					(= temp1 2)
				)
				(for ((= temp0 4)) (< temp0 12) ((++ temp0))
					((squares at: temp0) loop: temp1)
				)
				(gSounds play: 13010 0 82 self)
			)
			(1
				(if (not (IsFlag 87))
					(SetFlag 58)
					(proc951_15 6750)
				)
				(gCurRoom newRoom: 30420) ; rm30v420
				(self dispose:)
			)
		)
	)
)

