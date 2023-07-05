;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 11)
(include sci.sh)
(use Main)
(use n913)
(use Inset)
(use Scaler)
(use PolyPath)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	lampTradeScr 2
	talkToSellerScr 3
)

(local
	local0
)

(instance lampTradeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 10 0) setIt: 16) ; rgCrown
				(if (not ((ScriptID 10 0) isSet: 4)) ; rgCrown
					((ScriptID 10 0) setIt: 4) ; rgCrown
					(= register 22)
				else
					(= register 23)
				)
				(gMessager say: 4 43 register 1 self 240)
			)
			(1
				((ScriptID 241 0) setPri: -1 loop: 6 cel: 0 setCycle: End self) ; lampSeller
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo hide:)
				((ScriptID 241 0) ; lampSeller
					view: 245
					loop: 2
					cel: 0
					posn: 41 128
					scaleX: 102
					scaleY: 102
					setScale:
					setSpeed: 6
					setCycle: End self
				)
			)
			(4
				(gMessager say: 4 43 register 2 self 240)
			)
			(5
				(= cycles 2)
			)
			(6
				((ScriptID 241 0) hide:) ; lampSeller
				(gEgo
					show:
					normal: 0
					view: 247
					loop: 0
					cel: 0
					setSpeed: 6
					setCycle: End self
				)
			)
			(7
				(gEgo loop: 1 cel: 0 setCycle: End self)
			)
			(8
				(= ticks 60)
			)
			(9
				(lampSellerInset init: self gCurRoom)
			)
			(10
				(gGame handsOff:)
				(= cycles 2)
			)
			(11
				(if (not local0)
					(gMessager say: 39 0 0 1 self 240) ; "(SLIGHTLY EMBARRASSED) Um, I think I've changed my mind. I'm going to keep my lamp for now."
				else
					(gMessager say: 34 5 0 1 self 240) ; "(CHEERFUL) Ah, fine choice, my son. Here is your new lamp."
				)
			)
			(12
				(if local0
					(= cycles 1)
				else
					(gEgo reset: 1 loop: 9 cel: 1)
					((ScriptID 241 0) ; lampSeller
						show:
						setScale: 0
						view: 2431
						loop: 6
						cel: 6
						setPri: 7
						posn: 19 128
						setCycle: Beg self
					)
					(+= state 2)
				)
			)
			(13
				(gEgo hide:)
				((ScriptID 241 0) ; lampSeller
					show:
					view: 245
					loop: 1
					cel: 0
					setCycle: End self
				)
			)
			(14
				(= cycles 2)
			)
			(15
				(if (not local0)
					(gMessager say: 39 0 0 2 self 240) ; "(WORLD WEARY) As you wish, sir."
				else
					(++ state)
					(self cue:)
				)
			)
			(16
				((ScriptID 241 0) ; lampSeller
					setScale: 0
					posn: 19 128
					view: 2431
					loop: 6
					cel: ((ScriptID 241 0) lastCel:) ; lampSeller
					setCycle: Beg self
				)
				(gEgo reset: 1)
				(gGame handsOn:)
				(client setScript: (ScriptID 241 1)) ; lampSellerScr
			)
			(17
				((ScriptID 241 0) ; lampSeller
					posn: 19 128
					view: 243
					loop: 0
					setCycle: Walk
					setScale: Scaler 90 72 188 95
				)
				(gEgo reset: 1)
				(client setScript: sealTheDealScr self)
			)
		)
	)
)

(instance lamp of Prop ; UNUSED
	(properties
		view 245
	)
)

(instance sealTheDealScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 34 5 0 2 self 240) ; "(RESPECTFUL) Good day, and I thank you, sir."
			)
			(1
				(gMessager say: 34 5 0 3 self 240) ; "(FRIENDLY) Good day."
			)
			(2
				(gCurRoom notify:)
				(= cycles 2)
			)
			(3
				((ScriptID 241 0) ; lampSeller
					moveSpeed: 3
					cycleSpeed: 3
					setMotion: PolyPath 274 187 self
				)
				(SetFlag 12)
			)
			(4
				((ScriptID 241 0) loop: 0) ; lampSeller
				(= cycles 2)
			)
			(5
				((ScriptID 241 0) ; lampSeller
					moveSpeed: 6
					cycleSpeed: 6
					view: 254
					loop: 0
					cel: 0
					setCycle: End self
				)
			)
			(6
				((ScriptID 241 0) loop: 1 cel: 0 setCycle: Fwd self) ; lampSeller
				(= seconds 4)
			)
			(7
				(gMessager say: 34 5 0 4 self 240) ; "Drat! Another dud!"
			)
			(8
				(= cycles 3)
			)
			(9
				((ScriptID 241 0) loop: 0 cel: ((ScriptID 241 0) lastCel:)) ; lampSeller, lampSeller
				(= cycles 2)
			)
			(10
				((ScriptID 241 0) setCycle: Beg self) ; lampSeller
			)
			(11
				(= cycles 2)
			)
			(12
				((ScriptID 241 0) ; lampSeller
					moveSpeed: 3
					cycleSpeed: 3
					view: 243
					setCycle: Walk
					setMotion: MoveTo 274 230 self
				)
			)
			(13
				(gGame handsOn:)
				(client dispose:)
			)
		)
	)
)

(instance talkToSellerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 241 0) loop: 0 cel: 0 setCycle: 0) ; lampSeller
				(if (== register -1)
					(gEgo
						view: 272
						loop: 1
						cel: 0
						setSpeed: 6
						setCycle: End self
					)
				else
					(gMessager say: 4 2 register 0 self 240)
					(+= state 4)
				)
			)
			(1
				(gMessager say: 4 0 0 0 self 240) ; "Would you accept this in exchange for one of your lamps, peddler?"
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo reset: 1)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(client setScript: (ScriptID 241 1)) ; lampSellerScr
			)
		)
	)
)

(instance lampSellerInset of Inset
	(properties
		picture 245
		hideTheCast 1
		disposeNotOnMe 1
		noun 9
	)

	(method (onMe param1)
		(return (InRect 83 48 232 136 (param1 x:) (param1 y:)))
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (init)
		(self drawInset:)
		(super init: &rest)
		(lamps init:)
		(gGame handsOn:)
		(gTheIconBar disable: 0 3 4 5 6 curIcon: (gTheIconBar at: 1))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb &rest)
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(super dispose:)
	)
)

(instance lamps of Feature
	(properties
		y 1
		onMeCheck 118
	)

	(method (onMe param1)
		(return
			(= noun
				(switch (OnControl CONTROL (param1 x:) (param1 y:))
					(2
						(lampTradeScr register: 0)
						((gInventory at: 25) ; newLamp
							message: 57
							noun: 25
							cel: 11
							setCursor: 990 1 11
						)
						34
					)
					(4
						(lampTradeScr register: 3)
						((gInventory at: 25) ; newLamp
							message: 56
							noun: 24
							loop: 2
							cel: 9
							setCursor: 990 2 9
						)
						7
					)
					(8
						(lampTradeScr register: 4)
						((gInventory at: 25) ; newLamp
							message: 58
							noun: 26
							cel: 13
							setCursor: 990 1 13
						)
						35
					)
					(16
						(lampTradeScr register: 3)
						((gInventory at: 25) ; newLamp
							message: 59
							noun: 27
							cel: 15
							setCursor: 990 1 15
						)
						36
					)
					(32
						(lampTradeScr register: 4)
						((gInventory at: 25) ; newLamp
							message: 60
							noun: 28
							cel: 14
							setCursor: 990 1 14
						)
						37
					)
					(64
						((gInventory at: 25) ; newLamp
							message: 96
							noun: 65
							cel: 12
							setCursor: 990 1 12
						)
						6
					)
					(else 0)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame givePoints: 1)
				(gEgo put: 19) ; huntersLamp
				(gGame handsOff:)
				(cond
					((== noun 7)
						(gEgo get: 25) ; newLamp
					)
					((not (gEgo has: 25)) ; newLamp
						(gEgo get: 25) ; newLamp
					)
				)
				(= local0 1)
				(lampSellerInset dispose:)
			)
			(else
				(if (!= theVerb 1) ; Look
					(= noun 34)
				)
				(gMessager say: noun theVerb 0 0 0 240)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(self sightAngle: 26505)
	)
)

