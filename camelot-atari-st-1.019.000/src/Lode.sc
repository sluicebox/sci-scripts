;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 118)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	Lode 0
)

(local
	local0
	local1
	local2
)

(instance LodeBox of View
	(properties
		y 35
		x 265
		view 504
		priority 15
		signal 16
	)
)

(instance LodeStone of Prop
	(properties
		y 35
		x 265
		view 504
		loop 1
		priority 15
		signal 16
	)
)

(instance Lode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (User controls:))
				(= local2 (User canInput:))
				(= local0 global80)
				(HandsOff)
				(LodeBox setLoop: 0 init:)
				(LodeStone
					setLoop: 1
					cel: 0
					init:
					setCycle:
						CT
						(switch global112
							(1 7)
							(2 11)
							(3 15)
							(else 0)
						)
						1
						self
				)
			)
			(1
				(switch global112
					(0
						(LodeStone cel: 0 setCycle: CT 3 1 self)
					)
					(4
						(LodeStone cel: 0 setCycle: CT 1 1 self)
					)
					(5
						(LodeStone cel: 0 setCycle: CT 5 1 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(LodeStone
					setCycle:
						CT
						(switch global112
							(1 2)
							(2 6)
							(3 10)
							(0 14)
							(4 12)
							(else 0)
						)
						-1
						self
				)
			)
			(3
				(LodeStone
					setCycle:
						CT
						(switch global112
							(1 5)
							(2 9)
							(3 13)
							(0 1)
							(4 15)
							(else 3)
						)
						1
						self
				)
			)
			(4
				(LodeStone cel: (- (LodeStone cel:) 1))
				(= seconds 4)
			)
			(5
				(LodeBox dispose:)
				(LodeStone dispose:)
				(= cycles 1)
			)
			(6
				(client setScript: 0)
				(User controls: local1 canInput: local2)
				(= global80 local0)
				(DisposeScript 118)
			)
		)
	)
)

