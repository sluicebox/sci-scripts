;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use Feature)
(use LoadMany)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm355 0
)

(local
	lookCount
	talkCount
	breathLineTimer
)

(instance rm355 of LLRoom
	(properties
		picture 355
	)

	(method (init)
		(LoadMany rsVIEW 355)
		(LoadMany rsSOUND 352)
		(gEgo init: hide:)
		(super init:)
		(herEyes init: cycleSpeed: gLarrySpeed setScript: sBlink)
		(herMouth init: cycleSpeed: gLarrySpeed)
		(if (and (not gSpraySeconds) (IsFlag 20)) ; fMouthSmellsBad
			(= breathLineTimer 60)
			(herMouth setScript: sFrown)
		)
		(hair init:)
		(theBreasts init:)
		(faithF init:)
		(neck init:)
		(necklace init:)
		(face init:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and breathLineTimer (== (-- breathLineTimer) 1))
			(Print 355 0 #at -1 140) ; "Bad breath's one thing, Mister; but, you could knock a buzzard off a manure truck!"
		)
		(cond
			(script)
			((gEgo mover:)
				(gCurRoom newRoom: 350)
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 1) ; "She is a knockout! But that pair of pistols slung around her hips brings a sense of foreboding to your gut."
			)
			(4 ; Inventory
				(switch invItem
					(1 ; breathSpray
						(= breathLineTimer 0)
						(herEyes setScript: sFlap)
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

(instance sFaithLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 352 play:)
				(herEyes setScript: sFlap)
				(herMouth setScript: sSmile 0 1)
				(gEgo put: 15 350) ; pills
				(Points 64 5)
				(= seconds 2)
			)
			(1
				(herEyes setCycle: End self)
			)
			(2
				(Print 355 2) ; "Faith only gives the bottle of Spanish Fly a quick glance before saying, "Boy, thanks! How did you know I love this stuff?!""
				(Print 355 3) ; "She tosses back a few pills, then a few more, finally gulping down the whole bottle! Her breathing becomes faster and faster. She begins to pant!"
				(herEyes setScript: sFlap)
				(= seconds 4)
			)
			(3
				(herEyes setCycle: End self)
			)
			(4
				(Print 355 4) ; "She's really getting turned on!"
				(Print 355 5 #at -1 140) ; "(Looks like tonight's your lucky night, Larry.)"
				(= seconds 4)
			)
			(5
				(gCurRoom newRoom: 350)
			)
		)
	)
)

(instance sFrown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(herMouth setLoop: 2 setCel: 0)
				(herEyes setScript: 0 setLoop: 1 setCel: 0)
				(= seconds 5)
			)
			(1
				(herMouth setLoop: 4 setCel: 0)
				(herEyes setLoop: 0 setCel: 0 setScript: sBlink)
				(self dispose:)
			)
		)
	)
)

(instance sSmile of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (gCurRoom script:) sFaithLeaves)
					(herEyes setLoop: 0 setCel: 0 setScript: sBlink)
				)
				(herMouth setLoop: 5 setCel: 0)
				(= seconds register)
			)
			(1
				(herMouth setLoop: 4 setCel: 0)
				(if (> register 3)
					(self dispose:)
				else
					(self init:)
				)
			)
		)
	)
)

(instance sFlap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(herEyes setLoop: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(1
				(if (== (gCurRoom script:) sFaithLeaves)
					(self init:)
				else
					(herEyes setCycle: Beg self)
				)
			)
			(2
				(herEyes setScript: sBlink)
				(self dispose:)
			)
		)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(herEyes setCycle: Beg self)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance herEyes of Prop
	(properties
		x 122
		y 71
		z 28
		description {her eyes}
		view 355
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 6) ; "Her eyes are as sensuous as her lips."
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance herMouth of Prop
	(properties
		x 128
		y 71
		description {her mouth}
		view 355
		loop 4
		signal 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 7) ; "Her lips are moist and inviting, but then, you also felt that way about Mr. Bergman, your junior high school math instructor!"
			)
			(11 ; Taste/Smell
				(herMouth setScript: sSmile 0 5)
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance face of Feature
	(properties
		x 131
		y 53
		nsTop 37
		nsLeft 105
		nsBottom 81
		nsRight 157
		description {her face}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 8) ; "She's the loveliest woman you've even been THIS close to, Larry."
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance neck of Feature
	(properties
		x 152
		y 54
		nsTop 82
		nsLeft 131
		nsBottom 114
		nsRight 174
		description {her neck}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 9) ; "You long to get closer to her beautiful long neck."
			)
			(11 ; Taste/Smell
				(Print 355 10 #at -1 140) ; "Oh, DON'T do that!" she says, "I have a job to do here!"
				(herMouth setScript: sSmile 0 5)
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance necklace of Feature
	(properties
		x 151
		y 55
		nsTop 115
		nsLeft 129
		nsBottom 141
		nsRight 174
		description {her necklace}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 11) ; "You wonder just how religious this girl could be, wearing an outfit like that."
			)
			(3 ; Do
				(Print 355 12) ; "Upon touching the cross, you feel a sudden inspiration."
				(Print 355 13) ; ""What is your name?" you ask."
				(Print 355 14) ; ""Faith," she replies."
				(Print 355 15) ; "Hmmm. Unusual name."
				(herMouth setScript: sSmile 0 5)
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance hair of Feature
	(properties
		x 151
		y 52
		nsTop 2
		nsLeft 83
		nsBottom 103
		nsRight 219
		description {her hair}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 16) ; "Her hair is thick and beautiful, falling in cascades around her delicate shoulders."
			)
			(3 ; Do
				(Print 355 17) ; ""I'd love to run my fingers through your hair," you say."
				(Print 355 18) ; "From the looks of your hairline, you'd love to run your fingers through ANY hair!"
			)
			(11 ; Taste/Smell
				(Print 355 19) ; "Your hair smells wonderful," you offer, assuming it's her shampoo you're smelling. "What's your brand?"
				(Print 355 20) ; "Smith and Wesson!"
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance theBreasts of Feature
	(properties
		x 146
		y 170
		nsTop 152
		nsLeft 77
		nsBottom 189
		nsRight 215
		description {her breasts}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 355 21) ; "What a pair of pistols!"
			)
			(3 ; Do
				(Print 355 22) ; "That pair of pistols she's wearing aren't the only 38's she's packing!"
			)
			(11 ; Taste/Smell
				(Print 355 23) ; "You can only imagine!"
			)
			(else
				(faithF doVerb: theVerb invItem)
			)
		)
	)
)

(instance faithF of Feature
	(properties
		x 166
		y 24
		nsTop 2
		nsLeft 74
		nsBottom 189
		nsRight 259
		description {Faith}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(switch (++ lookCount)
					(1
						(Print 355 1) ; "She is a knockout! But that pair of pistols slung around her hips brings a sense of foreboding to your gut."
					)
					(2
						(Print 355 24) ; "Her uniform reveals she's built like a brick shipyard."
					)
					(else
						(Print 355 25) ; ""Stop staring there," she says softly."
						(herMouth setScript: sSmile 0 5)
					)
				)
			)
			(3 ; Do
				(Print 355 26 #at -1 140) ; "You know, I'm supposed to be working!"
			)
			(5 ; Talk
				(switch (++ talkCount)
					(1
						(Print 355 27) ; "Hi ya, Baby. I think I loves ya!!"
						(herMouth setScript: sSmile 0 5)
						(Print 355 28 #at -1 140) ; ""May I help you in some way, Sir?" she responds in a pleasant, but businesslike voice."
					)
					(2
						(Print 355 29) ; ""My name is Larry; Larry Laffer," you offer."
						(Print 355 30 #at -1 140) ; "Say, Larry," she says with a smile. "Is that a roll of dimes in your pocket, or are you just glad to see me?"
						(herMouth setScript: sSmile 0 5)
					)
					(3
						(Print 355 31) ; ""Hey, sweetheart. What's your sign?" you ask her."
						(Print 355 32 #at -1 140) ; "`EXIT," she replies. "Try using it!"
					)
					(4
						(Print 355 33) ; ""What's your name, beautiful?" you ask."
						(Print 355 14 #at -1 140) ; ""Faith," she replies."
						(Print 355 15) ; "Hmmm. Unusual name."
					)
					(5
						(Print 355 34) ; "I'm only in town for one night," you try again. "How about we get together when you get off duty?"
						(Print 355 35 #at -1 140) ; "She smiles and says, "Oh, I could never be unfaithful to my boyfriend.""
						(Print 355 36 #at -1 140) ; "(Larry, it seems this one's gonna require outside assistance.)"
						(herMouth setScript: sSmile 0 5)
					)
					(6
						(Print 355 37) ; ""When do you get off?" you ask her."
						(Print 355 38 #at -1 140) ; ""When I'm with someone romantic!" she replies."
					)
					(7
						(Print 355 39) ; "Don't sit here all night," you plead. "Why don't you come with me?"
						(Print 355 40 #at -1 140) ; "Perhaps," she says, "but right now, I'm working."
					)
					(else
						(Print 355 41) ; "You're a man of the world, Larry. Perhaps some sort of medical stimulant would help."
					)
				)
			)
			(10 ; Zipper
				(Print 355 42) ; "Try it, and I'll blow your head off."
				(Print 355 43 #at -1 140) ; "(She is, of course, referring to the use of her pistols, Larry!)"
				(herMouth setScript: sFrown)
			)
			(11 ; Taste/Smell
				(Print 355 44) ; "There's an aroma of authority in the air!"
			)
			(4 ; Inventory
				(switch invItem
					(0 ; wallet
						(Print 355 45) ; "Really? I'm not that kind of girl."
						(herMouth setScript: sFrown)
					)
					(2 ; watch
						(Print 355 46) ; ""So, what time do you get off?" you ask her."
						(Print 355 47) ; ""Usually after I get home following work," she replies."
					)
					(3 ; apple
						(Print 355 48) ; "Oh, no, thanks. It is against regulations for security guards to eat while on duty."
					)
					(4 ; ring
						(Print 355 49) ; "I'm sorry," Faith replies, "but you don't know me that well!"
					)
					(5 ; whiskey
						(Print 355 50) ; "Oh, no, thanks. It is against regulations for security guards to drink while on duty."
					)
					(6 ; remoteControl
						(Print 355 51) ; "You click the remote at the security guard. As you expected, it fails to turn her on."
						(Print 355 52) ; ""Apparently your unit isn't functioning properly," she says smugly."
					)
					(7 ; rose
						(Print 355 53) ; "Oh, no, thanks. It is against regulations for security guards to accept common, ordinary, gifts while on duty."
					)
					(8 ; lubber
						(Print 355 54) ; "Yes, good idea," she smiles, caressing that pair of loaded weapons, "I try to always pack a little protection myself!"
					)
					(9 ; candy
						(Print 355 55) ; "Oh, no, thanks. It is against regulations for security guards to eat while on duty," she says. "Besides, I have to watch my girlish figure."
						(Print 355 56) ; ""That's a duty I'd be glad to volunteer for!" you think."
					)
					(10 ; discoPass
						(Print 355 57) ; "She peers closely at your disco pass. "Say, exactly what's going on here? This isn't an authorized disco-dancing-type club admittance authorization voucher, 7325B/11" she says. "I'm going to confiscate this on the grounds!""
						(gEgo put: 10) ; discoPass
					)
					(11 ; pocketKnife
						(Print 355 58) ; "An impressive weapon, Buddy!" she whispers huskily, "but you must learn how to thrust it properly!"
					)
					(12 ; wine
						(Print 355 50) ; "Oh, no, thanks. It is against regulations for security guards to drink while on duty."
					)
					(13 ; magazine
						(Print 355 59) ; "Faith has her own "Jugs," Larry!"
					)
					(14 ; hammer
						(Print 355 60) ; "You'd better not threaten me, Buddy! My weapons are bigger than yours!"
					)
					(15 ; pills
						(HandsOff)
						(gCurRoom setScript: sFaithLeaves)
					)
					(else
						(Printf 355 61 ((Inv at: invItem) description:)) ; "I'm sorry, Sir, but I'm on duty right now, and even if I were off-duty, I'd still have no use whatsoever for %s!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

