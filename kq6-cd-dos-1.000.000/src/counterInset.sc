;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 283)
(include sci.sh)
(use Main)
(use rm280)
(use n913)
(use Inset)
(use Conversation)
(use Actor)
(use System)

(public
	counterInset 0
	buyItemWithCoinScr 1
	genericExchangeScr 2
	offerCoinForMapScr 3
	lookAtCounterScr 4
)

(local
	local0
	[local1 21] = [48 3 14 27 -1 0 5 38 1 0 0 -1 -1 10 5 38 2 0 0 -1 0]
	local22
	local23
)

(instance counterInset of Inset
	(properties
		view 287
		x 84
		y 48
		priority 15
		disposeNotOnMe 1
		noun 35
	)

	(method (init)
		(super init: &rest)
		(if (== ((gInventory at: 48) owner:) gCurRoomNum) ; tinderBox
			(tinderBox init:)
		)
		(if (== ((gInventory at: 3) owner:) gCurRoomNum) ; brush
			(paintBrush init:)
		)
		(if (== ((gInventory at: 27) owner:) gCurRoomNum) ; nightingale
			(windupBird init:)
		)
		(if (== ((gInventory at: 14) owner:) gCurRoomNum) ; flute
			(flute init:)
		)
		(if (and (== (gCurRoom script:) lookAtCounterScr) 1)
			(gMessager say: 9 1) ; "Alexander takes a closer look at the items on the counter."
		)
		(if (and (IsFlag 29) (IsFlag 30) (not (gEgo has: 0))) ; map
			(counterMap init:)
		)
		(self setScript: initDoneScr)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (drawInset)
		(super drawInset:)
		(insetView ignoreActors: addToPic:)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(gGame handsOff:)
		(DisposeClone insetView)
		(if (not local0)
			(ClearFlag 51)
			(ClearFlag 50)
		)
		(super dispose: &rest)
		(gCurRoom drawPic: gCurRoomNum 100)
	)
)

(class counterItemObj of View
	(properties
		view 287
		loop 1
		priority 15
		signal 16401
		baseFlag 32
		lookFlagNum 0
		invItemNum 0
		item 0
	)

	(method (init param1)
		(super init: &rest)
		(if (> argc 0)
			(= item param1)
		)
		(= invItemNum [local1 item])
		(= lookFlagNum (+ baseFlag item))
		(= sightAngle 26505)
		(self addToPic:)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag lookFlagNum))
					(SetFlag lookFlagNum)
					(gMessager say: noun 1 42 0 0 280)
				else
					(gMessager say: noun 1 43)
				)
			)
			(5 ; Do
				(= local0 1)
				(if (gCurRoom script:)
					((gCurRoom script:)
						setScript: itemTradeScr (counterInset caller:) noun
					)
				else
					(gCurRoom
						setScript: itemTradeScr (counterInset caller:) noun
					)
				)
				(counterInset caller: 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance roomTalk of Conversation ; UNUSED
	(properties)
)

(instance tinderBox of counterItemObj
	(properties
		x 197
		y 89
		noun 10
	)
)

(instance paintBrush of counterItemObj
	(properties
		x 191
		y 67
		noun 13
		cel 2
		item 1
	)
)

(instance windupBird of counterItemObj
	(properties
		x 92
		y 76
		noun 12
		cel 1
		item 3
	)
)

(instance flute of counterItemObj
	(properties
		x 143
		y 62
		noun 11
		cel 3
		item 2
	)
)

(instance counterMap of View
	(properties
		x 145
		y 106
		noun 37
		view 287
		loop 1
		cel 4
		priority 15
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gMessager
					say:
						noun
						theVerb
						(cond
							((IsFlag 50) 16)
							((IsFlag 51) 39)
							(else 0)
						)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= sightAngle 26505)
		(self addToPic:)
	)
)

(instance itemTradeScr of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(counterInset dispose:)
				(= cycles 2)
			)
			(2
				(= cycles 2)
			)
			(3
				(= temp1 0)
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					(if (gEgo has: [local1 temp0])
						(= temp1 1)
						(break)
					)
				)
				(cond
					(temp1
						(= state 5)
						(gMessager say: register 5 41 1 self)
					)
					((or (IsFlag 50) (IsFlag 51))
						(= state 3)
						(= local22 (if (IsFlag 50) 4 else 6))
						(gMessager say: register 5 16 1 self)
					)
					(else
						(= state 7)
						(gMessager say: register 5 38 1 self)
					)
				)
			)
			(4
				(= state local22)
				(self
					setScript:
						(ScriptID 287 1) ; getFromCounter
						self
						(switch register
							(11 2)
							(10 0)
							(12 3)
							(13 1)
						)
				)
			)
			(5
				(= state 8)
				(gMessager say: 10 5 16 2 self oneOnly: 0) ; "Very well. Your coin is well spent. Remember, this is a pawn shop. I am always willing to take back my own goods in trade."
			)
			(6
				(= state 8)
				(gMessager say: 10 5 41 2 self oneOnly: 0) ; "Certainly. What do you wish to offer me in trade?"
			)
			(7
				(= state 8)
				(gMessager
					say: register 5 (if (== gAct 1) 39 else 40) 0 self
				)
			)
			(8
				(= state 8)
				(gMessager say: 10 5 38 2 self) ; "What do you desire to give me in trade? The items on the front counter are all of equally slight value--worth only a copper or two. They are handy items, nonetheless."
			)
			(9
				(ClearFlag 50)
				(ClearFlag 51)
				(if (== client gCurRoom)
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance lookAtCounterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
			)
			(1
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(2
				(UnLoad 128 900)
				(= cycles 2)
			)
			(3
				(counterInset init: self gCurRoom)
			)
			(4
				(gEgo reset: 0)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 283)
	)
)

(instance buyItemWithCoinScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
			)
			(1
				(self
					setScript:
						(ScriptID 286 1) ; alexGiveScr
						self
						(if (SetFlag 109)
							(= register 69)
							-32768
						else
							(= register 23)
							-16384
						)
				)
			)
			(2
				(gMessager say: 4 40 register 1 script)
			)
			(3
				(gMessager
					say:
						4
						40
						register
						2
						(if (!= register 23)
							(++ state)
							self
						else
							script
						)
				)
			)
			(4
				(gMessager say: 4 40 23 3 self oneOnly: 0) ; "The items on the front counter are the only things in the store that I can let go for the price of one copper. You may make your choice from there."
			)
			(5
				(= cycles 2)
			)
			(6
				(SetFlag 50)
				(counterInset init: self gCurRoom)
			)
			(7
				(= cycles 2)
			)
			(8
				(if (not local0)
					(gMessager say: 1 5 63 0 self) ; "I'm really not interested in anything on the counter at this time."
				else
					(++ state)
					(gGame givePoints: 2)
					(gEgo put: 9 gCurRoomNum) ; coin
					(= cycles 1)
				)
			)
			(9
				(self setScript: (ScriptID 286 0) self 1) ; ownerGiveScr
			)
			(10
				(gEgo reset: 0)
				(= cycles 2)
			)
			(11
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 283)
	)
)

(instance genericExchangeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
			)
			(1
				(= register
					(switch register
						(20 0)
						(37 3)
						(29 1)
						(31 2)
					)
				)
				(self setScript: (ScriptID 287 0) self register) ; placeOnCounter
			)
			(2
				(gMessager say: 4 20 24 1 script) ; "Would you mind if I traded this in?"
			)
			(3
				(if (== gAct 1)
					(gMessager say: 4 20 24 2 self) ; "Certainly not, stranger. Please, choose an item in exchange from those on the counter."
				else
					(gMessager say: 4 20 25 1 self) ; "Of course, Prince Alex. Please, choose something in exchange from the items on the counter."
				)
			)
			(4
				(gMessager say: 4 20 24 3 self) ; "Alexander looks closely at the items on the counter to make his selection."
			)
			(5
				(= cycles 2)
			)
			(6
				(SetFlag 51)
				(counterInset init: self gCurRoom)
			)
			(7
				(= cycles 10)
			)
			(8
				(if (not local0)
					(gMessager say: 1 5 63 1 self) ; "I'm really not interested in anything on the counter at this time."
				else
					(+= state 2)
					(= cycles 1)
				)
			)
			(9
				(gMessager say: 1 5 64 2 self) ; "As you wish. Allow me to return your item for trade."
			)
			(10
				(self setScript: (ScriptID 287 1) self register) ; getFromCounter
			)
			(11
				(= cycles 2)
			)
			(12
				(gEgo reset: 0)
				(= cycles 2)
			)
			(13
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 283)
	)
)

(instance offerCoinForMapScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
			)
			(1
				(self
					setScript:
						(ScriptID 286 1) ; alexGiveScr
						self
						(if (SetFlag 109)
							(= register 70)
							-32768
						else
							(= register 22)
							-16384
						)
				)
			)
			(2
				(gMessager say: 4 40 register 1 script)
			)
			(3
				(gMessager
					say:
						4
						40
						register
						2
						(if (!= register 22)
							(++ state)
							self
						else
							script
						)
				)
			)
			(4
				(gMessager say: 4 40 22 3 self oneOnly: 0) ; "In fact, I would say it is about the worth of our own copper. The only items in the store that I could let go for the price of a single copper are the four simple items I normally display on the front counter."
			)
			(5
				(= cycles 2)
			)
			(6
				(SetFlag 50)
				(counterInset init: self gCurRoom)
			)
			(7
				(= cycles 2)
			)
			(8
				(if (not local0)
					(gMessager say: 1 5 63 0 self) ; "I'm really not interested in anything on the counter at this time."
				else
					(++ state)
					(gGame givePoints: 2)
					(gEgo put: 9 gCurRoomNum) ; coin
					(= cycles 1)
				)
			)
			(9
				(self setScript: (ScriptID 286 0) self) ; ownerGiveScr
			)
			(10
				(gEgo reset: 0)
				(= cycles 2)
			)
			(11
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 283)
	)
)

(instance initDoneScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar curIcon: (gTheIconBar at: 1))
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
				(gTheIconBar disable: 0 3 4 5 6)
				(= local0 0)
				(self dispose:)
			)
		)
	)
)

