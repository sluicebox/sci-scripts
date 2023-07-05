;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1070)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1070 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(if
		(or
			(proc4_11 62)
			(proc4_11 64)
			(proc4_11 65)
			(proc4_11 66)
			(proc4_11 67)
			(proc4_11 68)
			(proc4_11 69)
			(proc4_11 70)
			(proc4_11 71)
			(proc4_11 72)
			(proc4_11 73)
			(proc4_11 74)
			(proc4_11 75)
			(proc4_11 76)
		)
		(return 1)
	else
		(return 0)
	)
)

(instance rm1070 of PQRoom
	(properties
		picture 1070
	)

	(method (init)
		(if (!= 10303 (gBackMusic number:))
			(if (!= 0 (gBackMusic number:))
				(Lock rsAUDIO (gBackMusic number:) 0)
			)
			(Load rsAUDIO 10303)
			(gBackMusic number: 10303 loop: -1 play:)
			(Lock rsAUDIO 10303 1)
		)
		(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
			(SetFlag 288)
		)
		(if (IsFlag 288)
			(Load rsVIEW 10711)
		else
			(Load rsVIEW 10700 10701 10715)
			(Load rsAUDIO 43 51 52 54 55 10314 21003)
		)
		(Load rsVIEW 997 10 13 25 31 32)
		(Load rsSCRIPT 64960)
		(Load rsHEAP 64960)
		(super init: &rest)
		(door init:)
		(van init:)
		(windows init:)
		(if (IsFlag 288)
			(gCurRoom setScript: enterRoom)
		else
			(ClearFlag 12)
			(gSwatInterface closeInvWindow:)
			(gCurRoom setScript: killElement)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(self setScript: sShootRoom 0 theVerb)
			)
			(7
				(self setScript: sShootRoom 0 theVerb)
			)
			(16
				(if local0
					(self setScript: eastmanDies)
				else
					(self setScript: defaultBang)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (lashNotify)
		(switch local1
			(0
				(cond
					((and (proc4_11 46) (== global149 1))
						(= local3 85)
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
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(gCurRoom setScript: tryDoor)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local3 58)
						(= local4 12)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 12)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 12)
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
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local3 62)
						(= local4 16)
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
						(= local4 16)
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
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local3 86)
						(= local4 15)
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
					((localproc_0)
						(self setScript: shotsFromDoor)
						(return -1)
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
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(gCurRoom setScript: breachDoor)
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
						(gCurRoom setScript: walkOffLeft)
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
						(gCurRoom setScript: walkOffRight)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 23)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 23)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 21)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 21)
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
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 22)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(self setScript: shotsFromDoor)
						(return -1)
					)
					(else
						(return -1)
					)
				)
			)
			(2
				(cond
					((and (proc4_11 57) (== global149 1))
						(gCurRoom setScript: initiateBreach)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 24)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 24)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
						(= local4 25)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 25)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 24)
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
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 39)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 39)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 39)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(self setScript: shotsFromDoor)
						(return -1)
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
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(gCurRoom setScript: mirrorDoor)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: throwBang)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 29)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 29)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
						(= local4 26)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 26)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 27)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 29)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local3 58)
						(= local4 29)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 28)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: moveAOnly)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: moveBOnly)
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
						(gCurRoom setScript: walkOffLeft)
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
						(gCurRoom setScript: walkOffRight)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(self setScript: shotsFromDoor)
						(return -1)
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
						(gCurRoom setScript: instructARightMove)
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
						(gCurRoom setScript: instructALeftMove)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
						(= local4 40)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 40)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local3 58)
						(= local4 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: throwBang)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: moveAOnly)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 42)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 44)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: moveBOnly)
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
						(gCurRoom setScript: walkOffLeft)
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
						(gCurRoom setScript: walkOffRight)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 46)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(self setScript: shotsFromDoor)
						(return -1)
					)
					(else
						(return -1)
					)
				)
			)
			(5
				(cond
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(gCurRoom setScript: doMove)
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
						(gCurRoom setScript: walkOffLeft)
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
						(gCurRoom setScript: walkOffRight)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: moveAOnly)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: moveBOnly)
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
						(gCurRoom setScript: throwBang)
					)
					(
						(or
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
						)
						(= local3 65)
						(= local4 48)
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
						(= local3 63)
						(= local4 41)
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
						(= local3 67)
						(= local4 41)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 39) (proc4_11 11) (== global149 2))
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 73) (proc4_11 68) (== global149 2))
							(and (proc4_11 56) (== global149 1))
							(and (proc4_11 73) (== global149 1))
						)
						(= local3 60)
						(= local4 31)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 43)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 45)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local3 77)
						(= local4 30)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 1) (proc4_11 11) (== global149 2))
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 52) (== global149 1))
							(and (proc4_11 69) (== global149 1))
						)
						(= local3 57)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 38) (proc4_11 11) (== global149 2))
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 53) (== global149 1))
							(and (proc4_11 70) (== global149 1))
						)
						(= local3 58)
						(= local4 48)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 47)
						(gCurRoom setScript: sayThis)
					)
					(else
						(return -1)
					)
				)
			)
		)
	)

	(method (dispose)
		(if (gTimers contains: actionTimer)
			(actionTimer dispose: delete:)
		)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 1 0) ; "Highground One. Side two clear of threat. Vehicle clear."
				(proc4_6 10701 -1 129)
			)
			(1
				(gMessager say: 0 0 33 0) ; "Hold."
				(gSwatInterface showHandAni: 4)
			)
			(2
				(proc4_5)
				(setUpElement doit: 1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tryDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(setUpElement doit: 0)
				(proc4_6 10701 -1 129 74)
			)
			(1
				(proc4_5)
				(setUpElement doit: 2)
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance breachDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(setUpElement doit: 0)
				(proc4_6 10701 -1 129 146)
			)
			(1
				(proc4_5)
				(setUpElement doit: 3)
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance initiateBreach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(setUpElement doit: 0)
				(proc4_6 10701 -1 129 241)
			)
			(1
				(door setCycle: CT 2 1)
			)
			(2
				(door setCycle: CT 4 1)
			)
			(3
				(proc4_5)
				(setUpElement doit: 4)
				(door setPri: 400)
				(= local0 1)
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mirrorDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(setUpElement doit: 0)
				(proc4_6 10701 -1 129 313)
			)
			(1
				(proc4_5)
				(setUpElement doit: 5)
				(gSwatInterface showHandAni: 6 self)
			)
			(2
				(door setPri: -1)
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerInitBreach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(setUpElement doit: 0)
				(proc4_6 10701 -1 129 241)
			)
			(1
				(door setCycle: CT 2 1)
			)
			(2
				(door setCycle: CT 4 1)
			)
			(3
				(proc4_5)
				(door setPri: 400)
				(self dispose:)
			)
		)
	)
)

(instance rookerTakesOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local1
					(0
						(gMessager say: 0 0 3 0 self) ; "Pup! What's going on?"
					)
					(1
						(gMessager say: 0 0 4 0 self) ; "Pup! Are you inside? What's going on?"
					)
					(2
						(gMessager say: 0 0 5 0 self) ; "Status! Entry team..."
					)
				)
			)
			(1
				(switch local1
					(0
						(setUpElement doit: 0)
						(proc4_6 10701 -1 129 74)
					)
					(1
						(setUpElement doit: 0)
						(proc4_6 10701 -1 129 146)
					)
					(2
						(self setScript: rookerInitBreach self)
					)
				)
			)
			(2
				(proc4_5)
				(switch local1
					(0
						(setUpElement doit: 2)
					)
					(1
						(setUpElement doit: 3)
					)
					(2
						(setUpElement doit: 4)
					)
				)
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
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
				(Load rsVIEW 10718 10715)
				(Load rsAUDIO 43 21003 10715)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 63 21 1 self) ; "Denton, shotgun the door."
			)
			(2
				(door view: 10718 posn: 140 161)
				(gGame showCloseUp: 10722 180 66 self)
			)
			(3
				(gMessager sayRange: 1 63 21 2 3) ; "Status!"
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(4
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 10715 loop: 0 play: self)
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

(instance sShootRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10715 10314)
				(= seconds 1)
			)
			(1
				(gGame
					showCloseUp:
						(if (== register 7) 10719 else 10720)
						180
						66
						self
						1
				)
			)
			(2
				(gMessager say: 6 7 0 0 self) ; "Compromised!"
			)
			(3
				(gFxSound number: 10715 loop: 0 play: self)
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

(instance shootVan of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
				(gGame handsOff:)
				(Load rsAUDIO 44 21003 52 50 10314)
				(Load rsVIEW 10734)
				(= seconds 2)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gMessager say: 6 7 0 0) ; "Compromised!"
				(gCurRoom drawPic: -1)
				(vanCloseUp init:)
				((View new:)
					view: 10734
					loop: 1
					cel: 0
					posn: 200 90
					setPri: 110
					init:
				)
				(if (== register 7)
					((View new:)
						view: 10734
						loop: 1
						cel: 1
						posn: 200 90
						setPri: 110
						init:
					)
					((View new:)
						view: 10734
						loop: 1
						cel: 1
						posn: 252 91
						setPri: 110
						init:
					)
					(gFxSound number: 52 loop: 0 play: self)
				else
					(gFxSound number: 50 loop: 0 play: self)
				)
				(sound5 number: 21003 loop: 0 play:)
			)
			(2
				(if (== register 7)
					(self cue:)
				else
					((View new:)
						view: 10734
						loop: 1
						cel: 1
						posn: 200 90
						setPri: 110
						init:
					)
					(gFxSound number: 50 loop: 0 play: self)
				)
			)
			(3
				(if (== register 7)
					(= seconds 2)
				else
					((View new:)
						view: 10734
						loop: 1
						cel: 1
						posn: 252 91
						setPri: 110
						init:
					)
					(gFxSound number: 50 loop: 0 play: self)
				)
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(gFxSound number: 44 loop: 0 play: self)
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

(instance shootDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10715 10314)
				(= seconds 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 10715 loop: 0 play: self)
			)
			(2
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shotsFromDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44)
				(Load rsVIEW 10717)
				(= seconds 1)
			)
			(1
				(if (gCast contains: door)
					(door setCycle: CT 6 1 self)
				else
					(self cue:)
				)
			)
			(2
				(doorGuy init: setCycle: End)
				(= ticks 90)
			)
			(3
				(shotSound stop:)
				(proc4_5)
				(gCast eachElementDo: #dispose)
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

(instance instructARightMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10705)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10727 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(groupProp view: 10705 setLoop: 0 setCel: 0 posn: -1 316 init:)
				(Palette 2 42 254 100) ; PalIntensity
				(= local2 1)
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance instructALeftMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10702)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10728 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(groupProp view: 10702 setLoop: 0 setCel: 0 posn: 0 320 init:)
				(Palette 2 42 254 100) ; PalIntensity
				(++ local1)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10310)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 62 16 1 self) ; "Move!"
			)
			(2
				(door setPri: 400)
				(groupProp setCycle: CT 14 1 self)
			)
			(3
				(door setCycle: End)
				(groupProp setCycle: End self)
			)
			(4
				(if local2
					(gCurRoom setScript: do1320)
				else
					(gCurRoom newRoom: 1050)
				)
			)
		)
	)
)

(instance walkOffLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10703)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10724 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(groupProp
					view: 10703
					setLoop: 0
					setCel: 0
					posn: 0 321
					init:
					setCycle: End self
				)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance walkOffRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10704)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10729 180 66 self 1)
			)
			(2
				(door setPri: -1)
				(setUpElement doit: 0)
				(groupProp
					view: 10704
					setLoop: 0
					setCel: 0
					posn: 0 320
					init:
					setCycle: End self
				)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance moveAOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 10314)
				(Load rsVIEW 10707)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(gGame showCloseUp: 10723 180 66 self)
			)
			(2
				(groupProp
					view: 10707
					setLoop: 0
					setCel: 0
					posn: 0 319
					init:
					setCycle: CT 4 1 self
				)
			)
			(3
				(door setPri: -1 setCycle: End)
				(groupProp setCycle: End self)
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(shotSound number: 44 play: self)
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

(instance moveBOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 10314)
				(Load rsVIEW 10708)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(gGame showCloseUp: 10725 180 66 self)
			)
			(2
				(groupProp
					view: 10708
					setLoop: 0
					setCel: 0
					posn: 0 357
					init:
					setCycle: CT 7 1 self
				)
			)
			(3
				(door setPri: -1 setCycle: End)
				(groupProp setCycle: End self)
			)
			(4
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(shotSound number: 44 play: self)
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

(instance throwBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 10715 10314)
				(Load rsVIEW 10701 10715 10705 10733)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10711 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(bangFlash init:)
				(gFxSound number: 1002 loop: 0 play: self)
				(groupProp
					view: 10705
					loop: 0
					cel: 0
					posn: 0 310
					init:
					setCycle: CT 13 1 self
				)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(bangFlash dispose:)
			)
			(4
				(door setCycle: End)
				(groupProp setCycle: End self)
			)
			(5
				(shotSound number: 10715 play: self)
				(= ticks 150)
			)
			(6
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(7
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance defaultBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 44 10314 21003 43)
				(Load rsVIEW 10713 10715)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10721 180 66 self 1)
			)
			(2
				(shotSound number: 1002 play:)
				(setUpElement doit: 0)
				(groupProp view: 10713 loop: 0 cel: 0 posn: -2 319 init:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
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
				(groupProp setCycle: End self)
			)
			(6
				(gMessager say: 9 16) ; "Status! Status!"
				(militiaMan init: setCycle: CT 25 1 self)
			)
			(7
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 44 loop: 0 play: self)
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

(instance eastmanDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 6007)
				(Load rsVIEW 10714 10733)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10721 180 66 self 1)
			)
			(2
				(bangFlash init:)
				(door setPri: -1 setCycle: End)
				(shotSound number: 1002 play:)
				(setUpElement doit: 0)
				(groupProp view: 10714 setLoop: 0 setCel: 0 posn: 0 344 init:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(bangFlash dispose:)
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
				(groupProp setCycle: End self)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
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

(instance killElement of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(groupProp init: setCycle: CT 45 1 self)
			)
			(1
				(groupProp setCycle: End self)
				(gMessager say: 0 0 33 0 0) ; "Hold."
			)
			(2
				(militiaMan init: setCycle: CT 12 1 self)
			)
			(3
				(militiaMan setCycle: End)
				(groupProp view: 10701 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(4
				(gCast eachElementDo: #dispose)
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
				(Lock rsAUDIO (gBackMusic number:) 0)
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

(instance do1320 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsMESSAGE 1320)
				(Load rsAUDIO 43 10310 10314)
				(Load rsVIEW 13201)
				(Load rsPIC 1320)
				(= seconds 2)
			)
			(1
				(groupProp dispose:)
				(door dispose:)
				(gCurRoom drawPic: 1320)
				(if (!= 10310 (gBackMusic number:))
					(if (!= 0 (gBackMusic number:))
						(Lock rsAUDIO (gBackMusic number:) 0)
					)
					(Load rsAUDIO 10310)
					(gBackMusic number: 10310 loop: -1 play:)
					(Lock rsAUDIO 10310 1)
				)
				(gMessager say: 0 0 1 1 0 1320) ; "Entry team in!"
				(proc4_6 13200 110 10 0 0 -1 1)
			)
			(2
				(militiaMan2 init: setCycle: End self)
			)
			(3
				(proc4_5)
				(militiaMan2 dispose:)
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

(instance egoDude of Prop
	(properties)
)

(instance groupProp of Prop
	(properties
		y 300
		view 10700
	)

	(method (doit)
		(super doit:)
		(if (and (== view 10701) (== cel 19))
			(sound2 number: 52 play:)
		)
		(if (and (== view 10701) (OneOf cel 13 20 26))
			(sound3 number: 54 play:)
		)
		(if (and (== view 10701) (OneOf cel 15 21 27))
			(sound4 number: 55 play:)
		)
	)
)

(instance militiaMan of Prop
	(properties
		x 513
		y 100
		view 10715
	)

	(method (doit)
		(super doit:)
		(if (== cel 1)
			(sound5 number: 21003 play:)
		)
		(if (OneOf cel 1 18 24 29 36 39 46)
			(sound1 number: 43 play:)
		)
	)
)

(instance militiaMan2 of Prop
	(properties
		x 398
		y 248
		view 13201
	)

	(method (doit)
		(super doit:)
		(if (OneOf cel 18 20 25)
			(sound1 number: 43 play:)
		)
	)
)

(instance doorGuy of Prop
	(properties
		x 187
		y 314
		view 10717
	)

	(method (init)
		(self setPri: 160)
		(super init: &rest)
	)

	(method (doit)
		(if (and (== cel 8) (not (shotSound handle:)))
			(shotSound number: 44 play: setLoop: -1)
		)
		(super doit:)
	)
)

(instance bangFlash of View
	(properties
		x 129
		y 153
		view 10733
	)
)

(instance door of Prop
	(properties
		x 143
		y 161
		view 10710
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootDoor 0 7)
			)
			(6
				(gCurRoom setScript: shootDoor 0 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vanCloseUp of Prop
	(properties
		x 200
		y 90
		view 10734
	)
)

(instance van of Feature
	(properties
		nsLeft 362
		nsTop 205
		nsRight 622
		nsBottom 324
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootVan 0 7)
			)
			(6
				(gCurRoom setScript: shootVan 0 6)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance windows of Feature
	(properties
		nsLeft 331
		nsRight 639
		nsBottom 197
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: sShootRoom 0 7)
			)
			(6
				(gCurRoom setScript: sShootRoom 0 6)
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
		(programAction doit:)
		(self dispose: delete:)
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
				(denton dispose:)
				(carmichael dispose:)
				(tello dispose:)
				(wix dispose:)
				(if (gCast contains: egoDude)
					(egoDude dispose:)
				)
				(if (gCast contains: groupProp)
					(groupProp dispose:)
				)
			)
			(1
				(carmichael view: 10711 loop: 0 cel: 0 x: 0 y: 163 init:)
				(denton view: 10711 loop: 0 cel: 1 x: 0 y: 163 init:)
				(tello view: 10711 loop: 0 cel: 2 x: 0 y: 163 init:)
				(egoDude view: 10711 loop: 0 cel: 3 x: 0 y: 163 init:)
				(wix view: 10711 loop: 0 cel: 4 x: 0 y: 163 init:)
				(if (gCast contains: groupProp)
					(groupProp dispose:)
				)
			)
			(2
				(carmichael view: 10711 loop: 1 cel: 0 x: -1 y: 169 init:)
				(denton view: 10711 loop: 1 cel: 1 x: -1 y: 169 init:)
				(tello view: 10711 loop: 1 cel: 2 x: -1 y: 169 init:)
				(egoDude view: 10711 loop: 1 cel: 3 x: -1 y: 169 init:)
				(wix view: 10711 loop: 1 cel: 4 x: -1 y: 169 init:)
				(if (gCast contains: groupProp)
					(groupProp dispose:)
				)
			)
			(3
				(carmichael view: 10711 loop: 2 cel: 0 x: -1 y: 165 init:)
				(denton view: 10711 loop: 2 cel: 1 x: -1 y: 165 init:)
				(tello view: 10711 loop: 2 cel: 2 x: -1 y: 165 init:)
				(egoDude view: 10711 loop: 2 cel: 3 x: -1 y: 165 init:)
				(wix view: 10711 loop: 2 cel: 4 x: -1 y: 165 init:)
				(if (gCast contains: groupProp)
					(groupProp dispose:)
				)
			)
			(4
				(carmichael view: 10711 loop: 3 cel: 0 x: -1 y: 162 init:)
				(denton view: 10711 loop: 3 cel: 1 x: -1 y: 162 init:)
				(tello view: 10711 loop: 3 cel: 2 x: -1 y: 162 init:)
				(egoDude view: 10711 loop: 3 cel: 3 x: -1 y: 162 init:)
				(wix view: 10711 loop: 3 cel: 4 x: -1 y: 162 init:)
				(if (gCast contains: groupProp)
					(groupProp dispose:)
				)
			)
			(5
				(carmichael view: 10711 loop: 4 cel: 0 x: -1 y: 168 init:)
				(denton view: 10711 loop: 4 cel: 1 x: -1 y: 168 init:)
				(tello view: 10711 loop: 4 cel: 2 x: -1 y: 168 init:)
				(egoDude view: 10711 loop: 4 cel: 3 x: -1 y: 168 init:)
				(wix view: 10711 loop: 4 cel: 4 x: -1 y: 168 init:)
				(if (gCast contains: groupProp)
					(groupProp dispose:)
				)
			)
		)
	)
)

(instance programAction of Code
	(properties)

	(method (doit)
		(switch local1
			(0
				(gCurRoom setScript: rookerTakesOver)
			)
			(1
				(gCurRoom setScript: rookerTakesOver)
			)
			(2
				(gCurRoom setScript: rookerTakesOver)
			)
			(else
				(gCurRoom setScript: shotsFromDoor)
			)
		)
	)
)

(instance shotSound of Sound
	(properties)
)

(instance sound1 of Sound
	(properties)
)

(instance sound2 of Sound
	(properties)
)

(instance sound3 of Sound
	(properties)
)

(instance sound4 of Sound
	(properties)
)

(instance sound5 of Sound
	(properties)
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

