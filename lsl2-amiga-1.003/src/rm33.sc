;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 33)
(include sci.sh)
(use Main)
(use Door)
(use Interface)
(use Timer)
(use Extra)
(use Sound)
(use Jump)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm33 0
)

(local
	mamaInRoom
	aMama
	drawerState
	closetState
	debugMsg
)

(instance mOdrawer of Sound
	(properties
		number 27
		priority 100
	)
)

(instance mCdrawer of Sound
	(properties
		number 28
		priority 100
	)
)

(instance rm33 of Rm
	(properties
		picture 33
	)

	(method (init)
		(Load rsVIEW 100)
		(Load rsVIEW 306)
		(Load rsVIEW 307)
		(Load rsVIEW 308)
		(Load rsVIEW 305)
		(Load rsVIEW 313)
		(Load rsSOUND 27)
		(Load rsSOUND 28)
		(Load rsSCRIPT 991)
		(super init:)
		(mOdrawer init:)
		(mCdrawer init:)
		(gAddToPics add: aView1 aView2 doit:)
		(aBigMama view: 313 posn: 273 1058 setPri: 15 setCycle: Fwd init:)
		(aPorthole setCycle: Fwd cycleSpeed: 10 isExtra: 1 init:)
		(NormalEgo)
		(gEgo posn: 109 112 loop: 0 init:)
		(self setRegions: 300 setScript: rm33Script) ; rm300
		(if (== gCurrentEgoView 100)
			(cond
				((== 1 (++ gTimesInRm33))
					(= mamaInRoom 1)
					(= debugMsg 1)
					((= aMama (Extra new:))
						view: 305
						setLoop: 4
						setPri: 7
						posn: 201 110
						cycleSpeed: 1
						minPause: 20
						maxPause: 50
						init:
					)
					(rm33Script changeState: 2)
				)
				((> 3 (Random 1 5))
					(= debugMsg 0)
				)
				((> 3 (Random 1 5))
					(= debugMsg 2)
					((= aMama (Extra new:))
						view: 305
						setLoop: 4
						setPri: 7
						posn: 201 110
						cycleSpeed: 1
						minPause: 20
						maxPause: 50
						init:
					)
					(rm33Script changeState: 14)
				)
				(else
					(= debugMsg 3)
					((= aMama (Act new:))
						view: 306
						loop: 3
						posn: 154 125
						illegalBits: 0
						ignoreActors:
						setCycle: Walk
						init:
						hide:
					)
					(rm33Script changeState: 5)
				)
			)
		)
		(aCloset doorCtrl: 16 doorBlock: 0 roomCtrl: 0 init:)
		(aDrawer doorCtrl: 32 doorBlock: 0 roomCtrl: 0 init:)
		(if gDebugging
			(RedrawCast)
			(switch debugMsg
				(1
					(Print 33 0 #at -1 20) ; "His first Mama."
				)
				(2
					(Print 33 1 #at -1 20) ; "Here's Mama."
				)
				(3
					(Print 33 2 #at -1 20) ; "Mama's coming... later!"
				)
				(else
					(Print 33 3 #at -1 20) ; "Not this time."
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance rm33Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0004)
			(gCurRoom newRoom: 32)
		)
		(if (and (== state 5) (& (gEgo onControl: 1) $0020))
			(self changeState: 6)
		)
		(if (and (== state 7) (== (whipScript state:) 1))
			(self cue:)
		)
		(if (and mamaInRoom (== gCurrentStatus 0) (> (gEgo x:) 170))
			(= gCurrentStatus 1000)
			(HandsOff)
			(aMama view: 308 posn: 173 104)
			(Print 33 4) ; "Wow, sonny," shrieks big Mama, I thought you were never gonna come over here! Sit here on the bed while I slip into something more comfortable. I bet you'd like this little mink-lined leather special, wouldn't ya? Now you get comfortable in those chromium chains and handcuffs conveniently attached to the four corners of the bed."
			(self changeState: 12)
			(whipScript changeState: 5)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look<below/bed')
			(Print 33 5) ; "You find plenty of dust."
		)
		(if (Said 'look>')
			(if (Said '/(door<cabinet),cabinet')
				(cond
					((== closetState 0)
						(Print 33 6) ; "It's not open."
					)
					(mamaInRoom
						(Print 33 7) ; "Not now! Mother would be displeased."
					)
					(else
						(Print 33 8) ; "You see lots of unusual garments, many made of leather, with fur linings. Mother must be a policewoman, as she also has handcuffs, whips, chains and other paraphernalia that you assume would only be useful in the field of law enforcement."
					)
				)
			)
			(if (Said '/door')
				(Print 33 9) ; "There is an open door here leading back to your room. The door to the hall is locked. There is also a closet and a drawer in the nightstand, either of which may be opened."
			)
			(if (Said '/bureau,new,buffet,bureau')
				(cond
					((not (& (gEgo onControl: 1) $0020))
						(NotClose) ; "You're not close enough."
					)
					((== drawerState 0)
						(Print 33 6) ; "It's not open."
					)
					(mamaInRoom
						(Print 33 7) ; "Not now! Mother would be displeased."
					)
					(else
						(Ok) ; "Ok."
						(if ((gInventory at: 12) ownedBy: gCurRoomNum) ; Sewing_Kit
							(Print 33 10) ; "You see lots of unmentionables, which will remain unmentioned, plus Mother's sewing kit."
						else
							(Print 33 11) ; "You see nothing of further interest to you."
						)
					)
				)
			)
			(if (Said '/bed')
				(Print 33 12) ; "It's small and hard."
				(if (> gFilthLevel 10)
					(Print 33 13 #at -1 130) ; "(A condition not unknown to you!)"
				)
			)
			(if (Said '/woman')
				(cond
					((== (User canControl:) 0)
						(Print 33 7) ; "Not now! Mother would be displeased."
					)
					((not mamaInRoom)
						(Print 33 14) ; "Where?"
					)
					(else
						(Print 33 15) ; "Must we? Oh, ok."
						(aBigMama posn: 273 58)
						(Timer setReal: aBigMama 5)
						(HandsOff)
					)
				)
			)
			(if (Said '/art,brick')
				(Print 33 16) ; "The painting on the aft wall is from the Starving Sailors' School of art."
			)
			(if (Said '[/cabin,airport]')
				(Print 33 17) ; "There is a door on the forward wall that leads back to your room. The door to the hall is locked. A large closet and a nightstand are against the starboard wall."
				(if mamaInRoom
					(Print 33 18) ; "And a large, ugly woman is looking back at you!"
				)
			)
		)
		(if (Said 'open>')
			(if (Said '/(door<cabinet),door,cabinet')
				(cond
					((& (gEgo onControl:) $0002)
						(Print 33 19) ; "The door to your room IS open!"
					)
					((gEgo inRect: 127 117 333 222)
						(Print 33 20) ; "The door to the hallway is locked."
					)
					((not (& (gEgo onControl: 1) $0010))
						(NotClose) ; "You're not close enough."
					)
					((== closetState 1)
						(ItIs) ; "It is."
					)
					(mamaInRoom
						(Print 33 7) ; "Not now! Mother would be displeased."
					)
					(else
						(Ok) ; "Ok."
						(= closetState 1)
						(aCloset force: 1 open:)
					)
				)
			)
			(if (Said '/bureau,new,buffet,bureau')
				(cond
					((not (& (gEgo onControl: 1) $0020))
						(NotClose) ; "You're not close enough."
					)
					((== drawerState 1)
						(ItIs) ; "It is."
					)
					(mamaInRoom
						(Print 33 7) ; "Not now! Mother would be displeased."
					)
					(else
						(Ok) ; "Ok."
						(mOdrawer play:)
						(= drawerState 1)
						(aDrawer force: 1 open:)
					)
				)
			)
		)
		(if (Said 'close>')
			(if (Said '/(door<cabinet),door,cabinet')
				(cond
					((& (gEgo onControl:) $0002)
						(Print 33 21) ; "You don't want to close yourself in here!"
					)
					((gEgo inRect: 127 117 333 222)
						(Print 33 22) ; "The door to the hallway IS closed."
					)
					((not (& (gEgo onControl: 1) $0010))
						(NotClose) ; "You're not close enough."
					)
					((== closetState 0)
						(ItIs) ; "It is."
					)
					(mamaInRoom
						(Print 33 23) ; "It's too late now!"
					)
					(else
						(Ok) ; "Ok."
						(= closetState 0)
						(aCloset force: 1 close:)
					)
				)
			)
			(if (Said '/bureau,new,buffet,bureau')
				(cond
					((not (& (gEgo onControl: 1) $0020))
						(NotClose) ; "You're not close enough."
					)
					((== drawerState 0)
						(ItIs) ; "It is."
					)
					(mamaInRoom
						(Print 33 23) ; "It's too late now!"
					)
					(else
						(Ok) ; "Ok."
						(mCdrawer play:)
						(= drawerState 0)
						(aDrawer force: 1 close:)
					)
				)
			)
		)
		(if (Said 'get/chain,dirt')
			(Print 33 24) ; "You have better things to do. Try to find one."
		)
		(if (Said 'get/kit')
			(cond
				((not (& (gEgo onControl: 1) $0020))
					(NotClose) ; "You're not close enough."
				)
				((not ((gInventory at: 12) ownedBy: gCurRoomNum)) ; Sewing_Kit
					(AlreadyTook) ; "You already took it."
				)
				((!= drawerState 1)
					(Print 33 14) ; "Where?"
				)
				((or mamaInRoom (!= gCurrentStatus 0))
					(NotNow) ; "Not now!"
				)
				(else
					(Ok) ; "Ok."
					(gEgo get: 12) ; Sewing_Kit
					(gGame changeScore: 6)
				)
			)
		)
		(if
			(or
				(Said '(get<on,in),lie,board/bed')
				(Said '(get<off),drain/bra')
				(Said 'yes,play,(get<naked)')
				(Said 'get/naked')
				(Said 'caress,(make<enjoy),embrace,embrace/woman')
				(Said 'bath,(bath<using),(nap<using),fuck/bed,woman')
			)
			(if (not mamaInRoom)
				(Print 33 25) ; "You should not do that here."
			else
				(Print 33 26) ; "Come on over, Larry," says Mother. "Sit here on the bed with me."
			)
		)
		(if (Said 'talk/woman')
			(cond
				((== (User canControl:) 0)
					(Print 33 7) ; "Not now! Mother would be displeased."
				)
				((not mamaInRoom)
					(Print 33 14) ; "Where?"
				)
				(else
					(Print (Format @gString 33 27 gLaffer)) ; ""Gosh, I'm real sorry I busted into your room like this," you tell the woman. %s"
					(Print 33 28) ; "Yes, I know, big boy," says Mama Bimbo. "I was hopin' you'd come next door!"
				)
			)
		)
		(if (Said 'get')
			(if mamaInRoom
				(Print 33 7) ; "Not now! Mother would be displeased."
			else
				(Print 33 29) ; "There's nothing in there that you know how to use!"
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(2
				(HandsOff)
				(= mamaInRoom 1)
				(= seconds 3)
			)
			(3
				(Print 33 30 #at -1 20) ; ""Well, well, well; what have we here?" says the woman on the bed."
				(Print 33 31) ; "Uh, oh, Larry. You've been caught entering someone else's stateroom."
				(Print 33 32 #at -1 20) ; ""Why, I do believe it's that darling young man that my daughter won on TV!" says the woman."
				(Print 33 33) ; "Good lord! She's Bachelorette Barbara's mother!"
				(Print 33 34 #at -1 20) ; "Poor little Barbie got to feeling poorly just as the cruise was about to start, so I decided to 'borrow' her ticket and come along instead!"
				(Print 33 35) ; "Your mind quickly envisions "Paradise Lost.""
				(Print 33 36 #at -1 20) ; "I hope you don't mind: I convinced the purser that it was in his best interests to assign us to adjoining cabins! I'm sure I can make your voyage enjoyable!"
				(= seconds 3)
			)
			(4
				(Print 33 37 #at -1 20) ; "I really want to get to 'know' you (if you get my drift). After I saw you win that Lottery show, I thought you were just about the cutest thing I'd ever seen!"
				(Print 33 38 #at -1 20) ; "Except for my Mister, of course (may he rest in peace). He was a good man, and usually quite sturdy, but one day his heart just couldn't take it any more!"
				(Print 33 39) ; "You wonder why it is necessary for you to learn this."
				(Print 33 40 #at -1 20) ; "Honey, any time you want to come over and see Momma, you just feel free to pop on through that doorway, ya hear?"
				(Print 33 41) ; "She attempts to give you a cute, girlish smile."
				(Print 33 42 #at -1 130) ; "(She fails.)"
				(HandsOn)
			)
			(6
				(= seconds 0)
				(= gCurrentStatus 1000)
				(= mamaInRoom 3)
				(aMama loop: 3 show: setMotion: MoveTo 108 113 self)
				(gEgo setScript: whipScript)
				(Print 33 43 #at -1 15 #width 280 #draw) ; "Say, look who's back!" says the Mother. "It's my little friend from next door! Came over for a little action, did we? Well, you've come to the right place, big boy!"
				(Print 33 44) ; "You've been caught in someone else's stateroom!"
				(Print 33 45) ; "You decide to make a run for the door!"
			)
			(7
				(aMama loop: 0)
				(Print 33 46 #at -1 15 #width 280 #draw) ; "Yep, I've been lookin' for a man like you ever since my Mister had his big one. Whaddaya say we have a little fun? You do like havin' fun, doncha?"
			)
			(8
				(aMama
					view: 307
					setLoop: 0
					posn: 107 112
					setPri: 12
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(9
				(aMama
					setLoop: 1
					cel: 0
					posn: 105 112
					setPri: 7
					cycleSpeed: 1
					setCycle: CT 6 1 self
				)
				(whipScript changeState: 2)
				(Print 33 47 #at -1 20) ; "Hop over there on the bed, baby."
			)
			(10
				(aMama setLoop: 1 setCel: 255)
				(whipScript changeState: 3)
			)
			(11
				(aCloset setCel: 255)
				(aMama
					view: 308
					setLoop: 0
					setCycle: Walk
					cycleSpeed: 0
					setMotion: MoveTo 167 105 self
				)
				(Print 33 48 #draw) ; "Now you just get comfortable in those chromium chains and handcuffs while I slip into something a little more comfortable myself," she says, opening her closet. "Let's see, possibly a little something in mink-lined leather would be nice..."
			)
			(12
				(aMama setLoop: 1 setCycle: Fwd cycleSpeed: 1)
				(= seconds 7)
			)
			(13
				(Print 33 49) ; "Mama proceeds to have her way with you repeatedly."
				(Print 33 50) ; "Too bad that "her way" is not "your way!""
				(Print 33 51 #at -1 130) ; "(You can see why this broad's a widow!)"
				(= gCurrentStatus 1001)
			)
			(14
				(= mamaInRoom 2)
				(= seconds 5)
			)
			(15
				(Print 33 52) ; ""Hi, sweetie!" says Mama."
				(Print 33 53) ; "Back to play?"
			)
		)
	)
)

(instance whipScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					loop: 2
					ignoreActors:
					illegalBits: 0
					setMotion: MoveTo 119 113 self
				)
			)
			(1
				(gEgo setLoop: 1)
			)
			(2
				(gEgo hide:)
			)
			(3
				(gEgo
					view: 307
					illegalBits: 0
					ignoreActors:
					loop: 2
					cel: 0
					posn: 117 85
					setPri: 9
					setStep: 5 5
					show:
					setMotion: JumpTo 194 94 self
				)
			)
			(4
				(rm33Script changeState: 11)
				(self changeState: 5)
			)
			(5
				(gEgo
					view: 307
					illegalBits: 0
					ignoreActors:
					setLoop: 3
					posn: 184 84
					setPri: 5
					setCycle: Fwd
					setMotion: 0
				)
				(= cycles (Random 2 11))
			)
			(6
				(gEgo cycleSpeed: (Random 0 7))
				(= cycles (Random 6 22))
				(= state 5)
			)
		)
	)
)

(instance aBigMama of Prop
	(properties)

	(method (cue)
		(Print 33 54) ; "You find women sexy."
		(Print 33 55 #at 66 155 #width 190) ; "(But in this case, you make an exception!)"
		(self posn: 273 1058)
		(HandsOn)
	)
)

(instance aView1 of PV
	(properties
		y 77
		x 172
		view 305
		loop 5
		priority 3
		signal 16384
	)
)

(instance aView2 of PV
	(properties
		y 86
		x 222
		view 305
		priority 5
		signal 16384
	)
)

(instance aPorthole of Prop
	(properties
		y 74
		x 172
		view 305
		loop 1
		priority 4
		signal 16384
	)
)

(instance aCloset of Door
	(properties
		y 96
		x 137
		view 305
		loop 3
		priority 6
		msgLook {mOdrawer}
		msgLookLock {rm33}
		msgLocked 4256
		msgExcept 4277
		msgFunny 4300
		msgCloser 4320
	)
)

(instance aDrawer of Door
	(properties
		y 88
		x 161
		view 305
		loop 2
		priority 5
		msgLook {mOdrawer}
		msgLookLock {rm33}
		msgLocked 4256
		msgExcept 4277
		msgFunny 4300
		msgCloser 4320
	)
)

