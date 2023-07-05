;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use rmnScript)
(use SQRoom)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm381 0
)

(local
	local0
	local1
	local2
	local3
	local4 = 1
	[local5 8] = [314 68 235 67 157 64 220 90]
	[local13 8]
)

(procedure (localproc_0)
	(HandsOn)
	(User canControl: 0)
	(gIconBar disable: 0)
)

(procedure (localproc_1 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (- (robo brLeft:) 5))
	(= temp1 (- (robo brTop:) 5))
	(= temp2 (+ (robo brRight:) 6))
	(= temp3 (robo brBottom:))
	(= [local13 0] (= [local13 6] temp0))
	(= [local13 1] (= [local13 3] temp1))
	(= [local13 2] (= [local13 4] temp2))
	(= [local13 5] (= [local13 7] temp3))
	(roboPoly points: @local13 size: 4)
	(gCurRoom addObstacle: roboPoly)
)

(instance rm381 of SQRoom
	(properties
		picture 381
		style 30
		south 380
		picAngle 60
	)

	(method (init)
		(LoadMany rsVIEW 0 4 402 383 381)
		(LoadMany rsFONT 68 69)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 107 150 152 150 181 159 181 170 152 180 116 180 90 174 80 163
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 268 56 238 61 201 57 159 62 124 58 109 73 118 73 102 89 46 89 7 106 7 172 76 172 69 189 0 189 0 0 319 0 319 55
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 242 189 221 148 151 111 197 91 241 91 251 77 319 77
					yourself:
				)
		)
		(super init:)
		(gFeatures
			add:
				light1
				light2
				CashRegister
				shelves
				alienSuit1
				alienSuit2
				alienSuit3
				alienSuit4
				alienSuit5
				BargainShelf
				dressingRoom
				theShop
			eachElementDo: #init
			doit:
		)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(rmnProp init:)
		(robo init: setLoop: Grooper setHeading: 0)
		(if (not (IsFlag 18))
			(gEgo view: 402)
		)
		(gEgo posn: 192 222 loop: 3 init:)
		(AnimateEgoHead)
		(self setScript: EnterShop)
		(self setRegions: 700) ; mall
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(= temp0
						(switch ((User alterEgo:) edgeHit:)
							(3 south)
						)
					)
					local2
					local4
				)
				(gCurRoom setScript: ExitScript)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if (and local2 local4)
			((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0080)) ; mall, mall
		)
		(if
			(and
				(not (TestMallFlag (ScriptID 700 0) #rFlag2 4)) ; mall
				(TestMallFlag (ScriptID 700 0) #rFlag2 2) ; mall
				(TestMallFlag (ScriptID 700 0) #rFlag1 128) ; mall
			)
			((ScriptID 700 0) rFlag2: (| ((ScriptID 700 0) rFlag2:) $0004)) ; mall, mall
		)
		(if (and (not (TestMallFlag (ScriptID 700 0) #rFlag2 2)) local0) ; mall
			((ScriptID 700 0) rFlag2: (| ((ScriptID 700 0) rFlag2:) $0002)) ; mall, mall
		)
		(super dispose:)
	)
)

(instance EnterShop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 192 185 self)
			)
			(1
				(robo setScript: roboClerkWelcome)
				(self dispose:)
			)
		)
	)
)

(instance ExitScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(1
				(Face gEgo robo self)
			)
			(2
				(self
					save1:
						(proc0_12
							{** How dare you try to leave without paying.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 380)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance roboClerkWelcome of rmnScript
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (User canInput:) (gEgo mover:))
			(= seconds 0)
			(HandsOff)
			(Face gEgo robo self)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(localproc_0)
				(if (not (IsFlag 18))
					(robo
						illegalBits: 0
						xStep: 5
						yStep: 3
						setCycle: Walk
						setMotion: MoveTo 203 85 self
					)
				else
					(self changeState: 7)
				)
			)
			(1
				(Face robo gEgo self)
			)
			(2
				(gEgo moveHead: 0)
				(if (TestMallFlag (ScriptID 700 0) #rFlag2 4) ; mall
					(self
						save1:
							(proc0_12
								{** It's you AGAIN!!  Stop wasting my time.}
								67
								0
								20
								28
								global132
								29
								global129
								30
								1
							)
					)
					(= state 6)
				else
					(self
						save1:
							(proc0_12
								{Welcome, sir. How may I help you?}
								67
								0
								20
								28
								global132
								29
								global129
								30
								1
							)
					)
				)
				(= seconds 10)
			)
			(4
				(HandsOn)
				(= seconds 15)
			)
			(5
				(self
					save1:
						(proc0_12
							{** Let me know if there is anything I can get for you.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(gEgo moveHead: 1)
				(= seconds 10)
			)
			(7
				(HandsOn)
				(= cycles 1)
			)
			(8
				(= temp0 (Random 0 3))
				(robo
					setMotion:
						MoveTo
						[local5 (*= temp0 2)]
						[local5 (+ temp0 1)]
						self
				)
				(= seconds 10)
			)
			(9
				(= state 7)
				(robo setHeading: (Random (Random 0 180) (Random 180 360)))
				(= cycles (Random 8 15))
			)
			(10
				(self changeState: 7)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance measureEgo of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(robo
					view: 383
					loop: 3
					cel: 0
					heading: 270
					setCycle: Osc 1 self
					cycleSpeed: 1
				)
			)
			(1
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 163 99 self
				)
			)
			(2
				(robo setMotion: MoveTo 138 99 self)
			)
			(3
				(robo setHeading: 90 self)
			)
			(4
				(robo
					view: 383
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: Osc 1 self
				)
			)
			(5
				(robo loop: 1 cel: 0 setCycle: Osc 1 self)
			)
			(6
				(self
					save1:
						(proc0_12
							{We've got just the thing for the likes of you.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(8
				((ScriptID 700 0) rFlag2: (| ((ScriptID 700 0) rFlag2:) $0001)) ; mall, mall
				(self dispose:)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance getPants of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo moveHead: 0)
				(if (TestMallFlag (ScriptID 700 0) #rFlag2 1) ; mall
					(= state 4)
				)
				(= cycles 1)
			)
			(1
				(if
					(= local1
						(<=
							(GetDistance (robo x:) (robo y:) 140 90 0)
							(GetDistance (gEgo x:) (gEgo y:) 140 90 0)
						)
					)
					(robo setMotion: PolyPath 180 85 robo)
				else
					(gEgo setMotion: PolyPath 140 90 self)
				)
			)
			(2
				(if local1
					(= local1 0)
					(gEgo setMotion: PolyPath 140 90 self)
				else
					(= cycles 1)
				)
			)
			(3
				((gCurRoom obstacles:) delete: roboPoly)
				(robo setMotion: MoveTo 163 90 self)
				(gEgo illegalBits: -32768 setHeading: 180)
			)
			(4
				(if (not (TestMallFlag (ScriptID 700 0) #rFlag2 1)) ; mall
					(self setScript: measureEgo self)
				else
					(= cycles 1)
				)
			)
			(5
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 0
					setMotion: PolyPath 65 89 self
				)
			)
			(6
				(robo setHeading: 0)
				(= cycles 6)
			)
			(7
				(self
					save1:
						(proc0_12
							{We have a nice line of apparel for the generic space hero.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(9
				(robo view: 383 setLoop: 7 cel: 0 setMotion: MoveTo 48 93 self)
			)
			(10
				(robo setLoop: 8 heading: 180)
				(= cycles 2)
			)
			(11
				(self
					save1:
						(proc0_12
							{** Here you are sir. You may try this on in the dressing room, just to my right.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(13
				(gEgo setMotion: PolyPath 48 100 self)
			)
			(14
				(gEgo setHeading: 0)
				(robo view: 381 setLoop: Grooper)
				(= cycles 5)
			)
			(15
				(robo setLoop: -1 setMotion: PolyPath 314 68 self)
				(gEgo illegalBits: 0 setMotion: MoveTo -5 (gEgo y:))
			)
			(16
				(= cycles 5)
			)
			(17
				(robo posn: 314 100 setMotion: MoveTo 243 117 self)
			)
			(18
				(Print 381 0) ; "** You change your clothes, not forgetting the items in your pocket. You never know when you'll need them."
				(= cycles 1)
			)
			(19
				(Print 381 1) ; "You step out looking good as new."
				(gEgo
					view: 0
					setCycle: StopWalk 4
					setMotion: MoveTo 48 100 self
				)
			)
			(20
				(gEgo illegalBits: -32768)
				(= local2 1)
				(self
					save1:
						(proc0_12
							{That will be twenty Buckaziods, please.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(22
				(if (and (>= gBuckazoidCount 20) local3)
					(Print 381 2) ; "You wisely decide to pay-up this time."
					(gEgo setMotion: PolyPath 188 135 self)
				else
					(HandsOn)
					(gEgo moveHead: 1)
					(self dispose:)
				)
			)
			(23
				(if local3
					(= cycles 1)
				)
			)
			(24
				(HandsOn)
				(robo doVerb: 6 0)
				(= seconds 30)
			)
			(25
				(robo setMotion: MoveTo 330 (robo y:) self)
			)
			(26
				(roboClerkWelcome start: 6)
				(robo posn: 314 68 setScript: roboClerkWelcome)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance roboVerbTalkStuff of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 18))
					(cond
						((TestMallFlag (ScriptID 700 0) #rFlag2 4) ; mall
							(self changeState: 18)
						)
						((TestMallFlag (ScriptID 700 0) #rFlag2 2) ; mall
							(self changeState: 7)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(Print 381 3) ; "You start to talk to the clerk but realize there is nothing else in here that would fit muchless be useful."
					(self dispose:)
				)
			)
			(2
				(robo setMotion: 0)
				(switch local0
					(1
						(if (== (robo script:) roboClerkWelcome)
							(roboClerkWelcome dispose:)
						)
						(Face robo gEgo self)
					)
					(else
						(self dispose:)
					)
				)
			)
			(3
				(robo stopUpd:)
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(4
				(self
					save1:
						(proc0_12
							{Yes. I've misplaced the legs of my pants. My boots seem to missing as well.}
							67
							0
							20
							30
							1
						)
				)
				(= seconds 10)
			)
			(6
				(robo setScript: getPants)
				(self dispose:)
			)
			(7
				(robo setMotion: 0)
				(if (== (robo script:) roboClerkWelcome)
					(roboClerkWelcome dispose:)
				)
				(if (not local3)
					(= local3 1)
					(Face robo gEgo 0)
					(= cycles 2)
				else
					(switch local0
						(2
							(if (== (robo script:) roboClerkWelcome)
								((robo script:) dispose:)
							)
							(self changeState: 12)
						)
						(else
							(self dispose:)
						)
					)
				)
			)
			(8
				(self
					save1:
						(proc0_12
							{Hello. I was hoping to make a purchase.}
							67
							0
							20
							30
							1
						)
				)
				(= seconds 10)
			)
			(10
				(self
					save1:
						(proc0_12
							{Oh, it's you! Please don't waste my time.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(12
				(self
					save1:
						(proc0_12
							{Please help me. That other deal was a total misunderstanding. Anyway, as I said, I've misplaced the legs of my pants. My boots seem to be missing as well.}
							67
							0
							20
							30
							1
							67
							0
							10
						)
				)
				(= seconds 10)
			)
			(14
				(self
					save1:
						(proc0_12
							{If it will help me rid the store of you I'll give you one more try. Come with me then.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(16
				(robo setScript: getPants)
				(self dispose:)
			)
			(18
				(self
					save1:
						(proc0_12
							{** Oh, it's you again.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(= seconds 10)
			)
			(20
				(if (>= gBuckazoidCount 20)
					(self changeState: 11)
				else
					(self dispose:)
				)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance roboVerbUseStuff of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch register
					(0
						(cond
							(
								(or
									(IsFlag 18)
									(not local4)
									(not local2)
									(not (OneOf (gEgo view:) 0 4))
								)
								(self dispose:)
							)
							((>= gBuckazoidCount 20)
								(HandsOff)
								(gEgo setMotion: PolyPath 188 135 self)
							)
							(else
								(if (== (robo script:) getPants)
									(getPants dispose:)
								)
								(self
									save1:
										(proc0_12
											{** You haven't the money to pay for this.}
											67
											0
											20
											28
											global132
											29
											global129
											30
											1
										)
								)
								(= state 3)
								(= seconds 10)
							)
						)
					)
					(else
						(self dispose:)
					)
				)
			)
			(2
				(Face gEgo robo self)
			)
			(3
				(HandsOn)
				(self
					save1:
						(proc0_12
							{Thanks for shopping in a truly fine establishment. Good day.}
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
						)
				)
				(SetFlag 18)
				(= local4 0)
				(-= gBuckazoidCount 20)
			)
			(5
				(self dispose:)
			)
			(6
				((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0080)) ; mall, mall
				(gCurRoom newRoom: 380)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance robo of Actor
	(properties
		x 235
		y 67
		description {roboclerk}
		sightAngle 90
		lookStr {This is your friendly automated sales clerk.}
		view 381
		loop 1
		illegalBits 0
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if
					(and
						(!= (self script:) getPants)
						(!= (rmnProp script:) roboVerbTalkStuff)
					)
					(++ local0)
					(rmnProp setScript: roboVerbTalkStuff)
				)
			)
			(6 ; Inventory
				(if (not (rmnProp script:))
					(rmnProp setScript: roboVerbUseStuff 0 invItem)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(localproc_1)
		(getPants cycles: 1)
	)
)

(instance rmnProp of Prop
	(properties
		x -20
		y -20
	)
)

(instance poly1 of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

(instance theShop of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {Big and Tall Alien store}
		sightAngle 500
		lookStr {Your first thought upon looking around here is, "Hey, this clothing store isn't so big and tall!"  Then your brain kicks in.  The store is crammed with racks of apparel for the discriminating gigantic obese alien.  You silently remind yourself to start working out to get rid of those pesky fatty deposits.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb)
			)
			(else 0)
		)
	)
)

(instance dressingRoom of Feature
	(properties
		x 28
		y 58
		nsTop 33
		nsLeft 24
		nsBottom 84
		nsRight 33
		description {dressing room}
		sightAngle 90
		lookStr {This is the Big and Tall Alien store dressing room.}
	)
)

(instance BargainShelf of Feature
	(properties
		x 59
		y 48
		nsTop 23
		nsLeft 37
		nsBottom 73
		nsRight 81
		description {bargain shelf}
		sightAngle 90
		lookStr {The reduced-cost shelf is stocked full of wonderful crap.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(not (IsFlag 18))
						(== (robo script:) roboClerkWelcome)
					)
					(robo doVerb: 5)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alienSuit1 of Feature
	(properties
		x 36
		y 130
		nsTop 85
		nsLeft 5
		nsBottom 176
		nsRight 68
		description {alien suit 1}
		sightAngle 90
		lookStr {** alien suit for the multi-eyed alien.}
	)
)

(instance alienSuit2 of Feature
	(properties
		x 133
		y 116
		nsTop 72
		nsLeft 108
		nsBottom 161
		nsRight 158
		description {** the alien suit #2}
		sightAngle 90
		lookStr {** alien suit for the multi-legged alien.}
	)
)

(instance alienSuit3 of Feature
	(properties
		x 283
		y 130
		nsTop 85
		nsLeft 256
		nsBottom 175
		nsRight 311
		description {** the alien suit #3}
		sightAngle 90
		lookStr {** alien suit for the single-legged alien.}
	)
)

(instance alienSuit4 of Feature
	(properties
		x 157
		y 31
		nsTop 10
		nsLeft 135
		nsBottom 53
		nsRight 180
		description {** the alien suit #4}
		sightAngle 90
		lookStr {** left rear alien suit.}
	)
)

(instance alienSuit5 of Feature
	(properties
		x 236
		y 32
		nsTop 10
		nsLeft 214
		nsBottom 54
		nsRight 258
		description {** the alien suit #5}
		sightAngle 90
		lookStr {** right rear alien suit.}
	)
)

(instance shelves of Feature
	(properties
		x 109
		y 31
		nsTop 10
		nsLeft 100
		nsBottom 53
		nsRight 119
		description {the shelves}
		sightAngle 90
		lookStr {** another bargain type of suits.}
	)
)

(instance CashRegister of Feature
	(properties
		x 205
		y 129
		z 32
		nsTop 90
		nsLeft 189
		nsBottom 105
		nsRight 221
		description {the cash register}
		sightAngle 90
		lookStr {** advanced cash register.}
	)
)

(instance light1 of Feature
	(properties
		x 23
		y 189
		z 174
		nsTop 10
		nsLeft 9
		nsBottom 20
		nsRight 37
		description {the light}
		sightAngle 90
		lookStr {** lights are used to brighten the display case.}
	)
)

(instance light2 of Feature
	(properties
		x 295
		y 189
		z 174
		nsTop 10
		nsLeft 282
		nsBottom 21
		nsRight 309
		description {the light}
		sightAngle 90
		lookStr {** lights are used to brighten the display case.}
	)
)

(instance roboPoly of Polygon
	(properties
		type PBarredAccess
	)
)

