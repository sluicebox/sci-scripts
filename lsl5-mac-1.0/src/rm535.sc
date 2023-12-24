;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 535)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm535 0
)

(local
	cueCounter
	oldTime
	secsInRoom
	[unused 2]
	giveItems
	didSomething
	loserCounter
)

(procedure (BranchIt)
	(Reset)
	(mEyes hide:)
	(switch (++ giveItems)
		(1
			(if (or (gEgo has: 12) (gEgo has: 13) (gEgo has: 11)) ; Money, Credit_Cards, DayTrotter
				(gCurRoom setScript: sSuckFinger)
			else
				(gCurRoom setScript: sStartGoDown)
			)
		)
		(2
			(if (or (gEgo has: 12) (gEgo has: 13) (gEgo has: 11)) ; Money, Credit_Cards, DayTrotter
				(gCurRoom setScript: sCherry)
			else
				(gCurRoom setScript: sStartGoDown)
			)
		)
		(3
			(gCurRoom setScript: sStartGoDown)
		)
	)
)

(procedure (Reset)
	(= didSomething 1)
	(= loserCounter 0)
)

(instance rm535 of LLRoom
	(properties
		lookStr {You are sitting with the gorgeous Michelle Milken in an exclusive private booth in the exclusive Herman Hollerith Room in the exclusive Hard Disk Cafe in exclusive New York City, trying hard not to stare through her see-through blouse.}
		picture 535
	)

	(method (init)
		(super init:)
		(HandsOff)
		(michelle init: stopUpd: setScript: sConversation)
		(if (not (IsFlag 16)) ; fMCloseUp
			(Load rsSOUND 536)
			(mEyes init: setScript: sBlink)
			(mMouth init: hide:)
			(iceCream init:)
			(cherry init:)
			(HandsOn)
			(gTheIconBar disable: 0)
			(User canControl: 0)
		else
			(michelle view: 540)
			(iceCream init:)
			(mMouth init: hide:)
			(LoadMany rsSOUND 538 537)
			(if (not (IsFlag 40)) ; fCherryGone
				(cherry init:)
			)
			(self setScript: sGoDown)
		)
		(face init:)
		(tits init:)
	)

	(method (doit)
		(super doit:)
		(if (and (not script) (!= oldTime (GetTime 1))) ; SysTime12
			(= oldTime (GetTime 1)) ; SysTime12
			(if (== (++ loserCounter) 90)
				(Reset)
				(HandsOff)
				(self setScript: sLoser)
			)
			(if (and (not didSomething) (== (++ secsInRoom) 60))
				(TPrint 535 0) ; "Perhaps you should take the initiative, Larry. You've been sitting there for over a minute now. Try something!"
			)
		)
	)
)

(instance sLoser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say Michelle_Milken 535 1 108 139 self) ; "You know, Larry, it's nice just sitting here with you, but I'm going to have to run. I've got a big, uh, er, `bored' meeting I'm late for. Maybe I'll see you around, eh?"
			)
			(1
				(gCast eachElementDo: #dispose)
				(DrawPic 1 6)
				(michelle hide:)
				(Say gEgo 535 2 67 -1 185) ; "Wait, Michelle!" you cry as she leaves, "I've still got a few things left to say..."
				(= seconds 3)
			)
			(2
				(TPrint 535 3) ; "Well, Larry, you "blew" that one!"
				(= seconds 3)
			)
			(3
				(TPrint 535 4) ; "Hanging your head in shame, you wander back to the lobby."
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sGoDown of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and (== (gTheMusic number:) 538) (== (gTheMusic prevSignal:) 10))
			(gTheMusic number: 538 play:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(michelle view: 540 setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(2
				(iceCream hide:)
				(if (IsObject cherry)
					(cherry hide:)
				)
				(michelle setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(soundFX number: 537 play:)
				(= seconds 3)
			)
			(5
				(soundFX stop:)
				(michelle setLoop: 1 setCel: 0 setCycle: End self)
			)
			(6
				(= seconds 3)
			)
			(7
				(mMouth
					view: 540
					setLoop: 3
					setCel: 0
					x: (- (mMouth x:) 1)
					setPri: 14
					show:
					setCycle: End self
				)
			)
			(8
				(= seconds 2)
			)
			(9
				(mMouth hide:)
				(michelle view: 541 setCel: 0 cycleSpeed: 18 setCycle: End self)
				(iceCream setCel: 1 x: (michelle x:) y: (michelle y:) show:)
			)
			(10
				(= seconds 3)
			)
			(11
				(michelle hide:)
				(iceCream dispose:)
				(cherry dispose:)
				(DrawPic 1 6)
				(= ticks 34)
			)
			(12
				(michelle view: 545 posn: 192 119 setLoop: 0 setCel: 0 show:)
				(DrawPic 535 16384)
				(= seconds 4)
			)
			(13
				(michelle setCel: 1)
				(TPrint 535 5) ; "Oh, NOW you get her drift!"
				(if (>= ((Inv at: 0) state:) 100) ; Camcorder
					(RecordTape 2)
					(Points 20 117)
					(TPrint 535 6) ; "You're almost sorry you're recording all this. What will the boys in Hollywood think?"
				else
					(TPrint 535 7) ; "What a shame you didn't get this on tape, Larry!"
				)
				(= seconds 4)
			)
			(14
				(michelle setLoop: 1 setCel: 0)
				(= seconds 4)
			)
			(15
				(michelle setCel: 1)
				(= seconds 4)
			)
			(16
				(michelle setCel: 2)
				(= seconds 4)
			)
			(17
				(gCast eachElementDo: #dispose)
				(DrawPic 1 6)
				(michelle hide:)
				(= seconds 3)
			)
			(18
				(if (gEgo has: 12) ; Money
					(gEgo put: 12) ; Money
					(TPrint 535 8) ; "You more than willingly give all your money to Michelle!"
				)
				(if (gEgo has: 13) ; Credit_Cards
					(gEgo put: 13) ; Credit_Cards
					(TPrint 535 9) ; "You think, "I don't need those credit cards," so you gladly offer them to Michelle, in return for a little more of the same!"
				)
				(if (gEgo has: 11) ; DayTrotter
					(gEgo put: 11) ; DayTrotter
					(TPrint 535 10) ; "Leafing through your DayTrotter\05 with Michelle, she expresses an interest in some of those cryptic numbers listed beside the notation "Swiss Accounts." You allow her to keep the book, since you have no interest in chocolate."
				)
				(Points 40 116)
				(TPrint 535 11) ; "After a few more minutes with Michelle, you stagger to your feet and attempt to walk back to the Hard Disk Cafe lobby."
				(= cycles 2)
			)
			(19
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= seconds (Random 1 4))
			)
			(1
				(mEyes setCycle: End self)
			)
			(2
				(= cycles (Random 1 3))
			)
			(3
				(mEyes setCycle: Beg self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance sSuckFinger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mEyes hide:)
				(michelle view: 536 setCel: 0 cycleSpeed: 16 setLoop: 0)
				(= ticks 123)
			)
			(1
				(michelle setCycle: CT 7 1 self)
			)
			(2
				(= seconds 5)
			)
			(3
				(michelle setCycle: End self)
			)
			(4
				(michelle view: 535 setLoop: 0 cycleSpeed: 10 stopUpd:)
				(= seconds 2)
			)
			(5
				(Say Michelle_Milken 535 12 108 139 self) ; "Oh, Larry. Don't you just love stiff cream?"
				(mEyes show:)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sCherry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mEyes hide:)
				(michelle view: 535 setLoop: 0 stopUpd:)
				(mMouth show: setLoop: 5 setCel: 0 setCycle: End self)
			)
			(1
				(soundFX number: 536 loop: 1 play:)
				(= ticks 30)
			)
			(2
				(cherry setLoop: 7 setCycle: End cherry)
				(mMouth setCycle: Beg self)
			)
			(3
				(cherry hide:)
				(mMouth hide:)
				(= seconds 2)
			)
			(4
				(SetFlag 40) ; fCherryGone
				(Say gEgo 535 13 67 -1 185) ; ""Well, there goes her cherry," you think."
				(mEyes show:)
				(HandsOn)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sStartGoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFFRoom 510)
				(Say Michelle_Milken 535 14 108 139 self) ; "Oooooh, Larry!" says Michelle. "I know a way we can `increase your interest!'"
			)
			(1
				(= seconds 2)
			)
			(2
				(TPrint 535 15 67 -1 185) ; "(What does she mean by that, Larry?)"
				(= seconds 2)
			)
			(3
				(Say Michelle_Milken 535 16 108 139 self) ; "You're a `software' kind of guy and I'm a `hardware' kind of girl," she says. "How about if I `download onto your hard disk?'"
			)
			(4
				(= seconds 2)
			)
			(5
				(Say Michelle_Milken 535 17 108 139 self) ; "Allow me to make our booth more private."
			)
			(6
				(gCurRoom newRoom: 530)
			)
		)
	)
)

(instance sTrotter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say gEgo 535 18) ; "Would you be interested in this?" you ask. "It's `my' personal organizer and contains a list of all `my' Swiss bank accounts, off-shore deposits, and international funds."
				(Say Michelle_Milken 535 19 108 139 self) ; ""Well, I don't know," she pretends to hesitate."
			)
			(1
				(gEgo put: 11) ; DayTrotter
				(Points 5 112)
				(Say Michelle_Milken 535 20 108 139 self) ; "Why, yes," she says with a big smile, "I'm sure I could `invest' these for you tomorrow! Trust me!"
			)
			(2
				(BranchIt)
			)
		)
	)
)

(instance sCreditCards of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say gEgo 535 21) ; "Would you be interested in this?" you ask. "These credit cards would surely be useful to you if you ever need to withdraw funds. You know, cash advances, things like that?"
				(gEgo put: 13) ; Credit_Cards
				(Points 5 113)
				(Say Michelle_Milken 535 22 108 139 self) ; "Oohh," she squeals, "perhaps I haven't mentioned how much stock I put in these things! And what a smart rubber band you have around them!"
			)
			(1
				(BranchIt)
			)
		)
	)
)

(instance sMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Say gEgo 535 23) ; "I also have this little bit of cash on me," you say, offering it to her. "Could you make some investments for me with this?"
				(gEgo put: 12) ; Money
				(Points 5 114)
				(Say Michelle_Milken 535 24 108 139 self) ; "Oh, could I?!" she cries. "As my friend, Donald Tramp says, `cash is king!'"
			)
			(1
				(BranchIt)
			)
		)
	)
)

(instance sConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(Say gEgo 535 25 67 -1 185) ; "Did I mention my name?" you ask. "I didn't think so. My name is Larry; Larry Laffer."
				(Say Michelle_Milken 535 26 108) ; "Good evening, Lawrence," she says, "I'm Michelle Milken, program-trading specialist and sometime computer hobbyist."
			)
			(2
				(Say gEgo 535 27 67 -1 185) ; "I'm really into computers," you say, exposing wisdom beyond your years. "In fact, I've written a couple of very successful computer games. At least, I think I have."
				(Say Michelle_Milken 535 28 108 139 self) ; "Oh, really?" asks Michelle. "Does that mean you have lots of money?"
			)
			(3
				(Say gEgo 535 29 67 -1 185) ; "I make a nice living, er, well, that is, I think I did!" you say. "But now I'm not so sure. You see, I've been having a little trouble lately with amnesia. So what is it that you do?"
				(Say Michelle_Milken 535 30 108) ; "I laugh all the way to and from the bank!" she says with a grin. "I'm a junk bond dealer."
			)
			(4
				(Say gEgo 535 31 67 -1 185) ; ""So, what does a junk bond dealer do?" you ask."
				(Say Michelle_Milken 535 32 108 139 self) ; ""Whatever she can," Michelle replies cryptically."
			)
			(5
				(Say gEgo 535 33 67 -1 185) ; "I've been hearing lots of good things recently about junk bonds," you say. "Would you recommend them as an integral part of my portfolio?"
				(Say Michelle_Milken 535 34 108) ; "Junk bonds, eh?" she warms perceptibly. "Why I was just telling a friend about them today. Yes, I think they would be perfect for someone like you!"
			)
			(6
				(Say gEgo 535 35 67 -1 185) ; "Really? I always thought investments like that were too risky for an ordinary guy like me!"
				(Say Michelle_Milken 535 36 108 139 self) ; "Larry, no one I know would ever admit to thinking that you are in any way, shape, or form, `ordinary!'"
			)
			(7
				(Say Michelle_Milken 535 37 108 139 self) ; "So, do you have any cash-equivalent funds lying about, just gathering whatever conservative interest rate you're presently earning?"
			)
			(8
				(Say gEgo 535 38 67 -1 185) ; ""Well, no, Michelle, I don't," you say."
			)
			(9
				(Say gEgo 535 39 67 -1 185) ; "Michelle, I just thought of something!" you say. "I might just have lots of royalties waiting for me from my last job. Of course, I can't quite remember if I do or not, but it is something to consider."
				(Say Michelle_Milken 535 40 108 139 self) ; "And consider it I do, Larry," Michelle replies. "In fact, perhaps I could open your account right now."
			)
			(10
				(Points 5 115)
				(Say gEgo 535 41 67 -1 185) ; "Huh? Well, oh, I don't... Ohhh!" you say as a big smile crosses your lips. "Well, okay, Michelle, have it your way!"
				(HandsOff)
				(gCurRoom setScript: sStartGoDown)
			)
		)
	)
)

(instance michelle of Actor
	(properties
		x 150
		y 105
		description {Michelle Milken}
		sightAngle 90
		yStep 1
		view 535
		priority 3
		signal 20496
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 535 42) ; "You can see why this woman made the finals back at good ol' PornProdCorp! She has to be one of the sexiest babes YOU'VE ever seen!"
				(TPrint 535 43 67 -1 185) ; "(But she sure has a funny way of eating ice cream!)"
			)
			(3 ; Do
				(TPrint 535 44) ; "While you may wish to reach across the table and grab her, your professional attitude and loyalty to your employer prevent such blatant, crass behavior."
			)
			(10 ; Zipper
				(Say Michelle_Milken 535 45 108) ; "Hmmm," says Michelle, with a coy smile, "that's an idea!"
			)
			(4 ; Inventory
				(switch invItem
					(12 ; Money
						(HandsOff)
						(Reset)
						(gCurRoom setScript: sMoney)
					)
					(13 ; Credit_Cards
						(HandsOff)
						(Reset)
						(gCurRoom setScript: sCreditCards)
					)
					(11 ; DayTrotter
						(HandsOff)
						(Reset)
						(gCurRoom setScript: sTrotter)
					)
					(6 ; Hard_Disk_Cafe_Napkin
						(TPrint 535 46) ; "Yeah, that ought to impress her, Larry. Give her a napkin that she could pick up off any table in the building!"
					)
					(else
						(Say Michelle_Milken 535 47 108) ; "Oh, no thanks, Larry," responds Michelle. "I have no idea what I'd do with that."
					)
				)
			)
			(5 ; Talk
				(= didSomething 1)
				(sConversation cue:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mEyes of Prop
	(properties
		x 153
		y 65
		description {her eyes}
		sightAngle 90
		lookStr {Her sultry eyes burn into your soul.}
		view 535
		loop 2
		priority 13
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(michelle doVerb: theVerb invItem)
	)
)

(instance mMouth of Prop
	(properties
		x 153
		y 68
		description {her mouth}
		sightAngle 90
		lookStr {Her lips are moist and inviting.}
		view 535
		loop 4
		priority 14
		signal 16400
		cycleSpeed 10
	)

	(method (doVerb theVerb invItem)
		(michelle doVerb: theVerb invItem)
	)
)

(instance iceCream of View
	(properties
		x 151
		y 126
		nsTop 118
		nsLeft 137
		nsBottom 142
		nsRight 165
		description {the ice cream}
		sightAngle 90
		lookStr {You love ice cream. Especially ice cream that's sitting where THAT ice cream is!}
		view 535
		loop 6
		signal 16384
	)
)

(instance cherry of Prop
	(properties
		x 148
		y 101
		description {her cherry}
		sightAngle 90
		lookStr {Her cherry looks soft, red, ripe and ready for the picking!}
		view 535
		loop 9
		cel 1
		priority 14
		signal 16400
	)

	(method (cue)
		(super cue:)
		(self dispose:)
	)
)

(instance tits of Feature
	(properties
		x 151
		y 130
		nsTop 107
		nsLeft 130
		nsBottom 127
		nsRight 172
		description {her breasts}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Say Michelle_Milken 535 48 108) ; "You really enjoy staring at me there, don't you, Larry?"
			)
			(3 ; Do
				(TPrint 535 49) ; "There's plenty of time for that later, Larry!"
			)
			(else
				(michelle doVerb: theVerb invItem)
			)
		)
	)
)

(instance face of Feature
	(properties
		x 155
		y 130
		nsTop 49
		nsLeft 132
		nsBottom 93
		nsRight 179
		description {her face}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 535 50) ; "This is a face you could dream about, Larry!"
			)
			(3 ; Do
				(Say Michelle_Milken 535 51 108) ; "I like it when you stroke my face, Larry!"
			)
			(else
				(michelle doVerb: theVerb invItem)
			)
		)
	)
)

(instance Michelle_Milken of Talker
	(properties
		name {Michelle Milken}
		x 8
		y 5
		nsTop 58
		nsLeft 142
		view 1535
		loop 1
		talkWidth 300
	)

	(method (init)
		(= eyes MMEyes)
		(= mouth MMMouth)
		(super init: &rest)
	)
)

(instance MMEyes of Prop
	(properties
		nsLeft 1
		view 1535
		loop 2
		signal 16384
		cycleSpeed 25
	)
)

(instance MMMouth of Prop
	(properties
		nsTop 10
		nsLeft 7
		view 1535
		signal 16384
	)
)

(instance soundFX of Sound
	(properties
		flags 1
		loop -1
	)
)

