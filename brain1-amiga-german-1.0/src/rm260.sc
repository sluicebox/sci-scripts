;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use dummyClient)
(use Interface)
(use Language)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm260 0
)

(local
	local0
	local1
	local2
	local3
	[local4 17] = [145 185 97 97 97 55 55 55 152 152 194 194 278 278 278 278 217]
	[local21 17] = [127 127 127 163 102 102 61 33 57 33 57 101 33 78 127 153 153]
	[local38 17]
	[local55 5] = [185 35 116 241 217]
	[local60 5] = [153 163 33 57 170]
	[local65 6] = [152 55 215 278 252 246]
	[local71 6] = [102 47 33 103 127 153]
	[local77 6]
	[local83 6] = [1 1 0 0 0 1]
	[local89 5] = [55 242 229 216 278]
	[local94 5] = [126 101 78 127 167]
	[local99 10] = [1 2 2 3 3 4 5 -1 4 3]
	[local109 5] = [{Multiply} {Apply CPU} {It has square roots} {They're afraid of short circuits} {A cowculator}]
	[local114 5] = [{Multiplizieren} {CPU anwenden} {Sie hat Quadratwurzeln} {Um Kurzschl\81sse zu vermeiden} {Einen Kuhculator}]
	[local119 5] = [3 3 180 180 3]
	[local124 5] = [1 2 4 8 16]
	[local129 4] = [6 4 7 5]
	[local133 17]
	[local150 5]
	local155
	local156
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(if (not (& local2 $0002))
		(= temp0 0)
		(= temp1 (robot x:))
		(= temp2 (robot y:))
		(while
			(and
				(< temp0 17)
				(not (and (== temp1 [local4 temp0]) (== temp2 [local21 temp0])))
			)
			(++ temp0)
		)
		(if (and (< temp0 17) [local38 temp0])
			(robot setScript: turnRight)
			(robotMakesTurn play:)
			(|= local2 $0002)
			(return 1)
		else
			(return 0)
		)
	)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2)
	(if (not (& local2 $0001))
		(= temp0 0)
		(= temp1 (robot x:))
		(= temp2 (robot y:))
		(while
			(and
				(< temp0 6)
				(not
					(and (== temp1 [local65 temp0]) (== temp2 [local71 temp0]))
				)
			)
			(++ temp0)
		)
		(if (< temp0 6)
			(= local2 1)
			(if ([local77 temp0] cycler:)
				(robotHitWarp play:)
				(robot setScript: transportRobot)
				(return 1)
			else
				(return 0)
			)
		else
			(return 0)
		)
	)
)

(procedure (localproc_2 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
	(if (not (& local2 $0004))
		(= temp0 0)
		(= temp2 (robot x:))
		(= temp3 (robot y:))
		(while
			(and
				(< temp0 5)
				(not
					(and (== temp2 [local89 temp0]) (== temp3 [local94 temp0]))
				)
			)
			(++ temp0)
		)
		(if (< temp0 5)
			(robotHitSwitch play:)
			(= temp5 (- [local89 temp0] 7))
			(= temp4 (- [local94 temp0] 7))
			(DrawCel 260 1 1 temp5 temp4 10)
			(Animate (gCast elements:) 0)
			(= temp1 (* temp0 2))
			(localproc_7 [local99 temp1])
			(localproc_7 [local99 (++ temp1)])
			(Wait 0)
			(Wait 5)
			(DrawCel 260 1 0 temp5 temp4 10)
			(robot setScript: turnRobotAround)
			(= local2 4)
		)
	)
)

(procedure (localproc_3 param1 &tmp [temp0 150] temp150 temp151)
	(= temp150 (- [local55 param1] 8))
	(= temp151 (- [local60 param1] 7))
	(Graph grRESTORE_BOX [local150 param1])
	(Graph grUPDATE_BOX temp151 temp150 (+ temp151 14) (+ temp150 17) 1)
	(= [local150 param1]
		(Graph grSAVE_BOX temp151 temp150 (+ temp151 14) (+ temp150 16) 1)
	)
	(DrawCel 260 3 1 temp150 temp151 10)
	(Format @temp0 260 0 (localproc_8 param1) (localproc_8 param1)) ; "Writing "%s" to Data Card"
	(Print @temp0 #at -1 [local119 param1] #time 3 #dispose)
	(++ global176)
	(|= global166 [local124 param1])
	(Graph grRESTORE_BOX [local150 param1])
	(Graph grUPDATE_BOX temp151 temp150 (+ temp151 14) (+ temp150 17) 1)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(= temp1 (robot x:))
	(= temp2 (robot y:))
	(while
		(and
			(< temp0 5)
			(not (and (== temp1 [local55 temp0]) (== temp2 [local60 temp0])))
		)
		(++ temp0)
	)
	(if (and (< temp0 5) (not (& global166 [local124 temp0])))
		(localproc_3 temp0)
		(= local2 0)
		(robotOnA play:)
		(clue dispose:)
	)
)

(procedure (localproc_5)
	(Wait 0)
	(Wait 45)
	(if (>= global176 (+ global114 3))
		(proc5_0 54)
	)
	(proc5_9 260 1) ; "Congratulations! You helped the robot get out of the maze."
	(gCurRoom newRoom: 220)
)

(procedure (localproc_6)
	(switch local0
		(0
			(robot setMotion: MoveTo (robot x:) 0)
		)
		(1
			(robot setMotion: MoveTo 290 (robot y:))
		)
		(2
			(robot setMotion: MoveTo (robot x:) 190)
		)
		(3
			(robot setMotion: MoveTo 0 (robot y:))
		)
	)
)

(procedure (localproc_7 param1)
	(if (>= param1 0)
		(if ([local77 param1] cycler:)
			([local77 param1] setCel: 0 setCycle: 0)
		else
			([local77 param1] setCel: -1 setCycle: Fwd)
		)
	)
)

(procedure (localproc_8 param1)
	(if (== (gGame printLang:) 1)
		(return [local109 param1])
	else
		(return [local114 param1])
	)
)

(instance rm260 of Rm
	(properties
		lookStr {A small robot is moving through a maze. It's a pretty stupid robot, and looks like it could use your help.}
		picture 260
		style 7
		south 220
	)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(LoadMany rsSOUND 261 262 263 264 265 266 53)
		(gCMusic number: 260 setLoop: -1 flags: 1 play:)
		(robot
			init:
			setCycle: Walk
			signal: (| (robot signal:) $0013)
			setMotion: MoveTo (robot x:) 0
		)
		(for ((= local1 0)) (< local1 17) ((++ local1))
			(= [local38 local1] 0)
			(= temp1 (- [local4 local1] 7))
			(= temp0 (- [local21 local1] 6))
			(= [local133 local1]
				(Graph grSAVE_BOX temp0 temp1 (+ temp0 14) (+ temp1 15) 1)
			)
			(DrawCel 260 0 0 temp1 temp0 10)
		)
		(turner init:)
		(for ((= local1 0)) (< local1 6) ((++ local1))
			(= [local77 local1] (trap new:))
			([local77 local1]
				x: [local65 local1]
				y: [local71 local1]
				init:
				signal: (| ([local77 local1] signal:) $4000)
				setCycle: (if [local83 local1] Fwd else 0)
			)
		)
		(for ((= local1 0)) (< local1 5) ((++ local1))
			(DrawCel 260 1 0 (- [local89 local1] 7) (- [local94 local1] 7) 10)
		)
		(tSwitch init:)
		(for ((= local1 0)) (< local1 5) ((++ local1))
			(if (not (& global166 [local124 local1]))
				(= temp1 (- [local55 local1] 8))
				(= temp0 (- [local60 local1] 7))
				(= [local150 local1]
					(Graph grSAVE_BOX temp0 temp1 (+ temp0 14) (+ temp1 16) 1)
				)
				(DrawCel 260 3 0 temp1 temp0 10)
			)
		)
		(clue init:)
		(quitSquare init:)
		(helpSquare init:)
		(endSquare init:)
		(startSquare init:)
		(hintCoin init:)
		(= local0 0)
		(= local155 global114)
		(localproc_6)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if local156
			(= local156 0)
			(for ((= local1 0)) (< local1 17) ((++ local1))
				(= temp0 [local38 local1])
				(= temp1 (- [local4 local1] 7))
				(= temp2 (- [local21 local1] 6))
				(= [local133 local1]
					(Graph grSAVE_BOX temp2 temp1 (+ temp2 14) (+ temp1 15) 1)
				)
				(DrawCel 260 0 temp0 temp1 temp2 10)
			)
			(for ((= local1 0)) (< local1 5) ((++ local1))
				(= temp1 (- [local89 local1] 7))
				(= temp2 (- [local94 local1] 7))
				(DrawCel 260 1 0 temp1 temp2 10)
			)
			(for ((= local1 0)) (< local1 5) ((++ local1))
				(if (not (& global166 [local124 local1]))
					(= temp1 (- [local55 local1] 8))
					(= temp2 (- [local60 local1] 7))
					(= [local150 local1]
						(Graph grSAVE_BOX temp2 temp1 (+ temp2 14) (+ temp1 16) 1)
					)
					(DrawCel 260 3 0 temp1 temp2 10)
				)
			)
			(Graph grUPDATE_BOX 24 19 186 287 1)
		)
		(if (!= local155 global114)
			(robot
				moveSpeed:
					(switch global114
						(0 3)
						(1 2)
						(2 1)
					)
			)
			(= local155 global114)
		)
		(if (GameIsRestarting)
			(= local156 1)
			(Animate (gCast elements:) 1)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gCMusic fade: 0 15 12 1)
		(super dispose: &rest)
	)
)

(instance robot of Actor
	(properties
		x 145
		y 178
		description {robot}
		yStep 1
		view 265
		loop 2
		priority 14
		illegalBits 0
		xStep 1
		moveSpeed 2
	)

	(method (init)
		(= moveSpeed
			(switch global114
				(0 3)
				(1 2)
				(2 1)
			)
		)
		(super init:)
		(self baseSetter: robotBase)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc5_9 260 2) ; "This little robot is programmed to always travel in a straight line, except when it hits a wall or right turn signal. Hitting a wall will cause it to turn around in the opposite direction. The robot will turn right any time it hits a right turn signal."
			)
			(3
				(proc5_9 260 3) ; "You can't do anything to the robot directly. The only controls you can manipulate are the right turn markers at each intersection in the maze."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(= temp1 0)
		(if (and (= temp0 (robot onControl:)) (not (robot script:)))
			(cond
				((& temp0 $0200)
					(localproc_2)
				)
				((and (& temp0 $0010) (= temp1 1) (localproc_0)))
				((and (& temp0 $0400) (= temp1 1) (localproc_1)))
				((& temp0 $0100)
					(gCMusic2 number: 53 setLoop: 1 flags: 1 play:)
					(localproc_5)
				)
				((& (robot onControl:) $1000)
					(if (not (& local2 $0008))
						(robot setScript: turnRobotAround)
						(robotHitWall play:)
						(robotMakesTurn play:)
						(= local2 (| (|= local2 $0008) $0002))
					)
				)
				((& temp0 $0800)
					(localproc_4)
				)
				(temp1)
				(else
					(= local2 0)
				)
			)
		)
	)
)

(instance robotHitWall of Sound
	(properties
		flags 1
		number 261
	)
)

(instance robotOnA of Sound
	(properties
		flags 1
		number 262
	)
)

(instance robotHitSwitch of Sound
	(properties
		flags 1
		number 263
	)
)

(instance robotHitWarp of Sound
	(properties
		flags 1
		number 264
	)
)

(instance robotMakesTurn of Sound
	(properties
		flags 1
		number 265
	)
)

(instance clickTurnPiece of Sound
	(properties
		flags 1
		number 266
	)
)

(instance robotBase of Code
	(properties)

	(method (doit param1)
		(param1
			brTop: (+ (param1 nsTop:) 1)
			brLeft: (+ (param1 nsLeft:) 1)
			brBottom: (param1 nsBottom:)
			brRight: (+ (param1 nsRight:) 1)
		)
	)
)

(instance endSquare of Feature
	(properties
		nsTop 177
		nsLeft 208
		nsBottom 185
		nsRight 224
		description {end square}
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 260 4) ; "This is the maze exit. You want to help the robot get here."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance startSquare of Feature
	(properties
		nsTop 172
		nsLeft 136
		nsBottom 185
		nsRight 152
		description {start square}
		onMeCheck 8192
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 260 5) ; "This is where the robot starts the maze. It also returns here whenever it hits an active transport spiral."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance trap of Prop
	(properties
		description {a trap}
		onMeCheck 1024
		view 260
		loop 2
	)

	(method (doVerb theVerb)
		(cond
			((!= theVerb 2)
				(super doVerb: theVerb &rest)
			)
			((IsObject cycler)
				(proc5_9 260 6) ; "This transporter is active. It would probably be a good idea to keep the robot away from here."
			)
			(else
				(proc5_9 260 7) ; "This transporter is off right now."
			)
		)
	)
)

(instance tSwitch of Feature
	(properties
		description {a switch}
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 260 8) ; "When the robot runs over this switch, it will turn one or more of the transport traps Off or On."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance clue of Feature
	(properties
		description {a clue square}
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(Print 260 9) ; "When the robot runs over this square, the maze computer will write a Robot Riddle answer to your data card."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance turner of Feature
	(properties
		description {right turn square}
		onMeCheck 16
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 -1)
		(= temp1 0)
		(= temp2 (Event new:))
		(= temp3 (temp2 x:))
		(= temp4 (- (temp2 y:) 10))
		(temp2 dispose:)
		(while (and (not temp1) (< (++ temp0) 17))
			(if
				(and
					(<= (- [local4 temp0] 9) temp3 (+ [local4 temp0] 9))
					(<= (- [local21 temp0] 8) temp4 (+ [local21 temp0] 8))
				)
				(= temp1 1)
			)
		)
		(if (IsObject gModelessDialog)
			(gModelessDialog dispose:)
		)
		(cond
			((== theVerb 2)
				(if temp1
					(if [local38 temp0]
						(proc5_9 260 10) ; "This is a right turn signal. When the robot hits this signal, it will turn right. (If this makes it hit a wall, it will bounce off and go the opposite direction.)"
					else
						(proc5_9 260 11) ; "Click the hand here to cause the robot to turn right when it hits the signal. Right now, the signal is inactive."
					)
				)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(temp1
				(= temp5 (- [local4 temp0] 7))
				(= temp6 (- [local21 temp0] 6))
				(clickTurnPiece play:)
				(if [local38 temp0]
					(= [local38 temp0] 0)
					(Graph grRESTORE_BOX [local133 temp0])
					(Graph grUPDATE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					(= [local133 temp0]
						(Graph grSAVE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					)
					(DrawCel 260 0 0 temp5 temp6 10)
				else
					(= [local38 temp0] 1)
					(Graph grRESTORE_BOX [local133 temp0])
					(Graph grUPDATE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					(= [local133 temp0]
						(Graph grSAVE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					)
					(DrawCel 260 0 1 temp5 temp6 10)
				)
			)
		)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (IsObject param1)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (& onMeCheck (OnControl CONTROL temp0 temp1)))
	)
)

(instance hintCoin of Feature
	(properties
		x 85
		y 19
		nsTop 4
		nsLeft 73
		nsBottom 20
		nsRight 96
		description {a hint slot}
		onMeCheck 2
	)

	(method (doVerb theVerb invItem &tmp [temp0 250])
		(cond
			(local156
				(super doVerb: theVerb invItem &rest)
			)
			((== theVerb 2)
				(Print 260 12) ; "You can put a hint coin in here to buy an answer."
			)
			((not (or (== theVerb 3) (and (== theVerb 4) (== invItem 0))))
				(super doVerb: theVerb invItem &rest)
			)
			((not global115)
				(proc5_9 260 13) ; "You are out of hint coins."
			)
			((== global166 31)
				(proc5_9 260 14) ; "You can't buy any more hints here."
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (not (-- global115))
					(gEgo put: 0)
					(proc5_9 260 15) ; "You insert your last hint coin in the slot."
				else
					(Format ; "You insert a hint coin in the slot. You have %d hint coin%sleft."
						@temp0
						260
						16
						global115
						(if (== global115 1)
							{ }
						else
							(LangSwitch {s } {n})
						)
						global115
						(if (== global115 1)
							{ }
						else
							(LangSwitch {s } {n})
						)
					)
					(proc5_11 @temp0)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(for ((= local1 0)) (< local1 5) ((++ local1))
					(if (not (& global166 [local124 local1]))
						(localproc_3 local1)
						(break)
					)
				)
			)
		)
	)
)

(instance quitSquare of Feature
	(properties
		x 158
		y 19
		nsTop 4
		nsLeft 108
		nsBottom 20
		nsRight 208
		description {a quit button}
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 2)
				(Print 260 17) ; "Click here to return to the hallway."
			)
			((== theVerb 3)
				(gCurRoom newRoom: 220)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance helpSquare of Feature
	(properties
		x 231
		y 19
		nsTop 4
		nsLeft 220
		nsBottom 20
		nsRight 243
		description {instructions}
		onMeCheck 8
	)

	(method (doVerb)
		(proc5_9 260 18) ; "Help the robot travel through the maze by clicking on intersections. At an "active" intersection, the robot will turn right. At "inactive" intersections, the robot goes straight. Get the robot to pass over as many "A" squares as possible -- they will write Robot Riddle answers to your data card."
		(proc5_9 260 19) ; "Watch out for the red and white spirals -- they are traps which will transport the robot back to the beginning of the maze. When the robot runs over a switch, one or more of the traps will turn on -- or off."
	)
)

(instance transportRobot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robot setLoop: 8 cel: 0 setMotion: 0 setCycle: End self)
			)
			(1
				(= ticks 60)
			)
			(2
				(robot x: 145 y: 178 setLoop: -1 setCycle: Beg self)
			)
			(3
				(robot
					loop: 2
					cel: 0
					setCycle: Walk
					setMotion: MoveTo (robot x:) 0
				)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

(instance turnRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robot
					setLoop: [local129 local0]
					cel: 0
					setCycle: CT 2 1 self
					setMotion: 0
				)
			)
			(1
				(= local0 (mod (+ local0 1) 4))
				(robot setLoop: -1 setCycle: Walk)
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

(instance turnRobotAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robot
					setLoop: [local129 local0]
					cel: 0
					setCycle: End self
					setMotion: 0
				)
			)
			(1
				(= local0 (mod (+ local0 2) 4))
				(robot setLoop: -1 setCycle: Walk)
				(localproc_6)
				(self dispose:)
			)
		)
	)
)

