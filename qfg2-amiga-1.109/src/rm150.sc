;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 150)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Bar)
(use Interface)
(use LoadMany)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm150 0
)

(local
	strengthFactor
	egoPressure
	egoPressureIncrement
	issurPressureIncrement
	egoPressureCounter
	egoStamina
	testEgoStamina
	egoStaminaRate = 1
	egoSlamming
	egoIncrease
	issurPressure
	issurPressureCounter
	issurStamina = 400
	issurStaminaRate = 1
	issurSlamming
	updater
	tryToHold
	deadlockCounter = 10
	oldSameCel
	gameOver
	allDone
	[trim 6]
	[trimLoop 6] = [0 1 1 0 2 3]
	[trimCel 6] = [0 0 1 1 0 0]
	[trimX 6] = [83 235 235 84 50 269]
	[trimY 6] = [52 52 160 160 125 124]
)

(procedure (AddTrim &tmp I)
	(for ((= I 0)) (< I 6) ((++ I))
		((= [trim I] (aTrim new:))
			loop: [trimLoop I]
			cel: [trimCel I]
			x: [trimX I]
			y: [trimY I]
		)
		(gAddToPics add: [trim I] init: doit:)
	)
)

(instance aTrim of PicView
	(properties
		shiftClick 0
		view 150
		signal 16
	)
)

(instance rm150 of Rm
	(properties
		picture 150
		style 7
	)

	(method (init &tmp S yourStrength)
		(LoadMany rsVIEW 150 151)
		(switch gHowFast
			(0
				(= gSpeed 0)
			)
			(1
				(= gSpeed 2)
			)
			(2
				(= gSpeed 5)
			)
			(3
				(= gSpeed 6)
			)
		)
		(if (== gArcadeLevel 1)
			(+= gSpeed 5)
		)
		(if (== gArcadeLevel 3)
			(/= gSpeed 2)
		)
		(= testEgoStamina (= egoStamina [gEgoStats 17])) ; stamina
		(= yourStrength 150)
		(= S 1)
		(while (< S 5)
			(= strengthFactor S)
			(if (>= [gEgoStats 0] yourStrength) ; strength
				(break)
			)
			(++ S)
			(-= yourStrength 25)
		)
		(= issurPressure (= egoPressure (/ 1500 strengthFactor)))
		(= issurPressureIncrement (/ (* (= egoPressureIncrement (/ egoPressure 80)) 8) 10))
		(gDirectionHandler add: self)
		(gKeyDownHandler add: self)
		(gCSound number: 50 loop: -1 playBed:)
		(super init:)
		(AddTrim)
		(Display 150 0 dsCOORD 84 3 dsFONT 300 dsCOLOR 12 dsBACKGROUND 0) ; "YOU"
		(Display 150 1 dsCOORD 201 3 dsFONT 300 dsCOLOR 12 dsBACKGROUND 0) ; "ISSUR"
		(fatHead init:)
		(arms init:)
		(egoPressureBar max: 500 value: (/ egoPressure 100) init:)
		(issurPressureBar max: 500 value: (/ issurPressure 100) init:)
		(gCurRoom setScript: readySetGo)
	)

	(method (dispose)
		(SetFlag 17)
		(= gSpeed 6)
		(gCSound fade:)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance rulesWindow of SysWindow
	(properties
		back 7
	)
)

(instance egoPressureBar of Bar
	(properties
		x 85
		y 18
		cel 7
	)
)

(instance issurPressureBar of Bar
	(properties
		x 210
		y 18
		cel 7
	)
)

(instance fatHead of Prop
	(properties
		x 161
		y 93
		shiftClick 0
		view 151
		loop 2
		cel 3
	)

	(method (doit)
		(if (arms loop:)
			(self setCel: (arms cel:))
		)
		(super doit:)
	)
)

(instance arms of Prop
	(properties
		x 125
		y 153
		shiftClick 0
		view 151
	)
)

(instance readySetGo of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Print 150 2 #mode 1 #width 270 #at -1 100 #window rulesWindow) ; "HOW TO PLAY Enter key - holds back opponent SpaceBar - attempts slam LeftArrow - increases pressure applied RightArrow - decreases pressure applied"
				(self cue:)
			)
			(1
				(HighPrint 150 3 103) ; "Ready!"
				(= seconds 2)
			)
			(2
				(HighPrint 150 4 103) ; "Set!"
				(arms setCycle: End)
				(= seconds 2)
			)
			(3
				(HighPrint 150 5 103) ; "GO!"
				(arms loop: 1 cel: 3)
				(egoPressureBar
					max: (/ (* (/ 2500 strengthFactor) 2) 10)
					value: (/ egoPressure 10)
					doit:
				)
				(issurPressureBar
					max: (/ (* (/ 2500 strengthFactor) 2) 10)
					value: (/ issurPressure 10)
					doit:
				)
				(fatHead setScript: issurStrategy)
				(gCurRoom setScript: goForIt)
			)
		)
	)
)

(instance goForIt of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(cls)
			)
		)
	)

	(method (doit &tmp armCel theEdge)
		(if updater
			(= updater 0)
			(egoPressureBar
				max: (/ (* (/ 2500 strengthFactor) 2) 10)
				value: (/ egoPressure 10)
				draw:
			)
			(issurPressureBar
				max: (/ (* (/ 2500 strengthFactor) 2) 10)
				value: (/ issurPressure 10)
				draw:
			)
			(= issurStaminaRate (+ (/ (* 7 issurPressure) 4000) 1))
			(= egoStaminaRate (+ (/ (* 5 egoPressure) (* (/ 2500 strengthFactor) 2)) 1))
			(if egoSlamming
				(*= egoStaminaRate egoSlamming)
			)
			(if issurSlamming
				(*= issurStaminaRate (+ issurSlamming 2))
			)
			(cond
				((< [gEgoStats 0] 40) ; strength
					(*= egoStaminaRate 4)
				)
				((< [gEgoStats 0] 60) ; strength
					(*= egoStaminaRate 3)
				)
				((< [gEgoStats 0] 80) ; strength
					(*= egoStaminaRate 2)
				)
			)
			(-= egoStamina egoStaminaRate)
			(-= issurStamina issurStaminaRate)
			(if (< egoStamina (- testEgoStamina 10))
				(= testEgoStamina egoStamina)
				(UseStamina 10)
			)
			(= armCel (arms cel:))
			(cond
				((< deadlockCounter 0)
					(if (== deadlockCounter -1)
						(arms setCel: oldSameCel)
						(= deadlockCounter 10)
					else
						(++ deadlockCounter)
					)
				)
				((!= oldSameCel armCel)
					(= oldSameCel armCel)
					(= deadlockCounter 10)
				)
				(deadlockCounter
					(-- deadlockCounter)
				)
				((and (!= armCel 1) (> issurPressure egoPressure))
					(arms setCel: (- armCel 1))
					(= deadlockCounter -4)
				)
				((and (!= armCel 5) (> egoPressure issurPressure))
					(arms setCel: (+ armCel 1))
					(= deadlockCounter -4)
				)
			)
			(= theEdge
				(cond
					((== gDay 10) 10)
					((or (>= strengthFactor 2) (< (arms cel:) 3)) 0)
					(else
						(/ 200 issurStamina)
					)
				)
			)
			(if egoSlamming
				(-- egoSlamming)
				(+= egoPressure (* egoPressureIncrement (+ egoSlamming theEdge)))
			)
			(if issurSlamming
				(-- issurSlamming)
				(+= issurPressure (* issurPressureIncrement issurSlamming))
				(if (not (or tryToHold egoSlamming egoIncrease))
					(-= egoPressure egoPressureIncrement)
				)
			)
			(cond
				((not tryToHold))
				((-- tryToHold)
					(cond
						((== gDay 10)
							(= egoPressure issurPressure)
						)
						((> egoPressure issurPressure)
							(-= egoPressure egoPressureIncrement)
						)
						((> issurPressure (+ egoPressure 30))
							(if (> (arms cel:) 3)
								(+= egoPressure (* egoPressureIncrement (if issurSlamming 14 else 8)))
							else
								(+= egoPressure (* egoPressureIncrement 4))
							)
						)
						((> issurPressure egoPressure)
							(+= egoPressure egoPressureIncrement)
						)
						(else
							(+= egoPressure (/ egoPressureIncrement 4))
						)
					)
				)
			)
			(if (> egoPressure (+ issurPressure 30))
				(if egoSlamming
					(+= issurPressure (* issurPressureIncrement (+ strengthFactor 1)))
				else
					(+= issurPressure (* issurPressureIncrement (- 5 strengthFactor)))
				)
			)
			(if (> egoPressure (* (/ 2500 strengthFactor) 2))
				(= egoPressure (* (/ 2500 strengthFactor) 2))
			)
			(if (> issurPressure 4000)
				(= issurPressure 4000)
			)
			(cond
				((and (< egoStamina 50) (not allDone))
					(= allDone 1)
					(= egoPressure 0)
					(LowPrint 150 6 25 4 103) ; "Your staying power diminished, Issur takes advantage of the opportunity to slam your hand to the anvil."
				)
				((and (<= issurStamina 0) (not allDone) (!= (arms cel:) 6))
					(= allDone 1)
					(= issurPressure 0)
					(LowPrint 150 7 25 4 103) ; "You can feel Issur weaken from the great effort he has taken to overcome your staying power. You take advantage of the opportunity to slam his hand to the anvil."
				)
			)
			(cond
				((> egoPressure (+ issurPressure 50))
					(= issurPressureCounter 0)
					(if (>= (++ egoPressureCounter) 5)
						(arms setCel: (+ (arms cel:) 1))
						(= egoPressureCounter 0)
						(= deadlockCounter 10)
					)
				)
				((> issurPressure (+ egoPressure 50))
					(= egoPressureCounter 0)
					(if (>= (++ issurPressureCounter) 5)
						(arms setCel: (- (arms cel:) 1))
						(= issurPressureCounter 0)
						(= deadlockCounter 10)
					)
				)
			)
			(cond
				((and (== (arms cel:) 6) (not gameOver))
					(= gameOver 1)
					(SetFlag 23)
					(arms setScript: byeBye)
				)
				((and (== (arms cel:) 0) (== (arms loop:) 1) (not gameOver))
					(= gameOver 1)
					(arms setScript: byeBye)
				)
			)
		else
			(= updater 1)
		)
		(= egoIncrease 0)
		(super doit:)
	)

	(method (handleEvent event &tmp evt)
		(if (and (== (event message:) KEY_RETURN) allDone)
			(event claimed: 1)
			(return)
		else
			(if (super handleEvent: event)
				(return 1)
			)
			(switch (event type:)
				($0040 ; direction
					(event claimed: 1)
					(switch (event message:)
						(JOY_LEFT
							(= egoIncrease 1)
							(+= egoPressure egoPressureIncrement)
						)
						(JOY_RIGHT
							(-= egoPressure egoPressureIncrement)
						)
					)
					(while ((= evt (Event new:)) type:)
						(evt dispose:)
					)
					(evt dispose:)
				)
				(evKEYBOARD
					(event claimed: 1)
					(switch (event message:)
						(KEY_RETURN
							(if (and (not tryToHold) (not egoSlamming))
								(SkillUsed 0 4) ; strength
								(= tryToHold (/ egoStamina 100))
							)
						)
						(KEY_SPACE
							(if (and (not tryToHold) (not egoSlamming))
								(SkillUsed 0 8) ; strength
								(= egoSlamming 6)
							)
						)
					)
					(while ((= evt (Event new:)) type:)
						(evt dispose:)
					)
					(evt dispose:)
				)
			)
		)
	)
)

(instance byeBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(cls)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 140)
			)
		)
	)
)

(instance issurStrategy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles (Random 5 20))
			)
			(1
				(if (not issurSlamming)
					(= issurSlamming 6)
				)
				(= cycles (Random 20 50))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

