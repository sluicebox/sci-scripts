;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 144)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Menu)
(use Actor)
(use System)

(public
	crawler 0
)

(local
	local0
)

(instance crawler of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(MenuBar state: 0)
				(if (< global189 10)
					(= global189 0)
				)
				(gEgo view: 59 cel: 0 cycleSpeed: 2 setCycle: End)
				(= cycles 10)
			)
			(1
				((= local0 (View new:))
					view: 58
					ignoreActors: 1
					x:
						(if (== (gEgo loop:) 0)
							(+ (gEgo x:) 14)
						else
							(- (gEgo x:) 14)
						)
					y:
						(if (== (gEgo loop:) 0)
							(- (gEgo y:) 5)
						else
							(+ (gEgo y:) 11)
						)
					setLoop: 4
					setCel: (gEgo loop:)
					setPri:
						(if (and (== gCurRoomNum 40) (== (gEgo priority:) 1))
							0
						else
							-1
						)
					init:
					stopUpd:
				)
				(gEgo view: 58 cycleSpeed: 1)
				(= cycles 2)
			)
			(2
				(gEgo
					setStep: 1 1
					moveSpeed: 1
					setCycle: Fwd
					setMotion:
						MoveTo
						(if (== (gEgo loop:) 0)
							(+ (gEgo x:) 30)
						else
							(- (gEgo x:) 30)
						)
						(gEgo y:)
				)
				(= cycles 30)
			)
			(3
				(gEgo setMotion: 0 setCel: 0 setLoop: (+ (gEgo loop:) 2))
				(= cycles 10)
			)
			(4
				(= temp0 (if (< (gEgo x:) 160) 19 else 93))
				(= temp1
					(cond
						((< (gEgo y:) 65) 17)
						((> (gEgo y:) 140) 117)
						(else
							(- (gEgo y:) 42)
						)
					)
				)
				(if global169
					((ScriptID 130 1) hide:) ; jabirHead
				)
				(if (== global189 10)
					(EgoDead 144 0) ; "Alas, you did not find water in time! You die as parched as a piece of old leather, and soon your bones will adorn the sands."
				else
					((ScriptID 130 0) ; Jabir
						view: 308
						setLoop: 0
						cel: 0
						ignoreActors: 1
						illegalBits: 0
						posn:
							(if (== (gEgo loop:) 2)
								(+ (gEgo x:) 37)
							else
								(gEgo x:)
							)
							(gEgo y:)
						init:
						cycleSpeed: 3
						setCycle: Fwd
					)
					(if (== gCurRoomNum 41)
						(Print 144 1 #at temp0 temp1 #width 200 #dispose) ; "Alas, your strength failed and you died at the very edge of the water you so desperately needed. Truly, there is no justice in life."
					else
						(Print 144 0 #at temp0 temp1 #width 200 #dispose) ; "Alas, you did not find water in time! You die as parched as a piece of old leather, and soon your bones will adorn the sands."
					)
					(= seconds 5)
				)
			)
			(5
				(if (== gCurRoomNum 41)
					(gMuleObj
						illegalBits: 0
						ignoreActors: 1
						posn: 67 137
						setScript: (ScriptID 41 1) ; muleDrinks
					)
				)
				(= seconds 2)
			)
			(6
				(clr)
				(= cycles 20)
			)
			(7
				(= temp1 (if (> ((ScriptID 130 0) y:) 100) 30 else 130)) ; Jabir
				(Print 144 2 #at -1 temp1 #dispose) ; "To add insult to injury, the scoundrel Jabir robs your corpse."
				(= seconds 4)
			)
			(8
				(clr)
				(EgoDead)
			)
		)
	)
)

