;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 223)
(include sci.sh)
(use Main)
(use Scaler)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	slaveWomenScr 0
)

(local
	[local0 4]
	local4
)

(instance slave1 of Actor
	(properties
		x 137
		y 124
		noun 7
		view 225
		signal 18432
	)

	(method (cue)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk)
	)
)

(instance slave2 of Actor
	(properties
		x 152
		y 132
		noun 7
		view 225
		loop 1
		signal 18432
	)

	(method (cue)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk)
	)
)

(instance slave3 of Actor
	(properties
		x 165
		y 143
		noun 7
		view 225
		loop 3
		signal 18432
	)

	(method (cue)
		(self dispose:)
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk)
	)
)

(instance slave4 of Actor
	(properties
		x 179
		y 151
		noun 7
		view 225
		loop 2
		signal 18432
	)

	(method (init)
		(super init: &rest)
		(self setCycle: Walk)
	)
)

(instance slaveWomenScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local4 (if (== gAct 3) 3 else 4))
				(= [local0 0] (slave1 init: yourself:))
				(= [local0 1] (slave2 init: yourself:))
				(= [local0 2] (slave3 init: yourself:))
				(= [local0 3] (slave4 init: yourself:))
				(= cycles 3)
			)
			(1
				(gMessager say: 1 0 local4 1 self)
			)
			(2
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					([local0 temp0]
						setMotion:
							MoveTo
							(- ([local0 temp0] x:) 19)
							(- ([local0 temp0] y:) 11)
							(if (== temp0 3) self else 0)
					)
				)
			)
			(3
				(if (== gAct 5)
					(gMessager say: 1 0 local4 2 self)
				else
					(self cue:)
				)
			)
			(4
				(if (== gAct 3)
					((ScriptID 220 4) ; guard2
						view: 725
						setLoop: 1
						setCycle: Rev
						setMotion:
							MoveTo
							(+ ((ScriptID 220 4) x:) 10) ; guard2
							((ScriptID 220 4) y:) ; guard2
							self
					)
				else
					(self cue:)
				)
			)
			(5
				(if (== gAct 3)
					((ScriptID 220 4) setCycle: 0 setLoop: -1) ; guard2
					(self setScript: (ScriptID 220 1) self 1) ; guardOpenDoorScr
				else
					(self setScript: (ScriptID 220 7) self) ; secondGuardDoorScr
				)
			)
			(6
				((ScriptID 220 3) setPri: 7) ; guard1
				((ScriptID 220 4) setPri: 4) ; guard2
				(for ((= temp0 0)) (< temp0 4) ((++ temp0))
					([local0 temp0] setPri: 5)
				)
				(gMessager say: 1 0 local4 (if (== gAct 3) 2 else 3) self)
			)
			(7
				(gMessager say: 1 0 local4 (if (== gAct 3) 3 else 4) self)
			)
			(8
				((ScriptID 220 4) stopUpd:) ; guard2
				([local0 0] setMotion: MoveTo 104 94 self)
				([local0 1]
					setMotion: MoveTo ([local0 0] x:) ([local0 0] y:) self
				)
				([local0 2]
					setMotion: MoveTo ([local0 1] x:) ([local0 1] y:) self
				)
				([local0 3]
					setMotion: MoveTo ([local0 2] x:) ([local0 2] y:) self
				)
			)
			(9 0)
			(10 0)
			(11 0)
			(12
				([local0 0]
					setPri: 2
					setScale: Scaler 64 94 103 95
					setMotion: MoveTo 75 100 [local0 0]
				)
				([local0 1] setMotion: MoveTo 104 94 self)
				([local0 2]
					setMotion: MoveTo ([local0 1] x:) ([local0 1] y:) self
				)
				([local0 3]
					setMotion: MoveTo ([local0 2] x:) ([local0 2] y:) self
				)
			)
			(13 0)
			(14 0)
			(15
				([local0 1]
					setPri: 2
					setScale: Scaler 64 94 103 95
					setMotion: MoveTo 75 100 [local0 1]
				)
				([local0 2] setMotion: MoveTo 104 94 self)
				([local0 3]
					setMotion: MoveTo ([local0 2] x:) ([local0 2] y:) self
				)
			)
			(16 0)
			(17
				([local0 2]
					setPri: 2
					setScale: Scaler 64 94 103 95
					setMotion: MoveTo 75 100 [local0 2]
				)
				([local0 3] setMotion: MoveTo 104 94 self)
			)
			(18
				([local0 3]
					setPri: 2
					setScale: Scaler 64 94 103 95
					setMotion: MoveTo 75 100 self
				)
			)
			(19
				([local0 3] dispose:)
				(= cycles 2)
			)
			(20
				(if (== gAct 3)
					((ScriptID 220 4) ; guard2
						setCycle: Walk
						setMotion:
							MoveTo
							(- ((ScriptID 220 4) x:) 10) ; guard2
							((ScriptID 220 4) y:) ; guard2
					)
				)
				((ScriptID 220 3) setPri: -1) ; guard1
				((ScriptID 220 4) setPri: -1) ; guard2
				(script cue:)
			)
			(21
				(if (== gAct 3)
					((ScriptID 220 4) ; guard2
						view: 224
						setLoop: -1
						loop: 1
						cel: 0
						posn: 139 109
					)
					(= cycles 2)
				else
					(self cue:)
				)
			)
			(22
				(if (== gAct 3)
					(gMessager say: 1 0 local4 4 self)
				else
					(self cue:)
				)
			)
			(23
				(gMessager say: 1 0 local4 5 self)
			)
			(24
				((ScriptID 220 3) stopUpd:) ; guard1
				((ScriptID 220 4) stopUpd:) ; guard2
				((ScriptID 220 5) stopUpd:) ; castleDoor
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 223)
	)
)

