;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2150)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use n777)
(use Motion)
(use Actor)
(use System)

(public
	rm2150 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0 temp1)
	(if (or (== argc 0) (== param1 1))
		(for ((= temp0 100)) (> temp0 0) ((-= temp0 param2))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	else
		(for ((= temp0 0)) (< temp0 100) ((+= temp0 param2))
			(Palette 2 0 71 temp0) ; PalIntensity
			(Palette 2 104 235 temp0) ; PalIntensity
			(gCast doit:)
			(FrameOut)
		)
	)
	(if (and (== argc 3) param3)
		(param3 cue:)
	)
)

(instance rm2150 of KQRoom
	(properties
		picture 2150
	)

	(method (init)
		(super init:)
		(gGame handsOff:)
		(= gValOrRoz -3) ; Roz
		(gKqSound1 stop:)
		(Load rsVIEW 2152)
		(Load rsVIEW 2153)
		(Load 140 2156 2157 2160 871 867) ; WAVE
		(cond
			((IsFlag 266)
				(ClearFlag 266)
				(gCurRoom setScript: sVolcanoErupts)
			)
			((== gPrevRoomNum 2155)
				(gCurRoom setScript: sWeb_Spinning)
			)
			((== gPrevRoomNum 2206)
				(gCurRoom setScript: sVolcanoSmokingWeb)
			)
			(else
				(gCurRoom setScript: sVolcanoSmokingWeb)
			)
		)
	)

	(method (dispose)
		(gKqSound1 fade:)
		(if local0
			(Palette 2 0 71 100) ; PalIntensity
			(Palette 2 104 235 100) ; PalIntensity
		)
		(super dispose: &rest)
	)
)

(instance sWeb_Spinning of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gKqMusic1 number:) 2150)
					(gKqMusic1 number: 2150 setLoop: -1 play:)
				)
				(bigThree
					view: 2151
					init:
					setPri: 200
					setLoop: 0
					setCel: 0
					setCycle: CT 12 1 self
				)
			)
			(1
				(gKqSound1 stop: setLoop: -1 number: 867 play:)
				(bigThree setCel: 13 setCycle: End self)
			)
			(2
				(web view: 2151 init: setLoop: 1 setCel: 0 setCycle: End)
				(bigThree
					view: 2151
					init:
					setLoop: 0
					setCel: 31
					setCycle: CT 12 -1 self
				)
			)
			(3
				(gKqSound1 stop:)
				(= cycles 1)
			)
			(4
				(bigThree cel: 11 setCycle: Beg self)
			)
			(5
				(gGame handsOn:)
				(gCurRoom newRoom: 2155)
				(self dispose:)
			)
		)
	)
)

(instance sVolcanoSmokingWeb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gKqMusic1 number:) 2150)
					(gKqMusic1 stop: number: 2154 setLoop: -1 play:)
				)
				(lava
					view: 2152
					y: 110
					init:
					setCel: 0
					setLoop: 2 1
					setCycle: Fwd
				)
				(bigThree
					view: 2152
					init:
					posn: 110 90
					setCel: 0
					setLoop: 1 1
					setCycle: End self
				)
			)
			(1
				(gKqSound1 stop: number: 2157 setLoop: 1 play:)
				(= ticks 220)
			)
			(2
				(cond
					((> (gGame speedRating:) 165)
						(proc777_0 gThePlane 1 5)
					)
					((> (gGame speedRating:) 90)
						(proc777_0 gThePlane 1 (Random 3 5))
					)
					((> (gGame speedRating:) 40)
						(proc777_0 gThePlane 1 (Random 2 3))
					)
				)
				(gKqSound1 stop: number: 871 setLoop: 1 play: self)
				(= ticks 120)
			)
			(3
				(if (> (gGame speedRating:) 165)
					(localproc_0 1 2 self)
				else
					(localproc_0 1 4 self)
				)
				(= local1 1)
				(= local0 1)
			)
			(4
				(bigThree hide:)
				(lava hide:)
				(= cycles 2)
			)
			(5
				(gKqSound1 fade:)
				(gCurRoom newRoom: 2208)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sVolcanoErupts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lava
					view: 2152
					y: 110
					setCel: 0
					setLoop: 2 1
					setCycle: Fwd
					init:
				)
				(= ticks 220)
			)
			(1
				(gKqSound1 stop: number: 2157 setLoop: 1 play: self)
			)
			(2
				(gKqSound1 stop: number: 871 setLoop: 1 play: self)
				(if (> (gGame speedRating:) 165)
					(proc777_0 gThePlane 1 5)
				else
					(proc777_0 gThePlane 1 3)
				)
			)
			(3
				(web view: 2153 setCel: 0 setLoop: 1 setCycle: End init:)
				(lava
					view: 2153
					y: 103
					show:
					setCel: 0
					setLoop: 0 1
					setCycle: Fwd
				)
				(gKqSound1 number: 2160 setLoop: -1 play:)
				(= ticks 180)
			)
			(4
				(cond
					((> (gGame speedRating:) 165)
						(proc777_0 gThePlane 1 5)
					)
					((> (gGame speedRating:) 90)
						(proc777_0 gThePlane 1 (Random 3 5))
					)
					((> (gGame speedRating:) 40)
						(proc777_0 gThePlane 1 (Random 2 3))
					)
				)
				(= cycles 1)
			)
			(5
				(if (> (gGame speedRating:) 165)
					(localproc_0 1 2 self)
				else
					(localproc_0 1 4 self)
				)
			)
			(6
				(lava hide:)
				(web hide:)
				(gKqSound1 stop:)
				(= cycles 1)
			)
			(7
				(Palette 2 0 71 100) ; PalIntensity
				(Palette 2 104 235 100) ; PalIntensity
				(= cycles 2)
			)
			(8
				(EgoDead 40 self)
			)
			(9
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance bigThree of Prop
	(properties
		x 152
		y 60
	)
)

(instance web of Prop
	(properties
		x 152
		y 80
	)
)

(instance lava of Prop
	(properties
		x 155
		y 103
	)
)

