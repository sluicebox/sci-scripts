;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 83)
(include sci.sh)
(use Main)
(use n007)
(use n008)
(use TalkObj)
(use LoadMany)
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
		title {Hermit:}
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
			((or (MouseClaimed self event 3) (Said 'look/bed,hay'))
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
			((or (MouseClaimed self event 3) (Said 'look/table'))
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
			((or (MouseClaimed self event 3) (Said 'look/chair'))
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
			((or (MouseClaimed self event 3) (Said 'look/cot'))
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
			((or (MouseClaimed self event 3) (Said 'look/candle,flame'))
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
			((or (MouseClaimed self event 3) (Said 'look/ermit,man'))
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
		(if (and (== (gEgo edgeHit:) 3) (!= (self script:) sLeaving))
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
		(LoadMany rsSCRIPT 143 144 145)
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
		(self setScript: (ScriptID 143 0)) ; introToHenry
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look[<around,at][/room]')
						(HighPrint 83 6) ; "The cave is cold and clammy and it smells like mildew and wet dog hair in here!"
					)
					((Said 'look>')
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
							((Said '//fall,water')
								(self setScript: (ScriptID 145 8)) ; sFalls
							)
							((Said '//magic,ladder')
								(self setScript: (ScriptID 145 7)) ; sLadder
							)
							((or (Said '//trigger') (Said '//spell<trigger'))
								(self setScript: (ScriptID 145 5)) ; sTrig
							)
							((Said '//spell')
								(self setScript: (ScriptID 145 6)) ; sSpell
							)
							((Said '//wizard,erasmus')
								(self setScript: (ScriptID 144 0)) ; sErasmus
							)
							((Said '//familiar,fenrus')
								(self setScript: (ScriptID 144 1)) ; sFenrus
							)
							((Said '//game')
								(self setScript: (ScriptID 144 2)) ; sGame
							)
							((Said '//bandit')
								(self setScript: (ScriptID 144 3)) ; sBrigs
							)
							((Said '//warlock')
								(self setScript: (ScriptID 144 4)) ; sWarlock
							)
							((Said '//mirror')
								(self setScript: (ScriptID 144 5)) ; sMirror
							)
							((Said '//cave,home')
								(self setScript: (ScriptID 145 0)) ; sCave
							)
							((Said '//ermit')
								(self setScript: (ScriptID 145 1)) ; sErmit
							)
							((Said '//family,hortense,arry,mama,dad,farther')
								(self setScript: (ScriptID 145 2)) ; sFamily
							)
							((Said '//enry,name')
								(self setScript: (ScriptID 145 3)) ; sEnry
							)
							((Said '//cribbage')
								(self setScript: (ScriptID 145 4)) ; sCrib
							)
							((Said '//nap,bed,hay')
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
					((Said 'talk/')
						(self setScript: (ScriptID 145 3)) ; sEnry
					)
					((Said 'give,give/ration')
						(cond
							((not (gEgo use: 3 1)) ; food
								(HighPrint 83 11) ; "You can't share what you don't have."
							)
							(gNight
								(Say hermitTalk 83 12) ; "Me guest bed is the straw in the corner over there. You're welcome to stay the night since you've shared your rations. When you want to sleep, just say so."
								(SetFlag 338)
							)
							(else
								(Say hermitTalk 83 13) ; "Me guest bed is the straw in the corner over there. You're welcome to come back and sleep tonight since you've shared your rations."
								(SetFlag 338)
							)
						)
					)
					(
						(or
							(Said 'nap/')
							(Said 'go/bed,nap')
							(Said 'get<on/bed,hay')
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
					((or (Said 'stand,get<up/') (Said 'stand/'))
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
					((Said 'get/scroll')
						(if (gCast contains: scroll)
							(scroll dispose:)
							(gEgo get: 10) ; note
							(HighPrint 83 24) ; "The scroll vanishes even as you read the magical runes upon it.  You now have the knowledge to cast a "Trigger" spell."
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
					((or (Said 'cast/open') (Said 'cast/spell<open'))
						(if (CastSpell 17)
							(HighPrint 83 27) ; "There is no need to use magic to open anything here."
						)
					)
					((Said 'get,grab/candle,cot,hay,bed,table,chair')
						(HighPrint 83 28) ; "It's not polite to steal from your 'airy little 'ost."
						(HighPrint 83 29) ; "You seem to have made the 'ermit un'appy."
						(SetFlag 240)
						(self setScript: TPego)
					)
					((Said 'kill,attack,throw,hit,cast,fight/')
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

