;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use CycleBet)
(use BalloonTalker)
(use invCode)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
	guyBehindRock 1
	nathenTalker 2
	benBoyTalker 3
)

(local
	local0 = 1
	local1
	local2 = 1
	local3 = 1
	local4
)

(instance rm500 of ADRoom
	(properties
		noun 8
		picture 500
		vanishingY -60
	)

	(method (init)
		(gEgo actions: aEgoActions normalize:)
		(super init: &rest)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 0 189 0 120 55 108 213 108 302 126 308 100 171 91 161 77 171 62 127 58 83 57 65 60 61 74 34 78 52 99 48 108 0 117 0 0 319 0
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 75 73 146 70 170 97 156 102 143 106 107 106 68 105 55 86
					yourself:
				)
		)
		(rmSound number: 500 loop: -1 play:)
		(gInventory
			addAfter:
				(gInventory at: 44) ; Wood_Cutting_c
				(invPicnicCloth init: yourself:)
				(invBensClothes init: yourself:)
		)
		(ethan init: stopUpd:)
		(darcy init: stopUpd:)
		(ben init: approachVerbs: 85 7 6 86 30 89 setCycle: Fwd) ; Talk, Do, Look, Nose, Paw, Teeth
		(ship init: setLoop: 4 setMotion: MoveTo 46 40)
		(ship2 init:)
		(picnicCloth init:)
		(harbor init: setOnMeCheck: 1 16384)
		(hidingRock init: setOnMeCheck: 1 8192 approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(tree init: setOnMeCheck: 1 4096)
		(pond init: setOnMeCheck: 1 1024)
		(rocks init: setOnMeCheck: 1 512)
		(waterWeeds init: setOnMeCheck: 1 2048 approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(gCurRoom setScript: sCartoon)
	)

	(method (dispose)
		(gInventory delete: invPicnicCloth delete: invBensClothes)
		(invPicnicCloth dispose:)
		(invBensClothes dispose:)
		(gTheIconBar curInvIcon: 0)
		(super dispose:)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 231 y: 1097 init:)
				(= cycles 1)
			)
			(1
				(= seconds 4)
			)
			(2
				(ben stopUpd:)
				(ethan stopUpd:)
				(gMessager say: 10 0 8 1 8 self) ; "I dunno, Ethan, my theory was not quite correct. I swim faster with the paddles, but they wear me out! I'm dog-tired!"
			)
			(3
				(rmSound number: 501 loop: -1 play:)
				(= cycles 1)
			)
			(4
				(gMessager say: 10 0 8 9 self) ; "BEN FRANKLIN, I AM THE GHOST OF PANAMA PETE! I'VE TAKEN YOUR CLOTHES TO WARM MY COLD, WHITE BONES!"
			)
			(5
				(darcy view: 501 loop: 1 posn: 144 83 setCycle: CT 4 1 self)
			)
			(6
				(darcy setCycle: CycleBet 4 10 2 self)
			)
			(7
				(darcy setCycle: End self)
			)
			(8
				(darcy stopUpd:)
				(= cycles 2)
			)
			(9
				(gMessager say: 10 0 8 10 self) ; "YIKES!!!"
			)
			(10
				(ethan
					view: 501
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo -20 115 self
				)
			)
			(11
				(ethan dispose:)
				(gMessager say: 10 0 8 11 19 self) ; "<Sigh.> Darcy Hancock, you goose, I should have guessed 'twas you behind this mischief. Come out from behind that rock and give me my clothes!"
			)
			(12
				(sFX number: 929 play:)
				(gEgo
					view: 803
					loop: 2
					cel: 0
					x: 198
					y: 109
					setCycle: End self
				)
			)
			(13
				(darcy setMotion: MoveTo (darcy x:) 86 self)
			)
			(14
				(ben startUpd:)
				(gEgo
					normalize: 790
					x: (- (gEgo x:) 6)
					illegalBits: -32768
				)
				(darcy stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveBenClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 417 1)
				(= cycles 3)
			)
			(1
				(gEgo put: 46 setMotion: PolyPath 179 107 self)
			)
			(2
				(gEgo view: 805 loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(bensClothes x: 153 y: 112 init:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gMessager say: 2 43 2 1 2 self) ; "Here you go, Ben."
			)
			(5
				(gEgo setMotion: PolyPath 93 71 self)
			)
			(6
				(gEgo stopUpd:)
				(gMessager say: 2 43 2 3 self) ; "Uh, er, ah, I'll just wait for you behind this rock!"
			)
			(7
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sGetClothes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 416 1)
				(= local4 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo
					view: 805
					loop: 1
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(2
				((ScriptID 2000 3) winX: 117 winY: 73 tailPosn: 3) ; PepperTalker
				(gMessager say: 1 7 1 0 self) ; "I'll just, er, pick up your clothes, Ben. (Yikes! He's nekkid in there!)"
			)
			(3
				(gGame handsOn:)
				(gEgo normalize: get: 46 setSpeed: local4)
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(bensClothes dispose:)
				(self dispose:)
			)
		)
	)
)

(instance s502_503_Sound of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rmSound number: 502 setLoop: 1 play: self)
			)
			(1
				(rmSound number: 503 setLoop: 1 play: self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sHandOnTableCloth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 414 1)
				(= local4 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(gEgo get: 45 setMotion: PolyPath 232 100 self)
			)
			(2
				(gMessager say: 11 7 9 0 self) ; "Oh, man, this thing is NASTY!"
			)
			(3
				(gEgo
					view: 803
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(picnicCloth dispose:)
				(gEgo setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(gEgo normalize: illegalBits: -32768 setSpeed: local4)
				(self dispose:)
			)
		)
	)
)

(instance sPutOnTableCloth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local4 (gEgo cycleSpeed:))
				(= cycles 1)
			)
			(1
				(if
					(or
						(& (gEgo onControl: 1) $0002)
						(& (gEgo onControl: 1) $0020)
					)
					(gEgo setMotion: PolyPath 45 76 self)
				else
					(= cycles 1)
				)
				(gMessager say: 5 42 0 1 self) ; "(MUTTERS) How 'bout a taste of your own medicine, you big dork?"
			)
			(2 0)
			(3
				(gEgo
					view: 502
					loop: 0
					cel: 0
					put: 45
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gEgo
					view: 502
					loop: 1
					cel: 0
					posn: (- (gEgo x:) 1) (+ (gEgo y:) 6)
					setCycle: End self
				)
			)
			(5
				(gMessager say: 5 42 0 2 self) ; "|c2|OOOOWOOOOOOO! Who dares use MY name? Whooo daaaares?!?|c|"
			)
			(6
				(rmSound number: 502 setLoop: 1 play:)
				(guyBehindRock winX: 142 winY: 80 tailPosn: 3)
				(gMessager say: 5 42 0 3 8 self) ; "Wha--?"
			)
			(7
				(gEgo setCycle: CycleBet 0 3 3)
				(darcy view: 502 setLoop: 2 setCycle: End self)
			)
			(8
				(bensClothes init:)
				(darcy setCycle: CT 2 -1 self)
			)
			(9
				(gMessager say: 5 42 0 9 10 self) ; "MOMEEEEEEE!"
			)
			(10
				(rmSound number: 503 setLoop: 1 play:)
				(= local1 1)
				(darcy
					view: 502
					setLoop: 4
					cel: 0
					posn: 131 84
					ignoreActors: 1
					setSpeed: 3
					setCycle: Walk
					setMotion: MoveTo -20 64 self
				)
			)
			(11
				(darcy dispose:)
				(gGame points: 415 3)
				(= cycles 1)
			)
			(12
				(gEgo
					loop: 0
					cel: 15
					posn: (+ (gEgo x:) 1) (- (gEgo y:) 6)
					setCycle: Beg self
				)
			)
			(13
				(gEgo normalize: illegalBits: -32768 setSpeed: local4)
				(= cycles 1)
			)
			(14
				(Face gEgo ben self)
			)
			(15
				(gMessager say: 5 42 0 11 13 self) ; "Hahahahaha! I didn't know that lunk could run so fast! Truly, friend, 'twas worth the discomfort just to see it!"
			)
			(16
				(gGame handsOn:)
				(picnicCloth show:)
				(self dispose:)
			)
		)
	)
)

(instance aEgoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(42 ; invPicnicCloth
				(gCurRoom setScript: sPutOnTableCloth)
			)
			(43 ; invBensClothes
				(gMessager say: 5 43) ; "Pepper doesn't want to wear Ben's clothes. Besides, Ben needs them!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ethan of Actor
	(properties
		x 57
		y 110
		view 500
		loop 3
		cel 7
		illegalBits 0
	)
)

(instance darcy of Actor
	(properties
		x 130
		y 86
		sightAngle 40
		view 502
		loop 2
		signal 20480
		illegalBits 0
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(hidingRock doVerb: 85)
			)
			(7 ; Do
				(hidingRock doVerb: 7)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance ben of Actor
	(properties
		x 165
		y 156
		noun 2
		sightAngle 40
		approachX 179
		approachY 107
		view 500
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(43 ; invBensClothes
				(gCurRoom setScript: sGiveBenClothes)
			)
			(42 ; invPicnicCloth
				(gMessager say: 2 42 2) ; "Um, Ben, maybe you could wear this..."
			)
			(85 ; Talk
				(gGame points: 413 1)
				(cond
					((and (not (gEgo has: 46)) (gCast contains: darcy))
						(switch local2
							(1
								(gMessager say: 2 85 2) ; "Uh, hi. You sure look like Ben Franklin..."
								(++ local2)
							)
							(2
								(gMessager say: 2 85 4) ; "Give me one of those paddles! I'll smack that bully upside the head!"
								(++ local2)
							)
							(3
								(gMessager say: 2 85 5) ; "Please, friend, get my clothes if you can. My nose is getting numb!"
							)
						)
					)
					((gEgo has: 46)
						(gMessager say: 2 85 3) ; "Okay, Ben, I have your clothes!"
					)
					(else
						(gMessager say: 2 85 6) ; "Darcy's gone, Ben! He ran like a big fat chicken!"
					)
				)
			)
			(84 ; Trivia
				(gMessager say: 2 84) ; "|c1|TRUE. Ben Franklin loved the water, and was a very strong swimmer. He once found a book on swimming, and taught himself many exotic strokes. Ben really invented swimming paddles, but later decided they were too heavy to be practical.|c|"
				(sFX number: 927 loop: 1 play:)
			)
			((OneOf theVerb 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 2 19) ; "No thank you, lad. What I really need is my clothes!"
			)
		)
	)
)

(instance picnicCloth of View
	(properties
		x 229
		y 81
		noun 11
		sightAngle 40
		view 500
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 11 6 1) ; "An old, dirty, stained, shredded picnic cloth is lying on the rock."
			)
			(7 ; Do
				(if (not (IsFlag 414))
					(gCurRoom setScript: sHandOnTableCloth)
				else
					(gMessager say: 11 7 10) ; "Pepper doesn't need the disgusting tablecloth any more."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invPicnicCloth of TWInvItem
	(properties
		loop 3
		cel 6
		message 42
		noun 11
		modNum 500
	)
)

(instance bensClothes of View
	(properties
		x 132
		y 60
		noun 1
		sightAngle 40
		approachX 150
		approachY 66
		_approachVerbs 9
		view 502
		loop 3
		cel 5
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 1 6 1) ; "Ben's clothes have landed on the ground in a heap."
			)
			(7 ; Do
				(gCurRoom setScript: sGetClothes)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance invBensClothes of TWInvItem
	(properties
		loop 3
		cel 7
		message 43
		noun 1
		modNum 500
	)
)

(instance ship of Actor
	(properties
		x 154
		y 40
		noun 9
		sightAngle 40
		view 500
		loop 4
		moveSpeed 70
	)
)

(instance ship2 of View
	(properties
		x 83
		y 39
		noun 9
		sightAngle 40
		view 500
		loop 4
		cel 1
	)
)

(instance harbor of Feature
	(properties
		y 20
		noun 3
	)
)

(instance hidingRock of Feature
	(properties
		y 160
		noun 4
		sightAngle 40
		approachX 175
		approachY 102
	)

	(method (doVerb theVerb &tmp temp0)
		(if (gEgo has: 46)
			(= temp0 7)
		else
			(= temp0 2)
		)
		(switch theVerb
			(6 ; Look
				(if (not (gCast contains: darcy))
					(gMessager say: 4 6 7) ; "I wonder what other creepy-crawly things live under that rock! Nah, I don't want to know."
				else
					(gMessager say: 4 6 temp0)
				)
			)
			(85 ; Talk
				(if (== temp0 2)
					(cond
						((not (gCast contains: darcy))
							(super doVerb: theVerb)
						)
						((== local3 1)
							(gMessager say: 4 85 2) ; "You! You give those clothes back right now!"
							(++ local3)
						)
						(else
							(gMessager say: 4 85 4) ; "Listen, you--"
						)
					)
				else
					(super doVerb: theVerb)
				)
			)
			(7 ; Do
				(if (not (gCast contains: darcy))
					(gMessager say: 4 7 7 0) ; "Pepper doesn't need to do anything with the rock anymore."
				else
					(gMessager say: 4 7 temp0)
				)
			)
			(84 ; Trivia
				(gMessager say: 0 84 0 0 0 0) ; "Nope. Nothing of historical interest there."
			)
			(42 ; invPicnicCloth
				(gMessager say: 4 42 2) ; "Pepper could probably think of a better way to use the tablecloth."
			)
			(96 ; Pebbles
				(gMessager say: 4 96 temp0)
			)
			(else
				(if (gCast contains: darcy)
					(gMessager say: 4 88 2) ; "Darcy's not impressed."
				else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance pond of Feature
	(properties
		x 160
		y 155
		noun 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(= global215 90)
				(gMessager say: 6 7) ; "I don't THINK so! |r||c0|Stagnant|c||r| water doesn't do much for my complexion."
			)
			(85 ; Talk
				(= global215 15)
				(gMessager say: 6 85) ; "Wow, it's not even |r||c0|chlorinated|c||r|! Cool!"
			)
			(84 ; Trivia
				(gMessager say: 6 84) ; "|c1|TRUE. Ben Franklin loved the water, and was a very strong swimmer. He once found a book on swimming, and taught himself many exotic strokes. Ben really invented swimming paddles, but later decided they were too heavy to be practical.|c|"
				(sFX number: 927 loop: 1 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rocks of Feature
	(properties
		x 300
		y 10
		noun 7
	)
)

(instance tree of Feature
	(properties
		x 160
		y 180
		noun 12
	)
)

(instance waterWeeds of Feature
	(properties
		x 160
		y 180
		noun 13
		approachX 80
		approachY 108
	)
)

(instance rmSound of TwistySound
	(properties
		flags 1
	)
)

(instance rmSound2 of TwistySound ; UNUSED
	(properties
		flags 1
	)
)

(instance guyBehindRock of BalloonTalker
	(properties
		x 135
		y 82
		talkWidth 140
		tailPosn 3
	)
)

(instance nathenTalker of BalloonTalker
	(properties
		x 57
		y 71
		talkWidth 130
	)
)

(instance benBoyTalker of BalloonTalker
	(properties
		x 169
		y 138
		talkWidth 140
	)
)

(instance sFX of Sound
	(properties)
)

