;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1110)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1110 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm1110 of PQRoom
	(properties
		picture 1110
	)

	(method (init)
		(super init:)
		(leftExit init:)
		(firstStack init:)
		(secondStack init:)
		(thirdStack init:)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(actionTimer setReal: actionTimer 30)
		else
			(actionTimer setReal: actionTimer 8)
		)
		(gDirectionHandler add: self)
		(gGame handsOn:)
	)

	(method (handleEvent event)
		(if (and (& (event type:) $0010) (== (event message:) JOY_LEFT)) ; direction
			(event claimed: 1)
			(actionTimer dispose: delete:)
			(gCurRoom newRoom: 1130)
		)
		(super handleEvent: event)
	)

	(method (lashNotify)
		(switch local0
			(0
				(cond
					(
						(or
							(and (proc4_11 45) (== global149 1))
							(and (proc4_11 62) (== global149 1))
							(and (proc4_11 45) (proc4_11 62) (== global149 2))
						)
						(= local4 1)
						(gCurRoom setScript: otherDudeScript)
					)
					(
						(or
							(and (proc4_11 47) (== global149 1))
							(and (proc4_11 64) (== global149 1))
							(and (proc4_11 14) (== global149 1))
							(and (proc4_11 47) (proc4_11 64) (== global149 2))
						)
						(= local4 2)
						(gCurRoom setScript: otherDudeScript)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
						)
						(= local4 3)
						(gCurRoom setScript: otherDudeScript)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
						)
						(= local4 4)
						(gCurRoom setScript: otherDudeScript)
					)
					(
						(or
							(and (proc4_11 46) (== global149 1))
							(and (proc4_11 63) (== global149 1))
							(and (proc4_11 46) (proc4_11 63) (== global149 2))
						)
						(= local2 62)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 4)
							)
							(and (proc4_11 49) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 49)
								(proc4_11 66)
								(proc4_11 63)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 66)
								(== global149 3)
							)
						)
						(= local2 64)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 4)
							)
							(and (proc4_11 50) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 50)
								(proc4_11 67)
								(proc4_11 63)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 67)
								(== global149 3)
							)
						)
						(= local2 74)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 48) (== global149 1))
							(and (proc4_11 65) (== global149 1))
							(and (proc4_11 48) (proc4_11 65) (== global149 2))
						)
						(= local2 98)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 48) (proc4_11 49) (== global149 2))
							(and (proc4_11 65) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 48)
								(proc4_11 49)
								(proc4_11 65)
								(proc4_11 66)
								(== global149 4)
							)
						)
						(= local2 99)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 48) (proc4_11 50) (== global149 2))
							(and (proc4_11 65) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 48)
								(proc4_11 50)
								(proc4_11 65)
								(proc4_11 67)
								(== global149 4)
							)
						)
						(= local2 100)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 47) (proc4_11 50) (== global149 2))
							(and (proc4_11 64) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 47)
								(proc4_11 50)
								(proc4_11 64)
								(proc4_11 67)
								(== global149 4)
							)
						)
						(= local2 97)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 47) (proc4_11 49) (== global149 2))
							(and (proc4_11 64) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 47)
								(proc4_11 49)
								(proc4_11 64)
								(proc4_11 66)
								(== global149 4)
							)
						)
						(= local2 96)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(proc4_11 11)
							(proc4_11 51)
							(proc4_11 68)
							(and (proc4_11 1) (proc4_11 11) (== global149 2))
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 52) (== global149 1))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 38) (proc4_11 11) (== global149 2))
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 53) (== global149 1))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
							(and (proc4_11 40) (proc4_11 11) (== global149 2))
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 55) (== global149 1))
							(and (proc4_11 72) (== global149 1))
						)
						(= local2 88)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and
								(or (proc4_11 59) (proc4_11 76))
								(== global149 1)
							)
							(and
								(or (proc4_11 57) (proc4_11 74))
								(or (proc4_11 59) (proc4_11 76))
								(== global149 2)
							)
						)
						(= local2 67)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 41) (== global149 2))
							(and
								(or (proc4_11 57) (proc4_11 74))
								(or (proc4_11 58) (proc4_11 75))
								(== global149 2)
							)
							(and
								(or (proc4_11 58) (proc4_11 75))
								(== global149 1)
							)
						)
						(= local2 16)
						(= local3 3)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 20) (== global149 1))
						(= local2 101)
						(= local3 2)
						(gCurRoom setScript: sayThis)
					)
					(else
						(return -1)
					)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(gCurRoom setScript: doFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance otherDudeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 11100)
				(= seconds 1)
			)
			(1
				(switch local4
					(1
						(gMessager say: 1 94 2 0 self) ; "Entry team, hold!"
					)
					(2
						(gMessager say: 1 95 2 0 self) ; "Provide cover."
					)
					(3
						(gMessager say: 1 89 2 0 self) ; "Suspect..."
					)
					(4
						(gMessager say: 1 90 2 0 self) ; "Hostage..."
					)
				)
			)
			(2
				(otherBadGuy init: setCycle: CT 24 1 self)
			)
			(3
				(gunShot dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 53 loop: 0 play: self)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance doFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 (actionTimer seconds:))
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002)
				(Load rsVIEW 6)
				(= seconds 1)
			)
			(1
				(whiteScreen init:)
				(gunShot number: 1002 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(2
				(whiteScreen dispose:)
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
				(actionTimer setReal: actionTimer local1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shootFirstStack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 53 10314)
				(Load rsVIEW 11101)
				(= seconds 1)
			)
			(1
				(militiaDude init: setCycle: CT 27 1 self)
			)
			(2
				(gunShot dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootSecondStack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314)
				(= seconds 1)
			)
			(1
				(proc4_6 11102 213 -12)
			)
			(2
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance timerExpires of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 53 10314)
				(Load rsVIEW 11101)
				(= seconds 1)
			)
			(1
				(militiaDude init: setCycle: CT 27 1 self)
			)
			(2
				(gunShot dispose:)
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(3
				(gFxSound number: 53 loop: 0 play: self)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance otherBadGuy of Prop
	(properties
		x 251
		y 387
		view 11100
	)

	(method (init)
		(self setPri: 350)
		(super init: &rest)
	)

	(method (doit)
		(if (and (not (gunShot handle:)) (OneOf cel 11 26))
			(gunShot number: 53 play:)
		)
		(super doit:)
	)
)

(instance militiaDude of Prop
	(properties
		x 320
		y 328
		view 11101
	)

	(method (init)
		(self setPri: 330)
		(super init: &rest)
	)

	(method (doit)
		(if (and (not (gunShot handle:)) (OneOf cel 21 26))
			(gunShot number: 53 play:)
		)
		(super doit:)
	)
)

(instance firstStack of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 120 131 225 113 266 122 265 227 334 231 337 357 66 358 65 324 122 313 115 179 122 178 120 131
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootFirstStack 0 7)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (OneOf (event message:) JOY_DOWNLEFT JOY_LEFT)
			((= temp0 (Prop new:))
				view: 11103
				posn: (event x:) (event y:)
				setLoop: 0
				setCel: 0
				setPri: 400
				init:
				yourself:
			)
			(if (== (event message:) JOY_LEFT)
				(super handleEvent: event)
				(event claimed:)
				(return)
			else
				(event claimed: 1)
				(return)
			)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance secondStack of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 344 331 344 180 450 183 453 276 493 281 493 336 482 347
					yourself:
				)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (OneOf (event message:) JOY_DOWNLEFT JOY_LEFT)
			((= temp0 (Prop new:))
				view: 11103
				posn: (event x:) (event y:)
				setLoop: 0
				setCel: 0
				setPri: 400
				init:
				yourself:
			)
			(if (== (event message:) JOY_LEFT)
				(super handleEvent: event)
				(event claimed:)
				(return)
			else
				(event claimed: 1)
				(return)
			)
		else
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootSecondStack)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance thirdStack of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 455 270 452 177 380 175 382 161 487 160 491 200 530 208 588 250 590 296 537 310
					yourself:
				)
		)
	)

	(method (handleEvent event &tmp temp0)
		(if (OneOf (event message:) JOY_DOWNLEFT JOY_LEFT)
			((= temp0 (Prop new:))
				view: 11103
				posn: (event x:) (event y:)
				setLoop: 0
				setCel: 0
				setPri: 320
				init:
				yourself:
			)
			(event claimed: 1)
			(return)
		else
			(super handleEvent: event &rest)
		)
	)
)

(instance leftExit of HotSpot
	(properties
		nsLeft 216
		nsTop 181
		nsRight 423
		nsBottom 358
		type 32771
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gCurRoom newRoom: 1130)
			)
			(55
				(actionTimer dispose: delete:)
				(gCurRoom newRoom: 1140)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: timerExpires)
		(self dispose: delete:)
	)
)

(instance gunShot of Sound
	(properties)
)

(instance sayThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 local2 local3 0 self)
			)
			(2
				(actionTimer setReal: actionTimer 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

