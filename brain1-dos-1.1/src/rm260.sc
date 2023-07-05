;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use dummyClient)
(use Interface)
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
	local4
	local5
	[local6 17] = [145 185 97 97 97 55 55 55 152 152 194 194 278 278 278 278 217]
	[local23 17] = [127 127 127 163 102 102 61 33 57 33 57 101 33 78 127 153 153]
	[local40 17]
	[local57 5] = [185 35 116 241 217]
	[local62 5] = [153 163 33 57 170]
	[local67 6] = [152 55 215 278 252 246]
	[local73 6] = [102 47 33 103 127 153]
	[local79 6]
	[local85 6] = [1 1 0 0 0 1]
	[local91 5] = [55 242 229 216 278]
	[local96 5] = [126 101 78 127 167]
	[local101 10] = [1 2 2 3 3 4 5 -1 4 3]
	[local111 5] = [{Multiply} {Apply CPU} {It has square roots} {They're afraid of short circuits} {A cowculator}]
	[local116 5] = [3 3 180 180 3]
	[local121 5] = [1 2 4 8 16]
	[local126 4] = [6 4 7 5]
	[local130 17]
	[local147 5]
	local152
	local153
)

(procedure (localproc_0 &tmp temp0 temp1 temp2)
	(if (not (& local2 $0002))
		(= temp0 0)
		(= temp1 (robot x:))
		(= temp2 (robot y:))
		(while
			(and
				(< temp0 17)
				(not (and (== temp1 [local6 temp0]) (== temp2 [local23 temp0])))
			)
			(++ temp0)
		)
		(if (and (< temp0 17) [local40 temp0])
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
					(and (== temp1 [local67 temp0]) (== temp2 [local73 temp0]))
				)
			)
			(++ temp0)
		)
		(if (< temp0 6)
			(= local2 1)
			(if ([local79 temp0] cycler:)
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
					(and (== temp2 [local91 temp0]) (== temp3 [local96 temp0]))
				)
			)
			(++ temp0)
		)
		(if (< temp0 5)
			(robotHitSwitch play:)
			(= temp5 (- [local91 temp0] 7))
			(= temp4 (- [local96 temp0] 7))
			(DrawCel 260 1 1 temp5 temp4 10)
			(Animate (gCast elements:) 0)
			(= temp1 (* temp0 2))
			(localproc_7 [local101 temp1])
			(localproc_7 [local101 (++ temp1)])
			(Wait 0)
			(Wait 5)
			(DrawCel 260 1 0 temp5 temp4 10)
			(robot setScript: turnRobotAround)
			(= local2 4)
		)
	)
)

(procedure (localproc_3 param1 &tmp [temp0 30] temp30 temp31)
	(= temp30 (- [local57 param1] 8))
	(= temp31 (- [local62 param1] 7))
	(Graph grRESTORE_BOX [local147 param1])
	(Graph grUPDATE_BOX temp31 temp30 (+ temp31 14) (+ temp30 17) 1)
	(= [local147 param1] (Graph grSAVE_BOX temp31 temp30 (+ temp31 14) (+ temp30 16) 1))
	(DrawCel 260 3 1 temp30 temp31 10)
	(Format @temp0 260 0 [local111 param1]) ; "Writing "%s" to Data Card"
	(Print @temp0 #at -1 [local116 param1] #time 3 #dispose)
	(++ global176)
	(|= global166 [local121 param1])
	(Graph grRESTORE_BOX [local147 param1])
	(Graph grUPDATE_BOX temp31 temp30 (+ temp31 14) (+ temp30 17) 1)
)

(procedure (localproc_4 &tmp temp0 temp1 temp2)
	(= temp0 0)
	(= temp1 (robot x:))
	(= temp2 (robot y:))
	(while
		(and
			(< temp0 5)
			(not (and (== temp1 [local57 temp0]) (== temp2 [local62 temp0])))
		)
		(++ temp0)
	)
	(if (and (< temp0 5) (not (& global166 [local121 temp0])))
		(localproc_3 temp0)
		(= local2 0)
		(robotOnA play:)
	)
)

(procedure (localproc_5)
	(Wait 0)
	(Wait 45)
	(if (>= global176 (+ global114 3))
		(proc5_0 54)
	)
	(proc5_9 260 1)
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
		(if ([local79 param1] cycler:)
			([local79 param1] setCel: 0 setCycle: 0)
		else
			([local79 param1] setCel: -1 setCycle: Fwd)
		)
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
			(= [local40 local1] 0)
			(= temp1 (- [local6 local1] 7))
			(= temp0 (- [local23 local1] 6))
			(= [local130 local1]
				(Graph grSAVE_BOX temp0 temp1 (+ temp0 14) (+ temp1 15) 1)
			)
			(DrawCel 260 0 0 temp1 temp0 10)
		)
		(turner init:)
		(for ((= local1 0)) (< local1 6) ((++ local1))
			(= [local79 local1] (trap new:))
			([local79 local1]
				x: [local67 local1]
				y: [local73 local1]
				init:
				signal: (| ([local79 local1] signal:) $4000)
				setCycle: (if [local85 local1] Fwd else 0)
			)
		)
		(for ((= local1 0)) (< local1 5) ((++ local1))
			(DrawCel 260 1 0 (- [local91 local1] 7) (- [local96 local1] 7) 10)
		)
		(tSwitch init:)
		(for ((= local1 0)) (< local1 5) ((++ local1))
			(if (not (& global166 [local121 local1]))
				(= temp1 (- [local57 local1] 8))
				(= temp0 (- [local62 local1] 7))
				(= [local147 local1]
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
		(= local152 global114)
		(localproc_6)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(if local153
			(= local153 0)
			(for ((= local1 0)) (< local1 17) ((++ local1))
				(= temp0 [local40 local1])
				(= temp1 (- [local6 local1] 7))
				(= temp2 (- [local23 local1] 6))
				(= [local130 local1]
					(Graph grSAVE_BOX temp2 temp1 (+ temp2 14) (+ temp1 15) 1)
				)
				(DrawCel 260 0 temp0 temp1 temp2 10)
			)
			(for ((= local1 0)) (< local1 5) ((++ local1))
				(= temp1 (- [local91 local1] 7))
				(= temp2 (- [local96 local1] 7))
				(DrawCel 260 1 0 temp1 temp2 10)
			)
			(for ((= local1 0)) (< local1 5) ((++ local1))
				(if (not (& global166 [local121 local1]))
					(= temp1 (- [local57 local1] 8))
					(= temp2 (- [local62 local1] 7))
					(= [local147 local1]
						(Graph grSAVE_BOX temp2 temp1 (+ temp2 14) (+ temp1 16) 1)
					)
					(DrawCel 260 3 0 temp1 temp2 10)
				)
			)
			(Graph grUPDATE_BOX 24 19 186 287 1)
		)
		(if (!= local152 global114)
			(robot
				moveSpeed:
					(switch global114
						(0 3)
						(1 2)
						(2 1)
					)
			)
			(= local152 global114)
		)
		(if (GameIsRestarting)
			(= local153 1)
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
				(proc5_9 260 2)
			)
			(3
				(proc5_9 260 3)
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
		lookStr {This is the maze exit. You want to help the robot get here.}
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
		lookStr {This is where the robot starts the maze. It also returns here whenever it hits an active transport spiral.}
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
				(proc5_9 260 4)
			)
			(else
				(proc5_9 260 5)
			)
		)
	)
)

(instance tSwitch of Feature
	(properties
		description {a switch}
		onMeCheck 512
		lookStr {When the robot runs over this switch, it will turn one or more of the transport traps Off or On.}
	)

	(method (onMe param1 param2)
		(if (IsObject param1)
			(= local4 (param1 x:))
			(= local5 (param1 y:))
		else
			(= local4 param1)
			(= local5 param2)
		)
		(return (& onMeCheck (OnControl CONTROL local4 local5)))
	)
)

(instance clue of Feature
	(properties
		description {clue square}
		onMeCheck 2048
		lookStr {When the robot runs over this square, the maze computer will write a Robot Riddle answer to your data card.}
	)

	(method (onMe param1 param2)
		(if (IsObject param1)
			(= local4 (param1 x:))
			(= local5 (param1 y:))
		else
			(= local4 param1)
			(= local5 param2)
		)
		(return (& onMeCheck (OnControl CONTROL local4 local5)))
	)

	(method (doVerb theVerb &tmp temp0)
		(if (< global176 5)
			(cond
				((< local4 45)
					(= temp0 1)
				)
				((< local4 126)
					(= temp0 2)
				)
				((< local5 67)
					(= temp0 3)
				)
				((> local4 207)
					(= temp0 4)
				)
				(else
					(= temp0 0)
				)
			)
			(if (not (& global166 [local121 temp0]))
				(super doVerb: theVerb &rest)
			)
		)
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
					(<= (- [local6 temp0] 9) temp3 (+ [local6 temp0] 9))
					(<= (- [local23 temp0] 8) temp4 (+ [local23 temp0] 8))
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
					(if [local40 temp0]
						(proc5_9 260 6)
					else
						(proc5_9 260 7)
					)
				)
			)
			((!= theVerb 3)
				(super doVerb: theVerb &rest)
			)
			(temp1
				(= temp5 (- [local6 temp0] 7))
				(= temp6 (- [local23 temp0] 6))
				(clickTurnPiece play:)
				(if [local40 temp0]
					(= [local40 temp0] 0)
					(Graph grRESTORE_BOX [local130 temp0])
					(Graph grUPDATE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					(= [local130 temp0]
						(Graph grSAVE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					)
					(DrawCel 260 0 0 temp5 temp6 10)
				else
					(= [local40 temp0] 1)
					(Graph grRESTORE_BOX [local130 temp0])
					(Graph grUPDATE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					(= [local130 temp0]
						(Graph grSAVE_BOX temp6 temp5 (+ temp6 14) (+ temp5 15) 1)
					)
					(DrawCel 260 0 1 temp5 temp6 10)
				)
			)
		)
	)

	(method (onMe param1 param2)
		(if (IsObject param1)
			(= local4 (param1 x:))
			(= local5 (param1 y:))
		else
			(= local4 param1)
			(= local5 param2)
		)
		(return (& onMeCheck (OnControl CONTROL local4 local5)))
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
		lookStr {You can put a hint coin in here to buy an answer.}
	)

	(method (doVerb theVerb invItem &tmp [temp0 100])
		(cond
			(local153
				(super doVerb: theVerb invItem &rest)
			)
			((not (or (== theVerb 3) (and (== theVerb 4) (== invItem 0))))
				(super doVerb: theVerb invItem &rest)
			)
			((not global115)
				(proc5_9 260 8)
			)
			((== global166 31)
				(proc5_9 260 9)
			)
			(else
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(if (not (-- global115))
					(gEgo put: 0)
					(proc5_9 260 10)
				else
					(Format ; "You insert a hint coin in the slot. You have %d hint coin%sleft."
						@temp0
						260
						11
						global115
						(if (== global115 1) { } else {s })
					)
					(proc5_11 @temp0)
				)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(for ((= local1 0)) (< local1 5) ((++ local1))
					(if (not (& global166 [local121 local1]))
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
		lookStr {Click here to return to the hallway.}
	)

	(method (doVerb theVerb)
		(if (== theVerb 3)
			(gCurRoom newRoom: 220)
		else
			(super doVerb: theVerb &rest)
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
		(proc5_9 260 12)
		(proc5_9 260 13)
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
					setLoop: [local126 local0]
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
					setLoop: [local126 local0]
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

