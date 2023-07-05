;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4120)
(include sci.sh)
(use Main)
(use Location)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)

(public
	bk2MusSECU2 0
)

(instance bk2MusSECU2 of CloseupLocation
	(properties
		heading 135
	)

	(method (init)
		(super init: 4136)
		(= plane global116)
		(exhibit14Butn init: global117)
		(self edgeW: 0 edgeE: 0)
		(SESSILE_135 init:)
	)

	(method (cue &tmp temp0)
		(switch (= temp0 (Random 0 2))
			(0
				(sessileRbtA init: 0 0 play: self)
				(SetFlag 312)
			)
			(1
				(sessileRbtB init: 0 0 play: self)
				(SetFlag 312)
			)
			(2
				(sessileRbtC init: 0 0 play: self)
				(SetFlag 312)
			)
		)
	)

	(method (pitch param1)
		(proc1111_6)
		(ClearFlag 312)
		(super pitch: param1 &rest)
	)
)

(instance exhibit14Butn of ExhibitButton
	(properties
		x 267
		y 250
		view 4162
	)

	(method (init)
		(if (IsFlag 312)
			(gCurRoom cue:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cond
					((sessileRbtA isPlaying:)
						(sessileRbtA client: 0 stop: 0)
						(ClearFlag 312)
					)
					((sessileRbtB isPlaying:)
						(sessileRbtB client: 0 stop: 0)
						(ClearFlag 312)
					)
					((sessileRbtC isPlaying:)
						(sessileRbtC client: 0 stop: 0)
						(ClearFlag 312)
					)
					(else
						(gCurRoom cue:)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sessileRbtA of RobotPlayer
	(properties
		robot 4160
		robotX 171
		robotY 102
	)
)

(instance sessileRbtB of RobotPlayer
	(properties
		robot 4161
		robotX 212
		robotY 23
	)
)

(instance sessileRbtC of RobotPlayer
	(properties
		robot 4162
		robotX 297
		robotY 56
	)
)

(instance SESSILE_135 of Feature
	(properties
		noun 28
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 180 68 274 21 430 110 419 154 338 236 223 245 191 228 175 148 177 76
					yourself:
				)
		)
	)
)

