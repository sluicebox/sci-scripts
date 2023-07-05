;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4224)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use RobotPlayer)
(use Polygon)
(use Feature)
(use System)

(public
	bk3MusSWCU1 0
)

(instance bk3MusSWCU1 of CloseupLocation
	(properties
		heading 225
	)

	(method (init)
		(super init: 4242)
		(= plane global116)
		(self edgeW: 0 edgeE: 0)
		(exhibit28Butn init: global117)
		(noteA init:)
		(noteB init:)
		(noteC init:)
		(noteD init:)
		(noteE init:)
		(INSTRUMENT_225 init:)
	)

	(method (pitch param1)
		(proc1111_6)
		(ClearFlag 312)
		(super pitch: param1 &rest)
	)
)

(instance sStopInstrument of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(octoInstrument stop: self 1)
			)
			(1
				(ClearFlag 312)
				(= seconds 2)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance exhibit28Butn of ExhibitButton
	(properties
		x 287
		y 246
		view 4255
	)

	(method (init)
		(if (IsFlag 312)
			(octoInstrument init: 1 play:)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (IsFlag 312)
					(octoInstrument stop: 0 1)
					(ClearFlag 312)
				else
					(octoInstrument init: 1 play:)
					(SetFlag 312)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance octoInstrument of RobotPlayer
	(properties
		robot 4255
		robotX 236
		robotY 79
	)
)

(instance octoNoteA of RobotPlayer
	(properties
		robot 4258
		robotX 236
		robotY 78
	)
)

(instance octoNoteB of RobotPlayer
	(properties
		robot 4259
		robotX 232
		robotY 76
	)
)

(instance octoNoteC of RobotPlayer
	(properties
		robot 4260
		robotX 235
		robotY 74
	)
)

(instance octoNoteD of RobotPlayer
	(properties
		robot 4261
		robotX 233
		robotY 50
	)
)

(instance octoNoteE of RobotPlayer
	(properties
		robot 4262
		robotX 235
		robotY 41
	)
)

(instance noteB of Feature
	(properties
		nsBottom 124
		nsLeft 274
		nsRight 293
		nsTop 105
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gTheCursor isInvCursor:)
						(== 114 (proc70_7 (gTheCursor invItem:)))
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (octoInstrument isPlaying:)
					(octoInstrument stop: 0 1)
					(ClearFlag 312)
				)
				(octoNoteB init: 0 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance noteC of Feature
	(properties
		nsBottom 100
		nsLeft 289
		nsRight 312
		nsTop 80
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gTheCursor isInvCursor:)
						(== 114 (proc70_7 (gTheCursor invItem:)))
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (octoInstrument isPlaying:)
					(octoInstrument stop: 0 1)
					(ClearFlag 312)
				)
				(octoNoteC init: 0 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance noteD of Feature
	(properties
		nsBottom 75
		nsLeft 310
		nsRight 335
		nsTop 54
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gTheCursor isInvCursor:)
						(== 114 (proc70_7 (gTheCursor invItem:)))
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (octoInstrument isPlaying:)
					(octoInstrument stop: 0 1)
					(ClearFlag 312)
				)
				(octoNoteD init: 0 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance noteE of Feature
	(properties
		nsBottom 50
		nsLeft 330
		nsRight 355
		nsTop 40
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gTheCursor isInvCursor:)
						(== 114 (proc70_7 (gTheCursor invItem:)))
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (octoInstrument isPlaying:)
					(octoInstrument stop: 0 1)
					(ClearFlag 312)
				)
				(octoNoteE init: 0 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance noteA of Feature
	(properties
		nsBottom 130
		nsLeft 260
		nsRight 275
		nsTop 125
	)

	(method (init)
		(super init: &rest)
		(= plane global116)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						(gTheCursor isInvCursor:)
						(== 114 (proc70_7 (gTheCursor invItem:)))
					)
					(super doVerb: theVerb)
				else
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (octoInstrument isPlaying:)
					(octoInstrument stop: 0 1)
					(ClearFlag 312)
				)
				(octoNoteA init: 0 play:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance INSTRUMENT_225 of Feature
	(properties
		noun 47
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 256 74 285 97 360 30 366 83 248 180 235 87 257 78
					yourself:
				)
		)
	)
)

