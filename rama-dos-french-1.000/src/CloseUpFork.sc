;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 134)
(include sci.sh)
(use Main)
(use SpinProp)
(use HardStopFwd)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use System)

(class CloseUpFork of SpinProp
	(properties
		activeCel 0
		switchCel 7
		animSnd 0
	)

	(method (start))

	(method (init)
		(= cel activeCel)
		(if (> animSnd 0)
			(Load rsAUDIO animSnd)
		)
		(super init: &rest)
		(self setPri: 200)
		(Trigger plane: (self plane:) init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
			)
			(2
				(if (!= cel activeCel)
					(if (> (self cel:) switchCel)
						(self setCycle: HardStopFwd activeCel)
					else
						(self setCycle: HardStopRev activeCel)
					)
				)
			)
			(else
				(super doVerb: &rest)
			)
		)
	)

	(method (doit)
		(cond
			((!= cel activeCel)
				(if (Trigger scratch:)
					(Trigger deleteHotspot:)
					(self setHotspot: 2 11)
				)
			)
			((not (Trigger scratch:))
				(Trigger setHotspot: 2 11)
				(self deleteHotspot:)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(Trigger dispose:)
		(super dispose: &rest)
	)
)

(class Trigger of Feature
	(properties
		client 0
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 239 108 260 95 276 107 256 119
					yourself:
				)
		)
	)

	(method (setNSRect param1 param2 param3 param4)
		(if (== argc 4)
			(= nsLeft param1)
			(= nsTop param2)
			(= nsRight param3)
			(= nsBottom param4)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (and client (client respondsTo: #start))
					(client start:)
				)
			)
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
		(= client 0)
	)
)

(class StrikeFork of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(client
					view: (+ (client view:) 1)
					loop: 0
					cel: 0
					setCycle: End self
				)
				(if (client animSnd:)
					(humA number: (client animSnd:) setVol: 127 play:)
				)
			)
			(2
				(client view: (- (client view:) 1) loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance humA of Sound
	(properties
		flags 5
	)
)

