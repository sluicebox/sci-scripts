;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm40 0
)

(local
	local0
	[local1 16] = [178 169 196 162 222 160 256 164 265 168 253 177 220 182 189 178]
	[local17 16] = [178 171 177 155 222 150 264 157 269 170 242 170 232 177 201 170]
	local33
	local34
)

(instance rm40 of SQRoom
	(properties
		picture 40
		horizon 133
		north 45
		east 41
	)

	(method (init)
		(holePoly points: @local1 size: 8)
		(shipPoly points: @local17 size: 8)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 241 0 179 126 155 149 111 146 75 152 76 163 0 167
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 172 308 172 306 166 277 163 253 147 291 144 319 146
					yourself:
				)
		)
		(LoadMany rsVIEW 27 514)
		(Load rsSOUND 603)
		(if (IsFlag 18)
			(self addObstacle: holePoly)
		else
			(self addObstacle: shipPoly)
		)
		(switch gPrevRoomNum
			(north
				(= style 10)
				(gEgo posn: 208 (+ horizon 5))
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
		(tinysign setCycle: Fwd init:)
		(radar setCycle: Fwd init:)
		(usedsign setCycle: Fwd init:)
		(allOfSign init:)
		(store init:)
		(banners init:)
		(pinkShip init:)
		(greenShip init:)
		(distantShips init:)
		(self setRegions: 702) ; ulenceRegion
		(gEgo init:)
		(super init:)
		(if (IsFlag 18)
			(hole init: addToPic:)
			(ladder view: 140 loop: 2 cel: 1 init: setPri: 8 addToPic:)
		else
			(shiplid init: stopUpd:)
			(ship init: stopUpd:)
		)
		(if (not (IsFlag 19))
			(tiny setScript: tinySellsShip)
		)
		(if (not (IsFlag 27))
			(if (!= gPrevRoomNum north)
				(ClearFlag 20)
			)
			(tiny init: stopUpd:)
			(arm init:)
		)
		(gLongSong2 number: 608 loop: -1 flags: 1 play:)
	)

	(method (doit)
		(if (and local0 (= local33 (gEgo edgeHit:)))
			(gEgo edgeHit: EDGE_NONE)
			(gCurRoom setScript: sayBye)
			(= local0 0)
		else
			(super doit:)
		)
	)

	(method (newRoom newRoomNumber)
		(if (not (IsFlag 20))
			(gLongSong2 fade:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(SetFlag 28)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 0) ; "You are on Tiny's Used Spaceship lot. There are only a few interesting ships to choose from."
			)
			(3 ; Do
				(Print 40 1) ; "Nothing to do there."
			)
			(5 ; Talk
				(if (IsFlag 27)
					(Print 40 2) ; "That's funny. Tiny is nowhere to be seen."
				else
					(Print 40 3) ; "No response from that."
				)
			)
			(12 ; Smell
				(Print 40 4) ; "You detect a bit of sulfur in the air here as well. You're getting quite tired of that smell, aren't you? I'm a friend. We can talk."
			)
			(11 ; Taste
				(Print 40 5) ; "Don't lick the air. You're libel to get more more than you bargained for."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tinySellsShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(if (not (IsFlag 20))
					(tinyTalker init: tinyBust tinyEye tinyMouth 140 0 0 1 self) ; "Howdy, bucko! Can I interest you in one of the finest little used space ships in the galaxy? You look like a man of discerning taste. This one, for instance, is just your speed... er... style, that is!"
				else
					(ClearFlag 20)
					(self cue:)
				)
			)
			(2
				(cond
					((IsFlag 19)
						(tinyTalker
							init: tinyBust tinyEye tinyMouth 140 1 0 1 self ; "Oops, sorry, chief. I forgot, you've already purchased that ship. What was I thinking of?"
						)
					)
					((IsFlag 28)
						(tinyTalker
							init: tinyBust tinyEye tinyMouth 140 2 0 1 self ; "Well, we're back for another look at this fine, fine, piece of jun... uh... spaceware. Right, chief?"
						)
						(= register 1)
					)
					(else
						(= register 1)
						(self cue:)
					)
				)
			)
			(3
				(if register
					(tinyTalker init: tinyBust tinyEye tinyMouth 140 3 0 1 self) ; "This is quite a unique little unit. Never been flown over Mach 3. It was owned by a little old lady from Glansadrom. You have to fly it to believe it. And she can be yours for only 99 buckazoids. One time offer only. TALK to me, friend!"
					(= register 0)
				else
					(self cue:)
				)
			)
			(4
				(= local0 1)
				(= seconds 7)
			)
			(5
				(if (not (IsFlag 20))
					(tinyTalker init: tinyBust tinyEye tinyMouth 140 4 0 1 self) ; "So how 'bout it, partner? Can I interest you in anything here? Can we do business, or what? I'm at your service. Talk to me, chief."
				else
					(self dispose:)
				)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance sayBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local33 1)
					(if local34
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{OK! Let's go take a look at those beauties!}
								0
								0
								1
								self
						)
					else
						(tinyTalker
							init: tinyBust tinyEye tinyMouth 140 5 0 1 self ; "Hey, fella, waitup! S'long as you're headed in that direction, why don'tcha let me show you my other fine spacecraft? No obligation whatsoever to you, pal. Just tryin' to be helpful to one in need."
						)
					)
					(SetFlag 20)
				else
					(tinyTalker init: tinyBust tinyEye tinyMouth 140 6 0 1 self) ; "It's been a heckuva pleasure doin' business with you. Well, good luck. Come again!"
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance getIntoShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tinyTalker init: tinyBust tinyEye tinyMouth 140 7 0 1 self) ; "It's been a heckuva pleasure doin' business with you. Well, good luck. Come again!"
			)
			(1
				(Print 40 6) ; "You proudly climb into your new used spacecraft. There is definitely something unique about it."
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					posn: 216 137
					view: 27
					setLoop: 0
					setPri: 14
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(2
				(shiplid view: 240 cel: 0 setCycle: End self)
				(gEgo hide:)
			)
			(3
				(gSoundEffects number: 603 loop: 1 play:)
				(= seconds 2)
			)
			(4
				(gLongSong2 fade: 0 10 10 1)
				(Print 40 7) ; "You turn the key excitedly."
				(= seconds 3)
			)
			(5
				(gSoundEffects number: 609 loop: 1 play: hold: 1)
				(shiplid hide:)
				(shiptail init:)
				(ship view: 240 loop: 3 setCycle: Fwd)
				(shiptail setCycle: Fwd)
				(ladder init: setCycle: CT 1 1 self)
			)
			(6
				(ladderSound loop: 0 play:)
				(ladder cel: 2 setCycle: End self)
			)
			(7
				(ladder setPri: 8 stopUpd:)
				(= seconds 6)
			)
			(8
				(gSoundEffects hold: 0 fade:)
				(shiptail hide:)
				(ship loop: 4 cel: 0 setCycle: End self)
			)
			(9
				(ship dispose:)
				(hole init: stopUpd:)
				(SetFlag 18)
				(SetFlag 24)
				(= seconds 5)
			)
			(10
				(gLongSong2 number: 608 loop: -1 play: 30 fade: 127 25 20 0)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					show:
					posn: 196 177
					view: 27
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(11
				(NormalEgo 0 1 61)
				(gEgo loop: 5 heading: 225)
				((gCurRoom obstacles:) delete: shipPoly)
				(gCurRoom addObstacle: holePoly)
				(= cycles 12)
			)
			(12
				(Print 40 8) ; "Drat! Where did mom and dad go wrong? You be the judge."
				(= seconds 2)
			)
			(13
				(tinyTalker init: tinyBust tinyEye tinyMouth 140 8 0 0 self) ; "Well, geez, guy! It seems it's developed some minor malfunction since we acquired it. We did have a small micro-meteoroid shower the other day. Maybe that was it! Yeah, that was probably it."
			)
			(14
				(tinyTalker say: 140 9 0 1 self) ; "Much as I'd like to, I can't refund your money. Company policy. It's out of my hands. However, I can give you seventy buckazoids credit on any other ship in our fine line of used spacecraft. Look around, see what you like."
			)
			(15
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance allOfSign of Feature
	(properties
		x 87
		y 10
		onMeCheck 4
	)

	(method (doVerb)
		(tinysign doVerb: &rest)
	)
)

(instance tinysign of Prop
	(properties
		x 87
		y 13
		view 140
		loop 1
		cycleSpeed 7
		detailLevel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 9) ; "There is a sign here which indicates that this is Tiny's Used Spaceship Lot."
			)
			(3 ; Do
				(Print 40 1) ; "Nothing to do there."
			)
			(5 ; Talk
				(Print 40 3) ; "No response from that."
			)
			(12 ; Smell
				(Print {You can't.})
			)
			(11 ; Taste
				(Print {You can't.})
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance usedsign of Prop
	(properties
		x 104
		y 26
		onMeCheck 4
		view 140
		cycleSpeed 5
		detailLevel 3
	)

	(method (doVerb)
		(tinysign doVerb: &rest)
	)
)

(instance store of Feature
	(properties
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 40 10) ; "There is a small, sturdy office here which unauthorized personnel are not allowed in."
			)
			(3 ; Do
				(Print 40 11) ; "You can't do anything to this stucco-style ship house."
			)
			(5 ; Talk
				(Print 40 12) ; "It responds not."
			)
			(12 ; Smell
				(Print 40 13) ; "It's just like all the other buildings in this place, rank!"
			)
			(11 ; Taste
				(Print 40 13) ; "It's just like all the other buildings in this place, rank!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance banners of Feature
	(properties
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 40 14) ; "There are some decorative banners which would seem to indicate that making a purchase at Tiny's can be a festive occasion."
			)
			(3 ; Do
				(Print 40 15) ; "You can't do anything to them. You're not in the proper union."
			)
			(5 ; Talk
				(Print 40 16) ; "In response, they hang limp."
			)
			(12 ; Smell
				(Print {You can't.})
			)
			(11 ; Taste
				(Print {You can't.})
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pinkShip of Feature
	(properties
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 40 17) ; "Who would paint their space ship pink? Anyway, it looks as if Tiny's using this old beast as a source for parts. It definitely won't fly."
			)
			(3 ; Do
				(Print 40 18) ; "Parts is parts and you don't have any need for them."
			)
			(5 ; Talk
				(Print 40 19) ; "Bad idea."
			)
			(12 ; Smell
				(Print 40 20) ; "It smells shippy."
			)
			(11 ; Taste
				(Print 40 21) ; "No thanks, I have to drive."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance greenShip of Feature
	(properties
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(switch theVerb
			(2 ; Look
				(Print 40 22) ; "This ship is a real classic - a WalWood WarpBlaster ZX with the original paint job. You've only seen these on old postcards. Too bad it belongs to one of the bar patrons and isn't for sale."
			)
			(3 ; Do
				(Print 40 23) ; "You really don't want to get handprints all over a valuable antique like this one."
			)
			(5 ; Talk
				(Print 40 24) ; "Your shout produces no response. The ship is empty."
			)
			(12 ; Smell
				(Print 40 25) ; "You're a nosy little beggar, aren't you?"
			)
			(11 ; Taste
				(Print 40 26) ; "Didn't your mother tell you not to go licking other people's spaceships?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance distantShips of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb)
		(= x ((User curEvent:) x:))
		(= y ((User curEvent:) y:))
		(if (== theVerb 2) ; Look
			(Print 40 27) ; "You see two ships in the northern part of Tiny's used spacecraft lot."
		)
		(if (OneOf theVerb 3 5 12 11) ; Do, Talk, Smell, Taste
			(Print 40 28) ; "They're way up there. You can't do anything from this distance."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance radar of Prop
	(properties
		x 165
		y 202
		z 30
		view 140
		loop 3
		cel 10
		priority 14
		signal 16400
		cycleSpeed 4
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 40 29) ; "The settlement of Ulence Flats is surrounded by these force field generators. They repel such undesirables such as the grell which thrive below the sands. It will allow only airborne vehicles in or out."
			)
			(3 ; Do
				(Print 40 30) ; "I wouldn't mess with them if I were you."
			)
			(5 ; Talk
				(Print 40 31) ; "No answer is forthcoming."
			)
			(12 ; Smell
				(Print 40 30) ; "I wouldn't mess with them if I were you."
			)
			(11 ; Taste
				(Print 40 30) ; "I wouldn't mess with them if I were you."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance tiny of Actor
	(properties
		x 132
		y 141
		approachX 148
		approachY 149
		view 445
		signal 16384
		cycleSpeed 14
		moveSpeed 14
	)

	(method (init)
		(self approachVerbs: 4) ; Inventory
		(super init: &rest)
	)

	(method (doVerb theVerb invItem &tmp [temp0 80])
		(switch theVerb
			(2 ; Look
				(Print 40 32) ; "Impossible to miss is the incredibly rotund owner, Tiny. The jaw jockey is most certainly an unusual-looking being. He looks very much like a fish who has swallowed its fishbowl."
			)
			(5 ; Talk
				(if (IsFlag 19)
					(tinyTalker
						init:
							tinyBust
							tinyEye
							tinyMouth
							{"I've got a coupl'a other fine ships just to the north of here. Whad'ya say, sport. Shall we go give 'em a gander?"}
							0
							0
							1
					)
					(= local34 (= local0 1))
				else
					(tinyTalker
						init:
							tinyBust
							tinyEye
							tinyMouth
							(Format @temp0 40 33 99 99) ; "I'll tell ya, ol' buddy, %u buckazoids is as low as I can go on this baby."
							0
							0
							1
					)
				)
			)
			(3 ; Do
				(Print 40 34) ; "Touching Tiny would be rude. However, you surmise from his scaly skin that he's probably about as slimy as his salespitches."
			)
			(12 ; Smell
				(Print 40 35) ; "Something smells fishy about this salesbeing."
			)
			(11 ; Taste
				(Print 40 36) ; "Sushi, anyone? Na, Tiny looks like a tough cookie."
			)
			(4 ; Inventory
				(switch invItem
					(10 ; buckazoid
						(cond
							((IsFlag 18)
								(Print 40 37) ; "There's nothing here to buy."
							)
							((IsFlag 19)
								(tinyTalker
									init:
										tinyBust
										tinyEye
										tinyMouth
										{I'd like to take your money, pal. But, even I wouldn't sell you the same ship twice.}
										0
										0
										1
								)
							)
							(local0
								(if (< gBuckazoidCount 99)
									(tinyTalker
										init:
											tinyBust
											tinyEye
											tinyMouth
											{"So, what are ya trying to pull? If you don't have the cash you can hit the road. Go on, get out of here. You're wasting my time!"}
											0
											0
											1
									)
								else
									(tinyTalker
										init:
											tinyBust
											tinyEye
											tinyMouth
											{"I tell ya, I think you've made a wise decision. She's a beauty. The keys are in her. If you have any problems don't hesitate to come back and tell us about 'em."}
											0
											0
											1
									)
									(SetFlag 19)
									(-= gBuckazoidCount 99)
								)
							)
							(else
								(Print 40 38) ; "Maybe you could get Tiny to sell you something if you talked to him."
							)
						)
					)
					(1 ; keyCard
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Thanks, pal. I don't know how long I've wanted one of these.}
								0
								0
								1
						)
						(gEgo put: 1) ; keyCard
					)
					(0 ; Cartridge
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{All riiiight! Is this that new Leisure Suit Larry movie?}
								0
								0
								1
						)
						(gEgo put: 0) ; Cartridge
					)
					(15 ; Widget
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{That's real cute. Now can we discuss buying a spaceship? I'm only here to serve you. Talk to me.}
								0
								0
								1
						)
					)
					(4 ; Knife
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{ "Yeah, I've heard about how your kind likes to skin my kind. If you only knew what WE do to monkeys on MY planet, you'd think twice about waving that little sticker in my direction. But, hey, I'd still like to sell you somethin'. What d'ya say?"}
								0
								0
								1
						)
					)
					(5 ; Dehydrated_Water
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Thanks a bunch, guy! This planet really dries me out. I feel like a you-know-what outa water.}
								0
								0
								1
						)
						(gEgo put: 5) ; Dehydrated_Water
					)
					(6 ; Broken_Glass
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Hey! I'm not responsible. That ship was in A-1 shape when I sold it to you!! I swear it!!! Hey, wait a minute. That's not from any of MY ships. What are you tryin' to pull here?}
								0
								0
								1
						)
					)
					(7 ; Rock
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Right, guy. Like I need a stupid rock. Do I look like I was hatched just yesterday?}
								0
								0
								1
						)
					)
					(9 ; Skimmer_Key
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Sorry, bud. I only deal in space ships, not sand skimmers.}
								0
								0
								1
						)
					)
					(11 ; Jetpack
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Sorry, bud. I only deal in space ships, not itsy-bitsy jetpacks.}
								0
								0
								1
						)
					)
					(2 ; Gadget
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{Lovely gadget - lovely. So are we gonna make a deal here?. Talk to me.}
								0
								0
								1
						)
					)
					(else
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
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

(instance arm of Prop
	(properties
		x 148
		y 117
		view 445
		loop 2
		cycleSpeed 12
	)
)

(instance hole of View
	(properties
		x 224
		y 167
		view 140
		loop 2
		priority 13
		signal 16400
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 2 3 1) ; Look, Do, ???
			(Print 40 39) ; "There is a hole here. I'm sure you recall its origin. At the bottom is the fine craft you rode to glory in. There is no reason to explore the hole any further."
		else
			(switch theVerb
				(3 ; Do
					(Print 40 40) ; "It's a hole. In this game there's nothing you can do to one."
				)
				(12 ; Smell
					(Print 40 41) ; "The hole smells like freshly dug dirt."
				)
				(11 ; Taste
					(Print 40 42) ; "It's dirt, man!"
				)
				(5 ; Talk
					(Print 40 43) ; "The void does not answer."
				)
				(4 ; Inventory
					(Print 40 44) ; "After carefully considering the hole matter, you decide not to throw anything down it."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance ship of Prop
	(properties
		x 224
		y 167
		approachX 207
		approachY 171
		view 340
		priority 13
		signal 16400
		cycleSpeed 6
	)

	(method (init)
		(self approachVerbs: 3 1) ; Do, ???
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 45) ; "You are standing near one of Tiny's used spacecraft. Upon close inspection they appear to have quite a few kilolightyears on them."
			)
			(3 ; Do
				(cond
					((IsFlag 19)
						(gCurRoom setScript: getIntoShip)
					)
					((gCast contains: tiny)
						(tinyTalker
							init:
								tinyBust
								tinyEye
								tinyMouth
								{"Sorry, you can only fly it when you buy it.  Oh, by the way, there are no refunds either.  Company Policy."}
								0
								0
								1
						)
					)
					(else
						(Print 40 46) ; "There's an old saying in these parts: "You don't touch a ship that isn't yours, you don't die.""
					)
				)
			)
			(12 ; Smell
				(Print 40 47) ; "For some reason, this ship smells like freshly-dug dirt."
			)
			(11 ; Taste
				(Print 40 48) ; "No wonder it smells like dirt. It also tastes like it."
			)
			(5 ; Talk
				(Print 40 49) ; "The ship offers no response."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shiplid of Prop
	(properties
		x 224
		y 108
		view 340
		cel 1
		priority 13
		signal 16400
		cycleSpeed 14
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 50) ; "That's the lid that covers and protects you during flight (provided this thing does fly)."
			)
			(else
				(ship doVerb: &rest)
			)
		)
	)
)

(instance shiptail of Prop
	(properties
		x 224
		y 107
		view 240
		loop 1
		priority 13
		signal 16400
		cycleSpeed 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 51) ; "This ship seems to have fins around its upper section. Quite a strange setup, but at least it's cheap."
			)
			(else
				(ship doVerb: &rest)
			)
		)
	)
)

(instance ladder of Prop
	(properties
		x 212
		y 167
		z -3
		view 240
		loop 2
		priority 14
		signal 16400
		cycleSpeed 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 40 52) ; "It's the ladder you used to climb aboard your mole ship."
			)
			(3 ; Do
				(Print 40 53) ; "There's no need for that."
			)
			(12 ; Smell
				(Print 40 54) ; "It smells like boot bottoms."
			)
			(11 ; Taste
				(Print 40 55) ; "UGGH! It tastes like boot bottoms!"
			)
			(5 ; Talk
				(Print 40 56) ; "It doesn't acknowledge your inquiry."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shipPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance holePoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance tinyTalker of Talker
	(properties
		x 99
		y 16
		nsTop 5
		nsLeft 11
		view 514
	)
)

(instance tinyBust of View
	(properties
		view 514
		cel 1
	)
)

(instance tinyMouth of Prop
	(properties
		nsTop 44
		nsLeft 29
		view 514
		loop 4
		cycleSpeed 9
	)
)

(instance tinyEye of Prop
	(properties
		nsTop 26
		nsLeft 35
		view 514
		loop 2
		cycleSpeed 30
	)
)

(instance ladderSound of Sound
	(properties
		number 631
	)
)

