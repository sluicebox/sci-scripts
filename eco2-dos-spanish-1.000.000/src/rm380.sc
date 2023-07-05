;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use Village)
(use Scaler)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
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
	[local8 25] = [3 1 131 217 3 2 133 213 3 3 136 216 3 4 141 212 3 5 147 211 3 6 150 208 -32768]
)

(instance rm380 of Rm
	(properties
		noun 12
		picture 380
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 6 0 381 382)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 56 153 102 153 102 137 158 137 158 166 150 166 150 171 161 171 161 134 175 134 175 124 190 124 165 105 124 111 115 105 95 110 93 117 56 124
					yourself:
				)
		)
		(super init:)
		(gGameSound1 number: 380 setLoop: -1 play:)
		(if (== gPrevRoomNum 360)
			(gEgo
				x: 94
				y: 112
				init:
				normalize: 0 4
				setScale: Scaler 100 81 138 106
			)
			(self setScript: inRoom)
		else
			(gEgo
				normalize:
				view: 380
				setLoop: 6
				cel: 7
				x: 161
				y: 132
				init:
				setScale: Scaler 100 81 138 106
			)
			(= local4 1)
			(= local2 1)
			(rainFall setLoop: 5 setCycle: Fwd init:)
			(self setScript: backHere)
		)
		(shaman init:)
		(quiri init: stopUpd: approachVerbs: 4 2) ; Do, Talk
		(bowl init:)
		(paintPot init:)
		(pot init: setOnMeCheck: 1 16)
		(masks init: setOnMeCheck: 1 8192)
		(walls init: setOnMeCheck: 1 2048)
		(doorway init: setOnMeCheck: 1 4)
		(pole init: setOnMeCheck: 1 256)
		(cookfire init: setOnMeCheck: 1 2)
		(fruit init: setOnMeCheck: 1 1024)
		(pottery init: setOnMeCheck: 1 64)
		(stool init: setOnMeCheck: 1 512)
		(goodFloor init: setOnMeCheck: 1 4096)
		(rattle init:)
		(leak init:)
		(basket init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl:) $0004)
				(if local2
					(self setScript: noOut)
				else
					(self newRoom: 360)
				)
			)
			((and (== (gEgo view:) 380) (gEgo mover:))
				(self setScript: standUp)
			)
			((and (== (gEgo view:) 384) (gEgo mover:))
				(self setScript: slipDown)
			)
		)
	)

	(method (dispose)
		(slideSound dispose:)
		(super dispose:)
	)
)

(instance backHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 5)
			)
			(1
				(if (gCurrentRegionFlags test: 41)
					(= register 1)
					(gMessager say: 16 0 3 0 self) ; "I have given this problem much thought."
				else
					(= register 0)
					(gMessager say: 16 0 13 0 self) ; "The answer to this problem lies in the words of your world."
				)
			)
			(2
				(if register
					(gEgo put: 16)
					(gCurRoom newRoom: 430) ; ceremony
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance noOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gMessager say: 12 4 11 0 self) ; "The rain is falling steadily. It's too wet to go out right now."
			)
			(2
				(gEgo
					setMotion:
						PolyPath
						(+ (gEgo x:) 8)
						(+ (gEgo y:) 6)
						self
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance inRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 119 119 self)
			)
			(1
				(if (gCurrentRegionFlags test: 42)
					(gMessager say: 16 0 12 0 self) ; "You must stay here and we will decide what to do. But first you must mix the heart paint."
				else
					(gCurrentRegionFlags set: 42)
					(gMessager say: 16 0 7 0 self) ; "Ah, there you are! Welcome, welcome, and surprise!"
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(if (== (gEgo view:) 384)
					(self setScript: slipDown self)
				else
					(self cue:)
				)
			)
			(2
				(gEgo setMotion: PolyPath 161 132 self)
			)
			(3
				(gEgo
					view: 380
					setLoop: 6
					cel: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(4
				(cond
					(local7
						(gCurRoom newRoom: 390)
					)
					((not local2)
						(Village points: 5)
						(= local2 1)
						(rainFall init: setScript: startRain)
						(self dispose:)
					)
					(else
						(self dispose:)
						(gGame handsOn:)
					)
				)
			)
		)
	)
)

(instance startRain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGameSound1 fade: 0 20 12 1)
				(rainFall setCycle: End self)
			)
			(1
				(gGameSound1 number: 383 play:)
				(rainFall setLoop: 5 cycleSpeed: 10 setCycle: Fwd)
				(= seconds 1)
			)
			(2
				(rainDrop
					init:
					setLoop: 7
					setMotion: (myMoveTo new:) 130 123 rainDrop
				)
			)
			(3
				(quiri cycleSpeed: 10 setLoop: 6 cel: 0 setCycle: End self)
			)
			(4
				(quiri cycleSpeed: 6 setPri: 3 setCycle: MCyc @local8 self)
			)
			(5
				(quiri
					setLoop: 4
					setPri: 10
					setCycle: Walk
					setMotion: MoveTo 176 (quiri y:) self
				)
			)
			(6
				(quiri setLoop: 1 setCycle: End self)
			)
			(7
				(gMessager say: 12 0 14 0 self) ; "Quiri! Not there! How can Adam mix the paint?"
			)
			(8
				(quiri setPri: -1 approachX: 161 approachY: 132 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance standUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					view: 380
					setLoop: 6
					cel: (gEgo lastCel:)
					cycleSpeed: 10
					setCycle: Beg self
				)
			)
			(2
				(gEgo normalize: 0 4)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbThePole of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 2)
			(arm x: (gEgo x:) y: (- (gEgo y:) 1) cel: (gEgo cel:))
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					view: 384
					x: 152
					y: 173
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(2
				(arm init: x: (gEgo x:) y: (gEgo y:) setLoop: 1)
				(gEgo
					x: 151
					y: 173
					setLoop: 0
					cel: 0
					setStep: 3 3
					setPri: 14
					setCycle: Walk
					setScale: 0
					setMotion: MoveTo 151 60 self
				)
			)
			(3
				(gGame handsOn:)
				(arm dispose:)
				(if local6
					(client setScript: repairLeak)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance leavePot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(quiri
					setPri: 1
					setLoop: 4
					setCycle: Walk
					setMotion: MoveTo 130 (+ (quiri y:) 10) self
				)
			)
			(1
				(quiri setLoop: 1 setCycle: End self)
			)
			(2
				(quiri setPri: 11 approachX: 102 approachY: 141 stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance qTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(quiri setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 18 local1 register 0 self)
			)
			(3
				(quiri setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(shaman cel: 0 setCycle: End self)
			)
			(2
				(gMessager say: 16 local1 register 0 self)
			)
			(3
				(shaman setCycle: Beg self)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance repairLeak of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 3)
			)
			(1
				(gEgo
					view: 384
					setLoop: 0
					cel: 7
					cycleSpeed: 16
					setCycle: (myForward new:)
				)
				(= cycles 55)
			)
			(2
				(gEgo setCycle: 0)
				(if (not local4)
					(quiri setScript: leavePot)
					(= local4 1)
				)
				(gEgo put: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance slipDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setCycle: 0
					setStep: 3 6
					setMotion: MoveTo 151 173 self
				)
				(slideSound number: 601 setLoop: 1 play:)
			)
			(1
				(gEgo setLoop: 2 x: 152 y: 173)
				(gEgo cel: (gEgo lastCel:) setCycle: Beg self)
			)
			(2
				(gEgo
					setStep: 3 2
					normalize: 0 1
					x: 154
					y: 172
					setScale: Scaler 100 81 138 106
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rainFall of Prop
	(properties
		x 107
		y 65
		view 380
		loop 4
		signal 16384
		cycleSpeed 20
		detailLevel 4
	)
)

(instance rainDrop of Actor
	(properties
		x 130
		y 20
		view 382
		loop 7
		priority 13
		signal 16400
	)

	(method (init)
		(if local3
			(self
				setLoop: 7
				cel: 0
				x: 130
				y: 20
				setMotion: (myMoveTo new:) 130 145 self
			)
		else
			(super init:)
		)
	)

	(method (cue)
		(if (not local3)
			(= local3 1)
			(startRain cue:)
		)
		(if local5
			(= local5 0)
			(if (not local4)
				(self init:)
			else
				(Village points: 5)
				(self dispose:)
			)
		else
			(= local5 1)
			(gGameSound2 number: 387 setLoop: 1 play:)
			(self setLoop: 8 cel: 0 setCycle: End self)
		)
	)
)

(instance shaman of Actor
	(properties
		x 196
		y 124
		noun 16
		view 381
		signal 20480
		cycleSpeed 20
	)

	(method (doVerb theVerb &tmp temp0)
		(if (not (self perform: gWriteEcorderData theVerb 71))
			(= local1 theVerb)
			(cond
				(local4
					(= temp0 4)
				)
				(local2
					(= temp0 2)
				)
				(else
					(= temp0 0)
				)
			)
			(switch theVerb
				(2 ; Talk
					(gCurRoom setScript: sTalk 0 temp0)
				)
				(25 ; berries
					(cond
						(local4
							(gMessager say: noun theVerb 4) ; "Mix the paint in the bowl, Adam, and we will begin."
						)
						(local2
							(gMessager say: noun theVerb 2) ; "You could mix the heart paint - if only Quiri would move!"
						)
						(else
							(gMessager say: noun theVerb) ; "You must sit before me. Then you may mix the heart paint."
						)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (doit)
		(if (not (IsEcorderFlag 71))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)
)

(instance arm of View
	(properties
		x 149
		y 172
		view 384
		loop 1
		priority 1
		signal 16400
	)
)

(instance quiri of Actor
	(properties
		x 130
		y 218
		z 70
		noun 18
		approachX 102
		approachY 141
		view 382
		priority 11
		signal 16400
	)

	(method (doVerb theVerb &tmp temp0)
		(= local1 theVerb)
		(cond
			(local4
				(= temp0 4)
			)
			(local2
				(= temp0 2)
			)
			(else
				(= temp0 0)
			)
		)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: qTalk 0 temp0)
			)
			(2 ; Talk
				(gCurRoom setScript: qTalk 0 temp0)
			)
			(1 ; Look
				(if (and local2 (not local4))
					(gMessager say: noun theVerb 2) ; "Quiri crouches on the paint pot. He has no intention of moving."
				else
					(gMessager say: noun theVerb 0) ; "A large, hairy spider crouches on the plate of fruit."
				)
			)
			(25 ; berries
				(gMessager say: 6 theVerb 9) ; "Mrrrrpppt!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bowl of View
	(properties
		x 168
		y 144
		noun 13
		view 380
		loop 3
		signal 16384
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
		(self addToPic:)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 68))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 68))
			(super doVerb: theVerb)
		)
	)
)

(instance masks of Feature
	(properties
		x 241
		y 68
		noun 3
		onMeCheck 8192
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 69))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 69))
			(super doVerb: theVerb)
		)
	)
)

(instance walls of Feature
	(properties
		x 178
		y 7
		noun 1
		onMeCheck 2048
	)
)

(instance doorway of Feature
	(properties
		x 106
		y 73
		noun 2
		onMeCheck 4
	)
)

(instance pole of Feature
	(properties
		x 146
		y 116
		noun 5
		onMeCheck 256
		approachX 159
		approachY 176
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4) ; Do
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (gEgo view:) 384)
					(gCurRoom setScript: climbThePole)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cookfire of Feature
	(properties
		x 223
		y 150
		noun 7
		onMeCheck 2
	)
)

(instance pot of Feature
	(properties
		x 258
		y 172
		noun 20
		onMeCheck 16
	)
)

(instance pottery of Feature
	(properties
		x 246
		y 133
		noun 11
		onMeCheck 64
	)
)

(instance stool of Feature
	(properties
		x 195
		y 129
		noun 14
		onMeCheck 512
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 67))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 67))
			(super doVerb: theVerb)
		)
	)
)

(instance goodFloor of Feature
	(properties
		x 144
		y 115
		noun 19
		onMeCheck 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (gEgo view:) 380)
					(gCurRoom setScript: sitDown)
				else
					(gCurRoom setScript: standUp)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance paintPot of Feature
	(properties
		x 200
		y 182
		noun 6
		nsTop 135
		nsLeft 170
		nsBottom 142
		nsRight 183
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (!= (gEgo view:) 380)
					(gCurRoom setScript: sitDown)
				else
					(super doVerb: theVerb)
				)
			)
			(25 ; berries
				(cond
					(local4
						(Village points: 5 60)
						(if (!= (gEgo view:) 380)
							(= local7 1)
							(gCurRoom setScript: sitDown)
						else
							(gCurRoom newRoom: 390)
						)
					)
					(local2
						(gMessager say: noun theVerb 9) ; "Mrrrrpppt!"
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fruit of Feature
	(properties
		x 84
		y 175
		noun 8
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local2
					(gMessager say: noun theVerb 2) ; "Quiri has left many small marks in the fruit."
				else
					(gMessager say: noun theVerb 0) ; "A hairy spider munches happily."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rattle of Feature
	(properties
		x 97
		y 54
		noun 21
		nsTop 47
		nsLeft 87
		nsBottom 62
		nsRight 107
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 70))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 70))
			(super doVerb: theVerb)
		)
	)
)

(instance leak of Feature
	(properties
		x 143
		y 28
		noun 10
		nsTop 24
		nsLeft 123
		nsBottom 33
		nsRight 163
		approachX 159
		approachY 176
	)

	(method (init)
		(super init:)
		(self approachVerbs: 4 15) ; Do, leaf
	)

	(method (doVerb theVerb)
		(switch theVerb
			(15 ; leaf
				(cond
					((and (== (gEgo view:) 384) local2)
						(gCurRoom setScript: repairLeak)
					)
					((and (not local4) local2)
						(= local6 1)
						(gCurRoom setScript: climbThePole)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(1 ; Look
				(cond
					(local4
						(gMessager say: noun theVerb 4) ; "The leaf holds the thatch together."
					)
					(local2
						(gMessager say: noun theVerb 2) ; "Alas, I just did not have time to fix that hole."
					)
					(else
						(gMessager say: noun theVerb 0) ; "There is a gap in the patch around the hut pole."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event)
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
				(CueObj
					state: 0
					cycles: 0
					client: self
					theVerb: (event message:)
				)
				(event claimed: 1)
				(if
					(and
						(gUser canControl:)
						(>
							(GetDistance
								(gEgo x:)
								(gEgo y:)
								approachX
								approachY
							)
							approachDist
						)
						gEco2ApproachCode
						(& _approachVerbs (gEco2ApproachCode doit: (event message:)))
					)
					(if (!= (gEgo view:) 384)
						(gEgo
							setMotion:
								PolyPath
								approachX
								(+ (gEgo z:) approachY)
								CueObj
						)
					else
						(CueObj cue:)
					)
				else
					(gEgo setMotion: 0)
					(if (self facingMe:)
						(CueObj changeState: 3)
					)
				)
			)
		)
		(event claimed:)
	)
)

(instance basket of Feature
	(properties
		x 214
		y 53
		noun 22
		nsTop 39
		nsLeft 204
		nsBottom 68
		nsRight 225
		approachX 177
		approachY 115
	)

	(method (init)
		(super init:)
		(gTheDoits add: self)
		(self approachVerbs: 4) ; Do
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 72))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 72))
			(super doVerb: theVerb)
		)
	)
)

(instance slideSound of Sound
	(properties)
)

(instance myMoveTo of MoveTo
	(properties)

	(method (doit)
		(++ dy)
		(super doit:)
	)
)

(instance myForward of Fwd
	(properties)

	(method (doit &tmp temp0)
		(if (== (= temp0 (self nextCel:)) 2)
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)

	(method (cycleDone)
		(client cel: 7)
	)
)

