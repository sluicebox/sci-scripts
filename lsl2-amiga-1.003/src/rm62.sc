;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
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
	rm62 0
)

(local
	cartsInAisle
	sawCartMessage
	firstTime
)

(instance rm62 of Rm
	(properties
		picture 62
	)

	(method (init)
		(Load rsVIEW 611)
		(Load rsVIEW 610)
		(Load rsVIEW 604)
		(Load rsVIEW 223)
		(if (gEgo has: 26) ; Pamphlet
			(Load rsVIEW 26)
		)
		(Load rsSOUND 105)
		(theSound init:)
		(super init:)
		(aBore setPri: 5)
		(if (== gBoreStatus 255)
			(aBore setLoop: 3 stopUpd: init:)
		else
			(aBore setLoop: 0 stopUpd: init:)
		)
		(aCartLeft yStep: 8 setCycle: Walk init: setScript: cartLeftScript)
		(aCartRight yStep: 8 setCycle: Walk init: setScript: cartRightScript)
		(self setRegions: 600 setScript: rm62Script) ; rm600
		(if (== gCurrentStatus 9)
			(= firstTime 1)
		else
			(NormalEgo)
		)
		(if firstTime
			(= firstTime 0)
			(HandsOff)
			(rm62Script changeState: 1)
			(aStewardess init: setCycle: Walk)
		)
		(if (== gPrevRoomNum 63)
			(gEgo posn: 298 101)
		else
			(gEgo posn: 37 101)
		)
		(gEgo init:)
	)
)

(instance rm62Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== gCurrentStatus 0)
			(if (& (gEgo onControl:) $0002)
				(gCurRoom newRoom: 61)
			)
			(if (& (gEgo onControl:) $0004)
				(gCurRoom newRoom: 63)
			)
		)
		(if (== state 18)
			(ShakeScreen 1 (Random 1 3))
		)
		(if (and (== gCurrentTimer 5) (not gRgTimer) (== gCurrentStatus 1009))
			(= gCurrentStatus 1000)
			(= gCurrentTimer 0)
			(rm62Script changeState: 21)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,talk,finger,talk/woman,cart,woman')
			(if (== cartsInAisle 0)
				(Print 62 0) ; "Whenever you need a stewardess, they're never around."
			else
				(Print 62 1) ; "Why is it they only serve drinks whenever you want to walk around the plane?"
			)
		)
		(if (Said 'pull,pull/cart')
			(if (== cartsInAisle 0)
				(Print 62 2) ; "Where?"
			else
				(Print 62 3) ; "There's no way you can affect them!"
			)
		)
		(if (Said 'look>')
			(if (Said '/bra,barstool,barstool')
				(if ((gInventory at: 27) ownedBy: gCurRoomNum) ; Airsick_Bag
					(Print 62 4) ; "There's nothing there but an airsick bag."
				else
					(Print 62 5) ; "It's empty."
				)
			)
			(if (Said '/man')
				(if (== gBoreStatus 255)
					(Print 62 6) ; "He's fascinated by that pamphlet!"
				else
					(Print 62 7) ; "He has a deadly glint in his eyes."
				)
			)
			(if (Said '[/airline,airport]')
				(if ((gInventory at: 27) ownedBy: gCurRoomNum) ; Airsick_Bag
					(Print 62 8) ; "There's not even a magazine to read in the seatback pocket in front of you; nothing but a slightly crumpled airsick bag."
				else
					(Print 62 9) ; "Boy, are these the cheap seats!"
				)
			)
		)
		(if (Said 'bath')
			(cond
				((== gCurrentStatus 1009)
					(YouAre) ; "You are."
				)
				((not (gEgo inRect: 158 94 194 106))
					(NotClose) ; "You're not close enough."
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(gEgo setScript: sittingScript)
					(sittingScript changeState: 1)
				)
			)
		)
		(if (and (== gCurrentStatus 1009) (Said 'free,afix/belt'))
			(Ok) ; "Ok."
		)
		(if (or (Said 'new,(get<up),(new<up)') (Said 'disembark[/barstool]'))
			(cond
				((== gCurrentStatus 0)
					(YouAre) ; "You are."
				)
				((!= gCurrentStatus 1009)
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(gEgo setScript: sittingScript)
					(sittingScript changeState: 6)
				)
			)
		)
		(if (Said 'buy,get,buy/drink')
			(cond
				((not cartsInAisle)
					(Print 62 2) ; "Where?"
				)
				((== gCurrentStatus 1009)
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 62 10) ; "I'm sorry, sir," responds the stewardess, "you must return to your seat before I can serve you."
				)
			)
		)
		(if (Said 'talk/man,man')
			(Print 62 11) ; "You'd rather not. Besides, the only person he wants to hear is himself!"
		)
		(if (Said 'give,apply/pamphlet')
			(cond
				((not (gEgo has: 26)) ; Pamphlet
					(DontHave) ; "You don't have it."
				)
				((!= gCurrentStatus 1009)
					(NotClose) ; "You're not close enough."
				)
				(else
					(gEgo put: 26 -1) ; Pamphlet
					(gGame changeScore: 8)
					(boreScript changeState: 10)
					(Print 62 12 #icon 26 0 0) ; "Instantly intrigued by the fascinating treatise, Ken finally leaves you alone."
					(Print 62 13) ; "The question is: have those stewardesses finished serving drinks?"
				)
			)
		)
		(if (Said 'get/bag')
			(cond
				((not ((gInventory at: 27) ownedBy: gCurRoomNum)) ; Airsick_Bag
					(AlreadyTook) ; "You already took it."
				)
				((!= gCurrentStatus 1009)
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 62 14) ; "You slowly slip your hand inside the slightly sticky seatback pocket and slide out the semi-soiled airsick bag."
					(Print 62 15 #at -1 130) ; "(If you didn't need it before, you need it now!)"
					(gEgo get: 27) ; Airsick_Bag
					(gGame changeScore: 5)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds 3)
			)
			(2
				(Print 62 16) ; "Well. Things are slightly closer back here!"
				(gEgo setMotion: MoveTo 169 102 self)
			)
			(3
				(= seconds 3)
			)
			(4
				(Print 62 17) ; "No way!" you think to yourself. "I can't possibly fit into such a skinny place."
				(= seconds 3)
			)
			(5
				(Print 62 18) ; "Well, here goes..."
				(gEgo
					view: 163
					setLoop: 0
					illegalBits: 0
					setCel: 0
					cycleSpeed: 4
					posn: 166 97
					setCycle: End self
				)
			)
			(6
				(gEgo
					setLoop: 1
					cycleSpeed: 2
					setCycle: Fwd
					moveSpeed: 10
					setStep: 1 1
					setPri: 6
					setMotion: MoveTo 167 94
				)
				(= cycles 40)
			)
			(7
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 167 93
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(8
				(gEgo stopUpd:)
				(Print 62 19) ; "Whew!"
				(= seconds 4)
			)
			(9
				(aStewardess posn: 11 101 setMotion: MoveTo 50 102 self)
			)
			(10
				(aStewardess setLoop: 3 setCycle: Fwd)
				(= seconds 3)
			)
			(11
				(Print 62 20) ; "Good afternoon, ladies uh, er, gentlemen," says the cute stewardess. "I'd like to welcome you aboard Flight 1."
				(= seconds 3)
			)
			(12
				(Print 62 21) ; ""In the unlikely event of a water landing, there's no need to panic--because we'll all be dead anyway!" she laughs."
				(Print 62 22) ; "Now don't get upset, that's just a little airline humor!"
				(= seconds 3)
			)
			(13
				(aStewardess setLoop: 2)
				(= seconds 2)
			)
			(14
				(Print 62 23) ; "Oh, and if during our flight those cute little yellow masks happen to drop down from their overhead compartments... why, just ignore them. Lately, those practical jokers in maintenance have been substituting nitrous oxide for the oxygen again!"
				(aStewardess setLoop: 3)
				(= seconds 3)
			)
			(15
				(Print 62 24) ; "And remember: in case of an emergency, we women get to leave first!"
				(Print 62 25) ; ""Are there any questions?" she asks, while leaving."
				(aStewardess
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 11 102 self
				)
			)
			(16
				(aStewardess dispose:)
				(= seconds 5)
			)
			(17
				(Print 62 26) ; "A voice crackles through the loudspeakers, "Please fasten your seatbelt and move your seatback and tray table to their fully upright and locked positions. We have just been cleared for takeoff.""
				(= seconds 5)
			)
			(18
				(= seconds 3)
			)
			(19
				(Print 62 27) ; "The captain's voice returns, "We have reached our cruising altitude...""
				(Print 62 28 #at -1 130) ; "(Pretty fast takeoff, wasn't it?)"
				(Print 62 29) ; "...of 500 feet!"
				(Print 62 30) ; "Passengers in our rear smoking compartment may smoke 'em if you gottem."
				(= seconds 6)
			)
			(20
				(Print 62 31) ; "We hope you enjoy your flight. Our ETA is approximately ten minutes. Your lovely stewardesses will be serving drinks shortly. (But that's just because we couldn't hire any taller stewardesses!)"
				(Print 62 32) ; "The man sitting next to you responds to the captain's lame quip with a hearty, "Har, har, har!""
				(aBore setScript: boreScript)
				(gEgo setScript: sittingScript)
				(sittingScript changeState: 5)
			)
			(21
				(HandsOff)
				(Print 62 33) ; "The airplane's PA system again crackles to life, "Ladies and gentlemen, we are starting our final descent at this time.""
				(= seconds 2)
			)
			(22
				(Print 62 34) ; "Ok, we've landed!"
				(Print 62 35 #at -1 130) ; "(That was even faster than the takeoff!)"
				(Print 62 36) ; "On behalf of the entire crew of Flight #1, we'd like to welcome you to Calwa where the local time is up!"
				(Print 62 37) ; "Please remain in your seats, we have some members of the local police force coming aboard to check for contraband."
				(= seconds 3)
			)
			(23
				(aCartLeft
					view: 223
					posn: 20 103
					setLoop: -1
					setCycle: Walk
					show:
					setMotion: MoveTo 140 104
				)
				(aCartRight
					view: 223
					posn: 308 103
					setLoop: -1
					setCycle: Walk
					show:
					setMotion: MoveTo 210 104 self
				)
				(theSound play:)
			)
			(24
				(Print 62 38) ; "Something makes you believe these two are no "local police.""
				(Print 62 39) ; "There must be some way you could escape from this airplane before it lands!"
				(Print 62 40) ; ""Ah, ha! Ve ghot you again, monkey breath!" shouts the KGB agent."
				(Print 62 41) ; "Hang on, Larry. Here we go again!!"
				(= gCurrentStatus 23)
				(gCurRoom newRoom: 96)
			)
		)
	)
)

(instance sittingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= seconds (= cycles 0))
				(HandsOff)
				(cartLeftScript changeState: 4)
				(cartRightScript changeState: 4)
				(gEgo setMotion: MoveTo 169 98 self)
			)
			(2
				(gEgo
					view: 163
					setLoop: 0
					setCel: 0
					cycleSpeed: 4
					posn: 166 97
					setCycle: End self
				)
			)
			(3
				(gEgo
					setLoop: 1
					cycleSpeed: 2
					setCycle: Fwd
					setPri: 6
					moveSpeed: 10
					setStep: 1 1
					setMotion: MoveTo 166 94
					illegalBits: 0
				)
				(= seconds 3)
			)
			(4
				(gEgo
					setLoop: 2
					setCel: 0
					posn: 167 93
					cycleSpeed: 4
					setCycle: End self
				)
				(if (!= gBoreStatus 255)
					(aBore setScript: boreScript)
				)
			)
			(5
				(= seconds (= cycles 0))
				(gEgo setCel: setMotion: 0 stopUpd:)
				(= gCurrentStatus 1009)
				(User canControl: 0 canInput: 1)
			)
			(6
				(HandsOff)
				(= seconds (= cycles 0))
				(gEgo
					cycleSpeed: 4
					setLoop: 2
					setCel: 255
					setCycle: Beg self
					setMotion: 0
				)
				(boreScript changeState: 9)
				(if (!= gBoreStatus 255)
					(cartLeftScript changeState: 1)
					(cartRightScript changeState: 1)
					(= cartsInAisle 1)
					(gEgo observeControl: 16384)
				)
			)
			(7
				(gEgo
					setLoop: 1
					cycleSpeed: 2
					setCycle: Fwd
					posn: 166 93
					setPri: -1
					setMotion: MoveTo 166 98
				)
				(= seconds 3)
			)
			(8
				(gEgo
					setLoop: 0
					setCel: 255
					moveSpeed: 0
					setStep: 3 2
					setCycle: Beg self
					cycleSpeed: 4
				)
			)
			(9
				(gEgo posn: 169 97)
				(NormalEgo 1)
			)
		)
	)
)

(instance cartLeftScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aCartLeft posn: 20 103 setMotion: MoveTo 140 104 self)
			)
			(2
				(aCartLeft setMotion: MoveTo 30 104 self)
			)
			(3
				(if (== gCurrentStatus 1009)
					(self changeState: 4)
				else
					(= state 0)
					(= cycles (Random 5 30))
				)
			)
			(4
				(= seconds (= cycles 0))
				(aCartLeft setMotion: MoveTo 20 104 self)
			)
			(5
				(= cartsInAisle 0)
				(aCartLeft posn: -1020 103)
			)
		)
	)
)

(instance cartRightScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aCartRight posn: 308 103 show: setMotion: MoveTo 210 104 self)
				(Print 62 42 #draw) ; "Drinks? Drinks, anyone?"
			)
			(2
				(aCartRight setMotion: MoveTo 308 104 self)
			)
			(3
				(if (== gCurrentStatus 1009)
					(self changeState: 4)
				else
					(= state 0)
					(= cycles (Random 5 30))
				)
			)
			(4
				(= seconds (= cycles 0))
				(aCartRight setMotion: MoveTo 308 104 self)
			)
			(5
				(= cartsInAisle 0)
				(aCartRight posn: 1308 103)
			)
		)
	)
)

(instance boreScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aBore init: setLoop: 0 setCycle: End self)
			)
			(1
				(aBore setLoop: 1 setCycle: Fwd)
				(= seconds (Random 2 4))
			)
			(2
				(switch (++ gBoreStatus)
					(1
						(Print 62 43) ; "Hey," says the man beside you, in his too-loud voice, "I remember you: you're that guy from Lefty's Bar! I haven't seen you in a long time."
						(Print 62 44) ; "Let me tell you this new joke I heard..."
						(Print 62 45) ; "No way," you respond, "no jokes! All you ever told me was punch lines!"
					)
					(2
						(Print 62 46) ; "Once again, the bore attempts to strike up a conversation."
						(Print 62 47) ; "Say, I don't believe we've ever met. My name is Ken; what's yours?"
						(Print gLaffer)
						(Print 62 48) ; "Well, Larry, what kind of work are you in?"
						(Print 62 49) ; "I'm not," you reply, "I'm recently incredibly rich."
						(Print 62 50) ; "Oh."
						(Print 62 51 #at -1 130) ; "(Well, that's one way to stifle him, Larry!)"
					)
					(3
						(Print 62 52) ; "Say, Larry, I'm expecting to be wealthy soon myself," he continues. "Yep, just bought into a big, national franchise. Pretty soon I'll be rolling in it!"
						(Print 62 53) ; "Define "it," you think to yourself!"
					)
					(4
						(Print 62 54) ; "'Great market opportunity,' this guy told me. 'Can't miss deal,' he said. 'Always a steady stream of new customers,' he says."
						(Print 62 55) ; ""Betcha you'll never guess my new business," he concludes."
						(Print 62 56) ; "You win."
						(Print 62 57) ; "HAIR TRANSPLANTS!"
						(Print 62 58) ; "Yep, that's the ticket! You know, transplants are so easy nowadays that anybody can perform 'em," he spouts. "Even a guy like me, with nothing but a correspondence course!"
						(Print 62 59) ; "You scan the aircraft for empty seats."
						(Print 62 60) ; "You find none!"
					)
					(5
						(Print 62 61) ; "You know lil' buddy, I'm lookin' to get my first real scalp under my belt right soon now!"
						(Print 62 62 #at -1 130) ; "(Why is this creep staring above your eyes?)"
					)
					(6
						(HandsOff)
						(Print 62 63) ; ""I'll help you out, Larry ol' buddy." he says, opening his briefcase!"
						(Print 62 64) ; "Just relax. I've done this on fourteen dummies and haven't lost a one of 'em!"
						(Print 62 65) ; "Har, har, har!!"
						(self changeState: 5)
					)
				)
				(aBore setLoop: 2)
				(= seconds (Random 2 5))
			)
			(3
				(aBore setLoop: 0 setCel: 255 setCycle: Beg)
				(switch gBoreStatus
					(1
						(= seconds (Random 40 60))
					)
					(2
						(= seconds (Random 30 50))
					)
					(3
						(= seconds (Random 20 40))
					)
					(4
						(= seconds (Random 10 30))
					)
					(5
						(= seconds (Random 0 20))
					)
				)
			)
			(4
				(aBore setLoop: 0 setCycle: End)
				(self changeState: 1)
			)
			(5
				(HandsOff)
				(= seconds (= cycles 0))
				(= gCurrentStatus 1000)
				(gEgo hide:)
				(aBore
					view: 604
					setLoop: 0
					cycleSpeed: 2
					posn: 171 83
					cel: 0
					setCycle: End self
				)
			)
			(6
				(aBore setLoop: 1 cel: 0 setCycle: End self)
			)
			(7
				(= seconds 3)
			)
			(8
				(Print 62 66 #draw) ; "What a time for you to forget those complicated seat belt instructions! Maybe you could distract this guy with something..."
				(= gCurrentStatus 1001)
			)
			(9
				(= seconds (= cycles 0))
				(if (!= gBoreStatus 255)
					(aBore setLoop: 0 setCel: 0 stopUpd:)
				)
			)
			(10
				(= seconds (= cycles 0))
				(= gBoreStatus 255)
				(SetRgTimer 5 3 33)
				(aBore setLoop: 3 setCel: 0 stopUpd:)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		number 105
	)
)

(instance aBore of Prop
	(properties
		y 85
		x 175
		view 602
	)
)

(instance aCartLeft of Act
	(properties
		y 1103
		x 23
		view 611
	)
)

(instance aCartRight of Act
	(properties
		y 1103
		x 308
		view 610
		loop 1
	)
)

(instance aStewardess of Act
	(properties
		y 101
		x 11
		view 600
	)
)

