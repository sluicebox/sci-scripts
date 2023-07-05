;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 531)
(include sci.sh)
(use Main)
(use verseScript)
(use rhEgo)
(use RTEyeCycle)
(use PolyPath)
(use Sound)
(use Motion)
(use System)

(public
	monkCode 0
)

(local
	[local0 9] = [535 0 2 4 26 38 22 26 27]
	[local9 4] = [1531 66 1 0]
	[local13 5] = [1531 10 1 2 0]
	[local18 4] = [1531 12 1 0]
	[local22 8] = [1531 59 1 2 1 1 1 0]
	[local30 5] = [1531 64 1 2 0]
	[local35 5] = [1531 67 1 2 0]
	[local40 8] = [1531 13 1 2 1 2 1 0]
	[local48 5] = [1531 18 1 1 0]
	[local53 4] = [1531 18 1 0]
	[local57 5] = [1531 20 1 1 0]
	[local62 4] = [1531 20 1 0]
	[local66 5] = [1531 22 1 1 0]
	[local71 4] = [1531 22 1 0]
	[local75 4] = [1531 57 1 0]
	[local79 6] = [1531 36 1 2 2 0]
	[local85 10] = [1531 40 2 1 2 1 2 1 2 0]
	[local95 9] = [1531 47 1 2 1 2 2 2 0]
	[local104 6] = [1531 53 1 2 1 0]
	[local110 4] = [1531 56 1 0]
	[local114 5] = [1531 24 1 2 0]
	[local119 6] = [1531 26 1 2 1 0]
	[local125 7] = [1531 29 1 2 1 2 0]
	[local132 5] = [1531 0 1 1 0]
	[local137 5] = [1531 2 1 1 0]
	[local142 4] = [1531 4 1 0]
	[local146 4] = [1531 5 1 0]
	[local150 4] = [1531 6 1 0]
	[local154 5] = [1531 8 1 1 0]
	[local159 4] = [1531 7 1 0]
	local163
	local164
	local165
	local166
	local167
)

(instance monkCode of Code
	(properties)

	(method (init)
		((ScriptID 530 1) actions: vbKeeperMonk) ; keeper
		((ScriptID 530 2) actions: vbGateMonk) ; gate
	)
)

(instance payBill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (gMoney doit:))
				(if (not register)
					(self dispose:)
					(return)
				)
				(cond
					((IsFlag 86)
						(if (and (>= register 48) (not (IsFlag 116)))
							(++ state)
							(Converse @local125 @local0 999 self) ; "What's all this?"
							(SetScore 20 116)
						else
							(= cycles 1)
						)
					)
					((and (not local167) (IsFlag 31))
						(= local167 1)
						(Converse @local114 @local0 999 self 1) ; "What's this for? I filled your cask."
					)
					((not local166)
						(= local166 1)
						(Converse @local119 @local0 999 self 1) ; "It's about time the Abbot sent some money."
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				((ScriptID 530 1) setScript: (ScriptID 530 3) 0 register) ; keeper, payKeeper
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance tryNOpen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((or (and (IsFlag 25) (== gDay 6)) (> gDay 6))
						(Converse @local154 @local0 0 self) ; "The Abbot's in an uproar over something or other and doesn't want anyone using the secret way."
						(+= state 4)
					)
					((and (IsFlag 31) (gEgo has: 11)) ; cask
						(Converse @local132 @local0 0 self) ; "Since you brought me the cask, I'll let you go back the short way."
					)
					((IsFlag 117)
						(cond
							((IsFlag 116)
								(Converse @local150 @local0 0 self) ; "Here you go, Brother and be careful no one sees you using the secret way."
							)
							(local165
								(Converse @local146 @local0 0 self) ; "Remind the Abbot this is the last time I'm letting one of you into the cellar until he pays his bill."
							)
							((not (gEgo has: 11)) ; cask
								(Converse @local159 @local0 0 self) ; "I've no love for most of you Monks, but since you brought me that cask before, I'll let you through."
							)
							(else
								(Converse @local142 @local0 0 self) ; "You're decent enough for a Monk, but you tell the Abbot no one is using the secret way again until he's paid his bill."
								(+= state 4)
							)
						)
					)
					(else
						(Converse @local137 @local0 0 self) ; "You're as much a bloody nuisance as the rest of your order."
						(+= state 4)
					)
				)
			)
			(1
				((ScriptID 530 1) setMotion: PolyPath 210 113 self) ; keeper
			)
			(2
				(gateSound play:)
				((ScriptID 530 2) ; gate
					signal: (& ((ScriptID 530 2) signal:) $feff) ; gate
					startUpd:
					setCycle: End self
				)
			)
			(3
				(gCurRoom newRoom: 550)
			)
			(4
				((ScriptID 530 1) setMotion: PolyPath 265 133 self) ; keeper
			)
			(5
				((ScriptID 530 1) setHeading: 270 self) ; keeper
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fillCask of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 25)
				(Converse @local79 9 @local0 self) ; "I believe this empty cask belongs to you."
			)
			(1
				((ScriptID 530 1) setHeading: 0 self) ; keeper
			)
			(2
				(= seconds 2)
			)
			(3
				((ScriptID 530 1) setHeading: 270 self) ; keeper
			)
			(4
				(SetFlag 31)
				(Converse @local85 9 @local0 self) ; "Here's a new cask. Did the Abbot send payment?"
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance vbKeeperMonk of SpecialDoVerb
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(cond
					((IsFlag 117)
						(switch (+ (if (IsFlag 116) 2 else 0) local165)
							(0
								(Converse @local40 @local0 9) ; "I don't suppose you've come back to pay the Abbot's bill?"
							)
							(1
								(if
									(or
										(and (IsFlag 25) (== gDay 6))
										(> gDay 6)
									)
									(Converse @local53 @local0) ; "Much obliged for the return of the cask."
								else
									(Converse @local48 @local0) ; "Much obliged for the return of the cask."
								)
							)
							(2
								(if
									(or
										(and (IsFlag 25) (== gDay 6))
										(> gDay 6)
									)
									(Converse @local62 @local0) ; "I much appreciate you seeing to the bill."
								else
									(Converse @local57 @local0) ; "I much appreciate you seeing to the bill."
								)
							)
							(3
								(if
									(or
										(and (IsFlag 25) (== gDay 6))
										(> gDay 6)
									)
									(Converse @local71 @local0) ; "You're worth your weight in salt, Brother."
								else
									(Converse @local66 @local0) ; "You're worth your weight in salt, Brother."
								)
							)
						)
					)
					((and (IsFlag 31) (gEgo has: 11)) ; cask
						(if local164
							(Converse @local18 @local0) ; "If you bring back that cask when it's empty, I'll be most pleased."
						else
							(Converse @local13 @local0 9) ; "Perhaps you haven't been with this order long enough to learn the Abbot's bad habits. I hope you don't."
							(= local164 1)
						)
					)
					(else
						(switch local163
							(0
								(++ local163)
								(if (not (SetFlag 187))
									(Converse @local22 @local0 9) ; "You don't look familiar. You must be new to the order."
								else
									(Converse @local35 9 @local0) ; "You don't seem pleased to see me again."
								)
							)
							(1
								(Converse @local30 9 @local0) ; "I take it you don't care for the Abbot?"
								(++ local163)
							)
							(else
								(Converse @local9 @local0) ; "I'm not in the mood for idle chatter."
							)
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; bucks
						((ScriptID 530 1) setScript: payBill) ; keeper
						(return 1)
					)
					(11 ; cask
						(cond
							((IsFlag 31)
								(Converse @local75 @local0) ; "This is full. Bring it back when it's empty."
							)
							(
								(or
									(and (IsFlag 25) (== gDay 6))
									(> gDay 6)
								)
								(gEgo put: 11) ; cask
								(Converse @local110 @local0) ; "Much obliged for the return of my cask, Brother."
							)
							((IsFlag 117)
								(gEgo put: 11) ; cask
								(SetScore 10)
								(if (IsFlag 116)
									(Converse @local104 9 @local0) ; "I've brought back another empty cask."
								else
									(Converse @local95 9 @local0) ; "I've brought back another empty cask."
								)
							)
							(else
								(gCurRoom setScript: fillCask)
							)
						)
						(= local165 1)
					)
					(else
						(return 0)
					)
				)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance vbGateMonk of SpecialDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom setScript: tryNOpen)
				(return 1)
			)
		)
		(return 0)
	)
)

(instance gateSound of Sound
	(properties
		flags 1
		number 532
	)
)

