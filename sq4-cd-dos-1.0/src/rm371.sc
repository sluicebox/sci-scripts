;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 371)
(include sci.sh)
(use Main)
(use mall)
(use eRS)
(use Sq4Narrator)
(use Sq4Feature)
(use Osc)
(use PolyPath)
(use Polygon)
(use ForwardCounter)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Motion)
(use System)

(public
	rm371 0
)

(local
	local0 = 1
	local1
	local2 = 60
	[local3 52]
)

(procedure (localproc_0 &tmp temp0) ; UNUSED
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

(procedure (localproc_1) ; UNUSED
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

(class Mannequin2 of Sq4Prop
	(properties
		direct 0
		lastcel 0
		dummyTime 0
		detail 0
	)
)

(instance rm371 of SQRoom
	(properties
		picture 371
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 0 4 402 371 372 373 374 920)
		(LoadMany rsFONT 68 69)
		(gLongSong number: 0 stop:)
		(gLongSong2 setVol: 127)
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
		(if (>= (gGame detailLevel:) (dummy1 detail:))
			(dummy1 setCycle: Osc)
		else
			(dummy1 stopUpd:)
		)
		(dummy2 init:)
		(if (>= (gGame detailLevel:) (dummy2 detail:))
			(dummy2 setCycle: Osc)
		else
			(dummy2 stopUpd:)
		)
		(dummy3 init:)
		(if (>= (gGame detailLevel:) (dummy3 detail:))
			(dummy3 setCycle: Osc)
		else
			(dummy3 stopUpd:)
		)
		(dummy4 init:)
		(if (>= (gGame detailLevel:) (dummy4 detail:))
			(dummy4 setCycle: Osc)
		else
			(dummy4 stopUpd:)
		)
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
		(if
			(and
				(OneOf (gEgo view:) 0 4)
				(IsFlag 29)
				(TestMallFlag (ScriptID 700 0) #rFlag3 16) ; mall
			)
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
					(TestMallFlag (ScriptID 700 0) #rFlag3 4) ; mall
					(!= (clerk script:) firstTimeScript)
					(>= (gEgo x:) 310)
				)
				(gCurRoom setScript: changeScript)
			)
			((== (gEgo edgeHit:) EDGE_BOTTOM)
				(gCurRoom setScript: exitScript)
			)
			((== (gEgo edgeHit:) EDGE_RIGHT)
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
					(if (TestMallFlag (ScriptID 700 0) #rFlag3 4) ; mall
						(gNarrator say: 1) ; "As you change your clothes, you think to yourself that, even in drag, you still have incredible animal magnetism... or is that just a lack of deodorant?"
						(if (TestMallFlag (ScriptID 700 0) #rFlag3 8) ; mall
							(NormalEgo 2 402 14)
							(AnimateEgoHead 14)
						else
							(NormalEgo 2 0 4)
							(AnimateEgoHead 4)
						)
						(= cycles 10)
					else
						(gNarrator say: 2) ; "Quickly changing your clothes, you emerge in your space guy wardrobe."
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
					(gNarrator say: 3) ; "You're becoming a whiz at putting on women's clothing. In a flash you emerge looking tres chic. Could you be enjoying this just a little too much?"
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
				(HandsOff)
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

(instance introScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(TestMallFlag (ScriptID 700 0) #rFlag3 32) ; mall
						(TestMallFlag (ScriptID 700 0) #rFlag3 64) ; mall
					)
					(gNarrator say: 4) ; "She said she was busy."
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
					(tClerk say: 20 self) ; "Listen hon, I got work to do here. You run along now. Maybe you could bring back your girl sometime. Bye now."
					(= state 7)
					(mall rFlag3: (| (mall rFlag3:) $0040))
				else
					(= cycles 1)
				)
			)
			(3
				(tClerk say: 12 self) ; "Are you sure you got the right store, hon?"
			)
			(5
				(tRog say: 7 self) ; "I'm not sure, I think I'll just look around for a bit."
			)
			(7
				(tClerk say: 19 self) ; "Let us know if we can help."
				(mall rFlag3: (| (mall rFlag3:) $0020))
			)
			(9
				(HandsOn)
				(self dispose:)
			)
			(else
				(= cycles 1)
			)
		)
	)
)

(instance exitScript of Script
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
				(tClerk say: 13 self) ; "Thanks for shopping at Sacks!"
			)
			(4
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

(instance firstTimeScript of Script
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
				(tClerk say: 7 self) ; "I'm sure this will suit that 'special someone's needs'. It's all the rage."
			)
			(7
				(clerk setLoop: 9 setCycle: 0 setMotion: PolyPath 281 75 self)
				(clerkSFX play:)
			)
			(8
				(clerkSFX stop:)
				(tClerk say: 8 self) ; "I suppose you'll want to try it on now. Here, use this dressing room."
			)
			(10
				(clerk setMotion: PolyPath 317 75 self)
				(gEgo setMotion: PolyPath 317 75 self)
				(clerkSFX play:)
			)
			(11
				(clerkSFX stop:)
			)
			(13
				(clerk setLoop: 1 ignoreActors: setMotion: PolyPath 273 74 self)
				(clerkSFX play:)
			)
			(14
				(clerkSFX stop:)
				(clerk setLoop: 0 setCel: 2)
				(tClerk say: 9 self) ; "And honey, if your 'special someone' needs a wig, this one should look pretty good on you."
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
				(tClerk say: 10 self) ; "Very lovely, honey, it's made for you. Would you like us to wrap it up, or would that 'special someone' prefer you to wear it home?"
			)
			(23
				(tRogette say: 5 self) ; "I think I'll wear it home."
			)
			(25
				(arm setCycle: ForwardCounter (Random 1 3))
				(tClerk say: 11 self) ; "Just what we thought. That will be 60 buckazoids, sicko."
				(gTheIconBar enable: 6 7)
				(= local1 1)
			)
			(26
				(= cycles 1)
			)
			(27
				(HandsOn)
				(gEgo ignoreActors: 0)
				(clerk setScript: bogusScript)
			)
			(else
				(= cycles 1)
			)
		)
	)
)

(instance firstTalk of Script
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
				(tClerk say: 1 self) ; "Hiya, hon. I'm Maebot, fashion consultant to the cosmos. What can we do with ya today?"
			)
			(2
				(HandsOff)
				(tRog say: 1 self) ; "Well, uh, this is kinda hard to explain..."
			)
			(4
				(arm setCycle: ForwardCounter (Random 1 3))
				(tClerk say: 2 self) ; "Oh, let me guess. You want something for someone very special, somebody who'd die to get the latest in high-galactic fashion."
			)
			(6
				(tClerk say: 3 self) ; "Are we right or are we right?"
			)
			(8
				(tRog say: 2 self) ; "Uh...we're right."
			)
			(10
				(arm setCycle: ForwardCounter (Random 1 3))
				(tClerk say: 4 self) ; "Okay, what size does she take?"
			)
			(12
				(tRog say: 3 self) ; "38."
			)
			(14
				(arm setCycle: ForwardCounter (Random 1 3))
				(tClerk say: 5 self) ; "Ooh, I don't think we're right about that."
			)
			(16
				(tRog say: 4 self) ; "Um, I'm...uh...I'm not sure, but she's, um, built about like me."
			)
			(18
				(arm setCycle: ForwardCounter (Random 1 3))
				(tClerk say: 6 self) ; "Is she? A likely story. Good thing for you I can keep a secret, sweetie."
			)
			(20
				(arm dispose:)
				(clerk setLoop: -1)
				(self dispose:)
			)
			(else
				(= cycles 1)
			)
		)
	)
)

(instance secondTalk of Script
	(properties)

	(method (init)
		(super init: &rest)
		(arm init: x: (+ (clerk x:) 2) y: (- (clerk y:) 28))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (TestMallFlag (ScriptID 700 0) #rFlag3 2) ; mall
					(= state 1)
					(tClerk say: 17 self) ; "Oh, it's you again, would you stop wasting my time?"
				else
					(tClerk say: 15 self) ; "Oh, it's you again. What do you want?"
				)
				(arm setCycle: ForwardCounter (Random 1 3))
			)
			(3
				(tRog say: 6 self) ; "I would still like to buy that dress, I'm terribly sorry about the misunderstanding."
			)
			(5
				(arm setCycle: ForwardCounter (Random 1 3))
				(tClerk say: 16 self) ; "Well, okay, but don't try that again. If you have to be weird, fine, but we don't appreciate shoplifters, dear."
			)
			(7
				(arm dispose:)
				(self dispose:)
			)
			(else
				(= cycles 1)
			)
		)
	)
)

(instance talkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(tClerk say: (+ (Random 0 7) 21) self)
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

(instance clerkHead of Sq4Prop ; UNUSED
	(properties
		x 50
		y 50
		z -1000
		view 372
		loop 6
	)
)

(instance arm of Sq4Prop
	(properties
		x 50
		y 50
		view 372
		loop 8
		priority 14
		signal 16400
	)
)

(instance dummy1 of Mannequin2
	(properties
		x 88
		y 69
		sightAngle 180
		view 371
		cel 10
		priority 6
		signal 16400
		lastcel 6
		detail 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 5) ; "Would stripes look good on me", you wonder. "Those boots are attractive."
			)
			(4 ; Do
				(gNarrator say: 6) ; "Hmmm.. they can't be real. No living thing can resist your charm."
			)
			(7 ; Taste
				(gNarrator say: 7) ; "Nah. You've never had a taste for stripes."
			)
			(6 ; Smell
				(gNarrator say: 8) ; "Aromatic metals, lubricants, and synthetic materials emanate from its general vicinity."
			)
			(2 ; Talk
				(gNarrator say: 9) ; "You ask her to dance but get no response. Shot down again."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dummy2 of Mannequin2
	(properties
		x 221
		y 73
		sightAngle 180
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
			(1 ; Look
				(gNarrator say: 10) ; "Hey! Not bad for a robotic mannequin."
			)
			(4 ; Do
				(gNarrator say: 6) ; "Hmmm.. they can't be real. No living thing can resist your charm."
			)
			(7 ; Taste
				(gNarrator say: 11) ; "Despite your love for Synthoskin, you decide that wouldn't be gentlemanly."
			)
			(6 ; Smell
				(gNarrator say: 12) ; "Closet mannequin whiffer, eh?"
			)
			(2 ; Talk
				(gNarrator say: 18) ; "Although just an animated mannequin, it's not intelligent enough to converse with even you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dummy3 of Mannequin2
	(properties
		x 159
		y 70
		sightAngle 180
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
			(1 ; Look
				(gNarrator say: 14) ; "You like the shoes, but the stripes might make you look overweight."
			)
			(4 ; Do
				(gNarrator say: 15) ; "It can't be real. You know you're an irresistable babe magnet."
			)
			(7 ; Taste
				(gNarrator say: 16) ; "OUCH! You almost got a sliver in your tongue!"
			)
			(6 ; Smell
				(gNarrator say: 17) ; "Technosmell emanates from it."
			)
			(2 ; Talk
				(gNarrator say: 18) ; "Although just an animated mannequin, it's not intelligent enough to converse with even you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dummy4 of Mannequin2
	(properties
		x 31
		y 62
		sightAngle 180
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
			(1 ; Look
				(gNarrator say: 19) ; "Fringe! Would that be too daring?"
			)
			(4 ; Do
				(if
					(and
						(not (clerk script:))
						(not (gCurRoom script:))
						(OneOf (gEgo view:) 373 374)
					)
					(gCurRoom setScript: rogerDance)
				else
					(gNarrator say: 20) ; "Keep your hands to yourself!"
				)
			)
			(7 ; Taste
				(gNarrator say: 21) ; "This doesn't look like your favorite flavor mannequin."
			)
			(6 ; Smell
				(gNarrator say: 22) ; "Yep. Smells robotic."
			)
			(2 ; Talk
				(gNarrator say: 23) ; "Don't bother. You don't need dummies making you look stupid, too!"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance verbUseScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(switch register
					(8
						(cond
							((and (< gBuckazoidCount local2) local1 local0)
								(tClerk say: 18) ; "Are you in need of an auditory exam or what? Pay up, pal!"
							)
							((and local1 local0)
								(tClerk say: 14) ; "Appreciate it, hon."
								(if (< (-= gBuckazoidCount local2) 1)
									(gEgo put: 0) ; buckazoid
								)
								(SetScore 49 5)
								(mall rFlag3: (| (mall rFlag3:) $0004))
								(= local0 0)
							)
						)
					)
					(else
						(self dispose:)
					)
				)
				(= seconds 5)
			)
			(3
				(self dispose:)
			)
			(else
				(= cycles 1)
			)
		)
	)
)

(instance clerk of Sq4Actor
	(properties
		x 322
		y 72
		sightAngle 500
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

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; buckazoid
				(if
					(and
						(!= (rmnProp script:) verbUseScript)
						(!= (clerk script:) firstTimeScript)
					)
					(rmnProp setScript: verbUseScript 0 theVerb)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(1 ; Look
				(gNarrator say: 24) ; "You check out the clerk. Hmmmm...You've always had a thing for women with antennae."
			)
			(2 ; Talk
				(cond
					((TestMallFlag (ScriptID 700 0) #rFlag3 4) ; mall
						(gNarrator say: 25) ; "Having already purchased the dress, you decide to stick with men's clothes from now on...even though it was almost TOO too enjoyable."
					)
					(
						(and
							(not (clerk script:))
							(not (gCurRoom script:))
							(not (TestMallFlag (ScriptID 700 0) #rFlag3 4)) ; mall
						)
						(self setScript: shopScript)
					)
					((and ((self script:) script:) (gUser canInput:))
						(((clerk script:) script:) cue:)
					)
					(
						(and
							(not (TestMallFlag (ScriptID 700 0) #rFlag3 4)) ; mall
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
			(4 ; Do
				(gNarrator say: 26) ; "It is darn tempting, but you realize that duty calls and this will have to wait. Maybe you could cruise back by when the game is over."
			)
			(7 ; Taste
				(gNarrator say: 27) ; "It tastes like Tarnex! Well, at least your tongue is tarnish free."
			)
			(6 ; Smell
				(gNarrator say: 28) ; "Uhmm! The rich smell of robotic lubricants wafts through your smell buds."
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

(instance rmnProp of Sq4Prop
	(properties
		x -20
		y -20
		view 920
	)
)

(instance wig of Sq4Prop
	(properties
		x 277
		y 44
		sightAngle 500
		view 372
		loop 10
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 29) ; "It's a deep pile wig."
			)
			(4 ; Do
				(gNarrator say: 30) ; "Nah. You'd rather not. You never know where it's been."
			)
			(6 ; Smell
				(gNarrator say: 31) ; "Whew!! From what type of beast was this rendered?"
			)
			(7 ; Taste
				(gNarrator say: 32) ; "You lick the wig and almost immediately cough up a fur ball."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRack of Sq4Feature
	(properties
		x 100
		y 139
		nsTop 115
		nsLeft 81
		nsBottom 163
		nsRight 120
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 33) ; "The latest in swank fashion displayed in a number of horrifying colors."
			)
			(4 ; Do
				(gCurRoom setScript: sRackDo)
			)
			(6 ; Smell
				(gNarrator say: 36) ; "AAAhh! The smell of brand new simulated fabric!"
			)
			(7 ; Taste
				(gNarrator say: 37) ; "That's not a very clean habit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theRack1 of Sq4Feature
	(properties
		x 137
		y 125
		nsTop 107
		nsLeft 115
		nsBottom 154
		nsRight 159
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 33) ; "The latest in swank fashion displayed in a number of horrifying colors."
			)
			(4 ; Do
				(gCurRoom setScript: sRackDo)
			)
			(6 ; Smell
				(gNarrator say: 36) ; "AAAhh! The smell of brand new simulated fabric!"
			)
			(7 ; Taste
				(gNarrator say: 37) ; "That's not a very clean habit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sRackDo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gNarrator say: 34 self) ; "While enjoying this banquet o' fashion you wonder what you might look like in one of these cute little frocks."
			)
			(1
				(gNarrator say: 35 self) ; "Hey! What kind of thing is that for a studly guy like you to be thinking? Get ahold of yourself, fella!"
			)
			(2
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance theRack2 of Sq4Feature
	(properties
		x 177
		y 116
		nsTop 98
		nsLeft 153
		nsBottom 134
		nsRight 196
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 33) ; "The latest in swank fashion displayed in a number of horrifying colors."
			)
			(4 ; Do
				(gCurRoom setScript: sRackDo)
			)
			(6 ; Smell
				(gNarrator say: 36) ; "AAAhh! The smell of brand new simulated fabric!"
			)
			(7 ; Taste
				(gNarrator say: 37) ; "That's not a very clean habit."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance theArea of Sq4Feature
	(properties
		nsBottom 200
		nsRight 320
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 38) ; "All the best-dressed bipedal female fashion slaves shop here at Sock's. The dazzling decor is just eye-numbing enough to make the price tags hard to read. "Wow", you think to yourself, "this place is fancier than Frederick's of Uranus!""
			)
			(6 ; Smell
				(gNarrator say: 39) ; "The air is thick with the smell of synthetics."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance model1 of Sq4Feature
	(properties
		x 99
		y 27
		nsTop 6
		nsLeft 89
		nsBottom 49
		nsRight 110
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 40) ; "It's a nice outfit, but you're not sure you have the midriff for it."
			)
			(4 ; Do
				(if (OneOf (gEgo view:) 373 374)
					(tRogette say: 10) ; "Oooooh! Real plastic!"
				else
					(tRog say: 10) ; "Oooooh! Real plastic!"
				)
			)
			(6 ; Smell
				(gNarrator say: 41) ; "It doesn't smell great, but it smells better than you."
			)
			(7 ; Taste
				(gNarrator say: 42) ; "You lick the mannequin and find that it doesn't please your palate."
			)
			(2 ; Talk
				(gNarrator say: 43) ; "Although just a mannequin, it's not intelligent enough to converse with even you."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance model2 of Sq4Feature
	(properties
		x 208
		y 27
		nsTop 6
		nsLeft 197
		nsBottom 49
		nsRight 219
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 44) ; "The skin color and cape make a statement - the kind taken in police stations!"
			)
			(4 ; Do
				(gNarrator say: 45) ; "Wow! Genuine Zynthion leather."
			)
			(6 ; Smell
				(gNarrator say: 46) ; "Whoaa, baby! Where have you been? Eau de Water Buffalo went out of style epochs ago."
			)
			(7 ; Taste
				(if (OneOf (gEgo view:) 373 374)
					(tRogette say: 11) ; "Yechh! Seriously gross!"
				else
					(tRog say: 11) ; "Yechh! Seriously gross!"
				)
			)
			(2 ; Talk
				(gNarrator say: 47) ; "Sorry. No brain."
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
				(if (or (== (gEgo view:) 373) (== (gEgo view:) 374))
					(tRogette say: 12) ; "Let's boogie, girls!"
				else
					(tRog say: 12) ; "Let's boogie, girls!"
				)
				(roger init: setCycle: Osc)
				(gEgo y: 1000)
				(arm setCycle: Osc)
				(= cycles 1)
			)
			(3
				(= seconds 15)
			)
			(4
				(gEgo y: 113)
				(roger dispose:)
				(arm setCycle: 0)
				(= cycles 3)
			)
			(5
				(if (or (== (gEgo view:) 373) (== (gEgo view:) 374))
					(tRogette say: 13) ; "I sure know how to bust a move!"
				else
					(tRog say: 13) ; "I sure know how to bust a move!"
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance roger of Mannequin2
	(properties
		x 112
		y 113
		view 371
		loop 4
		signal 16384
		lastcel 7
	)
)

(instance wigs of Sq4Feature
	(properties
		x 265
		y 58
		nsTop 30
		nsLeft 250
		nsBottom 46
		nsRight 281
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 48) ; "These wigs are the latest fashion if you have a conehead or like the purple haze look."
			)
			(4 ; Do
				(gNarrator say: 49) ; "Yep. It's synthetic hair."
			)
			(7 ; Taste
				(gNarrator say: 50) ; "Dragging your tongue across the synthetic hair is almost as enjoyable as running it through a french fry slicer."
			)
			(6 ; Smell
				(gNarrator say: 51) ; "No smell."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wall of Sq4Feature
	(properties
		x 312
		y 76
		nsTop 10
		nsLeft 306
		nsBottom 85
		nsRight 320
		sightAngle 180
	)
)

(instance changeRoom of Sq4Feature
	(properties
		x 297
		y 49
		nsTop 18
		nsLeft 289
		nsBottom 81
		nsRight 305
		sightAngle 180
		lookStr 52 ; "It's the dressing room door."
	)
)

(instance wigs2 of Sq4Feature
	(properties
		x 55
		y 55
		nsTop 25
		nsLeft 45
		nsBottom 38
		nsRight 66
		sightAngle 180
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gNarrator say: 53) ; "These are some darn attractive wigs. Just the thing if you want a head like an ax, or you want to capture that Ed Grimly look."
			)
			(4 ; Do
				(gNarrator say: 54) ; "Yep. It's synthetic hair all right."
			)
			(7 ; Taste
				(gNarrator say: 55) ; "Dragging your tongue across the fine strands of of synthetic hair is almost as enjoyable as running it through a french fry slicer."
			)
			(6 ; Smell
				(gNarrator say: 51) ; "No smell."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tRog of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 371
		view 1008
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 27
		eyeOffsetY 21
	)
)

(instance tRogette of Sq4Talker
	(properties
		z 400
		noun 7
		modNum 371
		view 1009
		talkerNum 7
		mouthOffsetX 21
		mouthOffsetY 32
		eyeOffsetX 26
		eyeOffsetY 21
	)
)

(instance tClerk of Sq4Talker
	(properties
		z 400
		noun 9
		modNum 371
		view 1709
		talkerNum 9
		mouthOffsetX 18
		mouthOffsetY 63
		eyeOffsetX 28
		eyeOffsetY 25
		tStyle 1
	)
)

