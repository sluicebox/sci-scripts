;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 960)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	proc960_0 0
	proc960_1 1
)

(local
	local0
	[local1 36]
	[local37 36]
	[local73 36]
	[local109 12]
	[local121 12]
	local133
	local134
	local135
	local136
	local137
	local138
)

(procedure (proc960_0 param1 &tmp temp0)
	(cond
		((< global347 2)
			(= temp0 (Random 0 2))
		)
		((< global347 5)
			(= temp0 (Random 3 6))
		)
		(else
			(= temp0 (Random 7 11))
		)
	)
	(PrintDebug {puzzle:%d} temp0)
	(switch temp0
		(0
			(= global116 4)
			(= global117 1)
			(localproc_0 1 2 2 1 1 1 1 2 0 0 param1)
		)
		(1
			(= global116 4)
			(= global117 2)
			(localproc_0 2 1 2 1 1 2 1 1 2 2 1 1 param1)
		)
		(2
			(= global116 4)
			(= global117 2)
			(localproc_0 2 3 1 3 3 1 2 1 0 0 3 3 param1)
		)
		(3
			(= global116 5)
			(= global117 2)
			(localproc_0 2 3 1 1 2 0 1 0 1 1 1 2 3 0 param1)
		)
		(4
			(= global116 5)
			(= global117 0)
			(localproc_0 3 3 2 3 1 1 1 0 0 3 param1)
		)
		(5
			(= global116 5)
			(= global117 2)
			(localproc_0 1 3 1 1 3 2 1 0 1 2 2 4 1 1 param1)
		)
		(6
			(= global116 5)
			(= global117 3)
			(localproc_0 2 1 1 3 3 1 3 3 0 2 1 1 3 4 4 2 param1)
		)
		(7
			(= global116 6)
			(= global117 1)
			(localproc_0 2 3 1 1 1 2 2 0 0 1 2 1 1 2 param1)
		)
		(8
			(= global116 6)
			(= global117 0)
			(localproc_0 1 1 3 3 1 1 1 2 0 1 0 1 param1)
		)
		(9
			(= global116 6)
			(= global117 1)
			(localproc_0 1 2 2 3 2 3 1 3 3 1 3 0 1 5 param1)
		)
		(10
			(= global116 6)
			(= global117 2)
			(localproc_0 1 3 3 3 2 3 2 1 2 1 2 1 4 4 1 1 param1)
		)
		(11
			(= global116 6)
			(= global117 2)
			(localproc_0 1 1 2 3 3 1 0 1 1 1 0 2 2 5 3 0 param1)
		)
	)
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4)
	(if
		(or
			(< global116 4)
			(> global116 6)
			(!= argc (+ (* 2 (+ global116 global117)) 1))
		)
		(return 0)
	)
	(proc951_18 10506)
	(= local0 [param1 (* 2 (+ global116 global117))])
	(PrintDebug {who to cue:%d} local0)
	(switch global116
		(4
			(= local134 27)
			(= local135 22)
			(= local137 97)
			(= local138 45)
		)
		(5
			(= local134 21)
			(= local135 17)
			(= local137 95)
			(= local138 43)
		)
		(6
			(= local134 18)
			(= local135 15)
			(= local137 93)
			(= local138 41)
		)
	)
	(hsOutsidePuzzle init:)
	(ClearFlag 6)
	(for ((= temp0 0)) (< temp0 global116) ((++ temp0))
		(for ((= temp1 0)) (< temp1 global116) ((++ temp1))
			(= temp2 (+ temp1 (* global116 temp0)))
			(= [local37 temp2] 0)
			(= [local1 temp2] (View new:))
			(= [local73 temp2] 0)
			([local1 temp2]
				x: (+ local137 (* local134 temp1))
				y: (+ local138 (* local135 temp0))
				view: 50400
				setLoop: global116 1
				init:
			)
		)
	)
	(for ((= temp0 0)) (< temp0 2) ((++ temp0))
		(for ((= temp1 0)) (< temp1 global116) ((++ temp1))
			(= [local109 temp2]
				[param1 (= temp2 (+ temp1 (* global116 temp0)))]
			)
			(if [local109 temp2]
				(= temp3 ((pushButton new:) loop: (* temp0 3) scratch: temp1))
				(if temp0
					(temp3
						x: (- local137 (+ 2 (/ local134 2)))
						y: (+ local138 (* local135 temp1))
					)
				else
					(temp3
						x: (+ local137 (* local134 temp1))
						y: (- local138 (+ 2 (/ local135 2)))
					)
				)
				(temp3 init:)
				(= [local121 temp2] temp3)
			else
				(= [local121 temp2] 0)
			)
		)
	)
	(for ((= temp2 0)) (< temp2 global117) ((++ temp2))
		(= temp0 [param1 (+ (* global116 2) (* temp2 2))])
		(= temp1 [param1 (+ (* global116 2) (* temp2 2) 1)])
		([local1 (+ temp0 (* temp1 global116))] cel: 1)
		(= [local73 (+ temp0 (* temp1 global116))] 1)
	)
	(for ((= temp0 0)) (< temp0 global116) ((++ temp0))
		(= temp2 -1)
		(while (< temp2 0)
			(if
				(or
					[local37 (= temp2 (Random 0 (- (* global116 global116) 1)))]
					[local73 temp2]
					(== (mod temp2 (- global116 1)) 0)
				)
				(= temp2 -1)
			else
				(= [local37 temp2] (ball new:))
				([local37 temp2]
					x: (+ local137 (* (mod temp2 global116) local134))
					y: (+ local138 (* (/ temp2 global116) local135))
					init:
				)
			)
		)
	)
)

(procedure (proc960_1 &tmp temp0 temp1 temp2 temp3)
	(PrintDebug {dispose hotspot})
	(hsOutsidePuzzle dispose:)
	(proc951_19 10506)
	(PrintDebug {dispose grid})
	(for ((= temp0 0)) (< temp0 global116) ((++ temp0))
		(for ((= temp1 0)) (< temp1 global116) ((++ temp1))
			(if [local37 (= temp2 (+ temp1 (* global116 temp0)))]
				([local37 temp2] dispose:)
			)
			([local1 temp2] dispose:)
		)
	)
	(PrintDebug {dispose buttons})
	(for ((= temp0 0)) (< temp0 2) ((+= temp0 1))
		(for ((= temp1 0)) (< temp1 global116) ((++ temp1))
			(if [local121 (= temp2 (+ temp1 (* global116 temp0)))]
				([local121 temp2] dispose:)
			)
		)
	)
)

(procedure (localproc_1 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 [temp6 6])
	(= temp0 param2)
	(if param1
		(+= temp0 global116)
	)
	(= temp1 [local109 temp0])
	(= temp5 1)
	(if param1
		(= temp2 param2)
		(= temp1 (- global116 temp1))
		(for ((= temp3 0)) (< temp3 global116) ((++ temp3))
			(= [temp6 temp3]
				[local37
					(+ (mod (+ temp3 temp1) global116) (* temp2 global116))
				]
			)
			(if (and [temp6 temp3] [local73 (+ temp3 (* temp2 global116))])
				(= temp5 0)
			)
		)
		(if temp5
			(for ((= temp3 0)) (< temp3 global116) ((++ temp3))
				(= [local37 (+ temp3 (* temp2 global116))] [temp6 temp3])
				(= [temp6 0] 0)
			)
		)
	else
		(= temp3 param2)
		(= temp1 (- global116 temp1))
		(for ((= temp2 0)) (< temp2 global116) ((++ temp2))
			(= [temp6 temp2]
				[local37
					(+ temp3 (* (mod (+ temp2 temp1) global116) global116))
				]
			)
			(if (and [temp6 temp2] [local73 (+ temp3 (* temp2 global116))])
				(= temp5 0)
			)
		)
		(if temp5
			(for ((= temp2 0)) (< temp2 global116) ((++ temp2))
				(= [local37 (+ temp3 (* temp2 global116))] [temp6 temp2])
				(= [temp6 temp2] 0)
			)
		)
	)
)

(instance sButtonScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(client cel: 1)
				(= cycles 1)
			)
			(1
				(localproc_1 (client loop:) (client scratch:))
				(= cycles 1)
			)
			(2
				(= local133 0)
				(= local136 0)
				(for ((= temp0 0)) (< temp0 global116) ((++ temp0))
					(for ((= temp1 0)) (< temp1 global116) ((++ temp1))
						(if (= temp2 [local37 (+ temp1 (* temp0 global116))])
							(++ local133)
							(temp2
								scratch: (+ temp1 (* temp0 global116))
								setScript: (sMoveBall new:)
							)
						)
					)
				)
				(= cycles 1)
			)
			(3
				(if local133
					(-- state)
				)
				(= cycles 1)
			)
			(4
				(= temp3 1)
				(for ((= temp4 1)) (<= temp4 global116) ((++ temp4))
					(if (not [local37 (* temp4 (- global116 1))])
						(= temp3 0)
					)
				)
				(if temp3
					(client cel: 0)
					(UpdateScreenItem client)
					(local0 setScript: sPuzzleDone local0)
				else
					(= cycles 1)
				)
			)
			(5
				(client cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveBall of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(= temp2
					(+ local137 (* (mod (client scratch:) global116) local134))
				)
				(if
					(==
						(= temp3
							(+
								local138
								(* (/ (client scratch:) global116) local135)
							)
						)
						(client y:)
					)
					(if (== temp2 (client x:))
						(client setCycle: 0 cel: 0)
						(= cycles 1)
					else
						(cond
							((not local136)
								(= local136 client)
								(PrintDebug {sound ob %d} local136)
							)
							((== client local136)
								(gSounds stop: 10506)
								(proc951_18 10506)
							)
						)
						(= temp0 (+ (client x:) local134))
						(= temp1 temp3)
						(if (>= temp0 (+ local137 (* global116 local134)))
							(= temp0 (+ (client x:) (/ local134 2)))
							(client
								view: (- (+ 50400 global116) 3)
								setLoop: 0 1
								cel: 1
								setCycle: CT 3 1 self
								setMotion: MoveTo temp0 temp1
							)
							(if (== client local136)
								(PrintDebug {half-flip right})
								(gSounds play: 10506 0 90 0)
							)
							(= state 1)
						else
							(client
								view: (- (+ 50400 global116) 3)
								setLoop: 0 1
								cel: 0
								setCycle: End
								setMotion: MoveTo temp0 temp1 self
							)
							(if (== client local136)
								(PrintDebug {flip right})
								(gSounds play: 10506 0 90 0)
							)
							(-- state)
						)
					)
				else
					(cond
						((not local136)
							(= local136 client)
							(PrintDebug {sound ob %d} local136)
						)
						((== client local136)
							(gSounds stop: 10506)
							(proc951_18 10506)
						)
					)
					(= temp1 (+ (client y:) local135))
					(= temp0 temp2)
					(if (>= temp1 (+ local138 (* global116 local135)))
						(= temp1 (+ (client y:) (/ local135 2)))
						(client
							view: (- (+ 50400 global116) 3)
							setLoop: 1 1
							cel: 1
							setCycle: CT 3 1 self
							setMotion: MoveTo temp0 temp1
						)
						(if (== client local136)
							(PrintDebug {half-flip down})
							(gSounds play: 10506 0 90 0)
						)
						(= state 2)
					else
						(client
							cel: 0
							view: (- (+ 50400 global116) 3)
							setLoop: 1 1
							setCycle: End
							setMotion: MoveTo temp0 temp1 self
						)
						(if (== client local136)
							(PrintDebug {flip down})
							(gSounds play: 10506 0 90 0)
						)
						(-- state)
					)
				)
			)
			(1
				(-- local133)
				(self dispose:)
			)
			(2
				(client
					x: (- local137 (/ local134 2))
					setCycle: End
					setMotion: MoveTo local137 (client y:) self
				)
				(= state -1)
			)
			(3
				(client
					y: (- local138 (/ local135 2))
					setCycle: End
					setMotion: MoveTo (client x:) local138 self
				)
				(= state -1)
			)
		)
	)
)

(instance sPuzzleDone of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(= temp1 1)
				(for ((= temp0 1)) (<= temp0 global116) ((++ temp0))
					(if (not [local37 (* temp0 (- global116 1))])
						(= temp1 0)
					)
				)
				(if (not temp1)
					(++ state)
				)
				(= cycles 1)
			)
			(2
				(gSounds play: 10509 0 90 0)
				(++ global347)
				([local37 (- global116 1)]
					view: (- (+ 50400 global116) 3)
					setLoop: 0 1
					setCycle: End self
				)
				(for ((= temp0 2)) (<= temp0 global116) ((++ temp0))
					([local37 (* temp0 (- global116 1))]
						view: (- (+ 50400 global116) 3)
						setLoop: 0 1
						setCycle: End
					)
				)
				(SetFlag 6)
				(proc951_15 6750)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ball of Actor
	(properties)

	(method (init)
		(self
			view: (- (+ 50400 global116) 3)
			setLoop: 0 1
			setPri: 127 1
			ignoreActors: 1
			moveSpeed: 6
			cycleSpeed: 6
			xStep: (+ (/ local134 4) 1)
			yStep: (/ local135 4)
		)
		(super init: &rest)
	)
)

(instance hsOutsidePuzzle of HotSpot
	(properties)

	(method (init)
		(self
			createPoly: 132 127 132 143 0 143 0 0 263 0 263 143 133 143 133 127 197 127 197 16 49 16 49 127
		)
		(super init: &rest)
	)

	(method (doVerb)
		(local0 setScript: sPuzzleDone local0)
	)
)

(instance pushButton of ShiversProp
	(properties
		view 50400
	)

	(method (doVerb)
		(self setScript: sButtonScript)
	)
)

