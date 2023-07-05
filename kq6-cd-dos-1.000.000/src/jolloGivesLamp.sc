;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 751)
(include sci.sh)
(use Main)
(use rm750)
(use DPath)
(use Grooper)
(use Motion)
(use Actor)
(use System)

(public
	jolloGivesLamp 0
)

(local
	[local0 49] = [0 239 135 2 1 233 136 2 2 229 137 2 3 225 137 2 4 223 138 10 5 218 138 10 -1 -1 -1 -1 6 220 138 2 7 224 136 2 8 230 138 2 9 237 138 2 10 241 137 2 -1]
)

(instance jolloGivesLamp of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(UnLoad 128 717)
		(UnLoad 128 754)
		(DisposeScript 964)
		(DisposeScript 1020)
		(DisposeScript 751)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 750 6) setScript: 0 setCycle: 0 addToPic:) ; cassima
				((ScriptID 750 4) addToPic:) ; genie
				(= cycles 2)
			)
			(1
				(jollo
					init:
					view: 717
					setPri: 2
					setLoop: 3
					setLoop: Grooper
					posn: 294 198
					setStep: 5 3
					setSpeed: 3
					setScale:
					scaleX: 110
					scaleY: 110
					setCycle: Walk
					setMotion: DPath 281 178 263 150 self
				)
			)
			(2
				(jollo
					view: 754
					setLoop: -1
					scaleX: 94
					scaleY: 94
					loop: 1
					cel: 0
					posn: 247 150
					setCycle: End self
				)
			)
			(3
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo normal: 0 view: 7500 setLoop: 3 setCycle: 0 looper: 0)
				(= cycles 2)
			)
			(4
				(gMessager say: 1 0 3 1 self) ; "(WHISPERING EAGERLY TO ALEXANDER) Prince Alexander, I did it! I swapped the lamps! Here, quick, take it!"
			)
			(5
				(jollo loop: 2 cel: 0 posn: 239 135)
				(= ticks 10)
			)
			(6
				(if (!= [local0 register] -1)
					(-- state)
					(jollo
						cel: [local0 register]
						x: [local0 (+ register 1)]
						y: [local0 (+ register 2)]
						priority: [local0 (+ register 3)]
					)
				)
				(+= register 4)
				(= cycles 5)
			)
			(7
				(gEgo get: 25) ; newLamp
				(gGame givePoints: 1)
				((gInventory at: 25) message: 92 noun: 66) ; newLamp
				(gGame handsOff:)
				(gEgo
					setScale: 0
					normal: 0
					view: 703
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 1 1 self
				)
			)
			(8
				(gMessager say: 1 0 3 2 self oneOnly: 0) ; "Bless you, Jollo! I knew you could do it! Now get clear, friend!"
			)
			(9
				(gEgo setCycle: End)
				(= ticks 3)
			)
			(10
				(if (!= [local0 register] -1)
					(-- state)
					(jollo
						cel: [local0 register]
						x: [local0 (+ register 1)]
						y: [local0 (+ register 2)]
						priority: [local0 (+ register 3)]
					)
				)
				(+= register 4)
				(= cycles 5)
			)
			(11
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
				)
				(gEgo
					normal: 0
					view: 7500
					setLoop: 3
					setCycle: 0
					looper: 0
					scaleSignal: 1
					scaleX: 96
					scaleY: 96
				)
				(jollo
					view: 717
					setLoop: 2
					setLoop: Grooper
					posn: 250 135
					scaleX: 110
					scaleY: 110
					setSpeed: 3
					setCycle: Walk
					setMotion: DPath 275 157 286 189 self
				)
			)
			(12
				(jollo dispose:)
				(if global169
					(gCurRoom drawPic: 750 15)
				else
					(gCurRoom drawPic: 750 100)
				)
				((ScriptID 750 9) addToPic:) ; sword
				((ScriptID 750 6) ; cassima
					setScript: (ScriptID 750 8) ; tiedUpRightNow
					signal: 16384
					init:
				)
				((ScriptID 750 3) addToPic:) ; vizier
				((ScriptID 750 4) signal: 16384 init:) ; genie
				(= cycles 2)
			)
			(13
				(proc750_5)
				(self dispose:)
			)
		)
	)
)

(instance jollo of Actor
	(properties
		x 274
		y 197
		view 754
		signal 16384
	)
)

