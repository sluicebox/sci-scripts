;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 490)
(include sci.sh)
(use Main)
(use n013)
(use Array)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	bayouMaze 0
	passageExit 1
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	local5
	local6
	local7 = 1
	local8 = -1
	local9 = -1
	local10 = 301
	local11 = 162
	local12
	local13
	local14
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1 temp2)
	(= temp1 8)
	(if (> argc 2)
		(= temp0 [param2 1])
		(if (> argc 3)
			(= temp1 [param2 2])
		)
	else
		(= temp0 1)
	)
	(= temp2 (Abs (- param1 param2)))
	(return
		(if (<= (= temp2 (Min temp2 (Abs (- temp1 temp2)))) temp0)
			1
		else
			0
		)
	)
)

(procedure (localproc_1 &tmp [temp0 3])
	(local2 dispose:)
	(= local2 local3)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2 temp3)
	(switch
		(= temp1
			(if (and (> argc 1) (>= param2 0))
				param2
			else
				(= temp3 (mod (+ 4 param1) 8))
				(cond
					(
						(or
							(==
								(= temp2
									(if (> argc 1)
										(mod (- (* 2 param2)) 8)
									else
										-1
									)
								)
								-1
							)
							(not (localproc_0 temp2 temp3))
						)
						(/
							(mod
								(+=
									temp3
									(* (mod temp3 2) (if (Random 0 1) 1 else 7))
								)
								8
							)
							2
						)
					)
					((== temp3 temp2)
						(/ (mod (+ 2 temp3) 8) 2)
					)
					((== temp2 (= temp3 (mod (+ temp3 7) 8)))
						(/ (mod (+ 2 temp3) 8) 2)
					)
					(else
						(/ temp3 2)
					)
				)
			)
		)
		(0
			(gEgo posn: 156 93)
		)
		(1
			(gEgo posn: 312 116)
		)
		(2
			(gEgo posn: 156 139)
		)
		(3
			(gEgo posn: 7 116)
		)
	)
	(gEgo setMotion: PolyPath 159 116)
)

(instance bayouMaze of Room
	(properties
		noun 1
		style 14
		exitStyle 13
	)

	(method (init)
		(gGkMusic1
			loop: -1
			number: 490
			play:
			setVol: 0
			fade: (gGkMusic1 musicVolume:) 25 10 0
		)
		(Load rsPIC 490)
		(= global178 0)
		(gEgo actions: trackerView)
		(gEgo view: 900 loop: 2 cel: 0 x: 0 y: 0 setCycle: StopWalk -1 init:)
		(= local12 (gNarrator talkWidth:))
		(super init:)
		(= curPic 490)
		(= picture 490)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 145 319 145 319 86 0 86
					yourself:
				)
		)
		(= local2 (IntArray new:))
		(= local5 (Random 10 20))
		(gGame handsOff:)
		(self setScript: roomScript)
	)

	(method (doVerb theVerb)
		(if (== theVerb 45) ; tracker
			(if local7
				(gEgo setScript: trackerOn)
			else
				(gMessager say: 8 45 14 0) ; "(RRCC)Gabriel doesn't want to turn off his only means of direction! He can follow it to get to the conclave, or go the opposite way from what it suggests to return to the Bayou exit."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(UnLoad 129 490)
		(UnLoad 128 490)
		(UnLoad 128 4803)
		(UnLoad 128 4804)
		(DisposeScript 64941)
		(gNarrator talkWidth: local12)
		(gGkMusic1 fade:)
		(if (not local7)
			(trackerView dispose:)
		)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(switch (= state newState)
			(0
				(for ((= temp1 100)) (> temp1 0) ((-= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(if local0
					(gTheDoits delete: local0)
					(local0 dispose:)
					(= local0 0)
				)
				(if local1
					(local1 dispose:)
					(= local1 0)
				)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(if local7
					(-- local4)
				else
					(= temp3 (not (= temp5 (localproc_0 local8 local9))))
					(= temp6 (== local8 local9))
					(= temp5
						(if temp5
							(not temp6)
						)
					)
					(if temp3
						(if (< local5 20)
							(++ local5)
						)
						(-- local4)
					else
						(if local5
							(-- local5)
							(if (and local5 temp6)
								(-- local5)
							)
						)
						(if (< local4 6)
							(++ local4)
						)
					)
					(= local8
						(cond
							((> local5 18) local8)
							((> local5 14)
								(if temp3
									(mod
										(+ local8 (if (Random 0 1) 1 else 7))
										8
									)
								else
									local8
								)
							)
							((> local5 10)
								(cond
									(temp3
										(mod (+ local8 5 (Random 1 5)) 8)
									)
									(temp5
										(mod (+ local8 6 (Random 1 3)) 8)
									)
									(else local8)
								)
							)
							((> local5 8)
								(cond
									(temp3
										(mod (+ local8 4 (Random 1 7)) 8)
									)
									(temp5
										(mod (+ local8 5 (Random 1 5)) 8)
									)
									(else
										(mod (+ local8 6 (Random 1 3)) 8)
									)
								)
							)
							((> local5 4)
								(if temp3
									(mod (+ local8 4 (Random 1 7)) 8)
								else
									(mod (+ local8 5 (Random 1 5)) 8)
								)
							)
							((> local5 2)
								(cond
									(temp3
										(Random 0 7)
									)
									(temp5
										(mod (+ local8 4 (Random 1 7)) 8)
									)
									(else
										(mod (+ local8 5 (Random 1 5)) 8)
									)
								)
							)
							((> local5 0)
								(Random 0 7)
							)
						)
					)
					(= temp5
						(if (> local5 (= temp3 (if (mod local8 2) 14 else 20)))
							temp3
						else
							local5
						)
					)
					(= temp7
						(cond
							((<= 1 local8 3)
								(/ (+ 1 temp5) 2)
							)
							((<= 5 local8 7)
								(- (/ (+ 1 temp5) 2))
							)
							(else 0)
						)
					)
					(= temp8
						(cond
							((<= 3 local8 5)
								(/ (+ 1 temp5) 2)
							)
							((mod (+ local8 2) 4)
								(- (/ (+ 1 temp5) 2))
							)
							(else 0)
						)
					)
					(blip posn: (+ local10 temp7) (+ local11 temp8))
				)
				(= temp0
					(cond
						(global178 global178)
						((not local5) 15)
						((not local4) 1)
						(else
							(Random 2 14)
						)
					)
				)
				(= global178 0)
				(if local6
					(cond
						((and (== temp0 1) local7)
							(gEgo loop: 0 cel: 0)
							(gMessager say: 7 0 21 0) ; "(FRUSTRATED. IN MAZE)This looks familiar.... Damn! I'm back where I started!"
						)
						((and (not (== temp0 15)) (not (Random 0 1)))
							(if
								(and
									(== local14 (= temp4 (Random 1 5)))
									(not (-= temp4 1))
								)
								(= temp4 5)
							)
							(gMessager
								say: 7 0 (if local7 9 else 12) (= local14 temp4)
							)
						)
					)
				)
				(= state (- temp0 1))
				(= ticks 1)
			)
			(1
				(= local4 (Random 4 10))
				(= local3 (IntArray with: 497 4971 4981))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 145 319 145 319 105 301 106 194 103 194 84 160 83 146 91 80 96 0 74
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9 (if local6 -3 else 3))
				(= local6 1)
				(= local1
					((List new:)
						add:
							(item1
								view: 497
								loop: 0
								cel: 0
								x: 99
								y: 85
								init:
								setPri: 3
								yourself:
							)
							(item2
								view: 4971
								loop: 0
								cel: 0
								x: 243
								y: 90
								init:
								yourself:
							)
							(item3
								view: 4981
								loop: 1
								cel: 0
								x: 227
								y: 139
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem item1)
				(UpdateScreenItem item2)
				(UpdateScreenItem item3)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:)
										init: 6
										isExit: 1
										yourself:
									)
									((passageExit new:)
										init: 7
										isExit: 1
										yourself:
									)
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 4 yourself:)
								yourself:
							)
						)
				)
			)
			(2
				(= local3 (IntArray with: 491 493))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 106 223 105 228 86 0 86
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 491
								loop: 2
								cel: 0
								x: 44
								y: 89
								init:
								yourself:
							)
							(item2
								view: 493
								loop: 0
								cel: 0
								x: 290
								y: 75
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
								yourself:
							)
						)
				)
			)
			(3
				(= local3 (IntArray with: 4971 494 4981))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 192 92 317 92 317 112 192 112
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 4971
								loop: 0
								cel: 0
								x: 246
								y: 97
								init:
								yourself:
							)
							(item2
								view: 494
								loop: 1
								cel: 0
								x: 19
								y: 81
								init:
								yourself:
							)
							(item3
								view: 4981
								loop: 1
								cel: 0
								x: 93
								y: 136
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
								yourself:
							)
						)
				)
			)
			(4
				(= local3 (IntArray with: 4981))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 4981
								loop: 3
								cel: 0
								x: 33
								y: 132
								init:
								yourself:
							)
							(item2
								view: 4981
								loop: 2
								cel: 0
								x: 311
								y: 137
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 7 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
								yourself:
							)
						)
				)
			)
			(5
				(= local3 (IntArray with: 495 496))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 79 104 170 108 178 125 64 123
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 496
								loop: 0
								cel: 0
								x: 126
								y: 77
								init:
								yourself:
							)
							(item2
								view: 495
								loop: 2
								cel: 0
								x: 232
								y: 140
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(6
				(= local3 (IntArray with: 493 494 499))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 95 105 157 117 124 131 77 123
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 493
								loop: 1
								cel: 0
								x: 250
								y: 135
								init:
								yourself:
							)
							(item2
								view: 499
								loop: 1
								cel: 0
								x: 108
								y: 73
								init:
								yourself:
							)
							(item3
								view: 494
								loop: 0
								cel: 0
								x: 310
								y: 80
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(7
				(= local3 (IntArray with: 496 498 4981))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 498
								loop: 0
								cel: 0
								x: 112
								y: 30
								init:
								yourself:
							)
							(item2
								view: 496
								loop: 0
								cel: 0
								x: 318
								y: 83
								init:
								yourself:
							)
							(item3
								view: 4981
								loop: 1
								cel: 0
								x: 276
								y: 136
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(8
				(= local3 (IntArray with: 499 4981 4982))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 103 102 163 102 170 123 91 123
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 499
								loop: 0
								cel: 0
								x: 126
								y: 80
								init:
								yourself:
							)
							(item2
								view: 4982
								loop: 1
								cel: 0
								x: 287
								y: 103
								init:
								yourself:
							)
							(item3
								view: 4981
								loop: 1
								cel: 0
								x: 39
								y: 137
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(9
				(= local3 (IntArray with: 495 496))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 65 86 79 105 0 110
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 173 136 150 129 172 114 264 113 281 130
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 495
								loop: 0
								cel: 0
								x: 32
								y: 61
								init:
								yourself:
							)
							(item2
								view: 495
								loop: 1
								cel: 0
								x: 72
								y: 137
								init:
								yourself:
							)
							(item3
								view: 496
								loop: 0
								cel: 0
								x: 230
								y: 85
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 6 yourself:)
								yourself:
							)
						)
				)
			)
			(10
				(= local3 (IntArray with: 495 496 4971))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 109 227 109 228 91 319 91 319 86 0 86 0 121 87 121 93 133 0 133
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 496
								loop: 0
								cel: 0
								x: 49
								y: 85
								init:
								yourself:
							)
							(item2
								view: 4971
								loop: 3
								cel: 0
								x: 276
								y: 91
								init:
								yourself:
							)
							(item3
								view: 495
								loop: 2
								cel: 0
								x: 138
								y: 140
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(11
				(= local3 (IntArray with: 496 4982))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 16 100 107 102 118 120 12 116
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 496
								loop: 1
								cel: 0
								x: 101
								y: 70
								init:
								yourself:
							)
							(item2
								view: 4982
								loop: 0
								cel: 0
								x: 296
								y: 146
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(12
				(= local3 (IntArray with: 493 4981))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 107 255 107 253 86 0 86
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 141 103 197 103 203 118 136 118
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 493
								loop: 0
								cel: 0
								x: 289
								y: 75
								init:
								yourself:
							)
							(item2
								view: 493
								loop: 1
								cel: 0
								x: 95
								y: 135
								init:
								yourself:
							)
							(item3
								view: 4981
								loop: 0
								cel: 0
								x: 172
								y: 84
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 3 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(13
				(= local3 (IntArray with: 4971 4981 4982))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 0 86 0 97 113 98 123 118 0 115
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 4982
								loop: 0
								cel: 0
								x: 287
								y: 146
								init:
								yourself:
							)
							(item2
								view: 4981
								loop: 4
								cel: 0
								x: 6
								y: 142
								init:
								yourself:
							)
							(item3
								view: 4971
								loop: 2
								cel: 0
								x: 57
								y: 99
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
			)
			(14
				(= local3 (IntArray with: 491 496))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 86 69 86 58 106 0 108
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9)
				(= local1
					((List new:)
						add:
							(item1
								view: 496
								loop: 1
								cel: 0
								x: 51
								y: 60
								init:
								yourself:
							)
							(item2
								view: 491
								loop: 1
								cel: 0
								x: 286
								y: 73
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:) init: 1 yourself:)
									((passageExit new:) init: 2 yourself:)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 5 yourself:)
								yourself:
							)
						)
				)
			)
			(15
				(= local3 (IntArray with: 491 492))
				(localproc_1)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 143 319 143 319 87 228 96 203 86 0 86
							yourself:
						)
				)
				(gCurRoom drawPic: 490 0)
				(localproc_2 local9 -1)
				(= local1
					((List new:)
						add:
							(item1
								view: 492
								loop: 0
								cel: 0
								x: 197
								y: 22
								init:
								setPri: 5
								yourself:
							)
							(item2
								view: 491
								loop: 0
								cel: 0
								x: 44
								y: 82
								init:
								yourself:
							)
							(item3
								view: 492
								loop: 1
								cel: 0
								x: 237
								y: 132
								init:
								yourself:
							)
						yourself:
					)
				)
				(UpdateScreenItem gEgo)
				(for ((= temp1 0)) (< temp1 100) ((+= temp1 6))
					(Palette 2 0 256 temp1) ; PalIntensity
					(FrameOut)
				)
				(gGame handsOn:)
				(gTheDoits
					add:
						(= local0
							((List new:)
								add:
									((passageExit new:) init: 0 yourself:)
									((passageExit new:)
										init: 1
										isRitual: 1
										yourself:
									)
									((passageExit new:)
										init: 2
										isRitual: 1
										yourself:
									)
									((passageExit new:) init: 4 yourself:)
									((passageExit new:) init: 6 yourself:)
									((passageExit new:) init: 7 yourself:)
								yourself:
							)
						)
				)
				(gEgo getPoints: 175 3)
				(+= local5 3)
			)
			(16
				(if local0
					(gTheDoits delete: local0)
					(local0 dispose:)
					(= local0 0)
				)
				(if (== local9 -1)
					(for ((= temp1 100)) (> temp1 0) ((-= temp1 6))
						(Palette 2 0 256 temp1) ; PalIntensity
						(FrameOut)
					)
					(gCurRoom drawPic: 99 0)
					(if local1
						(local1 dispose:)
						(= local1 0)
					)
					(= local3 (IntArray new:))
					(localproc_1)
					(local2 dispose:)
					(= local2 0)
					(gEgo posn: 0 0)
					(UpdateScreenItem gEgo)
					(gEgo actions: 0)
					(if (gTalkers size:)
						(gMessager cue: 1)
					)
					(gGkMusic1 fade:)
					(FrameOut)
					(Palette 2 0 256 100) ; PalIntensity
					(gCurRoom newRoom: 205)
				else
					(gEgo setScript: letsGo)
				)
			)
		)
	)
)

(instance trackerOn of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gNarrator talkWidth: 250)
				(= temp0
					(if (<= gDay 6)
						(if (IsFlag 114)
							(if (IsFlag 246) 13 else 16)
						else
							15
						)
					else
						20
					)
				)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gMessager say: 8 45 temp0 (if (== temp0 13) 1 else 0) self)
				(gEgo view: 4901 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(trackerView init:)
			)
			(2
				(if (and (IsFlag 114) (IsFlag 246) (<= gDay 6))
					(gEgo cel: 8 setCycle: Beg self)
				else
					(trackerView dispose:)
					(gEgo setCycle: Beg self)
					(gNarrator talkWidth: local12)
				)
			)
			(3
				(if (and (IsFlag 114) (IsFlag 246) (<= gDay 6))
					(gEgo normalize:)
					(= cycles 3)
				else
					(= cycles 1)
				)
			)
			(4
				(if (and (IsFlag 114) (IsFlag 246) (<= gDay 6))
					(gMessager say: 8 45 13 2 self) ; "(RRCC. VERY EXCITED, HAPPY)All right! There's a blip! They must be here with the sekey madoul\82!"
				else
					(= cycles 1)
				)
			)
			(5
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance letsGo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (gEgo has: 21) local13) ; crocMask
					(Load rsVIEW 480)
					(Load rsVIEW (if (IsFlag 299) 4802 else 4801))
					(gMessager say: 8 31 18 1 self) ; "(TO HIMSELF. GETTING DRESSED FOR VOODOO RITUAL)When in Rome...."
				else
					(+= state 7)
					(= cycles 1)
				)
			)
			(1
				(gEgo setMotion: MoveTo 244 107 self)
			)
			(2
				(gEgo view: 480 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(4
				(jacket
					view: (if (IsFlag 299) 4802 else 4801)
					init:
					ignoreActors:
				)
				(gEgo
					view: (if (IsFlag 299) 4802 else 4801)
					loop: 0
					cel: 0
					setCycle: End self
				)
				(Load rsVIEW 4803)
				(if (not (and (gEgo has: 21) local13)) ; crocMask
					(Load rsVIEW 4804)
				)
			)
			(5
				(UnLoad 128 480)
				(jacket view: 4803)
				(if (and (gEgo has: 21) local13) ; crocMask
					(gEgo view: 4803 loop: 0 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(6
				(UnLoad 128 (if (IsFlag 299) 4802 else 4801))
				(gEgo
					view: (if (and (gEgo has: 21) local13) 4803 else 4804) ; crocMask
					setLoop: (if (and (gEgo has: 21) local13) 2 else 0) 1 ; crocMask
					cel: 0
				)
				(gMessager say: 8 31 18 2 self) ; "Here goes nothing."
			)
			(7
				(gEgo setCycle: Fwd setMotion: MoveTo 325 87 self)
			)
			(8
				(for ((= temp0 100)) (> temp0 0) ((-= temp0 6))
					(Palette 2 0 256 temp0) ; PalIntensity
					(FrameOut)
				)
				(gCurRoom drawPic: 99 0)
				(gEgo setLoop: -1)
				(gEgo posn: 0 0)
				(UpdateScreenItem gEgo)
				(if local1
					(local1 dispose:)
					(= local1 0)
				)
				(= local3 (IntArray new:))
				(localproc_1)
				(jacket dispose:)
				(local2 dispose:)
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(gEgo put: 21) ; crocMask
				(trackerView dispose:)
				(gEgo actions: 0)
				(FrameOut)
				(Palette 2 0 256 100) ; PalIntensity
				(gGkMusic1 fade:)
				(gCurRoom newRoom: 480) ; bayouRitual
			)
		)
	)
)

(instance trackerView of View
	(properties
		x 278
		y 148
		view 490
	)

	(method (init &tmp temp0 temp1 temp2 temp3)
		(super init:)
		(|= signal $5000)
		(self setPri: 179)
		(line init: setCycle: Fwd)
		(gEgo actions: 0)
		(gEgo actions: maskAction)
		(if (or (IsFlag 246) (not (IsFlag 114)))
			(greenLED1 init: setCycle: RandCycle)
			(greenLED2 init: setCycle: Fwd)
			(redLED1 init: setCycle: Fwd)
			(redLED2 init: setCycle: Fwd)
		)
		(if (and (IsFlag 246) (IsFlag 114) (<= gDay 6))
			(= local7 0)
			(= local8 (Random 0 5))
			(= temp0
				(if (> local5 (= temp3 (if (mod local8 2) 14 else 20)))
					temp3
				else
					local5
				)
			)
			(= temp1
				(cond
					((<= 1 local8 3)
						(/ (+ 1 temp0) 2)
					)
					((<= 5 local8 7)
						(- (/ (+ 1 temp0) 2))
					)
					(else 0)
				)
			)
			(= temp2
				(cond
					((<= 3 local8 5)
						(/ (+ 1 temp0) 2)
					)
					((mod (+ local8 2) 4)
						(- (/ (+ 1 temp0) 2))
					)
					(else 0)
				)
			)
			(blip x: (+ local10 temp1) y: (+ local11 temp2) init: setCycle: Fwd)
		)
	)

	(method (doVerb theVerb)
		(if local7
			(cond
				((== theVerb 45) ; tracker
					(gEgo setScript: trackerOn)
					(return 1)
				)
				((== theVerb 31) ; crocMask
					(gMessager say: 8 31 19 0) ; "Gabriel doesn't want to put that on until he finds the ritual. It doesn't look too comfortable."
					(return 1)
				)
				(else
					(return 0)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (hide)
		(line dispose:)
		(if (or (IsFlag 246) (not (IsFlag 114)))
			(greenLED1 dispose:)
			(greenLED2 dispose:)
			(redLED1 dispose:)
			(redLED2 dispose:)
		)
		(gEgo actions: self)
		(= local7 1)
		(super hide:)
	)

	(method (dispose)
		(if local7
			(gEgo actions: self)
		)
		(= local7 1)
		(if (or (IsFlag 246) (not (IsFlag 114)))
			(greenLED1 dispose:)
			(redLED1 dispose:)
			(greenLED2 dispose:)
			(redLED2 dispose:)
		)
		(if (and (IsFlag 246) (IsFlag 114) (<= gDay 6))
			(blip dispose:)
		)
		(line dispose:)
		(super dispose:)
	)
)

(instance greenLED1 of Prop
	(properties
		x 298
		y 180
		view 490
		loop 2
		cel 2
		cycleSpeed 60
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
	)
)

(instance greenLED2 of Prop
	(properties
		x 302
		y 180
		view 490
		loop 2
		cycleSpeed 30
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
	)
)

(instance redLED1 of Prop
	(properties
		x 308
		y 180
		view 490
		loop 3
		cel 2
		cycleSpeed 15
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
	)
)

(instance redLED2 of Prop
	(properties
		x 312
		y 180
		view 490
		loop 3
		cel 1
		cycleSpeed 25
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
	)
)

(instance blip of Prop
	(properties
		x 305
		y 157
		view 490
		loop 4
		cel 1
		cycleSpeed 9
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
		(self setPri: 180)
	)
)

(instance line of Prop
	(properties
		x 283
		y 184
		view 490
		loop 1
		cel 1
		cycleSpeed 20
	)

	(method (init)
		(super init: &rest)
		(self ignoreActors:)
	)
)

(instance maskAction of View
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; crocMask
				(if (== ((gCurRoom script:) state:) 15)
					(= local13 1)
					(SetFlag 216)
					(if local0
						(gTheDoits delete: local0)
						(local0 dispose:)
						(= local0 0)
					)
					(gEgo actions: 0)
					(gEgo getPoints: -999 2)
					(gCurRoom setScript: letsGo)
					(return 1)
				else
					(gMessager say: 8 31 19 0) ; "Gabriel doesn't want to put that on until he finds the ritual. It doesn't look too comfortable."
					(return 1)
				)
			)
			(45 ; tracker
				(gMessager say: 8 45 14 0) ; "(RRCC)Gabriel doesn't want to turn off his only means of direction! He can follow it to get to the conclave, or go the opposite way from what it suggests to return to the Bayou exit."
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance item1 of View
	(properties)

	(method (init)
		(super init: &rest)
		(|= signal $5000)
		(self setPri: (Min 144 (- nsBottom 2)))
	)

	(method (doVerb theVerb)
		(return
			(if (== theVerb 45) ; tracker
				(if local7
					(gEgo setScript: trackerOn)
				else
					(gMessager say: 8 45 14 0) ; "(RRCC)Gabriel doesn't want to turn off his only means of direction! He can follow it to get to the conclave, or go the opposite way from what it suggests to return to the Bayou exit."
				)
			else
				(if (== (roomScript state:) 1)
					(if (OneOf theVerb 7 9 6 8 12) ; Look, Move, Open, Operate, Pickup
						(gMessager say: 2 theVerb 0 0)
					else
						(gMessager say: 2 0 0 0) ; "There's no way to do that with the bayou exit."
					)
					(return 1)
				)
				(if (== (roomScript state:) 15)
					(if (OneOf theVerb 7 9 6 8 12) ; Look, Move, Open, Operate, Pickup
						(gMessager say: 3 theVerb 0 0)
					else
						(gMessager say: 3 0 0 0) ; "There's no way to do that with the entrance to the ritual circle."
					)
					(return 1)
				)
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance item2 of View
	(properties)

	(method (init)
		(super init: &rest)
		(|= signal $5000)
		(self setPri: (Min 144 (- nsBottom 2)))
	)

	(method (doVerb theVerb)
		(if (== theVerb 45) ; tracker
			(if local7
				(gEgo setScript: trackerOn)
			else
				(gMessager say: 8 45 14 0) ; "(RRCC)Gabriel doesn't want to turn off his only means of direction! He can follow it to get to the conclave, or go the opposite way from what it suggests to return to the Bayou exit."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance item3 of View
	(properties)

	(method (init)
		(super init: &rest)
		(|= signal $5000)
		(self setPri: (Min 144 (- nsBottom 2)))
	)

	(method (doVerb theVerb)
		(if (== theVerb 45) ; tracker
			(if local7
				(gEgo setScript: trackerOn)
			else
				(gMessager say: 8 45 14 0) ; "(RRCC)Gabriel doesn't want to turn off his only means of direction! He can follow it to get to the conclave, or go the opposite way from what it suggests to return to the Bayou exit."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance jacket of View
	(properties
		x 265
		y 104
		view 4802
		loop 1
	)

	(method (init)
		(super init: &rest)
		(|= signal $5000)
		(self setPri: (Min 145 (- nsBottom 2)))
	)
)

(class passageExit of Feature
	(properties
		dir -1
		isExit 0
		isRitual 0
	)

	(method (init param1)
		(= dir param1)
		(= nsLeft
			(cond
				((OneOf dir 7 6 5) 0)
				((OneOf dir 0 4) 88)
				((== dir 2) 315)
				(else 225)
			)
		)
		(= nsRight
			(cond
				((OneOf dir 7 5) 87)
				((== dir 6) 4)
				((OneOf dir 0 4) 224)
				(else 319)
			)
		)
		(= nsTop
			(cond
				((OneOf dir 7 0 1) 86)
				((OneOf dir 6 2) 91)
				(else 142)
			)
		)
		(= nsBottom
			(cond
				((OneOf dir 7 0 1) 90)
				((OneOf dir 6 2) 141)
				(else 146)
			)
		)
		(super init:)
	)

	(method (doit &tmp temp0)
		(if (self onMe: gEgo)
			(gGame handsOff:)
			(= local9 dir)
			(= temp0
				(cond
					(isExit
						(= local9 -1)
						16
					)
					(isRitual 16)
					(else 0)
				)
			)
			((gCurRoom script:) state: (- temp0 1))
			(if (not gCuees)
				(= gCuees (Set new:))
			)
			(gCuees
				add: ((Cue new:) cuee: (gCurRoom script:) cuer: self yourself:)
			)
		)
	)
)

