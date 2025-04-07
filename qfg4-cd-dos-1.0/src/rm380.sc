;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use GloryRm)
(use Teller)
(use Array)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm380 0
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
)

(instance rm380 of GloryRm
	(properties
		noun 20
		picture 380
		south 280
	)

	(method (init)
		(= local7
			(IntArray
				with:
					3
					3
					240
					137
					3
					3
					226
					86
					3
					4
					203
					137
					3
					0
					203
					137
					3
					1
					203
					137
					3
					2
					203
					137
					3
					3
					167
					44
					3
					3
					162
					178
					3
					4
					162
					178
					3
					0
					162
					178
					3
					1
					162
					178
					3
					2
					162
					178
					3
					3
					94
					67
					3
					3
					56
					177
					3
					4
					56
					177
					3
					0
					56
					177
					3
					1
					56
					177
					3
					2
					56
					177
					3
					3
					14
					75
					3
					3
					-5
					76
					32768
			)
		)
		(= local8
			(IntArray
				with:
					3
					3
					245
					140
					3
					3
					226
					84
					3
					3
					200
					134
					3
					4
					200
					134
					3
					0
					200
					134
					3
					1
					200
					134
					3
					2
					200
					134
					3
					3
					232
					178
					3
					4
					232
					178
					3
					0
					232
					178
					3
					1
					232
					178
					3
					2
					232
					178
					3
					3
					265
					174
					3
					4
					265
					174
					3
					0
					265
					174
					3
					1
					265
					174
					3
					2
					265
					174
					3
					3
					293
					144
					3
					3
					325
					144
					32768
			)
		)
		(= local9
			(IntArray
				with:
					3
					3
					250
					135
					3
					3
					228
					85
					3
					3
					210
					139
					3
					4
					210
					139
					3
					0
					210
					139
					3
					1
					210
					139
					3
					2
					210
					139
					3
					3
					167
					44
					3
					3
					162
					178
					3
					4
					162
					178
					3
					0
					162
					178
					3
					1
					162
					178
					3
					2
					162
					178
					3
					3
					94
					67
					3
					3
					96
					135
					3
					4
					96
					135
					3
					0
					96
					135
					3
					1
					96
					135
					3
					2
					96
					135
					3
					3
					88
					121
					3
					3
					-5
					122
					32768
			)
		)
		(= local10
			(IntArray
				with:
					3
					3
					250
					138
					3
					3
					222
					83
					3
					3
					190
					133
					3
					4
					190
					133
					3
					0
					190
					133
					3
					1
					190
					133
					3
					2
					190
					133
					3
					3
					167
					44
					3
					3
					164
					141
					3
					4
					164
					141
					3
					0
					164
					141
					3
					1
					164
					141
					3
					2
					164
					141
					3
					3
					206
					49
					3
					3
					217
					84
					3
					3
					330
					85
					32768
			)
		)
		(= local11
			(IntArray
				with:
					3
					3
					-5
					76
					3
					3
					14
					75
					3
					3
					85
					173
					3
					4
					85
					173
					3
					0
					85
					173
					3
					1
					85
					173
					3
					2
					85
					173
					3
					3
					160
					147
					3
					3
					220
					174
					3
					4
					220
					174
					3
					0
					220
					174
					3
					1
					220
					174
					3
					2
					220
					174
					3
					3
					294
					145
					3
					3
					330
					145
					32768
			)
		)
		(= local12
			(IntArray
				with:
					3
					3
					294
					145
					3
					3
					220
					174
					3
					4
					220
					174
					3
					0
					220
					174
					3
					1
					220
					174
					3
					2
					220
					174
					3
					3
					160
					147
					3
					3
					85
					173
					3
					4
					85
					173
					3
					0
					85
					173
					3
					1
					85
					173
					3
					2
					85
					173
					3
					3
					14
					75
					3
					3
					-5
					76
					32768
			)
		)
		(= local13
			(IntArray
				with:
					3
					3
					87
					121
					3
					3
					101
					135
					3
					4
					101
					135
					3
					0
					101
					135
					3
					1
					101
					135
					3
					2
					101
					135
					3
					3
					141
					119
					3
					3
					186
					137
					3
					4
					186
					137
					3
					0
					186
					137
					3
					1
					186
					137
					3
					2
					186
					137
					3
					3
					213
					85
					3
					3
					330
					85
					32768
			)
		)
		(= local14
			(IntArray
				with:
					3
					3
					216
					85
					3
					3
					186
					137
					3
					4
					186
					137
					3
					0
					186
					137
					3
					1
					186
					137
					3
					2
					186
					137
					3
					3
					141
					119
					3
					3
					101
					135
					3
					4
					101
					135
					3
					0
					101
					135
					3
					1
					101
					135
					3
					2
					101
					135
					3
					3
					87
					121
					3
					3
					-5
					121
					32768
			)
		)
		(= local15
			(IntArray
				with:
					3
					3
					276
					148
					3
					3
					226
					86
					3
					4
					203
					137
					3
					0
					203
					137
					3
					1
					203
					137
					3
					2
					203
					137
					3
					3
					163
					92
					3
					3
					144
					180
					3
					4
					144
					180
					3
					0
					144
					180
					3
					1
					144
					180
					3
					2
					144
					180
					3
					3
					121
					90
					3
					3
					96
					167
					3
					4
					96
					167
					3
					0
					96
					167
					3
					1
					96
					167
					3
					2
					96
					167
					32768
			)
		)
		(gLongSong number: 380 setLoop: -1 play:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 294 189 200 130 185 109 179 109 170 130 133 130 130 109 123 109 107 131 11 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 88 148 151 148 151 176 81 176
					yourself:
				)
		)
		(Load rsSCRIPT 64942)
		(trapMachine init: approachVerbs: 4 19) ; Do, theRations
		(hole1 init:)
		(hole2 init:)
		(hole3 init:)
		(hole4 init:)
		(mybust init:)
		(painting init:)
		(leftDoor approachVerbs: 4 29 init:) ; Do, theKeyRing
		(rightDoor approachVerbs: 4 29 init:) ; Do, theKeyRing
		(railing init:)
		(stairs1 init:)
		(stairs2 init:)
		(endDoor approachVerbs: 4 29 init:) ; Do, theKeyRing
		(ball1 init:)
		(ball2 init:)
		(pillar1 init:)
		(pillar2 init:)
		(wheel init:)
		(lightBulb init:)
		(catcher
			cel:
				(if (IsFlag 109)
					(catcher lastCel:)
				else
					0
				)
			init:
		)
		(leftDoorTeller init: leftDoor 380 5 121)
		(rightDoorTeller init: rightDoor 380 5 120)
		(endDoorTeller init: endDoor 380 5 122)
		(switch gPrevRoomNum
			(370
				(gEgo
					x: 130
					y: 109
					init:
					setScaler: Scaler 135 71 173 108
					normalize: 2
				)
				(self setScript: from370)
			)
			(280
				(gEgo
					x: 165
					y: 210
					setScaler: Scaler 135 71 173 108
					normalize: 3
					init:
				)
				(self setScript: enterRoom)
			)
			(else
				(gEgo
					x: 165
					y: 170
					setScaler: Scaler 135 71 173 108
					normalize:
					init:
				)
				(gGlory handsOn:)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(DisposeScript 80)
		(DisposeScript 81)
		(DisposeScript 83)
		(DisposeScript 64956)
		(DisposeScript 64942)
		(local7 dispose:)
		(local8 dispose:)
		(local9 dispose:)
		(local10 dispose:)
		(local11 dispose:)
		(local12 dispose:)
		(local13 dispose:)
		(local14 dispose:)
		(local15 dispose:)
		(= script 0)
		(LoadMany 0 80 81 83 64956 64942)
		(super dispose:)
	)
)

(instance from370 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 130 109 self)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 5)
			)
			(1
				(gEgo solvePuzzle: 405 6 setMotion: PolyPath 165 170 self)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openLeftDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 51)
				(= cycles 5)
			)
			(1
				(gEgo view: 31 setLoop: 1 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 7)
				(leftDoor setCycle: End self)
			)
			(4
				(if (and (IsFlag 109) (gEgo has: 58)) ; lab-key
					(gMessager say: 3 4 28 0 self) ; "You had so much fun running the maze that you decide to try it again."
				else
					(= ticks 1)
				)
			)
			(5
				(if (IsFlag 109)
					((ScriptID 81 0) init: show: dispose:) ; maze
					(DisposeScript 81)
					(gGlory handsOn:)
					(self cue:)
				else
					(gMessager say: 3 4 2 0 self) ; "Behind the door is a sort of rat maze, but it's missing the rat (or whatever is supposed to be traversing the maze)."
				)
			)
			(6
				(leftDoor setCycle: Beg self)
			)
			(7
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance openRightDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 51)
				(if (rightDoor script:)
					(rightDoor setScript: 0)
					(local1 hide:)
					(local2 hide:)
					(local3 hide:)
					(local4 hide:)
				)
				(= cycles 5)
			)
			(1
				(gEgo view: 31 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo normalize: 6)
				(rightDoor setCycle: End self)
			)
			(4
				(if local5
					(local1 posn: 240 137 show: setCycle: MCyc local7 self)
					(local2 posn: 255 130 show: setCycle: MCyc local8)
					(local3 posn: 254 140 show: setCycle: MCyc local9)
					(local4 posn: 248 135 show: setCycle: MCyc local10)
				else
					((= local1 (Actor new:))
						view: 380
						setLoop: 3
						x: 255
						y: 130
						cycleSpeed: 8
						moveSpeed: 8
						noun: 16
						ignoreActors: 1
						init:
						setCycle: MCyc local7 self
					)
					((= local2 (Actor new:))
						view: 380
						setLoop: 3
						x: 240
						y: 137
						cycleSpeed: 8
						moveSpeed: 8
						ignoreActors: 1
						init:
						noun: 16
						setCycle: MCyc local8
					)
					((= local3 (Actor new:))
						view: 380
						setLoop: 3
						x: 248
						y: 135
						cycleSpeed: 8
						moveSpeed: 8
						noun: 16
						ignoreActors: 1
						init:
						setCycle: MCyc local9
					)
					((= local4 (Actor new:))
						view: 380
						setLoop: 3
						x: 254
						y: 140
						cycleSpeed: 8
						moveSpeed: 8
						noun: 16
						ignoreActors: 1
						init:
						setCycle: MCyc local10
					)
					(= local5 1)
				)
				(= ticks 12)
			)
			(5
				(gEgo
					view: 6
					setLoop: 1
					x: (+ (gEgo x:) 7)
					y: (- (gEgo y:) 3)
					setCycle: End self
				)
			)
			(6)
			(7
				(= seconds 4)
			)
			(8
				(gMessager say: 6 6 25 0 self) ; "Oh no! You've been Antwerped!"
			)
			(9
				(gEgo
					setLoop: 3
					x: (- (gEgo x:) 2)
					y: (+ (gEgo y:) 1)
					cel: 0
					setCycle: End self
				)
			)
			(10
				(gEgo
					x: (- (gEgo x:) 21)
					y: (+ (gEgo y:) 5)
					normalize:
					loop: 5
				)
				(rightDoor setCycle: Beg self)
			)
			(11
				(gGlory handsOn:)
				(local1 hide:)
				(local2 hide:)
				(local3 hide:)
				(local4 hide:)
				(if (not (IsFlag 109))
					(rightDoor setScript: sDoAnAntwerp)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDoAnAntwerp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 10))
			)
			(1
				(switch (= local6 (Random 1 4))
					(1
						(if
							(and
								(& local0 $0001)
								(not (IsFlag 109))
								(IsFlag 27)
							)
							(local1 show: setCycle: MCyc local15 self)
						else
							(local1
								x: -5
								y: 76
								show:
								setCycle: MCyc local11 self
							)
						)
					)
					(2
						(if
							(and
								(& local0 $0001)
								(not (IsFlag 109))
								(IsFlag 27)
							)
							(local2 show: setCycle: MCyc local15 self)
						else
							(local2
								x: 294
								y: 145
								show:
								setCycle: MCyc local12 self
							)
						)
					)
					(3
						(if
							(and
								(& local0 $0001)
								(not (IsFlag 109))
								(IsFlag 27)
							)
							(local3 show: setCycle: MCyc local15 self)
						else
							(local3
								x: 87
								y: 121
								show:
								setCycle: MCyc local13 self
							)
						)
					)
					(4
						(if
							(and
								(& local0 $0001)
								(not (IsFlag 109))
								(IsFlag 27)
							)
							(local4 show: setCycle: MCyc local15 self)
						else
							(local4
								x: 216
								y: 85
								show:
								setCycle: MCyc local14 self
							)
						)
					)
				)
			)
			(2
				(if (and (& local0 $0001) (IsFlag 27) (not (IsFlag 109)))
					(SetFlag 109)
					(gEgo solvePuzzle: 408 2)
					(catcher setCycle: End self)
					(wheel setCycle: 0)
					(lightBulb setCycle: End)
				else
					(switch local6
						(1
							(local1 hide:)
						)
						(2
							(local2 hide:)
						)
						(3
							(local3 hide:)
						)
						(4
							(local4 hide:)
						)
					)
					(= ticks 30)
				)
			)
			(3
				(if (not (IsFlag 109))
					(self changeState: 0)
				else
					(gMessager say: 4 4 1 0 self) ; "You've caught an Antwerp. It's simply amazing!"
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance bustAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 20 45))
			)
			(1
				(mybust setCycle: ForwardCounter (Random 5 9) self)
			)
			(2
				(mybust cycleSpeed: 8 setLoop: 4 cel: 0 setCycle: End self)
			)
			(3
				(mybust setLoop: 3 cycleSpeed: 16)
				(self changeState: 0)
			)
		)
	)
)

(instance openEndDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(ClearFlag 51)
				(endDoor setCycle: End self)
			)
			(1
				(if (not (IsFlag 410))
					(gMessager say: 19 6 20 1 self) ; "Great! You've managed to find Dr. Cranium's keyhole and open the door. You pass through into Dr. Cranium's private laboratory."
				else
					(= ticks 1)
				)
			)
			(2
				(gCurRoom newRoom: 370)
			)
		)
	)
)

(instance myCueObj of CueObj
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(gEgo
					setHeading:
						(GetAngle
							(gEgo x:)
							(- (gEgo y:) 77)
							(client x:)
							(client y:)
						)
						self
				)
				(gTheDoits add: self)
			)
			(2
				(= cycles 3)
			)
			(3
				(gTheDoits delete: self)
				(if (not ((client actions:) doVerb: theVerb))
					(client doVerb: theVerb)
				)
				(= state 0)
			)
		)
	)
)

(instance wheel of Prop
	(properties
		x 135
		y 135
		priority 170
		fixPriority 1
		view 386
		signal 16385
		detailLevel 3
	)
)

(instance lightBulb of Prop
	(properties
		x 106
		y 106
		priority 170
		fixPriority 1
		view 386
		loop 2
		signal 16385
		cycleSpeed 8
		detailLevel 3
	)
)

(instance catcher of Prop
	(properties
		x 89
		y 131
		priority 170
		fixPriority 1
		view 386
		loop 1
		signal 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(19 ; theRations
				(trapMachine doVerb: theVerb)
			)
			(4 ; Do
				(if (IsFlag 109)
					(gMessager say: 4 4 1 0) ; "You've caught an Antwerp. It's simply amazing!"
				else
					(super doVerb: theVerb)
				)
			)
			(1 ; Look
				(if (IsFlag 109)
					(gMessager say: 4 4 1 0) ; "You've caught an Antwerp. It's simply amazing!"
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mybust of Prop
	(properties
		noun 8
		x 290
		y 110
		view 386
		loop 3
		signal 16385
		cycleSpeed 10
	)

	(method (init)
		(super init:)
		(self setScript: bustAnim)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (script state:))
					(script changeState: 1)
				)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftDoor of Prop
	(properties
		noun 3
		approachX 75
		approachY 154
		x 42
		y 39
		view 380
		signal 16385
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(myCueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(& (gEgo state:) $0002)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gApproachCode
						(& _approachVerbs (gApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							myCueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(myCueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance rightDoor of Prop
	(properties
		noun 2
		approachX 214
		approachY 145
		x 235
		y 39
		view 380
		loop 1
		signal 16385
	)

	(method (handleEvent event)
		(if script
			(script handleEvent: event)
		)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(self isNotHidden:)
				)
				(myCueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(& (gEgo state:) $0002)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gApproachCode
						(& _approachVerbs (gApproachCode doit: (event message:)))
					)
					(gEgo
						setMotion:
							PolyPath
							approachX
							(+ (gEgo z:) approachY)
							myCueObj
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(myCueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance endDoor of Prop
	(properties
		noun 1
		approachX 130
		approachY 107
		x 140
		y 64
		view 380
		loop 2
		signal 16385
	)

	(method (doVerb theVerb)
		(if (== theVerb 29) ; theKeyRing
			(cond
				((and (IsFlag 52) (not (gEgo has: 58))) ; lab-key
					(gMessager say: 1 4 21) ; "You've uncovered a keyhole, but you don't have the proper key to open this door."
				)
				((and (not (IsFlag 52)) (gEgo has: 58)) ; lab-key
					(gGlory setCursor: gNormalCursor)
					((ScriptID 80 0) init: show: dispose:) ; swap
					(DisposeScript 80)
					(if (IsFlag 375)
						(gCurRoom setScript: openEndDoor)
					else
						(gMessager say: 1 4 22) ; "The door remains securely locked."
					)
				)
				((and (IsFlag 52) (gEgo has: 58)) ; lab-key
					(gCurRoom setScript: openEndDoor)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 29) ; Do, theKeyRing
	)
)

(instance trapMachine of Feature
	(properties
		noun 4
		nsLeft 108
		nsTop 123
		nsRight 137
		nsBottom 168
		approachX 156
		approachY 177
		x 122
		y 145
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(= temp0 0)
				(if (IsFlag 33)
					(= temp0 1)
					(if (& local0 $0001)
						(if (IsFlag 109)
							(gMessager say: 4 4 1 0) ; "You've caught an Antwerp. It's simply amazing!"
						else
							(gMessager say: 4 4 2) ; "The TRAP is baited and ready to go, but there's nary an Antwerp in sight."
						)
					else
						(gMessager say: 4 4 3) ; "You need to bait the TRAP."
					)
				else
					((ScriptID 83 0) init: show: dispose:) ; trap
					(DisposeScript 83)
				)
			)
			(19 ; theRations
				(if (IsFlag 27)
					(if (& local0 $0001)
						(gMessager say: 4 theVerb 5) ; "You've already baited the TRAP."
					else
						(|= local0 $0001)
						(gEgo drop: 4 1) ; theRations
						(wheel setCycle: Fwd)
						(lightBulb setCycle: Fwd)
						(gMessager say: 4 theVerb 6) ; "You bait the TRAP with the avocado from your sandwich. Avocado was never high on your list of favorite foods anyway."
					)
				else
					(gMessager say: noun theVerb 4) ; "You need to program the TRAP before you can bait it."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hole1 of Feature
	(properties
		noun 7
		nsLeft 4
		nsTop 59
		nsRight 25
		nsBottom 96
		x 14
		y 77
	)
)

(instance hole2 of Feature
	(properties
		noun 7
		nsLeft 284
		nsTop 126
		nsRight 305
		nsBottom 169
		x 294
		y 147
	)
)

(instance hole3 of Feature
	(properties
		noun 7
		nsLeft 84
		nsTop 115
		nsRight 91
		nsBottom 128
		x 87
		y 121
	)
)

(instance hole4 of Feature
	(properties
		noun 7
		nsLeft 212
		nsTop 77
		nsRight 220
		nsBottom 91
		x 216
		y 84
	)
)

(instance painting of Feature
	(properties
		noun 9
		nsLeft 79
		nsTop 50
		nsRight 99
		nsBottom 108
		x 89
		y 79
	)
)

(instance railing of Feature
	(properties
		noun 11
		nsLeft 133
		nsTop 98
		nsRight 175
		nsBottom 117
		x 154
		y 107
	)
)

(instance stairs1 of Feature
	(properties
		noun 10
		nsLeft 101
		nsTop 108
		nsRight 141
		nsBottom 128
		x 121
		y 118
	)
)

(instance stairs2 of Feature
	(properties
		noun 10
		nsLeft 166
		nsTop 109
		nsRight 206
		nsBottom 130
		x 186
		y 119
	)
)

(instance ball1 of Feature
	(properties
		noun 12
		nsLeft 104
		nsTop 38
		nsRight 121
		nsBottom 50
		x 112
		y 44
	)
)

(instance ball2 of Feature
	(properties
		noun 12
		nsLeft 184
		nsTop 37
		nsRight 200
		nsBottom 49
		x 192
		y 43
	)
)

(instance pillar1 of Feature
	(properties
		noun 13
		nsLeft 102
		nsTop 50
		nsRight 120
		nsBottom 109
		x 111
		y 79
	)
)

(instance pillar2 of Feature
	(properties
		noun 14
		nsLeft 182
		nsTop 49
		nsRight 204
		nsBottom 109
		x 193
		y 79
	)
)

(instance leftDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 10 (gEgo has: 13)) ; Unlock, theLockpick
	)

	(method (sayMessage)
		(if (== iconValue 7) ; Open
			(gCurRoom setScript: openLeftDoor)
		else
			(super sayMessage:)
		)
	)
)

(instance rightDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 10 (gEgo has: 13)) ; Pick Lock, theLockpick
	)

	(method (sayMessage)
		(if (== iconValue 7) ; Open
			(gCurRoom setScript: openRightDoor)
		else
			(super sayMessage:)
		)
	)
)

(instance endDoorTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 7 0 10 (gEgo has: 13)) ; Open, Pick Lock, theLockpick
	)

	(method (sayMessage)
		(if (== iconValue 11) ; Unlock
			(self clean:)
			(if (and (IsFlag 52) (gEgo has: 58)) ; lab-key
				(gCurRoom setScript: openEndDoor)
			else
				((ScriptID 80 0) init: show: dispose:) ; swap
				(DisposeScript 80)
				(if (IsFlag 375)
					(if (gEgo has: 58) ; lab-key
						(gCurRoom setScript: openEndDoor)
					else
						(gMessager say: 1 4 21) ; "You've uncovered a keyhole, but you don't have the proper key to open this door."
					)
				else
					(gMessager say: 1 4 22) ; "The door remains securely locked."
				)
			)
		else
			(super sayMessage:)
		)
	)
)

