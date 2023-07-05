;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use dummyClient)
(use HandsOffScript)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm290 0
)

(local
	local0 = -1
	local1 = -1
)

(instance rm290 of Rm
	(properties
		noun 1
		picture 290
		north 300
		south 280
	)

	(method (init)
		(Load rsVIEW 294)
		(LoadMany rsSOUND 14 20 127 181 182 183)
		(fFootScale init:)
		(fFeetOnScale init:)
		(fElevator init:)
		(fMusic init:)
		(fKitchenScale init:)
		(fTipOMeter init:)
		(fRollerCoaster init:)
		(fElevatorDisplay init:)
		(fClock init:)
		(fElevatorButtons init:)
		(fFluidDispenser init:)
		(fFountainCups init:)
		(fWeightPicture init:)
		(fManometer init:)
		(fCounterWeight init:)
		(fFunnel init:)
		(fBathScale init:)
		(pElevatorScale init:)
		(pManSneezing init: stopUpd:)
		(pRollerCoaster init: stopUpd:)
		(pFish init: stopUpd:)
		(if (not (IsFlag 51))
			(aElevatorDoor1 init:)
			(aElevatorDoor2 init:)
		)
		(gCMusic number: 14 play: setVol: 0 setLoop: -1 fade: 127 10 10 0)
		(super init: &rest)
		(self setScript: elevatorScaleBoing)
	)

	(method (dispose)
		(musicScale dispose:)
		(scaleTicks dispose:)
		(if (IsObject (ScriptID 293 0)) ; weightsPuzzle
			((ScriptID 293 0) dispose:) ; weightsPuzzle
		)
		(if (IsObject (ScriptID 291 0)) ; gearsPuzzle
			((ScriptID 291 0) dispose:) ; gearsPuzzle
		)
		(DisposeScript 293)
		(DisposeScript 291)
		(super dispose: &rest)
	)
)

(instance rollThatCoaster of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSoundFX number: 182 setLoop: -1 play: setVol: 127)
				(pRollerCoaster startUpd: cycleSpeed: 10 setCycle: End self)
			)
			(1
				(= ticks (* (pRollerCoaster cycleSpeed:) 6))
			)
			(2
				(pRollerCoaster
					loop: 3
					cel: 0
					x: 0
					y: 20
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(3
				(pRollerCoaster loop: 2 cel: 0 x: 1 y: 19)
				(= cycles 1)
			)
			(4
				(pRollerCoaster stopUpd:)
				(gCSoundFX stop:)
				(self dispose:)
			)
		)
	)
)

(instance manSneezing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: (fWeightPicture noun:) 4 0 1 self)
			)
			(1
				(gCSoundFX number: 181 setLoop: 0 play:)
				(pManSneezing startUpd: setCycle: End self)
			)
			(2
				(pManSneezing stopUpd:)
				(gMessager say: (fWeightPicture noun:) 4 0 2 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance fishJumping of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pFish startUpd: setCycle: Rev)
				(= ticks (* (pFish cycleSpeed:) (NumCels pFish) 2))
			)
			(1
				(pFish setCycle: 0 cel: 0)
				(= cycles 1)
			)
			(2
				(pFish stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance elevatorScaleBoing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(pElevatorScale setScript: scaleTicking setCycle: End self)
			)
			(2
				(pElevatorScale setScript: 0)
				(gCSoundFX number: 183 setLoop: 0 play: 127)
				(pElevatorScale stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance scaleTicking of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scaleTicks number: 104 setLoop: 0 play: 127)
				(= ticks 10)
			)
			(1
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance musicScaling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCMusic setVol: 100)
				(musicScale number: 20 setLoop: 0 play: 127 self)
			)
			(1
				(gCMusic setVol: 127)
				(self dispose:)
			)
		)
	)
)

(instance openElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gCSoundFX number: 263 setLoop: 0 play: 127)
				(aElevatorDoor1 setMotion: MoveTo 30 36 self)
				(aElevatorDoor2 setMotion: MoveTo 153 36)
			)
			(2
				(aElevatorDoor1 dispose:)
				(aElevatorDoor2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance fFootScale of Feature
	(properties
		noun 6
		nsTop 140
		nsLeft 65
		nsBottom 180
		nsRight 239
		onMeCheck 1
	)
)

(instance fFeetOnScale of Feature
	(properties
		noun 29
		onMeCheck 16
	)
)

(instance fElevator of Feature
	(properties
		noun 25
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(if (and (== theVerb 4) (IsFlag 8) (IsFlag 5))
			(gCurRoom newRoom: (rm290 north:))
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fMusic of Feature
	(properties
		noun 5
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(gCurRoom setScript: musicScaling)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fKitchenScale of Feature
	(properties
		noun 2
		onMeCheck 8
	)
)

(instance fRollerCoaster of Feature
	(properties
		noun 12
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(pRollerCoaster doVerb: theVerb &rest)
	)
)

(instance fElevatorDisplay of Feature
	(properties
		noun 24
		onMeCheck 64
	)
)

(instance fClock of Feature
	(properties
		noun 8
		onMeCheck 128
	)
)

(instance fElevatorButtons of Feature
	(properties
		noun 21
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not (IsFlag 5))
					(gMessager say: noun 4 5 0) ; "Hmmm. Something is wrong with Dr. Brain's elevator counterweight. His elevator counterweight is made from the largest bucket you've ever seen. What could be wrong with his counterweight (huge bucket)?"
					(return)
				)
				(cond
					(
						(or
							(< local1 0)
							(not (IsObject (ScriptID 291 0))) ; gearsPuzzle
							(not ((ScriptID 291 0) inited:)) ; gearsPuzzle
						)
						((ScriptID 291 0) init:) ; gearsPuzzle
						(= local1 global114)
					)
					((!= local1 global114)
						((ScriptID 291 0) dispose: init:) ; gearsPuzzle
						(= local1 global114)
					)
				)
				(switch ((ScriptID 291 0) show:) ; gearsPuzzle
					(1
						(if (not (IsFlag 51))
							(gCurRoom setScript: openElevator)
							(SetFlag 51)
						)
						((ScriptID 291 0) dispose:) ; gearsPuzzle
					)
					(2
						(gMessager say: 13 40 0 0) ; "Oops! You broke Dr. Brain's crash test dummy! Well, don't feel too bad, he has some spare dummies around for just this reason. Please try to open his elevator again."
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fFluidDispenser of Feature
	(properties
		noun 15
		onMeCheck 512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(cond
					(
						(or
							(< local0 0)
							(not (IsObject (ScriptID 293 0))) ; weightsPuzzle
							(not ((ScriptID 293 0) inited:)) ; weightsPuzzle
						)
						((ScriptID 293 0) init:) ; weightsPuzzle
						(= local0 global114)
					)
					((!= local0 global114)
						((ScriptID 293 0) dispose: init:) ; weightsPuzzle
						(= local0 global114)
					)
				)
				(switch ((ScriptID 293 0) show:) ; weightsPuzzle
					(1
						((ScriptID 293 0) dispose:) ; weightsPuzzle
					)
					(0 0)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fFountainCups of Feature
	(properties
		noun 10
		onMeCheck 1024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(fFluidDispenser doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fWeightPicture of Feature
	(properties
		noun 11
		onMeCheck 2048
	)

	(method (doVerb theVerb)
		(pManSneezing doVerb: theVerb &rest)
	)
)

(instance fManometer of Feature
	(properties
		noun 22
		onMeCheck 4096
	)
)

(instance fCounterWeight of Feature
	(properties
		noun 23
		onMeCheck 8192
	)
)

(instance fFunnel of Feature
	(properties
		noun 16
		onMeCheck 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(fFluidDispenser doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fBathScale of Feature
	(properties
		noun 3
		onMeCheck -32768
	)
)

(instance fTipOMeter of Feature
	(properties
		noun 28
		nsTop 47
		nsLeft 195
		nsBottom 60
		nsRight 215
		onMeCheck 32
	)
)

(instance pElevatorScale of Prop
	(properties
		x 82
		y 4
		noun 24
		view 294
		loop 1
		signal 18434
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(fElevatorDisplay doVerb: theVerb &rest)
	)
)

(instance pManSneezing of Prop
	(properties
		x 239
		y 27
		noun 11
		view 294
		signal 18434
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (== (self cel:) 0)
					(self setScript: manSneezing)
				else
					(gMessager say: noun theVerb 6 0) ; "Did he get any on your screen?"
				)
			)
			(1
				(if (!= (self cel:) 0)
					(gMessager say: noun theVerb 6 0) ; "He looks a little disheartened, huh?"
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pRollerCoaster of Prop
	(properties
		x 1
		y 19
		noun 12
		view 294
		loop 2
		priority 11
		signal 18450
		cycleSpeed 12
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not script)
					(self setScript: rollThatCoaster)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pFish of Prop
	(properties
		x 43
		y 39
		noun 4
		view 294
		loop 4
		priority 11
		signal 18450
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4
				(if (not script)
					(self setScript: fishJumping)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance aElevatorDoor1 of Actor
	(properties
		x 72
		y 36
		noun 25
		view 294
		loop 5
		priority 1
		signal 18449
	)
)

(instance aElevatorDoor2 of Actor
	(properties
		x 112
		y 36
		noun 25
		view 294
		loop 5
		cel 1
		priority 1
		signal 18449
	)
)

(instance musicScale of Sound
	(properties)
)

(instance scaleTicks of Sound
	(properties)
)

