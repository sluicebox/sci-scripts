;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use rmnScript)
(use eRS)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm371 0
)

(local
	local0 = 1
	local1
	local2 = 60
	local3
	[local4 50]
)

(procedure (localproc_0 &tmp temp0)
	(return
		(cond
			((< (= temp0 (Random 0 10)) 4) 0)
			((< temp0 8) 1)
			((== (gCurRoom script:) rogerDance)
				(Random 0 1)
			)
			(else temp0)
		)
	)
)

(procedure (localproc_1)
	(return
		(switch (Random 0 7)
			(0 {"Trying to weasel out of paying, huh?"})
			(1 {"Cut the chit chat and hand over the cash."})
			(2 {"It really is nice weather, but then this is an artificial computer controlled climate. Now how about some cash?"})
			(3 {"I think you're cute too, but looks won't pay for those designer duds."})
			(4 {"We don't haggle over prices here hon, either pay up or put the dress back!"})
			(5 {"I don't want to have to throw you out, but if you don't hand over the cash, I'll have no choice."})
			(6 {"Stop wasting my time, you sickos are all the same, now pay up!})
			(7 {"Listen, you twerp, the dress is 60 buckazoids, now hand over the cash or the dress!"})
		)
	)
)

(class Mannequin of View
	(properties
		direct 0
		lastcel 0
		dummyTime 0
		detail 0
	)

	(method (dance)
		(if dummyTime
			(-- dummyTime)
		else
			(= dummyTime (Random 0 4))
			(= direct (localproc_0))
		)
		(cond
			((== cel lastcel)
				(= direct 0)
			)
			((not cel)
				(= direct 1)
			)
		)
		(if (>= (gGame detailLevel:) detail)
			(switch direct
				(0
					(self setCel: (- cel 1))
				)
				(1
					(self setCel: (+ cel 1))
				)
				(else 0)
			)
		else
			(self stopUpd:)
		)
	)
)

(instance rm371 of SQRoom
	(properties
		picture 371
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 0 4 402 371 372 373 374)
		(LoadMany rsFONT 68 69)
		(gLongSong number: 0 stop:)
		(gLongSong2 vol: 127 changeState:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 321 70 296 70 291 70 273 69 230 60 58 60 42 74 25 75 4 90 76 118 64 152 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 155 189 153 176 161 159 193 153 274 120 304 91 296 87 295 81 299 73 321 73
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 87 70 125 82 157 78 188 84 227 77 268 79 292 93 229 116 189 102 154 113 123 101 87 115 20 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 61 158 182 113 197 112 208 116 199 139 95 182 67 184 55 172
					yourself:
				)
		)
		(gEgo posn: 130 230 setHeading: 0 ignoreActors: 1 init:)
		(gCurRoom setScript: enterScript)
		(dummy1 init:)
		(dummy2 init:)
		(dummy3 init:)
		(dummy4 init:)
		(model1 init:)
		(model2 init:)
		(super init:)
		(rmnProp init:)
		(if (== (gEgo view:) 402)
			(mall rFlag3: (| (mall rFlag3:) $0008))
		else
			(mall rFlag3: (& (mall rFlag3:) $fff7))
		)
		(wig init:)
		(clerk init: posn: 268 157 setCycle: Walk)
		(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
		(gFeatures
			add: wall theRack theRack1 theRack2 theArea changeRoom wigs wigs2
			eachElementDo: #init
			doit:
		)
		(self setRegions: 700) ; mall
	)

	(method (doit &tmp temp0)
		(if (gLongSong2 prevSignal:)
			(gLongSong2 prevSignal: 0)
			(dummy1 dance:)
			(dummy3 dance:)
			(dummy4 dance:)
			(dummy2 dance:)
			(if (== (gCurRoom script:) rogerDance)
				(roger dance:)
			)
		)
		(if
			(and
				(OneOf (gEgo view:) 0 4)
				(IsFlag 29)
				(TestMallFlag (ScriptID 700 0) #rFlag3 16) ; mall
			)
			(ClearFlag 90)
			(SetScore 50 3)
		)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(OneOf (gEgo view:) 373 374)
					(!= (clerk script:) firstTimeScript)
					(>= (gEgo x:) 310)
				)
				(gCurRoom setScript: changeScript)
			)
			(
				(and
					(TestMallFlag (ScriptID 700 0) #rFlag3 16) ; mall
					(!= (clerk script:) firstTimeScript)
					(>= (gEgo x:) 310)
				)
				(gCurRoom setScript: changeScript)
			)
			(
				(and
					(IsFlag 90)
					(!= (clerk script:) firstTimeScript)
					(>= (gEgo x:) 310)
				)
				(gCurRoom setScript: changeScript)
			)
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: exitScript)
			)
			((== (gEgo edgeHit:) 2)
				(gEgo setMotion: 0 posn: 317 (gEgo y:))
			)
		)
		(super doit:)
	)

	(method (dispose)
		(if (and local1 local0)
			(mall rFlag1: (| (mall rFlag1:) $0080))
		)
		(if
			(and
				(not (TestMallFlag (ScriptID 700 0) #rFlag3 2)) ; mall
				(TestMallFlag (ScriptID 700 0) #rFlag3 1) ; mall
				(TestMallFlag (ScriptID 700 0) #rFlag1 128) ; mall
			)
			(mall rFlag3: (| (mall rFlag3:) $0002))
		)
		(if
			(and
				(not (TestMallFlag (ScriptID 700 0) #rFlag3 1)) ; mall
				(TestMallFlag (ScriptID 700 0) #rFlag1 128) ; mall
			)
			(mall rFlag3: (| (mall rFlag3:) $0001))
		)
		(gEgo ignoreActors: 0)
		(if (== local0 0)
			(SetFlag 90)
		)
		(super dispose:)
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 130 185 self)
			)
			(1
				(self dispose:)
				(HandsOn)
			)
		)
	)
)

(instance changeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 317 75 self)
			)
			(1
				(if (== (gEgo view:) 373)
					(if (IsFlag 90)
						(Print 371 0) ; "You quickly change your clothes while thinking to yourself that, even dressed in drag, you still have that animal magnetism... or is that just failed deodorant?"
						(if (TestMallFlag (ScriptID 700 0) #rFlag3 8) ; mall
							(NormalEgo 2 402 14)
							(AnimateEgoHead 14)
						else
							(NormalEgo 2 0 4)
							(AnimateEgoHead 4)
						)
						(= cycles 10)
					else
						(Print 371 1) ; "Quickly changing your clothes you emerge in your space guy regalia."
						(= local1 0)
						(if (TestMallFlag (ScriptID 700 0) #rFlag3 8) ; mall
							(NormalEgo 2 402 14)
							(AnimateEgoHead 14)
						else
							(NormalEgo 2 0 4)
							(AnimateEgoHead 4)
						)
						(= cycles 10)
					)
					(mall rFlag3: (| (mall rFlag3:) $0010))
				else
					(Print 371 2) ; "You're becoming a whiz at putting on women's clothing. In a flash you emerge looking swank as ever. For a split second you believe that you might be enjoying this just a little too much."
					(gEgo view: 373 setCycle: StopWalk 374)
					(= local1 1)
					(AnimateEgoHead 374)
					(mall rFlag3: (& (mall rFlag3:) $ffef))
					(= cycles 3)
				)
			)
			(2
				(gEgo setMotion: MoveTo 285 72 self)
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance shopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(gEgo setMotion: PolyPath 195 175 self)
			)
			(1
				(Face gEgo clerk)
				(if (IsFlag 33)
					(clerk setScript: firstTimeScript)
				else
					(clerk setScript: introScript)
				)
				(self dispose:)
			)
		)
	)
)

(instance introScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(TestMallFlag (ScriptID 700 0) #rFlag3 32) ; mall
						(TestMallFlag (ScriptID 700 0) #rFlag3 64) ; mall
					)
					(Print 371 3) ; "She ignores you. She said she was busy."
					(HandsOn)
					(self dispose:)
				else
					(= cycles 1)
				)
			)
			(1
				(if
					(and
						(TestMallFlag (ScriptID 700 0) #rFlag3 32) ; mall
						(not (TestMallFlag (ScriptID 700 0) #rFlag3 64)) ; mall
					)
					(self
						save1:
							(proc0_12
								{"Listen hon, I got work to do here. You run along now. Maybe you could bring back your girl sometime. Bye now."}
								67
								1
								1
								28
								global132
								29
								global129
								30
								1
								70
								310
							)
					)
					(= state 7)
					(mall rFlag3: (| (mall rFlag3:) $0040))
					(= seconds 10)
				else
					(= cycles 1)
				)
			)
			(3
				(self
					save1:
						(proc0_12
							{"Are you sure you got the right store, hon?"}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(5
				(self
					save1:
						(proc0_12
							{"I'm not sure, I think I'll just look around for a bit."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(7
				(self
					save1:
						(proc0_12
							{"Let us know if we can help."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(mall rFlag3: (| (mall rFlag3:) $0020))
				(= seconds 10)
			)
			(9
				(HandsOn)
				(self dispose:)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance exitScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (== local1 1) (== local0 1))
					(self changeState: 6)
				else
					(= cycles 1)
				)
			)
			(1
				(if (clerk script:)
					((clerk script:) dispose:)
				)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 10) self
				)
			)
			(2
				(Face gEgo clerk self)
			)
			(3
				(self
					save1:
						(proc0_12
							{"Thanks for shopping at Sacks!"}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 3)
			)
			(4
				(self restore:)
				(= cycles 1)
			)
			(5
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(6
				(gCurRoom newRoom: 370)
				(self dispose:)
			)
		)
	)
)

(instance firstTimeScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (TestMallFlag (ScriptID 700 0) #rFlag3 1) ; mall
					(self setScript: secondTalk self)
				else
					(self setScript: firstTalk self)
				)
			)
			(1
				(HandsOff)
				(clerk setMotion: MoveTo 344 185 self)
				(arm dispose:)
				(clerkSFX init: play:)
			)
			(2
				(clerk x: 322 y: 72 setPri: -1 setMotion: PolyPath 95 148 self)
			)
			(4
				(clerk setLoop: 9 setCycle: 0 setMotion: PolyPath 196 114 self)
			)
			(5
				(clerkSFX stop:)
				(self
					save1:
						(proc0_12
							{"I'm sure this will suit that 'special someone's needs'. It's all the rage." }
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(7
				(clerk setLoop: 9 setCycle: 0 setMotion: PolyPath 281 75 self)
				(clerkSFX play:)
			)
			(8
				(clerkSFX stop:)
				(self
					save1:
						(proc0_12
							{"I suppose you'll want to try it on now. Here, use this dressing room." }
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(10
				(clerk setPri: 0 setMotion: PolyPath 317 75 self)
				(gEgo setMotion: PolyPath 317 75 self)
				(clerkSFX play:)
			)
			(11
				(clerkSFX stop:)
			)
			(13
				(clerk
					setPri: -1
					setLoop: 1
					ignoreActors:
					setMotion: PolyPath 273 74 self
				)
				(clerkSFX play:)
			)
			(14
				(clerkSFX stop:)
				(clerk setLoop: 0 setCel: 2)
				(self
					save1:
						(proc0_12
							{"And honey, if your 'special someone' needs a wig, this one should look pretty good on you."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(16
				(wig dispose:)
				(clerk setMotion: PolyPath 317 75 self)
				(clerkSFX play:)
			)
			(17
				(clerkSFX stop:)
				(= cycles 40)
			)
			(18
				(clerk
					setLoop: 3
					setCycle: Walk
					x: 344
					y: 185
					setPri: 13
					setMotion: MoveTo 268 157 self
				)
				(clerkSFX play:)
			)
			(19
				(clerkSFX stop:)
				(clerk setLoop: 5)
				(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
				(= cycles 1)
			)
			(20
				(gEgo
					view: 373
					sightAngle: 180
					setCycle: StopWalk 374
					setMotion: PolyPath 185 160 self
				)
				(AnimateEgoHead 374)
			)
			(21
				(Face gEgo clerk)
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Very lovely, honey, it's made for you. Would you like us to wrap it up, or would that 'special someone' prefer you to wear it home?"}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(23
				(self
					save1:
						(proc0_12
							{"I think I'll wear it home."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(25
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Just what we thought. That will be 60 buckazoids, sicko."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(gTheIconBar enable: 6 7)
				(= local1 1)
				(= seconds 10)
			)
			(26
				(self restore:)
				(= cycles 1)
			)
			(27
				(HandsOn)
				(clerk setScript: bogusScript)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance firstTalk of rmnScript
	(properties)

	(method (init)
		(super init: &rest)
		(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(clerk setLoop: 5)
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Hiya, hon. I'm Maebot, fashion consultant to the cosmos. What can we do with ya today?" }
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(2
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(self
					save1:
						(proc0_12
							{"Well, uh, this is kinda hard to explain..."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(4
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Oh, let me guess. You want something for someone very special, somebody who'd die to get the latest in high-galactic fashion."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(6
				(self
					save1:
						(proc0_12
							{"Are we right or are we right?"}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(8
				(self
					save1:
						(proc0_12
							{"Uh...we're right."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(10
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Okay, what size does she take?"}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(12
				(self
					save1:
						(proc0_12
							{"38."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(14
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Ooh, I don't think we're right about that."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(16
				(self
					save1:
						(proc0_12
							{"Um, I'm...uh...I'm not sure, but she's, um, built about like me."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(18
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Is she? A likely story. Good thing for you I can keep a secret, sweetie."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 10)
			)
			(20
				(arm dispose:)
				(clerk setLoop: -1)
				(self dispose:)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance secondTalk of rmnScript
	(properties)

	(method (init)
		(super init: &rest)
		(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (TestMallFlag (ScriptID 700 0) #rFlag3 2) ; mall
					(= state 1)
					(self
						save1:
							(proc0_12
								{"Oh, it's you again, would you stop wasting my time?"}
								67
								1
								1
								28
								global132
								29
								global129
								30
								1
								70
								310
							)
					)
				else
					(self
						save1:
							(proc0_12
								{"Oh, it's you again. What do you want?"}
								67
								1
								1
								28
								global132
								29
								global129
								30
								1
								70
								310
							)
					)
				)
				(arm setCycle: ForwardCounter (Random 1 3))
				(= seconds 30)
			)
			(2
				(User canInput: 1)
			)
			(3
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(self
					save1:
						(proc0_12
							{"I would still like to buy that dress, I'm terribly sorry about the misunderstanding."}
							67
							1
							1
							28
							global140
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 30)
			)
			(5
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"Well, okay, but don't try that again. If you have to be weird, fine, but we don't appreciate shoplifters, dear."}
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							310
						)
				)
				(= seconds 30)
			)
			(7
				(arm dispose:)
				(self dispose:)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance talkScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self restore:)
				(= cycles 1)
			)
			(1
				(self
					save1:
						(proc0_12
							(localproc_1)
							67
							1
							1
							28
							global132
							29
							global129
							30
							1
							70
							320
						)
				)
				(= seconds 10)
			)
			(1
				(self restore:)
			)
		)
	)
)

(instance bogusScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
		)
	)
)

(instance clerkHead of Prop ; UNUSED
	(properties
		x 50
		y 50
		z -1000
		view 372
		loop 6
	)
)

(instance arm of Prop
	(properties
		x 50
		y 50
		view 372
		loop 8
		priority 14
		signal 16400
	)
)

(instance dummy1 of Mannequin
	(properties
		x 88
		y 69
		description {mannequin}
		sightAngle 180
		lookStr {"Would stripes look good on me", you wonder? Those boots are attractive.}
		view 371
		cel 10
		priority 6
		signal 16400
		lastcel 6
		detail 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 4) ; "Hmmm.. they can't be real. No living thing can resist my charm."
			)
			(10 ; Taste
				(Print 371 5) ; "Nah. You've never had a taste for stripes."
			)
			(11 ; Smell
				(Print 371 6) ; "Aromatic metals, lubricants, and synthetic materials emanate from its general vicinity."
			)
			(5 ; Talk
				(Print 371 7) ; "Hopefully, you ask her to dance but get no response. Shot down again."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dummy2 of Mannequin
	(properties
		x 221
		y 73
		description {mannequin}
		sightAngle 180
		lookStr {Hey! Not bad for a robotic mannequin.}
		view 371
		loop 1
		cel 3
		priority 6
		signal 16400
		lastcel 6
		detail 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 8) ; "Hmmm.., they can't be real. No living thing can resist my charm."
			)
			(10 ; Taste
				(Print 371 9) ; "Despite your love for Synthoskin, you decide that wouldn't be gentlemanly."
			)
			(11 ; Smell
				(Print 371 10) ; "Closet mannequin whiffer, eh?"
			)
			(5 ; Talk
				(Print 371 11) ; "Although just an animated mannequin, it's not intelligent enough to converse with even you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dummy3 of Mannequin
	(properties
		x 159
		y 70
		description {mannequin}
		sightAngle 180
		lookStr {You like the shoes, but the stripes might make you look overweight.}
		view 371
		loop 2
		cel 4
		priority 6
		signal 16400
		lastcel 7
		detail 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 12) ; "Must be phoney. You know you're a babe magnet."
			)
			(10 ; Taste
				(Print 371 13) ; "OUCH! You almost got a sliver in your tongue!"
			)
			(11 ; Smell
				(Print 371 14) ; "Technosmell emanates from it."
			)
			(5 ; Talk
				(Print 371 11) ; "Although just an animated mannequin, it's not intelligent enough to converse with even you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dummy4 of Mannequin
	(properties
		x 31
		y 62
		description {mannequin}
		sightAngle 180
		lookStr {Fringe! Would that be too daring?}
		view 371
		loop 3
		cel 6
		priority 3
		signal 16400
		lastcel 11
		detail 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if
					(and
						(not (clerk script:))
						(not (gCurRoom script:))
						(OneOf (gEgo view:) 373 374)
					)
					(gCurRoom setScript: rogerDance)
				else
					(Print 371 15) ; "Keep your hands to yourself!"
				)
			)
			(10 ; Taste
				(Print 371 16) ; "This doesn't look like your favorite flavor mannequin."
			)
			(11 ; Smell
				(Print 371 17) ; "Yep. Smells robotic."
			)
			(5 ; Talk
				(Print 371 18) ; "Don't bother. You don't need dummies making you look stupid, too!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance verbUseScript of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(switch register
					(0
						(cond
							((and (< gBuckazoidCount local2) local1 local0)
								(self
									save1:
										(proc0_12
											(Format
												@local4
												{"Are you in need of an auditory exam or what? I said it will be %3d buckazoids please."}
												local2
											)
											67
											1
											1
											28
											global132
											29
											global129
											30
											1
											70
											310
										)
								)
							)
							((and local1 local0)
								(self
									save1:
										(proc0_12
											{"Appreciate it, hon."}
											67
											1
											1
											28
											global132
											29
											global129
											30
											1
											70
											310
										)
								)
								(if (< (-= gBuckazoidCount local2) 1)
									(gEgo put: 0) ; buckazoid
								)
								(SetScore 49 5)
								(= local0 0)
							)
						)
					)
					(else
						(self restore:)
						(self dispose:)
					)
				)
				(= seconds 5)
			)
			(3
				(self restore:)
				(self dispose:)
			)
			(else
				(self restore:)
				(= cycles 1)
			)
		)
	)
)

(instance clerk of Actor
	(properties
		x 322
		y 72
		description {sales clerk}
		sightAngle 500
		lookStr {You check out the clerk. She's a burnished silver beauty if you ever saw one. You've always had a thing for women with antennae.}
		view 372
		loop 5
		priority 13
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (TestMallFlag (ScriptID 700 0) #rFlag3 1) ; mall
			(self posn: 275 116)
			(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(0 ; buckazoid
						(if
							(and
								(!= (rmnProp script:) verbUseScript)
								(!= (clerk script:) firstTimeScript)
							)
							(rmnProp setScript: verbUseScript 0 invItem)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(5 ; Talk
				(cond
					((IsFlag 90)
						(Print 371 19) ; "Having already purchased the lovely dress, you decide to stick with men's clothes from now on... even though it was quite enjoyable... almost too enjoyable."
					)
					(
						(and
							(not (clerk script:))
							(not (gCurRoom script:))
							(not (IsFlag 90))
						)
						(self setScript: shopScript)
					)
					((and ((self script:) script:) (User canInput:))
						(((clerk script:) script:) cue:)
					)
					(
						(and
							(not (IsFlag 90))
							(!= (rmnProp script:) verbUseScript)
							(!= (clerk script:) firstTimeScript)
							local1
							local0
							(OneOf (gEgo view:) 373 374)
						)
						(self setScript: talkScript)
					)
					(else 0)
				)
			)
			(3 ; Do
				(Print 371 20) ; "Although it seems darn tempting, you realize that duty calls and this will have to wait. Maybe after the game is over and all these players have gone to bed, you could cruise back by."
			)
			(10 ; Taste
				(Print 371 21) ; "Augh! It tastes like Tarnex(tm)! Well, at least you can rest assured knowing that your tongue is tarnish free."
			)
			(11 ; Smell
				(Print 371 22) ; "Uhmm! The rich smell of robotic lubricants wafts through your smell buds."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance clerkSFX of Sound
	(properties
		number 834
		loop -1
	)
)

(instance rmnProp of Prop
	(properties
		x -20
		y -20
	)
)

(instance wig of Prop
	(properties
		x 277
		y 44
		sightAngle 500
		lookStr {It's a deep pile wig.}
		view 372
		loop 10
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 23) ; "Nah. I'd rather not. You never know where it's been."
			)
			(11 ; Smell
				(Print 371 24) ; "Whew!! From what type of beast was this rendered?"
			)
			(10 ; Taste
				(Print 371 25) ; "You lick the wig and almost immediately cough up a fur ball."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRack of Feature
	(properties
		x 100
		y 139
		nsTop 115
		nsLeft 81
		nsBottom 163
		nsRight 120
		description {fashion rack}
		sightAngle 180
		lookStr {The latest in swank fashion displayed in a number of horrifying colors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 26) ; "While enjoying this banquet o' fashion you wonder what you might look like in one of these cute little frocks."
				(Print 371 27) ; "Hey! What kind of thing is that for a studly guy like you to be thinking? Get ahold of yourself, fella!"
			)
			(11 ; Smell
				(Print 371 28) ; "AAAhh! The smell of brand new simulated fabric!"
			)
			(10 ; Taste
				(Print 371 29) ; "That's not a very clean habit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRack1 of Feature
	(properties
		x 137
		y 125
		nsTop 107
		nsLeft 115
		nsBottom 154
		nsRight 159
		description {fashion rack}
		sightAngle 180
		lookStr {The latest in swank fashion displayed in a number of horrifying colors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 26) ; "While enjoying this banquet o' fashion you wonder what you might look like in one of these cute little frocks."
				(Print 371 30) ; "Hey! What kind of thing is that for a studly guy like you to be thinking! Get ahold of yourself, fella!"
			)
			(11 ; Smell
				(Print 371 28) ; "AAAhh! The smell of brand new simulated fabric!"
			)
			(10 ; Taste
				(Print 371 29) ; "That's not a very clean habit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRack2 of Feature
	(properties
		x 177
		y 116
		nsTop 98
		nsLeft 153
		nsBottom 134
		nsRight 196
		description {fashion stand}
		sightAngle 180
		lookStr {The latest in swank fashion displayed in a number of horrifying colors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 26) ; "While enjoying this banquet o' fashion you wonder what you might look like in one of these cute little frocks."
				(Print 371 30) ; "Hey! What kind of thing is that for a studly guy like you to be thinking! Get ahold of yourself, fella!"
			)
			(11 ; Smell
				(Print 371 28) ; "AAAhh! The smell of brand new simulated fabric!"
			)
			(10 ; Taste
				(Print 371 29) ; "That's not a very clean habit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Feature
	(properties
		nsBottom 200
		nsRight 320
		description {area}
		sightAngle 180
		lookStr {All the best-dressed bipedal female fashion slaves shop here at Sack's. The dazzling decor is just eye-numbing enough to make the price tags hard to read. "Wow", you think to yourself, "this place is fancier than Frederick's of Uranus!"}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(11 ; Smell
				(Print 371 31) ; "The air is thick with the smell of synthetics."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance model1 of Feature
	(properties
		x 99
		y 27
		nsTop 6
		nsLeft 89
		nsBottom 49
		nsRight 110
		description {mannequin}
		sightAngle 180
		lookStr {It's a nice outfit, but you're not sure you have the midriff for it.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 32) ; "Oooooh! Real plastic!"
			)
			(11 ; Smell
				(Print 371 33) ; "It doesn't smell great, but it at least smells better than you."
			)
			(10 ; Taste
				(Print 371 34) ; "You tongue the mannequin and find that it doesn't please your palate."
			)
			(5 ; Talk
				(Print 371 35) ; "Although just a mannequin, it's not intelligent enough to converse with even you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance model2 of Feature
	(properties
		x 208
		y 27
		nsTop 6
		nsLeft 197
		nsBottom 49
		nsRight 219
		description {mannequin}
		sightAngle 180
		lookStr {The skin color and cape make a statement - the kind taken in police stations!}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 36) ; "Wow! Genuine Zynthion leather."
			)
			(11 ; Smell
				(Print 371 37) ; "Whoaa, baby! Where have you been? Eau de Water Buffalo went out of style epochs ago."
			)
			(10 ; Taste
				(Print 371 38) ; "Yechh! Seriously gross!"
			)
			(5 ; Talk
				(Print 371 39) ; "Sorry. No brain."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rogerDance of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 112 113 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(Print 371 40) ; "Let's boogie, girls!"
				(roger init:)
				(gEgo y: 1000)
				(arm setCycle: Osc)
				(= cycles 1)
			)
			(3
				(= seconds 45)
			)
			(4
				(gEgo y: 113)
				(roger dispose:)
				(arm setCycle: 0)
				(= cycles 3)
			)
			(5
				(Print 371 41) ; "I sure know how to bust a move!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance roger of Mannequin
	(properties
		x 112
		y 113
		view 371
		loop 4
		signal 16384
		lastcel 7
	)
)

(instance wigs of Feature
	(properties
		x 265
		y 58
		nsTop 30
		nsLeft 250
		nsBottom 46
		nsRight 281
		description {wigs}
		sightAngle 180
		lookStr {These wigs are the latest fashion if you have a conehead or like the purple haze look.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 42) ; "Yep. It's synthetic hair."
			)
			(10 ; Taste
				(Print 371 43) ; "Dragging your tongue across the fine strands of of synthetic hair is almost as enjoyable as running it through a french fry slicer."
			)
			(11 ; Smell
				(Print 371 44) ; "No smell."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 312
		y 76
		nsTop 10
		nsLeft 306
		nsBottom 85
		nsRight 320
		description {wall}
		sightAngle 180
		lookStr {Nice walls!}
	)
)

(instance changeRoom of Feature
	(properties
		x 297
		y 49
		nsTop 18
		nsLeft 289
		nsBottom 81
		nsRight 305
		description {dressing room}
		sightAngle 180
		lookStr {It's the dressing room door.}
	)
)

(instance wigs2 of Feature
	(properties
		x 55
		y 55
		nsTop 25
		nsLeft 45
		nsBottom 38
		nsRight 66
		description {wigs}
		sightAngle 180
		lookStr {These are some darn attractive wigs. If you want a head like an ax, or you've wanted to capture that Ed Grimly look, they're just the thing.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print 371 45) ; "Yep. It's synthetic hair all right."
			)
			(10 ; Taste
				(Print 371 43) ; "Dragging your tongue across the fine strands of of synthetic hair is almost as enjoyable as running it through a french fry slicer."
			)
			(11 ; Smell
				(Print 371 44) ; "No smell."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

