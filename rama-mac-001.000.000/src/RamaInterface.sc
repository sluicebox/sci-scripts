;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use thighComputer)
(use InvInitialize)
(use SaveManager)
(use Compass)
(use QuitDialog)
(use Button)
(use n1111)
(use DText)
(use Plane)
(use Str)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	RamaInterface 0
	proc90_1 1
	proc90_2 2
	ramanEyes 3
)

(local
	local0
	local1
	local2
)

(procedure (proc90_1)
	(SetFlag 1)
	(proc44_2)
)

(procedure (proc90_2)
	(ClearFlag 1)
	(proc44_3)
)

(class MonitorDlg of DText
	(properties
		back 0
		skip 0
		width 180
		widthSet 0
	)

	(method (init param1)
		(if (not text)
			(= text (KArray 8 (KArray 9 { }))) ; ArrayDup, ArrayGetData
		)
		(if (> argc 1)
			(self setText: &rest)
		)
		(self setSize: width)
		(super init: param1)
	)

	(method (dispose)
		(if text
			(KArray 4 text) ; ArrayFree
			(= text 0)
		)
		(= widthSet 0)
		(super dispose:)
	)

	(method (setText &tmp temp0)
		(if (not text)
			(= text (KArray 8 (KArray 9 { }))) ; ArrayDup, ArrayGetData
		)
		(KArray 6 text 0 (KArray 9 &rest) 0 -1) ; ArrayCpy, ArrayGetData
	)

	(method (setSize)
		(= widthSet 1)
		(super setSize: &rest)
	)

	(method (display)
		(if (not widthSet)
			(self setSize: width)
		)
		(self setText: &rest draw:)
	)
)

(class RamaInterface of Cast
	(properties
		priority 200
	)

	(method (displayOptionsText param1 param2 param3 param4 param5 &tmp temp0)
		(switch argc
			(1
				(optionsText display: param1)
			)
			(5
				(= temp0 (Str new:))
				(if
					(and
						(Message msgSIZE param1 param2 param3 param4 param5)
						(Message
							msgGET
							param1
							param2
							param3
							param4
							param5
							(temp0 data:)
						)
					)
					(optionsText display: (temp0 data:))
				else
					(optionsText display: { })
				)
				(temp0 dispose:)
			)
			(else
				(optionsText display: { })
			)
		)
	)

	(method (init)
		(interfacePlane priority: priority init: 0 0 639 479)
		(= plane interfacePlane)
		((= global124 plane) addCast: self drawPic: -2)
		((interfacePlane theFtrs:)
			add: optionsButton ramanEyes upArrow downArrow
			eachElementDo: #plane interfacePlane
			eachElementDo: #init
		)
		(self
			add:
				optionBar
				hiliteOptText
				optionsText
				interfaceBrdr
				leftEyeBall
				middleEyeBall
				rightEyeBall
			eachElementDo: #setPri priority
			eachElementDo: #plane plane
			eachElementDo: #init self
		)
		(gCast add: self)
		(= global112 self)
		(ramanEyes setHotspot: 11)
		(Lock rsFONT 0 1)
	)

	(method (dispose param1)
		(if (and argc param1)
			(ClearFlag 11)
			(Compass clear:)
			((interfacePlane casts:) delete: self)
			(gCast delete: self)
			(= global123 0)
			(super dispose:)
			(interfacePlane dispose:)
			(= plane 0)
		)
	)

	(method (handleEvent event)
		(ramanEyes handleEvent: event)
		(cond
			((not (gUser canInput:))
				(event claimed: 1)
				(return)
			)
			((or (super handleEvent: event) (plane handleEvent: event))
				(event claimed: 1)
				(return)
			)
			(else
				(self displayOptionsText:)
				(return 0)
			)
		)
	)

	(method (displayBombCtr)
		(if (not (BombOptionsDisplay isActive:))
			(BombOptionsDisplay init: self)
		)
	)

	(method (killBombCtr)
		(if (BombOptionsDisplay isActive:)
			(BombOptionsDisplay hide: dispose:)
		)
	)

	(method (updateBombCtr)
		(if (and (== gNewRoomNum gCurRoomNum) (BombOptionsDisplay isActive:))
			(BombOptionsDisplay update: &rest)
		)
	)

	(method (doit)
		(if (BombOptionsDisplay isActive:)
			(BombOptionsDisplay doit:)
		)
		(super doit: &rest)
	)

	(method (serialize param1 &tmp temp0 temp1)
		(if (and argc param1)
			(InventoryWindow clear:)
			(= temp0 (SaveManager readWord:))
			((ScriptID 70 12) serialize: param1) ; playersInventory
			((ScriptID 70 13) serialize: param1) ; falstaffInventory
			(if (== temp0 -2)
				(= gInventory (ScriptID 70 12)) ; playersInventory
			else
				(= gInventory (ScriptID 70 13)) ; falstaffInventory
			)
			(for ((= temp1 0)) (<= temp1 123) ((++ temp1))
				((proc70_6 temp1) serialize: param1)
			)
			(InventoryWindow serialize: param1)
			(Palette 4 global177) ; PalSetGamma
			(gGame masterVolume: (Min (* global176 8) 127))
		else
			(SaveManager writeWord: (gInventory owner:))
			((ScriptID 70 12) serialize: param1) ; playersInventory
			((ScriptID 70 13) serialize: param1) ; falstaffInventory
			(for ((= temp1 0)) (<= temp1 123) ((++ temp1))
				((proc70_6 temp1) serialize: param1)
			)
			(InventoryWindow serialize: param1)
		)
	)
)

(instance optionBar of Actor
	(properties
		x -230
		y 107
		view 200
		cel 2
		xStep 10
		moveSpeed 0
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 7 125 172 125 202 155 202 241 200 248 193 254 185 257 7 257
					yourself:
				)
		)
		(self setPri: 240 ignoreActors: 1)
		(hiliteOptText hide:)
	)

	(method (show &tmp temp0)
		(self setMotion: MoveTo 30 107)
		(RamaInterface displayOptionsText:)
		(while (!= x 30)
			(= temp0 (Event new:))
			(temp0 dispose:)
			(if mover
				(mover doit:)
				(UpdateScreenItem self)
				(FrameOut)
				(self motionCue:)
			)
		)
		(self cue:)
	)

	(method (hide)
		(volumeSlider dispose:)
		(brightnessSlider dispose:)
		(hiliteOptText hide:)
		(self setMotion: MoveTo -230 107)
		(optionsPressed dispose:)
	)

	(method (cue &tmp temp0)
		(volumeSlider init: RamaInterface)
		(brightnessSlider init: RamaInterface)
		(while (> x -230)
			(switch gQuit
				(1
					(break)
				)
				(2
					(QuitDialog doit:)
				)
			)
			(= temp0 (Event new:))
			(= gMouseX (temp0 x:))
			(= gMouseY (temp0 y:))
			(self handleEvent: temp0)
			(FrameOut)
			(temp0 dispose:)
			(if mover
				(mover doit:)
				(UpdateScreenItem self)
				(FrameOut)
				(self motionCue:)
			)
		)
		(if local0
			(gGame panelObj: local0 panelSelector: local1)
			(= local0 (= local1 0))
		)
	)

	(method (onMe param1)
		(return (and (<= 30 (param1 x:) 218) (<= 122 (param1 y:) 255)))
	)

	(method (handleEvent event)
		(cond
			(mover
				(event claimed: 1)
			)
			((< x 0))
			((event claimed:))
			((== (event type:) evNULL)
				(event claimed: 1)
				(if (self onMe: event)
					(cond
						((< 123 gMouseY 150)
							(if
								(and
									(proc1111_24 14)
									(proc1111_24 94)
									(proc1111_24 1)
									(!= gCurRoomNum 1013)
								)
								(hiliteOptText loop: 2 y: 134 show:)
								(UpdateScreenItem hiliteOptText)
							else
								(hiliteOptText hide:)
							)
							(volumeSlider setLoop: 8)
							(UpdateScreenItem volumeSlider)
							(brightnessSlider setLoop: 10)
							(UpdateScreenItem brightnessSlider)
						)
						((< 149 gMouseY 169)
							(if
								(and
									(proc1111_24 14)
									(proc1111_24 94)
									(proc1111_24 1)
									(!= gCurRoomNum 1013)
								)
								(hiliteOptText loop: 3 y: 154 show:)
								(UpdateScreenItem hiliteOptText)
							else
								(hiliteOptText hide:)
							)
							(volumeSlider setLoop: 8)
							(UpdateScreenItem volumeSlider)
							(brightnessSlider setLoop: 10)
							(UpdateScreenItem brightnessSlider)
						)
						((< 168 gMouseY 191)
							(hiliteOptText loop: 4 y: 175 show:)
							(volumeSlider setLoop: 9)
							(UpdateScreenItem volumeSlider)
							(UpdateScreenItem hiliteOptText)
							(brightnessSlider setLoop: 10)
							(UpdateScreenItem brightnessSlider)
						)
						((< 190 gMouseY 213)
							(hiliteOptText loop: 5 y: 196 show:)
							(UpdateScreenItem hiliteOptText)
							(brightnessSlider setLoop: 11)
							(UpdateScreenItem brightnessSlider)
							(volumeSlider setLoop: 8)
							(UpdateScreenItem volumeSlider)
						)
						((< 212 gMouseY 235)
							(if
								(and
									(proc1111_24 14)
									(proc1111_24 94)
									(proc1111_24 1)
									(!= gCurRoomNum 1013)
								)
								(hiliteOptText loop: 6 y: 217 show:)
								(UpdateScreenItem hiliteOptText)
							else
								(hiliteOptText hide:)
							)
							(volumeSlider setLoop: 8)
							(UpdateScreenItem volumeSlider)
							(brightnessSlider setLoop: 10)
							(UpdateScreenItem brightnessSlider)
						)
						((< 234 gMouseY 263)
							(hiliteOptText loop: 7 y: 240 show:)
							(UpdateScreenItem hiliteOptText)
							(volumeSlider setLoop: 8)
							(UpdateScreenItem volumeSlider)
							(brightnessSlider setLoop: 10)
							(UpdateScreenItem brightnessSlider)
						)
						(else
							(hiliteOptText hide:)
							(volumeSlider setLoop: 8)
							(UpdateScreenItem volumeSlider)
							(brightnessSlider setLoop: 10)
							(UpdateScreenItem brightnessSlider)
						)
					)
				else
					(hiliteOptText hide:)
					(volumeSlider setLoop: 8)
					(UpdateScreenItem volumeSlider)
					(brightnessSlider setLoop: 10)
					(UpdateScreenItem brightnessSlider)
				)
			)
			((& (event type:) evMOUSEBUTTON)
				(if (> x 0)
					(if (self onMe: event)
						(cond
							((< 123 gMouseY 150)
								(if
									(and
										(proc1111_24 14)
										(proc1111_24 94)
										(proc1111_24 1)
										(!= gCurRoomNum 1013)
									)
									(= local0 gGame)
									(= local1 82)
									(self hide:)
								)
							)
							((< 140 gMouseY 169)
								(if
									(and
										(proc1111_24 14)
										(proc1111_24 1)
										(proc1111_24 94)
										(!= gCurRoomNum 1013)
									)
									(= local0 gGame)
									(= local1 83)
									(self hide:)
								)
							)
							((< 168 gMouseY 191)
								(if (volumeDownButton plane:)
									(volumeDownButton handleEvent: event)
									(volumeUpButton handleEvent: event)
								)
							)
							((< 190 gMouseY 213)
								(if (darkerButton plane:)
									(darkerButton handleEvent: event)
									(brighterButton handleEvent: event)
								)
							)
							((< 212 gMouseY 235)
								(if
									(and
										(proc1111_24 14)
										(proc1111_24 94)
										(proc1111_24 1)
										(!= gCurRoomNum 1013)
									)
									(= local0 gGame)
									(= local1 104)
									(self hide:)
								)
							)
							((< 234 gMouseY 263)
								(= local0 gGame)
								(= local1 103)
								(self hide:)
							)
							(else
								(= local0 (= local1 0))
								(self hide:)
							)
						)
					else
						(= local0 (= local1 0))
						(self hide:)
					)
					(event claimed: 1)
				)
			)
			(else
				(hiliteOptText hide:)
			)
		)
	)
)

(instance hiliteOptText of View
	(properties
		x 36
		view 1000
	)

	(method (init)
		(super init: &rest)
		(self setPri: 254 ignoreActors: 1)
		(self hide:)
	)

	(method (show)
		(if (> (optionBar x:) 0)
			(super show:)
		)
	)
)

(instance volumeSlider of View
	(properties
		x 133
		y 174
		view 1000
		cel 15
	)

	(method (init)
		(= loop 8)
		(= cel global176)
		(super init: global112)
		(self setPri: 253)
	)

	(method (setCel param1)
		(cond
			((< param1 0)
				(= param1 0)
			)
			((> param1 16)
				(= param1 16)
			)
		)
		(super setCel: param1)
		(UpdateScreenItem self)
		(FrameOut)
		(= global176 param1)
		(gGame masterVolume: (Min (* param1 8) 127))
	)

	(method (setLoop param1)
		(super setLoop: param1)
		(switch param1
			(8
				(volumeDownButton dispose:)
				(volumeUpButton dispose:)
			)
			(9
				(volumeDownButton init:)
				(volumeUpButton init:)
			)
		)
	)

	(method (dispose)
		(volumeDownButton dispose:)
		(volumeUpButton dispose:)
		(super dispose: &rest)
	)
)

(instance brightnessSlider of View
	(properties
		x 133
		y 195
		view 1000
	)

	(method (init)
		(= loop 9)
		(= cel global177)
		(super init: global112)
		(self setPri: 253)
	)

	(method (setCel param1)
		(cond
			((< param1 0)
				(= param1 0)
			)
			((> param1 5)
				(= param1 5)
			)
		)
		(super setCel: param1)
		(= global177 cel)
		(Palette 4 global177) ; PalSetGamma
		(UpdateScreenItem self)
		(FrameOut)
	)

	(method (setLoop param1)
		(super setLoop: param1)
		(switch param1
			(10
				(darkerButton dispose:)
				(brighterButton dispose:)
			)
			(11
				(darkerButton init:)
				(brighterButton init:)
			)
		)
	)

	(method (dispose)
		(darkerButton dispose:)
		(brighterButton dispose:)
		(super dispose: &rest)
	)
)

(instance volumeDownButton of Button
	(properties
		x 133
		y 174
		view 1000
		loop 12
		downCel 0
		doVerbCalled 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global112)
		(self setPri: 254)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(volumeSlider setCel: (- (volumeSlider cel:) 1))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance volumeUpButton of Button
	(properties
		x 213
		y 174
		view 1000
		loop 12
		downCel 0
		doVerbCalled 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global112)
		(self setPri: 255)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(volumeSlider setCel: (+ (volumeSlider cel:) 1))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance darkerButton of Button
	(properties
		x 133
		y 195
		view 1000
		loop 12
		downCel 0
		doVerbCalled 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global112)
		(self setPri: 254)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(brightnessSlider setCel: (- (brightnessSlider cel:) 1))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance brighterButton of Button
	(properties
		x 213
		y 195
		view 1000
		loop 12
		downCel 0
		doVerbCalled 1
	)

	(method (init)
		(&= signal $efff)
		(super init: global112)
		(self setPri: 254)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(brightnessSlider setCel: (+ (brightnessSlider cel:) 1))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance interfaceBrdr of View
	(properties
		view 200
	)

	(method (init)
		(super init: &rest)
		(self setPri: 249 ignoreActors: 1)
	)
)

(instance optText of View ; UNUSED
	(properties
		x 110
		y 35
		view 400
	)
)

(instance interfacePlane of Plane
	(properties)
)

(class InterfaceFeature of Feature
	(properties
		modNum 90
		ticks 0
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 31 11 9 2)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 1) 31) ; ramanNormalCursor
				(RamaInterface displayOptionsText: modNum noun 0 case 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ramanEyes of InterfaceFeature
	(properties
		noun 2
		case 4
		nsLeft 40
		nsTop 344
		nsRight 210
		nsBottom 414
	)

	(method (init)
		(super init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:))
			((== (event type:) evNULL)
				(if
					(and
						(self onMe: event)
						(or (gTheCursor isInvCursor:) (== gCurRoomNum 15)) ; prologue
					)
					(leftEyeBall move: (event x:) (event y:))
					(middleEyeBall move: (event x:) (event y:))
					(rightEyeBall move: (event x:) (event y:))
				else
					(leftEyeBall center:)
					(middleEyeBall center:)
					(rightEyeBall center:)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (gTheCursor isInvCursor:)
					(gTheCursor hilite:)
					(RamaInterface displayOptionsText: modNum noun 0 case 1)
				)
			)
			(else
				(if (gTalkers size:)
					(gMessager cue: 1)
				)
				(cond
					((== 39 (proc70_7 (gTheCursor invItem:)))
						(if (proc1111_24 1)
							(proc90_1)
						)
					)
					((IsFlag 14)
						((ScriptID 75 0) resetInvObj: (gTheCursor invItem:)) ; InvInset
					)
					((or (not gCurRoom) (and gCurRoom (not (gCurRoom inset:))))
						(if (IsFlag 1)
							(proc90_2)
						)
						((ScriptID 75 0) ; InvInset
							init: 0 gCurRoom 0 0 (gTheCursor invItem:)
						)
					)
				)
			)
		)
	)
)

(class InterfaceView of View
	(properties
		modNum 90
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 1) 31) ; ramanNormalCursor
				(RamaInterface displayOptionsText: modNum noun 0 case 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance upArrowPressed of View
	(properties
		x 575
		y 392
		view 200
		cel 5
	)
)

(instance downArrowPressed of View
	(properties
		x 576
		y 431
		view 200
		cel 4
	)
)

(instance upArrow of InterfaceFeature
	(properties
		noun 5
		case 4
		nsLeft 575
		nsTop 359
		nsRight 616
		nsBottom 392
	)

	(method (init)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: plane)
		(cond
			((and (not (event type:)) (self onMe: event))
				(if local2
					(self doVerb: 31)
				)
				(super handleEvent: event)
			)
			((and (self onMe: event) (& (event type:) evMOUSEBUTTON))
				(= ticks gGameTime)
				(= local2 1)
				(upArrowPressed init: global112)
				(self doVerb: 31)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			((& (event type:) evMOUSERELEASE)
				(= local2 0)
				(upArrowPressed dispose:)
				(event globalize:)
			)
			(else
				(event globalize:)
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31
				(if (and gInventory (<= ticks gGameTime))
					(gInventory scrollUp:)
					(= ticks (+ gGameTime 10))
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance downArrow of InterfaceFeature
	(properties
		noun 6
		case 4
		nsLeft 576
		nsTop 395
		nsRight 612
		nsBottom 430
	)

	(method (init)
		(super init: &rest)
	)

	(method (handleEvent event)
		(event localize: plane)
		(cond
			((and (not (event type:)) (self onMe: event))
				(if local2
					(self doVerb: 31)
				)
				(super handleEvent: event)
			)
			((and (self onMe: event) (& (event type:) evMOUSEBUTTON))
				(= ticks gGameTime)
				(= local2 1)
				(downArrowPressed init: global112)
				(self doVerb: 31)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			((& (event type:) evMOUSERELEASE)
				(= local2 0)
				(downArrowPressed dispose:)
				(event globalize:)
			)
			(else
				(event globalize:)
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31
				(if (and gInventory (<= ticks gGameTime))
					(gInventory scrollDown:)
					(= ticks (+ gGameTime 10))
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance optionsPressed of View
	(properties
		x 29
		y 37
		view 200
		cel 3
	)

	(method (init)
		(self setPri: 254)
		(super init: &rest)
	)
)

(instance optionsButton of InterfaceFeature
	(properties
		noun 4
		case 4
		nsLeft 34
		nsTop 10
		nsRight 69
		nsBottom 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31
				(optionsPressed init: global112)
				(UpdateScreenItem optionsPressed)
				(FrameOut)
				(if (== gCurRoomNum 15) ; prologue
					(gCurRoom newRoom: 1015) ; easyPickins
				else
					(optionBar show:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance optionsText of MonitorDlg
	(properties
		x 110
		y 15
		priority 254
		fixPriority 1
		fore 218
		back 222
		skip 222
		font 0
	)

	(method (init param1)
		(self setPri: 254 ignoreActors: 1)
		(super init: param1)
	)
)

(class RamanEyeBall of Prop
	(properties
		view 201
		loop 2
		cel 2
	)

	(method (init)
		(self setPri: 254 ignoreActors: 1)
		(super init: &rest)
	)

	(method (center)
		(if (and (or (!= cel 2) (!= loop 2)) (not script))
			(self setScript: (returnToCenter new:))
		)
	)

	(method (move param1 param2 &tmp temp0)
		(if script
			(script dispose:)
		)
		(cond
			((< (= temp0 (/ (- param2 y) 7)) 0)
				(switch temp0
					(-1
						(= loop 1)
					)
					(else
						(= loop 0)
					)
				)
			)
			((== temp0 0)
				(= loop 2)
			)
			(else
				(switch temp0
					(1
						(= loop 3)
					)
					(else
						(= loop 4)
					)
				)
			)
		)
		(cond
			((< (= temp0 (/ (- param1 x) 7)) 0)
				(switch temp0
					(-1
						(= cel 3)
					)
					(else
						(= cel 4)
					)
				)
			)
			((== temp0 0)
				(= cel 2)
			)
			(else
				(switch temp0
					(1
						(= cel 1)
					)
					(else
						(= cel 0)
					)
				)
			)
		)
	)
)

(instance leftEyeBall of RamanEyeBall
	(properties
		x 65
		y 386
	)
)

(instance middleEyeBall of RamanEyeBall
	(properties
		x 103
		y 379
		view 202
	)
)

(instance rightEyeBall of RamanEyeBall
	(properties
		x 143
		y 386
		view 203
	)
)

(instance returnToCenter of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(= temp1 0)
		(= temp0 0)
		(switch (= state newState)
			(0
				(= ticks 6)
			)
			(1
				(cond
					((< (client cel:) 2)
						(client cel: (+ (client cel:) 1))
					)
					((> (client cel:) 2)
						(client cel: (- (client cel:) 1))
					)
					(else
						(= temp0 1)
					)
				)
				(cond
					((< (client loop:) 2)
						(client loop: (+ (client loop:) 1))
					)
					((> (client loop:) 2)
						(client loop: (- (client loop:) 1))
					)
					(else
						(= temp1 1)
					)
				)
				(if (and temp1 temp0)
					(self dispose:)
				else
					(self changeState: 0)
				)
			)
		)
	)
)

(class BombOptionsDisplay of Obj
	(properties
		timeStr 0
		inited 0
	)

	(method (init param1)
		(= inited 1)
		(super init: &rest)
		(Load rsAUDIO 5012)
	)

	(method (hide)
		(if timeStr
			(timeStr dispose:)
		)
		(= timeStr 0)
	)

	(method (update param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0 (/ param1 3600))
		(= temp1 (/ (= temp2 (/ (= temp5 (mod param1 3600)) 60)) 10))
		(= temp2 (mod temp2 10))
		(= temp3 (/ (= temp5 (mod temp5 60)) 10))
		(= temp4 (mod temp5 10))
		(if timeStr
			(timeStr dispose:)
		)
		(= timeStr (Str format: {%d:%d%d:%d%d} temp0 temp1 temp2 temp3 temp4))
		(if (or (not temp4) (and (not temp0) (not temp1) (not temp2)))
			(bombTimerSnd play:)
		)
	)

	(method (isActive)
		(return inited)
	)

	(method (doit)
		(if timeStr
			(RamaInterface displayOptionsText: timeStr)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(self hide:)
		(= inited 0)
		(super dispose: &rest)
	)
)

(instance bombTimerSnd of Sound
	(properties
		flags 5
		number 5012
	)
)

(instance computerSnd of Sound ; UNUSED
	(properties
		flags 5
		number 1013
	)
)

