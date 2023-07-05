;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4220)
(include sci.sh)
(use Main)
(use PQRoom)
(use HotSpot)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	s1_4220 0
)

(instance s1_4220 of PQRoom
	(properties
		picture 4220
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(toiletHandle init:)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: shotFeatures)
			)
			(6
				(self setScript: shotFeatures)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance shotFeatures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 8 0 1 self) ; "Compromised!!!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(1
				(gGame handsOff: showCloseUp: 41002 180 70 self)
			)
			(2
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40106)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance throwFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(gMessager say: 0 16 0 0 self) ; "Compromised!!!"
			)
			(6
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40106)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flushToilet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(flushHandle init: setCycle: End self)
			)
			(1
				(gGame handsOff:)
				(Lock rsAUDIO 40106 0)
				(gFxSound number: 42201 setLoop: 1 play: self)
			)
			(2
				(gMessager say: 0 8 0 1 self) ; "Compromised!!!"
				(gBackMusic number: 0 stop:)
				(UnLoad 141 40106)
			)
			(3
				(gGame handsOff: showCloseUp: 41002 180 70 self)
			)
			(4
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 85
		y 320
		view 42200
	)
)

(instance flushHandle of Prop
	(properties
		x 100
		y 203
		view 42201
	)
)

(instance toiletHandle of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 111 168 141 161 148 183 121 190
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 29)
			(gCurRoom setScript: flushToilet)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 4230) ; s1_4230
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8195
	)

	(method (doVerb theVerb)
		(if (== theVerb 55)
			(global112 slicePie: 4230)
		)
		(gCurRoom newRoom: 4230) ; s1_4230
	)
)

