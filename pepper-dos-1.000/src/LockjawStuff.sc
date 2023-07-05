;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 838)
(include sci.sh)
(use Main)
(use CycleBet)
(use ForwardCounter)
(use Sound)
(use Motion)
(use System)

(public
	LockjawStuff 0
)

(local
	local0
	local1
)

(instance LockjawStuff of Script
	(properties)

	(method (doit)
		(cond
			((== ((ScriptID 895 1) normal:) 99) ; lockjaw
				((ScriptID 895 1) view: 1838 normal: 0) ; lockjaw
				(UnLoad 128 807)
				(UnLoad 128 831)
				(UnLoad 128 838)
				(= register 1)
				(= state 7)
			)
			((== ((ScriptID 895 1) normal:) 2) ; lockjaw
				((ScriptID 895 1) normal: 1) ; lockjaw
				(= seconds (= cycles (= ticks 0)))
				(self init:)
			)
			((and (not register) (!= state 3) (not ((ScriptID 895 1) normal:))) ; lockjaw
				(= state 2)
				(= seconds (= cycles (= ticks 0)))
				(= register 1)
				((ScriptID 895 1) setSpeed: global197) ; lockjaw
				(sfx setLoop: 1 stop:)
				(self cue:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (not ((ScriptID 895 1) normal:)) ; lockjaw
					(= state 2)
					(self cue:)
				else
					((ScriptID 895 1) ; lockjaw
						normalize:
						ignoreActors: 1
						setLoop: -1
						setHeading: 225 self
					)
				)
			)
			(1
				(if (not ((ScriptID 895 1) normal:)) ; lockjaw
					(= state 2)
					(self cue:)
				else
					((ScriptID 895 1) setCycle: 0 cel: 5 setLoop: 8) ; lockjaw
					(= ticks 30)
				)
			)
			(2
				(if ((ScriptID 895 1) normal:) ; lockjaw
					((ScriptID 895 1) ; lockjaw
						view: 838
						setLoop: 1
						cel: 0
						cycleSpeed: 6
						setCycle: End self
					)
					(UnLoad 128 807)
				else
					(= cycles 2)
				)
			)
			(3
				(sfx stop:)
				(if (OneOf ((ScriptID 895 1) view:) 838 831) ; lockjaw
					((ScriptID 895 1) ; lockjaw
						view: 838
						setLoop: 1
						cel: 2
						setCycle: 0
						forceUpd:
						stopUpd:
					)
				)
				(if register
					(-- state)
					(= register 0)
				)
				(= cycles 2)
			)
			(4
				(sfx stop:)
				(= register 0)
				(if (not (Random 0 1))
					(= local1 838)
					(UnLoad 128 831)
					(if (== 1 (= local0 (Random 0 2)))
						(-- state)
						(= cycles 2)
					else
						(= seconds (Random 6 15))
					)
				else
					(= local1 831)
					(UnLoad 128 838)
					(= local0 (Random 0 3))
					(= seconds (Random 6 15))
				)
			)
			(5
				(cond
					(register
						((ScriptID 895 1) setLoop: -1) ; lockjaw
						(= cycles (= state 2))
					)
					((not (OneOf ((ScriptID 895 1) view:) 831 838)) ; lockjaw
						(self init:)
					)
					((== local1 838)
						(switch local0
							(0
								(sfx number: 3800 setLoop: 1 play: self)
								(= state 2)
								((ScriptID 895 1) ; lockjaw
									view: local1
									setLoop: local0
									cel: 0
									cycleSpeed: 6
									setCycle: Fwd
								)
							)
							(2
								(sfx number: 4104 setLoop: 1 play: self)
								(= state 2)
								((ScriptID 895 1) ; lockjaw
									view: local1
									setLoop: local0
									cel: 0
									cycleSpeed: 3
									setCycle: CycleBet 1 2 5
								)
							)
						)
					)
					(else
						(switch local0
							(0
								(sfx number: 2901 setLoop: -1 play:)
								((ScriptID 895 1) ; lockjaw
									view: local1
									setLoop: local0
									cel: 0
									cycleSpeed: 5
									setCycle: End self
								)
							)
							(1
								(sfx number: 909 setLoop: 1 play: self)
								(= state 2)
								((ScriptID 895 1) ; lockjaw
									view: local1
									setLoop: local0
									cycleSpeed: 6
									setCycle: Fwd
								)
							)
							(2
								(sfx number: 911 setLoop: 1 play: self)
								(= state 2)
								((ScriptID 895 1) ; lockjaw
									view: local1
									setLoop: local0
									cycleSpeed: 6
									setCycle: ForwardCounter 3
								)
							)
							(3
								(= state 2)
								(sfx number: 911 setLoop: 1 play: self)
								((ScriptID 895 1) ; lockjaw
									view: local1
									setLoop: local0
									cel: 0
									cycleSpeed: 4
									setCycle: CycleBet 3 5 5
								)
							)
						)
					)
				)
			)
			(6
				(= state 2)
				(sfx number: 940 setLoop: 1 play: self)
			)
			(7 0)
		)
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

