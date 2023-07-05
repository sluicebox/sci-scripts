;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 755)
(include sci.sh)
(use Main)
(use rm750)
(use ArrayScript)
(use LoadMany)
(use Motion)
(use System)

(public
	startFight 0
	noDagger 1
	cassimaHasDagger 2
	fightPart1 3
)

(local
	[local0 25] = [7504 4 0 158 136 -4095 3 1 -3968 750 1 0 -4064 2 -4095 8 1 -3968 750 1 0 -4064 2 -4094 -1]
	[local25 505] = [751 4 0 136 144 -4095 2 1 -3968 750 1 0 -4064 1 -4094 751 7 0 138 137 -3968 750 1 0 -4064 1 -4095 5 1 -3968 750 1 0 -4064 1 -4094 -3840 -1 6 23 15 3 -3840 -1 6 23 15 4 -3840 -1 6 23 15 5 7511 0 0 101 156 -4095 3 1 -16 128 751 -3968 750 1 0 -4064 1 -4094 7511 2 0 106 147 -4095 1 1 -3968 750 1 0 -4064 1 -4094 7511 1 0 93 151 -4095 3 1 -3968 756 1 0 -4094 7512 2 0 100 165 -4094 7512 0 0 131 171 -4095 1 1 -3968 756 1 0 -4094 7515 3 0 149 162 -4095 2 1 -3968 750 1 0 -4064 1 -4095 6 1 -3968 750 1 0 -4064 1 -4094 7515 0 0 157 170 -4095 1 1 -3968 750 1 0 -4064 1 -4094 7515 1 0 152 171 -4095 3 1 -3968 750 1 0 -4064 1 -4095 5 1 -3968 755 1 0 -4094 7515 2 0 152 174 -4095 3 1 -3968 755 1 0 -4095 8 1 -3968 755 1 0 -4094 7516 0 0 143 158 -4095 2 1 -3968 756 1 0 -4094 7516 4 0 174 151 -4094 7516 1 0 179 152 -4095 3 1 -3968 750 1 0 -4064 1 -4094 7517 1 0 171 131 -4095 2 1 -3968 750 1 0 -4064 1 -4094 7517 0 0 170 139 -4095 3 1 -3968 750 1 0 -4064 1 -4094 7511 0 0 170 158 -4095 3 1 -3968 750 1 0 -4064 1 -4094 7511 1 0 162 143 -4095 3 1 -3968 756 1 0 -4094 7512 0 0 169 156 -4095 1 1 -3968 756 1 0 -4094 7515 0 0 167 156 -4095 1 1 -3968 750 1 0 -4064 1 -4094 7515 1 0 161 158 -4095 3 1 -3968 750 1 0 -4064 1 -4095 5 1 -3968 755 1 0 -4094 7515 2 0 159 159 -4095 3 1 -3968 755 1 0 -4095 8 1 -3968 755 1 0 -4094 7516 0 0 150 143 -4095 2 1 -3968 756 1 0 -4094 7516 1 0 157 145 -4095 3 1 -3968 750 1 0 -4064 1 -4094 7517 0 0 156 144 -4095 3 1 -3968 750 1 0 -4064 1 -4094 7511 0 0 158 163 -4095 3 1 -3968 750 1 0 -4064 1 -4094 -3840 -1 6 23 15 6 7511 1 0 152 148 -4095 3 1 -3968 756 1 0 -4094 7512 0 0 159 162 -4095 1 1 -3968 756 1 0 -4094 -3840 -1 6 23 15 7 -1 -3840 -1 6 23 16 1 7512 1 0 135 171 -4095 3 1 -3968 750 1 0 -4064 1 -4094 -3840 -1 6 23 16 2 -3840 -1 6 23 16 3 7513 0 0 134 161 -4094 7513 1 0 134 161 -4094 -1]
	[local530 52] = [7514 0 0 153 150 -4095 2 1 -3968 751 1 0 -4094 -1 -4092 -3840 -1 1 0 6 1 -3840 -1 1 0 6 2 7513 0 7 159 151 -4094 -3840 -1 1 0 6 3 7513 1 11 159 151 -4094 -3840 -1 1 0 6 4 -1]
)

(instance startFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not register)
					(gEgo
						view: 751
						loop: 6
						cel: 0
						posn: 178 132
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				((ScriptID 750 1) ; roomConv
					add: -1 6 23 15 1 ; "SO! The mouse would bite?"
					add: -1 6 23 15 2 ; "This mouse SHALL bite, as you shall soon see--or should I say, soon feel?"
					init: self
				)
			)
			(2
				((ScriptID 750 3) dispose:) ; vizier
				(if register
					(gTheIconBar disable: 6)
					(gCurRoom
						setScript: (lampStartScr next: fightPart1 yourself:)
					)
				else
					(= next fightPart1)
					(self dispose:)
				)
			)
		)
	)
)

(instance cassimaHasDagger of Script
	(properties)

	(method (init)
		(super init: &rest)
		(gMouseDownHandler add: self)
		(gKeyDownHandler add: self)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (and (== state 11) (gUser canInput:) (gEgo onMe: event))
			(event claimed: 1)
			(gGame handsOff:)
			(self state: 25 seconds: 0 cycles: 2)
		)
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 750 6) ; cassima
					view: 753
					setLoop: 2
					setCycle: Walk
					posn: 28 160
					setStep: 5 2
					setMotion: MoveTo 131 160 self
				)
			)
			(1
				(if (gCurRoom script:)
					(-- state)
				)
				(= cycles 2)
			)
			(2
				(gEgo
					view: 753
					loop: 0
					cel: 0
					posn: 159 149
					setCycle: CT 2 1 self
				)
			)
			(3
				(gMessager say: 6 23 15 8 self) ; "Not if I can help it, you murderer!"
			)
			(4
				((ScriptID 750 6) ; cassima
					view: 753
					loop: 1
					cel: 0
					posn: 140 153
					setCycle: CT 3 1 self
				)
			)
			(5
				(gGlobalSound2 number: 754 setLoop: 1 play:)
				(gEgo cel: 3)
				(= ticks 3)
			)
			(6
				((ScriptID 750 1) ; roomConv
					add: -1 6 23 15 9 ; "Cassima thrusts the small dagger into Alhazred's shoulder with all her might!"
					add: -1 6 23 15 10 ; "Yyeeiii!!!"
					init: self
				)
			)
			(7
				(gEgo setCycle: End self)
				((ScriptID 750 6) setCycle: End (ScriptID 750 6)) ; cassima, cassima
			)
			(8
				(gMessager say: 6 23 15 11 self) ; "You! You dare raise a finger to me?! You will regret that, princess!"
			)
			(9)
			(10
				(= cycles 4)
			)
			(11
				(proc750_5)
				(if (or (not gHowFast) (not (HaveMouse)))
					(= seconds 15)
				else
					(= seconds 8)
				)
			)
			(12
				(proc750_5 1)
				(= cycles 1)
			)
			(13
				(gGame handsOff:)
				(gEgo setCycle: Beg self)
			)
			(14
				(gMessager say: 1 0 6 1 self) ; "But I forget--I stalk a kitten and turn my back to a lion! It wouldn't do to let you gather your strength again, my prince."
			)
			(15
				(gMessager say: 1 0 6 2 self) ; "Alhazred finishes off Alexander with one swipe of his sword."
			)
			(16
				(gCurRoom setScript: noDagger 0 1)
				(self dispose:)
			)
			(26
				(proc750_5 1)
				(gGame givePoints: 5)
				(= cycles 1)
			)
			(27
				(gGame handsOff:)
				(gEgo
					view: 7514
					setLoop: 0
					cel: 0
					posn: 153 150
					setCycle: CT 2 1 self
				)
			)
			(28
				(gGlobalSound number: 0 stop:)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 751 setLoop: 1 play:)
				(= cycles 3)
			)
			(29
				(gGlobalSound number: 752 setLoop: -1 play:)
				(gEgo setCycle: End self)
			)
			(30
				(gEgo setLoop: 1 cel: 0 setCycle: CT 7 1 self)
			)
			(31
				(gEgo setCycle: End self)
			)
			(32
				((ScriptID 750 3) ; vizier
					init:
					view: 7514
					setLoop: 2
					posn: 153 150
					ignoreActors: 1
					addToPic:
				)
				((ScriptID 750 2) dispose:) ; vizHead
				(gEgo
					oldScaleSignal: 0
					view: 900
					loop: 9
					cel: 2
					setLoop: -1
					setPri: -1
					scaleSignal: 1
					scaleX: 96
					scaleY: 96
					posn: 164 146
					cycleSpeed: 6
					moveSpeed: 6
					ignoreActors: 1
					normal: 1
					setCycle: 0
				)
				(= cycles 2)
			)
			(33
				(gEgo
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 120 143 self
				)
			)
			(34
				(gEgo
					setLoop: 5
					setMotion:
						MoveTo
						((ScriptID 750 6) x:) ; cassima
						(- ((ScriptID 750 6) y:) 2) ; cassima
						self
				)
			)
			(35
				(gEgo setLoop: 9 cel: 2)
				(= ticks 30)
			)
			(36
				(gEgo
					view: 758
					setLoop: 0
					cel: 0
					posn: ((ScriptID 750 6) x:) ((ScriptID 750 6) y:) ; cassima, cassima
					normal: 0
				)
				((ScriptID 750 6) hide:) ; cassima
				(= ticks 30)
			)
			(37
				((ScriptID 750 1) ; roomConv
					add: -1 6 23 10 4 ; "Cassima! Are you all right?"
					add: -1 6 23 10 5 ; "I'm fine, Alexander. I just was so afraid for you!"
					add: -1 6 23 10 6 ; "There's no need to fear anymore, princess."
					add: -1 6 23 10 7 ; "Yes. I know. How can I ever repay you? For myself, for my kingdom...."
					init: self
				)
			)
			(38
				(gEgo setCycle: End self)
			)
			(39
				((ScriptID 750 1) ; roomConv
					add: -1 6 23 10 8 ; "It was not in me to let harm come to you. Can you find it in you, princess, to give me more than your gratitude?"
					add: -1 6 23 10 9 ; "Alexander! What are you saying?"
					add: -1 6 23 10 10 ; "I love you, Cassima. Would you ever consider...do you think you could...marry me?"
					add: -1 6 23 10 11 ; "Could you ever have doubted it, my prince?"
					init: self
				)
			)
			(40
				(gEgo setMotion: 0 setCycle: 0)
				(gTheIconBar enable: 6)
				(gCurRoom newRoom: 180)
			)
		)
	)
)

(instance startEndingCartoon of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTheIconBar enable: 6)
				(= cycles 2)
			)
			(1
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 740)
			)
		)
	)
)

(class SwordArrayScript of ArrayScript
	(properties)

	(method (play param1 param2 param3)
		(gGlobalSound3 number: 0 stop:)
		(gGlobalSound3 number: param1 setLoop: param2 play:)
		(if param3
			(gGlobalSound3 client: param3)
		else
			(= cycles 1)
		)
	)
)

(instance lampStartScr of SwordArrayScript
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance fightPart1 of SwordArrayScript
	(properties)

	(method (at param1)
		(LoadMany 0 751 7511 7512 7515 7516 7517)
		(return [local25 param1])
	)

	(method (dispose)
		(gTheIconBar enable: 6)
		(super dispose: &rest)
	)
)

(instance knockOutVizier of SwordArrayScript ; UNUSED
	(properties)

	(method (at param1)
		(return [local530 param1])
	)
)

(instance noDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc750_5 1)
				(gGlobalSound number: 0 stop:)
				(gGlobalSound number: 705 setLoop: 1 play:)
				(= cycles 1)
			)
			(1
				(gGame handsOff:)
				(if (not register)
					(gMessager say: 6 23 16 1 self) ; "The vizier takes advantage of Alexander's exhaustion. He thrusts his sword deep into Alexander's chest."
				else
					(= cycles 2)
				)
			)
			(1
				(gEgo view: 755 posn: 151 154 setLoop: 0 cel: 6)
				(= cycles 8)
			)
			(2
				(gEgo cel: 5)
				(= cycles 8)
			)
			(3
				(gEgo
					posn: 165 163
					view: 7504
					setLoop: 6
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(4
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 756 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(5
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 971 setLoop: 1 play: self)
			)
			(6
				(if (not register)
					((ScriptID 750 1) ; roomConv
						add: -1 6 23 16 2 ; "Cassima! Forgive me!"
						add: -1 6 23 16 3 ; "ALEXANDER! NO!"
						init: self
					)
				else
					(= cycles 2)
				)
			)
			(7
				(if register
					(gMessager say: 1 0 6 3 self) ; "(DYING) Forgive me...Cassima!"
				else
					(= cycles 2)
				)
			)
			(8
				(gEgo
					view: 7513
					posn: 161 150
					setLoop: 0
					cel: 0
					setCycle: End self
				)
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 652 setLoop: 1 play:)
			)
			(9
				(gEgo setLoop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(10
				(gGlobalSound2 number: 0 stop:)
				(gGlobalSound2 number: 652 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(11
				(if register
					(gMessager say: 1 0 6 4 self) ; "(HORRIFIED) Alexander, no!"
				else
					(= cycles 2)
				)
			)
			(12
				(if (== ((gInventory at: 8) owner:) 870) ; dagger
					(EgoDead 41) ; "Touche! Alexander should have been on guard."
				else
					(EgoDead 40) ; "Too bad Cassima's all tied up at the moment...."
				)
			)
		)
	)
)

