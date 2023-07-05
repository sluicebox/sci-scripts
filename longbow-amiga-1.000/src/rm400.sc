;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use n013)
(use Interface)
(use verseScript)
(use RTEyeCycle)
(use Polygon)
(use Feature)
(use MoveFwd)
(use Track)
(use Rev)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm400 0
	proc400_1 1
	sheriff 2
	table 3
	guards 4
	giles 5
	roger 6
	proc400_7 7
	proc400_8 8
)

(local
	[local0 4] = [1400 0 1 0]
	[local4 4] = [1400 1 1 0]
	[local8 4] = [1400 2 1 0]
	[local12 13] = [1400 3 1 0 -1 {Hubert} 19 0 0 0 0 0 0]
	[local25 4] = [1400 4 1 0]
)

(procedure (localproc_0 param1) ; UNUSED
	(Converse 3 param1 999 3 12 1 18 2 &rest)
)

(procedure (proc400_1 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (if (>= argc 1) param1 else gEgo))
	(= temp1 (if (>= argc 2) param2 else 10))
	(= temp2 (if (>= argc 3) param3))
	(cond
		(
			(= temp3
				(if (temp2 respondsTo: #notKilled)
					(temp2 notKilled:)
				)
			)
			(temp0 setScript: MoveBack temp2 temp1)
		)
		(temp2
			(temp2 cue: temp3)
		)
	)
)

(procedure (proc400_8 param1 param2) ; UNUSED
	(if (< argc 3)
		(Print param1 param2 #title {***STUB ASK:} #button {yes} 1 #button {no} 0)
	else
		(Print param1 param2 #title {***STUB ASK:} &rest)
	)
)

(procedure (proc400_7 param1 param2 param3 param4) ; UNUSED
	(if (or (< argc 4) param4)
		(Print param1 param2 #title {***STUB:})
	)
	(if (and (>= argc 3) param3)
		(param3 cue:)
	)
)

(class GuardFollow of Motion
	(properties
		who 0
		distance 20
	)

	(method (init param1 param2 param3)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= who param2)
				(if (>= argc 3)
					(= distance param3)
				)
			)
		)
		(if (not (self onTarget:))
			(super init: client (who x:) (who y:))
			(super doit:)
		)
	)

	(method (onTarget)
		(return (<= (client distanceTo: who) distance))
	)

	(method (setTarget)
		(cond
			(argc
				(super setTarget: &rest)
			)
			((not (self onTarget:))
				(super setTarget: (who x:) (who y:))
			)
		)
	)

	(method (doit &tmp temp0)
		(if (not (self onTarget:))
			(super init: client (who x:) (who y:))
			(super doit:)
		else
			(= xLast (client x:))
			(= yLast (client y:))
		)
		(client
			setHeading:
				(cond
					((< (client x:) (who x:)) 90)
					((> (client x:) (who x:)) 270)
				)
		)
	)

	(method (moveDone))
)

(instance GuardTrack of Track
	(properties)

	(method (doit &tmp [temp0 2])
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(= b-moveCnt gGameTime)
			(= xLast (client x:))
			(= yLast (client y:))
			(= x (+ (who x:) xOffset))
			(= y (+ (who y:) yOffset))
			(client x: x y: y z: (+ (who z:) zOffset))
			(if (or (!= x xLast) (!= y yLast))
				(client
					setHeading:
						(cond
							((who heading:))
							((<= 0 (gEgo heading:) 180) 90)
							(else 270)
						)
				)
			)
		)
	)
)

(class GuardStopWalk of Fwd
	(properties
		vWalking 0
		vStopped 0
	)

	(method (init param1 param2)
		(if argc
			(= vWalking ((= client param1) view:))
			(if (>= argc 2)
				(= vStopped param2)
			)
		)
		(super init: client)
	)

	(method (dispose)
		(if (== (client view:) vStopped)
			(client view: vWalking)
		)
		(super dispose:)
	)

	(method (doit &tmp temp0 temp1)
		(if (client isStopped:)
			(if (== (client view:) vWalking)
				(client view: vStopped)
				(= temp1 (client mover:))
				(super doit:)
			)
		else
			(if (== (client view:) vStopped)
				(client view: vWalking)
			)
			(super doit:)
		)
	)
)

(instance MoveBack of TScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(client
					setLoop:
					setCycle: Rev
					setMotion: MoveFwd (- register) self
				)
			)
			(1
				(if (== client gEgo)
					(NormalEgo)
				else
					(client setCycle: Walk setLoop: -1)
				)
				(self dispose:)
			)
		)
	)
)

(instance rm400 of Rm
	(properties
		picture 400
		west 390
		picAngle 70
	)

	(method (dispose)
		(DisposeScript 401)
		(DisposeScript 402)
		(DisposeScript 403)
		(super dispose: &rest)
	)

	(method (init)
		(super init: &rest)
		(AddToFeatures
			table
			leftChair
			book
			deer
			halberd
			alcove
			alcoveWindow
			desk
			shelves
			crowShield
			stripeShield
			rug
			leftTorch
			rightTorch
			fireplace
			firewood
			bench
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init:
						0
						157
						(table approachX:)
						157
						(table approachX:)
						155
						0
						155
					yourself:
				)
		)
		(gEgo posn: 60 156 loop: 0 heading: 90 init: ignoreActors:)
		(NormalEgo)
		(guards
			posn: (- (gEgo x:) 10) (gEgo y:)
			ignoreActors:
			init:
			setMotion:
				GuardFollow
				gEgo
				(if (OneOf gDisguiseNum 2 3) 30 else 2) ; jewler (no rouge), jewler (rouge)
		)
		(giles
			posn: (+ (guards x:) 15) (+ (guards y:) 9)
			init:
			ignoreActors:
			setCycle: GuardStopWalk 754
			setMotion: (Clone GuardTrack) guards 15 9
		)
		(roger
			posn: (+ (guards x:) -15) (+ (guards y:) -6)
			init:
			ignoreActors:
			setCycle: GuardStopWalk 754
			setMotion: (Clone GuardTrack) guards -15 -6
		)
		(sheriff
			posn: 179 145 18
			approachX: (table approachX:)
			approachY: (table approachY:)
			init:
		)
		(if (OneOf gDisguiseNum 2 3) ; jewler (no rouge), jewler (rouge)
			((ScriptID 403 1) init:) ; matilda
		)
		(Face gEgo sheriff)
		(gRgnMusic number: 391 loop: -1 play:)
		(self setScript: roomInit)
	)

	(method (newRoom newRoomNumber)
		(switch newRoomNumber
			(390
				(HandsOn)
			)
		)
		(gRgnMusic fade: 0 20 12 1)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(10 ; Longbow
				(if (== gDisguiseNum 4) ; yeoman
					(Say [local25 0] [local25 1])
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance roomInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(switch gDisguiseNum
					(6 ; fens monk
						(gCurRoom setScript: (ScriptID 401 0)) ; fensScript
					)
					(4 ; yeoman
						(sheriff actions: (ScriptID 402 1)) ; SheriffPuckActions
						(gCurRoom setScript: (ScriptID 402 0)) ; puckScript
					)
					(else
						(if (OneOf gDisguiseNum 2 3) ; jewler (no rouge), jewler (rouge)
							(gCurRoom setScript: (ScriptID 403 0)) ; jewelerArrivesScript
						)
					)
				)
			)
		)
	)
)

(instance guards of Actor
	(properties
		heading 90
		lookStr {These Sheriff's men all begin to look the same after a time.}
		view 753
		loop 6
		signal 1
	)

	(method (init)
		(self setLoop:)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say [local4 0] [local4 1])
			)
			(5 ; Talk
				(Say [local12 0] [local12 1])
			)
			(10 ; Longbow
				(Say 1400 4 1) ; "Must I get myself killed at every opportunity?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance giles of Actor
	(properties
		heading 90
		view 753
		signal 1
	)

	(method (doVerb)
		(guards doVerb: &rest)
	)
)

(instance roger of Actor
	(properties
		heading 90
		view 753
		signal 1
	)

	(method (doVerb)
		(guards doVerb: &rest)
	)
)

(instance sheriff of Prop
	(properties
		lookStr {What a bloated swine the Sheriff is.}
		view 401
		signal 1
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 173 101 182 101 190 120 180 127 160 121
				yourself:
			)
		)
		(self approachVerbs: 5) ; Talk
		(super init: &rest)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(= onMeCheck 0)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say [local0 0] [local0 1])
			)
			(10 ; Longbow
				(Say 1400 4 1) ; "Must I get myself killed at every opportunity?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 144
		y 156
		approachX 144
		approachY 156
		lookStr {He has a rich cloth upon his table}
	)

	(method (init)
		(= approachX (if (OneOf gDisguiseNum 2 3) 144 else 110)) ; jewler (no rouge), jewler (rouge)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 136 115 189 129 189 132 183 136 184 144 189 143 190 148 183 151 175 148 173 154 160 161 157 155 165 151 168 139 160 143 156 141 154 145 134 139 119 145 114 142 123 138 118 134 117 128 110 126 111 122
				yourself:
			)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Say [local8 0] [local8 1])
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftChair of Feature
	(properties
		x 152
		y 97
		lookStr {There's nothing special about that chair, save that it's well-padded.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 143 116 143 97 161 97 161 121
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance book of Feature
	(properties
		x 30
		y 103
		lookStr {The villain has a Holy Book upon that stand, yet I'll wager he cannot read a word of it.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 25 103 38 105 41 118 33 118 33 132 38 140 40 143 40 145 35 145 30 137 25 144 21 147 17 146 28 133 28 118 18 118 12 109
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance deer of Feature
	(properties
		x 39
		y 36
		lookStr {A fine stag adorns the wall. I can be sure the Sheriff did not loose the shaft that downed it.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 36 67 31 63 28 52 21 46 20 36 31 36 37 42 52 32 52 44 45 50 44 63
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance halberd of Feature
	(properties
		x 94
		y 35
		lookStr {'Tis a halberd.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 54 43 129 35 140 39 138 43 116 43 50 47
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance alcove of Feature
	(properties
		x 92
		y 54
		lookStr {That is a pleasant little alcove.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 125 54 125 117 56 130 56 61 yourself:)
		)
		(super init: &rest)
	)
)

(instance alcoveWindow of Feature
	(properties
		x 67
		y 60
		lookStr {I cannot see through the window from here.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 57 70 62 66 62 61 73 60 75 62 75 67 80 71 80 96 57 98
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance desk of Feature
	(properties
		x 105
		y 78
		lookStr {'Tis a desk.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 90 98 83 97 83 91 96 78 121 84 121 116 110 118 109 114 97 111 88 113
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance shelves of Feature
	(properties
		x 105
		y 55
		lookStr {The Sheriff's shelves look to be empty.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 89 58 123 55 123 79 114 81 97 77 89 80
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance crowShield of Feature
	(properties
		x 214
		y 42
		lookStr {That is the Sheriff's personal shield. The black crow upon it causes me to wonder if he has Danish blood in his lineage.\n\nAs for the axes, I can be sure the Sheriff never hefted those in battle.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 203 73 202 53 200 59 191 57 188 42 206 42 209 47 205 49 208 54 228 56 224 51 230 45 235 50 238 48 242 52 237 61 229 62 223 77 228 85 225 87 218 80 213 83 208 79 199 83
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance stripeShield of Feature
	(properties
		x 145
		y 56
		lookStr {How fitting that the Sheriff should hang a shield with a bend sinister upon it, the mark of a man of bastard descent.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 136 56 148 56 154 66 149 86 143 89 136 80
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance rug of Feature
	(properties
		x 160
		y 119
		lookStr {He has a superb, rich rug from the East.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 67 139 146 119 232 148 172 179
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance leftTorch of Feature
	(properties
		x 170
		y 49
		lookStr {'Tis a torch.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:) type: PTotalAccess init: 163 49 172 49 180 60 167 69 yourself:)
		)
		(super init: &rest)
	)
)

(instance rightTorch of Feature
	(properties
		x 270
		y 129
		z 64
		lookStr {'Tis a torch.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 269 88 262 65 272 65 273 65 278 75
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance fireplace of Feature
	(properties
		x 222
		y 85
		lookStr {There's nothing unusual about his fireplace.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 185 85 193 80 244 91 237 129 199 121 196 93
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance firewood of Feature
	(properties
		x 257
		y 115
		lookStr {'Tis only fire wood.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 239 123 255 115 298 124 298 143 291 140 272 149 235 140
				yourself:
			)
		)
		(super init: &rest)
	)
)

(instance bench of Feature
	(properties
		x 310
		y 161
		lookStr {That's an ordinary bench.}
	)

	(method (init)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 314 161 319 175 319 189 297 189 295 177 289 177 289 173 294 169 292 161
				yourself:
			)
		)
		(super init: &rest)
	)
)

