;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1510)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1510 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance rm1510 of PQRoom
	(properties
		picture 1510
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
		(Load rsVIEW 15101 59)
		(Load rsMESSAGE 1510)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(door init: setPri: 1)
		(topWindow init:)
		(bottomWindowL init:)
		(bottomWindowR init:)
		(self setScript: enterRoom)
	)

	(method (lashNotify)
		(switch local0
			(0
				(cond
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(gCurRoom setScript: openDoor)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local4 58)
						(= local5 12)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local4 65)
						(= local5 12)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local4 63)
						(= local5 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local4 67)
						(= local5 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local4 16)
						(= local5 13)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local4 85)
						(= local5 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local4 72)
						(= local5 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local4 70)
						(= local5 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local4 75)
						(= local5 18)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local4 60)
						(= local5 12)
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
							(and (proc4_11 64) (== global149 1))
						)
						(self setScript: timeOut)
						(return -2)
					)
					((and (proc4_11 77) (== global149 1))
						(= local4 76)
						(= local5 19)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local4 86)
						(= local5 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local4 71)
						(= local5 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(= local4 73)
						(= local5 15)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local4 62)
						(= local5 16)
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
						(= local4 64)
						(= local5 16)
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
						(= local4 74)
						(= local5 16)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== 1 global149))
							(and (proc4_11 60) (proc4_11 77) (= global149 2))
						)
						(= local4 77)
						(= local5 20)
						(gCurRoom setScript: sayThis)
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
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local4 67)
						(= local5 21)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local4 16)
						(= local5 21)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local4 65)
						(= local5 23)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local4 75)
						(= local5 37)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local4 60)
						(= local5 23)
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
							(and (proc4_11 64) (== global149 1))
						)
						(self setScript: timeOut)
						(return -2)
					)
					((and (proc4_11 77) (== global149 1))
						(= local4 76)
						(= local5 38)
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
						(gCurRoom setScript: moveLeft)
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
						(gCurRoom setScript: moveRight)
					)
					(
						(or
							(and (proc4_11 43) (== 1 global149))
							(and (proc4_11 60) (proc4_11 77) (= global149 2))
						)
						(= local4 77)
						(= local5 20)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local4 79)
						(= local5 22)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local4 80)
						(= local5 22)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local4 81)
						(= local5 22)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local4 83)
						(= local5 22)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local4 82)
						(= local5 22)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local4 84)
						(= local5 22)
						(gCurRoom setScript: sayThese)
					)
					(else
						(return -1)
					)
				)
			)
			(2
				(cond
					((and (proc4_11 57) (== global149 1))
						(gCurRoom setScript: initBreach)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local4 65)
						(= local5 24)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local4 60)
						(= local5 24)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local4 63)
						(= local5 25)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local4 67)
						(= local5 25)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local4 75)
						(= local5 40)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local4 57)
						(= local5 24)
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
							(and (proc4_11 64) (== global149 1))
							(and (proc4_11 74) (== global149 1))
						)
						(self setScript: timeOut)
						(return -2)
					)
					((and (proc4_11 77) (== global149 1))
						(= local4 76)
						(= local5 41)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== 1 global149))
							(and (proc4_11 60) (proc4_11 77) (= global149 2))
						)
						(= local4 77)
						(= local5 20)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local4 79)
						(= local5 42)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local4 80)
						(= local5 42)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local4 81)
						(= local5 42)
						(gCurRoom setScript: sayThese)
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
						(gCurRoom setScript: initBang)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: aMoveOnly)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local4 65)
						(= local5 29)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local4 63)
						(= local5 26)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local4 67)
						(= local5 26)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local4 57)
						(= local5 29)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local4 58)
						(= local5 29)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local4 75)
						(= local5 27)
						(gCurRoom setScript: sayThese)
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
							(and (proc4_11 64) (== global149 1))
						)
						(self setScript: timeOut)
						(return -2)
					)
					((and (proc4_11 77) (== global149 1))
						(= local4 76)
						(= local5 28)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: bMoveOnly)
					)
					(
						(or
							(and (proc4_11 43) (== 1 global149))
							(and (proc4_11 60) (proc4_11 77) (= global149 2))
						)
						(= local4 77)
						(= local5 30)
						(gCurRoom setScript: sayThese)
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
						(gCurRoom setScript: moveLeft)
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
						(gCurRoom setScript: moveRight)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local4 79)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local4 80)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local4 81)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local4 82)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local4 83)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local4 84)
						(= local5 30)
						(gCurRoom setScript: sayThese)
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
						(gCurRoom setScript: aRightBLeft)
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
						(gCurRoom setScript: initBang)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: aMoveOnly)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: bMoveOnly)
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
						(gCurRoom setScript: moveLeft)
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
						(gCurRoom setScript: moveRight)
					)
					(
						(or
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
						)
						(= local4 65)
						(= local5 31)
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
						(= local4 63)
						(= local5 35)
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
						(= local4 67)
						(= local5 35)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local4 75)
						(= local5 43)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 77) (== global149 1))
						(= local4 76)
						(= local5 45)
						(gCurRoom setScript: sayThese)
					)
					(
						(or
							(and (proc4_11 43) (== 1 global149))
							(and (proc4_11 60) (proc4_11 77) (= global149 2))
						)
						(= local4 77)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					(
						(or
							(and (proc4_11 1) (proc4_11 11) (== global149 2))
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 52) (== global149 1))
							(and (proc4_11 69) (== global149 1))
						)
						(= local4 57)
						(= local5 31)
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
						(= local4 60)
						(= local5 31)
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
						(= local4 58)
						(= local5 31)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local4 79)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local4 80)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local4 81)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local4 83)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local4 82)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local4 84)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					(else
						(return -1)
					)
				)
			)
			(5
				(cond
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(gCurRoom setScript: elementMove)
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
						(gCurRoom setScript: initBang)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: aMoveOnly)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: bMoveOnly)
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
						(gCurRoom setScript: moveLeft)
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
						(gCurRoom setScript: moveRight)
					)
					(
						(or
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
						)
						(= local4 65)
						(= local5 31)
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
						(= local4 63)
						(= local5 35)
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
						(= local4 67)
						(= local5 35)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local4 75)
						(= local5 43)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 77) (== global149 1))
						(= local4 76)
						(= local5 45)
						(gCurRoom setScript: sayThese)
					)
					(
						(or
							(and (proc4_11 43) (== 1 global149))
							(and (proc4_11 60) (proc4_11 77) (= global149 2))
						)
						(= local4 77)
						(= local5 30)
						(gCurRoom setScript: sayThese)
					)
					(
						(or
							(and (proc4_11 1) (proc4_11 11) (== global149 2))
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 69) (proc4_11 68) (== global149 2))
							(and (proc4_11 52) (== global149 1))
							(and (proc4_11 69) (== global149 1))
						)
						(= local4 57)
						(= local5 31)
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
						(= local4 60)
						(= local5 31)
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
						(= local4 58)
						(= local5 31)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local4 79)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local4 80)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local4 81)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local4 83)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local4 82)
						(= local5 36)
						(gCurRoom setScript: sayThese)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local4 84)
						(= local5 36)
						(gCurRoom setScript: sayThese)
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
			(7
				(self setScript: sShootWindow 0 theVerb)
			)
			(6
				(self setScript: sShootWindow 0 theVerb)
			)
			(16
				(self setScript: tossBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 15100 430 183)
			)
			(1
				(gSwatInterface showHandAni: 4)
			)
			(2
				(proc4_5)
				(setUpElement doit: 1)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
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
				(setUpElement doit: 0)
				(proc4_6 15100 430 183 96)
			)
			(1
				(proc4_5)
				(setUpElement doit: 2)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
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
				(proc4_6 15100 430 183 146)
			)
			(1
				(proc4_5)
				(setUpElement doit: 3)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance initBreach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 21003)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15100 430 183 209)
			)
			(2
				(gFxSound number: 21003 setLoop: 0 play:)
			)
			(3
				(door setCycle: CT 2 1)
			)
			(4
				(proc4_5)
				(setUpElement doit: 4)
				(door setPri: -1)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
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
				(proc4_6 15100 430 183 301)
			)
			(1
				(gSwatInterface showHandAni: 6)
			)
			(2
				(proc4_5)
				(setUpElement doit: 5)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance rookerBreach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 4 0 self) ; "Pup! Are you inside? What's going on?"
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15100 430 183 146)
			)
			(2
				(proc4_5)
				(setUpElement doit: 3)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
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
				(gGame handsOff:)
				(Load rsAUDIO 21003)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 5 0 self) ; "Pup! What are you waiting for?"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15100 430 183 209)
			)
			(3
				(gFxSound number: 21003 setLoop: 0 play:)
			)
			(4
				(door setCycle: CT 2 1)
			)
			(5
				(proc4_5)
				(setUpElement doit: 4)
				(door setPri: -1)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance rookerMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 34 0 self) ; "Is it clear? Carmichael, what do you see?"
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15100 430 183 301)
			)
			(2
				(gSwatInterface showHandAni: 6)
			)
			(3
				(proc4_5)
				(setUpElement doit: 5)
				(++ local0)
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
				(self dispose:)
			)
		)
	)
)

(instance timeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 21003 15108)
				(Load rsVIEW 15108)
				(= seconds 1)
			)
			(1
				(militiaMan init: setCycle: CT 8 1 self)
			)
			(2
				(gFxSound number: 21003 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(3
				(door dispose:)
				(militiaMan dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(gFxSound number: 15108 setLoop: 1 play: self)
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

(instance tossBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 21003 15108 1002)
				(Load rsVIEW 15108 6)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10322 180 66 self 1)
			)
			(2
				(shotSound number: 1002 play:)
				(whiteScreen init:)
				(setUpElement doit: 0)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gMessager say: 9 16 0 0) ; "Status! Status!"
				(proc4_6 15106 447 177 0 0 -1 1)
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
				(militiaMan init: setCycle: CT 8 1 self)
			)
			(7
				(gFxSound number: 21003 setLoop: 0 play:)
				(militiaMan setCycle: End self)
			)
			(8
				(proc4_5)
				(door dispose:)
				(militiaMan dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(9
				(gFxSound number: 15108 setLoop: 1 play: self)
			)
			(10
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(11
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance initBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10304 14000 1002 10314)
				(Load rsVIEW 15109 14002 14000)
				(Load rsPIC 1405)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 10335 180 66 self 1)
			)
			(2
				(if (>= local0 4)
					(gMessager say: 1 16 35 2) ; "Negative! This is a stealth entrance! No flashbang!"
				)
				(setUpElement doit: 0)
				(proc4_6 15103 421 184)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door setCycle: End setPri: 500)
			)
			(4
				((= local1 (Prop new:))
					view: 15109
					loop: 1
					cel: 0
					posn: 409 182
					init:
				)
				(shotSound number: 1002 play:)
				(= ticks 60)
			)
			(5
				(local1 dispose:)
			)
			(6
				(proc4_5)
				(door dispose:)
				(militiaMan2 init:)
				(billCrow init: setPri: 300)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10304 loop: -1 play:)
				(Lock rsAUDIO (gBackMusic number:) 1)
				(proc4_6 14001 191 54 0 0 -1 1)
				(gCurRoom drawPic: 1405)
			)
			(7
				(WalkieTalkie setPri: 299)
				(billCrow setCycle: End)
				(militiaMan2 setCycle: End)
				(gFxSound number: 14000 setLoop: 0 play:)
			)
			(8
				(WalkieTalkie setPri: 300)
			)
			(9
				(proc4_5)
				(billCrow dispose:)
				(militiaMan2 dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(10
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(11
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(Load rsAUDIO 44)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10320 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15104 428 188 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door setCycle: End setPri: 500)
			)
			(4
				(proc4_5)
				(door dispose:)
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

(instance bMoveOnly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 15118 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15105 416 187 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door setCycle: End)
			)
			(4
				(proc4_5)
				(door dispose:)
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

(instance moveLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 15108)
				(Load rsAUDIO 10314 15108 21003)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 15223 180 66 self 1)
			)
			(2
				(militiaMan init: setCycle: CT 8 1 self)
			)
			(3
				(setUpElement doit: 0)
				(proc4_6 15101 329 179 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
				(militiaMan setCycle: End self)
				(gFxSound number: 21003 setLoop: 0 play:)
			)
			(4
				(proc4_5)
				(door dispose:)
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

(instance moveRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6007)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 15117 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 15102 449 190)
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

(instance shotgunDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff: showCloseUp: 10324 180 66 self)
			)
			(1
				(door setLoop: 0 setCel: 1)
				(if (== local0 1)
					(gMessager say: 1 63 21 3 self) ; "Status!"
				else
					(self cue:)
				)
			)
			(2
				(gCurRoom setScript: timeOut)
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
				(Load rsAUDIO 44 10304 10314)
				(Load rsVIEW 14410)
				(Load rsPIC 1440)
				(= seconds 2)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 15100 430 183 469)
			)
			(2
				(door setCycle: End)
			)
			(3
				(proc4_5)
				(door dispose:)
				(gCurRoom drawPic: 1440)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10304 loop: -1 play:)
				(Lock rsAUDIO (gBackMusic number:) 1)
				(militiaDude view: 14410 loop: 0 cel: 0 posn: 381 175 init:)
				(proc4_6 14400 50 39 0 0 -1 1)
			)
			(4
				(militiaDude setCycle: CT 18 1 self)
			)
			(5
				(proc4_5)
				(militiaDude dispose:)
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
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootYourFriends of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 6007)
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

(instance aRightBLeft of Script
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
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
				(self dispose:)
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
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 60)
				else
					(actionTimer setReal: actionTimer 6)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShootWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 21003 44 10314)
				(= seconds 1)
			)
			(1
				(gCast eachElementDo: #dispose)
				(if (== register 7)
					(gGame showCloseUp: 10321 180 66 self 1)
				else
					(gGame showCloseUp: 10327 180 66 self 1)
				)
			)
			(2
				(if (== register 7)
					(gMessager say: 7 7 0 1 self) ; "Status!"
				else
					(gMessager say: 7 6 0 1 self) ; "Compromised!"
				)
			)
			(3
				(gFxSound number: 21003 loop: 0 play:)
				(shotSound number: 44 loop: 0 play: self)
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

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

(instance door of Prop
	(properties
		x 396
		y 260
		view 15109
		loop 2
	)
)

(instance egoProp of Prop
	(properties)
)

(instance tello of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(= local3 4)
				(gCurRoom setScript: sayYou)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carmike of Prop
	(properties)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(= local3 3)
				(gCurRoom setScript: sayYou)
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(= local3 5)
				(gCurRoom setScript: sayYou)
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(6
				(gCurRoom setScript: shootYourFriends 0 self)
			)
			(29
				(= local3 2)
				(gCurRoom setScript: sayYou)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance militiaMan2 of Prop
	(properties
		x 42
		y 395
		view 14000
	)
)

(instance militiaMan of Prop
	(properties
		x 209
		y 83
		view 15108
	)

	(method (doit)
		(super doit:)
		(if (and (not (shotSound handle:)) (== cel 5))
			(shotSound number: 15108 play:)
		)
	)
)

(instance militiaDude of Prop
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not (shotSound handle:)) (== cel 14))
			(shotSound number: 44 play:)
		)
	)
)

(instance billCrow of Prop
	(properties
		x 34
		y 376
		view 14002
		cel 4
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(0
				(gCurRoom setScript: timeOut)
			)
			(1
				(gCurRoom setScript: rookerBreach)
			)
			(2
				(gCurRoom setScript: rookerInitBreach)
			)
			(3
				(gCurRoom setScript: rookerMirror)
			)
			(else
				(gCurRoom setScript: timeOut)
			)
		)
		(self dispose: delete:)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(denton dispose:)
				(egoProp dispose:)
				(tello dispose:)
				(wix dispose:)
				(carmike dispose:)
			)
			(1
				(wix view: 15101 setCel: 0 setLoop: 0 posn: 462 191 init:)
				(egoProp view: 15101 setCel: 1 setLoop: 0 posn: 462 191 init:)
				(tello view: 15101 setCel: 2 setLoop: 0 posn: 462 191 init:)
				(denton view: 15101 setCel: 3 setLoop: 0 posn: 462 191 init:)
				(carmike view: 15101 setCel: 4 setLoop: 0 posn: 462 191 init:)
			)
			(2
				(wix view: 15101 setCel: 0 setLoop: 1 posn: 463 191 init:)
				(egoProp view: 15101 setCel: 1 setLoop: 1 posn: 463 191 init:)
				(tello view: 15101 setCel: 2 setLoop: 1 posn: 463 191 init:)
				(denton view: 15101 setCel: 3 setLoop: 1 posn: 463 191 init:)
				(carmike view: 15101 setCel: 4 setLoop: 1 posn: 463 191 init:)
			)
			(3
				(wix view: 15101 setCel: 0 setLoop: 2 posn: 440 193 init:)
				(egoProp view: 15101 setCel: 1 setLoop: 2 posn: 440 193 init:)
				(tello view: 15101 setCel: 2 setLoop: 2 posn: 440 193 init:)
				(denton view: 15101 setCel: 3 setLoop: 2 posn: 440 193 init:)
				(carmike view: 15101 setCel: 4 setLoop: 2 posn: 440 193 init:)
			)
			(4
				(wix view: 15101 setCel: 0 setLoop: 3 posn: 462 192 init:)
				(egoProp view: 15101 setCel: 1 setLoop: 3 posn: 462 192 init:)
				(tello view: 15101 setCel: 2 setLoop: 3 posn: 462 192 init:)
				(denton view: 15101 setCel: 3 setLoop: 3 posn: 462 192 init:)
				(carmike view: 15101 setCel: 4 setLoop: 3 posn: 462 192 init:)
			)
			(5
				(wix view: 15101 setCel: 0 setLoop: 4 posn: 464 190 init:)
				(egoProp view: 15101 setCel: 1 setLoop: 4 posn: 464 190 init:)
				(tello view: 15101 setCel: 2 setLoop: 4 posn: 464 190 init:)
				(denton view: 15101 setCel: 3 setLoop: 4 posn: 464 190 init:)
				(carmike view: 15101 setCel: 4 setLoop: 4 posn: 464 190 init:)
			)
		)
	)
)

(instance shotSound of Sound
	(properties
		number 50
	)
)

(instance sound1 of Sound ; UNUSED
	(properties)
)

(instance topWindow of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 137 83 638 87 639 129 136 127
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local2 1)
				(gCurRoom setScript: sShootWindow 0 theVerb)
			)
			(6
				(gCurRoom setScript: sShootWindow 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottomWindowL of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 137 182 391 182 391 228 138 227
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local2 1)
				(gCurRoom setScript: sShootWindow 0 theVerb)
			)
			(6
				(gCurRoom setScript: sShootWindow 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance bottomWindowR of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 463 184 639 184 639 228 465 226
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(= local2 1)
				(gCurRoom setScript: sShootWindow 0 theVerb)
			)
			(6
				(gCurRoom setScript: sShootWindow 0 theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sayThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: 1 local4 local5 0 self)
			)
			(1
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 30)
				else
					(actionTimer setReal: actionTimer 3)
				)
				(self dispose:)
			)
		)
	)
)

(instance sayThese of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager sayRange: 1 local4 local5 1 2 self)
			)
			(1
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 30)
				else
					(actionTimer setReal: actionTimer 3)
				)
				(self dispose:)
			)
		)
	)
)

(instance sayYou of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(gMessager say: local3 29 0 0 self)
			)
			(1
				(gGame handsOn:)
				(if (OneOf gPrevRoomNum 15 8) ; mainMenu, sierraLogo
					(actionTimer setReal: actionTimer 30)
				else
					(actionTimer setReal: actionTimer 3)
				)
				(self dispose:)
			)
		)
	)
)

