;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1100)
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
	rm1100 0
)

(local
	local0
	[local1 4]
	local5
	local6
	local7
	local8
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

(instance rm1100 of PQRoom
	(properties
		picture 1100
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
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
		(Load rsVIEW 11024 59 13)
		(Load rsSCRIPT 31 27 64960)
		(Load rsHEAP 31 27 64960)
		(Load rsVIEW 10 22 23 25)
		(Load rsAUDIO 5 50 51 53 57 58)
		(super init: &rest)
		(door init: setPri: 290)
		(van init:)
		(gCurRoom setScript: enterRoom)
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
					((and (proc4_11 54) (== global149 1))
						(= local7 66)
						(= local8 16)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local7 65)
						(= local8 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(gCurRoom setScript: shotGunDoor)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local7 58)
						(= local8 12)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local7 67)
						(= local8 13)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local7 16)
						(= local8 13)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local7 85)
						(= local8 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 49) (== global149 2))
							(and (proc4_11 49) (== global149 1))
						)
						(= local7 70)
						(= local8 14)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 46) (proc4_11 50) (== global149 2))
							(and (proc4_11 50) (== global149 1))
						)
						(= local7 72)
						(= local8 14)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local7 75)
						(= local8 18)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local7 86)
						(= local8 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 66) (== global149 2))
							(and (proc4_11 66) (== global149 1))
						)
						(= local7 71)
						(= local8 15)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 63) (proc4_11 67) (== global149 2))
							(and (proc4_11 67) (== global149 1))
						)
						(= local7 73)
						(= local8 15)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local7 76)
						(= local8 19)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local7 77)
						(= local8 20)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local7 62)
						(= local8 16)
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
						(= local7 64)
						(= local8 16)
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
						(= local7 74)
						(= local8 16)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(gCurRoom setScript: dudePopsOut)
					)
					(else
						(gGame handsOn:)
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
						(gCurRoom setScript: shotGunDoor)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local7 65)
						(= local8 23)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local7 75)
						(= local8 44)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local7 67)
						(= local8 21)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(= local7 16)
						(= local8 21)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local7 76)
						(= local8 36)
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
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local7 77)
						(= local8 20)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local7 79)
						(= local8 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local7 80)
						(= local8 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local7 81)
						(= local8 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local7 83)
						(= local8 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local7 82)
						(= local8 22)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local7 84)
						(= local8 22)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(gCurRoom setScript: dudePopsOut)
					)
					(else
						(gGame handsOn:)
						(return -1)
					)
				)
			)
			(2
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
							(and (proc4_11 38) (proc4_11 11) (== global149 2))
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 70) (proc4_11 68) (== global149 2))
							(and (proc4_11 53) (== global149 1))
							(and (proc4_11 70) (== global149 1))
						)
						(gCurRoom setScript: breachDoorThirdTimer)
					)
					(
						(or
							(and (proc4_11 40) (proc4_11 11) (== global149 2))
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 72) (proc4_11 68) (== global149 2))
							(and (proc4_11 55) (== global149 1))
							(and (proc4_11 72) (== global149 1))
						)
						(gCurRoom setScript: shotGunDoor)
					)
					(
						(or
							(and (proc4_11 25) (proc4_11 11) (== global149 2))
							(and (proc4_11 54) (proc4_11 51) (== global149 2))
							(and (proc4_11 71) (proc4_11 68) (== global149 2))
						)
						(= local7 65)
						(= local8 24)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (== global149 1))
						(= local7 85)
						(= local8 46)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(= local7 86)
						(= local8 47)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 46) (proc4_11 63) (== global149 2))
						(= local7 62)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local7 79)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local7 80)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local7 81)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local7 83)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local7 82)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local7 84)
						(= local8 41)
						(gCurRoom setScript: sayThis)
					)
					(else
						(gGame handsOn:)
						(return -1)
					)
				)
			)
			(3
				(cond
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(gCurRoom setScript: shotGunDoor)
					)
					((and (proc4_11 57) (== global149 1))
						(gCurRoom setScript: initBreach)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(gCurRoom setScript: initBreach)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local7 65)
						(= local8 24)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 6) (proc4_11 24) (== global149 2))
							(and (proc4_11 59) (== global149 1))
							(and (proc4_11 57) (proc4_11 59) (== global149 2))
						)
						(= local7 67)
						(= local8 26)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 60) (== global149 1))
						(= local7 75)
						(= local8 48)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local7 57)
						(= local8 29)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 77) (== global149 1))
						(= local7 76)
						(= local8 49)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local7 77)
						(= local8 20)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local7 79)
						(= local8 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local7 80)
						(= local8 30)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local7 81)
						(= local8 30)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(gCurRoom setScript: dudePopsOut)
					)
					(else
						(gGame handsOn:)
						(return -1)
					)
				)
			)
			(4
				(cond
					((and (proc4_11 46) (== global149 1))
						(gCurRoom setScript: aTeamMove)
					)
					((and (proc4_11 54) (proc4_11 51) (== global149 2))
						(= local7 65)
						(= local8 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 55) (proc4_11 51) (== global149 2))
							(and (proc4_11 55) (== global149 1))
						)
						(= local7 63)
						(= local8 42)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 52) (proc4_11 51) (== global149 2))
							(and (proc4_11 52) (== global149 1))
						)
						(= local7 57)
						(= local8 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 53) (proc4_11 51) (== global149 2))
							(and (proc4_11 53) (== global149 1))
						)
						(= local7 58)
						(= local8 31)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 58) (== global149 1))
							(and (proc4_11 57) (proc4_11 58) (== global149 2))
						)
						(gCurRoom setScript: initBang)
					)
					((and (proc4_11 60) (== global149 1))
						(= local7 75)
						(= local8 35)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 63) (== global149 1))
						(gCurRoom setScript: bTeamMove)
					)
					((and (proc4_11 77) (== global149 1))
						(= local7 76)
						(= local8 37)
						(gCurRoom setScript: sayThis)
					)
					(
						(or
							(and (proc4_11 43) (== global149 1))
							(and (proc4_11 60) (proc4_11 77) (== global149 2))
						)
						(= local7 77)
						(= local8 43)
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
					((and (proc4_11 21) (proc4_11 10) (== global149 2))
						(= local7 79)
						(= local8 43)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 42) (== global149 2))
						(= local7 80)
						(= local8 43)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 21) (proc4_11 23) (== global149 2))
						(= local7 81)
						(= local8 43)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 42) (== global149 2))
						(= local7 83)
						(= local8 43)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 10) (== global149 2))
						(= local7 82)
						(= local8 43)
						(gCurRoom setScript: sayThis)
					)
					((and (proc4_11 22) (proc4_11 23) (== global149 2))
						(= local7 84)
						(= local8 43)
						(gCurRoom setScript: sayThis)
					)
					((localproc_0)
						(gCurRoom setScript: dudePopsOut)
					)
					(else
						(gGame handsOn:)
						(return -1)
					)
				)
			)
		)
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
)

(instance enterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 0 0 1 1 self) ; "Highground One. Side two clear of threat. Vehicle clear."
			)
			(1
				(dudes init: setCycle: End self)
			)
			(2
				(gMessager say: 0 0 1 2 self) ; "Hold."
				(gSwatInterface showHandAni: 4 self)
			)
			(3)
			(4
				(dudes dispose:)
				(setUpElement doit: 2)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
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
				(Load rsVIEW 11025)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 57 2 0 self) ; "Carmichael, try the door."
			)
			(2
				(setUpElement doit: 0)
				(dudes
					view: 11025
					loop: 0
					cel: 0
					posn: 0 368
					init:
					setCycle: End self
				)
			)
			(3
				(dudes dispose:)
				(setUpElement doit: 3)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
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
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
				(gGame handsOff:)
				(Load rsVIEW 11026)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 58 7 0 self) ; "Prepare to breach door."
			)
			(2
				(setUpElement doit: 0)
				(dudes
					view: 11026
					loop: 0
					cel: 0
					posn: 0 368
					init:
					setCycle: End self
				)
			)
			(3
				(dudes dispose:)
				(setUpElement doit: 4)
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
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
				(Load rsVIEW 11031)
				(= seconds 1)
			)
			(1
				(gMessager say: 1 59 38 1 self) ; "Initiate!"
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 11027 0 73 0 0 -1 1)
			)
			(3
				(door setCycle: CT 1 1)
			)
			(4
				(door setCycle: CT 2 1)
			)
			(5
				(proc4_5)
				(setUpElement doit: 5)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
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
				(gGame handsOff: showCloseUp: 11018 180 66 self)
			)
			(1
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
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
				(gGame handsOff: showCloseUp: 11015 180 66 self)
			)
			(1
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance initBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(actionTimer dispose: delete:)
				(Load rsAUDIO 10314 52 1050 1002 10310)
				(Load rsVIEW 11028 11001 10801 10802)
				(Load rsPIC 1080)
				(Lock rsAUDIO 10310 1)
				(= seconds 2)
			)
			(1
				(gMessager say: 1 16 13 1 self) ; "Denton, flashbang."
			)
			(2
				(door setPri: 400)
				(setUpElement doit: 0)
				(dudes
					view: 11028
					loop: 0
					cel: 0
					posn: 0 328
					init:
					setCycle: End self
				)
			)
			(3
				(door setCycle: End)
				(dudes dispose:)
				(proc4_6 11011 0 29 0 0 -1 1)
			)
			(4
				(gFxSound number: 1002 loop: 0 play:)
				(flashBang init:)
				(= ticks 60)
			)
			(5
				(flashBang dispose:)
			)
			(6
				(proc4_5)
				(door dispose:)
				(proc4_6 10800 16 63 0 0 -1 1)
				(mrEastman init:)
				(militiaMen init:)
				(gCurRoom drawPic: 1080)
				(if (!= 10310 (gBackMusic number:))
					(if (!= 0 (gBackMusic number:))
						(Lock rsAUDIO (gBackMusic number:) 0)
					)
					(gBackMusic number: 10310 loop: -1 play:)
				)
			)
			(7
				(mrEastman setCycle: End self)
				(militiaMen setCycle: End self)
			)
			(8)
			(9)
			(10
				(proc4_5)
				(mrEastman dispose:)
				(militiaMen dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(11
				(gFxSound number: 1050 loop: 0 play: self)
			)
			(12
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(13
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance rookerTryDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 11025)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 3 0 self) ; "Pup! What's going on?"
			)
			(2
				(setUpElement doit: 0)
				(dudes
					view: 11025
					loop: 0
					cel: 0
					posn: 0 368
					init:
					setCycle: End self
				)
			)
			(3
				(dudes dispose:)
				(setUpElement doit: 3)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
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
				(Load rsVIEW 11026)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 4 0 self) ; "Pup! What's going on?"
			)
			(2
				(setUpElement doit: 0)
				(dudes
					view: 11026
					loop: 0
					cel: 0
					posn: 0 368
					init:
					setCycle: End self
				)
			)
			(3
				(dudes dispose:)
				(setUpElement doit: 4)
				(++ local0)
				(actionTimer setReal: actionTimer 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rookerInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 11031)
				(= seconds 1)
			)
			(1
				(gMessager say: 0 0 39 0 self) ; "Status! Entry team..."
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 11027 0 73 0 0 -1 1)
			)
			(3
				(door setCycle: CT 1 1)
			)
			(4
				(door setCycle: CT 2 1)
			)
			(5
				(proc4_5)
				(setUpElement doit: 5)
				(++ local0)
				(gGame handsOn:)
				(actionTimer setReal: actionTimer 6)
				(self dispose:)
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
				(gGame showCloseUp: 11017 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 11003 0 32)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
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
				(Load rsAUDIO 6007)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 11016 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 11002 0 39)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 5)
			)
			(4
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance aTeamMove of Script
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
				(gGame showCloseUp: 11023 180 66 self 1)
			)
			(2
				(door setCel: (door lastCel:))
				(setUpElement doit: 0)
				(proc4_6 11007 0 24)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(proc4_5)
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gunShot number: 1050 setLoop: 1 play: self)
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

(instance bTeamMove of Script
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
				(gGame showCloseUp: 11019 180 66 self 1)
			)
			(2
				(door setCel: (door lastCel:))
				(setUpElement doit: 0)
				(proc4_6 11006 0 16 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(proc4_5)
				(door dispose:)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gunShot number: 1050 setLoop: 1 play: self)
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

(instance breachDoorThirdTimer of Script
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
				(gGame showCloseUp: 11022 180 66 self 1)
			)
			(2
				(setUpElement doit: 0)
				(proc4_6 11027 0 73 0 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(3
				(door setCycle: CT 1 1)
			)
			(4
				(door setCycle: CT 2 1)
			)
			(5
				(gGame showCloseUp: 11024 180 66 self 1)
			)
			(6
				(proc4_5)
				(proc4_6 11004 0 0)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(7
				(door setPri: 400 setCycle: End)
			)
			(8
				(gunShot number: 44 play: self)
			)
			(9
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 10314 setLoop: 1 play: self)
			)
			(10
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
				(Load rsAUDIO 44 10314)
				(= seconds 1)
			)
			(1
				(gGame
					showCloseUp: (if register 10720 else 10719) 180 66 self 1
				)
			)
			(2
				(gMessager say: 10 7 0 0 self) ; "Compromised!"
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
				(Load rsVIEW 6 11010)
				(Load rsAUDIO 1002 52 10314 44)
				(= seconds 1)
			)
			(1
				(gGame showCloseUp: 10721 180 66 self 1)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(whiteScreen init:)
				(gunShot number: 1002 play:)
				(setUpElement doit: 0)
				(gMessager say: 9 16 0 0) ; "Status! Status!"
				(proc4_6 11008 0 37 16 0 -1 1)
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
				(= cycles 1)
			)
			(6)
			(7
				(door cycleSpeed: 2 setCycle: End self)
				(badGuy init: setCycle: CT 18 1 self)
			)
			(8)
			(9
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 44 loop: 0 play: self)
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

(instance shotGunDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
				(gGame handsOff:)
				(Load rsAUDIO 10310 10314 44 52)
				(Load rsVIEW 10802 11000 11030)
				(Load rsPIC 1080)
				(= seconds 2)
			)
			(1
				(switch local0
					(0
						(gMessager say: 1 63 13 0 self) ; "Denton, breach the door."
					)
					(1
						(gMessager say: 1 63 21 0 self) ; "Denton, breach the door."
					)
					(2
						(gMessager say: 1 63 25 0 self) ; "Denton, breach the door."
					)
					(3
						(gMessager say: 1 63 26 0 self) ; "Denton, breach the door."
					)
				)
			)
			(2
				(gGame showCloseUp: 10722 180 66 self 1)
			)
			(3
				(door setPri: 400 view: 11030 cel: 2)
				(setUpElement doit: 0)
				(proc4_6 11004 0 0)
				(Palette 2 42 254 100) ; PalIntensity
			)
			(4
				(door setCycle: End)
			)
			(5
				(door dispose:)
				(militiaMen init:)
				(setUpElement doit: 0)
				(proc4_6 10800 16 63 0 0 -1 1)
				(gCurRoom drawPic: 1080)
				(if (!= 10310 (gBackMusic number:))
					(if (!= 0 (gBackMusic number:))
						(Lock rsAUDIO (gBackMusic number:) 0)
					)
					(gBackMusic number: 10310 loop: -1 play:)
					(Lock rsAUDIO 10310 1)
				)
			)
			(6
				(militiaMen setCycle: End)
			)
			(7
				(proc4_5)
				(militiaMen dispose:)
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

(instance timerExpires of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch local0
					(0
						(gCurRoom setScript: rookerTryDoor)
					)
					(1
						(gCurRoom setScript: rookerBreach)
					)
					(2
						(gMessager say: 0 0 5 0 self) ; "Status! Entry team..."
					)
					(3
						(gCurRoom setScript: rookerInit)
					)
					(4
						(gCurRoom setScript: dudePopsOut)
					)
					(else
						(gGame handsOn:)
						(actionTimer setReal: actionTimer 6)
						(self dispose:)
					)
				)
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

(instance dudePopsOut of Script
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
				(if (door cel:)
					(dudes setPri: 100)
					(door cycleSpeed: 2 setCycle: End self)
					(proc4_6 11010 65 50 0 0 235 1)
				else
					(self cue:)
				)
			)
			(2
				(if (not (door cel:))
					(self cue:)
				)
			)
			(3
				(proc4_5)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: -1)
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(gFxSound number: 44 loop: 0 play: self)
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
				(gMessager say: 10 7 0 0) ; "Compromised!"
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

(instance sOfficerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: actionTimer)
					(actionTimer dispose: delete:)
				)
				(gGame showCloseUp: 9012 180 66 self)
			)
			(1
				(Lock rsAUDIO (gBackMusic number:) 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(Lock rsAUDIO 6007 1)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance badGuy of Prop
	(properties
		x 300
		y 260
		view 11010
	)

	(method (doit)
		(if (and (not (gunShot handle:)) (== cel 18))
			(gunShot number: 52 play:)
		)
		(super doit:)
	)
)

(instance door of Prop
	(properties
		x 172
		y 52
		view 11000
	)
)

(instance carmike of Prop
	(properties
		y 278
		view 11024
		loop 1
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local6 3)
				(gCurRoom setScript: sayYou)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(= local5 1)
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties
		y 278
		view 11024
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local6 2)
				(gCurRoom setScript: sayYou)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(= local5 1)
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
		y 278
		view 11024
		loop 1
		cel 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local6 4)
				(gCurRoom setScript: sayYou)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(= local5 1)
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
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(= local6 5)
				(gCurRoom setScript: sayYou)
			)
			(6
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(7
				(= local5 1)
				(gCurRoom setScript: shootYourFriend 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance dudes of Prop
	(properties
		y 278
		view 11024
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(7
				(= local5 1)
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance militiaMen of Prop
	(properties
		x 318
		y 325
		view 10802
	)

	(method (doit)
		(if (and (not (gunShot handle:)) (== cel 18))
			(gunShot number: 52 play:)
		)
		(super doit:)
	)
)

(instance mrEastman of Prop
	(properties
		x 257
		y 223
		view 10801
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

(instance flashBang of View
	(properties
		x 121
		y 37
		view 11001
	)
)

(instance van of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 445 100 401 172 400 172 397 162 370 168 366 192 391 189 364 206 356 290 372 337 386 344 399 340 405 315 504 359 637 358 639 70
					yourself:
				)
		)
		(super init: &rest)
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

(instance vanCloseUp of Prop
	(properties
		x 200
		y 90
		view 10734
	)
)

(instance actionTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: timerExpires)
		(actionTimer dispose: delete:)
	)
)

(instance gunShot of Sound
	(properties
		number 50
	)
)

(instance sound5 of Sound
	(properties)
)

(instance setUpElement of Code
	(properties)

	(method (doit param1)
		(switch param1
			(0
				(tello dispose:)
				(denton dispose:)
				(carmike dispose:)
			)
			(1)
			(2
				(tello view: 11024 loop: 1 cel: 2 posn: 0 278 init:)
				(denton view: 11024 loop: 1 cel: 0 posn: 0 278 init:)
				(carmike view: 11024 loop: 1 cel: 1 posn: 0 278 init:)
			)
			(3
				(tello view: 11025 loop: 1 cel: 2 posn: 0 368 init:)
				(denton view: 11025 loop: 1 cel: 0 posn: 0 368 init:)
				(carmike view: 11025 loop: 1 cel: 1 posn: 0 368 init:)
			)
			(4
				(tello view: 11026 loop: 1 cel: 2 posn: 0 368 init:)
				(denton view: 11026 loop: 1 cel: 0 posn: 0 368 init:)
				(carmike view: 11026 loop: 1 cel: 1 posn: 0 368 init:)
			)
			(5
				(tello view: 11031 loop: 0 cel: 2 posn: 0 368 init:)
				(denton view: 11031 loop: 0 cel: 0 posn: 0 368 init:)
				(carmike view: 11031 loop: 0 cel: 1 posn: 0 368 init:)
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
				(gMessager say: 1 local7 local8 0 self)
			)
			(1
				(actionTimer setReal: actionTimer 3)
				(gGame handsOn:)
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
				(gMessager say: local6 29 0 0 self)
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

