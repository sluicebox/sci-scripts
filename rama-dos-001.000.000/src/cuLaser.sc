;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1207)
(include sci.sh)
(use Main)
(use SpinProp)
(use HardStopFwd)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use System)

(public
	cuLaser 0
)

(instance cuLaser of SpinProp
	(properties)

	(method (init)
		(= cel 0)
		(Load rsAUDIO 20001)
		(super init: &rest)
		(self setPri: 200 setHotspot: 2 11)
		(itemFeat plane: (self plane:) init:)
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
				(if (itemFeat scratch:)
					(itemFeat deleteHotspot:)
					(self setHotspot: 2 11)
				)
			)
			((not (itemFeat scratch:))
				(itemFeat setHotspot: 2 11)
				(self deleteHotspot:)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(itemFeat dispose:)
		(super dispose: &rest)
	)
)

(instance itemFeat of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 252 126 272 134 273 144 259 147 242 150 236 146 238 137
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(cuLaser setScript: activateLaser)
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

(instance activateLaser of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(client view: 20113 loop: 0 cel: 0 setCycle: End self)
				(laz number: 20001 setVol: 127 play:)
			)
			(2
				(client view: 20112 loop: 0 cel: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance laz of Sound
	(properties
		flags 5
	)
)

