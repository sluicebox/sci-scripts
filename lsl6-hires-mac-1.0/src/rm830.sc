;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 830)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryRoom)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm830 0
)

(instance rm830 of LarryRoom
	(properties
		noun 1
		picture 830
		horizon 0
	)

	(method (init)
		(super init: &rest)
		((ScriptID 0 11) init: rm830) ; iconExit
		(battery init:)
		(motor init:)
		(transformer init:)
		(pulley init:)
		(wire init:)
		(gGame handsOn:)
	)

	(method (cue)
		(gCurRoom newRoom: 820)
	)

	(method (doVerb theVerb)
		(if (== theVerb 64) ; wrench
			(if (IsFlag 266)
				(gMessager say: 2 64 1) ; "You've done enough damage already."
			else
				(gCurRoom setScript: wrenchOnMotor)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (dispose)
		((ScriptID 0 11) dispose:) ; iconExit
		(super dispose: &rest)
	)
)

(instance wrenchOnMotor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: changeScore: 15 266)
				(SetFlag 23)
				(wire setCycle: End self)
			)
			(1
				(gMessager say: 3 64 0 0 self) ; "Clever. You use the wrench to disconnect the power cable from the motor."
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wire of Prop
	(properties
		noun 4
		x 163
		y 69
		view 830
	)

	(method (doVerb theVerb)
		(if (== theVerb 64) ; wrench
			(if (IsFlag 23)
				(gMessager say: 2 64 1) ; "You've done enough damage already."
			else
				(gCurRoom setScript: wrenchOnMotor)
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance battery of Feature
	(properties
		noun 2
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 148 85 142 66 176 63 171 86
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 64) ; wrench
			(if (IsFlag 23)
				(gMessager say: 2 64 1) ; "You've done enough damage already."
			else
				(gCurRoom setScript: wrenchOnMotor)
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance motor of Feature
	(properties
		noun 3
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 116 81 115 57 137 45 143 99 123 97
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 64) ; wrench
			(if (IsFlag 23)
				(gMessager say: 2 64 1) ; "You've done enough damage already."
			else
				(gCurRoom setScript: wrenchOnMotor)
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance transformer of Feature
	(properties
		noun 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 152 89 176 91 182 100 165 101 143 101
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pulley of Feature
	(properties
		noun 5
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 50 131 43 185 41 190 49 186 55 133 55
					yourself:
				)
		)
		(super init: &rest)
	)
)

