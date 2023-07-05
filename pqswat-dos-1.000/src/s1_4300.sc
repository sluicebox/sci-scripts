;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4300)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use Motion)
(use Actor)
(use System)

(public
	s1_4300 0
)

(instance s1_4300 of PQRoom
	(properties
		picture 4300
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 43003)
		(Load rsVIEW 43004)
		(switch gPrevRoomNum
			(4270 ; s1_4270
				(global112 resetData: 0)
				(self setScript: dentGoesCorner)
			)
			(else
				(self setScript: lucyComesOut)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance dentGoesCorner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 43000 40 25 0 0 -1 1)
			)
			(1
				(gSwatInterface showHandAni: 4)
			)
			(2
				(gSwatInterface showHandAni: 3 self)
			)
			(3
				(trailer init: setCycle: End)
			)
			(4
				(gCurRoom newRoom: 4280) ; s1_4280
			)
		)
	)
)

(instance lucyComesOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(denton init:)
				(gMessager say: 0 0 2 0) ; "Pacmeyer to Ten David - Suspect in control. Officers coming out!"
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40103 0)
				(gBackMusic number: 6006 loop: -1 play:)
				(UnLoad 141 40103)
				(team setPri: 1 init: setCycle: CT 32 1 self)
			)
			(2
				(denton setCycle: End)
				(team setCycle: End self)
			)
			(3
				(gEgo awardMedal: 64)
				(SetFlag 98)
				(SetFlag 96)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance denton of Prop
	(properties
		x 307
		y 241
		view 43004
	)
)

(instance team of Prop
	(properties
		x 13
		y 276
		view 43003
	)
)

(instance trailer of Prop
	(properties
		x 277
		y 223
		view 43001
	)
)

