;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use rgCastle)
(use Conversation)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm800 0
	proc800_1 1
	roomConv 2
)

(local
	local0
	[local1 24] = [0 189 0 0 319 0 319 189 207 189 207 186 285 186 212 143 75 143 16 186 161 186 161 189]
	[local25 8] = [75 152 99 152 99 159 75 159]
	[local33 16] = [197 147 197 149 165 149 165 158 205 158 205 160 113 160 113 147]
	[local49 8] = [288 187 212 143 77 143 22 187]
	[local57 34] = [0 -10 319 -10 319 189 295 189 0 189 0 186 287 186 211 143 119 143 119 147 201 147 201 152 99 152 99 144 74 144 52 161 0 161]
	[local91 24] = [79 82 98 82 192 155 192 151 99 78 88 78 88 76 110 76 238 -10 231 -10 108 73 63 73]
	local115
	local116
	[local117 8] = [0 0 198 155 79 77 211 5]
	[local125 6] = [188 185 188 189 110 189]
	local131
	local132
	local133
	local134
	local135
)

(procedure (localproc_0 param1)
	(if (== argc 1)
		(= local0 [param1 0])
	)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
	(mainPoly type: PBarredAccess)
	(switch local0
		(1
			(gCurRoom
				addObstacle:
					(mainPoly type: PContainedAccess points: @local49 size: 4 yourself:)
					(Poly1 type: PBarredAccess points: @local25 size: 4 yourself:)
					(Poly2 type: PBarredAccess points: @local33 size: 8 yourself:)
			)
		)
		(2
			(backPost setPri: 0 stopUpd:)
			(gCurRoom
				addObstacle:
					(mainPoly type: PContainedAccess points: @local91 size: 12 yourself:)
			)
		)
		(3
			(gCurRoom addObstacle: (mainPoly points: @local57 size: 17 yourself:))
		)
	)
)

(procedure (proc800_1)
	(gCurRoom drawPic: (gCurRoom picture:))
	(if (== local0 3)
		(upHallleft addToPic:)
		(upHalleft2 addToPic:)
		(upStairs addToPic:)
		(upStairs2 addToPic:)
	else
		(downStairs addToPic:)
		(downUpperHalf addToPic:)
		(downFloor addToPic:)
		(backPost show: stopUpd:)
	)
	(stoneDoor show: stopUpd:)
	(beam show:)
	(chink show: stopUpd:)
	(gEgo show:)
	(localproc_0)
)

(instance rm800 of CastleRoom
	(properties
		noun 3
		picture 800
		style 10
		horizon 17
		west 810
	)

	(method (init)
		(switch gPrevRoomNum
			(810
				(= local0 3)
			)
			(else
				(= local0 1)
			)
		)
		(localproc_0)
		(walls init:)
		(super init: &rest)
		(stoneDoor init:)
		(switch gPrevRoomNum
			(810
				(upHallleft addToPic:)
				(upHalleft2 addToPic:)
				(upStairs addToPic:)
				(upStairs2 addToPic:)
				(climbStairs register: 3)
				(gEgo posn: 30 165)
				(self setScript: firstTimeOnSecondLevel)
			)
			(else
				(downStairs addToPic:)
				(downUpperHalf addToPic:)
				(downFloor addToPic:)
				(backPost init: stopUpd:)
				(= local131 2)
				(secretDoorMove register: 1)
				(stoneDoor posn: 110 189)
				(self setScript: secretDoorMove)
				(gEgo reset: 3 posn: 183 184)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag1 32)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 4) ; rgCastle
					(if (not script)
						(self setScript: firstEntry)
					else
						(script next: firstEntry)
					)
				)
			)
		)
		(chink init: show: stopUpd:)
		(beam init: addToPic:)
		(gEgo init: reset:)
		(if (== gPrevRoomNum 810)
			(gEgo loop: 9 cel: 0)
		)
		(gEgo setScale: 0 scaleX: 128 scaleY: 128 ignoreHorizon:)
		(if (not script)
			(gGame handsOn:)
		)
		(if (!= (gGlobalSound number:) 810)
			(gGlobalSound fadeTo: 810 -1)
		)
	)

	(method (doit)
		(= local135 (gEgo onControl: 1))
		(cond
			(script 0)
			((and (== local0 1) (& local135 $4000))
				(self setScript: getOnStairs 0 1)
				(localproc_0 2)
			)
			((and (== local0 3) (<= (gEgo y:) 149) (& local135 $1000))
				(self setScript: changeLandings)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(1 ; Look
					(gMessager say: noun theVerb (+ 14 (== local0 3)))
					1
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance firstEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 1 0 1 0 self) ; "Alexander hears the sound of voices coming from nearby."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance firstTimeOnSecondLevel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(if (not ((ScriptID 80 0) tstFlag: #rFlag3 8)) ; rgCastle
					((ScriptID 80 0) setFlag: #rFlag3 8) ; rgCastle
					(roomConv add: -1 1 0 3) ; "Phew! That was a climb!"
				)
				(if (not ((ScriptID 80 0) tstFlag: #rFlag2 256)) ; rgCastle
					(roomConv add: -1 1 0 6) ; "Alexander hears the faint sound of a woman crying nearby."
				)
				(if (roomConv size:)
					(roomConv init: self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance changeLandings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local0
					(2
						(backPost startUpd:)
						(gEgo setMotion: MoveTo 207 9 self)
					)
					(3
						(gEgo
							setPri: 1
							setLoop: 1
							setMotion: MoveTo 157 164 self
						)
					)
				)
			)
			(1
				(if (== local0 3)
					(localproc_0 2)
				else
					(backPost dispose:)
					(chink startUpd:)
					(localproc_0 3)
				)
				(gAddToPics eachElementDo: #dispose release:)
				(gCurRoom drawPic: 800 10)
				(switch local0
					(3
						(upHallleft addToPic:)
						(upHalleft2 addToPic:)
						(upStairs addToPic:)
						(upStairs2 addToPic:)
						(gEgo setPri: 1 posn: 157 164)
					)
					(else
						(downStairs addToPic:)
						(downUpperHalf addToPic:)
						(downFloor addToPic:)
						(backPost init: stopUpd:)
						(gEgo posn: 207 9)
					)
				)
				(stoneDoor init: stopUpd:)
				(beam addToPic:)
				(chink show: stopUpd:)
				(= cycles 3)
			)
			(2
				(switch local0
					(3
						(= next firstTimeOnSecondLevel)
						(gEgo setMotion: MoveTo 191 145 self)
					)
					(else
						(gEgo setLoop: -1)
						(= next (climbStairs register: 3 yourself:))
						(gEgo setMotion: MoveTo 168 34 self)
					)
				)
			)
			(3
				(if (!= local0 3)
					(if (not ((ScriptID 80 0) tstFlag: #rFlag1 32)) ; rgCastle
						(gMessager say: 1 0 1 0 self) ; "Alexander hears the sound of voices coming from nearby."
					else
						(= cycles 1)
					)
				else
					(= cycles 1)
				)
			)
			(4
				(if (!= local0 3)
					(gGame handsOn:)
				)
				(gEgo reset:)
				(self dispose:)
			)
		)
	)
)

(instance getOnStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(gEgo setMotion: MoveTo 167 136 self)
				else
					(gEgo setMotion: MoveTo 198 155 self)
				)
			)
			(1
				(gGame handsOn:)
				(if register
					(client setScript: climbStairs)
				else
					(backPost setPri: -1 stopUpd:)
					(self dispose:)
				)
			)
		)
	)
)

(instance climbStairs of Script
	(properties
		register 1
	)

	(method (init)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(super init: &rest)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (cue)
		(return 0)
	)

	(method (doit)
		(cond
			((and (== local0 2) (& local135 $1000))
				(client setScript: getOnStairs 0 0)
				(localproc_0 1)
			)
			((== (gEgo edgeHit:) 1)
				(client setScript: changeLandings)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (and (!= (event type:) evVERB) (not (event modifiers:)))
			(if (& (event type:) evMOUSEBUTTON)
				(= local134 1)
			)
			(if (& (event type:) $0040) ; direction
				(event claimed: 1)
				(if local134
					(= local134 0)
					(= register (+ 2 (- (* (<= (gEgo y:) 77) 2) 1)))
				)
				(cond
					((OneOf (event message:) JOY_UP JOY_DOWN)
						(switch (event message:)
							(JOY_UP
								(if (< register 3)
									(++ register)
								)
							)
							(JOY_DOWN
								(if (> register 1)
									(-- register)
								)
							)
						)
						(gEgo
							setMotion:
								PolyPath
								[local117 (* register 2)]
								[local117 (+ (* register 2) 1)]
						)
					)
					((not (OneOf (event message:) JOY_UPLEFT JOY_UPRIGHT JOY_DOWNLEFT JOY_DOWNRIGHT))
						(event claimed: 0)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance secretDoorMove of Script
	(properties
		register -1
	)

	(method (init)
		(= register (- (* (== register -1) 2) 1))
		(if (== register -1)
			(gCurRoom south: 0)
			((gCurRoom obstacles:)
				delete: mainPoly
				add: (mainPoly type: PContainedAccess points: @local49 size: 4 yourself:)
			)
		else
			(gGame handsOff:)
		)
		(super init: &rest)
	)

	(method (dispose)
		(if (== register 1)
			(gCurRoom south: 720)
			(= next exitRoom)
		)
		(if (not next)
			(gGame handsOn:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gGlobalSound4 number: 909 loop: 1 play:)
				(= ticks 1)
			)
			(2
				(if (<= 0 (+= local131 register) 2)
					(-- state)
					(= local132 [local125 (* local131 2)])
					(= local133 [local125 (+ (* local131 2) 1)])
					(stoneDoor
						moveSpeed: 4
						setMotion: MoveTo local132 local133 self
					)
				else
					(= cycles 1)
				)
			)
			(3
				(gGlobalSound4 stop:)
				(stoneDoor stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 200 self)
			)
			(1
				(gCurRoom newRoom: 720)
			)
		)
	)
)

(instance stoneDoor of Actor
	(properties
		x 188
		y 185
		noun 8
		view 801
		loop 2
		cel 4
		priority 14
		signal 18448
	)

	(method (init)
		(super init: &rest)
		(self approachX: 188 approachY: 183 approachVerbs: 5 stopUpd:) ; Do
	)

	(method (onMe param1)
		(return
			(and
				(!= local131 3)
				(!= local0 3)
				(super onMe: param1)
				(> (param1 x:) 115)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not script)
					(self setScript: secretDoorMove)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chink of View
	(properties
		x 289
		y 128
		view 801
		loop 3
	)

	(method (show)
		(if (!= local0 3)
			(self posn: 289 128)
		else
			(self posn: 258 122)
		)
		(super show: &rest)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 5 1) ; Do, Look
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and
						(== local0 3)
						(= approachX 228)
						(= approachY 157)
						(= noun 4)
					)
					(and (= approachX 258) (= approachY 166) (= noun 6))
				)
			)
		)
	)

	(method (doVerb theVerb)
		(cond
			((and (== (gKq6ApproachCode doit: theVerb) -32768) (not (= theVerb 0)))
				(gMessager say: 7 theVerb)
			)
			((OneOf theVerb 5 1) ; Do, Look
				(switch noun
					(4
						(gCurRoom setScript: (ScriptID 801)) ; cassimaScript
					)
					(else
						(gCurRoom setScript: (ScriptID 802)) ; guardsScript
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance beam of View
	(properties
		onMeCheck 0
		view 801
		loop 4
		signal 16400
	)

	(method (init)
		(= cel (- (NumCels self) 1))
		(super init: &rest)
	)

	(method (doit)
		(if (and (not (& signal $0008)) (!= (gEgo view:) 802))
			(if
				(and
					(>= (gEgo x:) local115)
					(>= (+ y 2) (gEgo y:) (- y 2))
				)
				(= cel (- (/ (- x (gEgo x:)) 7) 1))
				(= priority (- (gEgo priority:) 1))
			else
				(= priority (CoordPri y))
				(= cel local116)
			)
		)
		(super doit:)
	)

	(method (addToPic &tmp temp0)
		(if (!= local0 3)
			(self posn: 289 128 0 loop: 4)
		else
			(self posn: 258 122 0 loop: 6)
		)
		(= cel (- (NumCels self) 1))
		(= local116 cel)
		(= priority (CoordPri y))
		(SetNowSeen self)
		(= local115 nsLeft)
		(= temp0 y)
		(= y (- nsBottom 2))
		(= z (- y temp0))
	)
)

(class Stair of View
	(properties
		noun 10
		view 801
		loop 1
	)

	(method (init)
		(super init: &rest)
		(gWalkHandler add: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(!= local0 2)
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(& (event type:) evMOVE)
				(self onMe: event)
			)
			(event claimed: 1)
			(gEgo setMotion: PolyPath 188 151)
		)
		(event claimed:)
	)

	(method (onMe param1)
		(return
			(and
				(super onMe: param1)
				(or
					(and (== (gTheIconBar curIcon:) (gTheIconBar at: 2)) (= noun 10))
					(= noun 11)
				)
			)
		)
	)
)

(instance downStairs of Stair
	(properties
		x 106
		y 158
		signal 20480
	)
)

(instance downUpperHalf of Stair
	(properties
		x 106
		y 78
		cel 1
		signal 20480
	)
)

(instance downFloor of Stair
	(properties
		x 106
		y 77
		cel 2
		signal 20496
	)
)

(instance backPost of Stair
	(properties
		x 181
		y 158
		z 15
		cel 3
		signal 20480
	)
)

(instance upHallleft of View
	(properties
		x 25
		y 114
		noun 9
		view 801
		loop 2
		priority 15
		signal 20496
	)
)

(instance upHalleft2 of View
	(properties
		x 25
		y 114
		noun 9
		view 801
		loop 2
		cel 1
		signal 16400
	)
)

(instance upStairs of View
	(properties
		x 154
		y 148
		noun 11
		view 801
		loop 2
		cel 3
		signal 20496
	)
)

(instance upStairs2 of View
	(properties
		x 154
		y 151
		noun 11
		view 801
		loop 2
		cel 2
		signal 20480
	)
)

(instance walls of Feature
	(properties
		noun 7
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(roomConv add: -1 noun theVerb 26) ; "The old walls are dirty and show the neglect of a forgotten place."
				(if (>= ((User curEvent:) x:) 214)
					(roomConv add: -1 noun theVerb 27) ; "The wall has deteriorated significantly in this area, leaving a chink in the wall."
				)
				(roomConv init:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomConv of Conversation
	(properties)
)

(instance mainPoly of Polygon
	(properties)
)

(instance Poly1 of Polygon
	(properties)
)

(instance Poly2 of Polygon
	(properties)
)

