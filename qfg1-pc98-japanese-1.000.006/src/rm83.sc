;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use n007)
(use n008)
(use TalkObj)
(use RFeature)
(use Sound)
(use Save)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm83 0
	hermitTalk 1
	dummy 2
)

(local
	local0
	local1
)

(instance pfSnd of Sound
	(properties
		priority 8
	)
)

(instance poof of Prop
	(properties
		view 83
		loop 5
	)
)

(instance scroll of Prop
	(properties
		y 162
		x 194
		view 83
	)
)

(instance hermitWin of SysWindow
	(properties
		color 8
		title {Hermit:%j\ca\b0\d0\af\c4}
	)

	(method (open &tmp temp0)
		(= temp0 (- top 12))
		(-= top temp0)
		(-= bottom temp0)
		(super open:)
	)
)

(instance hermitTalk of TalkObj
	(properties
		tLoop 3
		cSpeed 1
	)
)

(instance bed of RPicView
	(properties
		y 164
		x 67
		view 83
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/bed,hay'))
				(HighPrint 83 0) ; "The straw is relatively fresh and looks more comfortable to lie upon than the rocks."
			)
		)
	)
)

(instance table of RPicView
	(properties
		y 180
		x 189
		view 83
		loop 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/table'))
				(HighPrint 83 1) ; "Yes, what you see is a table."
			)
		)
	)
)

(instance chair of RPicView
	(properties
		y 167
		x 159
		view 83
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/chair'))
				(HighPrint 83 2) ; "You see a chair."
			)
		)
	)
)

(instance cot of RPicView
	(properties
		y 168
		x 227
		view 83
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/cot'))
				(HighPrint 83 3) ; "You see a cot."
			)
		)
	)
)

(instance candle of Prop
	(properties
		y 155
		x 185
		view 83
		loop 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/candle,flame'))
				(HighPrint 83 4) ; "A single candle sits upon the table."
			)
		)
	)
)

(instance hermit of Prop
	(properties
		y 162
		x 227
		view 83
		loop 3
	)

	(method (doit)
		(hermitTalk doit:)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (MouseClaimed self event 3) (Said 'look,look/ermit,man'))
				(HighPrint 83 5) ; "You see the shaggiest little man (you think it's a man, anyway) you've ever seen."
			)
			(else
				(hermitTalk handleEvent: event)
			)
		)
	)
)

(instance rm83 of Rm
	(properties
		picture 83
		style 2
	)

	(method (doit)
		(super doit:)
		(cond
			((or local0 global104)
				(if (User canControl:)
					(User canControl: 0)
				)
			)
			((not (User canControl:))
				(User canControl: 1)
			)
		)
		(if (and (== (gEgo edgeHit:) EDGE_BOTTOM) (!= (self script:) sLeaving))
			(if (not (IsFlag 73))
				(self setScript: sLeaving)
			else
				(gCurRoom newRoom: 82)
			)
		)
	)

	(method (init)
		(super init:)
		(SL enable:)
		(NormalEgo)
		(Load rsSOUND 41)
		(SolvePuzzle 699 5)
		(gEgo loop: 0 posn: 143 185 init:)
		(bed priority: 0)
		(gAddToPics add: bed table chair cot eachElementDo: #init doit:)
		(gFeatures add: bed table chair cot)
		(candle init: setPri: 14 cycleSpeed: 1 setCycle: Fwd)
		(hermit init:)
		(hermitTalk tWindow: hermitWin actor: hermit init:)
		(gContMusic stop: number: 41 loop: -1 play:)
		(gKeyHandler add: hermit)
		(pfSnd number: (SoundFX 28))
		(self setScript: introToHenry)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look[<around,at][/room]')
						(HighPrint 83 6) ; "The cave is cold and clammy and it smells like mildew and wet dog hair in here!"
					)
					((Said 'look,look>')
						(cond
							((Said '/cave,wall')
								(HighPrint 83 7) ; "The walls are covered with phosphorescent fungus."
							)
							((Said '/fungus')
								(HighPrint 83 8) ; "The phosphorescent fungus glows eerily in the cave's dim light."
							)
							((Said '/scroll,spell')
								(if (gCast contains: scroll)
									(HighPrint 83 9) ; "It's on the table."
								else
									(HighPrint 83 10) ; "There's nothing like that here."
								)
							)
						)
					)
					((Said 'read/scroll,spell')
						(if (gCast contains: scroll)
							(HighPrint 83 9) ; "It's on the table."
						else
							(HighPrint 83 10) ; "There's nothing like that here."
						)
					)
					((Said 'ask>')
						(= local1 1)
						(cond
							((Said '//fall,fall,water')
								(self setScript: sFalls)
							)
							((Said '//magic,ladder')
								(self setScript: sLadder)
							)
							((or (Said '//trigger') (Said '//spell<trigger'))
								(self setScript: sTrig)
							)
							((Said '//spell')
								(self setScript: sSpell)
							)
							((Said '//wizard,erasmus')
								(self setScript: sErasmus)
							)
							((Said '//familiar,fenrus')
								(self setScript: sFenrus)
							)
							((Said '//game')
								(self setScript: sGame)
							)
							((Said '//bandit')
								(self setScript: sBrigs)
							)
							((Said '//warlock')
								(self setScript: sWarlock)
							)
							((Said '//mirror')
								(self setScript: sMirror)
							)
							((Said '//cave,home')
								(self setScript: sCave)
							)
							((Said '//ermit')
								(self setScript: sErmit)
							)
							((Said '//family,hortense,arry,mama,dad,farther')
								(self setScript: sFamily)
							)
							((Said '//enry,name')
								(self setScript: sEnry)
							)
							((Said '//cribbage')
								(self setScript: sCrib)
							)
							((Said '//nap,nap,bed,hay')
								(self setScript: sSleep)
							)
							((Said '//scroll')
								(if (IsFlag 242)
									(if (gCast contains: scroll)
										(HighPrint 83 9) ; "It's on the table."
									else
										(self setScript: sNixScroll)
									)
								else
									(self setScript: sAskScroll)
								)
							)
							(
								(Said
									'//candle,table,chair,cot,flame,door,hay,food'
								)
								(self setScript: sMisc)
							)
							(else
								(= local1 0)
								(event claimed: 1)
								(self setScript: sElse)
							)
						)
						(if local1
							(SolvePuzzle 700 2)
						)
					)
					((Said 'buy/')
						(self setScript: sMisc)
					)
					((Said 'talk,talk/')
						(self setScript: sEnry)
					)
					((Said 'give,give/ration')
						(cond
							((not (gEgo use: 3 1)) ; food
								(HighPrint 83 11) ; "You can't share what you don't have."
							)
							(gNight
								(Say hermitTalk 83 12) ; "Me guest bed is the straw in the corner over there. You're welcome to stay the night since you've shared your rations.  When you want to sleep, just say so."
								(SetFlag 338)
							)
							(else
								(Say hermitTalk 83 13) ; "Me guest bed is the straw in the corner over there. You're welcome to come back and sleep tonight since you've shared your rations."
								(SetFlag 338)
							)
						)
					)
					((and (not gNight) (Said 'japaneserestorsleep>')))
					(
						(or
							(Said 'nap,nap/')
							(Said 'go/bed,nap,nap')
							(Said 'get,get<on/bed,hay')
						)
						(cond
							(local0
								(HighPrint 83 14) ; "You can't sleep in this old rickety chair. Get up and sleep on the bed of straw."
							)
							((> (gEgo x:) 165)
								(HighPrint 83 15) ; "Get closer to the bed of straw."
							)
							((not (or (IsFlag 338) (>= [gInvNum 3] 1))) ; food
								(self setScript: sNoSleep)
							)
							((not (CanSleep))
								(EgoSleeps 5)
							)
							(else
								(if (not (IsFlag 338))
									(gEgo use: 3 1) ; food
								)
								(ClearFlag 338)
								(self setScript: sGoSleep)
							)
						)
					)
					((Said 'sat/')
						(if (not local0)
							(if (gEgo inRect: 140 150 174 174)
								(gEgo
									view: 83
									setLoop: 8
									ignoreActors: 1
									illegalBits: 0
									posn: 159 167
									stopUpd:
								)
								(= local0 1)
							else
								(HighPrint 83 16) ; "You need to get closer to the chair."
							)
						else
							(HighPrint 83 17) ; "You are already sitting... on your brain, perhaps?"
						)
					)
					((or (Said 'stand,stand,get,get<up/') (Said 'stand,stand/'))
						(if local0
							(NormalEgo)
							(= local0 0)
							(gEgo posn: 156 171 loop: 0)
						else
							(HighPrint 83 18) ; "You're not sitting."
						)
					)
					((Said 'put,extinguish/candle,flame')
						(HighPrint 83 19) ; "The 'ermit wouldn't like that."
					)
					((Said 'search/')
						(HighPrint 83 20) ; "You should wait until the hermit is asleep to check his place out."
					)
					((Said 'play/cribbage,card,game,cardgame')
						(cond
							((== gDay global590)
								(HighPrint 83 21) ; "Despite your intentions, you can't bring yourself to spend any more time playing with the talkative 'Enry."
							)
							(local0
								(= global590 gDay)
								(EgoRests 60 0)
								(HighPrint 83 22) ; "You spend an hour at the game while 'Enry talks. You've obviously made his day."
							)
							(else
								(HighPrint 83 23) ; "You should sit down first."
							)
						)
					)
					((Said 'get,get/scroll')
						(if (gCast contains: scroll)
							(scroll dispose:)
							(gEgo get: 10) ; note
							(HighPrint 83 24) ; "The scroll vanishes even as you read the magical runes upon it. You now have the knowledge to cast a "Trigger" spell."
							(SetFlag 262)
							(gEgo learn: 19 10) ; triggerSpell
							(SolvePuzzle 619 4 1)
						else
							(HighPrint 83 25) ; "You see no scroll."
						)
					)
					((or (Said 'cast/detect') (Said 'cast/spell<detect'))
						(if (CastSpell 18)
							(HighPrint 83 26) ; "You can detect a faint aura of magic here."
						)
					)
					(
						(or
							(Said 'cast/open,open,open')
							(Said 'cast/spell<open,open,open')
						)
						(if (CastSpell 17)
							(HighPrint 83 27) ; "There is no need to use magic to open anything here."
						)
					)
					((Said 'get,get,grab/candle,cot,hay,bed,table,chair')
						(HighPrint 83 28) ; "It's not polite to steal from your 'airy little 'ost."
						(HighPrint 83 29) ; "You seem to have made the 'ermit un'appy."
						(SetFlag 240)
						(self setScript: TPego)
					)
					((Said 'kill,attack,attack,throw,hit,cast,attack/')
						(HighPrint 83 29) ; "You seem to have made the 'ermit un'appy."
						(SetFlag 240)
						(self setScript: TPego)
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

(instance sSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 30) ; "Me guest bed is the straw in the corner over there. You're welcome to stay if you share some rations and play some cribbage."
			)
			(1
				(HandsOn)
			)
		)
	)
)

(instance sAskScroll of Script
	(properties)

	(method (handleEvent event)
		(if (and (== (event type:) evSAID) (== state 2))
			(= seconds 0)
			(if (Said 'yes,please')
				(client setScript: sGetScroll)
			else
				(event claimed: 1)
				(client setScript: sNoScroll)
			)
		)
	)

	(method (changeState newState)
		(if client
			(switch (= state newState)
				(0
					(SetFlag 242)
					(hermitTalk caller: self)
					(HandsOff)
					(if [gEgoStats 12] ; magic
						(Say hermitTalk 83 31) ; "If you be wanting to learn the spell, I'll be pleased to share it to you. It's just getting molding in me 'iding place."
					else
						(Say hermitTalk 83 32) ; "I think you be 'avin too little magic for it to be any use to you."
						(HandsOn)
						(client setScript: 0)
					)
				)
				(1
					(Say hermitTalk 83 33) ; "Do you want it?"
				)
				(2
					(User canInput: 1)
					(= seconds 6)
				)
				(3
					(client setScript: sNoScroll)
					(HandsOn)
				)
			)
		)
	)
)

(instance sNoScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 34) ; "Oh well, maybe sumone else can use it sumtime."
			)
			(1
				(HandsOn)
			)
		)
	)
)

(instance sNixScroll of Script
	(properties)

	(method (handleEvent event)
		(if (and (== (event type:) evSAID) (== state 1))
			(= seconds 0)
			(if (Said 'yes,please')
				(client setScript: sGetScroll)
			else
				(event claimed: 1)
				(client setScript: sNoScroll)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(if (IsFlag 262)
					(Say hermitTalk 83 35) ; "You already 'ave me only scroll."
				else
					(Say hermitTalk 83 36) ; "Yes, I still have me magic scroll, but you didn't seem to want it. 'Ave you changed your mind?"
				)
			)
			(1
				(User canInput: 1)
				(= seconds 6)
			)
			(2
				(client setScript: sNoScroll)
				(HandsOn)
			)
		)
	)
)

(instance sGetScroll of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hermitTalk caller: self)
				(Say hermitTalk 83 37) ; "Let's see. 'Ow does Erasmus do it? Oh, yes."
			)
			(1
				(Say hermitTalk 83 38) ; "'E summons it with a Trigger. 'Ere goes!"
			)
			(2
				(scroll
					loop: 7
					setPri: 14
					init:
					cycleSpeed: 1
					setCycle: End self
				)
				(pfSnd init: play:)
			)
			(3
				(scroll setLoop: 2 setCel: 1)
				(Say hermitTalk 83 39) ; "There you 'as it."
			)
			(4
				(HandsOn)
			)
		)
	)
)

(instance sMisc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 40) ; "I don't 'ave much, but wot I 'ave, I 'ave, an' t'isn't for sale."
			)
			(1
				(HandsOn)
			)
		)
	)
)

(instance sElse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 41) ; "Well, see'en as I don't get out much, I don't know much."
			)
			(1
				(HandsOn)
			)
		)
	)
)

(instance sLeaving of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 73)
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 42) ; "If you be ever needen a place to stay the night and you're in the area, I could be willen to put you up for the night for sum rations and a couple o' games o' cribbage."
			)
			(1
				(gCurRoom newRoom: 82)
			)
		)
	)
)

(instance TPego of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 73)
				(HandsOff)
				(pfSnd init: play:)
				(poof
					posn: (gEgo x:) (gEgo y:)
					setCycle: CT 6 1 self
					cycleSpeed: 4
					init:
				)
			)
			(1
				(gEgo dispose:)
				(poof setCycle: End self)
			)
			(2
				(= cycles 10)
			)
			(3
				(poof dispose:)
				(gCurRoom newRoom: 82)
			)
		)
	)
)

(instance sGoSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(HighPrint 83 43) ; "After having traded a ration, which the 'ermit promptly swallowed, and spending a rather boring hour of cribbage and listening to 'Enry chatter, you hit the hay."
				(gEgo illegalBits: 0 setMotion: MoveTo 74 150 self)
			)
			(1
				(gEgo view: 510 setLoop: 1 setCycle: End self)
			)
			(2
				(gEgo
					view: 523
					setLoop: 0
					setCel: 2
					posn: 72 168
					setPri: 13
					stopUpd:
				)
				(hermit setLoop: 3 setCycle: Fwd)
				(= seconds 6)
			)
			(3
				(HighPrint 83 44) ; "Unfortunately, since the fungus on the walls shines at night so the room doesn't get dark, and the fact the hermit talks most of the night, you only get five hours rest."
				(EgoSleeps 5)
				(SetFlag 73)
				(gCurRoom newRoom: 82)
			)
		)
	)
)

(instance sNoSleep of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hermitTalk caller: self)
				(Say hermitTalk 83 45) ; "You can't sleep here, you got's no rations to give me."
			)
			(1
				(SetFlag 241)
				(client setScript: TPego)
			)
		)
	)
)

(instance dummy of Script
	(properties)
)

(instance introToHenry of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 10)
			)
			(1
				(hermitTalk caller: self)
				(if (IsFlag 73)
					(= state 4)
					(Say hermitTalk 83 46) ; "Come in, come in. Good to see you again.  Get's kind o' tiresome sitten here an' thinken by meself all the time."
				else
					(Say hermitTalk 83 47) ; "Ello. 'Ow are you? 'Ave we met before?"
				)
			)
			(2
				(Say hermitTalk 83 48) ; "I'm 'Enry the 'ermit, that's me. Me Farther was an 'ermit and me Murther was an 'ermit sos I come by me job rightly."
			)
			(3
				(Say hermitTalk 83 49) ; "Don't 'ave too many visitors. 'Ermits don't, you know. (Part o' the job description.) I likes to see a new face, though."
			)
			(4
				(Say hermitTalk 83 50) ; "Good to 'ear anurther's speaking besides meself. Sos wot can I do for you?"
			)
			(5
				(HandsOn)
			)
		)
	)
)

(instance sErasmus of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 51) ; "E's me friend, 'e and Fenrus. Powerful wizard 'e is."
			)
			(1
				(Say hermitTalk 83 52) ; "I 'ere 'is 'ouse is sumthin' to see up north."
			)
			(2
				(Say hermitTalk 83 53) ; "I don't make it out much, and 'e's pretty busy, sos I don't see 'em too often. But when we do all get together, you can be sure we'll 'ave fun."
			)
			(3
				(Say hermitTalk 83 54) ; "'E loves to play 'is games, 'e do."
			)
			(4
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sFenrus of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 55) ; "Fenrus is Erasmus' familiar or is that the other way around?"
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sGame of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 56) ; "Erasmus' favorite game is the Mage's Maze. 'Ave to be a magic user to play it, though. Erasmus is awful good at it."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sBrigs of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 57) ; "Nasty sorts, they is. I sees them sneaking arund the woods all the times. Uther then the Warlock, I 'as nothing to do with them"
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sWarlock of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 58) ; "E's not so bad. Got a good sense o' 'umor, 'e 'as. I get the giggles just to think of 'im. He heh he heh he."
			)
			(1
				(Say hermitTalk 83 59) ; "'E's come by at times to chat. Borrowed the mirror wot I borrowed from Erasmus 'e did."
			)
			(2
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sMirror of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 60) ; "A magic mirror of reflection, it was. If you use it, when a nasty spell was cast at you, it was wot sent it back at the one wot cast it. Do un to others, I sez. Heh, he, he."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sCave of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 61) ; "Well, it's dark and damp and the waters roars sos there's not a moment's quiet.  The ceiling drips and the walls are slimy and it's always cold. But, oh well, sez I, it's 'ome."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sErmit of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 62) ; "A 'ermit is one wot lives alone, far away from them wot talks too much or asks too many questions. 'Ermits are shy, quiet types wot don't say much. Me brother 'Arry 'ardly says a word in a year. Me sister 'Ortense 'asn't spoken since she were six. I never talks at all. Yes, we 'ermits nose how to keep a mouth shut."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sFamily of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 63) ; "Me family lives pretty far apart from each other. We're all 'ermits, you know."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sEnry of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 64) ; "I'm 'enry. 'Enry the eighth I is. Me farther was an 'Enry and 'is farther was an 'Enry and 'is farther was an 'Enry and 'is farther was an 'Enry and 'is farther was an 'Enry and 'is farther was an 'Enry and 'is farther was an 'Enry. And every one was an 'ermit."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sCrib of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 65) ; "I likes to play the game. I can show you how to play, if you likes."
			)
			(1
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sTrig of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 66) ; "It's the spell wot sets off uther spells."
			)
			(1
				(Say hermitTalk 83 67) ; "Like when you wants to see the ladder, you casts a trigger and there you 'ave it, large as life."
			)
			(2
				(Say hermitTalk 83 68) ; "Course, you gots to 'ave a spell on the invisible ladder to make it visible first. But it 'as its uses."
			)
			(3
				(Say hermitTalk 83 69) ; "I thinks I 'ave a scroll with the spell, if you be knowing sum magic, that is."
			)
			(4
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sSpell of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 70) ; "The spells wot I nose is pretty simple maybe, but I like 'em."
			)
			(1
				(Say hermitTalk 83 71) ; "I can make me ladder show up and me door close and even get rid o' pests using the trigger spell, you see."
			)
			(2
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sLadder of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 72) ; "I nose sum magic. Erasmus the wizard tot me sum spells."
			)
			(1
				(Say hermitTalk 83 73) ; "He's wot put the spell on me ladder sos the brigands don't get up. Them wot climbs th' rocks gets a door opening in their nose."
			)
			(2
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

(instance sFalls of Script
	(properties)

	(method (dispose)
		(hermitTalk caller: 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hermitTalk caller: self)
				(HandsOff)
				(Say hermitTalk 83 74) ; "This 'ere's wot's called the Flying Falls."
			)
			(1
				(Say hermitTalk 83 75) ; "I've doon sum flying falls arund 'ere meself. That porch gets slippery sumtimes. He, heh, he."
			)
			(2
				(client setScript: dummy)
				(HandsOn)
			)
		)
	)
)

