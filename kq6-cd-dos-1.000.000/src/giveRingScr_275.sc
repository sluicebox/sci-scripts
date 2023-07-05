;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 275)
(include sci.sh)
(use Main)
(use n913)
(use Conversation)
(use Motion)
(use System)

(public
	giveRingScr 0
)

(instance roomConv of Conversation
	(properties)
)

(instance interactionScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 274 0) view: 2722 loop: 3 cel: 0 setCycle: End self) ; clown
			)
			(1
				((ScriptID 274 0) stopUpd:) ; clown
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
			(3
				((ScriptID 274 0) view: 273 loop: 0 cel: 0 setCycle: End self) ; clown
			)
			(4
				((ScriptID 274 0) stopUpd:) ; clown
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
			(6
				((ScriptID 274 0) loop: 1 cel: 0 setCycle: End self) ; clown
			)
			(7
				((ScriptID 274 0) stopUpd:) ; clown
				(= cycles 2)
			)
			(8
				(self dispose:)
			)
			(9
				((ScriptID 274 0) view: 2731 loop: 0 cel: 0 setCycle: End self) ; clown
			)
			(10
				((ScriptID 274 0) stopUpd:) ; clown
				(= cycles 2)
			)
			(11
				(self dispose:)
			)
			(12
				((ScriptID 274 0) loop: 1 cel: 0 setCycle: End self) ; clown
			)
			(13
				((ScriptID 274 0) stopUpd:) ; clown
				(= cycles 2)
			)
			(14
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(= start (+ state 1))
	)
)

(instance giveRingScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 274 0) setScript: 0) ; clown
				(if register
					(gMessager say: 10 40 9 1 self) ; "Determined to learn more about the strange man's relationship with the princess, Alexander attempts to loosen the man's tongue with a coin."
				else
					(gMessager say: 10 70 11 1 self) ; "Determined to learn more about the strange man's relationship with the princess, Alexander shows the man his insignia ring and formally introduces himself."
				)
			)
			(1
				(gEgo
					setSpeed: 6
					normal: 0
					view: 272
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(3
				(UnLoad 128 900)
				(if register
					(gMessager say: 10 40 9 2 self) ; "Excuse me, good fellow, but my name is Alexander of Daventry, and I have this copper coin...."
				else
					(gMessager say: 10 70 11 2 self) ; "I'm sorry to insist, but my name is Alexander of Daventry and...."
				)
			)
			(4
				((ScriptID 274 0) view: 2721 loop: 1 cel: 0 setCycle: End self) ; clown
			)
			(5
				((ScriptID 274 0) stopUpd:) ; clown
				(= cycles 2)
			)
			(6
				(if register
					(gMessager say: 10 40 9 3 self) ; "The shopkeep is over there, Alexander. I'm not...."
				else
					(gMessager say: 10 70 11 3 self) ; "I appreciate the offer of the ring, Alexander, but I'm afraid I'm already spoken...."
				)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(9
				(roomConv
					add: -1 19 0 27 1 ; "Daventry? Where have I heard of Daventry?"
					add: interactionScr
					add: -1 19 0 27 2 ; "Flying flitmice! You must be Prince Alexander! Cassima told me about you when she arrived home! How came you here?"
					add: -1 19 0 27 3 ; "Why, by a ship, now wrecked upon the sand! But--you know Cassima? She truly spoke of me?"
					add: -1 19 0 27 4 ; "Yes, yes. I saw her briefly when she first returned home. She mentioned a prince to me, Prince Alexander of Daventry. I'm afraid that was before she was told about her parents' deaths."
					add: interactionScr
					add: -1 19 0 27 5 ; "You see, she arrived home a few weeks too late. The king and queen thought they'd never see her again. It is said they died of heartbreak. I'm afraid she's blamed herself."
					add: -1 19 0 27 6 ; "What a terrible homecoming! If we had only known...."
					add: -1 19 0 27 7 ; "<sniff> Terrible indeed, poor thing. Everyone in the kingdom seems to despair with her these days. The streets are silent."
					add: -1 19 0 27 8 ; "Where is she now?"
					add: -1 19 0 27 9 ; "The princess is sequestered in mourning. It's a rather dated tradition, and not required, but the vizier says she insisted out of respect."
					add: -1 19 0 27 10 ; "I see. You've yet to say who you are, and how you know the princess."
					add: interactionScr
					add: -1 19 0 27 11 ; "I? Oh, pardon me! My name is Jollo. I am clown to the royal court and have been since the marriage of Cassima's parents, King Caliphim and Queen Allaria. Ah, those were happy days! The pair of them were so full of joy and life! So in love!"
					add: -1 19 0 27 12 ; "And Cassima's birth.... It would be hard to explain how long they had waited, how they had hoped for a child. She was such a charming little thing, smart as a whip, kind and sweet. She means everything to this kingdom, Alexander, and to me. I am so terribly worried about her."
					add: interactionScr
					add: -1 19 0 27 13 ; "About her grief over her parents, you mean?"
					add: -1 19 0 27 14 ; "Well, the truth is, I do not trust the vizier, nor his plans for Cassima. I'm still living at the Castle of the Crown as court clown, HIS clown, but it is more to keep my ear to the ground than out of loyalty."
					add: interactionScr
					add: -1 19 0 27 15 ; "I wish I knew what the princess thinks these days. <sigh> If only I could find Sing Sing, Cassima's pet nightingale, I might be able to send the princess a message. As it is, I must wait for the end of her seclusion."
					init: self
				)
			)
			(10
				(= cycles 2)
			)
			(11
				(cond
					((OneOf gAct 1 2)
						(gMessager say: 10 70 11 4 self oneOnly: 0) ; "Now, I'm afraid I must hurry back to the castle. I'll try to return to the book shop again later."
					)
					((== gAct 3)
						(self setScript: giveRingAct3Scr self)
					)
					((== gAct 4)
						(self setScript: giveRingAct4Scr self)
					)
				)
			)
			(12
				(DisposeScript 1020)
				(DisposeScript 1001)
				(= cycles 1)
			)
			(13
				((ScriptID 274 0) ; clown
					view: 274
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(14
				(UnLoad 128 2721)
				(UnLoad 128 2722)
				(UnLoad 128 273)
				(UnLoad 128 2731)
				((ScriptID 270 3) init:) ; clownBook
				(= cycles 2)
			)
			(15
				(gEgo startUpd:)
				(= cycles 2)
			)
			(16
				((ScriptID 274 0) setCycle: End self) ; clown
				(gEgo
					posn:
						((ScriptID 274 0) approachX:) ; clown
						((ScriptID 274 0) approachY:) ; clown
					reset: 1
				)
			)
			(17
				(UnLoad 128 272)
				(client setScript: (ScriptID 274 1)) ; clownExitScr
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(= register 0)
	)
)

(instance giveRingAct3Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 10 70 12 1 self) ; "What can you tell me about the vizier?"
			)
			(1
				(= cycles 2)
			)
			(2
				(gMessager say: 19 0 28 0 self) ; "The vizier? Hmph. Now there's a dangerous subject. His name is Abdul Alhazred. He came to the kingdom fifteen years ago. The king was fascinated by his knowledge and his fine-sounding ideas."
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 10 70 12 2 self oneOnly: 0) ; "Now, I must return to the castle. I don't want to arouse suspicion. I'll try to meet you here again later."
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance giveRingAct4Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 10 70 13 0 self) ; "She needs the time to heal and she's safe enough in her room, I suppose. The vizier has been warning the guards about some threat to her, some stranger in the Land, but I think he's just...."
			)
			(1
				(= cycles 2)
			)
			(2
				(SetFlag 52)
				(gMessager say: 19 0 29 0 self) ; "The vizier's genie must have learned of your presence in the Land, Prince Alex. I don't know how, but he must have."
			)
			(3
				(self dispose:)
			)
		)
	)
)

