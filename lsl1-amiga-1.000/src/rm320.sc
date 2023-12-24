;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 320)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm320 0
)

(local
	trickTimer
	mcOnStage
	poopied
)

(procedure (PrintJoke &tmp joke)
	(jokes delete: (= joke (jokes at: (Random 1 (jokes size:)))))
	(switch joke
		(1
			(Print 320 37) ; "I told my doctor my sex life was boring. He said `You need to add the element of surprise. Go right home this afternoon, grab your wife, and immediately make love to her, no matter what she's doing.' So I did!"
			(Print 320 38) ; "It was still the same old boring crap, but her bridge club got a tremendous kick out of it!!"
		)
		(2
			(Print 320 39) ; "You know how I can tell when my wife has an orgasm?"
			(Print 320 40) ; "She drops her nail file!!"
		)
		(3
			(Print 320 41) ; "My wife is so ugly..."
			(Print 320 42) ; ""How ugly is she?" you shout."
			(Print 320 43) ; "...the picture of her in my wallet is an X-ray!"
		)
		(4
			(Print 320 44) ; "I told my psychiatrist `Nobody pays any attention to me.'"
			(Print 320 45) ; "He looks at me and says, `When did you get here?'"
		)
		(5
			(Print 320 46) ; "Didja hear about the clumsy female lawyer?"
			(Print 320 47) ; "She dropped her briefs!"
		)
		(6
			(Print 320 48) ; "A man walks into a doctor's office with a frog on his head. The doctor says, `May I help you?'"
			(Print 320 49) ; "The frog says, `Yeah, Doc. Could you take this wart off my ass?'"
		)
		(7
			(Print 320 50) ; "Did you hear about the new, chocolate-flavored, contraceptive, breakfast drink?"
			(Print 320 51) ; "It's called Ovumteen."
		)
		(8
			(Print 320 52) ; "My secretary is not only horny, she's ambitious. Today she asked me for a salary on next week's advance."
		)
		(9
			(Print 320 53) ; "Down the street there's a new, live, gay, sex show."
			(Print 320 54) ; "It's called `Anus and Andy.'"
		)
		(10
			(Print 320 55) ; "Have ya seen the new R-rated movie about midgets? It features full runtal nudity."
		)
		(11
			(Print 320 56) ; "My uncle is a hit man for the Mob. What a great job! He only goes to work when it's time to knock off."
		)
		(12
			(Print 320 57) ; "When I got married I asked my bride, `Do you perform fellatio?'"
			(Print 320 58) ; "She said, `I dunno. I guess it depends on the fella!'"
		)
		(13
			(Print 320 59) ; "Have you seen the impotent flasher in front of the wedding chapel next door?"
			(Print 320 60) ; "We call him our `public futility.'"
		)
		(14
			(Print 320 61) ; "I hear the pimp at Lefty's won't let his girls perform oral sex."
			(Print 320 62) ; "They call him the `Headless Whoresman.'"
		)
		(15
			(Print 320 63) ; "What do lesbians like most about their kind of sex?"
			(Print 320 64) ; "Tastes great."
			(Print 320 65) ; "Less filling."
			(Print 320 66) ; "Tastes great!"
			(Print 320 67) ; "Less filling!"
		)
		(16
			(Print 320 68) ; "Why don't sharks attack divorce lawyers?"
			(Print 320 69) ; "Professional courtesy."
		)
		(17
			(Print 320 70) ; "My wife and I have a new system: if she wants sex, she reaches over and strokes me once."
			(Print 320 71) ; "If she doesn't, she reaches over and strokes me 300 times."
		)
		(18
			(Print 320 72) ; ""My son just got kicked out of his co-ed college boarding house."
			(Print 320 73) ; "He got caught spreading roomers."
		)
		(19
			(Print 320 74) ; "My daughter came home from school today and tells me, `Eli Whitney invented the cotton gin.'"
			(Print 320 75) ; "I said, `Who wants a fluffy martini?'"
		)
		(20
			(Print 320 76) ; "The shop teacher asked the high school girl if she knew the difference between a screw, a nail and a bolt. She told him she'd never been bolted."
		)
		(21
			(Print 320 77) ; "Have you heard about the new urologist's training film?"
			(Print 320 78) ; "It's called, `E.T., the Extra Testicle.'"
		)
		(22
			(Print 320 79) ; "Have you heard about the new film about marching band musicians?"
			(Print 320 80) ; "It's called, `Desperately Seeking Sousa.'"
		)
		(23
			(Print 320 81) ; "My son has a problem with compulsive masturbation. His psychiatrist says he's gone completely wacky."
		)
		(24
			(Print 320 82) ; "My grandpa the farmer, finally got himself one of those latex ladies. I heard him singing about it the other day: `The farmer in the doll, the farmer in the doll...'"
		)
		(25
			(Print 320 83) ; "Our local inventor just came up with a new, vibrating tampon."
			(Print 320 84) ; "He says if women have to be miserable once a month, they might as well enjoy it."
		)
		(26
			(Print 320 85) ; "My wife just loves going to the movies to watch teenagers get laid for the first time."
			(Print 320 86) ; "Sometimes, she even watches the screen!"
		)
		(27
			(Print 320 87) ; "I asked my wife, `How come you never tell me when you're having an orgasm?'"
			(Print 320 88) ; "She replied, `Because you're never around!'"
		)
		(28
			(Print 320 89) ; "My wife just loves to experiment. Last week she mixed speed with her Midol."
			(Print 320 90) ; "She had a period six times in one day!"
		)
		(29
			(Print 320 91) ; "My wife is a lot like Halley's Comet."
			(Print 320 92) ; "They both come about every 76 years!"
		)
		(30
			(Print 320 93) ; "My son is becoming a real computer whiz!"
			(Print 320 94) ; "His teacher called him a `master byter.'"
		)
		(31
			(Print 320 95) ; "My uncle the inventor crossed a cucumber with a Mexican jumping bean."
			(Print 320 96) ; "He calls it the world's first organic vibrator!"
		)
		(32
			(Print 320 97) ; "Last week, I got arrested by a female cop. She asked me, `Are you carrying a concealed weapon?'"
			(Print 320 98) ; "I replied, `Keep frisking me like that, and I soon will be!'"
		)
		(33
			(Print 320 99) ; "My best sexual encounter was in the South Sea Islands..."
			(Print 320 100) ; "I pushed a volcano into a virgin!"
		)
		(34
			(Print 320 101) ; "Didja hear about the copier company that bought out a musical instrument maker?"
			(Print 320 102) ; "They're marketing a new reproductive organ!"
		)
		(35
			(Print 320 103) ; "I just flew in from Coarsegold..."
			(Print 320 104) ; "...and, boy, are my arms tired!"
		)
		(36
			(Print 320 105) ; "What do you call a Roman with hair between his teeth?"
			(Print 320 106) ; "Gladiator."
		)
		(37
			(Print 320 107) ; "I always say that little things mean a lot!"
			(Print 320 108) ; "On the other hand, never underestimate the power of big, jiggly things!"
		)
		(38
			(Print 320 109) ; "Have you heard about that new radio station in town, KPMS?"
			(Print 320 110) ; "Every month they play three weeks of blues and a week of ragtime!"
		)
	)
)

(procedure (PrintLine)
	(switch (Random 0 6)
		(0
			(Print 320 111) ; "Whaddsa' matter, folks? Am I keeping you up?"
		)
		(1
			(Print 320 112) ; "You know, folks, it just don't get much better than this!"
		)
		(2
			(Print 320 113) ; "Waddaya out there, a painting?"
		)
		(3
			(Print 320 114) ; "Tough crowd. Tough crowd."
		)
		(4
			(Print 320 115) ; "I shoulda never given up my day gig!"
		)
		(5
			(Print 320 116) ; "Waddaya waitin' for folks? This IS the `A' stuff!"
		)
		(6
			(Print 320 117) ; "For this I spent four years in college?"
		)
	)
)

(instance rm320 of LLRoom
	(properties
		picture 320
		south 330
	)

	(method (init &tmp i)
		(LoadMany rsVIEW 320)
		(LoadMany rsSOUND 133 320 321 322 323 324 325)
		(gTheMusic2 setVol: 127 setLoop: 1 flags: 1)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 252 189 252 179 271 172 296 172 296 179 317 179 317 142 267 114 135 111 32 117 13 147 53 147 53 156 2 156 2 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 19 189 19 178 43 168 74 168 97 178 97 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 148 189 148 176 167 165 195 165 219 176 219 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 39 133 103 133 103 138 83 138 83 143 39 143
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 100 144 172 144 172 156 100 156
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 170 123 243 123 243 135 219 135 219 138 193 138 193 135 170 135
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 232 158 302 158 302 168 232 168
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 226 142 298 142 298 150 226 150
					yourself:
				)
		)
		(gEgo init: x: 126 actions: egoActions)
		(if (!= gPrevRoomNum 330)
			(gEgo y: 180)
		)
		(if (IsFlag 98) ; fCaberetTgl
			(ClearFlag 98) ; fCaberetTgl
			(LoadMany rsVIEW 321 322 324)
			(= trickTimer (Random 1200 2000))
			(= mcOnStage 1)
			(comedian cycleSpeed: global101 init: setScript: sComedian)
			(head cycleSpeed: global101 init:)
			(drummer cycleSpeed: (+ global101 1) init:)
			(for ((= i 1)) (<= i 38) ((++ i))
				(jokes addToEnd: i)
			)
		else
			(SetFlag 98) ; fCaberetTgl
			(LoadMany rsVIEW 323)
			(gTheMusic number: 320 loop: -1 vol: 127 flags: 1 play:)
			(for
				((= i 0))
				(< i (+ (gGame detailLevel:) 2))
				((++ i))
				
				((dancer new:)
					cycleSpeed: global101
					init:
					x: (+ (dancer x:) (* i 22))
					y: (- (dancer y:) (* i 2))
					setCycle: Fwd
					approachVerbs: 3 4 10 11 5 2 ; Do, Inventory, Zipper, Taste/Smell, Talk, Look
					approachX: (+ (dancer x:) (* i 22))
					approachY: (- (dancer y:) (* i 2))
				)
			)
		)
		(super init:)
		(light1 cycleSpeed: global101 setCycle: Fwd init:)
		(light2 cycleSpeed: global101 setCycle: Fwd init:)
		(light3 cycleSpeed: global101 setCycle: Fwd init:)
		(light4 cycleSpeed: global101 setCycle: Fwd init:)
		(light5 cycleSpeed: global101 setCycle: Fwd init:)
		(light6 cycleSpeed: global101 setCycle: Fwd init:)
		(table1 init:)
		(table2 init:)
		(table3 init:)
		(table4 init:)
		(table5 init: approachVerbs: 3 4 10 11) ; Do, Inventory, Zipper, Taste/Smell
		(table6 init:)
		(theStage init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (> trickTimer 1)
			(-- trickTimer)
		)
		(cond
			(script)
			((and (gEgo mover:) (== (gEgo view:) 321))
				(HandsOff)
				(gCurRoom setScript: sStand)
			)
		)
	)

	(method (dispose)
		(jokes dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 320 0) ; "A sign off in the corner reads, "Welcome to The Lizard Lounge.""
				(Print 320 1) ; "It looks like a great place to be from."
				(Print 320 2 #at -1 140) ; "(You wonder where they keep the lizards.)"
			)
			(4 ; Inventory
				(switch invItem
					(7 ; rose
						(gEgo put: 7 0) ; rose
						(Print 320 3) ; "You toss the rose on the stage. It falls where you will not be able to retrieve it."
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

	(method (newRoom newRoomNumber)
		(if (== (gTheMusic number:) 320)
			(gTheMusic fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(class egoActions of Code
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(if mcOnStage
					(Print 320 4) ; ""Bravo. Bravo!" you cry."
					(Print 320 5) ; ""Thank you, thank you!" the comedian responds to your applause."
				else
					(Print 320 6) ; "The girls' smiles beam at your applause!"
				)
			)
		)
	)
)

(instance sComedian of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(drummer setLoop: 0 setCel: 0 stopUpd:)
				(comedian setLoop: (Random 1 2) setCycle: Fwd)
				(head setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(comedian setLoop: (Random 1 2))
				(= seconds 2)
			)
			(3
				(head setCel: (and (Random 0 1) 7) stopUpd:)
				(comedian stopUpd:)
				(= cycles 1)
			)
			(4
				(cond
					((== trickTimer 1)
						(= trickTimer 0)
						(head setScript: sMagicTrick)
					)
					((== (jokes size:) 1)
						(Print 320 7) ; "Well, that's all I know, folks," the comic says. "Come back for the next show, and you can hear 'em all again!"
						(self dispose:)
					)
					(else
						(PrintJoke)
						(= cycles 3)
					)
				)
			)
			(5
				(gTheMusic2 number: (Random 321 325) play:)
				(drummer setCycle: End self)
			)
			(6
				(= seconds 1)
			)
			(7
				(PrintLine)
				(self init:)
			)
		)
	)
)

(instance sMagicTrick of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 320 8) ; "And, now, ladi... uh, gentleman," announces the comic, "we're proud to present the Magic portion of our act."
				(Print 320 9) ; "Let me pick someone at random from our audience..."
				(Print 320 10) ; "How about you," he says looking directly at you. "Would you like to participate in a little experiment in telepathy?"
				(Print 320 11 #at -1 140) ; "(Of course he's looking at you! You're the only one here!)"
				(Print 320 12) ; "You're game, so you answer, "Sure.""
				(Print 320 13) ; "Great! Now Paul, my drummer and musical conductor for lo these many years, will read your mind," says the comic. "Come on, Paul, show him your stuff!"
				(drummer setLoop: 1)
				(drummerHead cycleSpeed: global101 init: setCycle: Fwd)
				(Print 320 14 #at 15 80 #dispose) ; "I want you to concentrate on your billfold," Paul says. "Clear your mind, and think solely about the contents of your wallet."
				(= seconds 5)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Print 320 15) ; "Since clearing your mind is no problem for you, Larry, you do so easily."
				(Print 320 16 #at 15 80 #dispose) ; "I'm getting a message... I see something..."
				(= seconds 5)
			)
			(2
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(Printf 320 17 gLarryDollars 67 15 80 105) ; "I've GOT IT!" he exclaims. "If you open your billfold you'll discover some wrinkled business cards, lots of notes, some credit cards (which won't work in this game), and exactly $%d.00 in cash!!"
				(= seconds 5)
			)
			(3
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(drummer setLoop: 0)
				(drummerHead dispose:)
				(Print 320 18) ; "Ladi... uh, GENTLEMAN!" shouts the comic. "PAUL THE MAGNIFICENT has done it again!!"
				(Print 320 19) ; "Just to make sure, you take out your wallet and look inside..."
				((gInventory at: 0) doVerb: 2) ; wallet
				(comedian setScript: sComedian)
			)
		)
	)
)

(instance sSit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 321
					normal: 0
					setLoop: 0
					setCel: 0
					setPri: 15
					setCycle: End self
				)
			)
			(1
				(if (and mcOnStage (not poopied))
					(gTheMusic3 number: 133 loop: 1 vol: 127 flags: 1 play:)
					(= poopied 1)
					(whoopyCushion
						cycleSpeed: (+ global101 1)
						init:
						setCycle: End self
					)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(2
				(whoopyCushion z: 1000 dispose:)
				(gEgo setLoop: 2 setCel: 0 setCycle: End self)
			)
			(3
				(Print 320 20) ; "At least the comic's whoopee cushion doesn't smell!"
				(Points 89 1)
				(gEgo setLoop: 0 setCel: 255)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sStand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(table5 approachX: 296 approachY: 178)
				(gEgo setPri: 14 setCycle: Beg self)
			)
			(1
				(HandsOn)
				(NormalEgo 1)
				(if
					(and
						(!= (CueObj client:) table5)
						((CueObj client:) approachX:)
					)
					(gEgo
						setMotion:
							PolyPath
							((CueObj client:) approachX:)
							(+ (gEgo z:) ((CueObj client:) approachY:))
							CueObj
					)
				else
					(gEgo
						setMotion:
							PolyPath
							((User curEvent:) x:)
							((User curEvent:) y:)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance comedian of Person
	(properties
		x 166
		y 70
		description {the comedian}
		lookStr {Evidently, HE thinks he's funny!}
		view 322
		loop 1
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(Print 320 21) ; "You shout to the comedian, "This ain't funny!""
				(Print 320 22) ; "The comedian retorts, "But you are!!""
			)
			(3 ; Do
				(Print 320 23) ; "You whistle loudly at the comic."
				(Print 320 24) ; "Hey, buddy, will ya hold it down?" says the comic. "I'm tryin' to earn a living up here!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance head of Prop
	(properties
		z 26
		description {the comedian}
		lookStr {Evidently, HE thinks he's funny!}
		view 322
		signal 16384
	)

	(method (init)
		(= y (comedian y:))
		(super init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (== (comedian loop:) 2)
			(= x (+ (comedian x:) 5))
		else
			(= x (- (comedian x:) 1))
		)
	)

	(method (doVerb theVerb invItem)
		(comedian doVerb: theVerb invItem)
	)
)

(instance drummerHead of Prop
	(properties
		z 30
		description {Paul, the drummer}
		lookStr {It's a living!}
		view 324
		loop 2
		signal 16384
	)

	(method (init)
		(= y (drummer y:))
		(= x (drummer x:))
		(super init:)
	)

	(method (doVerb theVerb invItem)
		(drummer doVerb: theVerb invItem)
	)
)

(instance drummer of Prop
	(properties
		x 101
		y 70
		description {Paul, the drummer}
		lookStr {It's a living!}
		view 324
		cycleSpeed 1
	)

	(method (cue)
		(super cue:)
		(Print 320 25 #at 15 80) ; "It's a living."
		(drummerHead dispose:)
	)

	(method (doVerb)
		(if (!= (comedian script:) sMagicTrick)
			(drummerHead cycleSpeed: global101 init: setCycle: Beg self)
		)
	)
)

(instance dancer of Actor
	(properties
		x 120
		y 76
		description {the dancer}
		view 323
		signal 16384
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 320 26) ; "Upon closer examination, you discover these dancers may not be the "girls" you thought they were!"
			)
			(3 ; Do
				(Print 320 27) ; "You whistle loudly at the girls."
				(Print 320 28) ; "You're not sure, but you suppose they enjoy it."
			)
			(5 ; Talk
				(Print 320 27) ; "You whistle loudly at the girls."
				(Print 320 28) ; "You're not sure, but you suppose they enjoy it."
			)
			(10 ; Zipper
				(Print 320 29) ; "Right, sure! As if it would reach from way down here!"
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance whoopyCushion of Prop
	(properties
		x 299
		y 172
		view 321
		loop 1
		priority 15
		signal 16400
	)
)

(instance theStage of Feature
	(properties
		x 156
		y 108
		z 31
		nsTop 76
		nsLeft 50
		nsBottom 98
		nsRight 262
		description {the stage}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 320 30) ; "The stage is only there as a "supporting" cast member!"
			)
			(3 ; Do
				(Print 320 31) ; "Stay off the stage, Larry. You're no star!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light1 of Prop
	(properties
		x 70
		y 141
		z 15
		description {the candle in a glass}
		view 320
		priority 10
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 320 32) ; "You wonder who invented that little plastic net surrounding the candle's glass."
				(Print 320 33) ; "And, how come it doesn't melt?"
			)
			(3 ; Do
				(Print 320 34) ; "You briefly hold your hand right above the candle flame, then reconsider as your hand begins to blister."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance table1 of Feature
	(properties
		x 68
		y 122
		nsTop 109
		nsLeft 51
		nsBottom 135
		nsRight 86
		description {the table}
		sightAngle 40
		lookStr {What wonderful decor! You just love furniture with a sense of humor.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 320 35) ; "As you are about to sit down in that chair, you notice a small sign on the table that reads, "Reserved.""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light2 of Prop
	(properties
		x 131
		y 153
		z 15
		description {the candle in a glass}
		view 320
		loop 2
		priority 11
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(light1 doVerb: theVerb invItem)
	)
)

(instance table2 of Feature
	(properties
		x 136
		y 137
		nsTop 125
		nsLeft 116
		nsBottom 149
		nsRight 156
		description {the table}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(table1 doVerb: theVerb invItem)
	)
)

(instance light3 of Prop
	(properties
		x 178
		y 178
		z 15
		description {the candle in a glass}
		view 320
		loop 4
		priority 15
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(light1 doVerb: theVerb invItem)
	)
)

(instance table3 of Feature
	(properties
		x 182
		y 165
		nsTop 152
		nsLeft 165
		nsBottom 178
		nsRight 200
		description {the table}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(table1 doVerb: theVerb invItem)
	)
)

(instance light4 of Prop
	(properties
		x 207
		y 137
		z 15
		description {the candle in a glass}
		view 320
		loop 3
		priority 9
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(light1 doVerb: theVerb invItem)
	)
)

(instance table4 of Feature
	(properties
		x 206
		y 121
		nsTop 111
		nsLeft 188
		nsBottom 131
		nsRight 225
		description {the table}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(table1 doVerb: theVerb invItem)
	)
)

(instance light5 of Prop
	(properties
		x 283
		y 180
		z 15
		description {the candle in a glass}
		view 320
		loop 5
		cel 1
		priority 15
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(light1 doVerb: theVerb invItem)
	)
)

(instance table5 of Feature
	(properties
		x 292
		y 166
		nsTop 149
		nsLeft 266
		nsBottom 184
		nsRight 319
		description {the table}
		sightAngle 40
		approachX 296
		approachY 178
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(table1 doVerb: 2)
			)
			(3 ; Do
				(if (== (gEgo view:) 321)
					(Print 320 36) ; "You already are sitting."
				else
					(self approachX: 0)
					(self approachY: 0)
					(HandsOff)
					(gCurRoom setScript: sSit)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light6 of Prop
	(properties
		x 63
		y 187
		z 15
		description {the candle in a glass}
		view 320
		loop 1
		cel 1
		priority 15
		signal 16400
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(light1 doVerb: theVerb invItem)
	)
)

(instance table6 of Feature
	(properties
		x 61
		y 173
		nsTop 160
		nsLeft 40
		nsBottom 187
		nsRight 82
		description {the table}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(table1 doVerb: theVerb invItem)
	)
)

(instance jokes of List
	(properties)
)

