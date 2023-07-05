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
				(if (or (== gCurRoomNum 18) (== gCurRoomNum 12))
					(goose y: 90)
				)
				(= cycles register)
			)
			(1
				(goose setMotion: MoveTo (+ local0 16) local1 self)
			)
			(2
				(goose
					setLoop: 1
					setCycle: End
					setMotion: MoveTo local0 local1 self
				)
			)
			(3
				(gEgo hide:)
				(goose
					view: (+ global114 21)
					setLoop: 3
					setCel: 255
					setCycle: Beg self
					setMotion: 0
				)
			)
			(4
				(= ticks 15)
			)
			(5
				(goose setLoop: 2 setCel: 255 setPri: setCycle: Beg self)
				(goose setMotion: MoveTo 11 local1)
			)
			(6
				(goose
					setLoop: 1
					setCycle: Fwd
					y: (- (goose y:) 22)
					x: (+ (goose x:) 10)
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
	)
)

(instance goose of Actor
	(properties
		x 281
		y 133
		view 16
		loop 3
		signal 26625
		cycleSpeed 4
		illegalBits 0
	)
)

