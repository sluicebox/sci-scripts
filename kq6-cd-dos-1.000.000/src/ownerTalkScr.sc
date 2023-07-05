;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 284)
(include sci.sh)
(use Main)
(use rm280)
(use n913)
(use Rev)
(use Motion)
(use System)

(public
	ownerTalkScr 0
	ringMapNotOutScr 1
	ringForMapActIScr 2
	ringForPearlScr 3
	ringForMapNotActIScr 4
	talkAfterActI 5
)

(instance ownerTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 4 2 13 1 self) ; "Excuse me, merchant, but the ferryman mentioned that you might have a magic map of the Land of the Green Isles."
			)
			(3
				(gMessager say: 4 2 13 2 self) ; "Why, as a matter of fact, I do! I keep it under the counter. It has been gathering dust so long, I nearly forgot about it."
			)
			(4
				((ScriptID 280 2) ; shopOwner
					view: 286
					posn: 236 127
					loop: 1
					cel: 0
					setPri: 11
					setCycle: End self
				)
				((gInventory at: 0) owner: -1) ; map
			)
			(5
				(= cycles 2)
			)
			(6
				(gMessager say: 4 2 13 3 self) ; "It was quite a few years ago, you see. The estate of a wealthy wizard fell into my hands when he died. It was useless magical junk mostly--which reminds me, I've still got some things of his in the back that I need to dump out."
			)
			(7
				(gMessager say: 4 2 13 4 self) ; "Anyway, the magic map was the one true treasure in the lot. The wizard was quite old and feeble and had enchanted the map to aid in traveling."
			)
			(8
				(gMessager say: 4 2 13 5 self) ; "It is said that one need only desire to be on an island depicted on the map to find oneself there."
			)
			(9
				(gMessager say: 4 2 13 6 self) ; "It is a very valuable map, as you can imagine. Unfortunately, no one is interested in traveling these days. It is far too dangerous with the current state of the kingdom."
			)
			(10
				((ScriptID 280 2) loop: 2 cel: 0 setCycle: CT 4 1 self) ; shopOwner
			)
			(11
				((ScriptID 280 1) init:) ; map
				((ScriptID 280 2) setCycle: End self) ; shopOwner
			)
			(12
				((ScriptID 280 2) setPri: -1 view: 280 loop: 8 cel: 0) ; shopOwner
				(= cycles 2)
			)
			(13
				(UnLoad 128 286)
				(gMessager say: 4 2 13 7 self oneOnly: 0) ; "What would you take for the map?"
			)
			(14
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 284)
	)
)

(instance ringMapNotOutScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(= register
					(if ((ScriptID 10 0) isSet: 1) ; rgCrown
						(self setScript: (ScriptID 286 2) self) ; alexShowScr
						36
					else
						((ScriptID 10 0) setIt: 1) ; rgCrown
						(self setScript: (ScriptID 286 1) self 16384) ; alexGiveScr
						18
					)
				)
			)
			(3
				(gMessager
					say: 4 70 register 1 (if (== register 36) self else script)
				)
			)
			(4
				(gMessager say: 4 70 register 2 script)
			)
			(5
				(if (== register 36)
					(+= state 2)
					(= cycles 2)
				else
					(gMessager say: 4 70 register 3 self)
				)
			)
			(6
				(self setScript: (ScriptID 286 0) self) ; ownerGiveScr
			)
			(7
				(gMessager say: 4 70 register 4 self)
			)
			(8
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 284)
	)
)

(instance ringForMapActIScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 39 gCurRoomNum) ; royalRing
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(gGame givePoints: 5)
				(self setScript: (ScriptID 286 1) self 16384) ; alexGiveScr
			)
			(3
				(UnLoad 128 2811)
				(UnLoad 128 284)
				(gMessager say: 4 70 19 1 (ScriptID 286 1)) ; "(HOPEFULLY) Would you be willing to take my family ring in exchange for the magic map?", alexGiveScr
			)
			(4
				(gMessager say: 4 70 19 2 (ScriptID 286 1)) ; "Daventry...are you a king, then?", alexGiveScr
			)
			(5
				(gMessager say: 4 70 19 3 self) ; "(BLUSHING) No, that's my father, King Graham. I'm just Alexander."
			)
			(6
				(gMessager say: 4 70 19 4 self) ; "Well, Prince Alex, she is a beautiful ring. Are you sure you can part with such a unique family heirloom?"
			)
			(7
				(gMessager say: 4 70 19 5 self) ; "(SAD) The ring does mean a lot to me. I didn't always have a family, you know. Still, it IS only gold. There are more important things at stake now."
			)
			(8
				(gMessager say: 4 70 19 6 self) ; "Then you now own a magic map, Prince Alex. I will keep your ring out of sight for a few days."
			)
			(9
				(gMessager say: 4 70 19 7 self) ; "If you find anything else of great value in your travels, you can return for your ring. I would hate to see it melted down for the gold."
			)
			(10
				(gMessager say: 4 70 19 8 self) ; "And a warning about the map; it will only operate when you are out in the open and within sight of the sea. The limitation has something to do with the teleport spell ingredients. You might try the beach."
			)
			(11
				(gMessager say: 4 70 19 9 self) ; "Thank you. You're very kind. And I'll remember about the map."
			)
			(12
				(NextAct)
				(self setScript: (ScriptID 286 3) self) ; alexTakeMapScr
			)
			(13
				(UnLoad 128 286)
				(self setScript: (ScriptID 282 2) self) ; genieTakeMintScr
				(= cycles 1)
			)
			(14
				(gEgo
					reset:
					setSpeed: 6
					setLoop: 0
					setCycle: Rev
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(15
				(gEgo setCycle: Walk)
			)
			(16
				(gCurRoom newRoom: 145)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 284)
	)
)

(instance ringForMapNotActIScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo get: 0 put: 39 gCurRoomNum) ; map, royalRing
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 4 70 21 1 self) ; "Can I trade you my ring for the magic map again, merchant? I'm afraid I am still in need of it."
			)
			(3
				(gMessager say: 4 70 21 2 self) ; "Of course, Prince Alex."
			)
			(4
				(self setScript: (ScriptID 286 1) self -32768) ; alexGiveScr
			)
			(5
				(script cue:)
			)
			(6
				(= ticks 15)
			)
			(7
				(self setScript: (ScriptID 286 3) self) ; alexTakeMapScr
			)
			(8
				((ScriptID 280 2) setScript: (ScriptID 280 9)) ; shopOwner, shopOwnerScr
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 284)
	)
)

(instance ringForPearlScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 39 get: 30) ; royalRing, pearl
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 4 70 20 1 self) ; "Might I trade you this ring again, merchant?"
			)
			(3
				(gMessager say: 4 70 20 2 self) ; "I have nothing of value enough to trade for it except the pearl you gave me. I would think you would prefer your family ring, but if you wish, I will trade it."
			)
			(4
				(self setScript: (ScriptID 286 1) self) ; alexGiveScr
			)
			(5
				(script cue:)
			)
			(6
				(= ticks 120)
			)
			(7
				(self setScript: (ScriptID 286 0) self) ; ownerGiveScr
			)
			(8
				(gMessager say: 4 70 20 3 self) ; "Thank you."
			)
			(9
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 284)
	)
)

(instance talkAfterActI of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc280_10 self)
				(gEgo normal: 0 view: 280 loop: 7 cel: 0)
				(= cycles 2)
			)
			(1
				(UnLoad 128 900)
			)
			(2
				(gMessager say: 4 2 47 1 self) ; "How fare you, good merchant?"
			)
			(3
				(gMessager
					say:
						4
						2
						(switch (Random 0 4)
							(0 15)
							(1 37)
							(2 44)
							(3 45)
							(4 46)
						)
						1
						self
				)
			)
			(4
				(gEgo reset: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 284)
	)
)

