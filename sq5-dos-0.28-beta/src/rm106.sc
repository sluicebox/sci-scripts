;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 106)
(include sci.sh)
(use Main)
(use Scaler)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm106 0
)

(instance rm106 of Rm
	(properties
		picture 35
		style 10
		horizon 64
		vanishingX 255
		vanishingY 64
	)

	(method (init)
		(gCurRoom setRegions: 210) ; eureka
		(LoadMany rsVIEW 156 158)
		(gGame setScript: sGo)
		(gGame handsOff:)
		(super init:)
	)
)

(instance eurek of Actor
	(properties
		x 176
		y 87
		view 158
		signal 24576
	)

	(method (init)
		(self
			setLoop: 0
			setCel: 0
			moveSpeed: 4
			setStep: 8 8
			setScale: Scaler 100 15 134 86
		)
		(super init: &rest)
	)
)

(instance ship of Prop
	(properties
		view 156
		signal 24576
	)
)

(instance ship1 of Prop ; UNUSED
	(properties
		view 156
		cel 1
		signal 24576
	)
)

(instance ship2 of Prop ; UNUSED
	(properties
		view 156
		cel 2
		signal 24576
	)
)

(instance ship3 of Prop
	(properties
		view 156
		cel 3
		signal 24576
	)
)

(instance ship4 of Prop ; UNUSED
	(properties
		view 156
		cel 4
		signal 24576
	)
)

(instance ship5 of Prop
	(properties
		view 156
		cel 5
		signal 24576
	)
)

(instance door of Prop
	(properties
		x 174
		y 84
		view 158
		loop 2
		cel 2
	)
)

(instance sCyclePal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palANIMATE 251 253 1)
				(Palette palANIMATE 253 255 1)
				(= cycles 3)
			)
			(1
				(-= state 2)
				(= cycles 1)
			)
		)
	)
)

(instance sCycleLights of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palANIMATE 250 255 10)
				(= cycles 1)
			)
			(1
				(-= state 2)
				(= cycles 1)
			)
		)
	)
)

(instance sGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= seconds 1)
				(self setScript: sCyclePal)
				(gSq5Music1 number: 44 loop: -1 play:)
			)
			(2
				(door init: setLoop: 4 cel: 2 setCycle: Beg self)
			)
			(3
				(= seconds 2)
			)
			(4
				(Palette palSET_FROM_RESOURCE 1060 2)
				(eurek init: setMotion: MoveTo 81 158 self)
			)
			(5
				(door setCycle: End)
				(eurek setScale: 0 setCycle: End self cycleSpeed: 4)
			)
			(6
				(eurek posn: 203 144 setLoop: 1 setCycle: End self)
			)
			(7
				(eurek posn: 264 129 setLoop: 2 setCycle: End self)
			)
			(8
				(eurek posn: 269 60 setLoop: 3 setCycle: End self)
				(gSq5Music2 number: 163 loop: 1 play:)
			)
			(9
				(eurek setLoop: 5 cel: 1 x: 271 y: 42 setCycle: Beg self)
			)
			(10
				(eurek setCycle: End self)
				(gSq5Music2 fade:)
			)
			(11
				(eurek dispose:)
				(gSq5Music1 fade:)
				(= seconds 4)
			)
			(12
				(ship init: addToPic:)
				(DrawPic 35 9)
				(gSq5Music1 number: 35 loop: -1 play:)
				(= cycles 1)
			)
			(13
				(ship3 init: addToPic:)
				(DrawPic 35 9)
				(= cycles 1)
			)
			(14
				(ship5 init: addToPic:)
				(DrawPic 35 9)
				(= cycles 1)
			)
			(15
				(= seconds 3)
			)
			(16
				(gCurRoom newRoom: 107)
				(self dispose:)
			)
		)
	)
)

