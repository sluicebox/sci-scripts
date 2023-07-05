;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 196)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use WalkieTalkie)
(use System)

(public
	rm196 0
)

(instance rm196 of PQRoom
	(properties
		picture 196
		infoRoomSignal 128
	)

	(method (init)
		(SetFlag 12)
		(SetFlag 15)
		(super init: &rest)
		(ClearFlag 43)
		(ClearFlag 44)
		(ClearFlag 45)
		(if (IsFlag 46)
			(ClearFlag 12)
			(ClearFlag 15)
			(ClearFlag 46)
			(self setScript: leaveDrill)
		else
			(self setScript: chooseDrill)
			(Load rsAUDIO 19501)
			(Lock rsAUDIO 19501 1)
			(gBackMusic number: 19501 loop: -1 play:)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance chooseDrill of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch (Random 0 2)
					(0
						(SetFlag 43)
					)
					(1
						(SetFlag 44)
					)
					(2
						(SetFlag 45)
					)
				)
				(cond
					((IsFlag 43)
						(if (not (IsFlag 19))
							(proc4_6 1962 160 82)
						else
							(proc4_6 19691 152 111)
						)
					)
					((IsFlag 44)
						(if (not (IsFlag 19))
							(proc4_6 1967 160 69)
						else
							(proc4_6 1968 152 112)
						)
					)
					((IsFlag 45)
						(if (not (IsFlag 19))
							(proc4_6 1961 159 82)
						else
							(proc4_6 1969 151 105)
						)
					)
				)
			)
			(1
				(gCurRoom newRoom: 197)
			)
		)
	)
)

(instance leaveDrill of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Lock rsAUDIO 19501 0)
				(= cycles 2)
			)
			(1
				(cond
					((IsFlag 41)
						(proc4_6 1960 160 76 0 0 1)
					)
					((IsFlag 59)
						(ClearFlag 59)
						(if (not (IsFlag 19))
							(proc4_6 1963 154 81)
						else
							(proc4_6 19692 151 117)
						)
					)
					((IsFlag 60)
						(ClearFlag 60)
						(if (not (IsFlag 19))
							(proc4_6 1965 153 96)
						else
							(proc4_6 19694 151 118 0 0 -1 1)
						)
					)
					((IsFlag 61)
						(ClearFlag 61)
						(if (not (IsFlag 19))
							(proc4_6 1964 148 105)
						else
							(proc4_6 19693 147 117)
						)
					)
					((IsFlag 62)
						(ClearFlag 62)
						(if (not (IsFlag 19))
							(proc4_6 1966 160 98)
						else
							(proc4_6 19696 124 112 0 0 -1 1)
						)
					)
				)
			)
			(2
				(if (IsFlag 41)
					(WalkieTalkie setPri: 300)
				else
					(self cue:)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(ClearFlag 41)
				(= temp0 global125)
				(= global125 0)
				(gBackMusic fade: 0 2 21 1)
				(gCurRoom newRoom: temp0)
			)
		)
	)
)

