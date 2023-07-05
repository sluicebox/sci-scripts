;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 801)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	runesPuz 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(procedure (localproc_0)
	(switch local1
		(0
			(if (== (dial cel:) 5)
				(= local1 1)
			else
				(= local1 0)
			)
		)
		(1
			(if (== (dial cel:) 1)
				(= local1 2)
			else
				(= local1 0)
			)
		)
		(2
			(if (OneOf (dial cel:) 0)
				(= local1 3)
			else
				(= local1 0)
			)
		)
		(3
			(if (OneOf (dial cel:) 0)
				(= local1 4)
			else
				(= local1 0)
			)
		)
		(4
			(if (== (dial cel:) 3)
				(= local1 5)
			else
				(= local1 0)
			)
		)
		(5
			(if (OneOf (dial cel:) 2)
				(SetFlag 355)
				(runesPuz dispose:)
			else
				(= local1 0)
			)
		)
		(else
			(= local1 0)
		)
	)
)

(instance runesPuz of Script
	(properties)

	(method (init)
		(ClearFlag 6)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(= local0 0)
		(= local1 0)
		(= local5 (= register 0))
		(= local3 1)
		(aFeature init:)
		(o2Feature init:)
		(lFeature init:)
		(o1Feature init:)
		(vFeature init:)
		(cFeature init:)
		(myEFeature init:)
		(zFeature init:)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			(register
				(if (OneOf (event type:) evMOUSERELEASE evKEYUP $0040) ; joyDown
					(= register 0)
				)
			)
			((OneOf (event type:) evMOUSEBUTTON evKEYBOARD $0020) ; joyUp
				(cond
					((aFeature onMe: event)
						(= local2 0)
						(self setScript: sTurnTheDial)
					)
					((o2Feature onMe: event)
						(= local2 5)
						(self setScript: sTurnTheDial)
					)
					((cFeature onMe: event)
						(= local2 6)
						(self setScript: sTurnTheDial)
					)
					((lFeature onMe: event)
						(= local2 4)
						(self setScript: sTurnTheDial)
					)
					((o1Feature onMe: event)
						(= local2 1)
						(self setScript: sTurnTheDial)
					)
					((vFeature onMe: event)
						(= local2 3)
						(self setScript: sTurnTheDial)
					)
					((myEFeature onMe: event)
						(= local2 7)
						(self setScript: sTurnTheDial)
					)
					((zFeature onMe: event)
						(= local2 2)
						(self setScript: sTurnTheDial)
					)
					((dial onMe: event)
						(gMessager say: 15 6 39) ; "Try clicking on the letters instead."
					)
					((runes onMe: event)
						(switch local0
							(3
								(= local0 0)
								(gMessager say: 15 6 3 4 0 800) ; "First hidden, then in plain sight -- you must find a hidden room in the monastery, then use your eyes."
							)
							(2
								(= local0 3)
								(gMessager say: 15 6 3 3 0 800) ; "The monastery in town was also built by followers of the Dark One. Perhaps the answer to this mystery lies there."
							)
							(1
								(= local0 2)
								(gMessager say: 15 6 3 2 0 800) ; "The stone was placed here by followers of The Dark One and keyed to its name."
							)
							(else
								(= local0 1)
								(gMessager say: 15 6 3 1 0 800) ; "You need to spell a word or name appropriate to those who carved this stone."
							)
						)
					)
					(else
						(self dispose:)
					)
				)
				(event claimed: 1)
				(return)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 50)
				(SetFlag 51)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				((ScriptID 0 21) doit: 100) ; statusCode
				(gCast eachElementDo: #perform (ScriptID 90 0) 1) ; ZCode
				(= cycles 2)
			)
			(1
				(runes init:)
				(dial setCel: 0 setPri: 97 init:)
				(vRedLetter setPri: 86 init:)
				(ClearFlag 51)
				(gGlory handsOn:)
				(gGlory
					setCursor:
						((gTheIconBar getCursor:)
							view: 999
							loop: 0
							cel: 0
							yourself:
						)
				)
				(PalVary 3) ; PalVaryKill
				(SetFlag 51)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(ClearFlag 50)
		(ClearFlag 51)
		(gCurRoom drawPic: gCurRoomNum 0)
		((ScriptID 0 21) doit: gCurRoomNum) ; statusCode
		(gCast eachElementDo: #perform (ScriptID 90 0) 0) ; ZCode
		(runes dispose:)
		(dial dispose:)
		(aFeature dispose:)
		(o2Feature dispose:)
		(lFeature dispose:)
		(o1Feature dispose:)
		(vFeature dispose:)
		(zFeature dispose:)
		(cFeature dispose:)
		(myEFeature dispose:)
		(vRedLetter dispose:)
		(if (< 2700 gClock 2801)
			(PalVary 9 (+ (gCurRoom picture:) 1)) ; PalVaryMergeSource
		)
		(proc0_16)
		(proc0_13)
		(SetFlag 6)
		(super dispose:)
	)
)

(instance sTurnTheDial of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOn:)
				(if local3
					(= local3 0)
					(= local4 -1)
				else
					(= local3 1)
					(= local4 1)
				)
				(vRedLetter hide:)
				(switch local2
					(0
						(dial setCel: local5 setCycle: CT 5 local4 self)
					)
					(7
						(dial setCel: local5 setCycle: CT 4 local4 self)
					)
					(5
						(dial setCel: local5 setCycle: CT 6 local4 self)
					)
					(2
						(dial setCel: local5 setCycle: CT 3 local4 self)
					)
					(3
						(dial setCel: local5 setCycle: CT 1 local4 self)
					)
					(1
						(dial setCel: local5 setCycle: CT 0 local4 self)
					)
					(4
						(dial setCel: local5 setCycle: CT 2 local4 self)
					)
					(6
						(dial setCel: local5 setCycle: CT 7 local4 self)
					)
				)
			)
			(1
				(switch local2
					(0
						(vRedLetter posn: 144 61 setCel: 0 show:)
					)
					(7
						(vRedLetter posn: 120 74 setCel: 7 show:)
					)
					(5
						(vRedLetter posn: 177 68 setCel: 3 show:)
					)
					(2
						(vRedLetter posn: 112 95 setCel: 6 show:)
					)
					(3
						(vRedLetter posn: 148 136 setCel: 4 show:)
					)
					(1
						(vRedLetter posn: 179 122 setCel: 1 show:)
					)
					(4
						(vRedLetter posn: 122 118 setCel: 5 show:)
					)
					(6
						(vRedLetter posn: 185 98 setCel: 2 show:)
					)
				)
				(= local5 (dial cel:))
				(= ticks 30)
			)
			(2
				(localproc_0)
				(User canControl: 1)
				(sTurnTheDial dispose:)
			)
		)
	)
)

(instance dial of Prop
	(properties
		x 154
		y 97
		priority 75
		fixPriority 1
		view 802
		loop 1
		signal 20481
	)
)

(instance runes of View
	(properties
		x 52
		y 66
		view 802
		signal 16384
	)
)

(instance vRedLetter of View
	(properties
		x 179
		y 122
		view 802
		loop 2
		cel 1
	)
)

(instance aFeature of Feature
	(properties
		nsLeft 128
		nsTop 51
		nsRight 181
		nsBottom 75
		sightAngle 180
		x 128
		y 51
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 144 51 164 51 181 59 163 75 143 74 128 58
				yourself:
			)
		)
	)
)

(instance o2Feature of Feature
	(properties
		nsLeft 163
		nsTop 60
		nsRight 200
		nsBottom 89
		sightAngle 180
		x 163
		y 60
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 163 75 181 60 190 67 196 76 200 83 177 89 173 81
				yourself:
			)
		)
	)
)

(instance cFeature of Feature
	(properties
		nsLeft 175
		nsTop 83
		nsRight 203
		nsBottom 115
		sightAngle 180
		x 175
		y 83
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 177 88 200 83 202 95 203 107 200 115 175 108 180 98
				yourself:
			)
		)
	)
)

(instance zFeature of Feature
	(properties
		nsLeft 106
		nsTop 84
		nsRight 132
		nsBottom 116
		sightAngle 180
		x 106
		y 84
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 132 110 110 116 106 100 109 84 132 88 129 99
				yourself:
			)
		)
	)
)

(instance vFeature of Feature
	(properties
		nsLeft 137
		nsTop 122
		nsRight 180
		nsBottom 148
		sightAngle 180
		x 137
		y 122
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 146 125 152 125 161 122 180 140 170 145 156 148 140 145 137 143
				yourself:
			)
		)
	)
)

(instance o1Feature of Feature
	(properties
		nsLeft 161
		nsTop 109
		nsRight 147
		nsBottom 140
		sightAngle 180
		x 161
		y 109
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 176 109 200 115 197 123 191 131 180 140 161 121 170 115
				yourself:
			)
		)
	)
)

(instance lFeature of Feature
	(properties
		nsLeft 109
		nsTop 110
		nsRight 146
		nsBottom 144
		sightAngle 180
		x 109
		y 110
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 124 136 115 127 109 117 131 110 138 118 146 125 136 144
				yourself:
			)
		)
	)
)

(instance myEFeature of Feature
	(properties
		nsLeft 109
		nsTop 59
		nsRight 142
		nsBottom 88
		sightAngle 180
		x 109
		y 59
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 116 69 131 59 142 76 132 88 128 87 109 85
				yourself:
			)
		)
	)
)

