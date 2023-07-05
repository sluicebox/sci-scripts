;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use PolyPath)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	proc160_0 0
	ExitCar 1
	EnterCar 2
	carDoor 3
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
)

(procedure (proc160_0 &tmp temp0)
	(switch global207
		(914
			(= local11 3)
		)
		(105
			(= local11 1)
		)
		(104
			(= local11 1)
		)
	)
	(switch global206
		(0
			(switch gCurRoomNum
				(45
					(= local0 270)
					(= local1 98)
					(= local2 -50)
				)
				(50
					(= local0 163)
					(= local1 5)
					(= local2 -100)
				)
			)
			(= temp0 (+ local1 (- local2)))
			(= local3 (- local0 20))
			(= local4 (- temp0 7))
			(= local5 (+ local0 1))
			(= local6 (+ temp0 12))
			(= local7 (+ local0 11))
			(= local8 (+ temp0 11))
			(= local9 (+ local0 22))
			(= local10 (+ temp0 18))
			(= local13 2)
			(= local12 7)
			(= local14 7)
		)
		(1
			(switch global207
				(105
					(switch gCurRoomNum
						(45
							(= local0 285)
							(= local1 76)
							(= local2 -50)
						)
						(50
							(= local0 145)
							(= local1 7)
							(= local2 -80)
						)
					)
					(= temp0 (+ local1 (- local2)))
					(= local3 (- local0 8))
					(= local4 (+ temp0 14))
					(= local5 (+ local0 13))
					(= local6 (+ temp0 32))
					(= local7 (+ local0 22))
					(= local8 (+ temp0 30))
					(= local9 (+ local0 46))
					(= local10 (+ temp0 35))
					(= local12 8)
					(= local13 3)
					(= local14 7)
				)
				(104
					(switch gCurRoomNum
						(45
							(= local0 178)
							(= local1 92)
							(= local2 -50)
						)
						(50
							(= local0 57)
							(= local1 4)
							(= local2 -99)
						)
					)
					(= temp0 (+ local1 (- local2)))
					(= local3 (+ local0 83))
					(= local4 (- temp0 8))
					(= local5 (+ local0 105))
					(= local6 (+ temp0 18))
					(= local7 (+ local0 119))
					(= local8 (+ temp0 18))
					(= local9 (+ local0 140))
					(= local10 (+ temp0 21))
					(= local12 8)
					(= local13 3)
					(= local14 8)
				)
			)
		)
		(2
			(switch gCurRoomNum
				(45
					(= local0 178)
					(= local1 92)
					(= local2 -50)
				)
				(50
					(= local0 57)
					(= local1 4)
					(= local2 -99)
				)
			)
			(= temp0 (+ local1 (- local2)))
			(= local3 (+ local0 83))
			(= local4 (- temp0 8))
			(= local5 (+ local0 107))
			(= local6 (+ temp0 15))
			(= local7 (+ local0 118))
			(= local8 (+ temp0 12))
			(= local9 (+ local0 140))
			(= local10 (+ temp0 21))
			(= local12 9)
			(= local13 0)
			(= local14 7)
		)
	)
	(car
		view: global207
		init:
		setCel: 1
		z: local2
		posn: local0 local1
		forceUpd:
		addToPic:
	)
	(carDoor
		view: global207
		init:
		posn: local3 local4
		setLoop: local11
		setCel: 0
		stopUpd:
	)
	(if (== global207 914)
		(backDoor
			view: global207
			init:
			setLoop: 4
			setCel: 0
			setPri: (car priority:)
			posn: (+ local0 11) (- temp0 19)
			forceUpd:
			addToPic:
		)
	)
)

(instance ExitCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 900)
				(Load rsSOUND 901)
				(proc160_0)
				(gEgo
					setCycle: 0
					view: local12
					setLoop: local13
					setCel: 0
					posn: local5 local6
					ignoreActors: 1
					setPri: (- (carDoor priority:) 1)
				)
				(= seconds 2)
			)
			(1
				(carSnd number: 900 play:)
				(carDoor setCycle: End self)
			)
			(2
				(carDoor stopUpd:)
				(= seconds 2)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(= ticks 20)
			)
			(5
				(NormalEgo)
				(gEgo
					posn: local7 local8
					loop: 7
					setPri: (- (carDoor priority:) 1)
				)
				(= ticks 20)
			)
			(6
				(gEgo setHeading: 100 self)
			)
			(7
				(= ticks 20)
			)
			(8
				(gEgo setMotion: MoveTo local9 local10 self)
			)
			(9
				(gEgo setHeading: 295 self)
			)
			(10
				(gEgo setPri: (+ (carDoor priority:) 1))
				(= ticks 20)
			)
			(11
				(carDoor setCycle: Beg self)
			)
			(12
				(carDoor stopUpd:)
				(carSnd number: 901 play:)
				(gEgo setPri: -1 setHeading: 225 self)
			)
			(13
				(= ticks 20)
			)
			(14
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance EnterCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 900)
				(Load rsSOUND 901)
				(Load rsSOUND 904)
				(gEgo
					setMotion:
						(if (== gCurRoomNum 45) MoveTo else PolyPath)
						local9
						local10
						self
				)
			)
			(1
				(gEgo setHeading: 310 self)
			)
			(2
				(= ticks 20)
			)
			(3
				(carSnd number: 900 play:)
				(carDoor setCycle: End self)
			)
			(4
				(carDoor stopUpd:)
				(= ticks 20)
			)
			(5
				(gEgo
					setPri: (- (carDoor priority:) 1)
					ignoreActors: 1
					setMotion: MoveTo local7 local8 self
				)
			)
			(6
				(= ticks 20)
			)
			(7
				(gEgo
					view: local12
					setLoop: local13
					setCel: 255
					posn: local5 local6
					setCycle: Beg self
				)
			)
			(8
				(= ticks 20)
			)
			(9
				(carDoor setCycle: Beg self)
			)
			(10
				(carDoor stopUpd:)
				(carSnd number: 901 play:)
				(= ticks 20)
			)
			(11
				(carSnd number: 904 play:)
				(= seconds 6)
			)
			(12
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance car of View
	(properties
		noun 1
		modNum 160
		signal 26624
	)

	(method (init)
		(super init: &rest)
		(self setPri: (if (== gCurRoomNum 50) 6 else 10))
	)
)

(instance backDoor of View
	(properties
		noun 1
		modNum 160
		signal 26624
	)
)

(instance carDoor of Prop
	(properties
		noun 2
		modNum 160
		view 104
		loop 1
		cel 3
		signal 26624
	)

	(method (init)
		(super init: &rest)
		(self setPri: (if (== gCurRoomNum 50) local14 else 12))
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(cond
					((and (== global206 2) (== gCurRoomNum 50))
						(gMessager say: 1 4 4 0 0 160) ; "That's not an option at this time."
					)
					((and (!= global211 70) (== gCurRoomNum 45))
						(gMessager say: 1 4 4 0 0 160) ; "That's not an option at this time."
					)
					(else
						(gCurRoom setScript: (ScriptID 160 2)) ; EnterCar
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance carSnd of Sound
	(properties
		flags -1
	)
)

