;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use LightRoom)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm210 0
)

(instance rm210 of LightRoom
	(properties
		picture 210
	)

	(method (init)
		(if (or (IsFlag 107) (IsFlag 229))
			(Load rsAUDIO 2029 2030)
		else
			(Load rsAUDIO 455)
		)
		((ScriptID 1 2) newPic: 211) ; exitBack
		(subEngineSet
			add: blueThing gears engine yellowThing redThing bigGears steam
			eachElementDo: #init
		)
		(if (== (gBackMusic number:) 2011)
			(gBackMusic setVol: 30)
		)
		(if (IsFlag 229)
			(gMySoundFX number: 2030 play: setLoop: -1)
		else
			(gMySoundFX number: 455 play: setLoop: -1)
		)
		(redThing hide:)
		(if (and (IsFlag 105) (IsFlag 107))
			(steam setCycle: Fwd)
			(blueThing setCycle: Fwd)
			(gears setCycle: Fwd)
		)
		(if (IsFlag 229)
			(redThing show:)
			(subEngineSet eachElementDo: #setCycle Fwd)
		)
		(engineLever init:)
		(super init: &rest)
	)

	(method (changeScene param1)
		(super changeScene: param1 &rest)
		(switch param1
			(210
				(subEngineSet
					add:
						blueThing
						gears
						engine
						yellowThing
						redThing
						bigGears
						steam
					eachElementDo: #init
				)
				(if (and (IsFlag 105) (IsFlag 107))
					(steam setCycle: Fwd)
					(blueThing setCycle: Fwd)
					(gears setCycle: Fwd)
				)
				(redThing hide:)
				(if (IsFlag 229)
					(redThing show:)
					(subEngineSet eachElementDo: #setCycle Fwd)
				)
				(engineLever init:)
				((ScriptID 1 2) newPic: 211) ; exitBack
			)
			(211
				(engineLever dispose:)
				(subEngineSet dispose:)
				((ScriptID 1 1) newRoom: 212) ; exitForward
				((ScriptID 1 2) newPic: 210) ; exitBack
			)
		)
	)
)

(instance subEngineSet of Set
	(properties)
)

(instance engineLever of Prop
	(properties
		x 307
		y 299
		view 2202
	)

	(method (cue)
		(if (IsFlag 229)
			(gCurRoom setScript: crankUpEngine)
			(self loop: 2)
			(subEngineSet
				add: blueThing gears engine yellowThing redThing bigGears steam
				eachElementDo: #init
				eachElementDo: #setCycle Fwd
			)
		else
			(subEngineSet eachElementDo: #setCycle 0)
			(if (and (IsFlag 105) (IsFlag 107))
				(blueThing setCycle: Fwd)
				(steam setCycle: Fwd)
				(gears setCycle: Fwd)
			)
			(gGame handsOn:)
		)
	)

	(method (init)
		(if (IsFlag 345)
			(= cel 24)
		else
			(= cel 0)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 5) ; Do
			(cond
				((IsFlag 229)
					(gGame handsOff:)
					(ClearFlag 229)
					(ClearFlag 345)
					(redThing hide:)
					(self loop: 0 cel: 12 setCycle: Beg self)
					(gMySoundFX fade:)
				)
				((and (IsFlag 105) (IsFlag 107))
					(SetFlag 345)
					(SetFlag 229)
					(gGame handsOff:)
					(self setCycle: End self setScript: soundScript)
				)
				(else
					(if (IsFlag 345)
						(gCurRoom setScript: begLoopLever)
					else
						(gCurRoom setScript: endLoopLever)
					)
					(gMySoundFX number: 2029 setLoop: 1 play:)
				)
			)
		)
	)
)

(instance begLoopLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(engineLever setCycle: Beg self)
			)
			(1
				(engineLever setCycle: End self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance endLoopLever of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(engineLever setCycle: End self)
			)
			(1
				(engineLever setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(rampUp number: 2029 setLoop: 1 play:)
				(= ticks 120)
			)
			(1
				(gMySoundFX number: 2030 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance crankUpEngine of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(subEngineSet
					add:
						blueThing
						gears
						engine
						yellowThing
						redThing
						bigGears
						steam
				)
				(redThing init: cycleSpeed: 8 setCycle: Fwd)
				(yellowThing init: cycleSpeed: 8 setCycle: Fwd)
				(= ticks 70)
			)
			(1
				(redThing cycleSpeed: 4)
				(yellowThing cycleSpeed: 4)
				(steam init: setCycle: Fwd)
				(gears init: cycleSpeed: 8 setCycle: Fwd)
				(bigGears init: cycleSpeed: 8 setCycle: Fwd)
				(= ticks 70)
			)
			(2
				(gears cycleSpeed: 4)
				(bigGears cycleSpeed: 4)
				(engine init: cycleSpeed: 8 setCycle: Fwd)
				(= ticks 70)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance blueThing of Prop
	(properties
		x 66
		y 299
		view 2203
	)
)

(instance gears of Prop
	(properties
		y 299
		loop 2
		view 2203
	)
)

(instance engine of Prop
	(properties
		x 193
		y 263
		loop 1
		view 2203
	)
)

(instance yellowThing of Prop
	(properties
		x 303
		y 208
		loop 5
		view 2203
	)
)

(instance redThing of Prop
	(properties
		x 326
		y 295
		loop 3
		view 2203
	)
)

(instance bigGears of Prop
	(properties
		x 379
		y 281
		loop 4
		view 2203
	)
)

(instance steam of Prop
	(properties
		x 40
		y 143
		loop 1
		view 2202
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== cel 7) (not (IsFlag 229)))
			(steamSnd play:)
		)
	)
)

(instance steamSnd of Sound
	(properties
		number 2037
		flags 1
	)
)

(instance rampUp of Sound
	(properties)
)

