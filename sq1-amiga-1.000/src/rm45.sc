;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 45)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Talker)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm45 0
)

(local
	[local0 3] = [0 145 210]
	local3
	local4
	local5
)

(procedure (localproc_0)
	(ship startUpd:)
	(gear startUpd:)
	(canopy startUpd:)
	(ladder startUpd:)
)

(procedure (localproc_1)
	(ship stopUpd:)
	(gear stopUpd:)
	(canopy stopUpd:)
	(ladder stopUpd:)
)

(instance rm45 of SQRoom
	(properties
		lookStr {You are standing in the back part of Tiny's used space-craft lot.}
		picture 45
		east 46
		south 40
	)

	(method (init)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 295 145 300 152 248 158 194 152 200 145 248 142
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 245 122 143 122 94 115 94 58 245 58
					yourself:
				)
		)
		(switch gPrevRoomNum
			(south
				(= style 10)
			)
			(east
				(= style 11)
				(gEgo x: 300)
				(HandsOn)
			)
			(else
				(= style 8)
				(gEgo posn: 160 180)
				(HandsOn)
			)
		)
		(self setRegions: 702) ; ulenceRegion
		(gEgo init:)
		(super init:)
		(if (and (== gPrevRoomNum south) (not (IsFlag 20)))
			(gLongSong2 fade:)
		)
		(saucer init: stopUpd:)
		(saucerShadow init: stopUpd:)
		(saucerLid init: stopUpd:)
		(ship init: stopUpd:)
		(canopy init: stopUpd:)
		(gear init: stopUpd:)
		(ladder init: stopUpd:)
		(shadow init: stopUpd:)
		(radar1 init: setCycle: Fwd)
		(radar2 init: setCycle: Fwd)
		(if (IsFlag 33)
			(robottrac init: hide:)
		else
			(Load rsSOUND 631)
		)
	)

	(method (notify)
		(super notify: &rest)
		(if (IsFlag 20)
			(tiny init: setScript: sellShips)
			(self
				addObstacle:
					((= local5 (Polygon new:))
						type: PBarredAccess
						init: 78 128 88 137 69 150 44 151 27 139 37 129
						yourself:
					)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (== (gLongSong2 number:) 608) (!= (gLongSong2 prevSignal:) -1))
			(gLongSong2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sellShips of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((and (gEgo mover:) (== ((gEgo mover:) caller:) CueObj)) 0)
			((gEgo inRect: 185 140 300 175)
				(if (!= local3 1)
					(= local3 1)
					(client setScript: sellSaucer)
				)
			)
			((gEgo inRect: 100 80 246 136)
				(if (!= local3 2)
					(= local3 2)
					(client setScript: sellRealShip)
				)
			)
			(
				(and
					(!= (gCurRoom script:) (ScriptID 812 0)) ; eRS
					(== (gEgo edgeHit:) EDGE_BOTTOM)
				)
				(gCurRoom setScript: walkTinyOutFirst)
				(self dispose:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tiny setLoop: 3 setCycle: Walk setMotion: MoveTo 54 140 self)
			)
			(1
				(tiny view: 445 setLoop: 0 cel: 0 stopUpd:)
				(arm init: stopUpd:)
				(arm
					show:
					setLoop: 2
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(2
				(arm stopUpd:)
				(localproc_0)
				(= cycles 4)
			)
			(3
				(tinyTalk init: tinyHead tinyEyes tinyLips 145 0 0 1 self) ; "Now, just take a gander at these beauties, sport. If ya see one ya like, just give a hoot. I'll stand right over here. No pressure. Absolutely none."
			)
			(4
				(= cycles 4)
			)
			(5
				(localproc_1)
				(HandsOn)
				(= seconds 6)
			)
			(6
				(localproc_0)
				(= cycles 4)
			)
			(7
				(switch (Random 0 4)
					(0
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 1 0 1 self ; "So how 'bout it partner? Can I interest you in anything here?"
						)
						(= register 2)
					)
					(1
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 2 0 1 self ; "Can we do business, or what? I'm at your service."
						)
						(= register 1)
					)
					(2
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 3 0 1 self ; "I'd really like to help you out, bud. Just give me a chance to treat you right!"
						)
						(= register 3)
					)
					(3
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 4 0 1 self ; "My sole purpose in life is to make you happy."
						)
						(= register 2)
					)
					(4
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 5 0 1 self ; ""Have I mentioned that I have another party or two who are ready to deal? Not that I'm pressuring you or anything, partner. Just so you know."
						)
						(= register 3)
					)
				)
			)
			(8
				(localproc_1)
				(switch register
					(1
						(arm
							show:
							setLoop: 2
							cel: 0
							posn: (+ (tiny x:) 17) (- (tiny y:) 28)
							setPri: (tiny priority:)
							setCycle: Osc 1 self
						)
					)
					(2
						(arm
							show:
							setLoop: 4
							cel: 0
							posn: (+ (tiny x:) 17) (- (tiny y:) 28)
							setPri: (tiny priority:)
							setCycle: Osc 1 self
						)
					)
					(3
						(arm
							show:
							setLoop: 4
							cel: 0
							posn: (+ (tiny x:) 17) (- (tiny y:) 28)
							setPri: (tiny priority:)
							setCycle: Osc 1 self
						)
					)
				)
			)
			(9
				(localproc_0)
				(= cycles 4)
			)
			(10
				(arm stopUpd:)
				(if (!= register 3)
					(tinyTalk
						init:
							tinyHead
							tinyEyes
							tinyLips
							{"Talk to me, chief."}
							0
							0
							1
							self
					)
				else
					(self cue:)
				)
			)
			(11
				(= cycles 4)
			)
			(12
				(localproc_1)
				(= seconds 12)
			)
			(13
				(= start 3)
				(self init:)
			)
		)
	)
)

(instance walkTinyOutFirst of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 y: 188)
				(Face gEgo tiny self)
			)
			(1
				(localproc_0)
				(= cycles 4)
			)
			(2
				(tinyTalk init: tinyHead tinyEyes tinyLips 145 6 0 1 self) ; "Hey, wait a sec, sport. Follow me and I'll show you the greatest ship you've ever seen. Truly unique! You'll be the envy of all your friends. The girls'll love it."
			)
			(3
				(= cycles 4)
			)
			(4
				(localproc_1)
				(arm
					show:
					setLoop: 2
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(5
				(arm dispose:)
				(tiny view: 446 setLoop: 2 setScript: 0 setCycle: Walk)
				(if (> (gEgo x:) 55)
					(tiny setMotion: MoveTo 12 240 self)
				else
					(tiny setMotion: MoveTo -30 180 self)
				)
			)
			(6
				(gEgo setMotion: MoveTo (gEgo x:) 190 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sellSaucer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo saucer self)
			)
			(1
				(localproc_0)
				(= cycles 4)
			)
			(2
				(tinyTalk init: tinyHead tinyEyes tinyLips 145 7 0 0 self) ; "Don't let appearances fool ya. This baby may be a relic, I mean, a classic, but she's as dependable as the day we got her. And just think, you'll be the only one in the quadrant with one. I guarantee it!"
			)
			(3
				(arm
					show:
					setLoop: 4
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(4
				(arm stopUpd:)
				(tinyTalk say: 145 8 0 (not (IsFlag 24)) self) ; "She's a beaut, isn't she? This little baby can do a spin around the planet in just under an hour. Look at the lines in that body work. They just don't make 'em like this any more, ya' know what I mean? And she's a real bargain at 185 buckazoids."
			)
			(5
				(arm
					show:
					setLoop: 2
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(6
				(arm stopUpd:)
				(if (IsFlag 24)
					(tinyTalk say: 145 9 0 1 self) ; "Of course, minus your 70 buckazoid credit, that would come to 115 buckazoids."
					(= local4 115)
				else
					(= local4 185)
					(arm
						show:
						setLoop: 4
						cel: 0
						posn: (+ (tiny x:) 17) (- (tiny y:) 28)
						setPri: (tiny priority:)
						setCycle: Osc 1 self
					)
				)
			)
			(7
				(= cycles 4)
			)
			(8
				(localproc_1)
				(= cycles 4)
			)
			(9
				(arm stopUpd:)
				(sellShips start: 3)
				(HandsOn)
				(client setScript: sellShips)
			)
		)
	)
)

(instance sellRealShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo ship self)
			)
			(1
				(localproc_0)
				(= cycles 4)
			)
			(2
				(tinyTalk init: tinyHead tinyEyes tinyLips 145 10 0 0 self) ; "Well, there's a man with a good eye. This here is the keenest little scrambler in the hemisphere. Top of the line. Handles like a charm. Perfect for cruising the asteroid fields."
			)
			(3
				(arm
					show:
					setLoop: 4
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(4
				(arm stopUpd:)
				(tinyTalk say: 145 11 0 (not (IsFlag 24)) self) ; "And she's got all the thrust a guy could need. I tell ya, she's an outright steal at 214 buckazoids."
			)
			(5
				(arm
					show:
					setLoop: 2
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(6
				(arm stopUpd:)
				(if (IsFlag 24)
					(tinyTalk say: 145 12 0 1 self) ; "Of course, minus your 70 buckazoid credit, that would come to, uh... 144 buckazoids."
					(= local4 144)
					(self cue:)
				else
					(= local4 214)
					(arm
						show:
						setLoop: 4
						cel: 0
						posn: (+ (tiny x:) 17) (- (tiny y:) 28)
						setPri: (tiny priority:)
						setCycle: Osc 1 self
					)
				)
			)
			(7
				(= cycles 4)
			)
			(8
				(localproc_1)
				(arm stopUpd:)
				(sellShips start: 3)
				(HandsOn)
				(client setScript: sellShips)
			)
		)
	)
)

(instance getInShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 167 122 self)
				(if (IsFlag 33)
					((ScriptID 702 1) setMotion: 0) ; robot
				)
			)
			(1
				(localproc_0)
				(= cycles 4)
			)
			(2
				(if (gCast contains: tiny)
					(if (IsFlag 33)
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 13 0 1 self ; "It's been a heckuva pleasure doin' business with you. It's a good thing you've already got a pilot droid, 'cause you need one to help you fly that thing. Well, good luck. Come again."
						)
					else
						(tinyTalk
							init: tinyHead tinyEyes tinyLips 145 14 0 1 self ; "It's been a heckuva pleasure doin' business with you. Oh, by the way, you're gonna need a droid to help you fly that thing. Well, good luck. Come again."
						)
					)
				else
					(++ state)
					(++ state)
					(self cue:)
				)
			)
			(3
				(= cycles 4)
			)
			(4
				(localproc_1)
				(arm
					show:
					setLoop: 2
					cel: 0
					posn: (+ (tiny x:) 17) (- (tiny y:) 28)
					setPri: (tiny priority:)
					setCycle: Osc 1 self
				)
			)
			(5
				(if (gCast contains: tiny)
					(arm dispose:)
					(tiny
						view: 446
						setLoop: 2
						setScript: 0
						setCycle: Walk
						setMotion: MoveTo 12 240
					)
					(local5 type: 0)
					(gLongSong2 fade:)
				)
				(gEgo
					posn: 171 86
					setPri: 14
					view: 145
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(6
				(canopy loop: 5 cel: 0 setCycle: End self)
				(gEgo hide:)
			)
			(7
				(gSoundEffects number: 603 loop: 1 play:)
				(= seconds 4)
			)
			(8
				(if (IsFlag 33)
					(client setScript: robotIntoShip)
				else
					(Print 45 0) ; "Seated in the cruiser, you notice there are no controls within reach, just a button marked "LOAD". Tiny must have been serious when he said you would need a droid to fly this thing."
					(Print 45 1) ; "And, since you are currently droidless, there seems to be nothing else to do but climb out."
					(gSoundEffects number: 603 loop: 1 play:)
					(canopy setCycle: Beg self)
					(gEgo show:)
				)
			)
			(9
				(= seconds 3)
			)
			(10
				(gEgo setPri: 14 setCycle: Beg self)
			)
			(11
				(NormalEgo 0 1 61)
				(gEgo
					posn: 167 122
					loop: 3
					heading: 0
					setMotion: MoveTo 167 133 self
				)
			)
			(12
				(tiny dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance robotIntoShip of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 4) (== (gLongSong2 prevSignal:) 10))
			(gLongSong2 prevSignal: 0)
			(= cycles 4)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 702 1) ; robot
					illegalBits: 0
					setMotion: PolyPath 235 117 self
				)
			)
			(1
				((ScriptID 702 1) setPri: 4 setMotion: MoveTo 151 117 self) ; robot
			)
			(2
				(Print 45 2) ; "Once you are seated snuggly in the ship's compact cockpit, the robot moves into position, and you push the "LOAD" button."
				(= cycles 4)
			)
			(3
				(gSoundEffects number: 606 loop: 1 play:)
				(robottrac posn: 151 117 show: stopUpd:)
				((ScriptID 702 1) ; robot
					setPri: 14
					view: 145
					setLoop: 4
					cel: 0
					posn: 151 87
					setCycle: End self
				)
			)
			(4
				(gSoundEffects stop:)
				(gLongSong2 number: 624 loop: 1 flags: 1 play:)
				(zap1 init: setCycle: Fwd)
				(zap2 init: setCycle: Fwd)
				(gear setCycle: End)
			)
			(5
				(canopy dispose:)
				((ScriptID 702 1) dispose:) ; robot
				(ship setCel: 1 setMotion: MoveTo (ship x:) -50 self)
				(shadow setCycle: End)
				(ladder setScript: fallDown)
			)
			(6
				(ship stopUpd:)
				(zap1 dispose:)
				(zap2 dispose:)
				(gLongSong2 fade: 40 25 4 0)
				(SetScore 25 159)
				(mugger init: setCycle: Walk setMotion: MoveTo 250 120 self)
			)
			(7
				(mugger setLoop: 7 cel: 0 cycleSpeed: 5 setCycle: End self)
			)
			(8
				(Print 45 3) ; "Hey! Wait a minute! Where do you think you're goin' with my ship?!!"
				(mugger setCycle: End self)
			)
			(9
				(ship
					setPri: -1
					setCel: -1
					view: 835
					posn: 65 158
					cel: 10
					setLoop: 0
					cycleSpeed: 18
					setCycle: Beg self
				)
			)
			(10
				(gLongSong number: 465 loop: -1 play:)
				(gCurRoom newRoom: 49)
			)
		)
	)
)

(instance getInSaucer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 223 146 self)
			)
			(1
				(gEgo
					view: 245
					setLoop: 0
					cel: 0
					posn: 247 141
					setPri: 14
					setCycle: End self
				)
			)
			(2
				(saucerLid cel: 1 setCycle: End self)
				(gEgo hide:)
				(gLongSong2 stop:)
			)
			(3
				(gSoundEffects number: 603 loop: 1 play: self)
			)
			(4
				(gSoundEffects number: 610 loop: 1 play: hold: 1)
				(saucerLid hide:)
				(saucer setLoop: 2 cel: 0)
				(= cycles 4)
			)
			(5
				(saucer setCycle: End self)
				(saucerShadow setCycle: End)
			)
			(6
				(gSoundEffects hold: 0)
				(saucer
					cycleSpeed: 6
					setCycle: CT 4 -1
					setStep: 4 7
					setMotion: MoveTo 200 60 self
				)
			)
			(7
				(gSoundEffects fade:)
				(saucer
					cycleSpeed: 8
					setCycle: End
					setStep: 4 12
					setMotion: MoveTo 260 -60 self
				)
			)
			(8
				(saucerShadow dispose:)
				(saucerLid dispose:)
				(= seconds 3)
			)
			(9
				(gSoundEffects number: 617 loop: 1 play:)
				(saucer
					posn: 220 30
					setLoop: 4
					cel: 0
					cycleSpeed: 6
					setCycle: CT 5 1 self
				)
			)
			(10
				(gSoundEffects number: 618 loop: 1 play:)
				(saucer setCycle: End self)
			)
			(11
				(EgoDead 945 0 0 45 4) ; "Darn the luck. You've crashed in the dunes and ended your life. The various inhabitants of the Keronian desert are now feasting on your remains. Guess that wasn't such a hot purchase."
			)
		)
	)
)

(instance fallDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ladder setCycle: CT 2 1 self)
			)
			(1
				(gSoundEffects number: 631 loop: 1 play:)
				(ladder cel: 3 setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance arm of Prop
	(properties
		view 445
		loop 2
		signal 24576
		cycleSpeed 7
	)
)

(instance zap1 of Prop
	(properties
		x 192
		view 145
		loop 2
		priority 14
		signal 8208
		cycleSpeed 1
	)

	(method (doit)
		(= y (- (ship y:) 13))
		(super doit: &rest)
	)
)

(instance zap2 of Prop
	(properties
		x 209
		view 145
		loop 3
		cel 3
		priority 14
		signal 8208
		cycleSpeed 1
	)

	(method (doit)
		(= y (- (ship y:) 13))
		(super doit: &rest)
	)
)

(instance tiny of Actor
	(properties
		x 12
		y 219
		description {Tiny}
		lookStr {Tiny is a large, green-scale-covered jaw jockey with the personality of a true salesman. Not a prime combination of traits, I must say.}
		yStep 3
		view 446
		signal 16384
		cycleSpeed 9
		illegalBits 0
		xStep 4
		moveSpeed 9
	)

	(method (doit)
		(= approachX (+ x 16))
		(= approachY (+ y 8))
		(super doit: &rest)
	)

	(method (init)
		(self approachVerbs: 4) ; Inventory
		(super init: &rest)
	)

	(method (cue)
		(if (IsFlag 24)
			(Printf 45 5 local4) ; "Of course, with your 70 buckazoid rebate, that's just %u to you."
		)
		(super cue: &rest)
	)

	(method (doVerb theVerb invItem &tmp [temp0 60])
		(switch theVerb
			(5 ; Talk
				(cond
					((not (IsFlag 19))
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 15 0 1) ; "I still have that other, fine ship just to the south of here. Whad'ya say, sport, shall we go give her another look-see?"
					)
					(local4
						(tinyTalk
							init:
								tinyHead
								tinyEyes
								tinyLips
								(Format @temp0 45 6 [local0 local3]) ; "I'll tell ya, ol' buddy, %u buckazoids is as low as I can go on that baby."
								0
								0
								1
						)
					)
					(else
						(Print 45 7) ; "Tiny isn't a great conversationalist. He just wants to sell, sell, sell."
					)
				)
			)
			(3 ; Do
				(Print 45 8) ; "Touching Tiny would be rude. However, you surmise from his scaly skin that he's probably about as slimy as his salespitch."
			)
			(12 ; Smell
				(Print 45 9) ; "Something smells fishy about this salesbeing."
			)
			(11 ; Taste
				(Print 45 10) ; "Sushi, anyone? Na, Tiny looks like a tough cookie."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(if local4
							(cond
								(
									(or
										(and (== local3 1) (IsFlag 26))
										(and (== local3 2) (IsFlag 27))
									)
									(tinyTalk
										init:
											tinyHead
											tinyEyes
											tinyLips
											{I'd like to take your money, pal. But, even I wouldn't sell you the same ship twice.}
											0
											0
											1
									)
								)
								((< gBuckazoidCount local4)
									(tinyTalk
										init: ; "So, what are ya tryin' to pull? If you don't have the cash you can hit the sand. Go on, get out of here. You're wasting my time!"
											tinyHead
											tinyEyes
											tinyLips
											145
											16
											0
											1
									)
								)
								(else
									(tinyTalk
										init: ; "I tell ya, I think you've made a wise decision. She's a beauty. The keys are in her. If you have any problems don't hesitate to come back and tell us about 'em."
											tinyHead
											tinyEyes
											tinyLips
											145
											17
											0
											1
									)
									(SetFlag
										(if (== local3 1)
											26
										else
											(ClearFlag 20)
											(SetScore 4 158)
											27
										)
									)
									(-= gBuckazoidCount local4)
									(self setScript: 0)
								)
							)
						else
							(Print 45 11) ; "Maybe you'd better take a closer look at Tiny's merchandise before making a purchase."
						)
					)
					(1 ; keyCard
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 18 0 1) ; "Thanks, pal. I can't say how long I've wanted one of these."
						(gEgo put: 1) ; keyCard
					)
					(2 ; Gadget
						(tinyTalk
							init:
								tinyHead
								tinyEyes
								tinyLips
								{Lovely gadget - lovely. So are we gonna make a deal here? Talk to me.}
								0
								0
								1
						)
					)
					(0 ; Cartridge
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 19 0 1) ; "All riiiight! Is this that new Earth Wars movie?"
						(gEgo put: 0) ; Cartridge
					)
					(4 ; Knife
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 20 0 1) ; "Yeah, I've heard about how your kind likes to skin my kind. If you only knew what WE do to monkeys on MY planet, you'd think twice about waving that little sticker in my direction. But, hey, I'd still like to sell you somethin'. What d'ya say?"
					)
					(11 ; Jetpack
						(tinyTalk
							init:
								tinyHead
								tinyEyes
								tinyLips
								{That's a smell jet ack, all right, but for exploring space, you need a real ship. Can we talk business.}
								0
								0
								1
						)
					)
					(5 ; Dehydrated_Water
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 21 0 1) ; "Thanks a bunch, guy! This planet really dries me out. I feel like a you-know-what outa water."
						(gEgo put: 5) ; Dehydrated_Water
					)
					(6 ; Broken_Glass
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 22 0 1) ; "Hey! I'm not responsible. That ship was in A-1 shape when I sold it to you. I swear it! Hey, wait a minute. That's not from any of MY ships. What are you tryin' to pull here?"
					)
					(7 ; Rock
						(tinyTalk init: tinyHead tinyEyes tinyLips 145 23 0 1) ; "Right, guy. Like I need a stupid rock. Do I look like I was hatched just yesterday?"
					)
					(9 ; Skimmer_Key
						(tinyTalk
							init:
								tinyHead
								tinyEyes
								tinyLips
								{Sorry, bud, but I only deal in space ships, not sand skimmers.}
								0
								0
								1
						)
					)
					(11 ; Jetpack
						(tinyTalk
							init:
								tinyHead
								tinyEyes
								tinyLips
								{Sorry, bud, but I only deal in space ships, not itsy-bitsy jetpacks.}
								0
								0
								1
						)
					)
					(else
						(tinyTalk
							init:
								tinyHead
								tinyEyes
								tinyLips
								{Sorry, pal, but I only take cash.}
								0
								0
								1
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance mugger of Actor
	(properties
		x 332
		y 140
		description {mugger}
		lookStr {As you rise high above the sands of Ulence, you look down and see someone waving good-bye. This really is a friendly place after-all!}
		view 432
		loop 1
		signal 2048
		cycleSpeed 4
		xStep 4
		moveSpeed 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(Print {That's not possible from up here.})
			)
			(5 ; Talk
				(Print {That's not possible from up here.})
			)
			(12 ; Smell
				(Print {That's not possible from up here.})
			)
			(11 ; Taste
				(Print {That's not possible from up here.})
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ship of Actor
	(properties
		x 171
		y 86
		description {ship}
		approachX 167
		approachY 130
		view 145
		loop 8
		priority 7
		signal 30736
		cycleSpeed 8
		moveSpeed 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (IsFlag 28)
					(Print 45 12) ; "Actually, this ship is not bad-looking. It appears to be a Drallion cruiser. They have a reputation for quickness and reliability. You are surprised that someone of Tiny's caliber would be carrying it."
				else
					(Print 45 13) ; "Actually, this ship is not bad-looking. It appears to be a Drallion cruiser. They have a reputation for quickness and reliability."
				)
			)
			(3 ; Do
				(if (IsFlag 27)
					(gCurRoom setScript: getInShip)
				else
					(Print 45 14) ; "There's a saying in these parts: "You don't touch a ship that isn't yours, you don't die.""
				)
			)
			(11 ; Taste
				(Print 45 15) ; "Hmmm... needs salt."
			)
			(12 ; Smell
				(Print 45 16) ; "This ship smells a bit like space. It must've been there recently."
			)
			(4 ; Inventory
				(switch invItem
					(11 ; Jetpack
						(Print 45 17) ; "An interesting idea, but applying the jetpack to a spacecraft makes about as much sense as attaching a C-64 to a Cray-64."
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance canopy of Actor
	(properties
		x 188
		y 61
		view 145
		loop 5
		priority 7
		signal 24592
		cycleSpeed 8
		moveSpeed 8
	)
)

(instance gear of Prop
	(properties
		x 171
		y 86
		view 145
		loop 1
		priority 7
		signal 16400
		cycleSpeed 8
	)
)

(instance robottrac of View
	(properties
		x 332
		y 139
		view 145
		loop 8
		cel 2
		signal 18432
	)
)

(instance ladder of Prop
	(properties
		x 169
		y 118
		description {ladder}
		approachX 167
		approachY 130
		lookStr {It's just a regular old ladder.}
		view 145
		loop 6
		priority 7
		signal 16400
		cycleSpeed 8
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3) ; Do
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Do
			(ship doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shadow of Prop
	(properties
		x 169
		y 118
		view 145
		loop 7
		priority 2
		signal 16400
		cycleSpeed 12
	)
)

(instance saucer of Actor
	(properties
		x 249
		y 141
		description {saucer ship}
		approachX 217
		approachY 142
		lookStr {It's awfully small, and also much older than you.}
		view 245
		loop 5
		priority 11
		signal 24592
		cycleSpeed 18
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 1) ; Do, ???
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if (IsFlag 26)
					(gCurRoom setScript: getInSaucer)
				else
					(Print 45 14) ; "There's a saying in these parts: "You don't touch a ship that isn't yours, you don't die.""
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance saucerShadow of Prop
	(properties
		x 249
		y 156
		view 245
		loop 3
		priority 2
		signal 16400
		cycleSpeed 18
	)
)

(instance saucerLid of Prop
	(properties
		x 263
		y 146
		z 7
		description {saucer's bubble}
		lookStr {That's the lid that covers and protects you during flight. Provided this thing does fly.}
		view 245
		loop 1
		priority 11
		signal 16400
		cycleSpeed 8
	)
)

(instance radar1 of Prop
	(properties
		x 87
		y 78
		description {force field sensor}
		lookStr {The settlement of Ulence Flats is surrounded by these force field generators. They repel such undesirables such as the grell which thrive below the sands. It will allow only airborne vehicles in or out.}
		view 171
		loop 2
		cel 1
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 45 18) ; "I wouldn't mess with them if I were you."
			)
			(5 ; Talk
				(Print 45 19) ; "No answer is forthcoming."
			)
			(12 ; Smell
				(Print 45 18) ; "I wouldn't mess with them if I were you."
			)
			(11 ; Taste
				(Print 45 18) ; "I wouldn't mess with them if I were you."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance radar2 of Prop
	(properties
		x 287
		y 78
		description {force field sensor}
		lookStr {The settlement of Ulence Flats is surrounded by these force field generators. They repel such undesirables such as the grell which thrive below the sands. It will allow only airborne vehicles in or out.}
		view 171
		loop 2
		cel 7
		cycleSpeed 8
	)

	(method (doVerb theVerb)
		(radar1 doVerb: theVerb)
	)
)

(instance tinyTalk of Talker
	(properties
		x 99
		y 16
		nsTop 5
		nsLeft 11
		view 514
	)
)

(instance tinyHead of View
	(properties
		view 514
		cel 1
	)
)

(instance tinyLips of Prop
	(properties
		nsTop 44
		nsLeft 29
		view 514
		loop 4
		cycleSpeed 9
	)
)

(instance tinyEyes of Prop
	(properties
		nsTop 26
		nsLeft 35
		view 514
		loop 2
		cycleSpeed 30
	)
)

(instance extraSound of Sound ; UNUSED
	(properties)
)

