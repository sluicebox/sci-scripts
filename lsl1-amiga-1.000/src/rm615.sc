;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 615)
(include sci.sh)
(use Main)
(use Interface)
(use Feature)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm615 0
)

(local
	looked
	talked
	moneyTimer
)

(instance rm615 of Rm
	(properties
		picture 615
	)

	(method (init)
		(gEgo init: hide:)
		(SetFlag 45) ; fLookedAtFawn
		(herMouth cycleSpeed: (+ 2 global101) init:)
		(rightEye cycleSpeed: (+ 2 global101) init:)
		(leftEye cycleSpeed: (+ 2 global101) init:)
		(angryEyes cycleSpeed: (+ 2 global101) init:)
		(fawnHead init:)
		(fawnBody init:)
		(fawnNeck init:)
		(super init:)
		(if gDebugging
			(SetFlag 60) ; pGaveFawnRose
			(SetFlag 62) ; pGaveFawnCandy
			(SetFlag 61) ; pGaveFawnDiamond
			(SetFlag 3) ; fDancedWithFawn
		)
	)

	(method (doit)
		(super doit: &rest)
		(cond
			((and (IsFlag 60) (IsFlag 62) (IsFlag 61) (not (IsFlag 3))) ; pGaveFawnRose, pGaveFawnCandy, pGaveFawnDiamond, fDancedWithFawn
				(Print 615 0) ; "So, Fawn, have I given you enough presents that you would dance with me?"
				(Points 54 5)
				(Print 615 1) ; "But, of course, Larry," Fawn replies, "You should have asked sooner!"
				(SetFlag 31) ; fReadyToDance
				(HandsOff)
				(gCurRoom newRoom: 610)
			)
			(
				(and
					(IsFlag 60) ; pGaveFawnRose
					(IsFlag 62) ; pGaveFawnCandy
					(IsFlag 61) ; pGaveFawnDiamond
					(IsFlag 3) ; fDancedWithFawn
					(not (IsFlag 10)) ; fFawnAskedForBucks
				)
				(= moneyTimer 400)
				(SetFlag 10) ; fFawnAskedForBucks
				(Print 615 2) ; "Oooh, you're so sweet. I just LOVE you! Larry, I want you to make wild, passionate love to me!"
				(Print 615 3) ; "(All right, Larry. At last, you're gonna get lucky!!)"
				(Print 615 4) ; "She continues, "But first, we must get married. I could never make love to a man unless he's my husband. If you would loan me two hundred dollars, I'd rent the Honeymoon Suite at the Casino Hotel for us. Then, after we're married, we'll celebrate there.""
			)
			((== moneyTimer 1)
				(-- moneyTimer)
				(Print 615 5) ; "You know, Larry, a swinging guy like you must be loaded with dough," says Fawn with a tempting smile. "Why don't you give me a couple hundred so we can blow this joint?"
			)
			(moneyTimer
				(-- moneyTimer)
			)
			((gEgo mover:)
				(HandsOff)
				(gCurRoom newRoom: 610)
			)
		)
	)
)

(instance sSmile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(angryEyes dispose:)
				(herMouth setLoop: 3 setCycle: End self)
			)
			(1
				(rightEye setCycle: Beg)
				(leftEye setCycle: Beg self)
			)
			(2
				(= seconds 10)
			)
			(3
				(herMouth setCycle: Beg self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sFrown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(angryEyes init: cycleSpeed: global101 setCel: 0 setCycle: End)
				(herMouth setLoop: 4 setCel: 0 setCycle: End self)
			)
			(1
				(= seconds 10)
			)
			(2
				(herMouth setCycle: Beg self)
				(angryEyes setCycle: Beg)
			)
			(3
				(angryEyes dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sWink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(angryEyes dispose:)
				(leftEye setCel: 0 setCycle: Beg)
				(herMouth setLoop: 5 setCel: 0 setCycle: Beg self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance herMouth of Prop
	(properties
		x 174
		y 72
		view 615
		loop 3
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(fawnHead doVerb: theVerb invItem)
	)
)

(instance rightEye of Prop
	(properties
		x 178
		y 47
		view 615
		loop 1
		signal 16384
		cycleSpeed 1
	)

	(method (doVerb theVerb invItem)
		(fawnHead doVerb: theVerb invItem)
	)
)

(instance leftEye of Prop
	(properties
		x 178
		y 47
		view 615
		signal 16384
		cycleSpeed 1
	)

	(method (doVerb theVerb invItem)
		(fawnHead doVerb: theVerb invItem)
	)
)

(instance angryEyes of Prop
	(properties
		x 178
		y 47
		lookStr {Her lips are moist and inviting, but remember: you also thought that about old Mrs. Bradley, your homeroom teacher!}
		view 615
		loop 2
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(fawnHead doVerb: theVerb invItem)
	)
)

(instance fawnBody of Feature
	(properties
		x 157
		y 155
		nsTop 122
		nsLeft 75
		nsBottom 189
		nsRight 240
		description {her}
		sightAngle 40
		lookStr {"Please," she says coyly, "stop staring there."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (++ looked)
					(1
						(Print 615 6) ; "What a knock-out! She has bright blue eyes and a dazzling smile. Your eyes roam her body, and what you see, you like. She's sensational!!"
						(Print 615 7 #at -1 140) ; "(Larry, this MUST be love!)"
					)
					(2
						(Print 615 8) ; "Those beautiful eyes tell you this doll requires more than your usual smooth talk."
					)
					(else
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
						(Print 615 9) ; "Please," she says coyly, "stop staring there."
					)
				)
			)
			(5 ; Talk
				(switch (++ talked)
					(1
						(Points 91 1)
						(Print 615 10) ; "Hi ya, Baby. What say you and me get it on?"
						(Print 615 11) ; "Get lost, creep."
						(if (!= (gCurRoom script:) sFrown)
							(gCurRoom setScript: sFrown)
						)
					)
					(2
						(Print 615 12) ; ""Hey, sweetheart. What's your sign?" you ask her."
						(Print 615 13) ; "Octagonal," she replies. "Like in `STOP!'"
						(if (!= (gCurRoom script:) sFrown)
							(gCurRoom setScript: sFrown)
						)
					)
					(3
						(Print 615 14) ; "My name is Larry," you offer. "Larry Laffer."
						(Print 615 15) ; "Say, Larry," she chuckles, glancing downward, "is that a pez dispenser in your pocket, or are you just lonely?"
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
					)
					(4
						(Print 615 16) ; ""What's your name, beautiful?" you ask."
						(Print 615 17) ; ""Fawn," she replies."
						(Print 615 18) ; "Somehow you knew that."
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
					)
					(else
						(if (IsFlag 10) ; fFawnAskedForBucks
							(Print 615 19) ; "So, how about it, Larry?" Fawn says in her petite voice. "May I have a measly two hundred bucks, or not?"
						else
							(Print 615 20) ; "I'd really like to get to know you better," you say. "What kind of girl are you, anyway?"
							(Print 615 21) ; "She smiles and says, "I'm just a girl who can't say no..."
							(Print 615 22 #at -1 140) ; "(All right, Larry; this is what you've been waiting for!)"
							(Print 615 23) ; ""...to nice presents," she concludes."
							(Print 615 24 #at -1 140) ; "(Oops.)"
							(if (!= (gCurRoom script:) sSmile)
								(gCurRoom setScript: sSmile)
							)
						)
					)
				)
			)
			(3 ; Do
				(if (IsFlag 3) ; fDancedWithFawn
					(Print 615 25) ; "Not again. That trip through the ceiling gave me a headache!"
				else
					(SetFlag 31) ; fReadyToDance
					(if (!= (gCurRoom script:) sSmile)
						(gCurRoom setScript: sSmile)
					)
					(Print 615 26) ; "You screw up your courage and ask, "What would you say to a spin around the dance floor with the nearest thing to John Travolta, baby?""
					(Points 54 5)
					(Print 615 27) ; "Well, okay, I guess," she replies, thinking to herself, "near as I'm gonna get!"
					(HandsOff)
					(gCurRoom newRoom: 610)
				)
			)
			(11 ; Taste/Smell
				(Print 615 28) ; "Fawn smells of expensive perfume--probably a gift from some admirer."
				(if (!= (gCurRoom script:) sWink)
					(gCurRoom setScript: sWink)
				)
			)
			(10 ; Zipper
				(Print 615 29) ; ""Something might be arranged in that department," says Fawn, coyly."
				(if (!= (gCurRoom script:) sWink)
					(gCurRoom setScript: sWink)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(cond
							((not (IsFlag 10)) ; fFawnAskedForBucks
								(Print 615 30) ; "Well, really. I'm not that kind of girl!!"
								(if (!= (gCurRoom script:) sFrown)
									(gCurRoom setScript: sFrown)
								)
							)
							((and (IsFlag 10) (<= gLarryDollars 200)) ; fFawnAskedForBucks
								(= moneyTimer 0)
								(Printf 615 31 gLarryDollars) ; "Uh, gosh, Fawn," you mumble. "I've only got $%d.00 bucks on me!"
								(Print 615 32) ; "I'm sorry, but I'll need at least two hundred dollars," she says with a coy smile. "You know it'll be worth it!"
								(Print 615 33) ; "It appears Fawn has caught you a "little short," Larry. Better try the casino, and hope for a run of good luck!"
								(Print 615 34) ; "You fervently hope she'll wait for your return."
								(Print 615 35) ; "Conveniently, she offers, "I'll wait right here until you return.""
								(Print 615 36) ; "Gee, Larry, this is working out swell."
							)
							((and (IsFlag 10) (> gLarryDollars 200)) ; fFawnAskedForBucks
								(Points 63 7)
								(Print 615 37) ; "Ooh you're so sweet. I just love money."
								(Print 615 38) ; "Thanks, Larry. You won't regret this. Meet me at the Marriage Chapel near the Casino in a few minutes. I'll get us a room. Hurry, Larry, I can hardly wait!"
								(SetFlag 32) ; fReadyToMarry
								(SetFlag 14) ; fFawnLeaves
								(if (!= (gCurRoom script:) sSmile)
									(gCurRoom setScript: sSmile)
								)
								(-= gLarryDollars 200)
								(HandsOff)
								(gCurRoom newRoom: 610)
							)
						)
					)
					(7 ; rose
						(Print 615 39) ; "Ooh you're so sweet. I just love roses."
						(gEgo put: 7) ; rose
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
						(Points 60 5)
					)
					(9 ; candy
						(Print 615 40) ; "Ooh you're so sweet. I just love Candy."
						(gEgo put: 9) ; candy
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
						(Points 62 5)
					)
					(4 ; ring
						(Print 615 41) ; "Ooh you're so sweet. I just love diamonds."
						(gEgo put: 4) ; ring
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
						(Points 61 5)
					)
					(1 ; breathSpray
						(Print 615 42) ; ""Are you implying I have bad breath?" she says angrily."
						(if (!= (gCurRoom script:) sFrown)
							(gCurRoom setScript: sFrown)
						)
					)
					(2 ; watch
						(Print 615 43) ; "It IS getting late, Larry. And you're sure she's soooo lonely!"
					)
					(6 ; remoteControl
						(Print 615 44) ; "Why, Larry! What a cute little clicker you've got."
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
					)
					(8 ; lubber
						(Print 615 45) ; "You're rushing things, Larry. Calm down."
					)
					(10 ; discoPass
						(Print 615 46) ; "She'd probably dance with you if you'd offer your hand."
					)
					(11 ; pocketKnife
						(Print 615 47) ; "It would be smart for you not to let Fawn know you're carrying a concealed weapon!"
					)
					(13 ; magazine
						(Print 615 48) ; ""I have no interest in naked women--or window washing!" Fawn says."
					)
					(14 ; hammer
						(Print 615 49) ; "Oooh, I just LOVE to play with manly tools!"
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
					)
					(17 ; graffiti
						(Print 615 50) ; "Ken? Never heard of him," she says. Then her expression changes. "Say... what's he like? How much does he make? Is he married?"
						(if (!= (gCurRoom script:) sSmile)
							(gCurRoom setScript: sSmile)
						)
					)
					(else
						(Printf 615 51 ((Inv at: invItem) description:)) ; "Oh, %s is sweet, but I'd like something special... from a guy like you!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance fawnHead of Feature
	(properties
		x 149
		y 56
		nsTop 12
		nsLeft 88
		nsBottom 101
		nsRight 210
		description {her head}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 615 52) ; "Her mind is stuck in the present(s)."
			)
			(else
				(fawnBody doVerb: theVerb invItem)
			)
		)
	)
)

(instance fawnNeck of Feature
	(properties
		x 172
		y 111
		nsTop 102
		nsLeft 136
		nsBottom 120
		nsRight 208
		description {her neck}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 615 53) ; "A long and lovely neck perfectly fills the distance between her head and her shoulders!"
			)
			(3 ; Do
				(Print 615 54) ; "Ooooh, that feels nice!"
			)
			(else
				(fawnBody doVerb: theVerb invItem)
			)
		)
	)
)

