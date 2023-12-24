;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm450 0
)

(synonyms
	(blackboard blackboard blackboard blackboard blackboard special board awning)
	(tip tip buck cup jar tips)
	(entertainer entertainer woman)
	(buffet booth keyboard)
)

(local
	elvisWinked
	pattiAtPiano
	request
	seenMsg
)

(instance rm450 of Rm
	(properties
		picture 450
		south 416
		west 416
	)

	(method (init)
		(Load rsVIEW 451)
		(super init:)
		(gAddToPics
			add: atpPiano
			add: atpChair1
			add: atpChair2
			add: atpChair3
			add: atpChair4
			add: atpChair5
			add:
				(if (and gEgoIsPatti (InRoom 18))
					atpBlackboard2
				else
					atpBlackboard1
				)
			doit:
		)
		(self setScript: RoomScript)
		(if (and gEgoIsPatti (InRoom 18))
			(aMarker init:)
		)
		(NormalEgo)
		(cond
			((== gEgoState 1)
				(aPatti view: 800 init: loop: 1 posn: 168 107 setCycle: Walk)
				(gEgo ignoreActors: illegalBits: 0 posn: 139 121 view: 451)
				(RoomScript changeState: 10)
				(PattiScript changeState: 6)
				(HandsOff)
			)
			((== gPrevRoomNum 455)
				(= pattiAtPiano 1)
				(HandsOff)
				(gEgo ignoreActors: illegalBits: 0 posn: 139 121 view: 451)
				(RoomScript changeState: 10)
			)
			(else
				(if (and (== gShowroomState 6) (InRoom 12))
					(= pattiAtPiano 1)
					(if (== (Random 0 3) 3)
						(aRoger init:)
					)
					(if (== (Random 0 3) 3)
						(aElvis init:)
					)
				)
				(if (> (gEgo y:) 130)
					(gEgo posn: 29 188)
				else
					(gEgo posn: 9 168)
				)
			)
		)
		(gEgo init:)
		(if pattiAtPiano
			(aPatti init:)
			(PattiScript changeState: 1)
			(blockPatti init:)
			(SetFlag 67) ; tipsIn450
			(gEgo observeBlocks: blockPatti observeControl: 16384)
		)
		(if (TestFlag 67)
			(aTips init:)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0200)
			(if (not seenMsg)
				(= seenMsg 1)
				(gEgo
					posn: (gEgo xLast:) (gEgo yLast:)
					setMotion: 0
					observeControl: 512
					forceUpd:
				)
				(if gEgoIsPatti
					(Print 450 0) ; "You have no need to use the employee's exit, Patti."
				else
					(Print 450 1) ; "This exit is marked "For Employees Only." You are no longer an employee of Natives, Inc."
				)
			)
		else
			(= seenMsg 0)
		)
		(if pattiAtPiano
			(gEgo observeBlocks: blockPatti observeControl: 16384)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'lie')
				(cond
					((== gEgoState 1004)
						(YouAre) ; "You are."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(gEgoIsPatti
						(Print 450 2) ; "You have no desire to spend any more time here!"
					)
					((& (gEgo onControl:) $0004)
						(Print 450 3) ; "These two stools are reserved for high rollers only."
					)
					(
						(or
							(& (gEgo onControl:) $0002)
							(& (gEgo onControl:) $0020)
							(& (gEgo onControl:) $0010)
						)
						(self changeState: 6)
					)
					((& (gEgo onControl:) $0040)
						(Print 450 4) ; "The booths are reserved for high rollers only."
					)
					(else
						(Print 450 5) ; "There is a stool available right beside the keyboard."
					)
				)
			)
			(
				(or
					(Said 'nightstand,(get<off),(get<up),(nightstand<up)')
					(Said 'exit/barstool,barstool')
				)
				(cond
					((== gEgoState 0)
						(YouAre) ; "You are."
					)
					((!= gEgoState 1004)
						(NotNow) ; "Good idea. You might try that again later."
					)
					(else
						(self changeState: 11)
					)
				)
			)
			((Said 'get/marker')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not gEgoIsPatti)
						(Print 450 6) ; "Where?"
					)
					((not (InRoom 18))
						(AlreadyTook) ; "You already took it."
					)
					((not (gEgo inRect: 10 152 55 160))
						(NotClose) ; "You're not close enough."
					)
					(else
						(Ok) ; "O.K."
						(gEgo get: 18) ; Magic_Marker
						(gGame changeScore: 50)
						(aMarker dispose:)
						(Print 450 7) ; "Great! A "Magic" marker. A girl never knows when she might need a little Magic in her life!"
					)
				)
			)
			((Said 'get/tip')
				(cond
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((not gEgoIsPatti)
						(Print 450 8) ; "Larry! That money belongs to Patti, not you!"
					)
					((not (TestFlag 67))
						(AlreadyTook) ; "You already took it."
					)
					((not (& (gEgo onControl:) $0002))
						(Print 450 9) ; "You keep your tip jar above the treble end of your keyboard."
					)
					(else
						(Ok) ; "O.K."
						(gEgo get: 6) ; A_Twenty_Dollar_Bill
						((Inv at: 6) view: 25) ; A_Twenty_Dollar_Bill
						(Format ((Inv at: 6) name:) 450 10) ; "Tips", A_Twenty_Dollar_Bill
						(gGame changeScore: 25)
						(= gDollars 43)
						(ClearFlag 67) ; tipsIn450
						(aTips dispose:)
						(Print 450 11) ; "Let's see; did we have a good night tonight? Oh, well; a few bucks is better than nothing. Where you're going you're not going to need a lot of money anyway."
					)
				)
			)
			((Said 'get,buy,call/attendant,attendant,drink')
				(Print 450 12) ; "You'll just have to wait until a waitress shows up."
			)
			((Said '/attendant,attendant')
				(Print 450 13) ; "You never can find one when you need one!"
			)
			((or (Said 'give,drop/tip') (Said 'tip'))
				(cond
					(gEgoIsPatti
						(Print 450 14) ; "You have no desire to tip yourself!"
					)
					((not (gEgo has: 6)) ; A_Twenty_Dollar_Bill
						(DontHave) ; "You don't have it."
					)
					((SetFlag 67) ; tipsIn450
						(Print 450 15) ; "You really should save your money for another place."
					)
					(else
						(Print 450 16) ; "Save your money, Larry. This is one girl you'll not be able to purchase!"
					)
				)
			)
			((Said 'gamble/buffet')
				(cond
					(gEgoIsPatti
						(Print 450 17) ; "No, you've played this piano quite enough for one lifetime!"
					)
					((not (gCast contains: aPatti))
						(Print 450 18) ; "On the scale of musical aptitude, you rank in the fourth percentile, nationally."
						(if (== gFilthLevel 4)
							(Print 450 19 #at -1 144) ; "(...just slightly below an elephant passing gas!)"
						)
					)
					(else
						(Print 450 20) ; "Say, Patti!" you shout. "Can you play `Melancholy Baby?'"
						(Print 450 21) ; "Sure, buddy," she responds, "here's one of my favorites."
						(PattiScript changeState: 1)
					)
				)
			)
			((Said 'listen')
				(if pattiAtPiano
					(Print 450 22) ; "She sounds a lot like a hip Bobby Short!"
				else
					(Print 450 23) ; "There's nothing more dull than a piano bar without a piano player!"
				)
			)
			((Said 'look<below')
				(Print 450 24) ; "You look under it and see its bottom."
			)
			((Said 'look>')
				(cond
					(
						(or
							(Said '/blackboard')
							(and (InRoom 18) (Said '/marker'))
						)
						(cond
							((not gEgoIsPatti)
								(Print 450 25) ; "The announcement board lists the drink specials of the day in a vivid florescent ink. You wonder how they get such vibrant, day-glo colors from a marking pen."
							)
							((not (InRoom 18))
								(Print 450 26) ; "The blackboard announces the beverage specials of the day... just above its now-empty tray."
							)
							(else
								(Print 450 27) ; "Why, look! Someone left the marking pen lying in the tray of the announcement board."
							)
						)
					)
					((Said '/wall,ceiling,burn')
						(Print 450 28) ; "This room certainly has an unusual shape! Look at how the walls curve into the ceiling then into that spotlight."
					)
					((Said '/bar')
						(if pattiAtPiano
							(Print 450 29) ; "Patti looks beautiful, doesn't she?"
						else
							(Print 450 30) ; "This is the dullest bar you've ever seen."
							(Print 450 31 #at -1 144) ; "(And you've seen quite a few!)"
						)
					)
					((Said '/barstool')
						(Print 450 32) ; "The stools here are near the piano bar."
					)
					((Said '/drink')
						(Print 450 33) ; "You haven't ordered a drink yet."
					)
					((and (SetFlag 67) (Said '/tip')) ; tipsIn450
						(Print 450 34) ; "On the end of the piano sits a large brandy snifter filled with money; tips donated by enthusiastic fans."
					)
					((Said '/door')
						(Print 450 35) ; "There is a door to the north marked "Employees Only" in addition to the way you entered."
					)
					((Said '/buffet,entertainer')
						(cond
							((< gShowroomState 6)
								(Print 450 36) ; "The piano awaits the arrival of its new performer -- Passionate Patti!"
							)
							((InRoom 12)
								(Print 450 37) ; "Look, Larry! It's that woman you've been waiting for -- Passionate Patti herself!! She looks even better than you expected."
								(Print 450 38 #at -1 144) ; "(You wonder why she selected "Passionate" as her stage name.)"
							)
							((not gEgoIsPatti)
								(Print 450 39) ; "She's not here, Larry. She's waiting for you upstairs."
							)
							((TestFlag 67)
								(Print 450 40) ; "It's your tip glass! Of course! You forgot all about it."
							)
							(else
								(Print 450 41) ; "This piano brings back fond memories for you."
							)
						)
					)
					((Said '[/bar,area]')
						(if gEgoIsPatti
							(Print 450 42) ; "This piano bar has been quite good to you, but then, you deserve it!"
						else
							(Print 450 43) ; "Unusual walls rise to a sculptured ceiling that descends upon the stool before a grand piano."
							(if pattiAtPiano
								(Print 450 44) ; "Seated before you is none other than the queen of the keyboard, the irresistable instrumentalist of the ivories, the sultress of the Steinway, the babe of the Bosendorfer... Passionate Patti!"
							else
								(Print 450 45) ; "This place is sure dead!"
							)
						)
					)
				)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 1)
		(switch (= state newState)
			(0)
			(6
				(HandsOff)
				(Ok) ; "O.K."
				(gEgo ignoreActors: illegalBits: 0)
				(cond
					((& (gEgo onControl:) $0002)
						(self changeState: 8)
					)
					((& (gEgo onControl:) $0020)
						(self changeState: 7)
					)
					(else
						(gEgo setMotion: MoveTo 118 (gEgo y:) self)
					)
				)
			)
			(7
				(gEgo setMotion: MoveTo (gEgo x:) 113 self)
			)
			(8
				(gEgo setMotion: MoveTo 134 113 self)
			)
			(9
				(gEgo
					posn: 139 121
					view: 451
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(10
				(if (!= gEgoState 1)
					(User canInput: 1)
					(= gEgoState 1004)
				)
				(gEgo
					loop: (Random 1 2)
					cel: 0
					cycleSpeed: (Random 0 2)
					setCycle: End
				)
				(-- state)
				(= seconds (Random 3 6))
			)
			(11
				(Ok) ; "O.K."
				(HandsOff)
				(= seconds (= cycles 0))
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self)
			)
			(12
				(gEgo posn: 134 113)
				(NormalEgo 3)
				(= gEgoState 0)
			)
			(13
				(HandsOff)
				(Ok) ; "O.K."
				(= gEgoState 14)
				(if (not (TestFlag 9))
					(Printf 450 46 gLaffer) ; ""Hello, beautiful," you say to the pianist. %s"
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(14
				(if (not (TestFlag 9))
					(SetFlag 9) ; seenPatti
					(gGame changeScore: 5)
					(Print 450 47) ; "And hello to you, Larry," replies Passionate Patti. "I'm the girl of your dreams, Passionate Patti!"
				)
				(gCurRoom newRoom: 455)
			)
		)
	)
)

(instance aElvis of Prop
	(properties
		y 145
		x 150
		view 453
		loop 2
	)

	(method (init)
		(super init:)
		(self setScript: ElvisScript)
	)
)

(instance ElvisScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/man,elvis')
				(Print 450 48) ; "Why, he looks just like The King!"
			)
			((Said 'talk/elvis')
				(Print 450 49) ; "He looks like he doesn't want to be disturbed."
			)
			((Said '/elvis')
				(Print 450 50) ; "So this is where he's been hiding!"
				(self changeState: 3)
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 3 3)
		(switch (= state newState)
			(0
				(aElvis loop: 2 setCel: 0)
				(= cycles (Random 22 111))
			)
			(1
				(if (not (Random 0 3))
					(aElvis loop: (Random 2 3) cel: 0 setCycle: End)
				else
					(= state -1)
				)
				(= cycles (Random 22 55))
			)
			(2
				(aElvis setCycle: Beg self)
				(= state -1)
			)
			(3
				(aElvis loop: 4 cel: 0 setCycle: End)
				(= cycles 22)
				(= state 1)
			)
		)
	)
)

(instance aRoger of Prop
	(properties
		y 133
		x 144
		view 453
	)

	(method (init)
		(super init:)
		(self setScript: RogerScript)
	)
)

(instance RogerScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/man,hardy')
				(Print 450 51) ; "Hey, look! It's Roger Wilco."
			)
			((Said 'talk/hardy,man')
				(Print 450 49) ; "He looks like he doesn't want to be disturbed."
			)
			((Said '/hardy')
				(Print 450 52) ; ""So what are you doing here without those Two Guys?" you ask him."
				(Print 450 53) ; ""What two guys?" he replies."
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 4 4)
		(switch (= state newState)
			(0
				(aRoger loop: 0 setCel: 0)
				(= seconds (Random 5 10))
			)
			(1
				(if (not (Random 0 2))
					(aRoger loop: (Random 0 1) setCycle: End)
				else
					(= state -1)
				)
				(= cycles (Random 22 55))
			)
			(2
				(aRoger setCycle: Beg self)
				(= state -1)
			)
		)
	)
)

(instance atpPiano of PV
	(properties
		y 116
		x 143
		view 450
		priority 8
		signal 16384
	)
)

(instance aTips of View
	(properties
		y 91
		x 150
		view 450
		cel 2
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 9 stopUpd:)
	)
)

(instance atpBlackboard1 of PV
	(properties
		y 153
		x 36
		view 450
		cel 3
		priority 10
	)
)

(instance atpBlackboard2 of PV
	(properties
		y 153
		x 36
		view 450
		cel 4
		priority 10
	)
)

(instance aMarker of Prop
	(properties
		y 145
		x 29
		view 450
		loop 1
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self setPri: 11 setCycle: Fwd)
	)
)

(instance atpChair1 of PV
	(properties
		y 122
		x 137
		view 450
		cel 1
		priority 8
	)
)

(instance atpChair2 of PV
	(properties
		y 133
		x 144
		view 450
		cel 1
		priority 9
	)
)

(instance atpChair3 of PV
	(properties
		y 145
		x 150
		view 450
		cel 1
		priority 10
	)
)

(instance atpChair4 of PV
	(properties
		y 155
		x 170
		view 450
		cel 1
		priority 11
	)
)

(instance atpChair5 of PV
	(properties
		y 155
		x 192
		view 450
		cel 1
		priority 11
	)
)

(instance aPatti of Act
	(properties
		y 84
		x 166
		view 452
	)

	(method (init)
		(super init:)
		(self ignoreActors: illegalBits: 0 setPri: 7 setScript: PattiScript)
	)
)

(instance PattiScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((super handleEvent: event))
			((Said 'get,make,(ask<about),gamble/music,buy')
				(gMusic fade:)
				(= request
					(switch (Random 1 16)
						(1 110)
						(2 120)
						(3 206)
						(4 265)
						(5 323)
						(6 330)
						(7 335)
						(8 395)
						(9 399)
						(0 431)
						(11 435)
						(12 500)
						(13 560)
						(14 599)
						(15 540)
						(else 261)
					)
				)
				(Printf ; "Ok," says Patti, "how about a selection from that hot new Sierra adventure game `Leisure Suit Larry 3?' Here's the hauntingly-beautiful LSL3 `%s Theme.'"
					450
					54
					(switch request
						(110 {Sierra})
						(120 {Title})
						(206 {Binocular})
						(265 {Tawni's})
						(323 {Dewey, Cheatem and Howe})
						(330 {Dale Exotic Dance})
						(335 {Dale's})
						(395 {Bambi's})
						(399 {Fat City})
						(431 {Cherri's Dance})
						(435 {Cherri's})
						(500 {Bamboo})
						(560 {Whitewater Rafting})
						(599 {Nontoonyt Jungle})
						(540 {Feral Pig})
						(else {Larry Gets Crabs})
					)
				)
				(self changeState: 1)
			)
			((Said 'talk[/entertainer]')
				(if gEgoIsPatti
					(Print 450 55) ; "No one can hear you, Patti."
				else
					(Print 450 56) ; "Before speaking to a woman, it is advisable to look at her, Larry."
				)
			)
			((Said 'look/entertainer')
				(if (!= gEgoState 1004)
					(Print 450 57) ; "Why not have a seat first, Larry?"
				else
					(RoomScript changeState: 13)
				)
			)
			((Said '/entertainer')
				(Print 450 58) ; "Perhaps you should establish eye contact."
			)
		)
	)

	(method (changeState newState &tmp howMany)
		(ShowState self newState 2 2)
		(switch (= state newState)
			(0)
			(1
				(= seconds 0)
				(aPatti view: 452 viewer: pianoCycler)
				(if request
					(= howMany 1)
				else
					(= request (Random 451 454))
					(= howMany (Random 1 3))
				)
				(gMusic stop: number: request loop: howMany play: self)
			)
			(2
				(gMusic number: request loop: 1 play:)
				(= request 0)
				(= seconds (Random 3 22))
			)
			(3
				(gMusic fade:)
				(aPatti viewer: 0 loop: 4 setCel: 0)
				(= seconds 7)
			)
			(4
				(Print 450 59) ; ""Here's another song you might enjoy," says Patti."
				(self changeState: 1)
			)
			(5)
			(6
				(gMusic stop: number: 499 loop: gBgMusicLoops play:)
				(= seconds 3)
			)
			(7
				(aPatti setMotion: MoveTo 145 112 self)
			)
			(8
				(Print 450 60) ; "Here, Larry, take the key to my suite," says Patti. "I'll slip out the back way and use the service elevator. Just wait a few minutes before you come upstairs, as I'd like to slip into something more comfortable..."
				(Print 450 61) ; "...like your flowers!"
				(gEgo get: 12) ; Penthouse_Key
				(PutInRoom 13 340)
				(gGame changeScore: 25)
				(aPatti setLoop: -1 setMotion: MoveTo 168 112 self)
			)
			(9
				(Print 450 62) ; "Oh, and remember Larry: I refuse to make love to a man without something to drink first!" she says over her shoulder. "No offense, of course."
				(aPatti setMotion: MoveTo 168 46 self)
			)
			(10
				(Print 450 63 #at -1 144) ; "(None taken, you suppose.)"
				(aPatti dispose:)
				(User canInput: 1)
				(= gEgoState 1004)
			)
		)
	)
)

(instance pianoCycler of Code
	(properties)

	(method (doit)
		(if (not (Random 0 9))
			(aPatti cycleSpeed: (Random 0 1))
		)
		(if (not (Random 0 5))
			(aPatti loop: (Random 0 3))
		)
	)
)

(instance blockPatti of Blk
	(properties
		top 90
		left 157
		bottom 111
		right 177
	)
)

