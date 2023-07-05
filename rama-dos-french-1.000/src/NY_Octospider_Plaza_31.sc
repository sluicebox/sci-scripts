;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5331)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use SaveManager)
(use Button)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Sound)
(use Actor)
(use System)

(public
	NY_Octospider_Plaza_31 0
)

(local
	[local0 5] = [0 63 127 190 254]
	local5
	local6
	[local7 10] = [190 286 196 266 200 243 205 227 210 208]
	[local17 10] = [234 287 237 264 241 243 243 223 246 208]
	[local27 10] = [279 287 280 264 281 244 282 223 283 208]
	local37
)

(instance NY_Octospider_Plaza_31 of CloseupLocation
	(properties
		noun 22
		heading 180
		picture 5397
	)

	(method (init)
		(super init: picture 0 0 0 backupExit)
		(backupExit init:)
		(monitorOne init: global117)
		(monitorTwo init: global117)
		(monitorThree init: global117)
		(curMonitorSlider init: global117)
		(redSlider init: global117)
		(greenSlider init: global117)
		(blueSlider init: global117)
		(powerButton init: global117)
		(= local37 0)
	)

	(method (newRoom)
		(if local6
			(powerButton doVerb: 2)
			(FrameOut)
		)
		(super newRoom: &rest)
	)

	(method (serialize param1 &tmp [temp0 6])
		(if (and argc param1)
			(super serialize: param1)
			(= local6 (SaveManager readWord:))
			(= local37 1)
		else
			(super serialize: param1)
			(SaveManager writeWord: local6)
		)
	)
)

(class OctoHeadronMonitor of View
	(properties
		priority 1
		fixPriority 1
		redValue 0
		greenValue 0
		blueValue 0
		monitorIdx 0
	)

	(method (init)
		(if (not (self setupColor:))
			(self createBitmap: 1 updateBitmap:)
		else
			(self view: 5397 loop: 1 cel: monitorIdx setPri: 300)
		)
		(super init: &rest)
		(if (not local6)
			(self hide:)
		)
	)

	(method (show)
		(self updateBitmap:)
		(super show: &rest)
	)

	(method (dispose)
		(self createBitmap: 0)
		(super dispose:)
	)

	(method (setupColor &tmp temp0 temp1)
		(= temp1 (& (= temp0 [global227 monitorIdx]) $f000))
		(if (== global216 monitorIdx)
			(redSlider cel: (& $000f (>> temp0 $0008)))
			(greenSlider cel: (& $000f (>> temp0 $0004)))
			(blueSlider cel: (& $000f temp0))
		)
		(return temp1)
	)

	(method (saveColor &tmp temp0)
		(= [global227 monitorIdx]
			(= temp0
				(|
					(= temp0
						(|
							(= temp0
								(|
									(= temp0 (& [global227 monitorIdx] $f000))
									(<< (redSlider cel:) $0008)
								)
							)
							(<< (greenSlider cel:) $0004)
						)
					)
					(blueSlider cel:)
				)
			)
		)
	)

	(method (createBitmap param1)
		(cond
			((and argc param1)
				(if (not bitmap)
					(= bitmap (Bitmap 0 80 80 255 255)) ; Create
				)
			)
			(bitmap
				(Bitmap 1 bitmap) ; Dispose
				(= bitmap 0)
			)
		)
	)

	(method (updateBitmap &tmp temp0 temp1)
		(if (and (== global216 monitorIdx) (not local37))
			(self saveColor:)
		)
		(if bitmap
			(if (== global216 monitorIdx)
				(= temp0
					(Palette
						3 ; PalMatch
						[local0 (redSlider cel:)]
						[local0 (greenSlider cel:)]
						[local0 (blueSlider cel:)]
					)
				)
			else
				(= temp1 [global227 monitorIdx])
				(= temp0
					(Palette
						3 ; PalMatch
						[local0 (& $000f (>> temp1 $0008))]
						[local0 (& $000f (>> temp1 $0004))]
						[local0 (& $000f temp1)]
					)
				)
			)
			(Bitmap 5 bitmap 0 0 79 79 temp0) ; AddRect
		)
	)

	(method (solveMonitor)
		(|= [global227 monitorIdx] $f000)
		(self dispose:)
		(self init: global117)
	)

	(method (compareColor)
		(return
			(and
				bitmap
				(== (redSlider cel:) redValue)
				(== (greenSlider cel:) greenValue)
				(== (blueSlider cel:) blueValue)
			)
		)
	)
)

(class ShermanColorSlider of View
	(properties
		poly 0
		sliderDir 1
		eY 0
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (onMe param1)
		(= eY (param1 y:))
		(return (super onMe: param1))
	)

	(method (dispose)
		(if poly
			(poly dispose:)
			(= poly 0)
		)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance monitorOne of OctoHeadronMonitor
	(properties
		x 162
		y 42
		blueValue 3
	)
)

(instance monitorTwo of OctoHeadronMonitor
	(properties
		x 267
		y 40
		redValue 3
		greenValue 2
		blueValue 4
		monitorIdx 1
	)
)

(instance monitorThree of OctoHeadronMonitor
	(properties
		x 373
		y 42
		redValue 2
		greenValue 3
		blueValue 1
		monitorIdx 2
	)
)

(instance curMonitorSlider of View
	(properties
		x 343
		y 228
		loop 3
		view 5397
	)

	(method (init)
		(= cel global216)
		(super init: &rest)
		(= local5
			(switch cel
				(0 monitorOne)
				(1 monitorTwo)
				(2 monitorThree)
			)
		)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 345 232 340 194 362 194 370 232
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (> (++ cel) 2)
					(= cel 0)
				)
				(= global216 cel)
				(UpdateScreenItem self)
				((= local5
						(switch cel
							(0 monitorOne)
							(1 monitorTwo)
							(2 monitorThree)
						)
					)
					updateBitmap:
				)
				(if local6
					(UpdateScreenItem local5)
					(if (local5 compareColor:)
						(gCurRoom setScript: solvedMonitor)
					)
				)
				(proc201_1 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance redSlider of ShermanColorSlider
	(properties
		view 5397
	)

	(method (init)
		(= x [local7 (* cel 2)])
		(= y [local7 (+ (* cel 2) 1)])
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 198 283 216 187 238 187 224 283
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(= sliderDir (- (* (< eY y) 2) 1))
				(+= cel sliderDir)
				(= cel (Min 4 (Max 0 cel)))
				(if (OneOf cel 0 4)
					(= sliderDir (if (< sliderDir 0) 1 else -1))
				)
				(self posn: [local7 (* cel 2)] [local7 (+ (* cel 2) 1)])
				(if local6
					(local5 updateBitmap:)
					(UpdateScreenItem local5)
					(if (local5 compareColor:)
						(gCurRoom setScript: solvedMonitor)
					)
				)
				(proc201_1 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance greenSlider of ShermanColorSlider
	(properties
		loop 5
		view 5397
	)

	(method (init)
		(= x [local17 (* cel 2)])
		(= y [local17 (+ (* cel 2) 1)])
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 240 284 251 187 274 187 268 284
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(= sliderDir (- (* (< eY y) 2) 1))
				(+= cel sliderDir)
				(= cel (Min 4 (Max 0 cel)))
				(if (OneOf cel 0 4)
					(= sliderDir (if (< sliderDir 0) 1 else -1))
				)
				(self posn: [local17 (* cel 2)] [local17 (+ (* cel 2) 1)])
				(if local6
					(local5 updateBitmap:)
					(UpdateScreenItem local5)
					(if (local5 compareColor:)
						(gCurRoom setScript: solvedMonitor)
					)
				)
				(proc201_1 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blueSlider of ShermanColorSlider
	(properties
		loop 6
		view 5397
	)

	(method (init)
		(= x [local27 (* cel 2)])
		(= y [local27 (+ (* cel 2) 1)])
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 288 284 288 187 309 187 309 284
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(= sliderDir (- (* (< eY y) 2) 1))
				(+= cel sliderDir)
				(= cel (Min 4 (Max 0 cel)))
				(if (OneOf cel 0 4)
					(= sliderDir (if (< sliderDir 0) 1 else -1))
				)
				(self posn: [local27 (* cel 2)] [local27 (+ (* cel 2) 1)])
				(if local6
					(local5 updateBitmap:)
					(UpdateScreenItem local5)
					(if (local5 compareColor:)
						(gCurRoom setScript: solvedMonitor)
					)
				)
				(proc201_1 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance powerButton of Button
	(properties
		x 284
		y 173
		loop 2
		view 5397
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 2
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 288 170 288 149 306 149 306 170
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(= local6 (not local6))
				(octoLairOpenSound number: 4207 loop: 1 play:)
				(if local6
					(monitorOne show:)
					(monitorTwo show:)
					(monitorThree show:)
				else
					(monitorOne hide:)
					(monitorTwo hide:)
					(monitorThree hide:)
				)
				(proc201_1 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance backupExit of ExitFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: -22 251 179 251 164 317 355 338 344 255 592 255 593 388 -14 390
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setDirCursor: backupCursor)
			)
			(else
				(if gVMDMovie
					(gVMDMovie mouseDownAction: 1)
				)
				(gCurRoom pitch: 1)
			)
		)
	)
)

(instance backupCursor of View
	(properties
		cel 5
		view 600
	)
)

(instance solvedMonitor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 60)
			)
			(1
				(local5 hide:)
				(= cycles 30)
			)
			(2
				(local5 show:)
				(= cycles 30)
			)
			(3
				(local5 hide:)
				(= cycles 30)
			)
			(4
				(local5 show:)
				(= cycles 30)
			)
			(5
				(local5 hide:)
				(= cycles 30)
			)
			(6
				(local5 show:)
				(= cycles 30)
			)
			(7
				(local5 hide:)
				(= cycles 30)
			)
			(8
				(local5 solveMonitor:)
				(if
					(and
						(& [global227 0] $f000)
						(& [global227 1] $f000)
						(& [global227 2] $f000)
					)
					(SetFlag 240)
					(octoLairOpenSound number: 5250 loop: 1 play: self)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(9
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance octoLairOpenSound of Sound
	(properties)
)

