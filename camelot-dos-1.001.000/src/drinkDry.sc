;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 175)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	drinkDry 0
	poisoned 1
)

(local
	local0
)

(instance drinkDry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((gEgo inRect: 163 0 319 73)
						(Print 175 0) ; "There is no water behind the rocks."
						(HandsOn)
						(client setScript: 0)
					)
					((> (gEgo y:) 106)
						(gEgo setMotion: MoveTo 115 (gEgo y:) self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(if (!= (gEgo x:) 115)
					(gEgo setMotion: MoveTo 115 (gEgo y:) self)
				else
					(self cue:)
				)
			)
			(2
				(if (!= (gEgo y:) 108)
					(gEgo setMotion: MoveTo 115 108 self)
				else
					(self cue:)
				)
			)
			(3
				(gEgo
					view: 42
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(4
				((= local0 (Prop new:))
					view: 42
					ignoreActors: 1
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 2)
					setLoop: 2
					cel: 0
					init:
					cycleSpeed: 2
					setCycle: Fwd
				)
				(gEgo setLoop: 1 cel: 0 cycleSpeed: 2 setCycle: Fwd)
				(= cycles 24)
			)
			(5
				(local0 dispose:)
				(gEgo setLoop: 0 cel: 2 setCycle: 0)
				(= cycles 3)
			)
			(6
				(gEgo cycleSpeed: 1 setCycle: Beg self)
			)
			(7
				(gEgo view: 0 setLoop: 2 cel: 0 cycleSpeed: 0 setCycle: Walk)
				(= cycles 10)
			)
			(8
				(gEgo setLoop: -1 setMotion: MoveTo 115 90 self)
			)
			(9
				(gEgo setMotion: MoveTo 115 92 self)
			)
			(10
				(gEgo setScript: poisoned)
			)
		)
	)
)

(instance poisoned of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 42
					setLoop: 4
					cel: 1
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gEgo setCycle: CT 1 -1 self)
			)
			(2
				(Print 175 1 #at -1 130) ; "Arthur! Something terrible is happening to you."
				(gEgo setLoop: 3 cel: 1 setCycle: End self)
			)
			(3
				(gEgo setLoop: 5 cel: 0 cycleSpeed: 1 setCycle: End self)
			)
			(4
				(= cycles 10)
			)
			(5
				(if global169
					((ScriptID 130 1) dispose:) ; jabirHead
					((ScriptID 130 0) ; Jabir
						view: 308
						setLoop: 0
						cel: 0
						posn: 157 94
						init:
						cycleSpeed: 3
						setCycle: Fwd
					)
				)
				(Print 175 2 #at -1 (- (gEgo y:) 55) #dispose) ; "Too late the signs are clear. This water is poisoned. It killed the camel who had not the sense of your mule. But then, neither did you."
				(= seconds 7)
			)
			(6
				(if global169
					(clr)
					(= cycles 20)
				else
					(self changeState: 8)
				)
			)
			(7
				(Print 175 3 #at -1 130 #dispose) ; "To add insult to injury, the scoundrel Jabir robs your corpse."
				(= seconds 4)
			)
			(8
				(clr)
				(EgoDead)
			)
		)
	)
)

