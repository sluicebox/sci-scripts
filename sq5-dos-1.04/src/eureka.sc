;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Print)
(use Sound)
(use Game)
(use System)

(public
	eureka 0
	sGoliathTimer 1
	sLiteSpeedTimer 2
	sBlowUpEureka 3
	sApproachTimer 4
	sBlobTimer 5
	sWD40Timer 6
	sTrashRunsTimer 8
	sEggTimer 9
	sAsteroidNoise 10
)

(class eureka of Rgn
	(properties
		state 0
		destination 0
		curLocation 0
		prevLocation 0
		warnings 0
		hits 0
		gdoor 0
		garbage 0
		puke 0
		damaged 0
	)

	(method (init)
		(super init: &rest)
		(if
			(not
				(OneOf
					gPrevRoomNum
					106
					107
					200
					201
					202
					203
					204
					205
					206
					212
					213
					215
					222
					225
					226
					228
					230
					240
					250
					280
					290
					295
				)
			)
			(self curLocation: gEurekaLocation)
			(if (OneOf gEurekaLocation 5 6 3 8 15 14) ; clorox2, thrakus, ku, genetix environdome, empty space, goliath
				(eureka state: 3)
			)
		)
	)

	(method (doit)
		(if (and (== gEurekaLocation 15) (not (eureka script:))) ; empty space
			(eureka setScript: sAsteroidNoise)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(= keep
			(OneOf
				newRoomNumber
				106
				107
				200
				201
				202
				203
				204
				205
				206
				212
				213
				215
				222
				225
				226
				228
				230
				240
				250
				280
				290
				295
			)
		)
		(= initialized 0)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(hailSound dispose:)
		(super dispose: &rest)
	)
)

(instance sLiteSpeedTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(eureka timer: 1)
				(self dispose:)
			)
		)
	)
)

(instance hailSound of Sound
	(properties)
)

(instance sMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (OneOf gCurRoomNum 226 228))
					(gGame handsOff:)
				)
				(hailSound number: 234 loop: 1 play: self)
			)
			(1
				(gMessager say: 11 0 14 5 self 201) ; "Captain Wilco, please report to the bridge."
			)
			(2
				(if (not (OneOf gCurRoomNum 226 228))
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sApproachTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(cond
					((== gCurRoomNum 201)
						(= cycles 1)
						(eureka timer: 2)
						(ClearFlag 115)
					)
					((gCurRoom script:)
						(-= state 2)
						(= register 5)
						(= cycles 1)
					)
					((IsFlag 37)
						(= gEurekaLocation 14) ; goliath
						(eureka
							timer: 0
							warnings: 0
							state: 3
							destination: 0 ; Nowhere
							curLocation: 14 ; goliath
						)
						(ClearFlag 37)
						(if (not (IsFlag 39))
							(client setScript: sBlowUpEureka 0 12)
							(self dispose:)
						else
							(= cycles 1)
						)
					)
					((== gCurRoomNum 200)
						(if (>= (eureka warnings:) 2)
							(gMessager say: 11 0 14 3 self 201) ; "Pull your head out Captain, we just missed our destination. Now we're gonna have to lay in a course again!"
							(eureka
								timer: 0
								warnings: 0
								state: 1
								destination: 0 ; Nowhere
							)
							(ClearFlag 38)
						else
							(gMessager say: 11 0 14 1 self 201) ; "We're approaching our destination, Captain."
							(eureka timer: 2)
							(= register 30)
							(-= state 2)
						)
					)
					(else
						(gCurRoom setScript: sMessage self)
						(SetFlag 115)
						(eureka timer: 2)
						(= register 30)
						(-= state 2)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sGoliathTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(cond
					((== gCurRoomNum 201)
						(eureka timer: 5)
						(= cycles 1)
					)
					((gCurRoom script:)
						(-= state 2)
						(= register 5)
						(= cycles 1)
					)
					(else
						(client setScript: sBlowUpEureka 0 12)
						(self dispose:)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sWD40Timer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(cond
					((== gCurRoomNum 201)
						(eureka timer: 3)
						(= cycles 1)
					)
					((gCurRoom script:)
						(= register 5)
						(-= state 2)
						(= cycles 1)
					)
					((== (eureka warnings:) 0)
						(if (== gCurRoomNum 200)
							(gMessager say: 11 0 14 1 self 201) ; "We're approaching our destination, Captain."
						else
							(gMessager say: 11 0 14 5 self 201) ; "Captain Wilco, please report to the bridge."
						)
						(eureka timer: 3 warnings: 0)
						(= register 30)
						(-= state 2)
					)
					(else
						(client setScript: sBlowUpEureka 0 6)
						(self dispose:)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTrashRunsTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(Prints
					{You didn't complete your mission in time! You're fired!}
				)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sEggTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 84)
				(gTheIconBar disable: 4)
				(= global136 600)
				(= cycles 1)
			)
			(1
				(= seconds 1)
			)
			(2
				(if (and (IsFlag 61) (<= global136 180) (== gCurRoomNum 201))
					(gGame handsOff:)
					(client setScript: (ScriptID 208 1)) ; sWD40Kills
					(self dispose:)
				)
				(if (!= gCurRoomNum 201)
					(-- global136)
				)
				(if global136
					(if (== global136 60)
						(gSq5Music1 number: 43 loop: -1 play:)
					)
					(-= state 2)
				)
				(= cycles 1)
			)
			(3
				(client setScript: sBlowUpEureka 0 11)
				(self dispose:)
			)
		)
	)
)

(instance sBlowUpEureka of Script
	(properties)

	(method (doit)
		(switch state
			(0
				(if (>= (PalVary pvGET_CURRENT_STEP) 63)
					(self cue:)
				)
			)
		)
		(super doit: &rest)
	)

	(method (cue)
		(self changeState: (+ state 1) &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PalVary pvUNINIT)
				(PalVary pvINIT 2100 1)
				(gEgo hide:)
				(gSq5Music2 number: 203 setLoop: 1 play:)
				(ShakeScreen 6 ssFULL_SHAKE)
			)
			(1
				(EgoDead register)
				(self dispose:)
			)
		)
	)
)

(instance sBlobTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(cond
					((and (== gCurRoomNum 201) (< (eureka puke:) 4))
						(eureka timer: 6)
						(self dispose:)
					)
					((gCurRoom script:)
						(-= state 2)
						(= register 5)
						(= cycles 1)
					)
					((== (eureka puke:) 1)
						(client setScript: sBlowUpEureka 0 43)
						(self dispose:)
					)
					((>= (eureka puke:) 2)
						(client setScript: sBlowUpEureka 0 7)
						(self dispose:)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance theMusic5 of Sound
	(properties)
)

(instance sAsteroidNoise of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(ShakeScreen 1 (Random 1 3))
				(theMusic5 number: 202 setLoop: 1 play: 80)
				(= seconds (Random 2 20))
			)
			(2
				(if (not (eureka destination:))
					(-= state 2)
				)
				(= cycles 1)
			)
			(3
				(theMusic5 stop:)
				(self dispose:)
			)
		)
	)
)

