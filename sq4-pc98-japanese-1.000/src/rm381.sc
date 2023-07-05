;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use rmnScript)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Avoid)
(use Sound)
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
	local21
)

(procedure (localproc_0)
	(HandsOn)
	(User canControl: 0)
	(gTheIconBar disable: 0)
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
		style 10
		south 380
		picAngle 60
	)

	(method (init)
		(LoadMany rsVIEW 0 4 402 383 381)
		(LoadMany rsFONT 68 69)
		(LoadMany rsSOUND 832 833)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 107 150 152 150 176 158 176 170 152 180 116 180 90 174 80 163
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 268 56 238 61 201 57 159 62 125 59 111 73 118 73 102 89 46 89 7 106 7 172 78 172 69 189 0 189 0 0 319 0 319 55
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 242 189 221 148 159 115 197 91 241 91 251 77 319 77
					yourself:
				)
		)
		(gEgo posn: 192 222 loop: 3 illegalBits: -32768 init:)
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
		(robo init: setLoop: Grooper setCycle: Walk setHeading: 0)
		(HandsOff)
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
							381
							0
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
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
				(if (or (OneOf (gEgo view:) 373 374) (not (IsFlag 17)))
					(robo
						illegalBits: 0
						xStep: 5
						yStep: 3
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
				(cond
					((OneOf (gEgo view:) 373 374)
						(self
							save1:
								(proc0_12
									381
									1
									67
									0
									20
									28
									global132
									29
									global129
									30
									1
									70
									319
								)
						)
						(= state 5)
					)
					((TestMallFlag (ScriptID 700 0) #rFlag2 4) ; mall
						(self
							save1:
								(proc0_12
									381
									2
									67
									0
									20
									28
									global132
									29
									global129
									30
									1
									70
									319
								)
						)
						(= state 5)
					)
					(else
						(self
							save1:
								(proc0_12
									381
									3
									67
									0
									20
									28
									global132
									29
									global129
									30
									1
									70
									319
								)
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
							381
							4
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(7
				(gEgo moveHead: 1)
				(HandsOn)
				(= cycles 1)
			)
			(8
				(= temp0 (Random 0 3))
				(robo
					setMotion:
						PolyPath
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
					setCycle: CT 1 1 self
					cycleSpeed: 1
				)
			)
			(1
				(robo setCycle: End self)
				(roboSound number: 832 loop: 0 play:)
			)
			(2
				(= cycles 3)
			)
			(3
				(robo setCycle: Beg self)
				(roboSound number: 833 loop: 0 play:)
			)
			(4
				(roboSound stop:)
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 163 99 self
				)
			)
			(5
				(robo setMotion: MoveTo 138 99 self)
			)
			(6
				(robo setHeading: 90 self)
			)
			(7
				(robo
					view: 383
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(roboSound number: 832 loop: 0 play:)
			)
			(8
				(= cycles 3)
			)
			(9
				(robo setCycle: Beg self)
				(roboSound number: 833 loop: 0 play:)
			)
			(10
				(robo setLoop: 1 cel: 0 setCycle: End self)
				(roboSound number: 832 loop: 0 play:)
			)
			(11
				(= cycles 3)
			)
			(12
				(roboSound number: 833 loop: 0 play:)
				(robo setCycle: Beg self)
			)
			(13
				(roboSound stop:)
				(self
					save1:
						(proc0_12
							381
							5
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(14
				(self restore:)
				(= cycles 1)
			)
			(15
				((ScriptID 700 0) rFlag2: (| ((ScriptID 700 0) rFlag2:) $0001)) ; mall, mall
				(self dispose:)
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
					(= state 7)
				)
				(robo stopUpd:)
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(1
				(self
					save1:
						(proc0_12
							381
							6
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(3
				((gEgo _head:) startUpd:)
				(robo startUpd:)
				(cond
					(
						(= local1
							(<=
								(GetDistance (robo x:) (robo y:) 140 90 0)
								(GetDistance (gEgo x:) (gEgo y:) 140 90 0)
							)
						)
						(robo ignoreActors: 0 setMotion: PolyPath 180 85 robo)
					)
					((> 20 (gEgo distanceTo: robo))
						(= local1 1)
						(robo ignoreActors: 0 setMotion: PolyPath 180 85 robo)
					)
					(else
						(gEgo
							ignoreActors: 0
							setAvoider: Avoid
							setMotion: PolyPath 140 90 self
						)
					)
				)
			)
			(5
				(if local1
					(= local1 0)
					(gEgo setAvoider: Avoid setMotion: PolyPath 140 90 self)
				else
					(= cycles 1)
				)
			)
			(6
				((gCurRoom obstacles:) delete: roboPoly)
				(robo setMotion: MoveTo 163 90 self)
				(gEgo
					setAvoider: 0
					ignoreActors: 0
					illegalBits: -32768
					setHeading: 180
				)
			)
			(7
				(if (not (TestMallFlag (ScriptID 700 0) #rFlag2 1)) ; mall
					(self setScript: measureEgo self)
				else
					(= cycles 1)
				)
			)
			(8
				(gEgo setMotion: PolyPath 165 100)
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 0
					setMotion: PolyPath 65 89 self
				)
			)
			(9
				(robo setLoop: 3)
				(= cycles 6)
			)
			(10
				(self
					save1:
						(proc0_12
							381
							7
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(12
				(robo view: 383 setLoop: 7 cel: 0 setMotion: MoveTo 48 93 self)
			)
			(13
				(robo setLoop: 8 heading: 180)
				(= cycles 2)
			)
			(14
				(self
					save1:
						(proc0_12
							381
							8
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(15
				(gEgo ignoreActors: 1 setMotion: PolyPath 48 100 self)
			)
			(17
				(gEgo ignoreActors: 0 setHeading: 0)
				(robo view: 381 setLoop: Grooper)
				(= cycles 5)
			)
			(18
				(robo setLoop: -1 setMotion: PolyPath 314 68 self)
				(gEgo illegalBits: 0 setMotion: MoveTo -5 (gEgo y:))
			)
			(19
				(= cycles 5)
			)
			(20
				(robo posn: 314 100 setMotion: MoveTo 243 117 self)
			)
			(21
				(Print 381 9) ; "You change your clothes, not forgetting the items in your pocket. You never know when you'll need them."
				(= cycles 1)
			)
			(22
				(Print 381 10) ; "You step out looking good as new."
				(gEgo
					view: 0
					setCycle: StopWalk 4
					headView: 4
					setMotion: MoveTo 48 100 self
				)
			)
			(23
				(gEgo illegalBits: -32768)
				(= local2 1)
				(self
					save1:
						(proc0_12
							381
							11
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(25
				(if (and (>= gBuckazoidCount 20) local3)
					(Print 381 12) ; "You wisely decide to pay up this time."
					(gEgo setMotion: PolyPath 188 135 self)
				else
					(HandsOn)
					(gEgo moveHead: 1)
					(self dispose:)
				)
			)
			(26
				(if local3
					(= cycles 1)
				)
			)
			(27
				(HandsOn)
				(robo doVerb: 4 0)
				(= seconds 30)
			)
			(28
				(robo setMotion: MoveTo 330 (robo y:) self)
			)
			(29
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

	(method (dispose)
		(if (and (not (& (gEgo signal:) $0002)) (gEgo _head:))
			((gEgo _head:) startUpd:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 17))
					(cond
						((and local2 local4)
							(self changeState: 21)
						)
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
					(Print 381 13) ; "You start to talk to the clerk but realize there is nothing else in here that would fit, much less be useful."
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
						(Face gEgo robo)
						(Face robo gEgo)
						(= cycles 4)
					)
					(else
						(self dispose:)
					)
				)
			)
			(3
				(robo stopUpd:)
				(gEgo moveHead: 0 stopUpd:)
				(= cycles 2)
			)
			(4
				(self
					save1:
						(proc0_12
							381
							14
							67
							0
							20
							28
							global137
							29
							global129
							30
							1
							70
							319
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
					(self dispose:)
				)
			)
			(8
				(robo stopUpd:)
				(gEgo moveHead: 0 stopUpd:)
				(= cycles 2)
			)
			(9
				(self
					save1:
						(proc0_12
							381
							15
							67
							0
							20
							28
							global137
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(11
				(self
					save1:
						(proc0_12
							381
							16
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(13
				(self
					save1:
						(proc0_12
							381
							17
							67
							0
							20
							28
							global137
							29
							global129
							30
							1
							70
							319
							67
							0
							10
						)
				)
				(= seconds 10)
			)
			(15
				(self
					save1:
						(proc0_12
							381
							18
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 10)
			)
			(17
				(robo setScript: getPants)
				(self dispose:)
			)
			(18
				(self
					save1:
						(proc0_12
							381
							19
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
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
			(21
				(gEgo mover: 0 stopUpd:)
				(= cycles 2)
			)
			(22
				(self
					save1:
						(proc0_12
							381
							11
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(= seconds 30)
			)
			(24
				(self dispose:)
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
			(1
				(switch register
					(0
						(cond
							(
								(or
									(IsFlag 17)
									(not local4)
									(not local2)
									(not (OneOf (gEgo view:) 0 4))
								)
								(Feature doVerb: 4)
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
											381
											20
											67
											0
											20
											28
											global132
											29
											global129
											30
											1
											70
											319
										)
								)
								(= state 4)
								(= seconds 10)
							)
						)
					)
					(10
						(if
							(or
								(IsFlag 17)
								(not local4)
								(not local2)
								(not (OneOf (gEgo view:) 0 4))
							)
							(Feature doVerb: 4)
							(self dispose:)
						else
							(self
								save1:
									(proc0_12
										381
										21
										67
										0
										20
										28
										global132
										29
										global129
										30
										1
										70
										319
									)
							)
							(= state 7)
							(= seconds 10)
						)
					)
					(else
						(Feature doVerb: 4)
						(self dispose:)
					)
				)
			)
			(3
				(Face gEgo robo self)
			)
			(4
				(HandsOn)
				(self
					save1:
						(proc0_12
							381
							22
							67
							0
							20
							28
							global132
							29
							global129
							30
							1
							70
							319
						)
				)
				(SetFlag 17)
				(SetScore 82 5)
				(= local4 0)
				(if (< (-= gBuckazoidCount 20) 1)
					(gEgo put: 0) ; buckazoid
				)
				(= seconds 10)
			)
			(6
				(self dispose:)
			)
			(7
				((ScriptID 700 0) rFlag1: (| ((ScriptID 700 0) rFlag1:) $0080)) ; mall, mall
				(gCurRoom newRoom: 380)
			)
			(9
				(self dispose:)
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
		view 381
		loop 1
		illegalBits 0
	)

	(method (init)
		(super init: &rest)
		(aSound prevSignal: -1)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 381 23) ; "This is your friendly sales clerk. He's automated and comes complete with a built-in attitude!"
			)
			(5 ; Talk
				(if
					(and
						(not (OneOf (gEgo view:) 373 374))
						(or
							(and
								(robo script:)
								((robo script:) isMemberOf: rmnScript)
								(== ((robo script:) save1:) 0)
							)
							(not (robo script:))
						)
						(!= (self script:) getPants)
						(!= (rmnProp script:) roboVerbTalkStuff)
					)
					(++ local0)
					(rmnProp setScript: roboVerbTalkStuff)
				else
					(super doVerb: theVerb)
				)
			)
			(4 ; Inventory
				(if (not (rmnProp script:))
					(rmnProp setScript: roboVerbUseStuff 0 invItem)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (not local21) (not mover) (!= (aSound prevSignal:) -1))
			(aSound prevSignal: -1)
			(aSound hold: 0)
		)
		(if local21
			(= local21 0)
		)
		(if (and mover (== (aSound prevSignal:) -1))
			(= local21 1)
			(aSound number: 830 loop: 0 play: prevSignal: 0 hold: 1)
		)
	)

	(method (cue)
		(localproc_1)
		(getPants cycles: 2)
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
		description {Big and Tall Alien Store}
		sightAngle 500
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 24) ; "Your first thought upon looking around here is, "Hey, this clothing store isn't so big and tall!" Then your brain kicks in. The store is crammed with racks of apparel for the discriminating gigantic obese alien. You silently remind yourself to start working out to get rid of those pesky fatty deposits."
			)
			(11 ; Smell
				(Print 381 25) ; "The store smells very much like a clothing store."
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 26) ; "This is the store's dressing room. It's empty."
			)
			(11 ; Smell
				(Print 381 27) ; "Grabbing a whiff confirms the suspicion that others have changed clothing here. Now if they'd only change socks..."
			)
			(10 ; Taste
				(Print 381 28) ; "There is nothing here you'd want to lay the old buds on."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 29) ; "The bargain shelves are loaded with all types of great things nobody would want."
			)
			(3 ; Do
				(if
					(and
						(not (IsFlag 17))
						(== (robo script:) roboClerkWelcome)
					)
					(robo doVerb: 5)
				else
					(super doVerb: theVerb)
				)
			)
			(11 ; Smell
				(Print 381 30) ; "You gather in the various fragrances offered by the menage of useless items stored here. You learn only that you don't want to do it again."
			)
			(10 ; Taste
				(Print 381 31) ; "Hey, there really is a difference in taste between the bargain brands and name brands!"
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
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 32) ; "This looks like a pressure suit for something with upper body appendages, the likes of which you've never seen."
			)
			(11 ; Smell
				(Print 381 33) ; "Now that's a clean smelling window."
			)
			(10 ; Taste
				(Print 381 34) ; "Do that and your anal-retentive host might have a stroke."
			)
			(3 ; Do
				(Print 381 35) ; "The suits are protected inside glass cases. Besides, none of them would fit you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {alien suit #2}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 36) ; "This suit is a replacement shell for some sort of exoskeletal wanderer. Check out those boots."
			)
			(11 ; Smell
				(Print 381 33) ; "Now that's a clean smelling window."
			)
			(10 ; Taste
				(Print 381 34) ; "Do that and your anal-retentive host might have a stroke."
			)
			(3 ; Do
				(Print 381 35) ; "The suits are protected inside glass cases. Besides, none of them would fit you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {alien suit #3}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 37) ; "It looks like a slip cover for a snake."
			)
			(11 ; Smell
				(Print 381 33) ; "Now that's a clean smelling window."
			)
			(10 ; Taste
				(Print 381 34) ; "Do that and your anal-retentive host might have a stroke."
			)
			(3 ; Do
				(Print 381 35) ; "The suits are protected inside glass cases. Besides, none of them would fit you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {alien suit #4}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 38) ; "The well dressed alien will want to be seen in this lovely ensemble. Perfect for those nights out at the solar ballet."
			)
			(11 ; Smell
				(Print 381 33) ; "Now that's a clean smelling window."
			)
			(10 ; Taste
				(Print 381 34) ; "Do that and your anal-retentive host might have a stroke."
			)
			(3 ; Do
				(Print 381 35) ; "The suits are protected inside glass cases. Besides, none of them would fit you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {alien suit #5}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 39) ; "This one looks like it might have been designed for ceremonial functions."
			)
			(11 ; Smell
				(Print 381 33) ; "Now that's a clean smelling window."
			)
			(10 ; Taste
				(Print 381 34) ; "Do that and your anal-retentive host might have a stroke."
			)
			(3 ; Do
				(Print 381 35) ; "The suits are protected inside glass cases. Besides, none of them would fit you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {shelves}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 40) ; "The reduced-cost shelf is stocked full of wonderful crap."
			)
			(3 ; Do
				(Print 381 41) ; "I'm sure the clerk would almost be glad to help you."
			)
			(11 ; Smell
				(Print 381 30) ; "You gather in the various fragrances offered by the menage of useless items stored here. You learn only that you don't want to do it again."
			)
			(10 ; Taste
				(Print 381 42) ; "Want more fiber in your diet?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {cash register}
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 381 43) ; "It's a Beancounter 200 revenue collection device."
			)
			(4 ; Inventory
				(if (not (rmnProp script:))
					(rmnProp setScript: roboVerbUseStuff 0 invItem)
				)
			)
			(3 ; Do
				(Print 381 44) ; "You start to mess with the register but quickly cease when you notice a sign which reads "Warning! Unauthorized users will be killed on sight!" These Beancounter folks take your money seriously."
			)
			(11 ; Smell
				(Print 381 45) ; "The heady scent of currency emanates from the revenue collection device."
			)
			(10 ; Taste
				(Print 381 46) ; "The dull taste of cold metal leaves you wanting for more."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {light}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 47) ; "Small fixtures emit rays of visible light greatly aiding the sighted shopper."
			)
			(else
				(super doVerb: theVerb)
			)
		)
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
		description {light}
		sightAngle 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 381 47) ; "Small fixtures emit rays of visible light greatly aiding the sighted shopper."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance roboPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance roboSound of Sound
	(properties)
)

(instance aSound of Sound
	(properties)
)

