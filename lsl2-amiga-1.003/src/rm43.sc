;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 43)
(include sci.sh)
(use Main)
(use Interface)
(use DPath)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm43 0
)

(local
	knifeHere
	tookKnifeThisTime
	preventInput
	MDatPodium
)

(instance rm43 of Rm
	(properties
		picture 43
		horizon 5
		south 40
	)

	(method (init)
		(Load rsVIEW 433)
		(super init:)
		(if ((gInventory at: 17) ownedBy: gCurRoomNum) ; Knife
			(= knifeHere 1)
		)
		(gAddToPics
			add:
				aCheese
				aSalad
				aFood
				aT1
				aT2
				aT3
				aT4
				aT5
				aLchair
				aWpicture
				aEpicture
			doit:
		)
		(aChair setPri: 7 init: hide:)
		(aTable setPri: 8 init: hide:)
		(Load rsVIEW 101)
		(Load rsVIEW 434)
		(Load rsVIEW 435)
		(Load rsVIEW 438)
		(Load rsVIEW 432)
		(aRope setPri: 12 ignoreActors: init:)
		(aMaitreD setCycle: Walk ignoreActors: stopUpd: init:)
		(aMan setCycle: Walk ignoreActors: init:)
		(aWoman setCycle: Walk ignoreActors: init:)
		(= MDatPodium 1)
		(NormalEgo 3)
		(gEgo posn: 195 178 observeControl: 16384 init:)
		(self setScript: rm43Script)
	)

	(method (dispose)
		(DisposeScript 964)
		(super dispose:)
	)
)

(instance rm43Script of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== gCurrentStatus 1009) (== 0 (mod state 20)))
			(self cue:)
		)
		(if preventInput
			(User canInput: 0)
		else
			(User canInput: 1)
		)
		(if (< state 101)
			(gEgo observeControl: 16384)
		)
		(if (& (gEgo onControl:) $0002)
			(gCurRoom newRoom: 40)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look<below/buffet')
			(Print 43 0) ; "You stick your head under the table nearest you."
			(Print 43 1 #at -1 130) ; "(You see nothing you wish to share at this time!)"
		)
		(if (Said 'look>')
			(if (Said '/appetizer,pate,buffet')
				(cond
					((gEgo inRect: 30 130 80 176)
						(if knifeHere
							(Print 43 2) ; "Why look! There's a knife lying next to the cheese plate."
						else
							(Print 43 3) ; "There's nothing left but food."
						)
					)
					((== gCurrentStatus 1010)
						(Print 43 4) ; "Your table conveniently arrived with food attached!"
					)
					((gEgo inRect: 266 111 296 124)
						(Print 43 5) ; "It's not much, but it's yours!"
					)
					((< state 3)
						(Print 43 6) ; "They aren't crowded! Perhaps you should talk to the Maitre d' about dining here."
					)
					(else
						(Print 43 7) ; "There are people sitting at the tables."
					)
				)
			)
			(if (Said '/barstool')
				(Print 43 8) ; "It's a nice chair."
			)
			(if (Said '/man,agent,woman,children')
				(cond
					((not state)
						(Print 43 9) ; "There's no one here except that snooty Maitre d'."
					)
					((< state 15)
						(Print 43 10) ; "They make a lovely couple."
					)
					(else
						(Print 43 11) ; "They certainly sit still!"
						(Print 43 12) ; "And, what a dress code!!"
					)
				)
			)
			(if (Said '/crackers,crystal,bowl')
				(Print 43 13) ; "Nothing is too expensive for this place."
			)
			(if (Said '[/airport,cafe]')
				(Print 43 14) ; "Expensive linen, crystal and silver weigh down the tables. An appetizer buffet fills one corner."
			)
		)
		(if (Said '/bathing')
			(Print 43 15) ; "It's just hanging around."
		)
		(if
			(or
				(Said 'talk,ask/man')
				(Said 'talk,ask/man/buffet')
				(Said 'talk,ask/man<buffet')
				(Said 'talk,ask/buffet<man')
				(Said 'talk,ask')
			)
			(cond
				((> state 100)
					(Print 43 16) ; "No one at this table is interested in speaking with you."
				)
				((!= gCurrentEgoView 100)
					(Print 43 17) ; "The Maitre d' stops you by growling angrily, "Sir! Our strict dress code forbids us serving anyone that looks like you! Please leave -- NOW!""
				)
				((== knifeHere 0)
					(Print 43 18) ; "We have a limit of one TV tray of food per customer," says the Maitre d' snootily. "Please leave... NOW!"
				)
				((== MDatPodium 0)
					(Print 43 19) ; "Wait until the maitre d' returns to his position."
				)
				(else
					(Print 43 20) ; "Uh, excuse me, sir," you say hesitantly, "I was wondering if I might get a bite to eat?"
					(Print 43 21) ; "The Maitre d' slowly diverts his gaze toward you."
					(if (!= gCurrentEgoView 100)
						(Print 43 22) ; "Certainly not!" he sputters, "appropriate dress is always required here!"
					else
						(= gTalkedToMD 1)
						(Print 43 23) ; ""Your name, please?" he asks."
						(Print gLaffer)
						(Print 43 24) ; "Well, I suppose I could try to find a place for you on our busy schedule," he replies disdainfully. "Just have a seat there in the chair while I prepare a table for you."
					)
				)
			)
		)
		(if (Said 'get,(get<up),eat/appetizer')
			(cond
				((gEgo inRect: 30 130 80 176)
					(if knifeHere
						(Print 43 25) ; "Grabbing the knife lying beside the cheese platter, you carve yourself off a huge hunk of cheddar and pop it into your mouth."
						(Print 43 26) ; "Not bad."
					else
						(Print 43 27) ; "You glom up a cracker full of brie, and slip it into your mouth."
						(Print 43 28) ; "You've never liked brie."
					)
				)
				((== gCurrentStatus 1010)
					(self changeState: 121)
				)
				((gEgo inRect: 266 111 296 124)
					(Print 43 29) ; "You reach over to your table, and grab a handful of oyster crackers, popping them into your mouth. (You've loved these things ever since you were a kid!)"
				)
				((< state 3)
					(Print 43 30) ; "A good idea. Perhaps you should talk to the Maitre d'."
				)
				(else
					(Print 43 31) ; "There's nothing nearby to eat."
				)
			)
		)
		(if (Said '(get<up),get/crackers,crystal,bowl')
			(Print 43 32) ; "That won't help you."
		)
		(if (Said '(get<up),get/gun')
			(cond
				((== knifeHere 0)
					(AlreadyTook) ; "You already took it."
				)
				((not (gEgo inRect: 32 142 55 161))
					(NotClose) ; "You're not close enough."
				)
				(else
					(Print 43 33) ; "The Maitre d' DID say to help yourself to the buffet, but this is rather borderline behavior, Larry!"
					(Print 43 34) ; "Oh, ok; you surreptitiously slip the slicer from the serving surface and sequester it in your suit."
					(gEgo get: 17) ; Knife
					(= knifeHere 0)
					(= tookKnifeThisTime 1)
					(gGame changeScore: 3)
				)
			)
		)
		(if (Said 'bath')
			(cond
				((or (== gCurrentStatus 1009) (== gCurrentStatus 1010))
					(Print 43 35) ; "You are!"
				)
				((!= gCurrentEgoView 100)
					(Print 43 36) ; "The Maitre d' stops you by growling angrily, "Sir! Our strict dress code forbids us serving anyone that looks like you! Please leave... NOW!""
				)
				((and (== knifeHere 0) (== tookKnifeThisTime 0))
					(Print 43 18) ; "We have a limit of one TV tray of food per customer," says the Maitre d' snootily. "Please leave... NOW!"
				)
				((!= gCurrentStatus 0)
					(NotNow) ; "Not now!"
				)
				((gEgo inRect: 266 111 296 124)
					(if (not (gEgo inRect: 268 111 290 116))
						(Print 43 37) ; "Please move between the table and chair if you want to sit down at your table."
					else
						(Ok) ; "Ok."
						(gEgo setScript: TSscript)
						(TSscript changeState: 0)
					)
				)
				((not (gEgo inRect: 175 160 241 189))
					(NotClose) ; "You're not close enough."
				)
				((not gTalkedToMD)
					(Print 43 38) ; "Perhaps you should talk to the man at the podium first."
				)
				(else
					(Ok) ; "Ok."
					(if (not gScoredRm43Sit)
						(= gScoredRm43Sit 1)
						(gGame changeScore: 1)
					)
					(gEgo setScript: SITscript)
					(SITscript changeState: 1)
				)
			)
		)
		(if (Said 'new,(new<up),(get<up)')
			(cond
				((== gCurrentStatus 0)
					(YouAre) ; "You are."
				)
				((== gCurrentStatus 1009)
					(Ok) ; "Ok."
					(gEgo setScript: SITscript)
					(SITscript changeState: 5)
				)
				((== gCurrentStatus 1010)
					(Ok) ; "Ok."
					(gEgo setScript: TSscript)
					(TSscript changeState: 3)
				)
				(else
					(Print 43 39) ; "Not now!"
				)
			)
		)
		(if
			(and
				(< state 101)
				(gEgo inRect: 170 155 194 179)
				(== MDatPodium 1)
				(or (Said 'give/man/buck') (Said 'tip,bribe/agent,man'))
			)
			(Print 43 40) ; "Here's a hundred dollars," you inform the Maitre d'. "May I please have a nice table and something to eat?"
			(Print 43 41) ; "Thank you, Sir. Just have a seat in the chair."
		)
		(if (Said 'drink')
			(Print 43 42) ; "That Grotesque Gulp was enough to quench your thirst for the rest of this game!"
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(aMan setScript: enterScript)
				(enterScript changeState: 1)
			)
			(2
				(Print 43 43) ; "Why, Mr. and Mrs. Rich," says the Maitre d'. "What a pleasure to see you again. Of course I have a table for you!"
			)
			(3
				(Print 43 44) ; "Well, that was certainly rude! You were here before them. You feel yourself becoming perturbed!"
				(aMaitreD
					setMotion: DPath 209 139 209 102 140 101 122 89 116 86 self
				)
				(= preventInput 0)
				(= cycles 15)
				(= state 8)
			)
			(9
				(aWoman
					setMotion: DPath 209 139 209 102 140 101 122 89 116 86 self
				)
				(= cycles 7)
			)
			(10
				(aMan
					setMotion: DPath 209 139 209 102 140 101 122 89 116 86 self
				)
			)
			(11
				(groupScript init:)
				(aMaitreD setMotion: MoveTo 80 82 groupScript)
			)
			(12
				(aWoman setMotion: MoveTo 95 77 groupScript)
			)
			(13
				(aMan setMotion: MoveTo 135 77 groupScript)
			)
			(14
				(aMaitreD loop: 0)
				(aWoman loop: 0)
				(aMan loop: 1)
				(= seconds 3)
			)
			(15
				(aMan hide:)
				(aWoman hide:)
				(gAddToPics add: aWoman1 aMan1 doit:)
				(Print 43 45 #draw) ; ""I hope you find this satisfactory, Sir," grovels the Maitre d' with his palm extended."
				(= seconds 3)
			)
			(16
				(aMaitreD setMotion: MoveTo 122 89 self)
			)
			(17
				(aMaitreD setMotion: MoveTo 140 101 self)
			)
			(18
				(MDscript changeState: 8)
			)
			(19
				(= seconds (Random 2 4))
			)
			(21
				(aMan setScript: enterScript)
				(enterScript changeState: 1)
			)
			(22
				(Print 43 46) ; "Why, Mr. and Mrs. Famous," says the Maitre d'. "What a pleasure to see you again. Of course I have a table for you!"
			)
			(23
				(Print 43 47) ; "Well, that was certainly rude! You were here before them. You feel yourself becoming annoyed!"
				(aMaitreD
					setMotion: DPath 209 139 209 102 140 101 122 89 116 86 self
				)
				(= cycles 15)
				(= state 27)
			)
			(28
				(aWoman
					setMotion: DPath 209 139 209 102 140 101 122 89 116 86 self
				)
				(= cycles 7)
			)
			(29
				(aMan
					setMotion: DPath 209 139 209 102 140 101 122 89 116 86 self
				)
			)
			(30
				(groupScript init:)
				(aMaitreD setMotion: MoveTo 68 90 groupScript)
			)
			(31
				(aWoman setMotion: MoveTo 47 105 groupScript)
			)
			(32
				(aMan setMotion: MoveTo 90 105 groupScript)
			)
			(33
				(aMaitreD loop: 0)
				(aWoman loop: 0)
				(aMan loop: 1)
				(= seconds 3)
			)
			(34
				(aMan hide:)
				(aWoman hide:)
				(gAddToPics add: aWoman2 aMan2 doit:)
				(Print 43 45 #draw) ; ""I hope you find this satisfactory, Sir," grovels the Maitre d' with his palm extended."
				(= seconds 3)
			)
			(35
				(aMaitreD setMotion: MoveTo 122 89 self)
			)
			(36
				(aMaitreD setMotion: MoveTo 140 101 self)
			)
			(37
				(MDscript changeState: 8)
			)
			(38
				(= state 39)
				(= seconds (Random 2 4))
			)
			(41
				(aMan setScript: enterScript)
				(enterScript changeState: 1)
			)
			(42
				(Print 43 48) ; "Why, Mr. and Mrs. Gates," says the Maitre d'. "What a pleasure to see you again. Of course I have a table for you!"
			)
			(43
				(Print 43 49) ; "Well, that was certainly rude! You were here before them. You feel yourself becoming indignant!"
				(aMaitreD setMotion: DPath 209 139 209 102 200 102 self)
				(= preventInput 0)
				(= cycles 15)
				(= state 47)
			)
			(48
				(aWoman setMotion: DPath 209 139 209 102 200 102 self)
				(= cycles 7)
			)
			(49
				(aMan setMotion: DPath 209 139 209 102 200 102 self)
			)
			(50
				(groupScript init:)
				(aMaitreD setMotion: MoveTo 147 101 groupScript)
			)
			(51
				(aWoman setMotion: MoveTo 158 96 groupScript)
			)
			(52
				(aMan setMotion: MoveTo 202 97 groupScript)
			)
			(53
				(aMaitreD loop: 0)
				(aWoman loop: 0)
				(aMan loop: 1)
				(= seconds 3)
			)
			(54
				(aMan hide:)
				(aWoman hide:)
				(gAddToPics add: aWoman3 aMan3 doit:)
				(Print 43 45 #draw) ; ""I hope you find this satisfactory, Sir," grovels the Maitre d' with his palm extended."
				(= seconds 3)
			)
			(55
				(MDscript changeState: 8)
			)
			(56
				(= state 59)
				(= seconds (Random 2 4))
			)
			(61
				(aMan setScript: enterScript)
				(enterScript changeState: 1)
			)
			(62
				(Print 43 50) ; "Why, Mr. Leach," says the Maitre d'. "What a pleasure to see you again. Of course I have a table for you!"
			)
			(63
				(Print 43 51) ; "Well, that was certainly rude! You were here before them. You feel yourself becoming incensed!"
				(aMaitreD setMotion: DPath 209 139 209 102 208 102 self)
				(= cycles 15)
				(= preventInput 0)
				(= state 67)
			)
			(68
				(aWoman setMotion: DPath 209 139 209 102 208 102 self)
				(= cycles 7)
			)
			(69
				(aMan setMotion: DPath 209 139 209 102 208 102 self)
			)
			(70
				(groupScript init:)
				(aMaitreD setMotion: MoveTo 277 100 groupScript)
			)
			(71
				(aWoman setMotion: MoveTo 220 96 groupScript)
			)
			(72
				(aMan setMotion: MoveTo 263 97 groupScript)
			)
			(73
				(aMaitreD loop: 1)
				(aWoman loop: 0)
				(aMan loop: 1)
				(= seconds 3)
			)
			(74
				(aMan hide:)
				(aWoman hide:)
				(gAddToPics add: aMan4 aWoman4 doit:)
				(Print 43 45 #draw) ; ""I hope you find this satisfactory, Sir," grovels the Maitre d' with his palm extended."
				(= seconds 3)
			)
			(75
				(MDscript changeState: 8)
			)
			(76
				(= state 79)
				(= seconds (Random 2 4))
			)
			(81
				(aMan setScript: enterScript)
				(enterScript changeState: 1)
			)
			(82
				(Print 43 52) ; "Why, Mr. and Mrs. Williams," says the Maitre d'. "What a pleasure to see you again. Of course I have a table for you!"
			)
			(83
				(Print 43 53) ; "Well, that was certainly rude! You were here before them. You feel yourself becoming enraged!"
				(aMaitreD setMotion: MoveTo 190 142 self)
				(= preventInput 0)
				(= state 87)
			)
			(88
				(aMaitreD setMotion: MoveTo 134 139 self)
			)
			(89
				(aMaitreD loop: 0)
				(aWoman setMotion: MoveTo 190 142 self)
			)
			(90
				(aWoman setMotion: MoveTo 149 136 self)
			)
			(91
				(aWoman loop: 0)
				(aMan setMotion: MoveTo 190 142 self)
			)
			(92
				(aMan setMotion: MoveTo 189 136 self)
			)
			(93
				(aMan loop: 1)
				(= seconds 3)
			)
			(94
				(aMan hide:)
				(aWoman dispose:)
				(gAddToPics add: aMan5 aWoman5 doit:)
				(Print 43 45 #draw) ; ""I hope you find this satisfactory, Sir," grovels the Maitre d' with his palm extended."
				(= seconds 3)
			)
			(95
				(aMaitreD setMotion: MoveTo 154 167 self)
			)
			(96
				(aMaitreD loop: 0)
				(= MDatPodium 1)
				(= state 99)
				(= seconds 3)
			)
			(101
				(= preventInput 1)
				(User canControl: 0)
				(= seconds 0)
				(Print 43 54) ; "All right, sir," the Maitre d' says begrudgingly, "I'll show you to your table now."
				(Print 43 55 #at -1 130) ; "(Sure, now that there are no tables left!)"
				(MDscript changeState: 1)
				(gEgo
					setScript: 0
					setLoop: 0
					setCel: 255
					setCycle: Beg self
					setMotion: 0
				)
			)
			(102
				(aRope setLoop: 7 stopUpd:)
				(gEgo
					view: 100
					setLoop: 2
					setLoop: -1
					cycleSpeed: 0
					setCycle: Walk
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 193 172 self
				)
			)
			(103
				(gEgo setMotion: MoveTo 193 150 self)
			)
			(104
				(= seconds 2)
			)
			(105
				(Print 43 56) ; "Please, walk this way."
				(Print 43 57) ; "You think to yourself, "If I walked that way, I'd use talcum powder!""
				(aMaitreD setMotion: MoveTo 209 139 241 113 self)
				(= cycles 10)
			)
			(106
				(gEgo setMotion: MoveTo 209 139 241 113 self)
			)
			(107
				(aMaitreD setMotion: MoveTo 253 105 self)
			)
			(108
				(gEgo setMotion: MoveTo 240 113 self)
			)
			(109
				(gEgo setLoop: 0)
				(Print 43 58 #draw) ; "Oh, boy," says the Maitre d', sharply clapping his hands, "please set up a table for Mr. Laffer!"
				(= seconds 3)
			)
			(110
				(aMan
					view: 432
					setLoop: -1
					loop: 1
					posn: 333 109
					setPri: 4
					show:
					setMotion: MoveTo 275 110 self
				)
			)
			(111
				(aMan loop: 0)
				(= cycles 5)
			)
			(112
				(aChair show:)
				(aTable show: setCycle: End self)
			)
			(113
				(aChair setCycle: End self)
			)
			(114
				(= cycles 5)
			)
			(115
				(Print 43 59 #at -1 20 #draw) ; "Be seated, Mr. Laffer," says the Maitre d' as he escapes to the kitchen. "Feel free to help yourself at our appetizer bar, and, oh yes, I almost forgot:"
				(gGame changeScore: 1)
				(Print (Format @gString 43 60 gTritePhrase) #at -1 20) ; "%s"
				(aTable stopUpd:)
				(aChair stopUpd:)
				(aMan setPri: 6 setMotion: MoveTo 311 110)
				(aMaitreD setPri: 6 setMotion: MoveTo 311 110 self)
			)
			(116
				(aMan dispose:)
				(aMaitreD dispose:)
				(gAddToPics add: aOldDoor doit:)
				(Print 43 61 #at -1 130 #draw) ; "(Choice location, Larry.)"
				(NormalEgo)
				(= preventInput 0)
			)
			(121
				(= preventInput 1)
				(User canControl: 0)
				(= gCurrentStatus 1000)
				(gEgo setMotion: 0)
				(Print 43 62) ; "Ummm."
				(Print 43 63) ; "Yummy."
				(= seconds 3)
			)
			(122
				(Print 43 64) ; "Bad idea, Larry."
				(Print 43 65) ; "For a while, you are afraid you are going to die. Then you are afraid you are NOT going to die!"
				(= seconds 3)
			)
			(123
				(Print 43 66) ; "Your last thoughts are, "Maybe it was something I ate...""
				(= gCurrentStatus 1001)
			)
		)
	)
)

(instance SITscript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(if seconds
					(= seconds 0)
				)
				(= preventInput 1)
				(User canControl: 0)
				(if (< (gEgo y:) 170)
					(gEgo setMotion: MoveTo 200 170 self)
					(-- state)
				else
					(gEgo setMotion: MoveTo 227 172 self)
				)
			)
			(2
				(gEgo
					view: 101
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setMotion: 0
					setCycle: End self
				)
			)
			(3
				(= gCurrentStatus 1009)
				(= preventInput 0)
				(= seconds (Random 2 6))
			)
			(4
				(gEgo setLoop: (Random 1 2))
				(if (== (gEgo cel:) 0)
					(gEgo setCycle: End)
				else
					(gEgo setCycle: Beg)
				)
				(-- state)
				(= seconds (Random 2 6))
			)
			(5
				(if seconds
					(= seconds 0)
				)
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self setMotion: 0)
				(= preventInput 1)
			)
			(6
				(NormalEgo 2)
				(= preventInput 0)
			)
		)
	)
)

(instance TSscript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if seconds
					(= seconds 0)
				)
				(= preventInput 1)
				(User canControl: 0)
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 283 113 self
				)
			)
			(1
				(gEgo
					view: 101
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setMotion: 0
					setCycle: End self
				)
			)
			(2
				(= gCurrentStatus 1010)
				(= preventInput 0)
			)
			(3
				(gEgo setLoop: 0 setCel: 255 setCycle: Beg self setMotion: 0)
				(= preventInput 1)
			)
			(4
				(NormalEgo 2)
				(= preventInput 0)
			)
		)
	)
)

(instance MDscript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(= MDatPodium 0)
				(aMaitreD
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 172 155 self
				)
			)
			(2
				(aMaitreD setMotion: MoveTo 189 155 self)
			)
			(3
				(aMaitreD cel: 0 setMotion: MoveTo 210 155 self)
				(aRope setCycle: End)
			)
			(4
				(rm43Script cue:)
			)
			(8
				(aMaitreD setMotion: MoveTo 209 102 self)
			)
			(9
				(aMaitreD setMotion: MoveTo 209 139 self)
			)
			(10
				(aMaitreD setMotion: MoveTo 172 155 self)
			)
			(11
				(aMaitreD setMotion: MoveTo 154 167 self)
			)
			(12
				(aMaitreD setLoop: 2)
				(= MDatPodium 1)
				(rm43Script cue:)
			)
		)
	)
)

(instance groupScript of Script
	(properties)

	(method (init)
		(= state 0)
	)

	(method (changeState newState)
		(switch (= state newState)
			(3
				(rm43Script cue:)
			)
		)
	)
)

(instance aChair of Prop
	(properties
		y 111
		x 287
		view 433
		loop 5
		cycleSpeed 2
	)
)

(instance aTable of Prop
	(properties
		y 116
		x 272
		view 433
		loop 6
		cycleSpeed 2
	)
)

(instance aRope of Prop
	(properties
		y 143
		x 225
		view 433
		loop 4
	)
)

(instance aMaitreD of Act
	(properties
		y 166
		x 154
		view 434
		illegalBits 0
	)
)

(instance aMan of Act
	(properties
		y 234
		x 188
		view 435
		loop 3
		illegalBits 0
	)
)

(instance aWoman of Act
	(properties
		y 234
		x 204
		view 438
		loop 3
		illegalBits 0
	)
)

(instance enterScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 102])
		(switch (= state newState)
			(1
				(if (!= gCurrentStatus 1009)
					(-- state)
					(= seconds (Random 2 4))
				else
					(= seconds 0)
					(= preventInput 1)
					(User canControl: 0)
					(aMan
						posn: 188 234
						setCycle: Walk
						show:
						setMotion: MoveTo 188 175 self
					)
					(aWoman
						posn: 204 234
						setCycle: Walk
						show:
						setMotion: MoveTo 204 175
					)
				)
			)
			(2
				(= MDatPodium 0)
				(aMaitreD
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 172 155 self
				)
			)
			(3
				(aMaitreD setMotion: MoveTo 189 155 self)
			)
			(4
				(aMaitreD cel: 0 setMotion: MoveTo 210 155 self)
				(aRope setCycle: End)
			)
			(5
				(rm43Script cue:)
				(= cycles 10)
			)
			(6
				(aWoman setMotion: MoveTo 193 165 self)
			)
			(7
				(aWoman setMotion: MoveTo 193 149)
				(aMan setMotion: MoveTo 193 165 self)
			)
			(8
				(aMan setMotion: MoveTo 193 152 self)
			)
			(9
				(aMaitreD setMotion: MoveTo 185 155 self)
				(aRope setCycle: Beg)
			)
			(10
				(aMaitreD setMotion: MoveTo 210 155 self)
			)
			(11
				(Print 43 56) ; "Please, walk this way."
				(= preventInput 0)
				(rm43Script cue:)
			)
		)
	)
)

(instance aCheese of PV
	(properties
		y 134
		x 22
		view 433
		priority 6
		signal 16384
	)
)

(instance aSalad of PV
	(properties
		y 121
		x 63
		view 433
		cel 1
		priority 6
		signal 16384
	)
)

(instance aFood of PV
	(properties
		y 163
		x 37
		view 433
		cel 2
		priority 13
		signal 16384
	)
)

(instance aT1 of PV
	(properties
		y 81
		x 116
		view 433
		loop 3
		cel 1
		priority 3
		signal 16384
	)
)

(instance aT2 of PV
	(properties
		y 119
		x 65
		view 433
		loop 3
		priority 7
		signal 16384
	)
)

(instance aT3 of PV
	(properties
		y 100
		x 178
		view 433
		loop 3
		cel 1
		priority 5
		signal 16384
	)
)

(instance aT4 of PV
	(properties
		y 100
		x 242
		view 433
		loop 3
		cel 1
		priority 5
		signal 16384
	)
)

(instance aT5 of PV
	(properties
		y 143
		x 168
		view 433
		loop 3
		priority 9
		signal 16384
	)
)

(instance aLchair of PV
	(properties
		y 171
		x 230
		view 433
		loop 3
		cel 2
		priority 13
		signal 16384
	)
)

(instance aWpicture of PV
	(properties
		y 77
		x 53
		view 433
		loop 2
		cel 1
		priority 4
		signal 16384
	)
)

(instance aEpicture of PV
	(properties
		y 55
		x 178
		view 433
		loop 2
		priority 2
		signal 16384
	)
)

(instance aMan1 of PV
	(properties
		y 73
		x 135
		view 435
		loop 4
		priority 4
		signal 16384
	)
)

(instance aWoman1 of PV
	(properties
		y 73
		x 99
		view 438
		loop 4
		priority 4
		signal 16384
	)
)

(instance aMan2 of PV
	(properties
		y 109
		x 87
		view 435
		loop 4
		priority 8
		signal 16384
	)
)

(instance aWoman2 of PV
	(properties
		y 110
		x 44
		view 438
		loop 4
		priority 8
		signal 16384
	)
)

(instance aMan3 of PV
	(properties
		y 92
		x 197
		view 435
		loop 4
		priority 6
		signal 16384
	)
)

(instance aWoman3 of PV
	(properties
		y 92
		x 161
		view 438
		loop 4
		priority 6
		signal 16384
	)
)

(instance aMan4 of PV
	(properties
		y 92
		x 261
		view 435
		loop 4
		priority 6
		signal 16384
	)
)

(instance aWoman4 of PV
	(properties
		y 92
		x 225
		view 438
		loop 4
		priority 6
		signal 16384
	)
)

(instance aMan5 of PV
	(properties
		y 133
		x 190
		view 435
		loop 4
		priority 10
		signal 16384
	)
)

(instance aWoman5 of PV
	(properties
		y 134
		x 151
		view 438
		loop 4
		priority 10
		signal 16384
	)
)

(instance aOldDoor of PV
	(properties
		y 63
		x 287
		view 433
		loop 1
		signal 16384
	)
)

