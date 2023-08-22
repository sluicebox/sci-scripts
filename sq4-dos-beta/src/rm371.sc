;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use Interface)
(use mall)
(use rmnScript)
(use SQRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
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
	[local54 8] = [108 60 118 104 214 125 275 116]
)

(procedure (localproc_0 &tmp temp0)
	(return
		(cond
			((< (= temp0 (Random 0 10)) 4) 0)
			((< temp0 8) 1)
			(else temp0)
		)
	)
)

(procedure (localproc_1)
	(return
		(switch (Random 0 3)
			(0 {"**Trying to weasel out of paying huh?"})
			(1 {"**Why not just cut the chit chat and hand over the cash."})
			(2 {"**It realy is nice weather, but then this is an artificial computer controlled climate... now how about some cash?"})
			(3 {"**I think your cute too, but looks won't pay for those designer duds."})
		)
	)
)

(class Mannequin of View
	(properties
		direct 0
		lastcel 0
		dummyTime 0
	)

	(method (dance)
		(if dummyTime
			(-- dummyTime)
		else
			(= dummyTime (Random 0 3))
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
		(switch direct
			(0
				(self setCel: (- cel 1))
			)
			(1
				(self setCel: (+ cel 1))
			)
			(else 0)
		)
	)
)

(instance rm371 of SQRoom
	(properties
		picture 371
		style 30
		south 370
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
					init: 0 0 319 0 319 67 273 68 230 60 58 60 42 74 25 75 4 90 68 126 64 152 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 155 189 153 176 274 120 304 91 294 72 319 72
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 87 70 125 82 157 78 188 84 227 77 268 79 288 93 229 116 189 102 154 113 123 101 87 115 20 89
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 61 158 182 113 197 112 208 116 203 140 100 183 67 184 55 172
					yourself:
				)
		)
		(gEgo posn: 130 185 setHeading: 0 ignoreActors: 1 init:)
		(dummy1 init:)
		(dummy2 init:)
		(dummy3 init:)
		(dummy4 init:)
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
			add: theRack theRack1 theRack2 theArea
			eachElementDo: #init
			doit:
		)
		(self setRegions: 700) ; mall
	)

	(method (doit &tmp temp0)
		(if (gLongSong2 prevSignal:)
			(gLongSong2 prevSignal: 0)
			(dummy1 dance:)
			(dummy2 dance:)
			(dummy3 dance:)
			(dummy4 dance:)
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
					(= temp0
						(switch ((User alterEgo:) edgeHit:)
							(EDGE_BOTTOM south)
						)
					)
					local1
					local0
				)
				(gCurRoom setScript: exitScript)
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
		(if (== local0 0)
			(mall rFlag3: (| (mall rFlag3:) $0004))
		)
		(super dispose:)
	)
)

(instance changeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 332 72 self)
			)
			(1
				(if (== (gEgo view:) 373)
					(if (TestMallFlag (ScriptID 700 0) #rFlag3 4) ; mall
						(Print 371 0) ; "HOOK**Quickly changing your clothes you think to yourself even dressed in drag you still have that animal attraction... or was that due to your slight odor??"
						(if (TestMallFlag (ScriptID 700 0) #rFlag3 8) ; mall
							(NormalEgo 2 402 14)
							(AnimateEgoHead 14)
						else
							(NormalEgo 2 0 4)
							(AnimateEgoHead 4)
						)
						(= cycles 10)
					else
						(Print 371 1) ; "HOOK**Quickly changing your clothes you emerge dressed to your former fashionable standards."
						(NormalEgo 2 0 4)
						(AnimateEgoHead 4)
						(= cycles 10)
					)
					(mall rFlag3: (| (mall rFlag3:) $0010))
				else
					(Print 371 2) ; "HOOK**Your becoming a whiz at putting on womens clothing, in a split second you emerge looking swank as ever."
					(gEgo view: 373 setCycle: StopWalk 374)
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

(instance enterShopScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 195 175 self)
			)
			(1
				(Face gEgo clerk)
				(clerk setScript: firstTimeScript)
				(self dispose:)
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
				(if (!= (gEgo view:) 373)
					(self changeState: 5)
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
							{"**You naughty boy!! Sstealing is a bad habit."}
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
				(= seconds 30)
			)
			(4
				(self restore:)
				(= cycles 1)
			)
			(5
				(HandsOn)
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
				(clerk setMotion: MoveTo 344 185 self)
				(arm dispose:)
			)
			(2
				(clerk x: 322 y: 72 setPri: -1 setMotion: PolyPath 95 148 self)
			)
			(4
				(clerk setLoop: 9 setCycle: 0 setMotion: PolyPath 281 72 self)
			)
			(5
				(self
					save1:
						(proc0_12
							{"**Ssince you are the ssame ssize why don't you try these on, the changing room is here to the right."}
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
			(7
				(clerk setMotion: MoveTo 332 72)
				(gEgo setMotion: PolyPath 322 72 self)
			)
			(8
				(clerk setLoop: 1 ignoreActors: setMotion: MoveTo 273 73 self)
			)
			(9
				(clerk setLoop: 0 setCel: 2)
				(self
					save1:
						(proc0_12
							{"**Ssay, why don't you try thiss on too, it's one of my personal favorites."}
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
				(= seconds 30)
			)
			(11
				(wig dispose:)
				(clerk setMotion: MoveTo 322 72)
				(= cycles 30)
			)
			(12
				(clerk
					setLoop: 3
					setCycle: Walk
					x: 344
					y: 185
					setPri: 14
					setMotion: MoveTo 268 157 self
				)
			)
			(13
				(clerk setLoop: 5)
				(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
				(= cycles 1)
			)
			(14
				(gEgo
					view: 373
					setCycle: StopWalk 374
					setMotion: PolyPath 185 160 self
				)
				(AnimateEgoHead 374)
			)
			(15
				(Face gEgo clerk)
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"**Oooh you look delicious, you'll... I mean she'll be so pleased!"}
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
			(17
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							(Format
								@local4
								{"**That will be %3d buckazoids please."}
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
							320
						)
				)
				(= local1 1)
				(= seconds 10)
			)
			(18
				(self restore:)
				(= cycles 1)
			)
			(19
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
							{"**Greetingss, I'm sssir Gaybot, what can I do with... err for you?"}
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
			(2
				(HandsOff)
				(self
					save1:
						(proc0_12
							{"***I.. uh.. well..."}
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
							320
						)
				)
				(= seconds 10)
			)
			(4
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"**Looking for the latest in high galactic polyfiber fashion."}
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
			(6
				(self
					save1:
						(proc0_12
							{"**Yeah I... uh.. guess so."}
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
							320
						)
				)
				(= seconds 10)
			)
			(8
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"**Shopping for that ssspecial sssomeone or is thiss for yoursself?"}
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
			(10
				(self
					save1:
						(proc0_12
							{"**Actually it's for... someone else.. yeah thats it, someone else."}
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
							320
						)
				)
				(= seconds 10)
			)
			(12
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"**Mmmm I ssee, ssay no more I understand perfectly.. this sspecial ssomeone has the same measurements, I presume?"}
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
			(14
				(self
					save1:
						(proc0_12
							{"**Uh yeah thats right, how did you know?"}
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
							320
						)
				)
				(= seconds 10)
			)
			(16
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"**Don't worry luv, I have a reputation for keeping a ssecret. Now I have just the thing, it's all the rage."}
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
			(18
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
								{"**Oh it's you, stop wasting my time until you have the money."}
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
				else
					(self
						save1:
							(proc0_12
								{"**Oh, it's you again. What do you want?"}
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
				)
				(arm setCycle: ForwardCounter (Random 1 3))
				(= seconds 30)
			)
			(2
				(User canInput: 1)
			)
			(3
				(HandsOff)
				(if (and (TestMallFlag (ScriptID 700 0) #rFlag3 2) (< gBuckazoidCount 25)) ; mall
					(clerk setScript: wanderAbout)
					(arm dispose:)
				else
					(self
						save1:
							(proc0_12
								{"**Well I'd like to buy that dress, I'm sorry about the misunderstanding."}
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
								320
							)
					)
				)
				(= seconds 30)
			)
			(5
				(arm setCycle: ForwardCounter (Random 1 3))
				(self
					save1:
						(proc0_12
							{"**Oh all right, but don't let me down again I was so disappointed in you."}
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

(instance wanderAbout of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(arm dispose:)
				(HandsOn)
				(= temp0 (Random 0 3))
				(clerk
					ignoreActors: 0
					setMotion:
						PolyPath
						[local54 (*= temp0 2)]
						[local54 (+ temp0 1)]
						self
				)
				(= seconds 10)
			)
			(1
				(= state -1)
				(clerk setHeading: (Random 0 360))
				(= cycles (Random 10 25))
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
		priority 15
		signal 16400
	)
)

(instance dummy1 of Mannequin
	(properties
		x 88
		y 69
		description {mannequin}
		lookStr {***1 Hey! Beats an inflatable pleasure droid.}
		view 371
		cel 10
		priority 6
		signal 16400
		lastcel 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 3) ; "** Hmmm.. they can't be real no living thing can resist my charm."
			)
			(3 ; Taste
				(Print 371 4) ; "** Thinking twice you decide It's not worth losing a tongue over."
			)
			(2 ; Smell
				(Print 371 5) ; "** She won't hold still long enough to be sniffed."
			)
			(5 ; Talk
				(Print 371 6) ; "** Hopefully, you ask her to dance but get no response."
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
		lookStr {***2 Hey! Beats an inflatable pleasure droid.}
		view 371
		loop 1
		cel 3
		priority 6
		signal 16400
		lastcel 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 3) ; "** Hmmm.. they can't be real no living thing can resist my charm."
			)
			(3 ; Taste
				(Print 371 4) ; "** Thinking twice you decide It's not worth losing a tongue over."
			)
			(2 ; Smell
				(Print 371 5) ; "** She won't hold still long enough to be sniffed."
			)
			(5 ; Talk
				(Print 371 7) ; "** She must be to busy dancing to talk right now."
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
		lookStr {***3 Hey! Beats an inflatable pleasure droid.}
		view 371
		loop 2
		cel 4
		priority 6
		signal 16400
		lastcel 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 3) ; "** Hmmm.. they can't be real no living thing can resist my charm."
			)
			(3 ; Taste
				(Print 371 8) ; "** OUCH! I got a sliver in my tongue!"
			)
			(2 ; Smell
				(Print 371 5) ; "** She won't hold still long enough to be sniffed."
			)
			(5 ; Talk
				(Print 371 7) ; "** She must be to busy dancing to talk right now."
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
		lookStr {***4 Hey! Beats an inflatable pleasure droid.}
		view 371
		loop 3
		cel 6
		priority 3
		signal 16400
		lastcel 11
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 9) ; "** The mannequin ignores your best attempts to make a pass."
			)
			(3 ; Taste
				(Print 371 10) ; "** Slurp..."
				(Print 371 11) ; "** SLAP!!..."
				(Print 371 12) ; "** OUCH!!!"
			)
			(2 ; Smell
				(Print 371 5) ; "** She won't hold still long enough to be sniffed."
			)
			(5 ; Talk
				(Print 371 7) ; "** She must be to busy dancing to talk right now."
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
												{"**Ssay you should have your hearing checked, I said it will be %3d buckazoids please."}
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
											320
										)
								)
							)
							((and local1 local0)
								(self
									save1:
										(proc0_12
											{"**Thanks killer, come back soon!"}
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
								(-= gBuckazoidCount local2)
								(= local0 0)
							)
						)
					)
					(else
						(self dispose:)
					)
				)
				(= seconds 30)
			)
			(3
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
		description {** the sales clerk}
		sightAngle 500
		lookStr {** you just looked at the sales clerk for this store.}
		view 372
		loop 5
		priority 14
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
			(6 ; Inventory
				(if (not (rmnProp script:))
					(rmnProp setScript: verbUseScript 0 invItem)
				)
			)
			(5 ; Talk
				(cond
					(
						(and
							(not (clerk script:))
							(not (gCurRoom script:))
							(not (TestMallFlag (ScriptID 700 0) #rFlag3 4)) ; mall
						)
						(gCurRoom setScript: enterShopScript)
					)
					((and ((self script:) script:) (User canInput:))
						(((clerk script:) script:) cue:)
					)
					(
						(and
							(not (TestMallFlag (ScriptID 700 0) #rFlag3 4)) ; mall
							(OneOf (gEgo view:) 373 374)
						)
						(self setScript: talkScript)
					)
					((TestMallFlag (ScriptID 700 0) #rFlag3 4) ; mall
						(Print 371 13) ; "HOOK**Having already purchased the lovely dress, you decide to stick with men's clothes from now on... even though it was quite enjoyable... almost to enjoyable."
					)
					(else
						(Print 371 14) ; "The clerk seems to be ignoring you."
					)
				)
			)
			(4 ; Do
				(Print 371 15) ; "** Grabbing the robot, you gain the satisfaction of doing something realy stupid."
			)
			(1 ; Look
				(Print 371 16) ; "** You just looked at the sales clerk for this store."
			)
			(3 ; Taste
				(Print 371 17) ; "** Not a good idea but thanks for trying."
			)
			(2 ; Smell
				(Print 371 18) ; "** Sniff! Sniff!"
			)
		)
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
		lookStr {** It's a deep pile wig.}
		view 372
		loop 10
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 19) ; "** Nah I'd rather not you never know were it's been."
			)
			(2 ; Smell
				(Print 371 20) ; "** Whew!! What kind of animal was this made from?"
			)
			(3 ; Taste
				(Print 371 21) ; "**After licking the wig you realize that you are truly a disgusting person."
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
		description {***fashion rack}
		sightAngle 90
		lookStr {**The latest in swank fashion displayed in a number of horrifying colors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 22) ; "** Hey none of that five fingered discount stuff!"
			)
			(2 ; Smell
				(Print 371 23) ; "** AAAhh! The smell of brand new simulated fabric!"
			)
			(3 ; Taste
				(Print 371 24) ; "** That's not a very clean habit."
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
		sightAngle 90
		lookStr {**The latest in swank fashion displayed in a number of horrifying colors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 22) ; "** Hey none of that five fingered discount stuff!"
			)
			(2 ; Smell
				(Print 371 23) ; "** AAAhh! The smell of brand new simulated fabric!"
			)
			(3 ; Taste
				(Print 371 24) ; "** That's not a very clean habit."
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
		sightAngle 90
		lookStr {**The latest in swank fashion displayed in a number of horrifying colors.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(Print 371 22) ; "** Hey none of that five fingered discount stuff!"
			)
			(2 ; Smell
				(Print 371 23) ; "** AAAhh! The smell of brand new simulated fabric!"
			)
			(3 ; Taste
				(Print 371 24) ; "** That's not a very clean habit."
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
		lookStr {All the best-dressed bipedal female fashion slaves shop here at sack's. The dazzling decor is just eye-numbing enough to make the price tags hard to read, and the mannequins are grotesque enough to make any living creature look swank in comparison."Wow", you think to yourself, "this place is fancier than Frederick's of Uranus!"}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4) ; Do
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

