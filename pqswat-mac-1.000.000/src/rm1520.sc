;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1520)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1520 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm1520 of PQRoom
	(properties
		picture 1520
	)

	(method (init)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(= gPrevRoomNum 1390)
		)
		(if (!= 6006 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10303)
			(gBackMusic number: 10303 loop: -1 play:)
			(Lock rsAUDIO 10303 1)
		)
		(Load rsSCRIPT 64960)
		(Load rsHEAP 64960)
		(Load rsMESSAGE 1520)
		(Load rsAUDIO 5)
		(Load rsVIEW 13 15207 59)
		(super init: &rest)
		(if (not (IsFlag 288))
			(= local1 1)
		)
		(if (!= gPrevRoomNum 1390)
			(door init:)
		)
		(if (== gPrevRoomNum 1390)
			(self setScript: comeOutWithBadGuys)
		else
			(self setScript: enterRoom)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(self setScript: shootWall 0 theVerb)
			)
			(7
				(self setScript: shootWall 0 theVerb)
			)
			(16
				(self setScript: tossFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (lashNotify param1)
		(switch local0
			(0
				(cond
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(if local1
							(gCurRoom setScript: openDoor)
						else
							(super lashNotify: param1)
						)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(if local1
							(gCurRoom setScript: timeOutNoHG)
						else
							(gCurRoom setScript: breachDoorHG)
						)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(gCurRoom setScript: shotgunDoor)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(if local1
							(= local3 65)
							(= local4 50)
							(gCurRoom setScript: sayThis)
						else
							(= local3 65)
							(= local4 13)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local3 70)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local3 72)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local3 85)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 18)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 47) (== global149 1))
							(and (proc4_11 14) (== global149 1))
							(and (proc4_11 47) (proc4_11 64) (== global149 2))
							(and (proc4_11 64) (== global149 1))
						)
						(= local3 95)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(if local1
							(= local3 86)
							(= local4 57)
							(gCurRoom setScript: sayThis)
						else
							(= local3 86)
							(= local4 15)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(if local1
							(= local3 73)
							(= local4 57)
							(gCurRoom setScript: sayThis)
						else
							(= local3 73)
							(= local4 15)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local3 71)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 19)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 20)
						(gCurRoom setScript: sayThis)
					)
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
						(if local1
							(= local3 74)
							(= local4 61)
							(gCurRoom setScript: sayThis)
						else
							(= local3 74)
							(= local4 16)
							(gCurRoom setScript: sayThis)
						)
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
						(if local1
							(= local3 64)
							(= local4 43)
							(gCurRoom setScript: sayThis)
						else
							(= local3 64)
							(= local4 16)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(if local1
							(= local3 62)
							(= local4 43)
							(gCurRoom setScript: sayThis)
						else
							(= local3 62)
							(= local4 16)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
						)
						(= local3 89)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
						)
						(= local3 90)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (== global149 1))
						(= local3 90)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 20) (== global149 1))
						(= local3 101)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 76) (== global149 1))
							(and (proc4_11 74) (proc4_11 76) (== global149 2))
							(and (proc4_11 75) (== global149 1))
							(and (proc4_11 74) (proc4_11 75) (== global149 2))
							(and (proc4_11 71) (== global149 1))
						)
						(gCurRoom setScript: timeOutNoHG)
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
							(and (proc4_11 47) (== global149 1))
							(and (proc4_11 14) (== global149 1))
							(and (proc4_11 47) (proc4_11 64) (== global149 2))
							(and (proc4_11 64) (== global149 1))
						)
						(= local3 95)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(if local1
							(gCurRoom setScript: breachDoorNoHG)
						else
							(super lashNotify: param1)
						)
					)
					((and (proc4_11 57) (== global149 1))
						(if local1
							(super lashNotify: param1)
						else
							(gCurRoom setScript: initBreachHG)
						)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(gCurRoom setScript: shotgunDoor)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(if local1
							(= local3 65)
							(= local4 50)
							(gCurRoom setScript: sayThis)
						else
							(= local3 65)
							(= local4 21)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 54) (== global149 1))
						(if local1
							(= local3 65)
							(= local4 51)
							(gCurRoom setScript: sayThis)
						else
							(= local3 65)
							(= local4 21)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(if local1
							(= local3 85)
							(= local4 14)
							(gCurRoom setScript: sayThis)
						else
							(= local3 85)
							(= local4 35)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local3 72)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 18)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local3 70)
						(= local4 14)
						(gCurRoom setScript: sayThis)
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
						(= local3 64)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
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
						(if local1
							(= local3 74)
							(= local4 61)
							(gCurRoom setScript: sayThis)
						else
							(= local3 74)
							(= local4 22)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 63) (== global149 1))
						(if local1
							(= local3 86)
							(= local4 57)
							(gCurRoom setScript: sayThis)
						else
							(= local3 86)
							(= local4 36)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local3 71)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(if local1
							(= local3 73)
							(= local4 57)
							(gCurRoom setScript: sayThis)
						else
							(= local3 73)
							(= local4 36)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 77) (== global149 1))
						(gCurRoom setScript: sayPosB)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(gCurRoom setScript: sayPos)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
							(and (proc4_11 21) (== global149 1))
						)
						(if local1
							(= local3 89)
							(= local4 48)
							(gCurRoom setScript: sayThis)
						else
							(= local3 89)
							(= local4 22)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
							(and (proc4_11 22) (== global149 1))
						)
						(if local1
							(= local3 90)
							(= local4 48)
							(gCurRoom setScript: sayThis)
						else
							(= local3 90)
							(= local4 22)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 20) (== global149 1))
						(= local3 101)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local3 62)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 76) (== global149 1))
							(and (proc4_11 74) (proc4_11 76) (== global149 2))
							(and (proc4_11 75) (== global149 1))
							(and (proc4_11 74) (proc4_11 75) (== global149 2))
							(and (proc4_11 71) (== global149 1))
						)
						(gCurRoom setScript: timeOutNoHG)
					)
					(else
						(return -1)
					)
				)
			)
			(2
				(cond
					(
						(or
							(and (proc4_11 47) (== global149 1))
							(and (proc4_11 64) (== global149 1))
							(and (proc4_11 14) (== global149 1))
							(and (proc4_11 47) (proc4_11 64) (== global149 2))
						)
						(= local3 95)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local3 72)
						(= local4 14)
						(gCurRoom setScript: sayThis)
						(++ local0)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(++ local0)
						(= local3 73)
						(= local4 57)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 49) (proc4_11 67) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 49)
								(proc4_11 63)
								(proc4_11 67)
								(== global149 4)
							)
						)
						(gCurRoom setScript: aLeftBRight)
					)
					(
						(or
							(and (proc4_11 50) (proc4_11 66) (== global149 2))
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 3)
							)
							(and
								(proc4_11 46)
								(proc4_11 50)
								(proc4_11 63)
								(proc4_11 66)
								(== global149 4)
							)
						)
						(gCurRoom setScript: aRightBLeft2)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 50)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 40) (proc4_11 11) (== global149 2))
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 55) (== global149 1))
							(and (proc4_11 72) (== global149 1))
						)
						(gCurRoom setScript: shotgunDoor)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local3 85)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local3 86)
						(= local4 57)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local3 62)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local3 70)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local3 71)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local3 72)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(= local3 73)
						(= local4 57)
						(gCurRoom setScript: sayThis)
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
						(= local3 64)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
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
						(= local3 74)
						(= local4 61)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 18)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 19)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 20)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
							(and (proc4_11 21) (== global149 1))
						)
						(if local1
							(= local3 89)
							(= local4 48)
							(gCurRoom setScript: sayThis)
						else
							(= local3 89)
							(= local4 43)
							(gCurRoom setScript: sayThis)
						)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
							(and (proc4_11 22) (== global149 1))
						)
						(if local1
							(= local3 90)
							(= local4 48)
							(gCurRoom setScript: sayThis)
						else
							(= local3 90)
							(= local4 43)
							(gCurRoom setScript: sayThis)
						)
					)
					((and (proc4_11 20) (== global149 1))
						(= local3 101)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 76) (== global149 1))
							(and (proc4_11 74) (proc4_11 76) (== global149 2))
							(and (proc4_11 75) (== global149 1))
							(and (proc4_11 74) (proc4_11 75) (== global149 2))
							(and (proc4_11 71) (== global149 1))
						)
						(gCurRoom setScript: timeOutNoHG)
					)
					(else
						(return -1)
					)
				)
			)
			(3
				(cond
					(
						(or
							(and (proc4_11 47) (== global149 1))
							(and (proc4_11 14) (== global149 1))
							(and (proc4_11 47) (proc4_11 64) (== global149 2))
							(and (proc4_11 64) (== global149 1))
						)
						(= local3 95)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local3 72)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local3 70)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local3 85)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 18)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 50)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 57) (== global149 1))
						(gCurRoom setScript: initBreachNoHG)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(gCurRoom setScript: shotgunDoor)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local3 71)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(= local3 73)
						(= local4 57)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local3 86)
						(= local4 57)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 19)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local3 62)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 20)
						(gCurRoom setScript: sayThis)
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
						(= local3 64)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
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
						(= local3 74)
						(= local4 61)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
							(and (proc4_11 21) (== global149 1))
						)
						(= local3 89)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
							(and (proc4_11 22) (== global149 1))
						)
						(= local3 90)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 20) (== global149 1))
						(= local3 101)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 76) (== global149 1))
							(and (proc4_11 74) (proc4_11 76) (== global149 2))
							(and (proc4_11 75) (== global149 1))
							(and (proc4_11 74) (proc4_11 75) (== global149 2))
							(and (proc4_11 71) (== global149 1))
						)
						(gCurRoom setScript: timeOutNoHG)
					)
					(else
						(return -1)
					)
				)
			)
			(4
				(cond
					(
						(or
							(and (proc4_11 47) (== global149 1))
							(and (proc4_11 14) (== global149 1))
							(and (proc4_11 47) (proc4_11 64) (== global149 2))
							(and (proc4_11 64) (== global149 1))
						)
						(= local3 95)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
						(= local4 49)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 49)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local5 1)
						(gCurRoom setScript: aMoveOnly)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local5 2)
						(gCurRoom setScript: aMoveOnly)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local5 3)
						(gCurRoom setScript: aMoveOnly)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(= local5 3)
						(gCurRoom setScript: bMoveOnly)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local5 2)
						(gCurRoom setScript: bMoveOnly)
					)
					((and (proc4_11 63) (== global149 1))
						(= local5 1)
						(gCurRoom setScript: bMoveOnly)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 49)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: initBangNoHG)
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
						(= local5 1)
						(gCurRoom setScript: elementMove)
					)
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
						(= local5 2)
						(gCurRoom setScript: elementMove)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local5 3)
						(gCurRoom setScript: elementMove)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 20)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 21) (proc4_11 10) (== global149 2))
							(and (proc4_11 21) (proc4_11 42) (== global149 2))
							(and (proc4_11 21) (proc4_11 23) (== global149 2))
							(and (proc4_11 21) (== global149 1))
						)
						(= local3 89)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 22) (proc4_11 10) (== global149 2))
							(and (proc4_11 22) (proc4_11 42) (== global149 2))
							(and (proc4_11 22) (proc4_11 23) (== global149 2))
							(and (proc4_11 22) (== global149 1))
						)
						(= local3 90)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 20) (== global149 1))
						(= local3 101)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 69) (== global149 1))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 70) (== global149 1))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 72) (== global149 1))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 73) (== global149 1))
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 76) (== global149 1))
							(and (proc4_11 74) (proc4_11 76) (== global149 2))
							(and (proc4_11 75) (== global149 1))
							(and (proc4_11 74) (proc4_11 75) (== global149 2))
							(and (proc4_11 71) (== global149 1))
						)
						(gCurRoom setScript: timeOutNoHG)
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
				(if (not (or local1 (OneOf gPrevRoomNum 15 8))) ; mainMenu, sierraLogo
					(gMessager say: 0 0 37 1) ; "Highground One. Side one clear of threat. No visible movement inside building."
				)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(self cue:)
				else
					(proc4_6 15207 328 189)
				)
			)
			(1
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(self cue:)
				else
					(gSwatInterface showHandAni: 4)
				)
			)
			(2
				(setUpElement doit: 1)
				(proc4_5)
				(if (or local1 (OneOf gPrevRoomNum 15 8)) ; mainMenu, sierraLogo
					(= seconds 2)
				else
					(gMessager sayRange: 0 0 37 3 5 self) ; "Entry team side one in position."
				)
			)
			(3
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
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
				(Load rsAUDIO 1050 10314)
				(= seconds 1)
			)
			(1
				(switch local5
					(1
						(gGame showCloseUp: 15223 180 66 self 1)
					)
					(2
						(gGame showCloseUp: 15224 180 66 self 1)
					)
					(3
						(gGame showCloseUp: 15225 180 66 self 1)
					)
				)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15210 350 191 0 0 400 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door dispose:)
				(doorLeft dispose:)
				(doorRight dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gunShot4 play: self)
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

(instance aLeftBRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff: showCloseUp: 10316 180 66 self)
			)
			(1
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance aRightBLeft of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 10314)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10315 180 66 self)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15204 329 194)
			)
			(3
				(gunShot4 play: self)
			)
			(4
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance aRightBLeft2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff: showCloseUp: 10315 180 66 self)
			)
			(1
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance aMoveOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 6007)
				(= seconds 1)
			)
			(1
				(switch local5
					(1
						(gGame showCloseUp: 15228 180 66 self 1)
					)
					(2
						(gGame showCloseUp: 15221 180 66 self 1)
					)
					(3
						(gGame showCloseUp: 15227 180 66 self 1)
					)
				)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15208 368 189 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3)
			(4
				(proc4_5)
				(doorLeft dispose:)
				(doorRight dispose:)
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gunShot4 play: self)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance bMoveOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(= seconds 1)
			)
			(1
				(switch local5
					(1
						(gGame showCloseUp: 10319 180 66 self 1)
					)
					(2
						(gGame showCloseUp: 15222 180 66 self 1)
					)
					(3
						(gGame showCloseUp: 15226 180 66 self 1)
					)
				)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15209 325 188 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(proc4_5)
				(door dispose:)
				(doorLeft dispose:)
				(doorRight dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gunShot4 play: self)
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

(instance shootWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050 10314)
				(= seconds 1)
			)
			(1
				(if (== register 6)
					(gGame showCloseUp: 10327 180 66 self 1)
				else
					(gGame showCloseUp: 10321 180 66 self 1)
				)
			)
			(2
				(door dispose:)
				(doorLeft dispose:)
				(doorRight dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(3
				(gMessager say: 7 7 0 1 self) ; "Compromised!"
			)
			(4
				(gunShot4 play: self)
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

(instance shotgunDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 14101 10304 6007)
				(Load rsVIEW 14100 14101)
				(Load rsPIC 1410)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 10324 180 66 self 1)
			)
			(2
				(if (gCast contains: door)
					(door dispose:)
				)
				(setUpElement doit: 0)
				(doorLeft init:)
				(doorRight init:)
				(proc4_6 15207 328 189 425 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(gCast eachElementDo: #dispose)
				(setUpElement doit: 0)
				(proc4_5)
				(gCurRoom drawPic: 1410)
				(if (!= 10304 (gBackMusic number:))
					(if (!= 0 (gBackMusic number:))
						(Lock rsAUDIO (gBackMusic number:) 0)
					)
					(gBackMusic number: 10304 loop: -1 play:)
					(Lock rsAUDIO 10304 1)
				)
				(militiaDude
					view: 14101
					loop: 0
					cel: 0
					posn: 47 219
					init:
					setCycle: CT 29 1 self
				)
			)
			(4
				(militiaDude setCycle: End self)
				(element
					view: 14100
					loop: 0
					cel: 0
					posn: 623 218
					init:
					setPri: 600
					setCycle: End self
				)
			)
			(5)
			(6
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 14101 loop: 0 play: self)
			)
			(7
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(SetFlag 94)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance initBreachHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 50 14110 21003 10304 10314)
				(Load rsVIEW 14100 14110 15214)
				(Load rsPIC 1410)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15201 327 189 50)
			)
			(2
				(gunShot number: 21003 play:)
				(door setCycle: End self)
			)
			(3
				(doorLeft init:)
				(doorRight init:)
			)
			(4
				(proc4_5)
				(door dispose:)
				(gCast eachElementDo: #dispose)
				(militiaDude view: 14110 loop: 0 cel: 0 posn: 28 307 init:)
				(gCurRoom drawPic: 1410)
				(if (!= 10304 (gBackMusic number:))
					(if (!= 0 (gBackMusic number:))
						(Lock rsAUDIO (gBackMusic number:) 0)
					)
					(gBackMusic number: 10304 loop: -1 play:)
					(Lock rsAUDIO 10304 1)
				)
				(= cycles 2)
			)
			(5
				(element
					view: 14100
					loop: 0
					cel: 0
					posn: 623 218
					init:
					setPri: 600
					setCycle: CT 13 1 self
				)
			)
			(6
				(militiaDude setCycle: End self)
				(element setCycle: End self)
			)
			(7)
			(8
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 14101 loop: 0 play: self)
			)
			(9
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(10
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance breachDoorHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 15203)
				(Load rsAUDIO 1002)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 15206 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(setUpElement doit: 5)
				(proc4_5)
				(++ local0)
				(gMessager say: 1 58 2 0 self) ; "Prepare to breach door."
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				((= local2 (Prop new:))
					view: 15203
					loop: 0
					cel: 0
					posn: 0 359
					init:
				)
				(gFxSound number: 1002 loop: 0 play: self)
			)
			(4
				(local2 dispose:)
				(= cycles 1)
			)
			(5
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 4)
				(self dispose:)
			)
		)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15207 328 189 96)
			)
			(2
				(proc4_5)
				(setUpElement doit: 2)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance breachDoorNoHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15207 328 189 188)
			)
			(2
				(proc4_5)
				(setUpElement doit: 3)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 4)
				(self dispose:)
			)
		)
	)
)

(instance initBreachNoHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 21003)
				(Load rsVIEW 15214)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15207 328 189 241)
			)
			(2
				(gFxSound number: 21003 loop: 0 play:)
				(door setCycle: End self)
			)
			(3
				(doorLeft init:)
				(doorRight init:)
			)
			(4
				(proc4_5)
				(door hide:)
				(setUpElement doit: 4)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
			)
		)
	)
)

(instance initBangNoHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 52 1002 10304 10314)
				(Load rsVIEW 15200 14699)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15207 328 189 316)
			)
			(2
				(door
					view: 15200
					loop: 1
					cel: 1
					posn: 371 170
					init:
					setCycle: End
				)
				(gFxSound number: 1002 setLoop: 1 play: self)
			)
			(3
				(door dispose:)
			)
			(4
				(doorLeft dispose:)
				(doorRight dispose:)
				(gCurRoom drawPic: 1460)
				(if (!= 10304 (gBackMusic number:))
					(if (!= 0 (gBackMusic number:))
						(Lock rsAUDIO (gBackMusic number:) 0)
					)
					(gBackMusic number: 10304 loop: -1 play:)
					(Lock rsAUDIO 10304 1)
				)
				(militiaMan init:)
				(proc4_6 14600 279 90 0 0 275)
			)
			(5
				(militiaMan setCycle: End self)
			)
			(6
				(proc4_5)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 52 setLoop: 2 play: self)
			)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance timeOutHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 15202)
				(Load rsAUDIO 43 44 21003 10314)
				(= seconds 1)
			)
			(1
				(badGuy
					view: 15202
					loop: 0
					cel: 0
					posn: 156 299
					setPri: 350
					init:
					setCycle: CT 5 1 self
				)
			)
			(2
				(gMessager say: 0 0 3 0) ; "Movement level one."
				(badGuy setCycle: CT 31 1 self)
			)
			(3
				(gunShot dispose:)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(gunShot number: 44 setLoop: 1 play: self)
			)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(SetFlag 97)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance timeOutNoHG of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 43 44 21003 10314)
				(Load rsVIEW 15213)
				(= seconds 1)
			)
			(1
				(badGuy init: setCycle: CT 26 1 self)
			)
			(2
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 44 loop: 0 play: self)
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

(instance timeOutNoHG2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 43 44 21003 10314)
				(Load rsVIEW 15213)
				(= seconds 1)
			)
			(1
				(badGuy init: setCycle: CT 26 1 self)
			)
			(2
				(gGame showCloseUp: 10321 180 66 self 1)
			)
			(3
				(gFxSound number: 44 loop: 0 play: self)
			)
			(4
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance tossFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 43 44 1002 21003 10314)
				(Load rsVIEW 6 15213)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10322 180 66 self 1)
			)
			(2
				(gFxSound number: 1002 play:)
				(whiteScreen init:)
				(setUpElement doit: 0)
				(proc4_6 15212 400 200 9 0 -1 1)
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
			)
			(6
				(gMessager say: 9 16) ; "Status! Status!"
				(badGuy init: setCycle: CT 26 1 self)
			)
			(7
				(proc4_5)
				(badGuy dispose:)
				(door dispose:)
				(doorLeft dispose:)
				(doorRight dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(8
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(9
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
					(carmike
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

(instance comeOutWithBadGuys of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 15211)
				(= seconds 1)
			)
			(1
				(exitDoor init: setCycle: End self)
			)
			(2
				(gEgo awardMedal: 32)
				(gEgo awardMedal: 2)
				(SetFlag 102)
				(SetFlag 91)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance element of Prop
	(properties)
)

(instance exitDoor of Prop
	(properties
		x 346
		y 293
		view 15211
	)
)

(instance door of Prop
	(properties
		x 371
		y 306
		priority 100
		fixPriority 1
		view 15200
	)
)

(instance carmike of Prop
	(properties)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 3 29 0 0 self) ; "Carmichael, you copy?"
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 2 29 0 0 self) ; "Denton, you copy?"
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tello of Prop
	(properties)

	(method (cue)
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 4 29 0 0 self) ; "Tello, you copy?"
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
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
		(actionTimer setReal: actionTimer 3)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 5 29 0 0 self) ; "Wixell, you copy?"
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance badGuy of Prop
	(properties
		x 154
		y 133
		view 15213
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== cel 1) (not (sound1 handle:)) (not (sound2 handle:)))
				(sound1 number: 43 play:)
				(sound2 number: 21003 play:)
			)
			((and (== view 15213) (== cel 24) (not (gunShot handle:)))
				(gunShot number: 44 play:)
			)
			((and (== view 15202) (== cel 15) (not (gunShot handle:)))
				(gunShot number: 44 play:)
			)
		)
	)
)

(instance sound1 of Sound
	(properties)
)

(instance sound2 of Sound
	(properties)
)

(instance militiaDude of Prop
	(properties)

	(method (doit)
		(cond
			((== view 14110)
				(if (and (not (gunShot handle:)) (== cel 1))
					(gunShot number: 14110 play:)
				)
			)
			((and (not (gunShot handle:)) (== cel 41))
				(gunShot number: 14101 play:)
			)
		)
		(super doit:)
	)
)

(instance militiaMan of Prop
	(properties
		x 445
		y 317
		view 14699
	)

	(method (doit)
		(super doit:)
		(if (and (not (gunShot handle:)) (== cel 16))
			(gunShot number: 52 play:)
		)
	)
)

(instance egoDude of Prop
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

(instance doorLeft of View
	(properties
		x 271
		y 161
		view 15214
	)

	(method (init)
		(self setPri: 300)
		(super init: &rest)
	)
)

(instance doorRight of View
	(properties
		view 15214
		loop 1
	)

	(method (init)
		(self setPri: 99)
		(super init: &rest)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if argc
			(= temp0 param1)
		else
			(= temp0 0)
		)
		(switch temp0
			(0
				(carmike dispose:)
				(denton dispose:)
				(tello dispose:)
				(wix dispose:)
				(if (gCast contains: egoDude)
					(egoDude dispose:)
				)
			)
			(1
				(carmike view: 15207 loop: 0 cel: 4 posn: 418 195 init:)
				(denton view: 15207 loop: 0 cel: 3 posn: 418 195 init:)
				(tello view: 15207 loop: 0 cel: 2 posn: 418 195 init:)
				(wix view: 15207 loop: 0 cel: 1 posn: 418 195 init:)
				(egoDude view: 15207 loop: 0 cel: 0 posn: 418 195 init:)
			)
			(2
				(carmike view: 15207 loop: 1 cel: 4 posn: 419 194 init:)
				(denton view: 15207 loop: 1 cel: 3 posn: 419 194 init:)
				(tello view: 15207 loop: 1 cel: 2 posn: 419 194 init:)
				(wix view: 15207 loop: 1 cel: 1 posn: 419 194 init:)
				(egoDude view: 15207 loop: 1 cel: 0 posn: 419 194 init:)
			)
			(3
				(carmike view: 15207 loop: 2 cel: 4 posn: 411 190 init:)
				(denton view: 15207 loop: 2 cel: 3 posn: 411 190 init:)
				(tello view: 15207 loop: 2 cel: 2 posn: 411 190 init:)
				(wix view: 15207 loop: 2 cel: 1 posn: 411 190 init:)
				(egoDude view: 15207 loop: 2 cel: 0 posn: 411 190 init:)
			)
			(4
				(carmike view: 15207 loop: 3 cel: 4 posn: 416 193 init:)
				(denton view: 15207 loop: 3 cel: 3 posn: 416 193 init:)
				(tello view: 15207 loop: 3 cel: 2 posn: 416 193 init:)
				(wix view: 15207 loop: 3 cel: 1 posn: 416 193 init:)
				(egoDude view: 15207 loop: 3 cel: 0 posn: 416 193 init:)
			)
			(5
				(carmike view: 15201 loop: 0 cel: 4 posn: 408 196 init:)
				(denton view: 15201 loop: 0 cel: 3 posn: 408 196 init:)
				(tello view: 15201 loop: 0 cel: 2 posn: 408 196 init:)
				(wix view: 15201 loop: 0 cel: 1 posn: 408 196 init:)
				(egoDude view: 15201 loop: 0 cel: 0 posn: 408 196 init:)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(if (not (gCurRoom script:))
			(if local1
				(if (< local0 2)
					(gCurRoom setScript: timeOutNoHG)
				else
					(gCurRoom setScript: timeOutNoHG2)
				)
			else
				(gCurRoom setScript: timeOutHG)
			)
		)
		(self dispose: delete:)
	)
)

(instance gunShot of Sound
	(properties)
)

(instance gunShot2 of Sound ; UNUSED
	(properties)
)

(instance gunShot3 of Sound ; UNUSED
	(properties)
)

(instance gunShot4 of Sound
	(properties
		number 1050
		loop 0
	)
)

(instance sayThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 local3 local4 0 self)
			)
			(1
				(actionTimer setReal: actionTimer 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayPosB of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 76 19 1 self) ; "Entry Team B in position!"
			)
			(1
				(gMessager say: 1 77 22 2 self) ; "Negative. Entry Team still outside, side one."
			)
			(2
				(actionTimer setReal: actionTimer 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayPos of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 77 20 1 self) ; "Entry team in position!"
			)
			(1
				(gMessager say: 1 77 22 2 self) ; "Negative. Entry Team still outside, side one."
			)
			(2
				(actionTimer setReal: actionTimer 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

