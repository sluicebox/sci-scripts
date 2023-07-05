;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm790 0
)

(local
	talked
)

(instance rm790 of LLRoom
	(properties
		lookStr {You are inside the only open shop along the entire boardwalk. You wonder why this place doesn't join in the celebration of Donald Tramp's birthday.}
		picture 790
		south 760
	)

	(method (init)
		(LoadMany rsVIEW 1792 792)
		(gEgo init: normalize: actions: sitActions)
		(switch gPrevRoomNum
			(south
				(HandsOff)
				(gEgo x: 160)
				(gCurRoom setScript: sFromSouth)
			)
			(else
				(HandsOn)
				(gEgo posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(gTheMusic number: 790 loop: -1 flags: 1 play:)
		(skates init:)
		(curtain init: stopUpd:)
		(poster1 init:)
		(poster2 init:)
		(poster3 init:)
		(poster4 init:)
		(poster5 init:)
		(poster6 init:)
		(poster7 init:)
		(box init:)
		(light init:)
		(desk init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 189 250 189 250 137 224 120 91 120 63 151 63 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 179 144 217 144 238 157 198 157
					yourself:
				)
		)
	)

	(method (dispose)
		(if (gEgo has: 18) ; Roller-skates
			(SetFlag 6)
		)
		(gTheMusic fade:)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (StepOn gEgo 2) (not (gCast contains: Ivana_a)))
				(HandsOff)
				(Ivana_a init: approachVerbs: 4 5 3 setCycle: Walk) ; Inventory, Talk, Do
				(gCurRoom setScript: sIvanaEnters)
			)
		)
	)
)

(instance sIvanaEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Ivana_a setMotion: MoveTo 121 107 self)
			)
			(1
				(curtain setCycle: End curtain)
				(Ivana_a setMotion: MoveTo 121 111 self)
			)
			(2
				(Ivana_a setPri: 6 setMotion: MoveTo 150 111 self)
			)
			(3
				(Ivana_a setHeading: 180 self)
			)
			(4
				(Say Ivana_b 790 0 108) ; "Hiya, Cutie!" says the older woman behind the counter. "Welcome to `Skates, Etc.' I'm your hostess for your visit, Ivana Tramp."
				(Ivana_a stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo y: 250 setMotion: MoveTo 160 180 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTalk of Script
	(properties)

	(method (changeState newState &tmp num [str 80])
		(switch (= state newState)
			(0
				(= talked 1)
				(Say gEgo 790 1 67 -1 185) ; "Hello," you say. "I'd like to rent some skates."
				(Say Ivana_b 790 2 108 139 self) ; "Good idea; you've come to the right place. My rental fee is quite reasonable, but there's no use quibbling over such details now. When you return the skates, we'll settle up based upon the number of minutes you actually skate."
			)
			(1
				(Format @str 790 3 250) ; "But, first, I'll need a small deposit for such valuable equipment," she says, sizing you up. "Let's say oh, $%d, okay?"
				(Say Ivana_b @str 108 139 self)
			)
			(2
				(Say gEgo 790 4 67 -1 185) ; ""I don't have any money," you say."
				(Say Ivana_b 790 5 108 139 self) ; "Oh? Well, I suppose I'll accept some more of those damned `silver dollars' from the casino."
			)
			(3
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sCamcorder of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say gEgo 790 6 67 -1 185) ; "You have an inspiration. "Instead of money," you offer, "would you accept this `auto-focus, auto-level, auto-color balance, auto-zoom, auto-pan, .5-lux, Complete-Video-Studio-in-a-Pocket-Protector?' It's a `Rob Lowe Model,' you know!""
				(Say gEgo 790 7 67 -1 185) ; "It's the very latest model and was very expensive," you continue. "But you've got to promise to give it back when I return your skates."
				(Points 8 141)
				(Say Ivana_b 790 8 108 139 self) ; "Hmmmm," she muses, "`The Rob Lowe?' Yeah, I suppose that'll do for a deposit."
			)
			(1
				(TPrint 790 9) ; "And she takes it from you."
				(gEgo put: 0 790 get: 18) ; Camcorder, Roller-skates
				(HandsOn)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(self dispose:)
			)
		)
	)
)

(instance sRollerblades of Script
	(properties)

	(method (changeState newState &tmp num [str 80])
		(switch (= state newState)
			(0
				(Say gEgo 790 10 67 -1 185) ; "Here's my skates, ma'am," you say, handing them across the counter. "May I have my deposit back now?"
				(Say Ivana_b 790 11 108 139 self) ; ""Well, I dunno," she hesitates. "First, lemme inspect 'em for damages." And she diligently inspects every inch of your skates."
			)
			(1
				(Points 3 142)
				(if (gEgo has: 0) ; Camcorder
					(= num (Random 100 240))
					(Format @str 790 12 num) ; "Hey, looky here! Ya scuffed this wheel!" she shrieks. "I'm gonna haf'ta dock yer refund %d bucks!"
					(Say Ivana_b @str 108)
					(gEgo put: 18 0 get: 17) ; Roller-skates, Silver_Dollar
					(+= gSilvDollars (- 250 num))
				else
					(Say Ivana_b 790 13 108) ; "Hmmm. Well there's a small nick in this one wheel, but I guess you can have your camcorder back anyway, although I was kinda hopin' you'd jes' keep the skates."
					(gEgo put: 18 0 get: 0) ; Roller-skates, Camcorder
				)
				(HandsOn)
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(self dispose:)
			)
		)
	)
)

(instance Ivana_a of Actor
	(properties
		name {Ivana}
		x 147
		y 107
		description {Ivana Tramp}
		sightAngle 40
		approachX 130
		approachY 120
		lookStr {Ivana Tramp (known locally as "Wheels, The Blademaster") has plummeted several social levels since her divorce from The Donald.}
		view 792
		priority 3
		signal 16
	)

	(method (doVerb theVerb invItem &tmp num [str 80])
		(switch theVerb
			(3 ; Do
				(TPrint 790 14) ; "There's no need to shove her around, Larry; she's been shoved enough already!"
			)
			(10 ; Zipper
				(TPrint 790 15) ; "Perish the thought!"
			)
			(5 ; Talk
				(cond
					((gEgo has: 18) ; Roller-skates
						(if (IsFlag 6)
							(Say Ivana_b 790 16 108) ; ""So, didja have a good time on them blades, my little `Chicken Fat?'" says Ivana."
						else
							(Say Ivana_b 790 17 108) ; "Happy rolling!" says Ivana. "Remember: `keep your tips up!'"
						)
					)
					((IsFlag 6)
						(Say Ivana_b 790 18 108) ; ""Come back any time!" says Ivana."
					)
					((not talked)
						(HandsOff)
						(gCurRoom setScript: sTalk)
					)
					(else
						(Say Ivana_b 790 19 108) ; "I've already quoted you a price, young man! Take it or leave it!"
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(17 ; Silver_Dollar
						(cond
							((and (gEgo has: 18) (not (IsFlag 6))) ; Roller-skates
								(Say Ivana_b 790 20 108) ; "Oh, no money is necessary yet. We'll settle up when you return the skates!"
							)
							((IsFlag 6)
								(Say Ivana_b 790 21 108) ; "Thanks for the offer, Cutie-pie, but I never accept tips!"
							)
							((not talked)
								(HandsOff)
								(gCurRoom setScript: sTalk)
							)
							((< gSilvDollars 250)
								(Format @str 790 22 gSilvDollars) ; "Would you be willing to settle for $%d.00?" you ask. "That's all the money I have!"
								(Say gEgo @str 67 -1 185)
								(Say Ivana_b 790 23 108) ; "Hardly," she sniffs. "But, do you have anything else of value?"
							)
							(else
								(Format @str 790 24 250) ; "Here you are," you say, "here's %d of those heavy silver dollars."
								(Say gEgo @str 67 -1 185)
								(Points 4 143)
								(Say Ivana_b 790 25 108) ; "Thank you, sir!" she replies, accepting your money. "And remember: keep your skates as long as you wish; enjoy them as you would any other fine mechanical object. Just don't wear them off the boardwalk, for any reason."
								(if (not (-= gSilvDollars 250))
									(gEgo put: 17 0) ; Silver_Dollar
								)
								(gEgo get: 18) ; Roller-skates
								(gTheIconBar curIcon: (gTheIconBar at: 0))
								(gGame
									setCursor: ((gTheIconBar curIcon:) cursor:)
								)
							)
						)
					)
					(0 ; Camcorder
						(cond
							((IsFlag 6)
								(Say Ivana_b 790 26 108) ; "Oh, no," says Ivana Tramp. "that's yours! But, thanks anyway."
							)
							((gEgo has: 18) ; Roller-skates
								(Say Ivana_b 790 27 108) ; "Yes? Isn't that cute?" says Ivana. "You've got your skates. Why are you showing that to me?"
							)
							(else
								(HandsOff)
								(gCurRoom setScript: sCamcorder)
							)
						)
					)
					(18 ; Roller-skates
						(if (IsFlag 6)
							(HandsOff)
							(gCurRoom setScript: sRollerblades)
						else
							(Say Ivana_b 790 28 108) ; "What's the matter, little buddy?" asks Ivana. "Are you afraid you'll go outside on the boardwalk and get `stuck in a crack?'"
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
)

(instance skates of Feature
	(properties
		x 177
		y 69
		nsTop 49
		nsLeft 148
		nsBottom 90
		nsRight 206
		description {the skates}
		sightAngle 40
		lookStr {From the many pairs of in-line skates on this rack, you feel safe in predicting that this store rents skates.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 790 29) ; "You can't reach the skates, but even if you could, the owner would break your finger if you tried to take them without paying."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance curtain of Prop
	(properties
		x 123
		y 94
		description {the curtain}
		sightAngle 40
		lookStr {A beaded curtain blocks your view of the skate shop's back room.}
		view 790
		signal 16384
	)

	(method (cue)
		(super cue:)
		(self stopUpd:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 790 30) ; "You can't reach the beaded curtain."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance poster1 of Feature
	(properties
		x 64
		y 42
		nsTop 31
		nsLeft 54
		nsBottom 54
		nsRight 75
		description {the poster}
		sightAngle 40
		lookStr {You presume this poster advertises an amusement park for insects.}
	)
)

(instance poster2 of Feature
	(properties
		x 76
		y 75
		nsTop 51
		nsLeft 62
		nsBottom 100
		nsRight 90
		description {the poster}
		sightAngle 40
		lookStr {So that's what Ivana looked like when she was a redhead!}
	)
)

(instance poster3 of Feature
	(properties
		x 61
		y 113
		nsTop 96
		nsLeft 50
		nsBottom 131
		nsRight 73
		description {the poster}
		sightAngle 40
		lookStr {To demonstrate how good these skates are, the lady in the poster is eating one.}
	)
)

(instance poster4 of Feature
	(properties
		x 230
		y 75
		nsTop 44
		nsLeft 221
		nsBottom 82
		nsRight 240
		description {the poster}
		sightAngle 40
		lookStr {This poster advertises roller skate odor eaters.}
	)
)

(instance poster5 of Feature
	(properties
		x 238
		y 44
		nsTop 66
		nsLeft 225
		nsBottom 103
		nsRight 252
		description {the poster}
		sightAngle 40
		lookStr {"Keep your in-line skates in line with the all new `Edlin,' from Ed's Skate Aligning Corp."}
	)
)

(instance poster6 of Feature
	(properties
		x 253
		y 37
		nsTop 25
		nsLeft 246
		nsBottom 50
		nsRight 261
		description {the poster}
		sightAngle 40
		lookStr {"Better skating, no waiting."}
	)
)

(instance poster7 of Feature
	(properties
		x 250
		y 106
		nsTop 92
		nsLeft 241
		nsBottom 121
		nsRight 259
		description {the poster}
		sightAngle 40
		lookStr {"Nuclear Blades" for those who want to go REALLY fast!}
	)
)

(instance light of Feature
	(properties
		x 165
		y 37
		nsTop 30
		nsLeft 147
		nsBottom 44
		nsRight 184
		description {the light}
		sightAngle 40
		lookStr {Ivana has thoughtfully replaced the standard 60-watt bulb with this new 250-watt halogen.}
	)
)

(instance desk of Feature
	(properties
		x 158
		y 105
		nsTop 91
		nsLeft 90
		nsBottom 120
		nsRight 227
		description {the counter}
		sightAngle 40
		lookStr {Across this counter pass the world's sharpest `blades!'}
	)
)

(instance box of Feature
	(properties
		x 205
		y 144
		nsTop 133
		nsLeft 188
		nsBottom 156
		nsRight 223
		description {the box}
		sightAngle 40
		lookStr {A wooden crate resides incongruously in the center of the floor.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 790 31) ; "Although you find the small wooden crate precious, you really have no desire to carry it with you throughout the rest of the game."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Ivana_b of Talker
	(properties
		name {Ivana}
		nsTop 15
		nsLeft 20
		view 1792
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust ivanaBust)
		(= eyes ivanaEyes)
		(= mouth ivanaMouth)
		(super init: &rest)
	)
)

(instance ivanaBust of Prop
	(properties
		view 1792
		loop 1
	)
)

(instance ivanaEyes of Prop
	(properties
		nsTop 41
		nsLeft 24
		view 1792
		loop 2
		cycleSpeed 30
	)
)

(instance ivanaMouth of Prop
	(properties
		nsTop 41
		nsLeft 24
		view 1792
		cycleSpeed 8
	)
)

(instance sitActions of Actions
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(18 ; Roller-skates
						(TPrint 790 32) ; "There's no place here to sit down--except that dirty box which might very well soil your pure white leisure suit. Perhaps you could find a place outside?"
					)
					(else
						(return 0)
					)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

