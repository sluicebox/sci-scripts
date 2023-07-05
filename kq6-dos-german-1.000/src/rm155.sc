;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use KQ6Room)
(use Motion)
(use Actor)
(use System)

(public
	rm155 0
)

(local
	local0 = 1551
)

(instance rm155 of KQ6Room
	(properties
		picture 98
		style 10
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar disable:)
		(self setScript: backgroundScr)
	)

	(method (dispose)
		(gTheIconBar enable:)
		(super dispose:)
	)
)

(instance backgroundScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> gPrevRoomNum 500)
					(Palette palSET_FROM_RESOURCE 1551)
					(= local0 155)
				else
					(moonEnd init:)
				)
				(gCurRoom drawPic: 136 100)
				(SetCursor 0)
				(mane1 init: setCycle: Fwd)
				(mane2 init: setCycle: Fwd)
				(mane3 init: setCycle: Fwd)
				(mane4 init: setCycle: Fwd)
				(mane5 init: setCycle: Fwd)
				(mane6 init: setCycle: Fwd)
				(water1 init: setCycle: Fwd)
				(water2 init: setCycle: Fwd)
				(isle1 init:)
				(isle2 init:)
				(isle1 moveSpeed: 15 setMotion: MoveTo 76 154 self)
				(isle2 moveSpeed: 15 setMotion: MoveTo 242 159 self)
				(= ticks 60)
			)
			(1
				(water1
					moveSpeed: 30
					setStep: 1 1
					setMotion: MoveTo 27 176
					setPri: 12
				)
				(water2
					moveSpeed: 30
					setStep: 1 1
					setMotion: MoveTo 289 176
					setPri: 12
				)
				(= ticks 120)
			)
			(2
				(PalVary pvINIT local0 4 64 1)
				(= ticks 60)
			)
			(3
				(if (gCast contains: moonEnd)
					(moonEnd moveSpeed: 4 setMotion: MoveTo 73 118)
				)
			)
			(4 0)
			(5
				(isle1 setPri: 13 cycleSpeed: 25)
				(isle2 setPri: 13 cycleSpeed: 25)
				(= ticks 1)
			)
			(6
				(isle1 setCycle: End setMotion: MoveTo 62 172 self)
				(isle2 setCycle: End setMotion: MoveTo 256 177 self)
			)
			(7
				(PalVary pvUNINIT)
				(if (== gPrevRoomNum 340)
					(gCurRoom newRoom: 600)
				else
					(gCurRoom newRoom: 200)
				)
			)
		)
	)
)

(instance water1 of Actor
	(properties
		x 27
		y 167
		view 137
		signal 2048
	)
)

(instance water2 of Actor
	(properties
		x 289
		y 167
		view 137
		loop 1
		cel 1
		signal 2048
	)
)

(instance isle1 of Actor
	(properties
		x 76
		y 185
		loop 2
		priority 2
		signal 18448
	)

	(method (init)
		(if (== gPrevRoomNum 340)
			(self view: 137)
		else
			(self view: 139)
		)
		(super init:)
	)
)

(instance isle2 of Actor
	(properties
		x 242
		y 190
		loop 3
		priority 2
		signal 18448
	)

	(method (init)
		(if (== gPrevRoomNum 340)
			(self view: 137)
		else
			(self view: 139)
		)
		(super init:)
	)
)

(instance moonEnd of Actor
	(properties
		x 71
		y 160
		view 137
		loop 4
		priority 1
		signal 18448
	)
)

(instance mane1 of Prop
	(properties
		x 171
		y 46
		view 138
		cel 4
		priority 15
		signal 16
		cycleSpeed 7
		detailLevel 2
	)
)

(instance mane2 of Prop
	(properties
		x 177
		y 124
		view 138
		loop 2
		priority 16
		signal 16
		detailLevel 2
	)
)

(instance mane3 of Prop
	(properties
		x 163
		y 159
		view 138
		loop 3
		priority 14
		signal 16
		detailLevel 2
	)
)

(instance mane4 of Prop
	(properties
		x 190
		y 137
		view 138
		loop 1
		cel 3
		priority 15
		signal 16
		detailLevel 2
	)
)

(instance mane5 of Prop
	(properties
		x 173
		y 96
		view 138
		loop 2
		priority 5
		signal 16
		detailLevel 2
	)
)

(instance mane6 of Prop
	(properties
		x 163
		y 98
		view 138
		loop 3
		priority 15
		signal 16
		detailLevel 2
	)
)

