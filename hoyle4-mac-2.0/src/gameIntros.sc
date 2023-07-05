;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use SpeakWindow)
(use Character)
(use Game)
(use System)

(public
	gameIntros 0
)

(local
	[local0 9] = [0 11 12 16 9 13 17 14 10]
	[local9 9] = [0 2 2 2 2 2 2 2 2]
	[local18 9] = [0 112 127 191 126 128 125 190 181]
	[local27 9] = [0 154 151 155 153 160 157 158 157]
	local36
	local37
)

(instance gameIntros of Rm
	(properties
		style 10
	)

	(method (init)
		(= picture global193)
		(super init:)
		(PicNotValid 1)
		(= local36 (gChar1 view:))
		(= local37 (gChar1 loop:))
		(gChar1
			active: 1
			view: [local0 (/ global193 100)]
			loop: [local9 (/ global193 100)]
		)
		((gChar1 face:) view: (gChar1 view:))
		(gChar1
			posn: [local18 (/ global193 100)] [local27 (/ global193 100)]
		)
		(gChar1 show: init:)
		(Characters init:)
		(self setScript: roomScript)
	)

	(method (dispose)
		(SpeakWindow forceToX: 0 forceToY: 0)
		(= global109 0)
		(gChar1 view: local36 loop: local37)
		((gChar1 face:) view: (gChar1 view:))
		(DisposeScript 9)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance roomScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= ticks 1)
			)
			(1
				(PicNotValid 0)
				(= global109 140)
				(if (or (== global193 400) (== global193 800))
					(= global109 130)
				)
				(switch global193
					(100
						(SpeakWindow forceToX: 1)
					)
					(200
						(SpeakWindow forceToX: 1)
					)
					(300
						(SpeakWindow forceToX: 140)
					)
					(400
						(SpeakWindow forceToX: 1)
					)
					(500
						(SpeakWindow forceToX: 1)
					)
					(600
						(SpeakWindow forceToX: 1)
					)
					(700
						(SpeakWindow forceToX: 140)
					)
					(800
						(SpeakWindow forceToX: 155)
					)
				)
				(= temp0
					(switch (Random 1 5)
						(1 1)
						(2 2)
						(3 3)
						(4 4)
						(5 5)
					)
				)
				(gChar1 say: 21 2 0 temp0 (/ global193 100) 464 1)
				(= ticks 100)
			)
			(2
				(= gNewRoomNum global193)
			)
		)
	)
)

