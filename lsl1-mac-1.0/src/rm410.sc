;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm410 0
)

(instance rm410 of LLRoom
	(properties
		lookStr {You are in a quickie marriage parlor. A flashing neon sign on the rear wall asks: "Why wait? Marry the girl of your dreams today! You provide the girl, we'll do the rest for only $100!!"}
		picture 410
		south 400
	)

	(method (init)
		(LoadMany rsVIEW 411 413 410)
		(LoadMany rsSOUND 410 411 321)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 172 189 140 133 183 128 171 122 148 127 120 130 71 127 59 132 108 135 110 189
					yourself:
				)
		)
		(window1 init:)
		(window2 init:)
		(window3 init:)
		(pew1 init:)
		(pew2 init:)
		(bouquet init:)
		(candelabra init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(candelabra2 init: approachVerbs: 3 4 10 11 5 2) ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		(fSign init:)
		(rightCandle
			cycleSpeed: global101
			setCycle: RandCycle
			init:
			approachVerbs: 3 4 10 11 5 2 ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		)
		(leftCandle
			cycleSpeed: global101
			setCycle: RandCycle
			init:
			approachVerbs: 3 4 10 11 5 2 ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
		)
		(if gDebugging
			(SetFlag 32)
		)
		(if (IsFlag 32)
			(fawn init: setLoop: 3 setCel: 0 x: 117 y: 135 stopUpd:)
			(preacherHead cycleSpeed: global101 init:)
			(aPreacher cycleSpeed: global101 moveSpeed: global101 init:)
			(gEgo x: 137 init:)
		else
			(gEgo x: 137 y: 170 init:)
		)
		(gTheMusic number: 410 vol: 127 loop: -1 flags: 1 play:)
		(gTheMusic3 loop: 1 flags: 1)
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (not script) (IsFlag 32))
			(gCurRoom setScript: sGetMarried)
		)
	)

	(method (dispose)
		(super dispose:)
		(gTheMusic fade:)
	)
)

(instance sGetMarried of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not (IsFlag 8))
					(Print 410 0 #at -1 19 #width 280) ; "Your heart fills with eager anticipation as you see your lovely bride, Fawn, waiting for you at the end of the aisle. You've always been a sucker for beautiful weddings and you feel sure that this will be your most special wedding of all!"
				)
				(gEgo setMotion: PolyPath 136 133 self)
			)
			(1
				(Face gEgo aPreacher)
				(= cycles 4)
			)
			(2
				(gEgo hide:)
				(fawn hide:)
				(egoAtAlter init: setCycle: End)
				(if (IsFlag 8)
					(Print 410 1 #at -1 20) ; "So... shall we try again?"
					(Print 410 2 #at 120 30) ; ""Yes, that's why I came back in," you reply."
					(Print 410 3 #at 120 30) ; "To Fawn you whisper, "Thanks for waiting, Babe!""
					(Print 410 4 #at 15 30) ; "Fawn replies, "It's okay, Larry. The preacher entertained me while you were gone!""
				)
				(preacherHead setCycle: RandCycle 35 self)
				(aPreacher setLoop: 3 setCycle: ForwardCounter 7)
			)
			(3
				(egoAtAlter stopUpd:)
				(Print 410 5 #at -1 20) ; "Dearly beloved, we are gathered together today in the sight of, er, ah, um... each other, to enter these two people into the eternal bonds of marriage."
				(preacherHead setCycle: RandCycle 35 self)
				(aPreacher setCycle: ForwardCounter 7)
			)
			(4
				(Print 410 6 #at -1 19 #width 280) ; "But before we really get rollin', I'd like to say a few words. Many's the marriage that I've performed here, in this little chapel, wearing this cheap suit, before those shiny plastic-covered pews, with these electric candles, looking at those genuine Plexiglas stained-glass windows, for these measly few bucks..."
				(= seconds 3)
			)
			(5
				(Print 410 7 #at -1 140) ; "(He pauses for another nip from his pocket flask.)"
				(aPreacher setLoop: 2 setCel: 0 setCycle: Beg self)
			)
			(6
				(Print 410 8 #at -1 20) ; ""Where was I?" he hiccups."
				(Print 410 9 #at 120 30) ; ""Digressing," you answer."
				(= seconds 3)
			)
			(7
				(aPreacher setLoop: 0)
				(preacherHead setCycle: RandCycle 20 self)
			)
			(8
				(Print 410 10 #at -1 20) ; ""Oh, well, have you got a ring?" he asks."
				(= seconds 3)
			)
			(9
				(Print 410 11 #at 120 30) ; "Yep," you reply. "She's wearing it."
				(preacherHead setCycle: RandCycle 15 self)
			)
			(10
				(Print 410 12 #at -1 20) ; "Good enough for me! Have you got a hundred bucks?"
				(= seconds 3)
			)
			(11
				(cond
					((== gLarryDollars 100)
						(Print 410 13 #at 120 30) ; "Oh, oh. I've got EXACTLY a hundred dollars," you cry, "Once we're married, I'm sure Fawn will be glad to support us!"
						(Print 410 14 #at 15 30) ; "Not on your life, Larryberry. Get back out on those streets and bring back some dough!"
						(Print 410 15 #at -1 20) ; ""Kill the music," the preacher shouts."
						(gTheMusic stop:)
						(Print 410 16) ; "Shrugging your shoulders in defeat, you head sadly down the aisle--all alone!"
						(gEgo
							show:
							setCycle: Walk
							setMotion: PolyPath 136 175 self
						)
						(fawn show: loop: 2 cel: 4)
						(egoAtAlter dispose:)
						(self changeState: 22)
					)
					((< gLarryDollars 100)
						(self changeState: 17)
					)
					(else
						(SetFlag 12)
						(Print 410 17 #at 120 30) ; ""Of course," you reply, forking over some of your hard-won dough."
						(-= gLarryDollars 100)
						(preacherHead setCycle: RandCycle 35 self)
					)
				)
			)
			(12
				(Print 410 18 #at -1 20) ; "Ok, now where were we? Oh, let's see here... let me skip some of this..."
				(Print 410 19 #at -1 20) ; "Oh well, let's cut to the chase. I now pronounce you man and wife, till death do you part, or until you get tired of each other, per the currently acceptable social standards!"
				(Points 71 12)
				(ClearFlag 32)
				(ClearFlag 8)
				(preacherHead setCycle: RandCycle 20 self)
			)
			(13
				(gTheMusic number: 411 vol: 127 loop: -1 flags: -1 play:)
				(Print 410 20 #at -1 20) ; ""You may kiss the bride," says the preacher."
				(Print 410 21 #at 120 30) ; ""(Oh, boy!)" you think."
				(Print 410 22) ; "And with that he disappears behind the altar to refill his flask."
				(aPreacher dispose:)
				(preacherHead dispose:)
				(Print 410 23) ; "Not now," says Fawn. "That kissing stuff can wait. I've got much better things in mind for us, Larry!"
				(Print 410 24 #at 15 30) ; "I'll go to our room right now and get everything ready for our big night," says Fawn knowingly. "You meet me at the Casino Hotel's Honeymoon Suite as soon as you can and I'll give you much more than kisses, my passionate polyester peacock!!"
				(gEgo show: loop: 2)
				(fawn
					show:
					loop: 2
					setCycle: Walk
					cycleSpeed: (+ 1 global101)
					moveSpeed: (+ 1 global101)
					setMotion: MoveTo 136 247 self
				)
				(egoAtAlter dispose:)
				(= seconds 3)
			)
			(14
				(Print 410 25 #at 120 30) ; "Hey!" you shout, "Wait for me!!"
				(= seconds 3)
			)
			(15
				(Print 410 26) ; "Somehow this entire ceremony was less than you expected. The sacred bonds of marriage certainly get tied loosely in this joint!"
			)
			(16
				(SetFlag 11)
				(HandsOn)
				(self dispose:)
			)
			(17
				(preacherHead setCycle: RandCycle 10 self)
			)
			(18
				(if (IsFlag 8)
					(Print 410 27 #at -1 20) ; "So?" the preacher asks sarcastically, "Did you bring the cash with you THIS time?"
					(Print 410 28 #at 120 30) ; ""Well, er, ah, no, I'm sorry. I suppose I forgot," you reply."
					(Print 410 29 #at -1 20) ; "I told you, buddy, come back with 100 cold, hard ones!"
					(gEgo
						show:
						setCycle: Walk
						setMotion: PolyPath 136 175 self
					)
					(fawn show: loop: 2 cel: 4)
					(egoAtAlter dispose:)
					(self changeState: 22)
				else
					(SetFlag 8)
					(Print 410 30 #at 120 30) ; "Not me," you reply. "I thought this was a temple of love!"
					(Print 410 31 #at -1 20) ; ""Sorry, buddy, you two are SOL until you can come back here with 100 cold, hard ones!" he says indignantly."
				)
				(Print 410 15 #at -1 20) ; ""Kill the music," the preacher shouts."
				(gTheMusic stop:)
				(= seconds 3)
			)
			(19
				(Print 410 32) ; "Gee, Larry! It looks like you have to leave your new bride waiting at the altar, while you generate a little positive cash flow!"
				(Print 410 33 #at 15 30) ; "As you leave, Fawn sighs under her breath, "Hurry back, Larry. I don't know how long I can wait before I have you!""
				(gEgo show: setCycle: Walk setMotion: PolyPath 136 175 self)
				(fawn show: loop: 2 cel: 4)
				(egoAtAlter dispose:)
			)
			(20
				(Print 410 34 #at 15 30) ; "By the way, Larry," she asks. "What does SOL stand for?"
				(Face gEgo fawn)
				(= seconds 3)
			)
			(21
				(Print 410 35 #at 120 30) ; ""Why, Sierra On-Line, I presume!" you respond."
				(gTheMusic3 number: 321 play:)
				(Print 410 36 #at -1 140) ; "(Drum fill)"
				(= seconds 2)
			)
			(22
				(Print 410 37 #at 120 30) ; "Wait here, Fawn baby! I'll be back in a flash!!"
				(gEgo setMotion: PolyPath 136 247 self)
			)
			(23
				(gCurRoom newRoom: 400)
			)
		)
	)
)

(instance preacherHead of Prop
	(properties
		view 413
		loop 1
	)

	(method (doit)
		(super doit:)
		(if (OneOf (aPreacher loop:) 0 3)
			(preacherHead x: (- (aPreacher x:) 1) y: (aPreacher y:) z: 27)
		else
			(preacherHead z: 1000)
		)
	)

	(method (doVerb theVerb invItem)
		(aPreacher doVerb: theVerb invItem)
	)
)

(instance aPreacher of Actor
	(properties
		x 127
		y 118
		description {Reverend Al}
		lookStr {He looks a lot like his brother, that bad comedian in the Lizard Lounge.}
		view 413
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 410 38) ; "Make up your mind, son. Time is money!"
				(Print 410 39 #at -1 140) ; "(What an old romantic!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fawn of Actor
	(properties
		x 119
		y 134
		description {Fawn}
		sightAngle 40
		view 612
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 410 40) ; "Fawn is waiting for you at the altar. Go for it, Larry!"
			)
			(5 ; Talk
				(Print 410 41) ; ""Fawn, I think I love you!" you cry."
				(Print 410 42) ; ""Good enough," she replies cryptically."
			)
			(3 ; Do
				(Print 410 43) ; ""There'll be time enough for that later," she smiles."
			)
			(10 ; Zipper
				(Print 410 44) ; ""Yeah, I know. I can hardy wait too, Larry," she smiles."
			)
			(11 ; Taste/Smell
				(Print 410 45) ; "Fawn smells of that new perfume, "Floppies.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance egoAtAlter of Prop
	(properties
		x 123
		y 133
		view 411
		signal 16384
	)
)

(instance rightCandle of Prop
	(properties
		x 181
		y 74
		description {the candle}
		sightAngle 40
		approachX 160
		approachY 130
		lookStr {You can barely tell they're made from pressed sawdust.}
		view 410
		loop 1
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 46) ; "You hold your hand in the flame."
				(Print 410 47) ; "OUCH!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance leftCandle of Prop
	(properties
		x 69
		y 76
		description {the candle}
		sightAngle 40
		approachX 95
		approachY 134
		lookStr {You can barely tell they're made from pressed sawdust.}
		view 410
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 46) ; "You hold your hand in the flame."
				(Print 410 47) ; "OUCH!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance window1 of Feature
	(properties
		x 274
		y 84
		nsTop 52
		nsLeft 259
		nsBottom 117
		nsRight 289
		description {the window}
		sightAngle 40
		lookStr {You can't see through the "stained glass" windows. They're fake, like everything else about this place.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance window2 of Feature
	(properties
		x 217
		y 82
		nsTop 52
		nsLeft 206
		nsBottom 112
		nsRight 228
		description {the window}
		sightAngle 40
		lookStr {You can't see through the "stained glass" windows. They're fake, like everything else about this place.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance window3 of Feature
	(properties
		x 29
		y 82
		nsTop 55
		nsLeft 11
		nsBottom 109
		nsRight 48
		description {the window}
		sightAngle 40
		lookStr {You can't see through the "stained glass" windows. They're fake, like everything else about this place.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fSign of Feature
	(properties
		x 112
		y 30
		nsTop 17
		nsLeft 77
		nsBottom 44
		nsRight 148
		description {the sign}
		sightAngle 40
		lookStr {You are in a quickie marriage parlor. A flashing neon sign on the rear wall asks: "Why wait? Marry the girl of your dreams today! You provide the girl, we'll do the rest for only $100!!"}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pew1 of Feature
	(properties
		x 234
		y 144
		nsTop 117
		nsLeft 152
		nsBottom 172
		nsRight 317
		description {the pew}
		sightAngle 40
		lookStr {It seems everything here is covered in plastic.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 48) ; "The plastic covers are so slick, you'd probably slide right off."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pew2 of Feature
	(properties
		x 50
		y 156
		nsTop 124
		nsBottom 189
		nsRight 100
		description {the pew}
		sightAngle 40
		lookStr {It seems everything here is covered in plastic.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 48) ; "The plastic covers are so slick, you'd probably slide right off."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bouquet of Feature
	(properties
		x 118
		y 114
		z 58
		nsTop 41
		nsLeft 83
		nsBottom 72
		nsRight 153
		description {the bouquet}
		sightAngle 40
		lookStr {A lovely artificial bouquet resides about an artificial mantle above an artificial fireplace /altar.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 49) ; "You don't need more plastic things in your life."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance candelabra of Feature
	(properties
		x 72
		y 131
		nsTop 71
		nsLeft 59
		nsBottom 126
		nsRight 85
		description {the candelabra}
		sightAngle 40
		approachX 95
		approachY 134
		lookStr {If you don't look too closely, you can barely see the wires running up the inside of the PVC tubing.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 50) ; "Who are you? Liberace?!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance candelabra2 of Feature
	(properties
		x 179
		y 93
		nsTop 64
		nsLeft 170
		nsBottom 122
		nsRight 188
		description {the candelabra}
		sightAngle 40
		approachX 160
		approachY 130
		lookStr {If you don't look too closely, you can barely see the wires running up the inside of the PVC tubing.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 410 50) ; "Who are you? Liberace?!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

