;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 276)
(include sci.sh)
(use Main)
(use rm270)
(use n913)
(use Motion)
(use System)

(public
	giveRareBookScr 1
	talkOwnerScr 2
	talkAfterLLoc 3
)

(instance giveRareBookScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 77)
				(proc270_7 self)
			)
			(1
				(gMessager say: 18 27 0 1 self) ; "I found this rare book, and I thought of your offer."
			)
			(2
				(gEgo
					setSpeed: 6
					normal: 0
					put: 36 ; riddleBook
					get: 45 ; spellBook
					view: 2771
					loop: 4
					cel: 0
					cycleSpeed: 5
					posn: 264 151
					setCycle: End
				)
				((ScriptID 270 2) ; shopOwner
					view: 2771
					loop: 5
					cel: 0
					posn: 307 152
					setCycle: End self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 18 27 0 2 self) ; "Very interesting! It is a wonderful riddle book. Riddles are much more marketable than spells these days. I guess people believe more in mirth than in magic."
			)
			(5
				((ScriptID 270 2) ; shopOwner
					loop: 0
					cel: 0
					posn: 300 161
					setCycle: CT 3 1 self
				)
			)
			(6
				((ScriptID 270 6) dispose:) ; spellBook
				(= cycles 2)
			)
			(7
				((ScriptID 270 2) setCycle: CT 7 1 self) ; shopOwner
			)
			(8
				(gEgo loop: 3 cel: 0 setCycle: CT 2 1 self)
			)
			(9
				((ScriptID 270 2) setCycle: End self) ; shopOwner
				(gEgo setCycle: End self)
			)
			(10 0)
			(11
				(= cycles 2)
			)
			(12
				(gEgo
					reset: 0
					posn:
						((ScriptID 270 2) approachX:) ; shopOwner
						((ScriptID 270 2) approachY:) ; shopOwner
				)
				((ScriptID 270 2) ; shopOwner
					view: 277
					loop: 2
					cel: 0
					posn: 303 151
					stopUpd:
				)
				(= cycles 2)
			)
			(13
				(gMessager say: 18 27 0 3 self) ; "Here is the spell book you wanted, and a fair trade it is, I must say. Enjoy it."
			)
			(14
				(gMessager say: 18 27 0 4 self) ; "I certainly hope so. We shall see how rusty my spell-casting truly is."
			)
			(15
				(gGame givePoints: 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 276)
	)
)

(instance talkOwnerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc270_7 self)
			)
			(1
				(if
					(and
						(gCast contains: (ScriptID 271 0)) ; bookShopGenie
						((ScriptID 10 0) isSet: -32768) ; rgCrown
					)
					(self setScript: (ScriptID 278 1) self) ; genieSpyScr
				else
					(= cycles 1)
				)
			)
			(2
				(if (not (IsFlag 16))
					(SetFlag 16)
					(gGame givePoints: 1)
					(gMessager say: 18 2 22 0 self) ; "Good day, sir. I'm a stranger in this land. What can you tell me about the Land of the Green Isles?"
				else
					(gMessager say: 18 2 23 1 self) ; "How fare you, merchant?"
				)
			)
			(3
				(if
					(and
						(gCast contains: (ScriptID 271 0)) ; bookShopGenie
						((ScriptID 10 0) isSet: -32768) ; rgCrown
					)
					((ScriptID 10 0) setIt: -32768) ; rgCrown
					(self setScript: (ScriptID 278 1) self) ; genieSpyScr
				else
					(= cycles 1)
				)
			)
			(4
				(self dispose:)
				(gGame handsOn:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 276)
	)
)

(instance talkAfterLLoc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc270_7 self)
			)
			(1
				(if
					(and
						(gCast contains: (ScriptID 271 0)) ; bookShopGenie
						((ScriptID 10 0) isSet: -32768) ; rgCrown
					)
					(self setScript: (ScriptID 278 1) self) ; genieSpyScr
				else
					(= cycles 1)
				)
			)
			(2
				(gMessager say: 18 2 21 0 self) ; "What can you tell me about the Land of the Green Isles?"
			)
			(3
				(gMessager say: 18 2 22 5 self oneOnly: 0) ; "This island is called the Isle of the Crown because the royal family's castle is here. Besides the castle, we also have this village, and the docks over to the west."
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 276)
	)
)

