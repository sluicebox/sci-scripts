;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use n814)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	painReaction 0
)

(local
	local0
	[local1 3]
)

(instance painReaction of Script
	(properties)

	(method (init)
		(sEgoHurt init:)
		(thatsIt init:)
		(= local0 (ScriptID 213 0)) ; warrior
		(egoBlood init: ignoreActors: setPri: (- (local0 priority:) 1))
		(super init: &rest)
	)

	(method (dispose)
		(sEgoHurt dispose:)
		(thatsIt dispose:)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not ((local0 opponent:) script:))
					((local0 opponent:) setCycle: 0)
					((local0 opponent:) setScript: (ScriptID global279 2))
				)
				(= global245 0)
				(= ticks 1)
			)
			(1
				(sEgoHurt play:)
				(if (gEgo has: 2) ; sword
					(local0 view: 113 forceUpd:)
				else
					(local0 view: 106 forceUpd:)
				)
				(local0 setPri: -1 setLoop: 0 setCel: 0)
				(egoBlood setCel: 0)
				(= ticks 8)
			)
			(2
				(local0 setCel: 1)
				(cond
					(((local0 opponent:) lowBlow:)
						(egoBlood
							posn: (local0 x:) (- (local0 y:) 27)
							setCycle: End
						)
					)
					((gEgo has: 2) ; sword
						(egoBlood
							posn: (+ (local0 x:) 1) (- (local0 y:) 48)
							setCycle: End
						)
					)
					(else
						(egoBlood
							posn: (+ (local0 x:) 4) (- (local0 y:) 48)
							setCycle: End
						)
					)
				)
				(= ticks 5)
			)
			(3
				(local0 cycleSpeed: 10 setCycle: End self)
			)
			(4
				(local0 cycleSpeed: 3 setLoop: 0 setCel: 0)
				(= ticks 30)
			)
			(5
				(= global245 1)
				(local0 canFight: 1)
				(local0 setEgoHP: (local0 health:))
				(if (or (IsFlag 248) (<= (local0 health:) 0))
					(thatsIt play:)
					(Animate (gCast elements:) 0)
					(gGame setCursor: gNormalCursor 1)
					(EgoDead 11 12) ; "It was a tough battle, and you lost. Never fear! All you have to do is restore your game, and... What do you mean, "Restore WHAT game?""
				)
				(egoBlood dispose:)
				(if (gEgo has: 2) ; sword
					(local0 view: 109)
				else
					(local0 view: 102)
				)
				(self dispose:)
			)
		)
	)
)

(instance egoBlood of Prop
	(properties
		x 500
		y 500
		view 535
		cycleSpeed 0
	)
)

(instance sEgoHurt of Sound
	(properties
		flags -1
		number 104
		priority 1
	)
)

(instance thatsIt of Sound
	(properties
		flags -1
		number 105
		priority 1
	)
)

