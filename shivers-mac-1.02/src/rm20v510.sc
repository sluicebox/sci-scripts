;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20510)
(include sci.sh)
(use Main)
(use n951)
(use Motion)
(use Actor)
(use System)

(public
	rm20v510 0
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 6) ((++ temp0))
		(if [global540 temp0]
			(return 0)
		)
	)
	(return 1)
)

(instance rm20v510 of ShiversRoom
	(properties
		picture 20510
	)

	(method (init &tmp temp0)
		(if (IsFlag 17)
			(= picture 20511)
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((spObPiece new:)
					loop: temp0
					cel: (* [global540 temp0] 2)
					setPri: 1 1
					createPoly: -1 -1 -1 -1 -1 -1
					init:
				)
			)
		else
			(for ((= temp0 0)) (< temp0 3) ((++ temp0))
				((spObPiece new:)
					loop: temp0
					cel: (* [global540 temp0] 2)
					setPri: 1 1
					init:
				)
			)
		)
		(efExitLeft init: 2)
		(efExitRight init: 1)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 20440
	)
)

(instance efExitRight of ExitFeature
	(properties
		nextRoom 20790
	)
)

(instance spObPiece of ShiversProp
	(properties
		view 20510
	)

	(method (handleEvent event &tmp temp0 temp1)
		(event localize: gThePlane)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(self onMe: event)
				(gUser canControl:)
				(!= global184 1)
				(not (self cycler:))
				(not (IsFlag 17))
			)
			(gSounds stop: 12007)
			(= temp0 (event x:))
			(= temp1 [global540 loop])
			(if (< temp0 142)
				(if (== cel 0)
					(= cel 8)
				)
				(= [global540 loop] (mod (+ temp1 3) 4))
				(if (localproc_0)
					(gCurRoom setScript: sIsSolved)
					(self setCycle: CT (- cel 2) -1 sIsSolved)
				else
					(self setCycle: CT (- cel 2) -1)
				)
			else
				(if (== cel 8)
					(= cel 0)
				)
				(= [global540 loop] (mod (++ temp1) 4))
				(if (localproc_0)
					(gCurRoom setScript: sIsSolved)
					(self setCycle: CT (+ cel 2) 1 sIsSolved)
				else
					(self setCycle: CT (+ cel 2) 1)
				)
			)
			(gSounds play: 12007 0 82 0)
			(localproc_0)
		)
	)
)

(instance sIsSolved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc951_15 6750)
			)
			(1
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 20440)
				((Prop new:)
					view: 20441
					setPri: 25 1
					cycleSpeed: 18
					setCycle: End self
					init:
				)
				(gSounds play: 12005 0 82 0)
			)
			(2
				(SetFlag 17)
				(gCurRoom newRoom: 20440) ; rm20v440
			)
		)
	)
)

