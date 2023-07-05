;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1215)
(include sci.sh)
(use Main)
(use SpinProp)
(use HardStopFwd)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	cuJack 0
)

(local
	local0
)

(instance cuJack of SpinProp
	(properties)

	(method (init)
		(= cel 0)
		(= loop (= local0 (> (myInvObj cel:) 1)))
		(Load rsAUDIO 20010)
		(super init: &rest)
		(self setPri: 200)
		(upButn plane: (self plane:) init:)
		(dnButn plane: (self plane:) init:)
		(upButnPress init: setPri: (+ (self priority:) 1) hide:)
		(dnButnPress init: setPri: (+ (self priority:) 1) hide:)
		(shaft init: setPri: (+ (self priority:) 1) hide:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
				(gTheCursor hilite:)
			)
			(2
				(if (!= cel 0)
					(if (> (self cel:) 7)
						(self setCycle: HardStopFwd 0)
					else
						(self setCycle: HardStopRev 0)
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
			((!= cel 0)
				(if (upButn scratch:)
					(upButn deleteHotspot:)
					(dnButn deleteHotspot:)
					(self setHotspot: 2 11)
				)
			)
			((not (upButn scratch:))
				(upButn setHotspot: 2 11)
				(dnButn setHotspot: 2 11)
				(self deleteHotspot:)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(upButn dispose:)
		(dnButn dispose:)
		(super dispose: &rest)
	)
)

(instance shaft of Prop
	(properties
		loop 4
	)

	(method (init)
		(= view (cuJack view:))
		(= x (cuJack x:))
		(= y (cuJack y:))
		(super init: &rest)
	)
)

(instance upButnPress of Prop
	(properties
		loop 2
	)

	(method (init)
		(= view (cuJack view:))
		(= x (cuJack x:))
		(= y (cuJack y:))
		(super init: &rest)
	)
)

(instance dnButnPress of Prop
	(properties
		loop 3
	)

	(method (init)
		(= view (cuJack view:))
		(= x (cuJack x:))
		(= y (cuJack y:))
		(super init: &rest)
	)
)

(instance upButn of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 251 132 281 135 265 162 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (not local0)
					(cuJack setScript: startMe 0 1)
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
	)
)

(instance dnButn of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 240 137 253 167 223 160 yourself:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if local0
					(cuJack setScript: startMe 0 2)
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
	)
)

(instance startMe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(if (== register 1)
					(shaft cel: 0 show: setCycle: End self)
					(upButnPress cel: 0 show: setCycle: End)
				else
					(shaft cel: (shaft lastCel:) show: setCycle: Beg self)
					(client loop: 0)
					(dnButnPress cel: 0 show: setCycle: End)
				)
				(extend setVol: 127 play:)
			)
			(2
				(if (== register 1)
					(= local0 1)
					(client loop: 1 cel: 0)
					(UpdateScreenItem client)
					(shaft hide:)
					(upButnPress hide:)
					((client myInvObj:) cel: 2 verb: 151)
				else
					(= local0 0)
					(client loop: 0 cel: 0)
					(shaft hide:)
					(dnButnPress hide:)
					((client myInvObj:) cel: 0 verb: 60)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance extend of Sound
	(properties
		number 20010
		flags 5
	)
)

