;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 381)
(include sci.sh)
(use Main)
(use mall)
(use rmnScript)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Sound)
(use Motion)
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

(procedure (localproc_0) ; UNUSED
	(HandsOn)
	(gUser canControl: 0)
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
		(LoadMany rsVIEW 0 4 402 383 381 920)
		(LoadMany rsFONT 68 69)
		(LoadMany rsSOUND 832 833)
		(gEgo posn: 192 222 loop: 3 illegalBits: $8000 init:)
		(if
			(and
				(>= gBuckazoidCount 1000)
				(!= (gEgo view:) 373)
				(not (TestMallFlag (ScriptID 700 0) #rFlag2 8)) ; mall
				((ScriptID 700 0) rFlag2: (| ((ScriptID 700 0) rFlag2:) $0008)) ; mall, mall
			)
			(bobA cycleSpeed: 12 init: setScript: bobScript)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 107 150 152 150 176 158 176 170 152 180 116 180 90 174 80 163
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 268 56 238 61 201 57 159 62 142 65 119 65 118 73 102 89 46 89 7 106 7 172 78 172 69 189 0 189 0 0 319 0 319 55
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 242 189 221 148 159 115 197 91 241 91 251 77 319 77
						yourself:
					)
			)
		else
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
		(robo setLoop: Grooper setCycle: Walk setHeading: 0 init:)
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
						(switch ((gUser alterEgo:) edgeHit:)
							(EDGE_BOTTOM south)
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

(instance bobScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bobA setCycle: Fwd)
				(= seconds 10)
			)
			(1
				(bobA setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(= seconds 3)
			)
			(3
				(bobA setCycle: Beg self)
			)
			(4
				(bobA setLoop: 0 setCycle: Fwd)
				(self dispose:)
			)
		)
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

(instance bobLookScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tBob say: 2 self) ; "Nope."
			)
			(1
				(tBob say: 2 self) ; "Nope."
			)
			(2
				(tBob say: 3 self) ; "Bad color."
			)
			(3
				(tBob say: 2 self) ; "Nope."
				(bobA setScript: bobScript)
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
				(tClerk modNum: 381 say: 12 self) ; "How dare you try to leave without paying."
			)
			(4
				(HandsOn)
				(gCurRoom newRoom: 380)
			)
			(else
				(= cycles 1)
			)
		)
	)
)

(instance roboClerkWelcome of rmnScript
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (gUser canInput:) (gEgo mover:))
			(= seconds 0)
			(HandsOff)
			(Face gEgo robo self)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
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
						(tClerk modNum: 381 say: 14 self) ; "I am dearly sorry, Miss. This is a male clothing store."
						(= state 5)
					)
					((TestMallFlag (ScriptID 700 0) #rFlag2 4) ; mall
						(tClerk modNum: 381 say: 12 self) ; "How dare you try to leave without paying."
						(= state 5)
					)
					(else
						(tClerk modNum: 381 say: 1 self) ; "Pardon me, sir. You appear to be in dire need of my services."
					)
				)
			)
			(4
				(HandsOn)
				(= seconds 15)
			)
			(5
				(tClerk modNum: 381 say: 2 self) ; "Let me know if there is anything I can get for you."
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
					cycleSpeed: 12
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
					cycleSpeed: 6
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
					cycleSpeed: 12
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
				(tClerk modNum: 381 say: 3 self) ; "We've got just the thing for the likes of you."
			)
			(14
				(= cycles 1)
			)
			(15
				((ScriptID 700 0) rFlag2: (| ((ScriptID 700 0) rFlag2:) $0001)) ; mall, mall
				(self dispose:)
			)
		)
	)
)

(instance getPants of Script
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
				(tClerk modNum: 381 say: 13 self) ; "I see. Well, alright, let me get your measurements."
			)
			(2
				((gEgo _head:) startUpd:)
				(robo startUpd:)
				(if
					(= local1
						(<=
							(GetDistance (robo x:) (robo y:) 140 90 0)
							(GetDistance (gEgo x:) (gEgo y:) 140 90 0)
						)
					)
					(robo ignoreActors: 1 setMotion: PolyPath 180 85 robo)
				else
					(gEgo ignoreActors: 1 setMotion: PolyPath 140 90 self)
				)
			)
			(3
				(if local1
					(= local1 0)
					(gEgo setMotion: PolyPath 140 90 self)
				else
					(= cycles 1)
				)
			)
			(4
				((gCurRoom obstacles:) delete: roboPoly)
				(robo setMotion: MoveTo 163 90 self)
				(gEgo setHeading: 180)
			)
			(5
				(if (not (TestMallFlag (ScriptID 700 0) #rFlag2 1)) ; mall
					(self setScript: measureEgo self)
				else
					(= cycles 1)
				)
			)
			(6
				(gEgo illegalBits: $8000 ignoreActors: 0)
				(robo
					view: 381
					setLoop: Grooper
					setCycle: Walk
					cycleSpeed: 6
					setMotion: PolyPath 65 89 self
				)
			)
			(7
				(robo setLoop: 3)
				(= cycles 6)
			)
			(8
				(tClerk modNum: 381 say: 16 self) ; "I assume you'll be wanting something in the generic space hero line."
			)
			(9
				(= cycles 2)
			)
			(10
				(robo view: 383 setLoop: 7 cel: 0 setMotion: MoveTo 48 93 self)
			)
			(11
				(robo setLoop: 8 heading: 180)
				(= cycles 2)
			)
			(12
				(tClerk modNum: 381 say: 4 self) ; "These will do for you. Try them on in the dressing room here, if you wish."
			)
			(13
				(gEgo ignoreActors: 1 setMotion: PolyPath 48 100 self)
			)
			(14
				(gEgo ignoreActors: 0 setHeading: 0)
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
				(roboSound stop:)
				(= cycles 2)
			)
			(19
				(gNarrator modNum: 381 say: 4 self) ; "You change your clothes, not forgetting the items in your pocket. You never know when you'll need them."
			)
			(20
				(gNarrator modNum: 381 say: 5 self) ; "You step out looking good as new."
			)
			(21
				(gEgo
					view: 0
					setCycle: StopWalk 4
					headView: 4
					setMotion: MoveTo 48 100 self
				)
			)
			(22
				(gEgo illegalBits: $8000)
				(= local2 1)
				(tClerk modNum: 383 say: 5 self) ; "That will be 20 buckazoids, please."
			)
			(23
				(if (and (>= gBuckazoidCount 20) local3)
					(gNarrator modNum: 381 say: 6) ; "You wisely decide to pay up this time."
					(gEgo setMotion: PolyPath 188 135 self)
				else
					(HandsOn)
					(gEgo moveHead: 1)
					(self dispose:)
				)
			)
			(24
				(if local3
					(= cycles 1)
				)
			)
			(25
				(HandsOn)
				(robo doVerb: 8)
				(= seconds 30)
			)
			(26
				(robo setMotion: MoveTo 330 (robo y:) self)
			)
			(27
				(roboClerkWelcome start: 6)
				(robo posn: 314 68 setScript: roboClerkWelcome)
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
					(gNarrator modNum: 381 say: 7) ; "You start to talk to the clerk but realize there is nothing else in here that would be appropriate."
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
				(tRog modNum: 383 say: 1 self) ; "I'm sorry, I lost my boots and the legs of my pants in a deadly fight with a giant sea slug, which I won in the nick of time with my clever thinking and my...uh...cleverness."
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
				(tRog modNum: 383 say: 2 self) ; "Hello. I was hoping to make a purchase."
			)
			(11
				(tClerk modNum: 383 say: 6 self) ; "Oh, it's you! Please don't waste my time."
			)
			(13
				(tRog modNum: 383 say: 3 self) ; "Please help me. That other deal was a total misunderstanding. Anyway, as I said, I've misplaced the legs of my pants. My boots seem to be missing as well."
			)
			(15
				(tClerk modNum: 383 say: 7 self) ; "If it will help me rid the store of you, I'll give you one more try. Come with me then."
			)
			(17
				(robo setScript: getPants)
				(self dispose:)
			)
			(18
				(tClerk modNum: 381 say: 10 self) ; "Oh, it's you again."
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
				(tClerk modNum: 383 say: 5 self) ; "That will be 20 buckazoids, please."
			)
			(24
				(self dispose:)
			)
			(else
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
					(8
						(cond
							(
								(or
									(IsFlag 17)
									(not local4)
									(not local2)
									(not (OneOf (gEgo view:) 0 4))
								)
								(Feature doVerb: 8)
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
								(tClerk modNum: 381 say: 9 self) ; "You haven't the money to pay for this."
								(= state 4)
							)
						)
					)
					(18
						(if
							(or
								(IsFlag 17)
								(not local4)
								(not local2)
								(not (OneOf (gEgo view:) 0 4))
							)
							(Feature doVerb: 18)
							(self dispose:)
						else
							(tClerk modNum: 381 say: 15 self) ; "I am sorry, we don't accept ATM cards."
							(= state 7)
						)
					)
					(else
						(Feature doVerb: register)
						(self dispose:)
					)
				)
			)
			(3
				(Face gEgo robo self)
			)
			(4
				(SetScore 82 5)
				(tClerk modNum: 381 say: 8 self) ; "Thank you so much for shopping with us, sir. Do come back soon."
				(SetFlag 17)
				(= local4 0)
				(if (< (-= gBuckazoidCount 20) 1)
					(gEgo put: 0) ; buckazoid
				)
				(HandsOn)
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
				(= cycles 1)
			)
		)
	)
)

(instance robo of Sq4Actor
	(properties
		x 235
		y 67
		sightAngle 90
		view 381
		loop 1
		illegalBits 0
		lookStr 8 ; "This is your friendly sales clerk. He's automated and comes complete with a built-in attitude!"
	)

	(method (init)
		(super init: &rest)
		(aSound prevSignal: -1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if
					(and
						(not (OneOf (gEgo view:) 373 374))
						(or
							(and
								(robo script:)
								(or
									((robo script:) isMemberOf: rmnScript)
									(== (robo script:) getPants)
								)
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
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(if (not (rmnProp script:))
					(rmnProp setScript: roboVerbUseStuff theVerb theVerb)
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

(instance rmnProp of Sq4Prop
	(properties
		x -20
		y -20
		view 920
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

(instance theShop of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 500
		lookStr 9 ; "Your first thought upon looking around is, "Hey, this store isn't so big and tall!" Then your brain kicks in. The store is crammed with racks of apparel for the discriminating gigantic obese alien."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 10) ; "The smell of synthetics permiates the air."
			)
			(else 0)
		)
	)
)

(instance dressingRoom of Sq4Feature
	(properties
		x 28
		y 58
		nsTop 33
		nsLeft 24
		nsBottom 84
		nsRight 33
		sightAngle 90
		lookStr 11 ; "This is the store's dressing room."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 12) ; "A good whiff confirms the suspicion that others have indeed changed clothing here. If only they'd changed socks..."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 13) ; "There is nothing here you'd want to lay the old buds on."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance BargainShelf of Sq4Feature
	(properties
		x 59
		y 48
		nsTop 23
		nsLeft 37
		nsBottom 73
		nsRight 81
		sightAngle 90
		lookStr 14 ; "The bargain shelves are loaded with all types of great things nobody would want."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if
					(and
						(not (IsFlag 17))
						(== (robo script:) roboClerkWelcome)
					)
					(robo doVerb: 2)
				else
					(super doVerb: theVerb)
				)
			)
			(6 ; Smell
				(gNarrator modNum: 381 say: 15) ; "You gather in the various fragrances offered by the menage of useless items stored here. You learn only that you don't want to do it again."
			)
			(7 ; Taste
				(gNarrator say: 30) ; "Hey, there really is a difference in taste between the bargain brands and name brands."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alienSuit1 of Sq4Feature
	(properties
		x 36
		y 130
		nsTop 85
		nsLeft 5
		nsBottom 176
		nsRight 68
		sightAngle 90
		lookStr 16 ; "This looks like a pressure suit for something with upper body appendages."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 2) ; "Now that's a clean smelling window."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 3) ; "Do that and your anal-retentive host might have a stroke."
			)
			(4 ; Do
				(gNarrator modNum: 381 say: 1) ; "The suits are locked inside glass cases. Besides, none of them would fit you unless of course you have twelve arms."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alienSuit2 of Sq4Feature
	(properties
		x 133
		y 116
		nsTop 72
		nsLeft 108
		nsBottom 161
		nsRight 158
		sightAngle 90
		lookStr 17 ; "This suit is a replacement shell for some sort of exoskeletal wanderer. And hey, check out those boots."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 2) ; "Now that's a clean smelling window."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 3) ; "Do that and your anal-retentive host might have a stroke."
			)
			(4 ; Do
				(gNarrator modNum: 381 say: 1) ; "The suits are locked inside glass cases. Besides, none of them would fit you unless of course you have twelve arms."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alienSuit3 of Sq4Feature
	(properties
		x 283
		y 130
		nsTop 85
		nsLeft 256
		nsBottom 175
		nsRight 311
		sightAngle 90
		lookStr 18 ; "It looks like a slip cover for a snake."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 2) ; "Now that's a clean smelling window."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 3) ; "Do that and your anal-retentive host might have a stroke."
			)
			(4 ; Do
				(gNarrator modNum: 381 say: 1) ; "The suits are locked inside glass cases. Besides, none of them would fit you unless of course you have twelve arms."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alienSuit4 of Sq4Feature
	(properties
		x 157
		y 31
		nsTop 10
		nsLeft 135
		nsBottom 53
		nsRight 180
		sightAngle 90
		lookStr 19 ; "The well dressed alien will want to be seen in this lovely ensemble. Perfect for those nights out at the solar ballet."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 2) ; "Now that's a clean smelling window."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 3) ; "Do that and your anal-retentive host might have a stroke."
			)
			(4 ; Do
				(gNarrator modNum: 381 say: 1) ; "The suits are locked inside glass cases. Besides, none of them would fit you unless of course you have twelve arms."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance alienSuit5 of Sq4Feature
	(properties
		x 236
		y 32
		nsTop 10
		nsLeft 214
		nsBottom 54
		nsRight 258
		sightAngle 90
		lookStr 20 ; "This one looks like it might have been designed for ceremonial functions."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Smell
				(gNarrator modNum: 381 say: 2) ; "Now that's a clean smelling window."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 3) ; "Do that and your anal-retentive host might have a stroke."
			)
			(4 ; Do
				(gNarrator modNum: 381 say: 1) ; "The suits are locked inside glass cases. Besides, none of them would fit you unless of course you have twelve arms."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shelves of Sq4Feature
	(properties
		x 109
		y 31
		nsTop 10
		nsLeft 100
		nsBottom 53
		nsRight 119
		sightAngle 90
		lookStr 21 ; "The reduced-cost shelf is stocked full of wonderful junk...er...merchandise."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator modNum: 381 say: 22) ; "I'm sure the clerk would almost be glad to help you."
			)
			(6 ; Smell
				(gNarrator modNum: 381 say: 15) ; "You gather in the various fragrances offered by the menage of useless items stored here. You learn only that you don't want to do it again."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 23) ; "Want more fiber in your diet?"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance CashRegister of Sq4Feature
	(properties
		x 205
		y 129
		z 32
		nsTop 90
		nsLeft 189
		nsBottom 105
		nsRight 221
		sightAngle 90
		lookStr 24 ; "It's a Beancounter 200 revenue collection device."
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gNarrator modNum: 381 say: 25) ; "You start to mess with the register but quickly cease when you notice a sign which reads "WARNING! UNAUTHORIZED USERS WILL BE KILLED ON SIGHT!""
			)
			(6 ; Smell
				(gNarrator modNum: 381 say: 26) ; "The heady scent of currency emanates from the revenue collection device."
			)
			(7 ; Taste
				(gNarrator modNum: 381 say: 27) ; "The dull taste of cold metal leaves you wanting for more."
			)
			((OneOf theVerb 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23) ; buckazoid, rope, bomb, rabbit, battery, jar, gum, tank, hintbook, pen, atmCard, plug, cigar, matches, diskette, laptop
				(if (not (rmnProp script:))
					(rmnProp setScript: roboVerbUseStuff theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance light1 of Sq4Feature
	(properties
		x 23
		y 189
		z 174
		nsTop 10
		nsLeft 9
		nsBottom 20
		nsRight 37
		sightAngle 90
		lookStr 28 ; "Small fixtures emit rays of visible light greatly aiding the sighted shopper."
	)
)

(instance light2 of Sq4Feature
	(properties
		x 295
		y 189
		z 174
		nsTop 10
		nsLeft 282
		nsBottom 21
		nsRight 309
		sightAngle 90
		lookStr 28 ; "Small fixtures emit rays of visible light greatly aiding the sighted shopper."
	)
)

(instance bobA of Prop
	(properties
		x 109
		y 27
		sightAngle 40
		approachX 149
		approachY 67
		view 103
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (self loop:)
					(tBob say: 1) ; "Too small!"
				else
					(self setScript: bobLookScript)
				)
			)
			(2 ; Talk
				(if (self loop:)
					(tBob say: 5) ; "I already have three pairs of these."
				else
					(tBob say: 6) ; "There's nothing in my size."
				)
			)
			(else
				(tBob say: 4) ; "Hey, leave me alone. I've got programming to do."
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

(instance tBob of Sq4Narrator
	(properties
		noun 38
		modNum 381
		talkerNum 38
	)
)

(instance tRog of Sq4Talker
	(properties
		noun 7
		modNum 383
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tClerk of Sq4Talker
	(properties
		noun 23
		view 1707
		talkerNum 23
		mouthOffsetX 9
		mouthOffsetY 33
		eyeOffsetX 18
		eyeOffsetY 16
		tStyle 1
	)
)

