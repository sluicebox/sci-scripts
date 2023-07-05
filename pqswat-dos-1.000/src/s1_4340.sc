;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4340)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4340 0
)

(instance s1_4340 of PQRoom
	(properties
		picture 4340
	)

	(method (init)
		(super init: &rest)
		(if (OneOf gPrevRoomNum 4310 4320) ; s1_4310, s1_4320
			(Load rsVIEW 43401)
			(self setScript: yourDead)
		else
			(self setScript: completeCapture)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance yourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(playerDies setPri: 1 init: setCycle: End)
				(proc4_6 43400 325 113 0 0 1 1)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40103)
			)
			(2
				(gBackMusic number: 0 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance completeCapture of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 43403 358 133)
			)
			(1
				(gBackMusic number: 0 stop:)
				(Lock rsAUDIO 40103 0)
				(Load rsAUDIO 6006)
				(Lock rsAUDIO 6006 1)
				(gBackMusic number: 6006 loop: -1 play:)
				(UnLoad 141 40103)
			)
			(2
				(gMessager say: 0 0 1 1) ; "Side three reporting. Suspect in control. Officers coming out."
			)
			(3
				(gEgo awardMedal: 4)
				(gEgo awardMedal: 32)
				(SetFlag 87)
				(gCurRoom newRoom: 4010) ; s1_4010
			)
		)
	)
)

(instance playerDies of Prop
	(properties
		x 560
		y 225
		view 43401
	)
)

