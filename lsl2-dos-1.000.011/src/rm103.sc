;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 103)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm103 0
	StartTalk 1
	StopTalk 2
)

(local
	[userLine 40]
	aSignWest
	aSignEast
	aCameraMonitor
	aTV
	aMC
	aCameraman
	aGirl
	aBoy1
	aBoy3
	aLarry
	aStoolLarry
	aApplause
)

(procedure (StartTalk who tvLoop)
	(aTV setLoop: tvLoop setCel: 0 cycleSpeed: 0 setCycle: Fwd)
	(who setCel: 0 cycleSpeed: 0 setCycle: Fwd)
)

(procedure (StopTalk who cel)
	(who setCel: (if (> argc 1) cel else 2) stopUpd:)
)

(instance theSound of Sound
	(properties
		number 108
		priority 100
		loop -1
	)
)

(instance rm103 of Rm
	(properties
		picture 103
		horizon 1
	)

	(method (init)
		(Load rsVIEW 207)
		(Load rsVIEW 212)
		(Load rsVIEW 208)
		(Load rsVIEW 209)
		(Load rsVIEW 210)
		(Load rsSOUND 108)
		(super init:)
		(theSound init:)
		((= aSignWest (Prop new:))
			view: 210
			loop: 1
			cel: 1
			posn: 97 54
			priority: 1
			ignoreActors:
			init:
			stopUpd:
		)
		((= aSignEast (Prop new:))
			view: 210
			loop: 0
			cel: 0
			posn: 197 54
			priority: 1
			ignoreActors:
			init:
			stopUpd:
		)
		((= aApplause (Prop new:))
			view: 207
			setLoop: 5
			setCel: 0
			setPri: 15
			posn: 127 16
			init:
			stopUpd:
		)
		((= aTV (Prop new:))
			view: 209
			loop: 4
			cel: 0
			posn: 49 52
			setPri: 15
			ignoreActors:
			setCycle: Fwd
			init:
		)
		((= aCameraMonitor (Prop new:))
			view: 210
			loop: 2
			posn: 276 6
			setPri: 15
			ignoreActors:
			isExtra: 1
			init:
			setCycle: Fwd
		)
		((View new:)
			view: 207
			loop: 0
			cel: 0
			posn: 31 93
			setPri: 5
			ignoreActors:
			addToPic:
		)
		((= aMC (Prop new:))
			view: 207
			loop: 1
			cel: 0
			posn: 31 78
			setPri: 5
			ignoreActors:
			stopUpd:
			init:
		)
		((View new:)
			view: 208
			loop: 0
			cel: 3
			posn: 86 66
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((= aGirl (Prop new:))
			view: 208
			setLoop: 3
			setCel: 0
			posn: 86 66
			setCycle: Fwd
			setPri: 6
			ignoreActors:
			stopUpd:
			init:
		)
		((View new:)
			view: 208
			loop: 0
			cel: 0
			posn: 170 66
			setPri: 4
			ignoreActors:
			addToPic:
		)
		((= aBoy1 (Prop new:))
			view: 208
			setLoop: 1
			setCel: 0
			posn: 170 66
			setPri: 6
			ignoreActors:
			init:
			stopUpd:
		)
		((= aStoolLarry (Prop new:))
			view: 208
			setLoop: 0
			setCel: 4
			posn: 205 88
			setPri: 4
			ignoreActors:
			init:
			stopUpd:
		)
		((= aLarry (Prop new:))
			view: 208
			setLoop: 4
			setCel: 0
			posn: 205 66
			setPri: 5
			ignoreActors:
			init:
			hide:
		)
		((View new:)
			view: 208
			loop: 0
			cel: 1
			posn: 238 66
			setPri: 2
			ignoreActors:
			addToPic:
		)
		((= aBoy3 (Prop new:))
			view: 208
			setLoop: 2
			setCel: 0
			posn: 238 66
			setPri: 3
			ignoreActors:
			init:
			stopUpd:
		)
		((= aCameraman (Act new:))
			view: 212
			loop: 0
			cel: 0
			posn: 86 144
			moveSpeed: 2
			cycleSpeed: 2
			setCycle: Walk
			setStep: 3 2
			init:
		)
		(gEgo view: 100 loop: 1 posn: 291 93 setCycle: Walk setPri: 5 init:)
		(HandsOff)
		(= gCurrentStatus 18)
		(self setScript: rm103Script)
		(aCameraman setScript: minicamScript)
	)
)

(instance rm103Script of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(if
			(and
				(== (event type:) evKEYBOARD)
				(<= KEY_SPACE (event message:) $007f)
				(or (== state 15) (== state 26))
			)
			(event claimed: 1)
			(if (!= (event message:) KEY_SPACE)
				(= userLine (event message:))
			)
			(GetInput @userLine 38 {Give her your best line...})
			(if (< (StrLen @userLine) 7)
				(Format @userLine {I dunno.})
			)
			(if (== state 15)
				(self changeState: 17)
			)
			(if (== state 26)
				(self changeState: 28)
			)
			(return)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 103 0) ; "The control room talkback speaker crackles, "Five seconds to air, boys and girls. Five seconds to air! Places, everybody!""
				(gEgo setMotion: 0)
				(= seconds 4)
			)
			(1
				(Print 103 1) ; "This doesn't look at all like you expected a lottery show to look. But, just in case, you decide to grab a seat on that empty stool over there."
				(gEgo setMotion: MoveTo 205 93 self)
				(minicamScript changeState: 7)
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo hide:)
				(aStoolLarry posn: 205 66 setCel: 2 forceUpd:)
				(aLarry show:)
				(= seconds 4)
			)
			(4
				(theSound play:)
				(Print 103 2) ; "The voiceover announcer says, "From Hollywood, it's the latest and greatest in embarrassment programming -- the all new 'Dating Connection!'""
				(StartTalk aMC 5)
				(Print 103 3 #draw) ; "And here's your host, Biff Barf!"
				(aSignWest setCycle: Fwd)
				(aSignEast setCycle: Fwd)
				(aApplause setCycle: Fwd)
				(minicamScript changeState: 3)
				(= seconds 4)
			)
			(5
				(Print 103 4) ; "Thank you and welcome; welcome, everybody! I'm so glad you're here for the all new 'Dating Connection.'"
				(Print 103 5) ; "We're just about ready to play our game, so let's meet our contestants. Who's going to make their big 'Dating Connection' today?"
				(StopTalk aMC)
				(aTV view: 209 setLoop: 3 setCel: 2 stopUpd:)
				(Print 103 6 #draw) ; "Biff, today's lovely bachelorette is Barbara Bimbo, of Airhead, California."
				(Print 103 7) ; "Barbara's hobbies are computer programming, creating unusual milkshakes, and tantalizing elderly men. She lists her turn-ons as industrial-grade blenders and RS-232 interfacing."
				(Print 103 8) ; "Turn-offs include international military conflicts and the aroma of rosin-core solder."
				(= seconds 4)
			)
			(6
				(minicamScript changeState: 7)
				(aTV view: 209 setLoop: 0 setCel: 2 forceUpd:)
				(Print 103 9 #draw) ; "On the left is bachelor number one, a professional surfboard waxer from Gumbo, Missouri. His hobbies include collecting braunschweiger casings, speculating on the sexual preference of professional dancers, and watching televised opera with the sound off."
				(Print 103 10) ; "Meet Davie Blair!"
				(= seconds 4)
			)
			(7
				(aTV view: 209 setLoop: 1 setCel: 2 forceUpd:)
				(Print 103 11 #draw) ; "Bachelor number two is today's token intellectual. He is presently chairman of the Physics Department at our local university, F.U."
				(Print 103 12) ; "Originally from Pakistan, Ohio, meet Raguka Singh Soong."
				(Print 103 13) ; "Hey, that's not your name!"
				(= seconds 2)
			)
			(8
				(Print (Format @gString 103 14 gLaffer)) ; ""Uh, excuse me," you shout. %s"
				(Print 103 15) ; "Ok, Raguka Larry," responds Biff. "Whatever you want to call yourself is ok with me!"
				(= seconds 3)
			)
			(9
				(aTV view: 209 setLoop: 2 setCel: 2 forceUpd:)
				(Print 103 16 #draw) ; "And, on the far right today is bachelor number three, a journalism major who quit college in order to pursue his dream job: fact-checker on the 'National Enquiry' newspaper."
				(Print 103 17) ; "Currently unemployed, meet A. P. Wire!"
				(= seconds 2)
			)
			(10
				(aSignWest stopUpd:)
				(aSignEast stopUpd:)
				(aApplause stopUpd:)
				(theSound stop:)
				(StartTalk aMC 5)
				(= seconds 2)
			)
			(11
				(Print 103 18) ; "And now, it's time to play 'The Dating Connection!'" says Biff Barf. "Barbara, may we have your first question please?"
				(StopTalk aMC)
				(StartTalk aGirl 3)
				(minicamScript changeState: 3)
				(= seconds 4)
			)
			(12
				(Print 103 19) ; "Ok like thanks, Biff, ya know," says Barbara. "Bachelor number one, like this one's for you!"
				(Print 103 20) ; "If I was to go like out on a you know date with you and you was like you know all dressed up or sumpthin' and like the car busted and we had to walk for help and I like broke a you know heel like how would you fix it?"
				(Print 103 21 #at -1 152) ; "("Like you know" it seems obvious her elevator doesn't reach her penthouse!)"
				(StopTalk aGirl)
				(StartTalk aBoy1 0)
				(= seconds 4)
			)
			(13
				(Print 103 22) ; "Why, beautiful, if you were with me you wouldn't have to worry about any ol' breakdown. We'd be cruisin' in my brand new Porsche, and you wouldn't have a care in the world."
				(Print 103 23) ; "Besides, if something did happen to your heel, I'd just sweep you up in these muscular arms and carry you wherever you wanted to go! When you're a top notch physical specimen like me, a light little feather like you would be a breeze."
				(Print 103 24 #at -1 152) ; "(You're sure not even this mental midget would fall for a cornball line like that!)"
				(StopTalk aBoy1)
				(StartTalk aGirl 3)
				(= seconds 4)
			)
			(14
				(Print 103 25) ; "Geeeeez, how romantic!" she gushes. "What more could any girl want?"
				(Print 103 26) ; "Well, bachelor, you're 'number one' with me!"
				(Print 103 27 #at -1 152) ; "(So much for your theory, Larry!)"
				(minicamScript changeState: 7)
				(= seconds 4)
			)
			(15
				(Print 103 28) ; "And now, how about you, bachelor number two?" she asks you. "How would you solve this puzzle?"
				(StopTalk aGirl)
				(aTV view: 209 setLoop: 1 setCel: 1 stopUpd:)
				(aLarry setCel: 1 forceUpd:)
				(Print 103 29 #draw) ; "Ok, Larry, that's your cue. You're ON!"
				(User canInput: 1)
				(= seconds 11)
			)
			(16
				(Print 103 30) ; "Well, Raguka Larry," prompts Biff Barf, "we're waiting for your answer!"
				(= state 15)
				(= seconds 11)
			)
			(17
				(= cycles 0)
				(User canInput: 0)
				(Print (Format @gString 103 31 @userLine)) ; "Uhhh, well, er," you stumble, "%s"
				(StopTalk aLarry)
				(StartTalk aGirl 3)
				(= seconds 4)
			)
			(18
				(Print 103 32) ; "Who let in that jerk?!" Barbara squeals. "What a putz!"
				(= seconds 4)
			)
			(19
				(Print 103 33) ; "Barbara attempts to assume an intelligent expression. "Now how about you bachelor number you know three?""
				(minicamScript changeState: 9)
				(StopTalk aGirl)
				(StartTalk aBoy3 2)
				(= seconds 4)
			)
			(20
				(Print 103 34) ; "Bachelorette Barbie, my deepest, personal feelings are that you are far too sexy for me ever to allow you to leave my highly-expensive, beachfront, swinging bachelor apartment."
				(Print 103 35) ; "You and I would spend all our time together alone, sharing each other in every way (if you know what I mean)!"
				(Print 103 36 #at -1 152) ; "(How's that for a way with words?)"
				(StopTalk aBoy3)
				(StartTalk aGirl 3)
				(= seconds 4)
			)
			(21
				(minicamScript changeState: 3)
				(Print 103 37) ; "Oooooh, how sexy!" she gushes. "What more could any girl want?"
				(Print 103 38) ; "You may be bachelor number three on this program, but you're 'number one' in my heart!"
				(Print 103 39 #at -1 152) ; "(Do you think anyone's still watching this tripe?)"
				(StopTalk aGirl)
				(StartTalk aMC 5)
				(= seconds 4)
			)
			(22
				(Print 103 40) ; "Barbara, in my opinion you've just asked one of our best questions ever," says Biff Barf. "Now, do you think you could come up with another great question?"
				(StopTalk aMC)
				(StartTalk aGirl 3)
				(= seconds 4)
			)
			(23
				(minicamScript changeState: 5)
				(Print 103 41) ; "Once again, Barbara burns off a few million brain cells attempting to rise to the occasion."
				(Print 103 42) ; "Ok like thanks Biff ya know," says Barbara. "Bachelor number one, like this one's for you!"
				(Print 103 43) ; "Like if you was a you know insect and like I was a you know flower what kind of you know insect would you like be and like what kind of flower am I?"
				(Print 103 44 #at -1 152) ; "(Sigh.)"
				(StopTalk aGirl)
				(StartTalk aBoy1 0)
				(= seconds 4)
			)
			(24
				(Print 103 45) ; "Barbara," responds bachelor number one, "I'd be a beautiful butterfly and you'd be my tender little buttercup. Together, we'd build a wonderful garden of love!"
				(Print 103 46 #at -1 152) ; "(At least his garden would be well-fertilized!)"
				(StartTalk aGirl 3)
				(StopTalk aBoy1)
				(= seconds 4)
			)
			(25
				(Print 103 47) ; "Like you ARE quite the charmer, aren't you, number one?" she gushes. "I'd love to sow a few seeds with you!"
				(= seconds 4)
			)
			(26
				(minicamScript changeState: 7)
				(Print 103 48) ; "Biff," she says, "MUST I like waste our time asking El Dorko this question?"
				(Print 103 49) ; "Biff responds, "Why, of course, Bachelorette Barbara. You must follow the rules!""
				(Print 103 50) ; "Ok, bore number two," she says sarcastically, "can you know even like remember the question?"
				(StopTalk aGirl)
				(aTV view: 209 setLoop: 1 setCel: 1 stopUpd:)
				(StopTalk aLarry 1)
				(Print 103 51 #draw) ; "Come on, Larry. Fire your best shot!"
				(User canInput: 1)
				(= seconds 11)
			)
			(27
				(Print 103 52) ; "Come on, El Do--, uh I mean Raguka Larry," stammers Biff Barf, "we need your answer now!"
				(= state 26)
				(= seconds 11)
			)
			(28
				(= cycles 0)
				(User canInput: 0)
				(Print (Format @gString 103 53 @userLine)) ; "Er, um, I think, ah that is," you stumble, "%s"
				(StartTalk aGirl 3)
				(StopTalk aLarry)
				(= seconds 4)
			)
			(29
				(Print 103 54) ; "Like, what planet beamed this spook down?!" she squeaks. "I've heard better lines in a you know nursing home!"
				(= seconds 4)
			)
			(30
				(Print 103 55) ; "Well, bachelor number three," she says, "I can't you know wait to learn like what insect are you and like what flower am you know I?"
				(StopTalk aGirl)
				(StartTalk aBoy3 2)
				(minicamScript changeState: 9)
				(= seconds 4)
			)
			(31
				(Print 103 56) ; "Barbie doll, you'd be my precious American Beauty rose and I'd be your little bumblebee. I know you'd enjoy rubbing a little of your pollen on MY stinger!"
				(Print 103 57 #at -1 152) ; "(Does this show supply antacids?)"
				(StartTalk aGirl 3)
				(StopTalk aBoy3)
				(= seconds 4)
			)
			(32
				(Print 103 58) ; ""Well, number three, we certainly are the oversexed little devil, aren't we?!" Barbara gushes."
				(StartTalk aMC 5)
				(StopTalk aGirl)
				(= seconds 1)
			)
			(33
				(Print 103 59) ; "Hold it right there!" interjects Biff, "I'm afraid that's all the time we have for questions today. Bachelorette Barbie: it's time for you to make your 'Dating Connection!'"
				(minicamScript changeState: 7)
				(StopTalk aMC)
				(StartTalk aGirl 3)
				(= seconds 4)
			)
			(34
				(StopTalk aGirl 2)
				(Print 103 60 #draw) ; "Barbie smiles, "Well, Biff, it's really difficult to choose; both men are really terrific!""
				(Print 103 61 #at -1 152) ; "(Something makes you feel the "both" doesn't include you!)"
				(Print 103 62) ; ""Yes, but I'm sure the audience has already made its decision," says Biff."
				(Print 103 63) ; "Yes," says Barbara, "and I've made my decision, you know, too."
				(theSound loop: -1 play:)
				(StopTalk aGirl)
				(StartTalk aMC 5)
				(aSignWest setCycle: Fwd)
				(aSignEast setCycle: Fwd)
				(aApplause setCycle: Fwd)
				(gGame changeScore: 20)
				(= seconds 5)
			)
			(35
				(Print 103 64) ; "Biff looks surprised, "Ok, bachelor TWO it is. But frankly, Bachelorette Barbara, I must admit I'm a little surprised!""
				(StopTalk aMC)
				(aLarry setLoop: 5 stopUpd:)
				(aTV setLoop: 7 setCel: 13)
				(Print 103 65 #draw #at -1 152) ; "(Did he say bachelor number TWO?)"
				(Print 103 66) ; ""Barbara, I think most of us expected a different choice!" says Biff Barf."
				(aGirl setCycle: Fwd)
				(= seconds 1)
			)
			(36
				(Print 103 67) ; "WAIT, BIFF!" shouts Barbara, "I wanted bachelor number THREE!!!"
				(StartTalk aMC 5)
				(StopTalk aGirl 2)
				(= seconds 4)
			)
			(37
				(Print 103 68) ; "I'm sorry, Barbara," says Biff, "the rules clearly state your first decision is final."
				(Print 103 69) ; "Let's find out what they've won!"
				(StopTalk aMC)
				(aTV setLoop: 6 setCel: 0 setCycle: End self cycleSpeed: 2)
			)
			(38
				(Print 103 70) ; "The voiceover announcer booms, "It's a CRUISE!""
				(Print 103 71 #at -1 152) ; "(audience goes oooooh)"
				(Print 103 72) ; "Yes, a romantic cruise of the South Pacific on the beautiful U.S.S. Love Tub."
				(aTV setLoop: 7 setCel: 0 setCycle: End self)
			)
			(39
				(Print 103 73 #draw) ; "You'll spend a solid MONTH together, exploring exotic ports of call courtesy of Wonder Cruise Lines."
				(Print 103 74) ; "Remember: if it's a good cruise, it's a Wonder!"
				(= seconds 4)
			)
			(40
				(Print 103 75) ; "And for our other contestants, why, you lucky fellows have won a year's supply of armadillo polish, twenty cases of black shoe laces, plus a copy of our home game."
				(aLarry setLoop: 4)
				(StartTalk aGirl 3)
				(= seconds 4)
			)
			(41
				(Print 103 76) ; "Hey, man! There ain't no way I'm spendin' no month on a boat with this jerk," shouts the delicate Bachelorette Barbara. "I wanna chance to hit on that number three guy!!"
				(StopTalk aGirl 2)
				(StartTalk aMC 5)
				(= seconds 4)
			)
			(42
				(Print 103 77) ; "I'm sure she's really truly delighted, folks," says Biff attempting to cover, "Now come on -- let's really hear it for our lucky couple."
				(Print 103 78 #at -1 152) ; "(a smattering of applause)"
				(Print 103 79) ; "The voiceover announcer says, "Be sure to tune in tomorrow night, same time, same station, for the finest in embarrassment programming: the all new 'Dating Connection.' Good night.""
				(theSound stop:)
				(StopTalk aMC)
				(aSignWest stopUpd:)
				(aSignEast stopUpd:)
				(aApplause stopUpd:)
				(aTV loop: 4 setCycle: Fwd)
				(aCameraman setCycle: Beg)
				(= seconds 2)
			)
			(43
				(Print 103 80) ; "The control room speaker crackles, "Ok, gang, that's another one in the can! Raguka Larry, please report to the green room to receive your prizes. The rest of you just stay where you are!""
				(= seconds 2)
			)
			(44
				(= seconds 2)
				(aLarry hide:)
				(aStoolLarry posn: 205 88 setCel: 4 forceUpd:)
				(gEgo loop: 0 show:)
			)
			(45
				(gEgo setMotion: MoveTo 291 93 self)
			)
			(46
				(Print 103 81) ; "Gosh, Larry, what good luck you have: winning a fun-filled, month-long cruise with that lovely bachelorette Barbara!"
				(gCurRoom newRoom: 102)
			)
		)
	)
)

(instance minicamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aCameraman loop: 2 setCycle: End self)
			)
			(2
				(aCameraman stopUpd:)
			)
			(3
				(aCameraman setCycle: Beg self)
			)
			(4
				(aCameraman setCycle: Walk setMotion: MoveTo 86 144 self)
				(= state 0)
			)
			(5
				(aCameraman setCycle: Beg self)
			)
			(6
				(aCameraman setCycle: Walk setMotion: MoveTo 170 144 self)
				(= state 0)
			)
			(7
				(aCameraman setCycle: Beg self)
			)
			(8
				(aCameraman setCycle: Walk setMotion: MoveTo 205 144 self)
				(= state 0)
			)
			(9
				(aCameraman setCycle: Beg self)
			)
			(10
				(aCameraman setCycle: Walk setMotion: MoveTo 238 144 self)
				(= state 0)
			)
		)
	)
)

