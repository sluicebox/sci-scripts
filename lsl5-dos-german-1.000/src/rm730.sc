;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use n940)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm730 0
)

(local
	seenMsg
	justWatching
	mainEvent
	payoff
	paid
	contestantState
)

(procedure (InitFeatures)
	(runway init:)
	(stage init:)
)

(procedure (DisposeFeatures)
	(runway dispose:)
	(stage dispose:)
)

(instance rm730 of LLRoom
	(properties
		lookStr {The Ballroom is pulsating with people--all of them men. "Where are the women?" you wonder.}
		picture 730
	)

	(method (init)
		(gEgo init:)
		(HandsOff)
		(switch gPrevRoomNum
			(710
				(self setScript: sFromSouth)
			)
			(else
				(gEgo get: 17) ; Silver_Dollar
				(= gSilvDollars 5000)
				(SetFlag 3) ; fSeenLL
				(HandsOn)
				(self setScript: sFromSouth)
			)
		)
		(super init:)
		(bouncer init: approachVerbs: 5 4) ; Talk, Inventory
		(InitFeatures)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 16 189 16 183 33 164 0 164
					yourself:
				)
		)
		(gTheMusic number: 738 setLoop: -1 flags: 1 play: 127)
		(cond
			((IsFlag 3) ; fSeenLL
				(LoadMany rsVIEW 1731 552)
				(LoadMany rsSOUND 744 743)
				(= mainEvent 1)
				(ring init: stopUpd:)
				(ropes init: stopUpd:)
			)
			((IsFlag 5) ; fMudWrestled
				(= mainEvent 0)
			)
			(else
				(= mainEvent 2)
				(Load rsSOUND 743)
				(LoadMany rsVIEW 733 738)
			)
		)
		(Load rsVIEW 731)
	)

	(method (doVerb theVerb invItem)
		(return
			(if (== (gCurRoom curPic:) 738)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 730 setScript: 0)
				(herEyes dispose:)
				(herMouth dispose:)
				(SetupExit 0)
				(InitFeatures)
				(sContest start: (sContest state:))
				(contestant setScript: sContest)
				1
			else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (gEgo mover:) (== (gCurRoom curPic:) 738))
			(gEgo setMotion: 0)
			(self doVerb:)
		)
		(cond
			(script)
			((gEgo script:))
			((gEgo edgeHit:)
				(gEgo edgeHit: EDGE_NONE)
				(HandsOff)
				(gCurRoom setScript: sLeave)
			)
			((and (gEgo sitting:) (gEgo mover:))
				(if (== (gCurRoom curPic:) 738)
					(self doVerb:)
				else
					(HandsOff)
					(gEgo setScript: sStandUp)
				)
			)
			(
				(and
					(gCast contains: lana)
					(not justWatching)
					(== (lana script:) sTaunt)
				)
				(gEgo setPri: 14 setScript: sLarryIntoRing)
			)
			((and (< (gEgo y:) 137) (not (gEgo sitting:)))
				(gEgo setScript: sSitDown)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (!= newRoomNumber 740)
			(gTheMusic fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion:
						MoveTo
						(- (gEgo x:) 25)
						(+ (gEgo y:) 25)
						self
				)
			)
			(1
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance sFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					normalize:
					posn: -30 222
					setMotion: PolyPath 8 188 self
				)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sSitDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 731
					setLoop: 1
					setCel: 0
					setPri: 14
					setCycle: End
					setMotion: MoveTo 111 130 self
				)
			)
			(1
				(gEgo x: 111 y: 123 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo sitting: 1)
				(HandsOn)
				(cond
					((== mainEvent 1)
						(if justWatching
							(= paid 0)
						)
						(if (not (gCast contains: lana))
							(lana init: setScript: sWrestle)
						)
					)
					((not (gCast contains: contestant))
						(contestant init: setScript: sContest)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo sitting: 0)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 7))
				(= cycles 1)
			)
			(2
				(gEgo
					setLoop: 2
					setCel: 0
					setCycle: End
					setMotion: PolyPath 80 137 self
				)
			)
			(3
				(HandsOn)
				(gEgo normalize:)
				(if
					(and
						((CueObj client:) approachX:)
						(!= ((gTheIconBar curIcon:) cursor:) 0)
					)
					(gEgo
						setMotion:
							PolyPath
							((CueObj client:) approachX:)
							(+ (gEgo z:) ((CueObj client:) approachY:))
							CueObj
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sWrestle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lana setLoop: 0 setCycle: Fwd setMotion: MoveTo 265 82 self)
			)
			(1
				(lana setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(soundFX number: 743 play:)
				(lana setLoop: 2 setCel: 0 setCycle: CT 7 1 self)
			)
			(3
				(robe init: setCycle: End)
				(lana setLoop: 4 setCycle: Fwd setMotion: MoveTo 223 82 self)
			)
			(4
				(lana
					x: 203
					y: 65
					setLoop: 5
					setCel: 0
					setPri: 7
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(5
				(soundFX number: 744 play:)
				(lana setLoop: 4 x: 174 y: 82)
				(= cycles 2)
			)
			(6
				(lana cycleSpeed: 6 setScript: sTaunt)
				(self dispose:)
			)
		)
	)
)

(instance sContest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(TPrint 730 0) ; "The public address system booms through the hall, "Come on, guys, let's give a great big welcome to the last contestant in the big `Tramp This! Wet T-Shirt Contest,' Miss Jennifer Jiggle!""
				(= seconds 3)
			)
			(1
				(contestant setCycle: Walk setMotion: MoveTo 250 82 self)
			)
			(2
				(soundFX number: 743 play:)
				(contestant setCycle: Walk setMotion: MoveTo 160 82 self)
			)
			(3
				(contestant
					setLoop: 2
					setCel: 0
					setMotion: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: End self
				)
			)
			(4
				(contestant setCycle: Beg self)
			)
			(5
				(= seconds 2)
			)
			(6
				(contestant
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 135 82 self
				)
			)
			(7
				(contestant setLoop: 3 setCel: 255 setCycle: Beg self)
			)
			(8
				(= seconds 2)
			)
			(9
				(contestant
					setLoop: -1
					cycleSpeed: 6
					moveSpeed: 6
					setCycle: Walk
					setMotion: MoveTo 360 82 self
				)
			)
			(10
				(TPrint 730 1) ; "And that completes today's matinee, guys! Come back later today for the wonderful "Tramp This! Mud Night Madness" mud wrestling contest!"
				(gTheMusic fade: 0 10 5 1)
				(self dispose:)
			)
		)
	)
)

(instance sLarryIntoRing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (gEgo sitting:))
					(gEgo setMotion: PolyPath 70 132 self)
				else
					(= cycles 3)
				)
			)
			(1
				(if (not (gEgo sitting:))
					(gEgo
						view: 731
						setLoop: 1
						setCel: 0
						setPri: 14
						setCycle: End
						setMotion: MoveTo 101 130 self
					)
				else
					(= cycles 3)
				)
			)
			(2
				(gEgo
					view: 552
					sitting: 0
					setLoop: -1
					setCycle: Walk
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: MoveTo 90 123 self
				)
			)
			(3
				(ropes ignoreActors: 1)
				(ring ignoreActors: 1)
				(gEgo
					view: 552
					setLoop: 3
					setCycle: Walk
					setMotion: MoveTo 109 102 self
				)
			)
			(4
				(gEgo view: 731 setCel: 0 setCycle: CT 7 1 self)
			)
			(5
				(gEgo setPri: (+ (ring priority:) 1) setCycle: End self)
			)
			(6
				(soundFX number: 744 play: self)
			)
			(7
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(instance sTaunt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (lana x:) 184)
					(lana
						setLoop: 6
						setCycle: Fwd
						setMotion: MoveTo 115 82 self
					)
				else
					(lana
						setLoop: 7
						setCycle: Fwd
						setMotion: MoveTo 184 82 self
					)
				)
			)
			(1
				(lana setLoop: 8 setCel: 0 setCycle: End self)
			)
			(2
				(switch (Random 0 5)
					(0
						(Say Lana 730 2 #dispose) ; "C'mon, Larry! Let's see what you've got!"
					)
					(1
						(Say Lana 730 3 #dispose) ; "What'sa matter, Larry? Are you a wimp or a mouse?"
					)
					(2
						(Say Lana 730 4 #dispose) ; "What a wussy! Get up here!"
					)
					(3
						(Say Lana 730 5 #dispose) ; "A REAL man would be up here already!"
					)
					(4
						(Say Lana 730 6 #dispose) ; "What's wrong, Big Boy? Afraid I might win?"
					)
					(5
						(Say Lana 730 7 #dispose) ; "Geez, Larry! What a chicken!"
					)
				)
				(Delay (Random 10 20) 1 self)
			)
			(3
				(self changeState: 0)
			)
		)
	)
)

(instance sCloseup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(herEyes init: setCel: 0 setCycle: Beg self)
			)
			(2
				(= seconds (Random 2 4))
			)
			(3
				(herMouth init: setCel: 0 setCycle: End self)
			)
			(4
				(= seconds (Random 1 3))
			)
			(5
				(herMouth setCycle: Beg self)
			)
			(6
				(= seconds (Random 2 4))
			)
			(7
				(herEyes init: setCel: 0 setCycle: Beg self)
			)
			(8
				(= start (* 2 (Random 0 1)))
				(self init:)
			)
		)
	)
)

(instance contestant of Actor
	(properties
		x 340
		y 82
		description {Jennifer Jiggle}
		view 733
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Points 8 135)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 738 setScript: sCloseup)
				(SetupExit 1)
				(DisposeFeatures)
				(self setCycle: 0 setMotion: 0)
			)
			(5 ; Talk
				(Say gEgo 730 8) ; ""Hey, Jennifer! Why don't you really wet down that T-shirt?" you shout."
			)
			(4 ; Inventory
				(TPrint 730 9) ; "There's nothing you can use on Jennifer that she hasn't used on herself already!"
			)
			(10 ; Zipper
				(TPrint 730 10) ; "You really wish she'd take off that shirt, don't you, Larry?"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance lana of Actor
	(properties
		x 340
		y 82
		description {Lana Luscious}
		lookStr {Lana looks much different, now that she's out of her roller skates and into her element!}
		view 734
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 730 11) ; "You'll have to pay first, Larry!"
			)
			(5 ; Talk
				(Say gEgo 730 12) ; ""Oh, yeah, Lana? I'm not afraid of you," you say quietly."
			)
			(10 ; Zipper
				(TPrint 730 13) ; "She's waiting for you to climb in that ring and do exactly that!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance robe of Prop
	(properties
		x 300
		y 55
		description {her robe}
		lookStr {She threw away her robe!}
		view 734
		loop 3
	)
)

(instance ring of View
	(properties
		x 147
		y 107
		description {the mud wrestling ring}
		lookStr {Welcome to "Tramp This! Mud Night Madness" mud wrestling ring.}
		view 730
		priority 4
		signal 16400
	)
)

(instance ropes of View
	(properties
		x 147
		y 107
		description {the ropes}
		lookStr {Welcome to "Tramp This! Mud Night Madness" mud wrestling ring.}
		view 730
		cel 1
		priority 8
		signal 16400
	)
)

(instance bouncer of Actor
	(properties
		x 16
		y 161
		description {the bouncer}
		sightAngle 40
		approachX 16
		approachY 168
		lookStr {You feel certain this bouncer is not nearly as wise as you in the ways of women.}
		view 732
		signal 16384
	)

	(method (doVerb theVerb invItem &tmp [str 200])
		(switch theVerb
			(2 ; Look
				(if (not payoff)
					(TPrint 730 14) ; "The gentleman blocking your path will be glad to allow you to pass--for a price."
				else
					(TPrint 730 15) ; "Since you've paid, he now treats you with all due respect."
					(TPrint 730 16 #at -1 185) ; "(Evidently you have none due!)"
				)
			)
			(10 ; Zipper
				(TPrint 730 17) ; "He'd bounce you a long way if you tried that!"
			)
			(5 ; Talk
				(switch mainEvent
					(0
						(Say The_Bouncer 730 18 #dispose) ; "Da ballroom's closed, Mac! Beat it, before I lose my delly-cate sense of humor."
					)
					(2
						(cond
							((< (gEgo y:) y)
								(Say The_Bouncer 730 19 #dispose) ; "There's one good seat down front, right at ringside!"
							)
							((Random 0 1)
								(Say The_Bouncer 730 20 #dispose) ; "$25.00, that's the cover charge and ya ain' gettin' in fer less!"
							)
							(else
								(Say The_Bouncer 730 21 #dispose) ; "Plenty o' good seats lef, Bud! Butcha ain' gettin' past me 'lessin' ya pays ma price!"
							)
						)
					)
					(1
						(if (< (gEgo y:) y)
							(Say The_Bouncer 730 22 #dispose) ; "You wanna chance to play wit' da goils? It'll cost ja $500.00, please! Up front. No refunds when ya get beat!"
						else
							(Say The_Bouncer 730 23 #dispose) ; "If ya wanna watch, I kin letcha in for a measly $25.00. If ya wanna participate, it'll cost ya 5 big ones! (Need I mention, it's worth it, too!)"
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; Silver_Dollar
						(cond
							(
								(not
									(= payoff
										(switch mainEvent
											(0 0)
											(2 25)
											(1
												(if (gCast contains: lana)
													500
												else
													(PrintD
														{"What's it gonna be?"}
														106
														80
														{The Bouncer}
														81
														{I'll just watch}
														25
														81
														{Lemme at 'em!}
														500
													)
												)
											)
										)
									)
								))
							(paid
								(if justWatching
									(Say The_Bouncer 730 24 #dispose) ; "Ya paid yer money. Now sit down!"
								else
									(Say The_Bouncer 730 25 #dispose) ; "Ya paid yer money. Now get in there!"
								)
							)
							((gEgo sitting:)
								(gEgo setScript: sStandUp)
							)
							((> payoff gSilvDollars)
								(Format @str 730 26 gSilvDollars gSilvDollars) ; "Excuse me, sir," you say to the hopefully friendly bouncer. "Would it be okay if I only paid you $%d.00? I seem to be a little short!"
								(Say gEgo @str)
								(TPrint 730 27) ; "The bouncer scowls at you."
								(Say The_Bouncer 730 28 #dispose) ; "Yeah, and not just in that wimpy little fake eelskin wallet, Donkey-doo! Get out of here!"
							)
							(else
								(if (== payoff 25)
									(Say gEgo 730 29) ; "Hello, Mister," you say to the bouncer. "I'd like to purchase one of your better seats. Here's my $25.00."
									(Say The_Bouncer 730 30 #dispose) ; "Thanks for nuttin'. Ya gets da best seat in da house--which is also da only seat in da house!"
									(= justWatching 1)
								else
									(Points 12 134)
									(Say gEgo 730 31) ; "Hello, Mister," you say to the bouncer. "I'd like to participate in the evening's next event. Here's my $500.00."
									(if (gCast contains: lana)
										(Say The_Bouncer 730 32 #dispose) ; "Thanks, suck... uh, er, Sir! Now if you'll kindly step into the ring, the beatin... ah, uh, the show will begin."
									else
										(Say The_Bouncer 730 33 #dispose) ; "Thanks, suck... uh, er, Sir! Now if you'll kindly sit down, the beatin... ah, uh, the show will begin."
									)
									(= justWatching 0)
								)
								(if (not (-= gSilvDollars payoff))
									(gEgo put: 17 0) ; Silver_Dollar
								)
								(= paid 1)
								(if (not (gCast contains: lana))
									(self
										setCycle: End self
										approachX: 43
										approachY: 153
									)
								)
							)
						)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(self setCel: 0 posn: (- x 16) y stopUpd:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 18 189 18 181 93 130 116 130 116 121 68 121 35 138 35 164 0 164
					yourself:
				)
		)
	)
)

(instance herEyes of Prop
	(properties
		x 150
		y 57
		view 738
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance herMouth of Prop
	(properties
		x 150
		y 57
		view 738
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(gCurRoom doVerb: theVerb)
	)
)

(instance The_Bouncer of Talker
	(properties
		name {The Bouncer}
		nsTop 15
		nsLeft 20
		view 1732
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust bouncerBust)
		(= eyes bouncerEyes)
		(= mouth bouncerMouth)
		(super init: &rest)
	)
)

(instance bouncerBust of Prop
	(properties
		view 1732
		loop 1
	)
)

(instance bouncerEyes of Prop
	(properties
		view 1732
		loop 2
		cycleSpeed 20
	)
)

(instance bouncerMouth of Prop
	(properties
		nsTop 53
		nsLeft 9
		view 1732
		cycleSpeed 8
	)
)

(instance Lana of Talker
	(properties
		nsTop 15
		nsLeft 15
		view 1731
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust lanaBust)
		(= eyes lanaEyes)
		(= mouth lanaMouth)
		(super init: &rest)
	)
)

(instance lanaBust of Prop
	(properties
		view 1731
		loop 1
	)
)

(instance lanaEyes of Prop
	(properties
		nsTop 31
		nsLeft 29
		view 1731
		loop 2
		cycleSpeed 30
	)
)

(instance lanaMouth of Prop
	(properties
		nsTop 40
		nsLeft 23
		view 1731
	)
)

(instance stage of Feature
	(properties
		x 152
		y 85
		nsTop 67
		nsLeft 91
		nsBottom 103
		nsRight 214
		description {the stage}
		sightAngle 40
		lookStr {The stage is where all the action takes place.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 730 34) ; "Of course, you want to go on stage, Larry, but first you must pay the bouncer his due."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance runway of Feature
	(properties
		x 260
		y 83
		nsTop 77
		nsLeft 202
		nsBottom 89
		nsRight 319
		description {the runway}
		sightAngle 40
		lookStr {You wonder what sort of babes must lie in wait down that runway.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 730 35) ; "You can't get on the runway, Larry. At least not yet!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

