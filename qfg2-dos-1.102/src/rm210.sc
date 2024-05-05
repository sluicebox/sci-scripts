;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use TopWindow)
(use Stage)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm210 0
)

(local
	whichQuestion
	[windowParams 51] = [{Erasmus:} 11 5 {Fenrus:} 5 11 {Zara:} 0 9 {Aziza:} 13 0 {Houdini:} 8 3 {Merlyn:} 0 7 {Ad Avis:} 7 0 {Low Voice:} 14 6 {Fluid Voice:} 15 1 {Breathy Voice:} 0 11 {Ardent Voice:} 4 14 {Voices:} 15 8 {Earth Wizard:} 14 6 {Water Wizard:} 15 1 {Air Wizard:} 0 11 {Fire Wizard:} 4 14 {Wizards:} 15 8]
)

(procedure (WhoPrint who &tmp thisWin thisTitle whichWindow)
	(= thisWin (= thisTitle (* who 3)))
	(= whichWindow (if (OneOf who 1 12 13 15 14) MidWindow else TopWindow))
	(whichWindow color: [windowParams (++ thisWin)] back: [windowParams (++ thisWin)])
	(Print &rest #title [windowParams thisTitle] #width 300 #window whichWindow #mode 1)
)

(procedure (BadReaction)
	(switch whichQuestion
		(1
			(SkillUsed 13 -65) ; communication
			(SkillUsed 14 -100) ; honor
			(WhoPrint 11 210 88) ; "We do not accept liars in our tower."
			(gCurRoom setScript: zapEgoOutS)
		)
		(2
			(WhoPrint 11 210 89) ; "We do not accept intruders in our tower."
			(gCurRoom setScript: zapEgoOutS)
		)
		(3
			(WhoPrint 11 210 41) ; "That is not an appropriate sponsor."
		)
	)
)

(instance rm210 of Stage
	(properties
		picture 210
		style 15
		south 229
		bottomFromX 160
		bottomToX 160
	)

	(method (init)
		(LoadMany rsVIEW 183 210 215 216 210)
		(erasmusPic init: stopUpd:)
		(door init: stopUpd:)
		(gEgo init:)
		(NormalEgo)
		(gCSound number: 211)
		(cond
			((IsFlag 65) ; fPassedTest
				(= inOut 3)
				(self setScript: passedTestS)
			)
			((== gPrevRoomNum 215)
				(= inOut 3)
				(self setScript: passedPretestS)
			)
			((IsFlag 64) ; fPassedPretest
				(= entranceScript playItAgainS)
			)
			((IsFlag 63) ; fWITSponsor
				(= entranceScript failedPretestS)
			)
			(else
				(SetFlag 28) ; fTeleporting
				(gCSound number: 210)
				(= entranceScript whoBU)
			)
		)
		(super init:)
		(gCSound loop: -1 init: playBed:)
		(if (== gPrevRoomNum 215)
			(gEgo illegalBits: 0 posn: 252 122)
		)
		(flame1 init: setCycle: Fwd)
		(flame2 init: setCycle: Fwd)
		(flame3 init: setCycle: Fwd)
		(flame4 init: setCycle: Fwd)
		(InitAddToPics
			harryPic
			azizaPic
			avisPic
			darkPic
			zaraPic
			eranaPic
			merlinPic
			dragon1
			dragon2
			BASE1
			BASE2
			pillar1
			pillar2
			top1
			top2
			pole1
			pole2
			wit
		)
		(InitFeatures
			thePath
			leftFarColumn
			rightFarColumn
			nearLeftCarving
			farLeftCarving
			farRightCarving
			nearRightCarving
		)
		(= gSpellChecker gAllChecker)
		(gKeyDownHandler addToFront: self)
	)

	(method (doit)
		(cond
			((and (& (gEgo onControl: 1) $0002) (== inOut 3))
				(= inOut 2)
				(= whereTo south)
				(= gRoomExitDir 3)
				(HandsOff)
				(gEgo setMotion: MoveTo 160 260 self)
			)
			((and (!= whichQuestion 0) (< (gEgo y:) 126))
				(gEgo y: 126 setMotion: 0)
				(WhoPrint 11 210 0) ; "You may go no further."
			)
			(else
				(super doit: &rest)
			)
		)
	)

	(method (handleEvent event &tmp whichStr [tmpStr 100])
		(cond
			((super handleEvent: event))
			((== (self script:) zapEgoOutS)
				(event claimed: 1)
			)
			((Said 'search,look,look[<at,around][/room,area][/!*]')
				(Print 210 1) ; "Testing..."
			)
			((Said 'look,look')
				(event claimed: 0)
			)
			((!= whichQuestion 0)
				(if
					(= whichStr
						(LookFor
							event
							0
							{look}
							@gUserName
							{wizard}
							{mag}
							{init}
							{glory}
							{erana}
							{zara}
							{aziza}
							{merl}
							{avis}
							{houdini}
							{erasmus}
							{save}
							{steal}
							{cast}
							{ask}
						)
					)
					(cond
						((== whichStr 1)
							(Parse (User inputLineAddr:) event)
							(event type: evSAID)
							(event claimed: 0)
							(User said: event)
						)
						((and (== whichQuestion 1) (== whichStr 2))
							(TrySkill 13 100) ; communication
							(SetFlag 66) ; fWITName
							(= whichQuestion 0)
							(whoBU cue:)
						)
						((and (== whichQuestion 2) (<= 3 whichStr 6))
							(TrySkill 13 100) ; communication
							(SetFlag 183) ; fWITWhyHere
							(= whichQuestion 0)
							(whoBU cue:)
						)
						((and (== whichQuestion 3) (<= 7 whichStr 13))
							(switch whichStr
								(7
									(WhoPrint 11 210 2) ; "To our regret, she has not answered our summons for many years. You must choose another sponsor."
								)
								(8
									(WhoPrint
										11
										(Format @tmpStr 210 3 @gUserName) ; "Zara Shashina, Wizard of the Eastern Woods, Emissary of the Faerie Folk: do you accept %s to be your initiate into the Wizard's Institute of Technocracy?"
									)
									(WhoPrint 2 210 4) ; "Outside of the few spells I gave him, I have no knowledge of his skills or abilities. I will not accept responsibility for him."
									(WhoPrint 11 210 5) ; "You must choose another sponsor."
								)
								(9
									(WhoPrint
										11
										(Format @tmpStr 210 6 @gUserName) ; "Aziza, Enchantress of Shapeir, Wizard of Water: do you accept %s to be your initiate into the Wizard's Institute of Technocery?"
									)
									(WhoPrint 3 210 7) ; "I cannot pass judgement upon the candidate until I have worked with him for some months. I am unwilling to have someone I do not know well as my initiate."
									(WhoPrint 11 210 5) ; "You must choose another sponsor."
								)
								(10
									(WhoPrint
										11
										(Format @tmpStr 210 8 @gUserName) ; "Trismagister Merlyn Ambrosius, Wizard of the Isle of Gramarye: do you accept %s to be your initiate into the Wizard's Institute of Technocery?"
									)
									(WhoPrint 5 210 9) ; "Have we met before? No, I don't believe so. Sorry."
									(WhoPrint 11 210 5) ; "You must choose another sponsor."
								)
								(11
									(WhoPrint
										11
										(Format @tmpStr 210 10 @gUserName) ; "Ad Avis, Wizard of the Southern Sands, Enchanter of the Elements: do you accept %s to be your initiate into the Wizard's Institute of Technocery?"
									)
									(HighPrint 210 11) ; "You hear a man's voice, deep and sonorous."
									(WhoPrint 6 210 12) ; "So, a Want-to-Be Wizard seeks me for a master? I am not interested in half-trained novices."
									(WhoPrint 6 210 13) ; "However, should you actually become a Wizard, you might be of use to me. There is much I can teach you."
									(WhoPrint 6 210 14) ; "Until that time, find someone else to paper-train you."
									(WhoPrint 11 210 5) ; "You must choose another sponsor."
								)
								(12
									(WhoPrint
										11
										(Format @tmpStr 210 15 @gUserName) ; "Houdini, Prestidigitator Paramount of far-away lands, Master of Escape: do you accept %s to be your initiate into the Wizard's Institute of Technocery?"
									)
									(HighPrint 210 16) ; "You hear a man's distant voice, apparently under great stress."
									(WhoPrint
										4
										(Format @tmpStr 210 17 @gUserName) ; "Mmmmph! I'm (gasp) a bit tied up (m-m-mmmmph!) at the moment, uh... uh... (ack!) The name escapes me. Now, you really MUST excuse... (choke)... me."
									)
									(WhoPrint 11 210 5) ; "You must choose another sponsor."
								)
								(13
									(= whichQuestion 0)
									(SetFlag 63) ; fWITSponsor
									(HighPrint 210 18) ; "There is a moment of silence."
									(WhoPrint 7 210 19) ; "Do you actually request such a ... whimsical Wizard to be your sponsor?"
									(WhoPrint 8 210 20) ; "It was the choice he made."
									(WhoPrint 9 210 21) ; "But you know what Erasmus is like. Do we have to endure his sense of levity?"
									(WhoPrint 10 210 22) ; "It was the initiate's decision. Let him abide with it."
									(WhoPrint 11 210 23) ; "Very well."
									(WhoPrint
										11
										(Format @tmpStr 210 24 @gUserName) ; "Magister Erasmus of Zauberberg, Archmage Extraordinaire: do you accept %s to be your initiate into the Wizard's Institute of Technocery?"
									)
									(HighPrint 210 25) ; "You hear the familiar voice of Erasmus."
									(WhoPrint
										0
										(Format @tmpStr 210 26 @gUserName) ; "Let me see... %s... Ah, yes. The young Hero who was so bright."
									)
									(HighPrint 210 27) ; "You hear the squeaky voice of Fenrus."
									(WhoPrint 1 210 28) ; "You think anyone who laughs at one of your jokes to be intelligent."
									(WhoPrint 0 210 29) ; "A good sense of humor is an excellent indicator of superior intellect."
									(WhoPrint 1 210 30) ; "Yes, but the keyword is "good." Heh, heh."
									(WhoPrint
										11
										(Format @tmpStr 210 31 @gUserName) ; "Erasmus! Do you or do you not accept %s?"
									)
									(WhoPrint
										0
										(Format @tmpStr 210 32 @gUserName) ; "I, Magister Erasmus of Zauberberg, do hereby accept %s as my initiate for WIT."
									)
									(WhoPrint 11 210 33) ; "Wizard's Institute of Technocery."
									(WhoPrint 0 210 34) ; "Of course. Now, Hero of Spielburg, before you can be initiated into WIT..."
									(WhoPrint 11 210 33) ; "Wizard's Institute of Technocery."
									(WhoPrint 0 210 35) ; "... Wizard's Institute of Technocery, you must first prove you are magically and mentally worthy. You will be presented with a choice of three objects. Using the Spells at your command, you must chose the correct object, move it to the stand, and cause it to ring using only three spells. The choice of the first two spells should be self-evident, and the third is also..."
									(WhoPrint 11 210 36) ; "Erasmus!"
									(WhoPrint 0 210 37) ; "Oh, all right. Well, good luck, young hero, and remember the joke about the man who grew more mellow as he grew balder ..."
									(WhoPrint 1 210 38) ; "He no longer had hair-brained schemes?"
									(WhoPrint 0 210 39) ; "No, he no longer had such a hair-triggered temper."
									(WhoPrint 11 210 36) ; "Erasmus!"
									(WhoPrint 0 210 40) ; "Very well then, young hero, please step into the dark room. Purely a formality. Don't worry about a thing."
									(self setScript: gotoPreTestS)
								)
								(else
									(WhoPrint 11 210 41) ; "That is not an appropriate sponsor."
								)
							)
						)
						((== whichStr 14)
							(if (Parse (User inputLineAddr:) event)
								(event type: evSAID claimed: 0)
								(User said: event)
							)
						)
						((>= whichStr 15)
							(WhoPrint 7 210 42) ; "How rude."
							(WhoPrint 8 210 43) ; "He doesn't seem to be house trained."
							(WhoPrint 9 210 44) ; "I say we scatter him to the four winds."
							(WhoPrint 10 210 45) ; "No, he's merely young and impetuous."
							(WhoPrint 11 210 46) ; "Begone! You may return when you have learned to behave."
							(self setScript: zapEgoOutS)
						)
						(else
							(BadReaction)
							(event claimed: 1)
						)
					)
				else
					(BadReaction)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance whoBU of Script
	(properties)

	(method (changeState newState &tmp [tmpName 21])
		(switch (= state newState)
			(0
				(if (not (IsFlag 62)) ; f210
					(SolvePuzzle 684 11 1)
					(HighPrint 210 47) ; "You have entered a very strange place The path you walk upon seems to be carved from ivory. The walls around you seem carved of marble."
					(HighPrint 210 48) ; "Between the walls and the path is a gap through which you view total darkness when you look down. When you look up, you see the same limitless black."
					(HighPrint 210 49) ; "You have a funny feeling you aren't in Shapeir anymore."
					(HighPrint 210 50) ; "You have been walking through halls hung with the portraits of many Wizards. At last, you come to some pictures that you recognize."
					(SetFlag 62) ; f210
				)
				(cond
					((not (IsFlag 66)) ; fWITName
						(HighPrint 210 51) ; "You hear several voices."
						(WhoPrint 11 210 52) ; "Who are you that enters the lofty portals of the Wizard's Institute of Technocery?"
						(= whichQuestion 1)
					)
					((not (IsFlag 183)) ; fWITWhyHere
						(self cue:)
					)
					((not (IsFlag 63)) ; fWITSponsor
						(self changeState: 2)
					)
				)
			)
			(1
				(WhoPrint 11 210 53) ; "Why have you sought to enter into the Wizard's Institute of Technocery?"
				(= whichQuestion 2)
			)
			(2
				(WhoPrint 11 210 54) ; "Who do you call upon to be your sponsor and mentor in these hallowed halls of the Wizard's Institute of Technocery?"
				(= whichQuestion 3)
			)
			(3
				(HandsOn 1)
				(self dispose:)
			)
		)
	)
)

(instance passedPretestS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(erasmusPic show: cel: 0 setPri: 5 setCycle: End self)
				(door show:)
			)
			(1
				(gEgo setMotion: MoveTo 157 126 self)
			)
			(2
				(erasmusPic setCycle: Beg self)
			)
			(3
				(SetFlag 64) ; fPassedPretest
				(WhoPrint 11 210 55) ; "You have shown yourself to be resourceful in your use of spells under simple conditions. To become a Wizard, you must prove that you are capable of using magic under time-critical and life-threatening conditions."
				(cond
					((not (and (gEgo knows: 27) (gEgo knows: 28))) ; forceBoltSpell, levitateSpell
						(WhoPrint 11 210 56) ; "However, we see that you do not yet have knowledge of all the spells required. Go then, and master the spells available to you. Return when you think yourself ready."
					)
					((WhoPrint 11 210 57 81 {Yes} 1 81 {No} 0) ; "You will be presented with a series of four tests. They will require all your intelligence and magic. Should you fail, your very life may be endangered. Will you accept the challenge and walk the path of Wizardry?"
						(self cue:)
					)
					(else
						(WhoPrint 11 210 58) ; "Then you may leave, mere user of magic."
						(client setScript: zapEgoOutS)
					)
				)
			)
			(4
				(door setCycle: End self)
			)
			(5
				(gEgo setMotion: MoveTo 157 114 self)
			)
			(6
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance passedTestS of HandsOffScript
	(properties)

	(method (changeState newState &tmp [tmpStr 120])
		(switch (= state newState)
			(0
				(gEgo posn: 157 164 hide: setMotion: 0)
				(Face gEgo wiz2)
				(wiz1 init: loop: 1 stopUpd:)
				(wiz2 init: loop: 1 stopUpd:)
				(wiz3 init: loop: 1 stopUpd:)
				(wiz4 init: loop: 1 stopUpd:)
				(sparkle
					posn: 157 148
					cel: 0
					init:
					setPri: 12
					setCycle: End self
				)
			)
			(1
				(gEgo show:)
				(sparkle setCycle: Beg self)
			)
			(2
				(sparkle dispose:)
				(RedrawCast)
				(WhoPrint 12 210 59) ; "You have proven yourself worthy of the Wizard's Institute of Technocery and Erasmus' faith. Congratulations. You are now a Wizard Initiate."
				(WhoPrint 14 210 60) ; "Now you have outgrown the childish Hero business and can devote yourself to years of metaphysical musings and esoteric exercises designed to invigorate your intellect and to manipulate your mental and magical muscles."
				(WhoPrint 13 210 61) ; "You have passed this day from the lesser mortal plane into the Realm of Wizards. You are now qualified to begin your post-graduate magical training. In fifteen or twenty years, you will be ready to return to the world of mere men. Until that time, you will bask in the sunshine and security of academia, knowing you shall receive the best of all possible educations."
				(WhoPrint 15 210 62) ; "Ahead of you are the wonders of Wizardry. Behind you are all the petty problems inherent in the mundane land. You have passed beyond those weaklings who depended upon your skills and dared to call you "friend." You will now learn the real Magic of the Wizard's Institute of Technocery -- knowledge gained through careful study."
				(if (WhoPrint 16 210 63 81 {Yes} 1 81 {No} 0) ; "Walk away from the world of those fools who claim they need you. You are more than just a Hero now. You are a scholar! You have only to take the oath that you will ignore and forget about those who said they needed you in the land of Shapeir and devote yourself to the improvement of your mind and magic. Will you take the oath?"
					(self cue:)
				else
					(self changeState: 5)
				)
			)
			(3
				(WhoPrint 16 210 64) ; "Welcome to the Wizard's Institute of Technocery, Wizard."
				(gEgo setMotion: MoveTo 160 155 self)
			)
			(4
				(Print 210 65) ; "You walk the hallowed halls of the ivory towers of WIT and devote the next twenty years of your life to learning. You become one of the greatest scholars of all time upon the subject of "Scrying Scrolls.""
				(Print 210 66) ; "You never did return to Shapeir again, because, for some reason the WIT Wizards were unable to explain, the door to that land became permanently closed. They believe it had something to do with the land being destroyed."
				(EgoDead
					1
					{You are now a very knowledgeable Wizard. However, on occasion, you find yourself wondering what ever happened to Abdulla Doo, the Kattas, and to all your other friends in Shapeir.__And you wonder: wouldn't it have been better to have endured your "Trial by Fire"?}
					#title
					{That was the Wiz that was}
				)
			)
			(5
				(SolvePuzzle 685 7 1)
				(WhoPrint 16 210 67) ; "Well, it is obvious you think being a Hero is more important than being a scholar. Perhaps someday when you have matured a bit, you will comprehend the enormity of the education you have ignored! The Wizard's Institute of Technocery is for real Wizards rather than the real world!"
				(wiz1 setCycle: End)
				(wiz2 setCycle: End)
				(wiz3 setCycle: End)
				(wiz4 setCycle: End self)
			)
			(6
				(WhoPrint 0 (Format @tmpStr 210 68 @gUserName)) ; "Congratulations, Wizard %s. You have shown exceptional intelligence by refusing to take their silly oath. After all, what good is magic or knowledge unless you use it?"
				(WhoPrint 0 210 69) ; "My graduation present for you is the "Reversal" Spell. You may recall the Kobold's use of it against you in Spielburg."
				(WhoPrint 0 210 70) ; "Cast Reversal and magical attacks directed at you will rebound to their caster. But take care -- it will not help against the indirect effects of other spells."
				(gEgo learn: 29 10) ; invisibility
				(HighPrint 210 71) ; "You feel the thrill of knowledge. Now you know how to cast the Spell of "Reversal.""
				(WhoPrint 0 210 72) ; "You should now return to Shapeir. They really need a real Wizard-Hero like you there. And, remember, "Those who can, do.""
				(WhoPrint 1 210 73) ; "Those that can't, tell others what to do?"
				(WhoPrint 0 210 74) ; "Fenrus, when is a rat not a rat?"
				(WhoPrint 1 210 75) ; "When it turns into its rathole?"
				(WhoPrint 0 210 76) ; "No, when it's e'rat'icated. What did the rat say as he fell 12,000 feet straight down?"
				(WhoPrint 1 210 77) ; "It's a long way to tip a ratty? Or maybe, "Cheese it, I Swiss I hadn't gone this Whey." Oh, all right, what did the rat say?"
				(WhoPrint 0 210 78) ; "I'm not sure either, but I know a way to find out. Care to volunteer?"
				(WhoPrint 1 210 79) ; "I guess I Bleu it. I'd Cheddar be Gouda for awhile, right?"
				(WhoPrint 0 210 80) ; "Right. At any rate, Wizard-Hero, good luck and farewell!"
				(client setScript: zapEgoOutS)
			)
		)
	)
)

(instance playItAgainS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WhoPrint 16 210 81) ; "Walk the path of Wizardry."
				(gEgo setMotion: MoveTo 160 155 self)
			)
			(1
				(door setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 160 144 self)
			)
			(3
				(gCurRoom newRoom: 220)
			)
		)
	)
)

(instance failedPretestS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WhoPrint 11 210 82) ; "Magister Erasmus of Zauberberg, Archmage Extraordinaire, your would-be initiate has returned."
				(= cycles 8)
			)
			(1
				(WhoPrint 0 210 83) ; "Very good. Now, young Hero of Spielburg, remember: To try and fail there is no shame ..."
				(WhoPrint 1 210 84) ; "As long as you can pass the blame?"
				(WhoPrint 0 210 85) ; "As long as you improve your aim."
				(WhoPrint 1 210 86) ; "Just don't make your excuses lame. Heh, heh!"
				(client setScript: gotoPreTestS)
			)
		)
	)
)

(instance gotoPreTestS of HandsOffScript
	(properties)

	(method (changeState newState &tmp whichBell)
		(switch (= state newState)
			(0
				(erasmusPic setPri: 5 setCycle: End self)
			)
			(1
				(WhoPrint 0 210 87) ; "Ouch! My nose!"
				(gEgo setMotion: MoveTo 157 124 self)
			)
			(2
				(gEgo setMotion: MoveTo 252 122 self)
			)
			(3
				(gCSound fade:)
				(gCurRoom newRoom: 215)
			)
		)
	)
)

(instance zapEgoOutS of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= [gEgoStats 17] 0) ; stamina
				(gSpareSound number: 342 loop: 1 play:)
				(sparkle
					view: 183
					loop: 0
					cel: 0
					posn: (gEgo x:) (- (gEgo y:) 36)
					setCycle: End self
					init:
				)
			)
			(1
				(sparkle dispose:)
				(gEgo hide:)
				(= cycles 4)
			)
			(2
				(= gRoomExitDir 3)
				(gCurRoom newRoom: 229)
			)
		)
	)
)

(instance pillar1 of PicView
	(properties
		x 35
		y 153
		noun '/column,column'
		description {the ornate column}
		view 216
		cel 1
		priority 15
		signal 16
	)
)

(instance pillar2 of PicView
	(properties
		x 282
		y 154
		description {the ornate column}
		view 216
		loop 1
		cel 1
	)
)

(instance top1 of PicView
	(properties
		x 282
		y 39
		view 216
		loop 1
		priority 10
		signal 16
	)

	(method (onMe)
		(return 0)
	)
)

(instance top2 of PicView
	(properties
		x 35
		y 38
		view 216
		loop 1
		priority 10
		signal 16
	)

	(method (onMe)
		(return 0)
	)
)

(instance dragon1 of PicView
	(properties
		x 112
		y 52
		noun '/dragon,creature'
		description {the carved dragons}
		lookStr {There are two intricately carved creatures -- probably dragons -- placed above either side of the path.}
		view 215
		loop 2
	)
)

(instance dragon2 of PicView
	(properties
		x 206
		y 53
		noun '/dragon,creature'
		description {the carved dragons}
		lookStr {There are two intricately carved creatures -- probably dragons -- placed above either side of the path.}
		view 215
		loop 3
	)
)

(instance BASE1 of PicView
	(properties
		x 45
		y 189
		view 216
		cel 2
		priority 10
		signal 16
	)
)

(instance BASE2 of PicView
	(properties
		x 274
		y 190
		view 216
		loop 1
		cel 2
		priority 10
		signal 16
	)
)

(instance pole1 of PicView
	(properties
		x 123
		y 112
		view 216
		cel 3
		priority 4
		signal 16
	)
)

(instance pole2 of PicView
	(properties
		x 196
		y 112
		view 216
		loop 1
		cel 3
		priority 4
		signal 16
	)
)

(instance wit of PicView
	(properties
		x 160
		y 25
		noun '/logo,wit,sign'
		description {the WIT sign}
		lookStr {This is it...the WIT.}
		view 216
		loop 2
		priority 10
		signal 16
	)
)

(instance harryPic of PicView
	(properties
		x -7
		y 154
		noun '/harry,(artist<escape),mage'
		description {the portrait of Harry Houdini, the Escape Artist.}
		lookStr {The portrait shows Harry Houdini in a typical state of intense concentration.}
		view 215
	)
)

(instance azizaPic of PicView
	(properties
		x 52
		y 156
		noun '/aziza,enchantress,portrait,painting[<aziza,enchantress][/aziza,enchantress]'
		description {the portrait of Aziza, the Enchantress.}
		lookStr {The portrait is politely formal, befitting Aziza the Enchantress}
		view 215
		cel 1
	)
)

(instance avisPic of PicView
	(properties
		x 78
		y 130
		noun '/ad,wizard,enchant,portrait,painting[<ad,wizard,enchant][/ad,wizard,enchant]'
		description {the portrait of Ad Avis, the Enchanter.}
		lookStr {The portrait shows a Wizard with a severe nature.__He appears totally humorless.}
		view 215
		cel 2
	)
)

(instance darkPic of PicView
	(properties
		x 97
		y 113
		noun '/portrait,painting[<black,dark,empty][/!*]'
		description {the portrait of Darkness}
		lookStr {The picture is entirely black.}
		view 215
		cel 3
	)
)

(instance zaraPic of PicView
	(properties
		x 220
		y 113
		noun '/zara,wizard,emissary,portrait,painting[<zara,emissary,wizard][/zara,emissary,wizard]'
		description {the portrait of Zara, the Wizard}
		lookStr {Like most of the Wizards, Zara's expression is serious and intent.__She shows little propensity towards humor.}
		view 215
		cel 4
		priority 1
		signal 16
	)
)

(instance erasmusPic of Prop
	(properties
		x 239
		y 130
		noun '/erasmus,wizard,portrait,painting[<erasmus,wizard][/erasmus,wizard]'
		description {the portrait of Erasmus, the jocular Wizard}
		lookStr {The portrait of Erasmus appears to be a duplicate of the one you remember hanging in his house on Zauberberg.__You think that perhaps he has a few more crinkles around his eyes.}
		view 215
		loop 1
		cycleSpeed 1
	)
)

(instance eranaPic of PicView
	(properties
		x 266
		y 155
		noun '/erana,wizard,portrait,painting[<erana,wizard][/erana,wizard]'
		description {the portrait of Erana, the lost Wizard of Spielburg}
		lookStr {You always wondered what Erana looked like.__She reminds you of Genesta, a Faery you once knew.}
		view 215
		cel 6
	)
)

(instance merlinPic of PicView
	(properties
		x 323
		y 155
		noun '/merlin,mage,portrait,painting[<merlin,mage][/merlin,mage]'
		description {the portrait of Merlyn, the legendary magician of King Arthur's Court}
		lookStr {That's funny!__He doesn't look anything like the way Peter Ledger drew him in Conquests of Camelot.}
		view 215
		cel 7
	)
)

(instance wiz1 of Prop
	(properties
		x 131
		y 73
		noun '/wizard[<fire]'
		description {the Wizard of Fire}
		lookStr {By his color, you judge that this Wizard specializes in Fire magic.}
		view 210
		priority 3
		signal 16400
		palette 3
		cycleSpeed 2
	)
)

(instance wiz2 of Prop
	(properties
		x 148
		y 79
		noun '/wizard[<water]'
		description {the Wizard of Water}
		lookStr {By his color, you judge that this Wizard specializes in Water magic.}
		view 210
		priority 3
		signal 16400
		palette 2
		cycleSpeed 1
	)
)

(instance wiz3 of Prop
	(properties
		x 167
		y 79
		noun '/wizard[<air]'
		description {the Wizard of Air}
		lookStr {By his color, you judge that this Wizard specializes in Air magic.}
		view 210
		priority 3
		signal 16400
		palette 1
		cycleSpeed 1
	)
)

(instance wiz4 of Prop
	(properties
		x 186
		y 74
		noun '/wizard[<earth]'
		description {the Wizard of Earth}
		lookStr {By his color, you judge that this Wizard specializes in Earth magic.}
		view 210
		priority 3
		signal 16400
		palette 4
		cycleSpeed 2
	)
)

(instance door of Prop
	(properties
		x 158
		y 93
		noun '/door'
		description {the door at the end of the path}
		lookStr {The door at the end of the path leads someplace strange, no doubt.}
		view 210
		loop 2
		priority 1
		signal 16
		cycleSpeed 1
	)
)

(instance sparkle of Prop
	(properties
		shiftClick 0
		view 183
		priority 15
		signal 16400
	)
)

(instance flame1 of Prop
	(properties
		x 57
		y 166
		view 216
		loop 3
		cel 1
		priority 14
		signal 16
		cycleSpeed 1
	)
)

(instance flame2 of Prop
	(properties
		x 263
		y 166
		view 216
		loop 3
		cel 2
		priority 14
		signal 16
		cycleSpeed 1
	)
)

(instance flame3 of Prop
	(properties
		x 127
		y 98
		view 216
		loop 4
		cycleSpeed 1
	)
)

(instance flame4 of Prop
	(properties
		x 192
		y 98
		view 216
		loop 4
		cel 4
		cycleSpeed 1
	)
)

(instance thePath of Feature
	(properties
		x 160
		y 141
		noun '/path[<ivory]'
		nsTop 95
		nsLeft 118
		nsBottom 188
		nsRight 202
		description {the ivory path}
	)
)

(instance nearLeftCarving of Feature
	(properties
		x 33
		y 163
		noun '/carving,relief,frieze'
		nsTop 7
		nsBottom 39
		nsRight 66
		description {the decorative frieze}
	)
)

(instance farLeftCarving of Feature
	(properties
		x 90
		y 36
		noun '/carving,relief,frieze'
		nsTop 20
		nsLeft 66
		nsBottom 53
		nsRight 114
		description {the decorative frieze}
	)
)

(instance farRightCarving of Feature
	(properties
		x 230
		y 37
		noun '/carving,relief,frieze'
		nsTop 23
		nsLeft 206
		nsBottom 51
		nsRight 254
		description {the ornamental frieze}
	)
)

(instance nearRightCarving of Feature
	(properties
		x 286
		y 23
		noun '/carving,relief,frieze'
		nsTop 10
		nsLeft 252
		nsBottom 36
		nsRight 320
		description {the ornamental frieze}
	)
)

(instance leftFarColumn of Feature
	(properties
		x 116
		y 80
		noun '/column'
		nsTop 56
		nsLeft 112
		nsBottom 104
		nsRight 120
		description {the ornate columns}
	)
)

(instance rightFarColumn of Feature
	(properties
		x 203
		y 79
		noun '/column'
		nsTop 55
		nsLeft 199
		nsBottom 103
		nsRight 207
		description {the ornate columns}
	)
)

