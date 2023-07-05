;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 601)
(include sci.sh)
(use Main)
(use DPath)
(use Motion)
(use System)

(public
	spadeScript 0
	clubScript 1
	heartScript 2
	diamondScript 3
)

(local
	local0
)

(instance spadeScript of Script
	(properties)

	(method (doit)
		(if (and (> 5 state 0) (not (client cycler:)))
			(client setLoop: 4 cycleSpeed: 0 setCycle: Fwd)
		)
		(if (and (== local0 3) (< state 3))
			(self changeState: 3)
		)
		(if (== state 7)
			(switch (gCurRoom picture:)
				(901
					(Palette palANIMATE 49 64 -1)
				)
				(902
					(Palette palANIMATE 49 64 -1)
				)
				(903
					(Palette palANIMATE 17 24 -1)
				)
				(904
					(Palette palANIMATE 0 224 -1)
				)
				(905
					(Palette palANIMATE 25 26 -1 145 152 -1 209 212 -1)
				)
				(906
					(Palette palANIMATE 65 80 -1)
				)
				(907
					(Palette palANIMATE 0 208 -1)
				)
				(909
					(Palette palANIMATE 4 224 -1)
				)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client
					view: 602
					cel: 0
					setStep: 20 14
					moveSpeed: 0
					ignoreActors:
					setCycle: End
					setMotion:
						DPath
						319
						117
						150
						199
						175
						1
						319
						75
						180
						199
						30
						1
						1
						100
						self
				)
			)
			(2
				(= state 1)
				(client
					setLoop: 4
					setMotion:
						DPath
						319
						117
						150
						199
						175
						1
						319
						75
						180
						199
						30
						1
						1
						100
						self
				)
			)
			(3
				(= ticks 25)
			)
			(4
				(client setLoop: 4 setMotion: MoveTo 100 130 self)
			)
			(5
				(client cel: 0 setLoop: 9 cycleSpeed: 8 setCycle: End self)
			)
			(6
				(proc0_1)
				(ShakeScreen 4 ssLEFTRIGHT)
				(= ticks 60)
			)
			(7
				(client hide: forceUpd:)
				(if
					(or
						(== (gCurRoom picture:) 907)
						(== (gCurRoom picture:) 909)
						(== (gCurRoom picture:) 904)
					)
					(= ticks 700)
				else
					(= ticks 350)
				)
			)
			(8
				(if (== (++ local0) 4)
					(= local0 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

(instance clubScript of Script
	(properties)

	(method (doit)
		(if (and (> 5 state 0) (not (client cycler:)))
			(client setLoop: 5 cycleSpeed: 0 setCycle: Fwd)
		)
		(if (and (== local0 2) (< state 3))
			(self changeState: 3)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client
					view: 602
					cel: 0
					moveSpeed: 0
					setStep: 20 14
					setCycle: End
					ignoreActors:
					setMotion:
						DPath
						80
						199
						100
						1
						120
						199
						319
						120
						150
						199
						1
						1
						240
						199
						200
						1
						170
						199
						140
						1
						self
				)
			)
			(2
				(= state 1)
				(client
					setLoop: 5
					setMotion:
						DPath
						80
						199
						100
						1
						120
						199
						319
						120
						150
						199
						1
						1
						240
						199
						200
						1
						170
						199
						140
						1
						self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(client setLoop: 5 setMotion: MoveTo 130 70 self)
			)
			(5
				(client cel: 0 setLoop: 9 cycleSpeed: 8 setCycle: End self)
			)
			(6
				(ShakeScreen 1)
				(if (== (++ local0) 4)
					(= local0 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

(instance heartScript of Script
	(properties)

	(method (doit)
		(if (and (> 5 state 0) (not (client cycler:)))
			(client setLoop: 6 cycleSpeed: 0 setCycle: Fwd)
		)
		(if (and (== local0 1) (< state 3))
			(self changeState: 3)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client
					view: 602
					cel: 0
					moveSpeed: 0
					setStep: 20 14
					setCycle: End
					ignoreActors:
					setMotion:
						DPath
						319
						20
						1
						40
						319
						60
						1
						80
						319
						100
						1
						120
						319
						140
						1
						160
						150
						1
						319
						199
						1
						100
						self
				)
			)
			(2
				(= state 1)
				(client
					setLoop: 6
					setMotion:
						DPath
						319
						20
						1
						40
						319
						60
						1
						80
						319
						100
						1
						120
						319
						140
						1
						160
						150
						1
						319
						199
						1
						100
						self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(client setLoop: 6 setMotion: MoveTo 200 70 self)
			)
			(5
				(client cel: 0 setLoop: 8 cycleSpeed: 8 setCycle: End self)
			)
			(6
				(ShakeScreen 1)
				(if (== (++ local0) 4)
					(= local0 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

(instance diamondScript of Script
	(properties)

	(method (doit)
		(if (and (> 4 state 0) (not (client cycler:)))
			(client setLoop: 7 cycleSpeed: 0 setCycle: Fwd)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register 0)
				(client setCycle: End self)
			)
			(1
				(client
					view: 602
					cel: 0
					moveSpeed: 0
					setStep: 20 14
					ignoreActors:
					setCycle: End
					setMotion:
						DPath
						280
						1
						319
						40
						40
						199
						280
						1
						40
						1
						1
						50
						280
						199
						319
						150
						self
				)
			)
			(2
				(if register
					(= state 1)
				)
				(++ register)
				(client
					setLoop: 7
					setMotion:
						DPath
						280
						1
						319
						40
						40
						199
						280
						1
						40
						1
						1
						50
						280
						199
						319
						150
						self
				)
			)
			(3
				(client setLoop: 7 setMotion: MoveTo 230 145 self)
			)
			(4
				(client cel: 0 setLoop: 8 cycleSpeed: 8 setCycle: End self)
			)
			(5
				(ShakeScreen 1)
				(if (== (++ local0) 4)
					(= local0 0)
					((ScriptID 600 3) cue:) ; roomScript
				)
				(client dispose:)
			)
		)
	)
)

