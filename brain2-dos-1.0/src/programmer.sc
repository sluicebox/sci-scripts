;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use PuzzleIcon)
(use Print)
(use Rev)
(use Window)
(use Motion)
(use Actor)
(use System)

(public
	programmer 0
	maze 1
)

(local
	[local0 101]
	[local101 51]
	local152
	[local153 144]
	[local297 36]
	[local333 3]
	[local336 3]
	[local339 3]
	[local342 14]
	[local356 3]
	[local359 3]
	local362
	local363
	local364
	local365
	[local366 6] = [24 6 24 54 75 77]
	[local372 6] = [105 113 134 113 104 118]
	[local378 9] = [{} {MOVE FORWARD} {TURN LEFT} {MOVE BACK} {TURN RIGHT} {PICK UP} {SET DOWN} {BEGIN} {END}]
	local387
	local388
	local389
	local390
	local391
	local392
	local393
	local394
	local395
	local396
	local397
	[local398 3] = [15 5 9]
	local401
	local402
	local403
	local404
	local405
	local406
	local407
	local408
)

(procedure (localproc_0 &tmp temp0 temp1 temp2 temp3 temp4 [temp5 10] temp15)
	(= temp2 0)
	(for ((= temp15 (- local363 2))) (< temp2 5) ((++ temp15))
		(if (== temp2 2)
			(DrawCel 302 1 1 23 (+ 31 (* temp2 14)) -1)
		else
			(DrawCel 302 1 0 23 (+ 31 (* temp2 14)) -1)
		)
		(if (and (== local362 1) (& $00f0 (StrAt local152 temp15)))
			(DrawCel 302 1 6 108 (+ 32 (* temp2 14)) -1)
		)
		(= temp3 2)
		(= temp1 (& $000f (StrAt local152 temp15)))
		(= temp0 (+ 33 (* temp2 14)))
		(if (< 0 temp15 (+ local364 1))
			(Format @temp5 {%d : %s} temp15 [local378 temp1])
			(proc5_8 @temp5 temp3 23 temp0)
		)
		(++ temp2)
	)
	(if (== local407 1)
		(localproc_15)
		(if (and (<= 0 local389 11) (<= 0 local388 11))
			(robotProp
				x: (+ 189 (* 8 local389))
				y: (+ 40 (* 8 local388))
				cel: (+ 8 local390)
				show:
			)
		else
			(robotProp hide:)
		)
	)
)

(procedure (localproc_1 &tmp temp0)
	(for ((= temp0 0)) (< temp0 99) ((++ temp0))
		(StrAt local152 temp0 (& $00f0 (StrAt local152 temp0)))
	)
	(= local364 3)
	(= local363 2)
	(StrAt local152 0 0)
	(StrAt local152 1 7)
	(StrAt local152 2 (& $00f0 (StrAt local152 2)))
	(StrAt local152 3 (+ 8 (& $00f0 (StrAt local152 3))))
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3)
	(for ((= temp0 0)) (< temp0 36) ((++ temp0))
		(= temp1 (+ 129 (* 16 (mod temp0 6))))
		(= temp2 (+ 30 (* 16 (/ temp0 6))))
		(DrawCel 302 15 (mod [local297 temp0] 100) temp1 temp2 -1)
	)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(if (!= (= temp3 [local333 temp0]) -1)
			(= temp1 (+ 129 (* 8 (mod temp3 12))))
			(= temp2 (+ 30 (* 8 (/ temp3 12))))
			([local339 temp0] nsTop: temp2 nsLeft: temp1)
		else
			([local339 temp0] nsTop: 500)
		)
	)
	(for ((= temp0 0)) (< temp0 3) ((++ temp0))
		(= temp1 (+ 129 (* 8 (mod [local356 temp0] 12))))
		(= temp2 (+ 30 (* 8 (/ [local356 temp0] 12))))
		([local359 temp0] nsTop: temp2 nsLeft: temp1)
	)
	(if (and local403 (not local407))
		(local402
			nsLeft: (+ 129 (* 8 local404))
			nsTop: (+ 30 (* 8 local405))
			cel: (+ 8 local406)
		)
	)
)

(procedure (localproc_3 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(= [local342 0] (= [local342 1] 10))
	(= [local342 2] (= [local342 3] 12))
	(for ((= temp0 11)) (>= temp0 0) ((-- temp0))
		(localproc_4 (* temp0 12))
	)
	(= temp0 0)
	(= temp2 0)
	(= temp5 0)
	(while (< temp0 12)
		(cond
			((and temp5 [local153 (* temp0 12)])
				(= [local342 temp2] (- temp0 1))
				(++ temp2)
				(= temp5 0)
			)
			((and (not temp5) (not [local153 (* temp0 12)]))
				(= [local342 temp2] temp0)
				(++ temp2)
				(= temp5 1)
			)
		)
		(++ temp0)
	)
	(if temp5
		(= [local342 temp2] (- temp0 1))
		(++ temp2)
	)
	(= [local342 temp2] temp0)
	(++ temp2)
	(= [local342 temp2] temp0)
	(++ temp2)
	(for ((= temp1 1)) (< temp1 12) ((++ temp1))
		(localproc_5 temp1)
	)
	(for ((= temp1 10)) (>= temp1 0) ((-- temp1))
		(localproc_5 temp1)
	)
	(= temp2 0)
	(while (< temp2 3)
		(if (== [local153 (= temp3 (+ (* (Random 0 11) 12) (Random 0 11)))] 1)
			(= [local356 temp2] temp3)
			(= [local153 temp3] 0)
			(++ temp2)
		)
	)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(for ((= temp1 0)) (< temp1 6) ((++ temp1))
			(= temp4 (+ (* temp0 6) temp1))
			(= temp3 (+ (* temp0 24) (* temp1 2)))
			(= temp2 0)
			(if [local153 temp3]
				(+= temp2 1)
			)
			(if [local153 (+ temp3 1)]
				(+= temp2 2)
			)
			(if [local153 (+ temp3 12)]
				(+= temp2 4)
			)
			(if [local153 (+ temp3 13)]
				(+= temp2 8)
			)
			(= [local297 temp4] temp2)
			(+= [local297 temp4] (* (Random 0 2) 100))
		)
	)
	(for ((= temp2 0)) (< temp2 3) ((++ temp2))
		(= [local153 [local356 temp2]] 2)
	)
	(= temp2 0)
	(while (< temp2 3)
		(= temp0 (Random 0 11))
		(= temp1 (Random 0 11))
		(if
			(and
				(== [local153 (= temp3 (+ (* temp0 12) temp1))] 1)
				(< (+ temp0 temp1) 19)
				(or
					(localproc_7 (- (mod temp3 12) 1) (/ temp3 12))
					(localproc_7 (mod temp3 12) (- (/ temp3 12) 1))
					(localproc_7 (+ (mod temp3 12) 1) (/ temp3 12))
					(localproc_7 (mod temp3 12) (+ (/ temp3 12) 1))
				)
			)
			(= [local333 temp2] temp3)
			(= [local153 temp3] 2)
			(++ temp2)
		)
	)
	(for ((= temp2 0)) (< temp2 3) ((++ temp2))
		(= [local153 [local333 temp2]] 1)
		(= [local153 [local356 temp2]] 1)
	)
)

(procedure (localproc_4 param1 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(= temp1 0)
	(= temp2 0)
	(while (< temp0 12)
		(cond
			((< temp0 [local342 temp1])
				(= [local153 (+ param1 temp0)] (localproc_6 60))
			)
			((<= temp0 [local342 (+ temp1 1)])
				(= [local153 (+ param1 temp0)] (localproc_6 60))
				(if (not [local153 (+ param1 temp0)])
					(= temp2 1)
				)
			)
			(else
				(if (not temp2)
					(=
						[local153
							(+
								param1
								(Random [local342 temp1] [local342 (+ temp1 1)])
							)
						]
						0
					)
				)
				(+= temp1 2)
				(= temp2 0)
				(= [local153 (+ param1 temp0)] (localproc_6 60))
			)
		)
		(++ temp0)
	)
	(if (and (== [local342 (+ temp1 1)] 11) (not temp2))
		(=
			[local153
				(+ param1 (Random [local342 temp1] [local342 (+ temp1 1)]))
			]
			0
		)
	)
	(= temp0 0)
	(= temp1 0)
	(= temp2 0)
	(while (< temp0 12)
		(cond
			((and temp2 [local153 (+ param1 temp0)])
				(= [local342 temp1] (- temp0 1))
				(++ temp1)
				(= temp2 0)
			)
			((and (not temp2) (not [local153 (+ param1 temp0)]))
				(= [local342 temp1] temp0)
				(++ temp1)
				(= temp2 1)
			)
		)
		(++ temp0)
	)
	(if temp2
		(= [local342 temp1] (- temp0 1))
		(++ temp1)
	)
	(= [local342 temp1] temp0)
	(++ temp1)
	(= [local342 temp1] temp0)
	(++ temp1)
)

(procedure (localproc_5 param1 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(= temp1 0)
	(= temp2 0)
	(while (< temp0 12)
		(cond
			((< temp0 [local342 temp1]))
			((<= temp0 [local342 (+ temp1 1)])
				(if (not [local153 (+ (* temp0 12) param1)])
					(= temp2 1)
				)
			)
			(else
				(if (not temp2)
					(=
						[local153
							(+
								param1
								(*
									12
									(Random
										[local342 temp1]
										[local342 (+ temp1 1)]
									)
								)
							)
						]
						0
					)
				)
				(+= temp1 2)
				(= temp2 0)
			)
		)
		(++ temp0)
	)
	(if (and (== [local342 (+ temp1 1)] 11) (not temp2))
		(=
			[local153
				(+
					param1
					(* 12 (Random [local342 temp1] [local342 (+ temp1 1)]))
				)
			]
			0
		)
	)
	(= temp0 0)
	(= temp1 0)
	(= temp2 0)
	(while (< temp0 12)
		(cond
			((and temp2 [local153 (+ param1 (* temp0 12))])
				(= [local342 temp1] (- temp0 1))
				(++ temp1)
				(= temp2 0)
			)
			((and (not temp2) (not [local153 (+ param1 (* temp0 12))]))
				(= [local342 temp1] temp0)
				(++ temp1)
				(= temp2 1)
			)
		)
		(++ temp0)
	)
	(if temp2
		(= [local342 temp1] (- temp0 1))
		(++ temp1)
	)
	(= [local342 temp1] temp0)
	(++ temp1)
	(= [local342 temp1] temp0)
	(++ temp1)
)

(procedure (localproc_6 param1)
	(return (< (Random 0 99) param1))
)

(procedure (localproc_7 param1 param2)
	(if (and (<= 0 param1 11) (<= 0 param2 11))
		(return (not [local153 (+ (* param2 12) param1)]))
	else
		(return 0)
	)
)

(procedure (localproc_8 param1)
	(return
		(or
			(localproc_9 (- (mod param1 12) 1) (/ param1 12))
			(localproc_9 (mod param1 12) (- (/ param1 12) 1))
			(localproc_9 (+ (mod param1 12) 1) (/ param1 12))
			(localproc_9 (mod param1 12) (+ (/ param1 12) 1))
		)
	)
)

(procedure (localproc_9 param1 param2 &tmp temp0)
	(if (and (<= 0 param1 11) (<= 0 param2 11))
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(if (== (+ (* param2 12) param1) [local356 temp0])
				(return 1)
			)
		)
		(return 0)
	else
		(return 0)
	)
)

(procedure (localproc_10)
	(if local393
		(if (== local394 3)
			(cond
				(local396
					(-- local396)
					(= local391 (localproc_11 (localproc_13)))
				)
				((== (= local391 (localproc_14)) 0)
					(= local391 10)
					(= local394 0)
				)
				(else
					(localproc_12 local391)
				)
			)
		else
			(++ local387)
			(if (and (& $00f0 (StrAt local152 local387)) (== local362 1))
				(= local391 (localproc_11 (& $000f (StrAt local152 local387))))
			else
				(= local391 (& $000f (StrAt local152 local387)))
			)
			(cond
				((and (== local394 1) (!= local391 1))
					(= local394 3)
					(= local396 (- local387 local395))
					(-- local396)
					(= local391 0)
				)
				((and (== local394 2) (!= local391 3))
					(= local394 3)
					(= local396 (- local387 local395))
					(-- local396)
					(= local391 0)
				)
			)
			(if (!= local394 3)
				(localproc_12 local391)
			)
		)
	else
		(= local391 (localproc_11 (localproc_13)))
	)
)

(procedure (localproc_11 param1)
	(return
		(switch param1
			(1 3)
			(3 1)
			(4 2)
			(2 4)
			(5 6)
			(6 5)
			(else param1)
		)
	)
)

(procedure (localproc_12 param1)
	(= [local0 (++ local0)] param1)
)

(procedure (localproc_13)
	(return [local0 (+ (-- local0) 1)])
)

(procedure (localproc_14 &tmp temp0 temp1)
	(= temp0
		(cond
			((localproc_9 local389 (- local388 1)) 0)
			((localproc_9 (+ local389 1) local388) 1)
			((localproc_9 local389 (+ local388 1)) 2)
			((localproc_9 (- local389 1) local388) 3)
		)
	)
	(if (= temp1 (- local390 temp0))
		(if (or (== temp1 1) (== temp1 -3) (== temp1 2))
			(return 2)
		else
			(return 4)
		)
	else
		(return 0)
	)
)

(procedure (localproc_15 &tmp temp0 temp1 temp2 temp3)
	(= local388 11)
	(= local389 10)
	(= local390 0)
	(= local394 0)
	(for ((= temp3 2)) (<= temp3 local363) ((++ temp3))
		(if
			(and
				(or
					(and
						(!=
							(= local391
								(if
									(and
										(& $00f0 (StrAt local152 temp3))
										(== local362 1)
									)
									(localproc_11
										(& $000f (StrAt local152 temp3))
									)
								else
									(& $000f (StrAt local152 temp3))
								)
							)
							1
						)
						(== local394 1)
					)
					(and (!= local391 3) (== local394 2))
				)
				(!= local391 0)
			)
			(= local388 temp0) ; UNINIT
			(= local389 temp1) ; UNINIT
			(= local391 (localproc_14))
			(= local394 0)
		)
		(switch local391
			(1
				(switch local390
					(0
						(-- local388)
					)
					(1
						(++ local389)
					)
					(2
						(++ local388)
					)
					(3
						(-- local389)
					)
				)
				(if
					(and
						(not local394)
						(== local362 2)
						(localproc_8 (+ (* local388 12) local389))
					)
					(= local394 1)
					(= temp0 local388)
					(= temp1 local389)
				)
			)
			(2
				(= local390 (mod (- local390 1) 4))
			)
			(3
				(switch local390
					(0
						(++ local388)
					)
					(1
						(-- local389)
					)
					(2
						(-- local388)
					)
					(3
						(++ local389)
					)
				)
				(if
					(and
						(not local394)
						(== local362 2)
						(localproc_8 (+ (* local388 12) local389))
					)
					(= local394 2)
					(= temp0 local388)
					(= temp1 local389)
				)
			)
			(4
				(= local390 (mod (+ local390 1) 4))
			)
		)
	)
)

(instance programmer of PuzzleBar
	(properties
		solvedFlag 9
		noun 13
		msgModule 300
		personalID 23
	)

	(method (init &tmp temp0)
		(gGame setCursor: 997 1)
		(gCSoundFX number: 22 setLoop: -1 play:)
		(= local408 -1)
		(= local407 0)
		(= showCast 1)
		(= puzzleCast (Set new:))
		(puzzleCast add: (robotProp setPri: 15 hide: yourself:))
		(= local403 0)
		(= local152 @local101)
		(for ((= temp0 0)) (< temp0 99) ((++ temp0))
			(StrAt local152 temp0 (if (localproc_6 30) 16 else 0))
		)
		(= global187 0)
		(= local401 0)
		(= local397 -1)
		(localproc_1)
		(self add: upArrow downArrow)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(self
				add:
					((pickIcon new:)
						nsLeft: [local366 temp0]
						nsTop: [local372 temp0]
						loop: (+ temp0 5)
						value: (+ temp0 1)
						yourself:
					)
			)
		)
		(self
			add:
				deleteIcon
				insert
				clearBut
				justDoIt
				((= local402 (mazeItem new:))
					noun: 2
					cel: 8
					value: 1
					nsLeft: 209
					nsTop: 118
					yourself:
				)
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(self
				add:
					(= [local339 temp0]
						((mazeItem new:)
							noun: 15
							cel: (+ temp0 2)
							value: (+ temp0 1)
							yourself:
						)
					)
					(= [local359 temp0]
						((mazeItem new:) noun: 16 cel: 5 value: 1 yourself:)
					)
			)
		)
		(self
			add:
				((mazeItem new:)
					noun: 13
					cel: 7
					nsTop: 124
					nsLeft: 209
					value: 1
				)
		)
		(= window pWindow)
		(super init: &rest)
		(localproc_3)
		(gGame setCursor: 900 1)
		(gCSoundFX setLoop: 1 stop:)
	)

	(method (doit)
		(if (== [local333 0] [local333 1] [local333 2] -1)
			(Prints {You have completed the puzzle})
			(= local365 2)
			(programmer solvePuzzle:)
		)
		(super doit: &rest)
	)

	(method (show param1 &tmp temp0)
		(if (> argc 0)
			(= local362 param1)
		else
			(= local362 0)
		)
		(if (!= local408 param1)
			(localproc_1)
			(= local408 param1)
		)
		(= local389 10)
		(= local388 11)
		(= local390 0)
		(= local365 0)
		(gKeyDownHandler add: self)
		(super show: &rest)
		(gKeyDownHandler delete: self)
		(return local365)
	)

	(method (hide)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(= local403 0)
		(super hide: &rest)
	)

	(method (dispatchEvent event &tmp temp0 temp1 temp2)
		(if
			(and
				local403
				(not local407)
				(or (& (event type:) $030f) (== (event type:) evKEYBOARD)) ; evJOYUP | evJOYDOWN | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE
			)
			(local402 nsLeft: 209 nsTop: 118 cel: 8 show:)
			(DrawCel 302 1 12 (+ 129 (* 8 local404)) (+ 30 (* 8 local405)) -1)
			(= local403 0)
		)
		(if (== (event type:) evKEYBOARD)
			(= temp1 1)
			(switch (event message:)
				(KEY_f
					(= temp0 2)
				)
				(KEY_b
					(= temp0 4)
				)
				(KEY_l
					(= temp0 3)
				)
				(KEY_r
					(= temp0 5)
				)
				(KEY_u
					(= temp0 6)
				)
				(KEY_d
					(= temp0 7)
				)
				(KEY_x
					(= temp0 8)
				)
				(KEY_c
					(= temp0 10)
				)
				(KEY_i
					(= temp0 9)
				)
				(KEY_g
					(= temp0 11)
				)
				(KEY_n
					(= temp0 1)
				)
				(KEY_p
					(= temp0 0)
				)
				(else
					(= temp1 0)
				)
			)
			(if temp1
				(if (IsObject highlightedIcon)
					(highlightedIcon highlight: 0)
				)
				(programmer highlight: (= temp2 (self at: temp0)))
				(programmer select: temp2 0)
				(proc5_9 temp2)
			)
		)
		(if (and puzzleStatus (& (event type:) $030f) (++ local397)) ; evJOYUP | evJOYDOWN | evKEYUP | evMOUSEKEYBOARD | evMOUSERELEASE
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)

	(method (buyClue)
		(if (super buyClue: &rest)
			(= local407 1)
			(local402 nsTop: 500)
			(if local403
				(DrawCel
					302
					1
					12
					(+ 129 (* 8 local404))
					(+ 30 (* 8 local405))
					-1
				)
			)
			(DrawCel 302 1 12 209 118 -1)
			(localproc_15)
			(robotProp
				x: (+ 189 (* 8 local389))
				y: (+ 40 (* 8 local388))
				cel: (+ 8 local390)
				show:
			)
		)
	)
)

(instance pWindow of SysWindow
	(properties
		top 10
		left 60
		bottom 165
		right 291
		back 43
		priority -1
	)

	(method (open &tmp temp0)
		(super open: &rest)
		(DrawCel 302 0 0 0 21 -1)
		(localproc_0)
		(localproc_2)
	)
)

(instance robotProp of Prop
	(properties
		view 302
		loop 1
		cel 8
	)
)

(instance upArrow of CodeIcon
	(properties
		view 302
		loop 2
		nsLeft 4
		nsTop 34
		downClick 207
		upClick 247
		upClickOff 0
	)

	(method (select)
		(if (and (super select: &rest) (> local363 2))
			(-- local363)
			(localproc_0)
		)
	)
)

(instance downArrow of CodeIcon
	(properties
		view 302
		loop 3
		nsLeft 4
		nsTop 67
		downClick 207
		upClick 247
		upClickOff 0
	)

	(method (select)
		(if (and (super select: &rest) (< local363 (- local364 1)))
			(++ local363)
			(localproc_0)
		)
	)
)

(instance pickIcon of CodeIcon
	(properties
		view 302
		cel 0
	)

	(method (select)
		(if (super select: &rest)
			(if (< local363 99)
				(StrAt
					local152
					local363
					(+ value (& $00f0 (StrAt local152 local363)))
				)
				(if (== local363 (- local364 1))
					(StrAt
						local152
						local364
						(& $00f0 (StrAt local152 local364))
					)
					(++ local364)
					(StrAt
						local152
						local364
						(+ 8 (& $00f0 (StrAt local152 local364)))
					)
					(++ local363)
				else
					(++ local363)
				)
				(localproc_0)
			else
				(Prints
					{Program terminated: You have reached the end of the command module length. }
				)
			)
		)
	)
)

(instance deleteIcon of CodeIcon
	(properties
		view 302
		loop 11
		nsLeft 83
		nsTop 137
	)

	(method (select &tmp temp0)
		(if (and (super select: &rest) (< 1 local363 (- local364 1)))
			(for ((= temp0 local363)) (<= temp0 local364) ((++ temp0))
				(StrAt
					local152
					temp0
					(+
						(& $000f (StrAt local152 (+ temp0 1)))
						(& $00f0 (StrAt local152 temp0))
					)
				)
			)
			(-- local364)
			(localproc_0)
		)
	)
)

(instance insert of CodeIcon
	(properties
		view 302
		loop 12
		nsLeft 118
		nsTop 137
	)

	(method (select &tmp temp0)
		(if (and (super select: &rest) (< (+ local363 1) local364 100))
			(for ((= temp0 (+ local364 1))) (> temp0 local363) ((-- temp0))
				(StrAt
					local152
					temp0
					(+
						(& $000f (StrAt local152 (- temp0 1)))
						(& $00f0 (StrAt local152 temp0))
					)
				)
			)
			(++ local364)
			(StrAt local152 local363 (& $00f0 (StrAt local152 local363)))
			(localproc_0)
		)
	)
)

(instance clearBut of CodeIcon
	(properties
		view 302
		loop 13
		nsLeft 155
		nsTop 137
		upClick 244
		upClickOff 0
	)

	(method (select)
		(if (super select: &rest)
			(localproc_1)
			(localproc_0)
		)
	)
)

(instance justDoIt of CodeIcon
	(properties
		view 302
		loop 14
		nsLeft 191
		nsTop 137
		upClick 213
		upClickOff 0
	)

	(method (select)
		(if (super select: &rest)
			(= local365 1)
			(programmer goAway:)
		)
	)
)

(instance mazeItem of CodeIcon
	(properties
		view 302
		loop 1
	)

	(method (highlight param1)
		(cond
			(param1
				(Print modeless: 1 addText: noun 1 0 value 0 0 gCurRoomNum init:)
			)
			((IsObject gModelessDialog)
				(gModelessDialog dispose:)
			)
		)
	)

	(method (select)
		(return 0)
	)
)

(instance maze of PuzzleBar
	(properties
		state 8192
		solvedFlag 9
		noun 13
		personalID 23
		idleTime 3000
	)

	(method (init &tmp temp0)
		(= puzzleCast (Set new:))
		(puzzleCast
			add: (robot setSpeed: 4 show: yourself:) (fan show: yourself:)
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(puzzleCast
				add:
					(= [local336 temp0]
						((thing new:)
							x: (+ 65 (* 17 (mod [local333 temp0] 12)))
							y: (+ 18 (* 14 (/ [local333 temp0] 12)))
							loop: (+ temp0 8)
							show:
							yourself:
						)
					)
					((terminal new:)
						x: (+ 56 (* 17 (mod [local356 temp0] 12)))
						y: (+ 11 (* 14 (/ [local356 temp0] 12)))
						show:
						yourself:
					)
			)
		)
		(= showCast 1)
		(= msgModule gCurRoomNum)
		(= window 0)
	)

	(method (show &tmp temp0 temp1 temp2)
		(DrawPic 320 -32761)
		(Animate (puzzleCast elements:) 0)
		(for ((= temp0 0)) (< temp0 6) ((++ temp0))
			(for ((= temp1 0)) (< temp1 6) ((++ temp1))
				(if (= temp2 [local297 (+ (* temp0 6) temp1)])
					(DrawCel
						320
						(/ temp2 100)
						(mod temp2 100)
						(+ 56 (* temp1 34))
						(+ 11 (* temp0 28))
						-1
					)
				)
			)
		)
		(DrawCel 320 4 0 52 179 -1)
		(Animate (puzzleCast elements:) 0)
		(super show:)
		(gCSoundFX stop: number: 0)
		(if (!= local392 -1)
			([local336 local392]
				x: (+ 65 (* 17 (mod [local333 local392] 12)))
				y: (+ 18 (* 14 (/ [local333 local392] 12)))
				signal: (& ([local336 local392] signal:) $dfff)
			)
			(= local392 -1)
		)
		(robot setMotion: 0 setScript: 0)
		(DrawPic 300 -32761)
		(return puzzleStatus)
	)

	(method (doit &tmp temp0)
		(fan setScript: fanScript)
		(= local393 1)
		(= local388 11)
		(= local389 10)
		(= local390 0)
		(if (IsObject [local336 local392])
			([local336 local392]
				signal: (& ([local336 local392] signal:) $dfff)
			)
		)
		(robot setLoop: 3 x: 235 y: 172)
		(= local392 -1)
		(= local0 0)
		(localproc_12 7)
		(= local387 1)
		(= local403 0)
		(= local394 0)
		(localproc_10)
		(robot cue:)
		(super doit:)
	)

	(method (animateOnce)
		(Palette palANIMATE 227 231 12 221 227 12 231 236 12)
		(super animateOnce: &rest)
	)

	(method (dispatchEvent event)
		(if (and puzzleStatus (& (event type:) $0105)) ; evJOYDOWN | evMOUSEKEYBOARD
			(event dispose:)
			(self goAway:)
		else
			(super dispatchEvent: event &rest)
		)
	)
)

(instance thing of Actor
	(properties
		view 321
		priority 14
		signal 16400
	)

	(method (doit)
		(if (& signal $2000)
			(= x (- (robot x:) 1))
			(= y (- (robot y:) 1))
			(= cel (robot loop:))
		)
		(super doit:)
	)

	(method (dispose)
		((maze puzzleCast:) delete: self)
		(super dispose: &rest)
		(self delete:)
	)
)

(instance terminal of Prop
	(properties
		view 320
		loop 3
	)

	(method (doit &tmp temp0)
		(cond
			(
				(or
					(<
						(= temp0
							(GetAngle (+ x 9) (+ y 7) (robot x:) (robot y:))
						)
						23
					)
					(> temp0 338)
				)
				(= cel 0)
			)
			((>= 68 temp0 23)
				(= cel 1)
			)
			((>= 113 temp0 69)
				(= cel 2)
			)
			((>= 158 temp0 114)
				(= cel 3)
			)
			((>= 203 temp0 159)
				(= cel 4)
			)
			((>= 248 temp0 204)
				(= cel 5)
			)
			((>= 293 temp0 249)
				(= cel 6)
			)
			((>= 338 temp0 294)
				(= cel 7)
			)
		)
		(super doit: &rest)
	)
)

(instance fan of Prop
	(properties
		x 13
		y 107
		view 322
		signal 16384
	)
)

(instance robot of Actor
	(properties
		x 235
		y 172
		view 321
		loop 3
		priority 13
		signal 16400
	)

	(method (cue &tmp temp0 temp1 temp2)
		(super cue:)
		(switch local391
			(1
				(if (!= (gCSoundFX number:) 188)
					(gCSoundFX number: 188 setLoop: -1 play:)
				)
				(if
					(or
						(==
							(= temp0
								(switch local390
									(0
										(if (> local388 0)
											(+ (* (- local388 1) 12) local389)
										else
											-1
										)
									)
									(1
										(if (< local389 11)
											(+ (* local388 12) local389 1)
										else
											-1
										)
									)
									(2
										(if (< local388 11)
											(+ (* (+ local388 1) 12) local389)
										else
											-1
										)
									)
									(3
										(if (> local389 0)
											(+ (* local388 12) (- local389 1))
										else
											-1
										)
									)
								)
							)
							-1
						)
						[local153 temp0]
					)
					(= local391 9)
					(self
						setCel: 0
						setLoop:
							(switch local390
								(0 3)
								(1 0)
								(2 2)
								(3 1)
							)
						setCycle: Rev
					)
					(switch local390
						(0
							(self setMotion: MoveTo x (- y 2) self)
						)
						(1
							(self setMotion: MoveTo (+ x 2) y self)
						)
						(2
							(self setMotion: MoveTo x (+ y 2) self)
						)
						(3
							(self setMotion: MoveTo (- x 2) y self)
						)
					)
				else
					(self setCel: 0 setCycle: Rev)
					(switch local390
						(0
							(-- local388)
							(self setLoop: 3 setMotion: MoveTo x (- y 14) self)
						)
						(1
							(++ local389)
							(self setLoop: 0 setMotion: MoveTo (+ x 17) y self)
						)
						(2
							(++ local388)
							(self setLoop: 2 setMotion: MoveTo x (+ y 14) self)
						)
						(3
							(-- local389)
							(self setLoop: 1 setMotion: MoveTo (- x 17) y self)
						)
					)
					(if (and (not local394) (== local362 2) (localproc_8 temp0))
						(= local394 1)
						(= local395 local387)
					)
					(localproc_10)
				)
			)
			(2
				(gCSoundFX number: 208 setLoop: 1 play:)
				(= local390 (mod (- local390 1) 4))
				(localproc_10)
				(self setCel: 2 setLoop: (+ local390 4) setCycle: Beg self)
			)
			(3
				(if (!= (gCSoundFX number:) 256)
					(gCSoundFX number: 256 setLoop: -1 play:)
				)
				(if
					(or
						(==
							(= temp0
								(switch local390
									(0
										(if (< local388 11)
											(+ (* (+ local388 1) 12) local389)
										else
											-1
										)
									)
									(1
										(if (> local389 0)
											(+ (* local388 12) (- local389 1))
										else
											-1
										)
									)
									(2
										(if (> local388 0)
											(+ (* (- local388 1) 12) local389)
										else
											-1
										)
									)
									(3
										(if (< local389 11)
											(+ (* local388 12) local389 1)
										else
											-1
										)
									)
								)
							)
							-1
						)
						[local153 temp0]
					)
					(= local391 9)
					(self
						setCel: 0
						setLoop:
							(switch local390
								(0 3)
								(1 0)
								(2 2)
								(3 1)
							)
						setCycle: Rev
					)
					(switch local390
						(0
							(self setMotion: MoveTo x (+ y 2) self)
						)
						(1
							(self setMotion: MoveTo (- x 2) y self)
						)
						(2
							(self setMotion: MoveTo x (- y 2) self)
						)
						(3
							(self setMotion: MoveTo (+ x 2) y self)
						)
					)
				else
					(self setCel: 0 setCycle: Rev)
					(switch local390
						(0
							(++ local388)
							(self setLoop: 3 setMotion: MoveTo x (+ y 14) self)
						)
						(1
							(-- local389)
							(self setLoop: 0 setMotion: MoveTo (- x 17) y self)
						)
						(2
							(-- local388)
							(self setLoop: 2 setMotion: MoveTo x (- y 14) self)
						)
						(3
							(++ local389)
							(self setLoop: 1 setMotion: MoveTo (+ x 17) y self)
						)
					)
					(if (and (not local394) (== local362 2) (localproc_8 temp0))
						(= local394 2)
						(= local395 local387)
					)
					(localproc_10)
				)
			)
			(4
				(gCSoundFX number: 208 setLoop: 1 play:)
				(self setCel: 0 setLoop: (+ local390 4))
				(= local390 (mod (+ local390 1) 4))
				(localproc_10)
				(self setCycle: End self)
			)
			(5
				(= temp0
					(switch local390
						(0
							(if (> local388 0)
								(+ (* (- local388 1) 12) local389)
							else
								-1
							)
						)
						(1
							(if (< local389 11)
								(+ (* local388 12) local389 1)
							else
								-1
							)
						)
						(2
							(if (< local388 11)
								(+ (* (+ local388 1) 12) local389)
							else
								-1
							)
						)
						(3
							(if (> local389 0)
								(+ (* local388 12) (- local389 1))
							else
								-1
							)
						)
					)
				)
				(= temp2 3)
				(= temp1 0)
				(if (!= temp0 -1)
					(for
						((= temp2 0))
						(and (< temp2 3) (not temp1))
						((++ temp2))
						
						(if (== temp0 [local333 temp2])
							(= temp1 1)
							(break)
						)
					)
				)
				(cond
					((and temp1 (!= local392 -1))
						(if (!= local392 temp2)
							(= local393 0)
							(localproc_10)
							(self setScript: bangHead self temp2)
							(= local363 local387)
							(= local403 1)
							(= local405 local388)
							(= local404 local389)
							(= local406 local390)
						else
							(localproc_10)
							(self setScript: (pickUpObject new:) self)
						)
					)
					(temp1
						(= local392 temp2)
						(localproc_10)
						(self setScript: (pickUpObject new:) self)
					)
					(else
						(localproc_10)
						(self setScript: (pickUpObject new:) self)
					)
				)
			)
			(6
				(= temp0
					(switch local390
						(0
							(if (> local388 0)
								(+ (* (- local388 1) 12) local389)
							else
								-1
							)
						)
						(1
							(if (< local389 11)
								(+ (* local388 12) local389 1)
							else
								-1
							)
						)
						(2
							(cond
								((== (+ (* local388 12) local389) 142) 999)
								((< local388 11)
									(+ (* (+ local388 1) 12) local389)
								)
								(else -1)
							)
						)
						(3
							(if (> local389 0)
								(+ (* local388 12) (- local389 1))
							else
								-1
							)
						)
					)
				)
				(if (and (!= local392 -1) (== temp0 -1))
					(Prints {Out of bounds})
					(= local393 0)
					(localproc_10)
					(self cue:)
				else
					(localproc_10)
					(self
						setScript:
							(dropObject new:)
							(if (or (== local392 -1) (!= temp0 999))
								self
							else
								0
							)
							temp0
					)
				)
			)
			(7
				(maze puzzleStatus: 2 goAway:)
			)
			(8
				(Prints {end program})
				(gCSoundFX stop:)
				(maze puzzleStatus: 2 goAway:)
			)
			(9
				(gCSoundFX number: 149 setLoop: 1 play:)
				(if (or (== local390 0) (== local390 2))
					(ShakeScreen 5 ssUPDOWN)
				else
					(ShakeScreen 5 ssLEFTRIGHT)
				)
				(= local393 0)
				(= local363 local387)
				(= local403 1)
				(= local405 local388)
				(= local404 local389)
				(= local406 local390)
				(localproc_13)
				(localproc_10)
				(self
					setMotion:
						MoveTo
						(+ 65 (* 17 local389))
						(+ 18 (* 14 local388))
						self
				)
			)
			(10
				(localproc_10)
				(Print
					addText: {Looks like the all new\nIsland of Dr. Brain} 0 62
					width: 100
					addIcon: 320 5 0 0 0
					init: self
				)
			)
			(else
				(localproc_10)
				(self cue:)
			)
		)
	)
)

(instance pickUpObject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot
					setLoop:
						(switch local390
							(0 13)
							(1 11)
							(2 14)
							(3 12)
						)
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot setCel: 5)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 11))
						)
						(1
							([local336 local392] x: (+ (robot x:) 15))
						)
						(2
							([local336 local392] y: (+ (robot y:) 11))
						)
						(3
							([local336 local392] x: (- (robot x:) 15))
						)
					)
				)
				(= ticks 10)
			)
			(2
				(robot setCel: 6)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 9))
						)
						(1
							([local336 local392] x: (+ (robot x:) 11))
						)
						(2
							([local336 local392] y: (+ (robot y:) 9))
						)
						(3
							([local336 local392] x: (- (robot x:) 11))
						)
					)
				)
				(= ticks 10)
			)
			(3
				(robot setCel: 7)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 6))
						)
						(1
							([local336 local392] x: (+ (robot x:) 6))
						)
						(2
							([local336 local392] y: (+ (robot y:) 6))
						)
						(3
							([local336 local392] x: (- (robot x:) 6))
						)
					)
				)
				(= ticks 10)
			)
			(4
				(robot setCel: 8)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 2))
						)
						(1
							([local336 local392] x: (+ (robot x:) 2))
						)
						(2
							([local336 local392] y: (+ (robot y:) 2))
						)
						(3
							([local336 local392] x: (- (robot x:) 2))
						)
					)
				)
				(= ticks 10)
			)
			(5
				(if (!= local392 -1)
					([local336 local392]
						signal: (| ([local336 local392] signal:) $2000)
					)
				)
				(robot setCycle: CT 10 1 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance dropObject of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= local392 -1)
					([local336 local392]
						signal: (& ([local336 local392] signal:) $dfff)
					)
				)
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot
					setLoop:
						(switch local390
							(0 13)
							(1 11)
							(2 14)
							(3 12)
						)
					setCel: 10
					setCycle: CT 8 -1 self
				)
			)
			(1
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot setCel: 8)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 2))
						)
						(1
							([local336 local392] x: (+ (robot x:) 2))
						)
						(2
							([local336 local392] y: (+ (robot y:) 2))
						)
						(3
							([local336 local392] x: (- (robot x:) 2))
						)
					)
				)
				(= ticks 10)
			)
			(2
				(robot setCel: 7)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 6))
						)
						(1
							([local336 local392] x: (+ (robot x:) 6))
						)
						(2
							([local336 local392] y: (+ (robot y:) 6))
						)
						(3
							([local336 local392] x: (- (robot x:) 6))
						)
					)
				)
				(= ticks 10)
			)
			(3
				(robot setCel: 6)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 9))
						)
						(1
							([local336 local392] x: (+ (robot x:) 11))
						)
						(2
							([local336 local392] y: (+ (robot y:) 9))
						)
						(3
							([local336 local392] x: (- (robot x:) 11))
						)
					)
				)
				(= ticks 10)
			)
			(4
				(robot setCel: 5)
				(if (!= local392 -1)
					(switch local390
						(0
							([local336 local392] y: (- (robot y:) 11))
						)
						(1
							([local336 local392] x: (+ (robot x:) 15))
						)
						(2
							([local336 local392] y: (+ (robot y:) 11))
						)
						(3
							([local336 local392] x: (- (robot x:) 15))
						)
					)
				)
				(= ticks 10)
			)
			(5
				(if (!= local392 -1)
					(= [local333 local392] register)
					([local336 local392]
						x: (+ 65 (* 17 (mod [local333 local392] 12)))
						y: (+ 18 (* 14 (/ [local333 local392] 12)))
						cel: 0
					)
				)
				(robot setCycle: CT 0 -1 self)
			)
			(6
				(if (!= local392 -1)
					(if (== register 999)
						([local336 local392] dispose:)
						(= [local333 local392] -1)
						(-- [global184 local362])
						(if (not (IsFlag (programmer solvedFlag:)))
							(gEgo get: [local398 global187])
						)
						(++ global187)
						(= local407 0)
						(local402 nsLeft: 209 nsTop: 118 cel: 8)
						(Say maze 13 1 8 global187)
						(if (>= (++ local401) 3)
							(maze solvePuzzle:)
						else
							(maze puzzleStatus: 2 goAway:)
						)
					)
					(= local392 -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance bangHead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot
					setLoop:
						(switch local390
							(0 13)
							(1 11)
							(2 14)
							(3 12)
						)
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot setCel: 5)
				(switch local390
					(0
						([local336 register] y: (- (robot y:) 11))
					)
					(1
						([local336 register] x: (+ (robot x:) 15))
					)
					(2
						([local336 register] y: (+ (robot y:) 11))
					)
					(3
						([local336 register] x: (- (robot x:) 15))
					)
				)
				(= ticks 10)
			)
			(2
				(robot setCel: 6)
				(switch local390
					(0
						([local336 register] y: (- (robot y:) 9))
					)
					(1
						([local336 register] x: (+ (robot x:) 11))
					)
					(2
						([local336 register] y: (+ (robot y:) 9))
					)
					(3
						([local336 register] x: (- (robot x:) 11))
					)
				)
				(= ticks 10)
			)
			(3
				(robot setCel: 7)
				(switch local390
					(0
						([local336 register] y: (- (robot y:) 6))
					)
					(1
						([local336 register] x: (+ (robot x:) 6))
					)
					(2
						([local336 register] y: (+ (robot y:) 6))
					)
					(3
						([local336 register] x: (- (robot x:) 6))
					)
				)
				(= ticks 10)
			)
			(4
				(gCSoundFX number: 249 setLoop: 1 play: self)
			)
			(5
				(gCSoundFX number: 115 setLoop: 1 play:)
				(robot setCel: 6)
				(switch local390
					(0
						([local336 register] y: (- (robot y:) 9))
					)
					(1
						([local336 register] x: (+ (robot x:) 11))
					)
					(2
						([local336 register] y: (+ (robot y:) 9))
					)
					(3
						([local336 register] x: (- (robot x:) 11))
					)
				)
				(= ticks 10)
			)
			(6
				(robot setCel: 5)
				(switch local390
					(0
						([local336 register] y: (- (robot y:) 11))
					)
					(1
						([local336 register] x: (+ (robot x:) 15))
					)
					(2
						([local336 register] y: (+ (robot y:) 11))
					)
					(3
						([local336 register] x: (- (robot x:) 15))
					)
				)
				(= ticks 10)
			)
			(7
				([local336 register]
					x: (+ 65 (* 17 (mod [local333 register] 12)))
					y: (+ 18 (* 14 (/ [local333 register] 12)))
					cel: 0
				)
				(robot setCycle: CT 0 -1 self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance fanScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(fan loop: 0 cel: 0)
				(= ticks (Random 60 150))
			)
			(1
				(fan setCycle: End self)
			)
			(2
				(fan loop: 1 setCycle: Fwd)
				(= ticks (Random 60 150))
			)
			(3
				(= state -1)
				(fan loop: 0 cel: 10 setCycle: Beg self)
			)
		)
	)
)

