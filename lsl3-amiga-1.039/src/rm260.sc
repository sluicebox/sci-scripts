;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm260 0
)

(synonyms
	(maller woman)
	(man man)
)

(local
	lieDownAfterTakingTowel
	seenMsg
	tawniBusy
	[unused 2]
	[string 40]
	[string2 22]
)

(instance rm260 of Rm
	(properties
		picture 260
		horizon 66
		west 250
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 3) ; cantSave
		(ClearFlag 4) ; preventAutoSave
		(super newRoom: newRoomNumber)
	)

	(method (init &tmp i)
		(super init:)
		(SetFlag 4) ; preventAutoSave
		(SetFlag 3) ; cantSave
		(self setScript: RoomScript)
		(if (and (TestFlag 23) (== gBeachState 0))
			(= gBeachState 1)
			(= gCurVendor 267)
		)
		(if
			(and
				(gEgo has: 3) ; Granadilla_Wood
				(< gBeachState 6)
				(== gNormalEgoView 707)
				(== gEgoState 10)
				(or
					(== ((gInventory at: 3) view:) 22) ; Granadilla_Wood
					(== ((gInventory at: 3) view:) 34) ; Granadilla_Wood
				)
			)
			(= gBeachState 5)
		)
		(if (== gEgoState 1)
			(= gBeachState 3)
			(= gCurVendor 264)
		)
		(if (< gPrevRoomNum gCurRoomNum)
			(gEgo posn: 1 174 loop: 0)
		)
		(NormalEgo)
		(switch gBeachState
			(0
				(Load rsVIEW 712)
				(aLizard init:)
			)
			(1
				(gEgo observeControl: 16384)
			)
			(2
				(aTawni setLoop: 2 setCel: 255)
				(TawniScript changeState: 8)
				(gEgo observeControl: 16384)
				(-- gBeachState)
			)
			(3
				(Load rsVIEW (- 263 (* 5 (>= gFilthLevel 3))))
				(Load rsVIEW 264)
				(Load rsSOUND 8)
				(Load rsSOUND 9)
				(Load rsSOUND 260)
				(Load rsSOUND 261)
				(aTawni
					illegalBits: 0
					ignoreActors:
					view: (- 263 (* 5 (>= gFilthLevel 3)))
					loop: 0
					cel: 0
				)
				(gEgo
					illegalBits: 0
					ignoreActors:
					view: gNormalEgoView
					loop: 0
					posn: 132 165
					setMotion: MoveTo 138 165
				)
				(RoomScript changeState: 29)
			)
			(4
				(aTawni init:)
				(gEgo observeControl: 16384)
			)
			(5
				(Load rsVIEW 707)
				(Load rsVIEW 22)
				(Load rsVIEW 34)
				(HandsOff)
				(SetFlag 5) ; noCursor
				(= gCurVendor 707)
				(= gEgoState 10)
				(aTawni init:)
			)
			(6
				(= gCurVendor -1)
				(aTowel init:)
			)
			(7
				(aTowel init: hide:)
				(= gCurVendor -1)
			)
		)
		(if (and (not gEgoIsPatti) (>= gBeachState 6))
			(Load rsVIEW (+ 701 gEgoIsHunk))
			(Load rsVIEW 261)
			(Load rsVIEW 709)
			(aLizard init:)
		)
		(if (!= gBeachState 5)
			(gEgo init:)
		)
		(if (and gBeachState (< gBeachState 6))
			(aTowel init:)
			(aTawni init:)
			(if (== gBeachState 3)
				(TawniScript changeState: 11)
			)
		)
		(if
			(and
				gCurVendor
				gBeachState
				(not gDemo)
				(!= gCurVendor -1)
				(< gBeachState 6)
			)
			(aVendor init:)
		)
		(if (and (not gDemo) (!= gBeachState 3))
			(gMusic number: 260 loop: -1 play:)
		)
		(if (and (== gEgoState 14) (or (== gPrevRoomNum 266) (== gPrevRoomNum 265)))
			(= gEgoState 0)
		)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0100)
			(if (not seenMsg)
				(= seenMsg 1)
				(Printf 260 0 gEgoName) ; "You have no desire to swim in a lagoon as polluted as this, %s!"
			)
		else
			(= seenMsg 0)
		)
		(if (and (!= gEgoState 0) (!= gEgoState 1003))
			(gEgo observeControl: 512)
		)
		(if (and (== (gEgo onControl:) 512) (== gEgoState 0))
			(self changeState: 5)
		)
	)

	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'cut,cut')
				(Print 260 1) ; "Not here; someone might see you!"
			)
			((Said 'get/crab')
				(Print 260 2) ; "You are perfectly content to allow the sand crabs to continue running everywhere in this area. Just be happy they aren't crawling on you!"
			)
			(
				(or
					(Said '(get<on),throw,use,lie,fuck/towel')
					(Said '(bath<air),sunbath')
					(Said 'get/tan,booth')
					(Said '/(bath<air),sunbath')
					(Said 'drain/cloth')
					(Said 'lie,fuck/down[<on]/towel')
				)
				(cond
					((== gEgoState 1005)
						(YouAre) ; "You are."
					)
					((== gEgoState 10)
						(Print 260 3) ; "Change clothes first."
					)
					((!= gEgoState 0)
						(NotNow) ; "Good idea. You might try that again later."
					)
					((== gBeachState 1)
						(Print 260 4) ; "That girl seems to be using almost all of her towel!"
					)
					((== gBeachState 4)
						(Print 260 5) ; "Share my towel?" asks Tawni. "Try it, and I'll break your..."
						(Print 260 6) ; "...arm!"
					)
					((== gBeachState 6)
						(Ok) ; "O.K."
						(= lieDownAfterTakingTowel 1)
						(self changeState: 9)
					)
					((not (gEgo has: 8)) ; Beach_Towel
						(DontHave) ; "You don't have it."
					)
					(else
						(Ok) ; "O.K."
						(self changeState: 13)
					)
				)
			)
			(
				(or
					(Said 'nightstand,(nightstand<up),(get<off),(get<up)')
					(Said 'sunbath<stop')
					(Said 'exit/towel')
				)
				(if (!= gEgoState 1005)
					(Print 260 7) ; "How can you do that?"
				else
					(self changeState: 23)
				)
			)
			((Said '/towel>')
				(cond
					((gEgo has: 8) ; Beach_Towel
						(event claimed: 0)
					)
					(
						(or
							(& (aTowel signal:) $0080)
							(not (gCast contains: aTowel))
						)
						(Print 260 8) ; "There is no towel here."
						(Print 260 9) ; "But... you can order an official "Leisure Suit Larry 2" beach towel just by dialing 1 (800) 326-6654 (or 1 (209) 683-4468) today!!"
						(event claimed: 1)
					)
					((Said 'get,grab,rob,(pick<up)')
						(cond
							((== gEgoState 10)
								(Print 260 3) ; "Change clothes first."
							)
							((!= gEgoState 0)
								(NotNow) ; "Good idea. You might try that again later."
							)
							((== gBeachState 1)
								(Print 260 10) ; "You can't take the towel when that girl is lying upon it."
							)
							((== gBeachState 4)
								(Print 260 11) ; "Take my towel from me?" asks Tawni. "Try it, and I'll break your..."
								(Print 260 6) ; "...arm!"
							)
							((!= gBeachState 6)
								(Print 260 7) ; "How can you do that?"
							)
							(else
								(Ok) ; "O.K."
								(self changeState: 9)
							)
						)
					)
					((Said 'look')
						(cond
							((and (>= gBeachState 1) (<= gBeachState 5))
								(Print 260 12) ; "Wouldn't you love to be in its place?"
							)
							((< gBeachState 6)
								(Print 260 13) ; "There's a towel under that girl."
							)
							((== gBeachState 6)
								(Print 260 14) ; "Oh, look! Tawni forgot her towel."
							)
							((== gEgoState 1005)
								(Print 260 15) ; "The towel is under you, protecting you from the sand crabs!"
							)
							(else
								(event claimed: 0)
							)
						)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			((Said 'look>')
				(cond
					((Said '/boulder,boulder')
						(Print 260 16) ; "Occasionally lizards love to scamper across the rocks here at Sunaffa Beach."
					)
					((Said '/bay,water,bay')
						(Print 260 17) ; "The reflection of the brilliant tropical sun off the waters of Nontoonyt Lagoon has a beautiful, aquamarine glow, due in large part to the quantity of raw sewage dumped directly into the water by Natives, Inc., although zillions in corporate revenue have been saved in the process of non-processing."
						(Print 260 18) ; "You suppose that means swimming is not recommended."
					)
					((or (Said 'down<look') (Said '/beach,down,beach'))
						(Print 260 19) ; "How interesting. Hundreds of tiny sand crabs are running about all over the sand of beautiful Sunaffa Beach."
					)
					((Said '/crab')
						(Print 260 20) ; "The sand crabs are everywhere. You feel fortunate they aren't crawling all over you!"
					)
					((Said '[/area]')
						(if (and gBeachState (< gBeachState 5))
							(Print 260 21) ; "There is a beautiful topless woman lying here, sunbathing on her towel."
						else
							(Print 260 22) ; "Beautiful Sunaffa Beach is deserted."
						)
						(Print 260 23) ; "There is something moving in the sand."
					)
				)
			)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0)
			(5
				(= cycles (= seconds 0))
				(HandsOff)
				(= gEgoState 1003)
				(gEgo
					view: (if gEgoIsPatti 812 else 712)
					illegalBits: -513
					cycleSpeed: 1
					moveSpeed: 1
					setStep: 2 2
					setCycle: Fwd
				)
				(= seconds 3)
			)
			(6
				(gEgo setMotion: 0 setCycle: End self)
			)
			(7
				(gEgo hide:)
				(= seconds 2)
			)
			(8
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: (+ 4 (gEgo view:))
					register: (Format @string 260 24 gEgoName) ; "Next time, %s, stay out of that polluted lagoon!"
					next: (Format @string2 260 25) ; "You're in over your head again"
				)
			)
			(9
				(HandsOff)
				(gEgo setMotion: MoveTo 126 155 self)
			)
			(10
				(gEgo view: 709 setLoop: 0 cel: 0 setCycle: End self)
			)
			(11
				(aTowel hide:)
				(gEgo get: 8 setCycle: Beg self) ; Beach_Towel
				(= gBeachState 7)
				(gGame changeScore: 2)
			)
			(12
				(if lieDownAfterTakingTowel
					(= lieDownAfterTakingTowel 0)
					(self cue:)
				else
					(NormalEgo)
				)
			)
			(13
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 151 170 self)
				(LizardScript changeState: 8)
			)
			(14
				(gEgo
					view: 261
					setLoop: 0
					cel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(15
				(aTowel view: 261 loop: 1 posn: 184 170 show: stopUpd:)
				(gEgo
					view: gNormalEgoView
					cycleSpeed: 0
					setCycle: Walk
					setMotion: MoveTo 184 170 self
				)
			)
			(16
				(gEgo
					cycleSpeed: 1
					view: (+ 701 gEgoIsHunk)
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(17
				(gEgo view: 261 setLoop: 2 cel: 0 setCycle: End self)
				(LizardScript changeState: 9)
			)
			(18
				(= gEgoState 1005)
				(User canInput: 1)
				(= seconds 5)
			)
			(19
				(Print 260 26) ; "The tropical sun warms you all over."
				(= seconds 5)
			)
			(20
				(Print 260 27) ; "You know, a guy could get a nice suntan here."
				(= seconds 5)
			)
			(21
				(if (TestFlag 11)
					(Print 260 28) ; "You had a pretty good tan when you laid down here."
					(= seconds 4)
				else
					(SetFlag 11) ; scoredTan
					(gGame changeScore: 30)
					(Print 260 29) ; "Your tan now looks MAHvelous."
					(= seconds 10)
				)
			)
			(22
				(Print 260 30) ; "As the tropical sun slices through a hole in the severely depleted ozone layer directly above the pollution of Nontoonyt, you seem to remember reading an article somewhere about UV overexposure being dangerous..."
				(gGame setScript: (ScriptID 40)) ; DyingScript
				((ScriptID 40) ; DyingScript
					caller: 259
					register: (Format @string 260 31) ; "Some guys never learn!"
					next: (Format @string2 260 32) ; "Another case of executive burnout"
				)
			)
			(23
				(HandsOff)
				(Ok) ; "O.K."
				(= seconds 0)
				(gEgo view: 261 setCycle: Beg self)
			)
			(24
				(gEgo
					view: (+ 701 gEgoIsHunk)
					setLoop: 0
					setCel: 255
					setCycle: Beg self
				)
			)
			(25
				(gEgo
					cycleSpeed: 0
					view: gNormalEgoView
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 151 169 self
				)
			)
			(26
				(gEgo
					cycleSpeed: 1
					view: 709
					setLoop: 0
					cel: 0
					setCycle: End self
				)
			)
			(27
				(aTowel hide:)
				(gEgo setCycle: Beg self)
			)
			(28
				(NormalEgo)
				(= gEgoState 0)
			)
			(29
				(HandsOff)
				(SetFlag 5) ; noCursor
				(= seconds 0)
				(aTawni setScript: 0 setCycle: End self)
				(gMusic number: 8 loop: -1 play:)
			)
			(30
				(aTawni hide:)
				(gEgo
					posn: 153 165
					view: (- 263 (* 5 (>= gFilthLevel 3)))
					loop: 1
					cel: 0
					setCycle: End self
					cycleSpeed: 1
				)
			)
			(31
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(32
				(gEgo viewer: humpCycler setLoop: 3 setCycle: Fwd)
			)
			(33
				(Print 260 33) ; ""Whacha selling?" Tawni yells at the peddler."
				(Print 260 34) ; "The peddler smiles. "I have some fine ginsu knives.""
				(Print 260 35) ; "Excuse me for a moment, will you?" Tawni asks you. "Something else has popped up."
				(gMusic number: 9 loop: 1 play:)
				(gEgo
					viewer: 0
					cycleSpeed: 1
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(34
				(Print 260 36) ; "Well," you think to yourself, "that was rude!"
				(= seconds 3)
			)
			(35
				(Print 260 37) ; "So what do you think, lady?" says the vendor. "Wouldn't you like one of these fine ginsu knives to take home for a souvenir? For you, I'd make a special deal!"
				(Print 260 38) ; "Oooohhhh," says Tawni, "is it really a bargain? I just LOVE bargains!"
				(= seconds 3)
			)
			(36
				(Print 260 39) ; "Most assuredly so," says the peddler, "it's made with hand-rubbed hickory handles, and a blade of the finest Sheffield carbonized steel, drawn from the hottest 100-year old oak charcoal fires, honed to perfection by small Oriental virgins, and guaranteed for life!"
				(Print 260 40 #at -1 144) ; "(Or until you leave this beach, whichever comes first!)"
				(= seconds 3)
			)
			(37
				(Print 260 41) ; "I'll take it," says Tawni. "Does it come in a carrying case?"
				(Print 260 42) ; ""No," says the peddler."
				(if (>= gFilthLevel 3)
					(Print 260 43) ; ""...but I'll bet you could!" thinks the peddler."
				)
				(Print 260 44) ; ""That'll be thirty dollars," he concludes."
				(= seconds 3)
			)
			(38
				(Print 260 45) ; "Well, let me see now," replies Tawni, digging into her bikini bottoms. "Oh, gosh, I've only got twenty bucks in cash left."
				(Print 260 46) ; "But wait, I do have this nice shiny new credit card!" Turning to you, she says, "Hey, hold this knife for me, willya?"
				(gEgo get: 2) ; Ginsu_Knife
				(= gNewspaperState 1)
				(= gShowroomState 0)
				(gGame changeScore: 40)
				(= seconds 3)
			)
			(39
				(Print 260 47) ; "Thanks ever so much, madam," says the native, sliding his imprinter over your former credit card. "It's a pleasure doing business with a real pro!"
				(Print 260 48) ; "Turning back to you, Tawni says, "I'm sorry to `interruptus,' my little shopper-whopper, but you know: I just can't resist a purchase!""
				(Print 260 49) ; "And now, where were we?"
				(VendorScript changeState: 10)
				(= seconds 3)
			)
			(40
				(gEgo setCycle: Beg self)
			)
			(41
				(Print 260 50) ; "You pause to contemplate her rude behavior. Were you too offended by her thoughtless interruption to continue making love to the beautiful young Tawni?"
				(= seconds 3)
			)
			(42
				(Print 260 51) ; "Nope."
				(gMusic number: 8 loop: -1 play:)
				(gEgo viewer: humpCycler setLoop: 3 setCycle: Fwd)
				(= seconds 12)
			)
			(43
				(gMusic fade:)
				(Print 260 52) ; "Suddenly, you become aware of the hundreds of tiny sand crabs that have been crawling inside your leisure suit pants since you first laid down on the sand..."
				(gMusic number: 261 loop: -1 play:)
				(Print 260 53 #at -1 10) ; "YEEEOOOOWWWW!!!" you scream. "Quick! Get off of me!!"
				(gEgo
					viewer: 0
					cycleSpeed: 0
					loop: 4
					cel: 0
					setCycle: End self
				)
			)
			(44
				(aTawni view: 262 loop: 2 setCel: 255 show:)
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(45
				(Print 260 54 #at -1 10) ; ""Is my lovemaking that good for you, my little middle-aged mall-man?" says Tawni."
				(gEgo
					posn: 142 165
					setLoop: 6
					setCycle: Fwd
					setStep: 1 1
					setMotion: MoveTo 127 165
				)
				(= cycles 44)
			)
			(46
				(Print (Format @string 260 55 gExpletive) #at -1 10) ; "%s" you cry. "Tawni, I've got a terrible case of crabs!!"
				(gEgo cycleSpeed: 1 loop: 7 cel: 0 setCycle: End self)
			)
			(47
				(Print 260 56 #at -1 10) ; "CRABS?!" shouts Tawni, "I should have known better than to have anything to do with a local. Especially, an OLDER local! And, a PUDGY older local at that!!"
				(gEgo viewer: humpCycler loop: 8 setCycle: Fwd)
				(= seconds 3)
			)
			(48
				(Print 260 57 #at -1 10) ; "As you pull a large crab from your pants, Tawni says, "Like, man! I refuse to party with any guy so socially irresponsible! Get lost, `Flaccido Domingo!'""
				(= cycles 11)
			)
			(49
				(aTawni view: 262 setScript: TawniScript)
				(TawniScript changeState: 9)
				(gEgo viewer: 0 loop: 9 cel: 0 setCycle: End self)
			)
			(50
				(Print 260 58 #at -1 10) ; "Tawni, baby!" you cry, "Does this mean we're through?"
				(= seconds 3)
			)
			(51
				(gMusic number: 9 loop: 1 play: self)
				(Print 260 59) ; "There is no response."
				(NormalEgo 2)
				(ClearFlag 5) ; noCursor
				(gEgo observeControl: 16384)
				(= gBeachState 4)
				(= gEgoState 0)
			)
			(52
				(gMusic number: 260 loop: -1 play:)
			)
		)
	)
)

(instance aTawni of Act
	(properties
		y 165
		x 153
		view 262
		loop 1
	)

	(method (init)
		(super init:)
		(self setScript: TawniScript ignoreActors:)
	)

	(method (handleEvent event &tmp theObj)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'give,sell,show>')
				(cond
					((not (& (gEgo onControl:) $1000))
						(NotClose) ; "You're not close enough."
					)
					((== 707 (gEgo view:))
						(= theObj (gInventory saidMe:))
						(event claimed: 0)
						(cond
							((Said '[/!*]')
								(Print 260 60) ; "You must be more specific."
							)
							((not theObj)
								(Print 260 61) ; "Better check your inventory, Larry. You don't have one of those."
							)
							((not (theObj ownedBy: gEgo))
								(DontHave) ; "You don't have it."
							)
							((== theObj (gInventory at: 3)) ; Granadilla_Wood
								(Print 260 62) ; ""Hunks of wood for sale!" you shout."
								(Print 260 63) ; "Who'd want a piece of wood for a souvenir?" responds Tawni. "I can pick up one of those anywhere! No thanks, little native man."
							)
							((== theObj (gInventory at: 5)) ; Soap-On-A-Rope
								(Print 260 64) ; "Souvenir soap!"
								(Print 260 64) ; "Souvenir soap!"
								(Print 260 65) ; "Soap?! You're trying to sell me soap? What a lousy souvenir. Get out of here, pudgy nature boy!"
							)
							((== theObj (gInventory at: 11)) ; some_Orchids
								(Print 260 66) ; "Wildflowers? Why would anyone buy flowers from a beach vendor when they grow wild everywhere on this island?"
							)
							(else
								(Print 260 67) ; "No thanks," says Tawni, "I'm not interested."
							)
						)
						(Print 260 68) ; "At least she didn't recognize you in your clever disguise. Now if you only had an authentic Nontoonyt souvenir!"
					)
					((== gBeachState 4)
						(Print 260 69) ; "Oh, wow!" exclaims Tawni, without looking up. "SOUVENIRS! Whacha selling?"
						(Print 260 70) ; "She turns her head and recognizes you. "Oh, it's you, again! Leave me alone, you creep!""
						(Print 260 71 #at -1 144) ; "(Obviously she still remembers you, Larry. If only you had some sort of disguise...)"
					)
					(else
						(Print 260 72) ; "You might be able to, if you would look at her first!"
					)
				)
				(event claimed: 1)
			)
			((or (Said '//maller>') (Said '/maller>'))
				(cond
					((> gBeachState 4)
						(event claimed: 1)
						(Print 260 73) ; "Where?"
					)
					((Said 'fuck')
						(Print 260 74) ; "Yeah, yeah, that's the idea; but as usual, the question is: how?!"
					)
					((Said 'talk')
						(cond
							((not (& (gEgo onControl:) $1000))
								(NotClose) ; "You're not close enough."
							)
							((== 707 (gEgo view:))
								(Print 260 69) ; "Oh, wow!" exclaims Tawni, without looking up. "SOUVENIRS! Whacha selling?"
								(Print 260 75) ; "Larry! She doesn't recognize you in your clever disguise. Now if you only had something to sell her!"
							)
							((== gBeachState 4)
								(Print 260 69) ; "Oh, wow!" exclaims Tawni, without looking up. "SOUVENIRS! Whacha selling?"
								(Print 260 70) ; "She turns her head and recognizes you. "Oh, it's you, again! Leave me alone, you creep!""
								(Print 260 71 #at -1 144) ; "(Obviously she still remembers you, Larry. If only you had some sort of disguise...)"
							)
							(else
								(Print 260 76) ; "Before speaking to a woman, it is advisable to look at her, Larry."
							)
						)
					)
					((Said 'look')
						(cond
							((== 707 (gEgo view:))
								(Print 260 77) ; "She doesn't seem to recognize you in your clever disguise."
							)
							((== gBeachState 4)
								(Print 260 78) ; "You wonder if she still has that twenty dollars she got in change from the souvenir bead vendor."
							)
							((== tawniBusy 1)
								(Print 260 79) ; "Now? She seems to be interested in that beach vendor."
							)
							((not (& (gEgo onControl:) $1000))
								(NotClose) ; "You're not close enough."
							)
							(else
								(if (not (TestFlag 61))
									(Printf 260 80 gLaffer) ; ""Hello," you say to the beautiful young girl on the towel. %s"
								)
								(HandsOff)
								(SetFlag 5) ; noCursor
								(= gBeachState 2)
								(TawniScript changeState: 5)
							)
						)
					)
				)
			)
		)
	)
)

(instance TawniScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 7))
			)
			(1
				(aTawni cycleSpeed: 1 setLoop: 1 setCycle: End)
				(= seconds (Random 1 3))
			)
			(2
				(aTawni setCycle: Beg)
				(= seconds (Random 3 5))
			)
			(3
				(aTawni setLoop: (Random 4 5) setCycle: End)
				(= seconds (Random 3 5))
			)
			(4
				(aTawni setCycle: Beg self)
				(= state -1)
			)
			(5
				(= seconds 0)
				(aTawni cycleSpeed: 2 setLoop: 2 cel: 0 setCycle: End self)
				(if (>= gFilthLevel 3)
					(++ state)
				)
			)
			(6
				(aTawni setLoop: 3 cel: 0 setCycle: End self)
			)
			(7
				(if (== gBeachState 2)
					(if (not (TestFlag 61))
						(SetFlag 61) ; saidHiToTawni
						(Print 260 81) ; "Hello, Larry," replies the blond. "My name is Tawni."
					)
					(= gEgoState 14)
					(gCurRoom newRoom: 266)
				)
			)
			(8
				(= seconds 0)
				(if (>= gFilthLevel 3)
					(self cue:)
				else
					(aTawni setCycle: Beg self)
				)
			)
			(9
				(aTawni setLoop: 2 setCel: 255 setCycle: Beg self)
				(= tawniBusy 0)
				(= state 0)
			)
			(11
				(= seconds 0)
			)
		)
	)
)

(instance aVendor of Act
	(properties)

	(method (init)
		(super init:)
		(self view: gCurVendor setCycle: Walk setScript: VendorScript)
	)
)

(instance VendorScript of Script
	(properties)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'look/man,man')
				(if (or (< state 1) (> state 10))
					(Print 260 73) ; "Where?"
				else
					(Print 260 82) ; "Don't you just love these colorful native types?"
				)
			)
			((Said 'talk/man,man')
				(if (or (< state 1) (> state 10))
					(Print 260 73) ; "Where?"
				else
					(Print 260 83) ; "Uh, excuse me, sir," you ask. "Do you have a permit to do this?"
					(Print 260 84) ; "Beat it, bub!" he whispers under his breath, carefully preventing the woman from hearing him. "Can't you see I'm just trying to make a quick buck off the Americano here?"
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(aVendor posn: -15 123)
				(switch gCurVendor
					(707
						(self cue:)
					)
					(264
						(if (<= gFilthLevel 1)
							(= cycles 99)
						else
							(= cycles 222)
						)
					)
					(else
						(= seconds (Random 5 11))
					)
				)
			)
			(1
				(= tawniBusy 1)
				(aVendor
					setLoop: 0
					view: gCurVendor
					setMotion: MoveTo 137 149 self
				)
				(= cycles 11)
			)
			(2
				(Print 260 85) ; "Souvenirs!"
				(= cycles 11)
			)
			(3
				(Print 260 85) ; "Souvenirs!"
				(= cycles 11)
			)
			(4
				(Print 260 86) ; "Get your genuine Nontoonyt souvenirs!"
			)
			(5
				(if (and (!= gBeachState 3) (>= (TawniScript state:) 5))
					(return)
				)
				(Print 260 87) ; "Oh, wow!" exclaims Tawni, "SOUVENIRS!"
				(aVendor setLoop: (- (NumLoops aVendor) 1))
				(if (== gCurVendor 264)
					(aVendor setCycle: Fwd)
					(RoomScript changeState: 33)
					(return)
				)
				(aVendor viewer: salesViewer)
				(Print 260 88) ; ""Whacha selling?" she asks the peddler."
				(switch gCurVendor
					(267
						(Print 260 89) ; "Genuine plastic souvenirs, handmade in the city of rsubfqsdf."
					)
					(268
						(Print 260 90) ; "Special souvenir seashells, mounted on a free-swinging necklace made of real Nontoonyt string."
					)
					(269
						(Print 260 91) ; "Today, only, I have a very special deal on these wonderful, souvenir beads."
					)
					(707
						(Print 260 92) ; "Genuine native-islander, designer-labeled erotic carvings for only twenty dollars!" you cry. "But you'd better hurry; I only have ONE left!"
					)
				)
				(TawniScript changeState: 5)
				(= cycles 30)
			)
			(6
				(switch gCurVendor
					(267
						(Print 260 93) ; ""What was that?" asks the girl."
					)
					(268
						(Print 260 94) ; "Seashells?" she surmises, "I see you sell seashells at this slimy seashore!"
						(Print 260 95) ; "Exactly how are your shells different from the ones lying all over Sunaffa Beach?"
					)
					(269
						(Print 260 96) ; "Ooooh, I just love jewelry," says the girl. "Would you allow me to purchase some?"
					)
					(707
						(Print 260 97) ; "Well," says Tawni, "I might be interested. Does it have any special features?"
						(Print 260 98 #at -1 144) ; "(Your disguise seems to be working, Larry; Tawni doesn't recognize you!)"
					)
				)
				(= cycles 30)
			)
			(7
				(switch gCurVendor
					(267
						(Print 260 99) ; ""(Hong Kong.)" the vendor mumbles under his breath."
					)
					(268
						(Print 260 100) ; "These are no longer contaminated with that crude oil/sewage mixture we call ocean water."
					)
					(269
						(Print 260 101) ; "Sure, if you're nice to me. And, give me lots of American money!"
					)
					(707
						(if (== ((Inv at: 3) view:) 22) ; Granadilla_Wood
							(Print 260 102 #icon 22 0 0) ; "I'm glad you asked," you respond, "there is one small part that might attract your eye!"
						else
							(Print 260 103 #icon 34 0 0) ; "No, but it is hand-made!"
						)
					)
				)
				(= cycles 30)
			)
			(8
				(switch gCurVendor
					(267
						(Print 260 104) ; "Oh, no matter. As long as they're genuine, give me several. You never know when I might get back this way and I just love buying souvenirs!"
					)
					(268
						(Print 260 105) ; "Oh. Well, better let me have a few," she says, "here's fifty bucks. Can I get lots?"
					)
					(269
						(Print 260 106) ; ""Ok. Here. Take all I've got," she says."
						(Print 260 107 #at -1 144) ; "(Boy, this gal will buy anything!)"
					)
					(707
						(Printf 260 108 gExpletive) ; "%s It's a deal," she says, "I don't know much about art... but I know what I like!"
					)
				)
				(= cycles 30)
			)
			(9
				(aVendor loop: 0 setCycle: Walk viewer: 0)
				(switch gCurVendor
					(267
						(Print 260 109) ; "All together, that comes to..." the peddler pauses, considering what the market will bear, "...three hundred dollars, American. And, I'll cover the taxes for you!"
						(Print 260 110) ; "Really? That expensive? Well, ok, if you say so."
						(Print 260 111) ; "Hey, thanks a lot," says the vendor. "Have a nice day!"
					)
					(268
						(Print 260 112) ; "Sure, here's a bag full," says the vendor. "Have a nice day!"
					)
					(269
						(Print 260 113) ; "Hey, thanks a lot," says the vendor, "But why don't you keep this twenty? You might need it."
						(Print 260 114) ; "Have a nice day!"
					)
					(707
						(Print 260 115) ; "You're lucky. I'm down to my last twenty bucks!" says Tawni. "Here you are."
						(gGame changeScore: 35)
						(gEgo get: 6 put: 3 -1) ; A_Twenty_Dollar_Bill, Granadilla_Wood
						(= gDollars 20)
						(Print 260 116) ; "Thank you very much, Miss. And... use it in good health."
					)
				)
				(TawniScript cue:)
				(= cycles 30)
			)
			(10
				(aVendor
					cycleSpeed: 0
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo -30 (Random 114 163) self
				)
			)
			(11
				(cond
					((== gCurVendor 707)
						(= gCurVendor -1)
						(= gBeachState 6)
						(gCurRoom newRoom: 250)
					)
					((or (== gCurVendor 269) (== gCurVendor 264))
						(= gCurVendor -1)
					)
					(else
						(++ gCurVendor)
						(self changeState: 0)
					)
				)
			)
		)
	)
)

(instance aTowel of View
	(properties
		y 169
		x 154
		view 262
	)

	(method (init)
		(super init:)
		(self setPri: 4 ignoreActors: stopUpd:)
	)
)

(instance aLizard of Act
	(properties
		view 260
		priority 15
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setCycle: Walk setScript: LizardScript setPri: 15 ignoreActors:)
	)
)

(instance LizardScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 5)
				(>= (RoomScript state:) 23)
				(<= (RoomScript state:) 28)
			)
			(self cue:)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (and state (Said '/lizard>'))
			(cond
				((Said 'get,grab/')
					(Print 260 117) ; "He's too fast for you; you'd never catch him."
				)
				((Said 'look/')
					(cond
						((== state 0)
							(Print 260 73) ; "Where?"
						)
						((and (== state 5) (== gEgoState 1005))
							(Print 260 118) ; "What a nasty looking little devil he is!"
						)
						(else
							(Print 260 119) ; "A bright red lizard scampers across the rocks near Sunaffa Beach."
						)
					)
				)
				(else
					(Print 260 120) ; "Leave the lizard alone. He's of no use to you."
					(event claimed: 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (Random 0 1)
					(aLizard setLoop: 0 posn: -20 (Random 172 188))
				else
					(aLizard setLoop: 1 posn: 218 198)
				)
				(= seconds (Random 10 20))
			)
			(1
				(aLizard
					setMotion: MoveTo (Random 126 192) (Random 172 188) self
				)
			)
			(2
				(= seconds (Random 2 5))
			)
			(3
				(aLizard
					cycleSpeed: 1
					setLoop: (+ 2 (aLizard loop:))
					cel: 0
					setCycle: End self
				)
			)
			(4
				(= cycles (Random 3 7))
			)
			(5
				(aLizard setLoop: (+ 2 (aLizard loop:)) cel: 0 setCycle: Fwd)
				(if
					(and
						(<= (RoomScript state:) 22)
						(>= (RoomScript state:) 18)
					)
					(= seconds 7)
				else
					(= cycles (Random 5 9))
				)
			)
			(6
				(aLizard
					setLoop: (- (aLizard loop:) 2)
					setCel: 255
					setCycle: Beg self
				)
			)
			(7
				(aLizard
					setLoop: (- (aLizard loop:) 2)
					cycleSpeed: 0
					setCycle: Walk
				)
				(if (== 0 (aLizard loop:))
					(aLizard setMotion: MoveTo 218 198 self)
				else
					(aLizard setMotion: MoveTo -55 (Random 172 188) self)
				)
				(= state -1)
			)
			(8
				(= seconds (= cycles 0))
				(aLizard
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo (- (aLizard x:) 33) 222
				)
			)
			(9
				(if (>= gFilthLevel 3)
					(aLizard
						setLoop: 0
						posn: -20 180
						setCycle: Walk
						setMotion: MoveTo 148 188 self
					)
				)
			)
			(10
				(aLizard setMotion: MoveTo 192 167 self)
			)
			(11
				(aLizard cycleSpeed: 1 setLoop: 2 cel: 0 setCycle: End self)
				(= state 3)
			)
		)
	)
)

(instance humpCycler of Code
	(properties)

	(method (doit)
		(cond
			((<= gFilthLevel 1)
				(gEgo setCycle: 0)
			)
			((not (Random 0 9))
				(gEgo cycleSpeed: (Random 0 5))
			)
		)
	)
)

(instance salesViewer of Code
	(properties)

	(method (doit)
		(if (not (Random 0 3))
			(aVendor setCel: (Random 0 (- (NumCels aVendor) 1)))
		)
	)
)

