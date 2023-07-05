;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2018)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use VMDMovie)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	wheelRgn9 0
)

(instance wheelRgn9 of CloseupLocation
	(properties
		heading 225
		picture 2227
	)

	(method (init)
		(super init: picture)
		(if (not (IsFlag 58))
			(Load rsVIEW 2227)
			(self setScript: lensesExtrude)
		)
		(laser_225 init:)
		(wheel_225 init:)
		(lights_225 init:)
		(london_225 init:)
	)

	(method (pitch)
		(if (not (IsFlag 58))
			(self setScript: lensesRetract)
		else
			(super pitch: &rest)
		)
	)
)

(instance lensesExtrude of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(laserCover play:)
				(laserPanel setPri: 10 init: global117 setCycle: End self)
			)
			(1
				(holder1 setPri: 20 init: global117 setCycle: End self)
				(holder2 setPri: 20 init: global117 setCycle: End)
				(holder3 setPri: 20 init: global117 setCycle: End)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lensesRetract of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(holder1 setCycle: Beg self)
				(holder2 setCycle: Beg)
				(holder3 setCycle: Beg)
			)
			(1
				(holder1 dispose:)
				(holder2 dispose:)
				(holder3 dispose:)
				(laserCover play:)
				(laserPanel setCycle: Beg self)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance fireLaser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== (proc70_9 105) gCurRoomNum)
						(== (proc70_9 106) gCurRoomNum)
						(== (proc70_9 107) gCurRoomNum)
					)
					(gGame handsOff:)
					(SetFlag 58)
					(= cycles 1)
				else
					(self dispose:)
				)
			)
			(1
				(laserPanel dispose:)
				(holder1 dispose:)
				(holder2 dispose:)
				(holder3 dispose:)
				(laserFire play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance laserFire of VMDMovie
	(properties
		movieName 2227
	)
)

(instance laserPanel of Prop
	(properties
		x 222
		y 165
		cycleSpeed 2
		view 2227
	)
)

(instance holder1 of Prop
	(properties
		loop 1
		view 2227
	)

	(method (init)
		(if (!= (proc70_9 105) gCurRoomNum)
			(+= loop 3)
			(self x: 200 y: 158)
		else
			(self x: 199 y: 159)
		)
		(super init: &rest)
		(if (!= (proc70_9 105) gCurRoomNum)
			(self setHotspot: 107)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(107
				(proc70_3)
				(proc70_10 105 gCurRoomNum)
				(-= loop 3)
				(= cel 10)
				(self posn: 199 159)
				(UpdateScreenItem self)
				(lensePlacedInHolder play:)
				(FrameOut)
				(gCurRoom setScript: fireLaser)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holder2 of Prop
	(properties
		loop 2
		view 2227
	)

	(method (init)
		(if (!= (proc70_9 106) gCurRoomNum)
			(+= loop 3)
			(self x: 229 y: 159)
		else
			(self x: 228 y: 159)
		)
		(super init: &rest)
		(if (!= (proc70_9 106) gCurRoomNum)
			(self setHotspot: 108)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(108
				(proc70_3)
				(proc70_10 106 gCurRoomNum)
				(-= loop 3)
				(= cel 10)
				(self posn: 228 159)
				(UpdateScreenItem self)
				(lensePlacedInHolder play:)
				(FrameOut)
				(gCurRoom setScript: fireLaser)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance holder3 of Prop
	(properties
		loop 3
		view 2227
	)

	(method (init)
		(if (!= (proc70_9 107) gCurRoomNum)
			(+= loop 3)
			(self x: 256 y: 159)
		else
			(self x: 256 y: 160)
		)
		(super init: &rest)
		(if (!= (proc70_9 107) gCurRoomNum)
			(self setHotspot: 109)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(109
				(proc70_3)
				(proc70_10 107 gCurRoomNum)
				(-= loop 3)
				(= cel 10)
				(self posn: 256 160)
				(UpdateScreenItem self)
				(lensePlacedInHolder play:)
				(FrameOut)
				(gCurRoom setScript: fireLaser)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lensePlacedInHolder of Sound
	(properties
		number 2227
		flags 5
	)
)

(instance laserCover of Sound
	(properties
		number 2228
		flags 5
	)
)

(instance laser_225 of Feature
	(properties
		noun 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 108 155 163 143 344 131 362 148 391 136 501 130 520 149 520 173 501 190 450 188 440 215 457 237 461 268 494 267 518 280 518 292 333 292 331 272 372 272 391 230 401 190 376 176 356 175 333 189 108 167
					yourself:
				)
		)
	)
)

(instance wheel_225 of Feature
	(properties
		noun 5
		x 371
		y 118
		nsBottom 144
		nsLeft 356
		nsRight 387
		nsTop 93
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance lights_225 of Feature
	(properties
		noun 15
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 201 97 591 36 593 59 194 107
					yourself:
				)
		)
	)
)

(instance london_225 of Feature
	(properties
		noun 16
		x 471
		y 50
		nsBottom 58
		nsLeft 455
		nsRight 487
		nsTop 43
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

