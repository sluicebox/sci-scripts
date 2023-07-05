;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1530)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use swatInvInit)
(use HotSpot)
(use Osc)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1530 0
)

(local
	local0
	local1
	local2
)

(instance rm1530 of PQRoom
	(properties
		picture 1530
	)

	(method (init)
		(if (!= 10304 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10304)
			(gBackMusic number: 10304 loop: -1 play:)
			(Lock rsAUDIO 10304 1)
		)
		(Load rsVIEW 15300)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init:)
		(= global114 myShootCode)
		(southExit init:)
		(leftWindow init:)
		(rightWindow init:)
		(self setScript: enterRoom)
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(self setScript: shootRoom 0 theVerb)
			)
			(6
				(self setScript: shootRoom 0 theVerb)
			)
			(16
				(self setScript: tossBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify)
		(if (and (proc4_11 22) (proc4_11 10) (== global149 2))
			(if (not local1)
				(= local1 1)
				(gCurRoom setScript: callEMT)
			)
		else
			(gCurRoom setScript: whatDidYouSay)
			(return -1)
		)
	)

	(method (dispose)
		(= global114 0)
		(proc4_5)
		(actionTimer dispose: delete:)
		(emtTimer dispose: delete:)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 15300 267 138 0 0 400)
			)
			(1
				(proc4_5)
				(mrEastman setPri: 400 init:)
				(actionTimer setReal: actionTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance southCase2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(emtTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 14715)
				(Load rsPIC 1480)
				(= seconds 2)
			)
			(1
				(if (gCast contains: mrEastman)
					(mrEastman dispose:)
				)
				(gCurRoom drawPic: 1480)
				(proc4_6 14802 363 60)
			)
			(2
				(gFxSound number: 14715 setLoop: 1 play: self)
			)
			(3
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance southCase4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(emtTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 14715 10314)
				(Load rsVIEW 14715)
				(Load rsPIC 1470)
				(= seconds 2)
			)
			(1
				(mrEastman dispose:)
				(gCurRoom drawPic: 1470)
				(militiaMan view: 14715 posn: 212 234 init: setPri: 10)
				(gMessager say: 0 0 1 1 0 1470) ; "EMT in and heading towards hostage."
				(proc4_6 14714 0 39)
			)
			(2
				(militiaMan setCycle: End)
			)
			(3
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(gFxSound number: 14715 setLoop: 1 play: self)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootEastman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(emtTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 48 50 51 52 6007 10314)
				(= seconds 1)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gGame showCloseUp: 15303 180 66 self 1)
			)
			(3
				(gMessager say: 1 7 0 0 self) ; "Cease firing! Cease firing!"
			)
			(4
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(SetFlag 93)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(emtTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 43 48 50 51 52 14618 10314)
				(Load rsVIEW 14618 15303)
				(Load rsPIC 1461)
				(= seconds 2)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(if (== local2 2)
									(backHoles init:)
								else
									(sideHoles init:)
								)
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(if (== local2 2)
									(backHoles init: setCycle: End)
								else
									(sideHoles init: setCycle: End)
								)
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(if (== local2 2)
							(backHoles init:)
						else
							(sideHoles init:)
						)
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gMessager sayRange: 3 6 0 1 2 self) ; "Compromised!"
				(gFxSound number: 14618 setLoop: 2 play: self)
			)
			(3)
			(4
				(mrEastman dispose:)
				(if (gCast contains: backHoles)
					(backHoles dispose:)
				)
				(if (gCast contains: sideHoles)
					(sideHoles dispose:)
				)
				(gCurRoom drawPic: 1461)
				(militiaMan view: 14618 posn: 318 191 init: setCycle: Osc -1)
				(proc4_6 14698 151 84 0 0 215)
			)
			(5
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(7
				(= global415 0)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootWall of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
				(gGame handsOff:)
				(Load rsAUDIO 43 10314)
				(Load rsVIEW 14691)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(gCurRoom drawPic: 1460)
				(militiaMan init: setCycle: End self)
				(proc4_6 14698 151 84)
			)
			(2
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance tossBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(emtTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1003 6007 10314)
				(Load rsVIEW 6 15302)
				(= seconds 2)
			)
			(1
				(proc4_5)
				(mrEastman
					x: 377
					y: 423
					view: 15302
					cel: 0
					init:
					setLoop: 0
					setCycle: End self
				)
				(gFxSound number: 1003 setLoop: 0 play: self)
			)
			(2
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 0 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(mrEastman dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gMessager sayRange: 4 16 0 1 2 self) ; "Compromised!"
			)
			(7
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(8
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(SetFlag 93)
				(SetFlag 103)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance talkToEastman of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(mrEastman dispose:)
				(proc4_6 15300 267 138 55 0 400 1)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance callEMT of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 2 82 2 0 self) ; "Hostage down. EMT! 1-2 corner, left office."
			)
			(1
				(emtTimer setReal: emtTimer 10)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance emtEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 0 0 3 0 self) ; "EMT in and heading for hostage."
			)
			(1
				(emtGuy init: setCycle: End self)
			)
			(2
				(if (mrEastman script:)
					(-- state)
				)
				(self cue:)
			)
			(3
				(= global415 1)
				(gCurRoom newRoom: 1460)
			)
		)
	)
)

(instance shootRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(emtTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 48 50 51 52 14715 10314)
				(Load rsVIEW 14715)
				(Load rsPIC 1470)
				(= seconds 2)
			)
			(1
				(switch register
					(7
						(switch (((proc19_3 3) data:) weaponSetting:)
							(0
								(gFxSound number: 48 setLoop: 0 play: self)
							)
							(1
								(gFxSound number: 51 setLoop: 0 play: self)
							)
							(2
								(gFxSound number: 52 setLoop: 0 play: self)
							)
						)
					)
					(6
						(gFxSound number: 50 setLoop: 0 play: self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(mrEastman dispose:)
				(gCurRoom drawPic: 1470)
				(militiaMan view: 14715 posn: 212 234 init: setPri: 10)
				(proc4_6 14714 0 39)
			)
			(3
				(militiaMan setCycle: End)
			)
			(4
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance mrEastman of Prop
	(properties
		x 391
		y 182
		view 15300
	)

	(method (cue)
		(gGame handsOn:)
		(actionTimer setReal: actionTimer 10)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(++ local0)
					(gCurRoom setScript: talkToEastman)
				else
					(super doVerb: theVerb)
				)
			)
			(7
				(gCurRoom setScript: shootEastman 0 theVerb)
			)
			(6
				(gCurRoom setScript: shootEastman 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance militiaMan of Prop
	(properties
		x 245
		y 196
		view 14691
	)

	(method (doit)
		(super doit:)
		(cond
			((== view 14715)
				(if (and (== cel 6) (not (sound1 handle:)))
					(sound1 number: 14715 play:)
				)
			)
			((== view 14618)
				(if (and (== cel 6) (not (sound1 handle:)))
					(sound1 number: 43 play:)
				)
			)
			((== view 14691)
				(if (and (== cel 11) (not (sound1 handle:)))
					(sound1 number: 43 play:)
				)
				(if (and (== cel 18) (not (sound2 handle:)))
					(sound2 number: 43 play:)
				)
			)
		)
	)
)

(instance emtGuy of Prop
	(properties
		x 638
		y 428
		view 15301
	)
)

(instance backHoles of Prop
	(properties
		x 476
		y 5
		view 15303
		loop 1
	)
)

(instance sideHoles of Prop
	(properties
		x 45
		y 20
		view 15303
	)
)

(instance leftWindow of Feature
	(properties
		nsTop 17
		nsRight 191
		nsBottom 165
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local2 1)
				(gCurRoom setScript: shootWindow 0 theVerb)
			)
			(6
				(= local2 1)
				(gCurRoom setScript: shootWindow 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rightWindow of Feature
	(properties
		nsLeft 463
		nsRight 638
		nsBottom 119
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local2 2)
				(gCurRoom setScript: shootWindow 0 theVerb)
			)
			(6
				(= local2 2)
				(gCurRoom setScript: shootWindow 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of HotSpot
	(properties
		nsTop 290
		nsRight 639
		nsBottom 360
		type 16385
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(cond
					((and local1 (not local0))
						(gCurRoom setScript: southCase4)
					)
					((and local0 (not local1))
						(gCurRoom setScript: southCase2)
					)
					((and (not local1) (not local0))
						(gCurRoom setScript: southCase2)
					)
					(else
						(gCurRoom setScript: southCase4)
					)
				)
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
		(= global415 0)
		(gCurRoom setScript: southCase2)
		(self dispose: delete:)
	)
)

(instance emtTimer of Timer
	(properties)

	(method (cue)
		(if (and gAutoRobot (== (gAutoRobot robot:) 15300))
			(self setReal: self 10)
		else
			(gCurRoom setScript: emtEnters)
			(self dispose: delete:)
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

(instance sound1 of Sound
	(properties)
)

(instance sound2 of Sound
	(properties)
)

(instance whatDidYouSay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 143 0 1 self) ; "Repeat!"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance myShootCode of Code
	(properties)

	(method (doit)
		(return 0)
	)
)

