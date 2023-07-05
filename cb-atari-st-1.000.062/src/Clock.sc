;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 406)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	Clock 0
)

(local
	[local0 16] = [406 0 406 1 406 2 406 3 406 4 406 5 406 6 406 7]
	local16
	local17
	local18
)

(instance Clock of Script
	(properties)

	(method (doit)
		(if (== state 2)
			(if (== (clockChime prevSignal:) -1)
				(if (== gMinute 0)
					(clockChime prevSignal: 0)
					(switch (clockChime number:)
						(94
							(clockChime number: 95 loop: 1 play:)
						)
						(95
							(clockChime number: 96 loop: 1 play:)
						)
						(96
							(clockChime number: 29 loop: gHour play:)
						)
						(else
							(= local16 1)
						)
					)
				else
					(= local16 1)
				)
			)
			(if local16
				(clockChime stop: dispose:)
				(= cycles 1)
			)
		)
		(= local16 0)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event claimed:))
				(or
					(== (event type:) evMOUSEBUTTON)
					(== (event type:) evKEYBOARD)
					(== (event type:) $0040) ; direction
				)
			)
			(if (!= (event type:) $0040) ; direction
				(= local16 1)
			)
			(event claimed: 1)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 406)
		(= global190 local18)
	)

	(method (changeState newState &tmp temp0 [temp1 25])
		(switch (= state newState)
			(0
				(if (== (User controls:) 1)
					(gEgo setMotion: 0)
				)
				(= local18 global190)
				(= global190 1)
				(= local17 gMinute)
				(if (> (++ gMinute) 3)
					(if (< gHour 12)
						(++ gHour)
					else
						(= gHour 1)
					)
					(= gMinute 0)
				)
				(if gDetailLevel
					(clockFace
						cel: (- (NumCels clockFace) 1)
						setCycle: Beg self
						init:
					)
				else
					(clockFace cel: 0 init: stopUpd:)
					(= cycles 1)
				)
				(hourHand init: hide:)
				(minuteHand init: hide:)
			)
			(1
				(hourHand
					loop: (if (and local17 (< local17 3)) 6 else 5)
					cel: (if (== gHour 12) 0 else gHour)
					show:
				)
				(minuteHand
					loop:
						(switch local17
							(0 1)
							(1 3)
							(2 4)
							(3 2)
						)
				)
				(minuteHand
					cel:
						(if (& local17 $0001)
							(- (NumCels minuteHand) 1)
						else
							0
						)
					setCycle: (if (& local17 $0001) Beg else End) self
					show:
				)
			)
			(2
				(if (== gMinute 0)
					(if (< gHour 7)
						(= temp0 1)
					else
						(= temp0 5)
					)
					(= temp0 (* (- gHour temp0) 2))
					(Print
						(Format @temp1 406 8 [local0 temp0] [local0 (++ temp0)]) ; "Act %s"
						#at
						108
						120
						#font
						41
						#width
						100
						#mode
						1
						#draw
						#dispose
					)
					(clockChime number: 94 loop: 1 play:)
				else
					(clockChime number: (+ (- gMinute 1) 94) loop: 1 play:)
				)
			)
			(3
				(cls)
				(hourHand hide: dispose: delete:)
				(minuteHand hide: dispose: delete:)
				(if gDetailLevel
					(clockFace setCycle: End self)
				else
					(clockFace cel: (clockFace lastCel:) forceUpd:)
					(= cycles 2)
				)
			)
			(4
				(clockFace hide: dispose: delete:)
				(client setScript: 0)
			)
		)
	)
)

(instance clockFace of Prop
	(properties
		y 45
		x 159
		view 642
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance hourHand of Prop
	(properties
		y 45
		x 159
		view 642
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance minuteHand of Prop
	(properties
		y 45
		x 159
		view 642
		priority 15
		signal 16400
		cycleSpeed 1
	)
)

(instance clockChime of Sound
	(properties
		priority 15
	)
)

