;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 600)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use RandCycle)
(use MCyc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm600 0
)

(local
	bouncerTalks
	seenBouncer
	gaveRing
	[MBRPOINTS 33] = [1 1 184 136 1 2 180 136 1 3 173 136 1 4 173 136 1 5 173 136 1 6 173 136 1 7 173 136 1 8 173 136 -32768]
	[MBLPOINTS 29] = [1 7 173 136 1 6 173 136 1 5 173 136 1 4 173 136 1 3 173 136 1 2 180 136 1 1 184 136 -32768]
)

(instance rm600 of LLRoom
	(properties
		picture 600
		north 610
		east 170
		west 500
	)

	(method (init)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 22 146 55 146 55 155 22 155
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 241 143 265 143 265 147 241 147
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 168 0 168 122 188 127 200 141 112 141 94 137 60 137 57 132 0 132
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 192 122 192 0 319 0 319 117 277 117 280 140 208 140
					yourself:
				)
		)
		(switch gPrevRoomNum
			(500
				(self style: 41)
				(if (< (gEgo y:) 135)
					(gEgo y: 135)
				)
			)
			(610
				(HandsOff)
				(gTheMusic3 fade:)
				(gEgo init: posn: 190 64)
				(self setScript: sFromDisco)
			)
			(170
				(gEgo y: 145)
			)
			(200 0)
			(else
				(gEgo posn: 160 160)
			)
		)
		(gEgo init:)
		(discoThump play:)
		(bouncer cycleSpeed: global101 init: approachVerbs: 3 4 10 11 5 11 10) ; Do, Inventory, Zipper, Taste/Smell, Talk, Taste/Smell, Zipper
		(firePlug init:)
		(disco init:)
		(darkAlley init:)
		(artGallery init:)
		(lights init:)
		(super init:)
		(self setRegions: 700) ; sidewalk
	)

	(method (doit)
		(super doit: &rest)
		(cond
			(script)
			((< (gEgo y:) 122)
				(if (> (gEgo x:) 240)
					(gCurRoom newRoom: 170)
				else
					(HandsOff)
					(self setScript: sToDisco)
				)
			)
		)
		(if
			(and
				(== seenBouncer 0)
				(gEgo inRect: 140 137 225 145)
				(== (gCurRoom script:) 0)
			)
			(= seenBouncer 1)
			(gCurRoom setScript: sBouncer)
		)
		(if
			(and
				seenBouncer
				(not (gEgo inRect: 140 137 225 145))
				(== (gCurRoom script:) 0)
			)
			(= seenBouncer 0)
		)
	)

	(method (dispose)
		(gTheMusic fade:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 600 0) ; "Gazing up at the storefronts before you, a deep, strange, mystical feeling comes over you. Surely every one of the windows looking down on the city has a wonderful, lonely story hidden behind it. There are millions of stories here in Lost Wages, but you'll never know any of them. Such is the fate of those who are morally-weak, but financially-strong."
				(Print 600 1 #at -1 140) ; "(What the hell was THAT all about?!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sFromDisco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bouncer setLoop: 1 setCel: 8 x: 173 y: 136)
				(= cycles 1)
			)
			(1
				(gEgo
					ignoreActors: 1
					posn: 190 64
					setMotion: PolyPath 190 150 self
				)
			)
			(2
				(HandsOn)
				(gEgo ignoreActors: 0)
				(bouncer setCycle: MCyc @MBLPOINTS self)
			)
			(3
				(bouncer setLoop: 0 x: 174 y: 136 setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sToDisco of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 177 64 self)
			)
			(1
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sBouncer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(Face gEgo bouncer)
				(bouncerHead
					init:
					cycleSpeed: global101
					setCycle: RandCycle 20 self
				)
			)
			(1
				(Print 600 2 #at -1 20) ; ""Halt!!" says the bouncer."
				(Print 600 3 #at -1 20) ; "I'm sorry, sir, but this is a private club."
				(= cycles 1)
			)
			(2
				(gEgo setMotion: PolyPath (gEgo x:) 146 self)
			)
			(3
				(HandsOn)
				(bouncerHead dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sCard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo bouncer)
				(= cycles 10)
			)
			(1
				(gEgo moveHead: 0)
				(Points 95 5)
				(Print 600 4) ; "You whip out your "borrowed" membership card, and lay it on him."
				(= cycles 10)
			)
			(2
				(gEgo
					view: 601
					setLoop: 0
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= cycles 10)
			)
			(4
				(Print 600 5) ; "Here ya go, lil' buddy," you tell the bouncer, "I'll just go on in now, ok?"
				(= cycles 10)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(bouncerHead
					init:
					cycleSpeed: global101
					setCycle: RandCycle 20 self
				)
				(bouncer setLoop: 1 setCel: 0 x: 184 y: 136 setCycle: CT 1)
			)
			(7
				(Print 600 6 #at -1 20) ; "Good evening, Sir. I'm so sorry I didn't recognize you sooner. Please, come right in!!"
				(= cycles 10)
			)
			(8
				(bouncerHead dispose:)
				(bouncer setCycle: MCyc @MBRPOINTS self)
			)
			(9
				(NormalEgo)
				(gEgo ignoreActors: 1 setMotion: PolyPath 190 90 self)
			)
			(10
				(gEgo moveHead: 1)
				(= cycles 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sDiamond of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Face gEgo bouncer)
				(= cycles 1)
			)
			(1
				(Print 600 7) ; ""Here, take this diamond ring," you tell the bouncer."
				(= cycles 1)
			)
			(2
				(bouncerHead
					init:
					cycleSpeed: (+ 2 global101)
					setCycle: RandCycle 20 self
				)
			)
			(3
				(Print 600 8 #at -1 20) ; "Gee, thanks, buddy!" he says. "Go right on in!"
				(bouncerHead dispose:)
				(= cycles 1)
			)
			(4
				(bouncer
					setLoop: 1
					setCel: 1
					x: 184
					y: 136
					setCycle: MCyc @MBRPOINTS self
				)
			)
			(5
				(gEgo ignoreActors: 1 setMotion: PolyPath 190 90 self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance bouncerHead of Prop
	(properties
		view 602
		loop 2
		priority 10
		signal 16400
	)

	(method (init)
		(super init:)
		(if (== (bouncer loop:) 0)
			(bouncerHead x: (+ (bouncer x:) 2) y: (bouncer y:) z: 39 species)
		else
			(bouncerHead x: (- (bouncer x:) 8) y: (bouncer y:) z: 39 species)
		)
	)
)

(instance bouncer of Person
	(properties
		x 174
		y 136
		description {Pickhinke}
		sightAngle 20
		approachX 190
		approachY 153
		view 602
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (== gPrevRoomNum 610)
					(Print 600 9) ; "The bouncer seems happy to see you leave."
				else
					(Print 600 10) ; "The bouncer is physically well-developed, but you feel sure he's not as wise as you are in the ways of women."
				)
			)
			(3 ; Do
				(Print 600 11) ; "Larry! How could you be so foolish! You can't pick a fight with a dude as tough as Pickhinke!"
				(Print 600 12 #at -1 140) ; "(You know he'd beat you to a pulp!)"
			)
			(5 ; Talk
				(if (== gPrevRoomNum 610)
					(Print 600 13 #at -1 20) ; "On behalf of our entire Disco staff, I'd like to express our appreciation for your patronage this evening. We hope you enjoyed your visit, Sir!"
					(Print 600 14 #at -1 140) ; "(Boy, has his tune changed, eh Larry?)"
				else
					(Print 600 15) ; "This disco looks like a very swinging place," you say to Pickhinke, "how's about letting me in?"
					(Print 600 16 #at -1 20) ; "Either show your membership card, or get lost, Scum-Breath!"
					(Print 600 17 #at -1 140) ; "(It seems he's uninterested in idle chit-chat, Larry.)"
				)
			)
			(10 ; Zipper
				(Print 600 18) ; "Excuse me, sir," you say to the bouncer, "but I really have to use the restroom. Would it be okay for me to use the one inside?"
				(Print 600 19 #at -1 20) ; ""Nope," he replies, succinctly."
			)
			(11 ; Taste/Smell
				(Print 600 20) ; "The bouncer smells of stale gymnasiums and vinyl exercise benches."
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(Print 600 21) ; ""How's about a little green sliding across your palm?" you ask the bouncer."
						(Print 600 22 #at -1 20) ; ""How's about your little butt sliding across the pavement?" he replies."
					)
					(1 ; breathSpray
						(Print 600 23) ; "Psst. Psst."
						(Print 600 24 #at -1 20) ; "Hey, get that crap away from me!"
					)
					(2 ; watch
						(Print 600 25) ; ""Wanna know what time it is?" you ask the bouncer."
						(Print 600 26 #at -1 20) ; "Time for you to get lost, Creep!"
					)
					(3 ; apple
						(Print 600 27) ; ""Wanna nibble on my fruit?" you ask the bouncer."
						(Print 600 28 #at -1 20) ; ""Wanna taste of my knuckles?" he responds."
					)
					(4 ; ring
						(gEgo put: 4) ; ring
						(gCurRoom setScript: sDiamond)
					)
					(5 ; whiskey
						(Print 600 29) ; ""How's about a little drink, buddy?" you ask the bouncer."
						(Print 600 30 #at -1 20) ; ""I never drink when I'm on duty," Pickhinke replies."
					)
					(7 ; rose
						(Print 600 31) ; "Peace, Love"
						(Print 600 32) ; "Piece this!"
					)
					(8 ; lubber
						(Print 600 33) ; "Have you ever made a balloon out one of these?"
						(Print 600 34) ; "Pickhinke ignores you completely."
					)
					(9 ; candy
						(Print 600 35) ; "Wanna nibble on my num nums?"
						(Print 600 36 #at -1 20) ; "You gotta be kiddin!"
					)
					(11 ; pocketKnife
						(Print 600 37) ; "Your attempt to stab the bouncer is foolish. He handles tough guys for a living."
					)
					(12 ; wine
						(Print 600 29) ; ""How's about a little drink, buddy?" you ask the bouncer."
						(Print 600 38 #at -1 20) ; ""I never drink when I'm on duty," he replies."
					)
					(13 ; magazine
						(Print 600 39) ; "Take a look at these!"
						(Print 600 40 #at -1 20) ; ""Man, I got better than that waiting at home," he replies."
					)
					(15 ; pills
						(Print 600 41) ; ""May I offer you one of these breath mints?" you ask the bouncer."
						(Print 600 42) ; "Right. Sure. Do I look stupid?"
						(Print 600 43 #at -1 140) ; "(Don't answer that, Larry! It may be a trick question.)"
					)
					(10 ; discoPass
						(gCurRoom setScript: sCard)
					)
					(17 ; graffiti
						(Print 600 44) ; ""Who's Ken?" barks the bouncer."
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

(instance firePlug of Feature
	(properties
		x 39
		y 141
		nsTop 129
		nsLeft 29
		nsBottom 153
		nsRight 50
		description {the fire plug}
		sightAngle 40
		lookStr {Why doesn't that dog use this fireplug instead of you?}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 600 45) ; "Try as you might, you are unable to "turn on" the fireplug."
			)
			(10 ; Zipper
				(Print 600 45) ; "Try as you might, you are unable to "turn on" the fireplug."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance disco of Feature
	(properties
		x 170
		y 30
		nsLeft 82
		nsBottom 139
		nsRight 258
		description {the disco sign}
		sightAngle 40
		lookStr {You are outside a flashy disco with an unhappy bouncer.}
	)
)

(instance lights of Feature
	(properties
		x 176
		y 36
		nsTop 16
		nsLeft 81
		nsBottom 56
		nsRight 272
		description {the lights}
		sightAngle 40
		lookStr {Gaudy, aren't they?}
	)
)

(instance artGallery of Feature
	(properties
		x 39
		y 65
		nsBottom 131
		nsRight 79
		description {the art gallery}
		sightAngle 40
		lookStr {The Lost Wages Art Emporium will satisfy your every need for modern art, as long as you're looking for something with dead fish!}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 600 46) ; "The locked gate effectively prevents you from gaining the cultural enlightenment you so desire."
			)
			(5 ; Talk
				(Print 600 47) ; "You have no wish to talk to a bunch of paintings."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance darkAlley of Feature
	(properties
		x 294
		y 136
		z 69
		nsLeft 270
		nsBottom 135
		nsRight 319
		description {the dark alley}
		sightAngle 40
		lookStr {You're not sure, but you think you hear cries of "Help" coming from that dark alley over there.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 600 48) ; "Hello!" you cry into the darkness, "is there anybody back there?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance discoThump of Sound
	(properties
		flags 1
		number 600
		loop -1
	)
)

