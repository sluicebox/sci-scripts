;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 224)
(include sci.sh)
(use Main)
(use enterScript)
(use n804)
(use Garbage)
(use n819)
(use Talker)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm224 0
)

(local
	local0 = -1
)

(instance rm224 of ApartmentRoom
	(properties
		lookStr 26
		picture 220
		style -32761
		east 200
		south 200
	)

	(method (init)
		(= global250 3)
		(= global251 1)
		(= global229 9)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 -10 319 -10 319 182 269 143 310 75 304 33 226 12 92 19 35 48 29 102 50 146 136 161 239 189
					yourself:
				)
			setRegions: 51 ; bubblesRegion
		)
		(super init: &rest)
		(if (not (IsFlag 49))
			(if (IsFlag 114)
				(seaTurtle init: view: 229 loop: 3 cel: 0)
			else
				(seaTurtle init:)
			)
		)
		(if (and (not (IsFlag 295)) (IsFlag 294))
			(fallBalloon init:)
		)
		(globe init:)
		(balloonOnGround init:)
		(bookcase init:)
		(gAddToPics
			add: plant wheel plant1 clock Bflag bed
			eachElementDo: #init
			doit:
		)
	)

	(method (notify)
		(gEgo setPri: 7)
		(HandsOn)
	)
)

(instance handOnString of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 2 0 0 26 1 self) ; Adam, "I'm gonna try to get that blockage out of your throat. Steady, now."
			)
			(1
				(gEgo hide:)
				(seaTurtle
					view: 229
					loop: 1
					cel: 0
					x: 70
					y: 91
					cycleSpeed: 15
					illegalBits: 0
					setCycle: CT 3 1 self
				)
			)
			(2
				(= cycles 19)
			)
			(3
				(seaTurtle cel: 2)
				(= cycles 20)
			)
			(4
				(seaTurtle cel: 3)
				(= cycles 20)
			)
			(5
				(SetScore 5 293)
				(SetFlag 114)
				(seaTurtle cel: 2)
				(= cycles 20)
			)
			(6
				(if (== register 3)
					(Narrator posn: -1 15 init: 3 0 0 88 self) ; "Adam pulls on the string. Boy! It's really in there!"
				else
					(Narrator posn: -1 15 init: 4 0 0 6 self) ; "Adam grasps the string with the tweezers and pulls. Boy! It's really in there!"
				)
			)
			(7
				(seaTurtle cycleSpeed: 15 setCycle: End self)
			)
			(8
				(gSoundEffects number: 215 loop: 1 play:)
				(seaTurtle view: 229 loop: 3 cel: 0 x: 70 y: 91)
				(= cycles 1)
			)
			(9
				(self setScript: fallOnBooty self)
			)
			(10
				(Narrator posn: -1 15 init: 3 0 0 89 self) ; "Well, that didn't help much! The string came off but whatever is stuck in the turtle's throat is still in there!"
			)
			(11
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance getBalloon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 2 1) init: 2 0 0 28 1 self) ; Adam, "Let's try this again! Open wide, now."
			)
			(1
				(SetScore 5 293)
				(gEgo hide:)
				(seaTurtle
					view: 229
					loop: 2
					cel: 0
					x: 70
					y: 91
					cycleSpeed: 15
					illegalBits: 0
					setCycle: CT 2 1 self
				)
			)
			(2
				(Narrator posn: -1 15 init: 3 0 0 90 self) ; "Adam uses the tweezers to reach carefully into the sea turtle's mouth and grasp the end of the object blocking his small throat."
			)
			(3
				(seaTurtle setCycle: End self)
			)
			(4
				(seaTurtle view: 229 loop: 3 cel: 0 posn: 70 91)
				(= cycles 1)
			)
			(5
				(SetScore 5 294)
				(gSoundEffects number: 216 loop: 1 play:)
				(fallBalloon
					illegalBits: 0
					view: 229
					setLoop: 5
					cel: 0
					posn: 87 103
					setPri: 5
					init:
					yStep: 2
					cycleSpeed: 15
					setCycle: ForwardCounter 3
					setMotion: MoveTo 87 125 fallBalloon
				)
				(self setScript: fallOnBooty self)
			)
			(6
				(Erroneous init: 1 0 0 1 1 self) ; "I say, that was terribly nice of you. I was having the most dreadful time breathing."
			)
			(7
				((ScriptID 2 1) init: 2 0 0 20 1 self) ; Adam, "That was a balloon I pulled out of your throat! Why'd you eat that?"
			)
			(8
				(Erroneous init: 1 0 0 2 1 self) ; "I mistook it for a particularly delectable dark comestible. My error - and a nearly fatal one. My throat, you see, is quite miniature. The rubbery texture of that balloon blocked it completely."
			)
			(9
				((ScriptID 2 1) init: 2 0 0 21 1 self) ; Adam, "They sometimes find huge whales who've been killed just by swallowing a little balloon."
			)
			(10
				(Erroneous init: 1 0 0 3 0 self) ; "Ah, yes, my equally small-throated brothers. But I get ahead of myself. I'm Erroneous, professor of most of the fish in these parts."
			)
			(11
				(Erroneous init: 1 0 0 8 1 self) ; "It's a pleasure to finally meet a human. I've taken quite a scholastic interest in you - as a species, that is."
			)
			(12
				((ScriptID 2 1) init: 2 0 0 22 1 self) ; Adam, "I noticed the flag. I'm Adam, and I actually find animals more interesting than humans - but maybe that's because I am one."
			)
			(13
				(Erroneous init: 1 0 0 4 1 self) ; "Ah, yes. We are often intrigued with the unknown."
			)
			(14
				((ScriptID 2 1) init: 2 0 0 23 1 self) ; Adam, "The Mayor sent me to tell the citizens about a meeting at the Council Chambers."
			)
			(15
				(Erroneous init: 1 0 0 5 0 self) ; "Well I shall certainly want to contribute to that ostentatious affair."
			)
			(16
				(Erroneous init: 1 0 0 9 1 self) ; "But first, let me persuade you to assume responsibility for these four little human objects I found. They might be troublesome if left floating about."
			)
			(17
				(seaTurtle
					view: 229
					loop: 3
					cel: 0
					x: 70
					y: 91
					cycleSpeed: 15
					setCycle: End self
				)
			)
			(18
				(gEgo setMotion: MoveTo 87 104 self)
			)
			(19
				(SetScore 2 297)
				(gEgo hide:)
				(seaTurtle
					view: 229
					loop: 4
					posn: 70 91
					cycleSpeed: 15
					setCycle: End self
				)
				(gEgo get: 18) ; screws
			)
			(20
				((ScriptID 2 1) init: 2 0 0 24 1 self) ; Adam, "Four metal screws?"
			)
			(21
				(Erroneous init: 1 0 0 6 1 self) ; "Yes, their size makes them particularly likely candidates for swallowing."
			)
			(22
				((ScriptID 2 1) init: 2 0 0 25 1 self) ; Adam, "I'll take care of them for you."
			)
			(23
				(Erroneous init: 1 0 0 7 1 self) ; "Well, I'll go join my fellow citizens now. Be well, my human friend. It's been a pleasure."
			)
			(24
				(NormalEgo)
				(gEgo show: setPri: 7)
				(gEgo setMotion: MoveTo 140 105 self)
				(seaTurtle
					view: 246
					loop: 4
					cel: 0
					cycleSpeed: 17
					setCycle: End self
				)
			)
			(25 0)
			(26
				(seaTurtle
					view: 246
					loop: 1
					cel: 0
					cycleSpeed: 20
					setCycle: End self
				)
			)
			(27
				(gEgo setHeading: 180 self)
			)
			(28
				(= cycles 12)
			)
			(29
				(seaTurtle
					setLoop: 3
					cycleSpeed: 11
					setCycle: Walk
					setMotion: MoveTo 333 210 self
				)
			)
			(30
				(SetFlag 49)
				(seaTurtle dispose:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallOnBooty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					show:
					setCycle: 0
					view: 221
					loop: 1
					cel: 8
					posn: 112 123
					setPri: 14
					cycleSpeed: 5
					setCycle: CT 4 -1 self
				)
			)
			(1
				(gLongSong2 number: 209 loop: 1 play:)
				(gEgo setCycle: CT 1 -1 self)
			)
			(2
				(gLongSong2 number: 209 loop: 1 play:)
				(gEgo setCycle: Beg self)
			)
			(3
				(gEgo cel: 5 posn: 135 126)
				(= cycles 1)
			)
			(4
				(NormalEgo)
				(gEgo posn: 125 113 setPri: 7)
				(= cycles 12)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance trashBalloon1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 97 99 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 229
					loop: 7
					cel: 0
					posn: 99 104
					cycleSpeed: 8
					setCycle: CT 5 1 self
				)
			)
			(2
				(fallBalloon dispose:)
				(SetScore 5 295)
				(gEgo setCycle: End self)
			)
			(3
				(NormalEgo)
				(gEgo posn: 94 102 setPri: 7)
				(= cycles 2)
			)
			(4
				(Narrator posn: -1 15 init: 3 0 0 5 self) ; "Adam picks up the deflated balloon and puts it into his garbage bag so that another animal doesn't swallow it."
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance trashBalloon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 210 104 self)
			)
			(1
				(gEgo
					setCycle: 0
					view: 229
					loop: 7
					cel: 0
					posn: 214 108
					cycleSpeed: 8
					setCycle: CT 5 1 self
				)
			)
			(2
				(balloonOnGround setFlag:)
				(balloonOnGround dispose:)
				(gEgo setCycle: End self)
			)
			(3
				(SetScore 5 296)
				(NormalEgo)
				(gEgo posn: 211 108 setPri: 7)
				(= cycles 2)
			)
			(4
				(Narrator posn: -1 15 init: 3 0 0 5 self) ; "Adam picks up the deflated balloon and puts it into his garbage bag so that another animal doesn't swallow it."
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance seaTurtle of Actor
	(properties
		x 70
		y 91
		view 229
		signal 20480
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 3 5 4 2 approachX: 87 approachY: 104 stopUpd:) ; Do, Talk, Inventory, Look
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 4 self) ; "The poor sea turtle appears to have something stuck in his throat. He's having trouble breathing."
				(if (not (IsFlag 114))
					(Narrator store: 97)
				)
			)
			(3 ; Do
				(if (IsFlag 114)
					(Narrator init: 3 0 0 65) ; "Now that the string is gone, there's nothing to pull on and Adam's hand is too big to reach into the sea turtle's mouth. He'll need to use something smaller to get at the blockage in the turtle's throat."
				else
					(gCurRoom setScript: handOnString 0 theVerb)
				)
			)
			(5 ; Talk
				(if (SetFlag 144)
					(Narrator init: 3 0 0 64) ; "The sea turtle can't talk to Adam while his throat is blocked."
				else
					(Narrator init: 3 0 0 64) ; "The sea turtle can't talk to Adam while his throat is blocked."
				)
			)
			(4 ; Inventory
				(switch invItem
					(14 ; tweezers
						(if (IsFlag 114)
							(gCurRoom setScript: getBalloon)
						else
							(gCurRoom setScript: handOnString 0 theVerb)
						)
					)
					(21 ; healingPotion
						(Narrator init: 3 0 0 95) ; "The sea turtle IS sick, but he doesn't need medicine - he needs to have that blockage in his throat removed."
					)
					(15 ; urchins
						(Narrator init: 3 0 0 93) ; "Those sea urchins can't help unblock the sea turtle's throat!"
					)
					(13 ; sharpShell
						(Narrator init: 3 0 0 94) ; "Adam will not need to cut anything to get the blockage out of the sea turtle's throat."
					)
					(else
						(Narrator init: 3 0 0 96) ; "That won't help the sea turtle."
					)
				)
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 103) ; "The turtle is a bit too large for the recycle sack. Besides, Adam is a sensitive kid! He wouldn't do that!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance balloonOnGround of Garbage
	(properties
		x 201
		y 132
		z 3
		view 229
		loop 6
		flag 39
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 66) ; "A red deflated balloon is lying on the floor. It looks like it came from the same bunch of red balloons that the boy on the cruise ship was playing with. So THAT'S what Adam saw in the courtyard!"
			)
			(3 ; Do
				(Narrator init: 3 0 0 98) ; "Adam should just throw the dangerous deflated balloon away."
			)
			(10 ; Recycle
				(gCurRoom setScript: trashBalloon2)
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 104) ; "Adam doesn't need to do anything with the deflated balloon except trash it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fallBalloon of Actor
	(properties
		x 87
		y 125
		view 229
		loop 6
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 67) ; "That's the balloon that Erroneous swallowed. It's a lucky thing for him that Adam got it out."
			)
			(3 ; Do
				(Narrator init: 3 0 0 98) ; "Adam should just throw the dangerous deflated balloon away."
			)
			(10 ; Recycle
				(gCurRoom setScript: trashBalloon1)
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 104) ; "Adam doesn't need to do anything with the deflated balloon except trash it."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(self setPri: 0 loop: 6 cel: 0)
	)
)

(instance bed of PicView
	(properties
		x 90
		y 130
		view 228
		priority 0
		signal 4113
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 73) ; "The shell bed looks quite comfortable."
			)
			(3 ; Do
				(Narrator init: 3 0 0 22) ; "Adam isn't the least bit tired."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Bflag of PicView
	(properties
		x 61
		y 91
		view 228
		loop 2
		cel 1
		priority 0
		signal 4113
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 68) ; "There's a flag of Great Britain on the wall. How curious."
			)
			(3 ; Do
				(Narrator init: 3 0 0 24) ; "Adam has no interest in taking the sea turtle's British flag."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance clock of PicView
	(properties
		x 126
		y 106
		view 228
		cel 1
		priority 0
		signal 4113
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 69) ; "How strange to see a Grandfather clock under the sea."
			)
			(3 ; Do
				(Narrator init: 3 0 0 21) ; "The clock is a little too heavy to be lugged around - even under water!"
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant1 of PicView
	(properties
		x 249
		y 122
		view 228
		loop 2
		priority 0
		signal 4113
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 11) ; "Sea vegetation decorates the apartment like potted plants."
			)
			(3 ; Do
				(Narrator init: 3 0 0 19) ; "Adam doesn't want to disturb the living sea plants. He knows the plants on the ocean floor are delicate and can be destroyed with even a gentle touch."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bookcase of Feature
	(properties
		x 231
		y 129
		z 48
		nsTop 66
		nsLeft 202
		nsBottom 96
		nsRight 261
		sightAngle 90
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (= local0 (mod (++ local0) 15))
					(0
						(Narrator init: 3 0 0 71) ; "The bookcase holds waterlogged copies of the Encyclopedia Britannica A-G as well as other more popular fish press titles."
					)
					(1
						(Narrator init: 3 0 0 74) ; "On the bookshelf Adam sees: "The Frugal Gourami""
					)
					(2
						(Narrator init: 3 0 0 75) ; "On the bookshelf Adam sees: "She Stoops to Conger""
					)
					(3
						(Narrator init: 3 0 0 76) ; "On the bookshelf Adam sees: "101 Cod Games""
					)
					(4
						(Narrator init: 3 0 0 77) ; "On the bookshelf Adam sees: "15 Days to Bigger Mussels""
					)
					(5
						(Narrator init: 3 0 0 78) ; "On the bookshelf Adam sees: "George Washingfin, the Flounder of our Country""
					)
					(6
						(Narrator init: 3 0 0 79) ; "On the bookshelf Adam sees: "Transactional Analysis in Grouper Therapy""
					)
					(7
						(Narrator init: 3 0 0 80) ; "On the bookshelf Adam sees: "The One-Minute Manatee""
					)
					(8
						(Narrator init: 3 0 0 81) ; "On the bookshelf Adam sees: "The Hunt for Red Octopus""
					)
					(9
						(Narrator init: 3 0 0 82) ; "On the bookshelf Adam sees: "Sign Language for the Herring Impaired""
					)
					(10
						(Narrator init: 3 0 0 83) ; "On the bookshelf Adam sees: "Scuba-diving for the Halibut""
					)
					(11
						(Narrator init: 3 0 0 84) ; "On the bookshelf Adam sees: "The Sole of a New Machine""
					)
					(12
						(Narrator init: 3 0 0 85) ; "On the bookshelf Adam sees: "Trout on a Limb""
					)
					(13
						(Narrator init: 3 0 0 86) ; "On the bookshelf Adam sees: "The Adventures of Hercule Pirahna""
					)
					(14
						(Narrator init: 3 0 0 87) ; "On the bookshelf Adam sees: "The Great Sardini""
					)
				)
			)
			(3 ; Do
				(Narrator init: 3 0 0 20) ; "The books would make for excellent reading, but they're more than a little water-logged."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance globe of Feature
	(properties
		x 221
		y 130
		z 34
		nsTop 49
		nsLeft 212
		nsBottom 65
		nsRight 230
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 72) ; "A world globe sits on top of the sea turtle's bookcase."
			)
			(3 ; Do
				(Narrator init: 3 0 0 23) ; "Adam has no interest in 'having the whole world in his hands'. His hands are full enough with Eluria's problems!"
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance wheel of PicView
	(properties
		x 260
		y 53
		view 228
		loop 1
		cel 1
		priority 0
		signal 4113
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(and
				(User canInput:)
				(not (gCurRoom script:))
				(!= (event type:) evVERB)
				(not (event modifiers:))
				(== (gTheIconBar curIcon:) (gTheIconBar at: 4))
				(== (gTheIconBar curInvIcon:) (Inv at: 18)) ; screws
			)
			(Narrator init: 3 0 0 105) ; "Erroneous asked Adam to take care of the screws. He doesn't want them back and they can't be used here."
			(event claimed: 1)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Narrator init: 3 0 0 70) ; "The sea turtle must like salvaging human items from the sea."
			)
			(3 ; Do
				(Narrator init: 3 0 0 25) ; "Adam looks appreciatingly at the old ship's wheel, but decides to leave it where it is."
			)
			(4 ; Inventory
				(Narrator init: 3 0 0 101) ; "Adam doesn't want to mess around with the sea turtle's things!"
			)
			(10 ; Recycle
				(Narrator init: 3 0 0 102) ; "The sea turtle wouldn't appreciate Adam's referring to his personal belongings as garbage!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plant of PicView
	(properties
		x 101
		y 185
		view 228
		loop 1
		priority 15
		signal 4113
	)

	(method (init)
		(proc804_8 self)
		(super init: &rest)
	)

	(method (doVerb theVerb invItem)
		(plant1 doVerb: theVerb invItem &rest)
	)
)

(instance Erroneous of Talker
	(properties
		nsTop 16
		nsLeft 10
		view 239
		viewInPrint 1
		charNum 13
		keepWindow 1
	)

	(method (init)
		(super init: eBust eEyes eMouth &rest)
	)
)

(instance eBust of Prop
	(properties
		view 239
		cel 1
	)
)

(instance eEyes of Prop
	(properties
		nsTop 10
		nsLeft 16
		view 239
		loop 2
		cycleSpeed 30
	)
)

(instance eMouth of Prop
	(properties
		nsTop 14
		nsLeft 10
		view 239
		loop 1
		cycleSpeed 10
	)
)

