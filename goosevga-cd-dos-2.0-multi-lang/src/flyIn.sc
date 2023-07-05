;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 250)
(include sci.sh)
(use Main)
(use Motion)
(use Actor)
(use System)

(public
	flyIn 0
)

(local
	local0
	local1
	local2
)

(instance flyIn of Script
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(= local0 param3)
		(= local1 param4)
		(= register param5)
		(super init: param1 param2)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(goose init: y: local1)
				(if (== gCurRoomNum 18)
					(goose y: 90)
				)
				(= cycles register)
			)
			(1
				(goose setMotion: MoveTo (+ local0 31) local1 self)
			)
			(2
				(goose setCycle: End self setMotion: MoveTo local0 local1)
			)
			(3
				((gEgo head:) hide:)
				(gEgo hide:)
				(goose
					view: (+ global114 21)
					setLoop: 3
					setCel: 255
					setCycle: Beg self
				)
			)
			(4
				(goose setLoop: 2 setCel: 255 setCycle: Beg self)
				(= cycles 11)
			)
			(5
				(goose setMotion: MoveTo 11 local1)
			)
			(6
				(goose
					setLoop: 1
					setCycle: Fwd
					y: (- (goose y:) 16)
					setPri:
					setMotion: MoveTo -41 (- local1 65) self
				)
			)
			(7
				(goose dispose:)
				(= cycles 2)
			)
			(8
				(self dispose:)
				(= local2 1)
			)
		)
		(if local2
			(DisposeScript 250)
		)
	)
)

(instance goose of Act
	(properties
		y 133
		x 281
		view 16
		loop 1
		signal 26624
		cycleSpeed 1
		illegalBits 0
	)
)

