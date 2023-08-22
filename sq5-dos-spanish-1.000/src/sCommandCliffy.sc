;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 218)
(include sci.sh)
(use Main)
(use eureka)
(use Print)
(use Sound)
(use System)

(public
	sCommandCliffy 0
)

(instance theMusic3 of Sound
	(properties)
)

(instance sCommandCliffy of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 202 13) setScript: 0) ; monitor1
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982 1)
				(= register
					(Print
						mode: 1
						window: (ScriptID 205 0) ; commandWindow
						width: 125
						addColorButton: 0 1 0 0 19 0 0 205 13 29 31 0 0 0 ; "Status Report"
						addColorButton: 1 1 0 0 20 0 10 205 13 29 31 0 0 0 ; "Cloak Ship"
						addColorButton: 2 1 0 0 21 0 20 205 13 29 31 0 0 0 ; "De-cloak Ship"
						addColorButton: 3 1 0 0 22 0 30 205 13 29 31 0 0 0 ; "More Power"
						addColorButton: 4 1 0 0 23 0 40 205 13 29 31 0 0 0 ; "Forget it"
						init:
					)
				)
				(= cycles 1)
			)
			(2
				(switch register
					(0
						(self setScript: sStatusReport self)
					)
					(1
						(self setScript: sCloakShip self)
					)
					(2
						(self setScript: sDeCloakShip self)
					)
					(3
						(self setScript: sMorePower self)
					)
					(4
						(self setScript: sForgetIt self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if (and (== gEurekaLocation 14) (not (IsFlag 39))) ; goliath
					(eureka setScript: (ScriptID 210 1) 0 1) ; sGoliathTimer
				)
				(if (!= register 4)
					(gMessager say: 43 0 0 1 self) ; "Anything else Captain?"
					(= state 0)
				else
					(= cycles 1)
				)
			)
			(4
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2))
				(gGame setCursor: 982 1)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 218)
		(DisposeScript 205)
	)
)

(instance sStatusReport of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((IsFlag 61)
						(gMessager say: 8 0 13 1 self) ; "Main energizers off line, Cap'n. Weapon systems are knocked out too. We're a sitting duck!"
					)
					((and (> gSpikeState 1) (not (IsFlag 56)))
						(gMessager say: 8 0 12 1 self) ; "Captain! That acid-squirting critter of yours is loose down here!"
					)
					((and (== gEurekaLocation 14) (IsFlag 39)) ; goliath
						(gMessager say: 8 0 55 1 self) ; "The cloaking device is working perfectly Captain. There's no way the Goliath can detect us. Unless of course, you go and do something stupid like order me to decloak!"
					)
					((eureka damaged:)
						(gMessager say: 8 0 11 1 self) ; "We're in bad shape, Captain. I don't think we can hold together much longer."
					)
					((>= (eureka puke:) 4)
						(gMessager say: 8 0 16 1 self) ; MISSING MESSAGE
					)
					((and (== gWD40State 2) (not (IsFlag 47)))
						(gMessager say: 8 0 5 1 self) ; "I've finished putting WD40 back together and reprogrammed her to perform as our science officer. You can now reach her through the science station on your com panel."
						(SetFlag 47)
					)
					((IsFlag 30)
						(gMessager say: 8 0 3 (Random 1 3) self)
					)
					(else
						(gMessager say: 8 0 4 (Random 1 3) self)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sCloakShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((IsFlag 39)
						(gMessager say: 7 0 9 1 self) ; "We're already cloaked, Captain."
					)
					((not (IsFlag 89))
						(if (IsFlag 30)
							(gMessager say: 7 0 3 (Random 1 3) self)
						else
							(gMessager say: 7 0 4 (Random 1 3) self)
						)
					)
					((IsFlag 32)
						(gMessager say: 7 0 45 1 self) ; "We can't cloak the ship while we're at lite speed, sir."
					)
					((and (== gAct 2) (IsFlag 75))
						(SetFlag 39)
						(self setScript: sCloaking self)
					)
					(else
						(gMessager say: 7 0 10 1 self) ; "Sorry sir, I haven't finished hooking it up yet."
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sCloaking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 42 0 52 1 self) ; "Yes, Captain. Right away."
			)
			(1
				(= seconds 2)
			)
			(2
				(if (IsFlag 37)
					(SetScore 194 50)
					(eureka setScript: (ScriptID 210 4) 0 1) ; sApproachTimer
				)
				(theMusic3 number: 106 loop: 1 play: self)
			)
			(3
				(theMusic3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sDeCloakShip of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 39))
					(if (IsFlag 30)
						(gMessager say: 10 0 3 (Random 1 3) self)
					else
						(gMessager say: 10 0 4 (Random 1 3) self)
					)
				else
					(self setScript: sCloaking self)
					(ClearFlag 39)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sMorePower of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 26 0 0 0 self) ; "She can't take much more o' this Captain!"
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sForgetIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 30)
					(gMessager say: 17 0 3 (Random 1 3) self)
				else
					(gMessager say: 17 0 4 (Random 1 3) self)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

