;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 278)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	forceGate 0
)

(instance forceGate of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 278)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 93 0) notify: 2) ; rm93
				((ScriptID 93 0) notify: 1) ; rm93
				(EgoGait 0 0) ; walking
				(gEgo setMotion: MoveTo 190 151 self)
			)
			(1
				(gEgo setLoop: 2)
				(HighPrint 278 0) ; "Well I'll huff, and I'll puff, and I'll smash the gate down."
				(= cycles 1)
			)
			(2
				(gEgo view: 550 setLoop: 0 setCel: 0 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(NormalEgo)
				(gEgo loop: 3 cel: 0)
				(= cycles 1)
			)
			(4
				(gEgo view: 5 setMotion: MoveTo 175 122 self)
			)
			(5
				(gEgo view: 523 setLoop: 0 setCel: 0 posn: 175 112)
				(= cycles 1)
			)
			(6
				(gEgo view: 523 setLoop: 0 setCel: 0 posn: 175 108)
				(= cycles 1)
			)
			(7
				(gEgo setCel: 1 posn: 175 104)
				(= cycles 1)
			)
			(8
				(gEgo setCel: 1 posn: 175 100)
				(= cycles 1)
			)
			(9
				(gEgo setCel: 2 setPri: 7 posn: 175 96)
				(= cycles 1)
			)
			(10
				(gEgo setCel: 2 setPri: 7 posn: 175 92)
				(= cycles 1)
			)
			(11
				(gEgo view: 538 setLoop: 0 setCel: 0 posn: 163 87)
				(= cycles 3)
			)
			(12
				(gEgo setCel: 1)
				(= cycles 3)
			)
			(13
				(gEgo setCel: 2 posn: 163 90)
				(= cycles 3)
			)
			(14
				(gEgo setCel: 3 posn: 163 93)
				(= cycles 3)
			)
			(15
				(gEgo setCel: 4 posn: 163 98)
				(= cycles 3)
			)
			(16
				(gEgo
					view: 503
					setLoop: 4
					setCel: -1
					cel: 0
					posn: 160 102
					cycleSpeed: 12
					setCycle: CT 3 1 self
				)
			)
			(17
				(gEgo setCel: -1 cel: 3 cycleSpeed: 2 setCycle: End self)
			)
			(18
				((ScriptID 93 0) notify: 0) ; rm93
				(HighPrint 278 1) ; "Boy that feels good."
				(if (TrySkill 0 60) ; strength
					((ScriptID 93 2) setScript: (ScriptID 93 3) self) ; gate, openGate
				else
					(self cue:)
				)
			)
			(19
				(HandsOff)
				(= seconds 3)
			)
			(20
				(gEgo posn: (+ (gEgo x:) 9) (gEgo y:) loop: 2)
				(= seconds 1)
			)
			(21
				(NormalEgo)
				(gEgo posn: (- (gEgo x:) 9) (+ (gEgo y:) 2))
				(if (IsFlag 238)
					(gEgo illegalBits: -32768)
				else
					(gEgo illegalBits: -28672)
				)
				((ScriptID 93 0) notify: 3) ; rm93
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

