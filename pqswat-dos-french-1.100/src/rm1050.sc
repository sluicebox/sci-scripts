;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1050)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1050 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm1050 of PQRoom
	(properties
		picture 1050
	)

	(method (init)
		(if (!= 10310 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10310)
			(gBackMusic number: 10310 loop: -1 play:)
			(Lock rsAUDIO 10310 1)
		)
		(Load rsSCRIPT 31 27 64960 64923)
		(Load rsHEAP 31 27 64960 64923)
		(Load rsVIEW 22 23 25 997 999)
		(Load rsAUDIO 50 51 53 57 58)
		(Load rsVIEW 1050 10)
		(super init: &rest)
		(northExit init:)
		(gCurRoom setScript: enterRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(self setScript: doFlashBang)
			)
			(7
				(self setScript: shootWall)
			)
			(6
				(self setScript: shootWall)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(if (not local0)
			(actionTimer setReal: actionTimer 3)
			(gGame handsOn:)
		)
	)

	(method (lashNotify)
		(switch local1
			(0
				(cond
					(
						(or
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
						(gCurRoom setScript: elementMoveRight)
					)
					(
						(or
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
						(gCurRoom setScript: elementMoveLeft)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(gCurRoom setScript: aRightOnly)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(gCurRoom setScript: bRightOnly)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(gCurRoom setScript: aLeftOnly)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(gCurRoom setScript: bLeftOnly)
					)
					((and (proc4_11 46) (== global149 1))
						(= local3 1)
						(gCurRoom setScript: elementMove)
					)
					((and (proc4_11 63) (== global149 1))
						(= local3 2)
						(gCurRoom setScript: elementMove)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local3 3)
						(gCurRoom setScript: elementMove)
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
						(= local4 67)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
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
						(= local4 16)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local4 77)
						(= local5 2)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					((and (proc4_11 18) (== global149 1))
						(= local4 87)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 1) (proc4_11 11) (== global149 2))
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 52) (== global149 1))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 40) (proc4_11 11) (== global149 2))
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 55) (== global149 1))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 39) (proc4_11 11) (== global149 2))
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 56) (== global149 1))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 38) (proc4_11 11) (== global149 2))
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 53) (== global149 1))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
						)
						(= local4 88)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
						)
						(= local4 89)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
						)
						(= local4 90)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(else
						(return -1)
					)
				)
			)
			(1
				(cond
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
						(= local4 67)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
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
						(= local4 16)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local4 77)
						(= local5 2)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					((and (proc4_11 18) (== global149 1))
						(= local4 87)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 1) (proc4_11 11) (== global149 2))
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 52) (== global149 1))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 40) (proc4_11 11) (== global149 2))
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 55) (== global149 1))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 39) (proc4_11 11) (== global149 2))
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 56) (== global149 1))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 38) (proc4_11 11) (== global149 2))
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 53) (== global149 1))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
						)
						(= local4 88)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
						)
						(= local4 89)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
						)
						(= local4 90)
						(= local5 7)
						(if (not local0)
							(actionTimer dispose: delete:)
							(gGame handsOff:)
						)
						(gMessager say: 1 local4 local5 0 self)
					)
					(else
						(return -1)
					)
				)
			)
		)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 10500 -5 -40)
			)
			(1
				(setUpElement doit: 1)
				(gMessager say: 1 77 2 0 self) ; "Entry team in building."
			)
			(2
				(actionTimer setReal: actionTimer 8)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance militiaManShoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 10314)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(2
				(gMessager say: 0 0 3 1 self) ; "Compromised!"
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
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

(instance elementMoveRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 43 50 10314)
				(Load rsVIEW 10507 10510 11901 986)
				(Load rsPIC 1190)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 10521 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10505 -5 -40 35 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
				(++ local1)
				(= local0 1)
				(= local2 1)
				(gGame handsOn:)
				(robotFeat init:)
			)
			(3)
			(4
				(gGame handsOff:)
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(5
				(if local0
					(proc4_5)
					(= local0 0)
				)
				(robotFeat dispose:)
				(gCurRoom drawPic: -1)
				(militiaMan dispose:)
				(gMessager say: 0 0 3 1 self) ; "Compromised!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(7
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance elementMoveLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6007)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10524 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10510 0 32 0 0 400 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(4
				(egoView dispose:)
				(gunShot dispose:)
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance aRightOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 10314)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10515 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10502 -7 -60 0 0 400 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(militiaMan init: cel: 0 setCycle: End)
			)
			(4
				(proc4_5)
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

(instance bRightOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 1050 6007)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10516 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10512 0 101 0 0 400 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(4
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(gFxSound number: 1050 setLoop: 1 play: self)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance aLeftOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 6007)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10513 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10503 0 -64 0 0 400 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(militiaMan init: cel: 0 setCycle: CT 25 1 self)
			)
			(4
				(gunShot dispose:)
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance bLeftOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6007)
				(Load rsVIEW 10504 10507)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10517 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(egoView init: setPri: 401 cel: 30 setCycle: CT 120 1 egoView)
				(proc4_6 10514 -85 -60 0 0 400 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(4
				(egoView dispose:)
				(gunShot dispose:)
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance elementMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 10314)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(switch local3
					(1
						(gGame showCloseUp: 10518 180 66 self 1)
					)
					(2
						(gGame showCloseUp: 10519 180 66 self 1)
					)
					(3
						(gGame showCloseUp: 10520 180 66 self 1)
					)
				)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10510 0 45 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(4
				(militiaMan dispose:)
				(proc4_5)
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

(instance doFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(if local2
					(Load rsVIEW 10501)
				else
					(Load rsVIEW 10509)
				)
				(Load rsAUDIO 1002 1003 50 10314 6007)
				(Load rsVIEW 6 1050 10508 10507)
				(= seconds 1)
			)
			(1
				(flashBang init: setCycle: End self)
			)
			(2
				(gunShot number: 1002 play:)
				(whiteScreen init:)
				(if local2
					(setUpElement doit: 0)
					(if local0
						(proc4_5)
						(= local0 0)
					)
					(dudes view: 10501 loop: 0 cel: 0 posn: 388 307 init:)
				else
					(setUpElement doit: 0)
					(dudes
						view: 10509
						loop: 0
						cel: 0
						posn: 0 382
						init:
						setPri: 400
					)
				)
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
				(dudes setCycle: End self)
			)
			(6
				(flashBang dispose:)
				(gMessager say: 0 16 0 0 self) ; "Status! Status!"
			)
			(7
				(militiaMan init: cel: 0 setCycle: CT 25 1 self)
			)
			(8
				(gunShot dispose:)
				(dudes dispose:)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(9
				(Lock rsAUDIO (gBackMusic number:) 0)
				(if local2
					(gBackMusic number: 10314 setLoop: 1 play: self)
				else
					(self cue:)
				)
			)
			(10
				(if local2
					(gCurRoom newRoom: 72) ; funeralRoom
				else
					(gBackMusic number: 6007 loop: 1 play:)
					(Lock rsAUDIO 6007 1)
					(SetFlag 94)
					(SetFlag 98)
					(gCurRoom newRoom: 35) ; metroExt
				)
			)
		)
	)
)

(instance shootWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 10314)
				(Load rsVIEW 10507)
				(= seconds 1)
			)
			(1
				(militiaMan init: cel: 0 setCycle: CT 25 1 self)
			)
			(2
				(gMessager say: 6 7 0 0 self) ; "Compromised!"
				(setUpElement doit: 0)
				(militiaMan dispose:)
				(gunShot dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
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

(instance shootYourFriend of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(if local0
					(proc4_5)
					(= local0 0)
				else
					(setUpElement doit: 0)
				)
				(gCurRoom drawPic: -1)
				(Load rsAUDIO 6007 10314)
				(= seconds 1)
			)
			(1
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 1)
			)
			(2
				(switch register
					(tello
						(gGame showCloseUp: 9028 180 66 self 1)
					)
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
					)
					(carmichael
						(gGame showCloseUp: 9008 180 66 self 1)
					)
					(wix
						(gGame showCloseUp: 9014 180 66 self 1)
					)
				)
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance timerExpires of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsAUDIO 10314)
				(= seconds 1)
			)
			(1
				(militiaMan setCycle: End self)
			)
			(2
				(gMessager say: 0 0 3 0 self) ; "Compromised!"
			)
			(3
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance do1190 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gCast contains: militiaMan)
					(militiaMan dispose:)
				)
				(proc4_5)
				(robotFeat dispose:)
				(badGuy1190 init:)
				(proc4_6 11900 327 129 0 0 -1 1)
				(gCurRoom drawPic: 1190)
			)
			(1)
			(2
				(badGuy1190 setCycle: End)
			)
			(3
				(badGuy1190 dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
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

(instance badGuy1190 of Prop
	(properties
		x 280
		y 131
		view 11901
	)

	(method (doit)
		(super doit:)
		(if (OneOf cel 33 38 45 50 54 66)
			(gunShot number: 43 play:)
		)
	)
)

(instance egoView of Prop
	(properties
		x 83
		y 360
		view 10504
	)

	(method (cue)
		(self setPri: 1)
	)
)

(instance militiaMan of Prop
	(properties
		x 340
		y 123
		view 10507
	)

	(method (doit)
		(if (OneOf cel 16 19 22 27 29 32 40)
			(gunShot number: 50 play:)
		)
		(super doit:)
	)
)

(instance denton of Prop
	(properties
		x 274
		y 426
		view 10500
		loop 1
	)

	(method (cue)
		(if (not local0)
			(gGame handsOn:)
			(actionTimer setReal: actionTimer 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(actionTimer dispose: delete:)
					(gGame handsOff:)
				)
				(gMessager say: 2 29 0 0 self) ; "Denton, you copy?"
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carmichael of Prop
	(properties
		x 274
		y 426
		view 10500
		loop 2
	)

	(method (cue)
		(if (not local0)
			(gGame handsOn:)
			(actionTimer setReal: actionTimer 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(actionTimer dispose: delete:)
					(gGame handsOff:)
				)
				(gMessager say: 3 29 0 0 self) ; "Carmichael, you copy?"
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tello of Prop
	(properties
		x 274
		y 426
		view 10500
	)

	(method (cue)
		(if (not local0)
			(gGame handsOn:)
			(actionTimer setReal: actionTimer 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(actionTimer dispose: delete:)
					(gGame handsOff:)
				)
				(gMessager say: 4 29 0 0 self) ; "Tello, you copy?"
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wix of Prop
	(properties)

	(method (cue)
		(if (not local0)
			(gGame handsOn:)
			(actionTimer setReal: actionTimer 3)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(actionTimer dispose: delete:)
					(gGame handsOff:)
				)
				(gMessager say: 5 29 0 0 self) ; "Wixell, you copy?"
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 162
		y 297
		view 10508
	)

	(method (doit)
		(super doit:)
		(if (and (== cel 8) (not (gunShot handle:)))
			(gunShot number: 1003 play:)
		)
	)
)

(instance dudes of Prop
	(properties)
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

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(actionManager doit:)
		(self dispose: delete:)
	)
)

(instance actionManager of Code
	(properties)

	(method (doit)
		(gCurRoom setScript: militiaManShoots)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(carmichael dispose:)
				(denton dispose:)
				(tello dispose:)
				(if (gCast contains: wix)
					(wix dispose:)
				)
			)
			(1
				(carmichael view: 10500 posn: 269 386 loop: 2 init:)
				(denton view: 10500 posn: 269 386 loop: 1 init:)
				(tello view: 10500 posn: 269 386 loop: 0 init:)
				(if (gCast contains: wix)
					(wix dispose:)
				)
			)
			(2
				(denton view: 10510 x: 366 y: 159 loop: 3 cel: 1 init:)
				(tello view: 10510 x: 366 y: 159 loop: 3 cel: 2 init:)
				(wix view: 10510 loop: 3 cel: 0 x: 366 y: 159 init:)
			)
		)
	)
)

(instance northExit of HotSpot
	(properties
		nsLeft 256
		nsTop 76
		nsRight 348
		nsBottom 221
		type 4097
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if local1
					(gCurRoom setScript: do1190)
				else
					(actionTimer dispose: delete:)
					(gCurRoom newRoom: 1110)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunShot of Sound
	(properties)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (not local0)
					(actionTimer dispose: delete:)
					(gGame handsOff:)
				)
				(gMessager say: 5 29 0 0 wix) ; "Wixell, you copy?"
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 wix)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 wix)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

