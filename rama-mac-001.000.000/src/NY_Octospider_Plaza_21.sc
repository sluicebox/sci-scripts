;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5321)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use newYorkRegion)
(use n1111)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NY_Octospider_Plaza_21 0
)

(instance NY_Octospider_Plaza_21 of CloseupLocation
	(properties
		picture 5362
		heading 225
	)

	(method (init)
		(super init: picture)
		(self edgeW: 0 edgeE: 0)
		(tetraYR init: global117)
		(lock_225 init:)
		(if (IsFlag 236)
			(clampsOpen_225 init:)
		else
			(clampsClosed_225 init:)
		)
	)
)

(instance tetraKeyFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PBarredAccess
					init: 170 112 187 113 205 126 205 137 187 147 171 147 153 138 151 125
					yourself:
				)
			setHotspot: 86
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(86
				(proc201_1 3)
				(unlockClampSound play:)
				(clampsClosed_225 dispose:)
				(clampsOpen_225 init:)
				(octoKeyUp_225 dispose:)
				(octoKeyDown_225 init:)
				(gCurRoom setScript: releaseTetra)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance tetraYR of View
	(properties
		x 289
		y 194
		view 5362
	)

	(method (init)
		(cond
			((not (IsFlag 236))
				(= cel 0)
				(tetraKeyFeat init:)
			)
			((and (IsFlag 236) (== (proc70_9 103) gCurRoomNum))
				(= cel 1)
			)
			(else
				(= cel 2)
			)
		)
		(super init: &rest)
		(if (== cel 1)
			(self setHotspot: 2)
		)
		(switch cel
			(0
				(octoKeyUp_225 init:)
			)
			(1
				(octoKeyDown_225 init:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc70_1 103 0)
				(= cel 2)
				(UpdateScreenItem self)
				(self deleteHotspot:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance releaseTetra of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc1111_7 5362 190 149 0 0 -1 1 self)
			)
			(1
				(tetraYR cel: 1 setHotspot: 2)
				(proc70_10 103 gCurRoomNum)
				(UpdateScreenItem tetraYR)
				(SetFlag 236)
				(proc1111_6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lock_225 of Feature
	(properties
		noun 6
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 112 120 161 83 181 87 232 118 232 142 185 173 162 172 115 140
					yourself:
				)
		)
	)
)

(instance octoKeyUp_225 of Feature
	(properties
		noun 14
		nsLeft 279
		nsTop 157
		nsRight 302
		nsBottom 175
		x 290
		y 166
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clampsClosed_225 of Feature
	(properties
		noun 5
		nsLeft 273
		nsTop 171
		nsRight 312
		nsBottom 198
		x 292
		y 184
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance octoKeyDown_225 of Feature
	(properties
		noun 14
		nsLeft 292
		nsTop 193
		nsRight 316
		nsBottom 209
		x 304
		y 201
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance clampsOpen_225 of Feature
	(properties
		noun 5
		case 2
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 207 181 226 180 226 202 206 204
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 287 156 297 158 298 176 287 177
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 357 181 371 181 377 204 358 203
					yourself:
				)
		)
	)
)

(instance unlockClampSound of Sound
	(properties
		flags 5
		number 5304
	)
)

