;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 550)
(include sci.sh)
(use Main)
(use Scaler)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm550 0
)

(instance rm550 of Rm
	(properties
		picture 76
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 546)
		(switch gPrevRoomNum
			(500
				(gGame handsOff:)
				(gCurRoom setScript: sExplode)
			)
			(else
				(gGame handsOff:)
				(gCurRoom setScript: sExplode)
			)
		)
		(super init:)
	)

	(method (dispose)
		(gSq5Music1 stop:)
		(super dispose: &rest)
	)
)

(instance sExplode of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gSq5Music1 number: 25 loop: 1 play: self)
				(self setScript: sExplodeAnim)
			)
			(1
				(if (IsFlag 49)
					(EgoDead 23) ; "Looks like you took a little too long getting out of there, but thanks for playing Space Quest 5. You've been a real blast."
				else
					(SetFlag 30)
					(gCurRoom newRoom: 201)
				)
			)
		)
	)
)

(instance sExplodeAnim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(spacebar init: stopUpd:)
				(myship init:)
				(ship1 init:)
				(ship2 init:)
				(ship3 init:)
				(ship4 init:)
				(= seconds 3)
			)
			(1
				(debris init: hide: stopUpd:)
				(debris2 init: hide: stopUpd:)
				(debris3 init: hide: stopUpd:)
				(debris4 init: hide: stopUpd:)
				(debris5 init: hide: stopUpd:)
				(debris6 init: hide: stopUpd:)
				(debris7 init: hide: stopUpd:)
				(explode init: hide: stopUpd:)
				(explode3 init: hide: stopUpd:)
				(= cycles 3)
			)
			(2
				(ship1 setScript: sShip1)
				(bulge1 init:)
				(gSq5Music2 number: 250 setLoop: 1 play:)
				(= seconds 1)
			)
			(3
				(ship2 setScript: sShip2)
				(ship3 setScript: sShip3)
				(bulge2 init:)
				(gSq5Music2 number: 250 setLoop: 1 play:)
				(= seconds 1)
			)
			(4
				(ship4 setScript: sShip4)
				(bulge3 init:)
				(gSq5Music2 number: 250 setLoop: 1 play:)
				(= seconds 1)
			)
			(5
				(bulge1 stopUpd:)
				(bulge2 stopUpd:)
				(bulge3 stopUpd:)
				(if (not (IsFlag 49))
					(myship setScript: sMyship)
				)
				(= cycles 1)
			)
			(6
				(= seconds 3)
			)
			(7
				(gSq5Music2 number: 203 loop: 1 play:)
				(bulge1 dispose:)
				(bulge2 dispose:)
				(bulge3 dispose:)
				(explode show: cycleSpeed: 10 setCycle: Fwd)
				(explode3 show: setCycle: Fwd)
				(= seconds 2)
			)
			(8
				(Palette palSET_FROM_RESOURCE 921 2)
				(= cycles 1)
			)
			(9
				(myship hide:)
				(explode3 setCycle: 0 dispose:)
				(explode setCycle: 0 dispose:)
				(gCurRoom drawPic: (gCurRoom picture:))
				(spacebar hide: dispose:)
				(debris show: startUpd:)
				(debris2 show: startUpd:)
				(debris3 show: startUpd:)
				(debris4 show: startUpd:)
				(debris5 show: startUpd:)
				(debris6 show: startUpd:)
				(debris7 show: startUpd:)
				(= cycles 1)
			)
			(10
				(debris setMotion: MoveTo 239 -40 self)
				(debris2 setMotion: MoveTo 350 180 self)
				(debris3 setMotion: MoveTo -40 108 self)
				(debris4 setMotion: MoveTo -40 185 self)
				(debris5 setMotion: MoveTo -30 12 self)
				(debris6 setMotion: MoveTo -30 52 self)
				(debris7 setMotion: MoveTo -40 173 self)
				(self setScript: sMonks self)
			)
			(11 0)
			(12 0)
			(13 0)
			(14 0)
			(15 0)
			(16 0)
			(17 0)
			(18
				(self dispose:)
			)
		)
	)
)

(instance sMyship of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(myship setMotion: MoveTo 210 220 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sShip1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship1 setMotion: MoveTo -30 95 self)
			)
			(1
				(ship1 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sShip2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship2 setMotion: MoveTo 350 120 self)
			)
			(1
				(ship2 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sShip3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ship3 setMotion: MoveTo 350 0 self)
			)
			(1
				(ship3 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sShip4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(ship4 setMotion: MoveTo 195 -30 self)
			)
			(2
				(ship4 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sMonks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(smonk1 init: setMotion: MoveTo 330 10 self)
				(smonk2 init: setMotion: MoveTo 330 78 self)
				(smonk3 init: setMotion: MoveTo -30 108 self)
				(smonk4 init: setMotion: MoveTo -30 200 self)
				(smonk init: setMotion: MoveTo 340 200 self)
			)
			(2 0)
			(3 0)
			(4 0)
			(5 0)
			(6
				(self dispose:)
			)
		)
	)
)

(instance smonk of Actor
	(properties
		x 150
		y 95
		view 546
		loop 8
		cel 2
	)

	(method (init)
		(self setLoop: 8 setCel: 2 setScale: Scaler 106 20 141 100 setStep: 8 5)
		(super init: &rest)
	)
)

(instance smonk1 of Actor
	(properties
		x 123
		y 65
		view 546
		loop 8
		signal 24576
	)

	(method (init)
		(self setLoop: 8 setCel: 0 setStep: 10 8)
		(super init: &rest)
	)
)

(instance smonk2 of Actor
	(properties
		x 170
		y 78
		view 546
		loop 8
		signal 24576
	)

	(method (init)
		(self setLoop: 8 setCel: 0 setStep: 10 8)
		(super init: &rest)
	)
)

(instance smonk3 of Actor
	(properties
		x 54
		y 38
		view 546
		loop 8
		cel 1
		signal 24576
	)

	(method (init)
		(self setLoop: 8 setCel: 1 setStep: 10 8)
		(super init: &rest)
	)
)

(instance smonk4 of Actor
	(properties
		x 78
		y 93
		view 546
		loop 8
		cel 1
		signal 24576
	)

	(method (init)
		(self setLoop: 8 setCel: 1 setStep: 10 8)
		(super init: &rest)
	)
)

(instance spacebar of Prop
	(properties
		x 58
		y 29
		view 546
		priority 8
		signal 16
	)
)

(instance bulge1 of Prop
	(properties
		x 87
		y 44
		view 546
		loop 1
		priority 9
		signal 16
	)
)

(instance bulge2 of Prop
	(properties
		x 126
		y 62
		view 546
		loop 2
		priority 9
		signal 16
	)
)

(instance bulge3 of Prop
	(properties
		x 101
		y 60
		view 546
		loop 3
		priority 9
		signal 16
	)
)

(instance myship of Actor
	(properties
		x 165
		y 105
		view 546
		loop 5
		priority 15
		signal 16384
	)

	(method (init)
		(self
			setStep: 8 5
			setLoop: 5
			setCel: 0
			setPri: 15
			setScale: Scaler 106 20 141 100
		)
		(super init: &rest)
	)
)

(instance ship1 of Actor
	(properties
		x 77
		y 85
		view 546
		loop 4
		priority 5
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 4 setCel: 0)
		(super init: &rest)
	)
)

(instance ship2 of Actor
	(properties
		x 137
		y 112
		view 546
		loop 4
		cel 1
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 4 setCel: 1)
		(super init: &rest)
	)
)

(instance ship3 of Actor
	(properties
		x 152
		y 84
		view 546
		loop 4
		cel 2
		signal 24576
	)

	(method (init)
		(self setStep: 10 8 setLoop: 4 setCel: 2)
		(super init: &rest)
	)
)

(instance ship4 of Actor
	(properties
		x 133
		y 58
		view 546
		loop 4
		cel 3
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 4 setCel: 3)
		(super init: &rest)
	)
)

(instance explode of Prop
	(properties
		x 116
		y 66
		view 546
		loop 6
		priority 10
		signal 16
	)

	(method (init)
		(self setLoop: 6)
		(super init: &rest)
	)
)

(instance explode3 of Prop
	(properties
		x 92
		y 46
		view 546
		loop 6
		cel 2
		priority 12
		signal 16
	)

	(method (init)
		(self setLoop: 6)
		(super init: &rest)
	)
)

(instance debris of Actor
	(properties
		x 162
		y 5
		view 546
		loop 7
		signal 24576
	)

	(method (init)
		(self setLoop: 7 setCel: 0)
		(super init: &rest)
	)
)

(instance debris2 of Actor
	(properties
		x 154
		y 73
		view 546
		loop 7
		cel 1
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 7 setCel: 1)
		(super init: &rest)
	)
)

(instance debris3 of Actor
	(properties
		x 45
		y 88
		view 546
		loop 7
		cel 2
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 7 setCel: 2)
		(super init: &rest)
	)
)

(instance debris4 of Actor
	(properties
		x 74
		y 95
		view 546
		loop 7
		cel 3
		priority 10
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 7 setCel: 3)
		(super init: &rest)
	)
)

(instance debris5 of Actor
	(properties
		x 70
		y 42
		view 546
		loop 7
		cel 4
		priority 10
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 7 setCel: 4)
		(super init: &rest)
	)
)

(instance debris6 of Actor
	(properties
		x 47
		y 62
		view 546
		loop 7
		cel 5
		priority 10
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 7 setCel: 5)
		(super init: &rest)
	)
)

(instance debris7 of Actor
	(properties
		x 54
		y 114
		view 546
		loop 7
		cel 6
		priority 10
		signal 24576
	)

	(method (init)
		(self setStep: 8 5 setLoop: 7 setCel: 6)
		(super init: &rest)
	)
)

