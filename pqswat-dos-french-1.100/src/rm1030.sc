;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1030)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm1030 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance rm1030 of PQRoom
	(properties
		picture 1030
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
		(Load rsVIEW 59 10310)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 22 23 25)
		(Load rsAUDIO 50 51 53 57 58)
		(super init: &rest)
		(van init:)
		(door init:)
		(gCurRoom setScript: enterRoom)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(gCurRoom setScript: egoThrowsBang)
			)
			(6
				(gCurRoom setScript: shootWindows 0 theVerb)
			)
			(7
				(gCurRoom setScript: shootWindows 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (cue)
		(gGame handsOn:)
		(super cue:)
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
						(gCurRoom setScript: tryDoor)
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
						(gCurRoom setScript: instructMoveLeft)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local3 72)
						(= local4 1)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(= local3 73)
						(= local4 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local3 58)
						(= local4 7)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 7)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 7)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 5)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 5)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local3 85)
						(= local4 1)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local3 86)
						(= local4 2)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local3 62)
						(= local4 27)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local3 70)
						(= local4 1)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local3 71)
						(= local4 2)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 7)
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
						(= local4 9)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 3)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 4)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
						)
						(= local3 77)
						(= local4 28)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					(else
						(gCurRoom setScript: goToFuneral)
						(return -1)
					)
				)
			)
			(1
				(cond
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(gCurRoom setScript: shotgunDoor2)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(gCurRoom setScript: breach)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 7)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 8)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 6)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 5)
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
						(= local4 10)
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
						(= local4 10)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 3)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 4)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
						)
						(= local3 77)
						(= local4 28)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					(else
						(gCurRoom setScript: goToFuneral)
						(return -1)
					)
				)
			)
			(2
				(cond
					((and (proc4_11 57) (== global149 1))
						(gCurRoom setScript: initiate)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 11)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 11)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 56) (proc4_11 51) (== global149 2))
							(and (proc4_11 56) (== global149 1))
						)
						(= local3 60)
						(= local4 7)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
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
						(= local4 12)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local3 16)
						(= local4 5)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 3)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 4)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
						)
						(= local3 77)
						(= local4 28)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 11)
						(gCurRoom setScript: sayThis)
					)
					(else
						(gCurRoom setScript: goToFuneral)
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
						(gCurRoom setScript: useTheMirror)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: throwBang)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: onlyAMove)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: onlyBMove)
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
						(gCurRoom setScript: instructMoveLeft)
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
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 15)
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
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local3 67)
						(= local4 13)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 36)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 4)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
						)
						(= local3 77)
						(= local4 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local3 58)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					(else
						(gCurRoom setScript: goToFuneral)
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
						(gCurRoom setScript: aTeamRight)
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
						(gCurRoom setScript: aTeamLeft)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: onlyAMove)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: onlyBMove)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: throwBang)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local3 65)
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 31)
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
						(= local4 32)
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
						(= local4 32)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
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
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 34)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 35)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
						)
						(= local3 77)
						(= local4 32)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 15)
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
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(gCurRoom setScript: correctEnter)
					)
					(else
						(gCurRoom setScript: goToFuneral)
						(return -1)
					)
				)
			)
			(5
				(cond
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(gCurRoom setScript: correctEnter)
					)
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: onlyAMove)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: onlyBMove)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local3 57)
						(= local4 15)
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
						(= local4 15)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local3 79)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local3 80)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local3 81)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local3 83)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local3 82)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local3 84)
						(= local4 0)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: throwBang)
					)
					((and (proc4_11 54) (== global149 1))
						(= local3 66)
						(= local4 31)
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
						(= local4 32)
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
						(= local4 32)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local3 63)
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
						(= local4 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local3 75)
						(= local4 34)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local3 76)
						(= local4 35)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (== global149 1))
							(and (proc4_11 77) (== global149 1))
						)
						(= local3 77)
						(= local4 32)
						(gCurRoom setScript: sayThis)
					)
					(else
						(gCurRoom setScript: goToFuneral)
						(return -1)
					)
				)
			)
		)
	)

	(method (dispose)
		(actionTimer dispose: delete:)
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
				(= cycles 1)
			)
			(1
				(gMessager say: 0 0 22 1 self) ; "Highground One. Side one-two clear of threat."
			)
			(2
				(proc4_6 10310 229 57)
			)
			(3
				(gSwatInterface showHandAni: 4)
			)
			(4
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
				(Load rsVIEW 10311)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 57 11 1 self) ; "Carmichael, try the door!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10311 229 57)
			)
			(3
				(setUpElement doit: 2)
				(actionTimer setReal: actionTimer 6)
				(++ local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerTryDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10311)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 17 0 self) ; "What's going on? Entry team report!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10311 229 57)
			)
			(3
				(setUpElement doit: 2)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance breach of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10312)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 58 24 1 self) ; "Ready to breach door."
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10312 229 57)
			)
			(3
				(setUpElement doit: 5)
				(actionTimer setReal: actionTimer 6)
				(++ local0)
				(gGame handsOn:)
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
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10312)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 18 0 self) ; "What's going on down there?"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10312 229 57)
			)
			(3
				(setUpElement doit: 5)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance initiate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10313)
				(= seconds 1)
			)
			(1
				(setUpElement doit: 0)
				(proc4_6 10313 229 57)
			)
			(2
				(door posn: 418 187 setLoop: 1 setCycle: CT 1 1)
			)
			(3
				(setUpElement doit: 3)
				(actionTimer setReal: actionTimer 4)
				(++ local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance goToFuneral of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314 21003)
				(Load rsVIEW 10316)
				(= seconds 1)
			)
			(1
				(militiaMan init: setCycle: CT 6 1 self)
				(gFxSound number: 21003 setLoop: 1 play:)
			)
			(2
				(gMessager say: 0 0 19 3) ; "Compromised!"
				(self cue:)
			)
			(3
				(militiaMan setCycle: CT 13 1 self)
				(gFxSound number: 53 setLoop: -1 play:)
			)
			(4
				(gFxSound stop:)
				(militiaMan dispose:)
				(door dispose:)
				(setUpElement doit: 0)
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

(instance initiateDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 53 10314 21003)
				(Load rsVIEW 10316)
				(= seconds 1)
			)
			(1
				(gMessager sayRange: 0 0 19 1 2 self) ; "Entry team. Status."
			)
			(2
				(gFxSound number: 21003 setLoop: 1 play:)
				(militiaMan init: setCycle: CT 6 1 self)
			)
			(3
				(gMessager say: 0 0 19 3) ; "Compromised!"
				(militiaMan setCycle: CT 13 1 self)
				(gFxSound number: 53 setLoop: -1 play:)
			)
			(4
				(gFxSound stop:)
				(militiaMan dispose:)
				(door dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(5
				(gFxSound number: 53 setLoop: 1 play: self)
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

(instance useTheMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10314)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 60 7 1 self) ; "Carmichael, mirror the door."
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10314 229 57 12)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(setUpElement doit: 4)
				(actionTimer setReal: actionTimer 6)
				(++ local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance mirrorDelay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 10314)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 20 0 self) ; "Pup, what's taking so long? Status!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 10314 229 57)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(setUpElement doit: 4)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aTeamRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10308)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10315 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(setUpElement doit: 6)
				(++ local0)
				(actionTimer setReal: actionTimer 4)
				(SetFlag 285)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance aTeamLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsVIEW 10309)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10316 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(setUpElement doit: 7)
				(actionTimer setReal: actionTimer 4)
				(++ local0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance correctEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(setUpElement doit: 0)
				(if (IsFlag 285)
					(= global415 1)
					(proc4_6 10308 364 152)
				else
					(= global415 0)
					(proc4_6 10309 338 113)
				)
			)
			(1
				(door setPri: 190 setCycle: End)
			)
			(2
				(gCurRoom newRoom: 1430)
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
				(Load rsAUDIO 44 53 6007 10314)
				(Load rsVIEW 10307 14691)
				(Load rsPIC 1460)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 10324 180 66 self 1)
			)
			(2
				(gMessager say: 1 63 5 2) ; "Negative! This is a stealth entrance!"
				(= cycles 5)
			)
			(3
				(Palette 2 42 254 100) ; PalIntensity
				(door setLoop: 3 setCel: 0 posn: 419 186)
				(doorLeft init: setPri: 323)
				(setUpElement doit: 0)
				(proc4_6 10307 413 208)
			)
			(4)
			(5
				(door dispose:)
				(doorLeft dispose:)
				(gCurRoom drawPic: 1460)
				(militiaMan
					view: 14691
					posn: 245 196
					setCel: 4
					init:
					setCycle: End self
				)
				(proc4_6 14614 257 68 0 0 280 1)
			)
			(6)
			(7
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(8
				(gFxSound number: 44 setLoop: 1 play: self)
				(fxSound2 init: number: 53 setLoop: 1 play: self)
			)
			(9)
			(10
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 loop: 1 play: self)
			)
			(11
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 94)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shotgunDoor2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 44 53 10314 21003)
				(Load rsVIEW 10315)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10324 180 66 self 1)
			)
			(2
				(door setLoop: 3 setCel: 0 posn: 419 186)
				(Palette 2 42 254 100) ; PalIntensity
				(gMessager say: 1 63 6 2 self) ; "Status!"
			)
			(3
				(setUpElement doit: 0)
				(gFxSound number: 21003 setLoop: -1 play:)
				(militiaMan
					view: 10315
					posn: 321 254
					init:
					setCycle: CT 6 1 self
				)
				(gMessager say: 1 63 6 3) ; "Compromised!"
				(proc4_6 10301 387 152 0 0 -1 1)
			)
			(4
				(militiaMan setCycle: CT 23 1 self)
				(gFxSound number: 53 setLoop: -1 play:)
			)
			(5
				(gFxSound stop:)
				(militiaMan setCycle: End self)
			)
			(6
				(door dispose:)
				(militiaMan dispose:)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(7
				(gFxSound number: 44 setLoop: 1 play: self)
				(fxSound2 init: number: 53 setLoop: 1 play: self)
			)
			(8)
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

(instance instructMoveLeft of Script
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
				(gGame showCloseUp: 10328 180 66 self)
			)
			(2
				(setUpElement doit: 0)
				(gMessager say: 1 64 9 2 self) ; "Negative! Hold position on side one!"
				(if local2
					(proc4_6 10318 52 134)
				else
					(proc4_6 10306 85 140)
				)
			)
			(3
				(if local2
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(4
				(if local2
					(gMessager say: 1 64 9 2 self) ; "Negative! Hold position on side one!"
				else
					(self cue:)
				)
			)
			(5
				(if local2
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(6
				(if local2
					(gMessager say: 0 0 17 1 self) ; "What's going on? Entry team report!"
				else
					(self cue:)
				)
			)
			(7
				(if local2
					(= seconds 3)
				else
					(self cue:)
				)
			)
			(8
				(if local2
					(gMessager say: 0 0 18 1) ; "What's going on down there?"
				)
			)
			(9
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gMessager say: 1 64 9 3 self) ; "What is he doing?"
			)
			(10
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
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
				(Load rsAUDIO 10314 53)
				(Load rsVIEW 6 10326)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10335 180 66 self 1)
			)
			(2
				(Palette 2 42 254 100) ; PalIntensity
				(setUpElement doit: 0)
				(proc4_6 10305 387 141)
				(= seconds 14)
			)
			(3
				(door setPri: 190 setCycle: End)
			)
			(4
				(gMessager say: 1 16 5 2) ; "Negative! This is a stealth entrance! Negative!"
				(flashBangDoor init: setPri: 190)
				(whiteScreen init:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(5
				(whiteScreen dispose:)
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(flashBangDoor dispose:)
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(7
				(Palette 2 42 254 100) ; PalIntensity
			)
			(8
				(gFxSound number: 53 setLoop: 1 play: self)
			)
			(9)
			(10
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(11
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(12
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance onlyAMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 53)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10320 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 10304 356 107 0 0 -1 1)
			)
			(3
				(door setPri: 190 setCycle: End)
			)
			(4
				(gFxSound number: 53 setLoop: 1 play: self)
			)
			(5
				(door dispose:)
				(proc4_5)
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

(instance onlyBMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 10314 53)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10319 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(Palette 2 42 254 100) ; PalIntensity
				(proc4_6 10302 416 98 0 0 -1 1)
			)
			(3
				(door setPri: 190 setCycle: End)
			)
			(4
				(gFxSound number: 53 setLoop: 1 play: self)
			)
			(5
				(door dispose:)
				(proc4_5)
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

(instance shootTeamMember of Script
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
					(charmichael
						(gGame showCloseUp: 9008 180 66 self 1)
					)
					(tello
						(gGame showCloseUp: 9028 180 66 self 1)
					)
					(denton
						(gGame showCloseUp: 9020 180 66 self 1)
					)
					(wixell
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

(instance shootVan of Script
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
				(gMessager say: 6 7 0 0 self) ; "Compromised!"
			)
			(2
				(door dispose:)
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 10)
			)
			(3
				(gFxSound number: 1050 setLoop: 1 play: self)
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

(instance shootWindows of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1050)
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
				(setUpElement doit: 0)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 10)
			)
			(3
				(gMessager say: 7 7 0 0 self) ; "Compromised!"
				(gFxSound number: 1050 setLoop: 1 play: self)
			)
			(4)
			(5
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(6
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance egoThrowsBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actionTimer dispose: delete:)
				(gGame handsOff:)
				(Load rsAUDIO 1002 1050 10314)
				(Load rsVIEW 6)
				(= seconds 2)
			)
			(1
				(gGame showCloseUp: 10322 180 66 self 1)
			)
			(2
				(whiteScreen init:)
				(sound1 number: 1002 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(whiteScreen dispose:)
				(door setLoop: 3 setCel: 10 setPri: 190 posn: 419 186)
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
				(setUpElement doit: 0)
				(proc4_6 10319 388 139)
			)
			(6
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 10)
			)
			(7
				(gFxSound number: 1050 setLoop: 1 play: self)
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

(instance doorLeft of Prop
	(properties
		x 343
		y 155
		view 10307
	)
)

(instance door of Prop
	(properties
		x 422
		y 190
		view 10325
		loop 4
	)
)

(instance flashBangDoor of Prop
	(properties
		x 409
		y 184
		view 10326
	)
)

(instance militiaMan of Prop
	(properties
		x 339
		y 165
		view 10316
	)
)

(instance charmichael of Prop
	(properties
		noun 3
		view 10310
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: noun theVerb 0 0 self) ; "Carmichael, you copy?"
			)
			(7
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(6
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance denton of Prop
	(properties
		noun 2
		view 10310
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gGame handsOff:)
				(gMessager say: noun theVerb 0 0 self) ; "Denton, you copy?"
			)
			(7
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(6
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tello of Prop
	(properties
		noun 4
		view 10310
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gMessager say: noun theVerb 0 0 self) ; "Tello, you copy?"
			)
			(7
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(6
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wixell of Prop
	(properties
		noun 5
		view 10310
	)

	(method (cue)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gMessager say: noun theVerb 0 0 self) ; "Wixell, you copy?"
			)
			(7
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(6
				(gCurRoom setScript: shootTeamMember 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance van of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 270 146 270 139 262 129 261 127 255 137 213 167 210
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7
				(gCurRoom setScript: shootVan)
			)
			(6
				(gCurRoom setScript: shootVan)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(if (gTalkers size:)
			(self dispose: delete:)
			(self setReal: self 4)
		else
			(actionCode doit:)
			(self dispose: delete:)
		)
	)
)

(instance actionCode of Code
	(properties)

	(method (doit)
		(switch local0
			(0
				(gCurRoom setScript: rookerTryDoor)
			)
			(1
				(gCurRoom setScript: rookerBreach)
			)
			(2
				(gCurRoom setScript: initiateDelay)
			)
			(3
				(gCurRoom setScript: mirrorDelay)
			)
			(4
				(gCurRoom setScript: goToFuneral)
			)
			(5
				(gCurRoom setScript: goToFuneral)
			)
		)
		(++ local0)
	)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(charmichael dispose:)
				(denton dispose:)
				(tello dispose:)
				(gEgo dispose:)
				(wixell dispose:)
			)
			(1
				(charmichael
					init:
					view: 10310
					setCel: 0
					setLoop: 0
					posn: 466 366
				)
				(denton init: view: 10310 setCel: 0 setLoop: 1 posn: 466 366)
				(tello init: view: 10310 setCel: 0 setLoop: 2 posn: 466 366)
				(gEgo view: 10310 init: setCel: 0 setLoop: 3 posn: 466 366)
				(wixell init: view: 10310 setCel: 0 setLoop: 4 posn: 466 366)
			)
			(2
				(charmichael
					view: 10311
					posn: 461 209
					setCel: 0
					setLoop: 4
					init:
				)
				(denton view: 10311 posn: 461 209 setCel: 0 setLoop: 2 init:)
				(tello view: 10311 posn: 461 209 setCel: 0 setLoop: 3 init:)
				(gEgo view: 10311 posn: 461 209 setCel: 0 setLoop: 1 init:)
				(wixell view: 10311 posn: 461 209 setCel: 0 setLoop: 0 init:)
			)
			(3
				(charmichael
					view: 10313
					posn: 547 362
					setCel: 0
					setLoop: 4
					init:
				)
				(tello view: 10313 posn: 547 362 setCel: 0 setLoop: 3 init:)
				(denton view: 10313 posn: 547 362 setCel: 0 setLoop: 2 init:)
				(gEgo view: 10313 posn: 547 362 setCel: 0 setLoop: 1 init:)
				(wixell view: 10313 posn: 547 362 setCel: 0 setLoop: 0 init:)
			)
			(4
				(charmichael
					view: 10314
					posn: 547 366
					setCel: 0
					setLoop: 4
					init:
				)
				(tello view: 10314 posn: 547 366 setCel: 0 setLoop: 3 init:)
				(denton view: 10314 posn: 547 366 setCel: 0 setLoop: 2 init:)
				(gEgo view: 10314 posn: 547 366 setCel: 0 setLoop: 1 init:)
				(wixell view: 10314 posn: 547 366 setCel: 0 setLoop: 0 init:)
			)
			(5
				(charmichael
					view: 10312
					posn: 416 198
					setCel: 4
					setLoop: 0
					init:
				)
				(tello view: 10312 posn: 416 198 setCel: 2 setLoop: 0 init:)
				(denton view: 10312 posn: 416 198 setCel: 3 setLoop: 0 init:)
				(gEgo view: 10312 posn: 416 198 setCel: 1 setLoop: 0 init:)
				(wixell view: 10312 posn: 416 198 setCel: 0 setLoop: 0 init:)
			)
			(6
				(charmichael
					view: 10308
					posn: 465 364
					setCel: 0
					setLoop: 4
					init:
				)
				(tello view: 10308 posn: 465 364 setCel: 0 setLoop: 2 init:)
				(denton view: 10308 posn: 465 364 setCel: 0 setLoop: 3 init:)
				(gEgo view: 10308 posn: 465 364 setCel: 0 setLoop: 1 init:)
				(wixell view: 10308 posn: 465 364 setCel: 0 setLoop: 0 init:)
			)
			(7
				(charmichael
					view: 10309
					posn: 466 367
					setCel: 0
					setLoop: 4
					init:
				)
				(tello view: 10309 posn: 466 367 setCel: 0 setLoop: 2 init:)
				(denton view: 10309 posn: 466 367 setCel: 0 setLoop: 3 init:)
				(gEgo view: 10309 posn: 466 367 setCel: 0 setLoop: 1 init:)
				(wixell view: 10309 posn: 466 367 setCel: 0 setLoop: 0 init:)
			)
			(8
				(charmichael
					view: 10308
					posn: 469 361
					setCel: 0
					setLoop: 4
					init:
				)
				(tello view: 10308 posn: 469 361 setCel: 0 setLoop: 2 init:)
				(denton view: 10308 posn: 469 361 setCel: 0 setLoop: 3 init:)
				(gEgo view: 10308 posn: 469 361 setCel: 0 setLoop: 1 init:)
				(wixell view: 10308 posn: 469 361 setCel: 0 setLoop: 0 init:)
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

(instance fxSound2 of Sound
	(properties)
)

(instance sound1 of Sound
	(properties)
)

(instance sound2 of Sound ; UNUSED
	(properties)
)

(instance sayThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 local3 local4 0 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayWhat of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 144 0 1 self 0) ; "Pup! The LASH is not a toy! Confine your comments to the situation at hand!"
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

