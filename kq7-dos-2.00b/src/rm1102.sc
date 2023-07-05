;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1102)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use ForwardCounter)
(use Motion)
(use Actor)
(use System)

(public
	rm1102 0
)

(instance rm1102 of KQRoom
	(properties
		picture 1102
		style 14
		exitStyle 13
	)

	(method (init)
		(SetFlag 21)
		(super init:)
		(gCurRoom setScript: demo)
	)
)

(instance demo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 1)
				(gEgo view: 8134 loop: 1 cel: 0 x: 308 y: 103 init:)
			)
			(1
				(gGame handsOff:)
				(Load rsVIEW 8344)
				(Load rsVIEW 8274)
				(Load rsSCRIPT 64956)
				(jack
					view: 1203
					loop: 0
					cel: 0
					x: 84
					y: 106
					init:
					setCycle: End self
				)
				(gEgo setCycle: CT 3 1 self)
			)
			(2 1)
			(3
				(jack loop: 2 cel: 0 x: 253 y: 99 setCycle: End self)
				(gEgo setCycle: CT 0 -1)
			)
			(4
				(jack setCycle: Beg self)
				(gEgo setCycle: CT 3 1 self)
			)
			(5 1)
			(6
				(jack view: 1203 loop: 4 cel: 0 setCycle: End self)
			)
			(7
				(jack cycleSpeed: 3 setCycle: End self)
				(gEgo view: 8344 loop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(8 1)
			(9
				(jack
					cycleSpeed: 0
					x: 259
					y: 96
					setCycle: ForwardCounter 5 self
				)
				(gEgo setCycle: End self)
			)
			(10 1)
			(11
				(jack cycleSpeed: 9 loop: 5 cel: 0 setCycle: End self)
			)
			(12
				(gEgo view: 8274 loop: 1 cel: 0 setCycle: CT 1 1 self)
			)
			(13
				(jack loop: 6 cel: 0 x: 86 y: 105 setCycle: End self)
				(gEgo setCycle: End self)
			)
			(14 1)
			(15
				(jack dispose:)
				(= seconds 2)
			)
			(16
				(for ((= temp0 100)) (>= temp0 0) ((-= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
					(FrameOut)
				)
				(gEgo view: 8074 loop: 1 cel: 3 x: 130 y: 103)
				(= seconds 1)
			)
			(17
				(for ((= temp0 0)) (<= temp0 100) ((+= temp0 5))
					(Palette 2 0 255 temp0) ; PalIntensity
					(FrameOut)
				)
				(Load rsVIEW 8074)
				(Load rsVIEW 1207)
				(Load rsVIEW 8294)
				(= seconds 1)
			)
			(18
				(gEgo setCycle: CT 0 -1 self)
			)
			(19
				(jack
					view: 1207
					loop: 0
					cel: 0
					x: 58
					y: 96
					init:
					setCycle: End self
				)
			)
			(20
				(glasses init:)
				(jack dispose:)
				(gEgo view: 8294 loop: 1 cel: 0 setCycle: End self)
			)
			(21
				(= seconds 2)
			)
			(22
				(gCurRoom newRoom: 1450)
			)
		)
	)
)

(instance glasses of View
	(properties
		x 58
		y 96
		view 1207
		loop 1
	)
)

(instance jack of Actor
	(properties
		x 80
		y 106
		view 1203
	)
)

