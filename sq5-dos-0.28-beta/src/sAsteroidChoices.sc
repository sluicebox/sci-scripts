;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 220)
(include sci.sh)
(use Main)
(use rm201)
(use eureka)
(use System)

(public
	sAsteroidChoices 0
	sFStarconChoices 1
	sDStarconChoices 2
	sDAlienChoices 3
	sFAlienChoices 4
	sFCloroxChoices 5
	sFNoiseChoices 6
	sFDefault 7
	sFGenericChoices 8
	sDCloroxChoices 9
	sFThrakusChoices 10
	sDThrakusChoices 11
	sFBeforeGoliath 12
	sFAfterClorox 13
	sDAfterClorox 15
	sDDefaultChoices 16
)

(local
	local0
)

(procedure (localproc_0)
	((ScriptID 201 13) normal: 0 keepWindow: 1) ; floTalker
	(gGame handsOn:)
	(gTheIconBar select: (gTheIconBar at: 2))
	(gGame setCursor: 982)
)

(procedure (localproc_1)
	((ScriptID 201 12) normal: 0 keepWindow: 1) ; drooleTalker
	(gGame handsOn:)
	(gTheIconBar select: (gTheIconBar at: 2))
	(gGame setCursor: 982)
)

(instance sDStarconChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 1)
			)
			(1
				(gMessager say: 4 0 5 1 self 202) ; "Yes Captain?"
			)
			(2
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(gMessager say: 4 0 2 0 self 202) ; "My personal life is none of your business, sir"
						)
						(2
							(gMessager say: 4 0 3 0 self 202) ; "Too long. As soon as my tour is up I'm outta here."
						)
						(3
							(gMessager say: 4 0 4 0 self 202) ; "Stay out of my way, sir."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFStarconChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 8 1 self 202) ; "What do you want, sir?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 9 0 self 202) ; "I'm sure you did sir, but it won't."
						)
						(2
							(= local0 1)
							(gMessager say: 12 0 10 1 3 self 202) ; "Previously I was assigned to the Phlegma, Sir."
						)
						(3
							(gMessager say: 12 0 11 0 self 202) ; "The Eureka's previous commanding officer 'accidently' fell out the airlock without a spacesuit."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(if local0
					(self setScript: sDrooleComments self)
				else
					(= cycles 1)
				)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sDAlienChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(localproc_1)
			)
			(1
				(gMessager say: 26 0 36 1 self 202) ; "What do you want, Captain?"
			)
			(2
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(gMessager say: 26 0 37 0 self 202) ; "Sounds to me like somebody was trying to unload a bunch of hot stereos, Captain."
						)
						(2
							(self setScript: sDTree6Choice2 self)
						)
						(3
							(gMessager say: 26 0 38 0 self 202) ; "Excuse me?"
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDDefaultChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(localproc_1)
			)
			(1
				(gMessager say: 26 0 47 1 self 202) ; "Pardon you, captain."
			)
			(2
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(gMessager say: 26 0 48 0 self 202) ; "The Refuse Recovery System or RRS for short, is the primary means by which the Hoover Class garbage scows perform their designated mission."
						)
						(2
							(gMessager say: 26 0 49 0 self 202) ; "There aren't a lot of options open to us Captain. The only place that's even halfway decent in this sector is the Space Bar."
						)
						(3
							(gMessager say: 26 0 50 0 self 202) ; "It's kind of a long story..."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDTree6Choice2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 26 0 40 1 2 self 202) ; "Don't take it personally, sir. Flo recently separated from her 18th husband and is understandably distraught. She's kind of down on men in general."
			)
			(1
				(proc201_6 self)
			)
			(2
				(gMessager say: 26 0 40 3 4 self 202) ; "Wanna make something of it fly boy? I've divorced better men then you!"
			)
			(3
				(self setScript: (ScriptID 201 4) self) ; sBusyFlo
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sFAlienChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 32 1 self 202) ; "Sir?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 33 0 self 202) ; "I don't know sir. The content was really strange, especially since a StarCon command frequency was used."
						)
						(2
							(gMessager say: 12 0 34 0 self 202) ; "You pig!"
						)
						(3
							(if (< gGarbagePickupCount 3)
								(gMessager say: 12 0 35 0 self 202) ; "Of course, captain."
							else
								(gMessager say: 25 0 22 0 self 202) ; "We've finished our mission, Captain. Let's take some R and R at the Space Bar."
							)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFNoiseChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 27 1 self 202) ; "What is it, o high and mighty?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 28 0 self 202) ; "I don't have any idea, sir. But you better go check it out; It might be dangerous."
						)
						(2
							(gMessager say: 12 0 29 0 self 202) ; "Don't ask--sir."
						)
						(3
							(if (< gGarbagePickupCount 3)
								(gMessager say: 12 0 30 0 self 202) ; "Hmph. You should pay more attention to what's going on around you sir."
							else
								(gMessager say: 25 0 22 0 self 202) ; "We've finished our mission, Captain. Let's take some R and R at the Space Bar."
							)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFDefault of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 41 1 self 202) ; "What is it now, Captain?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(if (IsFlag 30)
								(gMessager say: 4 0 3 2 self) ; "Yes, Captain."
							else
								(gMessager say: 12 0 43 0 self 202) ; "Hmph."
							)
						)
						(2
							(gMessager
								say:
									12
									0
									44
									(+ (eureka destination:) 1) ; garbage1
									self
									202
							)
						)
						(3
							(cond
								((< gGarbagePickupCount 3)
									(gMessager say: 25 0 21 1 self 202) ; "Our last orders were to proceed to garbage pickups at Gangularis, Peeyu, and Kiz Urazgubi."
								)
								((and (not (IsFlag 30)) (== gGarbagePickupCount 3))
									(gMessager say: 25 0 22 1 self 202) ; "We've finished our mission, Captain. Let's take some R and R at the Space Bar."
								)
								((and (IsFlag 30) (not (IsFlag 93)))
									(gMessager say: 25 0 26 1 self 202) ; "Starcon has ordered us to proceed to Clorox II for an auxiliary garbage pickup, Captain."
								)
								((and (== gAct 1) (not (IsFlag 94)))
									(gMessager say: 25 0 24 0 self 202) ; "Since we don't have any orders, I think we should try to check out the source of the Goliath's last transmission."
								)
								((and (== gAct 2) (not (IsFlag 75)))
									(gMessager say: 25 0 25 0 self 202) ; "We don't have any orders to cover this situation, Captain. I think we're on our own."
								)
								(else
									(gMessager
										say:
											12
											0
											44
											(+ (eureka destination:) 1) ; garbage1
											self
											202
									)
								)
							)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFGenericChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 42 1 self 202) ; "What do you want this time?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 45 0 self 202) ; "It's not exactly a vacation hotspot Captain"
						)
						(2
							(gMessager say: 12 0 46 0 self 202) ; "I really haven't given it any thought. But I can't say you've given me any reason not to conclude you're a total shmucko, though."
						)
						(3
							(if (< gGarbagePickupCount 3)
								(gMessager say: 12 0 60 0 self 202) ; "Our last orders were to proceed to garbage pickups at Gangularis, Peeyu, and Kiz Urazgubi."
							else
								(gMessager say: 25 0 22 0 self 202) ; "We've finished our mission, Captain. Let's take some R and R at the Space Bar."
							)
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDCloroxChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 1)
			)
			(1
				(gMessager say: 26 0 55 1 self 202) ; "What do you want, sir?"
			)
			(2
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(gGame handsOff:)
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(gMessager say: 26 0 56 0 self 202) ; "Are you really surprised, sir?"
						)
						(2
							(gMessager say: 26 0 57 0 self 202) ; "I really couldn't say Captain. But I think she was very taken with the way you handled the situation back there on the space station. Confidentially..."
						)
						(3
							(gMessager say: 26 0 58 0 self 202) ; "I'd prefer to keep our mothers out of this, sir. Though I must admit I've entertained some rather amusing speculations about your progenitors."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFCloroxChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 51 1 self 202) ; "How can I help you, Captain?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(gGame handsOff:)
				(proc201_27 0)
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(self setScript: sFTree9Choice1 self)
						)
						(2
							(gMessager say: 12 0 53 0 self 202) ; "I certainly hope not, Captain. By the way, that was a very brave thing you did back at the Space Bar."
						)
						(3
							(gMessager say: 12 0 54 0 self 202) ; "Starcon has ordered us to proceed to Clorox II for an auxiliary garbage pickup, Captain."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(proc201_27 1)
				(self dispose:)
			)
		)
	)
)

(instance sFTree9Choice1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 12 0 52 1 5 self 202) ; "Not much Captain. Just that it's a small colony on the fringe of the G6 quadrant."
			)
			(1
				(proc201_7 self)
				(proc201_27 1)
				(gEgo setLoop: 0 posn: 134 95 setCel: 0 show:)
			)
			(2
				(gMessager say: 12 0 52 6 self 202) ; "Nudge, Nudge, Wink, Wink, sir. I think Flo's opinion of you has altered somewhat, Captain."
			)
			(3
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
				(gEgo setLoop: 1 setCel: 0 posn: 178 95)
			)
			(4
				(gMessager say: 12 0 52 7 8 self 202) ; "Um...uhh... No thank you Flo, I think I'm fine for now."
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sFTree9Choice2 of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 12 0 53 1 8 self 202) ; "I certainly hope not, Captain. By the way, that was a very brave thing you did back at the Space Bar."
			)
			(1
				(gEgo setLoop: 0 posn: 134 95 setCel: 0)
				(= seconds 3)
			)
			(2
				(gEgo setLoop: 1 setCel: 0 posn: 178 95)
				(= seconds 1)
			)
			(3
				(gMessager say: 12 0 53 9 10 self 202) ; MISSING MESSAGE
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sDThrakusChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
				(localproc_1)
			)
			(1
				(gMessager say: 26 0 74 1 self 202) ; "What can I do for you, sir?"
			)
			(2
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(proc201_5 0)
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(gMessager say: 26 0 75 0 self 202) ; "I don't know sir. If we could sneak up on them somehow..."
						)
						(2
							(gMessager say: 26 0 76 0 self 202) ; "|f8|i'll|f| tell you what you should do about her! Put the little tart out the airlock and be done with it!"
						)
						(3
							(gMessager say: 26 0 77 0 self 202) ; "Let me see, We're up against a horde of rampaging mutants in stolen battle cruiser that outguns us a hundred to one..."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(proc201_5 1)
				(self dispose:)
			)
		)
	)
)

(instance sFThrakusChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 79 1 self 202) ; "Yes Captain?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 80 0 self 202) ; "The Goliath is jamming all transmissions Captain."
						)
						(2
							(gMessager say: 12 0 81 0 self 202) ; "We've been through a lot on this mission sir, and then you go and bring that little tramp on board..."
						)
						(3
							(gMessager say: 12 0 82 0 self 202) ; "I'm afraid not, sir. I guess we're on our own."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFAfterClorox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 64 1 self 202) ; "Yes, dear?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 65 0 self 202) ; "It was highly irregular, Sir. Quirk sounded like he was in big trouble."
						)
						(2
							(gMessager say: 12 0 66 0 self 202) ; "The transmission came from the vicinity of the Thrakus system."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sFBeforeGoliath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_0)
				(= cycles 1)
			)
			(1
				(gMessager say: 12 0 83 1 self 202) ; "<Sigh> What is it, Captain Wilco?"
			)
			(2
				((ScriptID 201 13) normal: 1 keepWindow: 0) ; floTalker
				(if ((ScriptID 201 13) whichSelect:) ; floTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 13) whichSelect:) ; floTalker
						(1
							(gMessager say: 12 0 84 0 self 202) ; "I'm sorry sir, I haven't made any progress countering the frequency jamming."
						)
						(2
							(gMessager say: 12 0 85 0 self 202) ; "I don't know sir, but there are a lot of people out there counting on us to figure something out."
						)
						(3
							(gMessager say: 12 0 87 0 self 202) ; "I'm a wreck, sir, and my bunions are killing me."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sDAfterClorox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(= cycles 1)
			)
			(1
				(gMessager say: 26 0 70 1 self 202) ; "Captain?"
			)
			(2
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(gMessager say: 26 0 71 0 self 202) ; "Hard to say sir. That whole business back on the planet definitely pegged the weird meter."
						)
						(2
							(gMessager say: 26 0 72 0 self 202) ; "No problem captain. Besides, I've always wanted to try one of those quick draws."
						)
						(else
							(= cycles 1)
						)
					)
				else
					(= cycles 1)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sAsteroidChoices of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 13 0 20 1 self 201) ; "But sir! That will take us directly into an asteroid field. It'd be suicide!"
			)
			(1
				(= cycles 1)
				(localproc_1)
			)
			(2
				(gMessager say: 22 0 8 1 self 202) ; "What should we do, Captain?"
			)
			(3
				((ScriptID 201 12) normal: 1 keepWindow: 0) ; drooleTalker
				(if ((ScriptID 201 12) whichSelect:) ; drooleTalker
					(gGame handsOff:)
					(switch ((ScriptID 201 12) whichSelect:) ; drooleTalker
						(1
							(eureka setScript: 0)
							(eureka warnings: 3 timer: 5)
							(ClearFlag 42)
							(SetScore 189 35)
						)
						(2)
						(3)
						(else
							(= cycles 1)
						)
					)
				else
					(self dispose:)
				)
				(= cycles 1)
			)
			(4
				(gGame handsOff:)
				(self dispose:)
			)
		)
	)
)

(instance sDrooleComments of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setLoop: 0 posn: 134 95 setCel: 0 show:)
				(proc201_7 self)
			)
			(1
				(gMessager say: 12 0 10 4 self 202) ; "You'll have to excuse Flo. She has a bit of a problem dealing with male authority figures. But she's really not so bad after you get to know her."
			)
			(2
				(gEgo setLoop: 1 setCel: 0 posn: 178 95)
				(= cycles 2)
			)
			(3
				(gMessager say: 12 0 10 5 self 202) ; "Can it, lobster boy."
			)
			(4
				(self setScript: (ScriptID 201 8) self) ; sTurnDrooleBack
			)
			(5
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

