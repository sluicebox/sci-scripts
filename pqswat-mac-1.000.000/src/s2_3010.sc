;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3010)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3010 0
)

(instance s2_3010 of PQRoom
	(properties
		picture 3010
	)

	(method (init)
		(super init: &rest)
		(cond
			((== gPrevRoomNum 3000) ; s2_3000
				(door cel: 0 init:)
				(gCurRoom setScript: sTransFrom3000)
			)
			((== gPrevRoomNum 3020) ; s2_3020
				(cond
					((IsFlag 209)
						(ClearFlag 209)
						(gCurRoom setScript: sTimerExpired)
					)
					((IsFlag 300)
						(ClearFlag 300)
						(gCurRoom setScript: sEgoFiringM16)
					)
					((IsFlag 290)
						(ClearFlag 290)
						(gCurRoom setScript: sEgoFiringC45)
					)
					((IsFlag 289)
						(ClearFlag 289)
						(gCurRoom setScript: sEgoFlashBang)
					)
					(else
						(gGame handsOn:)
					)
				)
			)
			(else
				(ClearFlag 290)
				(ClearFlag 300)
				(gCurRoom setScript: sRemoved)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sRemoved of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkieTalkie showFrame: 30109 0 243 22)
				(= cycles 5)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(proc4_5)
				(proc4_6 30109 243 22 0 0 -1 1)
			)
			(2
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sTransFrom3000 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(proc4_6 30100 -3 14 12 0 -1 1)
			)
			(1
				(gSwatInterface showHandAni: 4)
			)
			(2
				(door setCycle: End)
			)
			(3
				(gSwatInterface showHandAni: 6)
			)
			(4
				(proc4_5)
				(WalkieTalkie showFrame: 30100 656 -3 14)
				(= global128 30100)
				(gCurRoom newRoom: 3020) ; s2_3020
			)
		)
	)
)

(instance sTimerExpired of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(gMessager say: 0 0 2 0 self) ; "Suspect in control. One hostage. Officer coming out!"
			)
			(2
				((ScriptID 4054 0) changeMusic: 6006) ; kiplandRegion
				(proc4_6 30110 259 52 0 0 -1 1)
			)
			(3
				(SetFlag 97)
				(SetFlag 96)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sEgoFiringM16 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(if (IsFlag 219)
					(ClearFlag 219)
					(proc4_6 30104 243 29 0 0 -1 1)
				else
					(proc4_6 30102 224 38 0 0 -1 1)
				)
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sEgoFiringC45 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(cond
					((IsFlag 219)
						(ClearFlag 219)
						(if (IsFlag 222)
							(proc4_6 30106 269 34 0 0 -1 1)
						else
							(proc4_6 30108 198 33 0 0 -1 1)
						)
					)
					((IsFlag 222)
						(proc4_6 30107 198 33 0 0 -1 1)
					)
					(else
						(proc4_6 30105 198 33 0 0 -1 1)
					)
				)
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sEgoFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gMessager say: 0 0 2 0 self) ; "Suspect in control. One hostage. Officer coming out!"
			)
			(2
				(proc4_6 30110 259 52 0 0 -1 1)
			)
			(3
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance door of Prop
	(properties
		x 410
		y 119
		view 30115
	)
)

